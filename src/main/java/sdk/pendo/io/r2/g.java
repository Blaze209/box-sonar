package sdk.pendo.io.r2;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.hc.core5.http.HeaderElements;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\bB/\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\n\u0012\u0006\u0010\u0016\u001a\u00020\n¢\u0006\u0004\b8\u00109J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0006\u0010\b\u001a\u00020\u0002J\b\u0010\t\u001a\u00020\u0002H\u0016R\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u000bR\u0014\u0010\u0016\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000bR\u0016\u0010\u0017\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u000bR\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\u000bR\u0016\u0010#\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010\u000bR\u0016\u0010%\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010\u000bR\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010+\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010(R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0004\u0018\u0001008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0004\u0018\u0001048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106¨\u0006:"}, d2 = {"Lsdk/pendo/io/r2/g;", "Ljava/io/Closeable;", "", "c", "b", "e", "f", "d", CmcdData.OBJECT_TYPE_AUDIO_ONLY, HeaderElements.CLOSE, "", "Z", "isClient", "Lsdk/pendo/io/s2/f;", "Lsdk/pendo/io/s2/f;", "getSource", "()Lokio/BufferedSource;", "source", "Lsdk/pendo/io/r2/g$a;", "Lsdk/pendo/io/r2/g$a;", "frameCallback", "perMessageDeflate", "noContextTakeover", "closed", "", "g", "I", "opcode", "", CmcdData.STREAMING_FORMAT_HLS, "J", "frameLength", "i", "isFinalFrame", "j", "isControlFrame", "k", "readingCompressedMessage", "Lsdk/pendo/io/s2/d;", CmcdData.STREAM_TYPE_LIVE, "Lsdk/pendo/io/s2/d;", "controlFrameBuffer", CmcdData.OBJECT_TYPE_MANIFEST, "messageFrameBuffer", "Lsdk/pendo/io/r2/c;", "n", "Lsdk/pendo/io/r2/c;", "messageInflater", "", "o", "[B", "maskKey", "Lsdk/pendo/io/s2/d$a;", "p", "Lsdk/pendo/io/s2/d$a;", "maskCursor", "<init>", "(ZLokio/BufferedSource;Lokhttp3/internal/ws/WebSocketReader$FrameCallback;ZZ)V", "okhttp"}, k = 1, mv = {1, 8, 0})
public final class g implements Closeable {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final boolean isClient;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final sdk.pendo.io.s2.f source;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final a frameCallback;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final boolean perMessageDeflate;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final boolean noContextTakeover;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private boolean closed;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private int opcode;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private long frameLength;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private boolean isFinalFrame;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private boolean isControlFrame;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private boolean readingCompressedMessage;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    private final sdk.pendo.io.s2.d controlFrameBuffer;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    private final sdk.pendo.io.s2.d messageFrameBuffer;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    private c messageInflater;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    private final byte[] maskKey;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    private final sdk.pendo.io.s2.d.a maskCursor;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006H&J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006H&J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0002H&¨\u0006\u0010"}, d2 = {"Lsdk/pendo/io/r2/g$a;", "", "", "text", "", "onReadMessage", "Lsdk/pendo/io/s2/g;", "bytes", "d", "payload", "b", "c", "", "code", BoxNoteConstants.BOX_NOTE_BRIDGE_KEY_REASON, "onReadClose", "okhttp"}, k = 1, mv = {1, 8, 0})
    public interface a {
        void b(sdk.pendo.io.s2.g payload);

        void c(sdk.pendo.io.s2.g payload);

        void d(sdk.pendo.io.s2.g bytes);

        void onReadClose(int code, String reason);

        void onReadMessage(String text);
    }

    public g(boolean z, sdk.pendo.io.s2.f source, a frameCallback, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(frameCallback, "frameCallback");
        this.isClient = z;
        this.source = source;
        this.frameCallback = frameCallback;
        this.perMessageDeflate = z2;
        this.noContextTakeover = z3;
        this.controlFrameBuffer = new sdk.pendo.io.s2.d();
        this.messageFrameBuffer = new sdk.pendo.io.s2.d();
        this.maskKey = z ? null : new byte[4];
        this.maskCursor = z ? null : new sdk.pendo.io.s2.d.a();
    }

    private final void b() throws ProtocolException, EOFException {
        short s;
        String utf8;
        long j = this.frameLength;
        if (j > 0) {
            this.source.c(this.controlFrameBuffer, j);
            if (!this.isClient) {
                sdk.pendo.io.s2.d dVar = this.controlFrameBuffer;
                sdk.pendo.io.s2.d.a aVar = this.maskCursor;
                Intrinsics.checkNotNull(aVar);
                dVar.a(aVar);
                this.maskCursor.b(0L);
                f fVar = f.a;
                sdk.pendo.io.s2.d.a aVar2 = this.maskCursor;
                byte[] bArr = this.maskKey;
                Intrinsics.checkNotNull(bArr);
                fVar.a(aVar2, bArr);
                this.maskCursor.close();
            }
        }
        switch (this.opcode) {
            case 8:
                long size = this.controlFrameBuffer.getSize();
                if (size == 1) {
                    throw new ProtocolException("Malformed close payload length of 1.");
                }
                if (size != 0) {
                    s = this.controlFrameBuffer.readShort();
                    utf8 = this.controlFrameBuffer.readUtf8();
                    String strA = f.a.a(s);
                    if (strA != null) {
                        throw new ProtocolException(strA);
                    }
                } else {
                    s = 1005;
                    utf8 = "";
                }
                this.frameCallback.onReadClose(s, utf8);
                this.closed = true;
                return;
            case 9:
                this.frameCallback.b(this.controlFrameBuffer.g());
                return;
            case 10:
                this.frameCallback.c(this.controlFrameBuffer.g());
                return;
            default:
                throw new ProtocolException("Unknown control opcode: " + sdk.pendo.io.f2.b.a(this.opcode));
        }
    }

