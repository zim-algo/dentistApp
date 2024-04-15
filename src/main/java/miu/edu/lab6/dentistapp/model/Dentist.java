package miu.edu.lab6.dentistapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Dentist")
public class Dentist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String specialization;

    @OneToMany(mappedBy = "dentist")
    private List<Appointment> appointments;

}
