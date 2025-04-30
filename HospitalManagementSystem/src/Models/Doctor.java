package Models;

import java.util.Map;

public class Doctor {

    Integer doctorId;
    String doctorName;
    Map<TimeSlot, Boolean> availableSlots ;
    Specialization specialization;
    Integer rating;

    public Doctor(Integer doctorId, String doctorName, Map<TimeSlot, Boolean> availableSlots, Specialization specialization, Integer rating) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.availableSlots = availableSlots;
        this.specialization = specialization;
        this.rating = rating;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public Map<TimeSlot, Boolean> getAvailableSlots() {
        return availableSlots;
    }

    public void setAvailableSlots(Map<TimeSlot, Boolean> availableSlots) {
        this.availableSlots = availableSlots;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
