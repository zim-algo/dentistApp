package miu.edu.lab6.dentistapp.repository;

import miu.edu.lab6.dentistapp.model.Patient;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends ListCrudRepository <Patient, Integer>{
}
