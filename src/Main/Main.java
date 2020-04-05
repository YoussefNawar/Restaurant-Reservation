package Main;

import GUI.CustomerScene;
import GUI.LoginScene;
import GUI.MenuScene;
import GUI.ReservationsDetails;
import Logic.Customer;
import Logic.FileAccess;
import Logic.FileAccessWrite;
import Logic.Restaurant;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javax.xml.parsers.ParserConfigurationException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Main extends Application {
    public static FileAccess fileAccess = new FileAccess("file.xml");
    public static Restaurant r = new Restaurant(fileAccess.getUser(), fileAccess.getTables(),
            fileAccess.getDishes(), fileAccess.getReservations());

    /**
     * @param args
     */
    public static void main(String[] args) throws ParseException, ParserConfigurationException {
//        Date start = new SimpleDateFormat("HH:mm dd/MM/yyyy").parse("13:50 12/10/2017");
//        Date end = new SimpleDateFormat("HH:mm dd/MM/yyyy").parse("15:10 12/10/2017");
//        long diff= Math.abs(start.getTime() - end.getTime());
//        System.out.println(diff/60/1000);

        launch(args);
        new FileAccessWrite("file.xml").save(r);
    }


    @Override
    public void start(Stage primaryStage) throws ParseException {
        primaryStage.setResizable(false);
        Image img = new Image("logo.jpg");
        LoginScene lol = new LoginScene(primaryStage, r);
        primaryStage.setScene(lol.getScene());
        primaryStage.getIcons().setAll(img);
        primaryStage.show();
    }

}
	
	 
	 


