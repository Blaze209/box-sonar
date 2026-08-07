package io.opentelemetry.exporter.zipkin;

import com.microsoft.identity.common.nativeauth.internal.commands.ResetPasswordSubmitNewPasswordCommand;
import io.opentelemetry.api.internal.Utils;
import io.opentelemetry.api.metrics.MeterProvider;
import io.opentelemetry.exporter.internal.grpc.GrpcExporterBuilder$$ExternalSyntheticLambda3;
import io.split.android.client.service.ServiceConstants;
import java.net.InetAddress;
import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import javax.annotation.Nullable;
import zipkin2.Span;
import zipkin2.codec.BytesEncoder;
import zipkin2.codec.SpanBytesEncoder;
import zipkin2.reporter.Sender;
import zipkin2.reporter.okhttp3.OkHttpSender;

/* JADX INFO: loaded from: classes4.dex */
public final class ZipkinSpanExporterBuilder {

    @Nullable
    private Sender sender;
    private BytesEncoder<Span> encoder = SpanBytesEncoder.JSON_V2;
    private Supplier<InetAddress> localIpAddressSupplier = LocalInetAddressSupplier.getInstance();
    private String endpoint = ZipkinSpanExporter.DEFAULT_ENDPOINT;
    private boolean compressionEnabled = true;
    private long readTimeoutMillis = TimeUnit.SECONDS.toMillis(10);
    private Supplier<MeterProvider> meterProviderSupplier = new GrpcExporterBuilder$$ExternalSyntheticLambda3();

    static /* synthetic */ MeterProvider lambda$setMeterProvider$0(MeterProvider meterProvider) {
        return meterProvider;
    }

    public ZipkinSpanExporterBuilder setSender(Sender sender) {
        Objects.requireNonNull(sender, "sender");
        this.sender = sender;
        return this;
    }

    public ZipkinSpanExporterBuilder setEncoder(BytesEncoder<Span> bytesEncoder) {
        Objects.requireNonNull(bytesEncoder, "encoder");
        this.encoder = bytesEncoder;
        return this;
    }

    public ZipkinSpanExporterBuilder setLocalIpAddressSupplier(Supplier<InetAddress> supplier) {
        Objects.requireNonNull(supplier, "encoder");
        this.localIpAddressSupplier = supplier;
        return this;
    }

    public ZipkinSpanExporterBuilder setEndpoint(String str) {
        Objects.requireNonNull(str, ServiceConstants.WORKER_PARAM_ENDPOINT);
        this.endpoint = str;
        return this;
    }

    public ZipkinSpanExporterBuilder setCompression(String str) {
        Objects.requireNonNull(str, "compressionMethod");
        Utils.checkArgument(str.equals("gzip") || str.equals("none"), "Unsupported compression method. Supported compression methods include: gzip, none.");
        this.compressionEnabled = str.equals("gzip");
        return this;
    }

    public ZipkinSpanExporterBuilder setReadTimeout(long j, TimeUnit timeUnit) {
        Objects.requireNonNull(timeUnit, "unit");
        Utils.checkArgument(j >= 0, "timeout must be non-negative");
        this.readTimeoutMillis = timeUnit.toMillis(j);
        return this;
    }

    public ZipkinSpanExporterBuilder setReadTimeout(Duration duration) {
        Objects.requireNonNull(duration, ResetPasswordSubmitNewPasswordCommand.POLL_COMPLETION_TIMEOUT_ERROR_CODE);
        setReadTimeout(duration.toMillis(), TimeUnit.MILLISECONDS);
        return this;
    }

    public ZipkinSpanExporterBuilder setMeterProvider(final MeterProvider meterProvider) {
        Objects.requireNonNull(meterProvider, "meterProvider");
        this.meterProviderSupplier = new Supplier() { // from class: io.opentelemetry.exporter.zipkin.ZipkinSpanExporterBuilder$$ExternalSyntheticLambda0
            @Override // java.util.function.Supplier
            public final Object get() {
                return ZipkinSpanExporterBuilder.lambda$setMeterProvider$0(meterProvider);
            }
        };
        return this;
    }

    public ZipkinSpanExporter build() {
        Sender senderBuild = this.sender;
        if (senderBuild == null) {
            senderBuild = OkHttpSender.newBuilder().endpoint(this.endpoint).compressionEnabled(this.compressionEnabled).readTimeout((int) this.readTimeoutMillis).build();
        }
        return new ZipkinSpanExporter(this.encoder, senderBuild, this.meterProviderSupplier, OtelToZipkinSpanTransformer.create(this.localIpAddressSupplier));
    }
}
