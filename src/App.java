import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);
    private static User user = new User();
    private static Classes classes = new Classes();
    private static Course course = new Course();
    private static Permission permission = new Permission();
    private static Registration registration = new Registration();
    private static Student student = new Student();

    public static void main(String[] args) {
        DatabaseConnection.getConnection();
        System.out.println("Welcome to Student Information System");
        System.out.println("_____________________________________");
        System.out.println("Please Login First To Continue");
        System.out.println("_____________________________________");
        System.out.println("Enter Your Username: ");
        String username = scanner.nextLine();
        System.out.println("Enter Your Password: ");
        String password = scanner.nextLine();
        boolean isLogin = user.login(username, password);
        if (isLogin) {
            System.out.println("Login Successful");
            System.out.println("_____________________________________");
            mainMenu();
        } else {
            System.out.println("Login Failed");
        }
    }

    private static void mainMenu() {
        System.out.println("Welcome To Student Information System");
        System.out.println("_____________________________________");
        System.out.println("Please Select Your Option");
        System.out.println("\t 1. Classes Management");
        System.out.println("\t 2. Course Management");
        System.out.println("\t 3. Permission Management");
        System.out.println("\t 4. Registration Management");
        System.out.println("\t 5. School Management");
        System.out.println("\t 6. Student Management");
        System.out.println("\t 7. User Management");
        System.out.println("\t 8. Logout");
        System.out.println("_____________________________________");
        System.out.println("Enter Your Option: ");
        int option = scanner.nextInt();
        scanner.nextLine();
        switch (option) {
            case 1:
                classesMenu();
                break;
            case 2:
                courseMenu();
                break;
            case 3:
                permissionMenu();
                break;
            case 4:
                registrationMenu();
                break;
            case 5:
                schoolMenu();
                break;
            case 6:
                studentMenu();
                break;
            case 7:
                userMenu();
                break;
            case 8:
                System.out.println("Logout Successful");
                System.out.println("_____________________________________");
                mainMenu();
                break;
            default:
                System.out.println("Invalid Option");
                System.out.println("_____________________________________");
                mainMenu();
                break;
        }
    }

    private static void userMenu() {
        System.out.println("Welcome To User Management");
        System.out.println("_____________________________________");
        System.out.println("Please Select Your Option");
        System.out.println("\t 1. Add User");
        System.out.println("\t 2. Update User");
        System.out.println("\t 3. Delete User");
        System.out.println("\t 4. View All Users");
        System.out.println("\t 5. Back");
        System.out.println("_____________________________________");
        System.out.println("Enter Your Option: ");
        int option = scanner.nextInt();
        scanner.nextLine();
        switch (option) {
            case 1:
                user.insert();
                userMenu();
                break;
            case 2:
                user.update();
                userMenu();
                break;
            case 3:
                user.delete();
                userMenu();
                break;
            case 4:
                user.select();
                userMenu();
                break;
            case 5:
                mainMenu();
                break;
            default:
                System.out.println("Invalid Option");
                System.out.println("_____________________________________");
                userMenu();
                break;
        }
    }

    private static void studentMenu() {
        System.out.println("Welcome To Student Management");
        System.out.println("_____________________________________");
        System.out.println("Please Select Your Option");
        System.out.println("\t 1. Add Student");
        System.out.println("\t 2. Update Student");
        System.out.println("\t 3. Delete Student");
        System.out.println("\t 4. View All Students");
        System.out.println("\t 5. Back");
        System.out.println("_____________________________________");
        System.out.println("Enter Your Option: ");
        int option = scanner.nextInt();
        scanner.nextLine();
        switch (option) {
            case 1:
                student.insert();
                studentMenu();
                break;
            case 2:
                student.update();
                studentMenu();
                break;
            case 3:
                student.delete();
                studentMenu();
                break;
            case 4:
                student.select();
                studentMenu();
                break;
            case 5:
                mainMenu();
                break;
            default:
                System.out.println("Invalid Option");
                System.out.println("_____________________________________");
                studentMenu();
                break;
        }
    }

    private static void schoolMenu() {
        System.out.println("Welcome To School Management");
        System.out.println("_____________________________________");
        System.out.println("Please Select Your Option");
        System.out.println("\t 1. Add School");
        System.out.println("\t 2. Update School");
        System.out.println("\t 3. Delete School");
        System.out.println("\t 4. View All Schools");
        System.out.println("\t 5. Back");
        System.out.println("_____________________________________");
        System.out.println("Enter Your Option: ");
        int option = scanner.nextInt();
        scanner.nextLine();
        switch (option) {
            case 1:
                classes.insert();
                schoolMenu();
                break;
            case 2:
                classes.update();
                schoolMenu();
                break;
            case 3:
                classes.delete();
                schoolMenu();
                break;
            case 4:
                classes.select();
                schoolMenu();
                break;
            case 5:
                mainMenu();
                break;
            default:
                System.out.println("Invalid Option");
                System.out.println("_____________________________________");
                schoolMenu();
                break;
        }
    }

    private static void registrationMenu() {
        System.out.println("Welcome To Registration Management");
        System.out.println("_____________________________________");
        System.out.println("Please Select Your Option");
        System.out.println("\t 1. Add Registration");
        System.out.println("\t 2. Update Registration");
        System.out.println("\t 3. Delete Registration");
        System.out.println("\t 4. View All Registrations");
        System.out.println("\t 5. Back");
        System.out.println("_____________________________________");
        System.out.println("Enter Your Option: ");
        int option = scanner.nextInt();
        scanner.nextLine();
        switch (option) {
            case 1:
                registration.insert();
                registrationMenu();
                break;
            case 2:
                registration.update();
                registrationMenu();
                break;
            case 3:
                registration.delete();
                registrationMenu();
                break;
            case 4:
                registration.select();
                registrationMenu();
                break;
            case 5:
                mainMenu();
                break;
            default:
                System.out.println("Invalid Option");
                System.out.println("_____________________________________");
                registrationMenu();
                break;
        }
    }

    private static void permissionMenu() {
        System.out.println("Welcome To Permission Management");
        System.out.println("_____________________________________");
        System.out.println("Please Select Your Option");
        System.out.println("\t 1. Add Permission");
        System.out.println("\t 2. Update Permission");
        System.out.println("\t 3. Delete Permission");
        System.out.println("\t 4. View All Permissions");
        System.out.println("\t 5. Back");
        System.out.println("_____________________________________");
        System.out.println("Enter Your Option: ");
        int option = scanner.nextInt();
        scanner.nextLine();
        switch (option) {
            case 1:
                permission.insert();
                permissionMenu();
                break;
            case 2:
                permission.update();
                permissionMenu();
                break;
            case 3:
                permission.delete();
                permissionMenu();
                break;
            case 4:
                permission.select();
                permissionMenu();
                break;
            case 5:
                mainMenu();
                break;
            default:
                System.out.println("Invalid Option");
                System.out.println("_____________________________________");
                permissionMenu();
                break;
        }
    }

    private static void courseMenu() {
        System.out.println("Welcome To Course Management");
        System.out.println("_____________________________________");
        System.out.println("Please Select Your Option");
        System.out.println("\t 1. Add Course");
        System.out.println("\t 2. Update Course");
        System.out.println("\t 3. Delete Course");
        System.out.println("\t 4. View All Courses");
        System.out.println("\t 5. Back");
        System.out.println("_____________________________________");
        System.out.println("Enter Your Option: ");
        int option = scanner.nextInt();
        scanner.nextLine();
        switch (option) {
            case 1:
                course.insert();
                courseMenu();
                break;
            case 2:
                course.update();
                courseMenu();
                break;
            case 3:
                course.delete();
                courseMenu();
                break;
            case 4:
                course.select();
                courseMenu();
                break;
            case 5:
                mainMenu();
                break;
            default:
                System.out.println("Invalid Option");
                System.out.println("_____________________________________");
                courseMenu();
                break;
        }
    }

    private static void classesMenu() {
        System.out.println("Welcome To Classes Management");
        System.out.println("_____________________________________");
        System.out.println("Please Select Your Option");
        System.out.println("\t 1. Add Classes");
        System.out.println("\t 2. Update Classes");
        System.out.println("\t 3. Delete Classes");
        System.out.println("\t 4. View All Classes");
        System.out.println("\t 5. Back");
        System.out.println("_____________________________________");
        System.out.println("Enter Your Option: ");
        int option = scanner.nextInt();
        scanner.nextLine();
        switch (option) {
            case 1:
                classes.insert();
                classesMenu();
                break;
            case 2:
                classes.update();
                classesMenu();
                break;
            case 3:
                classes.delete();
                classesMenu();
                break;
            case 4:
                classes.select();
                classesMenu();
                break;
            case 5:
                mainMenu();
                break;
            default:
                System.out.println("Invalid Option");
                System.out.println("_____________________________________");
                classesMenu();
                break;
        }
    }
}
