public class Holiday extends RecurringEvent{
    private HolidayType holidayType;
    static String holidayTheme = "";

    public Holiday(String eventTitle, String eventDescription, String evenStartDate, String eventEndDate, HolidayType holidayType) {
        super(eventTitle, eventDescription, evenStartDate, eventEndDate);
        this.holidayType = holidayType;
    }

    public HolidayType getHolidayType() {
        return holidayType;
    }

    public void setHolidayType(HolidayType holidayType) {
        this.holidayType = holidayType;
    }
}
