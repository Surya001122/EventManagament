import java.util.Timer;
import java.util.TimerTask;

public class Alarm implements Notify{
    Timer timer;
    Alarm(int seconds)
    {
        timer = new Timer();
        timer.schedule(new Reminder(),seconds* 1000L);
    }
    public class Reminder extends TimerTask{
        @Override
        public void run() {
            displayMessage();
            timer.cancel();
        }

    }
    @Override
    public void displayMessage() {}
}
