package com.apollographql.apollo3.cache.normalized.api.internal;

import com.apollographql.apollo3.api.json.BufferedSinkJsonWriter;
import com.apollographql.apollo3.api.json.BufferedSourceJsonReader;
import com.apollographql.apollo3.api.json.JsonReaders;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.apollographql.apollo3.cache.normalized.api.CacheKey;
import com.apollographql.apollo3.cache.normalized.api.Record;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ByteString;

/* JADX INFO: compiled from: JsonRecordSerializer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004J\u001e\u0010\n\u001a\u00020\u00062\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fH\u0002J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0001H\u0002J\u0016\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0002¨\u0006\u0012"}, d2 = {"Lcom/apollographql/apollo3/cache/normalized/api/internal/JsonRecordSerializer;", "", "()V", "deserialize", "Lcom/apollographql/apollo3/cache/normalized/api/Record;", "key", "", "jsonFieldSource", "serialize", "record", "toJson", "fields", "", "deserializeCacheKeys", "writeJsonValue", "", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "apollo-normalized-cache-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class JsonRecordSerializer {
    public static final JsonRecordSerializer INSTANCE = new JsonRecordSerializer();

    private JsonRecordSerializer() {
    }

    public final String serialize(Record record) {
        Intrinsics.checkNotNullParameter(record, "record");
        return toJson(record.getFields());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final String toJson(Map<String, ? extends Object> fields) throws Throwable {
        Buffer buffer = new Buffer();
        Throwable th = null;
        BufferedSinkJsonWriter bufferedSinkJsonWriter = new BufferedSinkJsonWriter(buffer, 0 == true ? 1 : 0, 2, 0 == true ? 1 : 0);
        try {
            BufferedSinkJsonWriter bufferedSinkJsonWriter2 = bufferedSinkJsonWriter;
            bufferedSinkJsonWriter2.beginObject();
            for (Map.Entry<String, ? extends Object> entry : fields.entrySet()) {
                String key = entry.getKey();
                INSTANCE.writeJsonValue(bufferedSinkJsonWriter2.name(key), entry.getValue());
            }
            bufferedSinkJsonWriter2.endObject();
            try {
                bufferedSinkJsonWriter.close();
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            try {
                bufferedSinkJsonWriter.close();
            } catch (Throwable th4) {
                ExceptionsKt.addSuppressed(th3, th4);
            }
            th = th3;
        }
        if (th == null) {
            return buffer.readUtf8();
        }
        throw th;
    }

    private final Object deserializeCacheKeys(Object obj) {
        if (obj instanceof String) {
            String str = (String) obj;
            if (CacheKey.INSTANCE.canDeserialize(str)) {
                return CacheKey.INSTANCE.deserialize(str);
            }
        } else if (!(obj instanceof Map)) {
            if (obj instanceof List) {
                Iterable iterable = (Iterable) obj;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    arrayList.add(INSTANCE.deserializeCacheKeys(it.next()));
                }
                return arrayList;
            }
        } else {
            Map map = (Map) obj;
            LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
            for (Map.Entry entry : map.entrySet()) {
                linkedHashMap.put(entry.getKey(), INSTANCE.deserializeCacheKeys(entry.getValue()));
            }
            return linkedHashMap;
        }
        return obj;
    }

    public final Record deserialize(String key, String jsonFieldSource) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(jsonFieldSource, "jsonFieldSource");
        Object objDeserializeCacheKeys = deserializeCacheKeys(JsonReaders.readAny(new BufferedSourceJsonReader(new Buffer().write(ByteString.INSTANCE.encodeUtf8(jsonFieldSource)))));
        Map map = objDeserializeCacheKeys instanceof Map ? (Map) objDeserializeCacheKeys : null;
        if (map == null) {
            throw new IllegalStateException(("error deserializing: " + jsonFieldSource).toString());
        }
        return new Record(key, map, null, 4, null);
    }

    private final void writeJsonValue(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        if (obj instanceof String) {
            jsonWriter.value((String) obj);
            return;
        }
        if (obj instanceof Boolean) {
            jsonWriter.value(((Boolean) obj).booleanValue());
            return;
        }
        if (obj instanceof Integer) {
            jsonWriter.value(((Number) obj).intValue());
            return;
        }
        if (obj instanceof Long) {
            jsonWriter.value(((Number) obj).longValue());
            return;
        }
        if (obj instanceof Double) {
            jsonWriter.value(((Number) obj).doubleValue());
            return;
        }
        if (obj instanceof CacheKey) {
            jsonWriter.value(((CacheKey) obj).serialize());
            return;
        }
        if (obj instanceof List) {
            jsonWriter.beginArray();
            Iterator it = ((Iterable) obj).iterator();
            while (it.hasNext()) {
                INSTANCE.writeJsonValue(jsonWriter, it.next());
            }
            jsonWriter.endArray();
            return;
        }
        if (obj instanceof Map) {
            jsonWriter.beginObject();
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                writeJsonValue(jsonWriter.name((String) entry.getKey()), entry.getValue());
            }
            jsonWriter.endObject();
            return;
        }
        throw new IllegalStateException(("Unsupported record value type: '" + obj + '\'').toString());
    }
}
