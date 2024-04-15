package miu.edu.lab6.dentistapp.service.impl;

import lombok.NoArgsConstructor;
import miu.edu.lab6.dentistapp.model.Appointment;
import miu.edu.lab6.dentistapp.model.Dentist;
import miu.edu.lab6.dentistapp.repository.DentistRepository;
import miu.edu.lab6.dentistapp.service.DentistService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DentistServiceImpl implements DentistService {

    private DentistRepository dentistRepository;

    private DentistServiceImpl(DentistRepository dentistRepository){
        this.dentistRepository = dentistRepository;
    }


    @Override
    public Dentist save(Dentist dentist) {
       return dentistRepository.save(dentist);
    }

    @Override
    public void saveAll(List<Dentist> dentists) {
        dentistRepository.saveAll(dentists);
    }

    @Override
    public List<Dentist> getAll() {
        return dentistRepository.findAll();
    }

    @Override
    public Optional<Dentist> getById(Integer dentistId) {
        if(dentistRepository.existsById(dentistId)){
            return dentistRepository.findById(dentistId);
        }
        throw new RuntimeException("Dentist not found");
    }

    @Override
    public void delete(Integer dentistId) {
        dentistRepository.deleteById(dentistId);
    }

    @Override
    public void update(Dentist newDentist, Integer dentistId) {

        Optional<Dentist> dentistOptional = getById(dentistId);
        if(dentistOptional.isPresent()){
            Dentist dentist = dentistOptional.get();

            dentist.setAppointments(newDentist.getAppointments());
            dentist.setEmail(newDentist.getEmail());

            dentistRepository.save(dentist);
        }
        throw new RuntimeException("Dentist not found");
    }

}

