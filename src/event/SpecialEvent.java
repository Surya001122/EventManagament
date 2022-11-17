package event;

import constant.Type;

import java.util.ArrayList;

public class SpecialEvent extends NonRecurringEvent {

    private ArrayList<String> Attendees;
    private String eventLocation;
    private Type eventType;
    public static String eventTheme = "";

    public SpecialEvent(String eventTitle, String eventDescription, String evenStartDate, String eventEndDate, String nonRecurringEventStartTime, String nonRecurringEventEndTime, String eventLocation, Type eventType) {
        super(eventTitle, eventDescription, evenStartDate, eventEndDate, nonRecurringEventStartTime, nonRecurringEventEndTime);
        this.eventLocation = eventLocation;
        this.eventType = eventType;
    }

    public ArrayList<String> getAttendees() {
        return Attendees;
    }

    public void setAttendees(ArrayList<String> attendees) {
        Attendees = attendees;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public Type getEventType() {
        return eventType;
    }

    public void setEventType(Type eventType) {
        this.eventType = eventType;
    }


    public void addAttender(){}
    public void deleteAttender(){}
    public void editAttender(){}
    public void displayAttendees(){}
    public void completeEvent(){}
}
