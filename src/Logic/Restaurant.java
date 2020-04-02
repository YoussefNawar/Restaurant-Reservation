package Logic;
import java.util.ArrayList;
import java.util.Date;


public class Restaurant {
	private ArrayList<User> listOfUsers;
	private ArrayList<Table> listOfTables;
	private ArrayList<Dish> listOfDishes;
	private ArrayList<Reservation> listOfReservations;
 

	public Restaurant(ArrayList<User> listOfUsers, ArrayList<Table> listOfTables
			, ArrayList<Dish> listOfDishes,ArrayList<Reservation> listOfReservations) {
		this.listOfUsers = listOfUsers;
		this.listOfTables = listOfTables;
		this.listOfDishes = listOfDishes;
		this.listOfReservations = listOfReservations;
	}

	public ArrayList<User> getListOfUsers() {
		return listOfUsers;
	}

	public ArrayList<Table> getListOfTables() {
		return listOfTables;
	}

	public ArrayList<Dish> getListOfDishes() {
		return listOfDishes;
	}

	public ArrayList<Reservation> getListOfReservations() {
		return listOfReservations;
	}

	public void addUser(String name, String username, String password) {
		User x = new Customer(name,username,password);
		this.listOfUsers.add(x);
		
	}

	public int checkAvailable(int seatNumber, Date dateStart, Date dateEnd, boolean smoking){
		ArrayList<Integer> x = new ArrayList<>();
		int j=0;
		for(Table e : this.listOfTables){
			if(seatNumber<e.getSeatNo()&& smoking==e.isSmoking()){
				x.add(e.getId());
			}
		}
		for(int i=0; i<x.size();i++){

		}
		return j;
	}

	public void addReservation (Reservation r){
		this.listOfReservations.add(r);
	}
}
