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
                        System.out.print("\nEnter 1 to create event\nEnter 2 to cancel event\nEnter 3 to update event\nEnter 4 to create task\nEnter 5 to cancel task\nEnter 6 to update task\nEnter 7 to view Events\nEnter 8 to view Tasks\nEnter 9 to view Attendees\nEnter 10 to view My calendar\nEnter 11 to update personal information\nEnter 12 to change my password\nEnter 13 to exit\n\n\nEnter your choice : ");
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
                                userRun = false;
                                break;
                            default:
                                System.out.println("\nEnter valid option...");
                                userRun = false;
                                break;
                        }
                    }
                    break;
                case 3:
                    String adminId = signup.createLogin();
                    boolean adminRun = adminId != null ? true : false;
                    while (adminRun){

                    }
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