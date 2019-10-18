package cert.book1.chapter4.school;

public class ClassRoom {
    private int roomNumber;
    protected String teacherName;
    static int globalKey = 54321;
    public int floor = 3;

    ClassRoom(int roomNumber, String teacherName) {
        this.roomNumber = roomNumber;
        this.teacherName = teacherName;
    }
}
