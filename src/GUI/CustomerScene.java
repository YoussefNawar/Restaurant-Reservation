package GUI;

import Logic.Customer;
import Logic.Waiter;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CustomerScene {
    Stage stage ;
    Scene scene;
    LoginScene l ;
    Customer c;

    public CustomerScene(Stage stage , Customer e){
        this.c = e;
        this.stage=stage ;
        prepareScene();
    }
    public void prepareScene(){
        this.stage.setTitle("Customer");



        VBox vBox = new VBox();
        HBox hBox1= new HBox();
        hBox1.setAlignment(Pos.CENTER);
        Button btn1 = new Button("Make a reservation");
        btn1.setFont(new Font("Arial", 12));
        btn1.setStyle("-fx-background-color: #ffe6b3");
        hBox1.setStyle("-fx-background-color: #ffe6b3");
        hBox1.getChildren().add(btn1);

        HBox hBox2= new HBox();
        hBox2.setAlignment(Pos.CENTER);
        Button btn2 = new Button("View previous reservations");
        btn2.setFont(new Font("Arial", 12));
        btn2.setStyle("-fx-background-color: #ffe6b3");
        hBox2.setStyle("-fx-background-color: #ffe6b3");
        hBox2.getChildren().add(btn2);

        Separator separator = new Separator();
        separator.setOrientation(Orientation.HORIZONTAL);

        Separator separator1 = new Separator();
        separator1.setOrientation(Orientation.HORIZONTAL);

        Separator separator2 = new Separator();
        separator2.setOrientation(Orientation.HORIZONTAL);

        HBox hBox3= new HBox();
        hBox3.setAlignment(Pos.CENTER);
        Button btn3 = new Button("User Info");
        btn3.setFont(new Font("Arial", 12));
        btn3.setStyle("-fx-background-color: #ffe6b3");
        hBox3.setStyle("-fx-background-color: #ffe6b3");
        hBox3.getChildren().add(btn3);

        vBox.setStyle("-fx-background-color: #ffe6b3");
        vBox.setPadding(new Insets(1));
        vBox.getChildren().addAll(hBox3,separator,hBox1,separator1,hBox2,separator2);

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color: #fff7e6");

        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(vBox);
        borderPane.setCenter(anchorPane);
        scene = new Scene(borderPane,600,350);


    }
    public Scene getScene() {
        prepareScene();
        return this.scene;
    }


}
