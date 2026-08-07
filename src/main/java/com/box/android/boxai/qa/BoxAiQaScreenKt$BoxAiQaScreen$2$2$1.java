package com.box.android.boxai.qa;

import androidx.compose.material3.SnackbarHostState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: BoxAiQaScreen.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.boxai.qa.BoxAiQaScreenKt$BoxAiQaScreen$2$2$1", f = "BoxAiQaScreen.kt", i = {}, l = {118}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class BoxAiQaScreenKt$BoxAiQaScreen$2$2$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ SnackbarHostState $snackbarHostState;
    final /* synthetic */ String $voiceErrorMessage;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BoxAiQaScreenKt$BoxAiQaScreen$2$2$1(SnackbarHostState snackbarHostState, String str, Continuation<? super BoxAiQaScreenKt$BoxAiQaScreen$2$2$1> continuation) {
        super(1, continuation);
        this.$snackbarHostState = snackbarHostState;
        this.$voiceErrorMessage = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new BoxAiQaScreenKt$BoxAiQaScreen$2$2$1(this.$snackbarHostState, this.$voiceErrorMessage, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((BoxAiQaScreenKt$BoxAiQaScreen$2$2$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (SnackbarHostState.showSnackbar$default(this.$snackbarHostState, this.$voiceErrorMessage, null, false, null, this, 14, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
