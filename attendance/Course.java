package attendance;

import java.util.ArrayList;
import java.util.HashMap;

public class Course {
    private String id;
    private String name;
    private String teacher;
    private ArrayList<String> lectures;
    private ArrayList<Student> enrolledStudents;
    private HashMap<String, Integer> attendance;
    private double eligibilityPercentage;

    public Course(String id, String name, String teacher) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
        this.lectures = new ArrayList<>();
        this.enrolledStudents = new ArrayList<>();
        this.attendance = new HashMap<>();
        this.eligibilityPercentage = 75.0; // default eligibility percentage
    }

    public String getId() {
        return id;
    }

    public void addLecture(String lecture) {
        lectures.add(lecture);
    }

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
        attendance.put(student.getId(), 0);
    }

    public void unenrollStudent(String studentId) {
        enrolledStudents.removeIf(student -> student.getId().equals(studentId));
        attendance.remove(studentId);
    }

    public void markAttendance(String studentId) {
        attendance.put(studentId, attendance.getOrDefault(studentId, 0) + 1);
    }

    public void displayAttendance() {
        for (Student student : enrolledStudents) {
            System.out.println(student.getId() + ": " + attendance.get(student.getId()));
        }
    }

    public void generateAttendanceReport() {
        System.out.println("Attendance Report for Course: " + name);
        for (Student student : enrolledStudents) {
            System.out.println(student.getId() + ": " + attendance.get(student.getId()));
        }
    }

    public void displayAttendanceReport() {
        generateAttendanceReport();
    }

    public void displayAttendanceReportForStudent(String studentId) {
        System.out.println("Attendance for student " + studentId + ": " + attendance.get(studentId));
    }

    public void displayEligibilityStatus(String studentId) {
        int attended = attendance.getOrDefault(studentId, 0);
        int totalLectures = lectures.size();
        double attendancePercentage = ((double) attended / totalLectures) * 100;
        System.out.println("Eligibility Status for student " + studentId + ": " + (attendancePercentage >= eligibilityPercentage ? "Eligible" : "Not Eligible"));
    }

    public void setEligibilityPercentage(double percentage) {
        this.eligibilityPercentage = percentage;
    }
}