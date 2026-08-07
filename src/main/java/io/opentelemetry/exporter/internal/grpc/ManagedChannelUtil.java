package io.opentelemetry.exporter.internal.grpc;

import androidx.core.app.NotificationCompat;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.NettyChannelBuilder;
import io.grpc.okhttp.OkHttpChannelBuilder;
import io.opentelemetry.exporter.internal.TlsUtil;
import io.opentelemetry.exporter.internal.retry.RetryPolicy;
import io.opentelemetry.exporter.internal.retry.RetryUtil;
import io.opentelemetry.sdk.common.CompletableResultCode;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import javax.net.ssl.SSLException;
import javax.net.ssl.X509KeyManager;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes4.dex */
public final class ManagedChannelUtil {
    private static final Logger logger = Logger.getLogger(ManagedChannelUtil.class.getName());

    public static void setClientKeysAndTrustedCertificatesPem(ManagedChannelBuilder<?> managedChannelBuilder, @Nullable byte[] bArr, @Nullable byte[] bArr2, byte[] bArr3) throws SSLException {
        Objects.requireNonNull(managedChannelBuilder, "managedChannelBuilder");
        Objects.requireNonNull(bArr3, "trustedCertificatesPem");
        X509TrustManager x509TrustManagerTrustManager = TlsUtil.trustManager(bArr3);
        X509KeyManager x509KeyManagerKeyManager = (bArr == null || bArr2 == null) ? null : TlsUtil.keyManager(bArr, bArr2);
        if (managedChannelBuilder.getClass().getName().equals("io.grpc.netty.NettyChannelBuilder")) {
            ((NettyChannelBuilder) managedChannelBuilder).sslContext(GrpcSslContexts.forClient().keyManager(x509KeyManagerKeyManager).trustManager(x509TrustManagerTrustManager).build());
        } else if (managedChannelBuilder.getClass().getName().equals("io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder")) {
            ((io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder) managedChannelBuilder).sslContext(io.grpc.netty.shaded.io.grpc.netty.GrpcSslContexts.forClient().trustManager(x509TrustManagerTrustManager).keyManager(x509KeyManagerKeyManager).build());
        } else {
            if (managedChannelBuilder.getClass().getName().equals("io.grpc.okhttp.OkHttpChannelBuilder")) {
                ((OkHttpChannelBuilder) managedChannelBuilder).sslSocketFactory(TlsUtil.sslSocketFactory(x509KeyManagerKeyManager, x509TrustManagerTrustManager));
                return;
            }
            throw new SSLException("TLS certificate configuration not supported for unrecognized ManagedChannelBuilder " + managedChannelBuilder.getClass().getName());
        }
    }

    public static Map<String, ?> toServiceConfig(String str, RetryPolicy retryPolicy) {
        List list = (List) RetryUtil.retryableGrpcStatusCodes().stream().map(new Function() { // from class: io.opentelemetry.exporter.internal.grpc.ManagedChannelUtil$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Double.valueOf(Double.parseDouble((String) obj));
            }
        }).collect(Collectors.toList());
        HashMap map = new HashMap();
        map.put("retryableStatusCodes", list);
        map.put("maxAttempts", Double.valueOf(retryPolicy.getMaxAttempts()));
        map.put("initialBackoff", (retryPolicy.getInitialBackoff().toMillis() / 1000.0d) + "s");
        map.put("maxBackoff", (retryPolicy.getMaxBackoff().toMillis() / 1000.0d) + "s");
        map.put("backoffMultiplier", Double.valueOf(retryPolicy.getBackoffMultiplier()));
        HashMap map2 = new HashMap();
        map2.put("name", Collections.singletonList(Collections.singletonMap(NotificationCompat.CATEGORY_SERVICE, str)));
        map2.put("retryPolicy", map);
        return Collections.singletonMap("methodConfig", Collections.singletonList(map2));
    }

    public static CompletableResultCode shutdownChannel(final ManagedChannel managedChannel) {
        final CompletableResultCode completableResultCode = new CompletableResultCode();
        managedChannel.shutdown();
        Thread thread = new Thread(new Runnable() { // from class: io.opentelemetry.exporter.internal.grpc.ManagedChannelUtil$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ManagedChannelUtil.lambda$shutdownChannel$0(managedChannel, completableResultCode);
            }
        });
        thread.setDaemon(true);
        thread.setName("grpc-cleanup");
        thread.start();
        return completableResultCode;
    }

    static /* synthetic */ void lambda$shutdownChannel$0(ManagedChannel managedChannel, CompletableResultCode completableResultCode) {
        try {
            managedChannel.awaitTermination(10L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.log(Level.WARNING, "Failed to shutdown the gRPC channel", (Throwable) e);
            completableResultCode.fail();
        }
        completableResultCode.succeed();
    }

    private ManagedChannelUtil() {
    }
}
