package sdk.pendo.io.s2;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.microsoft.identity.common.nativeauth.internal.commands.ResetPasswordSubmitNewPasswordCommand;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.hc.core5.http.HeaderElements;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u0001\u0012\u0006\u0010\u0013\u001a\u00020\u0011¢\u0006\u0004\b\u001a\u0010\u001bB\u0019\b\u0000\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u0011¢\u0006\u0004\b\u001a\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0016\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\tJ\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016R\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0018¨\u0006\u001d"}, d2 = {"Lsdk/pendo/io/s2/m;", "Lsdk/pendo/io/s2/a0;", "", "b", "Lsdk/pendo/io/s2/d;", "sink", "", "byteCount", "d", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/s2/b0;", ResetPasswordSubmitNewPasswordCommand.POLL_COMPLETION_TIMEOUT_ERROR_CODE, HeaderElements.CLOSE, "Lsdk/pendo/io/s2/f;", "Lsdk/pendo/io/s2/f;", "source", "Ljava/util/zip/Inflater;", "Ljava/util/zip/Inflater;", "inflater", "", "c", "I", "bufferBytesHeldByInflater", "Z", "closed", "<init>", "(Lokio/Source;Ljava/util/zip/Inflater;)V", "(Lokio/BufferedSource;Ljava/util/zip/Inflater;)V", "external.sdk.pendo.io.okio"}, k = 1, mv = {1, 9, 0})
public final class m implements a0 {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final f source;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final Inflater inflater;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private int bufferBytesHeldByInflater;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private boolean closed;

    public m(f source, Inflater inflater) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this.source = source;
        this.inflater = inflater;
    }

    public final boolean a() {
        if (!this.inflater.needsInput()) {
            return false;
        }
        if (this.source.exhausted()) {
            return true;
        }
        v vVar = this.source.getBuffer().head;
        Intrinsics.checkNotNull(vVar);
        int i = vVar.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String;
        int i2 = vVar.pos;
        int i3 = i - i2;
        this.bufferBytesHeldByInflater = i3;
        this.inflater.setInput(vVar.data, i2, i3);
        return false;
    }

    @Override // sdk.pendo.io.s2.a0
    public long b(d sink, long byteCount) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        do {
            long jD = d(sink, byteCount);
            if (jD > 0) {
                return jD;
            }
            if (this.inflater.finished() || this.inflater.needsDictionary()) {
                return -1L;
            }
        } while (!this.source.exhausted());
        throw new EOFException("source exhausted prematurely");
    }

    @Override // sdk.pendo.io.s2.a0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.closed) {
            return;
        }
        this.inflater.end();
        this.closed = true;
        this.source.close();
    }

    public final long d(d sink, long byteCount) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (byteCount < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
        }
        if (this.closed) {
            throw new IllegalStateException("closed".toString());
        }
        if (byteCount == 0) {
            return 0L;
        }
        try {
            v vVarB = sink.b(1);
            int iMin = (int) Math.min(byteCount, 8192 - vVarB.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String);
            a();
            int iInflate = this.inflater.inflate(vVarB.data, vVarB.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String, iMin);
            b();
            if (iInflate > 0) {
                vVarB.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String += iInflate;
                long j = iInflate;
                sink.b(sink.getSize() + j);
                return j;
            }
            if (vVarB.pos == vVarB.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String) {
                sink.head = vVarB.b();
                w.a(vVarB);
            }
            return 0L;
        } catch (DataFormatException e) {
            throw new IOException(e);
        }
    }

    @Override // sdk.pendo.io.s2.a0
    /* JADX INFO: renamed from: timeout */
    public b0 getTimeout() {
        return this.source.getTimeout();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public m(a0 source, Inflater inflater) {
        this(o.a(source), inflater);
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
    }

    private final void b() {
        int i = this.bufferBytesHeldByInflater;
        if (i == 0) {
            return;
        }
        int remaining = i - this.inflater.getRemaining();
        this.bufferBytesHeldByInflater -= remaining;
        this.source.skip(remaining);
    }
}
