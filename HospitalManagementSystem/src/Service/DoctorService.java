package Service;

import Dao.DoctorRepository;
import Models.AvailableDoctor;
import Models.Doctor;
import Models.Specialization;
import Models.TimeSlot;
import PrintMode.IPrint;

import java.util.List;

public class DoctorService {

    DoctorRepository doctorRepo;
    IPrint print;

    public DoctorService(DoctorRepository repo, IPrint print) {
        this.doctorRepo = repo;
        this.print = print;
    }

    public void registerDoctor(Doctor doctor){
        doctorRepo.registerDoctor(doctor);
        print.printData(doctor.getDoctorName() +  "registered successfully");
    }

    public void addDoctorAvailability(Integer doctorId, TimeSlot slot) {
        Doctor doctor = doctorRepo.getDoctorDetails(doctorId);
        if(doctor.getAvailableSlots().get(doctorId)  == false){
            print.printData("Doctor busy at the selected slot");
        }
        doctorRepo.addDoctorAvailability(doctorId,slot);
    }

    public void showAvailableSlotsBySpeciality(Specialization specialization){
        List<Doctor> doctorList = doctorRepo.getDoctorsBySpeciality(specialization);
        List<AvailableDoctor> availableDoctorList = doctorRepo.getAvailableDoctorsBySpecialization(doctorList);

        if(availableDoctorList.size()>0){
            print.printData("Available doctors for the specialization " + specialization);
            for(AvailableDoctor doctor : availableDoctorList){
                for(TimeSlot slot : doctor.getSlotList()){
                    print.printData(doctor.getDoctor().getDoctorName() + " : " +slot.getStartTime()+" - "+slot.getEndTime());
                }
            }
        }
        else{
            print.printData("No slots available");
        }
    }
}
