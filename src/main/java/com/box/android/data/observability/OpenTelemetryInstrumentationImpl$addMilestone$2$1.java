package com.box.android.data.observability;

import io.opentelemetry.api.trace.Span;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: OpenTelemetryInstrumentation.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.data.observability.OpenTelemetryInstrumentationImpl$addMilestone$2$1", f = "OpenTelemetryInstrumentation.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class OpenTelemetryInstrumentationImpl$addMilestone$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $eventName;
    final /* synthetic */ Span $it;
    final /* synthetic */ Long $timestamp;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OpenTelemetryInstrumentationImpl$addMilestone$2$1(Long l, Span span, String str, Continuation<? super OpenTelemetryInstrumentationImpl$addMilestone$2$1> continuation) {
        super(2, continuation);
        this.$timestamp = l;
        this.$it = span;
        this.$eventName = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OpenTelemetryInstrumentationImpl$addMilestone$2$1(this.$timestamp, this.$it, this.$eventName, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OpenTelemetryInstrumentationImpl$addMilestone$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        Long l = this.$timestamp;
        if (l != null) {
            this.$it.addEvent(this.$eventName, l.longValue(), TimeUnit.MILLISECONDS);
        } else {
            this.$it.addEvent(this.$eventName);
        }
        return Unit.INSTANCE;
    }
}
