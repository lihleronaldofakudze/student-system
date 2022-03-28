import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Classes extends DatabaseActions {
    int id;
    String type;
    String description;
    int studentId;
    String name;
    String room;
    Connection connection = DatabaseConnection.getConnection();
    Scanner scanner = new Scanner(System.in);

    public Classes() {
    }

    public Classes(int id, String type, String description, int studentId, String name, String room) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.studentId = studentId;
        this.name = name;
        this.room = room;
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

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    @Override
    void insert() {
        System.out.println("Inserting Class");
        System.out.print("Enter Class Type: ");
        String type = scanner.nextLine();

        System.out.print("Enter Class Description: ");
        String description = scanner.nextLine();

        System.out.print("Enter Student ID: ");
        int studentId = scanner.nextInt();

        System.out.print("Enter Class Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Class Room: ");
        String room = scanner.nextLine();

        String sql = "INSERT INTO classes (type, description, studentId, name, room) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, type);
            preparedStatement.setString(2, description);
            preparedStatement.setInt(3, studentId);
            preparedStatement.setString(4, name);
            preparedStatement.setString(5, room);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    void update() {
        System.out.println("Updating Class");
        System.out.print("Enter Class ID: ");
        int id = scanner.nextInt();

        System.out.print("Enter Class Type: ");
        String type = scanner.nextLine();

        System.out.print("Enter Class Description: ");
        String description = scanner.nextLine();

        System.out.print("Enter Student ID: ");
        int studentId = scanner.nextInt();

        System.out.print("Enter Class Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Class Room: ");
        String room = scanner.nextLine();

        String sql = "UPDATE classes SET type = ?, description = ?, studentId = ?, name = ?, room = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, type);
            preparedStatement.setString(2, description);
            preparedStatement.setInt(3, studentId);
            preparedStatement.setString(4, name);
            preparedStatement.setString(5, room);
            preparedStatement.setInt(6, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    void delete() {
        System.out.println("Deleting Class");
        System.out.print("Enter Class ID: ");
        int id = scanner.nextInt();

        String sql = "DELETE FROM classes WHERE id = ?";
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
        String sql = "SELECT * FROM classes";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.print("ID: " + resultSet.getInt("id"));
                System.out.print("Type: " + resultSet.getString("type"));
                System.out.print("Description: " + resultSet.getString("description"));
                System.out.print("Student ID: " + resultSet.getInt("studentId"));
                System.out.print("Name: " + resultSet.getString("name"));
                System.out.println("Room: " + resultSet.getString("room"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}