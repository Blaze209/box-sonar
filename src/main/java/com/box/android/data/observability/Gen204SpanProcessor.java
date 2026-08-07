package com.box.android.data.observability;

import com.box.android.data.service.impl.ApdexScoreProvider;
import com.box.android.domain.models.observability.ApdexGen204Metric;
import com.box.android.domain.services.IApdexScoreProvider;
import com.box.android.domain.usecases.observability.MetricsUseCase;
import com.box.androidsdk.content.utils.BoxLogUtils;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.trace.ReadWriteSpan;
import io.opentelemetry.sdk.trace.ReadableSpan;
import io.opentelemetry.sdk.trace.SpanProcessor;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: OpenTelemetryInstrumentation.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/box/android/data/observability/Gen204SpanProcessor;", "Lio/opentelemetry/sdk/trace/SpanProcessor;", "metricsUseCase", "Lcom/box/android/domain/usecases/observability/MetricsUseCase;", "apdexScoreProvider", "Lcom/box/android/data/service/impl/ApdexScoreProvider;", "<init>", "(Lcom/box/android/domain/usecases/observability/MetricsUseCase;Lcom/box/android/data/service/impl/ApdexScoreProvider;)V", "onStart", "", "parentContext", "Lio/opentelemetry/context/Context;", "span", "Lio/opentelemetry/sdk/trace/ReadWriteSpan;", "isStartRequired", "", "onEnd", "Lio/opentelemetry/sdk/trace/ReadableSpan;", "isEndRequired", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Gen204SpanProcessor implements SpanProcessor {
    private final ApdexScoreProvider apdexScoreProvider;
    private final MetricsUseCase metricsUseCase;

    @Override // io.opentelemetry.sdk.trace.SpanProcessor
    public boolean isEndRequired() {
        return true;
    }

    @Override // io.opentelemetry.sdk.trace.SpanProcessor
    public boolean isStartRequired() {
        return true;
    }

    @Override // io.opentelemetry.sdk.trace.SpanProcessor
    public void onStart(Context parentContext, ReadWriteSpan span) {
        Intrinsics.checkNotNullParameter(parentContext, "parentContext");
        Intrinsics.checkNotNullParameter(span, "span");
    }

    public Gen204SpanProcessor(MetricsUseCase metricsUseCase, ApdexScoreProvider apdexScoreProvider) {
        Intrinsics.checkNotNullParameter(metricsUseCase, "metricsUseCase");
        Intrinsics.checkNotNullParameter(apdexScoreProvider, "apdexScoreProvider");
        this.metricsUseCase = metricsUseCase;
        this.apdexScoreProvider = apdexScoreProvider;
    }

    @Override // io.opentelemetry.sdk.trace.SpanProcessor
    public void onEnd(ReadableSpan span) {
        Intrinsics.checkNotNullParameter(span, "span");
        ApdexScoreProvider apdexScoreProvider = this.apdexScoreProvider;
        String name = span.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(OpenTelemetryInstrumentationKt.toApdexMetric(span, IApdexScoreProvider.score$default(apdexScoreProvider, name, OpenTelemetryInstrumentationKt.toMillis(span.toSpanData().getEndEpochNanos() - span.toSpanData().getStartEpochNanos()), null, null, 12, null)), this, null), 3, null);
        BoxLogUtils.e("ApdexMetric: " + span.getName());
    }

    /* JADX INFO: renamed from: com.box.android.data.observability.Gen204SpanProcessor$onEnd$1, reason: invalid class name */
    /* JADX INFO: compiled from: OpenTelemetryInstrumentation.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.observability.Gen204SpanProcessor$onEnd$1", f = "OpenTelemetryInstrumentation.kt", i = {0, 0, 0, 0, 0}, l = {110}, m = "invokeSuspend", n = {"$this$forEach$iv", "element$iv", "it", "$i$f$forEach", "$i$a$-forEach-Gen204SpanProcessor$onEnd$1$1"}, s = {"L$0", "L$3", "L$4", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ApdexMetric $apdexMetric;
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        final /* synthetic */ Gen204SpanProcessor this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ApdexMetric apdexMetric, Gen204SpanProcessor gen204SpanProcessor, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$apdexMetric = apdexMetric;
            this.this$0 = gen204SpanProcessor;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$apdexMetric, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Iterator it;
            Iterable iterable;
            Gen204SpanProcessor gen204SpanProcessor;
            int i;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                List<ApdexGen204Metric> gen204Metrics = ApdexMetricKt.toGen204Metrics(this.$apdexMetric);
                Gen204SpanProcessor gen204SpanProcessor2 = this.this$0;
                it = gen204Metrics.iterator();
                iterable = gen204Metrics;
                gen204SpanProcessor = gen204SpanProcessor2;
                i = 0;
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i = this.I$0;
                it = (Iterator) this.L$2;
                gen204SpanProcessor = (Gen204SpanProcessor) this.L$1;
                iterable = (Iterable) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            while (it.hasNext()) {
                Object next = it.next();
                ApdexGen204Metric apdexGen204Metric = (ApdexGen204Metric) next;
                this.L$0 = SpillingKt.nullOutSpilledVariable(iterable);
                this.L$1 = gen204SpanProcessor;
                this.L$2 = it;
                this.L$3 = SpillingKt.nullOutSpilledVariable(next);
                this.L$4 = SpillingKt.nullOutSpilledVariable(apdexGen204Metric);
                this.I$0 = i;
                this.I$1 = 0;
                this.label = 1;
                if (gen204SpanProcessor.metricsUseCase.log(apdexGen204Metric, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
    }
}
