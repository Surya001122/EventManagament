package reminder;

import java.util.Date;

public interface Reminder {

    void displayMessageForEvent(Date date1, Date date2, long seconds);
    void playRingtoneForEvent(Date date1, Date date2, long seconds);
    void displayMessageForBirthdays(Date date1, Date date2, long seconds);
    void playRingtoneForBirthdays(Date date1, Date date2, long seconds);
    void displayMessageForHolidays(Date date1, Date date2, long seconds);
    void playRingtoneForHolidays(Date date1, Date date2, long seconds);
    void displayMessageForTask(Date date1, Date date2, long seconds);
    void playRingtoneForTask(Date date1, Date date2, long seconds);
    void cancelReminder();
}
