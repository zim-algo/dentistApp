package miu.edu.lab6.dentistapp;

import miu.edu.lab6.dentistapp.model.*;
import miu.edu.lab6.dentistapp.service.DentistService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication
public class DentistAppApplication implements CommandLineRunner {

    private DentistService dentistService;


    public DentistAppApplication(DentistService dentistService) {
        this.dentistService = dentistService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DentistAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        var newDentist = new Dentist(null, "John", "Doe", "123-456-7890", "john.doe@example.com", "Orthodontics", null);
        var dentist1 = new Dentist(null, "Alice", "Smith", "555-0100", "alice.smith@example.com", "Pedodontics",null);
        var dentist2 = new Dentist(null, "Bob", "Johnson", "555-0101", "bob.johnson@example.com", "Endodontics",null);
        var dentist3 = new Dentist(null, "Charlie", "Williams", "555-0102", "charlie.williams@example.com", "Orthodontics",null);
        var dentist4 = new Dentist(null, "Diana", "Brown", "555-0103", "diana.brown@example.com", "Periodontics",null);
        var dentist5 = new Dentist(null, "Ethan", "Jones", "555-0104", "ethan.jones@example.com", "Prosthodontics",null);

        var address1 = new Address("Gotham", "NY", 10001, "101A");
        var address2 = new Address("Metropolis", "IL", 62960, "202B");
        var address3 = new Address("Central City", "MO", 65101, "303C");
        var address4 = new Address("Star City", "CA", 90001, "404D");
        var address5 = new Address("Coast City", "FL", 33101, "505E");

        var patient1 = new Patient(null, "Jane", "Roe", "555-2222", "jane.roe@example.com", LocalDate.of(1990, 2, 2), address1, null);
        var patient2 = new Patient(3, "Jim", "Beam", "555-3333", "jim.beam@example.com", LocalDate.of(1985, 3, 3), address2, null);
        var patient3 = new Patient(4, "Julia", "Rich", "555-4444", "julia.rich@example.com", LocalDate.of(1995, 4, 4), address3, null);
        var patient4 = new Patient(5, "Jake", "Peralta", "555-5555", "jake.peralta@example.com", LocalDate.of(1988, 5, 5), address4, null);

       // Address address1 = new Address("1234 Medical Plaza", "Gotham", "NY", 10001);
        var surgery1 = new Surgery(null,"Gotham Dental", 5551234, address1, null);

        //Address address2 = new Address("4321 Healing Blvd", "Metropolis", "IL", 62960);
        var surgery2 = new Surgery(null,"Metropolis Orthopedics", 5555678, address2,null);

       // Address address3 = new Address("5678 Care Lane", "Star City", "CA", 90001);
        var surgery3 = new Surgery(null,"Star City Pediatrics", 5559101, address3,null);

        var appointment1 = new Appointment(null, LocalDate.of(1990, 4, 4),patient1,surgery1,dentist1);
        var appointment2 = new Appointment(null, LocalDate.of(1995, 4, 4),patient2,surgery2,dentist2);
        var appointment3 = new Appointment(null, LocalDate.of(2000, 4, 4),patient3,surgery3,dentist3);
        //var appointment1 = new Appointment(null, LocalDate.of(12020, 4, 4),patient4,surgery4,dentist1);


       // dentistService.saveAll(Arrays.asList(dentist1,dentist2));
        dentist1.setAppointments(Arrays.asList(appointment1));
        dentist1 = dentistService.save(dentist1);
        appointment1.setDentist(dentist1);

        //appoimentService.salve(appointment1)


        dentistService.getAll().stream().forEach(System.out::println);




    }
}
