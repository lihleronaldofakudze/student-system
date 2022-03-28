import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Registration extends DatabaseActions {
    int id;
    String type;
    String description;
    int phoneNumber;
    int studentId;
    String name;
    String date;
    Connection connection = DatabaseConnection.getConnection();
    Scanner scanner = new Scanner(System.in);

    public Registration() {
    }

    public Registration(int id, String type, String description, int phoneNumber, int studentId, String name,
            String date) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.phoneNumber = phoneNumber;
        this.studentId = studentId;
        this.name = name;
        this.date = date;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    void insert() {
        System.out.print("Enter registration type: ");
        String type = scanner.nextLine();

        System.out.print("Enter registration description: ");
        String description = scanner.nextLine();

        System.out.print("Enter registration phone number: ");
        int phoneNumber = scanner.nextInt();

        System.out.print("Enter registration student id: ");
        int studentId = scanner.nextInt();

        System.out.print("Enter registration name: ");
        String name = scanner.nextLine();

        System.out.print("Enter registration date: ");
        String date = scanner.nextLine();

        String sql = "INSERT INTO registrations (type, description, phoneNumber, studentId, name, date) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, type);
            preparedStatement.setString(2, description);
            preparedStatement.setInt(3, phoneNumber);
            preparedStatement.setInt(4, studentId);
            preparedStatement.setString(5, name);
            preparedStatement.setString(6, date);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    void update() {
        System.out.print("Enter registration id: ");
        int id = scanner.nextInt();

        System.out.print("Enter registration type: ");
        String type = scanner.nextLine();

        System.out.print("Enter registration description: ");
        String description = scanner.nextLine();

        System.out.print("Enter registration phone number: ");
        int phoneNumber = scanner.nextInt();

        System.out.print("Enter registration student id: ");
        int studentId = scanner.nextInt();

        System.out.print("Enter registration name: ");
        String name = scanner.nextLine();

        System.out.print("Enter registration date: ");
        String date = scanner.nextLine();

        String sql = "UPDATE registrations SET type = ?, description = ?, phoneNumber = ?, studentId = ?, name = ?, date = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, type);
            preparedStatement.setString(2, description);
            preparedStatement.setInt(3, phoneNumber);
            preparedStatement.setInt(4, studentId);
            preparedStatement.setString(5, name);
            preparedStatement.setString(6, date);
            preparedStatement.setInt(7, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    void delete() {
        System.out.print("Enter registration id: ");
        int id = scanner.nextInt();

        String sql = "DELETE FROM registrations WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    void select() {
        String sql = "SELECT * FROM registrations";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.print("ID: " + resultSet.getInt("id"));
                System.out.print("Type: " + resultSet.getString("type"));
                System.out.print("Description: " + resultSet.getString("description"));
                System.out.print("Phone Number: " + resultSet.getInt("phoneNumber"));
                System.out.print("Student ID: " + resultSet.getInt("studentId"));
                System.out.print("Name: " + resultSet.getString("name"));
                System.out.println("Date: " + resultSet.getString("date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
