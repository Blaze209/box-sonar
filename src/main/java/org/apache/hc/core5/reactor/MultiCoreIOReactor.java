package org.apache.hc.core5.reactor;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.hc.core5.io.CloseMode;
import org.apache.hc.core5.io.Closer;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.TimeValue;
import org.apache.hc.core5.util.Timeout;

/* JADX INFO: loaded from: classes5.dex */
class MultiCoreIOReactor implements IOReactor {
    private final IOReactor[] ioReactors;
    private final AtomicReference<IOReactorStatus> status = new AtomicReference<>(IOReactorStatus.INACTIVE);
    private final AtomicBoolean terminated = new AtomicBoolean();
    private final Thread[] threads;

    MultiCoreIOReactor(IOReactor[] iOReactorArr, Thread[] threadArr) {
        this.ioReactors = (IOReactor[]) iOReactorArr.clone();
        this.threads = (Thread[]) threadArr.clone();
    }

    @Override // org.apache.hc.core5.reactor.IOReactor
    public IOReactorStatus getStatus() {
        return this.status.get();
    }

    public final void start() {
        if (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.status, IOReactorStatus.INACTIVE, IOReactorStatus.ACTIVE)) {
            return;
        }
        int i = 0;
        while (true) {
            Thread[] threadArr = this.threads;
            if (i >= threadArr.length) {
                return;
            }
            threadArr[i].start();
            i++;
        }
    }

    @Override // org.apache.hc.core5.reactor.IOReactor
    public final void initiateShutdown() {
        if (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.status, IOReactorStatus.INACTIVE, IOReactorStatus.SHUT_DOWN) && !PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.status, IOReactorStatus.ACTIVE, IOReactorStatus.SHUTTING_DOWN)) {
            return;
        }
        int i = 0;
        while (true) {
            IOReactor[] iOReactorArr = this.ioReactors;
            if (i >= iOReactorArr.length) {
                return;
            }
            iOReactorArr[i].initiateShutdown();
            i++;
        }
    }

    @Override // org.apache.hc.core5.reactor.IOReactor
    public final void awaitShutdown(TimeValue timeValue) throws InterruptedException {
        Args.notNull(timeValue, "Wait time");
        long jCurrentTimeMillis = System.currentTimeMillis() + timeValue.toMilliseconds();
        long milliseconds = timeValue.toMilliseconds();
        int i = 0;
        int i2 = 0;
        while (true) {
            IOReactor[] iOReactorArr = this.ioReactors;
            if (i2 < iOReactorArr.length) {
                IOReactor iOReactor = iOReactorArr[i2];
                if (iOReactor.getStatus().compareTo(IOReactorStatus.SHUT_DOWN) < 0) {
                    iOReactor.awaitShutdown(TimeValue.of(milliseconds, TimeUnit.MILLISECONDS));
                    milliseconds = jCurrentTimeMillis - System.currentTimeMillis();
                    if (milliseconds <= 0) {
                        return;
                    }
                }
                i2++;
            } else {
                while (true) {
                    Thread[] threadArr = this.threads;
                    if (i >= threadArr.length) {
                        return;
                    }
                    threadArr[i].join(milliseconds);
                    milliseconds = jCurrentTimeMillis - System.currentTimeMillis();
                    if (milliseconds <= 0) {
                        return;
                    } else {
                        i++;
                    }
                }
            }
        }
    }

    @Override // org.apache.hc.core5.reactor.IOReactor, org.apache.hc.core5.io.ModalCloseable
    public final void close(CloseMode closeMode) {
        close(closeMode, Timeout.ofSeconds(5L));
    }

    public void close(CloseMode closeMode, Timeout timeout) {
        if (closeMode == CloseMode.GRACEFUL) {
            initiateShutdown();
            try {
                awaitShutdown(timeout);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
        this.status.set(IOReactorStatus.SHUT_DOWN);
        int i = 0;
        if (!this.terminated.compareAndSet(false, true)) {
            return;
        }
        int i2 = 0;
        while (true) {
            IOReactor[] iOReactorArr = this.ioReactors;
            if (i2 >= iOReactorArr.length) {
                break;
            }
            Closer.close(iOReactorArr[i2], CloseMode.IMMEDIATE);
            i2++;
        }
        while (true) {
            Thread[] threadArr = this.threads;
            if (i >= threadArr.length) {
                return;
            }
            threadArr[i].interrupt();
            i++;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        close(CloseMode.GRACEFUL);
    }

    public String toString() {
        return getClass().getSimpleName() + " [status=" + this.status + "]";
    }
}
