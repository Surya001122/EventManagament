import java.util.Timer;
import java.util.TimerTask;

public class Notifier implements Notify{
    Timer timer;
    Notifier(int seconds)
    {
        timer = new Timer();
        timer.schedule(new Reminder(),seconds* 1000L);
    }
    private class Reminder extends TimerTask{
        @Override
        public void run() {
            displayMessageForEvent();
            playRingtoneForEvent();
            timer.cancel();
        }

    }
    @Override
    public void displayMessageForEvent() {
        System.out.println("\nYour event started");
    }


    @Override
    public void playRingtoneForEvent() {

    }

}