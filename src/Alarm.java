import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Alarm extends Notifier{
    private Timer soundTimer;
    private int alarmCount = 0;

    public Timer getSoundTimer() {
        return soundTimer;
    }

    public void setSoundTimer(Timer soundTimer) {
        this.soundTimer = soundTimer;
    }

    public int getAlarmCount() {
        return alarmCount;
    }

    public void setAlarmCount(int alarmCount) {
        this.alarmCount = alarmCount;
    }

    private class NonRecurringSoundReminder extends TimerTask{
        @Override
        public void run() {
            Toolkit.getDefaultToolkit().beep();
            alarmCount++;
            if(alarmCount == 20) {
                soundTimer.cancel();
            }
        }
    }
    private class RecurringSoundReminder extends TimerTask{
        @Override
        public void run() {
            Toolkit.getDefaultToolkit().beep();
            alarmCount++;
            if(alarmCount == 20) {
                soundTimer.cancel();
            }
        }
    }
    @Override
    public void playRingtoneForEvent(long seconds) {
        soundTimer = new Timer();
        soundTimer.scheduleAtFixedRate(new NonRecurringSoundReminder(),seconds*1000L,1000L);
    }
    @Override
    public void playRingtoneForBirthdays(long seconds) {
        soundTimer = new Timer();
        soundTimer.scheduleAtFixedRate(new NonRecurringSoundReminder(),seconds*1000L,1000L);
    }
    @Override
    public void playRingtoneForHolidays(long seconds){
        soundTimer = new Timer();
        soundTimer.scheduleAtFixedRate(new NonRecurringSoundReminder(),seconds*1000L,1000L);
    }
    @Override
    public void playRingtoneForTask(long seconds){
        soundTimer = new Timer();
        soundTimer.scheduleAtFixedRate(new NonRecurringSoundReminder(),seconds*1000L,1000L);
    }
    @Override
    public void cancelReminder(){
        if(soundTimer != null) {
            soundTimer.cancel();
            getMessageTimer().cancel();
        }
    }

}