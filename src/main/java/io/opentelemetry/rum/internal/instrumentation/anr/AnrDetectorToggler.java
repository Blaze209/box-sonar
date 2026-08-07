package io.opentelemetry.rum.internal.instrumentation.anr;

import io.opentelemetry.rum.internal.instrumentation.ApplicationStateListener;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
final class AnrDetectorToggler implements ApplicationStateListener {
    private final ScheduledExecutorService anrScheduler;
    private final Runnable anrWatcher;
    private ScheduledFuture<?> future;

    AnrDetectorToggler(Runnable runnable, ScheduledExecutorService scheduledExecutorService) {
        this.anrWatcher = runnable;
        this.anrScheduler = scheduledExecutorService;
    }

    @Override // io.opentelemetry.rum.internal.instrumentation.ApplicationStateListener
    public void onApplicationForegrounded() {
        if (this.future == null) {
            this.future = this.anrScheduler.scheduleAtFixedRate(this.anrWatcher, 1L, 1L, TimeUnit.SECONDS);
        }
    }

    @Override // io.opentelemetry.rum.internal.instrumentation.ApplicationStateListener
    public void onApplicationBackgrounded() {
        ScheduledFuture<?> scheduledFuture = this.future;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.future = null;
        }
    }
}
