package com.squareup.sqldelight;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Transacter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/squareup/sqldelight/RollbackException;", "", "value", "", "(Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "runtime"}, k = 1, mv = {1, 5, 1}, xi = 48)
final class RollbackException extends Throwable {
    private final Object value;

    /* JADX WARN: Illegal instructions before constructor call */
    public RollbackException() {
        DefaultConstructorMarker defaultConstructorMarker = null;
        this(defaultConstructorMarker, 1, defaultConstructorMarker);
    }

    public RollbackException(Object obj) {
        this.value = obj;
    }

    public /* synthetic */ RollbackException(Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : obj);
    }

    public final Object getValue() {
        return this.value;
    }
}
