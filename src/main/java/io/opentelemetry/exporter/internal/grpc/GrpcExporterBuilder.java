package io.opentelemetry.exporter.internal.grpc;

import io.grpc.Channel;
import io.grpc.ClientInterceptor;
import io.grpc.ClientInterceptors;
import io.grpc.Codec;
import io.grpc.ManagedChannel;
import io.grpc.Metadata;
import io.grpc.stub.MetadataUtils;
import io.opentelemetry.api.metrics.MeterProvider;
import io.opentelemetry.exporter.internal.ExporterBuilderUtil;
import io.opentelemetry.exporter.internal.TlsUtil;
import io.opentelemetry.exporter.internal.marshal.Marshaler;
import io.opentelemetry.exporter.internal.okhttp.OkHttpUtil;
import io.opentelemetry.exporter.internal.retry.RetryInterceptor;
import io.opentelemetry.exporter.internal.retry.RetryPolicy;
import java.net.URI;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import javax.annotation.Nullable;
import javax.net.ssl.SSLException;
import javax.net.ssl.X509TrustManager;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Response;

/* JADX INFO: loaded from: classes4.dex */
public class GrpcExporterBuilder<T extends Marshaler> {

    @Nullable
    private byte[] certificatePem;
    private URI endpoint;
    private final String exporterName;

    @Nullable
    private Object grpcChannel;
    private final String grpcEndpointPath;
    private final Supplier<BiFunction<Channel, String, MarshalerServiceStub<T, ?, ?>>> grpcStubFactory;

    @Nullable
    private byte[] privateKeyPem;

    @Nullable
    private RetryPolicy retryPolicy;
    private long timeoutNanos;

    @Nullable
    private byte[] trustedCertificatesPem;
    private final String type;
    private boolean compressionEnabled = false;
    private final Map<String, String> headers = new HashMap();
    private Supplier<MeterProvider> meterProviderSupplier = new GrpcExporterBuilder$$ExternalSyntheticLambda3();

    static /* synthetic */ MeterProvider lambda$setMeterProvider$0(MeterProvider meterProvider) {
        return meterProvider;
    }

    GrpcExporterBuilder(String str, String str2, long j, URI uri, Supplier<BiFunction<Channel, String, MarshalerServiceStub<T, ?, ?>>> supplier, String str3) {
        this.exporterName = str;
        this.type = str2;
        this.grpcEndpointPath = str3;
        this.timeoutNanos = TimeUnit.SECONDS.toNanos(j);
        this.endpoint = uri;
        this.grpcStubFactory = supplier;
    }

    public GrpcExporterBuilder<T> setChannel(ManagedChannel managedChannel) {
        this.grpcChannel = managedChannel;
        return this;
    }

    public GrpcExporterBuilder<T> setTimeout(long j, TimeUnit timeUnit) {
        this.timeoutNanos = timeUnit.toNanos(j);
        return this;
    }

    public GrpcExporterBuilder<T> setTimeout(Duration duration) {
        return setTimeout(duration.toNanos(), TimeUnit.NANOSECONDS);
    }

    public GrpcExporterBuilder<T> setEndpoint(String str) {
        this.endpoint = ExporterBuilderUtil.validateEndpoint(str);
        return this;
    }

    public GrpcExporterBuilder<T> setCompression(String str) {
        this.compressionEnabled = str.equals("gzip");
        return this;
    }

    public GrpcExporterBuilder<T> setTrustedCertificates(byte[] bArr) {
        this.trustedCertificatesPem = bArr;
        return this;
    }

    public GrpcExporterBuilder<T> setClientTls(byte[] bArr, byte[] bArr2) {
        this.privateKeyPem = bArr;
        this.certificatePem = bArr2;
        return this;
    }

    public GrpcExporterBuilder<T> addHeader(String str, String str2) {
        this.headers.put(str, str2);
        return this;
    }

    public GrpcExporterBuilder<T> setRetryPolicy(RetryPolicy retryPolicy) {
        this.retryPolicy = retryPolicy;
        return this;
    }

