public interface Reminder {

    void displayMessageForEvent(long seconds);
    void playRingtoneForEvent();
    void displayMessageForBirthdays();
    void playRingtoneForBirthdays();
    void displayMessageForHolidays();
    void playRingtoneForHolidays();
    void displayMessageForTask(long seconds);
    void playRingtoneForTask();
    void cancelReminder();
}
