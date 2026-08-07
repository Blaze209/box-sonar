package com.box.android.browse.cpl.copymove;

import androidx.compose.material3.SnackbarDuration;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.SnackbarResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;

/* JADX INFO: compiled from: CopyOrMoveScreen.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "Landroidx/compose/material3/SnackbarResult;", "message", "", "<unused var>", "Landroidx/compose/material3/SnackbarDuration;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.browse.cpl.copymove.CopyOrMoveScreenKt$CopyOrMoveScreen$7$1$1$1", f = "CopyOrMoveScreen.kt", i = {0}, l = {105}, m = "invokeSuspend", n = {"message"}, s = {"L$0"}, v = 1)
final class CopyOrMoveScreenKt$CopyOrMoveScreen$7$1$1$1 extends SuspendLambda implements Function4<String, String, SnackbarDuration, Continuation<? super SnackbarResult>, Object> {
    final /* synthetic */ SnackbarHostState $snackbarHostState;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CopyOrMoveScreenKt$CopyOrMoveScreen$7$1$1$1(SnackbarHostState snackbarHostState, Continuation<? super CopyOrMoveScreenKt$CopyOrMoveScreen$7$1$1$1> continuation) {
        super(4, continuation);
        this.$snackbarHostState = snackbarHostState;
    }

    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(String str, String str2, SnackbarDuration snackbarDuration, Continuation<? super SnackbarResult> continuation) {
        CopyOrMoveScreenKt$CopyOrMoveScreen$7$1$1$1 copyOrMoveScreenKt$CopyOrMoveScreen$7$1$1$1 = new CopyOrMoveScreenKt$CopyOrMoveScreen$7$1$1$1(this.$snackbarHostState, continuation);
        copyOrMoveScreenKt$CopyOrMoveScreen$7$1$1$1.L$0 = str;
        return copyOrMoveScreenKt$CopyOrMoveScreen$7$1$1$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str = (String) this.L$0;
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
        this.L$0 = SpillingKt.nullOutSpilledVariable(str);
        this.label = 1;
        Object objShowSnackbar$default = SnackbarHostState.showSnackbar$default(this.$snackbarHostState, str, null, false, null, this, 14, null);
        return objShowSnackbar$default == coroutine_suspended ? coroutine_suspended : objShowSnackbar$default;
    }
}
