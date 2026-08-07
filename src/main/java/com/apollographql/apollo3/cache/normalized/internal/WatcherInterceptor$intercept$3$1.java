package com.apollographql.apollo3.cache.normalized.internal;

import com.apollographql.apollo3.api.ApolloRequest;
import com.apollographql.apollo3.api.ApolloResponse;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.Executable;
import com.apollographql.apollo3.cache.normalized.ApolloStore;
import com.apollographql.apollo3.cache.normalized.api.OperationCacheExtensionsKt;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: Add missing generic type declarations: [D] */
/* JADX INFO: compiled from: WatcherInterceptor.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "D", "Lcom/apollographql/apollo3/api/Operation$Data;", "response", "Lcom/apollographql/apollo3/api/ApolloResponse;"}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.apollographql.apollo3.cache.normalized.internal.WatcherInterceptor$intercept$3$1", f = "WatcherInterceptor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class WatcherInterceptor$intercept$3$1<D> extends SuspendLambda implements Function2<ApolloResponse<D>, Continuation<? super Unit>, Object> {
    final /* synthetic */ CustomScalarAdapters $customScalarAdapters;
    final /* synthetic */ ApolloRequest<D> $request;
    final /* synthetic */ Ref.ObjectRef<Set<String>> $watchedKeys;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ WatcherInterceptor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WatcherInterceptor$intercept$3$1(Ref.ObjectRef<Set<String>> objectRef, WatcherInterceptor watcherInterceptor, ApolloRequest<D> apolloRequest, CustomScalarAdapters customScalarAdapters, Continuation<? super WatcherInterceptor$intercept$3$1> continuation) {
        super(2, continuation);
        this.$watchedKeys = objectRef;
        this.this$0 = watcherInterceptor;
        this.$request = apolloRequest;
        this.$customScalarAdapters = customScalarAdapters;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        WatcherInterceptor$intercept$3$1 watcherInterceptor$intercept$3$1 = new WatcherInterceptor$intercept$3$1(this.$watchedKeys, this.this$0, this.$request, this.$customScalarAdapters, continuation);
        watcherInterceptor$intercept$3$1.L$0 = obj;
        return watcherInterceptor$intercept$3$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ApolloResponse<D> apolloResponse, Continuation<? super Unit> continuation) {
        return ((WatcherInterceptor$intercept$3$1) create(apolloResponse, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [T, java.util.Set] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        ApolloResponse apolloResponse = (ApolloResponse) this.L$0;
        if (apolloResponse.data != 0) {
            Ref.ObjectRef<Set<String>> objectRef = this.$watchedKeys;
            ApolloStore store = this.this$0.getStore();
            Executable operation = this.$request.getOperation();
            D d = apolloResponse.data;
            Intrinsics.checkNotNull(d);
            objectRef.element = OperationCacheExtensionsKt.dependentKeys(store.normalize(operation, d, this.$customScalarAdapters).values());
        }
        return Unit.INSTANCE;
    }
}
