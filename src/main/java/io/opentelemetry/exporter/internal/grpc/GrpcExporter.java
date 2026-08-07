package io.opentelemetry.exporter.internal.grpc;

import io.grpc.Channel;
import io.opentelemetry.exporter.internal.marshal.Marshaler;
import io.opentelemetry.sdk.common.CompletableResultCode;
import java.net.URI;
import java.util.function.BiFunction;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes4.dex */
public interface GrpcExporter<T extends Marshaler> {
    CompletableResultCode export(T t, int i);

    CompletableResultCode shutdown();

    static <T extends Marshaler> GrpcExporterBuilder<T> builder(String str, String str2, long j, URI uri, Supplier<BiFunction<Channel, String, MarshalerServiceStub<T, ?, ?>>> supplier, String str3) {
        return new GrpcExporterBuilder<>(str, str2, j, uri, supplier, str3);
    }
}
