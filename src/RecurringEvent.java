public class RecurringEvent {
    static int hId = 1,bId = 1;
    class HoliDays{
        private int holidayId;
        private String holidayTitle;
        private String holidayDescription;
        private Type holidayType;
        private String dateOfHoliday;
        private Notify holidayAlarm;
    }
    class BirthDays{
        private int birthDayId;
        private String friendName;
        private String friendPhoneNumber;
        private String dateOfBirth;
        private Gender gender;
        private String friendWorkType;
        private String friendLocation;
        private Notify birthDayAlarm;
    }
}
