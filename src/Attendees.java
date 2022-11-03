public class Attendees {
    private String attenderName;
    private int attenderId;
    private Gender gender;
    private String attenderPassword;
    private String attenderWorkType;
    private String attenderLocation;
    private String attenderPhoneNumber;
    private Status attenderStatus;

    public Attendees(String attenderName, int attenderId, Gender gender, String attenderPassword, String attenderWorkType, String attenderLocation, String attenderPhoneNumber, Status attenderStatus) {
        this.attenderName = attenderName;
        this.attenderId = attenderId;
        this.gender = gender;
        this.attenderPassword = attenderPassword;
        this.attenderWorkType = attenderWorkType;
        this.attenderLocation = attenderLocation;
        this.attenderPhoneNumber = attenderPhoneNumber;
        this.attenderStatus = attenderStatus;
    }
}
