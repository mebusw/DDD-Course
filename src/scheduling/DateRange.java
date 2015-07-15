package scheduling;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by jacky on 15/7/13.
 */
public class DateRange {
    private String weekday;
    private String startTime;
    private String endTime;
    private String dateStr;
    public int times;

    public DateRange(String weekday, String startTime, String endTime, String dateStr, int times) {
        this.weekday = weekday;
        this.startTime = startTime;
        this.endTime = endTime;
        this.dateStr = dateStr;
        this.times = times;
    }
    public boolean isOverlappedWith(DateRange other) {
        return true;
    }
}
