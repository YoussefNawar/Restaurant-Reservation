package GUI;

import Logic.Customer;
import Logic.Restaurant;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.text.ParseException;
import java.util.ArrayList;


public class CustomerScene {
    private Stage stage ;
    private Scene scene;
    private Restaurant restaurant;
    private LoginScene l ;
    private Customer c;

    public CustomerScene(Stage stage , Customer e, Restaurant restaurant){
        this.c = e;
        this.stage=stage ;
        this.restaurant=restaurant;
        try {
            prepareScene();
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }

    public void prepareScene() throws ParseException {
        BorderPane borderPane = new BorderPane();
        this.stage.setTitle("Customer");
        VBox vBox = new VBox();
        HBox hBox1= new HBox();
        hBox1.setAlignment(Pos.CENTER);
        Button userInfo = new Button("Account Info");
        userInfo.setFont(new Font("Arial", 12));
        userInfo.setStyle("-fx-background-color: #ffe6b3");
        hBox1.setStyle("-fx-background-color: #ffe6b3");
        hBox1.getChildren().add(userInfo);
        HBox hBox2= new HBox();
        hBox2.setAlignment(Pos.CENTER);
        Button previousReservations = new Button("View previous reservations");
        previousReservations.setFont(new Font("Arial", 12));
        previousReservations.setStyle("-fx-background-color: #ffe6b3");
        hBox2.setStyle("-fx-background-color: #ffe6b3");
        hBox2.getChildren().add(previousReservations);

        Separator separator = new Separator();
        separator.setOrientation(Orientation.HORIZONTAL);

        Separator separator1 = new Separator();
        separator1.setOrientation(Orientation.HORIZONTAL);

        Separator separator2 = new Separator();
        separator2.setOrientation(Orientation.HORIZONTAL);

        HBox hBox3= new HBox();
        hBox3.setAlignment(Pos.CENTER);
        Button makeReservation = new Button("Make a reservation");
        makeReservation.setFont(new Font("Arial", 12));
        makeReservation.setStyle("-fx-background-color: #ffe6b3");
        hBox3.setStyle("-fx-background-color: #ffe6b3");
        hBox3.getChildren().add(makeReservation);

        vBox.setStyle("-fx-background-color: #ffe6b3");
        vBox.setPadding(new Insets(1));
        vBox.getChildren().addAll(hBox1,separator,hBox3,separator1,hBox2,separator2);
        borderPane.setLeft(vBox);

        Cusdetails cusDetails = new Cusdetails(this.c);
        borderPane.setCenter(cusDetails.getLayout());

        makeReservation.setOnAction(e -> {
            ReservationsDetails reservationsDetails = null;
            try {
                reservationsDetails = new ReservationsDetails(this.c,this.restaurant,borderPane);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
            borderPane.setCenter(reservationsDetails.getLayout());
        });
        userInfo.setOnAction(e -> borderPane.setCenter(cusDetails.getLayout()));
        previousReservations.setOnAction(e->{
              ArrayList x  = (ArrayList)restaurant.getUserMap().get(c.getName());
            if (x.size()==0){
                Label label = new Label("You have no previous reservations");
                borderPane.setCenter(label);
            }else{
                ReservationScene reservationScene = new ReservationScene(c,x);
                VBox vBox1 = new VBox();
                vBox1.getChildren().add(reservationScene.getTree());
                vBox1.setPadding(new Insets(10));
                borderPane.setCenter(vBox1);
            }
        });

        scene = new Scene(borderPane,600,500);
    }

    public Scene getScene() {
        //prepareScene();
        return this.scene;
    }


}
