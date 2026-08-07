package com.microsoft.identity.common.java.net;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import com.microsoft.identity.common.java.AuthenticationConstants;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.exception.ConnectionError;
import com.microsoft.identity.common.java.flighting.CommonFlight;
import com.microsoft.identity.common.java.flighting.CommonFlightsManager;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.opentelemetry.AttributeName;
import com.microsoft.identity.common.java.opentelemetry.SpanExtension;
import com.microsoft.identity.common.java.telemetry.Telemetry;
import com.microsoft.identity.common.java.telemetry.events.HttpEndEvent;
import com.microsoft.identity.common.java.telemetry.events.HttpStartEvent;
import com.microsoft.identity.common.java.util.StringUtil;
import com.microsoft.identity.common.java.util.ported.Consumer;
import com.microsoft.identity.common.java.util.ported.Function;
import com.microsoft.identity.common.java.util.ported.Supplier;
import io.opentelemetry.api.trace.Span;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import net.jcip.annotations.ThreadSafe;

/* JADX INFO: loaded from: classes14.dex */
@ThreadSafe
public class UrlConnectionHttpClient extends AbstractHttpClient {
    public static final int DEFAULT_CONNECT_TIME_OUT_MS = 30000;
    public static final int DEFAULT_READ_TIME_OUT_MS = 30000;
    protected static final int DEFAULT_STREAM_BUFFER_SIZE_BYTE = 1024;
    protected static final int RETRY_TIME_WAITING_PERIOD_MSEC = 1000;
    private static final String TAG = "UrlConnectionHttpClient";
    private static final AtomicReference<UrlConnectionHttpClient> defaultReference = new AtomicReference<>(null);
    private final int connectTimeoutMs;
    private final Supplier<Integer> connectTimeoutMsSupplier;
    private final int readTimeoutMs;
    private final Supplier<Integer> readTimeoutMsSupplier;
    private final IRetryPolicy<HttpResponse> retryPolicy;
    private final SSLSocketFactoryWrapper sslSocketFactory;
    private final int streamBufferSize;

    public static boolean isRetryableError(int i) {
        return i == 500 || i == 504 || i == 503;
    }

    public UrlConnectionHttpClient(IRetryPolicy<HttpResponse> iRetryPolicy, int i, int i2, int i3, Supplier<Integer> supplier, Supplier<Integer> supplier2, SSLSocketFactoryWrapper sSLSocketFactoryWrapper) {
        this.retryPolicy = iRetryPolicy;
        this.streamBufferSize = i;
        this.connectTimeoutMs = i2;
        this.readTimeoutMs = i3;
        this.connectTimeoutMsSupplier = supplier;
        this.readTimeoutMsSupplier = supplier2;
        this.sslSocketFactory = sSLSocketFactoryWrapper;
    }

    public static class UrlConnectionHttpClientBuilder {
        private Integer connectTimeoutMs;
        private Supplier<Integer> connectTimeoutMsSupplier;
        private Integer readTimeoutMs;
        private Supplier<Integer> readTimeoutMsSupplier;
        private IRetryPolicy<HttpResponse> retryPolicy;
        private SSLContext sslContext;
        private Integer streamBufferSize;
        private List<String> supportedSslProtocols;

        UrlConnectionHttpClientBuilder() {
        }

        public UrlConnectionHttpClient build() {
            return new UrlConnectionHttpClient(this.retryPolicy, this.streamBufferSize, this.connectTimeoutMs, this.readTimeoutMs, this.connectTimeoutMsSupplier, this.readTimeoutMsSupplier, this.supportedSslProtocols, this.sslContext);
        }

        public UrlConnectionHttpClientBuilder connectTimeoutMs(@Nullable Integer num) {
            this.connectTimeoutMs = num;
            return this;
        }

        public UrlConnectionHttpClientBuilder connectTimeoutMsSupplier(@Nullable Supplier<Integer> supplier) {
            this.connectTimeoutMsSupplier = supplier;
            return this;
        }

