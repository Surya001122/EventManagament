public class RecurringEvent extends Event{
    private final String RecurringEventStartTime = ""; // start time of holiday or birthday starts at 00:00 on that day.
    private final String RecurringEventEndTime = ""; // end time of holiday or birthday starts at 24:00 on that day.
    Notify recurringNotifier;
    private int delay;
    private int period;

    public RecurringEvent() {
    }

    @Override
    public void createReminder(){}
}
