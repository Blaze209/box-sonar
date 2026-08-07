package sdk.pendo.io.s2;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.microsoft.identity.common.nativeauth.internal.commands.ResetPasswordSubmitNewPasswordCommand;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.hc.core5.http.HeaderElements;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0012\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0011¨\u0006\u0014"}, d2 = {"Lsdk/pendo/io/s2/n;", "Lsdk/pendo/io/s2/a0;", "Lsdk/pendo/io/s2/d;", "sink", "", "byteCount", "b", "", HeaderElements.CLOSE, "Lsdk/pendo/io/s2/b0;", ResetPasswordSubmitNewPasswordCommand.POLL_COMPLETION_TIMEOUT_ERROR_CODE, "", "toString", "Ljava/io/InputStream;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Ljava/io/InputStream;", "input", "Lsdk/pendo/io/s2/b0;", "<init>", "(Ljava/io/InputStream;Lokio/Timeout;)V", "external.sdk.pendo.io.okio"}, k = 1, mv = {1, 9, 0})
class n implements a0 {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final InputStream input;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final b0 timeout;

    public n(InputStream input, b0 timeout) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(timeout, "timeout");
        this.input = input;
        this.timeout = timeout;
    }

    @Override // sdk.pendo.io.s2.a0
    public long b(d sink, long byteCount) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (byteCount == 0) {
            return 0L;
        }
        if (byteCount < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
        }
        try {
            this.timeout.e();
            v vVarB = sink.b(1);
            int i = this.input.read(vVarB.data, vVarB.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String, (int) Math.min(byteCount, 8192 - vVarB.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String));
            if (i != -1) {
                vVarB.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String += i;
                long j = i;
                sink.b(sink.getSize() + j);
                return j;
            }
            if (vVarB.pos != vVarB.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String) {
                return -1L;
            }
            sink.head = vVarB.b();
            w.a(vVarB);
            return -1L;
        } catch (AssertionError e) {
            if (o.a(e)) {
                throw new IOException(e);
            }
            throw e;
        }
    }

    @Override // sdk.pendo.io.s2.a0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.input.close();
    }

    @Override // sdk.pendo.io.s2.a0
    /* JADX INFO: renamed from: timeout, reason: from getter */
    public b0 getTimeout() {
        return this.timeout;
    }

    public String toString() {
        return "source(" + this.input + ')';
    }
}
