package GUI;

import Logic.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class LoginScene {
    Scene scene;
    Stage stage;
    Restaurant r;
    TextField UserTextField;
    PasswordField PasswordField;
    Label validateLabel;


    public LoginScene(Stage stage, Restaurant r) {
        this.stage = stage;
        this.stage.setTitle("Login");
        this.r = r;
        prepareScene();
    }

    public void prepareScene() {

        Label Usernamelabel = new Label("Username:");
        Usernamelabel.setFont(new Font("Arial", 14));
        Usernamelabel.setStyle("-fx-text-fill: #1a1100");

        Label PasswordLabel = new Label("Password:");
        PasswordLabel.setFont(new Font("Arial", 14));
        PasswordLabel.setStyle("-fx-text-fill: #1a1100");

        UserTextField = new TextField();
        UserTextField.setPromptText("Enter User Name");
        UserTextField.setStyle("-fx-background-color: #ffe4b3");

        PasswordField = new PasswordField();
        PasswordField.setPromptText("Enter Password");
        PasswordField.setStyle("-fx-background-color: #ffe4b3");
        PasswordField.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER) {
                    valid();
                }
            }
        });

        validateLabel = new Label();

        Button sign = new Button("Sign in");
        sign.setFont(new Font("Arial", 12));
        sign.setStyle("-fx-background-color: #ffc966");

        Label SignUpLabel = new Label("New ? create user ");
        SignUpLabel.setFont(new Font("Arial", 12));
        SignUpLabel.setStyle("-fx-text-fill: #1a1100");

        Button SignUp = new Button("Sign Up");
        SignUp.setFont(new Font("Arial", 12));
        SignUp.setStyle("-fx-background-color:  #ffc966");


        AnchorPane layout = new AnchorPane();
        layout.setStyle("-fx-background-color: #ffffe6");
        layout.setPadding(new Insets(10, 10, 10, 10));

        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10, 10, 10, 10));
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(8);

        HBox hBox = new HBox();
        hBox.getChildren().addAll(Usernamelabel, UserTextField);
        hBox.setSpacing(8);
        hBox.setAlignment(Pos.CENTER);

        HBox hBox1 = new HBox();
        hBox1.getChildren().addAll(PasswordLabel, PasswordField);
        hBox1.setSpacing(8);
        hBox1.setAlignment(Pos.CENTER);

        HBox hBox2 = new HBox();
        hBox2.getChildren().addAll(SignUpLabel, SignUp);
        hBox2.setSpacing(8);
        hBox2.setAlignment(Pos.CENTER);

        ImageView imageView = new ImageView(new Image("logo.jpg"));
        imageView.setFitHeight(70);
        imageView.setFitWidth(70);
        vBox.getChildren().addAll(imageView, hBox, hBox1, validateLabel, sign, hBox2);
        layout.getChildren().add(vBox);

        SignUp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SignUp signup = new SignUp();
                signup.display(r);
            }
        });

        sign.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                valid();
            }
        });
        scene = new Scene(layout, 250, 250);
    }

    public Scene getScene() {
        return this.scene;
    }

    public void valid() {
        String Username = UserTextField.getText();
        String Password = PasswordField.getText();
        for (User e : r.getListOfUsers()) {
            if ((Username.equals(e.getUsername())) && (Password.equals(e.getPassword()))) {
                if (e.getRole().equals("Manager")) {
                  //  ManScene m = new ManScene(this.stage, (Manager) e);
                  //  stage.setScene(m.getScene());
                } else if (e.getRole().equals("Cook")) {
                 //   CookScene cS = new CookScene(this.stage, (Cook) e);
                   // stage.setScene(cS.getScene());
                } else if (e.getRole().equals("Waiter")) {
                   // WaiterScene w = new WaiterScene(this.stage, (Waiter) e);
                    //stage.setScene(w.getScene());
                } else if (e.getRole().equals("Client")) {
                    CustomerScene c = new CustomerScene(this.stage, (Customer) e);
                    stage.setScene(c.getScene());

                }
                } else {
                    validateLabel.setText("Incorrect username or password ");
                    validateLabel.setStyle("-fx-text-fill: #4d3300");
                }

            }

        }

    }


