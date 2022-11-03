import java.util.HashMap;
public class Registration {
    private HashMap<String,String> usersLoginInfo;
    private Verification verification;
    public void SignUp(){}


    private class Verification{
        public void userVerification(){}
        public void adminVerification(){}

    }


    void createLogin(){
        verification = new Verification();
    }
    public void validatePassword() {}
    public void validatePhoneNumber(){}
    public void generateUserLoginId(){}
    public void generateAdminLoginId(){}
}
