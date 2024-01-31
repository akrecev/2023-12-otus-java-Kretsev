package ru.otus.model;

import java.time.LocalDate;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder(toBuilder = true)
public class Person {
    String firstName;
    String lastName;
    LocalDate dateOfBirth;
    String address;
    String telephone;
}
