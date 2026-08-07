package com.apollographql.apollo3.cache.normalized.api;

import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.Executable;
import com.apollographql.apollo3.api.Executables;
import com.apollographql.apollo3.api.Fragment;
import com.apollographql.apollo3.api.Operation;
import com.apollographql.apollo3.api.json.MapJsonReader;
import com.apollographql.apollo3.api.json.MapJsonWriter;
import com.apollographql.apollo3.cache.normalized.api.internal.CacheBatchReader;
import com.apollographql.apollo3.cache.normalized.api.internal.Normalizer;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OperationCacheExtensions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000d\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0018\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u001aK\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0006\"\b\b\u0000\u0010\u0007*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00070\t2\u0006\u0010\n\u001a\u0002H\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002¢\u0006\u0002\u0010\u0010\u001aC\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0006\"\b\b\u0000\u0010\u0007*\u00020\u0011*\b\u0012\u0004\u0012\u0002H\u00070\u00122\u0006\u0010\n\u001a\u0002H\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u0013\u001a?\u0010\u0014\u001a\u0002H\u0007\"\b\b\u0000\u0010\u0007*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00070\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a¢\u0006\u0002\u0010\u001b\u001aG\u0010\u0014\u001a\u0002H\u0007\"\b\b\u0000\u0010\u0007*\u00020\u001c*\b\u0012\u0004\u0012\u0002H\u00070\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a¢\u0006\u0002\u0010 \u001aI\u0010!\u001a\u0002H\u0007\"\b\b\u0000\u0010\u0007*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00070\t2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002¢\u0006\u0002\u0010\"¨\u0006#"}, d2 = {"dependentKeys", "", "", "", "Lcom/apollographql/apollo3/cache/normalized/api/Record;", "normalize", "", "D", "Lcom/apollographql/apollo3/api/Executable$Data;", "Lcom/apollographql/apollo3/api/Executable;", "data", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "cacheKeyGenerator", "Lcom/apollographql/apollo3/cache/normalized/api/CacheKeyGenerator;", "rootKey", "(Lcom/apollographql/apollo3/api/Executable;Lcom/apollographql/apollo3/api/Executable$Data;Lcom/apollographql/apollo3/api/CustomScalarAdapters;Lcom/apollographql/apollo3/cache/normalized/api/CacheKeyGenerator;Ljava/lang/String;)Ljava/util/Map;", "Lcom/apollographql/apollo3/api/Operation$Data;", "Lcom/apollographql/apollo3/api/Operation;", "(Lcom/apollographql/apollo3/api/Operation;Lcom/apollographql/apollo3/api/Operation$Data;Lcom/apollographql/apollo3/api/CustomScalarAdapters;Lcom/apollographql/apollo3/cache/normalized/api/CacheKeyGenerator;)Ljava/util/Map;", "readDataFromCache", SemanticAttributes.DbSystemValues.CACHE, "Lcom/apollographql/apollo3/cache/normalized/api/ReadOnlyNormalizedCache;", "cacheResolver", "Lcom/apollographql/apollo3/cache/normalized/api/CacheResolver;", "cacheHeaders", "Lcom/apollographql/apollo3/cache/normalized/api/CacheHeaders;", "(Lcom/apollographql/apollo3/api/Executable;Lcom/apollographql/apollo3/api/CustomScalarAdapters;Lcom/apollographql/apollo3/cache/normalized/api/ReadOnlyNormalizedCache;Lcom/apollographql/apollo3/cache/normalized/api/CacheResolver;Lcom/apollographql/apollo3/cache/normalized/api/CacheHeaders;)Lcom/apollographql/apollo3/api/Executable$Data;", "Lcom/apollographql/apollo3/api/Fragment$Data;", "Lcom/apollographql/apollo3/api/Fragment;", "cacheKey", "Lcom/apollographql/apollo3/cache/normalized/api/CacheKey;", "(Lcom/apollographql/apollo3/api/Fragment;Lcom/apollographql/apollo3/cache/normalized/api/CacheKey;Lcom/apollographql/apollo3/api/CustomScalarAdapters;Lcom/apollographql/apollo3/cache/normalized/api/ReadOnlyNormalizedCache;Lcom/apollographql/apollo3/cache/normalized/api/CacheResolver;Lcom/apollographql/apollo3/cache/normalized/api/CacheHeaders;)Lcom/apollographql/apollo3/api/Fragment$Data;", "readInternal", "(Lcom/apollographql/apollo3/api/Executable;Lcom/apollographql/apollo3/cache/normalized/api/CacheKey;Lcom/apollographql/apollo3/api/CustomScalarAdapters;Lcom/apollographql/apollo3/cache/normalized/api/ReadOnlyNormalizedCache;Lcom/apollographql/apollo3/cache/normalized/api/CacheResolver;Lcom/apollographql/apollo3/cache/normalized/api/CacheHeaders;)Lcom/apollographql/apollo3/api/Executable$Data;", "apollo-normalized-cache-api"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class OperationCacheExtensionsKt {
    public static final <D extends Operation.Data> Map<String, Record> normalize(Operation<D> operation, D data, CustomScalarAdapters customScalarAdapters, CacheKeyGenerator cacheKeyGenerator) {
        Intrinsics.checkNotNullParameter(operation, "<this>");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
        Intrinsics.checkNotNullParameter(cacheKeyGenerator, "cacheKeyGenerator");
        return normalize(operation, data, customScalarAdapters, cacheKeyGenerator, CacheKey.INSTANCE.rootKey().getKey());
    }

    public static final <D extends Executable.Data> Map<String, Record> normalize(Executable<D> executable, D data, CustomScalarAdapters customScalarAdapters, CacheKeyGenerator cacheKeyGenerator, String rootKey) throws IOException {
        Intrinsics.checkNotNullParameter(executable, "<this>");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
        Intrinsics.checkNotNullParameter(cacheKeyGenerator, "cacheKeyGenerator");
        Intrinsics.checkNotNullParameter(rootKey, "rootKey");
        MapJsonWriter mapJsonWriter = new MapJsonWriter();
        executable.adapter().toJson(mapJsonWriter, customScalarAdapters, data);
        Normalizer normalizer = new Normalizer(Executables.variables(executable, customScalarAdapters, true), rootKey, cacheKeyGenerator);
        Object objRoot = mapJsonWriter.root();
        Intrinsics.checkNotNull(objRoot, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
        return normalizer.normalize((Map) objRoot, executable.rootField().getSelections(), executable.rootField().getType().rawType().getName());
    }

    public static final <D extends Executable.Data> D readDataFromCache(Executable<D> executable, CustomScalarAdapters customScalarAdapters, ReadOnlyNormalizedCache cache, CacheResolver cacheResolver, CacheHeaders cacheHeaders) {
        Intrinsics.checkNotNullParameter(executable, "<this>");
        Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
        Intrinsics.checkNotNullParameter(cache, "cache");
        Intrinsics.checkNotNullParameter(cacheResolver, "cacheResolver");
        Intrinsics.checkNotNullParameter(cacheHeaders, "cacheHeaders");
        return (D) readInternal(executable, CacheKey.INSTANCE.rootKey(), customScalarAdapters, cache, cacheResolver, cacheHeaders);
    }

    public static final <D extends Fragment.Data> D readDataFromCache(Fragment<D> fragment, CacheKey cacheKey, CustomScalarAdapters customScalarAdapters, ReadOnlyNormalizedCache cache, CacheResolver cacheResolver, CacheHeaders cacheHeaders) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
        Intrinsics.checkNotNullParameter(cache, "cache");
        Intrinsics.checkNotNullParameter(cacheResolver, "cacheResolver");
        Intrinsics.checkNotNullParameter(cacheHeaders, "cacheHeaders");
        return (D) readInternal(fragment, cacheKey, customScalarAdapters, cache, cacheResolver, cacheHeaders);
    }

    private static final <D extends Executable.Data> D readInternal(Executable<D> executable, CacheKey cacheKey, CustomScalarAdapters customScalarAdapters, ReadOnlyNormalizedCache readOnlyNormalizedCache, CacheResolver cacheResolver, CacheHeaders cacheHeaders) throws IOException {
        return executable.adapter().fromJson(new MapJsonReader(new CacheBatchReader(readOnlyNormalizedCache, cacheKey.getKey(), Executables.variables(executable, customScalarAdapters, true), cacheResolver, cacheHeaders, executable.rootField().getSelections(), executable.rootField().getType().rawType().getName()).toMap(), null, 2, null), customScalarAdapters);
    }

    public static final Set<String> dependentKeys(Collection<Record> collection) {
        if (collection != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                CollectionsKt.addAll(arrayList, ((Record) it.next()).fieldKeys());
            }
            Set<String> set = CollectionsKt.toSet(arrayList);
            if (set != null) {
                return set;
            }
        }
        return SetsKt.emptySet();
    }
}
