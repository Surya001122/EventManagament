import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.logging.Handler;

public abstract class Event {
    private static int Id;
    private int eventId;
    private String eventTitle;
    private String eventDescription;
    private String evenStartDate;
    private String eventEndDate;
    private Status eventStatus;
    private String eventTheme;
    abstract void createReminder();
}
