package sdk.pendo.io.l2;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.identity.common.nativeauth.internal.commands.ResetPasswordSubmitNewPasswordCommand;
import com.pspdfkit.analytics.Analytics;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.io.IOUtils;
import org.apache.hc.core5.http.HeaderElements;
import sdk.pendo.io.e2.d0;
import sdk.pendo.io.e2.n;
import sdk.pendo.io.e2.u;
import sdk.pendo.io.e2.v;
import sdk.pendo.io.e2.z;
import sdk.pendo.io.k2.d;
import sdk.pendo.io.k2.i;
import sdk.pendo.io.s2.a0;
import sdk.pendo.io.s2.b0;
import sdk.pendo.io.s2.k;
import sdk.pendo.io.s2.y;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 =2\u00020\u0001:\u0007\u0003\u0004\n\u001e.25B)\u0012\b\u0010!\u001a\u0004\u0018\u00010\u001f\u0012\u0006\u0010&\u001a\u00020\"\u0012\u0006\u0010)\u001a\u00020'\u0012\u0006\u0010,\u001a\u00020*¢\u0006\u0004\b;\u0010<J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u0003\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\u0007H\u0002J\u0010\u0010\u0003\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\b\u0010\u0011\u001a\u00020\rH\u0016J\u0010\u0010\u0003\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0003\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0004\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\rH\u0016J\b\u0010\u0015\u001a\u00020\rH\u0016J\u0016\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u000e\u0010\u001e\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0012R\u0016\u0010!\u001a\u0004\u0018\u00010\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010 R\u001a\u0010&\u001a\u00020\"8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010#\u001a\u0004\b$\u0010%R\u0014\u0010)\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010(R\u0014\u0010,\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00107\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0018\u00108\u001a\u00020\u001a*\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b8\u00109R\u0018\u00108\u001a\u00020\u001a*\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b8\u0010:¨\u0006>"}, d2 = {"Lsdk/pendo/io/l2/b;", "Lsdk/pendo/io/k2/d;", "Lsdk/pendo/io/s2/y;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "b", "", Analytics.Data.LENGTH, "Lsdk/pendo/io/s2/a0;", "Lsdk/pendo/io/e2/v;", "url", "c", "Lsdk/pendo/io/s2/k;", ResetPasswordSubmitNewPasswordCommand.POLL_COMPLETION_TIMEOUT_ERROR_CODE, "", "Lsdk/pendo/io/e2/b0;", "request", "contentLength", "cancel", "Lsdk/pendo/io/e2/d0;", "response", "flushRequest", "finishRequest", "Lsdk/pendo/io/e2/u;", "headers", "", "requestLine", "", "expectContinue", "Lsdk/pendo/io/e2/d0$a;", "readResponseHeaders", "d", "Lsdk/pendo/io/e2/z;", "Lsdk/pendo/io/e2/z;", "client", "Lsdk/pendo/io/j2/f;", "Lsdk/pendo/io/j2/f;", "getConnection", "()Lokhttp3/internal/connection/RealConnection;", "connection", "Lsdk/pendo/io/s2/f;", "Lsdk/pendo/io/s2/f;", "source", "Lsdk/pendo/io/s2/e;", "Lsdk/pendo/io/s2/e;", "sink", "", "e", "I", "state", "Lsdk/pendo/io/l2/a;", "f", "Lsdk/pendo/io/l2/a;", "headersReader", "g", "Lsdk/pendo/io/e2/u;", "trailers", "isChunked", "(Lokhttp3/Request;)Z", "(Lokhttp3/Response;)Z", "<init>", "(Lokhttp3/OkHttpClient;Lokhttp3/internal/connection/RealConnection;Lokio/BufferedSource;Lokio/BufferedSink;)V", CmcdData.STREAMING_FORMAT_HLS, "okhttp"}, k = 1, mv = {1, 8, 0})
public final class b implements d {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final z client;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final sdk.pendo.io.j2.f connection;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final sdk.pendo.io.s2.f source;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final sdk.pendo.io.s2.e sink;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private int state;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final sdk.pendo.io.l2.a headersReader;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private u trailers;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\b¢\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0006\u0010\b\u001a\u00020\tR\u001a\u0010\u0003\u001a\u00020\n8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\"\u0010\u0013\u001a\u00020\u000f8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0010\u001a\u0004\b\u000b\u0010\u0011\"\u0004\b\u000b\u0010\u0012¨\u0006\u0016"}, d2 = {"Lsdk/pendo/io/l2/b$a;", "Lsdk/pendo/io/s2/a0;", "Lsdk/pendo/io/s2/b0;", ResetPasswordSubmitNewPasswordCommand.POLL_COMPLETION_TIMEOUT_ERROR_CODE, "Lsdk/pendo/io/s2/d;", "sink", "", "byteCount", "b", "", "Lsdk/pendo/io/s2/k;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/s2/k;", "getTimeout", "()Lokio/ForwardingTimeout;", "", "Z", "()Z", "(Z)V", "closed", "<init>", "(Lokhttp3/internal/http1/Http1ExchangeCodec;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
    private abstract class a implements a0 {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final k timeout;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        private boolean closed;

        public a() {
            this.timeout = new k(b.this.source.getTimeout());
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        protected final boolean getClosed() {
            return this.closed;
        }

        @Override // sdk.pendo.io.s2.a0
        public long b(sdk.pendo.io.s2.d sink, long byteCount) throws IOException {
            Intrinsics.checkNotNullParameter(sink, "sink");
            try {
                return b.this.source.b(sink, byteCount);
            } catch (IOException e) {
                b.this.getConnection().k();
                b();
                throw e;
            }
        }

        @Override // sdk.pendo.io.s2.a0
        /* JADX INFO: renamed from: timeout */
        public b0 getTimeout() {
            return this.timeout;
        }

        protected final void a(boolean z) {
            this.closed = z;
        }

        public final void b() {
            if (b.this.state == 6) {
                return;
            }
            if (b.this.state != 5) {
                throw new IllegalStateException("state: " + b.this.state);
            }
            b.this.a(this.timeout);
            b.this.state = 6;
        }
    }

    /* JADX INFO: renamed from: sdk.pendo.io.l2.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lsdk/pendo/io/l2/b$b;", "Lsdk/pendo/io/s2/y;", "Lsdk/pendo/io/s2/b0;", ResetPasswordSubmitNewPasswordCommand.POLL_COMPLETION_TIMEOUT_ERROR_CODE, "Lsdk/pendo/io/s2/d;", "source", "", "byteCount", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "flush", HeaderElements.CLOSE, "Lsdk/pendo/io/s2/k;", "Lsdk/pendo/io/s2/k;", "", "b", "Z", "closed", "<init>", "(Lokhttp3/internal/http1/Http1ExchangeCodec;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
    private final class C0409b implements y {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final k timeout;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        private boolean closed;

        public C0409b() {
            this.timeout = new k(b.this.sink.getTimeout());
        }

        @Override // sdk.pendo.io.s2.y
        public void a(sdk.pendo.io.s2.d source, long byteCount) {
            Intrinsics.checkNotNullParameter(source, "source");
            if (this.closed) {
                throw new IllegalStateException("closed".toString());
            }
            if (byteCount == 0) {
                return;
            }
            b.this.sink.writeHexadecimalUnsignedLong(byteCount);
            b.this.sink.writeUtf8(IOUtils.LINE_SEPARATOR_WINDOWS);
            b.this.sink.a(source, byteCount);
            b.this.sink.writeUtf8(IOUtils.LINE_SEPARATOR_WINDOWS);
        }

        @Override // sdk.pendo.io.s2.y, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            b.this.sink.writeUtf8("0\r\n\r\n");
            b.this.a(this.timeout);
            b.this.state = 3;
        }

        @Override // sdk.pendo.io.s2.y, java.io.Flushable
        public synchronized void flush() {
            if (this.closed) {
                return;
            }
            b.this.sink.flush();
        }

        @Override // sdk.pendo.io.s2.y
        /* JADX INFO: renamed from: timeout */
        public b0 getTimeout() {
            return this.timeout;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lsdk/pendo/io/l2/b$c;", "Lsdk/pendo/io/l2/b$a;", "Lsdk/pendo/io/l2/b;", "", "c", "Lsdk/pendo/io/s2/d;", "sink", "", "byteCount", "b", HeaderElements.CLOSE, "Lsdk/pendo/io/e2/v;", "d", "Lsdk/pendo/io/e2/v;", "url", "e", "J", "bytesRemainingInChunk", "", "f", "Z", "hasMoreChunks", "<init>", "(Lokhttp3/internal/http1/Http1ExchangeCodec;Lokhttp3/HttpUrl;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
    private final class c extends a {

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        private final v url;

        /* JADX INFO: renamed from: e, reason: from kotlin metadata */
        private long bytesRemainingInChunk;

        /* JADX INFO: renamed from: f, reason: from kotlin metadata */
        private boolean hasMoreChunks;
        final /* synthetic */ b g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(b bVar, v url) {
            super();
            Intrinsics.checkNotNullParameter(url, "url");
            this.g = bVar;
            this.url = url;
            this.bytesRemainingInChunk = -1L;
            this.hasMoreChunks = true;
        }

        private final void c() throws ProtocolException {
            if (this.bytesRemainingInChunk != -1) {
                this.g.source.readUtf8LineStrict();
            }
            try {
                this.bytesRemainingInChunk = this.g.source.readHexadecimalUnsignedLong();
                String string = StringsKt.trim((CharSequence) this.g.source.readUtf8LineStrict()).toString();
                if (this.bytesRemainingInChunk < 0 || (string.length() > 0 && !StringsKt.startsWith$default(string, AuthenticationConstants.Broker.CHALLENGE_REQUEST_CERT_AUTH_DELIMETER, false, 2, (Object) null))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.bytesRemainingInChunk + string + '\"');
                }
                if (this.bytesRemainingInChunk == 0) {
                    this.hasMoreChunks = false;
                    b bVar = this.g;
                    bVar.trailers = bVar.headersReader.a();
                    z zVar = this.g.client;
                    Intrinsics.checkNotNull(zVar);
                    n cookieJar = zVar.getCookieJar();
                    v vVar = this.url;
                    u uVar = this.g.trailers;
                    Intrinsics.checkNotNull(uVar);
                    sdk.pendo.io.k2.e.a(cookieJar, vVar, uVar);
                    b();
                }
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }

        @Override // sdk.pendo.io.l2.b.a, sdk.pendo.io.s2.a0
        public long b(sdk.pendo.io.s2.d sink, long byteCount) throws IOException {
            Intrinsics.checkNotNullParameter(sink, "sink");
            if (byteCount < 0) {
                throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
            }
            if (getClosed()) {
                throw new IllegalStateException("closed".toString());
            }
            if (!this.hasMoreChunks) {
                return -1L;
            }
            long j = this.bytesRemainingInChunk;
            if (j == 0 || j == -1) {
                c();
                if (!this.hasMoreChunks) {
                    return -1L;
                }
            }
            long jB = super.b(sink, Math.min(byteCount, this.bytesRemainingInChunk));
            if (jB != -1) {
                this.bytesRemainingInChunk -= jB;
                return jB;
            }
            this.g.getConnection().k();
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            b();
            throw protocolException;
        }

        @Override // sdk.pendo.io.s2.a0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (getClosed()) {
                return;
            }
            if (this.hasMoreChunks && !sdk.pendo.io.f2.b.a(this, 100, TimeUnit.MILLISECONDS)) {
                this.g.getConnection().k();
                b();
            }
            a(true);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u0016\u0010\f\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lsdk/pendo/io/l2/b$e;", "Lsdk/pendo/io/l2/b$a;", "Lsdk/pendo/io/l2/b;", "Lsdk/pendo/io/s2/d;", "sink", "", "byteCount", "b", "", HeaderElements.CLOSE, "d", "J", "bytesRemaining", "<init>", "(Lokhttp3/internal/http1/Http1ExchangeCodec;J)V", "okhttp"}, k = 1, mv = {1, 8, 0})
    private final class e extends a {

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        private long bytesRemaining;

        public e(long j) {
            super();
            this.bytesRemaining = j;
            if (j == 0) {
                b();
            }
        }

        @Override // sdk.pendo.io.l2.b.a, sdk.pendo.io.s2.a0
        public long b(sdk.pendo.io.s2.d sink, long byteCount) throws IOException {
            Intrinsics.checkNotNullParameter(sink, "sink");
            if (byteCount < 0) {
                throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
            }
            if (getClosed()) {
                throw new IllegalStateException("closed".toString());
            }
            long j = this.bytesRemaining;
            if (j == 0) {
                return -1L;
            }
            long jB = super.b(sink, Math.min(j, byteCount));
            if (jB == -1) {
                b.this.getConnection().k();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                b();
                throw protocolException;
            }
            long j2 = this.bytesRemaining - jB;
            this.bytesRemaining = j2;
            if (j2 == 0) {
                b();
            }
            return jB;
        }

        @Override // sdk.pendo.io.s2.a0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (getClosed()) {
                return;
            }
            if (this.bytesRemaining != 0 && !sdk.pendo.io.f2.b.a(this, 100, TimeUnit.MILLISECONDS)) {
                b.this.getConnection().k();
                b();
            }
            a(true);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lsdk/pendo/io/l2/b$f;", "Lsdk/pendo/io/s2/y;", "Lsdk/pendo/io/s2/b0;", ResetPasswordSubmitNewPasswordCommand.POLL_COMPLETION_TIMEOUT_ERROR_CODE, "Lsdk/pendo/io/s2/d;", "source", "", "byteCount", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "flush", HeaderElements.CLOSE, "Lsdk/pendo/io/s2/k;", "Lsdk/pendo/io/s2/k;", "", "b", "Z", "closed", "<init>", "(Lokhttp3/internal/http1/Http1ExchangeCodec;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
    private final class f implements y {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final k timeout;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        private boolean closed;

        public f() {
            this.timeout = new k(b.this.sink.getTimeout());
        }

        @Override // sdk.pendo.io.s2.y
        public void a(sdk.pendo.io.s2.d source, long byteCount) {
            Intrinsics.checkNotNullParameter(source, "source");
            if (this.closed) {
                throw new IllegalStateException("closed".toString());
            }
            sdk.pendo.io.f2.b.a(source.getSize(), 0L, byteCount);
            b.this.sink.a(source, byteCount);
        }

        @Override // sdk.pendo.io.s2.y, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            b.this.a(this.timeout);
            b.this.state = 3;
        }

        @Override // sdk.pendo.io.s2.y, java.io.Flushable
        public void flush() {
            if (this.closed) {
                return;
            }
            b.this.sink.flush();
        }

        @Override // sdk.pendo.io.s2.y
        /* JADX INFO: renamed from: timeout */
        public b0 getTimeout() {
            return this.timeout;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lsdk/pendo/io/l2/b$g;", "Lsdk/pendo/io/l2/b$a;", "Lsdk/pendo/io/l2/b;", "Lsdk/pendo/io/s2/d;", "sink", "", "byteCount", "b", "", HeaderElements.CLOSE, "", "d", "Z", "inputExhausted", "<init>", "(Lokhttp3/internal/http1/Http1ExchangeCodec;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
    private final class g extends a {

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        private boolean inputExhausted;

        public g() {
            super();
        }

        @Override // sdk.pendo.io.l2.b.a, sdk.pendo.io.s2.a0
        public long b(sdk.pendo.io.s2.d sink, long byteCount) throws IOException {
            Intrinsics.checkNotNullParameter(sink, "sink");
            if (byteCount < 0) {
                throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
            }
            if (getClosed()) {
                throw new IllegalStateException("closed".toString());
            }
            if (this.inputExhausted) {
                return -1L;
            }
            long jB = super.b(sink, byteCount);
            if (jB != -1) {
                return jB;
            }
            this.inputExhausted = true;
            b();
            return -1L;
        }

        @Override // sdk.pendo.io.s2.a0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (getClosed()) {
                return;
            }
            if (!this.inputExhausted) {
                b();
            }
            a(true);
        }
    }

    public b(z zVar, sdk.pendo.io.j2.f connection, sdk.pendo.io.s2.f source, sdk.pendo.io.s2.e sink) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(sink, "sink");
        this.client = zVar;
        this.connection = connection;
        this.source = source;
        this.sink = sink;
        this.headersReader = new sdk.pendo.io.l2.a(source);
    }

    @Override // sdk.pendo.io.k2.d
    public void cancel() {
        getConnection().a();
    }

    @Override // sdk.pendo.io.k2.d
    public void finishRequest() {
        this.sink.flush();
    }

    @Override // sdk.pendo.io.k2.d
    public void flushRequest() {
        this.sink.flush();
    }

    @Override // sdk.pendo.io.k2.d
    public sdk.pendo.io.j2.f getConnection() {
        return this.connection;
    }

    @Override // sdk.pendo.io.k2.d
    public d0.a readResponseHeaders(boolean expectContinue) {
        int i = this.state;
        if (i != 1 && i != 2 && i != 3) {
            throw new IllegalStateException(("state: " + this.state).toString());
        }
        try {
            sdk.pendo.io.k2.k kVarA = sdk.pendo.io.k2.k.INSTANCE.a(this.headersReader.b());
            d0.a aVarA = new d0.a().a(kVarA.protocol).a(kVarA.code).a(kVarA.message).a(this.headersReader.a());
            if (expectContinue && kVarA.code == 100) {
                return null;
            }
            int i2 = kVarA.code;
            if (i2 != 100 && (102 > i2 || i2 >= 200)) {
                this.state = 4;
                return aVarA;
            }
            this.state = 3;
            return aVarA;
        } catch (EOFException e2) {
            throw new IOException("unexpected end of stream on " + getConnection().getRoute().getAddress().getUrl().n(), e2);
        }
    }

    private final boolean b(sdk.pendo.io.e2.b0 b0Var) {
        return StringsKt.equals("chunked", b0Var.a("Transfer-Encoding"), true);
    }

    private final boolean c(d0 d0Var) {
        return StringsKt.equals("chunked", d0.a(d0Var, "Transfer-Encoding", null, 2, null), true);
    }

    public final void d(d0 response) {
        Intrinsics.checkNotNullParameter(response, "response");
        long jA = sdk.pendo.io.f2.b.a(response);
        if (jA == -1) {
            return;
        }
        a0 a0VarA = a(jA);
        sdk.pendo.io.f2.b.b(a0VarA, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
        a0VarA.close();
    }

    private final y b() {
        if (this.state != 1) {
            throw new IllegalStateException(("state: " + this.state).toString());
        }
        this.state = 2;
        return new f();
    }

    private final a0 c() {
        if (this.state != 4) {
            throw new IllegalStateException(("state: " + this.state).toString());
        }
        this.state = 5;
        getConnection().k();
        return new g();
    }

    @Override // sdk.pendo.io.k2.d
    public a0 b(d0 response) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (!sdk.pendo.io.k2.e.b(response)) {
            return a(0L);
        }
        if (c(response)) {
            return a(response.getRequest().i());
        }
        long jA = sdk.pendo.io.f2.b.a(response);
        return jA != -1 ? a(jA) : c();
    }

    @Override // sdk.pendo.io.k2.d
    public y a(sdk.pendo.io.e2.b0 request, long contentLength) throws ProtocolException {
        Intrinsics.checkNotNullParameter(request, "request");
        if (request.getBody() != null && request.getBody().c()) {
            throw new ProtocolException("Duplex connections are not supported for HTTP/1");
        }
        if (b(request)) {
            return a();
        }
        if (contentLength != -1) {
            return b();
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(k timeout) {
        b0 delegate = timeout.getDelegate();
        timeout.a(b0.e);
        delegate.a();
        delegate.b();
    }

    private final y a() {
        if (this.state != 1) {
            throw new IllegalStateException(("state: " + this.state).toString());
        }
        this.state = 2;
        return new C0409b();
    }

    private final a0 a(v url) {
        if (this.state != 4) {
            throw new IllegalStateException(("state: " + this.state).toString());
        }
        this.state = 5;
        return new c(this, url);
    }

    private final a0 a(long length) {
        if (this.state != 4) {
            throw new IllegalStateException(("state: " + this.state).toString());
        }
        this.state = 5;
        return new e(length);
    }

    @Override // sdk.pendo.io.k2.d
    public long a(d0 response) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (!sdk.pendo.io.k2.e.b(response)) {
            return 0L;
        }
        if (c(response)) {
            return -1L;
        }
        return sdk.pendo.io.f2.b.a(response);
    }

    public final void a(u headers, String requestLine) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(requestLine, "requestLine");
        if (this.state != 0) {
            throw new IllegalStateException(("state: " + this.state).toString());
        }
        this.sink.writeUtf8(requestLine).writeUtf8(IOUtils.LINE_SEPARATOR_WINDOWS);
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            this.sink.writeUtf8(headers.a(i)).writeUtf8(": ").writeUtf8(headers.b(i)).writeUtf8(IOUtils.LINE_SEPARATOR_WINDOWS);
        }
        this.sink.writeUtf8(IOUtils.LINE_SEPARATOR_WINDOWS);
        this.state = 1;
    }

    @Override // sdk.pendo.io.k2.d
    public void a(sdk.pendo.io.e2.b0 request) {
        Intrinsics.checkNotNullParameter(request, "request");
        i iVar = i.a;
        Proxy.Type type = getConnection().getRoute().getProxy().type();
        Intrinsics.checkNotNullExpressionValue(type, "connection.route().proxy.type()");
        a(request.getHeaders(), iVar.a(request, type));
    }
}
