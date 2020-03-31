import java.util.ArrayList;

public class Main {
	public static Restaurant r ;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FileAccess fp = new FileAccess("habl.xml");
		r = new Restaurant(fp.getUser(), fp.getTables(), fp.getDishes());
		
		for(User e :r.getListOfUsers())
		System.out.println(e.toString());
		
	}
}

	
	
	 
	 


