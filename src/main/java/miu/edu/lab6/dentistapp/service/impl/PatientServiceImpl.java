package miu.edu.lab6.dentistapp.service.impl;

import miu.edu.lab6.dentistapp.model.Patient;
import miu.edu.lab6.dentistapp.repository.PatientRepository;
import miu.edu.lab6.dentistapp.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient save(Patient newPatient) {
        return patientRepository.save(newPatient);
    }

    @Override
    public void saveAll(List<Patient> patients) {
      patientRepository.saveAll(patients);
    }

    @Override
    public List<Patient> getAll() {
        return patientRepository.findAll();
    }

    @Override
    public Optional<Patient> getById(Integer patientId) {
        if(patientRepository.existsById(patientId)){
            return patientRepository.findById(patientId);
        }
        throw new RuntimeException("Patient not found");
    }

    @Override
    public void delete(Integer patientId) {
        patientRepository.deleteById(patientId);
    }

    @Override
    public void update(Patient newPatient, Integer patientId) {
        Optional<Patient> patientOptional = getById(patientId);
        if(patientOptional.isPresent()){
            Patient patient = patientOptional.get();

            patient.setAddress(patient.getAddress());
            patient.setAppointments(patient.getAppointments());
            patient.setEmail(patient.getEmail());
            patient.setFirstName(patient.getFirstName());
            patient.setLastName(patient.getLastName());
            patient.setDateOfBirth(patient.getDateOfBirth());
            patient.setPhoneNumber(patient.getPhoneNumber());

            patientRepository.save(patient);
        }
        throw new RuntimeException("Patient not found");
    }
}
