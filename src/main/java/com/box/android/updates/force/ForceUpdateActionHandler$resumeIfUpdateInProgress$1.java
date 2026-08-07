package com.box.android.updates.force;

import androidx.appcompat.app.AppCompatActivity;
import com.box.androidsdk.content.models.BoxRepresentation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ForceUpdateActionHandler.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.updates.force.ForceUpdateActionHandler$resumeIfUpdateInProgress$1", f = "ForceUpdateActionHandler.kt", i = {0, 1, 1, 1}, l = {42, 48}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "infoResult", BoxRepresentation.FIELD_INFO}, s = {"L$0", "L$0", "L$1", "L$2"}, v = 1)
final class ForceUpdateActionHandler$resumeIfUpdateInProgress$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppCompatActivity $activity;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ ForceUpdateActionHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ForceUpdateActionHandler$resumeIfUpdateInProgress$1(ForceUpdateActionHandler forceUpdateActionHandler, AppCompatActivity appCompatActivity, Continuation<? super ForceUpdateActionHandler$resumeIfUpdateInProgress$1> continuation) {
        super(2, continuation);
        this.this$0 = forceUpdateActionHandler;
        this.$activity = appCompatActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ForceUpdateActionHandler$resumeIfUpdateInProgress$1 forceUpdateActionHandler$resumeIfUpdateInProgress$1 = new ForceUpdateActionHandler$resumeIfUpdateInProgress$1(this.this$0, this.$activity, continuation);
        forceUpdateActionHandler$resumeIfUpdateInProgress$1.L$0 = obj;
        return forceUpdateActionHandler$resumeIfUpdateInProgress$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ForceUpdateActionHandler$resumeIfUpdateInProgress$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x008e, code lost:
    
        if (com.box.android.updates.AppUpdateManagerExtensionsKt.startUpdateFlowAsResult(r8.this$0.appUpdateManager, r2, r8.$activity, 1, r8) == r1) goto L19;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = r8.L$0
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r8.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L2b
            if (r2 == r4) goto L27
            if (r2 != r3) goto L1f
            java.lang.Object r0 = r8.L$2
            com.google.android.play.core.appupdate.AppUpdateInfo r0 = (com.google.android.play.core.appupdate.AppUpdateInfo) r0
            java.lang.Object r8 = r8.L$1
            com.box.android.domain.utils.result.Result r8 = (com.box.android.domain.utils.result.Result) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L9e
        L1f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L27:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L42
        L2b:
            kotlin.ResultKt.throwOnFailure(r9)
            com.box.android.updates.force.ForceUpdateActionHandler r9 = r8.this$0
            com.google.android.play.core.appupdate.AppUpdateManager r9 = com.box.android.updates.force.ForceUpdateActionHandler.access$getAppUpdateManager$p(r9)
            r2 = r8
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r8.L$0 = r0
            r8.label = r4
            java.lang.Object r9 = com.box.android.updates.AppUpdateManagerExtensionsKt.getAppUpdateInfoAsResult(r9, r2)
            if (r9 != r1) goto L42
            goto L90
        L42:
            com.box.android.domain.utils.result.Result r9 = (com.box.android.domain.utils.result.Result) r9
            boolean r2 = r9 instanceof com.box.android.domain.utils.result.Result.Success
            if (r2 == 0) goto L91
            r2 = r9
            com.box.android.domain.utils.result.Result$Success r2 = (com.box.android.domain.utils.result.Result.Success) r2
            java.lang.Object r2 = r2.getValue()
            com.google.android.play.core.appupdate.AppUpdateInfo r2 = (com.google.android.play.core.appupdate.AppUpdateInfo) r2
            com.box.android.updates.force.ForceUpdateActionHandler r5 = r8.this$0
            boolean r5 = com.box.android.updates.force.ForceUpdateActionHandler.access$isUpdateInProgress(r5, r2)
            if (r5 == 0) goto L9e
            java.lang.String r5 = com.box.android.domain.utils.ExtensionsKt.getTAG(r0)
            java.lang.String r6 = "Resuming in-progress update"
            com.box.androidsdk.content.utils.BoxLogUtils.d(r5, r6)
            com.box.android.updates.force.ForceUpdateActionHandler r5 = r8.this$0
            com.box.android.domain.metrics.ForceUpdateObservability r5 = com.box.android.updates.force.ForceUpdateActionHandler.access$getObservability$p(r5)
            r5.logInAppUpdateResumed()
            com.box.android.updates.force.ForceUpdateActionHandler r5 = r8.this$0
            com.google.android.play.core.appupdate.AppUpdateManager r5 = com.box.android.updates.force.ForceUpdateActionHandler.access$getAppUpdateManager$p(r5)
            androidx.appcompat.app.AppCompatActivity r6 = r8.$activity
            r7 = r8
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
            r8.L$0 = r0
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r8.L$1 = r9
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r8.L$2 = r9
            r8.label = r3
            java.lang.Object r8 = com.box.android.updates.AppUpdateManagerExtensionsKt.startUpdateFlowAsResult(r5, r2, r6, r4, r7)
            if (r8 != r1) goto L9e
        L90:
            return r1
        L91:
            boolean r8 = r9 instanceof com.box.android.domain.utils.result.Result.Error
            if (r8 == 0) goto La1
            java.lang.String r8 = com.box.android.domain.utils.ExtensionsKt.getTAG(r0)
            java.lang.String r9 = "Failed to check update status"
            com.box.androidsdk.content.utils.BoxLogUtils.e(r8, r9)
        L9e:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        La1:
            kotlin.NoWhenBranchMatchedException r8 = new kotlin.NoWhenBranchMatchedException
            r8.<init>()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.updates.force.ForceUpdateActionHandler$resumeIfUpdateInProgress$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
