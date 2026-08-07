package com.apollographql.apollo3.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: flows.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.apollographql.apollo3.internal.FlowsKt$collectWhile$collector$1", f = "flows.kt", i = {0}, l = {31}, m = "emit", n = {"this"}, s = {"L$0"})
public final class FlowsKt$collectWhile$collector$1$emit$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowsKt$collectWhile$collector$1<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowsKt$collectWhile$collector$1$emit$1(FlowsKt$collectWhile$collector$1<T> flowsKt$collectWhile$collector$1, Continuation<? super FlowsKt$collectWhile$collector$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = flowsKt$collectWhile$collector$1;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit(null, this);
    }
}
