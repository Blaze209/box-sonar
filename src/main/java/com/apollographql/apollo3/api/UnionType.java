package com.apollographql.apollo3.api;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CompiledGraphQL.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006¢\u0006\u0002\u0010\u0007R\u001b\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/apollographql/apollo3/api/UnionType;", "Lcom/apollographql/apollo3/api/CompiledNamedType;", "name", "", "members", "", "Lcom/apollographql/apollo3/api/ObjectType;", "(Ljava/lang/String;[Lcom/apollographql/apollo3/api/ObjectType;)V", "getMembers", "()[Lcom/apollographql/apollo3/api/ObjectType;", "[Lcom/apollographql/apollo3/api/ObjectType;", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class UnionType extends CompiledNamedType {
    private final ObjectType[] members;

    public final ObjectType[] getMembers() {
        return this.members;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnionType(String name, ObjectType... members) {
        super(name, null);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(members, "members");
        this.members = members;
    }
}
