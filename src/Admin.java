import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Admin {
    Scanner sc;
    private String adminId;
    private String adminName;
    private Gender gender;
    private String adminPassword;
    private String adminLocation;
    private String adminPhoneNumber;
    private ArrayList<User> users;

    public void addUsers(){}
    public void removeUsers(){}
    public void viewUsers(){}
    public User getUser(){return new User();}
    public void viewCalendars(){}

    public void addPublicHolidays(){} // admin can add holidays manually before creating the calendar instance for each user.
    public void removeHolidays(){} // admin can remove holidays
    public static void setBirthdayEvent(String phoneNumber){

    }
}
