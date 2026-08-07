package com.box.android.base.compose;

import androidx.compose.material3.SnackbarDuration;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.SnackbarResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: SnackbarMessage.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.base.compose.SnackbarMessageKt$SnackbarMessage$1$1$1$1", f = "SnackbarMessage.kt", i = {}, l = {25}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class SnackbarMessageKt$SnackbarMessage$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SnackbarDuration $duration;
    final /* synthetic */ String $message;
    final /* synthetic */ SnackbarAction $snackbarAction;
    final /* synthetic */ SnackbarHostState $snackbarHostState;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SnackbarMessageKt$SnackbarMessage$1$1$1$1(String str, SnackbarAction snackbarAction, SnackbarHostState snackbarHostState, SnackbarDuration snackbarDuration, Continuation<? super SnackbarMessageKt$SnackbarMessage$1$1$1$1> continuation) {
        super(2, continuation);
        this.$message = str;
        this.$snackbarAction = snackbarAction;
        this.$snackbarHostState = snackbarHostState;
        this.$duration = snackbarDuration;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SnackbarMessageKt$SnackbarMessage$1$1$1$1(this.$message, this.$snackbarAction, this.$snackbarHostState, this.$duration, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SnackbarMessageKt$SnackbarMessage$1$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SnackbarAction snackbarAction;
        Function0<Unit> onClick;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String str = this.$message;
            SnackbarAction snackbarAction2 = this.$snackbarAction;
            String label = snackbarAction2 != null ? snackbarAction2.getLabel() : null;
            this.label = 1;
            obj = SnackbarHostState.showSnackbar$default(this.$snackbarHostState, str, label, false, this.$duration, this, 4, null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        if (((SnackbarResult) obj) == SnackbarResult.ActionPerformed && (snackbarAction = this.$snackbarAction) != null && (onClick = snackbarAction.getOnClick()) != null) {
            onClick.invoke();
        }
        return Unit.INSTANCE;
    }
}
