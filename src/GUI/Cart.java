package GUI;

import Logic.DishPair;
import Logic.Reservation;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Cart {
    Reservation reservation;
    public Cart(Reservation reservation) {
        this.reservation = reservation;
    }

    public VBox createCart(){
        TableView tableView = new TableView<>();
        TableColumn<String , DishPair> column = new TableColumn<>("Item name");
        column.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<String , DishPair> column2 = new TableColumn("Quantity");
        column2.setCellValueFactory(new PropertyValueFactory<>("count"));

        tableView.getColumns().addAll(column,column2);

        VBox vBox = new VBox();
        HBox orderSummary = new HBox();
        Label name = new Label("Item name ");
        Label quantity = new Label(" Quantity");
        orderSummary.getChildren().addAll(name,quantity);
        vBox.getChildren().add(orderSummary);
        for (DishPair dishPair : reservation.getOrder().getPlateList()){
            HBox pair = new HBox();
            pair.getChildren().addAll(new Label(dishPair.getName()),new Label(" x "+dishPair.getCount()  ));
            vBox.getChildren().add(pair);
            tableView.getItems().add(dishPair);
        }
        HBox totalPrice = new HBox();
        totalPrice.getChildren().addAll(new Label("Total Price : "), new Label(reservation.getOrder().getPrice() + "$"));
        vBox.getChildren().add(totalPrice);
        VBox newV = new VBox();
        DishPair dishPair = new DishPair("Total Price" , (int) reservation.getOrder().getPrice());
        tableView.getItems().add(dishPair);
        newV.getChildren().add(tableView);
        return vBox;
    }
}
