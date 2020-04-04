package GUI;
import Logic.Customer;
import Logic.Dish;
import Logic.Order;
import Logic.Restaurant;
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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Cusdetails {

Customer c ;
Scene scene ;
Stage stage ;
String s ;
String e ;
public Cusdetails(Stage stage ,Customer c){
    this.stage=stage ;
    this.stage.setTitle("Details");
    this.c=c ;
    preparescene();


}
public void preparescene(){
    HBox h1=new HBox();
    HBox h2 =new HBox();
    HBox h3=new HBox();
            Label UserLabel=new Label("Username : ");
            Label PasswordLabel=new Label("Password");

    TextField UserField=new TextField();
    TextField PassField=new TextField();
    Button newp=new Button("Change Password");
    UserField.setText(c.getUsername());
    PassField.setText(c.getPassword());
    newp.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            TextField newpassword=new TextField();
           // newpassword.setText(c.setPassword(s));

            h3.getChildren().add(newpassword);
        }
    });
    h1.getChildren().addAll(UserLabel,UserField);
    h2.getChildren().addAll(PasswordLabel,PassField);
    VBox v=new VBox();
    v.getChildren().addAll(h1,h2,newp,h3);
    scene=new Scene(v,250,250);
}
    public Scene getScene() {
        return this.scene;
    }






































}
