package sdk.pendo.io.s2;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.microsoft.identity.common.nativeauth.internal.commands.ResetPasswordSubmitNewPasswordCommand;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 \t2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\u0000H\u0016J\b\u0010\u0006\u001a\u00020\u0000H\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J/\u0010\u0013\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\u0010\u001a\u00020\u00002\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0015R\u0016\u0010\u000b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0017\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001b"}, d2 = {"Lsdk/pendo/io/s2/b0;", "", "", ResetPasswordSubmitNewPasswordCommand.POLL_COMPLETION_TIMEOUT_ERROR_CODE, "Ljava/util/concurrent/TimeUnit;", "unit", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "f", "", "d", "c", "deadlineNanoTime", "b", "", "e", ExifInterface.GPS_DIRECTION_TRUE, "other", "Lkotlin/Function0;", "block", "intersectWith", "(Lokio/Timeout;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Z", "hasDeadline", "J", "timeoutNanos", "<init>", "()V", "external.sdk.pendo.io.okio"}, k = 1, mv = {1, 9, 0})
public class b0 {
    public static final b0 e = new a();

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private boolean hasDeadline;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private long deadlineNanoTime;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private long timeoutNanos;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"sdk/pendo/io/s2/b0$a", "Lsdk/pendo/io/s2/b0;", "", ResetPasswordSubmitNewPasswordCommand.POLL_COMPLETION_TIMEOUT_ERROR_CODE, "Ljava/util/concurrent/TimeUnit;", "unit", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "deadlineNanoTime", "", "e", "external.sdk.pendo.io.okio"}, k = 1, mv = {1, 9, 0})
    public static final class a extends b0 {
        a() {
        }

        @Override // sdk.pendo.io.s2.b0
        public b0 a(long deadlineNanoTime) {
            return this;
        }

        @Override // sdk.pendo.io.s2.b0
        public void e() {
        }

        @Override // sdk.pendo.io.s2.b0
        public b0 a(long timeout, TimeUnit unit) {
            Intrinsics.checkNotNullParameter(unit, "unit");
            return this;
        }
    }

    public b0 a() {
        this.hasDeadline = false;
        return this;
    }

    public b0 b() {
        this.timeoutNanos = 0L;
        return this;
    }

    public long c() {
        if (this.hasDeadline) {
            return this.deadlineNanoTime;
        }
        throw new IllegalStateException("No deadline".toString());
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public boolean getHasDeadline() {
        return this.hasDeadline;
    }

    public void e() throws InterruptedIOException {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        if (this.hasDeadline && this.deadlineNanoTime - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public long getTimeoutNanos() {
        return this.timeoutNanos;
    }

    public b0 a(long deadlineNanoTime) {
        this.hasDeadline = true;
        this.deadlineNanoTime = deadlineNanoTime;
        return this;
    }

    public b0 a(long timeout, TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (timeout < 0) {
            throw new IllegalArgumentException(("timeout < 0: " + timeout).toString());
        }
        this.timeoutNanos = unit.toNanos(timeout);
        return this;
    }
}
