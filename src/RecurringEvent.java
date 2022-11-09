public class RecurringEvent {
    static int hId = 1,bId = 1;
    class HoliDays{
        private int holidayId;
        private String holidayTitle;
        private String holidayDescription;
        private String dateOfHoliday;
    }
    class BirthDays{
        private int birthDayId;
        private String friendName;
        private String friendPhoneNumber;
        private String dateOfBirth;
        private Notify birthDayAlarm;
    }
}
