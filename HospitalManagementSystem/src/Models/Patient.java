package Models;

import java.util.List;
import java.util.Map;

public class Patient {
    Integer patientId;
    String patientName;
    Map<Doctor, List<TimeSlot>> bookedSlots;


    public Patient(Integer patientId,  String patientName){
        this.patientId = patientId;
        this.patientName = patientName;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Map<Doctor, List<TimeSlot>> getBookedSlots() {
        return bookedSlots;
    }

    public void setBookedSlots(Map<Doctor, List<TimeSlot>> bookedSlots) {
        this.bookedSlots = bookedSlots;
    }
}
