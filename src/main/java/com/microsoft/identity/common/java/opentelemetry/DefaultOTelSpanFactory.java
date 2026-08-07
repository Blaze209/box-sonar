package com.microsoft.identity.common.java.opentelemetry;

import com.microsoft.identity.common.internal.broker.ipc.WebAppsAdditionalRequiredParameters;
import com.microsoft.identity.common.java.logging.Logger;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.context.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DefaultOTelSpanFactory.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001a\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\"\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\f"}, d2 = {"Lcom/microsoft/identity/common/java/opentelemetry/DefaultOTelSpanFactory;", "Lcom/microsoft/identity/common/java/opentelemetry/IOTelSpanFactory;", "()V", "createSpan", "Lio/opentelemetry/api/trace/Span;", "name", "", WebAppsAdditionalRequiredParameters.FIELD_CALLING_PACKAGE_NAME, "createSpanFromParent", "parentSpanContext", "Lio/opentelemetry/api/trace/SpanContext;", "Companion", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DefaultOTelSpanFactory implements IOTelSpanFactory {
    private static final String TAG = "DefaultOTelSpanFactory";

    @Override // com.microsoft.identity.common.java.opentelemetry.IOTelSpanFactory
    public Span createSpan(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Tracer tracer = OpenTelemetryHolder.getTracer(TAG);
        Intrinsics.checkNotNullExpressionValue(tracer, "getTracer(TAG)");
        Span spanStartSpan = tracer.spanBuilder(name).startSpan();
        Intrinsics.checkNotNullExpressionValue(spanStartSpan, "tracer.spanBuilder(name).startSpan()");
        return spanStartSpan;
    }

    @Override // com.microsoft.identity.common.java.opentelemetry.IOTelSpanFactory
    public Span createSpan(String name, String callingPackageName) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(callingPackageName, "callingPackageName");
        Tracer tracer = OpenTelemetryHolder.getTracer(TAG);
        Intrinsics.checkNotNullExpressionValue(tracer, "getTracer(TAG)");
        Span spanStartSpan = tracer.spanBuilder(name).setAttribute(AttributeName.calling_package_name.name(), callingPackageName).startSpan();
        Intrinsics.checkNotNullExpressionValue(spanStartSpan, "tracer.spanBuilder(name)…\n            .startSpan()");
        return spanStartSpan;
    }

    @Override // com.microsoft.identity.common.java.opentelemetry.IOTelSpanFactory
    public Span createSpanFromParent(String name, SpanContext parentSpanContext) {
        Intrinsics.checkNotNullParameter(name, "name");
        StringBuilder sb = new StringBuilder();
        String str = TAG;
        String string = sb.append(str).append(":createSpanFromParent").toString();
        if (parentSpanContext == null) {
            Logger.verbose(string, "parentSpanContext is NULL. Creating span without parent.");
            return createSpan(name);
        }
        if (!parentSpanContext.isValid()) {
            Logger.warn(string, "parentSpanContext is INVALID. Creating span without parent.");
            return createSpan(name);
        }
        Tracer tracer = OpenTelemetryHolder.getTracer(str);
        Intrinsics.checkNotNullExpressionValue(tracer, "getTracer(TAG)");
        Span spanStartSpan = tracer.spanBuilder(name).setParent(Context.current().with(Span.wrap(parentSpanContext))).startSpan();
        Intrinsics.checkNotNullExpressionValue(spanStartSpan, "tracer.spanBuilder(name)…\n            .startSpan()");
        return spanStartSpan;
    }

    @Override // com.microsoft.identity.common.java.opentelemetry.IOTelSpanFactory
    public Span createSpanFromParent(String name, SpanContext parentSpanContext, String callingPackageName) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(callingPackageName, "callingPackageName");
        StringBuilder sb = new StringBuilder();
        String str = TAG;
        String string = sb.append(str).append(":createSpanFromParent").toString();
        if (parentSpanContext == null) {
            Logger.verbose(string, "parentSpanContext is NULL. Creating span without parent.");
            return createSpan(name, callingPackageName);
        }
        if (!parentSpanContext.isValid()) {
            Logger.warn(string, "parentSpanContext is INVALID. Creating span without parent.");
            return createSpan(name, callingPackageName);
        }
        Tracer tracer = OpenTelemetryHolder.getTracer(str);
        Intrinsics.checkNotNullExpressionValue(tracer, "getTracer(TAG)");
        Span spanStartSpan = tracer.spanBuilder(name).setParent(Context.current().with(Span.wrap(parentSpanContext))).setAttribute(AttributeName.calling_package_name.name(), callingPackageName).startSpan();
        Intrinsics.checkNotNullExpressionValue(spanStartSpan, "tracer.spanBuilder(name)…\n            .startSpan()");
        return spanStartSpan;
    }
}
