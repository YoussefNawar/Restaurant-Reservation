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
    private Customer c;
    private VBox layout;

    public Cusdetails(Customer c) {
        this.c = c;
        preparescene();
    }

    public void preparescene() {
        HBox h1 = new HBox();
        HBox h3 = new HBox();
        HBox h4 = new HBox();
        HBox h5 = new HBox();
        Label UserLabel = new Label("Username : ");
        Label userName = new Label(c.getUsername());

        Label error = new Label();

        Label fullName = new Label("Full name : ");
        Label fullNametext = new Label(c.getName());
        HBox hBox = new HBox();
        hBox.getChildren().addAll(fullName,fullNametext);
        hBox.setAlignment(Pos.CENTER_LEFT);

        Button newp = new Button("Change Password");
        newp.setStyle("-fx-background-color: #ffc966");

        h1.getChildren().addAll(UserLabel, userName);
        h1.setAlignment(Pos.CENTER_LEFT);

        Button confirm = new Button("Confirm");
        confirm.setStyle("-fx-background-color: #ffc966");
        confirm.setVisible(false);
        Label oldPassword = new Label();
        TextField oldPaswordField = new TextField();
        oldPaswordField.setVisible(false);
        Label newPassword = new Label();
        TextField newPasswordField = new TextField();
        newPasswordField.setVisible(false);
        TextField confirmPasswordField = new TextField();
        confirmPasswordField.setVisible(false);
        Label confirmPassword = new Label();
        h3.getChildren().addAll(newPassword,newPasswordField);
        h3.setAlignment(Pos.CENTER_LEFT);
        h4.getChildren().addAll(oldPassword,oldPaswordField);
        h4.setAlignment(Pos.CENTER_LEFT);
        h5.getChildren().addAll(confirmPassword,confirmPasswordField);
        h5.setAlignment(Pos.CENTER_LEFT);

        VBox v = new VBox();
        v.getChildren().addAll(hBox,h1, newp,h4,h3,h5,confirm,error);

        v.setSpacing(8);
        v.setPadding(new Insets(10));
        v.setStyle("-fx-background-color: #ffffe6");

        confirm.setOnAction(e -> {
            if ((oldPaswordField.getText().equals(c.getPassword())) &&
                    (newPasswordField.getText().equals(confirmPasswordField.getText()))) {
                c.setPassword(newPasswordField.getText());
                newPassword.setVisible(false);
                confirmPassword.setVisible(false);
                oldPassword.setVisible(false);
                confirmPasswordField.setVisible(false);
                oldPaswordField.setVisible(false);
                newPasswordField.setVisible(false);
                confirm.setVisible(false);
            } else if (!(oldPaswordField.getText().equals(c.getPassword()))) {
                error.setText("Invalid old password");
            } else {
                error.setText("Passwords entered are incorrect");
            }
        });
        newp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                newPassword.setText("New password  :");
                confirmPassword.setText("Confirm password  :");
                oldPassword.setText("Old password  :");
                confirmPasswordField.setVisible(true);
                oldPaswordField.setVisible(true);
                newPasswordField.setVisible(true);
                confirm.setVisible(true);
            }
        });

        this.layout = v;
    }

    public VBox getLayout() {
        return layout;
    }
}
