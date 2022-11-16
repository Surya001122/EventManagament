public interface Reminder {

    void displayMessageForEvent(long seconds);
    void playRingtoneForEvent(long seconds);
    void displayMessageForBirthdays();
    void playRingtoneForBirthdays();
    void displayMessageForHolidays();
    void playRingtoneForHolidays();
    void displayMessageForTask(long seconds);
    void playRingtoneForTask(long seconds);
    void cancelReminder();
}
