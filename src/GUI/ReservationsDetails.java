package GUI;

import Logic.Customer;
import Logic.Restaurant;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.converter.DateTimeStringConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class ReservationsDetails {
    private Customer customer;
    private Restaurant restaurant;
    private VBox layout;
    private int i = 0;
    private String smoking;
    private BorderPane borderPane;
    private VBox userInfo;

    public ReservationsDetails(Customer customer, Restaurant restaurant, BorderPane borderPane,VBox userInfo) throws ParseException {
        this.customer = customer;
        this.restaurant = restaurant;
        this.borderPane = borderPane;
        this.userInfo = userInfo;
        prepareScene();
    }

    public void prepareScene() throws ParseException {
        Label details = new Label("Enter reservations details : ");
        details.setFont(new Font("Verdana", 16));
        Separator sep = new Separator();
        sep.setOrientation(Orientation.HORIZONTAL);

        DatePicker datePicker = new DatePicker();
        datePicker.setValue(LocalDate.now());
        HBox hBox1 = new HBox();
        Label date = new Label("Please pick a day :");
        hBox1.getChildren().addAll(date, datePicker);
        hBox1.setAlignment(Pos.BASELINE_LEFT);

        Label smoking1 = new Label("Smoking ? :");
        Button yes = new Button("Yes");
        yes.setStyle("-fx-background-color: #ffc966");
        Button no = new Button("No");
        no.setStyle("-fx-background-color: #ffc966");
        HBox hBox5 = new HBox();
        no.setOnAction(e -> {
            no.setDisable(true);
            this.smoking = "false";
            yes.setDisable(false);
        });
        yes.setOnAction(e -> {
            yes.setDisable(true);
            this.smoking = "true";
            no.setDisable(false);
        });
        hBox5.setSpacing(5);
        hBox5.getChildren().addAll(smoking1, yes, no);
        hBox5.setAlignment(Pos.BASELINE_LEFT);

        Label startTime = new Label("From : ");
        TextField startTimeField = new TextField();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        startTimeField.setPromptText("HH:mm");
        startTimeField.setTextFormatter((new TextFormatter(new DateTimeStringConverter(format), format.parse("00:00"))));
        startTimeField.setStyle("-fx-background-color: #ffe4b3");
        HBox hBox2 = new HBox();
        hBox2.getChildren().addAll(startTime, startTimeField);
        hBox2.setAlignment(Pos.BASELINE_LEFT);

        Label endTime = new Label("To : ");
        TextField endTimeField = new TextField();
        endTimeField.setTextFormatter((new TextFormatter<>(new DateTimeStringConverter(format), format.parse("00:00"))));
        endTimeField.setStyle("-fx-background-color: #ffe4b3");
        endTimeField.setPromptText("HH:mm");
        HBox hBox3 = new HBox();
        hBox3.getChildren().addAll(endTime, endTimeField);
        hBox3.setAlignment(Pos.BASELINE_LEFT);

        Label seatNumber = new Label("Number of Seats : ");
        Label number = new Label(" " + i + " ");
        Button add = new Button("+");
        Button remove = new Button("-");
        remove.setDisable(true);
        remove.setOnAction(e -> {
            if (i == 1) remove.setDisable(true);
            i--;
            number.setText("" + i + "");
            add.setDisable(false);
        });
        remove.setStyle("-fx-background-color: #ffc966");
        add.setOnAction(e -> {
            if (i == 11) add.setDisable(true);
            i++;
            number.setText("" + i + "");
            remove.setDisable(false);
        });
        add.setStyle("-fx-background-color: #ffc966");
        HBox hBox4 = new HBox();
        hBox4.setAlignment(Pos.BASELINE_LEFT);
        hBox4.getChildren().addAll(seatNumber, add, number, remove);

        Button proceed = new Button("Proceed");
        proceed.setStyle("-fx-background-color: #ffc966");
        HBox hbox6 = new HBox();
        hbox6.getChildren().add(proceed);
        hbox6.setAlignment(Pos.CENTER_RIGHT);
        Label label1 = new Label("");


        proceed.setOnAction(e -> {
            try {
                String day = datePicker.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                String day1 = startTimeField.getText() + " " + day;
                String day2 = endTimeField.getText() + " " + day;
                Date a = new SimpleDateFormat("HH:mm dd/MM/yyyy").parse(day1);
                Date b = new SimpleDateFormat("HH:mm dd/MM/yyyy").parse(day2);
                int id = (restaurant.checkAvailable(i, a, b, Boolean.valueOf(this.smoking)));
                if (valid(a, b, label1,id)) {
                    setMenu(id,a,b);
                }
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
        });


        VBox vBox = new VBox();
        vBox.getChildren().addAll(details, sep, hBox4, hBox5, hBox1, hBox2, hBox3, label1, hbox6);
        vBox.setSpacing(8);
        vBox.setPadding(new Insets(10));
        vBox.setStyle("-fx-background-color: #ffffe6");
        this.layout = vBox;

    }

    public VBox getLayout() {
        return layout;
    }

    private boolean valid(Date a, Date b, Label label, int id ){
        Date today = Calendar.getInstance().getTime();
        if (b.before(a) || a.before(today) || checkDifference(a,b)) {
            label.setText("Please enter valid Time");
            return false;
        } else if (i == 0) {
            label.setText("Enter correct number of seats");
            return false;
        } else if (smoking == null) {
            label.setText("Enter correct smoking preference");
            return false;
        }else if( id == -1){
            label.setText("Sorry no table available with selected preferences");
            return false;
        } else return true;
    }

    private boolean checkDifference(Date a, Date b) {
        long diff = Math.abs(b.getTime() - a.getTime());
        diff = diff/(1000*60);
        return !(diff <= 120 && diff >= 30) ;
    }

    public void setMenu(int id , Date a ,Date b ) {
        VBox vBox = new VBox();
        vBox.setStyle("-fx-background-color: #ffffe6");
        Button confirm = new Button("Confirm");
        confirm.setStyle("-fx-background-color: #ffc966");
        customer.createNewReservation(i, id, a, b, Boolean.valueOf(this.smoking));
        MenuScene menuScene = new MenuScene(restaurant, customer);
        VBox vBox1 =menuScene.getMenu();
        vBox1.setMinHeight(474);
        vBox.getChildren().addAll(vBox1,confirm);
        confirm.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                customer.saveReservation();
                borderPane.setCenter(userInfo);
            }
        });
        borderPane.setCenter(vBox);
    }

}
