package enrollment;


public class CourseRepository {
    private StorageService storageService = StorageService.getInstance();

    public CourseRepository() {

    }

    public CourseRepository(StorageService storageService) {
        this.storageService = storageService;

    }

    public Course find(String courseName) {
        Course course = storageService.getCourse(courseName);
        course.enrollments = storageService.getEnrollments(courseName);
        return course;

    }

    public void save(Course course) {
        storageService.saveCourse(course);

    }

}
