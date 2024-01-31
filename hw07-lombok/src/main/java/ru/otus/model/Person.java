package ru.otus.model;

import java.time.LocalDate;
import lombok.Value;
import lombok.experimental.NonFinal;
import lombok.experimental.SuperBuilder;

@Value
@NonFinal
@SuperBuilder(toBuilder = true)
public class Person {
    String firstName;
    String lastName;
    LocalDate dateOfBirth;
    String address;
    String telephone;
}
