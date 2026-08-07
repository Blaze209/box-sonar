package io.opentelemetry.exporter.internal.grpc;

import io.opentelemetry.api.GlobalOpenTelemetry;
import java.util.function.Supplier;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class GrpcExporterBuilder$$ExternalSyntheticLambda3 implements Supplier {
    @Override // java.util.function.Supplier
    public final Object get() {
        return GlobalOpenTelemetry.getMeterProvider();
    }
}
