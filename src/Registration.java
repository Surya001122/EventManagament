import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Registration {

    private HashMap<String,String> usersLoginInfo;

    private static int loginId = 1;

    private Verification verification;

    public void userSignUp(Admin admin){}

    private class Verification{
        public boolean userVerification(Admin admin){return true;}
        public boolean adminVerification(Admin admin){return true;}

    }
    public void createLogin(Admin admin){}
    public void addLoginInfo(String id,String password) {}
    public boolean validatePassword(String password) {return true;}
    public boolean validatePhoneNumber(String phoneNumber){return true;}
    public String generateUserLoginId(String name){return null;}
}
