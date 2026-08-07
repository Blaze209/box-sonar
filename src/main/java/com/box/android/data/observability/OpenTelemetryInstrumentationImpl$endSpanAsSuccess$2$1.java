package com.box.android.data.observability;

import io.opentelemetry.api.trace.Span;
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
@DebugMetadata(c = "com.box.android.data.observability.OpenTelemetryInstrumentationImpl$endSpanAsSuccess$2$1", f = "OpenTelemetryInstrumentation.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class OpenTelemetryInstrumentationImpl$endSpanAsSuccess$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Span $span;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OpenTelemetryInstrumentationImpl$endSpanAsSuccess$2$1(Span span, Continuation<? super OpenTelemetryInstrumentationImpl$endSpanAsSuccess$2$1> continuation) {
        super(2, continuation);
        this.$span = span;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OpenTelemetryInstrumentationImpl$endSpanAsSuccess$2$1(this.$span, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OpenTelemetryInstrumentationImpl$endSpanAsSuccess$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.$span.end();
        return Unit.INSTANCE;
    }
}
