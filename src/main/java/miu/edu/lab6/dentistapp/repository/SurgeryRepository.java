package miu.edu.lab6.dentistapp.repository;

import miu.edu.lab6.dentistapp.model.Surgery;
import org.springframework.data.repository.ListCrudRepository;

public interface SurgeryRepository extends ListCrudRepository<Surgery, Integer> {
}
