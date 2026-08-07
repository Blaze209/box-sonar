package com.j256.ormlite.table;

import com.j256.ormlite.field.DatabaseFieldConfig;
import com.j256.ormlite.field.DatabaseFieldConfigLoader;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public class DatabaseTableConfigLoader {
    private static final String CONFIG_FILE_END_MARKER = "# --table-end--";
    private static final String CONFIG_FILE_FIELDS_END = "# --table-fields-end--";
    private static final String CONFIG_FILE_FIELDS_START = "# --table-fields-start--";
    private static final String CONFIG_FILE_START_MARKER = "# --table-start--";
    private static final String FIELD_NAME_DATA_CLASS = "dataClass";
    private static final String FIELD_NAME_TABLE_NAME = "tableName";

    public static List<DatabaseTableConfig<?>> loadDatabaseConfigFromReader(BufferedReader bufferedReader) throws SQLException {
        ArrayList arrayList = new ArrayList();
        while (true) {
            DatabaseTableConfig databaseTableConfigFromReader = fromReader(bufferedReader);
            if (databaseTableConfigFromReader == null) {
                return arrayList;
            }
            arrayList.add(databaseTableConfigFromReader);
        }
    }

    public static <T> DatabaseTableConfig<T> fromReader(BufferedReader bufferedReader) throws SQLException {
        DatabaseTableConfig<T> databaseTableConfig = new DatabaseTableConfig<>();
        boolean z = false;
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line == null || line.equals(CONFIG_FILE_END_MARKER)) {
                    break;
                }
                if (line.equals(CONFIG_FILE_FIELDS_START)) {
                    readFields(bufferedReader, databaseTableConfig);
                } else if (line.length() != 0 && !line.startsWith("#") && !line.equals(CONFIG_FILE_START_MARKER)) {
                    String[] strArrSplit = line.split(SimpleComparison.EQUAL_TO_OPERATION, -2);
                    if (strArrSplit.length != 2) {
                        throw new SQLException("DatabaseTableConfig reading from stream cannot parse line: " + line);
                    }
                    readTableField(databaseTableConfig, strArrSplit[0], strArrSplit[1]);
                    z = true;
                }
            } catch (IOException e) {
                throw SqlExceptionUtil.create("Could not read DatabaseTableConfig from stream", e);
            }
        }
        if (z) {
            return databaseTableConfig;
        }
        return null;
    }

    public static <T> void write(BufferedWriter bufferedWriter, DatabaseTableConfig<T> databaseTableConfig) throws SQLException {
        try {
            writeConfig(bufferedWriter, databaseTableConfig);
        } catch (IOException e) {
            throw SqlExceptionUtil.create("Could not write config to writer", e);
        }
    }

    private static <T> void writeConfig(BufferedWriter bufferedWriter, DatabaseTableConfig<T> databaseTableConfig) throws SQLException, IOException {
        bufferedWriter.append(CONFIG_FILE_START_MARKER);
        bufferedWriter.newLine();
        if (databaseTableConfig.getDataClass() != null) {
            bufferedWriter.append(FIELD_NAME_DATA_CLASS).append('=').append((CharSequence) databaseTableConfig.getDataClass().getName());
            bufferedWriter.newLine();
        }
        if (databaseTableConfig.getTableName() != null) {
            bufferedWriter.append(FIELD_NAME_TABLE_NAME).append('=').append((CharSequence) databaseTableConfig.getTableName());
            bufferedWriter.newLine();
        }
        bufferedWriter.append(CONFIG_FILE_FIELDS_START);
        bufferedWriter.newLine();
        if (databaseTableConfig.getFieldConfigs() != null) {
            Iterator<DatabaseFieldConfig> it = databaseTableConfig.getFieldConfigs().iterator();
            while (it.hasNext()) {
                DatabaseFieldConfigLoader.write(bufferedWriter, it.next(), databaseTableConfig.getTableName());
            }
        }
        bufferedWriter.append(CONFIG_FILE_FIELDS_END);
        bufferedWriter.newLine();
        bufferedWriter.append(CONFIG_FILE_END_MARKER);
        bufferedWriter.newLine();
    }

    private static <T> void readTableField(DatabaseTableConfig<T> databaseTableConfig, String str, String str2) {
        if (str.equals(FIELD_NAME_DATA_CLASS)) {
            try {
                databaseTableConfig.setDataClass(Class.forName(str2));
            } catch (ClassNotFoundException unused) {
                throw new IllegalArgumentException("Unknown class specified for dataClass: " + str2);
            }
        } else if (str.equals(FIELD_NAME_TABLE_NAME)) {
            databaseTableConfig.setTableName(str2);
        }
    }

    private static <T> void readFields(BufferedReader bufferedReader, DatabaseTableConfig<T> databaseTableConfig) throws SQLException {
        DatabaseFieldConfig databaseFieldConfigFromReader;
        ArrayList arrayList = new ArrayList();
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line == null || line.equals(CONFIG_FILE_FIELDS_END) || (databaseFieldConfigFromReader = DatabaseFieldConfigLoader.fromReader(bufferedReader)) == null) {
                    break;
                } else {
                    arrayList.add(databaseFieldConfigFromReader);
                }
            } catch (IOException e) {
                throw SqlExceptionUtil.create("Could not read next field from config file", e);
            }
        }
        databaseTableConfig.setFieldConfigs(arrayList);
    }
}
