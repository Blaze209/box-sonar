package com.box.android.capture.audiorecording.viewmodel;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: RecorderServiceViewModel.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.capture.audiorecording.viewmodel.RecorderServiceViewModel$recordedTime$1$1", f = "RecorderServiceViewModel.kt", i = {0, 1}, l = {43, 44}, m = "invokeSuspend", n = {"$this$flow", "$this$flow"}, s = {"L$0", "L$0"}, v = 1)
final class RecorderServiceViewModel$recordedTime$1$1 extends SuspendLambda implements Function2<FlowCollector<? super String>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ RecorderServiceViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RecorderServiceViewModel$recordedTime$1$1(RecorderServiceViewModel recorderServiceViewModel, Continuation<? super RecorderServiceViewModel$recordedTime$1$1> continuation) {
        super(2, continuation);
        this.this$0 = recorderServiceViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        RecorderServiceViewModel$recordedTime$1$1 recorderServiceViewModel$recordedTime$1$1 = new RecorderServiceViewModel$recordedTime$1$1(this.this$0, continuation);
        recorderServiceViewModel$recordedTime$1$1.L$0 = obj;
        return recorderServiceViewModel$recordedTime$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super String> flowCollector, Continuation<? super Unit> continuation) {
        return ((RecorderServiceViewModel$recordedTime$1$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0022  */
    /* JADX WARN: Code duplicated, block: B:13:0x0030  */
    /* JADX WARN: Code duplicated, block: B:16:0x0044  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0051 -> B:11:0x0022). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.L$0
            kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r7.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L1f
            if (r2 == r4) goto L1b
            if (r2 != r3) goto L13
            goto L1f
        L13:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L1b:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L44
        L1f:
            kotlin.ResultKt.throwOnFailure(r8)
        L22:
            com.box.android.capture.audiorecording.viewmodel.RecorderServiceViewModel r8 = r7.this$0
            kotlinx.coroutines.flow.MutableStateFlow r8 = com.box.android.capture.audiorecording.viewmodel.RecorderServiceViewModel.access$getRecordingStateFlow$p(r8)
            java.lang.Object r8 = r8.getValue()
            com.box.android.capture.audiorecording.RecordingFileState r2 = com.box.android.capture.audiorecording.RecordingFileState.RECORDING
            if (r8 != r2) goto L54
            com.box.android.capture.audiorecording.viewmodel.RecorderServiceViewModel r8 = r7.this$0
            java.lang.String r8 = r8.getElapsedTime()
            r2 = r7
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r7.L$0 = r0
            r7.label = r4
            java.lang.Object r8 = r0.emit(r8, r2)
            if (r8 != r1) goto L44
            goto L53
        L44:
            r8 = r7
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r7.L$0 = r0
            r7.label = r3
            r5 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r8 = kotlinx.coroutines.DelayKt.delay(r5, r8)
            if (r8 != r1) goto L22
        L53:
            return r1
        L54:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.capture.audiorecording.viewmodel.RecorderServiceViewModel$recordedTime$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
