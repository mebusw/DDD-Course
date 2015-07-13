package scheduling;

import static org.junit.Assert.*;

import org.junit.*;

import java.util.List;

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
 */
public class CourseTest {

    private Teacher teacher;
    private DateRange dateRange;
    private Course course;
    private CourseRepository repo;

    @Before
    public void setUp() throws Exception {
        teacher = new Teacher("幼幼", "13809878765");
        dateRange = new DateRange("Wednesday", "18:00", "19:30", "2015.02.11", 12);
        course = Course.create("美术预科", "针对2-3岁儿童心理、生理特点以及敏感期的发展特点，从最基础的看、摸、闻、听、尝（视觉、触觉、嗅觉、听觉、味觉）感觉入手，培养孩子最基础的",
                "2～3岁", 3000, "达芬奇", teacher, dateRange);
        repo = new CourseRepository();
        repo.save(course);
    }

    @Test
    public void can_create_a_course() {
        repo.save(course);

        Course storedCourse = repo.find("美术预科");
        assertEquals(course, storedCourse);
    }

    @Test
    public void can_update_a_course() {
        course.fee = 5000;

        repo.save(course);

        Course storedCourse = repo.find("美术预科");
        assertEquals(5000, storedCourse.fee);
    }

    @Test
    public void can_delete_a_course() {
        repo.delete(course);

        Course storedCourse = repo.find("美术预科");
        assertNull(storedCourse);
    }

    @Test
    public void can_find_all_courses() {
        Teacher anotherTeacher = new Teacher("杆子", "18976876567");
        Course anotherCourse = Course.create("书法", "书法的字体结构与笔画线条的教学，培养儿童对中国文化的理解与表达能力。书法是以书法技法学习为途径，通过对汉字艺术造型演化的了解，获得传统文",
                "5～8岁", 2000, "毕加索", anotherTeacher, dateRange);
        repo.save(anotherCourse);

        List<Course> courses = repo.findAll();
        assertEquals(2, courses.size());
    }
    @Test
    public void can_tell_teacher_info() {
        Course storedCourse = repo.find("美术预科");
        assertEquals("幼幼 13809878765", storedCourse.getTeachersAndMobiles());
    }

}