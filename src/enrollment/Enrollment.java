package enrollment;

/**
 * Created by jacky on 15/7/15.
 */
public class Enrollment {
    public Long id;
    public Long courseId;
    public String kidName;
    public int age;
    public String gender;
    public String guardianName;
    public String guardianMobile;
    public String payTime;
    public int payAmount;

    public Enrollment(String kidName, int age, String gender, String guardianName, String guardianMobile, String payTime, int payAmount) {
        this.kidName = kidName;
        this.age = age;
        this.gender = gender;
        this.guardianName = guardianName;
        this.guardianMobile = guardianMobile;
        this.payTime = payTime;
        this.payAmount = payAmount;
    }


}
