package Logic;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import Main.*;

public class FileAccessWrite {

    private String outputFile;
    private static DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
    private static DocumentBuilder documentBuilder;

    static {
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    static Document dom = documentBuilder.newDocument();

    public FileAccessWrite(String outputFile) {
        this.outputFile = outputFile;
    }

    public void save(Restaurant r) throws ParserConfigurationException {
        Element rootEle = dom.createElement("Restaurant");
        Element e = dom.createElement("users");
        for(User user : r.getListOfUsers()) {
            Element eus = userCreate(user);
            e.appendChild(eus);
            rootEle.appendChild(e);
        }
        Element f = dom.createElement("tables");
        for(Table table : r.getListOfTables()) {
            Element eus = tableCreate(table);
            f.appendChild(eus);
            rootEle.appendChild(f);
        }
        Element d = dom.createElement("dishes");
        for(Dish dish : r.getListOfDishes()) {
            Element eus = dishCreate(dish);
            d.appendChild(eus);
            rootEle.appendChild(d);
        }
        Element re = dom.createElement("reservations");
        if (r.getListOfReservations() != null) {
            for (Reservation res : r.getListOfReservations()) {
                Element eus = reservationCreate(res);
                re.appendChild(eus);
                rootEle.appendChild(re);
            }
            dom.appendChild(rootEle);
        }

        try {
            Transformer tr = TransformerFactory.newInstance().newTransformer();
            // send DOM to file
            tr.setOutputProperty(OutputKeys.INDENT,"yes");
            tr.setOutputProperty(OutputKeys.METHOD,"xml");
            tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            tr.transform(new DOMSource(dom),
                    new StreamResult(new FileOutputStream("resources/"+outputFile)));

        } catch (TransformerException te) {
            System.out.println(te.getMessage());
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }

        }

    public static Element userCreate(User e) {

        Element eus = dom.createElement("user");
        Element name = dom.createElement("name");
        name.appendChild(dom.createTextNode(e.getName()));
        Element role = dom.createElement("role");
        role.appendChild(dom.createTextNode(e.getRole()));
        Element username = dom.createElement("username");
        username.appendChild(dom.createTextNode(e.getUsername()));
        Element password = dom.createElement("password");
        password.appendChild(dom.createTextNode(e.getPassword()));
        eus.appendChild(name);
        eus.appendChild(role);
        eus.appendChild(username);
        eus.appendChild(password);
        return eus;
    }

    public static Element tableCreate(Table e) {

        Element eus = dom.createElement("table");
        Element number = dom.createElement("number");
        number.appendChild(dom.createTextNode( String.valueOf(e.getId())));
        Element number_of_seats = dom.createElement("number_of_seats");
        number_of_seats.appendChild(dom.createTextNode(String.valueOf(e.getSeatNo())));
        Element smoking = dom.createElement("smoking");
        smoking.appendChild(dom.createTextNode(String.valueOf(e.isSmoking())));
        eus.appendChild(number);
        eus.appendChild(number_of_seats);
        eus.appendChild(smoking);
        return eus;
    }

    public static Element dishCreate(Dish e) {

        Element eus = dom.createElement("dish");
        Element name = dom.createElement("name");
        name.appendChild(dom.createTextNode( e.getName()));
        Element price = dom.createElement("price");
        price.appendChild(dom.createTextNode(String.valueOf(e.getPrice())));
        Element type = dom.createElement("type");
        type.appendChild(dom.createTextNode(e.getType()));
        eus.appendChild(name);
        eus.appendChild(price);
        eus.appendChild(type);
        return eus;
    }

    public static Element reservationCreate(Reservation e) {
        Element eus = dom.createElement("reservation");

        Element number_of_seats = dom.createElement("number_of_seats");
        number_of_seats.appendChild(dom.createTextNode(String.valueOf(e.getSeatNumber())));

        Element tableId = dom.createElement("tableId");
        tableId.appendChild(dom.createTextNode(String.valueOf(e.getTableID())));

        DateFormat parser = new SimpleDateFormat("HH:mm dd/MM/yyyy");

        Element startingdate = dom.createElement("startingdate");
        startingdate.appendChild(dom.createTextNode(parser.format(e.getStartingDate())+ ""));

        Element endingdate = dom.createElement("endingdate");

        endingdate.appendChild(dom.createTextNode(parser.format(e.getEndingDate()) + ""));

        Element smoking = dom.createElement("smoking");
        smoking.appendChild(dom.createTextNode(String.valueOf(e.isSmoking())));

        Element state = dom.createElement("state");
        state.appendChild(dom.createTextNode(e.getState()));

        Element totalPrice = dom.createElement("totalPrice");
        totalPrice.appendChild(dom.createTextNode(e.getOrder().getPrice()+""));

        Element name = dom.createElement("name");
        name.appendChild(dom.createTextNode(e.getName()));

        Element order = dom.createElement("order");
        for( DishPair o : e.getOrder().getPlateList()){
            Element eu = dom.createElement("dishe");
            eu.appendChild(dom.createTextNode(o.getName()));
            Element count = dom.createElement("quantity");
            count.appendChild(dom.createTextNode(String.valueOf(o.getCount())));
            order.appendChild(eu);
            order.appendChild(count);
        }
        eus.appendChild(number_of_seats);
        eus.appendChild(name);
        eus.appendChild(startingdate);
        eus.appendChild(endingdate);
        eus.appendChild(smoking);
        eus.appendChild(state);
        eus.appendChild(tableId);
        order.appendChild(totalPrice);
        eus.appendChild(order);
        return eus;
    }
}