    public GrpcExporterBuilder<T> setMeterProvider(final MeterProvider meterProvider) {
        this.meterProviderSupplier = new Supplier() { // from class: io.opentelemetry.exporter.internal.grpc.GrpcExporterBuilder$$ExternalSyntheticLambda2
            @Override // java.util.function.Supplier
            public final Object get() {
                return GrpcExporterBuilder.lambda$setMeterProvider$0(meterProvider);
            }
        };
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [io.opentelemetry.exporter.internal.grpc.GrpcExporterBuilder$1] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v2, types: [javax.net.ssl.KeyManager] */
    public GrpcExporter<T> build() {
        byte[] bArr;
        ?? KeyManager = 0;
        KeyManager = 0;
        if (this.grpcChannel == null) {
            OkHttpClient.Builder builderDispatcher = new OkHttpClient.Builder().dispatcher(OkHttpUtil.newDispatcher());
            builderDispatcher.callTimeout(Duration.ofNanos(this.timeoutNanos));
            byte[] bArr2 = this.trustedCertificatesPem;
            if (bArr2 != null) {
                try {
                    X509TrustManager x509TrustManagerTrustManager = TlsUtil.trustManager(bArr2);
                    byte[] bArr3 = this.privateKeyPem;
                    if (bArr3 != null && (bArr = this.certificatePem) != null) {
                        KeyManager = TlsUtil.keyManager(bArr3, bArr);
                    }
                    builderDispatcher.sslSocketFactory(TlsUtil.sslSocketFactory(KeyManager, x509TrustManagerTrustManager), x509TrustManagerTrustManager);
                } catch (SSLException e) {
                    throw new IllegalStateException("Could not set trusted certificates, are they valid X.509 in PEM format?", e);
                }
            }
            String string = this.endpoint.resolve(this.grpcEndpointPath).toString();
            if (string.startsWith("http://")) {
                builderDispatcher.protocols(Collections.singletonList(Protocol.H2_PRIOR_KNOWLEDGE));
            } else {
                builderDispatcher.protocols(Arrays.asList(Protocol.HTTP_2, Protocol.HTTP_1_1));
            }
            final Headers.Builder builder = new Headers.Builder();
            Map<String, String> map = this.headers;
            Objects.requireNonNull(builder);
            map.forEach(new BiConsumer() { // from class: io.opentelemetry.exporter.internal.grpc.GrpcExporterBuilder$$ExternalSyntheticLambda0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    builder.add((String) obj, (String) obj2);
                }
            });
            builder.add("te", "trailers");
            if (this.compressionEnabled) {
                builder.add("grpc-encoding", "gzip");
            }
            if (this.retryPolicy != null) {
                builderDispatcher.addInterceptor(new RetryInterceptor(this.retryPolicy, new Function() { // from class: io.opentelemetry.exporter.internal.grpc.GrpcExporterBuilder$$ExternalSyntheticLambda1
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return Boolean.valueOf(OkHttpGrpcExporter.isRetryable((Response) obj));
                    }
                }));
            }
            return new OkHttpGrpcExporter(this.exporterName, this.type, builderDispatcher.build(), this.meterProviderSupplier, string, builder.build(), this.compressionEnabled);
        }
        return new UpstreamGrpcExporterFactory().buildWithChannel((Channel) this.grpcChannel);
    }

    private class UpstreamGrpcExporterFactory {
        private UpstreamGrpcExporterFactory() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public GrpcExporter<T> buildWithChannel(Channel channel) {
            Metadata metadata = new Metadata();
            String str = null;
            for (Map.Entry entry : GrpcExporterBuilder.this.headers.entrySet()) {
                String str2 = (String) entry.getKey();
                String str3 = (String) entry.getValue();
                if (str2.equals("host")) {
                    str = str3;
                } else {
                    metadata.put(Metadata.Key.of(str2, Metadata.ASCII_STRING_MARSHALLER), str3);
                }
            }
            return new UpstreamGrpcExporter(GrpcExporterBuilder.this.exporterName, GrpcExporterBuilder.this.type, ((MarshalerServiceStub) ((BiFunction) GrpcExporterBuilder.this.grpcStubFactory.get()).apply(ClientInterceptors.intercept(channel, new ClientInterceptor[]{MetadataUtils.newAttachHeadersInterceptor(metadata)}), str)).withCompression((GrpcExporterBuilder.this.compressionEnabled ? new Codec.Gzip() : Codec.Identity.NONE).getMessageEncoding()), GrpcExporterBuilder.this.meterProviderSupplier, GrpcExporterBuilder.this.timeoutNanos);
        }
    }
}