        public UrlConnectionHttpClientBuilder readTimeoutMs(@Nullable Integer num) {
            this.readTimeoutMs = num;
            return this;
        }

        public UrlConnectionHttpClientBuilder readTimeoutMsSupplier(@Nullable Supplier<Integer> supplier) {
            this.readTimeoutMsSupplier = supplier;
            return this;
        }

        public UrlConnectionHttpClientBuilder retryPolicy(@Nullable IRetryPolicy<HttpResponse> iRetryPolicy) {
            this.retryPolicy = iRetryPolicy;
            return this;
        }

        public UrlConnectionHttpClientBuilder sslContext(@Nullable SSLContext sSLContext) {
            this.sslContext = sSLContext;
            return this;
        }

        public UrlConnectionHttpClientBuilder streamBufferSize(@Nullable Integer num) {
            this.streamBufferSize = num;
            return this;
        }

        public UrlConnectionHttpClientBuilder supportedSslProtocols(@Nullable List<String> list) {
            this.supportedSslProtocols = list;
            return this;
        }

        public String toString() {
            return "UrlConnectionHttpClient.UrlConnectionHttpClientBuilder(retryPolicy=" + this.retryPolicy + ", streamBufferSize=" + this.streamBufferSize + ", connectTimeoutMs=" + this.connectTimeoutMs + ", readTimeoutMs=" + this.readTimeoutMs + ", connectTimeoutMsSupplier=" + this.connectTimeoutMsSupplier + ", readTimeoutMsSupplier=" + this.readTimeoutMsSupplier + ", supportedSslProtocols=" + this.supportedSslProtocols + ", sslContext=" + this.sslContext + ")";
        }
    }

    public static UrlConnectionHttpClientBuilder builder() {
        return new UrlConnectionHttpClientBuilder();
    }

    private UrlConnectionHttpClient(@Nullable IRetryPolicy<HttpResponse> iRetryPolicy, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable Supplier<Integer> supplier, @Nullable Supplier<Integer> supplier2, @Nullable List<String> list, @Nullable SSLContext sSLContext) {
        this.retryPolicy = iRetryPolicy == null ? new NoRetryPolicy() : iRetryPolicy;
        this.streamBufferSize = num != null ? num.intValue() : 1024;
        this.connectTimeoutMs = num2 != null ? num2.intValue() : CommonFlightsManager.INSTANCE.getFlightsProvider().getIntValue(CommonFlight.URL_CONNECTION_CONNECT_TIME_OUT);
        this.readTimeoutMs = num3 != null ? num3.intValue() : CommonFlightsManager.INSTANCE.getFlightsProvider().getIntValue(CommonFlight.URL_CONNECTION_READ_TIME_OUT);
        this.connectTimeoutMsSupplier = supplier;
        this.readTimeoutMsSupplier = supplier2;
        list = list == null ? SSLSocketFactoryWrapper.SUPPORTED_SSL_PROTOCOLS : list;
        if (sSLContext == null) {
            this.sslSocketFactory = new SSLSocketFactoryWrapper((SSLSocketFactory) SSLSocketFactory.getDefault(), list);
        } else {
            this.sslSocketFactory = new SSLSocketFactoryWrapper(sSLContext.getSocketFactory(), list);
        }
    }

