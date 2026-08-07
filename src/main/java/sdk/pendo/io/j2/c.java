package sdk.pendo.io.j2;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.box.boxandroidlibv2private.requests.BoxRequestGetInbox;
import java.io.IOException;
import java.net.ProtocolException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.hc.core5.http.HeaderElements;
import sdk.pendo.io.e2.b0;
import sdk.pendo.io.e2.c0;
import sdk.pendo.io.e2.d0;
import sdk.pendo.io.e2.e0;
import sdk.pendo.io.e2.r;
import sdk.pendo.io.s2.a0;
import sdk.pendo.io.s2.o;
import sdk.pendo.io.s2.y;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0002\u0005\u0012B'\u0012\u0006\u0010#\u001a\u00020\u001f\u0012\u0006\u0010(\u001a\u00020$\u0012\u0006\u0010-\u001a\u00020)\u0012\u0006\u00100\u001a\u00020.¢\u0006\u0004\bA\u0010BJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\u0005\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0004J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\bJ\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0005\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0016\u001a\u00020\u0004J\u0006\u0010\u0017\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\u0004J9\u0010\u0005\u001a\u00028\u0000\"\n\b\u0000\u0010\u0018*\u0004\u0018\u00010\u00022\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u0005\u0010\u001dJ\u0006\u0010\u001e\u001a\u00020\u0004R\u001a\u0010#\u001a\u00020\u001f8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010 \u001a\u0004\b!\u0010\"R\u001a\u0010(\u001a\u00020$8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0012\u0010%\u001a\u0004\b&\u0010'R\u001a\u0010-\u001a\u00020)8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\f\u0010*\u001a\u0004\b+\u0010,R\u0014\u00100\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010/R$\u00105\u001a\u00020\b2\u0006\u00101\u001a\u00020\b8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b\u0003\u00102\u001a\u0004\b3\u00104R$\u00108\u001a\u00020\b2\u0006\u00101\u001a\u00020\b8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b6\u00102\u001a\u0004\b7\u00104R\u001a\u0010>\u001a\u0002098\u0000X\u0080\u0004¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u0014\u0010@\u001a\u00020\b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b?\u00104¨\u0006C"}, d2 = {"Lsdk/pendo/io/j2/c;", "", "Ljava/io/IOException;", "e", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/e2/b0;", "request", "", "duplex", "Lsdk/pendo/io/s2/y;", "d", "c", "o", "expectContinue", "Lsdk/pendo/io/e2/d0$a;", "Lsdk/pendo/io/e2/d0;", "response", "b", "Lsdk/pendo/io/e2/e0;", "Lsdk/pendo/io/r2/d$d;", CmcdData.STREAM_TYPE_LIVE, "p", CmcdData.OBJECT_TYPE_MANIFEST, ExifInterface.LONGITUDE_EAST, "", "bytesRead", "responseDone", "requestDone", "(JZZLjava/io/IOException;)Ljava/io/IOException;", "n", "Lsdk/pendo/io/j2/e;", "Lsdk/pendo/io/j2/e;", "getCall$okhttp", "()Lokhttp3/internal/connection/RealCall;", NotificationCompat.CATEGORY_CALL, "Lsdk/pendo/io/e2/r;", "Lsdk/pendo/io/e2/r;", "getEventListener$okhttp", "()Lokhttp3/EventListener;", "eventListener", "Lsdk/pendo/io/j2/d;", "Lsdk/pendo/io/j2/d;", "getFinder$okhttp", "()Lokhttp3/internal/connection/ExchangeFinder;", "finder", "Lsdk/pendo/io/k2/d;", "Lsdk/pendo/io/k2/d;", "codec", "<set-?>", "Z", "k", "()Z", "isDuplex", "f", "i", "hasFailure", "Lsdk/pendo/io/j2/f;", "g", "Lsdk/pendo/io/j2/f;", "getConnection$okhttp", "()Lokhttp3/internal/connection/RealConnection;", "connection", "j", "isCoalescedConnection", "<init>", "(Lokhttp3/internal/connection/RealCall;Lokhttp3/EventListener;Lokhttp3/internal/connection/ExchangeFinder;Lokhttp3/internal/http/ExchangeCodec;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
public final class c {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final e call;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final r eventListener;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final d finder;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final sdk.pendo.io.k2.d codec;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private boolean isDuplex;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private boolean hasFailure;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final f connection;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u0010\u001a\u00020\t¢\u0006\u0004\b\u001a\u0010\u001bJ#\u0010\u0005\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0005\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016R\u0014\u0010\u0010\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u000fR\u0016\u0010\u0017\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0013¨\u0006\u001c"}, d2 = {"Lsdk/pendo/io/j2/c$a;", "Lsdk/pendo/io/s2/i;", "Ljava/io/IOException;", ExifInterface.LONGITUDE_EAST, "e", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Ljava/io/IOException;)Ljava/io/IOException;", "Lsdk/pendo/io/s2/d;", "source", "", "byteCount", "", "flush", HeaderElements.CLOSE, "b", "J", "contentLength", "", "c", "Z", BoxRequestGetInbox.STATUS_COMPLETED, "d", "bytesReceived", "closed", "Lsdk/pendo/io/s2/y;", "delegate", "<init>", "(Lokhttp3/internal/connection/Exchange;Lokio/Sink;J)V", "okhttp"}, k = 1, mv = {1, 8, 0})
    private final class a extends sdk.pendo.io.s2.i {

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        private final long contentLength;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        private boolean completed;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        private long bytesReceived;

