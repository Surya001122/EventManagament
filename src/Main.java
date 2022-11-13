import java.awt.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Registration signup = new Registration();
        Admin admin = new Admin("A1_Surya","Surya","Surya123!!!","Chennai","12345");
        signup.addLoginInfo(admin.getAdminId(), admin.getAdminPassword());
        boolean start = true;
        while(start)
        {
            System.out.print("\n1.User SignUp\n2.UserLogin\n3.AdminLogin\n4.Exit\n\n\nEnter your choice : ");
            int login;
            try {
                login = Integer.parseInt(sc.nextLine().trim());
            }
            catch(NumberFormatException numberFormatException){
                System.out.println("Enter valid option...");
                continue;
            }
            switch(login){
                case 1:
                    signup.userSignUp(admin);
                    break;
                case 2:
                    String userId = signup.createLogin();
                    boolean userRun = userId != null ? true : false;
                    while(userRun)
                    {
                        User user = admin.getUser(userId);
                        System.out.print("\nEnter 1 to create event\nEnter 2 to cancel event\nEnter 3 to update event\nEnter 4 to create task\nEnter 5 to cancel task\nEnter 6 to update task\nEnter 7 to create birthdays\nEnter 8 to cancel birthdays\nEnter 9 to update birthdays\nEnter 10 to create holiday\nEnter 11 to cancel holidays\nEnter 12 to set themes\nEnter 13 to view events\nEnter 14 to view tasks\nEnter 15 to view birthdays\nEnter 16 to view holidays\nEnter 17 to view available themes\nEnter 18 to view my calendar\nEnter 19 to update personal information\nEnter 20 to change my password\nEnter 21 to exit\n\n\nEnter your choice : ");
                        int userChoice = 0;
                        try {
                            userChoice = Integer.parseInt(sc.nextLine().trim());
                        }
                        catch(NumberFormatException numberFormatException) {
                            System.out.print("\nTry again.");
                        }
                        switch (userChoice) {
                            case 1:
                                user.createEvent();
                                break;
                            case 2:
                                user.cancelEvent();
                                break;
                            case 3:
                                user.updateEvent();
                                break;
                            case 4:
                                user.createTask();
                                break;
                            case 5:
                                user.cancelTask();
                                break;
                            case 6:
                                user.updateTask();
                                break;
                            case 7:
                                user.addBirthdays();
                                break;
                            case 8:
                                user.removeBirthdays();
                                break;
                            case 9:
                                user.modifyBirthdays();
                                break;
                            case 10:
                                user.addHolidays();
                                break;
                            case 11:
                                user.removeHolidays();
                                break;
                            case 12:
                                user.setThemes();
                                break;
                            case 13:
                                user.viewEvents();
                                break;
                            case 14:
                                user.viewTasks();
                                break;
                            case 15:
                                user.viewBirthdays();
                                break;
                            case 16:
                                user.viewMyHolidays();
                                break;
                            case 17:
                                user.viewAvailableThemes();
                                break;
                            case 18:
                                user.viewMyCalendar();
                                break;
                            case 19:
                                user.updatePersonalInformation();
                                break;
                            case 20:
                                user.changeMyPassword();
                                break;
                            case 21:
                                userRun = false;
                                System.out.println("\nExit");
                                break;
                            default:
                                System.out.println("\nEnter valid option...");
                                userRun = false;
                                break;
                        }
                    }
                    break;
                case 3:
                    break;
                case 4:
                    start = false;
                    break;
                default:
                    break;
            }
        }
    }
}