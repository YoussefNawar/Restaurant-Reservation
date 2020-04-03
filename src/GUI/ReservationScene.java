package GUI;

import Logic.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ReservationScene {
    Scene scene;
    Stage stage;
    LoginScene l;
    User u;
    ArrayList<Reservation>reservationArrayList;
    TreeView <String> tree;

    public ReservationScene(Stage stage, User e, ArrayList<Reservation> reservationArrayList) {
        this.u = e;
        this.stage = stage;
        this.reservationArrayList = reservationArrayList;
        prepareScene();
    }

    public void prepareScene() {
        VBox layout = new VBox();
        if (reservationArrayList == null) {
            Label label2 = new Label("No Reservations for Today");
            label2.setFont(new Font("Arial", 16));
            layout.getChildren().add(label2);
            scene = new Scene(layout,400,600);
        } else {
            if (u.getRole() == "Manager") this.stage.setTitle("Manager");
            if (u.getRole() == "Waiter") this.stage.setTitle("Waiter");
            if (u.getRole() == "Cooker") this.stage.setTitle("Cook");
            tree = getTree();
            layout.getChildren().add(tree);
            if (u.getRole()=="Manager") {
                Manager x = (Manager) u;
                Label label1 = new Label("Total amount of money today =" + x.getTotalMoney(reservationArrayList));
                label1.setFont(new Font("Arial", 16));
                layout.getChildren().add(label1);
            }
            scene = new Scene(layout, 400, 500);

        }
    }

    public void maketree(TreeItem<String> parent, Reservation r) {
        String role = u.getRole();
        TreeItem<String> order = new TreeItem<>("Order");
        TreeItem<String> Dish = new TreeItem<>("Dish");
        makebranch("Table ID " + r.getTableID(), parent);
       if (role=="Manager"||role=="Waiter"||role=="Client") makebranch("Name " + r.getName(), parent);
        for (DishPair x : r.getOrder().getPlateList()) {
            makebranch(x.getName() + " * " + x.getCount(), order);

        }
       if(role=="Manager"||role=="Client") makebranch(String.valueOf(r.getOrder().getPrice()), order);
        parent.getChildren().add(order);
        DateFormat parser = new SimpleDateFormat("HH:mm dd/MM/yyyy");
        String a = parser.format(r.getStartingDate());
        String b = parser.format(r.getEndingDate());

        makebranch("From " + a, parent);
       if(role=="Manager"||role=="Waiter"||role=="Client") makebranch("To " + b, parent);
       if(role=="Manager"||role=="Waiter"||role=="Client") makebranch("Number of seats " + r.getSeatNumber(), parent);
       makebranch("State " + r.getState(), parent);
       if(role=="Waiter"||role=="Cooker") {
           TreeItem<String> btn = new TreeItem(" ");
           Button button = new Button("Mark as cooked");
           btn.setGraphic(button);
           parent.getChildren().add(btn);
       }
    }




    public TreeItem<String> makebranch (String details, TreeItem<String> parent) {
        TreeItem<String> item = new TreeItem<>(details);
        item.setExpanded(true);
        parent.getChildren().add(item);
        return item ;
    }


    public Scene getScene() {
        return this.scene;
    }

    public void setlogin(LoginScene l) {

        this.l = l;

    }

    public TreeView<String> getTree(){

        TreeItem<String> root,root1;
        root = new TreeItem<>("Reservations");

        int i =1;
        for (Reservation r : reservationArrayList){
            root1 = new TreeItem<>("Reservation " + i++);
            maketree(root1, r);
            root.getChildren().add(root1);
        }
        tree = new TreeView<>(root);
     return tree;
    }

    public AnchorPane treeView(){
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().add(this.treeView());
        return anchorPane;
    }



}
