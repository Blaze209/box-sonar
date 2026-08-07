package com.apollographql.apollo3.cache.normalized.api;

import com.apollographql.apollo3.api.CompiledField;
import com.apollographql.apollo3.api.Executable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CacheKeyGenerator.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/apollographql/apollo3/cache/normalized/api/CacheKeyGeneratorContext;", "", "field", "Lcom/apollographql/apollo3/api/CompiledField;", "variables", "Lcom/apollographql/apollo3/api/Executable$Variables;", "(Lcom/apollographql/apollo3/api/CompiledField;Lcom/apollographql/apollo3/api/Executable$Variables;)V", "getField", "()Lcom/apollographql/apollo3/api/CompiledField;", "getVariables", "()Lcom/apollographql/apollo3/api/Executable$Variables;", "apollo-normalized-cache-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class CacheKeyGeneratorContext {
    private final CompiledField field;
    private final Executable.Variables variables;

    public CacheKeyGeneratorContext(CompiledField field, Executable.Variables variables) {
        Intrinsics.checkNotNullParameter(field, "field");
        Intrinsics.checkNotNullParameter(variables, "variables");
        this.field = field;
        this.variables = variables;
    }

    public final CompiledField getField() {
        return this.field;
    }

    public final Executable.Variables getVariables() {
        return this.variables;
    }
}
