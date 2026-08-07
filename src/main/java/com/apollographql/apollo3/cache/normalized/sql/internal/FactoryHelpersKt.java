package com.apollographql.apollo3.cache.normalized.sql.internal;

import com.apollographql.apollo3.cache.normalized.sql.internal.json.JsonDatabase;
import com.apollographql.apollo3.exception.ApolloExceptionHandlerKt;
import com.squareup.sqldelight.db.SqlCursor;
import com.squareup.sqldelight.db.SqlDriver;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: factoryHelpers.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\b\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, d2 = {"createRecordDatabase", "Lcom/apollographql/apollo3/cache/normalized/sql/internal/RecordDatabase;", "driver", "Lcom/squareup/sqldelight/db/SqlDriver;", "getSchema", "Lcom/squareup/sqldelight/db/SqlDriver$Schema;", "apollo-normalized-cache-sqlite_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class FactoryHelpersKt {
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public static final RecordDatabase createRecordDatabase(SqlDriver driver) {
        Intrinsics.checkNotNullParameter(driver, "driver");
        FactoryImplementationsKt.maybeCreateOrMigrateSchema(driver, getSchema());
        ArrayList arrayList = new ArrayList();
        try {
            SqlCursor sqlCursorExecuteQuery$default = SqlDriver.DefaultImpls.executeQuery$default(driver, null, "SELECT name FROM sqlite_master WHERE type='table' ORDER BY name;", 0, null, 8, null);
            try {
                SqlCursor sqlCursor = sqlCursorExecuteQuery$default;
                while (sqlCursor.next()) {
                    String string = sqlCursor.getString(0);
                    if (string == null) {
                        string = "";
                    }
                    arrayList.add(string);
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(sqlCursorExecuteQuery$default, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(sqlCursorExecuteQuery$default, th);
                    throw th2;
                }
            }
        } catch (Exception e) {
            ApolloExceptionHandlerKt.getApolloExceptionHandler().invoke(new Exception("An exception occurred while looking up the table names", e));
        }
        if (!arrayList.isEmpty() && !arrayList.contains("records")) {
            throw new IllegalStateException(("Apollo: Cannot find the 'records' table? (found '" + arrayList + "' instead)").toString());
        }
        return new JsonRecordDatabase(JsonDatabase.INSTANCE.invoke(driver).getJsonQueries());
    }

    public static final SqlDriver.Schema getSchema() {
        return JsonDatabase.INSTANCE.getSchema();
    }
}
