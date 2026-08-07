package com.apollographql.apollo3.cache.normalized.api.internal;

import com.apollographql.apollo3.cache.normalized.api.CacheKey;
import com.apollographql.apollo3.cache.normalized.api.Record;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import okio.Buffer;

/* JADX INFO: compiled from: BlobRecordSerializer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u000eJ\u000e\u0010\u0015\u001a\u0004\u0018\u00010\u0001*\u00020\u0016H\u0002J\f\u0010\u0017\u001a\u00020\u0010*\u00020\u0016H\u0002J\u0016\u0010\u0018\u001a\u00020\u0019*\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0002J\u0014\u0010\u001b\u001a\u00020\u0019*\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/apollographql/apollo3/cache/normalized/api/internal/BlobRecordSerializer;", "", "()V", "BOOLEAN", "", "CACHE_KEY", "DOUBLE", "INT", "LIST", "LONG", "MAP", "NULL", "STRING", "deserialize", "Lcom/apollographql/apollo3/cache/normalized/api/Record;", "key", "", "bytes", "", "serialize", "record", "readAny", "Lokio/Buffer;", "readString", "writeAny", "", "value", "writeString", "apollo-normalized-cache-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class BlobRecordSerializer {
    private static final int BOOLEAN = 3;
    private static final int CACHE_KEY = 7;
    private static final int DOUBLE = 4;
    public static final BlobRecordSerializer INSTANCE = new BlobRecordSerializer();
    private static final int INT = 1;
    private static final int LIST = 5;
    private static final int LONG = 2;
    private static final int MAP = 6;
    private static final int NULL = 8;
    private static final int STRING = 0;

    private BlobRecordSerializer() {
    }

    public final byte[] serialize(Record record) {
        Intrinsics.checkNotNullParameter(record, "record");
        Buffer buffer = new Buffer();
        Set<String> setKeySet = record.getFields().keySet();
        buffer.writeInt(setKeySet.size());
        for (String str : setKeySet) {
            writeString(buffer, str);
            Map<String, Long> date = record.getDate();
            writeAny(buffer, date != null ? date.get(str) : null);
            writeAny(buffer, record.getFields().get(str));
        }
        return buffer.readByteArray();
    }

    public final Record deserialize(String key, byte[] bytes) throws EOFException {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Buffer bufferWrite = new Buffer().write(bytes);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        int i = bufferWrite.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            String string = readString(bufferWrite);
            linkedHashMap2.put(string, (Long) readAny(bufferWrite));
            linkedHashMap.put(string, readAny(bufferWrite));
        }
        return new Record(key, linkedHashMap, null, linkedHashMap2);
    }

    private final void writeString(Buffer buffer, String str) {
        buffer.writeInt(str.length());
        buffer.writeUtf8(str);
    }

    private final String readString(Buffer buffer) {
        return buffer.readUtf8(buffer.readInt());
    }

    private final void writeAny(Buffer buffer, Object obj) {
        if (obj instanceof String) {
            buffer.getBuffer().writeByte(0);
            writeString(buffer.getBuffer(), (String) obj);
            return;
        }
        if (obj instanceof Integer) {
            buffer.getBuffer().writeByte(1);
            buffer.getBuffer().writeInt(((Number) obj).intValue());
            return;
        }
        if (obj instanceof Long) {
            buffer.getBuffer().writeByte(2);
            buffer.getBuffer().writeLong(((Number) obj).longValue());
            return;
        }
        if (obj instanceof Double) {
            buffer.getBuffer().writeByte(4);
            writeString(buffer.getBuffer(), String.valueOf(((Number) obj).doubleValue()));
            return;
        }
        if (obj instanceof Boolean) {
            buffer.getBuffer().writeByte(3);
            buffer.getBuffer().writeByte(((Boolean) obj).booleanValue() ? 1 : 0);
            return;
        }
        if (obj instanceof CacheKey) {
            buffer.getBuffer().writeByte(7);
            writeString(buffer.getBuffer(), ((CacheKey) obj).getKey());
            return;
        }
        if (obj instanceof List) {
            buffer.getBuffer().writeByte(5);
            buffer.getBuffer().writeInt(((List) obj).size());
            Iterator it = ((Iterable) obj).iterator();
            while (it.hasNext()) {
                INSTANCE.writeAny(buffer.getBuffer(), it.next());
            }
            return;
        }
        if (!(obj instanceof Map)) {
            if (obj == null) {
                buffer.getBuffer().writeByte(8);
                return;
            }
            throw new IllegalStateException(("Trying to write unsupported Record value: " + obj).toString());
        }
        buffer.getBuffer().writeByte(6);
        Map map = (Map) obj;
        buffer.getBuffer().writeInt(map.size());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
        for (Map.Entry entry : map.entrySet()) {
            BlobRecordSerializer blobRecordSerializer = INSTANCE;
            blobRecordSerializer.writeString(buffer.getBuffer(), (String) entry.getKey());
            blobRecordSerializer.writeAny(buffer.getBuffer(), entry.getValue());
        }
    }

    private final Object readAny(Buffer buffer) throws EOFException {
        byte b = buffer.readByte();
        switch (b) {
            case 0:
                return readString(buffer);
            case 1:
                return Integer.valueOf(buffer.readInt());
            case 2:
                return Long.valueOf(buffer.readLong());
            case 3:
                return Boolean.valueOf(buffer.readByte() > 0);
            case 4:
                return Double.valueOf(Double.parseDouble(readString(buffer)));
            case 5:
                IntRange intRangeUntil = RangesKt.until(0, buffer.readInt());
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeUntil, 10));
                Iterator<Integer> it = intRangeUntil.iterator();
                while (it.hasNext()) {
                    ((IntIterator) it).nextInt();
                    arrayList.add(INSTANCE.readAny(buffer));
                }
                return arrayList;
            case 6:
                IntRange intRangeUntil2 = RangesKt.until(0, buffer.readInt());
                LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(intRangeUntil2, 10)), 16));
                Iterator<Integer> it2 = intRangeUntil2.iterator();
                while (it2.hasNext()) {
                    ((IntIterator) it2).nextInt();
                    BlobRecordSerializer blobRecordSerializer = INSTANCE;
                    Pair pair = TuplesKt.to(blobRecordSerializer.readString(buffer), blobRecordSerializer.readAny(buffer));
                    linkedHashMap.put(pair.getFirst(), pair.getSecond());
                }
                return linkedHashMap;
            case 7:
                return new CacheKey(readString(buffer));
            case 8:
                return null;
            default:
                throw new IllegalStateException(("Trying to read unsupported Record value: " + ((int) b)).toString());
        }
    }
}
