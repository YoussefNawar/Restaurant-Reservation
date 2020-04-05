package Logic;

import com.sun.deploy.net.MessageHeader;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class RestrauntTest {
        private static ArrayList<User> customerList;
        private  static ArrayList <Table> tableArrayList;
        private static Restaurant restaurant;

        @BeforeAll
        static void setUp() {
                Customer customer = new Customer("youssef", "yusef", "1234");
                customerList.add(customer);
                Table table = new Table(1, 5, true);
                tableArrayList.add(table);
                restaurant = new Restaurant(customerList,tableArrayList,null,null);
        }

}
