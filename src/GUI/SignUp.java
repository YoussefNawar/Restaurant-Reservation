package GUI;

import Logic.Restaurant;
import Logic.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SignUp {

    public static void display(Restaurant r) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("SignUp");

        Label validateLabel = new Label();

        Label nameLabel = new Label("Full name  :");
        nameLabel.setFont(new Font("Arial", 14));
        nameLabel.setStyle("-fx-text-fill: #1a1100");

        TextField nameTextField = new TextField();
        nameTextField.setPromptText("Enter full name");
        nameTextField.setStyle("-fx-background-color: #ffe4b3");

        Label Usernamelabel = new Label("Username:");
        Usernamelabel.setFont(new Font("Arial", 14));
        Usernamelabel.setStyle("-fx-text-fill: #1a1100");

        Label PasswordLabel = new Label("Password:");
        PasswordLabel.setFont(new Font("Arial", 14));
        PasswordLabel.setStyle("-fx-text-fill: #1a1100");

        TextField UserTextField = new TextField();
        UserTextField.setPromptText("Enter User Name");
        UserTextField.setStyle("-fx-background-color: #ffe4b3");

        PasswordField PasswordField = new PasswordField();
        PasswordField.setPromptText("Enter Password");
        PasswordField.setStyle("-fx-background-color: #ffe4b3");

        Button close = new Button("Close");
        close.setFont(new Font("Arial", 12));
        close.setStyle("-fx-background-color:  #ffc966");
        close.setOnAction(e -> window.close());

        Button create = new Button("Sign Up");
        create.setFont(new Font("Arial", 12));
        create.setStyle("-fx-background-color:  #ffc966");

        HBox hBox = new HBox();
        hBox.getChildren().addAll(Usernamelabel, UserTextField);
        hBox.setAlignment(Pos.CENTER);

        HBox hBox1 = new HBox();
        hBox1.getChildren().addAll(PasswordLabel, PasswordField);
        hBox1.setAlignment(Pos.CENTER);

        HBox hBox2 = new HBox();
        hBox2.getChildren().addAll(nameLabel, nameTextField);
        hBox2.setAlignment(Pos.CENTER);

        HBox hBox3 = new HBox();
        hBox3.getChildren().addAll(create, close);
        hBox3.setSpacing(8);
        hBox3.setAlignment(Pos.CENTER);

        VBox layout = new VBox();
        layout.setSpacing(8);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().addAll(hBox2, hBox, hBox1, hBox3, validateLabel);

        create.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                String x = nameTextField.getText();
                String y = UserTextField.getText();
                String z = PasswordField.getText();
                int i = 0;
                for (User e : r.getListOfUsers()) {
                    if (y.equals(e.getUsername()))
                        i = 1;
                }
                if (i == 1) {
                    validateLabel.setText("Sorry username is taken!");
                    validateLabel.setFont(new Font("Arial", 14));
                    validateLabel.setStyle("-fx-text-fill: #1a1100");
                } else {
                    r.addUser(x, y, z);
                    window.close();
                }
            }

        });
        Scene scene = new Scene(layout, 300, 400);
        window.setScene(scene);
        window.showAndWait();

    }
}