package GUI;

import Main.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene ;
import javafx.scene.control.Button ;
import javafx.scene.control.Label ;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import Logic.*;


public class login {
    Scene scene;
    Stage stage;
    manscene m;
    cookscene ck;
    Waiterscene w;

    public login(Stage stage) {
        this.stage = stage;
        m=new manscene(stage) ;
        ck=new cookscene(stage) ;
        w=new Waiterscene(stage);
        prepareScene();
    }

    public void prepareScene() {
        Label Username = new Label("Enter username:");
        Label PasswordLabel = new Label("Enter Password:");
        TextField UserTextField = new TextField();
        UserTextField.setPromptText("Enter User Name");

        PasswordField PasswordField = new PasswordField();
        UserTextField.setPromptText("Enter Password");

        Label validateLabel=new Label();
        Button sign = new Button("Sign in");
        sign.setFont(new Font("Arial",12));
        GridPane grid = new GridPane();

        grid.setHgap(0);
        grid.setVgap(0);
        grid.setAlignment(Pos.BASELINE_CENTER);

        grid.add(Username, 0, 0);
        grid.add(UserTextField, 2, 0);

        grid.add(PasswordLabel, 0, 1);
        grid.add(PasswordField, 2, 1);


        grid.add(sign, 1, 3);
        grid.add(validateLabel,1,5);

        sign.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String Username = UserTextField.getText();
                String Password = PasswordField.getText();
                for(User e: Main.r.getListOfUsers()){
                    if ((Username.equals(e.getUsername())) && (Password.equals(e.getPassword()))){
                        if (e.getRole().equals("Manager")) {
                            m.preparescene();
                            stage.setScene(m.getScene());
                        } else if (e.getRole().equals("Cook")) {
                            ck.preparescene();
                            stage.setScene(ck.getScene());
                        } else if (e.getRole().equals("Waiter")) {
                            w.preparescene();
                            stage.setScene(w.getScene());

                        } else {
                            validateLabel.setText("Username or password incorrect");
                        }
                    }
                }
            }
            });
        scene = new Scene(grid, 600, 400);
    }

    public Scene getScene() {
        return this.scene;
    }
    public void setmanscene(manscene m){
    this.m=m ;
    }
    public void setcookscene(cookscene ck){
    this.ck=ck;
    }
    public void setWaiterscene(Waiterscene w){
    this.w=w ;
    }
}
