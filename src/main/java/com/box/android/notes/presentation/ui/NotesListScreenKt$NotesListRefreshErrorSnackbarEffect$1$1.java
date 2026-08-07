package com.box.android.notes.presentation.ui;

import androidx.compose.material3.SnackbarHostState;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: NotesListScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.notes.presentation.ui.NotesListScreenKt$NotesListRefreshErrorSnackbarEffect$1$1", f = "NotesListScreen.kt", i = {}, l = {Token.COMMENT, 171}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class NotesListScreenKt$NotesListRefreshErrorSnackbarEffect$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isNetworkConnectionErrorMessage;
    final /* synthetic */ String $message;
    final /* synthetic */ String $networkErrorRetryLabel;
    final /* synthetic */ Function0<Unit> $onDismiss;
    final /* synthetic */ Function0<Unit> $onRetry;
    final /* synthetic */ SnackbarHostState $snackbarHostState;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NotesListScreenKt$NotesListRefreshErrorSnackbarEffect$1$1(SnackbarHostState snackbarHostState, boolean z, String str, String str2, Function0<Unit> function0, Function0<Unit> function1, Continuation<? super NotesListScreenKt$NotesListRefreshErrorSnackbarEffect$1$1> continuation) {
        super(2, continuation);
        this.$snackbarHostState = snackbarHostState;
        this.$isNetworkConnectionErrorMessage = z;
        this.$message = str;
        this.$networkErrorRetryLabel = str2;
        this.$onRetry = function0;
        this.$onDismiss = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NotesListScreenKt$NotesListRefreshErrorSnackbarEffect$1$1(this.$snackbarHostState, this.$isNetworkConnectionErrorMessage, this.$message, this.$networkErrorRetryLabel, this.$onRetry, this.$onDismiss, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NotesListScreenKt$NotesListRefreshErrorSnackbarEffect$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0044, code lost:
    
        if (r13 == r0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0069, code lost:
    
        if (androidx.compose.material3.SnackbarHostState.showSnackbar$default(r12.$snackbarHostState, r12.$message, null, false, androidx.compose.material3.SnackbarDuration.Short, r12, 6, null) == r0) goto L24;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.throwOnFailure(r13)
            goto L6c
        L12:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L1a:
            kotlin.ResultKt.throwOnFailure(r13)
            goto L47
        L1e:
            kotlin.ResultKt.throwOnFailure(r13)
            androidx.compose.material3.SnackbarHostState r13 = r12.$snackbarHostState
            androidx.compose.material3.SnackbarData r13 = r13.getCurrentSnackbarData()
            if (r13 == 0) goto L2c
            r13.dismiss()
        L2c:
            boolean r13 = r12.$isNetworkConnectionErrorMessage
            if (r13 == 0) goto L55
            androidx.compose.material3.SnackbarHostState r4 = r12.$snackbarHostState
            java.lang.String r5 = r12.$message
            java.lang.String r6 = r12.$networkErrorRetryLabel
            androidx.compose.material3.SnackbarDuration r8 = androidx.compose.material3.SnackbarDuration.Indefinite
            r9 = r12
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            r12.label = r3
            r7 = 0
            r10 = 4
            r11 = 0
            java.lang.Object r13 = androidx.compose.material3.SnackbarHostState.showSnackbar$default(r4, r5, r6, r7, r8, r9, r10, r11)
            if (r13 != r0) goto L47
            goto L6b
        L47:
            androidx.compose.material3.SnackbarResult r13 = (androidx.compose.material3.SnackbarResult) r13
            androidx.compose.material3.SnackbarResult r0 = androidx.compose.material3.SnackbarResult.ActionPerformed
            if (r13 != r0) goto L52
            kotlin.jvm.functions.Function0<kotlin.Unit> r13 = r12.$onRetry
            r13.invoke()
        L52:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            goto L6c
        L55:
            androidx.compose.material3.SnackbarHostState r1 = r12.$snackbarHostState
            r13 = r2
            java.lang.String r2 = r12.$message
            androidx.compose.material3.SnackbarDuration r5 = androidx.compose.material3.SnackbarDuration.Short
            r6 = r12
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r12.label = r13
            r3 = 0
            r4 = 0
            r7 = 6
            r8 = 0
            java.lang.Object r13 = androidx.compose.material3.SnackbarHostState.showSnackbar$default(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r13 != r0) goto L6c
        L6b:
            return r0
        L6c:
            kotlin.jvm.functions.Function0<kotlin.Unit> r12 = r12.$onDismiss
            r12.invoke()
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.notes.presentation.ui.NotesListScreenKt$NotesListRefreshErrorSnackbarEffect$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
