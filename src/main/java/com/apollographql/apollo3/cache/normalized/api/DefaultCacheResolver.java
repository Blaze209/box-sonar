package com.apollographql.apollo3.cache.normalized.api;

import com.apollographql.apollo3.api.CompiledField;
import com.apollographql.apollo3.api.Executable;
import com.apollographql.apollo3.exception.CacheMissException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.events.IdentificationData;

/* JADX INFO: compiled from: CacheResolver.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J=\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0019\u0010\t\u001a\u0015\u0012\u0004\u0012\u00020\u000b\u0012\u000b\u0012\t\u0018\u00010\u0004¢\u0006\u0002\b\f0\n2\u0006\u0010\r\u001a\u00020\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/apollographql/apollo3/cache/normalized/api/DefaultCacheResolver;", "Lcom/apollographql/apollo3/cache/normalized/api/CacheResolver;", "()V", "resolveField", "", "field", "Lcom/apollographql/apollo3/api/CompiledField;", "variables", "Lcom/apollographql/apollo3/api/Executable$Variables;", "parent", "", "", "Lkotlin/jvm/JvmSuppressWildcards;", IdentificationData.FIELD_PARENT_ID, "apollo-normalized-cache-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DefaultCacheResolver implements CacheResolver {
    public static final DefaultCacheResolver INSTANCE = new DefaultCacheResolver();

    private DefaultCacheResolver() {
    }

    @Override // com.apollographql.apollo3.cache.normalized.api.CacheResolver
    public Object resolveField(CompiledField field, Executable.Variables variables, Map<String, Object> parent, String parentId) {
        Intrinsics.checkNotNullParameter(field, "field");
        Intrinsics.checkNotNullParameter(variables, "variables");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(parentId, "parentId");
        String strNameWithArguments = field.nameWithArguments(variables);
        if (!parent.containsKey(strNameWithArguments)) {
            throw new CacheMissException(parentId, strNameWithArguments);
        }
        return parent.get(strNameWithArguments);
    }
}
