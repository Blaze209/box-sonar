package com.box.android.base.presentation.utilities;

import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.utils.BoxLogUtils;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: IntuneAuthMAMListener.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.base.presentation.utilities.IntuneAuthMAMListener$handleSsoFlow$msalAccessCode$1", f = "IntuneAuthMAMListener.kt", i = {0}, l = {77}, m = "invokeSuspend", n = {"code"}, s = {"L$0"}, v = 1)
final class IntuneAuthMAMListener$handleSsoFlow$msalAccessCode$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String $tokenId;
    Object L$0;
    int label;
    final /* synthetic */ IntuneAuthMAMListener this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    IntuneAuthMAMListener$handleSsoFlow$msalAccessCode$1(String str, IntuneAuthMAMListener intuneAuthMAMListener, Continuation<? super IntuneAuthMAMListener$handleSsoFlow$msalAccessCode$1> continuation) {
        super(2, continuation);
        this.$tokenId = str;
        this.this$0 = intuneAuthMAMListener;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new IntuneAuthMAMListener$handleSsoFlow$msalAccessCode$1(this.$tokenId, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((IntuneAuthMAMListener$handleSsoFlow$msalAccessCode$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r3v5, types: [T, java.lang.String] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            objectRef = new Ref.ObjectRef();
            if (this.$tokenId != null) {
                this.L$0 = objectRef;
                this.label = 1;
                Object objAuthenticateWithMsal = this.this$0.authRequestService.authenticateWithMsal(this.$tokenId, this.this$0.codeChallenge, this);
                if (objAuthenticateWithMsal == coroutine_suspended) {
                    return coroutine_suspended;
                }
                objectRef2 = objectRef;
                obj = objAuthenticateWithMsal;
            }
            return objectRef.element;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        objectRef2 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(obj);
        Result result = (Result) obj;
        boolean z = result instanceof Result.Success;
        if (z) {
            ?? r3 = (String) ((Result.Success) result).getValue();
            BoxLogUtils.i("IntuneAuthMAMListener", "Box MSAL authentication succeeded");
            objectRef2.element = r3;
        } else if (!(result instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        IntuneAuthMAMListener intuneAuthMAMListener = this.this$0;
        if (!z) {
            if (!(result instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            BoxLogUtils.e("IntuneAuthMAMListener", "Box MSAL authentication failed");
            intuneAuthMAMListener.intuneAuthManager.signOutUser();
        }
        objectRef = objectRef2;
        return objectRef.element;
    }
}
