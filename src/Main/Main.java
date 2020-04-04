package Main;

import GUI.LoginScene;
import GUI.ReservationScene;
import Logic.*;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javax.xml.parsers.ParserConfigurationException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;


public class Main extends Application {
    public static FileAccess fileAccess = new FileAccess("file.xml");
    public static Restaurant r = new Restaurant(fileAccess.getUser(), fileAccess.getTables(),
            fileAccess.getDishes(), fileAccess.getReservations());


        /**
         * @param args
         */
        public static void main(String[] args) throws ParseException, ParserConfigurationException {
            launch(args);
            new FileAccessWrite("file.xml").save(r);
        }


    @Override
    public void start(Stage primaryStage) {
        primaryStage.setResizable(false);
        Image img = new Image("logo.jpg");
        LoginScene lol = new LoginScene(primaryStage, r);
        primaryStage.setScene(lol.getScene());
        primaryStage.getIcons().setAll(img);
        primaryStage.show();
    }

}
	
	 
	 


