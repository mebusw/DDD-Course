package scheduling;

import java.util.List;

/**
 * Created by jacky on 15/7/13.
 */
public class CourseRepository {
    private StorageService storageService = StorageService.getInstance();
    public CourseRepository() {

    }

    public void save(Course course) {
        storageService.saveCourses(course);
    }

    public Course find(String name) {
        return storageService.getCourse(name);
    }

    public void delete(Course course) {
        storageService.deleteCourses(course);
    }

    public List<Course> findAll() {
        return storageService.findAllCourses();
    }
}
