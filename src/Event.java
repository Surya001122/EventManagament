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
    private String eventStartDate;
    private String eventEndDate;
    private Status eventStatus;
    private String eventTheme;

    public Event(String eventTitle, String eventDescription, String evenStartDate, String eventEndDate) {
        this.eventId = Id++;
        this.eventTitle = eventTitle;
        this.eventDescription = eventDescription;
        this.eventStartDate = evenStartDate;
        this.eventEndDate = eventEndDate;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventStartDate() {
        return eventStartDate;
    }

    public void setEventStartDate(String evenStartDate) {
        this.eventStartDate = evenStartDate;
    }

    public String getEventEndDate() {
        return eventEndDate;
    }

    public void setEventEndDate(String eventEndDate) {
        this.eventEndDate = eventEndDate;
    }

    public Status getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(Status eventStatus) {
        this.eventStatus = eventStatus;
    }

    public String getEventTheme() {
        return eventTheme;
    }

    public void setEventTheme(String eventTheme) {
        this.eventTheme = eventTheme;
    }

    abstract void createReminder(long seconds);
}
