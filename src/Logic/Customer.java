package Logic;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import Main.*;

public class Customer extends User {
	private Reservation currentReservation;
	private ArrayList<Reservation> reservations;
	

	public Customer(String name,String username, String password) {
		super(name, "Client", username, password);
		this.reservations= new ArrayList<Reservation>();
	}

	public void createNewReservation(int seatNumber, int tableID, Date startdate,Date enddate, boolean smoking) {
		this.currentReservation = new Reservation(seatNumber,tableID, startdate ,enddate,smoking,this.getName(),false);
	}
	
	public void addtoOrder(String dish) {
		Order currentOrder = currentReservation.getOrder();
		currentOrder.addDish(dish);
		currentReservation.setOrder(currentOrder);
	}
	public void removeFromOrder(String dish){
		removeFromOrder(dish);
	}
	
	public void saveReservation() {
		this.currentReservation.getOrder().totalPrice();
		this.reservations.add(currentReservation);
		Main.r.addReservation(this.currentReservation);

	}

	public Reservation getCurrentReservation() {
		return currentReservation;
	}
}
