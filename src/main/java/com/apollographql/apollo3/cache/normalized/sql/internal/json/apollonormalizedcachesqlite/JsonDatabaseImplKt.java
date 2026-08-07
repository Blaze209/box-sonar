package com.apollographql.apollo3.cache.normalized.sql.internal.json.apollonormalizedcachesqlite;

import com.apollographql.apollo3.cache.normalized.sql.internal.json.JsonDatabase;
import com.box.androidsdk.content.BoxApiMetadata;
import com.squareup.sqldelight.db.SqlDriver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: JsonDatabaseImpl.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0006\u001a\u00020\u0003*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0000\"\u001e\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\t"}, d2 = {BoxApiMetadata.BOX_API_METADATA_SCHEMA, "Lcom/squareup/sqldelight/db/SqlDriver$Schema;", "Lkotlin/reflect/KClass;", "Lcom/apollographql/apollo3/cache/normalized/sql/internal/json/JsonDatabase;", "getSchema", "(Lkotlin/reflect/KClass;)Lcom/squareup/sqldelight/db/SqlDriver$Schema;", "newInstance", "driver", "Lcom/squareup/sqldelight/db/SqlDriver;", "apollo-normalized-cache-sqlite_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class JsonDatabaseImplKt {
    public static final SqlDriver.Schema getSchema(KClass<JsonDatabase> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        return JsonDatabaseImpl.Schema.INSTANCE;
    }

    public static final JsonDatabase newInstance(KClass<JsonDatabase> kClass, SqlDriver driver) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Intrinsics.checkNotNullParameter(driver, "driver");
        return new JsonDatabaseImpl(driver);
    }
}
