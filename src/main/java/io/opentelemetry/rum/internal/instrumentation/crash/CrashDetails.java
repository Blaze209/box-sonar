package io.opentelemetry.rum.internal.instrumentation.crash;

/* JADX INFO: loaded from: classes4.dex */
public final class CrashDetails {
    private final Throwable cause;
    private final Thread thread;

    public static CrashDetails create(Thread thread, Throwable th) {
        return new CrashDetails(thread, th);
    }

    CrashDetails(Thread thread, Throwable th) {
        this.thread = thread;
        this.cause = th;
    }

    public Thread getThread() {
        return this.thread;
    }

    public Throwable getCause() {
        return this.cause;
    }

    String spanName() {
        return getCause().getClass().getSimpleName();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CrashDetails crashDetails = (CrashDetails) obj;
        if (this.thread.equals(crashDetails.thread)) {
            return this.cause.equals(crashDetails.cause);
        }
        return false;
    }

    public int hashCode() {
        return (this.thread.hashCode() * 31) + this.cause.hashCode();
    }
}
