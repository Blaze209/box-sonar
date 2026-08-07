package com.apollographql.apollo3.cache.normalized.api;

import com.apollographql.apollo3.api.CompiledField;
import com.apollographql.apollo3.api.CompiledGraphQL;
import com.apollographql.apollo3.api.CompiledListType;
import com.apollographql.apollo3.api.CompiledNamedType;
import com.apollographql.apollo3.api.CompiledNotNullType;
import com.apollographql.apollo3.api.CompiledType;
import com.apollographql.apollo3.api.Executable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.events.IdentificationData;

/* JADX INFO: compiled from: CacheKeyResolver.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\"\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J;\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0019\u0010\r\u001a\u0015\u0012\u0004\u0012\u00020\u000f\u0012\u000b\u0012\t\u0018\u00010\f¢\u0006\u0002\b\u00100\u000e2\u0006\u0010\u0011\u001a\u00020\u000f¨\u0006\u0012"}, d2 = {"Lcom/apollographql/apollo3/cache/normalized/api/CacheKeyResolver;", "Lcom/apollographql/apollo3/cache/normalized/api/CacheResolver;", "()V", "cacheKeyForField", "Lcom/apollographql/apollo3/cache/normalized/api/CacheKey;", "field", "Lcom/apollographql/apollo3/api/CompiledField;", "variables", "Lcom/apollographql/apollo3/api/Executable$Variables;", "listOfCacheKeysForField", "", "resolveField", "", "parent", "", "", "Lkotlin/jvm/JvmSuppressWildcards;", IdentificationData.FIELD_PARENT_ID, "apollo-normalized-cache-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class CacheKeyResolver implements CacheResolver {
    public abstract CacheKey cacheKeyForField(CompiledField field, Executable.Variables variables);

    public List<CacheKey> listOfCacheKeysForField(CompiledField field, Executable.Variables variables) {
        Intrinsics.checkNotNullParameter(field, "field");
        Intrinsics.checkNotNullParameter(variables, "variables");
        return null;
    }

    @Override // com.apollographql.apollo3.cache.normalized.api.CacheResolver
    public final Object resolveField(CompiledField field, Executable.Variables variables, Map<String, Object> parent, String parentId) {
        List<CacheKey> listListOfCacheKeysForField;
        CacheKey cacheKeyCacheKeyForField;
        Intrinsics.checkNotNullParameter(field, "field");
        Intrinsics.checkNotNullParameter(variables, "variables");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(parentId, "parentId");
        CompiledType type = field.getType();
        if (type instanceof CompiledNotNullType) {
            type = ((CompiledNotNullType) type).getOfType();
        }
        if ((type instanceof CompiledNamedType) && CompiledGraphQL.isComposite((CompiledNamedType) type) && (cacheKeyCacheKeyForField = cacheKeyForField(field, variables)) != null) {
            return cacheKeyCacheKeyForField;
        }
        if (type instanceof CompiledListType) {
            CompiledType ofType = ((CompiledListType) type).getOfType();
            if (ofType instanceof CompiledNotNullType) {
                ofType = ((CompiledNotNullType) ofType).getOfType();
            }
            if ((ofType instanceof CompiledNamedType) && CompiledGraphQL.isComposite((CompiledNamedType) ofType) && (listListOfCacheKeysForField = listOfCacheKeysForField(field, variables)) != null) {
                return listListOfCacheKeysForField;
            }
        }
        return DefaultCacheResolver.INSTANCE.resolveField(field, variables, parent, parentId);
    }
}
