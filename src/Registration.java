import java.util.HashMap;

public class Registration {
    private HashMap<String,String> usersLoginInfo;

    public Registration() {

        usersLoginInfo = new HashMap<>();

    }

    public void SignUp(){};

    private class Verification{

        public void userVerification(){};
        public void adminVerification(){};

    }

    public void validatePassword(){};
    public void validatePhoneNumber(){};
    public void generateUserLoginId(){};
    public void generateAdminLoginId(){};
}
