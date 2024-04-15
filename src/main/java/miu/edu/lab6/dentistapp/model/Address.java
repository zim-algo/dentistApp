package miu.edu.lab6.dentistapp.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Address {


    private String city;
    private String state;
    private Integer zip;
    private String houseNumber;

}
