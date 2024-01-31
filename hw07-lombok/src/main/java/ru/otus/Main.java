package ru.otus;

import java.io.File;
import java.io.FileInputStream;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import ru.otus.model.Person;

@Slf4j
public class Main {
    @SneakyThrows
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

        val file = new File("not_existing_file.txt");
        try (FileInputStream stream = new FileInputStream(file)) {
            log.debug("Stream {}", stream);
        }
    }
}
