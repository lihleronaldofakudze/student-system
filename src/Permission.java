import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Permission extends DatabaseActions {
    private int id;
    private String name;
    private String description;
    Connection connection = DatabaseConnection.getConnection();
    Scanner scanner = new Scanner(System.in);

    public Permission() {
    }

    public Permission(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    @Override
    void insert() {
        System.out.println("Enter permission name: ");
        String name = scanner.nextLine();

        System.out.println("Enter permission description: ");
        String description = scanner.nextLine();

        String sql = "INSERT INTO permissions (name, description) VALUES (?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, description);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    void update() {
        System.out.print("Enter permission id: ");
        int id = scanner.nextInt();

        System.out.print("Enter permission name: ");
        String name = scanner.nextLine();

        System.out.print("Enter permission description: ");
        String description = scanner.nextLine();

        String sql = "UPDATE permissions SET name = ?, description = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, description);
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    void delete() {
        System.out.print("Enter permission id: ");
        int id = scanner.nextInt();

        String sql = "DELETE FROM permissions WHERE id = ?";
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
        String sql = "SELECT * FROM permissions";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.print("ID: " + resultSet.getInt("id"));
                System.out.print("Name: " + resultSet.getString("name"));
                System.out.println("Description: " + resultSet.getString("description"));
                System.out.println("---------------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}