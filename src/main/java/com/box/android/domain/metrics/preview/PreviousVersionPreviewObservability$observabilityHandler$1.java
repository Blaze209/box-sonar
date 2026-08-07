package com.box.android.domain.metrics.preview;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;

/* JADX INFO: compiled from: PreviousVersionPreviewObservability.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class PreviousVersionPreviewObservability$observabilityHandler$1 extends AdaptedFunctionReference implements Function2<PreviousVersionObservabilityLaunchData, Continuation<? super Unit>, Object>, SuspendFunction {
    PreviousVersionPreviewObservability$observabilityHandler$1(Object obj) {
        super(2, obj, PreviousVersionPreviewObservability.class, "sendEvent", "sendEvent(Lcom/box/android/domain/metrics/preview/PreviousVersionObservabilityLaunchData;)V", 4);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PreviousVersionObservabilityLaunchData previousVersionObservabilityLaunchData, Continuation<? super Unit> continuation) {
        return PreviousVersionPreviewObservability.observabilityHandler$sendEvent((PreviousVersionPreviewObservability) this.receiver, previousVersionObservabilityLaunchData, continuation);
    }
}
