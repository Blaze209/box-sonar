package sdk.pendo.io.s2;

import androidx.collection.SieveCacheKt;
import androidx.media3.common.C;
import androidx.media3.exoplayer.MediaPeriodQueue;
import androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.ts.PsExtractor;
import com.box.android.data.jobs.DownloadFileJobKt;
import com.box.androidsdk.content.models.BoxIterator;
import com.google.common.base.Ascii;
import com.microsoft.identity.common.nativeauth.internal.commands.ResetPasswordSubmitNewPasswordCommand;
import com.yubico.yubikit.core.fido.CtapException;
import java.io.Closeable;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Typography;
import okhttp3.internal.connection.RealConnection;
import okio.Utf8;
import org.apache.hc.core5.http.HeaderElements;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\u0014B\u0007¢\u0006\u0004\bd\u0010eJ\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0000H\u0016J\b\u0010\b\u001a\u00020\u0000H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J \u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u0015\u001a\u00020\u000bJ\b\u0010\u0017\u001a\u00020\u0016H\u0016J\u0018\u0010\u0014\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u000bH\u0087\u0002¢\u0006\u0004\b\u0014\u0010\u0019J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001e\u001a\u00020\u000bH\u0016J\b\u0010\u001f\u001a\u00020\u001aH\u0016J\b\u0010 \u001a\u00020\u001cH\u0016J\b\u0010!\u001a\u00020\u000bH\u0016J\b\u0010#\u001a\u00020\"H\u0016J\u0010\u0010$\u001a\u00020\"2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0014\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020%H\u0016J\u0018\u0010\u0015\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020(H\u0016J\b\u0010*\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020)2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010-\u001a\u00020)2\u0006\u0010,\u001a\u00020+H\u0016J\u0018\u0010-\u001a\u00020)2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020+H\u0016J\b\u0010.\u001a\u00020)H\u0016J\u0010\u0010.\u001a\u00020)2\u0006\u0010/\u001a\u00020\u000bH\u0016J\b\u00100\u001a\u00020\u001cH\u0016J\b\u00102\u001a\u000201H\u0016J\u0010\u00102\u001a\u0002012\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u00103\u001a\u00020\r2\u0006\u0010'\u001a\u000201H\u0016J \u00104\u001a\u00020\u001c2\u0006\u0010'\u001a\u0002012\u0006\u0010\u0013\u001a\u00020\u001c2\u0006\u0010\f\u001a\u00020\u001cH\u0016J\u0010\u00104\u001a\u00020\u001c2\u0006\u0010'\u001a\u000205H\u0016J\u0006\u0010\u0014\u001a\u00020\rJ\u0010\u00106\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0015\u001a\u00020\u00002\u0006\u00107\u001a\u00020\"H\u0016J\u0010\u0010\u0014\u001a\u00020\u00002\u0006\u00108\u001a\u00020)H\u0016J \u0010\u0014\u001a\u00020\u00002\u0006\u00108\u001a\u00020)2\u0006\u00109\u001a\u00020\u001c2\u0006\u0010:\u001a\u00020\u001cH\u0016J\u0010\u0010\u0007\u001a\u00020\u00002\u0006\u0010;\u001a\u00020\u001cH\u0016J\u0018\u0010\u0014\u001a\u00020\u00002\u0006\u00108\u001a\u00020)2\u0006\u0010,\u001a\u00020+H\u0016J(\u0010\u0014\u001a\u00020\u00002\u0006\u00108\u001a\u00020)2\u0006\u00109\u001a\u00020\u001c2\u0006\u0010:\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020+H\u0016J\u0010\u0010\u0014\u001a\u00020\u00002\u0006\u0010<\u001a\u000201H\u0016J \u0010\u0014\u001a\u00020\u00002\u0006\u0010<\u001a\u0002012\u0006\u0010\u0013\u001a\u00020\u001c2\u0006\u0010\f\u001a\u00020\u001cH\u0016J\u0010\u0010=\u001a\u00020\u001c2\u0006\u0010<\u001a\u000205H\u0016J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020>H\u0016J\u0010\u0010\u0015\u001a\u00020\u00002\u0006\u0010?\u001a\u00020\u001cH\u0016J\u0010\u0010\b\u001a\u00020\u00002\u0006\u0010@\u001a\u00020\u001cH\u0016J\u0010\u0010B\u001a\u00020\u00002\u0006\u0010A\u001a\u00020\u001cH\u0016J\u0010\u0010\b\u001a\u00020\u00002\u0006\u0010C\u001a\u00020\u000bH\u0016J\u0010\u0010\u0015\u001a\u00020\u00002\u0006\u0010C\u001a\u00020\u000bH\u0016J\u0010\u0010B\u001a\u00020\u00002\u0006\u0010C\u001a\u00020\u000bH\u0016J\u0017\u0010?\u001a\u00020E2\u0006\u0010D\u001a\u00020\u001cH\u0000¢\u0006\u0004\b?\u0010FJ\u0018\u0010\u0014\u001a\u00020\r2\u0006\u0010<\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010?\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bH\u0016J \u0010I\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020\u00162\u0006\u0010G\u001a\u00020\u000b2\u0006\u0010H\u001a\u00020\u000bH\u0016J\u0010\u0010?\u001a\u00020\u000b2\u0006\u0010J\u001a\u00020\"H\u0016J\u0018\u0010\u0014\u001a\u00020\u000b2\u0006\u0010J\u001a\u00020\"2\u0006\u0010G\u001a\u00020\u000bH\u0016J\u0018\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010K\u001a\u00020\"H\u0016J(\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010K\u001a\u00020\"2\u0006\u0010L\u001a\u00020\u001c2\u0006\u0010\f\u001a\u00020\u001cH\u0016J\b\u0010M\u001a\u00020\rH\u0016J\b\u0010N\u001a\u00020\tH\u0016J\b\u0010O\u001a\u00020\rH\u0016J\b\u0010Q\u001a\u00020PH\u0016J\u0013\u0010T\u001a\u00020\t2\b\u0010S\u001a\u0004\u0018\u00010RH\u0096\u0002J\b\u0010U\u001a\u00020\u001cH\u0016J\b\u0010V\u001a\u00020)H\u0016J\u0006\u0010B\u001a\u00020\u0000J\b\u0010?\u001a\u00020\u0000H\u0016J\u0006\u0010A\u001a\u00020\"J\u000e\u0010\u0014\u001a\u00020\"2\u0006\u0010\f\u001a\u00020\u001cJ\u0012\u0010\u0014\u001a\u00020W2\b\b\u0002\u0010X\u001a\u00020WH\u0007R\u0018\u0010Z\u001a\u0004\u0018\u00010E8\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010YR*\u0010`\u001a\u00020\u000b2\u0006\u0010[\u001a\u00020\u000b8G@@X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b?\u0010_R\u0014\u0010c\u001a\u00020\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\ba\u0010b¨\u0006f"}, d2 = {"Lsdk/pendo/io/s2/d;", "Lsdk/pendo/io/s2/f;", "Lsdk/pendo/io/s2/e;", "", "Ljava/nio/channels/ByteChannel;", "Ljava/io/OutputStream;", "outputStream", "f", "e", "", "exhausted", "", "byteCount", "", "require", "request", "Ljava/io/InputStream;", "inputStream", "out", "offset", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "c", "", "readByte", "pos", "(J)B", "", "readShort", "", "readInt", "readLong", "readShortLe", "readIntLe", "readHexadecimalUnsignedLong", "Lsdk/pendo/io/s2/g;", "g", "readByteString", "Lsdk/pendo/io/s2/r;", "options", "sink", "Lsdk/pendo/io/s2/y;", "", "readUtf8", "Ljava/nio/charset/Charset;", "charset", "readString", "readUtf8LineStrict", BoxIterator.FIELD_LIMIT, "readUtf8CodePoint", "", "readByteArray", "readFully", "read", "Ljava/nio/ByteBuffer;", "skip", "byteString", "string", "beginIndex", "endIndex", "codePoint", "source", "write", "Lsdk/pendo/io/s2/a0;", "b", "s", "i", "d", "v", "minimumCapacity", "Lsdk/pendo/io/s2/v;", "(I)Lsdk/pendo/io/s2/v;", "fromIndex", "toIndex", "indexOf", "targetBytes", "bytes", "bytesOffset", "flush", "isOpen", HeaderElements.CLOSE, "Lsdk/pendo/io/s2/b0;", ResetPasswordSubmitNewPasswordCommand.POLL_COMPLETION_TIMEOUT_ERROR_CODE, "", "other", "equals", "hashCode", "toString", "Lsdk/pendo/io/s2/d$a;", "unsafeCursor", "Lsdk/pendo/io/s2/v;", "head", "<set-?>", "J", CmcdData.STREAMING_FORMAT_HLS, "()J", "(J)V", "size", "getBuffer", "()Lokio/Buffer;", "buffer", "<init>", "()V", "external.sdk.pendo.io.okio"}, k = 1, mv = {1, 9, 0})
public final class d implements f, e, Cloneable, ByteChannel {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public v head;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private long size;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0012\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b#\u0010$J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J\b\u0010\t\u001a\u00020\bH\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u000eR$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b!\u0010\u001f¨\u0006%"}, d2 = {"Lsdk/pendo/io/s2/d$a;", "Ljava/io/Closeable;", "", "b", "", "offset", "newSize", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", HeaderElements.CLOSE, "Lsdk/pendo/io/s2/d;", "Lsdk/pendo/io/s2/d;", "buffer", "", "Z", "readWrite", "Lsdk/pendo/io/s2/v;", "c", "Lsdk/pendo/io/s2/v;", "getSegment$okio", "()Lokio/Segment;", "setSegment$okio", "(Lokio/Segment;)V", "segment", "d", "J", "", "e", "[B", "data", "f", "I", "start", "g", "end", "<init>", "()V", "external.sdk.pendo.io.okio"}, k = 1, mv = {1, 9, 0})
    public static final class a implements Closeable {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        public d buffer;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        public boolean readWrite;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        private v segment;

