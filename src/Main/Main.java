package Main;

import GUI.ReservationScene;
import Logic.Customer;
import Logic.FileAccess;
import Logic.Restaurant;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.text.ParseException;



public class Main extends Application {
    public static FileAccess fileAccess = new FileAccess("file.xml");
    public static Restaurant r = new Restaurant(fileAccess.getUser(), fileAccess.getTables(),
            fileAccess.getDishes(), fileAccess.getReservations());


        /**
         * @param args
         */
        public static void main(String[] args) throws ParseException {
            Customer e = (Customer) r.getListOfUsers().get(1);


		launch(args);
        }


    @Override
    public void start(Stage primaryStage) {
        //primaryStage.setResizable(false);
        Image img = new Image("logo.jpg");
        // LoginScene lol = new LoginScene(primaryStage,r);
//        CustomerScene cs = new CustomerScene(primaryStage,(Customer)r.getListOfUsers().get(2));
//          System.out.println(r.getListOfUsers().size());
        ReservationScene mn = new ReservationScene(primaryStage, r.getListOfUsers().get(4), r.getListOfReservations());
        primaryStage.setScene(mn.getScene());
        primaryStage.getIcons().setAll(img);
        primaryStage.show();
    }

}
	
	 
	 


