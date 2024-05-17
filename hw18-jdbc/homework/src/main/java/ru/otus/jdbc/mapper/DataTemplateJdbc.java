package ru.otus.jdbc.mapper;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import ru.otus.core.repository.DataTemplate;
import ru.otus.core.repository.DataTemplateException;
import ru.otus.core.repository.executor.DbExecutor;

/** Сохратяет объект в базу, читает объект из базы */
@SuppressWarnings("java:S1068")
public class DataTemplateJdbc<T> implements DataTemplate<T> {

    private final DbExecutor dbExecutor;
    private final EntitySQLMetaData entitySQLMetaData;
    private final EntityClassMetaData<?> entityClassMetaData;

    public DataTemplateJdbc(
            DbExecutor dbExecutor, EntitySQLMetaData entitySQLMetaData, EntityClassMetaData<?> entityClassMetaData) {
        this.dbExecutor = dbExecutor;
        this.entitySQLMetaData = entitySQLMetaData;
        this.entityClassMetaData = entityClassMetaData;
    }

    @Override
    public Optional<T> findById(Connection connection, long id) {
        return dbExecutor.executeSelect(connection, entitySQLMetaData.getSelectByIdSql(), List.of(id), resultSet -> {
            try {
                Object entity = entityClassMetaData.getConstructor();
                if (resultSet.next()) {
                    return null;
                }
                return null;
            } catch (SQLException e) {
                throw new DataTemplateException(e);
            }
        } );
    }

    @Override
    public List<T> findAll(Connection connection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public long insert(Connection connection, T client) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(Connection connection, T client) {
        throw new UnsupportedOperationException();
    }
}
