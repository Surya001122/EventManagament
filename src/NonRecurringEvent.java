public class NonRecurringEvent extends Event{
    private String nonRecurringEventStartTime; // start time varies according to the user.
    private String nonRecurringEventEndTime; // end time varies according to the user.
    Notify normalNotifier;
    private int delay;

    @Override
    public void createReminder(){}
}
