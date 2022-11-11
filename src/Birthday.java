public class Birthday extends RecurringEvent{
    private String contactName;
    private String phoneNumber;
    private Gender gender;
    private String jobTitle;
    private String location;

    public Birthday(String eventTitle, String eventDescription, String evenStartDate, String eventEndDate, String contactName, String phoneNumber, Gender gender, String jobTitle, String location) {
        super(eventTitle, eventDescription, evenStartDate, eventEndDate);
        this.contactName = contactName;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.jobTitle = jobTitle;
        this.location = location;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
