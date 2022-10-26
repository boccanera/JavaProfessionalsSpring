package com.SpringJavaProfessionals.SpringJavaProfessionals.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "First name can not be empty.")
    private String firstName;

    @NotBlank(message = "Last name can not be empty.")
    private String lastName;

    @Past(message = "Date of birth must be in the past.")
    @NotNull(message = "Date of birth must be especified.")
    private LocalDate dateOfBirth;

    @Email(message = "Email must be valid.")
    @NotEmpty(message = "Email must not be empty.")
    private String email;

    @NotNull(message = "Salary must be filled")
    @DecimalMin(value = "1", message = "Must be greater than zero.")
    private BigDecimal salary;

    @NotEmpty
    private String photoFilename;

}
