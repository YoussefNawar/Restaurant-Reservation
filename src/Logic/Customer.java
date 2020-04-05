package Logic;

import java.util.Date;
import Main.Main;

public class Customer extends User {
    private Reservation currentReservation ;


    public Customer(String name, String username, String password) {
        super(name, "Client", username, password);
    }
    public void createNewReservation(int seatNumber, int tableID, Date startdate, Date enddate, boolean smoking) {
        this.currentReservation = new Reservation(seatNumber, tableID, startdate, enddate, smoking, this.getName(), "pending");
    }
    public void addtoOrder(String dish) {
        Order currentOrder = currentReservation.getOrder();
        currentOrder.addDish(dish);
        currentReservation.setOrder(currentOrder);
    }
    public void removeFromOrder(String dish) {
        Order currentOrder = currentReservation.getOrder();
        currentOrder.removeDish(dish);
    }
    public void saveReservation() {
        this.currentReservation.getOrder().totalPrice();
        Main.r.addReservation(this.currentReservation);
    }
    public Reservation getCurrentReservation() {
        return currentReservation;
    }

}
