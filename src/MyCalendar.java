import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class MyCalendar {
    private ArrayList<Task> myTasks;
    private ArrayList<Event> myEvents;
    private ArrayList<Birthday> birthDays;
    private ArrayList<Holiday> holidays;
    private HashMap<String,String> myThemes;
    public void viewMyCalendar(String Date){} // 1 day view of calendar events, calendar tasks, calendar holidays, calendar birthdays.
    public void viewMyCalendar(String fromDate,String toDate){} // weekly view or monthly view of calendar events, calendar tasks, calendar holidays, calendar birthdays.
    public void addEvents(){} // used to create an event
    public void cancelEvents(){} // used to delete an event
    public void updateEvents(){} // use to update an event
    public void addTasks(){} // used to create a task
    public void deleteTasks(){} // used to delete a task
    public void updateTasks(){} // use to update a task
    public void addBirthDays() {}
    public void removeBirthDays() {}
    public void modifyBirthDays() {}
    public void viewTasks(){}
    public void viewAEvents(){}
    public void viewBirthdays(){}
    public void viewHolidays(){}
    public Event getEvent(){return new Event();}
    public Task  getTask(){return new Task();}
    public Holiday getHoliday(){return new Holiday();}
    public Birthday getBirthDay(){return new Birthday();}
    public long findDifferenceInDates(){return 1;}
    public void viewAvailableThemes(){}
    public void setThemes(){}

}
