import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene ;
import javafx.scene.control.Button ;
import javafx.scene.control.Label ;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class Waiterscene {Scene scene ;
    Stage stage ;
    login l ;
    public Waiterscene (Stage stage){

        this.stage=stage ;
    }
    public void preparescene (){
        GridPane grid = new GridPane();
        scene = new Scene(grid, 600, 400);




    }
    public Scene getScene() {
        return this.scene ;
    }
    public void setlogin(login l){

        this.l=l ;

    }




}