    private final void c() throws IOException {
        boolean z;
        if (this.closed) {
            throw new IOException("closed");
        }
        long timeoutNanos = this.source.getTimeout().getTimeoutNanos();
        this.source.getTimeout().b();
        try {
            int iA = sdk.pendo.io.f2.b.a(this.source.readByte(), 255);
            this.source.getTimeout().a(timeoutNanos, TimeUnit.NANOSECONDS);
            int i = iA & 15;
            this.opcode = i;
            boolean z2 = (iA & 128) != 0;
            this.isFinalFrame = z2;
            boolean z3 = (iA & 8) != 0;
            this.isControlFrame = z3;
            if (z3 && !z2) {
                throw new ProtocolException("Control frames must be final.");
            }
            boolean z4 = (iA & 64) != 0;
            if (i == 1 || i == 2) {
                if (!z4) {
                    z = false;
                } else {
                    if (!this.perMessageDeflate) {
                        throw new ProtocolException("Unexpected rsv1 flag");
                    }
                    z = true;
                }
                this.readingCompressedMessage = z;
            } else if (z4) {
                throw new ProtocolException("Unexpected rsv1 flag");
            }
            if ((iA & 32) != 0) {
                throw new ProtocolException("Unexpected rsv2 flag");
            }
            if ((iA & 16) != 0) {
                throw new ProtocolException("Unexpected rsv3 flag");
            }
            int iA2 = sdk.pendo.io.f2.b.a(this.source.readByte(), 255);
            boolean z5 = (iA2 & 128) != 0;
            if (z5 == this.isClient) {
                throw new ProtocolException(this.isClient ? "Server-sent frames must not be masked." : "Client-sent frames must be masked.");
            }
            long j = iA2 & 127;
            this.frameLength = j;
            if (j == 126) {
                this.frameLength = sdk.pendo.io.f2.b.a(this.source.readShort(), 65535);
            } else if (j == 127) {
                long j2 = this.source.readLong();
                this.frameLength = j2;
                if (j2 < 0) {
                    throw new ProtocolException("Frame length 0x" + sdk.pendo.io.f2.b.a(this.frameLength) + " > 0x7FFFFFFFFFFFFFFF");
                }
            }
            if (this.isControlFrame && this.frameLength > 125) {
                throw new ProtocolException("Control frame must be less than 125B.");
            }
            if (z5) {
                sdk.pendo.io.s2.f fVar = this.source;
                byte[] bArr = this.maskKey;
                Intrinsics.checkNotNull(bArr);
                fVar.readFully(bArr);
            }
        } catch (Throwable th) {
            this.source.getTimeout().a(timeoutNanos, TimeUnit.NANOSECONDS);
            throw th;
        }
    }

    private final void d() throws IOException {
        while (!this.closed) {
            long j = this.frameLength;
            if (j > 0) {
                this.source.c(this.messageFrameBuffer, j);
                if (!this.isClient) {
                    sdk.pendo.io.s2.d dVar = this.messageFrameBuffer;
                    sdk.pendo.io.s2.d.a aVar = this.maskCursor;
                    Intrinsics.checkNotNull(aVar);
                    dVar.a(aVar);
                    this.maskCursor.b(this.messageFrameBuffer.getSize() - this.frameLength);
                    f fVar = f.a;
                    sdk.pendo.io.s2.d.a aVar2 = this.maskCursor;
                    byte[] bArr = this.maskKey;
                    Intrinsics.checkNotNull(bArr);
                    fVar.a(aVar2, bArr);
                    this.maskCursor.close();
                }
            }
            if (this.isFinalFrame) {
                return;
            }
            f();
            if (this.opcode != 0) {
                throw new ProtocolException("Expected continuation opcode. Got: " + sdk.pendo.io.f2.b.a(this.opcode));
            }
        }
        throw new IOException("closed");
    }

    private final void e() throws IOException {
        int i = this.opcode;
        if (i != 1 && i != 2) {
            throw new ProtocolException("Unknown opcode: " + sdk.pendo.io.f2.b.a(i));
        }
        d();
        if (this.readingCompressedMessage) {
            c cVar = this.messageInflater;
            if (cVar == null) {
                cVar = new c(this.noContextTakeover);
                this.messageInflater = cVar;
            }
            cVar.a(this.messageFrameBuffer);
        }
        if (i == 1) {
            this.frameCallback.onReadMessage(this.messageFrameBuffer.readUtf8());
        } else {
            this.frameCallback.d(this.messageFrameBuffer.g());
        }
    }

    private final void f() throws IOException {
        while (!this.closed) {
            c();
            if (!this.isControlFrame) {
                return;
            } else {
                b();
            }
        }
    }

    public final void a() {
        c();
        if (this.isControlFrame) {
            b();
        } else {
            e();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        c cVar = this.messageInflater;
        if (cVar != null) {
            cVar.close();
        }
    }
}
