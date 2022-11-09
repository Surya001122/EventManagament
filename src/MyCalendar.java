import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class MyCalendar {
    private ArrayList<Task> myTasks;
    private ArrayList<Event> myEvents;
    private ArrayList<Birthday> birthDays;
    private ArrayList<Holiday> holidays;
    private HashMap<String,String> myThemes;

    public void addEvents(){} // used to create an event
    public void cancelEvents(){} // used to delete an event
    public void updateEvents(){} // use to update an event
    public void viewEvents(int day,int month,int year){}
    public void viewEvents(int day,int month){}
    public void viewEvents(int day){}
    public void addTasks(){} // used to create a task
    public void deleteTasks(){} // used to delete a task
    public void updateTasks(){} // use to update a task
    public void viewAllTasks(){}
    public void viewAllEvents(){}
    public Event getEvent(){return new Event();}
    public Task  getTask(){return new Task();}
    public Holiday getHoliday(){return new Holiday();}
    public Birthday getBirthDay(){return new Birthday();}
    public void displayEvent(){}
    public void displayTask(){}
    public void addBirthDays() {}
    public void removeBirthDays() {}
    public void modifyBirthDays() {}
    public long findDifferenceInDates(){return 1;}
    public void viewAvailableThemes(){}
    public void setThemes(){}

}
