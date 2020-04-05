package Logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.parsers.ParserConfigurationException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class FileAccessWriteTest {
    static String fileName = "test.xml";
    static FileAccessWrite fileAccessWrite = new FileAccessWrite(fileName);
    static FileAccess fileAccess ;
    static ArrayList<User> userArrayList;
    static ArrayList<Table> tableArrayList;
    static ArrayList<Dish> dishArrayList;
    static ArrayList<Reservation> reservationArrayList;

    @BeforeAll
    static void setup() throws ParserConfigurationException, ParseException {
        userArrayList = new ArrayList<>();
        userArrayList.add(new Customer("youssef" , "youssef" , "1234"));
        tableArrayList = new ArrayList<>();
        tableArrayList.add(new Table(1,2,false));
        dishArrayList = new ArrayList<>();
        dishArrayList.add(new Dish("as",2,"qw"));
        reservationArrayList = new ArrayList<>();
        Date start = new SimpleDateFormat("HH:mm dd/MM/yyyy").parse("13:50 12/10/2017");
        reservationArrayList.add(new Reservation(12,12,start,start,false,"youssef","1"));
        Restaurant restaurant = new Restaurant(userArrayList,tableArrayList,dishArrayList,reservationArrayList);
        fileAccessWrite.save(restaurant);
    }

    @Test
    void createAndReadUserList() throws ParserConfigurationException {
        fileAccess = new FileAccess(fileName);
        Assertions.assertEquals(fileAccess.getUser(),userArrayList);
    }

    @Test
    void createAndReadReservationList() throws ParserConfigurationException {
        fileAccess = new FileAccess(fileName);
        Assertions.assertEquals(fileAccess.getReservations(),reservationArrayList);
    }


}
