import java.util.ArrayList;

public class Restaurant {
	private ArrayList<Users> listOfUsers;
	private ArrayList<Table> listOfTables;
	private ArrayList<Dish> listOfDishes;

	public Restaurant(ArrayList<Users> listOfUsers, ArrayList<Table> listOfTables, ArrayList<Dish> listOfDishes) {
		this.listOfUsers = listOfUsers;
		this.listOfTables = listOfTables;
		this.listOfDishes = listOfDishes;
	}

}
