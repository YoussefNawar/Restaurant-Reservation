import java.util.ArrayList;

public class Restaurant {
	private ArrayList<User> listOfUsers;
	private ArrayList<Table> listOfTables;
	private ArrayList<Dish> listOfDishes;
 

	public Restaurant(ArrayList<User> listOfUsers, ArrayList<Table> listOfTables, ArrayList<Dish> listOfDishes) {
		this.listOfUsers = listOfUsers;
		this.listOfTables = listOfTables;
		this.listOfDishes = listOfDishes;
	}

	public ArrayList<User> getListOfUsers() {
		return listOfUsers;
	}

	public void setListOfUsers(ArrayList<User> listOfUsers) {
		this.listOfUsers = listOfUsers;
	}

	public ArrayList<Table> getListOfTables() {
		return listOfTables;
	}

	public void setListOfTables(ArrayList<Table> listOfTables) {
		this.listOfTables = listOfTables;
	}

	public ArrayList<Dish> getListOfDishes() {
		return listOfDishes;
	}

	public void setListOfDishes(ArrayList<Dish> listOfDishes) {
		this.listOfDishes = listOfDishes;
	}
	
	
	public ArrayList<User> filterBy(String jobtitle){
		ArrayList<User> result = new ArrayList<>(); 
		for (User e : listOfUsers) {
			if (e.getRole() == jobtitle) result.add(e);
		}
		return result;
	}

}
