package Service;

import Dao.DoctorRepository;
import Dao.PatientRepository;
import Models.Booking;
import Models.Doctor;
import Models.Patient;
import Models.TimeSlot;
import PrintMode.IPrint;

import java.util.*;

public class BookingService {
    DoctorRepository doctorRepository;
    PatientRepository patientRepository;
    IPrint print;

    Map<Integer, Booking> bookings = new HashMap<>();
    Map<Integer , List<TimeSlot>> patientSlots = new HashMap<>();
    Queue<Booking> waitingListQueue = new LinkedList<>();

    static int uid = 1;

    public BookingService(DoctorRepository doctorRepository, PatientRepository patientRepository,
                          IPrint print){
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    public void bookAppointment(Patient patient, Doctor doctor, String fromTime){
        if(!patientRepository.isPatientRegistered(patient.getPatientId())){
            throw new RuntimeException("Patient not registered");
        }
        if(!doctorRepository.isDoctorRegistered(doctor.getDoctorId())){
            throw new RuntimeException("Doctor not registered");
        }

        //Check if patient already booked for that slot
        if(patientSlots.containsKey(patient.getPatientId())) {
            for(TimeSlot slot : patientSlots.get(patient.getPatientId())){
                if(slot.getStartTime().equals(fromTime)){
                    throw new RuntimeException("Patient already booked for the selected time");
                }
            }
        }
        else{
            patientSlots.put(patient.getPatientId(),new ArrayList<>());
        }

        // check if doctor available for the time slot
        Doctor doctorDetails = doctorRepository.getDoctorDetails(doctor.getDoctorId());

        Map<TimeSlot, Boolean>  availableDoctorSlots= doctorDetails.getAvailableSlots();

        for(Map.Entry<TimeSlot,Boolean> timeslot : availableDoctorSlots.entrySet()){
            if(timeslot.getKey().getStartTime().equals(fromTime) &&
            timeslot.getValue()){
                availableDoctorSlots.put(timeslot.getKey(), false);
                patientSlots.get(patient.getPatientId()).add(timeslot.getKey());

                Booking booking = new Booking(uid++, doctor, patient, timeslot.getKey());
                bookings.put(booking.getBookingId(), booking);
                print.printData("Appointment booked : " + booking.getBookingId());
                return;
            }
        }

        print.printData("No slots available!");
        Booking booking = new Booking(uid++, doctor, patient, new TimeSlot(fromTime,fromTime));
        booking.setWaitingList(true);
        print.printData("Added to waiting list : " + booking.getBookingId());
        waitingListQueue.add(booking);

    }

}
