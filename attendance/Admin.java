package attendance;

import java.util.ArrayList;

public class Admin {
    private String id;
    private String name;
    private String password;
    private String email;
    private ArrayList<Teacher> teachers;
    private ArrayList<Student> students;
    private ArrayList<Course> courses;
    private ArrayList<Admin> admins;

    public Admin(String id, String name, String password, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.teachers = new ArrayList<>();
        this.students = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.admins = new ArrayList<>();
    }

    // Add New Teacher
    public void addNewTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    // Modify Teacher
    public void modifyTeacher(String id, Teacher updatedTeacher) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId().equals(id)) {
                teachers.set(i, updatedTeacher);
                break;
            }
        }
    }

    // Remove Teacher
    public void removeTeacher(String id) {
        teachers.removeIf(teacher -> teacher.getId().equals(id));
    }

    // Add New Student
    public void addNewStudent(Student student) {
        students.add(student);
    }

    // Modify Student
    public void modifyStudent(String id, Student updatedStudent) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(id)) {
                students.set(i, updatedStudent);
                break;
            }
        }
    }

    // Remove Student
    public void removeStudent(String id) {
        students.removeIf(student -> student.getId().equals(id));
    }

    // Add New Admin
    public void addNewAdmin(Admin admin) {
        admins.add(admin);
    }

    // Modify Admin
    public void modifyAdmin(String id, Admin updatedAdmin) {
        for (int i = 0; i < admins.size(); i++) {
            if (admins.get(i).id.equals(id)) {
                admins.set(i, updatedAdmin);
                break;
            }
        }
    }

    // Remove Admin
    public void removeAdmin(String id) {
        admins.removeIf(admin -> admin.id.equals(id));
    }

    // Add New Course
    public void addNewCourse(Course course) {
        courses.add(course);
    }

    // Modify Course
    public void modifyCourse(String id, Course updatedCourse) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId().equals(id)) {
                courses.set(i, updatedCourse);
                break;
            }
        }
    }

    // Enroll Students in Course
    public void enrollStudentInCourse(String studentId, String courseId) {
        Student student = null;
        for (Student s : students) {
            if (s.getId().equals(studentId)) {
                student = s;
                break;
            }
        }

        for (Course course : courses) {
            if (course.getId().equals(courseId)) {
                if (student != null) {
                    course.enrollStudent(student);
                }
                break;
            }
        }
    }

    // Unenroll Students from Course
    public void unenrollStudentFromCourse(String studentId, String courseId) {
        for (Course course : courses) {
            if (course.getId().equals(courseId)) {
                course.unenrollStudent(studentId);
                break;
            }
        }
    }

    // Get list of courses
    public ArrayList<Course> getCourses() {
        return courses;
    }
}