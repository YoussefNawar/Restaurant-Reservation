import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class FileAccess  {
	private String fileName;
	
	public FileAccess(String fileName) {
		super();
		this.fileName = fileName;
	}

	public String getFileName() {
		return fileName;
	}

	public ArrayList<User> getUser(){
		try {
			DocumentBuilderFactory dbfact=DocumentBuilderFactory.newInstance();
			DocumentBuilder dbuild =dbfact.newDocumentBuilder();
			Document doc = dbuild.parse(new File("src/"+this.fileName));	
		
			ArrayList<User> userList = new ArrayList<>();	

			
			NodeList nlist = doc.getElementsByTagName("user");
			
			for(int i=0;i<nlist.getLength();i++) {
					
				Node nNode =  nlist.item(i);
								
				if(nNode instanceof Element) {
					Element eElement =(Element)nNode;

					User e= new User(eElement
									.getElementsByTagName("name")
									.item(0).getTextContent()
									,eElement
									.getElementsByTagName("role")
									.item(0)
									.getTextContent()
									,eElement
									.getElementsByTagName("username")
									.item(0)
									.getTextContent()
									,eElement
									.getElementsByTagName("password")
									.item(0)
									.getTextContent());
				
				userList.add(e);

				}
			}	
			return extracted(userList);
			

		}
		catch(Exception e){
			return null;
		}
	}

	private ArrayList<User>  extracted (ArrayList<User> userList) {
		ArrayList<User> listOfUser = new ArrayList<>();
		for(int i=0 ; i < userList.size(); i++) {
			User e = userList.get(i);	
			if (e.getRole().equals("Manager")) {
				Manager x = new Manager(e.getName(),e.getUsername(),e.getPassword());
				listOfUser.add(x);
			}
			if (e.getRole().equals("Client")) {
				 Customer x = new Customer(e.getName(),e.getUsername(),e.getPassword());
				 listOfUser.add(x);
			}
			if (e.getRole().equals("Cooker")){
				 Cook x = new Cook(e.getName(),e.getUsername(),e.getPassword());
				 listOfUser.add(x);
				 
			}
			if (e.getRole().equals("Waiter")) {
				 Waiter x = new Waiter(e.getName(),e.getUsername(),e.getPassword());
				 listOfUser.add(x);
			}
			
			
		}

			return listOfUser;

	}
	
	public ArrayList<Table> getTables(){
		try {
			DocumentBuilderFactory dbfact=DocumentBuilderFactory.newInstance();
			DocumentBuilder dbuild =dbfact.newDocumentBuilder();
			Document doc = dbuild.parse(new File("src/"+this.fileName));	
		
			ArrayList<Table> tableList = new ArrayList<>();		
			
			NodeList nlist = doc.getElementsByTagName("table");
			
			for(int i=0;i<nlist.getLength();i++) {
				Node nNode =  nlist.item(i);
								
				if(nNode instanceof Element) {
					Element eElement =(Element)nNode;
					
					Table e=new Table(
							Integer.valueOf(eElement
									.getElementsByTagName("number")
									.item(0)
									.getTextContent())
						   ,Integer.valueOf(eElement
								   .getElementsByTagName("number_of_seats")
								   .item(0)
								   .getTextContent())
						   ,Boolean.valueOf(eElement
								   .getElementsByTagName("smoking")
								   .item(0)
								   .getTextContent()));				

				
					tableList.add(e);

				}
			}	
			return tableList;

		}
		catch(Exception e){
			return null;
		}
	}

	public ArrayList<Dish> getDishes(){
		try {
			DocumentBuilderFactory dbfact=DocumentBuilderFactory.newInstance();
			DocumentBuilder dbuild =dbfact.newDocumentBuilder();
			Document doc = dbuild.parse(new File("src/"+this.fileName));	
		
			ArrayList<Dish> dishList = new ArrayList<>();		
			
			NodeList nlist = doc.getElementsByTagName("dish");
			
			for(int i=0;i<nlist.getLength();i++) {
				Node nNode =  nlist.item(i);
								
				if(nNode instanceof Element) {
					Element eElement =(Element)nNode;
					
					Dish e=new Dish(
									eElement.getElementsByTagName("name")
											.item(0)
											.getTextContent()
						            ,Integer.valueOf(eElement
						            		.getElementsByTagName("price")
						            		.item(0)
						            		.getTextContent())
						            ,eElement.getElementsByTagName("type")
						            		.item(0)
						            		.getTextContent());				

				
					dishList.add(e);

				}
			}	
			return dishList;

		}
		catch(Exception e){
			return null;
		}
	}
	
			
	}


