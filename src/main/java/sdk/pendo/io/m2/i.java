package sdk.pendo.io.m2;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.microsoft.identity.common.nativeauth.internal.commands.ResetPasswordSubmitNewPasswordCommand;
import com.pspdfkit.analytics.Analytics;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.apache.hc.core5.http.HeaderElements;
import sdk.pendo.io.e2.u;
import sdk.pendo.io.s2.a0;
import sdk.pendo.io.s2.b0;
import sdk.pendo.io.s2.y;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u0000 ^2\u00020\u0001:\u0004\u0011\u0007&,B3\b\u0000\u0012\u0006\u0010\u001f\u001a\u00020\u0014\u0012\u0006\u0010$\u001a\u00020 \u0012\u0006\u0010[\u001a\u00020\u0006\u0012\u0006\u0010\u0017\u001a\u00020\u0006\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\\\u0010]J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\nJ\u0006\u0010\u000e\u001a\u00020\rJ\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014J\u0016\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002J\u000f\u0010\u0011\u001a\u00020\u0010H\u0000¢\u0006\u0004\b\u0011\u0010\u0018J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0019J\u000f\u0010\u0007\u001a\u00020\u0010H\u0000¢\u0006\u0004\b\u0007\u0010\u0018J\u000f\u0010\u001b\u001a\u00020\u0010H\u0000¢\u0006\u0004\b\u001b\u0010\u0018R\u0017\u0010\u001f\u001a\u00020\u00148\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010$\u001a\u00020 8\u0006¢\u0006\f\n\u0004\b\u0007\u0010!\u001a\u0004\b\"\u0010#R*\u0010+\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u00198\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b&\u0010*R*\u0010.\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u00198\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010'\u001a\u0004\b-\u0010)\"\u0004\b\u0007\u0010*R*\u00101\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u00198\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010'\u001a\u0004\b0\u0010)\"\u0004\b,\u0010*R*\u00104\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u00198\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010'\u001a\u0004\b2\u0010)\"\u0004\b3\u0010*R\u001a\u00107\u001a\b\u0012\u0004\u0012\u00020\b058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u00106R\u0016\u00109\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u00108R\u001e\u0010\u0013\u001a\u00060:R\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u001e\u0010C\u001a\u00060?R\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000e\u0010@\u001a\u0004\bA\u0010BR\u001e\u0010I\u001a\u00060DR\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR\u001e\u0010L\u001a\u00060DR\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\bJ\u0010F\u001a\u0004\bK\u0010HR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028@@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b2\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b0\u0010R\u001a\u0004\b/\u0010S\"\u0004\bT\u0010UR\u0011\u0010X\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\bV\u0010WR\u0011\u0010Z\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\bY\u0010W¨\u0006_"}, d2 = {"Lsdk/pendo/io/m2/i;", "", "Lsdk/pendo/io/m2/b;", "errorCode", "Ljava/io/IOException;", "errorException", "", "b", "Lsdk/pendo/io/e2/u;", "s", "Lsdk/pendo/io/s2/b0;", "r", "u", "Lsdk/pendo/io/s2/y;", "j", "rstStatusCode", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/s2/f;", "source", "", Analytics.Data.LENGTH, "headers", "inFinished", "()V", "", "delta", "t", "I", "f", "()I", "id", "Lsdk/pendo/io/m2/f;", "Lsdk/pendo/io/m2/f;", "getConnection", "()Lokhttp3/internal/http2/Http2Connection;", "connection", "<set-?>", "c", "J", CmcdData.STREAMING_FORMAT_HLS, "()J", "(J)V", "readBytesTotal", "d", "g", "readBytesAcknowledged", "e", "n", "writeBytesTotal", CmcdData.OBJECT_TYPE_MANIFEST, "setWriteBytesMaximum$okhttp", "writeBytesMaximum", "Ljava/util/ArrayDeque;", "Ljava/util/ArrayDeque;", "headersQueue", "Z", "hasResponseHeaders", "Lsdk/pendo/io/m2/i$c;", "i", "Lsdk/pendo/io/m2/i$c;", "getSource$okhttp", "()Lokhttp3/internal/http2/Http2Stream$FramingSource;", "Lsdk/pendo/io/m2/i$b;", "Lsdk/pendo/io/m2/i$b;", "getSink$okhttp", "()Lokhttp3/internal/http2/Http2Stream$FramingSink;", "sink", "Lsdk/pendo/io/m2/i$d;", "k", "Lsdk/pendo/io/m2/i$d;", "getReadTimeout$okhttp", "()Lokhttp3/internal/http2/Http2Stream$StreamTimeout;", "readTimeout", CmcdData.STREAM_TYPE_LIVE, "getWriteTimeout$okhttp", "writeTimeout", "Lsdk/pendo/io/m2/b;", "getErrorCode$okhttp", "()Lokhttp3/internal/http2/ErrorCode;", "setErrorCode$okhttp", "(Lokhttp3/internal/http2/ErrorCode;)V", "Ljava/io/IOException;", "()Ljava/io/IOException;", "setErrorException$okhttp", "(Ljava/io/IOException;)V", "q", "()Z", "isOpen", "p", "isLocallyInitiated", "outFinished", "<init>", "(ILokhttp3/internal/http2/Http2Connection;ZZLokhttp3/Headers;)V", "o", "okhttp"}, k = 1, mv = {1, 8, 0})
public final class i {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final int id;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final f connection;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private long readBytesTotal;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private long readBytesAcknowledged;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private long writeBytesTotal;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private long writeBytesMaximum;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final ArrayDeque<u> headersQueue;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private boolean hasResponseHeaders;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private final c source;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private final b sink;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private final d readTimeout;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    private final d writeTimeout;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    private sdk.pendo.io.m2.b errorCode;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    private IOException errorException;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016R\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0014R$\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010 \u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u000e\u001a\u0004\b\u0005\u0010\u0010\"\u0004\b\u001f\u0010\u0012¨\u0006#"}, d2 = {"Lsdk/pendo/io/m2/i$b;", "Lsdk/pendo/io/s2/y;", "", "outFinishedOnLastFrame", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/s2/d;", "source", "", "byteCount", "flush", "Lsdk/pendo/io/s2/b0;", ResetPasswordSubmitNewPasswordCommand.POLL_COMPLETION_TIMEOUT_ERROR_CODE, HeaderElements.CLOSE, "Z", "b", "()Z", "setFinished", "(Z)V", "finished", "Lsdk/pendo/io/s2/d;", "sendBuffer", "Lsdk/pendo/io/e2/u;", "c", "Lsdk/pendo/io/e2/u;", "getTrailers", "()Lokhttp3/Headers;", "setTrailers", "(Lokhttp3/Headers;)V", "trailers", "d", "setClosed", "closed", "<init>", "(Lokhttp3/internal/http2/Http2Stream;Z)V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public final class b implements y {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private boolean finished;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        private final sdk.pendo.io.s2.d sendBuffer = new sdk.pendo.io.s2.d();

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        private u trailers;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        private boolean closed;

        public b(boolean z) {
            this.finished = z;
        }

        private final void a(boolean outFinishedOnLastFrame) throws IOException {
            long jMin;
            boolean z;
            i iVar = i.this;
            synchronized (iVar) {
                iVar.getWriteTimeout().l();
                while (iVar.getWriteBytesTotal() >= iVar.getWriteBytesMaximum() && !this.finished && !this.closed && iVar.d() == null) {
                    try {
                        iVar.t();
                    } catch (Throwable th) {
                        iVar.getWriteTimeout().o();
                        throw th;
                    }
                }
                iVar.getWriteTimeout().o();
                iVar.b();
                jMin = Math.min(iVar.getWriteBytesMaximum() - iVar.getWriteBytesTotal(), this.sendBuffer.getSize());
                iVar.d(iVar.getWriteBytesTotal() + jMin);
                z = outFinishedOnLastFrame && jMin == this.sendBuffer.getSize();
                Unit unit = Unit.INSTANCE;
            }
            i.this.getWriteTimeout().l();
            try {
                i.this.getConnection().a(i.this.getId(), z, this.sendBuffer, jMin);
            } finally {
                i.this.getWriteTimeout().o();
            }
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final boolean getFinished() {
            return this.finished;
        }

        @Override // sdk.pendo.io.s2.y, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            i iVar = i.this;
            if (sdk.pendo.io.f2.b.h && Thread.holdsLock(iVar)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + iVar);
            }
            i iVar2 = i.this;
            synchronized (iVar2) {
                if (this.closed) {
                    return;
                }
                boolean z = iVar2.d() == null;
                Unit unit = Unit.INSTANCE;
                if (!i.this.getSink().finished) {
                    boolean z2 = this.sendBuffer.getSize() > 0;
                    if (this.trailers != null) {
                        while (this.sendBuffer.getSize() > 0) {
                            a(false);
                        }
                        f connection = i.this.getConnection();
                        int id = i.this.getId();
                        u uVar = this.trailers;
                        Intrinsics.checkNotNull(uVar);
                        connection.a(id, z, sdk.pendo.io.f2.b.a(uVar));
                    } else if (z2) {
                        while (this.sendBuffer.getSize() > 0) {
                            a(true);
                        }
                    } else if (z) {
                        i.this.getConnection().a(i.this.getId(), true, (sdk.pendo.io.s2.d) null, 0L);
                    }
                }
                synchronized (i.this) {
                    this.closed = true;
                    Unit unit2 = Unit.INSTANCE;
                }
                i.this.getConnection().flush();
                i.this.a();
            }
        }

        @Override // sdk.pendo.io.s2.y, java.io.Flushable
        public void flush() throws IOException {
            i iVar = i.this;
            if (sdk.pendo.io.f2.b.h && Thread.holdsLock(iVar)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + iVar);
            }
            i iVar2 = i.this;
            synchronized (iVar2) {
                iVar2.b();
                Unit unit = Unit.INSTANCE;
            }
            while (this.sendBuffer.getSize() > 0) {
                a(false);
                i.this.getConnection().flush();
            }
        }

        @Override // sdk.pendo.io.s2.y
        /* JADX INFO: renamed from: timeout */
        public b0 getTimeout() {
            return i.this.getWriteTimeout();
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final boolean getClosed() {
            return this.closed;
        }

        @Override // sdk.pendo.io.s2.y
        public void a(sdk.pendo.io.s2.d source, long byteCount) throws IOException {
            Intrinsics.checkNotNullParameter(source, "source");
            i iVar = i.this;
            if (sdk.pendo.io.f2.b.h && Thread.holdsLock(iVar)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + iVar);
            }
            this.sendBuffer.a(source, byteCount);
            while (this.sendBuffer.getSize() >= 16384) {
                a(false);
            }
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0012¢\u0006\u0004\b*\u0010+J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\fJ\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016R\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0010R\"\u0010\u0016\u001a\u00020\u00128\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0013\u001a\u0004\b\t\u0010\u0014\"\u0004\b\u0005\u0010\u0015R\u0017\u0010\u001b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001e\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001d\u0010\u001aR$\u0010&\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010)\u001a\u00020\u00128\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b'\u0010\u0013\u001a\u0004\b\u0005\u0010\u0014\"\u0004\b(\u0010\u0015¨\u0006,"}, d2 = {"Lsdk/pendo/io/m2/i$c;", "Lsdk/pendo/io/s2/a0;", "", "read", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/s2/d;", "sink", "byteCount", "b", "Lsdk/pendo/io/s2/f;", "source", "(Lsdk/pendo/io/s2/f;J)V", "Lsdk/pendo/io/s2/b0;", ResetPasswordSubmitNewPasswordCommand.POLL_COMPLETION_TIMEOUT_ERROR_CODE, HeaderElements.CLOSE, "J", "maxByteCount", "", "Z", "()Z", "(Z)V", "finished", "c", "Lsdk/pendo/io/s2/d;", "getReceiveBuffer", "()Lokio/Buffer;", "receiveBuffer", "d", "getReadBuffer", "readBuffer", "Lsdk/pendo/io/e2/u;", "e", "Lsdk/pendo/io/e2/u;", "getTrailers", "()Lokhttp3/Headers;", "setTrailers", "(Lokhttp3/Headers;)V", "trailers", "f", "setClosed$okhttp", "closed", "<init>", "(Lokhttp3/internal/http2/Http2Stream;JZ)V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public final class c implements a0 {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final long maxByteCount;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        private boolean finished;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        private final sdk.pendo.io.s2.d receiveBuffer = new sdk.pendo.io.s2.d();

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        private final sdk.pendo.io.s2.d readBuffer = new sdk.pendo.io.s2.d();

        /* JADX INFO: renamed from: e, reason: from kotlin metadata */
        private u trailers;

        /* JADX INFO: renamed from: f, reason: from kotlin metadata */
        private boolean closed;

        public c(long j, boolean z) {
            this.maxByteCount = j;
            this.finished = z;
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final boolean getClosed() {
            return this.closed;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final boolean getFinished() {
            return this.finished;
        }

        @Override // sdk.pendo.io.s2.a0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            long size;
            i iVar = i.this;
            synchronized (iVar) {
                this.closed = true;
                size = this.readBuffer.getSize();
                this.readBuffer.a();
                Intrinsics.checkNotNull(iVar, "null cannot be cast to non-null type java.lang.Object");
                iVar.notifyAll();
                Unit unit = Unit.INSTANCE;
            }
            if (size > 0) {
                a(size);
            }
            i.this.a();
        }

        @Override // sdk.pendo.io.s2.a0
        /* JADX INFO: renamed from: timeout */
        public b0 getTimeout() {
            return i.this.getReadTimeout();
        }

        public final void a(sdk.pendo.io.s2.f source, long byteCount) throws EOFException {
            boolean z;
            boolean z2;
            boolean z3;
            Intrinsics.checkNotNullParameter(source, "source");
            i iVar = i.this;
            if (sdk.pendo.io.f2.b.h && Thread.holdsLock(iVar)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + iVar);
            }
            long j = byteCount;
            while (j > 0) {
                synchronized (i.this) {
                    z = this.finished;
                    z2 = true;
                    z3 = this.readBuffer.getSize() + j > this.maxByteCount;
                    Unit unit = Unit.INSTANCE;
                }
                if (z3) {
                    source.skip(j);
                    i.this.a(sdk.pendo.io.m2.b.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z) {
                    source.skip(j);
                    return;
                }
                long jB = source.b(this.receiveBuffer, j);
                if (jB == -1) {
                    throw new EOFException();
                }
                j -= jB;
                i iVar2 = i.this;
                synchronized (iVar2) {
                    if (this.closed) {
                        this.receiveBuffer.a();
                    } else {
                        if (this.readBuffer.getSize() != 0) {
                            z2 = false;
                        }
                        this.readBuffer.a((a0) this.receiveBuffer);
                        if (z2) {
                            Intrinsics.checkNotNull(iVar2, "null cannot be cast to non-null type java.lang.Object");
                            iVar2.notifyAll();
                        }
                    }
                    Unit unit2 = Unit.INSTANCE;
                }
            }
            a(byteCount);
        }

        @Override // sdk.pendo.io.s2.a0
        public long b(sdk.pendo.io.s2.d sink, long byteCount) throws IOException {
            IOException errorException;
            boolean z;
            long jB;
            Intrinsics.checkNotNullParameter(sink, "sink");
            long j = 0;
            if (byteCount < 0) {
                throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
            }
            while (true) {
                i iVar = i.this;
                synchronized (iVar) {
                    iVar.getReadTimeout().l();
                    try {
                        if (iVar.d() == null || this.finished) {
                            errorException = null;
                        } else {
                            errorException = iVar.getErrorException();
                            if (errorException == null) {
                                sdk.pendo.io.m2.b bVarD = iVar.d();
                                Intrinsics.checkNotNull(bVarD);
                                errorException = new n(bVarD);
                            }
                        }
                        if (this.closed) {
                            throw new IOException("stream closed");
                        }
                        z = false;
                        if (this.readBuffer.getSize() > j) {
                            sdk.pendo.io.s2.d dVar = this.readBuffer;
                            jB = dVar.b(sink, Math.min(byteCount, dVar.getSize()));
                            iVar.c(iVar.getReadBytesTotal() + jB);
                            long readBytesTotal = iVar.getReadBytesTotal() - iVar.getReadBytesAcknowledged();
                            if (errorException == null && readBytesTotal >= iVar.getConnection().getOkHttpSettings().b() / 2) {
                                iVar.getConnection().a(iVar.getId(), readBytesTotal);
                                iVar.b(iVar.getReadBytesTotal());
                            }
                        } else {
                            if (!this.finished && errorException == null) {
                                iVar.t();
                                z = true;
                            }
                            jB = -1;
                        }
                        iVar.getReadTimeout().o();
                        Unit unit = Unit.INSTANCE;
                    } catch (Throwable th) {
                        iVar.getReadTimeout().o();
                        throw th;
                    }
                }
                if (!z) {
                    if (jB != -1) {
                        return jB;
                    }
                    if (errorException == null) {
                        return -1L;
                    }
                    throw errorException;
                }
                j = 0;
            }
        }

        public final void a(boolean z) {
            this.finished = z;
        }

        public final void a(u uVar) {
            this.trailers = uVar;
        }

        private final void a(long read) {
            i iVar = i.this;
            if (sdk.pendo.io.f2.b.h && Thread.holdsLock(iVar)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + iVar);
            }
            i.this.getConnection().b(read);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J\u0006\u0010\u0007\u001a\u00020\u0002¨\u0006\n"}, d2 = {"Lsdk/pendo/io/m2/i$d;", "Lsdk/pendo/io/s2/c;", "", "n", "Ljava/io/IOException;", "cause", "b", "o", "<init>", "(Lokhttp3/internal/http2/Http2Stream;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public final class d extends sdk.pendo.io.s2.c {
        public d() {
        }

        @Override // sdk.pendo.io.s2.c
        protected IOException b(IOException cause) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException(ResetPasswordSubmitNewPasswordCommand.POLL_COMPLETION_TIMEOUT_ERROR_CODE);
            if (cause != null) {
                socketTimeoutException.initCause(cause);
            }
            return socketTimeoutException;
        }

        @Override // sdk.pendo.io.s2.c
        protected void n() {
            i.this.a(sdk.pendo.io.m2.b.CANCEL);
            i.this.getConnection().l();
        }

        public final void o() throws IOException {
            if (m()) {
                throw b((IOException) null);
            }
        }
    }

    public i(int i, f connection, boolean z, boolean z2, u uVar) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        this.id = i;
        this.connection = connection;
        this.writeBytesMaximum = connection.getPeerSettings().b();
        ArrayDeque<u> arrayDeque = new ArrayDeque<>();
        this.headersQueue = arrayDeque;
        this.source = new c(connection.getOkHttpSettings().b(), z2);
        this.sink = new b(z);
        this.readTimeout = new d();
        this.writeTimeout = new d();
        boolean zP = p();
        if (uVar == null) {
            if (!zP) {
                throw new IllegalStateException("remotely-initiated streams should have headers".toString());
            }
        } else {
            if (zP) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet".toString());
            }
            arrayDeque.add(uVar);
        }
    }

    public final void a(long delta) {
        this.writeBytesMaximum += delta;
        if (delta > 0) {
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
        }
    }

    public final void b() throws IOException {
        if (this.sink.getClosed()) {
            throw new IOException("stream closed");
        }
        if (this.sink.getFinished()) {
            throw new IOException("stream finished");
        }
        if (this.errorCode != null) {
            IOException iOException = this.errorException;
            if (iOException != null) {
                throw iOException;
            }
            sdk.pendo.io.m2.b bVar = this.errorCode;
            Intrinsics.checkNotNull(bVar);
            throw new n(bVar);
        }
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final f getConnection() {
        return this.connection;
    }

    public final synchronized sdk.pendo.io.m2.b d() {
        return this.errorCode;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final IOException getErrorException() {
        return this.errorException;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final long getReadBytesAcknowledged() {
        return this.readBytesAcknowledged;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final long getReadBytesTotal() {
        return this.readBytesTotal;
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final d getReadTimeout() {
        return this.readTimeout;
    }

    public final y j() {
        synchronized (this) {
            if (!this.hasResponseHeaders && !p()) {
                throw new IllegalStateException("reply before requesting the sink".toString());
            }
            Unit unit = Unit.INSTANCE;
        }
        return this.sink;
    }

    /* JADX INFO: renamed from: k, reason: from getter */
    public final b getSink() {
        return this.sink;
    }

    /* JADX INFO: renamed from: l, reason: from getter */
    public final c getSource() {
        return this.source;
    }

    /* JADX INFO: renamed from: m, reason: from getter */
    public final long getWriteBytesMaximum() {
        return this.writeBytesMaximum;
    }

    /* JADX INFO: renamed from: n, reason: from getter */
    public final long getWriteBytesTotal() {
        return this.writeBytesTotal;
    }

    /* JADX INFO: renamed from: o, reason: from getter */
    public final d getWriteTimeout() {
        return this.writeTimeout;
    }

    public final boolean p() {
        return this.connection.getClient() == ((this.id & 1) == 1);
    }

    public final synchronized boolean q() {
        if (this.errorCode != null) {
            return false;
        }
        return ((this.source.getFinished() || this.source.getClosed()) && (this.sink.getFinished() || this.sink.getClosed()) && this.hasResponseHeaders) ? false : true;
    }

    public final b0 r() {
        return this.readTimeout;
    }

    public final synchronized u s() {
        u uVarRemoveFirst;
        this.readTimeout.l();
        while (this.headersQueue.isEmpty() && this.errorCode == null) {
            try {
                t();
            } catch (Throwable th) {
                this.readTimeout.o();
                throw th;
            }
        }
        this.readTimeout.o();
        if (this.headersQueue.isEmpty()) {
            IOException iOException = this.errorException;
            if (iOException != null) {
                throw iOException;
            }
            sdk.pendo.io.m2.b bVar = this.errorCode;
            Intrinsics.checkNotNull(bVar);
            throw new n(bVar);
        }
        uVarRemoveFirst = this.headersQueue.removeFirst();
        Intrinsics.checkNotNullExpressionValue(uVarRemoveFirst, "headersQueue.removeFirst()");
        return uVarRemoveFirst;
    }

    public final void t() throws InterruptedIOException {
        try {
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public final b0 u() {
        return this.writeTimeout;
    }

    private final boolean b(sdk.pendo.io.m2.b errorCode, IOException errorException) {
        if (sdk.pendo.io.f2.b.h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        synchronized (this) {
            if (this.errorCode != null) {
                return false;
            }
            this.errorCode = errorCode;
            this.errorException = errorException;
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
            if (this.source.getFinished() && this.sink.getFinished()) {
                return false;
            }
            Unit unit = Unit.INSTANCE;
            this.connection.c(this.id);
            return true;
        }
    }

    public final void a() {
        boolean z;
        boolean zQ;
        if (sdk.pendo.io.f2.b.h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        synchronized (this) {
            z = !this.source.getFinished() && this.source.getClosed() && (this.sink.getFinished() || this.sink.getClosed());
            zQ = q();
            Unit unit = Unit.INSTANCE;
        }
        if (z) {
            a(sdk.pendo.io.m2.b.CANCEL, (IOException) null);
        } else {
            if (zQ) {
                return;
            }
            this.connection.c(this.id);
        }
    }

    public final void c(long j) {
        this.readBytesTotal = j;
    }

    public final void d(long j) {
        this.writeBytesTotal = j;
    }

    public final void a(sdk.pendo.io.m2.b rstStatusCode, IOException errorException) {
        Intrinsics.checkNotNullParameter(rstStatusCode, "rstStatusCode");
        if (b(rstStatusCode, errorException)) {
            this.connection.b(this.id, rstStatusCode);
        }
    }

    public final synchronized void b(sdk.pendo.io.m2.b errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        if (this.errorCode == null) {
            this.errorCode = errorCode;
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
        }
    }

    public final void a(sdk.pendo.io.m2.b errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        if (b(errorCode, null)) {
            this.connection.c(this.id, errorCode);
        }
    }

    public final void b(long j) {
        this.readBytesAcknowledged = j;
    }

    public final void a(sdk.pendo.io.s2.f source, int length) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (sdk.pendo.io.f2.b.h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        this.source.a(source, length);
    }

    public final void a(u headers, boolean inFinished) {
        boolean zQ;
        Intrinsics.checkNotNullParameter(headers, "headers");
        if (sdk.pendo.io.f2.b.h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        synchronized (this) {
            if (this.hasResponseHeaders && inFinished) {
                this.source.a(headers);
            } else {
                this.hasResponseHeaders = true;
                this.headersQueue.add(headers);
            }
            if (inFinished) {
                this.source.a(true);
            }
            zQ = q();
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
            Unit unit = Unit.INSTANCE;
        }
        if (zQ) {
            return;
        }
        this.connection.c(this.id);
    }
}
