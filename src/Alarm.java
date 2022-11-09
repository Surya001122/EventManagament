import java.util.Timer;
import java.util.TimerTask;

public class Alarm extends Notifier{
    public Alarm(int seconds) {
        super(seconds);
    }
    @Override
    public void playRingtoneForEvent() {}
    @Override
    public void playRingtoneForBirthDays() {}
    @Override
    public void playRingtoneForHolidays(){}

}