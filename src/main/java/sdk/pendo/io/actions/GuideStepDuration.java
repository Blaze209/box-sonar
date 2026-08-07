package sdk.pendo.io.actions;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\fR\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0006\"\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lsdk/pendo/io/actions/GuideStepDuration;", "", "()V", "duration", "", "getDuration", "()J", "startDuration", "getStartDuration", "setStartDuration", "(J)V", "reset", "", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GuideStepDuration {
    private long startDuration;

    public final long getDuration() {
        if (this.startDuration > 0) {
            return System.currentTimeMillis() - this.startDuration;
        }
        return 0L;
    }

    public final long getStartDuration() {
        return this.startDuration;
    }

    public final void reset() {
        this.startDuration = 0L;
    }

    public final void setStartDuration(long j) {
        this.startDuration = j;
    }
}
