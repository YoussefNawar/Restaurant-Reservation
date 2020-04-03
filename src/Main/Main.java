package Main;

import GUI.CustomerScene;
import GUI.LoginScene;
import Logic.Customer;
import Logic.FileAccess;
import Logic.FileAccessWrite;
import Logic.Restaurant;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javax.xml.parsers.ParserConfigurationException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class Main  {
    public static FileAccess fileAccess = new FileAccess("file.xml");
    public static Restaurant r = new Restaurant(fileAccess.getUser(), fileAccess.getTables(),
            fileAccess.getDishes(),fileAccess.getReservations());

    /**
     * @param args
     */
    public static void main(String[] args) throws ParseException {
        Customer e = (Customer) r.getListOfUsers().get(1);


//		launch(args);
    }

//    @Override
//    public void start(Stage primaryStage) {
//        primaryStage.setResizable(false);
//        Image img = new Image("logo.jpg");
//        LoginScene lol = new LoginScene(primaryStage,r);
//        primaryStage.setScene(lol.getScene());
//        primaryStage.getIcons().setAll(img);
//        primaryStage.show();
//    }

}
	
	 
	 


