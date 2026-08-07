package sdk.pendo.io.s2;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.microsoft.identity.common.nativeauth.internal.commands.ResetPasswordSubmitNewPasswordCommand;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.hc.core5.http.HeaderElements;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010&\u001a\u00020$¢\u0006\u0004\b1\u00102J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0007\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\rH\u0016J \u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u000fH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0011H\u0016J\u0010\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u0010\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u000fH\u0016J\u0010\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u000fH\u0016J\u0010\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0004H\u0016J\u0010\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0004H\u0016J\b\u0010\u001b\u001a\u00020\u0001H\u0016J\b\u0010\u001c\u001a\u00020\u0001H\u0016J\b\u0010\u001d\u001a\u00020\u0006H\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\b\u0010 \u001a\u00020\u0006H\u0016J\b\u0010\"\u001a\u00020!H\u0016J\b\u0010#\u001a\u00020\nH\u0016R\u0014\u0010&\u001a\u00020$8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010%R\u0014\u0010(\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010'R\u0016\u0010+\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u001b\u00100\u001a\u00020\u00028Ö\u0002X\u0096\u0004¢\u0006\f\u0012\u0004\b.\u0010/\u001a\u0004\b,\u0010-¨\u00063"}, d2 = {"Lsdk/pendo/io/s2/t;", "Lsdk/pendo/io/s2/e;", "Lsdk/pendo/io/s2/d;", "source", "", "byteCount", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/s2/g;", "byteString", "", "string", "writeUtf8", "", "write", "", "offset", "Ljava/nio/ByteBuffer;", "b", "writeByte", "s", "writeShort", "i", "writeInt", "v", "writeDecimalLong", "writeHexadecimalUnsignedLong", "emitCompleteSegments", "emit", "flush", "", "isOpen", HeaderElements.CLOSE, "Lsdk/pendo/io/s2/b0;", ResetPasswordSubmitNewPasswordCommand.POLL_COMPLETION_TIMEOUT_ERROR_CODE, "toString", "Lsdk/pendo/io/s2/y;", "Lsdk/pendo/io/s2/y;", "sink", "Lsdk/pendo/io/s2/d;", "bufferField", "c", "Z", "closed", "getBuffer", "()Lokio/Buffer;", "getBuffer$annotations", "()V", "buffer", "<init>", "(Lokio/Sink;)V", "external.sdk.pendo.io.okio"}, k = 1, mv = {1, 9, 0})
public final class t implements e {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final y sink;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final d bufferField;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public boolean closed;

    public t(y sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        this.sink = sink;
        this.bufferField = new d();
    }

    @Override // sdk.pendo.io.s2.e
    public e a(g byteString) {
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        if (this.closed) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.a(byteString);
        return emitCompleteSegments();
    }

    @Override // sdk.pendo.io.s2.y, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.closed) {
            return;
        }
        if (this.bufferField.getSize() > 0) {
            y yVar = this.sink;
            d dVar = this.bufferField;
            yVar.a(dVar, dVar.getSize());
        }
        th = null;
        try {
            this.sink.close();
        } catch (Throwable th) {
            if (th == null) {
                th = th;
            }
        }
        this.closed = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // sdk.pendo.io.s2.e
    public e emit() {
        if (this.closed) {
            throw new IllegalStateException("closed".toString());
        }
        long size = this.bufferField.getSize();
        if (size > 0) {
            this.sink.a(this.bufferField, size);
        }
        return this;
    }

    @Override // sdk.pendo.io.s2.e
    public e emitCompleteSegments() {
        if (this.closed) {
            throw new IllegalStateException("closed".toString());
        }
        long jC = this.bufferField.c();
        if (jC > 0) {
            this.sink.a(this.bufferField, jC);
        }
        return this;
    }

    @Override // sdk.pendo.io.s2.e, sdk.pendo.io.s2.y, java.io.Flushable
    public void flush() {
        if (this.closed) {
            throw new IllegalStateException("closed".toString());
        }
        if (this.bufferField.getSize() > 0) {
            y yVar = this.sink;
            d dVar = this.bufferField;
            yVar.a(dVar, dVar.getSize());
        }
        this.sink.flush();
    }

    @Override // sdk.pendo.io.s2.e
    /* JADX INFO: renamed from: getBuffer, reason: from getter */
    public d getBufferField() {
        return this.bufferField;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.closed;
    }

    @Override // sdk.pendo.io.s2.y
    /* JADX INFO: renamed from: timeout */
    public b0 getTimeout() {
        return this.sink.getTimeout();
    }

    public String toString() {
        return "buffer(" + this.sink + ')';
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer source) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (this.closed) {
            throw new IllegalStateException("closed".toString());
        }
        int iWrite = this.bufferField.write(source);
        emitCompleteSegments();
        return iWrite;
    }

    @Override // sdk.pendo.io.s2.e
    public e writeByte(int b) {
        if (this.closed) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeByte(b);
        return emitCompleteSegments();
    }

    @Override // sdk.pendo.io.s2.e
    public e writeDecimalLong(long v) {
        if (this.closed) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeDecimalLong(v);
        return emitCompleteSegments();
    }

    @Override // sdk.pendo.io.s2.e
    public e writeHexadecimalUnsignedLong(long v) {
        if (this.closed) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeHexadecimalUnsignedLong(v);
        return emitCompleteSegments();
    }

    @Override // sdk.pendo.io.s2.e
    public e writeInt(int i) {
        if (this.closed) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeInt(i);
        return emitCompleteSegments();
    }

    @Override // sdk.pendo.io.s2.e
    public e writeShort(int s) {
        if (this.closed) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeShort(s);
        return emitCompleteSegments();
    }

    @Override // sdk.pendo.io.s2.e
    public e writeUtf8(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        if (this.closed) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeUtf8(string);
        return emitCompleteSegments();
    }

    @Override // sdk.pendo.io.s2.y
    public void a(d source, long byteCount) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (this.closed) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.a(source, byteCount);
        emitCompleteSegments();
    }

    @Override // sdk.pendo.io.s2.e
    public e write(byte[] source) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (this.closed) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.write(source);
        return emitCompleteSegments();
    }

    @Override // sdk.pendo.io.s2.e
    public e write(byte[] source, int offset, int byteCount) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (this.closed) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.write(source, offset, byteCount);
        return emitCompleteSegments();
    }
}
