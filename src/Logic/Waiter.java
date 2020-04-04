package Logic;

public class Waiter extends User implements Employee{
	private String change;

	public Waiter(String name,String username, String password) {
		super(name,"Waiter", username, password);
		change="served";
	}
	@Override
	public void setReservationstate(Reservation x) {
		x.setState("served");
	}
	public String getChange() {
		return change;
	}
}
