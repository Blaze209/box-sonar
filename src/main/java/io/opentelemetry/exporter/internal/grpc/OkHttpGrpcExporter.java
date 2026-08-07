package io.opentelemetry.exporter.internal.grpc;

import io.opentelemetry.api.metrics.MeterProvider;
import io.opentelemetry.exporter.internal.ExporterMetrics;
import io.opentelemetry.exporter.internal.marshal.Marshaler;
import io.opentelemetry.exporter.internal.retry.RetryUtil;
import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.internal.ThrottlingLogger;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes4.dex */
public final class OkHttpGrpcExporter<T extends Marshaler> implements GrpcExporter<T> {
    private static final String GRPC_MESSAGE = "grpc-message";
    private static final String GRPC_STATUS = "grpc-status";
    private static final Logger internalLogger = Logger.getLogger(OkHttpGrpcExporter.class.getName());
    private final OkHttpClient client;
    private final boolean compressionEnabled;
    private final ExporterMetrics exporterMetrics;
    private final Headers headers;
    private final String type;
    private final HttpUrl url;
    private final ThrottlingLogger logger = new ThrottlingLogger(internalLogger);
    private final AtomicBoolean loggedUnimplemented = new AtomicBoolean();

    OkHttpGrpcExporter(String str, String str2, OkHttpClient okHttpClient, Supplier<MeterProvider> supplier, String str3, Headers headers, boolean z) {
        this.type = str2;
        this.exporterMetrics = ExporterMetrics.createGrpcOkHttp(str, str2, supplier);
        this.client = okHttpClient;
        this.url = HttpUrl.get(str3);
        this.headers = headers;
        this.compressionEnabled = z;
    }

    @Override // io.opentelemetry.exporter.internal.grpc.GrpcExporter
    public CompletableResultCode export(T t, final int i) {
        this.exporterMetrics.addSeen(i);
        Request.Builder builderHeaders = new Request.Builder().url(this.url).headers(this.headers);
        builderHeaders.post(new GrpcRequestBody(t, this.compressionEnabled));
        final CompletableResultCode completableResultCode = new CompletableResultCode();
        this.client.newCall(builderHeaders.build()).enqueue(new Callback() { // from class: io.opentelemetry.exporter.internal.grpc.OkHttpGrpcExporter.1
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                OkHttpGrpcExporter.this.exporterMetrics.addFailed(i);
                OkHttpGrpcExporter.this.logger.log(Level.SEVERE, "Failed to export " + OkHttpGrpcExporter.this.type + "s. The request could not be executed. Full error message: " + iOException.getMessage());
                completableResultCode.fail();
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                String str;
                try {
                    response.body().bytes();
                    String strGrpcStatus = OkHttpGrpcExporter.grpcStatus(response);
                    if ("0".equals(strGrpcStatus)) {
                        OkHttpGrpcExporter.this.exporterMetrics.addSuccess(i);
                        completableResultCode.succeed();
                        return;
                    }
                    OkHttpGrpcExporter.this.exporterMetrics.addFailed(i);
                    if (strGrpcStatus != null) {
                        str = "gRPC status code " + strGrpcStatus;
                    } else {
                        str = "HTTP status code " + response.code();
                    }
                    String strGrpcMessage = OkHttpGrpcExporter.grpcMessage(response);
                    if (GrpcStatusUtil.GRPC_STATUS_UNIMPLEMENTED.equals(strGrpcStatus)) {
                        if (OkHttpGrpcExporter.this.loggedUnimplemented.compareAndSet(false, true)) {
                            GrpcExporterUtil.logUnimplemented(OkHttpGrpcExporter.internalLogger, OkHttpGrpcExporter.this.type, strGrpcMessage);
                        }
                    } else if (GrpcStatusUtil.GRPC_STATUS_UNAVAILABLE.equals(strGrpcStatus)) {
                        OkHttpGrpcExporter.this.logger.log(Level.SEVERE, "Failed to export " + OkHttpGrpcExporter.this.type + "s. Server is UNAVAILABLE. Make sure your collector is running and reachable from this network. Full error message:" + strGrpcMessage);
                    } else {
                        OkHttpGrpcExporter.this.logger.log(Level.WARNING, "Failed to export " + OkHttpGrpcExporter.this.type + "s. Server responded with " + str + ". Error message: " + strGrpcMessage);
                    }
                    completableResultCode.fail();
                } catch (IOException e) {
                    OkHttpGrpcExporter.this.logger.log(Level.WARNING, "Failed to export " + OkHttpGrpcExporter.this.type + "s, could not consume server response.", e);
                    OkHttpGrpcExporter.this.exporterMetrics.addFailed(i);
                    completableResultCode.fail();
                }
            }
        });
        return completableResultCode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static String grpcStatus(Response response) {
        String strHeader = response.header(GRPC_STATUS);
        if (strHeader != null) {
            return strHeader;
        }
        try {
            return response.trailers().get(GRPC_STATUS);
        } catch (IOException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String grpcMessage(Response response) {
        String strHeader = response.header(GRPC_MESSAGE);
        if (strHeader == null) {
            try {
                strHeader = response.trailers().get(GRPC_MESSAGE);
            } catch (IOException unused) {
            }
        }
        if (strHeader != null) {
            return unescape(strHeader);
        }
        return response.message();
    }

    @Override // io.opentelemetry.exporter.internal.grpc.GrpcExporter
    public CompletableResultCode shutdown() {
        this.client.dispatcher().cancelAll();
        this.client.dispatcher().executorService().shutdownNow();
        this.client.connectionPool().evictAll();
        return CompletableResultCode.ofSuccess();
    }

    public static boolean isRetryable(Response response) {
        if (!response.isSuccessful()) {
            return false;
        }
        return RetryUtil.retryableGrpcStatusCodes().contains(response.header(GRPC_STATUS));
    }

    private static String unescape(String str) {
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt < ' ' || cCharAt >= '~' || (cCharAt == '%' && i + 2 < str.length())) {
                return doUnescape(str.getBytes(StandardCharsets.US_ASCII));
            }
        }
        return str;
    }

    private static String doUnescape(byte[] bArr) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArr.length);
        int i = 0;
        while (i < bArr.length) {
            if (bArr[i] == 37 && i + 2 < bArr.length) {
                try {
                    byteBufferAllocate.put((byte) Integer.parseInt(new String(bArr, i + 1, 2, StandardCharsets.UTF_8), 16));
                    i += 3;
                } catch (NumberFormatException unused) {
                    byteBufferAllocate.put(bArr[i]);
                    i++;
                }
            }
            byteBufferAllocate.put(bArr[i]);
            i++;
        }
        return new String(byteBufferAllocate.array(), 0, byteBufferAllocate.position(), StandardCharsets.UTF_8);
    }
}
