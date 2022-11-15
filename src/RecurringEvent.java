public class RecurringEvent extends Event{
    private final String RecurringEventStartTime = "00:00:00"; // start time of holiday or birthday starts at 00:00 on that day.
    private final String RecurringEventEndTime = "24:00:00"; // end time of holiday or birthday starts at 24:00 on that day.
    Reminder recurringNotifier;
    private int delay;
    private int period;

    public String getRecurringEventStartTime() {
        return RecurringEventStartTime;
    }

    public String getRecurringEventEndTime() {
        return RecurringEventEndTime;
    }

    public Reminder getRecurringNotifier() {
        return recurringNotifier;
    }

    public void setRecurringNotifier(Reminder recurringNotifier) {
        this.recurringNotifier = recurringNotifier;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public RecurringEvent(String eventTitle, String eventDescription, String evenStartDate, String eventEndDate) {
        super(eventTitle, eventDescription, evenStartDate, eventEndDate);
    }

    @Override
    public void createReminder(long seconds){}
    @Override
    public void cancelReminder(){}
}
