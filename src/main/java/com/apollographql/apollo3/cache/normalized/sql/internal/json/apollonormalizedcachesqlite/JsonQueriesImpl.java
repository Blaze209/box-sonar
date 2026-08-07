package com.apollographql.apollo3.cache.normalized.sql.internal.json.apollonormalizedcachesqlite;

import androidx.exifinterface.media.ExifInterface;
import com.apollographql.apollo3.cache.normalized.sql.internal.json.JsonQueries;
import com.apollographql.apollo3.cache.normalized.sql.internal.json.RecordForKey;
import com.apollographql.apollo3.cache.normalized.sql.internal.json.Records;
import com.apollographql.apollo3.cache.normalized.sql.internal.json.RecordsForKeys;
import com.box.androidsdk.content.requests.BoxRequestEvent;
import com.j256.ormlite.field.FieldType;
import com.squareup.sqldelight.Query;
import com.squareup.sqldelight.QueryKt;
import com.squareup.sqldelight.TransacterImpl;
import com.squareup.sqldelight.db.SqlCursor;
import com.squareup.sqldelight.db.SqlDriver;
import com.squareup.sqldelight.db.SqlPreparedStatement;
import com.squareup.sqldelight.internal.FunctionsJvmKt;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JsonDatabaseImpl.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0002,-B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00130\nH\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0015H\u0016J\u0016\u0010\u0019\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u0017H\u0016J\u0018\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u0017H\u0016J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020 0\n2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016JX\u0010\r\u001a\b\u0012\u0004\u0012\u0002H!0\n\"\b\b\u0000\u0010!*\u00020\"2\u0006\u0010\u0016\u001a\u00020\u001726\u0010#\u001a2\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u0002H!0$H\u0016J\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020'0\n2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u001aH\u0016J^\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H!0\n\"\b\b\u0000\u0010!*\u00020\"2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u001a26\u0010#\u001a2\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u0002H!0$H\u0016J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020(0\nH\u0016Je\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H!0\n\"\b\b\u0000\u0010!*\u00020\"2K\u0010#\u001aG\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u0002H!0)H\u0016J\u0018\u0010+\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u001e\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u001e\u0010\u000f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u001e\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006."}, d2 = {"Lcom/apollographql/apollo3/cache/normalized/sql/internal/json/apollonormalizedcachesqlite/JsonQueriesImpl;", "Lcom/squareup/sqldelight/TransacterImpl;", "Lcom/apollographql/apollo3/cache/normalized/sql/internal/json/JsonQueries;", "database", "Lcom/apollographql/apollo3/cache/normalized/sql/internal/json/apollonormalizedcachesqlite/JsonDatabaseImpl;", "driver", "Lcom/squareup/sqldelight/db/SqlDriver;", "(Lcom/apollographql/apollo3/cache/normalized/sql/internal/json/apollonormalizedcachesqlite/JsonDatabaseImpl;Lcom/squareup/sqldelight/db/SqlDriver;)V", BoxRequestEvent.STREAM_TYPE_CHANGES, "", "Lcom/squareup/sqldelight/Query;", "getChanges$apollo_normalized_cache_sqlite_release", "()Ljava/util/List;", "recordForKey", "getRecordForKey$apollo_normalized_cache_sqlite_release", "recordsForKeys", "getRecordsForKeys$apollo_normalized_cache_sqlite_release", "selectRecords", "getSelectRecords$apollo_normalized_cache_sqlite_release", "", "delete", "", "key", "", "deleteAll", "deleteRecords", "", "deleteRecordsWithKeyMatching", "value", "value_", SemanticAttributes.FaasDocumentOperationValues.INSERT, "record", "Lcom/apollographql/apollo3/cache/normalized/sql/internal/json/RecordForKey;", ExifInterface.GPS_DIRECTION_TRUE, "", "mapper", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Lcom/apollographql/apollo3/cache/normalized/sql/internal/json/RecordsForKeys;", "Lcom/apollographql/apollo3/cache/normalized/sql/internal/json/Records;", "Lkotlin/Function3;", FieldType.FOREIGN_ID_FIELD_SUFFIX, "update", "RecordForKeyQuery", "RecordsForKeysQuery", "apollo-normalized-cache-sqlite_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
final class JsonQueriesImpl extends TransacterImpl implements JsonQueries {
    private final List<Query<?>> changes;
    private final JsonDatabaseImpl database;
    private final SqlDriver driver;
    private final List<Query<?>> recordForKey;
    private final List<Query<?>> recordsForKeys;
    private final List<Query<?>> selectRecords;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonQueriesImpl(JsonDatabaseImpl database, SqlDriver driver) {
        super(driver);
        Intrinsics.checkNotNullParameter(database, "database");
        Intrinsics.checkNotNullParameter(driver, "driver");
        this.database = database;
        this.driver = driver;
        this.recordForKey = FunctionsJvmKt.copyOnWriteList();
        this.recordsForKeys = FunctionsJvmKt.copyOnWriteList();
        this.selectRecords = FunctionsJvmKt.copyOnWriteList();
        this.changes = FunctionsJvmKt.copyOnWriteList();
    }

    public final List<Query<?>> getRecordForKey$apollo_normalized_cache_sqlite_release() {
        return this.recordForKey;
    }

    public final List<Query<?>> getRecordsForKeys$apollo_normalized_cache_sqlite_release() {
        return this.recordsForKeys;
    }

    public final List<Query<?>> getSelectRecords$apollo_normalized_cache_sqlite_release() {
        return this.selectRecords;
    }

    public final List<Query<?>> getChanges$apollo_normalized_cache_sqlite_release() {
        return this.changes;
    }

    @Override // com.apollographql.apollo3.cache.normalized.sql.internal.json.JsonQueries
    public <T> Query<T> recordForKey(String key, final Function2<? super String, ? super String, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new RecordForKeyQuery(this, key, new Function1<SqlCursor, T>() { // from class: com.apollographql.apollo3.cache.normalized.sql.internal.json.apollonormalizedcachesqlite.JsonQueriesImpl.recordForKey.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function2<String, String, T> function2 = mapper;
                String string = cursor.getString(0);
                Intrinsics.checkNotNull(string);
                String string2 = cursor.getString(1);
                Intrinsics.checkNotNull(string2);
                return function2.invoke(string, string2);
            }
        });
    }

    @Override // com.apollographql.apollo3.cache.normalized.sql.internal.json.JsonQueries
    public Query<RecordForKey> recordForKey(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return recordForKey(key, new Function2<String, String, RecordForKey>() { // from class: com.apollographql.apollo3.cache.normalized.sql.internal.json.apollonormalizedcachesqlite.JsonQueriesImpl.recordForKey.2
            @Override // kotlin.jvm.functions.Function2
            public final RecordForKey invoke(String key_, String record) {
                Intrinsics.checkNotNullParameter(key_, "key_");
                Intrinsics.checkNotNullParameter(record, "record");
                return new RecordForKey(key_, record);
            }
        });
    }

    @Override // com.apollographql.apollo3.cache.normalized.sql.internal.json.JsonQueries
    public <T> Query<T> recordsForKeys(Collection<String> key, final Function2<? super String, ? super String, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new RecordsForKeysQuery(this, key, new Function1<SqlCursor, T>() { // from class: com.apollographql.apollo3.cache.normalized.sql.internal.json.apollonormalizedcachesqlite.JsonQueriesImpl.recordsForKeys.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function2<String, String, T> function2 = mapper;
                String string = cursor.getString(0);
                Intrinsics.checkNotNull(string);
                String string2 = cursor.getString(1);
                Intrinsics.checkNotNull(string2);
                return function2.invoke(string, string2);
            }
        });
    }

    @Override // com.apollographql.apollo3.cache.normalized.sql.internal.json.JsonQueries
    public Query<RecordsForKeys> recordsForKeys(Collection<String> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return recordsForKeys(key, new Function2<String, String, RecordsForKeys>() { // from class: com.apollographql.apollo3.cache.normalized.sql.internal.json.apollonormalizedcachesqlite.JsonQueriesImpl.recordsForKeys.2
            @Override // kotlin.jvm.functions.Function2
            public final RecordsForKeys invoke(String key_, String record) {
                Intrinsics.checkNotNullParameter(key_, "key_");
                Intrinsics.checkNotNullParameter(record, "record");
                return new RecordsForKeys(key_, record);
            }
        });
    }

    @Override // com.apollographql.apollo3.cache.normalized.sql.internal.json.JsonQueries
    public <T> Query<T> selectRecords(final Function3<? super Long, ? super String, ? super String, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return QueryKt.Query(-316451569, this.selectRecords, this.driver, "json.sq", "selectRecords", "SELECT * FROM records", new Function1<SqlCursor, T>() { // from class: com.apollographql.apollo3.cache.normalized.sql.internal.json.apollonormalizedcachesqlite.JsonQueriesImpl.selectRecords.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function3<Long, String, String, T> function3 = mapper;
                Long l = cursor.getLong(0);
                Intrinsics.checkNotNull(l);
                String string = cursor.getString(1);
                Intrinsics.checkNotNull(string);
                String string2 = cursor.getString(2);
                Intrinsics.checkNotNull(string2);
                return function3.invoke(l, string, string2);
            }
        });
    }

    @Override // com.apollographql.apollo3.cache.normalized.sql.internal.json.JsonQueries
    public Query<Records> selectRecords() {
        return selectRecords(new Function3<Long, String, String, Records>() { // from class: com.apollographql.apollo3.cache.normalized.sql.internal.json.apollonormalizedcachesqlite.JsonQueriesImpl.selectRecords.2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Records invoke(Long l, String str, String str2) {
                return invoke(l.longValue(), str, str2);
            }

            public final Records invoke(long j, String key, String record) {
                Intrinsics.checkNotNullParameter(key, "key");
                Intrinsics.checkNotNullParameter(record, "record");
                return new Records(j, key, record);
            }
        });
    }

    @Override // com.apollographql.apollo3.cache.normalized.sql.internal.json.JsonQueries
    public Query<Long> changes() {
        return QueryKt.Query(-1095725844, this.changes, this.driver, "json.sq", BoxRequestEvent.STREAM_TYPE_CHANGES, "SELECT changes()", new Function1<SqlCursor, Long>() { // from class: com.apollographql.apollo3.cache.normalized.sql.internal.json.apollonormalizedcachesqlite.JsonQueriesImpl.changes.1
            @Override // kotlin.jvm.functions.Function1
            public final Long invoke(SqlCursor cursor) {
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Long l = cursor.getLong(0);
                Intrinsics.checkNotNull(l);
                return l;
            }
        });
    }

    @Override // com.apollographql.apollo3.cache.normalized.sql.internal.json.JsonQueries
    public void insert(final String key, final String record) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(record, "record");
        this.driver.execute(1943613296, "INSERT INTO records (key, record) VALUES (?,?)", 2, new Function1<SqlPreparedStatement, Unit>() { // from class: com.apollographql.apollo3.cache.normalized.sql.internal.json.apollonormalizedcachesqlite.JsonQueriesImpl.insert.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                invoke2(sqlPreparedStatement);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SqlPreparedStatement execute) {
                Intrinsics.checkNotNullParameter(execute, "$this$execute");
                execute.bindString(1, key);
                execute.bindString(2, record);
            }
        });
        notifyQueries(1943613296, new Function0<List<? extends Query<?>>>() { // from class: com.apollographql.apollo3.cache.normalized.sql.internal.json.apollonormalizedcachesqlite.JsonQueriesImpl.insert.2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends Query<?>> invoke() {
                return CollectionsKt.plus((Collection) CollectionsKt.plus((Collection) JsonQueriesImpl.this.database.getJsonQueries().getRecordForKey$apollo_normalized_cache_sqlite_release(), (Iterable) JsonQueriesImpl.this.database.getJsonQueries().getSelectRecords$apollo_normalized_cache_sqlite_release()), (Iterable) JsonQueriesImpl.this.database.getJsonQueries().getRecordsForKeys$apollo_normalized_cache_sqlite_release());
            }
        });
    }

    @Override // com.apollographql.apollo3.cache.normalized.sql.internal.json.JsonQueries
    public void update(final String record, final String key) {
        Intrinsics.checkNotNullParameter(record, "record");
        Intrinsics.checkNotNullParameter(key, "key");
        this.driver.execute(-2006407808, "UPDATE records SET record=? WHERE key=?", 2, new Function1<SqlPreparedStatement, Unit>() { // from class: com.apollographql.apollo3.cache.normalized.sql.internal.json.apollonormalizedcachesqlite.JsonQueriesImpl.update.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                invoke2(sqlPreparedStatement);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SqlPreparedStatement execute) {
                Intrinsics.checkNotNullParameter(execute, "$this$execute");
                execute.bindString(1, record);
                execute.bindString(2, key);
            }
        });
        notifyQueries(-2006407808, new Function0<List<? extends Query<?>>>() { // from class: com.apollographql.apollo3.cache.normalized.sql.internal.json.apollonormalizedcachesqlite.JsonQueriesImpl.update.2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends Query<?>> invoke() {
                return CollectionsKt.plus((Collection) CollectionsKt.plus((Collection) JsonQueriesImpl.this.database.getJsonQueries().getRecordForKey$apollo_normalized_cache_sqlite_release(), (Iterable) JsonQueriesImpl.this.database.getJsonQueries().getSelectRecords$apollo_normalized_cache_sqlite_release()), (Iterable) JsonQueriesImpl.this.database.getJsonQueries().getRecordsForKeys$apollo_normalized_cache_sqlite_release());
            }
        });
    }

    @Override // com.apollographql.apollo3.cache.normalized.sql.internal.json.JsonQueries
    public void delete(final String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.driver.execute(1791947362, "DELETE FROM records WHERE key=?", 1, new Function1<SqlPreparedStatement, Unit>() { // from class: com.apollographql.apollo3.cache.normalized.sql.internal.json.apollonormalizedcachesqlite.JsonQueriesImpl.delete.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                invoke2(sqlPreparedStatement);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SqlPreparedStatement execute) {
                Intrinsics.checkNotNullParameter(execute, "$this$execute");
                execute.bindString(1, key);
            }
        });
        notifyQueries(1791947362, new Function0<List<? extends Query<?>>>() { // from class: com.apollographql.apollo3.cache.normalized.sql.internal.json.apollonormalizedcachesqlite.JsonQueriesImpl.delete.2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends Query<?>> invoke() {
                return CollectionsKt.plus((Collection) CollectionsKt.plus((Collection) JsonQueriesImpl.this.database.getJsonQueries().getRecordForKey$apollo_normalized_cache_sqlite_release(), (Iterable) JsonQueriesImpl.this.database.getJsonQueries().getSelectRecords$apollo_normalized_cache_sqlite_release()), (Iterable) JsonQueriesImpl.this.database.getJsonQueries().getRecordsForKeys$apollo_normalized_cache_sqlite_release());
            }
        });
    }

    @Override // com.apollographql.apollo3.cache.normalized.sql.internal.json.JsonQueries
    public void deleteRecords(final Collection<String> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.driver.execute(null, "DELETE FROM records WHERE key IN " + createArguments(key.size()), key.size(), new Function1<SqlPreparedStatement, Unit>() { // from class: com.apollographql.apollo3.cache.normalized.sql.internal.json.apollonormalizedcachesqlite.JsonQueriesImpl.deleteRecords.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                invoke2(sqlPreparedStatement);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SqlPreparedStatement execute) {
                Intrinsics.checkNotNullParameter(execute, "$this$execute");
                int i = 0;
                for (Object obj : key) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    execute.bindString(i2, (String) obj);
                    i = i2;
                }
            }
        });
        notifyQueries(-1244679808, new Function0<List<? extends Query<?>>>() { // from class: com.apollographql.apollo3.cache.normalized.sql.internal.json.apollonormalizedcachesqlite.JsonQueriesImpl.deleteRecords.2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends Query<?>> invoke() {
                return CollectionsKt.plus((Collection) CollectionsKt.plus((Collection) JsonQueriesImpl.this.database.getJsonQueries().getRecordForKey$apollo_normalized_cache_sqlite_release(), (Iterable) JsonQueriesImpl.this.database.getJsonQueries().getSelectRecords$apollo_normalized_cache_sqlite_release()), (Iterable) JsonQueriesImpl.this.database.getJsonQueries().getRecordsForKeys$apollo_normalized_cache_sqlite_release());
            }
        });
    }

    @Override // com.apollographql.apollo3.cache.normalized.sql.internal.json.JsonQueries
    public void deleteRecordsWithKeyMatching(final String value, final String value_) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(value_, "value_");
        this.driver.execute(1083807030, "DELETE FROM records WHERE key LIKE ? ESCAPE ?", 2, new Function1<SqlPreparedStatement, Unit>() { // from class: com.apollographql.apollo3.cache.normalized.sql.internal.json.apollonormalizedcachesqlite.JsonQueriesImpl.deleteRecordsWithKeyMatching.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                invoke2(sqlPreparedStatement);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SqlPreparedStatement execute) {
                Intrinsics.checkNotNullParameter(execute, "$this$execute");
                execute.bindString(1, value);
                execute.bindString(2, value_);
            }
        });
        notifyQueries(1083807030, new Function0<List<? extends Query<?>>>() { // from class: com.apollographql.apollo3.cache.normalized.sql.internal.json.apollonormalizedcachesqlite.JsonQueriesImpl.deleteRecordsWithKeyMatching.2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends Query<?>> invoke() {
                return CollectionsKt.plus((Collection) CollectionsKt.plus((Collection) JsonQueriesImpl.this.database.getJsonQueries().getRecordForKey$apollo_normalized_cache_sqlite_release(), (Iterable) JsonQueriesImpl.this.database.getJsonQueries().getSelectRecords$apollo_normalized_cache_sqlite_release()), (Iterable) JsonQueriesImpl.this.database.getJsonQueries().getRecordsForKeys$apollo_normalized_cache_sqlite_release());
            }
        });
    }

    @Override // com.apollographql.apollo3.cache.normalized.sql.internal.json.JsonQueries
    public void deleteAll() {
        SqlDriver.DefaultImpls.execute$default(this.driver, 1755405279, "DELETE FROM records", 0, null, 8, null);
        notifyQueries(1755405279, new Function0<List<? extends Query<?>>>() { // from class: com.apollographql.apollo3.cache.normalized.sql.internal.json.apollonormalizedcachesqlite.JsonQueriesImpl.deleteAll.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends Query<?>> invoke() {
                return CollectionsKt.plus((Collection) CollectionsKt.plus((Collection) JsonQueriesImpl.this.database.getJsonQueries().getRecordForKey$apollo_normalized_cache_sqlite_release(), (Iterable) JsonQueriesImpl.this.database.getJsonQueries().getSelectRecords$apollo_normalized_cache_sqlite_release()), (Iterable) JsonQueriesImpl.this.database.getJsonQueries().getRecordsForKeys$apollo_normalized_cache_sqlite_release());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: JsonDatabaseImpl.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B!\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\tJ\b\u0010\f\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/apollographql/apollo3/cache/normalized/sql/internal/json/apollonormalizedcachesqlite/JsonQueriesImpl$RecordForKeyQuery;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lcom/squareup/sqldelight/Query;", "key", "", "mapper", "Lkotlin/Function1;", "Lcom/squareup/sqldelight/db/SqlCursor;", "(Lcom/apollographql/apollo3/cache/normalized/sql/internal/json/apollonormalizedcachesqlite/JsonQueriesImpl;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getKey", "()Ljava/lang/String;", "execute", "toString", "apollo-normalized-cache-sqlite_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    final class RecordForKeyQuery<T> extends Query<T> {
        private final String key;
        final /* synthetic */ JsonQueriesImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RecordForKeyQuery(JsonQueriesImpl jsonQueriesImpl, String key, Function1<? super SqlCursor, ? extends T> mapper) {
            super(jsonQueriesImpl.getRecordForKey$apollo_normalized_cache_sqlite_release(), mapper);
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = jsonQueriesImpl;
            this.key = key;
        }

        public final String getKey() {
            return this.key;
        }

        @Override // com.squareup.sqldelight.Query
        public SqlCursor execute() {
            return this.this$0.driver.executeQuery(-1788979202, "SELECT key, record FROM records WHERE key=?", 1, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.apollographql.apollo3.cache.normalized.sql.internal.json.apollonormalizedcachesqlite.JsonQueriesImpl$RecordForKeyQuery$execute$1
                final /* synthetic */ JsonQueriesImpl.RecordForKeyQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindString(1, this.this$0.getKey());
                }
            });
        }

        public String toString() {
            return "json.sq:recordForKey";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: JsonDatabaseImpl.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B'\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0002\u0010\nJ\b\u0010\r\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/apollographql/apollo3/cache/normalized/sql/internal/json/apollonormalizedcachesqlite/JsonQueriesImpl$RecordsForKeysQuery;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lcom/squareup/sqldelight/Query;", "key", "", "", "mapper", "Lkotlin/Function1;", "Lcom/squareup/sqldelight/db/SqlCursor;", "(Lcom/apollographql/apollo3/cache/normalized/sql/internal/json/apollonormalizedcachesqlite/JsonQueriesImpl;Ljava/util/Collection;Lkotlin/jvm/functions/Function1;)V", "getKey", "()Ljava/util/Collection;", "execute", "toString", "apollo-normalized-cache-sqlite_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    final class RecordsForKeysQuery<T> extends Query<T> {
        private final Collection<String> key;
        final /* synthetic */ JsonQueriesImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RecordsForKeysQuery(JsonQueriesImpl jsonQueriesImpl, Collection<String> key, Function1<? super SqlCursor, ? extends T> mapper) {
            super(jsonQueriesImpl.getRecordsForKeys$apollo_normalized_cache_sqlite_release(), mapper);
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = jsonQueriesImpl;
            this.key = key;
        }

        public final Collection<String> getKey() {
            return this.key;
        }

        @Override // com.squareup.sqldelight.Query
        public SqlCursor execute() {
            return this.this$0.driver.executeQuery(null, "SELECT key, record FROM records WHERE key IN " + this.this$0.createArguments(this.key.size()), this.key.size(), new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.apollographql.apollo3.cache.normalized.sql.internal.json.apollonormalizedcachesqlite.JsonQueriesImpl$RecordsForKeysQuery$execute$1
                final /* synthetic */ JsonQueriesImpl.RecordsForKeysQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    int i = 0;
                    for (Object obj : this.this$0.getKey()) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        executeQuery.bindString(i2, (String) obj);
                        i = i2;
                    }
                }
            });
        }

        public String toString() {
            return "json.sq:recordsForKeys";
        }
    }
}
