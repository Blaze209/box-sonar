package com.apollographql.apollo3.cache.normalized;

import com.apollographql.apollo3.api.ApolloResponse;
import external.sdk.pendo.io.mozilla.javascript.Context;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: ClientCacheExtensions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.apollographql.apollo3.cache.normalized.NormalizedCache$watch$1$2", f = "ClientCacheExtensions.kt", i = {0, 0}, l = {Token.ARRAYCOMP, Context.VERSION_1_7}, m = "emit", n = {"this", "it"}, s = {"L$0", "L$1"})
final class NormalizedCache$watch$1$2$emit$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NormalizedCache.C08711.AnonymousClass2<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    NormalizedCache$watch$1$2$emit$1(NormalizedCache.C08711.AnonymousClass2<? super T> anonymousClass2, Continuation<? super NormalizedCache$watch$1$2$emit$1> continuation) {
        super(continuation);
        this.this$0 = anonymousClass2;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((ApolloResponse) null, (Continuation<? super Unit>) this);
    }
}
