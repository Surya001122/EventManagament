import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Registration {
    Scanner sc = new Scanner(System.in);
    private HashMap<String,String> usersLoginInfo;
    private static int loginId = 1;
    private Verification verification;
    private Operations operations;
    public Registration(){
        usersLoginInfo = new HashMap<>();
        operations = new Operations();
    }

    public void userSignUp(Admin admin){}
    private class Verification{
        public void userVerification(Admin admin){}
        public void adminVerification(Admin admin){}

    }
    public void createLogin(Admin admin){}
    public void addLoginInfo(String id,String password) {}
    public boolean validatePassword(String password) {return true;}
    public boolean validatePhoneNumber(String phoneNumber){return true;}
    public String generateUserLoginId(String name){return null;}
}
