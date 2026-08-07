package com.apollographql.apollo3.cache.normalized.sql.internal.json.apollonormalizedcachesqlite;

import com.apollographql.apollo3.cache.normalized.sql.internal.json.JsonDatabase;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import com.squareup.sqldelight.TransacterImpl;
import com.squareup.sqldelight.db.SqlDriver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JsonDatabaseImpl.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\nB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/apollographql/apollo3/cache/normalized/sql/internal/json/apollonormalizedcachesqlite/JsonDatabaseImpl;", "Lcom/squareup/sqldelight/TransacterImpl;", "Lcom/apollographql/apollo3/cache/normalized/sql/internal/json/JsonDatabase;", "driver", "Lcom/squareup/sqldelight/db/SqlDriver;", "(Lcom/squareup/sqldelight/db/SqlDriver;)V", "jsonQueries", "Lcom/apollographql/apollo3/cache/normalized/sql/internal/json/apollonormalizedcachesqlite/JsonQueriesImpl;", "getJsonQueries", "()Lcom/apollographql/apollo3/cache/normalized/sql/internal/json/apollonormalizedcachesqlite/JsonQueriesImpl;", "Schema", "apollo-normalized-cache-sqlite_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
final class JsonDatabaseImpl extends TransacterImpl implements JsonDatabase {
    private final JsonQueriesImpl jsonQueries;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonDatabaseImpl(SqlDriver driver) {
        super(driver);
        Intrinsics.checkNotNullParameter(driver, "driver");
        this.jsonQueries = new JsonQueriesImpl(this, driver);
    }

    @Override // com.apollographql.apollo3.cache.normalized.sql.internal.json.JsonDatabase
    public JsonQueriesImpl getJsonQueries() {
        return this.jsonQueries;
    }

    /* JADX INFO: compiled from: JsonDatabaseImpl.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/apollographql/apollo3/cache/normalized/sql/internal/json/apollonormalizedcachesqlite/JsonDatabaseImpl$Schema;", "Lcom/squareup/sqldelight/db/SqlDriver$Schema;", "()V", "version", "", "getVersion", "()I", PasskeyWebListener.CREATE_UNIQUE_KEY, "", "driver", "Lcom/squareup/sqldelight/db/SqlDriver;", "migrate", "oldVersion", "newVersion", "apollo-normalized-cache-sqlite_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Schema implements SqlDriver.Schema {
        public static final Schema INSTANCE = new Schema();

        @Override // com.squareup.sqldelight.db.SqlDriver.Schema
        public int getVersion() {
            return 1;
        }

        @Override // com.squareup.sqldelight.db.SqlDriver.Schema
        public void migrate(SqlDriver driver, int oldVersion, int newVersion) {
            Intrinsics.checkNotNullParameter(driver, "driver");
        }

        private Schema() {
        }

        @Override // com.squareup.sqldelight.db.SqlDriver.Schema
        public void create(SqlDriver driver) {
            Intrinsics.checkNotNullParameter(driver, "driver");
            SqlDriver.DefaultImpls.execute$default(driver, null, "CREATE TABLE records (\n  _id INTEGER PRIMARY KEY AUTOINCREMENT,\n  key TEXT NOT NULL,\n  record TEXT NOT NULL\n)", 0, null, 8, null);
            SqlDriver.DefaultImpls.execute$default(driver, null, "CREATE INDEX idx_records_key ON records(key)", 0, null, 8, null);
        }
    }
}
