package event;

import reminder.Alarm;
import reminder.Reminder;

import java.awt.*;
import java.util.Scanner;

public class NonRecurringEvent extends Event {

    Scanner sc = new Scanner(System.in);
    private String nonRecurringEventStartTime; // start time varies according to the user.
    private String nonRecurringEventEndTime; // end time varies according to the user.
    Reminder normalNotifier;

    public NonRecurringEvent(String eventTitle, String eventDescription, String evenStartDate, String eventEndDate, String nonRecurringEventStartTime, String nonRecurringEventEndTime) {
        super(eventTitle, eventDescription, evenStartDate, eventEndDate);
        this.nonRecurringEventStartTime = nonRecurringEventStartTime;
        this.nonRecurringEventEndTime = nonRecurringEventEndTime;
    }

    public String getNonRecurringEventStartTime() {
        return nonRecurringEventStartTime;
    }

    public void setNonRecurringEventStartTime(String nonRecurringEventStartTime) {
        this.nonRecurringEventStartTime = nonRecurringEventStartTime;
    }

    public String getNonRecurringEventEndTime() {
        return nonRecurringEventEndTime;
    }

    public void setNonRecurringEventEndTime(String nonRecurringEventEndTime) {
        this.nonRecurringEventEndTime = nonRecurringEventEndTime;
    }

    public Reminder getNormalReminder() {
        return normalNotifier;
    }

    public void setNormalReminder(Reminder normalNotifier) {
        this.normalNotifier = normalNotifier;
    }
    @Override
    public void createReminder(long seconds){
        System.out.print("\nEnter 1 for task notifier\nEnter 2 for event notifier\nEnter your choice : ");
        int reminderChoice = 0;
        try{
            reminderChoice = Integer.parseInt(sc.nextLine().trim());
        }
        catch (NumberFormatException numberFormatException){
            System.out.print("\nEnter valid choice...\nNo reminder set...");
        }
        switch(reminderChoice){
            case 1:
                normalNotifier = new Alarm();
                System.out.print("SECONDS -> "+seconds);
                normalNotifier.displayMessageForTask(seconds);
                normalNotifier.playRingtoneForTask(seconds);
                break;
            case 2:
                normalNotifier = new Alarm();
                System.out.print("SECONDS -> "+seconds);
                normalNotifier.displayMessageForEvent(seconds);
                normalNotifier.playRingtoneForEvent(seconds);
                break;
            default:
                System.out.println("\nExit");
                break;
        }
    }
    @Override
    public void cancelReminder(){
        if(normalNotifier!=null)
        normalNotifier.cancelReminder();
    }
}
