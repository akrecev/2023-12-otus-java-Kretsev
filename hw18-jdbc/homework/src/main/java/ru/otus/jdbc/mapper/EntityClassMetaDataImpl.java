package ru.otus.jdbc.mapper;

import static java.util.function.Predicate.not;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import ru.otus.crm.annotations.Id;

public class EntityClassMetaDataImpl<T> implements EntityClassMetaData<T> {
    // TODO нужно ли выделять поля для передачи данных в entitySQLMetaDataManager?
    // TODO или хватит геттеров, которые берут данные напрямую из clazz?
    private final Class<T> clazz;

    // TODO Возможно ли узнать тип <T> без передачи экземпляра класса в конструктор?
    public EntityClassMetaDataImpl(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public String getName() {
        return clazz.getSimpleName();
    }

    @Override
    public Constructor<T> getConstructor() {
        try {
            var types =
                    Arrays.stream(clazz.getDeclaredFields()).map(Field::getType).toList();
            return clazz.getDeclaredConstructor(types.toArray(Class[]::new));
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Exception getting constructor", e);
        }
    }

    @Override
    public Field getIdField() {
        return Arrays.stream(clazz.getDeclaredFields())
                .filter(f -> f.isAnnotationPresent(Id.class))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Field not found"));
    }

    @Override
    public List<Field> getAllFields() {
        return List.of(clazz.getDeclaredFields());
    }

    @Override
    public List<Field> getFieldsWithoutId() {
        return Arrays.stream(clazz.getDeclaredFields())
                .filter(not(f -> f.isAnnotationPresent(Id.class)))
                .collect(Collectors.toList());
    }
}
