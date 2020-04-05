package Logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class UserTest {
    Customer customer = new Customer("Youssef","youssef","1234");

    @Test
    void constructor(){
       Assertions.assertEquals(customer,customer);
    }
    @Test
    void setterAndGetters(){
        customer.setName("abdelrahman");
        customer.setPassword("123");
        customer.setUsername("abdelrahman_12");
        Assertions.assertEquals(customer.getUsername(),("abdelrahman_12"));
        Assertions.assertEquals(customer.getPassword(),("123"));
        Assertions.assertEquals(customer.getName(),("abdelrahman"));
        Assertions.assertEquals(customer.getRole(),("Client"));
    }
    @Test
    void equals1(){
        Assertions.assertNotEquals(customer,null);
        Assertions.assertNotEquals(customer,new ArrayList<>());
    }

    @Test
    void equals2(){
        Customer customer1 = new Customer("Youssef","1","1234");
        Assertions.assertNotEquals(customer,customer1);
    }

    @Test
    void equals3(){
        Customer customer1 = new Customer("1","youssef","1234");
        Assertions.assertNotEquals(customer,customer1);
    }

    @Test
    void equals4(){
        Customer customer1 = new Customer("Youssef","youssef","122");
        Assertions.assertNotEquals(customer,customer1);
    }

    @Test
    void toStringTest(){
        Assertions.assertEquals(customer.toString(),
                "Name=" + customer.getName() + ", Role=" + customer.getRole() +
                        ", Username=" + customer.getUsername() + ",Password=" + customer.getPassword());
    }


}
