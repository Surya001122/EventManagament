import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.logging.Handler;

public class Event {
    private String eventTitle;
    private Type eventType;
    private Date eventStartDate;
    private Date eventEndDate;
    private Time eventStartTime;
    private Time eventEndTime;
    private String eventLocation;
    private String eventDescription;
    private HashMap<String,Status> AttendeesName;
    private Status EventStatus;
    private Alarm alarm;

    public void addAttender(){}
    public void deleteAttender(){}
    public void editAttender(){}
    public int getTotalAttendees(){return 1;}
}
