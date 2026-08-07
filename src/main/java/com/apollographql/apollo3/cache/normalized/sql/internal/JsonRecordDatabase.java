package com.apollographql.apollo3.cache.normalized.sql.internal;

import androidx.exifinterface.media.ExifInterface;
import com.apollographql.apollo3.cache.normalized.api.Record;
import com.apollographql.apollo3.cache.normalized.api.internal.JsonRecordSerializer;
import com.apollographql.apollo3.cache.normalized.sql.internal.json.JsonQueries;
import com.apollographql.apollo3.cache.normalized.sql.internal.json.RecordForKey;
import com.apollographql.apollo3.cache.normalized.sql.internal.json.Records;
import com.apollographql.apollo3.cache.normalized.sql.internal.json.RecordsForKeys;
import com.box.androidsdk.content.requests.BoxRequestEvent;
import com.squareup.sqldelight.Transacter;
import com.squareup.sqldelight.TransactionWithReturn;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JsonRecordDatabase.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\u0014H\u0016J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012H\u0016J)\u0010\u0016\u001a\u0002H\u0017\"\u0004\b\u0000\u0010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00170\u001bH\u0016¢\u0006\u0002\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/apollographql/apollo3/cache/normalized/sql/internal/JsonRecordDatabase;", "Lcom/apollographql/apollo3/cache/normalized/sql/internal/RecordDatabase;", "jsonQueries", "Lcom/apollographql/apollo3/cache/normalized/sql/internal/json/JsonQueries;", "(Lcom/apollographql/apollo3/cache/normalized/sql/internal/json/JsonQueries;)V", BoxRequestEvent.STREAM_TYPE_CHANGES, "", "delete", "", "key", "", "deleteAll", "deleteMatching", "pattern", SemanticAttributes.FaasDocumentOperationValues.INSERT, "record", "Lcom/apollographql/apollo3/cache/normalized/api/Record;", "select", "", "keys", "", "selectAll", SemanticAttributes.MessagingRocketmqMessageTypeValues.TRANSACTION, ExifInterface.GPS_DIRECTION_TRUE, "noEnclosing", "", "body", "Lkotlin/Function0;", "(ZLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "update", "apollo-normalized-cache-sqlite_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class JsonRecordDatabase implements RecordDatabase {
    private final JsonQueries jsonQueries;

    public JsonRecordDatabase(JsonQueries jsonQueries) {
        Intrinsics.checkNotNullParameter(jsonQueries, "jsonQueries");
        this.jsonQueries = jsonQueries;
    }

    @Override // com.apollographql.apollo3.cache.normalized.sql.internal.RecordDatabase
    public Record select(String key) throws IOException {
        Intrinsics.checkNotNullParameter(key, "key");
        List<RecordForKey> listExecuteAsList = this.jsonQueries.recordForKey(key).executeAsList();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listExecuteAsList, 10));
        for (RecordForKey recordForKey : listExecuteAsList) {
            arrayList.add(JsonRecordSerializer.INSTANCE.deserialize(recordForKey.getKey(), recordForKey.getRecord()));
        }
        return (Record) CollectionsKt.singleOrNull((List) arrayList);
    }

    @Override // com.apollographql.apollo3.cache.normalized.sql.internal.RecordDatabase
    public List<Record> select(Collection<String> keys) throws IOException {
        Intrinsics.checkNotNullParameter(keys, "keys");
        List<RecordsForKeys> listExecuteAsList = this.jsonQueries.recordsForKeys(keys).executeAsList();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listExecuteAsList, 10));
        for (RecordsForKeys recordsForKeys : listExecuteAsList) {
            arrayList.add(JsonRecordSerializer.INSTANCE.deserialize(recordsForKeys.getKey(), recordsForKeys.getRecord()));
        }
        return arrayList;
    }

    @Override // com.apollographql.apollo3.cache.normalized.sql.internal.RecordDatabase
    public <T> T transaction(boolean noEnclosing, final Function0<? extends T> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        return (T) Transacter.DefaultImpls.transactionWithResult$default(this.jsonQueries, false, new Function1<TransactionWithReturn<T>, T>() { // from class: com.apollographql.apollo3.cache.normalized.sql.internal.JsonRecordDatabase.transaction.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(TransactionWithReturn<T> transactionWithResult) {
                Intrinsics.checkNotNullParameter(transactionWithResult, "$this$transactionWithResult");
                return body.invoke();
            }
        }, 1, null);
    }

    @Override // com.apollographql.apollo3.cache.normalized.sql.internal.RecordDatabase
    public void delete(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.jsonQueries.delete(key);
    }

    @Override // com.apollographql.apollo3.cache.normalized.sql.internal.RecordDatabase
    public void deleteMatching(String pattern) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        this.jsonQueries.deleteRecordsWithKeyMatching(pattern, "\\");
    }

    @Override // com.apollographql.apollo3.cache.normalized.sql.internal.RecordDatabase
    public void deleteAll() {
        this.jsonQueries.deleteAll();
    }

    @Override // com.apollographql.apollo3.cache.normalized.sql.internal.RecordDatabase
    public long changes() {
        return this.jsonQueries.changes().executeAsOne().longValue();
    }

    @Override // com.apollographql.apollo3.cache.normalized.sql.internal.RecordDatabase
    public void insert(Record record) {
        Intrinsics.checkNotNullParameter(record, "record");
        this.jsonQueries.insert(record.getKey(), JsonRecordSerializer.INSTANCE.serialize(record));
    }

    @Override // com.apollographql.apollo3.cache.normalized.sql.internal.RecordDatabase
    public void update(Record record) {
        Intrinsics.checkNotNullParameter(record, "record");
        this.jsonQueries.update(JsonRecordSerializer.INSTANCE.serialize(record), record.getKey());
    }

    @Override // com.apollographql.apollo3.cache.normalized.sql.internal.RecordDatabase
    public List<Record> selectAll() throws IOException {
        List<Records> listExecuteAsList = this.jsonQueries.selectRecords().executeAsList();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listExecuteAsList, 10));
        for (Records records : listExecuteAsList) {
            arrayList.add(JsonRecordSerializer.INSTANCE.deserialize(records.getKey(), records.getRecord()));
        }
        return arrayList;
    }
}
