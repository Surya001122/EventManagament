package event;
import constant.EventStatus;

import java.util.Date;

public abstract class Event {

    private static int Id;
    private int eventId;
    private String eventTitle;
    private String eventDescription;
    private String eventStartDate;
    private String eventEndDate;
    private EventStatus eventStatus;

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

    public EventStatus getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(EventStatus eventStatus) {
        this.eventStatus = eventStatus;
    }

    public abstract void createReminder(Date date1, Date date2, long seconds);
    public abstract void cancelReminder();
}

