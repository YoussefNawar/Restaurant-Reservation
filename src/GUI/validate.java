import java.util.HashMap;

public class validate {

HashMap valid ;
public validate() {
    valid=new HashMap();
    valid.put("adam","adam_manager");
    valid.put ("john","john_doe");
    valid.put("brian","mdir@admj%ar5qX2");
    valid.put("george","k6987_#LpQ");
    valid.put("hobbens_tom","cooker_pass");
}
public boolean manvalidate(String Username,String Password){
boolean validationresult ;
String fetchedpassword=(String) valid.get(Username);
if (fetchedpassword!=null){


    validationresult=fetchedpassword.equals(Password);

}
else {
    validationresult=false ;
}


return validationresult;


}




































}
