package com.microsoft.identity.common.java.opentelemetry;

import com.microsoft.identity.common.internal.broker.ipc.WebAppsAdditionalRequiredParameters;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanContext;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OTelBenchmarkSpanFactory.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004H\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\u001a\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\"\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/microsoft/identity/common/java/opentelemetry/OTelBenchmarkSpanFactory;", "Lcom/microsoft/identity/common/java/opentelemetry/IOTelSpanFactory;", "benchmarkSpanNames", "", "", "spanPrinter", "Lcom/microsoft/identity/common/java/opentelemetry/IBenchmarkSpanPrinter;", "(Ljava/util/Set;Lcom/microsoft/identity/common/java/opentelemetry/IBenchmarkSpanPrinter;)V", "getBenchmarkSpanNames", "()Ljava/util/Set;", "defaultFactory", "Lcom/microsoft/identity/common/java/opentelemetry/DefaultOTelSpanFactory;", "createSpan", "Lio/opentelemetry/api/trace/Span;", "name", WebAppsAdditionalRequiredParameters.FIELD_CALLING_PACKAGE_NAME, "createSpanFromParent", "parentSpanContext", "Lio/opentelemetry/api/trace/SpanContext;", "isBenchmarkSpan", "", "spanName", "Companion", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class OTelBenchmarkSpanFactory implements IOTelSpanFactory {
    private static final String TAG = "OTelBenchmarkSpanFactory";
    private final Set<String> benchmarkSpanNames;
    private final DefaultOTelSpanFactory defaultFactory;
    private final IBenchmarkSpanPrinter spanPrinter;

    public OTelBenchmarkSpanFactory(Set<String> benchmarkSpanNames, IBenchmarkSpanPrinter spanPrinter) {
        Intrinsics.checkNotNullParameter(benchmarkSpanNames, "benchmarkSpanNames");
        Intrinsics.checkNotNullParameter(spanPrinter, "spanPrinter");
        this.benchmarkSpanNames = benchmarkSpanNames;
        this.spanPrinter = spanPrinter;
        this.defaultFactory = new DefaultOTelSpanFactory();
    }

    public final Set<String> getBenchmarkSpanNames() {
        return this.benchmarkSpanNames;
    }

    public final boolean isBenchmarkSpan(String spanName) {
        Intrinsics.checkNotNullParameter(spanName, "spanName");
        return this.benchmarkSpanNames.contains(spanName);
    }

    @Override // com.microsoft.identity.common.java.opentelemetry.IOTelSpanFactory
    public Span createSpan(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Span spanCreateSpan = this.defaultFactory.createSpan(name);
        if (!isBenchmarkSpan(name)) {
            return spanCreateSpan;
        }
        BenchmarkSpan benchmarkSpan = new BenchmarkSpan(spanCreateSpan, this.spanPrinter, name);
        benchmarkSpan.start();
        return benchmarkSpan;
    }

    @Override // com.microsoft.identity.common.java.opentelemetry.IOTelSpanFactory
    public Span createSpan(String name, String callingPackageName) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(callingPackageName, "callingPackageName");
        Span spanCreateSpan = this.defaultFactory.createSpan(name, callingPackageName);
        if (!isBenchmarkSpan(name)) {
            return spanCreateSpan;
        }
        BenchmarkSpan benchmarkSpan = new BenchmarkSpan(spanCreateSpan, this.spanPrinter, name);
        benchmarkSpan.start();
        return benchmarkSpan;
    }

    @Override // com.microsoft.identity.common.java.opentelemetry.IOTelSpanFactory
    public Span createSpanFromParent(String name, SpanContext parentSpanContext) {
        Intrinsics.checkNotNullParameter(name, "name");
        Span spanCreateSpanFromParent = this.defaultFactory.createSpanFromParent(name, parentSpanContext);
        if (!isBenchmarkSpan(name)) {
            return spanCreateSpanFromParent;
        }
        BenchmarkSpan benchmarkSpan = new BenchmarkSpan(spanCreateSpanFromParent, this.spanPrinter, name);
        benchmarkSpan.start();
        return benchmarkSpan;
    }

    @Override // com.microsoft.identity.common.java.opentelemetry.IOTelSpanFactory
    public Span createSpanFromParent(String name, SpanContext parentSpanContext, String callingPackageName) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(callingPackageName, "callingPackageName");
        Span spanCreateSpanFromParent = this.defaultFactory.createSpanFromParent(name, parentSpanContext, callingPackageName);
        if (!isBenchmarkSpan(name)) {
            return spanCreateSpanFromParent;
        }
        BenchmarkSpan benchmarkSpan = new BenchmarkSpan(spanCreateSpanFromParent, this.spanPrinter, name);
        benchmarkSpan.start();
        return benchmarkSpan;
    }
}
