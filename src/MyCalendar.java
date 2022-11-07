import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class MyCalendar {
    private ArrayList<Task> myTasks;
    private ArrayList<Event> myEvents;
    private HashMap<String,String> myContacts; // phoneNumber of friends and their dob..If the friends does not have login, default values will be null.
    public void addEvents(){} // used to create an event
    public void cancelEvents(){} // used to delete an event
    public void updateEvents(){} // use to update an event
    public void viewEvents(int day,int month,int year){} // view events in year
    public void viewEvents(int day,int month){} // view events in months
    public void viewEvents(int day){} // view events in weeks
    public void addTasks(){} // used to create a task
    public void deleteTasks(){} // used to delete a task
    public void updateTasks(){} // use to update a task
    public void viewAllTasks(){}
    public void viewAllEvents(){}
    public Event getEvent(){return new Event();}
    public Task  getTask(){return new Task();}
    public void displayEvent(){}
    public void displayTask(){}


    public void addMyContacts(){}
    public void removeMyContacts(){}
    public void viewMyContacts(){}
    public void addMyHolidays(){}
    public void removeMyHolidays(){}
    public void viewMyHolidays(){}
    public long findDifferenceInDates(){return 1;}

}
