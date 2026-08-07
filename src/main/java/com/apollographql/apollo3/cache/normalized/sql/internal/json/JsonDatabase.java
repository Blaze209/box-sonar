package com.apollographql.apollo3.cache.normalized.sql.internal.json;

import com.apollographql.apollo3.cache.normalized.sql.internal.json.apollonormalizedcachesqlite.JsonDatabaseImplKt;
import com.squareup.sqldelight.Transacter;
import com.squareup.sqldelight.db.SqlDriver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: JsonDatabase.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/apollographql/apollo3/cache/normalized/sql/internal/json/JsonDatabase;", "Lcom/squareup/sqldelight/Transacter;", "jsonQueries", "Lcom/apollographql/apollo3/cache/normalized/sql/internal/json/JsonQueries;", "getJsonQueries", "()Lcom/apollographql/apollo3/cache/normalized/sql/internal/json/JsonQueries;", "Companion", "apollo-normalized-cache-sqlite_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface JsonDatabase extends Transacter {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    JsonQueries getJsonQueries();

    /* JADX INFO: compiled from: JsonDatabase.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0011\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/apollographql/apollo3/cache/normalized/sql/internal/json/JsonDatabase$Companion;", "", "()V", "Schema", "Lcom/squareup/sqldelight/db/SqlDriver$Schema;", "getSchema", "()Lcom/squareup/sqldelight/db/SqlDriver$Schema;", "invoke", "Lcom/apollographql/apollo3/cache/normalized/sql/internal/json/JsonDatabase;", "driver", "Lcom/squareup/sqldelight/db/SqlDriver;", "apollo-normalized-cache-sqlite_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final SqlDriver.Schema getSchema() {
            return JsonDatabaseImplKt.getSchema(Reflection.getOrCreateKotlinClass(JsonDatabase.class));
        }

        public final JsonDatabase invoke(SqlDriver driver) {
            Intrinsics.checkNotNullParameter(driver, "driver");
            return JsonDatabaseImplKt.newInstance(Reflection.getOrCreateKotlinClass(JsonDatabase.class), driver);
        }
    }
}
