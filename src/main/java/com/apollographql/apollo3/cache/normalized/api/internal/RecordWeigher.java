package com.apollographql.apollo3.cache.normalized.api.internal;

import com.apollographql.apollo3.cache.normalized.api.CacheKey;
import com.apollographql.apollo3.cache.normalized.api.Record;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import okio.internal._Utf8Kt;

/* JADX INFO: compiled from: RecordWeigher.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0007J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/apollographql/apollo3/cache/normalized/api/internal/RecordWeigher;", "", "()V", "SIZE_OF_ARRAY_OVERHEAD", "", "SIZE_OF_BOOLEAN", "SIZE_OF_CACHE_KEY_OVERHEAD", "SIZE_OF_DOUBLE", "SIZE_OF_INT", "SIZE_OF_LONG", "SIZE_OF_MAP_OVERHEAD", "SIZE_OF_NULL", "SIZE_OF_RECORD_OVERHEAD", "byteChange", "newValue", "oldValue", "calculateBytes", "record", "Lcom/apollographql/apollo3/cache/normalized/api/Record;", "weighField", "field", "apollo-normalized-cache-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class RecordWeigher {
    public static final RecordWeigher INSTANCE = new RecordWeigher();
    private static final int SIZE_OF_ARRAY_OVERHEAD = 16;
    private static final int SIZE_OF_BOOLEAN = 16;
    private static final int SIZE_OF_CACHE_KEY_OVERHEAD = 16;
    private static final int SIZE_OF_DOUBLE = 8;
    private static final int SIZE_OF_INT = 4;
    private static final int SIZE_OF_LONG = 8;
    private static final int SIZE_OF_MAP_OVERHEAD = 16;
    private static final int SIZE_OF_NULL = 4;
    private static final int SIZE_OF_RECORD_OVERHEAD = 16;

    private RecordWeigher() {
    }

    @JvmStatic
    public static final int byteChange(Object newValue, Object oldValue) {
        RecordWeigher recordWeigher = INSTANCE;
        return recordWeigher.weighField(newValue) - recordWeigher.weighField(oldValue);
    }

    @JvmStatic
    public static final int calculateBytes(Record record) {
        Intrinsics.checkNotNullParameter(record, "record");
        int length = _Utf8Kt.commonAsUtf8ToByteArray(record.getKey()).length + 16;
        for (Map.Entry<String, Object> entry : record.getFields().entrySet()) {
            length += _Utf8Kt.commonAsUtf8ToByteArray(entry.getKey()).length + INSTANCE.weighField(entry.getValue());
        }
        return length;
    }

    private final int weighField(Object field) {
        if (field == null) {
            return 4;
        }
        if (field instanceof String) {
            return _Utf8Kt.commonAsUtf8ToByteArray((String) field).length;
        }
        if (field instanceof Boolean) {
            return 16;
        }
        if (field instanceof Integer) {
            return 4;
        }
        if ((field instanceof Long) || (field instanceof Double)) {
            return 8;
        }
        int iWeighField = 0;
        if (field instanceof List) {
            Iterator it = ((Iterable) field).iterator();
            while (it.hasNext()) {
                iWeighField += INSTANCE.weighField(it.next());
            }
            return 16 + iWeighField;
        }
        if (field instanceof CacheKey) {
            return _Utf8Kt.commonAsUtf8ToByteArray(((CacheKey) field).getKey()).length + 16;
        }
        if (field instanceof Map) {
            Map map = (Map) field;
            Iterator it2 = map.keySet().iterator();
            int iWeighField2 = 0;
            while (it2.hasNext()) {
                iWeighField2 += INSTANCE.weighField(it2.next());
            }
            int i = 16 + iWeighField2;
            Iterator it3 = map.values().iterator();
            while (it3.hasNext()) {
                iWeighField += INSTANCE.weighField(it3.next());
            }
            return i + iWeighField;
        }
        throw new IllegalStateException(("Unknown field type in Record: '" + field + '\'').toString());
    }
}
