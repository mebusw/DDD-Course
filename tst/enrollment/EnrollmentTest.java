package enrollment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * 作为赫赫老师,我能创建报名条目,以便接受家长报名某门课程。
 * 作为赫赫老师,我能浏览所创建的报名条目,以便检查是否有错误。
 * 作为赫赫老师,我能修改某条报名条目,以便改正其中的错误。
 * 作为赫赫老师,我能删除某条报名条目,以便清除不需要的报名信息
 * 作为赫赫老师,我能查询报名某门课程的孩⼦子信息,以便查看这些孩⼦子的姓名、性别和年
 * 龄。
 */
public class EnrollmentTest {

    private Course course;
    private CourseRepository repo;

    @Before
    public void setUp() throws Exception {
        course = new Course("美术预科");
        repo = new CourseRepository();
        repo.save(course);
    }

    @Test
    public void can_create_a_enrollment() {
        Enrollment enrollment = new Enrollment("小红", 10, "女", "大力", "13812345678", "2015-07-15", 2500);
        course.enrollments.add(enrollment);
        repo.save(course);

        Course storedCourse = repo.find("美术预科");

        assertEquals(enrollment, storedCourse.enrollments.get(0));
    }

    @Test
    public void can_update_a_enrollment() {
        Enrollment enrollment = new Enrollment("小红", 10, "女", "大力", "13812345678", "2015-07-15", 2500);
        Guardian guardian = enrollment.fetchGuardian();
        assertEquals("大力", guardian.name);

        enrollment.updateGuardian("老刘", "18900000000");
        Guardian guardian2 = enrollment.fetchGuardian();
        assertEquals("老刘", guardian2.name);
        assertNotEquals(guardian, guardian2);
    }

    @Test
    public void can_delete_a_enrollment() {
    }

    @Test
    public void can_get_contact_info_of_a_enrollment() {
    }

}