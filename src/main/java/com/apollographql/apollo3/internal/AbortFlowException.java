package com.apollographql.apollo3.internal;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: flows.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0011\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0002\u0010\u0005J\u0012\u0010\b\u001a\u00020\t2\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004R\u0015\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/apollographql/apollo3/internal/AbortFlowException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "owner", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;)V", "getOwner", "()Lkotlinx/coroutines/flow/FlowCollector;", "checkOwnership", "", "apollo-runtime"}, k = 1, mv = {1, 5, 1}, xi = 48)
final class AbortFlowException extends CancellationException {
    private final FlowCollector<?> owner;

    public final FlowCollector<?> getOwner() {
        return this.owner;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbortFlowException(FlowCollector<?> owner) {
        super("Flow was aborted, no more elements needed");
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.owner = owner;
    }

    public final void checkOwnership(FlowCollector<?> owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        if (this.owner != owner) {
            throw this;
        }
    }
}
