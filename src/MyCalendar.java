import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
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
        myThemes = new HashMap<>();
        Admin.addThemes(myThemes);
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

    public void viewMyCalendar(){
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH); // 10
        GregorianCalendar calendar = new GregorianCalendar(year,month, 1);
        int startingDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK); // S M T W T F S 1 2 3 4 5 6 7
        int totalDaysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH); // 28,29,30,31
        System.out.println(new SimpleDateFormat("MMMM YYYY").format(calendar.getTime()));
        System.out.println(" S  M  T  W  T  F  S");
        for (int i = 0; i < startingDayOfWeek - 1; i++) {
            System.out.print("   ");
        }
        for (int i = 0, day = 1; day <= totalDaysInMonth; i++)  {
            for (int j = ((i == 0) ? startingDayOfWeek - 1 : 0); j < 7 && (day <= totalDaysInMonth); j++) {
                System.out.printf("%2d ", day);
                day++;
            }
            System.out.println();
        }
        System.out.print("\nEnter 1 to view Events\nEnter 2 to view tasks\nEnter 3 to view birthdays\nEnter 4 to view holidays\nEnter 5 to view all events\nEnter 6 to exit\nEnter your choice : ");
        int viewChoice;
        try{
            viewChoice = Integer.parseInt(sc.nextLine().trim());
        }
        catch (NumberFormatException numberFormatException){
            System.out.print("\nEnter valid choice..try again...");
            return;
        }
        switch(viewChoice){
            case 1:
                for (int i = 0, day = 1; day <= totalDaysInMonth; i++)  {
                    for (int j = ((i == 0) ? startingDayOfWeek - 1 : 0); j < 7 && (day <= totalDaysInMonth); j++) {
                        boolean star = false;
                        for(SpecialEvent event : myEvents){
                            if(isEqual(day,month,year, event.getEventStartDate())){
                                displayEvent(event);
                                star = true;
                            }
                        }
                        if(star) {
                            star = false;
                            System.out.println("\n***************************************************************************");
                        }
                        day++;
                    }
                }
                break;
            case 2:
                for (int i = 0, day = 1; day <= totalDaysInMonth; i++)  {
                    for (int j = ((i == 0) ? startingDayOfWeek - 1 : 0); j < 7 && (day <= totalDaysInMonth); j++) {
                        boolean star = false;
                        for(Task task : myTasks){
                            if(isEqual(day,month,year, task.getEventStartDate())){
                                displayTask(task);
                                star = true;
                            }
                        }
                        if(star) {
                            star = false;
                            System.out.println("\n***************************************************************************");
                        }
                        day++;
                    }
                }
                break;
            case 3:
                for (int i = 0, day = 1; day <= totalDaysInMonth; i++)  {
                    for (int j = ((i == 0) ? startingDayOfWeek - 1 : 0); j < 7 && (day <= totalDaysInMonth); j++) {
                        boolean star = false;
                        for(Birthday birthday : birthdays){
                            if(isEqual(day,month,year, birthday.getEventStartDate())){
                                displayBirthday(birthday);
                                star = true;
                            }
                        }
                        if(star) {
                            star = false;
                            System.out.println("\n***************************************************************************");
                        }
                        day++;
                    }
                }
                break;
            case 4:
                for (int i = 0, day = 1; day <= totalDaysInMonth; i++)  {
                    for (int j = ((i == 0) ? startingDayOfWeek - 1 : 0); j < 7 && (day <= totalDaysInMonth); j++) {
                        boolean star = false;
                        for(Holiday holiday : holidays){
                            if(isEqual(day,month,year, holiday.getEventStartDate())){
                                displayHoliday(holiday);
                                star = true;
                            }
                        }
                        if(star) {
                            star = false;
                            System.out.println("\n***************************************************************************");
                        }
                        day++;
                    }
                }
                break;
            case 5:
                for (int i = 0, day = 1; day <= totalDaysInMonth; i++)  {
                    for (int j = ((i == 0) ? startingDayOfWeek - 1 : 0); j < 7 && (day <= totalDaysInMonth); j++) {
                        boolean star = false;
                        for(SpecialEvent event : myEvents){
                            if(isEqual(day,month,year, event.getEventStartDate())){
                                displayEvent(event);
                                star = true;
                            }
                        }
                        if(star) {
                            star = false;
                            System.out.println("\n***************************************************************************");
                        }
                        for(Task task : myTasks){
                            if(isEqual(day,month,year, task.getEventStartDate())){
                                displayTask(task);
                                star = true;
                            }
                        }
                        if(star) {
                            star = false;
                            System.out.println("\n***************************************************************************");
                        }
                        for(Birthday birthday : birthdays){
                            if(isEqual(day,month,year, birthday.getEventStartDate())){
                                displayBirthday(birthday);
                                star = true;
                            }
                        }
                        if(star) {
                            star = false;
                            System.out.println("\n***************************************************************************");
                        }
                        for(Holiday holiday : holidays){
                            if(isEqual(day,month,year, holiday.getEventStartDate())){
                                displayHoliday(holiday);
                                star = true;
                            }
                        }
                        if(star) {
                            star = false;
                            System.out.println("\n==========================================================================================================");
                        }
                        day++;
                    }
                }
                break;
            case 6:
                System.out.print("\nExit");
                break;
            default:
                System.out.print("\nEnter valid choice..try again...");
                break;
        }
    } // default method to print that month in calendar
    public void viewMyCalendar(int fromMonth,int toMonth,int fromYear,int toYear){
        boolean calendarRun = true;
        while(calendarRun){
            GregorianCalendar calendar = new GregorianCalendar(fromYear,fromMonth, 1);
            int startingDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK); // S M T W T F S 1 2 3 4 5 6 7
            int totalDaysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH); // 28,29,30,31
            System.out.println(new SimpleDateFormat("MMMM YYYY").format(calendar.getTime()));
            System.out.println(" S  M  T  W  T  F  S");
            for (int i = 0; i < startingDayOfWeek - 1; i++) {
                System.out.print("   ");
            }
            for (int i = 0, day = 1; day <= totalDaysInMonth; i++)  {
                for (int j = ((i == 0) ? startingDayOfWeek - 1 : 0); j < 7 && (day <= totalDaysInMonth); j++) {
                    System.out.printf("%2d ", day);
                    day++;
                }
                System.out.println();
            }
            System.out.print("\nEnter 1 to view Events\nEnter 2 to view tasks\nEnter 3 to view birthdays\nEnter 4 to view holidays\nEnter 5 to view all events\nEnter 6 to exit\nEnter your choice : ");
            int viewChoice;
            try{
                viewChoice = Integer.parseInt(sc.nextLine().trim());
            }
            catch (NumberFormatException numberFormatException){
                System.out.print("\nEnter valid choice..try again...");
                return;
            }
            switch(viewChoice){
                case 1:
                    for (int i = 0, day = 1; day <= totalDaysInMonth; i++)  {
                        for (int j = ((i == 0) ? startingDayOfWeek - 1 : 0); j < 7 && (day <= totalDaysInMonth); j++) {
                            boolean star = false;
                            for(SpecialEvent event : myEvents){
                                if(isEqual(day,fromMonth,fromYear, event.getEventStartDate())){
                                    displayEvent(event);
                                    star = true;
                                }
                            }
                            if(star) {
                                star = false;
                                System.out.println("\n***************************************************************************");
                            }
                            day++;
                        }
                    }
                    break;
                case 2:
                    for (int i = 0, day = 1; day <= totalDaysInMonth; i++)  {
                        for (int j = ((i == 0) ? startingDayOfWeek - 1 : 0); j < 7 && (day <= totalDaysInMonth); j++) {
                            boolean star = false;
                            for(Task task : myTasks){
                                if(isEqual(day,fromMonth,fromYear, task.getEventStartDate())){
                                    displayTask(task);
                                    star = true;
                                }
                            }
                            if(star) {
                                star = false;
                                System.out.println("\n***************************************************************************");
                            }
                            day++;
                        }
                    }
                    break;
                case 3:
                    for (int i = 0, day = 1; day <= totalDaysInMonth; i++)  {
                        for (int j = ((i == 0) ? startingDayOfWeek - 1 : 0); j < 7 && (day <= totalDaysInMonth); j++) {
                            boolean star = false;
                            for(Birthday birthday : birthdays){
                                if(isEqual(day,fromMonth,fromYear, birthday.getEventStartDate())){
                                    displayBirthday(birthday);
                                    star = true;
                                }
                            }
                            if(star) {
                                star = false;
                                System.out.println("\n***************************************************************************");
                            }
                            day++;
                        }
                    }
                    break;
                case 4:
                    for (int i = 0, day = 1; day <= totalDaysInMonth; i++)  {
                        for (int j = ((i == 0) ? startingDayOfWeek - 1 : 0); j < 7 && (day <= totalDaysInMonth); j++) {
                            boolean star = false;
                            for(Holiday holiday : holidays){
                                if(isEqual(day,fromMonth,fromYear, holiday.getEventStartDate())){
                                    displayHoliday(holiday);
                                    star = true;
                                }
                            }
                            if(star) {
                                star = false;
                                System.out.println("\n***************************************************************************");
                            }
                            day++;
                        }
                    }
                    break;
                case 5:
                    for (int i = 0, day = 1; day <= totalDaysInMonth; i++)  {
                        for (int j = ((i == 0) ? startingDayOfWeek - 1 : 0); j < 7 && (day <= totalDaysInMonth); j++) {
                            boolean star = false;
                            for(SpecialEvent event : myEvents){
                                if(isEqual(day,fromMonth,fromYear, event.getEventStartDate())){
                                    displayEvent(event);
                                    star = true;
                                }
                            }
                            if(star) {
                                star = false;
                                System.out.println("\n***************************************************************************");
                            }
                            for(Task task : myTasks){
                                if(isEqual(day,fromMonth,fromYear, task.getEventStartDate())){
                                    displayTask(task);
                                    star = true;
                                }
                            }
                            if(star) {
                                star = false;
                                System.out.println("\n***************************************************************************");
                            }
                            for(Birthday birthday : birthdays){
                                if(isEqual(day,fromMonth,fromYear, birthday.getEventStartDate())){
                                    displayBirthday(birthday);
                                    star = true;
                                }
                            }
                            if(star) {
                                star = false;
                                System.out.println("\n***************************************************************************");
                            }
                            for(Holiday holiday : holidays){
                                if(isEqual(day,fromMonth,fromYear, holiday.getEventStartDate())){
                                    displayHoliday(holiday);
                                    star = true;
                                }
                            }
                            if(star) {
                                star = false;
                                System.out.println("\n==========================================================================================================");
                            }
                            day++;
                        }
                    }
                    break;
                default:
                    System.out.print("\nEnter valid choice..try again...");
                    break;
            }
            if(fromYear == toYear && fromMonth == toMonth){
                calendarRun = false;
            }
            fromMonth++;
            if(fromMonth>12){
                fromMonth = 1;
                fromYear++;
            }
        }
    } // weekly view or monthly view of calendar events, calendar tasks, calendar holidays, calendar birthdays.
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
                long seconds = findTotalDayDifferenceInDates(eventStartDate,eventStartTime);
                if(seconds != -1){
                    event.createReminder(seconds);
                }
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
            event.cancelReminder();
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
                        event.cancelReminder();
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
                        event.cancelReminder();

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
                        event.cancelReminder();
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
                        event.cancelReminder();
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
        int extraChoice;
        try{
            extraChoice = Integer.parseInt(sc.nextLine().trim());
        }
        catch (NumberFormatException numberFormatException){
            System.out.print("\nEnter valid choice...Try again...");
        }
        System.out.print("\nSet the reminder if you have updated the time and date : ");
        System.out.print("\nEnter 1 to set the alarm\nEnter 2 to exit\nEnter your choice : ");
        int alarmChoice = Integer.parseInt(sc.nextLine().trim());
        switch(alarmChoice){
            case 1:
                long seconds = findTotalDayDifferenceInDates(event.getEventStartDate(),event.getNonRecurringEventStartTime());
                if(seconds != -1){
                    event.createReminder(seconds);
                }
                break;
            case 2:
                System.out.print("\nAlarm not set for this event");
                break;
            default:
                System.out.print("\nEnter valid option..try again...");
                break;
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
        System.out.print("\nEnter 1 to set the alarm\nEnter 2 to exit\nEnter your choice : ");
        int alarmChoice = Integer.parseInt(sc.nextLine().trim());
        switch(alarmChoice){
            case 1:
                long seconds = findTotalDayDifferenceInDates(taskDate,taskStartTime);
                if(seconds != -1){
                    task.createReminder(seconds);
                }
                break;
            case 2:
                System.out.print("\nAlarm not set for this task");
                break;
            default:
                System.out.print("\nEnter valid option..try again...");
                break;
        }
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
            task.cancelReminder();
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
                        task.cancelReminder();

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
                        task.cancelReminder();
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
                        task.cancelReminder();
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
        int extraChoice;
        try{
            extraChoice = Integer.parseInt(sc.nextLine().trim());
        }
        catch (NumberFormatException numberFormatException){
            System.out.print("\nEnter valid choice...Try again...");
        }
        System.out.print("\nSet the reminder if you have updated the time and date : ");
        System.out.print("\nEnter 1 to set the alarm\nEnter 2 to exit\nEnter your choice : ");
        int alarmChoice = Integer.parseInt(sc.nextLine().trim());
        switch(alarmChoice){
            case 1:
                long seconds = findTotalDayDifferenceInDates(task.getEventStartDate(),task.getNonRecurringEventStartTime());
                if(seconds != -1){
                    task.createReminder(seconds);
                }
                break;
            case 2:
                System.out.print("\nAlarm not set for this task");
                break;
            default:
                System.out.print("\nEnter valid option..try again...");
                break;
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
            System.out.print("\nEnter mobileNumber : ");
            phoneNumber = sc.nextLine().trim();
        } while (!Registration.validatePhoneNumber(phoneNumber));
        Gender gender;
        String genderType;
        try {
            System.out.print("\nEnter gender of the contact (MALE,FEMALE,OTHERS): ");
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
                    displayTask(task);
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
                        displayTask(task);
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
                    displayEvent(event);
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
                        displayEvent(event);
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
                    displayBirthday(birthday);
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
                        displayBirthday(birthday);
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
    public void viewHolidays(){
        System.out.println("\nEnter 1 to view all holidays\nEnter 2 to view certain holidays \nEnter your choice : ");
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
                for(Holiday holiday : holidays){
                    displayHoliday(holiday);
                }
                break;
            case 2:
                String date = "";
                do{
                    System.out.print("\nEnter valid date (dd/mm/yyyy): ");
                    date = sc.nextLine().trim();
                }while(!validateDate(date));
                for(Holiday holiday : holidays){
                    if(holiday.getEventStartDate().equals(date))
                    {
                        displayHoliday(holiday);
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
            System.out.print("Enter valid date and time..Your event has no reminder...");
            return -1;
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
    public void viewAvailableThemes(){
        for (HashMap.Entry<String,String> entry : myThemes.entrySet())
        {
            System.out.println("Theme: " + entry.getKey());
        }
    }
    public void setThemes(){
        System.out.print("\nEnter 1 to set theme for event\nEnter 2 to set theme for task\nEnter 3 to set theme for birthday\nEnter 4 to set theme for holiday\nEnter 5 to reset theme for event\nEnter 6 to reset theme for task\nEnter 7 to reset theme for birthday\nEnter 8 to reset theme for holiday\nEnter your choice : ");
        int themeChoice;
        try{
            themeChoice = Integer.parseInt(sc.nextLine().trim());
        }
        catch (NumberFormatException numberFormatException){
            System.out.print("\nEnter valid option..please try again..");
            return;
        }
        viewAvailableThemes();
        System.out.print("\nEnter the color to change the theme (IN CAPITALS): ");
        String newColour = sc.nextLine().trim();
        switch(themeChoice){
            case 1:
                SpecialEvent.eventTheme = myThemes.get(newColour);
                break;
            case 2:
                Task.taskTheme = myThemes.get(newColour);
                break;
            case 3:
                Birthday.birthdayTheme = myThemes.get(newColour);
                break;
            case 4:
                Holiday.holidayTheme = myThemes.get(newColour);
                break;
            case 5:
                SpecialEvent.eventTheme = "";
                break;
            case 6:
                Task.taskTheme = "";
                break;
            case 7:
                Birthday.birthdayTheme = "";
                break;
            case 8:
                Holiday.holidayTheme = "";
                break;
            default:
                System.out.print("\nExit");
                break;
        }
    }
    public boolean isEqual(int day, int month, int year, String date){
        String dateParts[] =  date.split("/");
        int dayPart = Integer.parseInt(dateParts[0]);
        int monthPart = Integer.parseInt(dateParts[1]);
        int yearPart = Integer.parseInt(dateParts[2]);
        return (dayPart == day && monthPart-1 == month && yearPart == year);
    }
    public void displayEvent(SpecialEvent event){
        System.out.println(SpecialEvent.eventTheme+"\nEvent ID : "+event.getEventId()+"\nEvent title : "+event.getEventTitle()+"\nEvent description : "+event.getEventDescription()+"\nEvent location & type : ("+event.getEventType()+") "+event.getEventLocation()+"\nEvent start date : "+event.getEventStartDate()+"\nEvent end date : "+event.getEventEndDate()+"\nEvent start time : "+event.getNonRecurringEventStartTime()+"\nEvent end time : "+event.getNonRecurringEventEndTime()+"\n-----------------------------------"+"\u001B[0m");
    }
    public void displayTask(Task task){
        System.out.println(Task.taskTheme+"\nTask ID : "+task.getEventId()+"\nTask title : "+task.getEventTitle()+"\nTask description : "+task.getEventDescription()+"\nTask start date : "+task.getEventStartDate()+"\nTask end date : "+task.getEventEndDate()+"\nTask start time : "+task.getNonRecurringEventStartTime()+"\nTask end time : "+task.getNonRecurringEventEndTime()+"\n-----------------------------------"+"\u001B[0m");
    }
    public void displayHoliday(Holiday holiday){
        System.out.println(Holiday.holidayTheme+"\nHoliday ID : "+holiday.getEventId()+"\nHoliday title : "+holiday.getEventTitle()+"\nHoliday description : "+holiday.getEventDescription()+"\nHoliday date : "+holiday.getEventStartDate()+"\nType of holiday : "+holiday.getHolidayType()+"\n-----------------------------------"+"\u001B[0m");
    }
    public void displayBirthday(Birthday birthday){
        System.out.println(Birthday.birthdayTheme+"\nBirthday ID : "+birthday.getEventId()+"\nBirthday title : "+birthday.getEventTitle()+"\nBirthday description : "+birthday.getEventDescription()+"\nDate Of Birth : "+birthday.getEventStartDate()+"\nName : "+birthday.getContactName()+"\nPhoneNumber : "+birthday.getPhoneNumber()+"\nGender : "+birthday.getGender()+"\nJob : "+birthday.getJobTitle()+"\nLocation : "+birthday.getLocation()+"\n-----------------------------------"+"\u001B[0m");
    }
}
