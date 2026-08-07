package sdk.pendo.io.s2;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.box.androidsdk.content.models.BoxIterator;
import com.microsoft.identity.common.nativeauth.internal.commands.ResetPasswordSubmitNewPasswordCommand;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.Typography;
import org.apache.hc.core5.http.HeaderElements;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00105\u001a\u000203¢\u0006\u0004\b?\u0010@J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0017H\u0016J\u0018\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u001aH\u0016J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\u001f\u001a\u00020\u001dH\u0016J\u0010\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u0004H\u0016J\b\u0010\"\u001a\u00020!H\u0016J\b\u0010#\u001a\u00020!H\u0016J\b\u0010$\u001a\u00020\u0012H\u0016J\b\u0010%\u001a\u00020\u0012H\u0016J\b\u0010&\u001a\u00020\u0004H\u0016J\b\u0010'\u001a\u00020\u0004H\u0016J\u0010\u0010(\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010)\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\fH\u0016J \u0010)\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\f2\u0006\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0004H\u0016J\b\u0010-\u001a\u00020,H\u0016J\b\u0010.\u001a\u00020\u0007H\u0016J\b\u0010/\u001a\u00020\tH\u0016J\b\u00101\u001a\u000200H\u0016J\b\u00102\u001a\u00020\u001dH\u0016R\u0014\u00105\u001a\u0002038\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0013\u00104R\u0014\u00107\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0006\u00106R\u0016\u00109\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0019\u00108R\u001b\u0010>\u001a\u00020\u00028Ö\u0002X\u0096\u0004¢\u0006\f\u0012\u0004\b<\u0010=\u001a\u0004\b:\u0010;¨\u0006A"}, d2 = {"Lsdk/pendo/io/s2/u;", "Lsdk/pendo/io/s2/f;", "Lsdk/pendo/io/s2/d;", "sink", "", "byteCount", "b", "", "exhausted", "", "require", "request", "", "readByte", "Lsdk/pendo/io/s2/g;", "readByteString", "Lsdk/pendo/io/s2/r;", "options", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", "readByteArray", "readFully", "Ljava/nio/ByteBuffer;", "read", "c", "Lsdk/pendo/io/s2/y;", "Ljava/nio/charset/Charset;", "charset", "", "readString", "readUtf8LineStrict", BoxIterator.FIELD_LIMIT, "", "readShort", "readShortLe", "readInt", "readIntLe", "readLong", "readHexadecimalUnsignedLong", "skip", "indexOf", "fromIndex", "toIndex", "Ljava/io/InputStream;", "inputStream", "isOpen", HeaderElements.CLOSE, "Lsdk/pendo/io/s2/b0;", ResetPasswordSubmitNewPasswordCommand.POLL_COMPLETION_TIMEOUT_ERROR_CODE, "toString", "Lsdk/pendo/io/s2/a0;", "Lsdk/pendo/io/s2/a0;", "source", "Lsdk/pendo/io/s2/d;", "bufferField", "Z", "closed", "getBuffer", "()Lokio/Buffer;", "getBuffer$annotations", "()V", "buffer", "<init>", "(Lokio/Source;)V", "external.sdk.pendo.io.okio"}, k = 1, mv = {1, 9, 0})
public final class u implements f {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final a0 source;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final d bufferField;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public boolean closed;

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016¨\u0006\r"}, d2 = {"sdk/pendo/io/s2/u$a", "Ljava/io/InputStream;", "", "read", "", "data", "offset", "byteCount", "available", "", HeaderElements.CLOSE, "", "toString", "external.sdk.pendo.io.okio"}, k = 1, mv = {1, 9, 0})
    public static final class a extends InputStream {
        a() {
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            u uVar = u.this;
            if (uVar.closed) {
                throw new IOException("closed");
            }
            return (int) Math.min(uVar.bufferField.getSize(), Integer.MAX_VALUE);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws EOFException {
            u.this.close();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            u uVar = u.this;
            if (uVar.closed) {
                throw new IOException("closed");
            }
            if (uVar.bufferField.getSize() == 0) {
                u uVar2 = u.this;
                if (uVar2.source.b(uVar2.bufferField, 8192L) == -1) {
                    return -1;
                }
            }
            return u.this.bufferField.readByte() & 255;
        }

        public String toString() {
            return u.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] data, int offset, int byteCount) throws IOException {
            Intrinsics.checkNotNullParameter(data, "data");
            if (u.this.closed) {
                throw new IOException("closed");
            }
            b.a(data.length, offset, byteCount);
            if (u.this.bufferField.getSize() == 0) {
                u uVar = u.this;
                if (uVar.source.b(uVar.bufferField, 8192L) == -1) {
                    return -1;
                }
            }
            return u.this.bufferField.read(data, offset, byteCount);
        }
    }

    public u(a0 source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.source = source;
        this.bufferField = new d();
    }

    @Override // sdk.pendo.io.s2.f
    public long a(y sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        long j = 0;
        while (this.source.b(this.bufferField, 8192L) != -1) {
            long jC = this.bufferField.c();
            if (jC > 0) {
                j += jC;
                sink.a(this.bufferField, jC);
            }
        }
        if (this.bufferField.getSize() <= 0) {
            return j;
        }
        long size = j + this.bufferField.getSize();
        d dVar = this.bufferField;
        sink.a(dVar, dVar.getSize());
        return size;
    }

    @Override // sdk.pendo.io.s2.a0
    public long b(d sink, long byteCount) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (byteCount < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
        }
        if (this.closed) {
            throw new IllegalStateException("closed".toString());
        }
        if (this.bufferField.getSize() == 0 && this.source.b(this.bufferField, 8192L) == -1) {
            return -1L;
        }
        return this.bufferField.b(sink, Math.min(byteCount, this.bufferField.getSize()));
    }

    @Override // sdk.pendo.io.s2.f
    public void c(d sink, long byteCount) throws EOFException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        try {
            require(byteCount);
            this.bufferField.c(sink, byteCount);
        } catch (EOFException e) {
            sink.a((a0) this.bufferField);
            throw e;
        }
    }

    @Override // sdk.pendo.io.s2.a0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws EOFException {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.source.close();
        this.bufferField.a();
    }

    @Override // sdk.pendo.io.s2.f
    public boolean exhausted() {
        if (this.closed) {
            throw new IllegalStateException("closed".toString());
        }
        return this.bufferField.exhausted() && this.source.b(this.bufferField, 8192L) == -1;
    }

    @Override // sdk.pendo.io.s2.f, sdk.pendo.io.s2.e
    /* JADX INFO: renamed from: getBuffer, reason: from getter */
    public d getBufferField() {
        return this.bufferField;
    }

    public long indexOf(byte b) {
        return indexOf(b, 0L, Long.MAX_VALUE);
    }

    @Override // sdk.pendo.io.s2.f
    public InputStream inputStream() {
        return new a();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.closed;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (this.bufferField.getSize() == 0 && this.source.b(this.bufferField, 8192L) == -1) {
            return -1;
        }
        return this.bufferField.read(sink);
    }

    @Override // sdk.pendo.io.s2.f
    public byte readByte() throws EOFException {
        require(1L);
        return this.bufferField.readByte();
    }

    @Override // sdk.pendo.io.s2.f
    public byte[] readByteArray() {
        this.bufferField.a(this.source);
        return this.bufferField.readByteArray();
    }

    @Override // sdk.pendo.io.s2.f
    public g readByteString(long byteCount) throws EOFException {
        require(byteCount);
        return this.bufferField.readByteString(byteCount);
    }

    @Override // sdk.pendo.io.s2.f
    public void readFully(byte[] sink) throws EOFException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        try {
            require(sink.length);
            this.bufferField.readFully(sink);
        } catch (EOFException e) {
            int i = 0;
            while (this.bufferField.getSize() > 0) {
                d dVar = this.bufferField;
                int i2 = dVar.read(sink, i, (int) dVar.getSize());
                if (i2 == -1) {
                    throw new AssertionError();
                }
                i += i2;
            }
            throw e;
        }
    }

    @Override // sdk.pendo.io.s2.f
    public long readHexadecimalUnsignedLong() throws EOFException {
        require(1L);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!request(i2)) {
                break;
            }
            byte bA = this.bufferField.a(i);
            if ((bA < 48 || bA > 57) && ((bA < 97 || bA > 102) && (bA < 65 || bA > 70))) {
                if (i != 0) {
                    break;
                }
                StringBuilder sb = new StringBuilder("Expected leading [0-9a-fA-F] character but was 0x");
                String string = Integer.toString(bA, CharsKt.checkRadix(CharsKt.checkRadix(16)));
                Intrinsics.checkNotNullExpressionValue(string, "toString(this, checkRadix(radix))");
                throw new NumberFormatException(sb.append(string).toString());
            }
            i = i2;
        }
        return this.bufferField.readHexadecimalUnsignedLong();
    }

    @Override // sdk.pendo.io.s2.f
    public int readInt() throws EOFException {
        require(4L);
        return this.bufferField.readInt();
    }

    public int readIntLe() throws EOFException {
        require(4L);
        return this.bufferField.readIntLe();
    }

    @Override // sdk.pendo.io.s2.f
    public long readLong() throws EOFException {
        require(8L);
        return this.bufferField.readLong();
    }

    @Override // sdk.pendo.io.s2.f
    public short readShort() throws EOFException {
        require(2L);
        return this.bufferField.readShort();
    }

    public short readShortLe() throws EOFException {
        require(2L);
        return this.bufferField.readShortLe();
    }

    @Override // sdk.pendo.io.s2.f
    public String readString(Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        this.bufferField.a(this.source);
        return this.bufferField.readString(charset);
    }

    @Override // sdk.pendo.io.s2.f
    public String readUtf8LineStrict() {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    @Override // sdk.pendo.io.s2.f
    public boolean request(long byteCount) {
        if (byteCount < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
        }
        if (this.closed) {
            throw new IllegalStateException("closed".toString());
        }
        while (this.bufferField.getSize() < byteCount) {
            if (this.source.b(this.bufferField, 8192L) == -1) {
                return false;
            }
        }
        return true;
    }

    @Override // sdk.pendo.io.s2.f
    public void require(long byteCount) throws EOFException {
        if (!request(byteCount)) {
            throw new EOFException();
        }
    }

    @Override // sdk.pendo.io.s2.f
    public void skip(long byteCount) throws EOFException {
        if (this.closed) {
            throw new IllegalStateException("closed".toString());
        }
        while (byteCount > 0) {
            if (this.bufferField.getSize() == 0 && this.source.b(this.bufferField, 8192L) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(byteCount, this.bufferField.getSize());
            this.bufferField.skip(jMin);
            byteCount -= jMin;
        }
    }

    @Override // sdk.pendo.io.s2.a0
    /* JADX INFO: renamed from: timeout */
    public b0 getTimeout() {
        return this.source.getTimeout();
    }

    public String toString() {
        return "buffer(" + this.source + ')';
    }

    @Override // sdk.pendo.io.s2.f
    public int a(r options) throws EOFException {
        Intrinsics.checkNotNullParameter(options, "options");
        if (this.closed) {
            throw new IllegalStateException("closed".toString());
        }
        do {
            int iA = sdk.pendo.io.t2.a.a(this.bufferField, options, true);
            if (iA != -2) {
                if (iA == -1) {
                    break;
                }
                this.bufferField.skip(options.getByteStrings()[iA].j());
                return iA;
            }
        } while (this.source.b(this.bufferField, 8192L) != -1);
        return -1;
    }

    public long indexOf(byte b, long fromIndex, long toIndex) {
        if (this.closed) {
            throw new IllegalStateException("closed".toString());
        }
        if (0 > fromIndex || fromIndex > toIndex) {
            throw new IllegalArgumentException(("fromIndex=" + fromIndex + " toIndex=" + toIndex).toString());
        }
        long jMax = fromIndex;
        while (jMax < toIndex) {
            byte b2 = b;
            long j = toIndex;
            long jIndexOf = this.bufferField.indexOf(b2, jMax, j);
            if (jIndexOf != -1) {
                return jIndexOf;
            }
            long size = this.bufferField.getSize();
            if (size >= j || this.source.b(this.bufferField, 8192L) == -1) {
                break;
            }
            jMax = Math.max(jMax, size);
            b = b2;
            toIndex = j;
        }
        return -1L;
    }

    @Override // sdk.pendo.io.s2.f
    public byte[] readByteArray(long byteCount) throws EOFException {
        require(byteCount);
        return this.bufferField.readByteArray(byteCount);
    }

    @Override // sdk.pendo.io.s2.f
    public String readUtf8LineStrict(long limit) throws EOFException {
        if (limit < 0) {
            throw new IllegalArgumentException(("limit < 0: " + limit).toString());
        }
        long j = limit == Long.MAX_VALUE ? Long.MAX_VALUE : limit + 1;
        long jIndexOf = indexOf((byte) 10, 0L, j);
        if (jIndexOf != -1) {
            return sdk.pendo.io.t2.a.a(this.bufferField, jIndexOf);
        }
        if (j < Long.MAX_VALUE && request(j) && this.bufferField.a(j - 1) == 13 && request(j + 1) && this.bufferField.a(j) == 10) {
            return sdk.pendo.io.t2.a.a(this.bufferField, j);
        }
        d dVar = new d();
        d dVar2 = this.bufferField;
        dVar2.a(dVar, 0L, Math.min(32, dVar2.getSize()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.bufferField.getSize(), limit) + " content=" + dVar.g().f() + Typography.ellipsis);
    }
}
