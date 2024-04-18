package miu.edu.lab6.dentistapp.service.impl;

import miu.edu.lab6.dentistapp.model.Surgery;
import miu.edu.lab6.dentistapp.repository.SurgeryRepository;
import miu.edu.lab6.dentistapp.service.SurgeryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurgeryServiceImpl implements SurgeryService {

    private SurgeryRepository surgeryRepository;

    public SurgeryServiceImpl(SurgeryRepository surgeryRepository) {
        this.surgeryRepository = surgeryRepository;
    }


    @Override
    public Surgery save(Surgery surgery) {
        return surgeryRepository.save(surgery);
    }

    @Override
    public void saveAll(List<Surgery> surgeryList) {
        surgeryRepository.saveAll(surgeryList);
    }

    @Override
    public List<Surgery> getAll() {
        return surgeryRepository.findAll();
    }

    @Override
    public Optional<Surgery> getById(Integer surgeryId) {
        if(surgeryRepository.existsById(surgeryId)){
            return surgeryRepository.findById(surgeryId);
        }
        throw new RuntimeException("Surgery not found");
    }

    @Override
    public void delete(Integer surgeryId) {
        surgeryRepository.deleteById(surgeryId);
    }

    @Override
    public void update(Surgery newSurgery, Integer surgeryId) {

        Optional<Surgery> surgeryOptional = getById(surgeryId);
        if(surgeryOptional.isPresent()){
            Surgery surgery = surgeryOptional.get();

            surgery.setSurgeryName(surgery.getSurgeryName());
            surgery.setAppointments(surgery.getAppointments());
            surgery.setAddress(surgery.getAddress());
            surgery.setPhoneNumber(surgery.getPhoneNumber());

            surgeryRepository.save(surgery);
        }
        throw  new RuntimeException("Surgery not found");
    }
}
