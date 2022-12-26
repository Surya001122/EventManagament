package event;

import reminder.Alarm;
import reminder.Reminder;

import java.awt.*;
import java.util.Date;
import java.util.Scanner;

public abstract class RecurringEvent extends Event {

    Scanner sc = new Scanner(System.in);
    private final String RecurringEventStartTime = "00:00:00"; // start time of holiday or birthday starts at 00:00 on that day.
    private final String RecurringEventEndTime = "23:59:59"; // end time of holiday or birthday starts at 24:00 on that day.
    Reminder recurringNotifier;

    public String getRecurringEventStartTime() {
        return RecurringEventStartTime;
    }

    public String getRecurringEventEndTime() {
        return RecurringEventEndTime;
    }

    public Reminder getRecurringNotifier() {
        return recurringNotifier;
    }

    public void setRecurringNotifier(Reminder recurringNotifier) {
        this.recurringNotifier = recurringNotifier;
    }


    public RecurringEvent(String eventTitle, String eventDescription, String evenStartDate, String eventEndDate) {
        super(eventTitle, eventDescription, evenStartDate, eventEndDate);
    }

    @Override
    public void createReminder(Date date1, Date date2, long seconds){
        System.out.print("\nEnter 1 for holiday notifier\nEnter 2 for birthday notifier\nEnter your choice : ");
        int reminderChoice = 0;
        try{
            reminderChoice = Integer.parseInt(sc.nextLine().trim());
        }
        catch (NumberFormatException numberFormatException){
            System.out.print("\nEnter valid choice...\nNo reminder set...");
        }
        switch(reminderChoice){
            case 1:
                recurringNotifier = new Alarm();
                System.out.print("SECONDS -> "+seconds);
                recurringNotifier.displayMessageForHolidays(date1,date2,seconds);
                recurringNotifier.playRingtoneForHolidays(date1,date2,seconds);
                break;
            case 2:
                recurringNotifier = new Alarm();
                System.out.print("SECONDS -> "+seconds);
                recurringNotifier.displayMessageForBirthdays(date1,date2,seconds);
                recurringNotifier.playRingtoneForBirthdays(date1,date2,seconds);
                break;
            default:
                System.out.println("\nExit");
                break;
        }
    }
    @Override
    public void cancelReminder(){
        if(recurringNotifier!=null)
            recurringNotifier.cancelReminder();
    }
}
