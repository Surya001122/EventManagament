public class NonRecurringEvent extends Event{
    private String nonRecurringEventStartTime; // start time varies according to the user.
    private String nonRecurringEventEndTime; // end time varies according to the user.
    Notify normalNotifier;
    private int delay;

    public NonRecurringEvent(String eventTitle, String eventDescription, String evenStartDate, String eventEndDate, String nonRecurringEventStartTime, String nonRecurringEventEndTime) {
        super(eventTitle, eventDescription, evenStartDate, eventEndDate);
        this.nonRecurringEventStartTime = nonRecurringEventStartTime;
        this.nonRecurringEventEndTime = nonRecurringEventEndTime;
    }

    public String getNonRecurringEventStartTime() {
        return nonRecurringEventStartTime;
    }

    public void setNonRecurringEventStartTime(String nonRecurringEventStartTime) {
        this.nonRecurringEventStartTime = nonRecurringEventStartTime;
    }

    public String getNonRecurringEventEndTime() {
        return nonRecurringEventEndTime;
    }

    public void setNonRecurringEventEndTime(String nonRecurringEventEndTime) {
        this.nonRecurringEventEndTime = nonRecurringEventEndTime;
    }

    public Notify getNormalNotifier() {
        return normalNotifier;
    }

    public void setNormalNotifier(Notify normalNotifier) {
        this.normalNotifier = normalNotifier;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    @Override
    public void createReminder(){}
}
