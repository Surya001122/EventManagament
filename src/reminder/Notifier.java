package reminder;

import reminder.Reminder;

import java.util.*;
import java.util.concurrent.TimeUnit;

public abstract class Notifier implements Reminder {

    Scanner sc = new Scanner(System.in);
    private Timer messageTimer;
    private String messageType;

    public Timer getMessageTimer() {
        return messageTimer;
    }

    public void setMessageTimer(Timer messageTimer) {
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
        private Date date1;
        private Date date2;

        public Date getDate1() {
            return date1;
        }

        public void setDate1(Date date1) {
            this.date1 = date1;
        }

        public Date getDate2() {
            return date2;
        }

        public void setDate2(Date date2) {
            this.date2 = date2;
        }

        RecurringReminder(Date date1,Date date2){
            this.date1 = date1;
            this.date2 = date2;
        }
        @Override
        public void run() {
            System.out.println("\nNew Message : "+messageType);
            messageTimer.cancel();
            long diffInMillies = Math.abs(date2.getTime() - date1.getTime());
            long seconds = TimeUnit.SECONDS.convert(diffInMillies, TimeUnit.MILLISECONDS);
            displayMessageForBirthdays(date1,date2,seconds);
        }
    }
    @Override
    public void displayMessageForEvent(Date date1, Date date2,long seconds) {
        messageType = "Hi Your event has started...";
        messageTimer = new Timer();
        messageTimer.schedule(new NonRecurringReminder(),seconds*1000L);
    }
    @Override
    public void displayMessageForBirthdays(Date date1, Date date2,long seconds) {
        messageType = "Hi,Someone has a birthday today...Wish them happy birthday";
        Calendar cal = Calendar.getInstance();
        cal.setTime(date2);
        int nextYear = cal.getWeekYear() + 1;
        date1 = cal.getTime();
        cal.set(Calendar.YEAR,nextYear);
        date2 = cal.getTime();
        messageTimer = new Timer();
        messageTimer.schedule(new RecurringReminder(date1,date2),seconds*1000L);
    }
    @Override
    public void displayMessageForHolidays(Date date1, Date date2,long seconds){
        messageType = "Hi,Enjoy your holiday";
        Calendar cal = Calendar.getInstance();
        cal.setTime(date2);
        int nextYear = cal.getWeekYear() + 1;
        date1 = cal.getTime();
        cal.set(Calendar.YEAR,nextYear);
        date2 = cal.getTime();
        messageTimer = new Timer();
        messageTimer.schedule(new RecurringReminder(date1,date2),seconds*1000L);

    }
    @Override
    public void displayMessageForTask(Date date1, Date date2,long seconds){
        messageType = "Hi Your task has started...";
        messageTimer = new Timer();
        messageTimer.schedule(new NonRecurringReminder(),seconds*1000L);
    }

}