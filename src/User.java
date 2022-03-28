import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class User extends DatabaseActions {
    int id;
    int permissionId;
    String name;
    String email;
    String username;
    String password;
    static Connection connection = DatabaseConnection.getConnection();
    Scanner scanner = new Scanner(System.in);

    public User() {
    }

    public User(int id, int permissionId, String name, String email, String username, String password) {
        this.id = id;
        this.permissionId = permissionId;
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(int permissionId) {
        this.permissionId = permissionId;
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

    public boolean login(String username, String password) {
        try {
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    void insert() {
        System.out.print("Enter permission id: ");
        int permissionId = scanner.nextInt();

        System.out.print("Enter user name: ");
        String name = scanner.nextLine();

        System.out.print("Enter user email: ");
        String email = scanner.nextLine();

        System.out.print("Enter user username: ");
        String username = scanner.nextLine();

        System.out.print("Enter user password: ");
        String password = scanner.nextLine();

        String query = "INSERT INTO users (permission_id, name, email, username, password) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, permissionId);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, username);
            preparedStatement.setString(5, password);
            preparedStatement.executeUpdate();
            System.out.println("User inserted successfully");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    @Override
    void update() {
        System.out.print("Enter user id: ");
        int id = scanner.nextInt();

        System.out.print("Enter permission id: ");
        int permissionId = scanner.nextInt();

        System.out.print("Enter user name: ");
        String name = scanner.nextLine();

        System.out.print("Enter user email: ");
        String email = scanner.nextLine();

        System.out.print("Enter user username: ");
        String username = scanner.nextLine();

        System.out.print("Enter user password: ");
        String password = scanner.nextLine();

        String query = "UPDATE users SET permission_id = ?, name = ?, email = ?, username = ?, password = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, permissionId);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, username);
            preparedStatement.setString(5, password);
            preparedStatement.setInt(6, id);
            preparedStatement.executeUpdate();
            System.out.println("User updated successfully");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    @Override
    void delete() {
        System.out.print("Enter user id: ");
        int id = scanner.nextInt();

        String query = "DELETE FROM users WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("User deleted successfully");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    @Override
    void select() {
        String query = "SELECT * FROM users";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.print("ID: " + resultSet.getInt("id"));
                System.out.print("Permission ID: " + resultSet.getInt("permission_id"));
                System.out.print("Name: " + resultSet.getString("name"));
                System.out.print("Email: " + resultSet.getString("email"));
                System.out.print("Username: " + resultSet.getString("username"));
                System.out.println("Password: " + resultSet.getString("password"));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

}
