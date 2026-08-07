package com.apollographql.apollo3.cache.normalized.api;

import com.apollographql.apollo3.cache.normalized.api.internal.RecordWeigher;
import com.box.androidsdk.content.models.BoxOrder;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import io.split.android.client.dtos.Event;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.function.BiFunction;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: compiled from: Record.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0010&\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 72\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001:\u00017BK\b\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001\u0012\u000e\u0010\u0006\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b\u0012\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0001¢\u0006\u0002\u0010\u000bB5\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b¢\u0006\u0002\u0010\fJ\u0011\u0010(\u001a\u00020)2\u0006\u0010\u0004\u001a\u00020\u0002H\u0096\u0001J\u0013\u0010*\u001a\u00020)2\b\u0010+\u001a\u0004\u0018\u00010\u0003H\u0096\u0001J\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013J\u0013\u0010-\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\u0096\u0003J\t\u0010.\u001a\u00020)H\u0096\u0001J \u0010/\u001a\u0014\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0013002\u0006\u00101\u001a\u00020\u0000J1\u0010/\u001a\u0014\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0013002\u0006\u00101\u001a\u00020\u00002\b\u00102\u001a\u0004\u0018\u00010\nH\u0007¢\u0006\u0002\u00103J\f\u00104\u001a\b\u0012\u0004\u0012\u00020605RF\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u00012\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u00018\u0006@BX\u0087\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R&\u0010\u0012\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00140\u0013X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001f\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0016R\u0019\u0010\u0006\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0012\u0010\u001e\u001a\u00020\u001fX\u0096\u0005¢\u0006\u0006\u001a\u0004\b \u0010!R\u0011\u0010\"\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b#\u0010!R\u001a\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030%X\u0096\u0005¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u00068"}, d2 = {"Lcom/apollographql/apollo3/cache/normalized/api/Record;", "", "", "", "key", "fields", "mutationId", "Ljava/util/UUID;", "Lcom/benasher44/uuid/Uuid;", BoxOrder.SORT_DATE, "", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/UUID;Ljava/util/Map;)V", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/UUID;)V", "<set-?>", "getDate$annotations", "()V", "getDate", "()Ljava/util/Map;", "entries", "", "", "getEntries", "()Ljava/util/Set;", "getFields", "getKey", "()Ljava/lang/String;", "keys", "getKeys", "getMutationId", "()Ljava/util/UUID;", "size", "", "getSize", "()I", Event.SIZE_IN_BYTES_FIELD, "getSizeInBytes", "values", "", "getValues", "()Ljava/util/Collection;", "containsKey", "", "containsValue", "value", "fieldKeys", PasskeyWebListener.GET_UNIQUE_KEY, "isEmpty", "mergeWith", "Lkotlin/Pair;", "newRecord", "newDate", "(Lcom/apollographql/apollo3/cache/normalized/api/Record;Ljava/lang/Long;)Lkotlin/Pair;", "referencedFields", "", "Lcom/apollographql/apollo3/cache/normalized/api/CacheKey;", "Companion", "apollo-normalized-cache-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class Record implements Map<String, Object>, KMappedMarker {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Map<String, Long> date;
    private final Map<String, Object> fields;
    private final String key;
    private final UUID mutationId;

    public static /* synthetic */ void getDate$annotations() {
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object compute(String str, BiFunction<? super String, ? super Object, ? extends Object> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: renamed from: compute, reason: avoid collision after fix types in other method */
    public Object compute2(String str, BiFunction<? super String, ? super Object, ? extends Object> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object computeIfAbsent(String str, Function<? super String, ? extends Object> function) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: renamed from: computeIfAbsent, reason: avoid collision after fix types in other method */
    public Object computeIfAbsent2(String str, Function<? super String, ? extends Object> function) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object computeIfPresent(String str, BiFunction<? super String, ? super Object, ? extends Object> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: renamed from: computeIfPresent, reason: avoid collision after fix types in other method */
    public Object computeIfPresent2(String str, BiFunction<? super String, ? super Object, ? extends Object> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean containsKey(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.fields.containsKey(key);
    }

    @Override // java.util.Map
    public boolean containsValue(Object value) {
        return this.fields.containsValue(value);
    }

    public Object get(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.fields.get(key);
    }

    public Set<Map.Entry<String, Object>> getEntries() {
        return this.fields.entrySet();
    }

    public Set<String> getKeys() {
        return this.fields.keySet();
    }

    public int getSize() {
        return this.fields.size();
    }

    public Collection<Object> getValues() {
        return this.fields.values();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.fields.isEmpty();
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object merge(String str, Object obj, BiFunction<? super Object, ? super Object, ? extends Object> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: renamed from: merge, reason: avoid collision after fix types in other method */
    public Object merge2(String str, Object obj, BiFunction<? super Object, ? super Object, ? extends Object> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object put(String str, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: renamed from: put, reason: avoid collision after fix types in other method */
    public Object put2(String str, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends Object> map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object putIfAbsent(String str, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: renamed from: putIfAbsent, reason: avoid collision after fix types in other method */
    public Object putIfAbsent2(String str, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object replace(String str, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: renamed from: replace, reason: avoid collision after fix types in other method */
    public Object replace2(String str, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ boolean replace(String str, Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: renamed from: replace, reason: avoid collision after fix types in other method */
    public boolean replace2(String str, Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void replaceAll(BiFunction<? super String, ? super Object, ? extends Object> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Record(String key, Map<String, ? extends Object> fields, UUID uuid) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(fields, "fields");
        this.key = key;
        this.fields = fields;
        this.mutationId = uuid;
    }

    public /* synthetic */ Record(String str, Map map, UUID uuid, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, map, (i & 4) != 0 ? null : uuid);
    }

    @Override // java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        if (obj instanceof String) {
            return containsKey((String) obj);
        }
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<String, Object>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public final /* bridge */ Object get(Object obj) {
        if (obj instanceof String) {
            return get((String) obj);
        }
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<String> keySet() {
        return getKeys();
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<Object> values() {
        return getValues();
    }

    public final String getKey() {
        return this.key;
    }

    public final Map<String, Object> getFields() {
        return this.fields;
    }

    public final UUID getMutationId() {
        return this.mutationId;
    }

    public final Map<String, Long> getDate() {
        return this.date;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Record(String key, Map<String, ? extends Object> fields, UUID uuid, Map<String, Long> date) {
        this(key, fields, uuid);
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(fields, "fields");
        Intrinsics.checkNotNullParameter(date, "date");
        this.date = date;
    }

    public final int getSizeInBytes() {
        Map<String, Long> map = this.date;
        return RecordWeigher.calculateBytes(this) + (map != null ? map.size() * 8 : 0);
    }

    public final Pair<Record, Set<String>> mergeWith(Record newRecord, Long newDate) {
        LinkedHashMap linkedHashMap;
        Intrinsics.checkNotNullParameter(newRecord, "newRecord");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Map mutableMap = MapsKt.toMutableMap(this.fields);
        Map<String, Long> map = this.date;
        if (map == null || (linkedHashMap = MapsKt.toMutableMap(map)) == null) {
            linkedHashMap = new LinkedHashMap();
        }
        for (Map.Entry<String, Object> entry : newRecord.fields.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            boolean zContainsKey = this.fields.containsKey(key);
            Object obj = this.fields.get(key);
            if (!zContainsKey || !Intrinsics.areEqual(obj, value)) {
                mutableMap.put(key, value);
                linkedHashSet.add(this.key + '.' + key);
            }
            if (newDate != null) {
                linkedHashMap.put(key, newDate);
            }
        }
        return TuplesKt.to(new Record(this.key, mutableMap, newRecord.mutationId, linkedHashMap), linkedHashSet);
    }

    public final Pair<Record, Set<String>> mergeWith(Record newRecord) {
        Intrinsics.checkNotNullParameter(newRecord, "newRecord");
        return mergeWith(newRecord, null);
    }

    public final Set<String> fieldKeys() {
        Set<String> setKeySet = this.fields.keySet();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(setKeySet, 10));
        Iterator<T> it = setKeySet.iterator();
        while (it.hasNext()) {
            arrayList.add(this.key + '.' + ((String) it.next()));
        }
        return CollectionsKt.toSet(arrayList);
    }

    public final List<CacheKey> referencedFields() {
        ArrayList arrayList = new ArrayList();
        List mutableList = CollectionsKt.toMutableList((Collection) this.fields.values());
        while (!mutableList.isEmpty()) {
            Object objRemove = mutableList.remove(mutableList.size() - 1);
            if (objRemove instanceof CacheKey) {
                arrayList.add(objRemove);
            } else if (objRemove instanceof Map) {
                mutableList.addAll(((Map) objRemove).values());
            } else if (objRemove instanceof List) {
                mutableList.addAll((Collection) objRemove);
            }
        }
        return arrayList;
    }

    /* JADX INFO: compiled from: Record.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J#\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/apollographql/apollo3/cache/normalized/api/Record$Companion;", "", "()V", "changedKeys", "", "", "record1", "Lcom/apollographql/apollo3/cache/normalized/api/Record;", "record2", "changedKeys$apollo_normalized_cache_api", "apollo-normalized-cache-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Set<String> changedKeys$apollo_normalized_cache_api(Record record1, Record record2) {
            Intrinsics.checkNotNullParameter(record1, "record1");
            Intrinsics.checkNotNullParameter(record2, "record2");
            if (!Intrinsics.areEqual(record1.getKey(), record2.getKey())) {
                throw new IllegalStateException(("Cannot compute changed keys on record with different keys: '" + record1.getKey() + "' - '" + record2.getKey() + '\'').toString());
            }
            Set<String> setKeySet = record1.getFields().keySet();
            Set<String> setKeySet2 = record2.getFields().keySet();
            Set setIntersect = CollectionsKt.intersect(setKeySet, setKeySet2);
            Set setPlus = SetsKt.plus(SetsKt.minus((Set) setKeySet, (Iterable) setIntersect), (Iterable) SetsKt.minus((Set) setKeySet2, (Iterable) setIntersect));
            ArrayList arrayList = new ArrayList();
            for (Object obj : setIntersect) {
                String str = (String) obj;
                if (!Intrinsics.areEqual(record1.getFields().get(str), record2.getFields().get(str))) {
                    arrayList.add(obj);
                }
            }
            Set setPlus2 = SetsKt.plus(setPlus, (Iterable) arrayList);
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(setPlus2, 10));
            Iterator it = setPlus2.iterator();
            while (it.hasNext()) {
                arrayList2.add(record1.getKey() + '.' + ((String) it.next()));
            }
            return CollectionsKt.toSet(arrayList2);
        }
    }
}
