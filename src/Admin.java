import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Admin {

    Scanner sc;
    private String adminId;
    private String adminName;
    private String adminPassword;
    private String adminLocation;
    private String adminPhoneNumber;
    private ArrayList<User> users;
    public Admin(String adminId, String adminName,String adminPassword, String adminLocation, String adminPhoneNumber) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminPassword = adminPassword;
        this.adminLocation = adminLocation;
        this.adminPhoneNumber = adminPhoneNumber;
        users = new ArrayList<>();
        sc = new Scanner(System.in);
    }
    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminLocation() {
        return adminLocation;
    }

    public void setAdminLocation(String adminLocation) {
        this.adminLocation = adminLocation;
    }

    public String getAdminPhoneNumber() {
        return adminPhoneNumber;
    }

    public void setAdminPhoneNumber(String adminPhoneNumber) {
        this.adminPhoneNumber = adminPhoneNumber;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public void addUsers(User user){
        users.add(user);
    }
    public void removeUsers(){
        System.out.println("Enter userId : ");
        String userId = sc.nextLine().trim();
        User user = getUser(userId);
        if(user!=null) {
            users.remove(user);
            System.out.println("\nUser removed...");
        }
        else{
            System.out.println("\nUser not available...");
        }
    }
    public void viewUsers(){
        System.out.print("Enter 1 to get particular user\nEnter 2 to get all users\nEnter your choice : ");
        int choice;
        try{
            choice = Integer.parseInt(sc.nextLine().trim());
        }
        catch(NumberFormatException numberFormatException){
            System.out.println("Enter valid choice...");
            return;
        }
        switch(choice){
            case 1:
                System.out.println("Enter userId : ");
                String userId = sc.nextLine().trim();
                User user = getUser(userId);
                if(user == null){
                    System.out.println("User not available...");
                }
                else{
                    System.out.println("UserID : "+user.getUserId()+"   UserName : "+user.getUserName()+"   Gender : "+user.getGender()+"   UserWorkType : "+user.getUserWorkType()+"   UserLocation : "+user.getUserLocation()+"   UserPhoneNumber : "+user.getUserPhoneNumber());
                }
                break;
            case 2:
                System.out.println("Displaying all Users : \n");
                for(User User : users){
                    System.out.println("UserID : "+User.getUserId()+"   UserName : "+User.getUserName()+"   Gender : "+User.getGender()+"   UserWorkType : "+User.getUserWorkType()+"   UserLocation : "+User.getUserLocation()+"   UserPhoneNumber : "+User.getUserPhoneNumber());
                }
                break;
            case 3:
                break;
            default:
                System.out.println("\nEnter valid option...");
                break;
        }
    }
    public User getUser(String userId){
        for(User user : users){
            if(user.getUserId().equals(userId)){
                return user;
            }
        }
        return null;
    }
    public void viewCalendars(){
        System.out.print("Enter 1 to get particular User's calendar\nEnter 2 to get all User's calendar\nEnter your choice : ");
        int choice;
        try{
            choice = Integer.parseInt(sc.nextLine().trim());
        }
        catch(NumberFormatException numberFormatException){
            System.out.println("Enter valid choice...");
            return;
        }
        switch(choice){
            case 1:
                System.out.println("Enter userId : ");
                String userId = sc.nextLine().trim();
                User user = getUser(userId);
                if(user == null){
                    System.out.println("User not available...");
                }
                else{
                    System.out.println("User");
                }
                break;
            case 2:
                System.out.println("Displaying all Users : \n");
                for(User User : users){
                    System.out.println("User");
                }
                break;
            case 3:
                break;
            default:
                System.out.println("\nEnter valid option...");
                break;
        }
    }
    public void addHolidays(){}
    public void removeHolidays(){}
    public static void addThemes(HashMap<String,String> Themes){
        Themes.put("BLACK","\u001B[30m");
        Themes.put("RED","\u001B[31m");
        Themes.put("GREEN","\u001B[32m");
        Themes.put("YELLOW","\u001B[33m");
        Themes.put("BLUE","\u001B[34m");
        Themes.put("PURPLE","\u001B[35m");
        Themes.put("CYAN","\u001B[36m");
        Themes.put("WHITE","\u001B[37m");
    }
}
