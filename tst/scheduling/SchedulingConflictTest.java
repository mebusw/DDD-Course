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
 * Created by jacky on 15/7/13.
 * 作为赫赫老师,我能创建课程,以便向家长发布课程信息。
 * 作为赫赫老师,我能浏览所创建的课程,以便检查是否有错误。
 * 作为赫赫老师,我能修改某门课程,以便改正其中的错误。
 * 作为赫赫老师,我能删除某门课程,以便清除不需要的课程信息
 * 作为赫赫老师,我能查询某门课程,以便查看该课程的截⾄至日期、 老师、教室、费用、课程描述、适合⼉儿童年龄等信息。
 * <p/>
 * 作为赫赫老师,我能创建报名条目,以便接受家长报名某门课程。
 * 作为赫赫老师,我能浏览所创建的报名条目,以便检查是否有错误。
 * 作为赫赫老师,我能修改某条报名条目,以便改正其中的错误。
 * 作为赫赫老师,我能删除某条报名条目,以便清除不需要的报名信息
 * 作为赫赫老师,我能查询报名某门课程的孩⼦子信息,以便查看这些孩⼦子的姓名、性别和年
 * 龄。
 * 作为赫赫老师,我能查询报名某门课程的某个孩⼦子的家长信息,以便能知道该家长与孩⼦子
 * 的关系及⼿手机号码来打电话进⾏行联系。
 * 作为赫赫老师,我能查询报名某门课程的某个孩⼦子的付费信息,以便能知道该孩⼦子的家长
 * 何时缴纳了多少学费。
 * <p/>
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