package com.apollographql.apollo3.cache.normalized.api;

import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: ReadOnlyNormalizedCache.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a#\u0012\r\u0012\u000b\u0012\u0002\b\u00030\u0004¢\u0006\u0002\b\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00030\u0003H&J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH&J$\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\r2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\u000f"}, d2 = {"Lcom/apollographql/apollo3/cache/normalized/api/ReadOnlyNormalizedCache;", "", "dump", "", "Lkotlin/reflect/KClass;", "Lkotlin/jvm/JvmSuppressWildcards;", "", "Lcom/apollographql/apollo3/cache/normalized/api/Record;", "loadRecord", "key", "cacheHeaders", "Lcom/apollographql/apollo3/cache/normalized/api/CacheHeaders;", "loadRecords", "", "keys", "apollo-normalized-cache-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface ReadOnlyNormalizedCache {
    Map<KClass<?>, Map<String, Record>> dump();

    Record loadRecord(String key, CacheHeaders cacheHeaders);

    Collection<Record> loadRecords(Collection<String> keys, CacheHeaders cacheHeaders);
}
