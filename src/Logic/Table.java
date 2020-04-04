package Logic;

import java.util.Comparator;

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

    public int getSeatNo() {
        return seatNo;
    }

    public boolean isSmoking() {
        return smoking;
    }

}

