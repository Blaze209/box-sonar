package zipkin2.reporter.okhttp3;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Dispatcher;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;
import okio.BufferedSink;
import okio.GzipSink;
import okio.Okio;
import zipkin2.Call;
import zipkin2.CheckResult;
import zipkin2.codec.Encoding;
import zipkin2.reporter.ClosedSenderException;
import zipkin2.reporter.Sender;

/* JADX INFO: loaded from: classes6.dex */
public final class OkHttpSender extends Sender {
    final OkHttpClient client;
    volatile boolean closeCalled;
    final boolean compressionEnabled;
    final RequestBodyMessageEncoder encoder;
    final Encoding encoding;
    final HttpUrl endpoint;
    final int maxRequests;
    final int messageMaxBytes;

    public static OkHttpSender create(String str) {
        return newBuilder().endpoint(str).build();
    }

    public static Builder newBuilder() {
        return new Builder(new OkHttpClient.Builder());
    }

    public static final class Builder {
        final OkHttpClient.Builder clientBuilder;
        boolean compressionEnabled;
        Encoding encoding;
        HttpUrl endpoint;
        int maxRequests;
        int messageMaxBytes;

        Builder(OkHttpClient.Builder builder) {
            this.encoding = Encoding.JSON;
            this.compressionEnabled = true;
            this.maxRequests = 64;
            this.messageMaxBytes = 500000;
            this.clientBuilder = builder;
        }

        Builder(OkHttpSender okHttpSender) {
            this.encoding = Encoding.JSON;
            this.compressionEnabled = true;
            this.maxRequests = 64;
            this.messageMaxBytes = 500000;
            this.clientBuilder = okHttpSender.client.newBuilder();
            this.endpoint = okHttpSender.endpoint;
            this.maxRequests = okHttpSender.client.dispatcher().getMaxRequests();
            this.compressionEnabled = okHttpSender.compressionEnabled;
            this.encoding = okHttpSender.encoding;
            this.messageMaxBytes = okHttpSender.messageMaxBytes;
        }

        public Builder endpoint(String str) {
            if (str == null) {
                throw new NullPointerException("endpoint == null");
            }
            HttpUrl httpUrl = HttpUrl.parse(str);
            if (httpUrl == null) {
                throw new IllegalArgumentException("invalid POST url: " + str);
            }
            return endpoint(httpUrl);
        }

        public Builder endpoint(HttpUrl httpUrl) {
            if (httpUrl == null) {
                throw new NullPointerException("endpoint == null");
            }
            this.endpoint = httpUrl;
            return this;
        }

        public Builder compressionEnabled(boolean z) {
            this.compressionEnabled = z;
            return this;
        }

        public Builder messageMaxBytes(int i) {
            this.messageMaxBytes = i;
            return this;
        }

        public Builder maxRequests(int i) {
            this.maxRequests = i;
            return this;
        }

        public Builder encoding(Encoding encoding) {
            if (encoding == null) {
                throw new NullPointerException("encoding == null");
            }
            this.encoding = encoding;
            return this;
        }

        public final Builder connectTimeout(int i) {
            this.clientBuilder.connectTimeout(i, TimeUnit.MILLISECONDS);
            return this;
        }

        public final Builder readTimeout(int i) {
            this.clientBuilder.readTimeout(i, TimeUnit.MILLISECONDS);
            return this;
        }

        public final Builder writeTimeout(int i) {
            this.clientBuilder.writeTimeout(i, TimeUnit.MILLISECONDS);
            return this;
        }

        public OkHttpClient.Builder clientBuilder() {
            return this.clientBuilder;
        }

        public final OkHttpSender build() {
            return new OkHttpSender(this);
        }
    }

    OkHttpSender(Builder builder) {
        if (builder.endpoint == null) {
            throw new NullPointerException("endpoint == null");
        }
        this.endpoint = builder.endpoint;
        Encoding encoding = builder.encoding;
        this.encoding = encoding;
        int i = AnonymousClass1.$SwitchMap$zipkin2$codec$Encoding[encoding.ordinal()];
        if (i == 1) {
            this.encoder = RequestBodyMessageEncoder.JSON;
        } else if (i == 2) {
            this.encoder = RequestBodyMessageEncoder.THRIFT;
        } else if (i == 3) {
            this.encoder = RequestBodyMessageEncoder.PROTO3;
        } else {
            throw new UnsupportedOperationException("Unsupported encoding: " + encoding.name());
        }
        int i2 = builder.maxRequests;
        this.maxRequests = i2;
        this.messageMaxBytes = builder.messageMaxBytes;
        this.compressionEnabled = builder.compressionEnabled;
        this.client = builder.clientBuilder().build().newBuilder().dispatcher(newDispatcher(i2)).build();
    }

