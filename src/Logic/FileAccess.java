package Logic;

import com.sun.deploy.net.MessageHeader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import sun.util.calendar.BaseCalendar;
import sun.util.calendar.LocalGregorianCalendar;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FileAccess {
	static String filename = "file.xml";

	static DocumentBuilderFactory dbfact = DocumentBuilderFactory.newInstance();
	static DocumentBuilder dbuild;

	static {
		try {
			dbuild = dbfact.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

	static Document doc;

	static {
		try {
			doc = dbuild.parse(new File("resources/" + filename));
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<User> getUser() {
		try {
			DocumentBuilderFactory dbfact = DocumentBuilderFactory.newInstance();
			DocumentBuilder dbuild = dbfact.newDocumentBuilder();
			Document doc = dbuild.parse(new File("resources/"+filename));

			ArrayList<User> userList = new ArrayList<>();


			NodeList nlist = doc.getElementsByTagName("user");

			for (int i = 0; i < nlist.getLength(); i++) {

				Node nNode = nlist.item(i);

				if (nNode instanceof Element) {
					Element eElement = (Element) nNode;

					User e = new User(eElement
							.getElementsByTagName("name")
							.item(0).getTextContent()
							, eElement
							.getElementsByTagName("role")
							.item(0)
							.getTextContent()
							, eElement
							.getElementsByTagName("username")
							.item(0)
							.getTextContent()
							, eElement
							.getElementsByTagName("password")
							.item(0)
							.getTextContent());
					userList.add(e);

				}
			}
			return filter(userList);


		} catch (Exception e) {
			return null;
		}
	}

	private static ArrayList<User> filter(ArrayList<User> userList) {
		ArrayList<User> listOfUser = new ArrayList<>();
		for (int i = 0; i < userList.size(); i++) {
			User e = userList.get(i);
			if (e.getRole().equals("Manager")) {
				Manager x = new Manager(e.getName(), e.getUsername(), e.getPassword());
				listOfUser.add(x);
			}
			if (e.getRole().equals("Client")) {
				Customer x = new Customer(e.getName(), e.getUsername(), e.getPassword());
				listOfUser.add(x);
			}
			if (e.getRole().equals("Cooker")) {
				Cook x = new Cook(e.getName(), e.getUsername(), e.getPassword());
				listOfUser.add(x);

			}
			if (e.getRole().equals("Waiter")) {
				Waiter x = new Waiter(e.getName(), e.getUsername(), e.getPassword());
				listOfUser.add(x);
			}


		}

		return listOfUser;

	}

	public static ArrayList<Table> getTables() {
		try {
			DocumentBuilderFactory dbfact = DocumentBuilderFactory.newInstance();
			DocumentBuilder dbuild = dbfact.newDocumentBuilder();
			Document doc = dbuild.parse(new File("resources/"+filename ));

			ArrayList<Table> tableList = new ArrayList<>();

			NodeList nlist = doc.getElementsByTagName("table");

			for (int i = 0; i < nlist.getLength(); i++) {
				Node nNode = nlist.item(i);

				if (nNode instanceof Element) {
					Element eElement = (Element) nNode;

					Table e = new Table(
							Integer.valueOf(eElement
									.getElementsByTagName("number")
									.item(0)
									.getTextContent())
							, Integer.valueOf(eElement
							.getElementsByTagName("number_of_seats")
							.item(0)
							.getTextContent())
							, Boolean.valueOf(eElement
							.getElementsByTagName("smoking")
							.item(0)
							.getTextContent()));


					tableList.add(e);

				}
			}
			return tableList;

		} catch (Exception e) {
			return null;
		}
	}

	public static ArrayList<Dish> getDishes() {
		try {
			DocumentBuilderFactory dbfact = DocumentBuilderFactory.newInstance();
			DocumentBuilder dbuild = dbfact.newDocumentBuilder();
			Document doc = dbuild.parse(new File("resources/"+filename));

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
							, Integer.valueOf(eElement
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

		} catch (Exception e) {
			return null;
		}
	}

	public static ArrayList<Reservation> getReservations() {
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
							,Integer.valueOf(qlist.item(j).getTextContent())));
				}
				Order o = new Order (d,Float.valueOf(total));
				o.toString();
				Reservation reservation = null;
				try {
					reservation = createReservationNode(eElement,o);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				reservationList.add(reservation);
			}
		}

		assert reservationList != null;
		return reservationList;
	}

	private static Reservation createReservationNode(Element eElement,Order o) throws ParseException {
		assert eElement!= null ;
		Integer a = Integer.valueOf(eElement.getElementsByTagName("number_of_seats").item(0).getTextContent());
		Integer b = Integer.valueOf(eElement.getElementsByTagName("tableId").item(0).getTextContent());
		String start = eElement.getElementsByTagName("startingdate").item(0).getTextContent();
		Date c = new SimpleDateFormat("HH:mm dd/MM/yyyy").parse(start);
		String end = eElement.getElementsByTagName("endingdate").item(0).getTextContent();
		Date e = new SimpleDateFormat("HH:mm dd/MM/yyyy").parse(end);
		Boolean f = Boolean.valueOf(eElement.getElementsByTagName("smoking").item(0).getTextContent());
		String g = eElement.getElementsByTagName("name").item(0).getTextContent();
		Boolean h = Boolean.valueOf(eElement.getElementsByTagName("done").item(0).getTextContent());
		return new Reservation(a,b,c,e,f,g,h,o);
	}
}




