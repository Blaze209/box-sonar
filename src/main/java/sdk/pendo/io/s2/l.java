package sdk.pendo.io.s2;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.microsoft.identity.common.nativeauth.internal.commands.ResetPasswordSubmitNewPasswordCommand;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
import org.apache.hc.core5.http.HeaderElements;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0001¢\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J \u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002J \u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002J\u0018\u0010\u0004\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016R\u0016\u0010\u0015\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lsdk/pendo/io/s2/l;", "Lsdk/pendo/io/s2/a0;", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "b", "Lsdk/pendo/io/s2/d;", "buffer", "", "offset", "byteCount", "", "name", "", "expected", "actual", "sink", "Lsdk/pendo/io/s2/b0;", ResetPasswordSubmitNewPasswordCommand.POLL_COMPLETION_TIMEOUT_ERROR_CODE, HeaderElements.CLOSE, "", "B", "section", "Lsdk/pendo/io/s2/u;", "Lsdk/pendo/io/s2/u;", "source", "Ljava/util/zip/Inflater;", "c", "Ljava/util/zip/Inflater;", "inflater", "Lsdk/pendo/io/s2/m;", "d", "Lsdk/pendo/io/s2/m;", "inflaterSource", "Ljava/util/zip/CRC32;", "e", "Ljava/util/zip/CRC32;", "crc", "<init>", "(Lokio/Source;)V", "external.sdk.pendo.io.okio"}, k = 1, mv = {1, 9, 0})
public final class l implements a0 {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private byte section;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final u source;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final Inflater inflater;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final m inflaterSource;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final CRC32 crc;

    public l(a0 source) {
        Intrinsics.checkNotNullParameter(source, "source");
        u uVar = new u(source);
        this.source = uVar;
        Inflater inflater = new Inflater(true);
        this.inflater = inflater;
        this.inflaterSource = new m((f) uVar, inflater);
        this.crc = new CRC32();
    }

    private final void a(String name, int expected, int actual) throws IOException {
        if (actual == expected) {
            return;
        }
        String str = String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{name, Integer.valueOf(actual), Integer.valueOf(expected)}, 3));
        Intrinsics.checkNotNullExpressionValue(str, "format(this, *args)");
        throw new IOException(str);
    }

    private final void b() throws IOException {
        a("CRC", this.source.readIntLe(), (int) this.crc.getValue());
        a("ISIZE", this.source.readIntLe(), (int) this.inflater.getBytesWritten());
    }

    @Override // sdk.pendo.io.s2.a0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.inflaterSource.close();
    }

    @Override // sdk.pendo.io.s2.a0
    /* JADX INFO: renamed from: timeout */
    public b0 getTimeout() {
        return this.source.getTimeout();
    }

    private final void a() throws IOException {
        this.source.require(10L);
        byte bA = this.source.bufferField.a(3L);
        boolean z = ((bA >> 1) & 1) == 1;
        if (z) {
            a(this.source.bufferField, 0L, 10L);
        }
        a("ID1ID2", 8075, this.source.readShort());
        this.source.skip(8L);
        if (((bA >> 2) & 1) == 1) {
            this.source.require(2L);
            if (z) {
                a(this.source.bufferField, 0L, 2L);
            }
            long shortLe = this.source.bufferField.readShortLe() & UShort.MAX_VALUE;
            this.source.require(shortLe);
            if (z) {
                a(this.source.bufferField, 0L, shortLe);
            }
            this.source.skip(shortLe);
        }
        if (((bA >> 3) & 1) == 1) {
            long jIndexOf = this.source.indexOf((byte) 0);
            if (jIndexOf == -1) {
                throw new EOFException();
            }
            if (z) {
                a(this.source.bufferField, 0L, jIndexOf + 1);
            }
            this.source.skip(jIndexOf + 1);
        }
        if (((bA >> 4) & 1) == 1) {
            long jIndexOf2 = this.source.indexOf((byte) 0);
            if (jIndexOf2 == -1) {
                throw new EOFException();
            }
            if (z) {
                a(this.source.bufferField, 0L, jIndexOf2 + 1);
            }
            this.source.skip(jIndexOf2 + 1);
        }
        if (z) {
            a("FHCRC", this.source.readShortLe(), (short) this.crc.getValue());
            this.crc.reset();
        }
    }

    @Override // sdk.pendo.io.s2.a0
    public long b(d sink, long byteCount) throws IOException {
        l lVar;
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (byteCount < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
        }
        if (byteCount == 0) {
            return 0L;
        }
        if (this.section == 0) {
            a();
            this.section = (byte) 1;
        }
        if (this.section == 1) {
            long size = sink.getSize();
            long jB = this.inflaterSource.b(sink, byteCount);
            lVar = this;
            if (jB != -1) {
                lVar.a(sink, size, jB);
                return jB;
            }
            lVar.section = (byte) 2;
        } else {
            lVar = this;
        }
        if (lVar.section == 2) {
            lVar.b();
            lVar.section = (byte) 3;
            if (!lVar.source.exhausted()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    private final void a(d buffer, long offset, long byteCount) {
        v vVar = buffer.head;
        while (true) {
            Intrinsics.checkNotNull(vVar);
            long j = vVar.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String - vVar.pos;
            if (offset < j) {
                break;
            }
            offset -= j;
            vVar = vVar.external.sdk.pendo.io.mozilla.javascript.ES6Iterator.NEXT_METHOD java.lang.String;
        }
        while (byteCount > 0) {
            int i = (int) (((long) vVar.pos) + offset);
            int iMin = (int) Math.min(vVar.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String - i, byteCount);
            this.crc.update(vVar.data, i, iMin);
            byteCount -= (long) iMin;
            vVar = vVar.external.sdk.pendo.io.mozilla.javascript.ES6Iterator.NEXT_METHOD java.lang.String;
            Intrinsics.checkNotNull(vVar);
            offset = 0;
        }
    }
}
