package com.box.android.browse.cpl.recents;

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

/* JADX INFO: compiled from: RecentsScreen.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n"}, d2 = {"<anonymous>", "Landroidx/compose/material3/SnackbarResult;", "message", "", "actionLabel", "duration", "Landroidx/compose/material3/SnackbarDuration;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.browse.cpl.recents.RecentsScreenKt$RecentsScreen$1$1", f = "RecentsScreen.kt", i = {0, 0, 0}, l = {48}, m = "invokeSuspend", n = {"message", "actionLabel", "duration"}, s = {"L$0", "L$1", "L$2"}, v = 1)
final class RecentsScreenKt$RecentsScreen$1$1 extends SuspendLambda implements Function4<String, String, SnackbarDuration, Continuation<? super SnackbarResult>, Object> {
    final /* synthetic */ SnackbarHostState $snackbarHostState;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RecentsScreenKt$RecentsScreen$1$1(SnackbarHostState snackbarHostState, Continuation<? super RecentsScreenKt$RecentsScreen$1$1> continuation) {
        super(4, continuation);
        this.$snackbarHostState = snackbarHostState;
    }

    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(String str, String str2, SnackbarDuration snackbarDuration, Continuation<? super SnackbarResult> continuation) {
        RecentsScreenKt$RecentsScreen$1$1 recentsScreenKt$RecentsScreen$1$1 = new RecentsScreenKt$RecentsScreen$1$1(this.$snackbarHostState, continuation);
        recentsScreenKt$RecentsScreen$1$1.L$0 = str;
        recentsScreenKt$RecentsScreen$1$1.L$1 = str2;
        recentsScreenKt$RecentsScreen$1$1.L$2 = snackbarDuration;
        return recentsScreenKt$RecentsScreen$1$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str = (String) this.L$0;
        String str2 = (String) this.L$1;
        SnackbarDuration snackbarDuration = (SnackbarDuration) this.L$2;
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
        this.L$1 = SpillingKt.nullOutSpilledVariable(str2);
        this.L$2 = SpillingKt.nullOutSpilledVariable(snackbarDuration);
        this.label = 1;
        Object objShowSnackbar$default = SnackbarHostState.showSnackbar$default(this.$snackbarHostState, str, str2, false, snackbarDuration, this, 4, null);
        return objShowSnackbar$default == coroutine_suspended ? coroutine_suspended : objShowSnackbar$default;
    }
}
