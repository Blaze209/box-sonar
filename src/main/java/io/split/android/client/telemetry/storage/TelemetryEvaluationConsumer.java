package io.split.android.client.telemetry.storage;

import io.split.android.client.telemetry.model.MethodExceptions;
import io.split.android.client.telemetry.model.MethodLatencies;

/* JADX INFO: loaded from: classes4.dex */
public interface TelemetryEvaluationConsumer {
    MethodExceptions popExceptions();

    MethodLatencies popLatencies();
}
