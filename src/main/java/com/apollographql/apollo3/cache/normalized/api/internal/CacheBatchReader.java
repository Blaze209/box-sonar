package com.apollographql.apollo3.cache.normalized.api.internal;

import com.apollographql.apollo3.api.CompiledField;
import com.apollographql.apollo3.api.CompiledFragment;
import com.apollographql.apollo3.api.CompiledSelection;
import com.apollographql.apollo3.api.Executable;
import com.apollographql.apollo3.cache.normalized.api.CacheHeaders;
import com.apollographql.apollo3.cache.normalized.api.CacheKey;
import com.apollographql.apollo3.cache.normalized.api.CacheResolver;
import com.apollographql.apollo3.cache.normalized.api.ReadOnlyNormalizedCache;
import com.apollographql.apollo3.cache.normalized.api.Record;
import com.apollographql.apollo3.exception.CacheMissException;
import com.box.android.data.datasource.gql.cache.GQLCacheConstants;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: CacheBatchReader.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010$\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001:\u0002$%BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0010\u000f\u001a\u00020\u0005¢\u0006\u0002\u0010\u0010J0\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J.\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\r2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005H\u0002J\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0013J2\u0010!\u001a\u00020\u0018*\u0004\u0018\u00010\u00012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u001a\u001a\u00020\u0005H\u0002J\u001e\u0010#\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u00012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00010\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010\u0011\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\r\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/apollographql/apollo3/cache/normalized/api/internal/CacheBatchReader;", "", SemanticAttributes.DbSystemValues.CACHE, "Lcom/apollographql/apollo3/cache/normalized/api/ReadOnlyNormalizedCache;", "rootKey", "", "variables", "Lcom/apollographql/apollo3/api/Executable$Variables;", "cacheResolver", "Lcom/apollographql/apollo3/cache/normalized/api/CacheResolver;", "cacheHeaders", "Lcom/apollographql/apollo3/cache/normalized/api/CacheHeaders;", "rootSelections", "", "Lcom/apollographql/apollo3/api/CompiledSelection;", "rootTypename", "(Lcom/apollographql/apollo3/cache/normalized/api/ReadOnlyNormalizedCache;Ljava/lang/String;Lcom/apollographql/apollo3/api/Executable$Variables;Lcom/apollographql/apollo3/cache/normalized/api/CacheResolver;Lcom/apollographql/apollo3/cache/normalized/api/CacheHeaders;Ljava/util/List;Ljava/lang/String;)V", "data", "", "", "pendingReferences", "", "Lcom/apollographql/apollo3/cache/normalized/api/internal/CacheBatchReader$PendingReference;", "collect", "", "selections", "parentType", "typename", "state", "Lcom/apollographql/apollo3/cache/normalized/api/internal/CacheBatchReader$CollectState;", "collectAndMergeSameDirectives", "Lcom/apollographql/apollo3/api/CompiledField;", "toMap", "registerCacheKeys", "path", "replaceCacheKeys", "CollectState", "PendingReference", "apollo-normalized-cache-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class CacheBatchReader {
    private final ReadOnlyNormalizedCache cache;
    private final CacheHeaders cacheHeaders;
    private final CacheResolver cacheResolver;
    private final Map<List<Object>, Map<String, Object>> data;
    private final List<PendingReference> pendingReferences;
    private final String rootKey;
    private final List<CompiledSelection> rootSelections;
    private final String rootTypename;
    private final Executable.Variables variables;

    /* JADX WARN: Multi-variable type inference failed */
    public CacheBatchReader(ReadOnlyNormalizedCache cache, String rootKey, Executable.Variables variables, CacheResolver cacheResolver, CacheHeaders cacheHeaders, List<? extends CompiledSelection> rootSelections, String rootTypename) {
        Intrinsics.checkNotNullParameter(cache, "cache");
        Intrinsics.checkNotNullParameter(rootKey, "rootKey");
        Intrinsics.checkNotNullParameter(variables, "variables");
        Intrinsics.checkNotNullParameter(cacheResolver, "cacheResolver");
        Intrinsics.checkNotNullParameter(cacheHeaders, "cacheHeaders");
        Intrinsics.checkNotNullParameter(rootSelections, "rootSelections");
        Intrinsics.checkNotNullParameter(rootTypename, "rootTypename");
        this.cache = cache;
        this.rootKey = rootKey;
        this.variables = variables;
        this.cacheResolver = cacheResolver;
        this.cacheHeaders = cacheHeaders;
        this.rootSelections = rootSelections;
        this.rootTypename = rootTypename;
        this.data = new LinkedHashMap();
        this.pendingReferences = new ArrayList();
    }

    /* JADX INFO: compiled from: CacheBatchReader.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/apollographql/apollo3/cache/normalized/api/internal/CacheBatchReader$PendingReference;", "", "key", "", "path", "", "selections", "Lcom/apollographql/apollo3/api/CompiledSelection;", "parentType", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "getParentType", "getPath", "()Ljava/util/List;", "getSelections", "apollo-normalized-cache-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class PendingReference {
        private final String key;
        private final String parentType;
        private final List<Object> path;
        private final List<CompiledSelection> selections;

        /* JADX WARN: Multi-variable type inference failed */
        public PendingReference(String key, List<? extends Object> path, List<? extends CompiledSelection> selections, String parentType) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(path, "path");
            Intrinsics.checkNotNullParameter(selections, "selections");
            Intrinsics.checkNotNullParameter(parentType, "parentType");
            this.key = key;
            this.path = path;
            this.selections = selections;
            this.parentType = parentType;
        }

        public final String getKey() {
            return this.key;
        }

        public final List<Object> getPath() {
            return this.path;
        }

        public final List<CompiledSelection> getSelections() {
            return this.selections;
        }

        public final String getParentType() {
            return this.parentType;
        }
    }

    /* JADX INFO: compiled from: CacheBatchReader.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/apollographql/apollo3/cache/normalized/api/internal/CacheBatchReader$CollectState;", "", "()V", "fields", "", "Lcom/apollographql/apollo3/api/CompiledField;", "getFields", "()Ljava/util/List;", "apollo-normalized-cache-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class CollectState {
        private final List<CompiledField> fields = new ArrayList();

        public final List<CompiledField> getFields() {
            return this.fields;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void collect(List<? extends CompiledSelection> selections, String parentType, String typename, CollectState state) {
        for (CompiledSelection compiledSelection : selections) {
            if (compiledSelection instanceof CompiledField) {
                state.getFields().add(compiledSelection);
            } else if (compiledSelection instanceof CompiledFragment) {
                CompiledFragment compiledFragment = (CompiledFragment) compiledSelection;
                if (CollectionsKt.contains(compiledFragment.getPossibleTypes(), typename) || Intrinsics.areEqual(compiledFragment.getTypeCondition(), parentType)) {
                    collect(compiledFragment.getSelections(), parentType, typename, state);
                }
            }
        }
    }

    private final List<CompiledField> collectAndMergeSameDirectives(List<? extends CompiledSelection> selections, String parentType, String typename) {
        CollectState collectState = new CollectState();
        collect(selections, parentType, typename, collectState);
        List<CompiledField> fields = collectState.getFields();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : fields) {
            CompiledField compiledField = (CompiledField) obj;
            Pair pair = TuplesKt.to(compiledField.getResponseName(), compiledField.getCondition());
            Object obj2 = linkedHashMap.get(pair);
            if (obj2 == null) {
                obj2 = (List) new ArrayList();
                linkedHashMap.put(pair, obj2);
            }
            ((List) obj2).add(obj);
        }
        Collection<List> collectionValues = linkedHashMap.values();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collectionValues, 10));
        for (List list : collectionValues) {
            CompiledField.Builder builderNewBuilder = ((CompiledField) CollectionsKt.first(list)).newBuilder();
            ArrayList arrayList2 = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                CollectionsKt.addAll(arrayList2, ((CompiledField) it.next()).getSelections());
            }
            arrayList.add(builderNewBuilder.selections(arrayList2).build());
        }
        return arrayList;
    }

    public final Map<String, Object> toMap() {
        Pair pair;
        this.pendingReferences.add(new PendingReference(this.rootKey, CollectionsKt.emptyList(), this.rootSelections, this.rootTypename));
        while (!this.pendingReferences.isEmpty()) {
            ReadOnlyNormalizedCache readOnlyNormalizedCache = this.cache;
            List<PendingReference> list = this.pendingReferences;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((PendingReference) it.next()).getKey());
            }
            Collection<Record> collectionLoadRecords = readOnlyNormalizedCache.loadRecords(arrayList, this.cacheHeaders);
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(collectionLoadRecords, 10)), 16));
            for (Object obj : collectionLoadRecords) {
                linkedHashMap.put(((Record) obj).getKey(), obj);
            }
            List<PendingReference> list2 = CollectionsKt.toList(this.pendingReferences);
            this.pendingReferences.clear();
            for (PendingReference pendingReference : list2) {
                Object record = linkedHashMap.get(pendingReference.getKey());
                if (record == null) {
                    if (!Intrinsics.areEqual(pendingReference.getKey(), CacheKey.INSTANCE.rootKey().getKey())) {
                        throw new CacheMissException(pendingReference.getKey(), null, false, 6, null);
                    }
                    record = new Record(pendingReference.getKey(), MapsKt.emptyMap(), null, 4, null);
                }
                List<CompiledSelection> selections = pendingReference.getSelections();
                String parentType = pendingReference.getParentType();
                Record record2 = (Record) record;
                Object obj2 = record2.get((Object) GQLCacheConstants.TYPENAME_KEY);
                List<CompiledField> listCollectAndMergeSameDirectives = collectAndMergeSameDirectives(selections, parentType, obj2 instanceof String ? (String) obj2 : null);
                ArrayList arrayList2 = new ArrayList();
                for (CompiledField compiledField : listCollectAndMergeSameDirectives) {
                    if (ShouldSkipKt.shouldSkip(compiledField, this.variables.getValueMap())) {
                        pair = null;
                    } else {
                        Object objResolveField = this.cacheResolver.resolveField(compiledField, this.variables, (Map) record, record2.getKey());
                        registerCacheKeys(objResolveField, CollectionsKt.plus((Collection<? extends String>) pendingReference.getPath(), compiledField.getResponseName()), compiledField.getSelections(), compiledField.getType().rawType().getName());
                        pair = TuplesKt.to(compiledField.getResponseName(), objResolveField);
                    }
                    if (pair != null) {
                        arrayList2.add(pair);
                    }
                }
                this.data.put(pendingReference.getPath(), MapsKt.toMap(arrayList2));
            }
        }
        Object objReplaceCacheKeys = replaceCacheKeys(this.data.get(CollectionsKt.emptyList()), CollectionsKt.emptyList());
        Intrinsics.checkNotNull(objReplaceCacheKeys, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
        return (Map) objReplaceCacheKeys;
    }

    private final void registerCacheKeys(Object obj, List<? extends Object> list, List<? extends CompiledSelection> list2, String str) {
        if (obj instanceof CacheKey) {
            this.pendingReferences.add(new PendingReference(((CacheKey) obj).getKey(), list, list2, str));
            return;
        }
        if (obj instanceof List) {
            int i = 0;
            for (Object obj2 : (Iterable) obj) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                registerCacheKeys(obj2, CollectionsKt.plus((Collection<? extends Integer>) list, Integer.valueOf(i)), list2, str);
                i = i2;
            }
        }
    }

    private final Object replaceCacheKeys(Object obj, List<? extends Object> list) {
        if (obj instanceof CacheKey) {
            return replaceCacheKeys(this.data.get(list), list);
        }
        if (obj instanceof List) {
            Iterable iterable = (Iterable) obj;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            int i = 0;
            for (Object obj2 : iterable) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                arrayList.add(replaceCacheKeys(obj2, CollectionsKt.plus((Collection<? extends Integer>) list, Integer.valueOf(i))));
                i = i2;
            }
            return arrayList;
        }
        if (!(obj instanceof Map)) {
            return obj;
        }
        Map map = (Map) obj;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            Object key2 = entry.getKey();
            Intrinsics.checkNotNull(key2, "null cannot be cast to non-null type kotlin.String");
            linkedHashMap.put(key, replaceCacheKeys(value, CollectionsKt.plus((Collection<? extends String>) list, (String) key2)));
        }
        return linkedHashMap;
    }
}
