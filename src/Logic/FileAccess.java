package Logic;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FileAccess {
    private static DocumentBuilderFactory dbfact = DocumentBuilderFactory.newInstance();
    private static DocumentBuilder dbuild;
    static Document doc;

    public FileAccess(String outputFile) {
        {
            try {
                dbuild = dbfact.newDocumentBuilder();
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            }
        }
        {
            try {
                doc = dbuild.parse(new File("resources/" + outputFile));
            } catch (SAXException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<User> getUser() {
        ArrayList<User> userList = new ArrayList<>();
        NodeList nlist = doc.getElementsByTagName("user");
        for (int i = 0; i < nlist.getLength(); i++) {
            Node nNode = nlist.item(i);
            if (nNode instanceof Element) {
                Element eElement = (Element) nNode;
                String a = eElement.getElementsByTagName("name").item(0).getTextContent();
                String b = eElement.getElementsByTagName("role").item(0).getTextContent();
                String c = eElement.getElementsByTagName("username").item(0).getTextContent();
                String d = eElement.getElementsByTagName("password").item(0).getTextContent();
                switch (b) {
                    case "Manager": {
                        Manager x = new Manager(a, c, d);
                        userList.add(x);
                        continue;
                    }
                    case "Client": {
                        Customer x = new Customer(a, c, d);
                        userList.add(x);
                        continue;
                    }
                    case "Waiter": {
                        Waiter x = new Waiter(a, c, d);
                        userList.add(x);
                        continue;
                    }
                    case "Cooker": {
                        Cook x = new Cook(a, c, d);
                        userList.add(x);
                    }
                }
            }
        }
        return userList;
    }

    public ArrayList<Table> getTables() {
        ArrayList<Table> tableList = new ArrayList<>();
        NodeList nlist = doc.getElementsByTagName("table");
        for (int i = 0; i < nlist.getLength(); i++) {
            Node nNode = nlist.item(i);
            if (nNode instanceof Element) {
                Element eElement = (Element) nNode;
                Table e = new Table(
                        Integer.parseInt(eElement
                                .getElementsByTagName("number")
                                .item(0)
                                .getTextContent())
                        , Integer.parseInt(eElement
                        .getElementsByTagName("number_of_seats")
                        .item(0)
                        .getTextContent())
                        , Boolean.parseBoolean(eElement
                        .getElementsByTagName("smoking")
                        .item(0)
                        .getTextContent()));

                tableList.add(e);

            }
        }
        return tableList;
    }

    public ArrayList<Dish> getDishes() {
        ArrayList<Dish> dishList = new ArrayList<>();
        NodeList nlist = doc.getElementsByTagName("dish");
        for (int i = 0; i < nlist.getLength(); i++) {
            Node nNode = nlist.item(i);
            if (nNode instanceof Element) {
                Element eElement = (Element) nNode;
                Dish e = new Dish(
                        eElement.getElementsByTagName("name")
                                .item(0)
                                .getTextContent()
                        , Integer.parseInt(eElement
                        .getElementsByTagName("price")
                        .item(0)
                        .getTextContent())
                        , eElement.getElementsByTagName("type")
                        .item(0)
                        .getTextContent());
                dishList.add(e);
            }
        }
        return dishList;
    }

    public ArrayList<Reservation> getReservations() {
        ArrayList<Reservation> reservationList = new ArrayList<>();
        NodeList nlist = doc.getElementsByTagName("reservation");

        for (int i = 0; i < nlist.getLength(); i++) { // reserve list loop
            Node nNode = nlist.item(i);
            if (nNode instanceof Element) {
                Element eElement = (Element) nNode;
                NodeList dlist = eElement.getElementsByTagName("dishe");
                NodeList qlist = eElement.getElementsByTagName("quantity");

                String total = eElement.getElementsByTagName("totalPrice").item(0).getTextContent();
                ArrayList<DishPair> d = new ArrayList<>();

                for (int j = 0; j < dlist.getLength(); j++) { // dish list
                    d.add(new DishPair(dlist.item(j).getTextContent()
                            , Integer.parseInt(qlist.item(j).getTextContent())));
                }
                Order o = new Order(d, Float.parseFloat(total));
                o.toString();
                Reservation reservation = null;
                try {
                    reservation = createReservationNode(eElement, o);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                reservationList.add(reservation);
            }
        }
        return reservationList;
    }

    private Reservation createReservationNode(Element eElement, Order o) throws ParseException {
        assert eElement != null;
        int a = Integer.parseInt(eElement.getElementsByTagName("number_of_seats").item(0).getTextContent());
        int b = Integer.parseInt(eElement.getElementsByTagName("tableId").item(0).getTextContent());
        String start = eElement.getElementsByTagName("startingdate").item(0).getTextContent();
        Date c = new SimpleDateFormat("HH:mm dd/MM/yyyy").parse(start);
        String end = eElement.getElementsByTagName("endingdate").item(0).getTextContent();
        Date e = new SimpleDateFormat("HH:mm dd/MM/yyyy").parse(end);
        boolean f = Boolean.parseBoolean(eElement.getElementsByTagName("smoking").item(0).getTextContent());
        String g = eElement.getElementsByTagName("name").item(0).getTextContent();
        String h = eElement.getElementsByTagName("state").item(0).getTextContent();
        return new Reservation(a, b, c, e, f, g, h, o);
    }
}




