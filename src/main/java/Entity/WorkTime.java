package Entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

public class WorkTime {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("h:mm");

    private Date startWorkTime;
    private Date endWorkTime;

    public WorkTime(String startTime, String endTime) throws ParseException {
        startWorkTime = simpleDateFormat.parse(startTime);
        endWorkTime = simpleDateFormat.parse(endTime);
    }

    public static SimpleDateFormat getSimpleDateFormat() {
        return simpleDateFormat;
    }

    public static void setSimpleDateFormat(SimpleDateFormat simpleDateFormat) {
        WorkTime.simpleDateFormat = simpleDateFormat;
    }

    public Date getStartWorkTime() {
        return startWorkTime;
    }

    public void setStartWorkTime(Date startWorkTime) {
        this.startWorkTime = startWorkTime;
    }

    public Date getEndWorkTime() {
        return endWorkTime;
    }

    public void setEndWorkTime(Date endWorkTime) {
        this.endWorkTime = endWorkTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkTime workTime = (WorkTime) o;
        return Objects.equals(startWorkTime, workTime.startWorkTime) &&
                Objects.equals(endWorkTime, workTime.endWorkTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(startWorkTime, endWorkTime);
    }

    @Override
    public String toString() {
        return "WorkTime{" +
                "startWorkTime=" + startWorkTime +
                ", endWorkTime=" + endWorkTime +
                '}';
    }
}
