import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Notifier implements Notify{
    Scanner sc = new Scanner(System.in);
    Timer timer;
    String messageType;
    Notifier(long seconds)
    {
        System.out.print("\n"+seconds+"*********");
        timer = new Timer();
        timer.schedule(new Reminder(),seconds*1000L);
    }
    Notifier(long second1,long second2){
        timer = new Timer();
        timer.schedule(new RecurringReminder(),second1*2000L,second2*1000L);
    }
    private class Reminder extends TimerTask{
        @Override
        public void run() {
            displayMessageForTask();
            displayMessageForEvent();
            timer.cancel();
        }
    }
    private class RecurringReminder extends TimerTask{
        @Override
        public void run() {}
    }
    @Override
    public void displayMessageForEvent() {
        System.out.print("\nYour event has started");
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
    public void displayMessageForTask(){
        System.out.print("\nYour task has started");

    }
    @Override
    public void playRingtoneForTask(){}
}