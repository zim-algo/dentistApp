package miu.edu.lab6.dentistapp.repository;

import miu.edu.lab6.dentistapp.model.Appointment;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface Appointmentrepository extends ListCrudRepository<Appointment, Integer> {
}
