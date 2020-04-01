package GUI;

import javafx.scene.Scene ;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class WaiterScene {Scene scene ;
    Stage stage ;
    LoginScene l ;
    public WaiterScene(Stage stage){

        this.stage=stage ;
    }
    public void preparescene (){
        GridPane grid = new GridPane();
        scene = new Scene(grid, 600, 400);




    }
    public Scene getScene() {
        return this.scene ;
    }
    public void setlogin(LoginScene l){

        this.l=l ;

    }




}
