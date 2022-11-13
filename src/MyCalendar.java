import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.concurrent.TimeUnit;
import java.util.*;

public class MyCalendar {
    Scanner sc = new Scanner(System.in);
    private ArrayList<Task> myTasks;
    private ArrayList<SpecialEvent> myEvents;
    private ArrayList<Birthday> birthdays;
    private ArrayList<Holiday> holidays;
    private HashMap<String,String> myThemes;

    public MyCalendar() {
        this.myTasks = new ArrayList<>();
        this.myEvents = new ArrayList<>();
        this.birthdays = new ArrayList<>();
        this.holidays = new ArrayList<>();
    }

    public ArrayList<Task> getMyTasks() {
        return myTasks;
    }

    public void setMyTasks(ArrayList<Task> myTasks) {
        this.myTasks = myTasks;
    }

    public ArrayList<SpecialEvent> getMyEvents() {
        return myEvents;
    }

    public void setMyEvents(ArrayList<SpecialEvent> myEvents) {
        this.myEvents = myEvents;
    }

    public ArrayList<Birthday> getBirthDays() {
        return birthdays;
    }

    public void setBirthDays(ArrayList<Birthday> birthDays) {
        this.birthdays = birthDays;
    }

    public ArrayList<Holiday> getHolidays() {
        return holidays;
    }

    public void setHolidays(ArrayList<Holiday> holidays) {
        this.holidays = holidays;
    }

    public HashMap<String, String> getMyThemes() {
        return myThemes;
    }

    public void setMyThemes(HashMap<String, String> myThemes) {
        this.myThemes = myThemes;
    }

