package attendance;

public class Student {
    private String id;
    private String name;
    private String password;
    private String email;

    public Student(String id, String name, String password, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void viewAttendanceReport(Course course) {
        course.displayAttendanceReportForStudent(this.id);
    }

    public void viewEligibilityStatus(Course course) {
        course.displayEligibilityStatus(this.id);
    }
}