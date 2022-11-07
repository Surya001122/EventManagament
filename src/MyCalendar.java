import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class MyCalendar {
    private ArrayList<Task> myTasks;
    private ArrayList<Event> myEvents;
    private HashMap<String,String> myContacts;
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
    public void addContacts(){}
    public void removeContacts(){}
    public void viewContacts(){}
    public long findDifferenceInDates(){return 1;}

}
