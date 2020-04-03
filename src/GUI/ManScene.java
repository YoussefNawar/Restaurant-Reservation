package GUI;

import Logic.Manager;
import Logic.User;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import Logic.*;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class ManScene {
    Scene scene;
    Stage stage;
    LoginScene l;
    Manager manager;
    Reservation r;
    Restaurant res;
    int i;
    Order or;
    // TableView<Reservation> reservationTableView ;
    TreeView<String> tree;

    public ManScene(Stage stage, Manager e, Restaurant res) {
        this.manager = e;
        this.stage = stage;
        this.res = res;
        prepareScene();
    }

    public void prepareScene() {
        this.stage.setTitle("Manager");
        TreeItem<String> root;
        root = new TreeItem<>("Reservations");
        tree = new TreeView<>(root);
        tree.setShowRoot(true);
        root.setExpanded(true);
        StackPane layout = new StackPane();
        maketree(root);
        Scene scene = new Scene(layout, 600, 400);

    }

    public void maketree(TreeItem<String> parent) {
        for (r : res.getListOfReservations()) {
            TreeItem<String> ID;
            ID = makebranch(r.getTableID(), parent);
            makebranch(r.getName(),r.getTableID());
          makebranch(r.getOrder().getPlateList().toString(),r.getTableID());
          makebranch(r.getOrder().getPrice(), r.getTableID());
          makebranch(r.getStartingDate().toString(),r.getTableID());
           makebranch(r.getEndingDate().toString(),r.getTableID());
            makebranch(r.getSeatNumber(),r.getTableID());
            makebranch(r.isSmoking(),r.getTableID());
            makebranch(r.isDone(),r.getTableID());
        }
    }



    public TreeItem<String> makebranch(String details, TreeItem<String> parent) {
TreeItem<String> item=new TreeItem<>(details);
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


}
