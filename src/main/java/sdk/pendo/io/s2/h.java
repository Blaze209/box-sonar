package sdk.pendo.io.s2;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.microsoft.identity.common.nativeauth.internal.commands.ResetPasswordSubmitNewPasswordCommand;
import java.io.IOException;
import java.util.zip.Deflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.hc.core5.http.HeaderElements;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0001\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u001b\u0010\u001cB\u0019\b\u0000\u0012\u0006\u0010\u0013\u001a\u00020\u0011\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u001b\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\u000f\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0005\u0010\u000bJ\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016R\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001e"}, d2 = {"Lsdk/pendo/io/s2/h;", "Lsdk/pendo/io/s2/y;", "", "syncFlush", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/s2/d;", "source", "", "byteCount", "flush", "()V", HeaderElements.CLOSE, "Lsdk/pendo/io/s2/b0;", ResetPasswordSubmitNewPasswordCommand.POLL_COMPLETION_TIMEOUT_ERROR_CODE, "", "toString", "Lsdk/pendo/io/s2/e;", "Lsdk/pendo/io/s2/e;", "sink", "Ljava/util/zip/Deflater;", "b", "Ljava/util/zip/Deflater;", "deflater", "c", "Z", "closed", "<init>", "(Lokio/Sink;Ljava/util/zip/Deflater;)V", "(Lokio/BufferedSink;Ljava/util/zip/Deflater;)V", "external.sdk.pendo.io.okio"}, k = 1, mv = {1, 9, 0})
public final class h implements y {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final e sink;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final Deflater deflater;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private boolean closed;

    public h(e sink, Deflater deflater) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        Intrinsics.checkNotNullParameter(deflater, "deflater");
        this.sink = sink;
        this.deflater = deflater;
    }

    private final void a(boolean syncFlush) throws IOException {
        v vVarB;
        int iDeflate;
        d bufferField = this.sink.getBufferField();
        while (true) {
            vVarB = bufferField.b(1);
            if (syncFlush) {
                try {
                    Deflater deflater = this.deflater;
                    byte[] bArr = vVarB.data;
                    int i = vVarB.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String;
                    iDeflate = deflater.deflate(bArr, i, 8192 - i, 2);
                } catch (NullPointerException e) {
                    throw new IOException("Deflater already closed", e);
                }
            } else {
                Deflater deflater2 = this.deflater;
                byte[] bArr2 = vVarB.data;
                int i2 = vVarB.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String;
                iDeflate = deflater2.deflate(bArr2, i2, 8192 - i2);
            }
            if (iDeflate > 0) {
                vVarB.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String += iDeflate;
                bufferField.b(bufferField.getSize() + ((long) iDeflate));
                this.sink.emitCompleteSegments();
            } else if (this.deflater.needsInput()) {
                break;
            }
        }
        if (vVarB.pos == vVarB.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String) {
            bufferField.head = vVarB.b();
            w.a(vVarB);
        }
    }

    @Override // sdk.pendo.io.s2.y, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.closed) {
            return;
        }
        a();
        th = null;
        try {
            this.deflater.end();
        } catch (Throwable th) {
            if (th == null) {
                th = th;
            }
        }
        try {
            this.sink.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.closed = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // sdk.pendo.io.s2.y, java.io.Flushable
    public void flush() throws IOException {
        a(true);
        this.sink.flush();
    }

    @Override // sdk.pendo.io.s2.y
    /* JADX INFO: renamed from: timeout */
    public b0 getTimeout() {
        return this.sink.getTimeout();
    }

    public String toString() {
        return "DeflaterSink(" + this.sink + ')';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h(y sink, Deflater deflater) {
        this(o.a(sink), deflater);
        Intrinsics.checkNotNullParameter(sink, "sink");
        Intrinsics.checkNotNullParameter(deflater, "deflater");
    }

    public final void a() throws IOException {
        this.deflater.finish();
        a(false);
    }

    @Override // sdk.pendo.io.s2.y
    public void a(d source, long byteCount) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        b.a(source.getSize(), 0L, byteCount);
        while (byteCount > 0) {
            v vVar = source.head;
            Intrinsics.checkNotNull(vVar);
            int iMin = (int) Math.min(byteCount, vVar.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String - vVar.pos);
            this.deflater.setInput(vVar.data, vVar.pos, iMin);
            a(false);
            long j = iMin;
            source.b(source.getSize() - j);
            int i = vVar.pos + iMin;
            vVar.pos = i;
            if (i == vVar.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String) {
                source.head = vVar.b();
                w.a(vVar);
            }
            byteCount -= j;
        }
    }
}
