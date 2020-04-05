package GUI;

import Logic.Customer;
import Logic.Dish;
import Logic.Restaurant;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class MenuScene {
    private Restaurant r;
    private VBox menu;
    private Customer c;
    private VBox cart ;
    private int max = 5;


    public MenuScene(Restaurant r, Customer c) {
        this.r = r;
        this.c = c;
        prepareScene();
    }

    public void prepareScene() {
        Label appLabel = new Label("Appetizers:");
        Label mainLabel = new Label("Main.Main Course:");
        Label DessertLabel = new Label("Desserts:");
        appLabel.setFont(new Font("Verdana", 14));
        mainLabel.setFont(new Font("Verdana", 14));
        DessertLabel.setFont(new Font("Verdana", 14));
        VBox layout = new VBox();
        HBox h1 = new HBox();
        h1.getChildren().add(appLabel);
        HBox h2 = new HBox();
        h2.getChildren().add(mainLabel);
        HBox h3 = new HBox();
        h3.getChildren().add(DessertLabel);
        VBox v1 = new VBox();
        VBox v2 = new VBox();
        VBox v3 = new VBox();
        v1.getChildren().add(h1);
        v2.getChildren().add(h2);
        v3.getChildren().add(h3);
        makeMenu(v1, v2, v3);
        Separator sep1 = new Separator();
        sep1.setOrientation(Orientation.HORIZONTAL);
        Separator sep2 = new Separator();
        sep2.setOrientation(Orientation.HORIZONTAL);
        layout.getChildren().addAll(v1,sep1,v2,sep2,v3);
        layout.setPadding(new Insets(10));
        layout.setStyle("-fx-background-color: #ffffe6");
        this.menu = layout;
    }

    public void makeMenu(VBox v1, VBox v2, VBox v3) {
        for (Dish d : r.getListOfDishes()) {
            switch (d.getType()) {
                case "appetizer": makeMenuHelper(v1, d);
                    break;
                case "main_course": makeMenuHelper(v2, d);
                    break;
                case "desert": makeMenuHelper(v3, d);
                    break;
            }
        }

    }

    private void makeMenuHelper(VBox v1 , Dish d) {
        Button add = new Button("+");
        add.setStyle("-fx-background-color: #ffc966");
        Button remove = new Button("-");
        remove.setStyle("-fx-background-color: #ffc966");
        Label type = new Label(d.getName());
        Label price = new Label(" "+d.getPrice()+"$");
        String dishName = d.getName();
        Label count = new Label(""+c.getCurrentReservation().getOrder().getCount(dishName));
        add.setOnAction(e -> addFunction(dishName ,remove , count));
        remove.setOnAction(e -> removeFunction(dishName ,remove, count));
        remove.setDisable(true);
        HBox hBox = new HBox();
        hBox.setSpacing(8.00);
        hBox.getChildren().addAll(type, price,add,count,remove);
        v1.setSpacing(8);
        v1.getChildren().add(hBox);
    }

    public VBox getMenu() {
        return menu;
    }

    private void addFunction(String dishname , Button remove , Label count) {
        remove.setDisable(false);
        c.addtoOrder(dishname);
        count.setText(c.getCurrentReservation().getOrder().getCount(dishname)+"");
        cart = new Cart(c.getCurrentReservation()).createCart();
        ObservableList<Node> x = menu.getChildren();
        if (x.size() == 5) {
            menu.getChildren().add(cart);
        } else {
            x.remove(x.get(x.size() - 1 ));
            x.add(cart);
        }

    }

    private void removeFunction(String dishname , Button remove , Label count) {
        if (c.getCurrentReservation().getOrder().getCount(dishname) == 1) remove.setDisable(true);
        c.removeFromOrder(dishname);
        count.setText(c.getCurrentReservation().getOrder().getCount(dishname)+"");
        cart = new Cart(c.getCurrentReservation()).createCart();
        ObservableList<Node> x = menu.getChildren();
        max=5;
        if (x.size() > max && c.getCurrentReservation().getOrder().getPlateList().size() == 0) {
            x.remove(x.get(x.size() - 1));
        } else {
            x.remove(x.get(x.size()-1));
            x.add(cart);
        }
    }

    public VBox getScene() {
        return this.menu;
    }

}
