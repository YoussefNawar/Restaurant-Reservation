package Main;

import GUI.WaiterScene;
import GUI.CookScene;
import GUI.LoginScene;
import GUI.ManScene;
import Logic.FileAccess;
import Logic.Restaurant;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main extends Application {
    static FileAccess fp = new FileAccess("data.xml");
    public static Restaurant r;

    /**
     * @param args
     */
    public static void main(String[] args) {
		launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Image img = new Image("logo.jpg");
        r = new Restaurant(fp.getUser(), fp.getTables(), fp.getDishes());
        ManScene mom = new ManScene(primaryStage);
        CookScene ck = new CookScene(primaryStage);
        WaiterScene w = new WaiterScene(primaryStage);
        LoginScene lol = new LoginScene(primaryStage,r);
        mom.setlogin(lol);
        ck.setlogin(lol);
        w.setlogin(lol);
        primaryStage.setScene(lol.getScene());
        primaryStage.getIcons().setAll(img);
        primaryStage.show();
    }

}
	
	 
	 


