package Logic;

public class Waiter extends User implements Employee{

	public Waiter(String name,String username, String password) {
		super(name,"Waiter", username, password);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setReservationstate(Reservation x) {
		x.setState("served");
	}
}