        /* JADX INFO: renamed from: e, reason: from kotlin metadata */
        public byte[] data;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        public long offset = -1;

        /* JADX INFO: renamed from: f, reason: from kotlin metadata */
        public int start = -1;

        /* JADX INFO: renamed from: g, reason: from kotlin metadata */
        public int end = -1;

        /* JADX INFO: renamed from: a, reason: from getter */
        public final v getSegment() {
            return this.segment;
        }

        public final int b() {
            long j = this.offset;
            d dVar = this.buffer;
            Intrinsics.checkNotNull(dVar);
            if (j == dVar.getSize()) {
                throw new IllegalStateException("no more bytes".toString());
            }
            long j2 = this.offset;
            return b(j2 == -1 ? 0L : j2 + ((long) (this.end - this.start)));
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.buffer == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            this.buffer = null;
            a((v) null);
            this.offset = -1L;
            this.data = null;
            this.start = -1;
            this.end = -1;
        }

        public final long a(long newSize) {
            d dVar = this.buffer;
            if (dVar == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            if (!this.readWrite) {
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers".toString());
            }
            long size = dVar.getSize();
            if (newSize <= size) {
                if (newSize < 0) {
                    throw new IllegalArgumentException(("newSize < 0: " + newSize).toString());
                }
                long j = size - newSize;
                while (j > 0) {
                    v vVar = dVar.head;
                    Intrinsics.checkNotNull(vVar);
                    v vVar2 = vVar.prev;
                    Intrinsics.checkNotNull(vVar2);
                    int i = vVar2.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String;
                    long j2 = i - vVar2.pos;
                    if (j2 > j) {
                        vVar2.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String = i - ((int) j);
                        break;
                    }
                    dVar.head = vVar2.b();
                    w.a(vVar2);
                    j -= j2;
                }
                a((v) null);
                this.offset = newSize;
                this.data = null;
                this.start = -1;
                this.end = -1;
            } else if (newSize > size) {
                long j3 = newSize - size;
                boolean z = true;
                while (j3 > 0) {
                    v vVarB = dVar.b(1);
                    int iMin = (int) Math.min(j3, 8192 - vVarB.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String);
                    vVarB.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String += iMin;
                    j3 -= (long) iMin;
                    if (z) {
                        a(vVarB);
                        this.offset = size;
                        this.data = vVarB.data;
                        int i2 = vVarB.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String;
                        this.start = i2 - iMin;
                        this.end = i2;
                        z = false;
                    }
                }
            }
            dVar.b(newSize);
            return size;
        }

        public final int b(long offset) {
            v vVarA;
            d dVar = this.buffer;
            if (dVar == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            if (offset < -1 || offset > dVar.getSize()) {
                throw new ArrayIndexOutOfBoundsException("offset=" + offset + " > size=" + dVar.getSize());
            }
            if (offset == -1 || offset == dVar.getSize()) {
                a((v) null);
                this.offset = offset;
                this.data = null;
                this.start = -1;
                this.end = -1;
                return -1;
            }
            long size = dVar.getSize();
            v segment = dVar.head;
            long j = 0;
            if (getSegment() != null) {
                long j2 = this.offset;
                int i = this.start;
                v segment2 = getSegment();
                Intrinsics.checkNotNull(segment2);
                long j3 = j2 - ((long) (i - segment2.pos));
                if (j3 > offset) {
                    vVarA = segment;
                    segment = getSegment();
                    size = j3;
                } else {
                    vVarA = getSegment();
                    j = j3;
                }
            } else {
                vVarA = segment;
            }
            if (size - offset > offset - j) {
                while (true) {
                    Intrinsics.checkNotNull(vVarA);
                    long j4 = ((long) (vVarA.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String - vVarA.pos)) + j;
                    if (offset < j4) {
                        break;
                    }
                    vVarA = vVarA.external.sdk.pendo.io.mozilla.javascript.ES6Iterator.NEXT_METHOD java.lang.String;
                    j = j4;
                }
            } else {
                while (size > offset) {
                    Intrinsics.checkNotNull(segment);
                    segment = segment.prev;
                    Intrinsics.checkNotNull(segment);
                    size -= (long) (segment.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String - segment.pos);
                }
                j = size;
                vVarA = segment;
            }
            if (this.readWrite) {
                Intrinsics.checkNotNull(vVarA);
                if (vVarA.shared) {
                    v vVarD = vVarA.d();
                    if (dVar.head == vVarA) {
                        dVar.head = vVarD;
                    }
                    vVarA = vVarA.a(vVarD);
                    v vVar = vVarA.prev;
                    Intrinsics.checkNotNull(vVar);
                    vVar.b();
                }
            }
            a(vVarA);
            this.offset = offset;
            Intrinsics.checkNotNull(vVarA);
            this.data = vVarA.data;
            int i2 = vVarA.pos + ((int) (offset - j));
            this.start = i2;
            int i3 = vVarA.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String;
            this.end = i3;
            return i3 - i2;
        }

        public final void a(v vVar) {
            this.segment = vVar;
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016¨\u0006\r"}, d2 = {"sdk/pendo/io/s2/d$b", "Ljava/io/InputStream;", "", "read", "", "sink", "offset", "byteCount", "available", "", HeaderElements.CLOSE, "", "toString", "external.sdk.pendo.io.okio"}, k = 1, mv = {1, 9, 0})
    public static final class b extends InputStream {
        b() {
        }

        @Override // java.io.InputStream
        public int available() {
            return (int) Math.min(d.this.getSize(), Integer.MAX_VALUE);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.InputStream
        public int read() {
            if (d.this.getSize() > 0) {
                return d.this.readByte() & 255;
            }
            return -1;
        }

        public String toString() {
            return d.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] sink, int offset, int byteCount) {
            Intrinsics.checkNotNullParameter(sink, "sink");
            return d.this.read(sink, offset, byteCount);
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\fH\u0016¨\u0006\u000e"}, d2 = {"sdk/pendo/io/s2/d$c", "Ljava/io/OutputStream;", "", "b", "", "write", "", "data", "offset", "byteCount", "flush", HeaderElements.CLOSE, "", "toString", "external.sdk.pendo.io.okio"}, k = 1, mv = {1, 9, 0})
    public static final class c extends OutputStream {
        c() {
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
        }

        public String toString() {
            return d.this + ".outputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int b) {
            d.this.writeByte(b);
        }

        @Override // java.io.OutputStream
        public void write(byte[] data, int offset, int byteCount) {
            Intrinsics.checkNotNullParameter(data, "data");
            d.this.write(data, offset, byteCount);
        }
    }

    public final void a() throws EOFException {
        skip(getSize());
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public d clone() {
        return d();
    }

    public final long c() {
        long size = getSize();
        if (size == 0) {
            return 0L;
        }
        v vVar = this.head;
        Intrinsics.checkNotNull(vVar);
        v vVar2 = vVar.prev;
        Intrinsics.checkNotNull(vVar2);
        int i = vVar2.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String;
        return (i >= 8192 || !vVar2.owner) ? size : size - ((long) (i - vVar2.pos));
    }

    @Override // sdk.pendo.io.s2.a0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public final d d() {
        d dVar = new d();
        if (getSize() == 0) {
            return dVar;
        }
        v vVar = this.head;
        Intrinsics.checkNotNull(vVar);
        v vVarC = vVar.c();
        dVar.head = vVarC;
        vVarC.prev = vVarC;
        vVarC.external.sdk.pendo.io.mozilla.javascript.ES6Iterator.NEXT_METHOD java.lang.String = vVarC;
        for (v vVar2 = vVar.external.sdk.pendo.io.mozilla.javascript.ES6Iterator.NEXT_METHOD java.lang.String; vVar2 != vVar; vVar2 = vVar2.external.sdk.pendo.io.mozilla.javascript.ES6Iterator.NEXT_METHOD java.lang.String) {
            v vVar3 = vVarC.prev;
            Intrinsics.checkNotNull(vVar3);
            Intrinsics.checkNotNull(vVar2);
            vVar3.a(vVar2.c());
        }
        dVar.b(getSize());
        return dVar;
    }

    @Override // sdk.pendo.io.s2.e
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public d emit() {
        return this;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof d)) {
            return false;
        }
        d dVar = (d) other;
        if (getSize() != dVar.getSize()) {
            return false;
        }
        if (getSize() == 0) {
            return true;
        }
        v vVar = this.head;
        Intrinsics.checkNotNull(vVar);
        v vVar2 = dVar.head;
        Intrinsics.checkNotNull(vVar2);
        int i = vVar.pos;
        int i2 = vVar2.pos;
        long j = 0;
        while (j < getSize()) {
            long jMin = Math.min(vVar.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String - i, vVar2.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String - i2);
            long j2 = 0;
            while (j2 < jMin) {
                int i3 = i + 1;
                int i4 = i2 + 1;
                if (vVar.data[i] != vVar2.data[i2]) {
                    return false;
                }
                j2++;
                i = i3;
                i2 = i4;
            }
            if (i == vVar.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String) {
                vVar = vVar.external.sdk.pendo.io.mozilla.javascript.ES6Iterator.NEXT_METHOD java.lang.String;
                Intrinsics.checkNotNull(vVar);
                i = vVar.pos;
            }
            if (i2 == vVar2.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String) {
                vVar2 = vVar2.external.sdk.pendo.io.mozilla.javascript.ES6Iterator.NEXT_METHOD java.lang.String;
                Intrinsics.checkNotNull(vVar2);
                i2 = vVar2.pos;
            }
            j += jMin;
        }
        return true;
    }

    @Override // sdk.pendo.io.s2.f
    public boolean exhausted() {
        return this.size == 0;
    }

    @Override // sdk.pendo.io.s2.e
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public d emitCompleteSegments() {
        return this;
    }

    @Override // sdk.pendo.io.s2.e, sdk.pendo.io.s2.y, java.io.Flushable
    public void flush() {
    }

    public g g() {
        return readByteString(getSize());
    }

    @Override // sdk.pendo.io.s2.f, sdk.pendo.io.s2.e
    public d getBuffer() {
        return this;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final long getSize() {
        return this.size;
    }

    public int hashCode() {
        v vVar = this.head;
        if (vVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = vVar.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String;
            for (int i3 = vVar.pos; i3 < i2; i3++) {
                i = (i * 31) + vVar.data[i3];
            }
            vVar = vVar.external.sdk.pendo.io.mozilla.javascript.ES6Iterator.NEXT_METHOD java.lang.String;
            Intrinsics.checkNotNull(vVar);
        } while (vVar != this.head);
        return i;
    }

    public final g i() {
        if (getSize() <= SieveCacheKt.NodeLinkMask) {
            return a((int) getSize());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + getSize()).toString());
    }

    public long indexOf(byte b2, long fromIndex, long toIndex) {
        v vVar;
        int i;
        long size = 0;
        if (0 > fromIndex || fromIndex > toIndex) {
            throw new IllegalArgumentException(("size=" + getSize() + " fromIndex=" + fromIndex + " toIndex=" + toIndex).toString());
        }
        if (toIndex > getSize()) {
            toIndex = getSize();
        }
        if (fromIndex == toIndex || (vVar = this.head) == null) {
            return -1L;
        }
        if (getSize() - fromIndex < fromIndex) {
            size = getSize();
            while (size > fromIndex) {
                vVar = vVar.prev;
                Intrinsics.checkNotNull(vVar);
                size -= (long) (vVar.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String - vVar.pos);
            }
            while (size < toIndex) {
                byte[] bArr = vVar.data;
                int iMin = (int) Math.min(vVar.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String, (((long) vVar.pos) + toIndex) - size);
                i = (int) ((((long) vVar.pos) + fromIndex) - size);
                while (i < iMin) {
                    if (bArr[i] != b2) {
                        i++;
                    }
                }
                size += (long) (vVar.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String - vVar.pos);
                vVar = vVar.external.sdk.pendo.io.mozilla.javascript.ES6Iterator.NEXT_METHOD java.lang.String;
                Intrinsics.checkNotNull(vVar);
                fromIndex = size;
            }
            return -1L;
        }
        while (true) {
            long j = ((long) (vVar.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String - vVar.pos)) + size;
            if (j > fromIndex) {
                break;
            }
            vVar = vVar.external.sdk.pendo.io.mozilla.javascript.ES6Iterator.NEXT_METHOD java.lang.String;
            Intrinsics.checkNotNull(vVar);
            size = j;
        }
        while (size < toIndex) {
            byte[] bArr2 = vVar.data;
            int iMin2 = (int) Math.min(vVar.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String, (((long) vVar.pos) + toIndex) - size);
            i = (int) ((((long) vVar.pos) + fromIndex) - size);
            while (i < iMin2) {
                if (bArr2[i] != b2) {
                    i++;
                }
            }
            size += (long) (vVar.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String - vVar.pos);
            vVar = vVar.external.sdk.pendo.io.mozilla.javascript.ES6Iterator.NEXT_METHOD java.lang.String;
            Intrinsics.checkNotNull(vVar);
            fromIndex = size;
        }
        return -1L;
        return ((long) (i - vVar.pos)) + size;
    }

    @Override // sdk.pendo.io.s2.f
    public InputStream inputStream() {
        return new b();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public OutputStream outputStream() {
        return new c();
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        v vVar = this.head;
        if (vVar == null) {
            return -1;
        }
        int iMin = Math.min(sink.remaining(), vVar.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String - vVar.pos);
        sink.put(vVar.data, vVar.pos, iMin);
        int i = vVar.pos + iMin;
        vVar.pos = i;
        this.size -= (long) iMin;
        if (i == vVar.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String) {
            this.head = vVar.b();
            w.a(vVar);
        }
        return iMin;
    }

    @Override // sdk.pendo.io.s2.f
    public byte readByte() throws EOFException {
        if (getSize() == 0) {
            throw new EOFException();
        }
        v vVar = this.head;
        Intrinsics.checkNotNull(vVar);
        int i = vVar.pos;
        int i2 = vVar.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String;
        int i3 = i + 1;
        byte b2 = vVar.data[i];
        b(getSize() - 1);
        if (i3 != i2) {
            vVar.pos = i3;
            return b2;
        }
        this.head = vVar.b();
        w.a(vVar);
        return b2;
    }

    @Override // sdk.pendo.io.s2.f
    public byte[] readByteArray() {
        return readByteArray(getSize());
    }

    @Override // sdk.pendo.io.s2.f
    public g readByteString(long byteCount) throws EOFException {
        if (byteCount < 0 || byteCount > SieveCacheKt.NodeLinkMask) {
            throw new IllegalArgumentException(("byteCount: " + byteCount).toString());
        }
        if (getSize() < byteCount) {
            throw new EOFException();
        }
        if (byteCount < 4096) {
            return new g(readByteArray(byteCount));
        }
        g gVarA = a((int) byteCount);
        skip(byteCount);
        return gVarA;
    }

    @Override // sdk.pendo.io.s2.f
    public void readFully(byte[] sink) throws EOFException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        int i = 0;
        while (i < sink.length) {
            int i2 = read(sink, i, sink.length - i);
            if (i2 == -1) {
                throw new EOFException();
            }
            i += i2;
        }
    }

    @Override // sdk.pendo.io.s2.f
    public long readHexadecimalUnsignedLong() throws EOFException {
        int i;
        if (getSize() == 0) {
            throw new EOFException();
        }
        int i2 = 0;
        boolean z = false;
        long j = 0;
        do {
            v vVar = this.head;
            Intrinsics.checkNotNull(vVar);
            byte[] bArr = vVar.data;
            int i3 = vVar.pos;
            int i4 = vVar.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String;
            while (i3 < i4) {
                byte b2 = bArr[i3];
                if (b2 >= 48 && b2 <= 57) {
                    i = b2 - 48;
                } else if (b2 >= 97 && b2 <= 102) {
                    i = b2 - 87;
                } else {
                    if (b2 < 65 || b2 > 70) {
                        if (i2 == 0) {
                            throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + sdk.pendo.io.s2.b.a(b2));
                        }
                        z = true;
                        break;
                    }
                    i = b2 - 55;
                }
                if (((-1152921504606846976L) & j) != 0) {
                    throw new NumberFormatException("Number too large: " + new d().writeHexadecimalUnsignedLong(j).writeByte((int) b2).readUtf8());
                }
                j = (j << 4) | ((long) i);
                i3++;
                i2++;
            }
            if (i3 == i4) {
                this.head = vVar.b();
                w.a(vVar);
            } else {
                vVar.pos = i3;
            }
            if (z) {
                break;
            }
        } while (this.head != null);
        b(getSize() - ((long) i2));
        return j;
    }

    @Override // sdk.pendo.io.s2.f
    public int readInt() throws EOFException {
        if (getSize() < 4) {
            throw new EOFException();
        }
        v vVar = this.head;
        Intrinsics.checkNotNull(vVar);
        int i = vVar.pos;
        int i2 = vVar.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String;
        if (i2 - i < 4) {
            return (readByte() & 255) | ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8);
        }
        byte[] bArr = vVar.data;
        int i3 = i + 3;
        int i4 = ((bArr[i + 1] & 255) << 16) | ((bArr[i] & 255) << 24) | ((bArr[i + 2] & 255) << 8);
        int i5 = i + 4;
        int i6 = (bArr[i3] & 255) | i4;
        b(getSize() - 4);
        if (i5 != i2) {
            vVar.pos = i5;
            return i6;
        }
        this.head = vVar.b();
        w.a(vVar);
        return i6;
    }

    public int readIntLe() {
        return sdk.pendo.io.s2.b.a(readInt());
    }

    @Override // sdk.pendo.io.s2.f
    public long readLong() throws EOFException {
        if (getSize() < 8) {
            throw new EOFException();
        }
        v vVar = this.head;
        Intrinsics.checkNotNull(vVar);
        int i = vVar.pos;
        int i2 = vVar.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String;
        if (i2 - i < 8) {
            return ((((long) readInt()) & 4294967295L) << 32) | (4294967295L & ((long) readInt()));
        }
        byte[] bArr = vVar.data;
        int i3 = i + 7;
        long j = ((((long) bArr[i]) & 255) << 56) | ((((long) bArr[i + 1]) & 255) << 48) | ((((long) bArr[i + 2]) & 255) << 40) | ((((long) bArr[i + 3]) & 255) << 32) | ((((long) bArr[i + 4]) & 255) << 24) | ((((long) bArr[i + 5]) & 255) << 16) | ((((long) bArr[i + 6]) & 255) << 8);
        int i4 = i + 8;
        long j2 = j | (((long) bArr[i3]) & 255);
        b(getSize() - 8);
        if (i4 != i2) {
            vVar.pos = i4;
            return j2;
        }
        this.head = vVar.b();
        w.a(vVar);
        return j2;
    }

    @Override // sdk.pendo.io.s2.f
    public short readShort() throws EOFException {
        if (getSize() < 2) {
            throw new EOFException();
        }
        v vVar = this.head;
        Intrinsics.checkNotNull(vVar);
        int i = vVar.pos;
        int i2 = vVar.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String;
        if (i2 - i < 2) {
            return (short) ((readByte() & 255) | ((readByte() & 255) << 8));
        }
        byte[] bArr = vVar.data;
        int i3 = i + 1;
        int i4 = (bArr[i] & 255) << 8;
        int i5 = i + 2;
        int i6 = (bArr[i3] & 255) | i4;
        b(getSize() - 2);
        if (i5 == i2) {
            this.head = vVar.b();
            w.a(vVar);
        } else {
            vVar.pos = i5;
        }
        return (short) i6;
    }

    public short readShortLe() {
        return sdk.pendo.io.s2.b.a(readShort());
    }

    public String readString(long byteCount, Charset charset) throws EOFException {
        Intrinsics.checkNotNullParameter(charset, "charset");
        if (byteCount < 0 || byteCount > SieveCacheKt.NodeLinkMask) {
            throw new IllegalArgumentException(("byteCount: " + byteCount).toString());
        }
        if (this.size < byteCount) {
            throw new EOFException();
        }
        if (byteCount == 0) {
            return "";
        }
        v vVar = this.head;
        Intrinsics.checkNotNull(vVar);
        int i = vVar.pos;
        if (((long) i) + byteCount > vVar.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String) {
            return new String(readByteArray(byteCount), charset);
        }
        int i2 = (int) byteCount;
        String str = new String(vVar.data, i, i2, charset);
        int i3 = vVar.pos + i2;
        vVar.pos = i3;
        this.size -= byteCount;
        if (i3 == vVar.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String) {
            this.head = vVar.b();
            w.a(vVar);
        }
        return str;
    }

    public String readUtf8() {
        return readString(this.size, Charsets.UTF_8);
    }

    public int readUtf8CodePoint() throws EOFException {
        int i;
        int i2;
        int i3;
        if (getSize() == 0) {
            throw new EOFException();
        }
        byte bA = a(0L);
        if ((bA & 128) == 0) {
            i = bA & 127;
            i3 = 0;
            i2 = 1;
        } else if ((bA & CtapException.ERR_EXTENSION_FIRST) == 192) {
            i = bA & Ascii.US;
            i2 = 2;
            i3 = 128;
        } else if ((bA & CtapException.ERR_VENDOR_FIRST) == 224) {
            i = bA & Ascii.SI;
            i2 = 3;
            i3 = 2048;
        } else {
            if ((bA & 248) != 240) {
                skip(1L);
                return Utf8.REPLACEMENT_CODE_POINT;
            }
            i = bA & 7;
            i2 = 4;
            i3 = 65536;
        }
        long j = i2;
        if (getSize() < j) {
            throw new EOFException("size < " + i2 + ": " + getSize() + " (to read code point prefixed 0x" + sdk.pendo.io.s2.b.a(bA) + ')');
        }
        for (int i4 = 1; i4 < i2; i4++) {
            long j2 = i4;
            byte bA2 = a(j2);
            if ((bA2 & 192) != 128) {
                skip(j2);
                return Utf8.REPLACEMENT_CODE_POINT;
            }
            i = (i << 6) | (bA2 & 63);
        }
        skip(j);
        return (i <= 1114111 && (55296 > i || i >= 57344) && i >= i3) ? i : Utf8.REPLACEMENT_CODE_POINT;
    }

    @Override // sdk.pendo.io.s2.f
    public String readUtf8LineStrict() {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    @Override // sdk.pendo.io.s2.f
    public boolean request(long byteCount) {
        return this.size >= byteCount;
    }

    @Override // sdk.pendo.io.s2.f
    public void require(long byteCount) throws EOFException {
        if (this.size < byteCount) {
            throw new EOFException();
        }
    }

    @Override // sdk.pendo.io.s2.f
    public void skip(long byteCount) throws EOFException {
        while (byteCount > 0) {
            v vVar = this.head;
            if (vVar == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(byteCount, vVar.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String - vVar.pos);
            long j = iMin;
            b(getSize() - j);
            byteCount -= j;
            int i = vVar.pos + iMin;
            vVar.pos = i;
            if (i == vVar.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String) {
                this.head = vVar.b();
                w.a(vVar);
            }
        }
    }

    @Override // sdk.pendo.io.s2.a0
    public b0 timeout() {
        return b0.e;
    }

    public String toString() {
        return i().toString();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer source) {
        Intrinsics.checkNotNullParameter(source, "source");
        int iRemaining = source.remaining();
        int i = iRemaining;
        while (i > 0) {
            v vVarB = b(1);
            int iMin = Math.min(i, 8192 - vVarB.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String);
            source.get(vVarB.data, vVarB.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String, iMin);
            i -= iMin;
            vVarB.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String += iMin;
        }
        this.size += (long) iRemaining;
        return iRemaining;
    }

    public final d a(d out, long offset, long byteCount) {
        Intrinsics.checkNotNullParameter(out, "out");
        long j = offset;
        sdk.pendo.io.s2.b.a(getSize(), j, byteCount);
        if (byteCount != 0) {
            out.b(out.getSize() + byteCount);
            v vVar = this.head;
            while (true) {
                Intrinsics.checkNotNull(vVar);
                long j2 = vVar.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String - vVar.pos;
                if (j < j2) {
                    break;
                }
                j -= j2;
                vVar = vVar.external.sdk.pendo.io.mozilla.javascript.ES6Iterator.NEXT_METHOD java.lang.String;
            }
            v vVar2 = vVar;
            long j3 = byteCount;
            while (j3 > 0) {
                Intrinsics.checkNotNull(vVar2);
                v vVarC = vVar2.c();
                int i = vVarC.pos + ((int) j);
                vVarC.pos = i;
                vVarC.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String = Math.min(i + ((int) j3), vVarC.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String);
                v vVar3 = out.head;
                if (vVar3 == null) {
                    vVarC.prev = vVarC;
                    vVarC.external.sdk.pendo.io.mozilla.javascript.ES6Iterator.NEXT_METHOD java.lang.String = vVarC;
                    out.head = vVarC;
                } else {
                    Intrinsics.checkNotNull(vVar3);
                    v vVar4 = vVar3.prev;
                    Intrinsics.checkNotNull(vVar4);
                    vVar4.a(vVarC);
                }
                j3 -= (long) (vVarC.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String - vVarC.pos);
                vVar2 = vVar2.external.sdk.pendo.io.mozilla.javascript.ES6Iterator.NEXT_METHOD java.lang.String;
                j = 0;
            }
        }
        return this;
    }

    public long b(g targetBytes) {
        Intrinsics.checkNotNullParameter(targetBytes, "targetBytes");
        return a(targetBytes, 0L);
    }

    @Override // sdk.pendo.io.s2.f
    public void c(d sink, long byteCount) throws EOFException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (getSize() >= byteCount) {
            sink.a(this, byteCount);
        } else {
            sink.a(this, getSize());
            throw new EOFException();
        }
    }

    @Override // sdk.pendo.io.s2.e
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public d writeHexadecimalUnsignedLong(long v) {
        if (v == 0) {
            return writeByte(48);
        }
        long j = (v >>> 1) | v;
        long j2 = j | (j >>> 2);
        long j3 = j2 | (j2 >>> 4);
        long j4 = j3 | (j3 >>> 8);
        long j5 = j4 | (j4 >>> 16);
        long j6 = j5 | (j5 >>> 32);
        long j7 = j6 - ((j6 >>> 1) & 6148914691236517205L);
        long j8 = ((j7 >>> 2) & 3689348814741910323L) + (j7 & 3689348814741910323L);
        long j9 = ((j8 >>> 4) + j8) & 1085102592571150095L;
        long j10 = j9 + (j9 >>> 8);
        long j11 = j10 + (j10 >>> 16);
        int i = (int) ((((j11 & 63) + ((j11 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
        v vVarB = b(i);
        byte[] bArr = vVarB.data;
        int i2 = vVarB.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String;
        for (int i3 = (i2 + i) - 1; i3 >= i2; i3--) {
            bArr[i3] = sdk.pendo.io.t2.a.a()[(int) (15 & v)];
            v >>>= 4;
        }
        vVarB.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String += i;
        b(getSize() + ((long) i));
        return this;
    }

    public d e(long v) {
        v vVarB = b(8);
        byte[] bArr = vVarB.data;
        int i = vVarB.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String;
        bArr[i] = (byte) ((v >>> 56) & 255);
        bArr[i + 1] = (byte) ((v >>> 48) & 255);
        bArr[i + 2] = (byte) ((v >>> 40) & 255);
        bArr[i + 3] = (byte) ((v >>> 32) & 255);
        bArr[i + 4] = (byte) ((v >>> 24) & 255);
        bArr[i + 5] = (byte) ((v >>> 16) & 255);
        bArr[i + 6] = (byte) ((v >>> 8) & 255);
        bArr[i + 7] = (byte) (v & 255);
        vVarB.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String = i + 8;
        b(getSize() + 8);
        return this;
    }

    public d f(int codePoint) {
        long size;
        long j;
        if (codePoint < 128) {
            writeByte(codePoint);
            return this;
        }
        if (codePoint < 2048) {
            v vVarB = b(2);
            byte[] bArr = vVarB.data;
            int i = vVarB.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String;
            bArr[i] = (byte) ((codePoint >> 6) | 192);
            bArr[i + 1] = (byte) ((codePoint & 63) | 128);
            vVarB.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String = i + 2;
            size = getSize();
            j = 2;
        } else {
            if (55296 <= codePoint && codePoint < 57344) {
                writeByte(63);
                return this;
            }
            if (codePoint < 65536) {
                v vVarB2 = b(3);
                byte[] bArr2 = vVarB2.data;
                int i2 = vVarB2.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String;
                bArr2[i2] = (byte) ((codePoint >> 12) | 224);
                bArr2[i2 + 1] = (byte) (((codePoint >> 6) & 63) | 128);
                bArr2[i2 + 2] = (byte) ((codePoint & 63) | 128);
                vVarB2.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String = i2 + 3;
                size = getSize();
                j = 3;
            } else {
                if (codePoint > 1114111) {
                    throw new IllegalArgumentException("Unexpected code point: 0x" + sdk.pendo.io.s2.b.b(codePoint));
                }
                v vVarB3 = b(4);
                byte[] bArr3 = vVarB3.data;
                int i3 = vVarB3.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String;
                bArr3[i3] = (byte) ((codePoint >> 18) | PsExtractor.VIDEO_STREAM_MASK);
                bArr3[i3 + 1] = (byte) (((codePoint >> 12) & 63) | 128);
                bArr3[i3 + 2] = (byte) (((codePoint >> 6) & 63) | 128);
                bArr3[i3 + 3] = (byte) ((codePoint & 63) | 128);
                vVarB3.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String = i3 + 4;
                size = getSize();
                j = 4;
            }
        }
        b(size + j);
        return this;
    }

    public int read(byte[] sink, int offset, int byteCount) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        sdk.pendo.io.s2.b.a(sink.length, offset, byteCount);
        v vVar = this.head;
        if (vVar == null) {
            return -1;
        }
        int iMin = Math.min(byteCount, vVar.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String - vVar.pos);
        byte[] bArr = vVar.data;
        int i = vVar.pos;
        ArraysKt.copyInto(bArr, sink, offset, i, i + iMin);
        vVar.pos += iMin;
        b(getSize() - ((long) iMin));
        if (vVar.pos == vVar.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String) {
            this.head = vVar.b();
            w.a(vVar);
        }
        return iMin;
    }

    @Override // sdk.pendo.io.s2.f
    public byte[] readByteArray(long byteCount) throws EOFException {
        if (byteCount < 0 || byteCount > SieveCacheKt.NodeLinkMask) {
            throw new IllegalArgumentException(("byteCount: " + byteCount).toString());
        }
        if (getSize() < byteCount) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) byteCount];
        readFully(bArr);
        return bArr;
    }

    @Override // sdk.pendo.io.s2.f
    public String readString(Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        return readString(this.size, charset);
    }

    public String readUtf8(long byteCount) throws EOFException {
        return readString(byteCount, Charsets.UTF_8);
    }

    @Override // sdk.pendo.io.s2.f
    public String readUtf8LineStrict(long limit) throws EOFException {
        if (limit < 0) {
            throw new IllegalArgumentException(("limit < 0: " + limit).toString());
        }
        long j = limit != Long.MAX_VALUE ? limit + 1 : Long.MAX_VALUE;
        long jIndexOf = indexOf((byte) 10, 0L, j);
        if (jIndexOf != -1) {
            return sdk.pendo.io.t2.a.a(this, jIndexOf);
        }
        if (j < getSize() && a(j - 1) == 13 && a(j) == 10) {
            return sdk.pendo.io.t2.a.a(this, j);
        }
        d dVar = new d();
        a(dVar, 0L, Math.min(32, getSize()));
        throw new EOFException("\\n not found: limit=" + Math.min(getSize(), limit) + " content=" + dVar.g().f() + Typography.ellipsis);
    }

    public final byte a(long pos) {
        sdk.pendo.io.s2.b.a(getSize(), pos, 1L);
        v vVar = this.head;
        if (vVar == null) {
            Intrinsics.checkNotNull(null);
            throw null;
        }
        if (getSize() - pos < pos) {
            long size = getSize();
            while (size > pos) {
                vVar = vVar.prev;
                Intrinsics.checkNotNull(vVar);
                size -= (long) (vVar.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String - vVar.pos);
            }
            Intrinsics.checkNotNull(vVar);
            return vVar.data[(int) ((((long) vVar.pos) + pos) - size)];
        }
        long j = 0;
        while (true) {
            long j2 = ((long) (vVar.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String - vVar.pos)) + j;
            if (j2 > pos) {
                Intrinsics.checkNotNull(vVar);
                return vVar.data[(int) ((((long) vVar.pos) + pos) - j)];
            }
            vVar = vVar.external.sdk.pendo.io.mozilla.javascript.ES6Iterator.NEXT_METHOD java.lang.String;
            Intrinsics.checkNotNull(vVar);
            j = j2;
        }
    }

    @Override // sdk.pendo.io.s2.a0
    public long b(d sink, long byteCount) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (byteCount < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
        }
        if (getSize() == 0) {
            return -1L;
        }
        if (byteCount > getSize()) {
            byteCount = getSize();
        }
        sink.a(this, byteCount);
        return byteCount;
    }

    @Override // sdk.pendo.io.s2.e
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public d a(g byteString) {
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        byteString.a(this, 0, byteString.j());
        return this;
    }

    @Override // sdk.pendo.io.s2.e
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public d writeInt(int i) {
        v vVarB = b(4);
        byte[] bArr = vVarB.data;
        int i2 = vVarB.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        bArr[i2 + 1] = (byte) ((i >>> 16) & 255);
        bArr[i2 + 2] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 3] = (byte) (i & 255);
        vVarB.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String = i2 + 4;
        b(getSize() + 4);
        return this;
    }

    @Override // sdk.pendo.io.s2.e
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public d writeShort(int s) {
        v vVarB = b(2);
        byte[] bArr = vVarB.data;
        int i = vVarB.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String;
        bArr[i] = (byte) ((s >>> 8) & 255);
        bArr[i + 1] = (byte) (s & 255);
        vVarB.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String = i + 2;
        b(getSize() + 2);
        return this;
    }

    public long a(g targetBytes, long fromIndex) {
        int i;
        Intrinsics.checkNotNullParameter(targetBytes, "targetBytes");
        long size = 0;
        if (fromIndex < 0) {
            throw new IllegalArgumentException(("fromIndex < 0: " + fromIndex).toString());
        }
        v vVar = this.head;
        if (vVar == null) {
            return -1L;
        }
        if (getSize() - fromIndex < fromIndex) {
            size = getSize();
            while (size > fromIndex) {
                vVar = vVar.prev;
                Intrinsics.checkNotNull(vVar);
                size -= (long) (vVar.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String - vVar.pos);
            }
            if (targetBytes.j() == 2) {
                byte bA = targetBytes.a(0);
                byte bA2 = targetBytes.a(1);
                while (size < getSize()) {
                    byte[] bArr = vVar.data;
                    i = (int) ((((long) vVar.pos) + fromIndex) - size);
                    int i2 = vVar.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String;
                    while (i < i2) {
                        byte b2 = bArr[i];
                        if (b2 != bA && b2 != bA2) {
                            i++;
                        }
                    }
                    size += (long) (vVar.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String - vVar.pos);
                    vVar = vVar.external.sdk.pendo.io.mozilla.javascript.ES6Iterator.NEXT_METHOD java.lang.String;
                    Intrinsics.checkNotNull(vVar);
                    fromIndex = size;
                }
                return -1L;
            }
            byte[] bArrG = targetBytes.g();
            while (size < getSize()) {
                byte[] bArr2 = vVar.data;
                i = (int) ((((long) vVar.pos) + fromIndex) - size);
                int i3 = vVar.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String;
                while (i < i3) {
                    byte b3 = bArr2[i];
                    for (byte b4 : bArrG) {
                        if (b3 != b4) {
                        }
                    }
                    i++;
                }
                size += (long) (vVar.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String - vVar.pos);
                vVar = vVar.external.sdk.pendo.io.mozilla.javascript.ES6Iterator.NEXT_METHOD java.lang.String;
                Intrinsics.checkNotNull(vVar);
                fromIndex = size;
            }
            return -1L;
        }
        while (true) {
            long j = ((long) (vVar.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String - vVar.pos)) + size;
            if (j > fromIndex) {
                break;
            }
            vVar = vVar.external.sdk.pendo.io.mozilla.javascript.ES6Iterator.NEXT_METHOD java.lang.String;
            Intrinsics.checkNotNull(vVar);
            size = j;
        }
        if (targetBytes.j() == 2) {
            byte bA3 = targetBytes.a(0);
            byte bA4 = targetBytes.a(1);
            while (size < getSize()) {
                byte[] bArr3 = vVar.data;
                i = (int) ((((long) vVar.pos) + fromIndex) - size);
                int i4 = vVar.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String;
                while (i < i4) {
                    byte b5 = bArr3[i];
                    if (b5 != bA3 && b5 != bA4) {
                        i++;
                    }
                }
                size += (long) (vVar.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String - vVar.pos);
                vVar = vVar.external.sdk.pendo.io.mozilla.javascript.ES6Iterator.NEXT_METHOD java.lang.String;
                Intrinsics.checkNotNull(vVar);
                fromIndex = size;
            }
            return -1L;
        }
        byte[] bArrG2 = targetBytes.g();
        while (size < getSize()) {
            byte[] bArr4 = vVar.data;
            i = (int) ((((long) vVar.pos) + fromIndex) - size);
            int i5 = vVar.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String;
            while (i < i5) {
                byte b6 = bArr4[i];
                for (byte b7 : bArrG2) {
                    if (b6 != b7) {
                    }
                }
                i++;
            }
            size += (long) (vVar.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String - vVar.pos);
            vVar = vVar.external.sdk.pendo.io.mozilla.javascript.ES6Iterator.NEXT_METHOD java.lang.String;
            Intrinsics.checkNotNull(vVar);
            fromIndex = size;
        }
        return -1L;
        return ((long) (i - vVar.pos)) + size;
    }

    public final void b(long j) {
        this.size = j;
    }

    @Override // sdk.pendo.io.s2.e
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public d writeByte(int b2) {
        v vVarB = b(1);
        byte[] bArr = vVarB.data;
        int i = vVarB.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String;
        vVarB.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String = i + 1;
        bArr[i] = (byte) b2;
        b(getSize() + 1);
        return this;
    }

    public boolean a(long offset, g bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return a(offset, bytes, 0, bytes.j());
    }

    public final v b(int minimumCapacity) {
        if (minimumCapacity < 1 || minimumCapacity > 8192) {
            throw new IllegalArgumentException("unexpected capacity".toString());
        }
        v vVar = this.head;
        if (vVar != null) {
            Intrinsics.checkNotNull(vVar);
            v vVar2 = vVar.prev;
            Intrinsics.checkNotNull(vVar2);
            return (vVar2.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String + minimumCapacity > 8192 || !vVar2.owner) ? vVar2.a(w.b()) : vVar2;
        }
        v vVarB = w.b();
        this.head = vVarB;
        vVarB.prev = vVarB;
        vVarB.external.sdk.pendo.io.mozilla.javascript.ES6Iterator.NEXT_METHOD java.lang.String = vVarB;
        return vVarB;
    }

    @Override // sdk.pendo.io.s2.e
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public d writeDecimalLong(long v) {
        boolean z;
        if (v == 0) {
            return writeByte(48);
        }
        int i = 1;
        if (v < 0) {
            v = -v;
            if (v < 0) {
                return writeUtf8("-9223372036854775808");
            }
            z = true;
        } else {
            z = false;
        }
        if (v < 100000000) {
            if (v < 10000) {
                if (v >= 100) {
                    i = v < 1000 ? 3 : 4;
                } else if (v >= 10) {
                    i = 2;
                }
            } else if (v < 1000000) {
                i = v < SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US ? 5 : 6;
            } else {
                i = v < DownloadFileJobKt.MIN_CHUNK_SIZE ? 7 : 8;
            }
        } else if (v < MediaPeriodQueue.INITIAL_RENDERER_POSITION_OFFSET_US) {
            if (v < RealConnection.IDLE_CONNECTION_HEALTHY_NS) {
                i = v < C.NANOS_PER_SECOND ? 9 : 10;
            } else {
                i = v < 100000000000L ? 11 : 12;
            }
        } else if (v < 1000000000000000L) {
            if (v < 10000000000000L) {
                i = 13;
            } else {
                i = v < 100000000000000L ? 14 : 15;
            }
        } else if (v < 100000000000000000L) {
            i = v < 10000000000000000L ? 16 : 17;
        } else {
            i = v < 1000000000000000000L ? 18 : 19;
        }
        if (z) {
            i++;
        }
        v vVarB = b(i);
        byte[] bArr = vVarB.data;
        int i2 = vVarB.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String + i;
        while (v != 0) {
            long j = 10;
            i2--;
            bArr[i2] = sdk.pendo.io.t2.a.a()[(int) (v % j)];
            v /= j;
        }
        if (z) {
            bArr[i2 - 1] = CtapException.ERR_KEEPALIVE_CANCEL;
        }
        vVarB.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String += i;
        b(getSize() + ((long) i));
        return this;
    }

    public boolean a(long offset, g bytes, int bytesOffset, int byteCount) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        if (offset >= 0 && bytesOffset >= 0 && byteCount >= 0 && getSize() - offset >= byteCount && bytes.j() - bytesOffset >= byteCount) {
            for (int i = 0; i < byteCount; i++) {
                if (a(((long) i) + offset) == bytes.a(bytesOffset + i)) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // sdk.pendo.io.s2.f
    public long a(y sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        long size = getSize();
        if (size > 0) {
            sink.a(this, size);
        }
        return size;
    }

    public final a a(a unsafeCursor) {
        Intrinsics.checkNotNullParameter(unsafeCursor, "unsafeCursor");
        return sdk.pendo.io.t2.a.a(this, unsafeCursor);
    }

    public static /* synthetic */ a a(d dVar, a aVar, int i, Object obj) {
        if ((i & 1) != 0) {
            aVar = sdk.pendo.io.s2.b.b();
        }
        return dVar.a(aVar);
    }

    @Override // sdk.pendo.io.s2.f
    public int a(r options) throws EOFException {
        Intrinsics.checkNotNullParameter(options, "options");
        int iA = sdk.pendo.io.t2.a.a(this, options, false, 2, null);
        if (iA == -1) {
            return -1;
        }
        skip(options.getByteStrings()[iA].j());
        return iA;
    }

    public final g a(int byteCount) {
        if (byteCount == 0) {
            return g.e;
        }
        sdk.pendo.io.s2.b.a(getSize(), 0L, byteCount);
        v vVar = this.head;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i2 < byteCount) {
            Intrinsics.checkNotNull(vVar);
            int i4 = vVar.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String;
            int i5 = vVar.pos;
            if (i4 == i5) {
                throw new AssertionError("s.limit == s.pos");
            }
            i2 += i4 - i5;
            i3++;
            vVar = vVar.external.sdk.pendo.io.mozilla.javascript.ES6Iterator.NEXT_METHOD java.lang.String;
        }
        byte[][] bArr = new byte[i3][];
        int[] iArr = new int[i3 * 2];
        v vVar2 = this.head;
        int i6 = 0;
        while (i < byteCount) {
            Intrinsics.checkNotNull(vVar2);
            bArr[i6] = vVar2.data;
            i += vVar2.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String - vVar2.pos;
            iArr[i6] = Math.min(i, byteCount);
            iArr[i6 + i3] = vVar2.pos;
            vVar2.shared = true;
            i6++;
            vVar2 = vVar2.external.sdk.pendo.io.mozilla.javascript.ES6Iterator.NEXT_METHOD java.lang.String;
        }
        return new x(bArr, iArr);
    }

    @Override // sdk.pendo.io.s2.e
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public d write(byte[] source) {
        Intrinsics.checkNotNullParameter(source, "source");
        return write(source, 0, source.length);
    }

    @Override // sdk.pendo.io.s2.e
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public d write(byte[] source, int offset, int byteCount) {
        Intrinsics.checkNotNullParameter(source, "source");
        long j = byteCount;
        sdk.pendo.io.s2.b.a(source.length, offset, j);
        int i = byteCount + offset;
        while (offset < i) {
            v vVarB = b(1);
            int iMin = Math.min(i - offset, 8192 - vVarB.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String);
            int i2 = offset + iMin;
            ArraysKt.copyInto(source, vVarB.data, vVarB.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String, offset, i2);
            vVarB.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String += iMin;
            offset = i2;
        }
        b(getSize() + j);
        return this;
    }

    @Override // sdk.pendo.io.s2.y
    public void a(d source, long byteCount) {
        v vVar;
        Intrinsics.checkNotNullParameter(source, "source");
        if (source == this) {
            throw new IllegalArgumentException("source == this".toString());
        }
        sdk.pendo.io.s2.b.a(source.getSize(), 0L, byteCount);
        while (byteCount > 0) {
            v vVar2 = source.head;
            Intrinsics.checkNotNull(vVar2);
            int i = vVar2.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String;
            v vVar3 = source.head;
            Intrinsics.checkNotNull(vVar3);
            if (byteCount < i - vVar3.pos) {
                v vVar4 = this.head;
                if (vVar4 != null) {
                    Intrinsics.checkNotNull(vVar4);
                    vVar = vVar4.prev;
                } else {
                    vVar = null;
                }
                if (vVar != null && vVar.owner) {
                    if ((((long) vVar.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String) + byteCount) - ((long) (vVar.shared ? 0 : vVar.pos)) <= 8192) {
                        v vVar5 = source.head;
                        Intrinsics.checkNotNull(vVar5);
                        vVar5.a(vVar, (int) byteCount);
                        source.b(source.getSize() - byteCount);
                        b(getSize() + byteCount);
                        return;
                    }
                }
                v vVar6 = source.head;
                Intrinsics.checkNotNull(vVar6);
                source.head = vVar6.a((int) byteCount);
            }
            v vVar7 = source.head;
            Intrinsics.checkNotNull(vVar7);
            long j = vVar7.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String - vVar7.pos;
            source.head = vVar7.b();
            v vVar8 = this.head;
            if (vVar8 == null) {
                this.head = vVar7;
                vVar7.prev = vVar7;
                vVar7.external.sdk.pendo.io.mozilla.javascript.ES6Iterator.NEXT_METHOD java.lang.String = vVar7;
            } else {
                Intrinsics.checkNotNull(vVar8);
                v vVar9 = vVar8.prev;
                Intrinsics.checkNotNull(vVar9);
                vVar9.a(vVar7).a();
            }
            source.b(source.getSize() - j);
            b(getSize() + j);
            byteCount -= j;
        }
    }

    public long a(a0 source) {
        Intrinsics.checkNotNullParameter(source, "source");
        long j = 0;
        while (true) {
            long jB = source.b(this, 8192L);
            if (jB == -1) {
                return j;
            }
            j += jB;
        }
    }

    public d a(String string, int beginIndex, int endIndex, Charset charset) {
        Intrinsics.checkNotNullParameter(string, "string");
        Intrinsics.checkNotNullParameter(charset, "charset");
        if (beginIndex < 0) {
            throw new IllegalArgumentException(("beginIndex < 0: " + beginIndex).toString());
        }
        if (endIndex < beginIndex) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + endIndex + " < " + beginIndex).toString());
        }
        if (endIndex > string.length()) {
            throw new IllegalArgumentException(("endIndex > string.length: " + endIndex + " > " + string.length()).toString());
        }
        if (Intrinsics.areEqual(charset, Charsets.UTF_8)) {
            return a(string, beginIndex, endIndex);
        }
        String strSubstring = string.substring(beginIndex, endIndex);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        byte[] bytes = strSubstring.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        return write(bytes, 0, bytes.length);
    }

