package com.box.android.browse.cpl.browse;

import androidx.compose.material3.SnackbarDuration;
import androidx.compose.material3.SnackbarResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;

/* JADX INFO: compiled from: FolderItemPickerScreen.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0002\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Landroidx/compose/material3/SnackbarResult;", "<unused var>", "", "Landroidx/compose/material3/SnackbarDuration;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.browse.cpl.browse.FolderItemPickerScreenKt$FolderItemPickerScreen$4$1", f = "FolderItemPickerScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class FolderItemPickerScreenKt$FolderItemPickerScreen$4$1 extends SuspendLambda implements Function4<String, String, SnackbarDuration, Continuation<? super SnackbarResult>, Object> {
    int label;

    FolderItemPickerScreenKt$FolderItemPickerScreen$4$1(Continuation<? super FolderItemPickerScreenKt$FolderItemPickerScreen$4$1> continuation) {
        super(4, continuation);
    }

    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(String str, String str2, SnackbarDuration snackbarDuration, Continuation<? super SnackbarResult> continuation) {
        return new FolderItemPickerScreenKt$FolderItemPickerScreen$4$1(continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return SnackbarResult.Dismissed;
    }
}
