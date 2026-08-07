package com.apollographql.apollo3.cache.normalized;

import com.apollographql.apollo3.api.ApolloResponse;
import com.apollographql.apollo3.exception.ApolloException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Add missing generic type declarations: [D] */
/* JADX INFO: compiled from: FetchPolicyInterceptors.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u008a@"}, d2 = {"<anonymous>", "", "D", "Lcom/apollographql/apollo3/api/Operation$Data;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/apollographql/apollo3/api/ApolloResponse;", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.apollographql.apollo3.cache.normalized.FetchPolicyInterceptors$CacheAndNetworkInterceptor$1$intercept$1$networkResponses$1", f = "FetchPolicyInterceptors.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class FetchPolicyInterceptors$CacheAndNetworkInterceptor$1$intercept$1$networkResponses$1<D> extends SuspendLambda implements Function3<FlowCollector<? super ApolloResponse<D>>, Throwable, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<ApolloException> $networkException;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FetchPolicyInterceptors$CacheAndNetworkInterceptor$1$intercept$1$networkResponses$1(Ref.ObjectRef<ApolloException> objectRef, Continuation<? super FetchPolicyInterceptors$CacheAndNetworkInterceptor$1$intercept$1$networkResponses$1> continuation) {
        super(3, continuation);
        this.$networkException = objectRef;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(FlowCollector<? super ApolloResponse<D>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
        FetchPolicyInterceptors$CacheAndNetworkInterceptor$1$intercept$1$networkResponses$1 fetchPolicyInterceptors$CacheAndNetworkInterceptor$1$intercept$1$networkResponses$1 = new FetchPolicyInterceptors$CacheAndNetworkInterceptor$1$intercept$1$networkResponses$1(this.$networkException, continuation);
        fetchPolicyInterceptors$CacheAndNetworkInterceptor$1$intercept$1$networkResponses$1.L$0 = th;
        return fetchPolicyInterceptors$CacheAndNetworkInterceptor$1$intercept$1$networkResponses$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [T, java.lang.Throwable] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        ?? r2 = (Throwable) this.L$0;
        if (r2 instanceof ApolloException) {
            this.$networkException.element = r2;
            return Unit.INSTANCE;
        }
        throw r2;
    }
}
