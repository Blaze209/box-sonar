package io.opentelemetry.exporter.internal.grpc;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.MoreExecutors;
import io.grpc.Status;
import io.opentelemetry.api.metrics.MeterProvider;
import io.opentelemetry.exporter.internal.ExporterMetrics;
import io.opentelemetry.exporter.internal.marshal.Marshaler;
import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.internal.ThrottlingLogger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes4.dex */
public final class UpstreamGrpcExporter<T extends Marshaler> implements GrpcExporter<T> {
    private static final Logger internalLogger = Logger.getLogger(UpstreamGrpcExporter.class.getName());
    private final ExporterMetrics exporterMetrics;
    private final MarshalerServiceStub<T, ?, ?> stub;
    private final long timeoutNanos;
    private final String type;
    private final ThrottlingLogger logger = new ThrottlingLogger(internalLogger);
    private final AtomicBoolean loggedUnimplemented = new AtomicBoolean();

    UpstreamGrpcExporter(String str, String str2, MarshalerServiceStub<T, ?, ?> marshalerServiceStub, Supplier<MeterProvider> supplier, long j) {
        this.type = str2;
        this.exporterMetrics = ExporterMetrics.createGrpc(str, str2, supplier);
        this.timeoutNanos = j;
        this.stub = marshalerServiceStub;
    }

    @Override // io.opentelemetry.exporter.internal.grpc.GrpcExporter
    public CompletableResultCode export(T t, final int i) {
        this.exporterMetrics.addSeen(i);
        final CompletableResultCode completableResultCode = new CompletableResultCode();
        MarshalerServiceStub<T, ?, ?> marshalerServiceStub = this.stub;
        long j = this.timeoutNanos;
        if (j > 0) {
            marshalerServiceStub = (MarshalerServiceStub) marshalerServiceStub.withDeadlineAfter(j, TimeUnit.NANOSECONDS);
        }
        Futures.addCallback(marshalerServiceStub.export(t), new FutureCallback<Object>() { // from class: io.opentelemetry.exporter.internal.grpc.UpstreamGrpcExporter.1
            @Override // com.google.common.util.concurrent.FutureCallback
            public void onSuccess(Object obj) {
                UpstreamGrpcExporter.this.exporterMetrics.addSuccess(i);
                completableResultCode.succeed();
            }

            @Override // com.google.common.util.concurrent.FutureCallback
            public void onFailure(Throwable th) {
                UpstreamGrpcExporter.this.exporterMetrics.addFailed(i);
                Status statusFromThrowable = Status.fromThrowable(th);
                int i2 = AnonymousClass2.$SwitchMap$io$grpc$Status$Code[statusFromThrowable.getCode().ordinal()];
                if (i2 != 1) {
                    if (i2 == 2) {
                        UpstreamGrpcExporter.this.logger.log(Level.SEVERE, "Failed to export " + UpstreamGrpcExporter.this.type + "s. Server is UNAVAILABLE. Make sure your collector is running and reachable from this network. Full error message:" + statusFromThrowable.getDescription());
                    } else {
                        UpstreamGrpcExporter.this.logger.log(Level.WARNING, "Failed to export " + UpstreamGrpcExporter.this.type + "s. Server responded with gRPC status code " + statusFromThrowable.getCode().value() + ". Error message: " + statusFromThrowable.getDescription());
                    }
                } else if (UpstreamGrpcExporter.this.loggedUnimplemented.compareAndSet(false, true)) {
                    GrpcExporterUtil.logUnimplemented(UpstreamGrpcExporter.internalLogger, UpstreamGrpcExporter.this.type, statusFromThrowable.getDescription());
                }
                if (UpstreamGrpcExporter.this.logger.isLoggable(Level.FINEST)) {
                    UpstreamGrpcExporter.this.logger.log(Level.FINEST, "Failed to export " + UpstreamGrpcExporter.this.type + "s. Details follow: " + th);
                }
                completableResultCode.fail();
            }
        }, MoreExecutors.directExecutor());
        return completableResultCode;
    }

    /* JADX INFO: renamed from: io.opentelemetry.exporter.internal.grpc.UpstreamGrpcExporter$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$io$grpc$Status$Code;

        static {
            int[] iArr = new int[Status.Code.values().length];
            $SwitchMap$io$grpc$Status$Code = iArr;
            try {
                iArr[Status.Code.UNIMPLEMENTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$grpc$Status$Code[Status.Code.UNAVAILABLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // io.opentelemetry.exporter.internal.grpc.GrpcExporter
    public CompletableResultCode shutdown() {
        return CompletableResultCode.ofSuccess();
    }
}
