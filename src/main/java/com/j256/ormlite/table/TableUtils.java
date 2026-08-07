package com.j256.ormlite.table;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.stmt.StatementBuilder;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.DatabaseResults;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public class TableUtils {
    private static Logger logger = LoggerFactory.getLogger((Class<?>) TableUtils.class);
    private static final FieldType[] noFieldTypes = new FieldType[0];

    private TableUtils() {
    }

    public static <T> int createTable(ConnectionSource connectionSource, Class<T> cls) throws SQLException {
        return createTable(connectionSource, (Class) cls, false);
    }

    public static <T> int createTableIfNotExists(ConnectionSource connectionSource, Class<T> cls) throws SQLException {
        return createTable(connectionSource, (Class) cls, true);
    }

    public static <T> int createTable(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig) throws SQLException {
        return createTable(connectionSource, (DatabaseTableConfig) databaseTableConfig, false);
    }

    public static <T> int createTableIfNotExists(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig) throws SQLException {
        return createTable(connectionSource, (DatabaseTableConfig) databaseTableConfig, true);
    }

    public static <T, ID> List<String> getCreateTableStatements(ConnectionSource connectionSource, Class<T> cls) throws SQLException {
        Dao daoCreateDao = DaoManager.createDao(connectionSource, cls);
        if (daoCreateDao instanceof BaseDaoImpl) {
            return addCreateTableStatements(connectionSource, ((BaseDaoImpl) daoCreateDao).getTableInfo(), false);
        }
        return addCreateTableStatements(connectionSource, new TableInfo(connectionSource, (BaseDaoImpl) null, cls), false);
    }

    public static <T, ID> List<String> getCreateTableStatements(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig) throws SQLException {
        Dao daoCreateDao = DaoManager.createDao(connectionSource, databaseTableConfig);
        if (daoCreateDao instanceof BaseDaoImpl) {
            return addCreateTableStatements(connectionSource, ((BaseDaoImpl) daoCreateDao).getTableInfo(), false);
        }
        databaseTableConfig.extractFieldTypes(connectionSource);
        return addCreateTableStatements(connectionSource, new TableInfo(connectionSource.getDatabaseType(), (BaseDaoImpl) null, databaseTableConfig), false);
    }

    public static <T, ID> int dropTable(ConnectionSource connectionSource, Class<T> cls, boolean z) throws SQLException {
        DatabaseType databaseType = connectionSource.getDatabaseType();
        Dao daoCreateDao = DaoManager.createDao(connectionSource, cls);
        if (daoCreateDao instanceof BaseDaoImpl) {
            return doDropTable(databaseType, connectionSource, ((BaseDaoImpl) daoCreateDao).getTableInfo(), z);
        }
        return doDropTable(databaseType, connectionSource, new TableInfo(connectionSource, (BaseDaoImpl) null, cls), z);
    }

    public static <T, ID> int dropTable(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig, boolean z) throws SQLException {
        DatabaseType databaseType = connectionSource.getDatabaseType();
        Dao daoCreateDao = DaoManager.createDao(connectionSource, databaseTableConfig);
        if (daoCreateDao instanceof BaseDaoImpl) {
            return doDropTable(databaseType, connectionSource, ((BaseDaoImpl) daoCreateDao).getTableInfo(), z);
        }
        databaseTableConfig.extractFieldTypes(connectionSource);
        return doDropTable(databaseType, connectionSource, new TableInfo(databaseType, (BaseDaoImpl) null, databaseTableConfig), z);
    }

    public static <T> int clearTable(ConnectionSource connectionSource, Class<T> cls) throws SQLException {
        String strExtractTableName = DatabaseTableConfig.extractTableName(cls);
        if (connectionSource.getDatabaseType().isEntityNamesMustBeUpCase()) {
            strExtractTableName = strExtractTableName.toUpperCase();
        }
        return clearTable(connectionSource, strExtractTableName);
    }

    public static <T> int clearTable(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig) throws SQLException {
        return clearTable(connectionSource, databaseTableConfig.getTableName());
    }

    private static <T, ID> int createTable(ConnectionSource connectionSource, Class<T> cls, boolean z) throws SQLException {
        Dao daoCreateDao = DaoManager.createDao(connectionSource, cls);
        if (daoCreateDao instanceof BaseDaoImpl) {
            return doCreateTable(connectionSource, ((BaseDaoImpl) daoCreateDao).getTableInfo(), z);
        }
        return doCreateTable(connectionSource, new TableInfo(connectionSource, (BaseDaoImpl) null, cls), z);
    }

    private static <T, ID> int createTable(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig, boolean z) throws SQLException {
        Dao daoCreateDao = DaoManager.createDao(connectionSource, databaseTableConfig);
        if (daoCreateDao instanceof BaseDaoImpl) {
            return doCreateTable(connectionSource, ((BaseDaoImpl) daoCreateDao).getTableInfo(), z);
        }
        databaseTableConfig.extractFieldTypes(connectionSource);
        return doCreateTable(connectionSource, new TableInfo(connectionSource.getDatabaseType(), (BaseDaoImpl) null, databaseTableConfig), z);
    }

    private static <T> int clearTable(ConnectionSource connectionSource, String str) throws SQLException {
        DatabaseType databaseType = connectionSource.getDatabaseType();
        StringBuilder sb = new StringBuilder(48);
        if (databaseType.isTruncateSupported()) {
            sb.append("TRUNCATE TABLE ");
        } else {
            sb.append("DELETE FROM ");
        }
        databaseType.appendEscapedEntityName(sb, str);
        String string = sb.toString();
        logger.info("clearing table '{}' with '{}", str, string);
        DatabaseConnection readWriteConnection = connectionSource.getReadWriteConnection();
        CompiledStatement compiledStatementCompileStatement = null;
        try {
            compiledStatementCompileStatement = readWriteConnection.compileStatement(string, StatementBuilder.StatementType.EXECUTE, noFieldTypes);
            return compiledStatementCompileStatement.runExecute();
        } finally {
            if (compiledStatementCompileStatement != null) {
                compiledStatementCompileStatement.close();
            }
            connectionSource.releaseConnection(readWriteConnection);
        }
    }

    private static <T, ID> int doDropTable(DatabaseType databaseType, ConnectionSource connectionSource, TableInfo<T, ID> tableInfo, boolean z) throws SQLException {
        logger.info("dropping table '{}'", tableInfo.getTableName());
        ArrayList arrayList = new ArrayList();
        addDropIndexStatements(databaseType, tableInfo, arrayList);
        addDropTableStatements(databaseType, tableInfo, arrayList);
        DatabaseConnection readWriteConnection = connectionSource.getReadWriteConnection();
        try {
            return doStatements(readWriteConnection, "drop", arrayList, z, databaseType.isCreateTableReturnsNegative(), false);
        } finally {
            connectionSource.releaseConnection(readWriteConnection);
        }
    }

    private static <T, ID> void addDropIndexStatements(DatabaseType databaseType, TableInfo<T, ID> tableInfo, List<String> list) {
        HashSet<String> hashSet = new HashSet();
        for (FieldType fieldType : tableInfo.getFieldTypes()) {
            String indexName = fieldType.getIndexName();
            if (indexName != null) {
                hashSet.add(indexName);
            }
            String uniqueIndexName = fieldType.getUniqueIndexName();
            if (uniqueIndexName != null) {
                hashSet.add(uniqueIndexName);
            }
        }
        StringBuilder sb = new StringBuilder(48);
        for (String str : hashSet) {
            logger.info("dropping index '{}' for table '{}", str, tableInfo.getTableName());
            sb.append("DROP INDEX ");
            databaseType.appendEscapedEntityName(sb, str);
            list.add(sb.toString());
            sb.setLength(0);
        }
    }

    private static <T, ID> void addCreateTableStatements(DatabaseType databaseType, TableInfo<T, ID> tableInfo, List<String> list, List<String> list2, boolean z) throws SQLException {
        boolean z2;
        StringBuilder sb;
        ArrayList arrayList;
        StringBuilder sb2 = new StringBuilder(256);
        sb2.append("CREATE TABLE ");
        if (z && databaseType.isCreateIfNotExistsSupported()) {
            sb2.append("IF NOT EXISTS ");
        }
        databaseType.appendEscapedEntityName(sb2, tableInfo.getTableName());
        sb2.append(" (");
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        FieldType[] fieldTypes = tableInfo.getFieldTypes();
        int length = fieldTypes.length;
        int i = 0;
        boolean z3 = true;
        while (i < length) {
            ArrayList arrayList5 = arrayList3;
            FieldType fieldType = fieldTypes[i];
            if (fieldType.isForeignCollection()) {
                ArrayList arrayList6 = arrayList4;
                sb = sb2;
                arrayList2 = arrayList2;
                arrayList = arrayList6;
                arrayList3 = arrayList5;
            } else {
                if (z3) {
                    z2 = false;
                } else {
                    sb2.append(", ");
                    z2 = z3;
                }
                String columnDefinition = fieldType.getColumnDefinition();
                if (columnDefinition == null) {
                    databaseType.appendColumnArg(tableInfo.getTableName(), sb2, fieldType, arrayList2, arrayList5, arrayList4, list2);
                    ArrayList arrayList7 = arrayList4;
                    sb = sb2;
                    arrayList = arrayList7;
                    arrayList3 = arrayList5;
                } else {
                    ArrayList arrayList8 = arrayList4;
                    sb = sb2;
                    arrayList = arrayList8;
                    arrayList3 = arrayList5;
                    databaseType.appendEscapedEntityName(sb, fieldType.getColumnName());
                    sb.append(' ').append(columnDefinition).append(' ');
                }
                z3 = z2;
            }
            i++;
            ArrayList arrayList9 = arrayList;
            arrayList2 = arrayList2;
            sb2 = sb;
            arrayList4 = arrayList9;
        }
        ArrayList arrayList10 = arrayList4;
        StringBuilder sb3 = sb2;
        ArrayList arrayList11 = arrayList2;
        databaseType.addPrimaryKeySql(tableInfo.getFieldTypes(), arrayList11, arrayList3, arrayList10, list2);
        databaseType.addUniqueComboSql(tableInfo.getFieldTypes(), arrayList11, arrayList3, arrayList10, list2);
        Iterator<String> it = arrayList11.iterator();
        while (it.hasNext()) {
            sb3.append(", ").append(it.next());
        }
        sb3.append(") ");
        databaseType.appendCreateTableSuffix(sb3);
        list.addAll(arrayList3);
        list.add(sb3.toString());
        list.addAll(arrayList10);
        addCreateIndexStatements(databaseType, tableInfo, list, z, false);
        addCreateIndexStatements(databaseType, tableInfo, list, z, true);
    }

    private static <T, ID> void addCreateIndexStatements(DatabaseType databaseType, TableInfo<T, ID> tableInfo, List<String> list, boolean z, boolean z2) {
        String indexName;
        HashMap map = new HashMap();
        for (FieldType fieldType : tableInfo.getFieldTypes()) {
            if (z2) {
                indexName = fieldType.getUniqueIndexName();
            } else {
                indexName = fieldType.getIndexName();
            }
            if (indexName != null) {
                List arrayList = (List) map.get(indexName);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    map.put(indexName, arrayList);
                }
                arrayList.add(fieldType.getColumnName());
            }
        }
        StringBuilder sb = new StringBuilder(128);
        for (Map.Entry entry : map.entrySet()) {
            logger.info("creating index '{}' for table '{}", entry.getKey(), tableInfo.getTableName());
            sb.append("CREATE ");
            if (z2) {
                sb.append("UNIQUE ");
            }
            sb.append("INDEX ");
            if (z && databaseType.isCreateIndexIfNotExistsSupported()) {
                sb.append("IF NOT EXISTS ");
            }
            databaseType.appendEscapedEntityName(sb, (String) entry.getKey());
            sb.append(" ON ");
            databaseType.appendEscapedEntityName(sb, tableInfo.getTableName());
            sb.append(" ( ");
            boolean z3 = true;
            for (String str : (List) entry.getValue()) {
                if (z3) {
                    z3 = false;
                } else {
                    sb.append(", ");
                }
                databaseType.appendEscapedEntityName(sb, str);
            }
            sb.append(" )");
            list.add(sb.toString());
            sb.setLength(0);
        }
    }

    private static <T, ID> void addDropTableStatements(DatabaseType databaseType, TableInfo<T, ID> tableInfo, List<String> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (FieldType fieldType : tableInfo.getFieldTypes()) {
            databaseType.dropColumnArg(fieldType, arrayList, arrayList2);
        }
        StringBuilder sb = new StringBuilder(64);
        sb.append("DROP TABLE ");
        databaseType.appendEscapedEntityName(sb, tableInfo.getTableName());
        sb.append(' ');
        list.addAll(arrayList);
        list.add(sb.toString());
        list.addAll(arrayList2);
    }

    private static <T, ID> int doCreateTable(ConnectionSource connectionSource, TableInfo<T, ID> tableInfo, boolean z) throws SQLException {
        DatabaseType databaseType = connectionSource.getDatabaseType();
        logger.info("creating table '{}'", tableInfo.getTableName());
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        addCreateTableStatements(databaseType, tableInfo, arrayList, arrayList2, z);
        DatabaseConnection readWriteConnection = connectionSource.getReadWriteConnection();
        try {
            return doStatements(readWriteConnection, PasskeyWebListener.CREATE_UNIQUE_KEY, arrayList, false, databaseType.isCreateTableReturnsNegative(), databaseType.isCreateTableReturnsZero()) + doCreateTestQueries(readWriteConnection, databaseType, arrayList2);
        } finally {
            connectionSource.releaseConnection(readWriteConnection);
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0045 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:25:0x006d  */
    /* JADX WARN: Code duplicated, block: B:44:0x0048 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:47:0x0091 A[SYNTHETIC] */
    private static int doStatements(DatabaseConnection databaseConnection, String str, Collection<String> collection, boolean z, boolean z2, boolean z3) throws SQLException {
        int iRunExecute;
        int i = 0;
        for (String str2 : collection) {
            CompiledStatement compiledStatementCompileStatement = null;
            try {
                try {
                    compiledStatementCompileStatement = databaseConnection.compileStatement(str2, StatementBuilder.StatementType.EXECUTE, noFieldTypes);
                    iRunExecute = compiledStatementCompileStatement.runExecute();
                    try {
                        logger.info("executed {} table statement changed {} rows: {}", str, Integer.valueOf(iRunExecute), str2);
                        if (compiledStatementCompileStatement != null) {
                            compiledStatementCompileStatement.close();
                        }
                    } catch (SQLException e) {
                        e = e;
                        if (z) {
                            logger.info("ignoring {} error '{}' for statement: {}", str, e, str2);
                            if (compiledStatementCompileStatement != null) {
                            }
                            if (iRunExecute < 0) {
                                if (z2) {
                                    throw new SQLException("SQL statement " + str2 + " updated " + iRunExecute + " rows, we were expecting >= 0");
                                }
                            } else if (iRunExecute > 0) {
                                continue;
                            }
                            i++;
                        } else {
                            throw SqlExceptionUtil.create("SQL statement failed: " + str2, e);
                        }
                    }
                } catch (Throwable th) {
                    if (compiledStatementCompileStatement != null) {
                        compiledStatementCompileStatement.close();
                    }
                    throw th;
                }
            } catch (SQLException e2) {
                e = e2;
                iRunExecute = 0;
            }
            if (iRunExecute < 0) {
                if (z2) {
                    throw new SQLException("SQL statement " + str2 + " updated " + iRunExecute + " rows, we were expecting >= 0");
                }
            } else if (iRunExecute > 0 && z3) {
                throw new SQLException("SQL statement updated " + iRunExecute + " rows, we were expecting == 0: " + str2);
            }
            i++;
        }
        return i;
    }

    private static int doCreateTestQueries(DatabaseConnection databaseConnection, DatabaseType databaseType, List<String> list) throws Throwable {
        int i = 0;
        for (String str : list) {
            CompiledStatement compiledStatement = null;
            try {
                try {
                    CompiledStatement compiledStatementCompileStatement = databaseConnection.compileStatement(str, StatementBuilder.StatementType.SELECT, noFieldTypes);
                    try {
                        DatabaseResults databaseResultsRunQuery = compiledStatementCompileStatement.runQuery(null);
                        int i2 = 0;
                        for (boolean zFirst = databaseResultsRunQuery.first(); zFirst; zFirst = databaseResultsRunQuery.next()) {
                            i2++;
                        }
                        logger.info("executing create table after-query got {} results: {}", Integer.valueOf(i2), str);
                        if (compiledStatementCompileStatement != null) {
                            compiledStatementCompileStatement.close();
                        }
                        i++;
                    } catch (SQLException e) {
                        e = e;
                        compiledStatement = compiledStatementCompileStatement;
                        throw SqlExceptionUtil.create("executing create table after-query failed: " + str, e);
                    } catch (Throwable th) {
                        th = th;
                        compiledStatement = compiledStatementCompileStatement;
                        if (compiledStatement != null) {
                            compiledStatement.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (SQLException e2) {
                e = e2;
            }
        }
        return i;
    }

    private static <T, ID> List<String> addCreateTableStatements(ConnectionSource connectionSource, TableInfo<T, ID> tableInfo, boolean z) throws SQLException {
        ArrayList arrayList = new ArrayList();
        addCreateTableStatements(connectionSource.getDatabaseType(), tableInfo, arrayList, new ArrayList(), z);
        return arrayList;
    }
}
