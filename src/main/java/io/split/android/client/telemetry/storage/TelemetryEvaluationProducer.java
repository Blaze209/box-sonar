package io.split.android.client.telemetry.storage;

import io.split.android.client.telemetry.model.Method;

/* JADX INFO: loaded from: classes4.dex */
public interface TelemetryEvaluationProducer {
    void recordException(Method method);

    void recordLatency(Method method, long latency);
}
