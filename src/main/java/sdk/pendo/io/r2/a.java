package sdk.pendo.io.r2;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.io.Closeable;
import java.io.IOException;
import java.util.zip.Deflater;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import org.apache.hc.core5.http.HeaderElements;
import sdk.pendo.io.s2.y;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\u0014\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u000e\u0010\u0006\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002J\b\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\u000b\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lsdk/pendo/io/r2/a;", "Ljava/io/Closeable;", "Lsdk/pendo/io/s2/d;", "Lsdk/pendo/io/s2/g;", "suffix", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "buffer", "", HeaderElements.CLOSE, "Z", "noContextTakeover", "b", "Lsdk/pendo/io/s2/d;", "deflatedBytes", "Ljava/util/zip/Deflater;", "c", "Ljava/util/zip/Deflater;", "deflater", "Lsdk/pendo/io/s2/h;", "d", "Lsdk/pendo/io/s2/h;", "deflaterSink", "<init>", "(Z)V", "okhttp"}, k = 1, mv = {1, 8, 0})
public final class a implements Closeable {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final boolean noContextTakeover;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final sdk.pendo.io.s2.d deflatedBytes;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final Deflater deflater;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final sdk.pendo.io.s2.h deflaterSink;

    public a(boolean z) {
        this.noContextTakeover = z;
        sdk.pendo.io.s2.d dVar = new sdk.pendo.io.s2.d();
        this.deflatedBytes = dVar;
        Deflater deflater = new Deflater(-1, true);
        this.deflater = deflater;
        this.deflaterSink = new sdk.pendo.io.s2.h((y) dVar, deflater);
    }

    public final void a(sdk.pendo.io.s2.d buffer) throws IOException {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        if (this.deflatedBytes.getSize() != 0) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (this.noContextTakeover) {
            this.deflater.reset();
        }
        this.deflaterSink.a(buffer, buffer.getSize());
        this.deflaterSink.flush();
        if (a(this.deflatedBytes, b.a)) {
            long size = this.deflatedBytes.getSize() - ((long) 4);
            sdk.pendo.io.s2.d.a aVarA = sdk.pendo.io.s2.d.a(this.deflatedBytes, (sdk.pendo.io.s2.d.a) null, 1, (Object) null);
            try {
                aVarA.a(size);
                CloseableKt.closeFinally(aVarA, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(aVarA, th);
                    throw th2;
                }
            }
        } else {
            this.deflatedBytes.writeByte(0);
        }
        sdk.pendo.io.s2.d dVar = this.deflatedBytes;
        buffer.a(dVar, dVar.getSize());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        this.deflaterSink.close();
    }

    private final boolean a(sdk.pendo.io.s2.d dVar, sdk.pendo.io.s2.g gVar) {
        return dVar.a(dVar.getSize() - ((long) gVar.j()), gVar);
    }
}
