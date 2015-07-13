package scheduling;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by jacky on 15/7/13.
 */
public class StorageService {
    private static StorageService instance = null;
    private HashMap<String, Course> courses = new HashMap<String, Course>();

    public static synchronized StorageService getInstance() {
        if (instance == null) {
            instance = new StorageService();
        }
        return instance;
    }

    public void saveCourses(Course course) {
        courses.put(course.name, course);
    }

    public Course getCourse(String name) {
        return courses.get(name);
    }

    public void deleteCourses(Course course) {
        courses.remove(course.name);
    }

    public List<Course> findAllCourses() {
        return new ArrayList<Course>(courses.values());
    }
}
