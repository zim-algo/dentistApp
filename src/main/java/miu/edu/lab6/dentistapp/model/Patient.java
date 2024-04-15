package miu.edu.lab6.dentistapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patientId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private LocalDate dateOfBirth;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;
}
