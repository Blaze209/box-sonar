package io.opentelemetry.instrumentation.api.instrumenter;

import io.opentelemetry.api.metrics.Meter;

/* JADX INFO: loaded from: classes4.dex */
@FunctionalInterface
public interface OperationMetrics {
    OperationListener create(Meter meter);
}
