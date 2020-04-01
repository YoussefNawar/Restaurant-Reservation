import javafx.scene.Scene;
        import javafx.scene.layout.GridPane;
        import javafx.stage.Stage;

public class cookscene {
    Scene scene ;
    Stage stage ;
    login l ;
    public cookscene (Stage stage){

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
