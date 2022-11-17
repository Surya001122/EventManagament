public interface Reminder {

    void displayMessageForEvent(long seconds);
    void playRingtoneForEvent(long seconds);
    void displayMessageForBirthdays(long seconds);
    void playRingtoneForBirthdays(long seconds);
    void displayMessageForHolidays(long seconds);
    void playRingtoneForHolidays(long seconds);
    void displayMessageForTask(long seconds);
    void playRingtoneForTask(long seconds);
    void cancelReminder();
}
