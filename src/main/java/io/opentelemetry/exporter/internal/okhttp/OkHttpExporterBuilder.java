package io.opentelemetry.exporter.internal.okhttp;

import com.splunk.rum.CustomHeadersRequestInterceptor$$ExternalSyntheticLambda0;
import io.opentelemetry.api.metrics.MeterProvider;
import io.opentelemetry.exporter.internal.ExporterBuilderUtil;
import io.opentelemetry.exporter.internal.TlsUtil;
import io.opentelemetry.exporter.internal.auth.Authenticator;
import io.opentelemetry.exporter.internal.grpc.GrpcExporterBuilder$$ExternalSyntheticLambda3;
import io.opentelemetry.exporter.internal.marshal.Marshaler;
import io.opentelemetry.exporter.internal.retry.RetryInterceptor;
import io.opentelemetry.exporter.internal.retry.RetryPolicy;
import java.io.IOException;
import java.time.Duration;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Supplier;
import javax.annotation.Nullable;
import javax.net.ssl.SSLException;
import javax.net.ssl.X509TrustManager;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

/* JADX INFO: loaded from: classes4.dex */
public final class OkHttpExporterBuilder<T extends Marshaler> {
    public static final long DEFAULT_TIMEOUT_SECS = 10;

    @Nullable
    private Authenticator authenticator;

    @Nullable
    private byte[] certificatePem;
    private String endpoint;
    private final String exporterName;

    @Nullable
    private Headers.Builder headersBuilder;

    @Nullable
    private byte[] privateKeyPem;

    @Nullable
    private RetryPolicy retryPolicy;

    @Nullable
    private byte[] trustedCertificatesPem;
    private final String type;
    private long timeoutNanos = TimeUnit.SECONDS.toNanos(10);
    private boolean compressionEnabled = false;
    private boolean exportAsJson = false;
    private Supplier<MeterProvider> meterProviderSupplier = new GrpcExporterBuilder$$ExternalSyntheticLambda3();

    static /* synthetic */ MeterProvider lambda$setMeterProvider$0(MeterProvider meterProvider) {
        return meterProvider;
    }

    public OkHttpExporterBuilder(String str, String str2, String str3) {
        this.exporterName = str;
        this.type = str2;
        this.endpoint = str3;
    }

    public OkHttpExporterBuilder<T> setTimeout(long j, TimeUnit timeUnit) {
        this.timeoutNanos = timeUnit.toNanos(j);
        return this;
    }

    public OkHttpExporterBuilder<T> setTimeout(Duration duration) {
        return setTimeout(duration.toNanos(), TimeUnit.NANOSECONDS);
    }

    public OkHttpExporterBuilder<T> setEndpoint(String str) {
        this.endpoint = ExporterBuilderUtil.validateEndpoint(str).toString();
        return this;
    }

    public OkHttpExporterBuilder<T> setCompression(String str) {
        this.compressionEnabled = str.equals("gzip");
        return this;
    }

    public OkHttpExporterBuilder<T> addHeader(String str, String str2) {
        if (this.headersBuilder == null) {
            this.headersBuilder = new Headers.Builder();
        }
        this.headersBuilder.add(str, str2);
        return this;
    }

    public OkHttpExporterBuilder<T> setAuthenticator(Authenticator authenticator) {
        this.authenticator = authenticator;
        return this;
    }

    public OkHttpExporterBuilder<T> setTrustedCertificates(byte[] bArr) {
        this.trustedCertificatesPem = bArr;
        return this;
    }

    public OkHttpExporterBuilder<T> setClientTls(byte[] bArr, byte[] bArr2) {
        this.privateKeyPem = bArr;
        this.certificatePem = bArr2;
        return this;
    }

    public OkHttpExporterBuilder<T> setMeterProvider(final MeterProvider meterProvider) {
        this.meterProviderSupplier = new Supplier() { // from class: io.opentelemetry.exporter.internal.okhttp.OkHttpExporterBuilder$$ExternalSyntheticLambda2
            @Override // java.util.function.Supplier
            public final Object get() {
                return OkHttpExporterBuilder.lambda$setMeterProvider$0(meterProvider);
            }
        };
        return this;
    }

    public OkHttpExporterBuilder<T> setRetryPolicy(RetryPolicy retryPolicy) {
        this.retryPolicy = retryPolicy;
        return this;
    }

    public OkHttpExporterBuilder<T> exportAsJson() {
        this.exportAsJson = true;
        return this;
    }

    public OkHttpExporter<T> build() {
        byte[] bArr;
        OkHttpClient.Builder builderCallTimeout = new OkHttpClient.Builder().dispatcher(OkHttpUtil.newDispatcher()).callTimeout(Duration.ofNanos(this.timeoutNanos));
        byte[] bArr2 = this.trustedCertificatesPem;
        if (bArr2 != null) {
            try {
                X509TrustManager x509TrustManagerTrustManager = TlsUtil.trustManager(bArr2);
                byte[] bArr3 = this.privateKeyPem;
                builderCallTimeout.sslSocketFactory(TlsUtil.sslSocketFactory((bArr3 == null || (bArr = this.certificatePem) == null) ? null : TlsUtil.keyManager(bArr3, bArr), x509TrustManagerTrustManager), x509TrustManagerTrustManager);
            } catch (SSLException e) {
                throw new IllegalStateException("Could not set trusted certificate for OTLP HTTP connection, are they valid X.509 in PEM format?", e);
            }
        }
        Headers.Builder builder = this.headersBuilder;
        Headers headersBuild = builder != null ? builder.build() : null;
        if (this.retryPolicy != null) {
            builderCallTimeout.addInterceptor(new RetryInterceptor(this.retryPolicy, new Function() { // from class: io.opentelemetry.exporter.internal.okhttp.OkHttpExporterBuilder$$ExternalSyntheticLambda0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return Boolean.valueOf(OkHttpExporter.isRetryable((Response) obj));
                }
            }));
        }
        final Authenticator authenticator = this.authenticator;
        if (authenticator != null) {
            builderCallTimeout.authenticator(new okhttp3.Authenticator() { // from class: io.opentelemetry.exporter.internal.okhttp.OkHttpExporterBuilder$$ExternalSyntheticLambda1
                @Override // okhttp3.Authenticator
                public final Request authenticate(Route route, Response response) {
                    return OkHttpExporterBuilder.lambda$build$1(authenticator, route, response);
                }
            });
        }
        return new OkHttpExporter<>(this.exporterName, this.type, builderCallTimeout.build(), this.meterProviderSupplier, this.endpoint, headersBuild, this.compressionEnabled, this.exportAsJson);
    }

    static /* synthetic */ Request lambda$build$1(Authenticator authenticator, Route route, Response response) throws IOException {
        Request.Builder builderNewBuilder = response.request().newBuilder();
        Map<String, String> headers = authenticator.getHeaders();
        Objects.requireNonNull(builderNewBuilder);
        headers.forEach(new CustomHeadersRequestInterceptor$$ExternalSyntheticLambda0(builderNewBuilder));
        return builderNewBuilder.build();
    }
}
