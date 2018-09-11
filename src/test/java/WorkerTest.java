import Entity.WorkTime;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class WorkerTest {

    private List<WorkTime> workTimes = new ArrayList<>();

    @Before
    public void setUp() throws ParseException {
        workTimes.add(new WorkTime("08:00", "09:07"));
        workTimes.add(new WorkTime("08:20", "09:30"));
    }

    @Test
    public void getConfluencesCount() {
        int count = Worker.getConfluencesCount(workTimes);
        assertEquals(Worker.getConfluencesCount(workTimes), count);
        assertEquals(2, Worker.getConfluencesCount(workTimes));
    }
}