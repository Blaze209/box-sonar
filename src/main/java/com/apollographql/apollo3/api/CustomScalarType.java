package com.apollographql.apollo3.api;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CompiledGraphQL.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/apollographql/apollo3/api/CustomScalarType;", "Lcom/apollographql/apollo3/api/CompiledNamedType;", "name", "", "className", "(Ljava/lang/String;Ljava/lang/String;)V", "getClassName", "()Ljava/lang/String;", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class CustomScalarType extends CompiledNamedType {
    private final String className;

    public final String getClassName() {
        return this.className;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomScalarType(String name, String className) {
        super(name, null);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(className, "className");
        this.className = className;
    }
}
