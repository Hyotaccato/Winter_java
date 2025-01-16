package Attendance;

public class Attendance {
    private String studentId;
    private String date;
    private boolean isPresent;

    public Attendance(String studentId, String date, boolean isPresent) {
        this.studentId = studentId;
        this.date = date;
        this.isPresent = isPresent;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getDate() {
        return date;
    }

    public boolean isPresent() {
        return isPresent;
    }
}