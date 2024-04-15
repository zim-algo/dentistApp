package miu.edu.lab6.dentistapp.repository;

import miu.edu.lab6.dentistapp.model.Dentist;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DentistRepository extends ListCrudRepository<Dentist, Integer> {
}
