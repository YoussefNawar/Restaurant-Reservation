package GUI;

import Logic.Waiter;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class WaiterScene {Scene scene ;
    Stage stage ;
    LoginScene l ;
    Waiter w;

    public WaiterScene(Stage stage , Waiter e){
        this.w=e;
        this.stage=stage ;
        prepareScene();

    }
    public void prepareScene (){
        this.stage.setTitle("Waiter");
        GridPane grid = new GridPane();
        scene = new Scene(grid, 600, 400);




    }

    public Scene getScene() {
        return this.scene;
    }
    public void setlogin(LoginScene l){

        this.l=l ;

    }

}
