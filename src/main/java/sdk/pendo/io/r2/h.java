package sdk.pendo.io.r2;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import java.io.Closeable;
import java.io.IOException;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.ws.WebSocketProtocol;
import org.apache.hc.core5.http.HeaderElements;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0012\u0012\u0006\u0010\u001b\u001a\u00020\u0017\u0012\u0006\u0010\u001d\u001a\u00020\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u000f\u0012\u0006\u0010#\u001a\u00020 ¢\u0006\u0004\b8\u00109J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0004J\u0016\u0010\b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0004J\b\u0010\u000e\u001a\u00020\u0006H\u0016R\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001b\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0010R\u0014\u0010\u001f\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u0010R\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010)\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010&R\u0016\u0010+\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010\u0010R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0004\u0018\u0001008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0004\u0018\u0001048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106¨\u0006:"}, d2 = {"Lsdk/pendo/io/r2/h;", "Ljava/io/Closeable;", "", "opcode", "Lsdk/pendo/io/s2/g;", "payload", "", "b", "c", "code", BoxNoteConstants.BOX_NOTE_BRIDGE_KEY_REASON, CmcdData.OBJECT_TYPE_AUDIO_ONLY, "formatOpcode", "data", HeaderElements.CLOSE, "", "Z", "isClient", "Lsdk/pendo/io/s2/e;", "Lsdk/pendo/io/s2/e;", "getSink", "()Lokio/BufferedSink;", "sink", "Ljava/util/Random;", "Ljava/util/Random;", "getRandom", "()Ljava/util/Random;", "random", "d", "perMessageDeflate", "e", "noContextTakeover", "", "f", "J", "minimumDeflateSize", "Lsdk/pendo/io/s2/d;", "g", "Lsdk/pendo/io/s2/d;", "messageBuffer", CmcdData.STREAMING_FORMAT_HLS, "sinkBuffer", "i", "writerClosed", "Lsdk/pendo/io/r2/a;", "j", "Lsdk/pendo/io/r2/a;", "messageDeflater", "", "k", "[B", "maskKey", "Lsdk/pendo/io/s2/d$a;", CmcdData.STREAM_TYPE_LIVE, "Lsdk/pendo/io/s2/d$a;", "maskCursor", "<init>", "(ZLokio/BufferedSink;Ljava/util/Random;ZZJ)V", "okhttp"}, k = 1, mv = {1, 8, 0})
public final class h implements Closeable {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final boolean isClient;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final sdk.pendo.io.s2.e sink;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final Random random;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final boolean perMessageDeflate;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final boolean noContextTakeover;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final long minimumDeflateSize;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final sdk.pendo.io.s2.d messageBuffer;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private final sdk.pendo.io.s2.d sinkBuffer;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private boolean writerClosed;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private a messageDeflater;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private final byte[] maskKey;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    private final sdk.pendo.io.s2.d.a maskCursor;

    public h(boolean z, sdk.pendo.io.s2.e sink, Random random, boolean z2, boolean z3, long j) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        Intrinsics.checkNotNullParameter(random, "random");
        this.isClient = z;
        this.sink = sink;
        this.random = random;
        this.perMessageDeflate = z2;
        this.noContextTakeover = z3;
        this.minimumDeflateSize = j;
        this.messageBuffer = new sdk.pendo.io.s2.d();
        this.sinkBuffer = sink.getBufferField();
        this.maskKey = z ? new byte[4] : null;
        this.maskCursor = z ? new sdk.pendo.io.s2.d.a() : null;
    }

    private final void b(int opcode, sdk.pendo.io.s2.g payload) throws IOException {
        if (this.writerClosed) {
            throw new IOException("closed");
        }
        int iJ = payload.j();
        if (iJ > 125) {
            throw new IllegalArgumentException("Payload size must be less than or equal to 125".toString());
        }
        this.sinkBuffer.writeByte(opcode | 128);
        if (this.isClient) {
            this.sinkBuffer.writeByte(iJ | 128);
            Random random = this.random;
            byte[] bArr = this.maskKey;
            Intrinsics.checkNotNull(bArr);
            random.nextBytes(bArr);
            this.sinkBuffer.write(this.maskKey);
            if (iJ > 0) {
                long size = this.sinkBuffer.getSize();
                this.sinkBuffer.a(payload);
                sdk.pendo.io.s2.d dVar = this.sinkBuffer;
                sdk.pendo.io.s2.d.a aVar = this.maskCursor;
                Intrinsics.checkNotNull(aVar);
                dVar.a(aVar);
                this.maskCursor.b(size);
                f.a.a(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        } else {
            this.sinkBuffer.writeByte(iJ);
            this.sinkBuffer.a(payload);
        }
        this.sink.flush();
    }

    public final void a(int code, sdk.pendo.io.s2.g reason) {
        sdk.pendo.io.s2.g gVarG = sdk.pendo.io.s2.g.e;
        if (code != 0 || reason != null) {
            if (code != 0) {
                f.a.b(code);
            }
            sdk.pendo.io.s2.d dVar = new sdk.pendo.io.s2.d();
            dVar.writeShort(code);
            if (reason != null) {
                dVar.a(reason);
            }
            gVarG = dVar.g();
        }
        try {
            b(8, gVarG);
        } finally {
            this.writerClosed = true;
        }
    }

    public final void c(int formatOpcode, sdk.pendo.io.s2.g data) throws IOException {
        Intrinsics.checkNotNullParameter(data, "data");
        if (this.writerClosed) {
            throw new IOException("closed");
        }
        this.messageBuffer.a(data);
        int i = formatOpcode | 128;
        if (this.perMessageDeflate && data.j() >= this.minimumDeflateSize) {
            a aVar = this.messageDeflater;
            if (aVar == null) {
                aVar = new a(this.noContextTakeover);
                this.messageDeflater = aVar;
            }
            aVar.a(this.messageBuffer);
            i = formatOpcode | 192;
        }
        long size = this.messageBuffer.getSize();
        this.sinkBuffer.writeByte(i);
        int i2 = this.isClient ? 128 : 0;
        if (size <= 125) {
            this.sinkBuffer.writeByte(i2 | ((int) size));
        } else if (size <= WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            this.sinkBuffer.writeByte(i2 | 126);
            this.sinkBuffer.writeShort((int) size);
        } else {
            this.sinkBuffer.writeByte(i2 | 127);
            this.sinkBuffer.e(size);
        }
        if (this.isClient) {
            Random random = this.random;
            byte[] bArr = this.maskKey;
            Intrinsics.checkNotNull(bArr);
            random.nextBytes(bArr);
            this.sinkBuffer.write(this.maskKey);
            if (size > 0) {
                sdk.pendo.io.s2.d dVar = this.messageBuffer;
                sdk.pendo.io.s2.d.a aVar2 = this.maskCursor;
                Intrinsics.checkNotNull(aVar2);
                dVar.a(aVar2);
                this.maskCursor.b(0L);
                f.a.a(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        }
        this.sinkBuffer.a(this.messageBuffer, size);
        this.sink.emit();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        a aVar = this.messageDeflater;
        if (aVar != null) {
            aVar.close();
        }
    }

    public final void b(sdk.pendo.io.s2.g payload) throws IOException {
        Intrinsics.checkNotNullParameter(payload, "payload");
        b(9, payload);
    }

    public final void c(sdk.pendo.io.s2.g payload) throws IOException {
        Intrinsics.checkNotNullParameter(payload, "payload");
        b(10, payload);
    }
}
