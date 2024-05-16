package ru.otus.jdbc.mapper;

public class EntitySQLMetaDataImpl implements EntitySQLMetaData {
    private final EntityClassMetaData metaData;

    public EntitySQLMetaDataImpl(EntityClassMetaData metaData) {
        this.metaData = metaData;
    }

    @Override
    public String getSelectAllSql() {
        return "";
    }

    @Override
    public String getSelectByIdSql() {
        return "";
    }

    @Override
    public String getInsertSql() {
        return "";
    }

    @Override
    public String getUpdateSql() {
        return "";
    }
}
