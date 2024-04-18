package miu.edu.lab6.dentistapp.service;

import miu.edu.lab6.dentistapp.model.Patient;
import java.util.List;
import java.util.Optional;

public interface PatientService {

   Patient save(Patient patient);
   void saveAll(List<Patient> patients);
   List <Patient> getAll();
   Optional<Patient> getById(Integer patientId);
   void delete(Integer patientId);
   void update(Patient newPatient, Integer patientId);

}
