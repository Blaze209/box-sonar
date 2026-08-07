package com.apollographql.apollo3.cache.normalized;

import com.apollographql.apollo3.api.ApolloRequest;
import com.apollographql.apollo3.api.ApolloResponse;
import com.apollographql.apollo3.interceptor.ApolloInterceptorChain;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Add missing generic type declarations: [D] */
/* JADX INFO: compiled from: FetchPolicyInterceptors.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004H\u008a@"}, d2 = {"<anonymous>", "", "D", "Lcom/apollographql/apollo3/api/Operation$Data;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/apollographql/apollo3/api/ApolloResponse;"}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.apollographql.apollo3.cache.normalized.FetchPolicyInterceptors$CacheFirstInterceptor$1$intercept$1", f = "FetchPolicyInterceptors.kt", i = {0, 0, 0, 2, 2, 2, 3, 3}, l = {64, 69, 72, 97}, m = "invokeSuspend", n = {"$this$flow", "cacheException", "networkException", "$this$flow", "cacheException", "networkException", "cacheException", "networkException"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1"})
final class FetchPolicyInterceptors$CacheFirstInterceptor$1$intercept$1<D> extends SuspendLambda implements Function2<FlowCollector<? super ApolloResponse<D>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ApolloInterceptorChain $chain;
    final /* synthetic */ ApolloRequest<D> $request;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FetchPolicyInterceptors$CacheFirstInterceptor$1$intercept$1(ApolloInterceptorChain apolloInterceptorChain, ApolloRequest<D> apolloRequest, Continuation<? super FetchPolicyInterceptors$CacheFirstInterceptor$1$intercept$1> continuation) {
        super(2, continuation);
        this.$chain = apolloInterceptorChain;
        this.$request = apolloRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FetchPolicyInterceptors$CacheFirstInterceptor$1$intercept$1 fetchPolicyInterceptors$CacheFirstInterceptor$1$intercept$1 = new FetchPolicyInterceptors$CacheFirstInterceptor$1$intercept$1(this.$chain, this.$request, continuation);
        fetchPolicyInterceptors$CacheFirstInterceptor$1$intercept$1.L$0 = obj;
        return fetchPolicyInterceptors$CacheFirstInterceptor$1$intercept$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super ApolloResponse<D>> flowCollector, Continuation<? super Unit> continuation) {
        return ((FetchPolicyInterceptors$CacheFirstInterceptor$1$intercept$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:38:0x010e  */
    /* JADX WARN: Code duplicated, block: B:41:0x0114  */
    /* JADX WARN: Code duplicated, block: B:43:0x0117  */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00b8, code lost:
    
        if (r8.emit(r12, r11) == r0) goto L37;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            Method dump skipped, instruction units count: 293
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apollographql.apollo3.cache.normalized.FetchPolicyInterceptors$CacheFirstInterceptor$1$intercept$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
