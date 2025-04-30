package Models;

public class Booking {
    Integer bookingId;
    Doctor doctor;
    Patient patient;
    TimeSlot timeSlot;
    Boolean waitingList;

    public Booking(Integer bookingId, Doctor doctor, Patient patient, TimeSlot timeSlot)
    {
        this.bookingId = bookingId;
        this.doctor = doctor;
        this.patient = patient;
        this.timeSlot = timeSlot;
        this.waitingList = false;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }

    public Boolean getWaitingList() {
        return waitingList;
    }

    public void setWaitingList(Boolean waitingList) {
        this.waitingList = waitingList;
    }
}
