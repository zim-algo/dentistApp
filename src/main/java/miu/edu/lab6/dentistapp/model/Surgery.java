package miu.edu.lab6.dentistapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "surgeries")
public class Surgery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer surgeryId;
    private String surgeryName;
    private Integer phoneNumber;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "surgery")
    private List<Appointment> appointments;
}
