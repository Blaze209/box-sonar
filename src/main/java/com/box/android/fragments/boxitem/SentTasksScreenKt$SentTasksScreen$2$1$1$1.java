package com.box.android.fragments.boxitem;

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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: SentTasksScreen.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.fragments.boxitem.SentTasksScreenKt$SentTasksScreen$2$1$1$1", f = "SentTasksScreen.kt", i = {}, l = {43}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class SentTasksScreenKt$SentTasksScreen$2$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $actionLabel;
    final /* synthetic */ SnackbarDuration $duration;
    final /* synthetic */ String $message;
    final /* synthetic */ Function0<Unit> $onActionClicked;
    final /* synthetic */ SnackbarHostState $snackbarHostState;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SentTasksScreenKt$SentTasksScreen$2$1$1$1(SnackbarHostState snackbarHostState, String str, String str2, SnackbarDuration snackbarDuration, Function0<Unit> function0, Continuation<? super SentTasksScreenKt$SentTasksScreen$2$1$1$1> continuation) {
        super(2, continuation);
        this.$snackbarHostState = snackbarHostState;
        this.$message = str;
        this.$actionLabel = str2;
        this.$duration = snackbarDuration;
        this.$onActionClicked = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SentTasksScreenKt$SentTasksScreen$2$1$1$1(this.$snackbarHostState, this.$message, this.$actionLabel, this.$duration, this.$onActionClicked, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SentTasksScreenKt$SentTasksScreen$2$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SnackbarHostState snackbarHostState = this.$snackbarHostState;
            String str = this.$message;
            Intrinsics.checkNotNull(str);
            String str2 = this.$actionLabel;
            SnackbarDuration snackbarDuration = this.$duration;
            Intrinsics.checkNotNull(snackbarDuration);
            this.label = 1;
            obj = SnackbarHostState.showSnackbar$default(snackbarHostState, str, str2, false, snackbarDuration, this, 4, null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        if (((SnackbarResult) obj) == SnackbarResult.ActionPerformed) {
            this.$onActionClicked.invoke();
        }
        return Unit.INSTANCE;
    }
}
