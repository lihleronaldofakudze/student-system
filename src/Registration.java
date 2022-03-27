public class Registration {
    int id;
    String type;
    String description;
    int phoneNumber;
    int studentId;
    String name;
    String date;

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
    public String toString() {
        return "Registration{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", studentId=" + studentId +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
