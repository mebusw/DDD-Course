package enrollment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StorageService {
    private static StorageService instance = null;
    private HashMap<String, Course> courses = new HashMap<>();
    private HashMap<String, List> enrollments = new HashMap<>();

    public static synchronized StorageService getInstance() {
        if (instance == null) {
            instance = new StorageService();
        }
        return instance;
    }

    public void saveCourse(Course course) {
        courses.put(course.name, course);
        enrollments.put(course.name, course.enrollments);
    }

    public Course getCourse(String name) {
        return courses.get(name);
    }

    public void saveEnrollment(String courseName, Enrollment enrollment) {
        List<Enrollment> list = enrollments.get(courseName);
        if (list == null) {
            list = new ArrayList<>();
            enrollments.put(courseName, list);
        }
        list.add(enrollment);
    }

    public Enrollment getEnrollment(String courseName, String kidName) {
        List<Enrollment> list = getEnrollments(courseName);
        for (Enrollment enrollment : list) {
            if (enrollment.kidName.equals(kidName)) {
                return enrollment;
            }
        }
        return null;
    }

    public List<Enrollment> getEnrollments(String courseName) {
        List<Enrollment> list = enrollments.get(courseName);
        return list;
    }
}
