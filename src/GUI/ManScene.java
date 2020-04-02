package GUI;

import Logic.Manager;
import Logic.User;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ManScene {
    Scene scene;
    Stage stage;
    LoginScene l;
    Manager manager;

    public ManScene(Stage stage, Manager e) {
        this.manager = e;
        this.stage = stage;
        prepareScene();
    }

    public void prepareScene() {
        this.stage.setTitle("Manager");
        GridPane grid = new GridPane();
        scene = new Scene(grid, 600, 400);


    }

    public Scene getScene() {
        return this.scene;
    }

    public void setlogin(LoginScene l) {

        this.l = l;

    }


}
