package sdk.pendo.io.s2;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.microsoft.identity.common.nativeauth.internal.commands.ResetPasswordSubmitNewPasswordCommand;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0014\u0010\u0013J\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\u0010\u0010\u0003\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u0001H\u0016J\b\u0010\u0003\u001a\u00020\u0001H\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016R\"\u0010\u0002\u001a\u00020\u00018\u0007@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0010\u001a\u0004\b\u0002\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lsdk/pendo/io/s2/k;", "Lsdk/pendo/io/s2/b0;", "delegate", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", ResetPasswordSubmitNewPasswordCommand.POLL_COMPLETION_TIMEOUT_ERROR_CODE, "Ljava/util/concurrent/TimeUnit;", "unit", "f", "", "d", "c", "deadlineNanoTime", "b", "", "e", "Lsdk/pendo/io/s2/b0;", "()Lokio/Timeout;", "setDelegate", "(Lokio/Timeout;)V", "<init>", "external.sdk.pendo.io.okio"}, k = 1, mv = {1, 9, 0})
public class k extends b0 {

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private b0 delegate;

    public k(b0 delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    @Override // sdk.pendo.io.s2.b0
    public b0 a() {
        return this.delegate.a();
    }

    @Override // sdk.pendo.io.s2.b0
    public b0 b() {
        return this.delegate.b();
    }

    @Override // sdk.pendo.io.s2.b0
    public long c() {
        return this.delegate.c();
    }

    @Override // sdk.pendo.io.s2.b0
    /* JADX INFO: renamed from: d */
    public boolean getHasDeadline() {
        return this.delegate.getHasDeadline();
    }

    @Override // sdk.pendo.io.s2.b0
    public void e() throws InterruptedIOException {
        this.delegate.e();
    }

    @Override // sdk.pendo.io.s2.b0
    /* JADX INFO: renamed from: f */
    public long getTimeoutNanos() {
        return this.delegate.getTimeoutNanos();
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final b0 getDelegate() {
        return this.delegate;
    }

    @Override // sdk.pendo.io.s2.b0
    public b0 a(long deadlineNanoTime) {
        return this.delegate.a(deadlineNanoTime);
    }

    public final k a(b0 delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
        return this;
    }

    @Override // sdk.pendo.io.s2.b0
    public b0 a(long timeout, TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return this.delegate.a(timeout, unit);
    }
}
