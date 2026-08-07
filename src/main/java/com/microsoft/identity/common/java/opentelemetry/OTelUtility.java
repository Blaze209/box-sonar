package com.microsoft.identity.common.java.opentelemetry;

import com.microsoft.identity.common.internal.broker.ipc.WebAppsAdditionalRequiredParameters;
import io.opentelemetry.api.metrics.LongCounter;
import io.opentelemetry.api.metrics.Meter;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanContext;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OTelUtility.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u0004H\u0007J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0007J\u001a\u0010\u000f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007J\"\u0010\u000f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000e\u001a\u00020\u0004H\u0007J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0007H\u0007R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/microsoft/identity/common/java/opentelemetry/OTelUtility;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "spanFactory", "Lcom/microsoft/identity/common/java/opentelemetry/IOTelSpanFactory;", "createLongCounter", "Lio/opentelemetry/api/metrics/LongCounter;", "name", "description", "createSpan", "Lio/opentelemetry/api/trace/Span;", WebAppsAdditionalRequiredParameters.FIELD_CALLING_PACKAGE_NAME, "createSpanFromParent", "parentSpanContext", "Lio/opentelemetry/api/trace/SpanContext;", "recordElapsedTime", "", "attributeName", "startTimeMillis", "", "setSpanFactory", "factory", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class OTelUtility {
    public static final OTelUtility INSTANCE = new OTelUtility();
    private static final String TAG = "OTelUtility";
    private static volatile IOTelSpanFactory spanFactory = new DefaultOTelSpanFactory();

    private OTelUtility() {
    }

    @JvmStatic
    public static final void setSpanFactory(IOTelSpanFactory factory) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        spanFactory = factory;
    }

    @JvmStatic
    public static final Span createSpan(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return spanFactory.createSpan(name);
    }

    @JvmStatic
    public static final Span createSpan(String name, String callingPackageName) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(callingPackageName, "callingPackageName");
        return spanFactory.createSpan(name, callingPackageName);
    }

    @JvmStatic
    public static final Span createSpanFromParent(String name, SpanContext parentSpanContext) {
        Intrinsics.checkNotNullParameter(name, "name");
        return spanFactory.createSpanFromParent(name, parentSpanContext);
    }

    @JvmStatic
    public static final Span createSpanFromParent(String name, SpanContext parentSpanContext, String callingPackageName) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(callingPackageName, "callingPackageName");
        return spanFactory.createSpanFromParent(name, parentSpanContext, callingPackageName);
    }

    @JvmStatic
    public static final LongCounter createLongCounter(String name, String description) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        Meter meter = OpenTelemetryHolder.getMeter(TAG);
        Intrinsics.checkNotNullExpressionValue(meter, "getMeter(TAG)");
        LongCounter longCounterBuild = meter.counterBuilder(name).setDescription(description).setUnit("count").build();
        Intrinsics.checkNotNullExpressionValue(longCounterBuild, "meter\n            .count…nt\")\n            .build()");
        return longCounterBuild;
    }

    @JvmStatic
    public static final void recordElapsedTime(String attributeName, long startTimeMillis) {
        Intrinsics.checkNotNullParameter(attributeName, "attributeName");
        SpanExtension.current().setAttribute(attributeName, System.currentTimeMillis() - startTimeMillis);
    }
}
