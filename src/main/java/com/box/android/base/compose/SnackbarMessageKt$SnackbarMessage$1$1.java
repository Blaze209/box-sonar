package com.box.android.base.compose;

import androidx.compose.material3.SnackbarData;
import androidx.compose.material3.SnackbarDuration;
import androidx.compose.material3.SnackbarHostState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: SnackbarMessage.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.base.compose.SnackbarMessageKt$SnackbarMessage$1$1", f = "SnackbarMessage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class SnackbarMessageKt$SnackbarMessage$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ SnackbarDuration $duration;
    final /* synthetic */ String $message;
    final /* synthetic */ Function0<Unit> $onSnackbarShown;
    final /* synthetic */ SnackbarAction $snackbarAction;
    final /* synthetic */ SnackbarHostState $snackbarHostState;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SnackbarMessageKt$SnackbarMessage$1$1(String str, SnackbarHostState snackbarHostState, CoroutineScope coroutineScope, Function0<Unit> function0, SnackbarAction snackbarAction, SnackbarDuration snackbarDuration, Continuation<? super SnackbarMessageKt$SnackbarMessage$1$1> continuation) {
        super(2, continuation);
        this.$message = str;
        this.$snackbarHostState = snackbarHostState;
        this.$coroutineScope = coroutineScope;
        this.$onSnackbarShown = function0;
        this.$snackbarAction = snackbarAction;
        this.$duration = snackbarDuration;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SnackbarMessageKt$SnackbarMessage$1$1(this.$message, this.$snackbarHostState, this.$coroutineScope, this.$onSnackbarShown, this.$snackbarAction, this.$duration, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SnackbarMessageKt$SnackbarMessage$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        String str = this.$message;
        if (str != null) {
            SnackbarHostState snackbarHostState = this.$snackbarHostState;
            CoroutineScope coroutineScope = this.$coroutineScope;
            Function0<Unit> function0 = this.$onSnackbarShown;
            SnackbarAction snackbarAction = this.$snackbarAction;
            SnackbarDuration snackbarDuration = this.$duration;
            SnackbarData currentSnackbarData = snackbarHostState.getCurrentSnackbarData();
            if (currentSnackbarData != null) {
                currentSnackbarData.dismiss();
            }
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new SnackbarMessageKt$SnackbarMessage$1$1$1$1(str, snackbarAction, snackbarHostState, snackbarDuration, null), 3, null);
            function0.invoke();
        }
        return Unit.INSTANCE;
    }
}
