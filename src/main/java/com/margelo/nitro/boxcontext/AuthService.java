package com.margelo.nitro.boxcontext;

import com.margelo.nitro.boxcontext.providers.AuthProvider;
import com.margelo.nitro.core.Promise;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AuthService.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¨\u0006\u0007"}, d2 = {"Lcom/margelo/nitro/boxcontext/AuthService;", "Lcom/margelo/nitro/boxcontext/HybridAuthServiceSpec;", "<init>", "()V", "getAuthToken", "Lcom/margelo/nitro/core/Promise;", "", "cirrus_box-context_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthService extends HybridAuthServiceSpec {

    /* JADX INFO: renamed from: com.margelo.nitro.boxcontext.AuthService$getAuthToken$1, reason: invalid class name */
    /* JADX INFO: compiled from: AuthService.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.margelo.nitro.boxcontext.AuthService$getAuthToken$1", f = "AuthService.kt", i = {}, l = {18}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super String>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super String> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object authToken = ((AuthProvider) BoxContext.INSTANCE.require(new Function1() { // from class: com.margelo.nitro.boxcontext.AuthService$getAuthToken$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return ((BoxContext.Dependencies) obj2).getAuthProvider();
                }
            })).getAuthToken(this);
            return authToken == coroutine_suspended ? coroutine_suspended : authToken;
        }
    }

    @Override // com.margelo.nitro.boxcontext.HybridAuthServiceSpec
    public Promise<String> getAuthToken() {
        return Promise.Companion.async$default(Promise.INSTANCE, null, new AnonymousClass1(null), 1, null);
    }
}
