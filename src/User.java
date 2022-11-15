import java.util.ArrayList;
import java.util.Scanner;

public class User {
    Scanner sc = new Scanner(System.in);
    private String userName;
    private String userId;
    private Gender gender;
    private String userPassword;
    private String userWorkType;
    private String userLocation;
    private String userPhoneNumber;
    private String dateOfBirth;
    private MyCalendar myCalendar;

    public User(String userName, String userId, Gender gender, String userPassword, String userWorkType, String userLocation, String userPhoneNumber, String dateOfBirth) {
        this.userName = userName;
        this.userId = userId;
        this.gender = gender;
        this.userPassword = userPassword;
        this.userWorkType = userWorkType;
        this.userLocation = userLocation;
        this.userPhoneNumber = userPhoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.myCalendar = new MyCalendar();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserWorkType() {
        return userWorkType;
    }

    public void setUserWorkType(String userWorkType) {
        this.userWorkType = userWorkType;
    }

    public String getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public MyCalendar getMyCalendar() {
        return myCalendar;
    }

    public void setMyCalendar(MyCalendar myCalendar) {
        this.myCalendar = myCalendar;
    }

    public void updatePersonalInformation(){}
    public void changeMyPassword(){}
    public void createEvent(){
        myCalendar.addSpecialEvents();
    }
    public void cancelEvent(){
        myCalendar.cancelSpecialEvents();
    }
    public void updateEvent(){
        myCalendar.updateSpecialEvents();
    }
    public void createTask(){
        myCalendar.addTasks();
    }
    public void cancelTask(){
        myCalendar.deleteTasks();
    }
    public void updateTask(){
        myCalendar.updateTasks();
    }
    public void viewTasks(){
        myCalendar.viewTasks();
    }
    public void viewEvents(){
        myCalendar.viewEvents();
    }
    public void viewMyCalendar(){
        System.out.print("\nEnter 1 to view default calendar\nEnter 2 to view calendar by entering fromMonth and fromYear\nEnter your choice : ");
        int calendarChoice;
        try{
            calendarChoice = Integer.parseInt(sc.nextLine().trim());
        }
        catch (NumberFormatException numberFormatException){
            System.out.print("\nEnter valid choice. please try again...");
            return;
        }
        switch(calendarChoice){
            case 1:
                myCalendar.viewMyCalendar();
                break;
            case 2:
                int fromMonth,toMonth,fromYear,toYear;
                System.out.print("\nEnter fromMonth : ");
                try{
                    fromMonth = Integer.parseInt(sc.nextLine().trim());
                }
                catch (NumberFormatException numberFormatException){
                    System.out.print("\nEnter valid month. please try again...");
                    return;
                }
                System.out.print("\nEnter fromYear : ");
                try{
                    fromYear = Integer.parseInt(sc.nextLine().trim());
                }
                catch (NumberFormatException numberFormatException){
                    System.out.print("\nEnter valid year. please try again...");
                    return;
                }
                System.out.print("\nEnter toMonth : ");
                try{
                    toMonth = Integer.parseInt(sc.nextLine().trim());
                }
                catch (NumberFormatException numberFormatException){
                    System.out.print("\nEnter valid month. please try again...");
                    return;
                }
                System.out.print("\nEnter toYear : ");
                try{
                    toYear = Integer.parseInt(sc.nextLine().trim());
                }
                catch (NumberFormatException numberFormatException){
                    System.out.print("\nEnter valid year. please try again...");
                    return;
                }
                myCalendar.viewMyCalendar(fromMonth-1,toMonth-1,fromYear,toYear);
                break;
            case 3:
                System.out.print("\nExit");
                break;
            default:
                System.out.print("\nEnter valid choice.Please try again...");
                break;
        }
        myCalendar.viewMyCalendar();

    }
    public void addBirthdays(){
        myCalendar.addBirthdays();
    }
    public void removeBirthdays(){
        myCalendar.removeBirthdays();
    }
    public void modifyBirthdays(){
        myCalendar.modifyBirthdays();
    }
    public void viewBirthdays(){
        myCalendar.viewBirthdays();
    }
    public void viewMyHolidays(){
        myCalendar.viewHolidays();
    }
    public void viewAvailableThemes(){
        myCalendar.viewAvailableThemes();
    }
    public void setThemes(){
        myCalendar.setThemes();
    }
}
