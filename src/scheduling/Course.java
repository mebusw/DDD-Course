package scheduling;

import java.util.Date;

/**
 * Created by jacky on 15/7/13.
 */
public class Course {
    public long id;
    public String name;
    public String desc;
    public int fee;
    public String forAge;
    public String classroom;
    public Teacher teacher;
    public DateRange dateRange;

    public Course(String name, String desc, String forAge, int fee, String classroom, Teacher teacher, DateRange dateRange) {
        this.name = name;
        this.desc = desc;
        this.forAge = forAge;
        this.fee = fee;
        this.classroom = classroom;
        this.teacher = teacher;
        this.dateRange = dateRange;
    }


    public static Course create(String name, String desc, String forAge, int fee, String classroom, Teacher teacher, DateRange dateRange) {
        return new Course(name, desc, forAge, fee, classroom, teacher, dateRange);
    }

    public String getTeachersAndMobiles() {
        return String.format("%s %s", teacher.name, teacher.phone);
    }
}
