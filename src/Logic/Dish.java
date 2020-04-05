package Logic;

public class Dish {
	private String name;
	private int price;
	private String type;
	
	
	
	public Dish() {
		super();
	}
	
	public Dish(String name, int price, String type) {
		this.name = name;
		this.price = price;
		this.type = type;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public String getType() {
		return type;
	}
}
