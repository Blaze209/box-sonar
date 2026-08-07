package com.apollographql.apollo3.cache.normalized.internal;

import androidx.media3.extractor.ts.TsExtractor;
import com.apollographql.apollo3.api.ApolloResponse;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: ApolloCacheInterceptor.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.apollographql.apollo3.cache.normalized.internal.ApolloCacheInterceptor$interceptMutation$1$1", f = "ApolloCacheInterceptor.kt", i = {0, 0, 1, 1}, l = {Token.YIELD_STAR, 171, TsExtractor.TS_STREAM_TYPE_AC4}, m = "emit", n = {"this", "response", "this", "response"}, s = {"L$0", "L$1", "L$0", "L$1"})
final class ApolloCacheInterceptor$interceptMutation$1$1$emit$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ApolloCacheInterceptor.AnonymousClass1.C01031<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ApolloCacheInterceptor$interceptMutation$1$1$emit$1(ApolloCacheInterceptor.AnonymousClass1.C01031<? super T> c01031, Continuation<? super ApolloCacheInterceptor$interceptMutation$1$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = c01031;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((ApolloResponse) null, (Continuation<? super Unit>) this);
    }
}