    /* JADX INFO: renamed from: zipkin2.reporter.okhttp3.OkHttpSender$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$zipkin2$codec$Encoding;

        static {
            int[] iArr = new int[Encoding.values().length];
            $SwitchMap$zipkin2$codec$Encoding = iArr;
            try {
                iArr[Encoding.JSON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$zipkin2$codec$Encoding[Encoding.THRIFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$zipkin2$codec$Encoding[Encoding.PROTO3.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static Dispatcher newDispatcher(int i) {
        Dispatcher dispatcher = new Dispatcher(new ThreadPoolExecutor(0, i, 60L, TimeUnit.SECONDS, new SynchronousQueue(), OkHttpSenderThreadFactory.INSTANCE));
        dispatcher.setMaxRequests(i);
        dispatcher.setMaxRequestsPerHost(i);
        return dispatcher;
    }

    enum OkHttpSenderThreadFactory implements ThreadFactory {
        INSTANCE;

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "OkHttpSender Dispatcher");
        }
    }

    public final Builder toBuilder() {
        return new Builder(this);
    }

    @Override // zipkin2.reporter.Sender
    public int messageSizeInBytes(List<byte[]> list) {
        return this.encoding.listSizeInBytes(list);
    }

    @Override // zipkin2.reporter.Sender
    public int messageSizeInBytes(int i) {
        return this.encoding.listSizeInBytes(i);
    }

    @Override // zipkin2.reporter.Sender
    public Encoding encoding() {
        return this.encoding;
    }

    @Override // zipkin2.reporter.Sender
    public int messageMaxBytes() {
        return this.messageMaxBytes;
    }

    @Override // zipkin2.reporter.Sender
    public Call<Void> sendSpans(List<byte[]> list) {
        if (this.closeCalled) {
            throw new ClosedSenderException();
        }
        try {
            return new HttpCall(this.client.newCall(newRequest(this.encoder.encode(list))));
        } catch (IOException e) {
            throw Platform.get().uncheckedIOException(e);
        }
    }

    @Override // zipkin2.Component
    public CheckResult check() {
        try {
            Response responseExecute = this.client.newCall(new Request.Builder().url(this.endpoint).post(RequestBody.create(MediaType.parse("application/json"), HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)).build()).execute();
            try {
                if (!responseExecute.isSuccessful()) {
                    CheckResult checkResultFailed = CheckResult.failed(new RuntimeException("check response failed: " + responseExecute));
                    if (responseExecute != null) {
                        responseExecute.close();
                    }
                    return checkResultFailed;
                }
                if (responseExecute != null) {
                    responseExecute.close();
                }
                return CheckResult.OK;
            } catch (Throwable th) {
                if (responseExecute != null) {
                    try {
                        responseExecute.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Exception e) {
            return CheckResult.failed(e);
        }
        return CheckResult.failed(e);
    }

    @Override // zipkin2.Component, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.closeCalled) {
            return;
        }
        this.closeCalled = true;
        Dispatcher dispatcher = this.client.dispatcher();
        dispatcher.executorService().shutdown();
        try {
            if (!dispatcher.executorService().awaitTermination(1L, TimeUnit.SECONDS)) {
                dispatcher.cancelAll();
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    Request newRequest(RequestBody requestBody) throws IOException {
        Request.Builder builderUrl = new Request.Builder().url(this.endpoint);
        builderUrl.addHeader("b3", "0");
        if (this.compressionEnabled) {
            builderUrl.addHeader("Content-Encoding", "gzip");
            Buffer buffer = new Buffer();
            BufferedSink bufferedSinkBuffer = Okio.buffer(new GzipSink(buffer));
            requestBody.writeTo(bufferedSinkBuffer);
            bufferedSinkBuffer.close();
            requestBody = new BufferRequestBody(requestBody.get$mediaType(), buffer);
        }
        builderUrl.post(requestBody);
        return builderUrl.build();
    }

    public final String toString() {
        return "OkHttpSender{" + this.endpoint + "}";
    }

    static final class BufferRequestBody extends RequestBody {
        final Buffer body;
        final MediaType contentType;

        BufferRequestBody(MediaType mediaType, Buffer buffer) {
            this.contentType = mediaType;
            this.body = buffer;
        }

        @Override // okhttp3.RequestBody
        public long contentLength() {
            return this.body.size();
        }

        @Override // okhttp3.RequestBody
        /* JADX INFO: renamed from: contentType */
        public MediaType get$mediaType() {
            return this.contentType;
        }

        @Override // okhttp3.RequestBody
        public void writeTo(BufferedSink bufferedSink) throws IOException {
            Buffer buffer = this.body;
            bufferedSink.write(buffer, buffer.size());
        }
    }
}
