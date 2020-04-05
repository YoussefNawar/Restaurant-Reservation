package Logic;
import Main.*;

import java.util.ArrayList;

public class Manager extends User {
	public Manager(String name, String username, String password) {
		super(name, "Manager", username, password);
	}

	public float getTotalMoney(ArrayList<Reservation> reservationsToday ) {
		float total = 0 ;
		for(Reservation e : reservationsToday){
			total += e.getOrder().getPrice();
		}
		return total;
	}

}
