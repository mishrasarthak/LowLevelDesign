package Dao;

import Exceptions.DoctorAlreadyExistException;
import Exceptions.DoctorDoesNotExistException;
import Exceptions.NoSpecializationExists;
import Exceptions.SlotNotFoundException;
import Models.AvailableDoctor;
import Models.Doctor;
import Models.Specialization;
import Models.TimeSlot;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DoctorRepository {

    Map<Integer, Doctor> doctorsList = new HashMap<>();
    Map<Specialization, List<Doctor>> specializationDoctorList = new HashMap<>();

    public void registerDoctor(Doctor doctor){
        if(doctorsList.containsKey(doctor.getDoctorId())){
            throw new DoctorAlreadyExistException();
        }
        doctorsList.put(doctor.getDoctorId(), doctor);
        if(!specializationDoctorList.containsKey(doctor.getSpecialization())){
            specializationDoctorList.put(doctor.getSpecialization(), new ArrayList<>());
        }
        specializationDoctorList.get(doctor.getSpecialization()).add(doctor);
    }

    public void addDoctorAvailability(Integer doctorId, TimeSlot timeSlot){
        if(!doctorsList.containsKey(doctorId)){
            throw new DoctorDoesNotExistException();
        }

        Doctor doctor = doctorsList.get(doctorId);
        Map<TimeSlot,Boolean> slots = doctor.getAvailableSlots();

        slots.put(timeSlot,true);
        doctorsList.put(doctorId,doctor);
    }

    public List<Doctor> getDoctorsBySpeciality(Specialization specialization){
        if(!specializationDoctorList.containsKey(specialization)){
            throw new NoSpecializationExists();
        }
        return  specializationDoctorList.get(specialization);
    }

    public List<AvailableDoctor> getAvailableDoctorsBySpecialization(List<Doctor> specializedDoctor){
        List<AvailableDoctor> availableDoctors = new ArrayList<>();

        for(Doctor doctor : specializedDoctor){
            AvailableDoctor availableDoctor = new AvailableDoctor();
            availableDoctor.setDoctor(doctor);
            List<TimeSlot> availableSlots = new ArrayList<>();
            Map<TimeSlot,Boolean> slots  = doctor.getAvailableSlots();

            for(Map.Entry<TimeSlot,Boolean> slotEntry : slots.entrySet()){
                if(slotEntry.getValue()){
                    availableSlots.add(slotEntry.getKey());
                }
            }
            availableDoctor.setSlotList(availableSlots);
            availableDoctors.add(availableDoctor);
        }
        return availableDoctors;
    }

    public boolean isDoctorRegistered(Integer doctorId){
        return doctorsList.containsKey(doctorId);
    }

    public Doctor getDoctorDetails(Integer doctorId){
        return doctorsList.get(doctorId);
    }

    public void freeSlot(Integer doctorId, TimeSlot timeSlot){
        Boolean isSlot = doctorsList.get(doctorId).getAvailableSlots().put(timeSlot,true);
        if(isSlot == null) {
            doctorsList.get(doctorId).getAvailableSlots().remove(timeSlot);
            throw new SlotNotFoundException();
        }
    }

}
