
public class Task extends NonRecurringEvent{

    static String taskTheme = "";
    public Task(String taskTitle, String taskDescription, String taskStartDate, String taskEndDate, String nonRecurringtaskStartTime, String nonRecurringtaskEndTime) {
        super(taskTitle, taskDescription, taskStartDate, taskEndDate, nonRecurringtaskStartTime, nonRecurringtaskEndTime);
    }

    public void completeTask(){} // used to change the status;
}