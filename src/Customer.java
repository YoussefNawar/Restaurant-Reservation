import java.util.ArrayList;

public class Customer extends User {
	private Order order;

	public Customer(String name,String username, String password) {
		super(name, "Customer", username, password);
		this.order= new Order();
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public void addtoOrder(String name) {
		this.order.addDish(name);

			
	}
	
}