    public static synchronized UrlConnectionHttpClient getDefaultInstance() {
        UrlConnectionHttpClient urlConnectionHttpClient;
        AtomicReference<UrlConnectionHttpClient> atomicReference = defaultReference;
        urlConnectionHttpClient = atomicReference.get();
        if (urlConnectionHttpClient == null) {
            PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, null, builder().retryPolicy(StatusCodeAndExceptionRetry.builder().number(1).extensionFactor(2).isAcceptable(new Function<HttpResponse, Boolean>() { // from class: com.microsoft.identity.common.java.net.UrlConnectionHttpClient.3
                @Override // com.microsoft.identity.common.java.util.ported.Function
                public Boolean apply(HttpResponse httpResponse) {
                    return Boolean.valueOf(httpResponse != null && httpResponse.getStatusCode() < 400);
                }
            }).initialDelay(1000).isRetryable(new Function<HttpResponse, Boolean>() { // from class: com.microsoft.identity.common.java.net.UrlConnectionHttpClient.2
                @Override // com.microsoft.identity.common.java.util.ported.Function
                public Boolean apply(HttpResponse httpResponse) {
                    return Boolean.valueOf(httpResponse != null && UrlConnectionHttpClient.isRetryableError(httpResponse.getStatusCode()));
                }
            }).isRetryableException(new Function<Exception, Boolean>() { // from class: com.microsoft.identity.common.java.net.UrlConnectionHttpClient.1
                @Override // com.microsoft.identity.common.java.util.ported.Function
                public Boolean apply(Exception exc) {
                    return Boolean.valueOf(ConnectionError.CONNECTION_TIMEOUT.compare(exc));
                }
            }).build()).build());
            urlConnectionHttpClient = atomicReference.get();
        }
        return urlConnectionHttpClient;
    }

    private static void recordHttpTelemetryEventStart(String str, URL url, String str2) {
        if (str == null) {
            throw new NullPointerException("requestMethod is marked non-null but is null");
        }
        if (url == null) {
            throw new NullPointerException("requestUrl is marked non-null but is null");
        }
        Telemetry.emit(new HttpStartEvent().putMethod(str).putPath(url).putRequestIdHeader(str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void recordHttpTelemetryEventEnd(HttpResponse httpResponse) {
        HttpEndEvent httpEndEvent = new HttpEndEvent();
        if (httpResponse != null) {
            httpEndEvent.putStatusCode(httpResponse.getStatusCode());
        }
        Telemetry.emit(httpEndEvent);
    }

    @Override // com.microsoft.identity.common.java.net.AbstractHttpClient, com.microsoft.identity.common.java.net.HttpClient
    public HttpResponse method(HttpClient.HttpMethod httpMethod, URL url, Map<String, String> map, byte[] bArr) throws ClientException {
        if (httpMethod == null) {
            throw new NullPointerException("httpMethod is marked non-null but is null");
        }
        if (url == null) {
            throw new NullPointerException("requestUrl is marked non-null but is null");
        }
        if (map == null) {
            throw new NullPointerException("requestHeaders is marked non-null but is null");
        }
        recordHttpTelemetryEventStart(httpMethod.name(), url, map.get("client-request-id"));
        final HttpRequest httpRequestConstructHttpRequest = constructHttpRequest(httpMethod, url, map, bArr);
        return this.retryPolicy.attempt(new Callable() { // from class: com.microsoft.identity.common.java.net.UrlConnectionHttpClient$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.m13857xb470155d(httpRequestConstructHttpRequest);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$method$0$com-microsoft-identity-common-java-net-UrlConnectionHttpClient, reason: not valid java name */
    /* synthetic */ HttpResponse m13857xb470155d(HttpRequest httpRequest) throws Exception {
        return executeHttpSend(httpRequest, new UrlConnectionHttpClient$$ExternalSyntheticLambda2());
    }

    @Override // com.microsoft.identity.common.java.net.AbstractHttpClient, com.microsoft.identity.common.java.net.HttpClient
    public HttpResponse patch(URL url, Map<String, String> map, @Nullable byte[] bArr) throws ClientException {
        if (url == null) {
            throw new NullPointerException("requestUrl is marked non-null but is null");
        }
        if (map == null) {
            throw new NullPointerException("requestHeaders is marked non-null but is null");
        }
        recordHttpTelemetryEventStart(HttpClient.HttpMethod.PATCH.name(), url, map.get("client-request-id"));
        final HttpRequest httpRequest = new HttpRequest(url, map, HttpClient.HttpMethod.PATCH.name(), bArr, null);
        return this.retryPolicy.attempt(new Callable() { // from class: com.microsoft.identity.common.java.net.UrlConnectionHttpClient$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.m13858x6c8b360f(httpRequest);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$patch$1$com-microsoft-identity-common-java-net-UrlConnectionHttpClient, reason: not valid java name */
    /* synthetic */ HttpResponse m13858x6c8b360f(HttpRequest httpRequest) throws Exception {
        return executeHttpSend(httpRequest, new UrlConnectionHttpClient$$ExternalSyntheticLambda2());
    }

    private static HttpRequest constructHttpRequest(HttpClient.HttpMethod httpMethod, URL url, Map<String, String> map, byte[] bArr) {
        Map<String, String> map2;
        if (httpMethod == null) {
            throw new NullPointerException("httpMethod is marked non-null but is null");
        }
        if (url == null) {
            throw new NullPointerException("requestUrl is marked non-null but is null");
        }
        if (map == null) {
            throw new NullPointerException("requestHeaders is marked non-null but is null");
        }
        if (HttpClient.HttpMethod.PATCH == httpMethod) {
            httpMethod = HttpClient.HttpMethod.POST;
            HashMap map3 = new HashMap(map);
            map3.put("X-HTTP-Method-Override", HttpClient.HttpMethod.PATCH.name());
            map2 = map3;
        } else {
            map2 = map;
        }
        return new HttpRequest(url, map2, httpMethod.name(), bArr, null);
    }

    private String convertStreamToString(InputStream inputStream) throws IOException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, AuthenticationConstants.CHARSET_UTF8));
            char[] cArr = new char[this.streamBufferSize];
            StringBuilder sb = new StringBuilder();
            while (true) {
                int i = bufferedReader.read(cArr);
                if (i > -1) {
                    sb.append(cArr, 0, i);
                } else {
                    return sb.toString();
                }
            }
        } finally {
            safeCloseStream(inputStream);
        }
    }

    private static void safeCloseStream(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e) {
            Logger.error(TAG + ":safeCloseStream", "Encountered IO exception when trying to close the stream", e);
        }
    }

    private HttpResponse executeHttpSend(HttpRequest httpRequest, Consumer<HttpResponse> consumer) throws Throwable {
        try {
            HttpURLConnection httpURLConnection = setupConnection(httpRequest);
            sendRequest(httpURLConnection, httpRequest.getRequestContent(), httpRequest.getRequestHeaders().get("Content-Type"));
            return getHttpResponse(consumer, httpURLConnection);
        } catch (IOException e) {
            throw ConnectionError.getClientException(e);
        }
    }

    private HttpResponse getHttpResponse(Consumer<HttpResponse> consumer, HttpURLConnection httpURLConnection) throws Throwable {
        InputStream errorStream;
        String strConvertStreamToString;
        HttpResponse httpResponse = null;
        try {
            try {
                errorStream = httpURLConnection.getInputStream();
            } catch (SocketTimeoutException e) {
                throw e;
            } catch (IOException unused) {
                errorStream = httpURLConnection.getErrorStream();
            }
            try {
                int responseCode = httpURLConnection.getResponseCode();
                Date date = new Date(httpURLConnection.getDate());
                if (errorStream == null) {
                    strConvertStreamToString = "";
                } else {
                    strConvertStreamToString = convertStreamToString(errorStream);
                }
                HttpResponse httpResponse2 = new HttpResponse(date, responseCode, strConvertStreamToString, httpURLConnection.getHeaderFields());
                try {
                    Span spanCurrent = SpanExtension.current();
                    if (httpResponse2.getHeaders() != null && httpResponse2.getHeaders().size() > 0) {
                        spanCurrent.setAttribute(AttributeName.response_content_type.name(), httpResponse2.getHeaderValue("Content-Type", 0));
                        spanCurrent.setAttribute(AttributeName.ccs_request_id.name(), httpResponse2.getHeaderValue(HttpConstants.HeaderField.XMS_CCS_REQUEST_ID, 0));
                        spanCurrent.setAttribute(AttributeName.ccs_request_sequence.name(), httpResponse2.getHeaderValue(HttpConstants.HeaderField.XMS_CCS_REQUEST_SEQUENCE, 0));
                    }
                    spanCurrent.setAttribute(AttributeName.response_body_length.name(), strConvertStreamToString.length());
                    spanCurrent.setAttribute(AttributeName.http_status_code.name(), httpResponse2.getStatusCode());
                    consumer.accept(httpResponse2);
                    safeCloseStream(errorStream);
                    return httpResponse2;
                } catch (Throwable th) {
                    th = th;
                    httpResponse = httpResponse2;
                    consumer.accept(httpResponse);
                    safeCloseStream(errorStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            errorStream = null;
            consumer.accept(httpResponse);
            safeCloseStream(errorStream);
            throw th;
        }
    }

    private HttpURLConnection setupConnection(HttpRequest httpRequest) throws IOException {
        HttpURLConnection httpURLConnectionCreateHttpURLConnection = HttpUrlConnectionFactory.createHttpURLConnection(httpRequest.getRequestUrl());
        for (Map.Entry<String, String> entry : httpRequest.getRequestHeaders().entrySet()) {
            httpURLConnectionCreateHttpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
        if (httpURLConnectionCreateHttpURLConnection instanceof HttpsURLConnection) {
            ((HttpsURLConnection) httpURLConnectionCreateHttpURLConnection).setSSLSocketFactory(this.sslSocketFactory);
        } else {
            if ("https".equalsIgnoreCase(httpRequest.getRequestUrl().getProtocol())) {
                throw new IllegalStateException("Trying to initiate a HTTPS request, but didn't get back HttpsURLConnection");
            }
            if ("http".equalsIgnoreCase(httpRequest.getRequestUrl().getProtocol())) {
                Logger.warn(TAG + ":setupConnection", "Making a request for non-https URL.");
            } else {
                Logger.warn(TAG + ":setupConnection", "gets a request from an unexpected protocol: " + httpRequest.getRequestUrl().getProtocol());
            }
        }
        httpURLConnectionCreateHttpURLConnection.setRequestMethod(httpRequest.getRequestMethod());
        httpURLConnectionCreateHttpURLConnection.setConnectTimeout(getConnectTimeoutMs());
        httpURLConnectionCreateHttpURLConnection.setReadTimeout(getReadTimeoutMs());
        httpURLConnectionCreateHttpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnectionCreateHttpURLConnection.setUseCaches(true);
        httpURLConnectionCreateHttpURLConnection.setDoInput(true);
        return httpURLConnectionCreateHttpURLConnection;
    }

    private int getReadTimeoutMs() {
        Supplier<Integer> supplier = this.readTimeoutMsSupplier;
        return supplier == null ? this.readTimeoutMs : supplier.get().intValue();
    }

    private int getConnectTimeoutMs() {
        Supplier<Integer> supplier = this.connectTimeoutMsSupplier;
        return supplier == null ? this.connectTimeoutMs : supplier.get().intValue();
    }

    private static void sendRequest(HttpURLConnection httpURLConnection, byte[] bArr, String str) throws Throwable {
        OutputStream outputStream;
        if (httpURLConnection == null) {
            throw new NullPointerException("connection is marked non-null but is null");
        }
        if (bArr == null) {
            return;
        }
        httpURLConnection.setDoOutput(true);
        if (!StringUtil.isNullOrEmpty(str)) {
            httpURLConnection.setRequestProperty("Content-Type", str);
        }
        httpURLConnection.setRequestProperty("Content-Length", String.valueOf(bArr.length));
        try {
            outputStream = httpURLConnection.getOutputStream();
            try {
                outputStream.write(bArr);
                safeCloseStream(outputStream);
            } catch (Throwable th) {
                th = th;
                safeCloseStream(outputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            outputStream = null;
        }
    }
}
