import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Student extends DatabaseActions {
    int id;
    String name;
    String email;
    String phoneNumber;
    String address;
    String username;
    String password;
    Connection connection = DatabaseConnection.getConnection();
    Scanner scanner = new Scanner(System.in);

    public Student() {
    }

    public Student(int id, String name, String email, String phoneNumber, String address, String username,
            String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    void insert() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student email: ");
        String email = scanner.nextLine();

        System.out.print("Enter student phone number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Enter student address: ");
        String address = scanner.nextLine();

        System.out.print("Enter student username: ");
        String username = scanner.nextLine();

        System.out.print("Enter student password: ");
        String password = scanner.nextLine();

        String sql = "INSERT INTO students(name, email, phoneNumber, address, username, password) VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, phoneNumber);
            preparedStatement.setString(4, address);
            preparedStatement.setString(5, username);
            preparedStatement.setString(6, password);
            preparedStatement.executeUpdate();
            System.out.println("Student added successfully");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    void update() {
        System.out.print("Enter student id: ");
        int id = scanner.nextInt();

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student email: ");
        String email = scanner.nextLine();

        System.out.print("Enter student phone number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Enter student address: ");
        String address = scanner.nextLine();

        System.out.print("Enter student username: ");
        String username = scanner.nextLine();

        System.out.print("Enter student password: ");
        String password = scanner.nextLine();

        String sql = "UPDATE students SET name = ?, email = ?, phoneNumber = ?, address = ?, username = ?, password = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, phoneNumber);
            preparedStatement.setString(4, address);
            preparedStatement.setString(5, username);
            preparedStatement.setString(6, password);
            preparedStatement.setInt(7, id);
            preparedStatement.executeUpdate();
            System.out.println("Student updated successfully");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    void delete() {
        System.out.print("Enter student id: ");
        int id = scanner.nextInt();

        String sql = "DELETE FROM students WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Student deleted successfully");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    @Override
    void select() {
        String sql = "SELECT * FROM students";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.print("ID: " + resultSet.getInt("id"));
                System.out.print("Name: " + resultSet.getString("name"));
                System.out.print("Email: " + resultSet.getString("email"));
                System.out.print("Phone Number: " + resultSet.getString("phoneNumber"));
                System.out.print("Address: " + resultSet.getString("address"));
                System.out.print("Username: " + resultSet.getString("username"));
                System.out.print("Password: " + resultSet.getString("password"));
                System.out.println("---------------------------------");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

}
