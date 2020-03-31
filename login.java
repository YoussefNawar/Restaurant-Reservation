import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene ;
import javafx.scene.control.Button ;
import javafx.scene.control.Label ;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class login {
  validate user=new validate();
    Scene scene;
    Stage stage;
    manscene m=new manscene(stage) ;
    cookscene ck=new cookscene(stage) ;
    Waiterscene w=new Waiterscene(stage) ;
    //FileAccess fp = new FileAccess("habl.xml");
    //estaurant r = new Restaurant(fp.getUser(), fp.getTables(), fp.getDishes());
    int i ;

    public login(Stage stage) {
        this.stage = stage;
    }

    public void preparescene(Restaurant r) {
        Label Username = new Label("Enter username:");
        Label PasswordLabel = new Label("Enter Password:");
       // Label RoleLabel = new Label("Enter Role");
        TextField UserTextField = new TextField();
        TextField PasswordField = new TextField();
       // TextField RoleField = new TextField();
        Label validateLabel=new Label();
        Button sign = new Button("Sign in");
        GridPane grid = new GridPane();
        grid.setHgap(6.00);
        grid.setVgap(6.00);
        grid.add(Username, 0, 0);
        grid.add(PasswordLabel, 0, 1);
     //   grid.add(RoleLabel, 0, 2);
        grid.add(UserTextField, 2, 0);
        grid.add(PasswordField, 2, 1);
       // grid.add(RoleField, 2, 2);
        grid.add(sign, 1, 3);
        grid.add(validateLabel,1,5);
        sign.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String Username = UserTextField.getText();
                String Password = PasswordField.getText();
                //String role = RoleField.getText();

                // boolean valid = user.manvalidate(Username, Password);
                //if (valid) {
                for (i = 0; i < r.getListOfUsers().size(); i++) {
                    if ((Username.equals(r.getListOfUsers().get(i).getUsername())) && (Password.equals(r.getListOfUsers().get(i).getPassword()))) {
                        String a = r.getListOfUsers().get(i).getRole();
                        if (a.equals("Manager")) {
                            m.preparescene();
                            stage.setScene(m.getScene());
                        } else if (a.equals("Cook")) {
                            ck.preparescene();
                            stage.setScene(ck.getScene());
                        } else if (a.equals("Waiter")) {
                            w.preparescene();
                            stage.setScene(w.getScene());

                        } else {
                            validateLabel.setText("Username or password incorrect");
                        }
                    }
                }
            }
            });



        scene = new Scene(grid, 600, 400);


    }

    public Scene getScene() {
        return this.scene;
    }
public void setmanscene(manscene m){
        this.m=m ;
}
public void setcookscene(cookscene ck){
        this.ck=ck;
}
public void setWaiterscene(Waiterscene w){
        this.w=w ;
}
}
