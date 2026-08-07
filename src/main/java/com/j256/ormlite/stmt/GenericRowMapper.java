package com.j256.ormlite.stmt;

import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;

/* JADX INFO: loaded from: classes14.dex */
public interface GenericRowMapper<T> {
    T mapRow(DatabaseResults databaseResults) throws SQLException;
}
