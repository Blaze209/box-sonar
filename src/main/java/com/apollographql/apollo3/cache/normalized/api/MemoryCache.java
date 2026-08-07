package com.apollographql.apollo3.cache.normalized.api;

import com.apollographql.apollo3.cache.normalized.api.internal.CacheLock;
import com.apollographql.apollo3.cache.normalized.api.internal.LruCache;
import com.apollographql.apollo3.mpp.UtilsKt;
import com.box.androidsdk.content.models.BoxFile;
import io.split.android.client.dtos.Event;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;
import kotlin.text.Regex;
import okio.internal._Utf8Kt;

/* JADX INFO: compiled from: MemoryCache.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001+B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\r\u0010\u0012\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0013J$\u0010\u0014\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00170\u00150\u0015H\u0016J\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u001e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001d2\u0006\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u001a\u0010\u001f\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J$\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00170!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000b0!2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u001e\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001d2\u0006\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J$\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001d2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00170!2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020&H\u0016J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006,"}, d2 = {"Lcom/apollographql/apollo3/cache/normalized/api/MemoryCache;", "Lcom/apollographql/apollo3/cache/normalized/api/NormalizedCache;", "maxSizeBytes", "", "expireAfterMillis", "", "(IJ)V", BoxFile.FIELD_LOCK, "Lcom/apollographql/apollo3/cache/normalized/api/internal/CacheLock;", "lruCache", "Lcom/apollographql/apollo3/cache/normalized/api/internal/LruCache;", "", "Lcom/apollographql/apollo3/cache/normalized/api/MemoryCache$CacheEntry;", "size", "getSize", "()I", "clearAll", "", "clearCurrentCache", "clearCurrentCache$apollo_normalized_cache_api", "dump", "", "Lkotlin/reflect/KClass;", "Lcom/apollographql/apollo3/cache/normalized/api/Record;", "internalLoadRecord", "key", "cacheHeaders", "Lcom/apollographql/apollo3/cache/normalized/api/CacheHeaders;", "internalMerge", "", "record", "loadRecord", "loadRecords", "", "keys", "merge", "records", "remove", "", "cacheKey", "Lcom/apollographql/apollo3/cache/normalized/api/CacheKey;", "cascade", "pattern", "CacheEntry", "apollo-normalized-cache-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class MemoryCache extends NormalizedCache {
    private final long expireAfterMillis;
    private final CacheLock lock;
    private final LruCache<String, CacheEntry> lruCache;
    private final int maxSizeBytes;

    public MemoryCache() {
        this(0, 0L, 3, null);
    }

    public /* synthetic */ MemoryCache(int i, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? Integer.MAX_VALUE : i, (i2 & 2) != 0 ? -1L : j);
    }

    public MemoryCache(int i, long j) {
        this.maxSizeBytes = i;
        this.expireAfterMillis = j;
        this.lock = new CacheLock();
        this.lruCache = new LruCache<>(i, new Function2<String, CacheEntry, Integer>() { // from class: com.apollographql.apollo3.cache.normalized.api.MemoryCache$lruCache$1
            @Override // kotlin.jvm.functions.Function2
            public final Integer invoke(String key, MemoryCache.CacheEntry cacheEntry) {
                Intrinsics.checkNotNullParameter(key, "key");
                return Integer.valueOf(_Utf8Kt.commonAsUtf8ToByteArray(key).length + (cacheEntry != null ? cacheEntry.getSizeInBytes() : 0));
            }
        });
    }

    public final int getSize() {
        return this.lruCache.getSize();
    }

    @Override // com.apollographql.apollo3.cache.normalized.api.ReadOnlyNormalizedCache
    public Record loadRecord(final String key, final CacheHeaders cacheHeaders) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(cacheHeaders, "cacheHeaders");
        return (Record) this.lock.lock(new Function0<Record>() { // from class: com.apollographql.apollo3.cache.normalized.api.MemoryCache.loadRecord.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Record invoke() {
                Record recordLoadRecord;
                Record recordInternalLoadRecord = MemoryCache.this.internalLoadRecord(key, cacheHeaders);
                if (recordInternalLoadRecord != null) {
                    return recordInternalLoadRecord;
                }
                NormalizedCache nextCache = MemoryCache.this.getNextCache();
                if (nextCache == null || (recordLoadRecord = nextCache.loadRecord(key, cacheHeaders)) == null) {
                    return null;
                }
                MemoryCache memoryCache = MemoryCache.this;
                memoryCache.lruCache.set(key, new CacheEntry(recordLoadRecord, memoryCache.expireAfterMillis));
                return recordLoadRecord;
            }
        });
    }

    @Override // com.apollographql.apollo3.cache.normalized.api.ReadOnlyNormalizedCache
    public Collection<Record> loadRecords(final Collection<String> keys, final CacheHeaders cacheHeaders) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        Intrinsics.checkNotNullParameter(cacheHeaders, "cacheHeaders");
        return (Collection) this.lock.lock(new Function0<List<? extends Record>>() { // from class: com.apollographql.apollo3.cache.normalized.api.MemoryCache.loadRecords.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends Record> invoke() {
                Collection<String> collection = keys;
                MemoryCache memoryCache = this;
                CacheHeaders cacheHeaders2 = cacheHeaders;
                LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(collection, 10)), 16));
                for (Object obj : collection) {
                    linkedHashMap.put(obj, memoryCache.internalLoadRecord((String) obj, cacheHeaders2));
                }
                LinkedHashMap linkedHashMap2 = linkedHashMap;
                LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                for (Map.Entry entry : linkedHashMap2.entrySet()) {
                    if (((Record) entry.getValue()) == null) {
                        linkedHashMap3.put(entry.getKey(), entry.getValue());
                    }
                }
                Set setKeySet = linkedHashMap3.keySet();
                NormalizedCache nextCache = this.getNextCache();
                List listLoadRecords = nextCache != null ? nextCache.loadRecords(setKeySet, cacheHeaders) : null;
                if (listLoadRecords == null) {
                    listLoadRecords = CollectionsKt.emptyList();
                }
                for (Record record : listLoadRecords) {
                    this.lruCache.set(record.getKey(), new CacheEntry(record, this.expireAfterMillis));
                }
                return CollectionsKt.plus((Collection) CollectionsKt.filterNotNull(linkedHashMap2.values()), (Iterable) listLoadRecords);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Record internalLoadRecord(String key, CacheHeaders cacheHeaders) {
        CacheEntry cacheEntry = this.lruCache.get(key);
        if (cacheEntry != null) {
            if (cacheEntry.isExpired() || cacheHeaders.hasHeader(ApolloCacheHeaders.EVICT_AFTER_READ)) {
                this.lruCache.remove(key);
            }
            if (cacheEntry.isExpired()) {
                cacheEntry = null;
            }
            if (cacheEntry != null) {
                return cacheEntry.getRecord();
            }
        }
        return null;
    }

    @Override // com.apollographql.apollo3.cache.normalized.api.NormalizedCache
    public void clearAll() {
        this.lruCache.clear();
        NormalizedCache nextCache = getNextCache();
        if (nextCache != null) {
            nextCache.clearAll();
        }
    }

    @Override // com.apollographql.apollo3.cache.normalized.api.NormalizedCache
    public boolean remove(CacheKey cacheKey, boolean cascade) {
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        CacheEntry cacheEntryRemove = this.lruCache.remove(cacheKey.getKey());
        if (cascade && cacheEntryRemove != null) {
            Iterator<CacheKey> it = cacheEntryRemove.getRecord().referencedFields().iterator();
            while (it.hasNext()) {
                remove(new CacheKey(it.next().getKey()), true);
            }
        }
        NormalizedCache nextCache = getNextCache();
        return cacheEntryRemove != null || (nextCache != null ? nextCache.remove(cacheKey, cascade) : false);
    }

    @Override // com.apollographql.apollo3.cache.normalized.api.NormalizedCache
    public int remove(String pattern) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        Regex regexPatternToRegex = NormalizedCache.INSTANCE.patternToRegex(pattern);
        int i = 0;
        for (String it : new HashSet(this.lruCache.keys())) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            if (regexPatternToRegex.matches(it)) {
                this.lruCache.remove(it);
                i++;
            }
        }
        NormalizedCache nextCache = getNextCache();
        return i + (nextCache != null ? nextCache.remove(pattern) : 0);
    }

    @Override // com.apollographql.apollo3.cache.normalized.api.NormalizedCache
    public Set<String> merge(Record record, CacheHeaders cacheHeaders) {
        Intrinsics.checkNotNullParameter(record, "record");
        Intrinsics.checkNotNullParameter(cacheHeaders, "cacheHeaders");
        if (cacheHeaders.hasHeader(ApolloCacheHeaders.DO_NOT_STORE)) {
            return SetsKt.emptySet();
        }
        Set<String> setInternalMerge = internalMerge(record, cacheHeaders);
        NormalizedCache nextCache = getNextCache();
        Set<String> setMerge = nextCache != null ? nextCache.merge(record, cacheHeaders) : null;
        if (setMerge == null) {
            setMerge = SetsKt.emptySet();
        }
        return SetsKt.plus((Set) setInternalMerge, (Iterable) setMerge);
    }

    @Override // com.apollographql.apollo3.cache.normalized.api.NormalizedCache
    public Set<String> merge(Collection<Record> records, CacheHeaders cacheHeaders) {
        Intrinsics.checkNotNullParameter(records, "records");
        Intrinsics.checkNotNullParameter(cacheHeaders, "cacheHeaders");
        if (cacheHeaders.hasHeader(ApolloCacheHeaders.DO_NOT_STORE)) {
            return SetsKt.emptySet();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = records.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(arrayList, internalMerge((Record) it.next(), cacheHeaders));
        }
        Set set = CollectionsKt.toSet(arrayList);
        NormalizedCache nextCache = getNextCache();
        Set<String> setMerge = nextCache != null ? nextCache.merge(records, cacheHeaders) : null;
        if (setMerge == null) {
            setMerge = SetsKt.emptySet();
        }
        return SetsKt.plus(set, (Iterable) setMerge);
    }

    private final Set<String> internalMerge(Record record, CacheHeaders cacheHeaders) {
        Record recordLoadRecord = loadRecord(record.getKey(), cacheHeaders);
        if (recordLoadRecord == null) {
            this.lruCache.set(record.getKey(), new CacheEntry(record, this.expireAfterMillis));
            return record.fieldKeys();
        }
        Pair<Record, Set<String>> pairMergeWith = recordLoadRecord.mergeWith(record);
        Record recordComponent1 = pairMergeWith.component1();
        Set<String> setComponent2 = pairMergeWith.component2();
        this.lruCache.set(record.getKey(), new CacheEntry(recordComponent1, this.expireAfterMillis));
        return setComponent2;
    }

    @Override // com.apollographql.apollo3.cache.normalized.api.ReadOnlyNormalizedCache
    public Map<KClass<?>, Map<String, Record>> dump() {
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(getClass());
        Map<String, CacheEntry> mapDump = this.lruCache.dump();
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(mapDump.size()));
        Iterator<T> it = mapDump.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), ((CacheEntry) entry.getValue()).getRecord());
        }
        Map mapMapOf = MapsKt.mapOf(TuplesKt.to(orCreateKotlinClass, linkedHashMap));
        NormalizedCache nextCache = getNextCache();
        Map<KClass<?>, Map<String, Record>> mapDump2 = nextCache != null ? nextCache.dump() : null;
        if (mapDump2 == null) {
            mapDump2 = MapsKt.emptyMap();
        }
        return MapsKt.plus(mapMapOf, mapDump2);
    }

    public final void clearCurrentCache$apollo_normalized_cache_api() {
        this.lruCache.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: MemoryCache.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/apollographql/apollo3/cache/normalized/api/MemoryCache$CacheEntry;", "", "record", "Lcom/apollographql/apollo3/cache/normalized/api/Record;", "expireAfterMillis", "", "(Lcom/apollographql/apollo3/cache/normalized/api/Record;J)V", "cachedAtMillis", "getCachedAtMillis", "()J", "getExpireAfterMillis", "isExpired", "", "()Z", "getRecord", "()Lcom/apollographql/apollo3/cache/normalized/api/Record;", Event.SIZE_IN_BYTES_FIELD, "", "getSizeInBytes", "()I", "apollo-normalized-cache-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
    static final class CacheEntry {
        private final long cachedAtMillis;
        private final long expireAfterMillis;
        private final Record record;
        private final int sizeInBytes;

        public CacheEntry(Record record, long j) {
            Intrinsics.checkNotNullParameter(record, "record");
            this.record = record;
            this.expireAfterMillis = j;
            this.cachedAtMillis = UtilsKt.currentTimeMillis();
            this.sizeInBytes = record.getSizeInBytes() + 8;
        }

        public final Record getRecord() {
            return this.record;
        }

        public final long getExpireAfterMillis() {
            return this.expireAfterMillis;
        }

        public final long getCachedAtMillis() {
            return this.cachedAtMillis;
        }

        public final int getSizeInBytes() {
            return this.sizeInBytes;
        }

        public final boolean isExpired() {
            return this.expireAfterMillis >= 0 && UtilsKt.currentTimeMillis() - this.cachedAtMillis >= this.expireAfterMillis;
        }
    }
}
