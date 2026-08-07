package com.apollographql.apollo3.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Exceptions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/apollographql/apollo3/exception/SubscriptionOperationException;", "Lcom/apollographql/apollo3/exception/ApolloException;", "operationName", "", "payload", "", "(Ljava/lang/String;Ljava/lang/Object;)V", "getPayload", "()Ljava/lang/Object;", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SubscriptionOperationException extends ApolloException {
    private final Object payload;

    public /* synthetic */ SubscriptionOperationException(String str, Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : obj);
    }

    public final Object getPayload() {
        return this.payload;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubscriptionOperationException(String operationName, Object obj) {
        super("Operation error " + operationName, null, 2, null);
        Intrinsics.checkNotNullParameter(operationName, "operationName");
        this.payload = obj;
    }
}
