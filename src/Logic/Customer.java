package Logic;
import java.util.ArrayList;
import java.util.Date;

public class Customer extends User {
	private Reservation currentReservation;
	private ArrayList<Reservation> reservations;
	

	public Customer(String name,String username, String password) {
		super(name, "Customer", username, password);
		this.reservations= new ArrayList<Reservation>();
	}

	public void createNewReservation(int seatNumber, int tableID, Date date, boolean smoking) {
		Reservation currentReservation = new Reservation(seatNumber,tableID, date,smoking);
	}
	
	public void addtoOrder(String dish) {
		Order currentOrder = currentReservation.getOrder();
		currentOrder.addDish(dish);
		currentReservation.setOrder(currentOrder);
	}
	
	public void saveReservation() {
		this.reservations.add(currentReservation);
	}


	
	
}
