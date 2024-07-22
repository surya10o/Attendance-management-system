package attendance;

import java.util.ArrayList;

public class Teacher {
    private String id;
    private String name;
    private String password;
    private String email;

    public Teacher(String id, String name, String password, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void addLecture(Course course, String lecture) {
        course.addLecture(lecture);
    }

    public void markAttendance(Course course, String studentId) {
        course.markAttendance(studentId);
    }

    public void viewAttendance(Course course) {
        course.displayAttendance();
    }

    public void prepareAttendanceReport(Course course) {
        course.generateAttendanceReport();
    }

    public void viewAttendanceReport(Course course) {
        course.displayAttendanceReport();
    }

    public void declareEligiblePercentage(Course course, double percentage) {
        course.setEligibilityPercentage(percentage);
    }
}