import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class MyCalendar {
    private ArrayList<Task> myTasks;
    private ArrayList<SpecialEvent> myEvents;
    private ArrayList<Birthday> birthDays;
    private ArrayList<Holiday> holidays;
    private HashMap<String,String> myThemes;

    public void viewMyCalendar(){} // default method to print that month in calendar
    public void viewMyCalendar(String Date){} // 1 day view of calendar events, calendar tasks, calendar holidays, calendar birthdays.
    public void viewMyCalendar(String fromDate,String toDate){} // weekly view or monthly view of calendar events, calendar tasks, calendar holidays, calendar birthdays.
    public void addSpecialEvents(){} // used to create an event
    public void cancelSpecialEvents(){} // used to delete an event
    public void updateSpecialEvents(){} // use to update an event
    public void addTasks(){} // used to create a task
    public void deleteTasks(){} // used to delete a task
    public void updateTasks(){} // use to update a task
    public void addBirthdays() {}
    public void removeBirthdays() {}
    public void modifyBirthdays() {}
    public void addHolidays(){}
    public void removeHolidays(){}
    public void viewTasks(){}
    public void viewEvents(){}
    public void viewBirthdays(){}
    public void viewHolidays(){}
    public Event getSpecialEvent(){return new SpecialEvent();}
    public Task  getTask(){return new Task();}
    public Holiday getHoliday(){return new Holiday();}
    public Birthday getBirthday(){return new Birthday();}
    public long findDifferenceInDates(){return 1;}
    public void viewAvailableThemes(){}
    public void setThemes(){}

}
