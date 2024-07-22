//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
package attendance;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin("admin1", "Admin Name", "password", "admin@example.com");

        while (true) {
            System.out.println("1. Add Teacher");
            System.out.println("2. Add Student");
            System.out.println("3. Add Course");
            System.out.println("4. Enroll Student in Course");
            System.out.println("5. Unenroll Student from Course");
            System.out.println("6. Add Lecture to Course");
            System.out.println("7. Mark Attendance");
            System.out.println("8. Display Attendance Report");
            System.out.println("9. Display Eligibility Status");
            System.out.println("10. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Teacher ID: ");
                    String teacherId = scanner.nextLine();
                    System.out.print("Enter Teacher Name: ");
                    String teacherName = scanner.nextLine();
                    System.out.print("Enter Teacher Password: ");
                    String teacherPassword = scanner.nextLine();
                    System.out.print("Enter Teacher Email: ");
                    String teacherEmail = scanner.nextLine();
                    Teacher teacher = new Teacher(teacherId, teacherName, teacherPassword, teacherEmail);
                    admin.addNewTeacher(teacher);
                    System.out.println("Teacher added successfully.");
                    System.out.println();
                    break;
                case 2:
                    System.out.print("Enter Student ID: ");
                    String studentId = scanner.nextLine();
                    System.out.print("Enter Student Name: ");
                    String studentName = scanner.nextLine();
                    System.out.print("Enter Student Password: ");
                    String studentPassword = scanner.nextLine();
                    System.out.print("Enter Student Email: ");
                    String studentEmail = scanner.nextLine();
                    Student student = new Student(studentId, studentName, studentPassword, studentEmail);
                    admin.addNewStudent(student);
                    System.out.println("Student added successfully.");
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Enter Course ID: ");
                    String courseId = scanner.nextLine();
                    System.out.print("Enter Course Name: ");
                    String courseName = scanner.nextLine();
                    System.out.print("Enter Teacher ID: ");
                    String courseTeacher = scanner.nextLine();
                    Course course = new Course(courseId, courseName, courseTeacher);
                    admin.addNewCourse(course);
                    System.out.println("Course added successfully.");
                    System.out.println();
                    break;
                case 4:
                    System.out.print("Enter Student ID: ");
                    String enrollStudentId = scanner.nextLine();
                    System.out.print("Enter Course ID: ");
                    String enrollCourseId = scanner.nextLine();
                    admin.enrollStudentInCourse(enrollStudentId, enrollCourseId);
                    System.out.println("Student enrolled successfully.");
                    System.out.println();
                    break;
                case 5:
                    System.out.print("Enter Student ID: ");
                    String unenrollStudentId = scanner.nextLine();
                    System.out.print("Enter Course ID: ");
                    String unenrollCourseId = scanner.nextLine();
                    admin.unenrollStudentFromCourse(unenrollStudentId, unenrollCourseId);
                    System.out.println("Student unenrolled successfully.");
                    System.out.println();
                    break;
                case 6:
                    System.out.print("Enter Course ID: ");
                    String lectureCourseId = scanner.nextLine();
                    System.out.print("Enter Lecture: ");
                    String lecture = scanner.nextLine();
                    for (Course c : admin.getCourses()) {
                        if (c.getId().equals(lectureCourseId)) {
                            c.addLecture(lecture);
                            System.out.println("Lecture added successfully.");
                        }
                    }
                    System.out.println();
                    break;
                case 7:
                    System.out.print("Enter Course ID: ");
                    String attendanceCourseId = scanner.nextLine();
                    System.out.print("Enter Student ID: ");
                    String attendanceStudentId = scanner.nextLine();
                    for (Course c : admin.getCourses()) {
                        if (c.getId().equals(attendanceCourseId)) {
                            c.markAttendance(attendanceStudentId);
                            System.out.println("Attendance marked successfully.");
                        }
                    }
                    System.out.println();
                    break;
                case 8:
                    System.out.print("Enter Course ID: ");
                    String reportCourseId = scanner.nextLine();
                    for (Course c : admin.getCourses()) {
                        if (c.getId().equals(reportCourseId)) {
                            c.displayAttendanceReport();
                        }
                    }
                    System.out.println();
                    break;
                case 9:
                    System.out.print("Enter Course ID: ");
                    String statusCourseId = scanner.nextLine();
                    System.out.print("Enter Student ID: ");
                    String statusStudentId = scanner.nextLine();
                    for (Course c : admin.getCourses()) {
                        if (c.getId().equals(statusCourseId)) {
                            c.displayEligibilityStatus(statusStudentId);
                        }
                    }
                    System.out.println();
                    break;
                case 10:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
                    System.out.println();
            }
        }
    }
}