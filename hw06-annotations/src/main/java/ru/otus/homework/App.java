package ru.otus.homework;

import lombok.extern.slf4j.Slf4j;
import ru.otus.homework.framework.TestFramework;

@Slf4j
class App {
    public static void main(String[] args) throws ClassNotFoundException {
        log.debug("Starting application...");

        TestFramework testFramework = new TestFramework("ru.otus.homework.test.UserServiceTest");
        testFramework.runTest();
    }
}
