public class User {
    int id;
    int permissionId;
    String name;
    String email;
    String username;
    String password;

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

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", permissionId=" + permissionId + ", name=" + name + ", email=" + email
                + ", username=" + username + ", password=" + password + '}';
    }

}
