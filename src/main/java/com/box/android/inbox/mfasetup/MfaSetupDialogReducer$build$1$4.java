package com.box.android.inbox.mfasetup;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: MfaSetupDialogReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.inbox.mfasetup.MfaSetupDialogReducer$build$1$4", f = "MfaSetupDialogReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class MfaSetupDialogReducer$build$1$4 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ MfaSetupDialogReducer.State $state;
    int label;
    final /* synthetic */ MfaSetupDialogReducer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MfaSetupDialogReducer$build$1$4(MfaSetupDialogReducer mfaSetupDialogReducer, MfaSetupDialogReducer.State state, Continuation<? super MfaSetupDialogReducer$build$1$4> continuation) {
        super(1, continuation);
        this.this$0 = mfaSetupDialogReducer;
        this.$state = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new MfaSetupDialogReducer$build$1$4(this.this$0, this.$state, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((MfaSetupDialogReducer$build$1$4) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.environment.getMfaSetupAnalytics().enrollMfaButtonClicked(this.$state.getMobileSessionId());
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
