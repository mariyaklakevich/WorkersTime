package Entity;

import java.util.Objects;

public class Confluence {

    private WorkTime firstWorkTime;
    private WorkTime secondWorkTime;

    public Confluence(WorkTime firstWorkTime, WorkTime secondWorkTime) {
        this.firstWorkTime = firstWorkTime;
        this.secondWorkTime = secondWorkTime;
    }

    public WorkTime getFirstWorkTime() {
        return firstWorkTime;
    }

    public void setFirstWorkTime(WorkTime firstWorkTime) {
        this.firstWorkTime = firstWorkTime;
    }

    public WorkTime getSecondWorkTime() {
        return secondWorkTime;
    }

    public void setSecondWorkTime(WorkTime secondWorkTime) {
        this.secondWorkTime = secondWorkTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Confluence that = (Confluence) o;
        return Objects.equals(firstWorkTime, that.firstWorkTime) &&
                Objects.equals(secondWorkTime, that.secondWorkTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(firstWorkTime, secondWorkTime);
    }
}
