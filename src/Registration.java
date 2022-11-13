import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Calendar;

public class Registration {

    Scanner sc = new Scanner(System.in);
    private static int loginId = 1;
    private HashMap<String, String> usersLoginInfo;
    private Verification verification;

    public Registration() {
        usersLoginInfo = new HashMap<>();
        verification = new Verification();
    }

    public HashMap<String, String> getUsersLoginInfo() {
        return usersLoginInfo;
    }

    public void setUsersLoginInfo(HashMap<String, String> usersLoginInfo) {
        this.usersLoginInfo = usersLoginInfo;
    }

    public Verification getVerification() {
        return verification;
    }

    public void setVerification(Verification verification) {
        this.verification = verification;
    }

    public void userSignUp(Admin admin) {
        User user = null;
        System.out.print("\nEnter your name : ");
        String name = sc.nextLine().trim();
        System.out.println("\nGenerating AdminID : ");
        String loginId = generateUserLoginId(name);
        Gender gender;
        String genderType;
        try {
            System.out.print("\nEnter your gender (MALE,FEMALE,OTHERS): ");
            genderType = sc.nextLine().trim();
            gender = Gender.valueOf(genderType);
        }
        catch (IllegalArgumentException illegalArgumentException){
            System.out.print("\nEnter valid option..please try again");
            return;
        }
        System.out.print("\nEnter your DateOfBirth (MM/DD/YYYY): ");
        String dateOfBirth = sc.nextLine().trim();
        System.out.print("\nEnter your location : ");
        String location = sc.nextLine().trim();
        String phoneNumber;
        do {
            System.out.print("\nEnter your mobileNumber : ");
            phoneNumber = sc.nextLine().trim();
        } while (!validatePhoneNumber(phoneNumber));
        System.out.print("\nEnter your work description : ");
        String workType = sc.nextLine().trim();
        String password;
        do {
            System.out.print("\nPassword must contain at least one digit [0-9].\n\nPassword must contain at least one lowercase character [a-z].\n\nPassword must contain at least one uppercase character [A-Z].\n\nPassword must contain at least one special character like ! @ # & ( ).\n\nPassword must contain a length of at least 8 characters and a maximum of 20 characters.\n\n\nEnter your password : ");
            password = sc.nextLine().trim();
        } while (!validatePassword(password));

        if (usersLoginInfo.containsKey(loginId)) {
            System.out.println("\nUser already exists...");
        }
        else {
            user = new User(name, loginId, gender, password, workType, location, phoneNumber, dateOfBirth);
            addLoginInfo(user.getUserId(), user.getUserPassword());
            admin.addUsers(user);
            System.out.println("User signed up successfully...");
        }
    }


    private class Verification {
        public boolean userVerification(String userId) {
            System.out.print("\nEnter your password : ");
            String userPassword = sc.nextLine().trim();
            if (usersLoginInfo.get(userId).equals(userPassword) && userId.charAt(0)=='U') {
                System.out.println("\n\nUser logged in successfully...");
                return true;
            } else {
                System.out.println("\nYou entered wrong password...Please try again...");
                return false;
            }
        }

        public boolean adminVerification(String adminId) {
            System.out.print("\nEnter your password : ");
            String adminPassword = sc.nextLine().trim();
            if (usersLoginInfo.get(adminId).equals(adminPassword)) {
                System.out.println("\n\nAdmin logged in successfully...");
                return true;
            } else {
                System.out.println("\nYou entered wrong password...Please try again...");
                return false;
            }
        }
    }
    public String createLogin()
    {
        int choice;
        String id = null;
        System.out.print("\nEnter 1 for admin login\nEnter 2 for user login\nEnter 3 to exit\n\n\nEnter your choice : ");
        try {
            choice = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException numberFormatException) {
            System.out.println("\nEnter valid option...");
            return null;
        }
        switch(choice){
            case 1:
                System.out.print("\nEnter your adminId : ");
                id = sc.nextLine().trim();
                if (usersLoginInfo.containsKey(id)) {
                    if(!verification.adminVerification(id)){
                        id = null;
                    }
                } else {
                    System.out.println("\nYour ID does not exist...Please try again...");
                    id = null;
                }
                break;
            case 2:
                System.out.print("\nEnter your userId : ");
                id = sc.nextLine().trim();
                if (usersLoginInfo.containsKey(id)) {
                    if(!verification.userVerification(id)){
                        id = null;
                    }
                }
                else {
                    System.out.println("\nYour ID does not exist...Please try again...");
                    id = null;
                }
                break;
            case 3:
                System.out.print("\nExit");
                break;
            default:
                System.out.print("\nEnter valid option..please try again...");
                break;
        }
        return id;
    }
    public void addLoginInfo(String id,String password){
        usersLoginInfo.put(id,password);
    }
    public boolean validatePassword(String password) {
        Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()]).{8,20}$");
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
    public static boolean validatePhoneNumber(String phoneNumber){
        Pattern pattern = Pattern.compile("^[0-9].{7,15}$");
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
    public String generateUserLoginId(String name){
        String id = "U"+loginId+"_"+name;
        System.out.println("Your generated UserID is "+id);
        loginId += 1;
        return id;
    }
}
