import java.util.Timer;
import java.util.TimerTask;

public class Alarm extends Notifier{
    Alarm(int seconds) {
        super(seconds);
    }
    Alarm(int second1,int second2){
        super(second1,second2);
    }
    @Override
    public void playRingtoneForEvent() {}
    @Override
    public void playRingtoneForBirthdays() {}
    @Override
    public void playRingtoneForHolidays(){}
    @Override
    public void playRingtoneForTask(){}

}