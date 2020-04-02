package Main;

import GUI.*;
import Logic.Customer;
import Logic.FileAccess;
import Logic.FileAcessWrite;
import Logic.Restaurant;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javax.xml.parsers.ParserConfigurationException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.spi.CalendarDataProvider;


public class Main //extends Application {
    {
    public static Restaurant r = new Restaurant(FileAccess.getUser(), FileAccess.getTables(),
            FileAccess.getDishes(),FileAccess.getReservations());;

    /**
     * @param args
     */
    public static void main(String[] args) throws ParseException, ParserConfigurationException {
        Date d = new Date();

//        Customer c = (Customer) r.getListOfUsers().get(1);
//        DateFormat dateFormat =new SimpleDateFormat("HH:mm dd/MM/yyyy");
//        Date a = dateFormat.parse("13:00 12/12/2012");
//        Date b = dateFormat.parse("14:00 12/12/2012");
//        c.createNewReservation(4,1,a,b,true);
//        c.addtoOrder("Mushroom Soup");
//        c.addtoOrder("Molten Cake");
//        c.saveReservation();

        FileAcessWrite.save(r);


		//launch(args);
    }

//    @Override
//    public void start(Stage primaryStage) {
//        primaryStage.setResizable(false);
//        Image img = new Image("logo.jpg");
//       // LoginScene lol = new LoginScene(primaryStage,r);
//        CustomerScene cs = new CustomerScene(primaryStage,(Customer)r.getListOfUsers().get(2));
//        primaryStage.setScene(cs.getScene());
//        primaryStage.getIcons().setAll(img);
//        primaryStage.show();
//    }

}
	
	 
	 


