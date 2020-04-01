import Logic.FileAccess;
import Logic.Restaurant;
import javafx.application.Application;
import javafx.stage.Stage;
import GUI.*;


public class Main extends Application {

public static Restaurant r ;
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		FileAccess fp = new FileAccess(".idea/habl.xml");
		Restaurant r = new Restaurant(fp.getUser(), fp.getTables(), fp.getDishes());
		//launch(args);
		System.out.println(fp.getTables().get(0).getId());
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
login lol=new login(primaryStage) ;
manscene mom =new manscene(primaryStage);
cookscene ck=new cookscene(primaryStage);
Waiterscene w=new Waiterscene(primaryStage);
lol.preparescene(r) ;

mom.setlogin(lol);
ck.setlogin(lol);
w.setlogin(lol);
		primaryStage.setScene(lol.getScene());
primaryStage.show();
	}

}
	
	 
	 


