package ru.otus;

import lombok.extern.slf4j.Slf4j;
import ru.otus.model.Person;

@Slf4j
public class Main {
    public static void main(String[] args) {
        log.debug("Hello world!");

        Person person = Person.builder()
                .firstName("firstName")
                .lastName("lastName")
                .lastName("lastName")
                .build();

        person.toBuilder().firstName("anotherName").build();
        log.debug("Person {}", person);

        person = person.toBuilder().firstName("anotherName").build();
        log.debug("Person {}", person);
    }
}
