package miu.edu.lab6.dentistapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer appointmentId;
    private LocalDate appointmentDate;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name= "surgery_id")
    private Surgery surgery;

    @ManyToOne
    @JoinColumn(name = "dentist_id")
    private Dentist dentist;
}
