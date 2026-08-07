package com.box.android.base.compose;

import androidx.compose.runtime.ProduceStateScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: ComposeUtils.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/runtime/ProduceStateScope;", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.base.compose.ComposeUtilsKt$rememberCurrentTimeMillis$1$1", f = "ComposeUtils.kt", i = {0}, l = {182}, m = "invokeSuspend", n = {"$this$produceState"}, s = {"L$0"}, v = 1)
final class ComposeUtilsKt$rememberCurrentTimeMillis$1$1 extends SuspendLambda implements Function2<ProduceStateScope<Long>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: $$v$c$kotlin-time-Duration$-updatePeriod$0, reason: not valid java name */
    final /* synthetic */ long f168$$v$c$kotlintimeDuration$updatePeriod$0;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ComposeUtilsKt$rememberCurrentTimeMillis$1$1(long j, Continuation<? super ComposeUtilsKt$rememberCurrentTimeMillis$1$1> continuation) {
        super(2, continuation);
        this.f168$$v$c$kotlintimeDuration$updatePeriod$0 = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ComposeUtilsKt$rememberCurrentTimeMillis$1$1 composeUtilsKt$rememberCurrentTimeMillis$1$1 = new ComposeUtilsKt$rememberCurrentTimeMillis$1$1(this.f168$$v$c$kotlintimeDuration$updatePeriod$0, continuation);
        composeUtilsKt$rememberCurrentTimeMillis$1$1.L$0 = obj;
        return composeUtilsKt$rememberCurrentTimeMillis$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ProduceStateScope<Long> produceStateScope, Continuation<? super Unit> continuation) {
        return ((ComposeUtilsKt$rememberCurrentTimeMillis$1$1) create(produceStateScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002d A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:12:0x002e). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:11:0x002d
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.L$0
            androidx.compose.runtime.ProduceStateScope r0 = (androidx.compose.runtime.ProduceStateScope) r0
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r6.label
            r3 = 1
            if (r2 == 0) goto L1b
            if (r2 != r3) goto L13
            kotlin.ResultKt.throwOnFailure(r7)
            goto L2e
        L13:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L1b:
            kotlin.ResultKt.throwOnFailure(r7)
        L1e:
            long r4 = r6.f168$$v$c$kotlintimeDuration$updatePeriod$0
            r7 = r6
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r6.L$0 = r0
            r6.label = r3
            java.lang.Object r7 = kotlinx.coroutines.DelayKt.m16309delayVtjQ1oo(r4, r7)
            if (r7 != r1) goto L2e
            return r1
        L2e:
            long r4 = java.lang.System.currentTimeMillis()
            java.lang.Long r7 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r4)
            r0.setValue(r7)
            goto L1e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.base.compose.ComposeUtilsKt$rememberCurrentTimeMillis$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
