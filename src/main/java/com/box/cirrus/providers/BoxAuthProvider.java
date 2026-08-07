package com.box.cirrus.providers;

import com.box.android.domain.services.AuthTokenService;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.margelo.nitro.boxcontext.providers.AuthProvider;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxAuthProvider.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/box/cirrus/providers/BoxAuthProvider;", "Lcom/margelo/nitro/boxcontext/providers/AuthProvider;", "authTokenService", "Lcom/box/android/domain/services/AuthTokenService;", "<init>", "(Lcom/box/android/domain/services/AuthTokenService;)V", "getAuthToken", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cirrus_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxAuthProvider implements AuthProvider {
    private final AuthTokenService authTokenService;

    /* JADX INFO: renamed from: com.box.cirrus.providers.BoxAuthProvider$getAuthToken$1, reason: invalid class name */
    /* JADX INFO: compiled from: BoxAuthProvider.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.cirrus.providers.BoxAuthProvider", f = "BoxAuthProvider.kt", i = {}, l = {12}, m = "getAuthToken", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BoxAuthProvider.this.getAuthToken(this);
        }
    }

    @Inject
    public BoxAuthProvider(AuthTokenService authTokenService) {
        Intrinsics.checkNotNullParameter(authTokenService, "authTokenService");
        this.authTokenService = authTokenService;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.margelo.nitro.boxcontext.providers.AuthProvider
    public Object getAuthToken(Continuation<? super String> continuation) throws UnauthenticatedUserException {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object accessToken = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(accessToken);
            AuthTokenService authTokenService = this.authTokenService;
            anonymousClass1.label = 1;
            accessToken = authTokenService.getAccessToken(anonymousClass1);
            if (accessToken == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(accessToken);
        }
        String str = (String) accessToken;
        if (str != null) {
            return str;
        }
        UnauthenticatedUserException unauthenticatedUserException = new UnauthenticatedUserException();
        BoxLogUtils.e(ExtensionsKt.getTAG(this), unauthenticatedUserException);
        throw unauthenticatedUserException;
    }
}
