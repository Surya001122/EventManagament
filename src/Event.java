import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.logging.Handler;

public class Event {
    private int eventId;
    private String eventTitle;
    private Type eventType;
    private String evenStartDate;
    private String eventEndDate;
    private String eventStartTime;
    private String eventEndTime;
    private String eventLocation;
    private String eventDescription;
    private HashMap<String,Status> AttendeesName;
    private Status eventStatus;
    private String eventTheme;
    private Notify eventAlarm;

    public void addAttender(){}
    public void deleteAttender(){}
    public void editAttender(){}
}
