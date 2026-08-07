package sdk.pendo.io.m2;

import androidx.collection.SieveCacheKt;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.pspdfkit.analytics.Analytics;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.hc.core5.http.HeaderElements;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 92\u00020\u0001:\u0001\bB\u0017\u0012\u0006\u0010&\u001a\u00020$\u0012\u0006\u0010(\u001a\u00020\u0012¢\u0006\u0004\b7\u00108J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\b\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tJ$\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u0006\u0010\u000f\u001a\u00020\u0006J\u0016\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0007\u001a\u00020\u0002J(\u0010\b\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0005\u001a\u00020\u0002J(\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0005\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\tJ\u001e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002J\u001e\u0010\b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001dJ\u0016\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0004J&\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0002J\b\u0010\"\u001a\u00020\u0006H\u0016J$\u0010\b\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\r0\fR\u0014\u0010&\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010%R\u0014\u0010(\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010'R\u0014\u0010+\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010'R\u0017\u00106\u001a\u0002018\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105¨\u0006:"}, d2 = {"Lsdk/pendo/io/m2/j;", "Ljava/io/Closeable;", "", "streamId", "", "byteCount", "", "b", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/m2/m;", "peerSettings", "promisedStreamId", "", "Lsdk/pendo/io/m2/c;", "requestHeaders", "flush", "Lsdk/pendo/io/m2/b;", "errorCode", "", "outFinished", "Lsdk/pendo/io/s2/d;", "source", "flags", "buffer", BoxAnalyticsParams.CATEGORY_SETTINGS, "ack", "payload1", "payload2", "lastGoodStreamId", "", "debugData", "windowSizeIncrement", Analytics.Data.LENGTH, "type", HeaderElements.CLOSE, "headerBlock", "Lsdk/pendo/io/s2/e;", "Lsdk/pendo/io/s2/e;", "sink", "Z", "client", "c", "Lsdk/pendo/io/s2/d;", "hpackBuffer", "d", "I", "maxFrameSize", "e", "closed", "Lsdk/pendo/io/m2/d$b;", "f", "Lsdk/pendo/io/m2/d$b;", "getHpackWriter", "()Lokhttp3/internal/http2/Hpack$Writer;", "hpackWriter", "<init>", "(Lokio/BufferedSink;Z)V", "g", "okhttp"}, k = 1, mv = {1, 8, 0})
public final class j implements Closeable {
    private static final Logger h = Logger.getLogger(e.class.getName());

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final sdk.pendo.io.s2.e sink;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final boolean client;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final sdk.pendo.io.s2.d hpackBuffer;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private int maxFrameSize;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private boolean closed;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final d.b hpackWriter;

    public j(sdk.pendo.io.s2.e sink, boolean z) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        this.sink = sink;
        this.client = z;
        sdk.pendo.io.s2.d dVar = new sdk.pendo.io.s2.d();
        this.hpackBuffer = dVar;
        this.maxFrameSize = 16384;
        this.hpackWriter = new d.b(0, false, dVar, 3, null);
    }

    public final synchronized void a(m peerSettings) {
        Intrinsics.checkNotNullParameter(peerSettings, "peerSettings");
        if (this.closed) {
            throw new IOException("closed");
        }
        this.maxFrameSize = peerSettings.b(this.maxFrameSize);
        if (peerSettings.a() != -1) {
            this.hpackWriter.b(peerSettings.a());
        }
        a(0, 0, 4, 1);
        this.sink.flush();
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final int getMaxFrameSize() {
        return this.maxFrameSize;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.closed = true;
        this.sink.close();
    }

    public final synchronized void flush() {
        if (this.closed) {
            throw new IOException("closed");
        }
        this.sink.flush();
    }

    public final synchronized void a() {
        if (this.closed) {
            throw new IOException("closed");
        }
        if (this.client) {
            Logger logger = h;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(sdk.pendo.io.f2.b.a(">> CONNECTION " + e.CONNECTION_PREFACE.f(), new Object[0]));
            }
            this.sink.a(e.CONNECTION_PREFACE);
            this.sink.flush();
        }
    }

    public final synchronized void b(m settings) {
        int i;
        Intrinsics.checkNotNullParameter(settings, "settings");
        if (this.closed) {
            throw new IOException("closed");
        }
        int i2 = 0;
        a(0, settings.d() * 6, 4, 0);
        while (i2 < 10) {
            if (settings.c(i2)) {
                if (i2 != 4) {
                    i = i2 != 7 ? i2 : 4;
                } else {
                    i = 3;
                }
                this.sink.writeShort(i);
                this.sink.writeInt(settings.a(i2));
            }
            i2++;
        }
        this.sink.flush();
    }

    private final void b(int streamId, long byteCount) {
        while (byteCount > 0) {
            long jMin = Math.min(this.maxFrameSize, byteCount);
            byteCount -= jMin;
            a(streamId, (int) jMin, 9, byteCount == 0 ? 4 : 0);
            this.sink.a(this.hpackBuffer, jMin);
        }
    }

    public final synchronized void a(boolean outFinished, int streamId, sdk.pendo.io.s2.d source, int byteCount) {
        if (this.closed) {
            throw new IOException("closed");
        }
        a(streamId, outFinished ? 1 : 0, source, byteCount);
    }

    public final void a(int streamId, int flags, sdk.pendo.io.s2.d buffer, int byteCount) {
        a(streamId, byteCount, 0, flags);
        if (byteCount > 0) {
            sdk.pendo.io.s2.e eVar = this.sink;
            Intrinsics.checkNotNull(buffer);
            eVar.a(buffer, byteCount);
        }
    }

    public final void a(int streamId, int length, int type, int flags) {
        int i;
        int i2;
        int i3;
        int i4;
        Logger logger = h;
        if (logger.isLoggable(Level.FINE)) {
            i = streamId;
            i2 = length;
            i3 = type;
            i4 = flags;
            logger.fine(e.a.a(false, i, i2, i3, i4));
        } else {
            i = streamId;
            i2 = length;
            i3 = type;
            i4 = flags;
        }
        if (i2 > this.maxFrameSize) {
            throw new IllegalArgumentException(("FRAME_SIZE_ERROR length > " + this.maxFrameSize + ": " + i2).toString());
        }
        if ((Integer.MIN_VALUE & i) != 0) {
            throw new IllegalArgumentException(("reserved bit set: " + i).toString());
        }
        sdk.pendo.io.f2.b.a(this.sink, i2);
        this.sink.writeByte(i3 & 255);
        this.sink.writeByte(i4 & 255);
        this.sink.writeInt(Integer.MAX_VALUE & i);
    }

    public final synchronized void a(int lastGoodStreamId, b errorCode, byte[] debugData) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        Intrinsics.checkNotNullParameter(debugData, "debugData");
        if (this.closed) {
            throw new IOException("closed");
        }
        if (errorCode.getHttpCode() == -1) {
            throw new IllegalArgumentException("errorCode.httpCode == -1".toString());
        }
        a(0, debugData.length + 8, 7, 0);
        this.sink.writeInt(lastGoodStreamId);
        this.sink.writeInt(errorCode.getHttpCode());
        if (!(debugData.length == 0)) {
            this.sink.write(debugData);
        }
        this.sink.flush();
    }

    public final synchronized void a(boolean outFinished, int streamId, List<c> headerBlock) {
        Intrinsics.checkNotNullParameter(headerBlock, "headerBlock");
        if (this.closed) {
            throw new IOException("closed");
        }
        this.hpackWriter.a(headerBlock);
        long size = this.hpackBuffer.getSize();
        long jMin = Math.min(this.maxFrameSize, size);
        int i = size == jMin ? 4 : 0;
        if (outFinished) {
            i |= 1;
        }
        a(streamId, (int) jMin, 1, i);
        this.sink.a(this.hpackBuffer, jMin);
        if (size > jMin) {
            b(streamId, size - jMin);
        }
    }

    public final synchronized void a(boolean ack, int payload1, int payload2) {
        if (this.closed) {
            throw new IOException("closed");
        }
        a(0, 8, 6, ack ? 1 : 0);
        this.sink.writeInt(payload1);
        this.sink.writeInt(payload2);
        this.sink.flush();
    }

    public final synchronized void a(int streamId, int promisedStreamId, List<c> requestHeaders) {
        Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
        if (this.closed) {
            throw new IOException("closed");
        }
        this.hpackWriter.a(requestHeaders);
        long size = this.hpackBuffer.getSize();
        int iMin = (int) Math.min(((long) this.maxFrameSize) - 4, size);
        long j = iMin;
        a(streamId, iMin + 4, 5, size == j ? 4 : 0);
        this.sink.writeInt(promisedStreamId & Integer.MAX_VALUE);
        this.sink.a(this.hpackBuffer, j);
        if (size > j) {
            b(streamId, size - j);
        }
    }

    public final synchronized void a(int streamId, b errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        if (this.closed) {
            throw new IOException("closed");
        }
        if (errorCode.getHttpCode() == -1) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        a(streamId, 4, 3, 0);
        this.sink.writeInt(errorCode.getHttpCode());
        this.sink.flush();
    }

    public final synchronized void a(int streamId, long windowSizeIncrement) {
        if (this.closed) {
            throw new IOException("closed");
        }
        if (windowSizeIncrement == 0 || windowSizeIncrement > SieveCacheKt.NodeLinkMask) {
            throw new IllegalArgumentException(("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + windowSizeIncrement).toString());
        }
        a(streamId, 4, 8, 0);
        this.sink.writeInt((int) windowSizeIncrement);
        this.sink.flush();
    }
}
