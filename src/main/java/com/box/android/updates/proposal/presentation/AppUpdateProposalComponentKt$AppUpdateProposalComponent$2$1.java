package com.box.android.updates.proposal.presentation;

import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.State;
import com.box.android.cpl.Store;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AppUpdateProposalComponent.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.updates.proposal.presentation.AppUpdateProposalComponentKt$AppUpdateProposalComponent$2$1", f = "AppUpdateProposalComponent.kt", i = {}, l = {44, 52}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class AppUpdateProposalComponentKt$AppUpdateProposalComponent$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $downloadCompletedActionLabel;
    final /* synthetic */ String $downloadCompletedMessage;
    final /* synthetic */ String $downloadInProgressMessage;
    final /* synthetic */ SnackbarHostState $snackbarHostState;
    final /* synthetic */ State<AppUpdateProposalReducer.State> $state$delegate;
    final /* synthetic */ Store<AppUpdateProposalReducer.State, AppUpdateProposalReducer.Action> $store;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AppUpdateProposalComponentKt$AppUpdateProposalComponent$2$1(SnackbarHostState snackbarHostState, String str, Store<AppUpdateProposalReducer.State, AppUpdateProposalReducer.Action> store, String str2, String str3, State<AppUpdateProposalReducer.State> state, Continuation<? super AppUpdateProposalComponentKt$AppUpdateProposalComponent$2$1> continuation) {
        super(2, continuation);
        this.$snackbarHostState = snackbarHostState;
        this.$downloadInProgressMessage = str;
        this.$store = store;
        this.$downloadCompletedMessage = str2;
        this.$downloadCompletedActionLabel = str3;
        this.$state$delegate = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AppUpdateProposalComponentKt$AppUpdateProposalComponent$2$1(this.$snackbarHostState, this.$downloadInProgressMessage, this.$store, this.$downloadCompletedMessage, this.$downloadCompletedActionLabel, this.$state$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AppUpdateProposalComponentKt$AppUpdateProposalComponent$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0046, code lost:
    
        if (androidx.compose.material3.SnackbarHostState.showSnackbar$default(r12.$snackbarHostState, r12.$downloadInProgressMessage, null, false, androidx.compose.material3.SnackbarDuration.Short, r12, 6, null) == r0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006d, code lost:
    
        if (r13 == r0) goto L20;
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
            goto L70
        L12:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L1a:
            kotlin.ResultKt.throwOnFailure(r13)
            goto L49
        L1e:
            kotlin.ResultKt.throwOnFailure(r13)
            androidx.compose.runtime.State<com.box.android.updates.proposal.presentation.AppUpdateProposalReducer$State> r13 = r12.$state$delegate
            com.box.android.updates.proposal.presentation.AppUpdateProposalReducer$State r13 = com.box.android.updates.proposal.presentation.AppUpdateProposalComponentKt.access$AppUpdateProposalComponent$lambda$0(r13)
            com.box.android.updates.proposal.presentation.AppUpdateProposalReducer$ViewEffect r13 = r13.getViewEffect()
            com.box.android.updates.proposal.presentation.AppUpdateProposalReducer$ViewEffect$DownloadStartedMessage r1 = com.box.android.updates.proposal.presentation.AppUpdateProposalReducer.ViewEffect.DownloadStartedMessage.INSTANCE
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r13, r1)
            if (r1 == 0) goto L51
            androidx.compose.material3.SnackbarHostState r4 = r12.$snackbarHostState
            java.lang.String r5 = r12.$downloadInProgressMessage
            androidx.compose.material3.SnackbarDuration r8 = androidx.compose.material3.SnackbarDuration.Short
            r9 = r12
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            r12.label = r3
            r6 = 0
            r7 = 0
            r10 = 6
            r11 = 0
            java.lang.Object r13 = androidx.compose.material3.SnackbarHostState.showSnackbar$default(r4, r5, r6, r7, r8, r9, r10, r11)
            if (r13 != r0) goto L49
            goto L6f
        L49:
            com.box.android.cpl.Store<com.box.android.updates.proposal.presentation.AppUpdateProposalReducer$State, com.box.android.updates.proposal.presentation.AppUpdateProposalReducer$Action> r12 = r12.$store
            com.box.android.updates.proposal.presentation.AppUpdateProposalReducer$Action$OnViewEffectProcessed r13 = com.box.android.updates.proposal.presentation.AppUpdateProposalReducer.Action.OnViewEffectProcessed.INSTANCE
            r12.send(r13)
            goto L8d
        L51:
            com.box.android.updates.proposal.presentation.AppUpdateProposalReducer$ViewEffect$DownloadCompletedMessage r1 = com.box.android.updates.proposal.presentation.AppUpdateProposalReducer.ViewEffect.DownloadCompletedMessage.INSTANCE
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r13, r1)
            if (r1 == 0) goto L85
            androidx.compose.material3.SnackbarHostState r3 = r12.$snackbarHostState
            java.lang.String r4 = r12.$downloadCompletedMessage
            java.lang.String r5 = r12.$downloadCompletedActionLabel
            androidx.compose.material3.SnackbarDuration r7 = androidx.compose.material3.SnackbarDuration.Indefinite
            r8 = r12
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r12.label = r2
            r6 = 0
            r9 = 4
            r10 = 0
            java.lang.Object r13 = androidx.compose.material3.SnackbarHostState.showSnackbar$default(r3, r4, r5, r6, r7, r8, r9, r10)
            if (r13 != r0) goto L70
        L6f:
            return r0
        L70:
            androidx.compose.material3.SnackbarResult r13 = (androidx.compose.material3.SnackbarResult) r13
            androidx.compose.material3.SnackbarResult r0 = androidx.compose.material3.SnackbarResult.ActionPerformed
            if (r13 != r0) goto L7d
            com.box.android.cpl.Store<com.box.android.updates.proposal.presentation.AppUpdateProposalReducer$State, com.box.android.updates.proposal.presentation.AppUpdateProposalReducer$Action> r13 = r12.$store
            com.box.android.updates.proposal.presentation.AppUpdateProposalReducer$Action$OnCompleteActionClicked r0 = com.box.android.updates.proposal.presentation.AppUpdateProposalReducer.Action.OnCompleteActionClicked.INSTANCE
            r13.send(r0)
        L7d:
            com.box.android.cpl.Store<com.box.android.updates.proposal.presentation.AppUpdateProposalReducer$State, com.box.android.updates.proposal.presentation.AppUpdateProposalReducer$Action> r12 = r12.$store
            com.box.android.updates.proposal.presentation.AppUpdateProposalReducer$Action$OnViewEffectProcessed r13 = com.box.android.updates.proposal.presentation.AppUpdateProposalReducer.Action.OnViewEffectProcessed.INSTANCE
            r12.send(r13)
            goto L8d
        L85:
            com.box.android.updates.proposal.presentation.AppUpdateProposalReducer$ViewEffect$None r12 = com.box.android.updates.proposal.presentation.AppUpdateProposalReducer.ViewEffect.None.INSTANCE
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual(r13, r12)
            if (r12 == 0) goto L90
        L8d:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L90:
            kotlin.NoWhenBranchMatchedException r12 = new kotlin.NoWhenBranchMatchedException
            r12.<init>()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.updates.proposal.presentation.AppUpdateProposalComponentKt$AppUpdateProposalComponent$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
