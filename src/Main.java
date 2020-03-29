import java.util.ArrayList;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FileAccess fp = new FileAccess("habl.xml");
		Restaurant r = new Restaurant(fp.getUsers(), fp.getTables(), fp.getDishes());
	}
}

	
	
	 
	 


