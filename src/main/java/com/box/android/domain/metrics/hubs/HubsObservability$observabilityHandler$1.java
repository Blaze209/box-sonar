package com.box.android.domain.metrics.hubs;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;

/* JADX INFO: compiled from: HubsObservability.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class HubsObservability$observabilityHandler$1 extends AdaptedFunctionReference implements Function2<HubsObservabilityLaunchData, Continuation<? super Unit>, Object>, SuspendFunction {
    HubsObservability$observabilityHandler$1(Object obj) {
        super(2, obj, HubsObservability.class, "sendEvent", "sendEvent(Lcom/box/android/domain/metrics/hubs/HubsObservabilityLaunchData;)V", 4);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(HubsObservabilityLaunchData hubsObservabilityLaunchData, Continuation<? super Unit> continuation) {
        return HubsObservability.observabilityHandler$sendEvent((HubsObservability) this.receiver, hubsObservabilityLaunchData, continuation);
    }
}
