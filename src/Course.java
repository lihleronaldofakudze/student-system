import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Course extends DatabaseActions {
    int id;
    String type;
    String name;
    String description;
    int year;
    int studentId;
    Connection connection = DatabaseConnection.getConnection();
    Scanner scanner = new Scanner(System.in);

    public Course() {
    }

    public Course(int id, String type, String name, String description, int year, int studentId) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.description = description;
        this.year = year;
        this.studentId = studentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Override
    void insert() {
        try {
            System.out.print("Enter Course Type : ");
            String type = scanner.nextLine();

            System.out.print("Enter Course Name : ");
            String name = scanner.nextLine();

            System.out.print("Enter Course Description : ");
            String description = scanner.nextLine();

            System.out.print("Enter Course Year : ");
            int year = scanner.nextInt();

            System.out.print("Enter Student ID : ");
            int studentId = scanner.nextInt();

            String query = "INSERT INTO `courses` (`id`, `type`, `name`, `description`, `year`, `student_id`) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, 0);
            preparedStatement.setString(2, type);
            preparedStatement.setString(3, name);
            preparedStatement.setString(4, description);
            preparedStatement.setInt(5, year);
            preparedStatement.setInt(6, studentId);
            preparedStatement.executeUpdate();
            System.out.println("Course has been inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    void update() {
        try {
            System.out.print("Enter Course ID : ");
            int id = scanner.nextInt();

            System.out.print("Enter Course Type : ");
            String type = scanner.nextLine();

            System.out.print("Enter Course Name : ");
            String name = scanner.nextLine();

            System.out.print("Enter Course Description : ");
            String description = scanner.nextLine();

            System.out.print("Enter Course Year : ");
            int year = scanner.nextInt();

            System.out.print("Enter Student ID : ");
            int studentId = scanner.nextInt();

            String query = "UPDATE `courses` SET `type`=?,`name`=?,`description`=?,`year`=?,`student_id`=? WHERE `id`=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, type);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, description);
            preparedStatement.setInt(4, year);
            preparedStatement.setInt(5, studentId);
            preparedStatement.setInt(6, id);
            preparedStatement.executeUpdate();
            System.out.println("Course has been updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    void delete() {
        try {
            System.out.print("Enter Course ID : ");
            int id = scanner.nextInt();

            String query = "DELETE FROM `courses` WHERE `id`=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Course has been deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    void select() {
        String query = "SELECT * FROM `courses`";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.print("Course ID: " + resultSet.getInt("id"));
                System.out.print("Course Type: " + resultSet.getString("type"));
                System.out.print("Course Name: " + resultSet.getString("name"));
                System.out.print("Course Description: " + resultSet.getString("description"));
                System.out.print("Course Year: " + resultSet.getInt("year"));
                System.out.print("Course Student ID: " + resultSet.getInt("student_id"));
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
