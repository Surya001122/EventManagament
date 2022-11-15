import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Notifier implements Notify{
    Scanner sc = new Scanner(System.in);
    Timer timer;
    String messageType;
    private class Reminder extends TimerTask{
        @Override
        public void run() {
            System.out.print(messageType);
            timer.cancel();
        }
    }
    private class RecurringReminder extends TimerTask{
        @Override
        public void run() {}
    }
    @Override
    public void displayMessageForEvent(long seconds) {
        System.out.print("\n"+seconds+"*********");
        messageType = "Hi Your event has started...";
        timer = new Timer();
        timer.schedule(new Reminder(),seconds*1000L);
    }
    @Override
    public void playRingtoneForEvent() {}
    @Override
    public void displayMessageForBirthdays() {}
    @Override
    public void playRingtoneForBirthdays() {}
    @Override
    public void displayMessageForHolidays(){}
    @Override
    public void playRingtoneForHolidays(){}
    @Override
    public void displayMessageForTask(long seconds){
        System.out.print("\n"+seconds+"*********");
        messageType = "Hi Your task has started...";
        timer = new Timer();
        timer.schedule(new Reminder(),seconds*1000L);
    }
    @Override
    public void playRingtoneForTask(){}
}