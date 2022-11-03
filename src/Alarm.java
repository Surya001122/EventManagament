import java.util.Timer;
import java.util.TimerTask;

public class Alarm implements Notify{
    Timer timer;
    Reminder reminder;
    Alarm(int seconds)
    {
        reminder = new Reminder();
        timer = new Timer();
        reminder.setSeconds(seconds);
        timer.schedule(new Reminder(),10000);
    }
    public class Reminder extends TimerTask{
        private int seconds;

        public int getSeconds() {
            return seconds;
        }

        public void setSeconds(int seconds) {
            this.seconds = seconds;
        }

        @Override
        public void run() {
            displayMessage();
        }

    }
    @Override
    public void makeSound() {

    }

    @Override
    public void displayMessage() {
        System.out.println("THANK YOU...");
    }
}
