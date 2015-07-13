package scheduling;

import java.util.HashMap;

/**
 * Created by jacky on 15/7/13.
 */
public class DataService {
    private static DataService instance = null;
    private HashMap<String, Course> courses = new HashMap<String, Course>();

    public static synchronized DataService getInstance() {
        if (instance == null) {
            instance = new DataService();
        }
        return instance;
    }

    public void saveCourses(Course course) {
        courses.put(course.name, course);
    }

    public Course getCourse(String name) {
        return courses.get(name);
    }
}
