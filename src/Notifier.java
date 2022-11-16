import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public abstract class Notifier implements Reminder{

    Scanner sc = new Scanner(System.in);
    private Timer messageTimer;
    private String messageType;

    public Timer getTimer() {
        return messageTimer;
    }

    public void setTimer(Timer messageTimer) {
        this.messageTimer = messageTimer;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    private class NonRecurringReminder extends TimerTask{
        @Override
        public void run() {
            System.out.println("\nNew Message : "+messageType);
            messageTimer.cancel();
        }
    }
    private class RecurringReminder extends TimerTask{
        @Override
        public void run() {
            System.out.println("\nNew Message : "+messageType);
        }
    }
    @Override
    public void displayMessageForEvent(long seconds) {
        messageType = "Hi Your event has started...";
        messageTimer = new Timer();
        messageTimer.schedule(new NonRecurringReminder(),seconds*1000L);
    }
    @Override
    public void displayMessageForBirthdays() {}
    @Override
    public void displayMessageForHolidays(){}
    @Override
    public void displayMessageForTask(long seconds){
        messageType = "Hi Your task has started...";
        messageTimer = new Timer();
        messageTimer.schedule(new NonRecurringReminder(),seconds*1000L);
    }

    @Override
    public void cancelReminder(){
        if(messageTimer != null)
            messageTimer.cancel();
    }
}