package com.apollographql.apollo3.cache.normalized.sql;

import com.apollographql.apollo3.cache.normalized.api.ApolloCacheHeaders;
import com.apollographql.apollo3.cache.normalized.api.CacheHeaders;
import com.apollographql.apollo3.cache.normalized.api.CacheKey;
import com.apollographql.apollo3.cache.normalized.api.NormalizedCache;
import com.apollographql.apollo3.cache.normalized.api.Record;
import com.apollographql.apollo3.cache.normalized.sql.internal.RecordDatabase;
import com.apollographql.apollo3.exception.ApolloExceptionHandlerKt;
import com.box.androidsdk.content.models.BoxOrder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: SqlNormalizedCache.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J$\u0010\u0007\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\b0\bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\rH\u0002J\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u0013H\u0002J%\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u00152\u0006\u0010\u0016\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0002\u0010\u0019J+\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\n0\u00152\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0002\u0010\u001cJ\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J$\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000b0\u00132\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u00132\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u001e\u0010!\u001a\b\u0012\u0004\u0012\u00020\n0\u00152\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J$\u0010!\u001a\b\u0012\u0004\u0012\u00020\n0\u00152\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00132\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0018\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u000f\u001a\u00020\rH\u0016J\u0010\u0010\"\u001a\u00020%2\u0006\u0010&\u001a\u00020\nH\u0016J\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018*\u00020\u001fH\u0002¢\u0006\u0002\u0010'J\u001b\u0010(\u001a\u00020\u000b*\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0002\u0010)R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/apollographql/apollo3/cache/normalized/sql/SqlNormalizedCache;", "Lcom/apollographql/apollo3/cache/normalized/api/NormalizedCache;", "recordDatabase", "Lcom/apollographql/apollo3/cache/normalized/sql/internal/RecordDatabase;", "(Lcom/apollographql/apollo3/cache/normalized/sql/internal/RecordDatabase;)V", "clearAll", "", "dump", "", "Lkotlin/reflect/KClass;", "", "Lcom/apollographql/apollo3/cache/normalized/api/Record;", "internalDeleteRecord", "", "key", "cascade", "internalGetRecords", "", "keys", "", "internalUpdateRecord", "", "record", BoxOrder.SORT_DATE, "", "(Lcom/apollographql/apollo3/cache/normalized/api/Record;Ljava/lang/Long;)Ljava/util/Set;", "internalUpdateRecords", "records", "(Ljava/util/Collection;Ljava/lang/Long;)Ljava/util/Set;", "loadRecord", "cacheHeaders", "Lcom/apollographql/apollo3/cache/normalized/api/CacheHeaders;", "loadRecords", "merge", "remove", "cacheKey", "Lcom/apollographql/apollo3/cache/normalized/api/CacheKey;", "", "pattern", "(Lcom/apollographql/apollo3/cache/normalized/api/CacheHeaders;)Ljava/lang/Long;", "withDate", "(Lcom/apollographql/apollo3/cache/normalized/api/Record;Ljava/lang/Long;)Lcom/apollographql/apollo3/cache/normalized/api/Record;", "apollo-normalized-cache-sqlite_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SqlNormalizedCache extends NormalizedCache {
    private final RecordDatabase recordDatabase;

    public SqlNormalizedCache(RecordDatabase recordDatabase) {
        Intrinsics.checkNotNullParameter(recordDatabase, "recordDatabase");
        this.recordDatabase = recordDatabase;
    }

    @Override // com.apollographql.apollo3.cache.normalized.api.ReadOnlyNormalizedCache
    public Record loadRecord(String key, CacheHeaders cacheHeaders) {
        Record recordSelect;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(cacheHeaders, "cacheHeaders");
        try {
            recordSelect = this.recordDatabase.select(key);
        } catch (Exception e) {
            ApolloExceptionHandlerKt.getApolloExceptionHandler().invoke(new Exception("Unable to read a record from the database", e));
            recordSelect = null;
        }
        if (recordSelect != null) {
            if (cacheHeaders.hasHeader(ApolloCacheHeaders.EVICT_AFTER_READ)) {
                this.recordDatabase.delete(key);
            }
            return recordSelect;
        }
        NormalizedCache nextCache = getNextCache();
        if (nextCache != null) {
            return nextCache.loadRecord(key, cacheHeaders);
        }
        return null;
    }

    @Override // com.apollographql.apollo3.cache.normalized.api.ReadOnlyNormalizedCache
    public Collection<Record> loadRecords(Collection<String> keys, CacheHeaders cacheHeaders) {
        List<Record> listEmptyList;
        NormalizedCache nextCache;
        Intrinsics.checkNotNullParameter(keys, "keys");
        Intrinsics.checkNotNullParameter(cacheHeaders, "cacheHeaders");
        try {
            listEmptyList = internalGetRecords(keys);
        } catch (Exception e) {
            ApolloExceptionHandlerKt.getApolloExceptionHandler().invoke(new Exception("Unable to read records from the database", e));
            listEmptyList = CollectionsKt.emptyList();
        }
        if (cacheHeaders.hasHeader(ApolloCacheHeaders.EVICT_AFTER_READ)) {
            Iterator<T> it = listEmptyList.iterator();
            while (it.hasNext()) {
                this.recordDatabase.delete(((Record) it.next()).getKey());
            }
        }
        Collection<String> collection = keys;
        List<Record> list = listEmptyList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(((Record) it2.next()).getKey());
        }
        List listMinus = CollectionsKt.minus((Iterable) collection, (Iterable) CollectionsKt.toSet(arrayList));
        List listEmptyList2 = null;
        if (listMinus.isEmpty()) {
            listMinus = null;
        }
        List list2 = listMinus;
        if (list2 != null && (nextCache = getNextCache()) != null) {
            listEmptyList2 = nextCache.loadRecords(list2, cacheHeaders);
        }
        if (listEmptyList2 == null) {
            listEmptyList2 = CollectionsKt.emptyList();
        }
        return CollectionsKt.plus((Collection) listEmptyList, (Iterable) listEmptyList2);
    }

    @Override // com.apollographql.apollo3.cache.normalized.api.NormalizedCache
    public void clearAll() {
        NormalizedCache nextCache = getNextCache();
        if (nextCache != null) {
            nextCache.clearAll();
        }
        this.recordDatabase.deleteAll();
    }

    @Override // com.apollographql.apollo3.cache.normalized.api.NormalizedCache
    public boolean remove(final CacheKey cacheKey, final boolean cascade) {
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        boolean zBooleanValue = ((Boolean) RecordDatabase.DefaultImpls.transaction$default(this.recordDatabase, false, new Function0<Boolean>() { // from class: com.apollographql.apollo3.cache.normalized.sql.SqlNormalizedCache$remove$selfRemoved$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(this.this$0.internalDeleteRecord(cacheKey.getKey(), cascade));
            }
        }, 1, null)).booleanValue();
        NormalizedCache nextCache = getNextCache();
        return zBooleanValue || (nextCache != null ? nextCache.remove(cacheKey, cascade) : false);
    }

    @Override // com.apollographql.apollo3.cache.normalized.api.NormalizedCache
    public int remove(final String pattern) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        final Ref.IntRef intRef = new Ref.IntRef();
        RecordDatabase.DefaultImpls.transaction$default(this.recordDatabase, false, new Function0<Unit>() { // from class: com.apollographql.apollo3.cache.normalized.sql.SqlNormalizedCache.remove.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                SqlNormalizedCache.this.recordDatabase.deleteMatching(pattern);
                intRef.element = (int) SqlNormalizedCache.this.recordDatabase.changes();
            }
        }, 1, null);
        NormalizedCache nextCache = getNextCache();
        return intRef.element + (nextCache != null ? nextCache.remove(pattern) : 0);
    }

    @Override // com.apollographql.apollo3.cache.normalized.api.NormalizedCache
    public Set<String> merge(Collection<Record> records, CacheHeaders cacheHeaders) {
        Intrinsics.checkNotNullParameter(records, "records");
        Intrinsics.checkNotNullParameter(cacheHeaders, "cacheHeaders");
        if (cacheHeaders.hasHeader(ApolloCacheHeaders.DO_NOT_STORE)) {
            return SetsKt.emptySet();
        }
        try {
            Set<String> setInternalUpdateRecords = internalUpdateRecords(records, date(cacheHeaders));
            NormalizedCache nextCache = getNextCache();
            Set<String> setMerge = nextCache != null ? nextCache.merge(records, cacheHeaders) : null;
            if (setMerge == null) {
                setMerge = SetsKt.emptySet();
            }
            return SetsKt.plus((Set) setInternalUpdateRecords, (Iterable) setMerge);
        } catch (Exception e) {
            ApolloExceptionHandlerKt.getApolloExceptionHandler().invoke(new Exception("Unable to merge records from the database", e));
            return SetsKt.emptySet();
        }
    }

    private final Long date(CacheHeaders cacheHeaders) {
        String strHeaderValue = cacheHeaders.headerValue(ApolloCacheHeaders.DATE);
        if (strHeaderValue != null) {
            return Long.valueOf(Long.parseLong(strHeaderValue));
        }
        return null;
    }

    @Override // com.apollographql.apollo3.cache.normalized.api.NormalizedCache
    public Set<String> merge(Record record, CacheHeaders cacheHeaders) {
        Intrinsics.checkNotNullParameter(record, "record");
        Intrinsics.checkNotNullParameter(cacheHeaders, "cacheHeaders");
        if (cacheHeaders.hasHeader(ApolloCacheHeaders.DO_NOT_STORE)) {
            return SetsKt.emptySet();
        }
        try {
            Set<String> setInternalUpdateRecord = internalUpdateRecord(record, date(cacheHeaders));
            NormalizedCache nextCache = getNextCache();
            Set<String> setMerge = nextCache != null ? nextCache.merge(record, cacheHeaders) : null;
            if (setMerge == null) {
                setMerge = SetsKt.emptySet();
            }
            return SetsKt.plus((Set) setInternalUpdateRecord, (Iterable) setMerge);
        } catch (Exception e) {
            ApolloExceptionHandlerKt.getApolloExceptionHandler().invoke(new Exception("Unable to merge a record from the database", e));
            return SetsKt.emptySet();
        }
    }

    @Override // com.apollographql.apollo3.cache.normalized.api.ReadOnlyNormalizedCache
    public Map<KClass<?>, Map<String, Record>> dump() {
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(getClass());
        List<Record> listSelectAll = this.recordDatabase.selectAll();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(listSelectAll, 10)), 16));
        for (Object obj : listSelectAll) {
            linkedHashMap.put(((Record) obj).getKey(), obj);
        }
        Map mapMapOf = MapsKt.mapOf(TuplesKt.to(orCreateKotlinClass, linkedHashMap));
        NormalizedCache nextCache = getNextCache();
        Map<KClass<?>, Map<String, Record>> mapDump = nextCache != null ? nextCache.dump() : null;
        if (mapDump == null) {
            mapDump = MapsKt.emptyMap();
        }
        return MapsKt.plus(mapMapOf, mapDump);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean internalDeleteRecord(String key, boolean cascade) {
        Record recordSelect;
        List<CacheKey> listReferencedFields;
        if (cascade && (recordSelect = this.recordDatabase.select(key)) != null && (listReferencedFields = recordSelect.referencedFields()) != null) {
            Iterator<T> it = listReferencedFields.iterator();
            while (it.hasNext()) {
                internalDeleteRecord(((CacheKey) it.next()).getKey(), true);
            }
        }
        this.recordDatabase.delete(key);
        return this.recordDatabase.changes() > 0;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [T, java.util.Set] */
    private final Set<String> internalUpdateRecords(final Collection<Record> records, final Long date) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = SetsKt.emptySet();
        RecordDatabase.DefaultImpls.transaction$default(this.recordDatabase, false, new Function0<Unit>() { // from class: com.apollographql.apollo3.cache.normalized.sql.SqlNormalizedCache.internalUpdateRecords.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r8v2, types: [T, java.util.Set] */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Set<String> setComponent2;
                SqlNormalizedCache sqlNormalizedCache = SqlNormalizedCache.this;
                Collection<Record> collection = records;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection, 10));
                Iterator<T> it = collection.iterator();
                while (it.hasNext()) {
                    arrayList.add(((Record) it.next()).getKey());
                }
                List listInternalGetRecords = sqlNormalizedCache.internalGetRecords(arrayList);
                LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(listInternalGetRecords, 10)), 16));
                for (Object obj : listInternalGetRecords) {
                    linkedHashMap.put(((Record) obj).getKey(), obj);
                }
                Ref.ObjectRef<Set<String>> objectRef2 = objectRef;
                Collection<Record> collection2 = records;
                SqlNormalizedCache sqlNormalizedCache2 = SqlNormalizedCache.this;
                Long l = date;
                ArrayList arrayList2 = new ArrayList();
                for (Record record : collection2) {
                    Record record2 = (Record) linkedHashMap.get(record.getKey());
                    if (record2 == null) {
                        sqlNormalizedCache2.recordDatabase.insert(sqlNormalizedCache2.withDate(record, l));
                        setComponent2 = record.fieldKeys();
                    } else {
                        Pair<Record, Set<String>> pairMergeWith = record2.mergeWith(record, l);
                        Record recordComponent1 = pairMergeWith.component1();
                        setComponent2 = pairMergeWith.component2();
                        if (!recordComponent1.isEmpty()) {
                            sqlNormalizedCache2.recordDatabase.update(recordComponent1);
                        }
                    }
                    CollectionsKt.addAll(arrayList2, setComponent2);
                }
                objectRef2.element = CollectionsKt.toSet(arrayList2);
            }
        }, 1, null);
        return (Set) objectRef.element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Record withDate(Record record, Long l) {
        if (l == null) {
            return record;
        }
        String key = record.getKey();
        Map<String, Object> fields = record.getFields();
        UUID mutationId = record.getMutationId();
        Map<String, Object> fields2 = record.getFields();
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(fields2.size()));
        Iterator<T> it = fields2.entrySet().iterator();
        while (it.hasNext()) {
            linkedHashMap.put(((Map.Entry) it.next()).getKey(), Long.valueOf(l.longValue()));
        }
        return new Record(key, fields, mutationId, linkedHashMap);
    }

    private final Set<String> internalUpdateRecord(final Record record, final Long date) {
        return (Set) RecordDatabase.DefaultImpls.transaction$default(this.recordDatabase, false, new Function0<Set<? extends String>>() { // from class: com.apollographql.apollo3.cache.normalized.sql.SqlNormalizedCache.internalUpdateRecord.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Set<? extends String> invoke() {
                Record recordSelect = SqlNormalizedCache.this.recordDatabase.select(record.getKey());
                if (recordSelect == null) {
                    SqlNormalizedCache.this.recordDatabase.insert(SqlNormalizedCache.this.withDate(record, date));
                    return record.fieldKeys();
                }
                Pair<Record, Set<String>> pairMergeWith = recordSelect.mergeWith(record, date);
                Record recordComponent1 = pairMergeWith.component1();
                Set<String> setComponent2 = pairMergeWith.component2();
                if (!recordComponent1.isEmpty()) {
                    SqlNormalizedCache.this.recordDatabase.update(recordComponent1);
                }
                return setComponent2;
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Record> internalGetRecords(Collection<String> keys) {
        List listChunked = CollectionsKt.chunked(keys, 999);
        ArrayList arrayList = new ArrayList();
        Iterator it = listChunked.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(arrayList, this.recordDatabase.select((List) it.next()));
        }
        return arrayList;
    }
}
