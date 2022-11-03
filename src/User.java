public class User {
    private String userName;
    private String userId;
    private Gender gender;
    private String userPassword;
    private String userWorkType;
    private String userLocation;
    private String userPhoneNumber;
    private MyCalendar myCalendar;
    public User(){}
    public User(String userName, String userId, Gender gender, String userPassword, String userWorkType, String userLocation, String userPhoneNumber, MyCalendar myCalendar) {
        this.userName = userName;
        this.userId = userId;
        this.gender = gender;
        this.userPassword = userPassword;
        this.userWorkType = userWorkType;
        this.userLocation = userLocation;
        this.userPhoneNumber = userPhoneNumber;
        this.myCalendar = myCalendar;
    }

    public void updatePersonalInformation(){}
    public void changeMyPassword(){}
    public void createEvent(){}
    public void cancelEvent(){}
    public void updateEvent(){}
    public void createTask(){}
    public void cancelTask(){}
    public void updateTask(){}
    public void viewTasks(){}
    public void viewEvents(){}
    public void viewMyCalendar(){}
    public void viewAttendees(){}
}
