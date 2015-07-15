package scheduling;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * 作为赫赫老师,我能发现在同一上课时间,同⼀教室被安排了两门课,便于发现冲突进⾏行调整。
 * 作为赫赫老师,我能发现在同⼀上课时间,同一老师被安排了两门课,便于发现冲突进⾏行调整。
 */
public class SchedulingConflictTest {

    private Teacher teacher;
    private DateRange dateRange;
    private Course course;
    private CourseRepository repo;

    @Test
    public void should_list_out_two_courses_with_same_classroom() {
        DateRange dateRange = new DateRange("Wednesday", "18:00", "19:30", "2015.02.11", 12);
        Teacher teacher1 = new Teacher("幼幼", "13809878765");
        Teacher teacher2 = new Teacher("杆子", "18976876567");
        Course course1 = Course.create("美术预科", "针对2-3岁儿童心理、生理特点以及敏感期的发展特点，从最基础的看、摸、闻、听、尝（视觉、触觉、嗅觉、听觉、味觉）感觉入手，培养孩子最基础的",
                "2～3岁", 3000, "小黑屋", teacher1, dateRange);
        Course course2 = Course.create("书法", "书法的字体结构与笔画线条的教学，培养儿童对中国文化的理解与表达能力。书法是以书法技法学习为途径，通过对汉字艺术造型演化的了解，获得传统文",
                "5～8岁", 2000, "小黑屋", teacher2, dateRange);
        Schedule schedule = new Schedule();

        schedule.add(course1);
        schedule.add(course2);

        assertEquals(2, schedule.getConflictCourses().size());
    }

    @Test
    public void lambda() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        Predicate<Course> fn = x -> x.name == "";
        Predicate<Course> allDrivers = p -> p.fee >= 16;
        list.forEach((Integer x) -> System.out.println(x+10));
    }
}