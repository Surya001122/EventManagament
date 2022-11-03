import java.util.ArrayList;
import java.util.Calendar;
public class MyCalendar {
    private ArrayList<Task> tasks;
    private ArrayList<Event> events;
    public void addEvents(){} // used to create an event
    public void cancelEvents(){} // used to delete an event
    public void updateEvents(){} // use to update an event
    public void viewEvents(int day,int month,int year){} // view events in year
    public void viewEvents(int day,int month){} // view events in months
    public void viewEvents(int day){} // view events in weeks
    public void addTasks(){} // used to create a task
    public void deleteTasks(){} // used to delete a task
    public void updateTasks(){} // use to update a task
    public void viewTasks(int day,int month,int year){} // view tasks in year
    public void viewTasks(int day,int month){} // view tasks in months
    public void viewTasks(int day){} // view tasks in weeks
    public void viewAttendees(){} // view attenders for an event

    public Event getEvent(){return new Event();}
    public Task  getTask(){return new Task();}
    public String getAttenderName(){return null;}

}
