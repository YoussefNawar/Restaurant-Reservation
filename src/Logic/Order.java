package Logic;
import java.util.ArrayList;
import java.util.Objects;

import Main.Main;

public class Order {
	private ArrayList <DishPair> plateList;
	private float price;	
	
	public Order() {
		this.plateList = new ArrayList<>();
		this.price = 0;
	}
	public Order(ArrayList<DishPair> plateList, float price) {
		this.plateList = plateList;
		this.price = price;
	}
	public	void addDish(String name) {
		for (DishPair e : this.plateList) {
			if (e.getName().equals(name)) {
				e.setCount(e.getCount() + 1);
				return;
			}
		}
		this.plateList.add(new DishPair(name,1));
	}
	public void removeDish(String name) {
		for (DishPair e : this.plateList) {
			if (e.getName().equals(name))
				e.setCount(e.getCount() - 1);
		}
	}
	public ArrayList <DishPair> getPlateList() {
		return plateList;
	}
	public float getPrice() {
		return price;
	}
	void totalPrice() {
		for(DishPair e : this.plateList) {
			for(Dish x : Main.r.getListOfDishes()) {
				if (e.getName().equals(x.getName())) {
					price += e.getCount()*x.getPrice();
				}
			}
		}
		
	}
	@Override
	public String toString() {
		return " Order :"
				 + plateList.toString() +
				", Total Price=" + price
				;
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Order order = (Order) o;
		return Float.compare(order.price, price) == 0 &&
				Objects.equals(plateList, order.plateList);
	}
}
