import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

import java.util.ArrayList;
import java.util.HashMap;

public class Admin {
    private String adminId;
    private String adminName;
    private Gender gender;
    private String adminPassword;
    private String adminLocation;
    private String adminPhoneNumber;
    HashMap<User,MyCalendar> usersCalendar;


    public void addUsers(){}
    public void removeUsers(){}
    public void viewUsers(){}
    public void viewCalendars(){}
}
