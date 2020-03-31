package Logic;
import java.util.Date;

public class Reservation {
	private int seatNumber;
	private int tableID;
	private Date date;
	private boolean smoking;
	private Order order;
	
	public Reservation() {
		this.order=new Order();
	}
	

	public Reservation(int seatNumber, int tableID, Date date, boolean smoking) {
		super();
		this.seatNumber = seatNumber;
		this.tableID = tableID;
		this.date = date;
		this.smoking = smoking;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	
	
	
	
	

}
