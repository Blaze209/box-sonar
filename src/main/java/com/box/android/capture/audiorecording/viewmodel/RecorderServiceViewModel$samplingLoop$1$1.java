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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.capture.audiorecording.viewmodel.RecorderServiceViewModel$samplingLoop$1$1", f = "RecorderServiceViewModel.kt", i = {0, 0, 1, 1}, l = {55, 56}, m = "invokeSuspend", n = {"$this$flow", "sample", "$this$flow", "sample"}, s = {"L$0", "D$0", "L$0", "D$0"}, v = 1)
final class RecorderServiceViewModel$samplingLoop$1$1 extends SuspendLambda implements Function2<FlowCollector<? super Unit>, Continuation<? super Unit>, Object> {
    double D$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ RecorderServiceViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RecorderServiceViewModel$samplingLoop$1$1(RecorderServiceViewModel recorderServiceViewModel, Continuation<? super RecorderServiceViewModel$samplingLoop$1$1> continuation) {
        super(2, continuation);
        this.this$0 = recorderServiceViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        RecorderServiceViewModel$samplingLoop$1$1 recorderServiceViewModel$samplingLoop$1$1 = new RecorderServiceViewModel$samplingLoop$1$1(this.this$0, continuation);
        recorderServiceViewModel$samplingLoop$1$1.L$0 = obj;
        return recorderServiceViewModel$samplingLoop$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super Unit> flowCollector, Continuation<? super Unit> continuation) {
        return ((RecorderServiceViewModel$samplingLoop$1$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0024  */
    /* JADX WARN: Code duplicated, block: B:13:0x0032  */
    /* JADX WARN: Code duplicated, block: B:16:0x0060 A[PHI: r5
      0x0060: PHI (r5v1 double) = (r5v0 double), (r5v3 double) binds: [B:14:0x005d, B:9:0x001b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x006f -> B:11:0x0024). Please report as a decompilation issue!!! */
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
            if (r2 == 0) goto L21
            if (r2 == r4) goto L1b
            if (r2 != r3) goto L13
            goto L21
        L13:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L1b:
            double r5 = r7.D$0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L60
        L21:
            kotlin.ResultKt.throwOnFailure(r8)
        L24:
            com.box.android.capture.audiorecording.viewmodel.RecorderServiceViewModel r8 = r7.this$0
            kotlinx.coroutines.flow.MutableStateFlow r8 = com.box.android.capture.audiorecording.viewmodel.RecorderServiceViewModel.access$getRecordingStateFlow$p(r8)
            java.lang.Object r8 = r8.getValue()
            com.box.android.capture.audiorecording.RecordingFileState r2 = com.box.android.capture.audiorecording.RecordingFileState.RECORDING
            if (r8 != r2) goto L72
            com.box.android.capture.audiorecording.viewmodel.RecorderServiceViewModel r8 = r7.this$0
            double r5 = com.box.android.capture.audiorecording.viewmodel.RecorderServiceViewModel.access$getLatestSample(r8)
            com.box.android.capture.audiorecording.viewmodel.RecorderServiceViewModel r8 = r7.this$0
            androidx.lifecycle.MutableLiveData r8 = com.box.android.capture.audiorecording.viewmodel.RecorderServiceViewModel.access$getRecordedFileAmps$p(r8)
            java.lang.Double r2 = kotlin.coroutines.jvm.internal.Boxing.boxDouble(r5)
            com.box.android.base.presentation.utilities.ViewModelExtensionsKt.addValue(r8, r2)
            com.box.android.capture.audiorecording.viewmodel.RecorderServiceViewModel r8 = r7.this$0
            com.box.android.capture.audiorecording.IRecordingFileManager r8 = com.box.android.capture.audiorecording.viewmodel.RecorderServiceViewModel.access$getRecordingFileManager$p(r8)
            r8.saveMetadataSample(r5)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            r2 = r7
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r7.L$0 = r0
            r7.D$0 = r5
            r7.label = r4
            java.lang.Object r8 = r0.emit(r8, r2)
            if (r8 != r1) goto L60
            goto L71
        L60:
            r8 = r7
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r7.L$0 = r0
            r7.D$0 = r5
            r7.label = r3
            r5 = 30
            java.lang.Object r8 = kotlinx.coroutines.DelayKt.delay(r5, r8)
            if (r8 != r1) goto L24
        L71:
            return r1
        L72:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.capture.audiorecording.viewmodel.RecorderServiceViewModel$samplingLoop$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
