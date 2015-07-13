package scheduling;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by jacky on 15/7/13.
 */
public class Schedule {
    private List<Course> courses = new ArrayList<Course>();
    private List<Course> conflictCourses = new ArrayList<Course>();


    public void add(Course course) {
        for (Course c : courses) {
            if (c.classroom.equals(course.classroom)) {
                conflictCourses.add(c);
                conflictCourses.add(course);
                System.out.print(conflictCourses);
                break;
            }
        }
        courses.add(course);
    }

    public List<Course> getConflictCourses() {
        return conflictCourses;
    }
}
