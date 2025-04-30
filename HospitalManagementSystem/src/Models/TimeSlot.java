package Models;

public class TimeSlot {
    public String startTime;
    public String endTime;

    public TimeSlot(String start, String end){
        this.startTime = start;
        this.endTime = end;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
}
