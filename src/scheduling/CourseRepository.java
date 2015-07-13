package scheduling;

/**
 * Created by jacky on 15/7/13.
 */
public class CourseRepository {
    private DataService dataService = DataService.getInstance();
    public CourseRepository() {

    }

    public void save(Course course) {
        dataService.saveCourses(course);
    }

    public Course retrive(String name) {
        return dataService.getCourse(name);
    }
}
