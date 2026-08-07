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
@DebugMetadata(c = "com.box.android.updates.force.ForceUpdateActionHandler$startUpdate$1", f = "ForceUpdateActionHandler.kt", i = {0, 1, 1, 1}, l = {72, 78}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "infoResult", BoxRepresentation.FIELD_INFO}, s = {"L$0", "L$0", "L$1", "L$2"}, v = 1)
final class ForceUpdateActionHandler$startUpdate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppCompatActivity $activity;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ ForceUpdateActionHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ForceUpdateActionHandler$startUpdate$1(ForceUpdateActionHandler forceUpdateActionHandler, AppCompatActivity appCompatActivity, Continuation<? super ForceUpdateActionHandler$startUpdate$1> continuation) {
        super(2, continuation);
        this.this$0 = forceUpdateActionHandler;
        this.$activity = appCompatActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ForceUpdateActionHandler$startUpdate$1 forceUpdateActionHandler$startUpdate$1 = new ForceUpdateActionHandler$startUpdate$1(this.this$0, this.$activity, continuation);
        forceUpdateActionHandler$startUpdate$1.L$0 = obj;
        return forceUpdateActionHandler$startUpdate$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ForceUpdateActionHandler$startUpdate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            Method dump skipped, instruction units count: 213
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.updates.force.ForceUpdateActionHandler$startUpdate$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
