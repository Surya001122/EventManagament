import application.Admin;
import application.User;
import authentication.Registration;
import constant.Gender;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Registration signup = new Registration();
        Admin admin = new Admin("A1_Surya","Surya","Surya123!!!","Chennai","1234567890");
        User u = new User("Surya","U1_Surya", Gender.MALE,"Surya123!!!","Developer","Chennai","1234567890","01/08/2002");
        signup.addLoginInfo(u.getUserId(), u.getUserPassword());
        admin.addUsers(u);
        boolean start = true;
        while(start)
        {
            System.out.print("\n1.SignUp\n2.Login\n3.Exit\n\n\nEnter your choice : ");
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
                        System.out.print("\nEnter 1 to create event\nEnter 2 to cancel event\nEnter 3 to update event\nEnter 4 to create task\nEnter 5 to cancel task\nEnter 6 to update task\nEnter 7 to create birthdays\nEnter 8 to cancel birthdays\nEnter 9 to update birthdays\nEnter 10 to set themes\nEnter 11 to view events\nEnter 12 to view tasks\nEnter 13 to view birthdays\nEnter 14 to view holidays\nEnter 15 to view available themes\nEnter 16 to view my calendar\nEnter 17 to update personal information\nEnter 18 to change my password\nEnter 19 to exit\n\n\nEnter your choice : ");
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
                                user.setThemes();
                                break;
                            case 11:
                                user.viewEvents();
                                break;
                            case 12:
                                user.viewTasks();
                                break;
                            case 13:
                                user.viewBirthdays();
                                break;
                            case 14:
                                user.viewMyHolidays();
                                break;
                            case 15:
                                user.viewAvailableThemes();
                                break;
                            case 16:
                                user.viewMyCalendar();
                                break;
                            case 17:
                                user.updatePersonalInformation();
                                break;
                            case 18:
                                user.changeMyPassword();
                                break;
                            case 19:
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
                    System.out.println("\nExit");
                    start = false;
                    break;
                default:
                    System.out.print("\nEnter valid option...");
                    start = false;
                    break;
            }
        }
    }
}