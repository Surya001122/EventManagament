import java.util.ArrayList;

public class User {
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
        myCalendar.viewMyCalendar();
        myCalendar.viewMyCalendar("1");
        myCalendar.viewMyCalendar("1","2");
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
    public void addHolidays(){
        myCalendar.addHolidays();
    }
    public void removeHolidays(){
        myCalendar.removeHolidays();
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
