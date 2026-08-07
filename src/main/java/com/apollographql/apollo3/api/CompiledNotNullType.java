package com.apollographql.apollo3.api;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CompiledGraphQL.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0017J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/apollographql/apollo3/api/CompiledNotNullType;", "Lcom/apollographql/apollo3/api/CompiledType;", "ofType", "(Lcom/apollographql/apollo3/api/CompiledType;)V", "getOfType", "()Lcom/apollographql/apollo3/api/CompiledType;", "leafType", "Lcom/apollographql/apollo3/api/CompiledNamedType;", "rawType", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class CompiledNotNullType extends CompiledType {
    private final CompiledType ofType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CompiledNotNullType(CompiledType ofType) {
        super(null);
        Intrinsics.checkNotNullParameter(ofType, "ofType");
        this.ofType = ofType;
    }

    public final CompiledType getOfType() {
        return this.ofType;
    }

    @Override // com.apollographql.apollo3.api.CompiledType
    @Deprecated(message = "Use rawType instead", replaceWith = @ReplaceWith(expression = "rawType()", imports = {}))
    public CompiledNamedType leafType() {
        return this.ofType.rawType();
    }

    @Override // com.apollographql.apollo3.api.CompiledType
    public CompiledNamedType rawType() {
        return this.ofType.rawType();
    }
}
