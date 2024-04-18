package miu.edu.lab6.dentistapp.service;

import miu.edu.lab6.dentistapp.model.Appointment;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {

    Appointment save(Appointment newAppointment);
    void saveAll(List<Appointment> appointments);
    List <Appointment> getAll();
    Optional<Appointment> getById(Integer appointmentId);
    void delete(Integer appointmentId);
    void update(Appointment newAppointment, Integer appointmentId);

}
