package Dao;

import Exceptions.PatientAlreadyExistException;
import Models.Patient;

import java.util.HashMap;
import java.util.Map;

public class PatientRepository {
    Map<Integer, Patient> patientList = new HashMap<>();

    public void registerPatient(Patient patient){
        if(patientList.containsKey(patient.getPatientId())){
            throw new PatientAlreadyExistException();
        }
        patientList.put(patient.getPatientId(), patient);
    }

    public boolean isPatientRegistered(Integer patientId){
        return patientList.containsKey(patientId);
    }
}
