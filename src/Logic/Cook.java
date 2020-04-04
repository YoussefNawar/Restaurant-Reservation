package Logic;

public class Cook extends User implements Employee {

	public Cook(String name, String username, String password) {
		super(name,"Cooker", username, password);
	}
	public void markDone(){

	}

	@Override
	public void setReservationstate(Reservation x) {
		x.setState("Cooked");

	}
}
