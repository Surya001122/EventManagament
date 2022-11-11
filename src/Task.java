import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Task extends NonRecurringEvent{
    public Task(String eventTitle, String eventDescription, String evenStartDate, String eventEndDate, String nonRecurringEventStartTime, String nonRecurringEventEndTime) {
        super(eventTitle, eventDescription, evenStartDate, eventEndDate, nonRecurringEventStartTime, nonRecurringEventEndTime);
    }

    public void completeTask(){} // used to change the status;
}