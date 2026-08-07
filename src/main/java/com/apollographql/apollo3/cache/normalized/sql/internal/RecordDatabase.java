package com.apollographql.apollo3.cache.normalized.sql.internal;

import androidx.exifinterface.media.ExifInterface;
import com.apollographql.apollo3.cache.normalized.api.Record;
import com.box.androidsdk.content.requests.BoxRequestEvent;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: RecordDatabase.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0007H&J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH&J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011H&J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH&J+\u0010\u0013\u001a\u0002H\u0014\"\u0004\b\u0000\u0010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0018H&¢\u0006\u0002\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH&¨\u0006\u001b"}, d2 = {"Lcom/apollographql/apollo3/cache/normalized/sql/internal/RecordDatabase;", "", BoxRequestEvent.STREAM_TYPE_CHANGES, "", "delete", "", "key", "", "deleteAll", "deleteMatching", "pattern", SemanticAttributes.FaasDocumentOperationValues.INSERT, "record", "Lcom/apollographql/apollo3/cache/normalized/api/Record;", "select", "", "keys", "", "selectAll", SemanticAttributes.MessagingRocketmqMessageTypeValues.TRANSACTION, ExifInterface.GPS_DIRECTION_TRUE, "noEnclosing", "", "body", "Lkotlin/Function0;", "(ZLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "update", "apollo-normalized-cache-sqlite_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface RecordDatabase {
    long changes();

    void delete(String key);

    void deleteAll();

    void deleteMatching(String pattern);

    void insert(Record record);

    Record select(String key);

    List<Record> select(Collection<String> keys);

    List<Record> selectAll();

    <T> T transaction(boolean noEnclosing, Function0<? extends T> body);

    void update(Record record);

    /* JADX INFO: compiled from: RecordDatabase.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object transaction$default(RecordDatabase recordDatabase, boolean z, Function0 function0, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: transaction");
            }
            if ((i & 1) != 0) {
                z = false;
            }
            return recordDatabase.transaction(z, function0);
        }
    }
}
