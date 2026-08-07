package io.opentelemetry.exporter.internal.okhttp;

import io.opentelemetry.api.metrics.MeterProvider;
import io.opentelemetry.exporter.internal.ExporterMetrics;
import io.opentelemetry.exporter.internal.grpc.GrpcStatusUtil;
import io.opentelemetry.exporter.internal.marshal.Marshaler;
import io.opentelemetry.exporter.internal.retry.RetryUtil;
import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.internal.ThrottlingLogger;
import java.io.IOException;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSink;
import okio.GzipSink;
import okio.Okio;

/* JADX INFO: loaded from: classes4.dex */
public final class OkHttpExporter<T extends Marshaler> {
    private static final Logger internalLogger = Logger.getLogger(OkHttpExporter.class.getName());
    private final OkHttpClient client;
    private final boolean compressionEnabled;
    private final ExporterMetrics exporterMetrics;

    @Nullable
    private final Headers headers;
    private final ThrottlingLogger logger = new ThrottlingLogger(internalLogger);
    private final Function<T, RequestBody> requestBodyCreator;
    private final String type;
    private final HttpUrl url;

    OkHttpExporter(String str, String str2, OkHttpClient okHttpClient, Supplier<MeterProvider> supplier, String str3, @Nullable Headers headers, boolean z, boolean z2) {
        ExporterMetrics exporterMetricsCreateHttpProtobuf;
        this.type = str2;
        this.client = okHttpClient;
        this.url = HttpUrl.get(str3);
        this.headers = headers;
        this.compressionEnabled = z;
        this.requestBodyCreator = z2 ? new Function() { // from class: io.opentelemetry.exporter.internal.okhttp.OkHttpExporter$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return new JsonRequestBody((Marshaler) obj);
            }
        } : new Function() { // from class: io.opentelemetry.exporter.internal.okhttp.OkHttpExporter$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return new ProtoRequestBody((Marshaler) obj);
            }
        };
        if (z2) {
            exporterMetricsCreateHttpProtobuf = ExporterMetrics.createHttpJson(str, str2, supplier);
        } else {
            exporterMetricsCreateHttpProtobuf = ExporterMetrics.createHttpProtobuf(str, str2, supplier);
        }
        this.exporterMetrics = exporterMetricsCreateHttpProtobuf;
    }

    public CompletableResultCode export(T t, final int i) {
        this.exporterMetrics.addSeen(i);
        Request.Builder builderUrl = new Request.Builder().url(this.url);
        Headers headers = this.headers;
        if (headers != null) {
            builderUrl.headers(headers);
        }
        RequestBody requestBodyApply = this.requestBodyCreator.apply(t);
        if (this.compressionEnabled) {
            builderUrl.addHeader("Content-Encoding", "gzip");
            builderUrl.post(gzipRequestBody(requestBodyApply));
        } else {
            builderUrl.post(requestBodyApply);
        }
        final CompletableResultCode completableResultCode = new CompletableResultCode();
        this.client.newCall(builderUrl.build()).enqueue(new Callback() { // from class: io.opentelemetry.exporter.internal.okhttp.OkHttpExporter.1
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                OkHttpExporter.this.exporterMetrics.addFailed(i);
                OkHttpExporter.this.logger.log(Level.SEVERE, "Failed to export " + OkHttpExporter.this.type + "s. The request could not be executed. Full error message: " + iOException.getMessage());
                completableResultCode.fail();
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                ResponseBody responseBodyBody = response.body();
                try {
                    if (response.isSuccessful()) {
                        OkHttpExporter.this.exporterMetrics.addSuccess(i);
                        completableResultCode.succeed();
                        if (responseBodyBody != null) {
                            responseBodyBody.close();
                            return;
                        }
                        return;
                    }
                    OkHttpExporter.this.exporterMetrics.addFailed(i);
                    OkHttpExporter.this.logger.log(Level.WARNING, "Failed to export " + OkHttpExporter.this.type + "s. Server responded with HTTP status code " + response.code() + ". Error message: " + OkHttpExporter.extractErrorStatus(response, responseBodyBody));
                    completableResultCode.fail();
                    if (responseBodyBody != null) {
                        responseBodyBody.close();
                    }
                } catch (Throwable th) {
                    if (responseBodyBody != null) {
                        try {
                            responseBodyBody.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
        });
        return completableResultCode;
    }

    public CompletableResultCode shutdown() {
        CompletableResultCode completableResultCodeOfSuccess = CompletableResultCode.ofSuccess();
        this.client.dispatcher().cancelAll();
        this.client.dispatcher().executorService().shutdownNow();
        this.client.connectionPool().evictAll();
        return completableResultCodeOfSuccess;
    }

    static boolean isRetryable(Response response) {
        return RetryUtil.retryableHttpResponseCodes().contains(Integer.valueOf(response.code()));
    }

    private static RequestBody gzipRequestBody(final RequestBody requestBody) {
        return new RequestBody() { // from class: io.opentelemetry.exporter.internal.okhttp.OkHttpExporter.2
            @Override // okhttp3.RequestBody
            public long contentLength() {
                return -1L;
            }

            @Override // okhttp3.RequestBody
            /* JADX INFO: renamed from: contentType */
            public MediaType get$mediaType() {
                return requestBody.get$mediaType();
            }

            @Override // okhttp3.RequestBody
            public void writeTo(BufferedSink bufferedSink) throws IOException {
                BufferedSink bufferedSinkBuffer = Okio.buffer(new GzipSink(bufferedSink));
                requestBody.writeTo(bufferedSinkBuffer);
                bufferedSinkBuffer.close();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String extractErrorStatus(Response response, @Nullable ResponseBody responseBody) {
        if (responseBody == null) {
            return "Response body missing, HTTP status message: " + response.message();
        }
        try {
            return GrpcStatusUtil.getStatusMessage(responseBody.bytes());
        } catch (IOException unused) {
            return "Unable to parse response body, HTTP status message: " + response.message();
        }
    }
}
