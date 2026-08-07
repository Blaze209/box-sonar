package sdk.pendo.io.s2;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.microsoft.identity.common.nativeauth.internal.commands.ResetPasswordSubmitNewPasswordCommand;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.hc.core5.http.HeaderElements;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\fH\u0016R\u0017\u0010\u000f\u001a\u00020\u00018\u0007¢\u0006\f\n\u0004\b\u0007\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lsdk/pendo/io/s2/i;", "Lsdk/pendo/io/s2/y;", "Lsdk/pendo/io/s2/d;", "source", "", "byteCount", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "flush", "Lsdk/pendo/io/s2/b0;", ResetPasswordSubmitNewPasswordCommand.POLL_COMPLETION_TIMEOUT_ERROR_CODE, HeaderElements.CLOSE, "", "toString", "Lsdk/pendo/io/s2/y;", "delegate", "()Lokio/Sink;", "<init>", "(Lokio/Sink;)V", "external.sdk.pendo.io.okio"}, k = 1, mv = {1, 9, 0})
public abstract class i implements y {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final y delegate;

    public i(y delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    @Override // sdk.pendo.io.s2.y
    public void a(d source, long byteCount) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.delegate.a(source, byteCount);
    }

    @Override // sdk.pendo.io.s2.y, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    @Override // sdk.pendo.io.s2.y, java.io.Flushable
    public void flush() {
        this.delegate.flush();
    }

    @Override // sdk.pendo.io.s2.y
    public b0 timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }
}
