package com.apollographql.apollo3.cache.normalized.api;

import com.apollographql.apollo3.api.CompiledGraphQL;
import com.box.android.data.datasource.gql.cache.GQLCacheConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CacheKeyGenerator.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00062\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/apollographql/apollo3/cache/normalized/api/TypePolicyCacheKeyGenerator;", "Lcom/apollographql/apollo3/cache/normalized/api/CacheKeyGenerator;", "()V", "cacheKeyForObject", "Lcom/apollographql/apollo3/cache/normalized/api/CacheKey;", "obj", "", "", "", "context", "Lcom/apollographql/apollo3/cache/normalized/api/CacheKeyGeneratorContext;", "apollo-normalized-cache-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TypePolicyCacheKeyGenerator implements CacheKeyGenerator {
    public static final TypePolicyCacheKeyGenerator INSTANCE = new TypePolicyCacheKeyGenerator();

    private TypePolicyCacheKeyGenerator() {
    }

    @Override // com.apollographql.apollo3.cache.normalized.api.CacheKeyGenerator
    public CacheKey cacheKeyForObject(Map<String, ? extends Object> obj, CacheKeyGeneratorContext context) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        Intrinsics.checkNotNullParameter(context, "context");
        List<String> listKeyFields = CompiledGraphQL.keyFields(context.getField().getType().rawType());
        if (listKeyFields.isEmpty()) {
            return null;
        }
        String strValueOf = String.valueOf(obj.get(GQLCacheConstants.TYPENAME_KEY));
        List<String> list = listKeyFields;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(obj.get((String) it.next())));
        }
        return new CacheKey(strValueOf, arrayList);
    }
}
