package com.box.android.data.observability;

import com.box.android.data.service.impl.ApdexScoreProvider;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.usecases.observability.MetricsUseCase;
import com.box.androidsdk.content.utils.BoxLogUtils;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanBuilder;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.extension.kotlin.ContextExtensionsKt;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: compiled from: OpenTelemetryInstrumentation.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0002\u0010\u0016J(\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0015H\u0096@¢\u0006\u0002\u0010\u001aJ\u0016\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\u001cJ\u001e\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001fH\u0096@¢\u0006\u0002\u0010 R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006!"}, d2 = {"Lcom/box/android/data/observability/OpenTelemetryInstrumentationImpl;", "Lcom/box/android/data/observability/OpenTelemetryInstrumentation;", "metricsUseCase", "Lcom/box/android/domain/usecases/observability/MetricsUseCase;", "apdexScoreProvider", "Lcom/box/android/data/service/impl/ApdexScoreProvider;", "<init>", "(Lcom/box/android/domain/usecases/observability/MetricsUseCase;Lcom/box/android/data/service/impl/ApdexScoreProvider;)V", "apdexTracer", "Lio/opentelemetry/api/trace/Tracer;", "apdexSpanMap", "", "", "Lio/opentelemetry/api/trace/Span;", "getApdexSpanMap", "()Ljava/util/Map;", "startSpan", "", "performanceType", "identifier", "startTimestamp", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "addMilestone", "eventName", "timestamp", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "endSpanAsSuccess", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "endSpanWithFailure", "error", "Lcom/box/android/domain/models/DomainError;", "(Ljava/lang/String;Lcom/box/android/domain/models/DomainError;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class OpenTelemetryInstrumentationImpl implements OpenTelemetryInstrumentation {
    private final Map<String, Span> apdexSpanMap;
    private final Tracer apdexTracer;

    /* JADX INFO: renamed from: com.box.android.data.observability.OpenTelemetryInstrumentationImpl$addMilestone$1, reason: invalid class name */
    /* JADX INFO: compiled from: OpenTelemetryInstrumentation.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.observability.OpenTelemetryInstrumentationImpl", f = "OpenTelemetryInstrumentation.kt", i = {0, 0, 0, 0, 0}, l = {61}, m = "addMilestone", n = {"eventName", "identifier", "timestamp", "it", "$i$a$-also-OpenTelemetryInstrumentationImpl$addMilestone$2"}, s = {"L$0", "L$1", "L$2", "L$4", "I$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OpenTelemetryInstrumentationImpl.this.addMilestone(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.observability.OpenTelemetryInstrumentationImpl$endSpanAsSuccess$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OpenTelemetryInstrumentation.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.observability.OpenTelemetryInstrumentationImpl", f = "OpenTelemetryInstrumentation.kt", i = {0, 0, 0}, l = {73}, m = "endSpanAsSuccess", n = {"identifier", "span", "$i$a$-also-OpenTelemetryInstrumentationImpl$endSpanAsSuccess$2"}, s = {"L$0", "L$2", "I$0"}, v = 1)
    static final class C13641 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C13641(Continuation<? super C13641> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OpenTelemetryInstrumentationImpl.this.endSpanAsSuccess(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.observability.OpenTelemetryInstrumentationImpl$endSpanWithFailure$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OpenTelemetryInstrumentation.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.observability.OpenTelemetryInstrumentationImpl", f = "OpenTelemetryInstrumentation.kt", i = {0, 0, 0, 0}, l = {83}, m = "endSpanWithFailure", n = {"identifier", "error", "span", "$i$a$-also-OpenTelemetryInstrumentationImpl$endSpanWithFailure$2"}, s = {"L$0", "L$1", "L$3", "I$0"}, v = 1)
    static final class C13651 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C13651(Continuation<? super C13651> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OpenTelemetryInstrumentationImpl.this.endSpanWithFailure(null, null, this);
        }
    }

    @Inject
    public OpenTelemetryInstrumentationImpl(MetricsUseCase metricsUseCase, ApdexScoreProvider apdexScoreProvider) {
        Intrinsics.checkNotNullParameter(metricsUseCase, "metricsUseCase");
        Intrinsics.checkNotNullParameter(apdexScoreProvider, "apdexScoreProvider");
        Tracer tracer = OpenTelemetrySdk.builder().setTracerProvider(SdkTracerProvider.builder().addSpanProcessor(new Gen204SpanProcessor(metricsUseCase, apdexScoreProvider)).build()).build().getTracerProvider().get("BoxApdexTracer");
        Intrinsics.checkNotNullExpressionValue(tracer, "get(...)");
        this.apdexTracer = tracer;
        this.apdexSpanMap = new LinkedHashMap();
    }

    public final Map<String, Span> getApdexSpanMap() {
        return this.apdexSpanMap;
    }

    @Override // com.box.android.data.observability.OpenTelemetryInstrumentation
    public void startSpan(String performanceType, String identifier, Long startTimestamp) {
        Intrinsics.checkNotNullParameter(performanceType, "performanceType");
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        if (this.apdexSpanMap.containsKey(identifier)) {
            BoxLogUtils.e("Span already exists for " + identifier);
            return;
        }
        Map<String, Span> map = this.apdexSpanMap;
        SpanBuilder spanBuilder = this.apdexTracer.spanBuilder(performanceType);
        if (startTimestamp != null) {
            spanBuilder.setStartTimestamp(startTimestamp.longValue(), TimeUnit.MILLISECONDS);
        }
        map.put(identifier, spanBuilder.startSpan());
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.data.observability.OpenTelemetryInstrumentation
    public Object addMilestone(String str, String str2, Long l, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Span span = this.apdexSpanMap.get(str2);
            if (span != null) {
                CoroutineContext coroutineContextAsContextElement = ContextExtensionsKt.asContextElement(span);
                OpenTelemetryInstrumentationImpl$addMilestone$2$1 openTelemetryInstrumentationImpl$addMilestone$2$1 = new OpenTelemetryInstrumentationImpl$addMilestone$2$1(l, span, str, null);
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str);
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str2);
                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(l);
                anonymousClass1.L$3 = span;
                anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(span);
                anonymousClass1.I$0 = 0;
                anonymousClass1.label = 1;
                if (BuildersKt.withContext(coroutineContextAsContextElement, openTelemetryInstrumentationImpl$addMilestone$2$1, anonymousClass1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = anonymousClass1.I$0;
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.data.observability.OpenTelemetryInstrumentation
    public Object endSpanAsSuccess(String str, Continuation<? super Unit> continuation) {
        C13641 c13641;
        if (continuation instanceof C13641) {
            c13641 = (C13641) continuation;
            if ((c13641.label & Integer.MIN_VALUE) != 0) {
                c13641.label -= Integer.MIN_VALUE;
            } else {
                c13641 = new C13641(continuation);
            }
        } else {
            c13641 = new C13641(continuation);
        }
        Object obj = c13641.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c13641.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Span span = this.apdexSpanMap.get(str);
            if (span != null) {
                CoroutineContext coroutineContextAsContextElement = ContextExtensionsKt.asContextElement(span);
                OpenTelemetryInstrumentationImpl$endSpanAsSuccess$2$1 openTelemetryInstrumentationImpl$endSpanAsSuccess$2$1 = new OpenTelemetryInstrumentationImpl$endSpanAsSuccess$2$1(span, null);
                c13641.L$0 = str;
                c13641.L$1 = span;
                c13641.L$2 = SpillingKt.nullOutSpilledVariable(span);
                c13641.I$0 = 0;
                c13641.label = 1;
                if (BuildersKt.withContext(coroutineContextAsContextElement, openTelemetryInstrumentationImpl$endSpanAsSuccess$2$1, c13641) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            this.apdexSpanMap.remove(str);
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        int i2 = c13641.I$0;
        str = (String) c13641.L$0;
        ResultKt.throwOnFailure(obj);
        BoxLogUtils.i("ApdexMetric::endSpan: " + str);
        this.apdexSpanMap.remove(str);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.data.observability.OpenTelemetryInstrumentation
    public Object endSpanWithFailure(String str, DomainError domainError, Continuation<? super Unit> continuation) {
        C13651 c13651;
        if (continuation instanceof C13651) {
            c13651 = (C13651) continuation;
            if ((c13651.label & Integer.MIN_VALUE) != 0) {
                c13651.label -= Integer.MIN_VALUE;
            } else {
                c13651 = new C13651(continuation);
            }
        } else {
            c13651 = new C13651(continuation);
        }
        Object obj = c13651.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c13651.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Span span = this.apdexSpanMap.get(str);
            if (span != null) {
                CoroutineContext coroutineContextAsContextElement = ContextExtensionsKt.asContextElement(span);
                OpenTelemetryInstrumentationImpl$endSpanWithFailure$2$1 openTelemetryInstrumentationImpl$endSpanWithFailure$2$1 = new OpenTelemetryInstrumentationImpl$endSpanWithFailure$2$1(span, domainError, null);
                c13651.L$0 = str;
                c13651.L$1 = SpillingKt.nullOutSpilledVariable(domainError);
                c13651.L$2 = span;
                c13651.L$3 = SpillingKt.nullOutSpilledVariable(span);
                c13651.I$0 = 0;
                c13651.label = 1;
                if (BuildersKt.withContext(coroutineContextAsContextElement, openTelemetryInstrumentationImpl$endSpanWithFailure$2$1, c13651) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            this.apdexSpanMap.remove(str);
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        int i2 = c13651.I$0;
        str = (String) c13651.L$0;
        ResultKt.throwOnFailure(obj);
        BoxLogUtils.i("ApdexMetric::endSpanWithFailure: " + str);
        this.apdexSpanMap.remove(str);
        return Unit.INSTANCE;
    }
}
