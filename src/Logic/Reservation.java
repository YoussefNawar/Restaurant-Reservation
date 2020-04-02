package Logic;
import sun.java2d.pipe.SpanShapeRenderer;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reservation {
	private int seatNumber;
	private int tableID;
	private Date startingDate;
	private Date endingDate;
	private boolean smoking;
	private Order order;
	private String name;
	private boolean done;


	public Reservation(int seatNumber, int tableID, Date dateStart,Date dateEnd, boolean smoking, String name, Boolean done,Order o) {
		super();
		this.seatNumber = seatNumber;
		this.tableID = tableID;
		this.startingDate = dateStart;
		this.endingDate=dateEnd;
		this.smoking = smoking;
		this.name = name;
		this.done = done;
		this.order = o;

	}


	public Reservation(int seatNumber, int tableID, Date dateStart,Date dateEnd, boolean smoking, String name, Boolean done) {
		super();
		this.seatNumber = seatNumber;
		this.tableID = tableID;
		this.startingDate = dateStart;
		this.endingDate=dateEnd;
		this.smoking = smoking;
		this.name = name;
		this.done = done;
		this.order = new Order();

	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	/**
	 * checks the difference between 2 dates
	 * and returns the difference as a long.
	 *
	 * @param date1 Date Object
	 * @param date2 Date Object
	 * @return long
	 */
	public static long  checkDifference(Date date1, Date date2) {
		return Math.abs((date1.getTime() - date2.getTime())) / (60 * 1000);
	}

	/**
	 * checks if a date is between 2 other dates.
	 *
	 * @param check date need to be checked
	 * @param date1 Date Object
	 * @param date2 Date Object
	 * @return iff check is after date1 and before date2
	 */
	public static boolean between(Date check, Date date1, Date date2) {
		return check.after(date1) && check.before(date2);
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public int getTableID() {
		return tableID;
	}

	public Date getStartingDate() {
		return startingDate;
	}

	public Date getEndingDate() {
		return endingDate;
	}

	public boolean isSmoking() {
		return smoking;
	}

	public String getName() {
		return name;
	}

	public boolean isDone() {
		return done;
	}

	@Override
	public String toString() {
		return "Reservation:" +
				"Number of seats=" + seatNumber +
				", TableID=" + tableID +
				", From " + startingDate +
				", To " + endingDate +
				", Smoking?" + smoking +"\n"
				 +order.toString() +
				", Mr." + name  +
				", Done?" + done
				;
	}
}
