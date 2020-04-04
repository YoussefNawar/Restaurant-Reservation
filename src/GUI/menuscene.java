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
import javafx.stage.Stage;

public class menuscene {
    Restaurant r;
    Dish d;
    Scene scene;
    Stage stage;
    Order or ;
    Customer c ;


    public menuscene(Stage stage, Restaurant r,Order or,Dish d,Customer c) {
        this.stage = stage;
        this.stage.setTitle("Menu");
        this.r = r;
        this.d = d;
        this.or= or ;
        this.c=c ;
        preparescene();
    }

public void preparescene(){
        Label appLabel=new Label("Appetizers:");
        Label mainLabel=new Label("Main Course:");
        Label DessertLabel=new Label("Desserts:");
        appLabel.setFont(new Font("Arial",16));
        mainLabel.setFont(new Font("Arial",16));
        DessertLabel.setFont(new Font("Arial",16));
    StackPane layout = new StackPane();
        HBox h1=new HBox();
        HBox h2=new HBox();
        HBox h3=new HBox();
        VBox v1=new VBox();
        VBox v2 = new VBox();
        VBox v3 =new VBox();
v1.setAlignment(Pos.TOP_LEFT);
v2.setAlignment(Pos.CENTER_LEFT);
v3.setAlignment(Pos.BOTTOM_LEFT);

    v1.setSpacing(8.00);
    v2.setSpacing(8.00);
    v3.setSpacing(8.00);
        Button add=new Button("+");
        Button remove=new Button("-");
        h1.getChildren().add(appLabel);
        v1.getChildren().add(h1);
        h1.getChildren().add(mainLabel);
        v2.getChildren().add(h2);
        h3.getChildren().add(DessertLabel);
        v3.getChildren().add(h3);
        makemenu(add,remove,v1,v2,v3);
        layout.getChildren().addAll(v1,v2,v3);

        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                c.addtoOrder(d.getName());
            }
        });
        remove.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                c.removeFromOrder(d.getName());
            }
        });
    scene = new Scene(layout, 350, 350);
    }

public void makemenu(Button b1,Button b2,VBox v1,VBox v2,VBox v3) {
    for (Dish d : r.getListOfDishes()) {
        Label type = new Label();
        HBox hBox = new HBox();
        Label price = new Label();
        hBox.setSpacing(8.00);
        if (d.getType().equals("appetizer")) {
            type.setText(d.getName());
            price.setText(d.getPrice() + "");
            hBox.getChildren().addAll(type, price, b1, b2);
            v1.getChildren().add(hBox);
        } else if (d.getType().equals("main_course")) {
            type.setText(d.getName());
            price.setText(d.getPrice() + "");
            hBox.getChildren().addAll(type, price, b1, b2);
            v1.getChildren().add(hBox);
        } else if  (d.getType().equals("desert")) {

            type.setText(d.getName());
            price.setText(d.getPrice() + "");
            hBox.getChildren().addAll(type, price, b1, b2);
            v1.getChildren().add(hBox);


        }
    }


}
    public Scene getScene() {
        return this.scene;
    }

}