package sdk.pendo.io.s2;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.microsoft.identity.common.nativeauth.internal.commands.ResetPasswordSubmitNewPasswordCommand;
import java.io.IOException;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.hc.core5.http.HeaderElements;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016R\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u000fR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lsdk/pendo/io/s2/s;", "Lsdk/pendo/io/s2/y;", "Lsdk/pendo/io/s2/d;", "source", "", "byteCount", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "flush", HeaderElements.CLOSE, "Lsdk/pendo/io/s2/b0;", ResetPasswordSubmitNewPasswordCommand.POLL_COMPLETION_TIMEOUT_ERROR_CODE, "", "toString", "Ljava/io/OutputStream;", "Ljava/io/OutputStream;", "out", "b", "Lsdk/pendo/io/s2/b0;", "<init>", "(Ljava/io/OutputStream;Lokio/Timeout;)V", "external.sdk.pendo.io.okio"}, k = 1, mv = {1, 9, 0})
final class s implements y {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final OutputStream out;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final b0 timeout;

    public s(OutputStream out, b0 timeout) {
        Intrinsics.checkNotNullParameter(out, "out");
        Intrinsics.checkNotNullParameter(timeout, "timeout");
        this.out = out;
        this.timeout = timeout;
    }

    @Override // sdk.pendo.io.s2.y
    public void a(d source, long byteCount) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        b.a(source.getSize(), 0L, byteCount);
        while (byteCount > 0) {
            this.timeout.e();
            v vVar = source.head;
            Intrinsics.checkNotNull(vVar);
            int iMin = (int) Math.min(byteCount, vVar.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String - vVar.pos);
            this.out.write(vVar.data, vVar.pos, iMin);
            vVar.pos += iMin;
            long j = iMin;
            byteCount -= j;
            source.b(source.getSize() - j);
            if (vVar.pos == vVar.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String) {
                source.head = vVar.b();
                w.a(vVar);
            }
        }
    }

    @Override // sdk.pendo.io.s2.y, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
    }

    @Override // sdk.pendo.io.s2.y, java.io.Flushable
    public void flush() throws IOException {
        this.out.flush();
    }

    @Override // sdk.pendo.io.s2.y
    /* JADX INFO: renamed from: timeout, reason: from getter */
    public b0 getTimeout() {
        return this.timeout;
    }

    public String toString() {
        return "sink(" + this.out + ')';
    }
}