    public void viewMyCalendar(){} // default method to print that month in calendar
    public void viewMyCalendar(String Date){} // 1 day view of calendar events, calendar tasks, calendar holidays, calendar birthdays.
    public void viewMyCalendar(String fromDate,String toDate){} // weekly view or monthly view of calendar events, calendar tasks, calendar holidays, calendar birthdays.
    public void addSpecialEvents(){
        System.out.print("\nEnter the event title : ");
        String eventTitle = sc.nextLine().trim();
        System.out.print("\nEnter the event description : ");
        String eventDescription = sc.nextLine().trim();
        String eventStartDate = "";
        do{
            System.out.print("\nEnter valid event startDate (dd/mm/yyyy): ");
            eventStartDate = sc.nextLine().trim();
        }while(!validateDate(eventStartDate));
        String eventEndDate = "";
        do{
            System.out.print("\nEnter valid event endDate (dd/mm/yyyy): ");
            eventEndDate = sc.nextLine().trim();
        }while(!validateDate(eventEndDate));
        String eventStartTime = "";
        do{
            System.out.print("\nEnter valid event startTime : ");
            eventStartTime = sc.nextLine().trim();
        }while(!validateTime(eventStartTime));
        String eventEndTime = "";
        do{
            System.out.print("\nEnter valid event endTime: ");
            eventEndTime = sc.nextLine().trim();
        }while(!validateTime(eventEndTime));
        System.out.print("\nEnter the location of the event : ");
        String eventLocation = sc.nextLine().trim();
        System.out.print("\nEnter the type of the event : (ONLINE OR OFFLINE)");
        String eventType = sc.nextLine().trim();
        Type type;
        try{
            type = Type.valueOf(eventType);
        }
        catch (IllegalArgumentException illegalArgumentException){
            System.out.print("\nEnter valid type...Please try again");
            return;
        }
        SpecialEvent event = new SpecialEvent(eventTitle,eventDescription,eventStartDate,eventEndDate,eventStartTime,eventEndTime,eventLocation,type);
        myEvents.add(event);
        System.out.print("\nNew event added");
        System.out.print("\nEnter 1 to set the alarm\nEnter 2 to exit\nEnter your choice : ");
        int alarmChoice = Integer.parseInt(sc.nextLine().trim());
        switch(alarmChoice){
            case 1:
                event.createReminder(findTotalDayDifferenceInDates(eventStartDate,eventStartTime));
                break;
            case 2:
                System.out.print("\nAlarm not set for this event");
                break;
            default:
                System.out.print("\nEnter valid option..try again...");
                break;
        }
    }
    public void cancelSpecialEvents(){
        viewEvents();
        System.out.print("\nEnter the event id to cancel : ");
        int eventId;
        try{
            eventId = Integer.parseInt(sc.nextLine().trim());
        }
        catch(NumberFormatException numberFormatException){
            System.out.print("\nEnter the valid option and try again...");
            return;
        }
        SpecialEvent event = getSpecialEvent(eventId);
        if(event!=null) {
            myEvents.remove(event);
            System.out.print("\nEvent cancelled...");
        }
        else{
            System.out.print("\nNo events present with id : "+eventId);
        }
    }
    public void updateSpecialEvents(){
        System.out.print("\nEnter the event id to modify information : ");
        int eventId;
        try{
            eventId = Integer.parseInt(sc.nextLine().trim());
        }
        catch(NumberFormatException numberFormatException){
            System.out.print("\nEnter the valid option and try again...");
            return;
        }
        SpecialEvent event = getSpecialEvent(eventId);
        boolean updateBool = true;
        while(updateBool){
            viewEvents();
            System.out.print("\nEnter 1 to change the event title\nEnter 2 to change the event description\nEnter 3 to change the event start date\nEnter 4 to change the event end date\nEnter 5 to change the event start time\nEnter 6 to change the event end time\nEnter 7 to change the event location\nEnter 8 to change the event type (ONLINE or OFFLINE)\nEnter 9 to exit\nEnter your choice : ");
            int updateChoice;
            try{
                updateChoice = Integer.parseInt(sc.nextLine().trim());
            }
            catch (NumberFormatException numberFormatException){
                System.out.println("\nEnter valid information...Please try again");
                return;
            }
            switch(updateChoice){
                case 1:
                    System.out.print("Enter the new title : ");
                    String newEventTitle = sc.nextLine().trim();
                    if(event!=null){
                        event.setEventTitle(newEventTitle);
                        System.out.print("\nEvent title modified...");
                    }
                    else {
                        System.out.print("\nNo events present with id : " + eventId);
                    }
                    break;
                case 2:
                    System.out.print("Enter the new description: ");
                    String newEventDescription = sc.nextLine().trim();
                    if(event!=null){
                        event.setEventDescription(newEventDescription);
                        System.out.print("\nEvent description modified...");

                    }
                    else {
                        System.out.print("\nNo events present with id : " + eventId);
                    }
                    break;
                case 3:
                    System.out.print("Enter the new start date: ");
                    String newEventStartDate = "";
                    do{
                        System.out.print("\nEnter valid event startDate (dd/mm/yyyy): ");
                        newEventStartDate = sc.nextLine().trim();
                    }while(!validateDate(newEventStartDate));
                    if(event!=null){
                        event.setEventStartDate(newEventStartDate);
                        System.out.print("\nNew Event start date modified...");

                    }
                    else {
                        System.out.print("\nNo events present with id : " + eventId);
                    }
                    break;
                case 4:
                    System.out.print("Enter the new end date: ");
                    String newEventEndDate = "";
                    do{
                        System.out.print("\nEnter valid event endDate (dd/mm/yyyy): ");
                        newEventEndDate = sc.nextLine().trim();
                    }while(!validateDate(newEventEndDate));
                    if(event!=null){
                        event.setEventEndDate(newEventEndDate);
                        System.out.print("\nNew Event end date modified...");

                    }
                    else {
                        System.out.print("\nNo events present with id : " + eventId);
                    }
                    break;
                case 5:
                    System.out.print("Enter the new start time: ");
                    String newEventStartTime = "";
                    do{
                        System.out.print("\nEnter valid event startTime : ");
                        newEventStartTime = sc.nextLine().trim();
                    }while(!validateTime(newEventStartTime));
                    if(event!=null){
                        event.setNonRecurringEventStartTime(newEventStartTime);
                        System.out.print("\nNew Event start time modified...");

                    }
                    else {
                        System.out.print("\nNo events present with id : " + eventId);
                    }
                    break;
                case 6:
                    System.out.print("Enter the new end time: ");
                    String newEventEndTime = "";
                    do{
                        System.out.print("\nEnter valid event endTime : ");
                        newEventEndTime = sc.nextLine().trim();
                    }while(!validateTime(newEventEndTime));
                    if(event!=null){
                        event.setNonRecurringEventEndTime(newEventEndTime);
                        System.out.print("\nNew Event end time modified...");

                    }
                    else {
                        System.out.print("\nNo events present with id : " + eventId);
                    }
                    break;
                case 7:
                    System.out.print("Enter the new location: ");
                    String newEventLocation = sc.nextLine().trim();
                    if(event!=null){
                        event.setEventLocation(newEventLocation);
                        System.out.print("\nNew Event Location modified...");
                    }
                    else {
                        System.out.print("\nNo events present with id : " + eventId);
                    }
                    break;
                case 8:
                    System.out.print("Enter the new type: ");
                    String newEventType = sc.nextLine().trim();
                    Type newType;
                    try{
                        newType = Type.valueOf(newEventType);
                    }
                    catch (IllegalArgumentException illegalArgumentException){
                        System.out.print("\nEnter valid type...Please try again");
                        return;
                    }
                    if (event != null) {
                        event.setEventType(newType);
                        System.out.print("\nEvent type modified...");

                    }
                    else {
                        System.out.print("\nNo events present with id : " + eventId);
                    }
                    break;
                case 9:
                    updateBool = false;
                    break;
                default:
                    updateBool = false;
                    System.out.println("\nEnter valid choice...");
                    break;
            }
        }
    }
    public void addTasks(){
        System.out.print("\nEnter the task title : ");
        String taskTitle = sc.nextLine().trim();
        System.out.print("\nEnter the task description : ");
        String taskDescription = sc.nextLine().trim();
        String taskDate = "";
        do{
            System.out.print("\nEnter valid task Date (dd/mm/yyyy): ");
            taskDate = sc.nextLine().trim();
        }while(!validateDate(taskDate));
        String taskStartTime = "";
        do{
            System.out.print("\nEnter valid task startTime : ");
            taskStartTime = sc.nextLine().trim();
        }while(!validateTime(taskStartTime));
        String taskEndTime= "";
        do{
            System.out.print("\nEnter valid task endTime: ");
            taskEndTime = sc.nextLine().trim();
        }while(!validateTime(taskEndTime));
        Task task = new Task(taskTitle,taskDescription,taskDate,taskDate,taskStartTime,taskEndTime);
        myTasks.add(task);
        System.out.print("\nNew task added");
    }
    public void deleteTasks(){
        viewTasks();
        System.out.print("\nEnter the task id to cancel : ");
        int taskId;
        try{
            taskId = Integer.parseInt(sc.nextLine().trim());
        }
        catch(NumberFormatException numberFormatException){
            System.out.print("\nEnter the valid option and try again...");
            return;
        }
        Task task = getTask(taskId);
        if(task!=null) {
            myTasks.remove(task);
            System.out.print("\ntask cancelled...");
        }
        else{
            System.out.print("\nNo task present with id : "+taskId);
        }
    }
    public void updateTasks(){
        viewTasks();
        System.out.print("\nEnter the task id to modify information : ");
        int taskId;
        try{
            taskId = Integer.parseInt(sc.nextLine().trim());
        }
        catch(NumberFormatException numberFormatException){
            System.out.print("\nEnter the valid option and try again...");
            return;
        }
        Task task = getTask(taskId);
        boolean updateBool = true;
        while(updateBool){
            viewTasks();
            System.out.print("\nEnter 1 to change the task title\nEnter 2 to change the task description\nEnter 3 to change the task date\nEnter 4 to change the task start time\nEnter 5 to change the task end time\nEnter 6 to exit\nEnter your choice : ");
            int updateChoice;
            try{
                updateChoice = Integer.parseInt(sc.nextLine().trim());
            }
            catch (NumberFormatException numberFormatException){
                System.out.println("\nEnter valid information...Please try again");
                return;
            }
            switch(updateChoice){
                case 1:
                    System.out.print("Enter the new title : ");
                    String newTaskTitle = sc.nextLine().trim();
                    if(task!=null){
                        task.setEventTitle(newTaskTitle);
                        System.out.print("\ntask title modified...");

                    }
                    else {
                        System.out.print("\nNo tasks present with id : " + taskId);
                    }
                    break;
                case 2:
                    System.out.print("Enter the new description: ");
                    String newTaskDescription = sc.nextLine().trim();
                    if(task!=null){
                        task.setEventDescription(newTaskDescription);
                        System.out.print("\ntask description modified...");

                    }
                    else {
                        System.out.print("\nNo tasks present with id : " + taskId);
                    }
                    break;
                case 3:
                    System.out.print("Enter the new task date: ");
                    String newTaskDate = "";
                    do{
                        System.out.print("\nEnter valid task startDate (dd/mm/yyyy): ");
                        newTaskDate = sc.nextLine().trim();
                    }while(!validateDate(newTaskDate));
                    if(task!=null){
                        task.setEventStartDate(newTaskDate);
                        task.setEventEndDate(newTaskDate);
                        System.out.print("\nNew task date modified...");

                    }
                    else {
                        System.out.print("\nNo task present with id : " + taskId);
                    }
                    break;
                case 4:
                    System.out.print("Enter the new start time: ");
                    String newTaskStartTime = "";
                    do{
                        System.out.print("\nEnter valid task startTime : ");
                        newTaskStartTime = sc.nextLine().trim();
                    }while(!validateTime(newTaskStartTime));
                    if(task!=null){
                        task.setNonRecurringEventStartTime(newTaskStartTime);
                        System.out.print("\nNew task start time modified...");

                    }
                    else {
                        System.out.print("\nNo task present with id : " + taskId);
                    }
                    break;
                case 5:
                    System.out.print("Enter the new end time: ");
                    String newTaskEndTime = "";
                    do{
                        System.out.print("\nEnter valid event endTime : ");
                        newTaskEndTime = sc.nextLine().trim();
                    }while(!validateTime(newTaskEndTime));
                    if(task!=null){
                        task.setNonRecurringEventEndTime(newTaskEndTime);
                        System.out.print("\nNew task end time modified...");
                    }
                    else {
                        System.out.print("\nNo tasks present with id : " + taskId);
                    }
                    break;
                case 6:
                    updateBool = false;
                    break;
                default:
                    updateBool = false;
                    System.out.println("\nEnter valid choice...");
                    break;
            }
        }
    }
    public void addBirthdays() {
        System.out.print("\nEnter the contact name : ");
        String contactName = sc.nextLine().trim();
        System.out.print("\nEnter the birthday event title : ");
        String birthdayTitle = sc.nextLine().trim();
        System.out.print("\nEnter the birthday event description : ");
        String birthdayDescription = sc.nextLine().trim();
        String dateOfBirth = "";
        do{
            System.out.print("\nEnter valid dateOfBirth (dd/mm/yyyy): ");
            dateOfBirth = sc.nextLine().trim();
        }while(!validateDate(dateOfBirth));
        String phoneNumber;
        do {
            System.out.print("\nEnter your mobileNumber : ");
            phoneNumber = sc.nextLine().trim();
        } while (!Registration.validatePhoneNumber(phoneNumber));
        Gender gender;
        String genderType;
        try {
            System.out.print("\nEnter your gender (MALE,FEMALE,OTHERS): ");
            genderType = sc.nextLine().trim();
            gender = Gender.valueOf(genderType);
        }
        catch (IllegalArgumentException illegalArgumentException){
            System.out.print("\nEnter valid option..please try again");
            return;
        }
        System.out.print("\nEnter the job title : ");
        String jobTitle = sc.nextLine().trim();
        System.out.print("\nEnter the location : ");
        String location = sc.nextLine().trim();
        Birthday birthday = new Birthday(birthdayTitle,birthdayDescription,dateOfBirth,dateOfBirth,contactName,phoneNumber,gender,jobTitle,location);
        birthdays.add(birthday);
        System.out.print("\nNew birthday added");
    }
    public void removeBirthdays() {
        viewBirthdays();
        System.out.print("\nEnter the birthday id to cancel : ");
        int birthdayId;
        try{
            birthdayId = Integer.parseInt(sc.nextLine().trim());
        }
        catch(NumberFormatException numberFormatException){
            System.out.print("\nEnter the valid option and try again...");
            return;
        }
        Birthday birthday = getBirthday(birthdayId);
        if(birthday!=null) {
            birthdays.remove(birthday);
            System.out.print("\nbirthday removed...");
        }
        else{
            System.out.print("\nNo birthday present with id : "+birthdayId);
        }
    }
    public void modifyBirthdays() {
        viewBirthdays();
        System.out.print("\nEnter the birthday id to modify information : ");
        int birthdayId;
        try{
            birthdayId = Integer.parseInt(sc.nextLine().trim());
        }
        catch(NumberFormatException numberFormatException){
            System.out.print("\nEnter the valid option and try again...");
            return;
        }
        Birthday birthday = getBirthday(birthdayId);
        boolean updateBool = true;
        while(updateBool){
            viewBirthdays();
            System.out.print("\nEnter 1 to change the birthday title\nEnter 2 to change the birthday description\nEnter 3 to change the DOB\nEnter 4 to change the contact name\nEnter 5 to change the mobile number\nEnter 6 to change the gender\nEnter 7 to change the job title\nEnter 8 to change the location\nEnter 9 to exit\nEnter your choice : ");
            int updateChoice;
            try{
                updateChoice = Integer.parseInt(sc.nextLine().trim());
            }
            catch (NumberFormatException numberFormatException){
                System.out.println("\nEnter valid information...Please try again");
                return;
            }
            switch(updateChoice){
                case 1:
                    System.out.print("Enter the new title : ");
                    String newBirthdayTitle = sc.nextLine().trim();
                    if(birthday!=null){
                        birthday.setEventTitle(newBirthdayTitle);
                        System.out.print("\nBirthday title modified...");

                    }
                    else {
                        System.out.print("\nNo birthday present with id : " + birthdayId);
                    }
                    break;
                case 2:
                    System.out.print("Enter the new description: ");
                    String newBirthdayDescription = sc.nextLine().trim();
                    if(birthday!=null){
                        birthday.setEventDescription(newBirthdayDescription);
                        System.out.print("\nBirthday description modified...");

                    }
                    else {
                        System.out.print("\nNo Birthday present with id : " + birthdayId);
                    }
                    break;
                case 3:
                    System.out.print("Enter the new DOB: ");
                    String dob = "";
                    do{
                        System.out.print("\nEnter valid DOB (dd/mm/yyyy): ");
                        dob = sc.nextLine().trim();
                    }while(!validateDate(dob));
                    if(birthday!=null){
                        birthday.setEventStartDate(dob);
                        birthday.setEventEndDate(dob);
                        System.out.print("\nNew dob modified...");

                    }
                    else {
                        System.out.print("\nNo Birthday present with id : " + birthdayId);
                    }
                    break;
                case 4:
                    System.out.print("Enter the new name: ");
                    String contactName = sc.nextLine().trim();
                    if(birthday!=null){
                        birthday.setContactName(contactName);
                        System.out.print("\nNew name modified...");

                    }
                    else {
                        System.out.print("\nNo Birthday present with id : " + birthdayId);
                    }
                    break;
                case 5:
                    String phoneNumber;
                    do {
                        System.out.print("\nEnter your mobileNumber : ");
                        phoneNumber = sc.nextLine().trim();
                    } while (!Registration.validatePhoneNumber(phoneNumber));
                    if(birthday!=null){
                        birthday.setPhoneNumber(phoneNumber);
                        System.out.print("\nphoneNumber modified...");

                    }
                    else {
                        System.out.print("\nNo Birthday present with id : " + birthdayId);
                    }
                    break;
                case 6:
                    Gender gender;
                    String genderType;
                    try {
                        System.out.print("\nEnter your gender (MALE,FEMALE,OTHERS): ");
                        genderType = sc.nextLine().trim();
                        gender = Gender.valueOf(genderType);
                    }
                    catch (IllegalArgumentException illegalArgumentException){
                        System.out.print("\nEnter valid option..please try again");
                        return;
                    }
                    if(birthday!=null){
                        birthday.setGender(gender);
                        System.out.print("\ngender modified...");

                    }
                    else {
                        System.out.print("\nNo Birthday present with id : " + birthdayId);
                    }
                case 7:
                    System.out.print("\nEnter the new job title : ");
                    String jobType = sc.nextLine().trim();
                    if(birthday!=null){
                        birthday.setJobTitle(jobType);
                        System.out.print("\njob type modified...");

                    }
                    else {
                        System.out.print("\nNo Birthday present with id : " + birthdayId);
                    }
                    break;
                case 8:
                    System.out.print("\nEnter the new location : ");
                    String newLocation = sc.nextLine().trim();
                    if(birthday!=null){
                        birthday.setLocation(newLocation);
                        System.out.print("\nLocation modified...");

                    }
                    else {
                        System.out.print("\nNo Birthday present with id : " + birthdayId);
                    }
                    break;
                case 9:
                    System.out.print("\nExit");
                    updateBool = false;
                    break;
                default:
                    updateBool = false;
                    System.out.println("\nEnter valid choice...");
                    break;
            }
        }
    }
    public void addHolidays(){}
    public void removeHolidays(){}
    public void viewTasks(){
        System.out.println("\nEnter 1 to view all tasks\nEnter 2 to view certain tasks \nEnter your choice : ");
        int viewChoice;
        try{
            viewChoice = Integer.parseInt(sc.nextLine().trim());
        }
        catch(NumberFormatException numberFormatException){
            System.out.print("\nEnter the valid option..please try again...");
            return;
        }
        switch(viewChoice){
            case 1:
                for(Task task : myTasks){
                    System.out.println("\nTask ID : "+task.getEventId()+"   Task title : "+task.getEventTitle()+"    Task description : "+task.getEventDescription()+"   Task start date : "+task.getEventStartDate()+"   Task end date : "+task.getEventEndDate()+"   Task start time : "+task.getNonRecurringEventStartTime()+"   Task end time : "+task.getNonRecurringEventEndTime());
                }
                break;
            case 2:
                String taskDate = "";
                do{
                    System.out.print("\nEnter valid task Date (dd/mm/yyyy): ");
                    taskDate = sc.nextLine().trim();
                }while(!validateDate(taskDate));
                String taskStartTime = "";
                do{
                    System.out.print("\nEnter valid task startTime : ");
                    taskStartTime = sc.nextLine().trim();
                }while(!validateTime(taskStartTime));
                String taskEndTime = "";
                do{
                    System.out.print("\nEnter valid event endTime: ");
                    taskEndTime = sc.nextLine().trim();
                }while(!validateTime(taskEndTime));
                for(Task task : myTasks){
                    if(task.getEventStartDate().equals(taskDate) && task.getEventEndDate().equals(taskDate) && task.getNonRecurringEventStartTime().equals(taskStartTime) && task.getNonRecurringEventEndTime().equals(taskEndTime))
                    {
                        System.out.println("\nTask ID : "+task.getEventId()+"   Task title : "+task.getEventTitle()+"    Task description : "+task.getEventDescription()+"   Task start date : "+task.getEventStartDate()+"   Task end date : "+task.getEventEndDate()+"   Task start time : "+task.getNonRecurringEventStartTime()+"   Task end time : "+task.getNonRecurringEventEndTime());
                    }
                }
                break;
            case 3:
                System.out.print("\nExit");
                break;
            default:
                System.out.print("\nEnter valid option..try again...");
                break;
        }
    }
    public void viewEvents(){
        System.out.println("\nEnter 1 to view all events\nEnter 2 to view certain events \nEnter your choice : ");
        int viewChoice;
        try{
            viewChoice = Integer.parseInt(sc.nextLine().trim());
        }
        catch(NumberFormatException numberFormatException){
            System.out.print("\nEnter the valid option..please try again...");
            return;
        }
        switch(viewChoice){
            case 1:
                for(SpecialEvent event : myEvents){
                    System.out.println("\nEvent ID : "+event.getEventId()+"   Event title : "+event.getEventTitle()+"    Event description : "+event.getEventDescription()+"   Event start date : "+event.getEventStartDate()+"   Event end date : "+event.getEventEndDate()+"   Event start time : "+event.getNonRecurringEventStartTime()+"   Event end time : "+event.getNonRecurringEventEndTime()+"   Event location & type : ("+event.getEventType()+") "+event.getEventLocation());
                }
                break;
            case 2:
                String eventStartDate = "";
                do{
                    System.out.print("\nEnter valid event startDate (dd/mm/yyyy): ");
                    eventStartDate = sc.nextLine().trim();
                }while(!validateDate(eventStartDate));
                String eventEndDate = "";
                do{
                    System.out.print("\nEnter valid event endDate (dd/mm/yyyy): ");
                    eventEndDate = sc.nextLine().trim();
                }while(!validateDate(eventEndDate));
                String eventStartTime = "";
                do{
                    System.out.print("\nEnter valid event startTime : ");
                    eventStartTime = sc.nextLine().trim();
                }while(!validateTime(eventStartTime));
                String eventEndTime = "";
                do{
                    System.out.print("\nEnter valid event endTime: ");
                    eventEndTime = sc.nextLine().trim();
                }while(!validateTime(eventEndTime));
                for(SpecialEvent event : myEvents){
                    if(event.getEventStartDate().equals(eventStartDate) && event.getEventEndDate().equals(eventEndDate) && event.getNonRecurringEventStartTime().equals(eventStartTime) && event.getNonRecurringEventEndTime().equals(eventEndTime))
                    {
                        System.out.println("\nEvent ID : "+event.getEventId()+"   Event title : "+event.getEventTitle()+"    Event description : "+event.getEventDescription()+"   Event start date : "+event.getEventStartDate()+"   Event end date : "+event.getEventEndDate()+"   Event start time : "+event.getNonRecurringEventStartTime()+"   Event end time : "+event.getNonRecurringEventEndTime()+"   Event location & type : ("+event.getEventType()+") "+event.getEventLocation());
                    }
                }
                break;
            case 3:
                System.out.print("\nExit");
                break;
            default:
                System.out.print("\nEnter valid option..try again...");
                break;
        }
    }
    public void viewBirthdays(){
        System.out.println("\nEnter 1 to view all birthdays\nEnter 2 to view certain birthdays \nEnter your choice : ");
        int viewChoice;
        try{
            viewChoice = Integer.parseInt(sc.nextLine().trim());
        }
        catch(NumberFormatException numberFormatException){
            System.out.print("\nEnter the valid option..please try again...");
            return;
        }
        switch(viewChoice){
            case 1:
                for(Birthday birthday : birthdays){
                    System.out.println("\nBirthday ID : "+birthday.getEventId()+"   Birthday title : "+birthday.getEventTitle()+"    Birthday description : "+birthday.getEventDescription()+"   DOB : "+birthday.getEventStartDate()+"    Name : "+birthday.getContactName()+"    MobileNumber : "+birthday.getPhoneNumber()+"   Gender : "+birthday.getGender()+"   Job : "+birthday.getJobTitle()+"    Location : "+birthday.getLocation());
                }
                break;
            case 2:
                String DateOfBirth = "";
                do{
                    System.out.print("\nEnter valid DOB (dd/mm/yyyy): ");
                    DateOfBirth = sc.nextLine().trim();
                }while(!validateDate(DateOfBirth));
                for(Birthday birthday : birthdays){
                    if(birthday.getEventStartDate().equals(DateOfBirth))
                    {
                        System.out.println("\nBirthday ID : "+birthday.getEventId()+"   Birthday title : "+birthday.getEventTitle()+"    Birthday description : "+birthday.getEventDescription()+"   DOB : "+birthday.getEventStartDate()+"    Name : "+birthday.getContactName()+"    MobileNumber : "+birthday.getPhoneNumber()+"   Gender : "+birthday.getGender()+"   Job : "+birthday.getJobTitle()+"    Location : "+birthday.getLocation());
                    }                }
                break;
            case 3:
                System.out.print("\nExit");
                break;
            default:
                System.out.print("\nEnter valid option..try again...");
                break;
        }
    }
    public void viewHolidays(){

    }
    public SpecialEvent getSpecialEvent(int eventId){
        for(SpecialEvent event : myEvents){
            if(event.getEventId() == eventId)
                return event;
        }
        return null;
    }
    public Task  getTask(int taskId){
        for(Task task : myTasks){
            if(task.getEventId() == taskId)
                return task;
        }
        return null;
    }
    public Holiday getHoliday(int holidayId){
        for(Holiday holiday : holidays){
            if(holiday.getEventId() == holidayId)
                return holiday;
        }
        return null;
    }
    public Birthday getBirthday(int birthdayId){
        for(Birthday birthday : birthdays){
            if(birthday.getEventId() == birthdayId)
                return birthday;
        }
        return null;
    }
    public long findTotalDayDifferenceInDates(String date,String time){
        System.out.println("Enter today's date and time as (dd/MM/yyyy HH:mm:ss) : ");
        String date1 = sc.nextLine().trim();
        String date2 = date+" "+time;
        Date d1 = null, d2 = null;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        try{
            d1 = format.parse(date1);
            d2 = format.parse(date2);
        }
        catch(ParseException e){
            e.printStackTrace();
        }
        long diffInMillies = Math.abs(d2.getTime() - d1.getTime());
        long totalSeconds = TimeUnit.SECONDS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        return totalSeconds;
    }
    public boolean validateDate(String date){
        SimpleDateFormat vDate = new SimpleDateFormat("dd/MM/yyyy");
        vDate.setLenient(false);
        try
        {
            Date newDate = vDate.parse(date);
            System.out.println(date+" is valid date format");
        }
        catch (ParseException e)
        {
            System.out.println(date+" is Invalid Date format");
            return false;
        }
        return true;
    }
    public boolean validateTime(String Time){
        return true;
    }
    public void viewAvailableThemes(){}
    public void setThemes(){}

}
