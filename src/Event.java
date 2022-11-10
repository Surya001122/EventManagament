import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.logging.Handler;

public class Event extends SpecialEvent{
    private int eventId;
    private Type eventType;
    private String eventStartTime;
    private String eventEndTime;
    private String eventLocation;
    private HashMap<String,Status> AttendeesName;
    private Notify eventAlarm;

    public void addAttender(){}
    public void deleteAttender(){}
    public void editAttender(){}
}
