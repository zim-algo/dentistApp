package miu.edu.lab6.dentistapp.service.impl;

import miu.edu.lab6.dentistapp.model.Appointment;
import miu.edu.lab6.dentistapp.repository.Appointmentrepository;
import miu.edu.lab6.dentistapp.service.AppointmentService;

import java.util.List;
import java.util.Optional;

public class AppointmentServiceImpl implements AppointmentService {

    private Appointmentrepository appointmentrepository;

    public AppointmentServiceImpl(Appointmentrepository appointmentrepository) {
        this.appointmentrepository = appointmentrepository;
    }

    @Override
    public Appointment save(Appointment newAppointment) {
        return appointmentrepository.save(newAppointment);
    }

    @Override
    public void saveAll(List<Appointment> appointments) {
        appointmentrepository.saveAll(appointments);
    }

    @Override
    public List<Appointment> getAll() {
        return appointmentrepository.findAll();
    }

    @Override
    public Optional<Appointment> getById(Integer appointmentId) {
        if(appointmentrepository.existsById(appointmentId)){
            return appointmentrepository.findById(appointmentId);
        }
        throw new RuntimeException("Appointment not found");
    }

    @Override
    public void delete(Integer appointmentId) {
        appointmentrepository.deleteById(appointmentId);
    }

    @Override
    public void update(Appointment newAppointment, Integer appointmentId) {
        Optional<Appointment> appointmentOptional = getById(appointmentId);
        if(appointmentOptional.isPresent()){
            Appointment appointment = appointmentOptional.get();

            appointment.setDentist(appointment.getDentist());
            appointment.setPatient(appointment.getPatient());
            appointment.setAppointmentDate(appointment.getAppointmentDate());
            appointment.setSurgery(appointment.getSurgery());

            appointmentrepository.save(appointment);
        }
        throw new RuntimeException("Appointment not found");
    }
}
