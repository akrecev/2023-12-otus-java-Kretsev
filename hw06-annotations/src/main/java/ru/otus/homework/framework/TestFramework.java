package ru.otus.homework.framework;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import ru.otus.homework.annotations.After;
import ru.otus.homework.annotations.Before;
import ru.otus.homework.annotations.Test;
import ru.otus.reflection.ReflectionHelper;

@Slf4j
public class TestFramework {
    private final Class<?> clazz;
    private final List<Method> beforeMethodList = new LinkedList<>();
    private final List<Method> testMethodList = new LinkedList<>();
    private final List<Method> afterMethodList = new LinkedList<>();
    private int passed;
    private int failed;

    public TestFramework(String className) throws ClassNotFoundException {
        this.clazz = Class.forName(className);
    }

    public void runTest() {
        getMethods();

        for (Method method : testMethodList) {
            executeTestMethod(method);
        }
        log.debug("Tests passed: {}, tests failed: {}, total: {}", passed, failed, passed + failed);
    }

    private void getMethods() {
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Before.class)) {
                beforeMethodList.add(method);
            } else if (method.isAnnotationPresent(Test.class)) {
                testMethodList.add(method);
            } else if (method.isAnnotationPresent(After.class)) {
                afterMethodList.add(method);
            }
        }
    }

    private void executeTestMethod(Method testMethod) {
        Object testingEntity = ReflectionHelper.instantiate(clazz);

        try {
            beforeMethodList.forEach(method -> ReflectionHelper.callMethod(testingEntity, method.getName()));
            ReflectionHelper.callMethod(testingEntity, testMethod.getName());
            passed++;

            log.debug("execute method: {}", testMethod.getName());

        } catch (Exception e) {
            failed++;

            log.debug("failed method: {}", testMethod.getName());

        } finally {
            afterMethodList.forEach(method -> ReflectionHelper.callMethod(testingEntity, method.getName()));
        }
    }
}
