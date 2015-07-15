package scheduling;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class DateRangeTest {
    private DateRange dateRange;

    @Before
    public void setUp() throws Exception {
        dateRange = new DateRange("Wed", "9:00", "11:00", "2015-07-15", 10);
    }

    @Test
    public void overlapped_with_another() {
        DateRange another = new DateRange("Wed", "10:00", "15:00", "2015-07-15", 10);
        assertTrue(dateRange.isOverlappedWith(another));
    }


}