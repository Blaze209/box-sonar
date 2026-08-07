package com.box.android.data.datasource.gql.cache;

import com.apollographql.apollo3.cache.normalized.api.CacheKey;
import com.apollographql.apollo3.cache.normalized.api.CacheKeyGenerator;
import com.apollographql.apollo3.cache.normalized.api.CacheKeyGeneratorContext;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GQLCacheKeyGenerator.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/box/android/data/datasource/gql/cache/GQLCacheKeyGenerator;", "Lcom/apollographql/apollo3/cache/normalized/api/CacheKeyGenerator;", "<init>", "()V", "cacheKeyForObject", "Lcom/apollographql/apollo3/cache/normalized/api/CacheKey;", "obj", "", "", "", "context", "Lcom/apollographql/apollo3/cache/normalized/api/CacheKeyGeneratorContext;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GQLCacheKeyGenerator implements CacheKeyGenerator {
    @Override // com.apollographql.apollo3.cache.normalized.api.CacheKeyGenerator
    public CacheKey cacheKeyForObject(Map<String, ? extends Object> obj, CacheKeyGeneratorContext context) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        Intrinsics.checkNotNullParameter(context, "context");
        Object obj2 = obj.get("id");
        String str = obj2 instanceof String ? (String) obj2 : null;
        Object obj3 = obj.get(GQLCacheConstants.TYPENAME_KEY);
        String name = obj3 instanceof String ? (String) obj3 : null;
        if (name == null) {
            name = context.getField().getType().leafType().getName();
        }
        String str2 = name;
        if (str == null || str2 == null) {
            return null;
        }
        return GQLCacheKeyUtils.createCacheKey$default(GQLCacheKeyUtils.INSTANCE, str, str2, null, 4, null);
    }
}