        /* JADX INFO: renamed from: e, reason: from kotlin metadata */
        private boolean closed;
        final /* synthetic */ c f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c cVar, y delegate, long j) {
            super(delegate);
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            this.f = cVar;
            this.contentLength = j;
        }

        private final <E extends IOException> E a(E e) {
            if (this.completed) {
                return e;
            }
            this.completed = true;
            return (E) this.f.a(this.bytesReceived, false, true, e);
        }

        @Override // sdk.pendo.io.s2.i, sdk.pendo.io.s2.y, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            long j = this.contentLength;
            if (j != -1 && this.bytesReceived != j) {
                throw new ProtocolException("unexpected end of stream");
            }
            try {
                super.close();
                a(null);
            } catch (IOException e) {
                throw a(e);
            }
        }

        @Override // sdk.pendo.io.s2.i, sdk.pendo.io.s2.y, java.io.Flushable
        public void flush() throws IOException {
            try {
                super.flush();
            } catch (IOException e) {
                throw a(e);
            }
        }

        @Override // sdk.pendo.io.s2.i, sdk.pendo.io.s2.y
        public void a(sdk.pendo.io.s2.d source, long byteCount) throws IOException {
            Intrinsics.checkNotNullParameter(source, "source");
            if (this.closed) {
                throw new IllegalStateException("closed".toString());
            }
            long j = this.contentLength;
            if (j != -1 && this.bytesReceived + byteCount > j) {
                throw new ProtocolException("expected " + this.contentLength + " bytes but received " + (this.bytesReceived + byteCount));
            }
            try {
                super.a(source, byteCount);
                this.bytesReceived += byteCount;
            } catch (IOException e) {
                throw a(e);
            }
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J!\u0010\f\u001a\u00028\u0000\"\n\b\u0000\u0010\n*\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00028\u0000¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0014¨\u0006\u001d"}, d2 = {"Lsdk/pendo/io/j2/c$b;", "Lsdk/pendo/io/s2/j;", "Lsdk/pendo/io/s2/d;", "sink", "", "byteCount", "b", "", HeaderElements.CLOSE, "Ljava/io/IOException;", ExifInterface.LONGITUDE_EAST, "e", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Ljava/io/IOException;)Ljava/io/IOException;", "J", "contentLength", "c", "bytesReceived", "", "d", "Z", "invokeStartEvent", BoxRequestGetInbox.STATUS_COMPLETED, "f", "closed", "Lsdk/pendo/io/s2/a0;", "delegate", "<init>", "(Lokhttp3/internal/connection/Exchange;Lokio/Source;J)V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public final class b extends sdk.pendo.io.s2.j {

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        private final long contentLength;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        private long bytesReceived;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        private boolean invokeStartEvent;

        /* JADX INFO: renamed from: e, reason: from kotlin metadata */
        private boolean completed;

        /* JADX INFO: renamed from: f, reason: from kotlin metadata */
        private boolean closed;
        final /* synthetic */ c g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(c cVar, a0 delegate, long j) {
            super(delegate);
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            this.g = cVar;
            this.contentLength = j;
            this.invokeStartEvent = true;
            if (j == 0) {
                a(null);
            }
        }

        public final <E extends IOException> E a(E e) {
            if (this.completed) {
                return e;
            }
            this.completed = true;
            if (e == null && this.invokeStartEvent) {
                this.invokeStartEvent = false;
                this.g.getEventListener().f(this.g.getCall());
            }
            return (E) this.g.a(this.bytesReceived, true, false, e);
        }

        @Override // sdk.pendo.io.s2.j, sdk.pendo.io.s2.a0
        public long b(sdk.pendo.io.s2.d sink, long byteCount) throws IOException {
            Intrinsics.checkNotNullParameter(sink, "sink");
            if (this.closed) {
                throw new IllegalStateException("closed".toString());
            }
            try {
                long jB = getDelegate().b(sink, byteCount);
                if (this.invokeStartEvent) {
                    this.invokeStartEvent = false;
                    this.g.getEventListener().f(this.g.getCall());
                }
                if (jB == -1) {
                    a(null);
                    return -1L;
                }
                long j = this.bytesReceived + jB;
                long j2 = this.contentLength;
                if (j2 != -1 && j > j2) {
                    throw new ProtocolException("expected " + this.contentLength + " bytes but received " + j);
                }
                this.bytesReceived = j;
                if (j == j2) {
                    a(null);
                }
                return jB;
            } catch (IOException e) {
                throw a(e);
            }
        }

        @Override // sdk.pendo.io.s2.j, sdk.pendo.io.s2.a0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            try {
                super.close();
                a(null);
            } catch (IOException e) {
                throw a(e);
            }
        }
    }

    public c(e call, r eventListener, d finder, sdk.pendo.io.k2.d codec) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(eventListener, "eventListener");
        Intrinsics.checkNotNullParameter(finder, "finder");
        Intrinsics.checkNotNullParameter(codec, "codec");
        this.call = call;
        this.eventListener = eventListener;
        this.finder = finder;
        this.codec = codec;
        this.connection = codec.getConnection();
    }

    public final <E extends IOException> E a(long bytesRead, boolean responseDone, boolean requestDone, E e) {
        if (e != null) {
            a(e);
        }
        if (requestDone) {
            r rVar = this.eventListener;
            e eVar = this.call;
            if (e != null) {
                rVar.b(eVar, e);
            } else {
                rVar.a(eVar, bytesRead);
            }
        }
        if (responseDone) {
            if (e != null) {
                this.eventListener.c(this.call, e);
            } else {
                this.eventListener.b(this.call, bytesRead);
            }
        }
        return (E) this.call.a(this, requestDone, responseDone, e);
    }

    public final void b() {
        this.codec.cancel();
        this.call.a(this, true, true, null);
    }

    public final void c() throws IOException {
        try {
            this.codec.finishRequest();
        } catch (IOException e) {
            this.eventListener.b(this.call, e);
            a(e);
            throw e;
        }
    }

    public final void d() throws IOException {
        try {
            this.codec.flushRequest();
        } catch (IOException e) {
            this.eventListener.b(this.call, e);
            a(e);
            throw e;
        }
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final e getCall() {
        return this.call;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final f getConnection() {
        return this.connection;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final r getEventListener() {
        return this.eventListener;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final d getFinder() {
        return this.finder;
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final boolean getHasFailure() {
        return this.hasFailure;
    }

    public final boolean j() {
        return !Intrinsics.areEqual(this.finder.getAddress().getUrl().getHost(), this.connection.getRoute().getAddress().getUrl().getHost());
    }

    /* JADX INFO: renamed from: k, reason: from getter */
    public final boolean getIsDuplex() {
        return this.isDuplex;
    }

    public final sdk.pendo.io.r2.d.AbstractC0471d l() {
        this.call.m();
        return this.codec.getConnection().a(this);
    }

    public final void m() {
        this.codec.getConnection().k();
    }

    public final void n() {
        this.call.a(this, true, false, null);
    }

    public final void o() {
        this.eventListener.g(this.call);
    }

    public final void p() {
        a(-1L, true, true, null);
    }

    public final void a() {
        this.codec.cancel();
    }

    public final void b(d0 response) {
        Intrinsics.checkNotNullParameter(response, "response");
        this.eventListener.c(this.call, response);
    }

    public final y a(b0 request, boolean duplex) {
        Intrinsics.checkNotNullParameter(request, "request");
        this.isDuplex = duplex;
        c0 body = request.getBody();
        Intrinsics.checkNotNull(body);
        long jA = body.a();
        this.eventListener.d(this.call);
        return new a(this, this.codec.a(request, jA), jA);
    }

    public final e0 a(d0 response) throws IOException {
        Intrinsics.checkNotNullParameter(response, "response");
        try {
            String strA = d0.a(response, "Content-Type", null, 2, null);
            long jA = this.codec.a(response);
            return new sdk.pendo.io.k2.h(strA, jA, o.a(new b(this, this.codec.b(response), jA)));
        } catch (IOException e) {
            this.eventListener.c(this.call, e);
            a(e);
            throw e;
        }
    }

    public final d0.a a(boolean expectContinue) throws IOException {
        try {
            d0.a responseHeaders = this.codec.readResponseHeaders(expectContinue);
            if (responseHeaders != null) {
                responseHeaders.a(this);
            }
            return responseHeaders;
        } catch (IOException e) {
            this.eventListener.c(this.call, e);
            a(e);
            throw e;
        }
    }

    private final void a(IOException e) {
        this.hasFailure = true;
        this.finder.a(e);
        this.codec.getConnection().a(this.call, e);
    }

    public final void a(b0 request) throws IOException {
        Intrinsics.checkNotNullParameter(request, "request");
        try {
            this.eventListener.e(this.call);
            this.codec.a(request);
            this.eventListener.a(this.call, request);
        } catch (IOException e) {
            this.eventListener.b(this.call, e);
            a(e);
            throw e;
        }
    }
}
