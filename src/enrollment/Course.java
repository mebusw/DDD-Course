package enrollment;

import scheduling.DateRange;
import scheduling.Teacher;

import java.util.ArrayList;
import java.util.List;

public class Course {
    public long id;
    public String name;
    public List<Enrollment> enrollments;

    public Course(String name) {
        this.name = name;
        this.enrollments = new ArrayList<>();
    }


}
