package io.opentelemetry.rum.internal.instrumentation.anr;

import android.os.Handler;
import io.opentelemetry.context.Context;
import io.opentelemetry.instrumentation.api.instrumenter.Instrumenter;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
final class AnrWatcher implements Runnable {
    private final AtomicInteger anrCounter = new AtomicInteger();
    private final Instrumenter<StackTraceElement[], Void> instrumenter;
    private final Thread mainThread;
    private final Handler uiHandler;

    AnrWatcher(Handler handler, Thread thread, Instrumenter<StackTraceElement[], Void> instrumenter) {
        this.uiHandler = handler;
        this.mainThread = thread;
        this.instrumenter = instrumenter;
    }

    @Override // java.lang.Runnable
    public void run() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        Handler handler = this.uiHandler;
        Objects.requireNonNull(countDownLatch);
        if (handler.post(new Runnable() { // from class: io.opentelemetry.rum.internal.instrumentation.anr.AnrWatcher$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                countDownLatch.countDown();
            }
        })) {
            try {
                if (countDownLatch.await(1L, TimeUnit.SECONDS)) {
                    this.anrCounter.set(0);
                } else if (this.anrCounter.incrementAndGet() >= 5) {
                    recordAnr(this.mainThread.getStackTrace());
                    this.anrCounter.set(0);
                }
            } catch (InterruptedException unused) {
            }
        }
    }

    private void recordAnr(StackTraceElement[] stackTraceElementArr) {
        this.instrumenter.end(this.instrumenter.start(Context.current(), stackTraceElementArr), stackTraceElementArr, null, null);
    }
}
