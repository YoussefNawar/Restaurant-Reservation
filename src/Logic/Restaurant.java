package Logic;
import Main.Main;

import java.lang.reflect.Array;
import java.util.*;


public class Restaurant  {
	private ArrayList<User> listOfUsers;
	private ArrayList<Table> listOfTables;
	private ArrayList<Dish> listOfDishes;
	private ArrayList<Reservation> listOfReservations;
	private MultiMap userMap ;
	private MultiMap tableMap;

	public Restaurant(ArrayList<User> listOfUsers, ArrayList<Table> listOfTables
			, ArrayList<Dish> listOfDishes,ArrayList<Reservation> listOfReservations) {
		this.listOfUsers = listOfUsers;
		this.listOfTables = listOfTables;
		this.listOfDishes = listOfDishes;
		this.listOfReservations = listOfReservations;

		userMap = new MultiMap();
		tableMap = new MultiMap();
		for(Reservation e : this.listOfReservations){
			this.userMap.put(e.getName(),e);
			this.tableMap.put(e.getTableID(),e);
		}
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
		int j=0;
		Collections.sort(listOfTables, new Comparator<Table>() {
			@Override
			public int compare(Table o1, Table o2) {
				return o1.getSeatNo() - o2.getSeatNo();
			}
		});
		for(Table e : listOfTables){
			if(seatNumber<e.getSeatNo() && e.isSmoking()==smoking){
				checkReservationTime(dateStart,dateEnd,e.getId());
			}

		}
		return j;
	}

	public MultiMap getUserMap() {
		return userMap;
	}

	public MultiMap getTableMap() {
		return tableMap;
	}

	public boolean checkReservationTime(Date a, Date b , int id){
			List X= new ArrayList<Reservation>();
			int j=1;
			X= tableMap.get(id);
			if(X.size()==0)return true;
			for(int i = 0;i<X.size();i++){
				Reservation res = (Reservation) X.get(i);
				if((a.before(res.getStartingDate())&&b.after(res.getEndingDate()))||()) {
					j = 1;
				}
			}



		return true;
	}

	public void addReservation (Reservation r){
		this.listOfReservations.add(r);
		this.userMap.put(r.getName(),r);
		this.tableMap.put(r.getTableID(),r);
	}
}
