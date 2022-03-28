import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class School extends DatabaseActions {
    int id;
    String name;
    String description;
    String type;
    Connection connection = DatabaseConnection.getConnection();
    Scanner scanner = new Scanner(System.in);

    public School() {
    }

    public School(int id, String name, String description, String type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    void insert() {
        System.out.print("Enter school name: ");
        String name = scanner.nextLine();

        System.out.print("Enter school description: ");
        String description = scanner.nextLine();

        System.out.print("Enter school type: ");
        String type = scanner.nextLine();

        String sql = "INSERT INTO schools (name, description, type) VALUES (?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, description);
            preparedStatement.setString(3, type);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    void update() {
        System.out.print("Enter school id: ");
        int id = scanner.nextInt();

        System.out.print("Enter school name: ");
        String name = scanner.nextLine();

        System.out.print("Enter school description: ");
        String description = scanner.nextLine();

        System.out.print("Enter school type: ");
        String type = scanner.nextLine();

        String sql = "UPDATE schools SET name = ?, description = ?, type = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, description);
            preparedStatement.setString(3, type);
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    void delete() {
        System.out.print("Enter school id: ");
        int id = scanner.nextInt();

        String sql = "DELETE FROM schools WHERE id = ?";
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
        String sql = "SELECT * FROM schools";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.print("ID: " + resultSet.getInt("id"));
                System.out.print("Name: " + resultSet.getString("name"));
                System.out.print("Description: " + resultSet.getString("description"));
                System.out.println("Type: " + resultSet.getString("type"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
