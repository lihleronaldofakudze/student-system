public class Classes {
    int id;
    String type;
    String description;
    int studentId;
    String name;
    String room;

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
    public String toString() {
        return "Classes{" + "id=" + id + ", type=" + type + ", description=" + description + ", studentId=" + studentId
                + ", name=" + name + ", room=" + room + '}';
    }

}