package Logic;

public class Cook extends User implements Employee {
	private String change;

	public Cook(String name, String username, String password) {
		super(name,"Cooker", username, password);
		this.change = "ready";
	}
	@Override
	public void setReservationstate(Reservation x) {
		x.setState("ready");
	}

	public String getChange() {
		return change;
	}
}
