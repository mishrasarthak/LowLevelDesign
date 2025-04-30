package Service;

import Dao.PatientRepository;
import Models.Patient;
import PrintMode.IPrint;

public class PatientService {
    PatientRepository patientRepository;
    IPrint print;

    PatientService(PatientRepository patientRepo, IPrint print){
        this.patientRepository = patientRepo;
        this.print = print;
    }

    public void registerPatient(Patient patient){
        patientRepository.registerPatient(patient);
        print.printData(patient.getPatientName() + "registered successfull");
    }
}
