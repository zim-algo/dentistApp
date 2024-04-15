package miu.edu.lab6.dentistapp.service;

import miu.edu.lab6.dentistapp.model.Appointment;
import miu.edu.lab6.dentistapp.model.Dentist;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface DentistService {

    Dentist save(Dentist dentist);
    void saveAll(List<Dentist> dentists);
    List<Dentist> getAll();
    Optional<Dentist> getById(Integer dentistId);
    void delete(Integer dentistId);
    void update(Dentist newDentist, Integer dentistId);



}
