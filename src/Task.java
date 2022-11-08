import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Task {
    private static int tId = 1;
    private int taskId;
    private String taskTitle;
    private String taskDetails;
    private Status taskStatus;
    private String taskStartDate;
    private String taskEndDate;
    private String taskStartTime;
    private String taskEndTime;
    private Notify taskAlarm;
    private String taskTheme;
}