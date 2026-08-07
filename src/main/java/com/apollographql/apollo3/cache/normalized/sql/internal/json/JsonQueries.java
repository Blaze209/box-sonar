package com.apollographql.apollo3.cache.normalized.sql.internal.json;

import androidx.exifinterface.media.ExifInterface;
import com.box.androidsdk.content.requests.BoxRequestEvent;
import com.j256.ormlite.field.FieldType;
import com.squareup.sqldelight.Query;
import com.squareup.sqldelight.Transacter;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: JsonQueries.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0006H&J\u0016\u0010\n\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u000bH&J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH&J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bH&J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00032\u0006\u0010\u0007\u001a\u00020\bH&JX\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0003\"\b\b\u0000\u0010\u0013*\u00020\u00142\u0006\u0010\u0007\u001a\u00020\b26\u0010\u0015\u001a2\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u0002H\u00130\u0016H&J\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u000bH&J^\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0003\"\b\b\u0000\u0010\u0013*\u00020\u00142\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u000b26\u0010\u0015\u001a2\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u0002H\u00130\u0016H&J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0003H&Je\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0003\"\b\b\u0000\u0010\u0013*\u00020\u00142K\u0010\u0015\u001aG\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u0002H\u00130\u001dH&J\u0018\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006 "}, d2 = {"Lcom/apollographql/apollo3/cache/normalized/sql/internal/json/JsonQueries;", "Lcom/squareup/sqldelight/Transacter;", BoxRequestEvent.STREAM_TYPE_CHANGES, "Lcom/squareup/sqldelight/Query;", "", "delete", "", "key", "", "deleteAll", "deleteRecords", "", "deleteRecordsWithKeyMatching", "value", "value_", SemanticAttributes.FaasDocumentOperationValues.INSERT, "record", "recordForKey", "Lcom/apollographql/apollo3/cache/normalized/sql/internal/json/RecordForKey;", ExifInterface.GPS_DIRECTION_TRUE, "", "mapper", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "recordsForKeys", "Lcom/apollographql/apollo3/cache/normalized/sql/internal/json/RecordsForKeys;", "selectRecords", "Lcom/apollographql/apollo3/cache/normalized/sql/internal/json/Records;", "Lkotlin/Function3;", FieldType.FOREIGN_ID_FIELD_SUFFIX, "update", "apollo-normalized-cache-sqlite_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface JsonQueries extends Transacter {
    Query<Long> changes();

    void delete(String key);

    void deleteAll();

    void deleteRecords(Collection<String> key);

    void deleteRecordsWithKeyMatching(String value, String value_);

    void insert(String key, String record);

    Query<RecordForKey> recordForKey(String key);

    <T> Query<T> recordForKey(String key, Function2<? super String, ? super String, ? extends T> mapper);

    Query<RecordsForKeys> recordsForKeys(Collection<String> key);

    <T> Query<T> recordsForKeys(Collection<String> key, Function2<? super String, ? super String, ? extends T> mapper);

    Query<Records> selectRecords();

    <T> Query<T> selectRecords(Function3<? super Long, ? super String, ? super String, ? extends T> mapper);

    void update(String record, String key);
}
