package Logic;

public class Table {
	private int id;
	private int seatNo;
	private boolean smoking;
	
	public Table(int id, int seatNo, boolean smoking) {
		this.id = id;
		this.seatNo = seatNo;
		this.smoking = smoking;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	public boolean isSmoking() {
		return smoking;
	}
	public void setSmoking(boolean smoking) {
		this.smoking = smoking;
	}
	

}
