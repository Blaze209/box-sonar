package com.box.android.inbox.mfasetup;

import com.box.android.utilities.BoxUtils;
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
@DebugMetadata(c = "com.box.android.inbox.mfasetup.MfaSetupDialogReducer$build$1$3", f = "MfaSetupDialogReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class MfaSetupDialogReducer$build$1$3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ MfaSetupDialogReducer.Action $action;
    final /* synthetic */ String $mfaUrl;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MfaSetupDialogReducer$build$1$3(MfaSetupDialogReducer.Action action, String str, Continuation<? super MfaSetupDialogReducer$build$1$3> continuation) {
        super(1, continuation);
        this.$action = action;
        this.$mfaUrl = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new MfaSetupDialogReducer$build$1$3(this.$action, this.$mfaUrl, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((MfaSetupDialogReducer$build$1$3) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        BoxUtils.launchSafeExternalLink(((MfaSetupDialogReducer.Action.NavigateToBrowser) this.$action).getContext(), this.$mfaUrl);
        return Unit.INSTANCE;
    }
}
