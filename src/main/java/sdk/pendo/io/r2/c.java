package sdk.pendo.io.r2;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.io.Closeable;
import java.io.IOException;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.hc.core5.http.HeaderElements;
import sdk.pendo.io.s2.a0;
import sdk.pendo.io.s2.m;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016R\u0014\u0010\t\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\bR\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lsdk/pendo/io/r2/c;", "Ljava/io/Closeable;", "Lsdk/pendo/io/s2/d;", "buffer", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, HeaderElements.CLOSE, "", "Z", "noContextTakeover", "b", "Lsdk/pendo/io/s2/d;", "deflatedBytes", "Ljava/util/zip/Inflater;", "c", "Ljava/util/zip/Inflater;", "inflater", "Lsdk/pendo/io/s2/m;", "d", "Lsdk/pendo/io/s2/m;", "inflaterSource", "<init>", "(Z)V", "okhttp"}, k = 1, mv = {1, 8, 0})
public final class c implements Closeable {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final boolean noContextTakeover;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final sdk.pendo.io.s2.d deflatedBytes;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final Inflater inflater;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final m inflaterSource;

    public c(boolean z) {
        this.noContextTakeover = z;
        sdk.pendo.io.s2.d dVar = new sdk.pendo.io.s2.d();
        this.deflatedBytes = dVar;
        Inflater inflater = new Inflater(true);
        this.inflater = inflater;
        this.inflaterSource = new m((a0) dVar, inflater);
    }

    public final void a(sdk.pendo.io.s2.d buffer) throws IOException {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        if (this.deflatedBytes.getSize() != 0) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (this.noContextTakeover) {
            this.inflater.reset();
        }
        this.deflatedBytes.a((a0) buffer);
        this.deflatedBytes.writeInt(65535);
        long bytesRead = this.inflater.getBytesRead() + this.deflatedBytes.getSize();
        do {
            this.inflaterSource.d(buffer, Long.MAX_VALUE);
        } while (this.inflater.getBytesRead() < bytesRead);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.inflaterSource.close();
    }
}
