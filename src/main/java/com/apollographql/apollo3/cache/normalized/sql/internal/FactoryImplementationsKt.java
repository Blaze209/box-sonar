package com.apollographql.apollo3.cache.normalized.sql.internal;

import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import com.apollographql.apollo3.cache.normalized.sql.ApolloInitializer;
import com.box.androidsdk.content.BoxApiMetadata;
import com.squareup.sqldelight.android.AndroidSqliteDriver;
import com.squareup.sqldelight.db.SqlDriver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: factoryImplementations.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a$\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¨\u0006\n"}, d2 = {"createDriver", "Lcom/squareup/sqldelight/db/SqlDriver;", "name", "", "baseDir", BoxApiMetadata.BOX_API_METADATA_SCHEMA, "Lcom/squareup/sqldelight/db/SqlDriver$Schema;", "maybeCreateOrMigrateSchema", "", "driver", "apollo-normalized-cache-sqlite_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class FactoryImplementationsKt {
    public static final void maybeCreateOrMigrateSchema(SqlDriver driver, SqlDriver.Schema schema) {
        Intrinsics.checkNotNullParameter(driver, "driver");
        Intrinsics.checkNotNullParameter(schema, "schema");
    }

    public static final SqlDriver createDriver(String str, String str2, SqlDriver.Schema schema) {
        Intrinsics.checkNotNullParameter(schema, "schema");
        if (str2 != null) {
            throw new IllegalStateException("Apollo: Android SqlNormalizedCacheFactory doesn't support 'baseDir'".toString());
        }
        return new AndroidSqliteDriver(schema, ApolloInitializer.INSTANCE.getContext$apollo_normalized_cache_sqlite_release(), str, new FrameworkSQLiteOpenHelperFactory(), null, 0, false, 112, null);
    }
}