    public d a(String string, Charset charset) {
        Intrinsics.checkNotNullParameter(string, "string");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return a(string, 0, string.length(), charset);
    }

    @Override // sdk.pendo.io.s2.e
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public d writeUtf8(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        return a(string, 0, string.length());
    }

    public d a(String string, int beginIndex, int endIndex) {
        char cCharAt;
        long size;
        long j;
        Intrinsics.checkNotNullParameter(string, "string");
        if (beginIndex < 0) {
            throw new IllegalArgumentException(("beginIndex < 0: " + beginIndex).toString());
        }
        if (endIndex < beginIndex) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + endIndex + " < " + beginIndex).toString());
        }
        if (endIndex > string.length()) {
            throw new IllegalArgumentException(("endIndex > string.length: " + endIndex + " > " + string.length()).toString());
        }
        while (beginIndex < endIndex) {
            char cCharAt2 = string.charAt(beginIndex);
            if (cCharAt2 < 128) {
                v vVarB = b(1);
                byte[] bArr = vVarB.data;
                int i = vVarB.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String - beginIndex;
                int iMin = Math.min(endIndex, 8192 - i);
                int i2 = beginIndex + 1;
                bArr[beginIndex + i] = (byte) cCharAt2;
                while (true) {
                    beginIndex = i2;
                    if (beginIndex >= iMin || (cCharAt = string.charAt(beginIndex)) >= 128) {
                        break;
                    }
                    i2 = beginIndex + 1;
                    bArr[beginIndex + i] = (byte) cCharAt;
                }
                int i3 = vVarB.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String;
                int i4 = (i + beginIndex) - i3;
                vVarB.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String = i3 + i4;
                b(getSize() + ((long) i4));
            } else {
                if (cCharAt2 < 2048) {
                    v vVarB2 = b(2);
                    byte[] bArr2 = vVarB2.data;
                    int i5 = vVarB2.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String;
                    bArr2[i5] = (byte) ((cCharAt2 >> 6) | 192);
                    bArr2[i5 + 1] = (byte) ((cCharAt2 & '?') | 128);
                    vVarB2.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String = i5 + 2;
                    size = getSize();
                    j = 2;
                } else if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                    v vVarB3 = b(3);
                    byte[] bArr3 = vVarB3.data;
                    int i6 = vVarB3.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String;
                    bArr3[i6] = (byte) ((cCharAt2 >> '\f') | 224);
                    bArr3[i6 + 1] = (byte) ((63 & (cCharAt2 >> 6)) | 128);
                    bArr3[i6 + 2] = (byte) ((cCharAt2 & '?') | 128);
                    vVarB3.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String = i6 + 3;
                    size = getSize();
                    j = 3;
                } else {
                    int i7 = beginIndex + 1;
                    char cCharAt3 = i7 < endIndex ? string.charAt(i7) : (char) 0;
                    if (cCharAt2 > 56319 || 56320 > cCharAt3 || cCharAt3 >= 57344) {
                        writeByte(63);
                        beginIndex = i7;
                    } else {
                        int i8 = (((cCharAt2 & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                        v vVarB4 = b(4);
                        byte[] bArr4 = vVarB4.data;
                        int i9 = vVarB4.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String;
                        bArr4[i9] = (byte) ((i8 >> 18) | PsExtractor.VIDEO_STREAM_MASK);
                        bArr4[i9 + 1] = (byte) (((i8 >> 12) & 63) | 128);
                        bArr4[i9 + 2] = (byte) (((i8 >> 6) & 63) | 128);
                        bArr4[i9 + 3] = (byte) ((i8 & 63) | 128);
                        vVarB4.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String = i9 + 4;
                        b(getSize() + 4);
                        beginIndex += 2;
                    }
                }
                b(size + j);
                beginIndex++;
            }
        }
        return this;
    }
}
