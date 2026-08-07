package com.box.android.data.datasource.gql.cache;

import com.apollographql.apollo3.api.CompiledField;
import com.apollographql.apollo3.api.Executable;
import com.apollographql.apollo3.cache.normalized.api.CacheKey;
import com.apollographql.apollo3.cache.normalized.api.CacheKeyResolver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GQLCacheKeyResolver.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/box/android/data/datasource/gql/cache/GQLCacheKeyResolver;", "Lcom/apollographql/apollo3/cache/normalized/api/CacheKeyResolver;", "<init>", "()V", "cacheKeyForField", "Lcom/apollographql/apollo3/cache/normalized/api/CacheKey;", "field", "Lcom/apollographql/apollo3/api/CompiledField;", "variables", "Lcom/apollographql/apollo3/api/Executable$Variables;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GQLCacheKeyResolver extends CacheKeyResolver {
    @Override // com.apollographql.apollo3.cache.normalized.api.CacheKeyResolver
    public CacheKey cacheKeyForField(CompiledField field, Executable.Variables variables) {
        Intrinsics.checkNotNullParameter(field, "field");
        Intrinsics.checkNotNullParameter(variables, "variables");
        Object objResolveArgument = field.resolveArgument("id", variables);
        String str = objResolveArgument instanceof String ? (String) objResolveArgument : null;
        String name = field.getName();
        Object objResolveArgument2 = field.resolveArgument("type", variables);
        return GQLCacheKeyUtils.INSTANCE.createCacheKey(str, objResolveArgument2 instanceof String ? (String) objResolveArgument2 : null, name);
    }
}
