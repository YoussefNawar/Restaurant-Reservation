package Main;
import java.util.ArrayList;
import Logic.*;

public class Main {
	public static Restaurant r ;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FileAccess fp = new FileAccess("habl.xml");
		r = new Restaurant(fp.getUser(), fp.getTables(), fp.getDishes());
		System.out.println(r.getListOfUsers().get(1).getRole());
		
	}
}

	
	
	 
	 


