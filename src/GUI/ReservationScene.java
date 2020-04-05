package GUI;

import Logic.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ReservationScene {
    private Scene scene;
    private Stage stage;
    private LoginScene l;
    private User u;
    private ArrayList<Reservation> reservationArrayList;
    private TreeView<String> tree;

    public ReservationScene(User e, ArrayList<Reservation> reservationArrayList) {
        this.u = e;
        this.reservationArrayList = reservationArrayList;
        prepareScene();
    }

    public ReservationScene(Stage stage, User e, ArrayList<Reservation> reservationArrayList) {
        this.u = e;
        this.stage = stage;
        validateReservations(reservationArrayList);
        prepareScene();
    }

    public void prepareScene() {
        VBox layout = new VBox();
        if (this.reservationArrayList.size() == 0) {
            if (u.getRole() == "Manager") this.stage.setTitle("Manager");
            if (u.getRole() == "Waiter") this.stage.setTitle("Waiter");
            if (u.getRole() == "Cooker") this.stage.setTitle("Cook");
            Label label2 = new Label("No Reservations for Today");
            label2.setFont(new Font("Arial", 16));
            layout.setAlignment(Pos.BASELINE_CENTER);
            layout.getChildren().add(label2);
            scene = new Scene(layout, 400, 410);
        } else {
            HBox hbox2 = new HBox();
            Label label3 = new Label("All reservations for today :");
            label3.setFont(new Font("Arial", 16));
            hbox2.setStyle("-fx-background-color :#ffffe6");
            hbox2.setAlignment(Pos.BASELINE_CENTER);
            hbox2.getChildren().add(label3);
            layout.getChildren().add(hbox2);
            if (u.getRole() == "Manager") this.stage.setTitle("Manager");
            if (u.getRole() == "Waiter") this.stage.setTitle("Waiter");
            if (u.getRole() == "Cooker") this.stage.setTitle("Cook");
            tree = getTree();
            layout.getChildren().add(tree);
            if (u.getRole() == "Manager") {
                Manager x = (Manager) u;
                HBox hBox = new HBox();
                Label label1 = new Label("Total amount of money today =" + x.getTotalMoney(reservationArrayList));
                label1.setFont(new Font("Verdana", 16));
                // label1.setStyle("-fx-background-color :#ffffe6");
                hBox.setStyle("-fx-background-color :#ffffe6");
                hBox.getChildren().add(label1);
                hBox.setAlignment(Pos.BASELINE_CENTER);
                layout.getChildren().add(hBox);
            }

            scene = new Scene(layout, 400, 410);
        }
    }

    public void maketree(TreeItem<String> parent, Reservation r) {
        String role = u.getRole();
        TreeItem<String> order = new TreeItem<>("Order");
        makebranch("Table ID " + r.getTableID(), parent);
        if (role == "Manager" || role == "Waiter" || role == "Client") makebranch("Mr " + r.getName(), parent);
        for (DishPair x : r.getOrder().getPlateList()) {
            makebranch(x.getName() + " * " + x.getCount(), order);
        }
        if (role == "Manager" || role == "Client") makebranch(String.valueOf(r.getOrder().getPrice()), order);
        parent.getChildren().add(order);
        DateFormat parser = new SimpleDateFormat("HH:mm dd/MM/yyyy");
        String a = parser.format(r.getStartingDate());
        String b = parser.format(r.getEndingDate());
        makebranch("From " + a, parent);
        if (role == "Manager" || role == "Waiter" || role == "Client") makebranch("To " + b, parent);
        if (role == "Manager" || role == "Waiter" || role == "Client")
            makebranch("Number of seats " + r.getSeatNumber(), parent);
        if (role == "Waiter" || role == "Cooker") {
            Employee employee = (Employee) u;
            TreeItem<String> btn = new TreeItem(" ");
            makebranch("State " + r.getState(), parent);
            Button button = new Button("Mark as " + employee.getChange());
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    employee.setReservationstate(r);

                }
            });
            if (!r.getState().equals(employee.getChange())) btn.setGraphic(button);
            parent.getChildren().add(btn);
        }
    }

    public TreeItem<String> makebranch(String details, TreeItem<String> parent) {
        TreeItem<String> item = new TreeItem<>(details);
        item.setExpanded(true);
        parent.getChildren().add(item);
        return item;
    }

    public Scene getScene() {
        return this.scene;
    }

    public void setlogin(LoginScene l) {

        this.l = l;

    }

    public TreeView<String> getTree() {

        TreeItem<String> root, root1;
        root = new TreeItem<>("Reservations");

        int i = 1;
        for (Reservation r : reservationArrayList) {
            root1 = new TreeItem<>("Reservation " + i++);
            maketree(root1, r);
            root.getChildren().add(root1);
        }
        tree = new TreeView<>(root);
        return tree;
    }

    public boolean isSameDay(Date date1, Date date2) {
        LocalDate localDate1 = date1.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        LocalDate localDate2 = date2.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        return localDate1.isEqual(localDate2);

    }

    public void validateReservations(ArrayList<Reservation> reservationArrayList) {
            this.reservationArrayList = new ArrayList<>();
            for (Reservation res : reservationArrayList) {
                Date today = Calendar.getInstance().getTime();
                Date x = res.getStartingDate();
                if (isSameDay(x, today))
                    this.reservationArrayList.add(res);
            }
        }
    }

