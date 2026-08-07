package com.apollographql.apollo3.cache.normalized.api.internal;

import com.apollographql.apollo3.cache.normalized.api.CacheHeaders;
import com.apollographql.apollo3.cache.normalized.api.CacheKey;
import com.apollographql.apollo3.cache.normalized.api.NormalizedCache;
import com.apollographql.apollo3.cache.normalized.api.Record;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;
import kotlin.text.Regex;

/* JADX INFO: compiled from: OptimisticCache.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0002'(B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\t\u001a\u00020\nJ\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J$\u0010\u0010\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0012\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\u00110\u0011H\u0016J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J$\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\r2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\r2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u001e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J$\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\n0\r2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001cH\u0016J\u0010\u0010\u001b\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0005H\u0016J\u0018\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\n\u0010#\u001a\u00060$j\u0002`%J\u0018\u0010&\u001a\u0004\u0018\u00010\n*\u0004\u0018\u00010\n2\u0006\u0010\u0014\u001a\u00020\u0005H\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/apollographql/apollo3/cache/normalized/api/internal/OptimisticCache;", "Lcom/apollographql/apollo3/cache/normalized/api/NormalizedCache;", "()V", "recordJournals", "", "", "Lcom/apollographql/apollo3/cache/normalized/api/internal/OptimisticCache$RecordJournal;", "addOptimisticUpdate", "", "record", "Lcom/apollographql/apollo3/cache/normalized/api/Record;", "addOptimisticUpdates", "recordSet", "", "clearAll", "", "dump", "", "Lkotlin/reflect/KClass;", "loadRecord", "key", "cacheHeaders", "Lcom/apollographql/apollo3/cache/normalized/api/CacheHeaders;", "loadRecords", "keys", "merge", "records", "remove", "", "cacheKey", "Lcom/apollographql/apollo3/cache/normalized/api/CacheKey;", "cascade", "", "pattern", "removeOptimisticUpdates", "mutationId", "Ljava/util/UUID;", "Lcom/benasher44/uuid/Uuid;", "mergeJournalRecord", "RecordJournal", "RemovalResult", "apollo-normalized-cache-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class OptimisticCache extends NormalizedCache {
    private final Map<String, RecordJournal> recordJournals = new LinkedHashMap();

    @Override // com.apollographql.apollo3.cache.normalized.api.ReadOnlyNormalizedCache
    public Record loadRecord(String key, CacheHeaders cacheHeaders) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(cacheHeaders, "cacheHeaders");
        try {
            NormalizedCache nextCache = getNextCache();
            return mergeJournalRecord(nextCache != null ? nextCache.loadRecord(key, cacheHeaders) : null, key);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.apollographql.apollo3.cache.normalized.api.ReadOnlyNormalizedCache
    public Collection<Record> loadRecords(Collection<String> keys, CacheHeaders cacheHeaders) {
        LinkedHashMap linkedHashMapEmptyMap;
        Collection<Record> collectionLoadRecords;
        Intrinsics.checkNotNullParameter(keys, "keys");
        Intrinsics.checkNotNullParameter(cacheHeaders, "cacheHeaders");
        NormalizedCache nextCache = getNextCache();
        if (nextCache == null || (collectionLoadRecords = nextCache.loadRecords(keys, cacheHeaders)) == null) {
            linkedHashMapEmptyMap = MapsKt.emptyMap();
        } else {
            Collection<Record> collection = collectionLoadRecords;
            linkedHashMapEmptyMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(collection, 10)), 16));
            for (Object obj : collection) {
                linkedHashMapEmptyMap.put(((Record) obj).getKey(), obj);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (String str : keys) {
            Record recordMergeJournalRecord = mergeJournalRecord((Record) linkedHashMapEmptyMap.get(str), str);
            if (recordMergeJournalRecord != null) {
                arrayList.add(recordMergeJournalRecord);
            }
        }
        return arrayList;
    }

    @Override // com.apollographql.apollo3.cache.normalized.api.NormalizedCache
    public Set<String> merge(Record record, CacheHeaders cacheHeaders) {
        Set<String> setMerge;
        Intrinsics.checkNotNullParameter(record, "record");
        Intrinsics.checkNotNullParameter(cacheHeaders, "cacheHeaders");
        NormalizedCache nextCache = getNextCache();
        return (nextCache == null || (setMerge = nextCache.merge(record, cacheHeaders)) == null) ? SetsKt.emptySet() : setMerge;
    }

    @Override // com.apollographql.apollo3.cache.normalized.api.NormalizedCache
    public Set<String> merge(Collection<Record> records, CacheHeaders cacheHeaders) {
        Set<String> setMerge;
        Intrinsics.checkNotNullParameter(records, "records");
        Intrinsics.checkNotNullParameter(cacheHeaders, "cacheHeaders");
        NormalizedCache nextCache = getNextCache();
        return (nextCache == null || (setMerge = nextCache.merge(records, cacheHeaders)) == null) ? SetsKt.emptySet() : setMerge;
    }

    @Override // com.apollographql.apollo3.cache.normalized.api.NormalizedCache
    public void clearAll() {
        this.recordJournals.clear();
        NormalizedCache nextCache = getNextCache();
        if (nextCache != null) {
            nextCache.clearAll();
        }
    }

    @Override // com.apollographql.apollo3.cache.normalized.api.NormalizedCache
    public boolean remove(CacheKey cacheKey, boolean cascade) {
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        NormalizedCache nextCache = getNextCache();
        boolean zRemove = nextCache != null ? nextCache.remove(cacheKey, cascade) : false;
        RecordJournal recordJournal = this.recordJournals.get(cacheKey.getKey());
        if (recordJournal == null) {
            return zRemove;
        }
        this.recordJournals.remove(cacheKey.getKey());
        if (!cascade) {
            return true;
        }
        while (true) {
            boolean z = true;
            for (CacheKey cacheKey2 : recordJournal.getCurrent().referencedFields()) {
                if (!z || !remove(new CacheKey(cacheKey2.getKey()), true)) {
                    z = false;
                }
            }
            return z;
        }
    }

    @Override // com.apollographql.apollo3.cache.normalized.api.NormalizedCache
    public int remove(String pattern) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        Regex regexPatternToRegex = NormalizedCache.INSTANCE.patternToRegex(pattern);
        Iterator<Map.Entry<String, RecordJournal>> it = this.recordJournals.entrySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            if (regexPatternToRegex.matches(it.next().getKey())) {
                it.remove();
                i++;
            }
        }
        NormalizedCache nextCache = getNextCache();
        return i + (nextCache != null ? nextCache.remove(pattern) : 0);
    }

    public final Set<String> addOptimisticUpdates(Collection<Record> recordSet) {
        Intrinsics.checkNotNullParameter(recordSet, "recordSet");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = recordSet.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(arrayList, addOptimisticUpdate((Record) it.next()));
        }
        return CollectionsKt.toSet(arrayList);
    }

    public final Set<String> addOptimisticUpdate(Record record) {
        Intrinsics.checkNotNullParameter(record, "record");
        RecordJournal recordJournal = this.recordJournals.get(record.getKey());
        if (recordJournal == null) {
            this.recordJournals.put(record.getKey(), new RecordJournal(record));
            return record.fieldKeys();
        }
        return recordJournal.addPatch(record);
    }

    public final Set<String> removeOptimisticUpdates(UUID mutationId) {
        Intrinsics.checkNotNullParameter(mutationId, "mutationId");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<Map.Entry<String, RecordJournal>> it = this.recordJournals.entrySet().iterator();
        while (it.hasNext()) {
            RemovalResult removalResultRemovePatch = it.next().getValue().removePatch(mutationId);
            linkedHashSet.addAll(removalResultRemovePatch.getChangedKeys());
            if (removalResultRemovePatch.getIsEmpty()) {
                it.remove();
            }
        }
        return linkedHashSet;
    }

    @Override // com.apollographql.apollo3.cache.normalized.api.ReadOnlyNormalizedCache
    public Map<KClass<?>, Map<String, Record>> dump() {
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(getClass());
        Map<String, RecordJournal> map = this.recordJournals;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), ((RecordJournal) entry.getValue()).getCurrent());
        }
        Map mapMapOf = MapsKt.mapOf(TuplesKt.to(orCreateKotlinClass, linkedHashMap));
        NormalizedCache nextCache = getNextCache();
        Map<KClass<?>, Map<String, Record>> mapDump = nextCache != null ? nextCache.dump() : null;
        if (mapDump == null) {
            mapDump = MapsKt.emptyMap();
        }
        return MapsKt.plus(mapMapOf, mapDump);
    }

    private final Record mergeJournalRecord(Record record, String str) {
        Pair<Record, Set<String>> pairMergeWith;
        Record first;
        RecordJournal recordJournal = this.recordJournals.get(str);
        if (recordJournal != null) {
            return (record == null || (pairMergeWith = record.mergeWith(recordJournal.getCurrent())) == null || (first = pairMergeWith.getFirst()) == null) ? recordJournal.getCurrent() : first;
        }
        return record;
    }

    /* JADX INFO: compiled from: OptimisticCache.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/apollographql/apollo3/cache/normalized/api/internal/OptimisticCache$RemovalResult;", "", "changedKeys", "", "", "isEmpty", "", "(Ljava/util/Set;Z)V", "getChangedKeys", "()Ljava/util/Set;", "()Z", "apollo-normalized-cache-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class RemovalResult {
        private final Set<String> changedKeys;
        private final boolean isEmpty;

        public RemovalResult(Set<String> changedKeys, boolean z) {
            Intrinsics.checkNotNullParameter(changedKeys, "changedKeys");
            this.changedKeys = changedKeys;
            this.isEmpty = z;
        }

        public final Set<String> getChangedKeys() {
            return this.changedKeys;
        }

        /* JADX INFO: renamed from: isEmpty, reason: from getter */
        public final boolean getIsEmpty() {
            return this.isEmpty;
        }
    }

    /* JADX INFO: compiled from: OptimisticCache.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0002\u001a\u00020\u0003J\u0012\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u00060\u0011j\u0002`\u0012R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/apollographql/apollo3/cache/normalized/api/internal/OptimisticCache$RecordJournal;", "", "record", "Lcom/apollographql/apollo3/cache/normalized/api/Record;", "(Lcom/apollographql/apollo3/cache/normalized/api/Record;)V", "current", "getCurrent", "()Lcom/apollographql/apollo3/cache/normalized/api/Record;", "setCurrent", "patches", "", "addPatch", "", "", "removePatch", "Lcom/apollographql/apollo3/cache/normalized/api/internal/OptimisticCache$RemovalResult;", "mutationId", "Ljava/util/UUID;", "Lcom/benasher44/uuid/Uuid;", "apollo-normalized-cache-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class RecordJournal {
        private Record current;
        private final List<Record> patches;

        public RecordJournal(Record record) {
            Intrinsics.checkNotNullParameter(record, "record");
            this.current = record;
            this.patches = CollectionsKt.mutableListOf(record);
        }

        public final Record getCurrent() {
            return this.current;
        }

        public final void setCurrent(Record record) {
            Intrinsics.checkNotNullParameter(record, "<set-?>");
            this.current = record;
        }

        public final Set<String> addPatch(Record record) {
            Intrinsics.checkNotNullParameter(record, "record");
            Pair<Record, Set<String>> pairMergeWith = this.current.mergeWith(record);
            Record recordComponent1 = pairMergeWith.component1();
            Set<String> setComponent2 = pairMergeWith.component2();
            this.current = recordComponent1;
            this.patches.add(record);
            return setComponent2;
        }

        public final RemovalResult removePatch(UUID mutationId) {
            Intrinsics.checkNotNullParameter(mutationId, "mutationId");
            Iterator<Record> it = this.patches.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                }
                if (Intrinsics.areEqual(mutationId, it.next().getMutationId())) {
                    break;
                }
                i++;
            }
            if (i == -1) {
                return new RemovalResult(SetsKt.emptySet(), false);
            }
            if (this.patches.size() == 1) {
                return new RemovalResult(this.current.fieldKeys(), true);
            }
            Record record = this.current;
            this.patches.remove(i).getKey();
            int size = this.patches.size();
            Record recordComponent1 = null;
            for (int iMax = Math.max(0, i - 1); iMax < size; iMax++) {
                Record record2 = this.patches.get(iMax);
                recordComponent1 = recordComponent1 == null ? record2 : recordComponent1.mergeWith(record2).component1();
            }
            Intrinsics.checkNotNull(recordComponent1);
            this.current = recordComponent1;
            return new RemovalResult(Record.INSTANCE.changedKeys$apollo_normalized_cache_api(record, this.current), false);
        }
    }
}
