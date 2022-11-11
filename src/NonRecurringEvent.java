public class NonRecurringEvent extends Event{
    private String eventStartTime;
    private String eventEndTime;
    Notify normalNotifier;
    private int delay;

    @Override
    public void createReminder(){}
}
