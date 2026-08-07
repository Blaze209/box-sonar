package org.apache.hc.core5.reactor;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import java.io.Closeable;
import java.io.IOException;
import java.nio.channels.ClosedSelectorException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.hc.core5.function.Callback;
import org.apache.hc.core5.io.CloseMode;
import org.apache.hc.core5.io.Closer;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.TimeValue;
import org.apache.hc.core5.util.Timeout;

/* JADX INFO: loaded from: classes5.dex */
abstract class AbstractSingleCoreIOReactor implements IOReactor {
    private final Condition condition;
    private final Callback<Exception> exceptionCallback;
    private final ReentrantLock lock;
    final Selector selector;
    private final AtomicReference<IOReactorStatus> status = new AtomicReference<>(IOReactorStatus.INACTIVE);
    private final AtomicBoolean terminated = new AtomicBoolean();

    abstract void doExecute() throws IOException;

    abstract void doTerminate() throws IOException;

    AbstractSingleCoreIOReactor(Callback<Exception> callback) {
        this.exceptionCallback = callback;
        try {
            this.selector = Selector.open();
            ReentrantLock reentrantLock = new ReentrantLock();
            this.lock = reentrantLock;
            this.condition = reentrantLock.newCondition();
        } catch (IOException e) {
            throw new IllegalStateException("Unexpected failure opening I/O selector", e);
        }
    }

    @Override // org.apache.hc.core5.reactor.IOReactor
    public final IOReactorStatus getStatus() {
        return this.status.get();
    }

    void logException(Exception exc) {
        Callback<Exception> callback = this.exceptionCallback;
        if (callback != null) {
            callback.execute(exc);
        }
    }

    public void execute() {
        try {
            try {
                if (PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.status, IOReactorStatus.INACTIVE, IOReactorStatus.ACTIVE)) {
                    try {
                        try {
                            doExecute();
                            try {
                                doTerminate();
                            } catch (Exception e) {
                                logException(e);
                            } finally {
                                close(CloseMode.IMMEDIATE);
                            }
                        } catch (Exception e2) {
                            logException(e2);
                        }
                    } catch (ClosedSelectorException unused) {
                        doTerminate();
                    } catch (Exception e3) {
                        logException(e3);
                        try {
                            doTerminate();
                        } catch (Exception e4) {
                            logException(e4);
                        } finally {
                            close(CloseMode.IMMEDIATE);
                        }
                    }
                }
            } catch (Throwable th) {
                try {
                    try {
                        doTerminate();
                    } finally {
                        close(CloseMode.IMMEDIATE);
                    }
                } catch (Exception e5) {
                    logException(e5);
                }
                throw th;
            }
        } finally {
            close(CloseMode.IMMEDIATE);
        }
    }

    @Override // org.apache.hc.core5.reactor.IOReactor
    public final void awaitShutdown(TimeValue timeValue) throws InterruptedException {
        Args.notNull(timeValue, "Wait time");
        long jCurrentTimeMillis = System.currentTimeMillis() + timeValue.toMilliseconds();
        long milliseconds = timeValue.toMilliseconds();
        this.lock.lock();
        while (this.status.get().compareTo(IOReactorStatus.SHUT_DOWN) < 0) {
            try {
                this.condition.await(milliseconds, TimeUnit.MILLISECONDS);
                milliseconds = jCurrentTimeMillis - System.currentTimeMillis();
                if (milliseconds <= 0) {
                    break;
                }
            } finally {
                this.lock.unlock();
            }
        }
    }

    @Override // org.apache.hc.core5.reactor.IOReactor
    public final void initiateShutdown() {
        if (PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.status, IOReactorStatus.INACTIVE, IOReactorStatus.SHUT_DOWN)) {
            this.lock.lock();
            try {
                this.condition.signalAll();
                return;
            } finally {
                this.lock.unlock();
            }
        }
        if (PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.status, IOReactorStatus.ACTIVE, IOReactorStatus.SHUTTING_DOWN)) {
            this.selector.wakeup();
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
        if (this.terminated.compareAndSet(false, true)) {
            try {
                for (SelectionKey selectionKey : this.selector.keys()) {
                    try {
                        Closer.close((Closeable) selectionKey.attachment());
                    } catch (IOException e) {
                        logException(e);
                    }
                    selectionKey.channel().close();
                }
                this.selector.close();
            } catch (Exception e2) {
                logException(e2);
            }
        }
        this.lock.lock();
        try {
            this.condition.signalAll();
        } finally {
            this.lock.unlock();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        close(CloseMode.GRACEFUL);
    }

    public String toString() {
        return super.toString() + " [status=" + this.status + "]";
    }
}
