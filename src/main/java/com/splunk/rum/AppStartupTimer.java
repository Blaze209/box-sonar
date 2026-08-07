package com.splunk.rum;

import android.os.Handler;
import android.util.Log;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.sdk.common.Clock;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
class AppStartupTimer {
    private static final long MAX_TIME_TO_UI_INIT = TimeUnit.MINUTES.toNanos(1);
    private volatile Runnable completionCallback;
    private final long firstPossibleTimestamp;
    private boolean isStartedFromBackground;
    private volatile Span overallAppStartSpan;
    final RumInitializer.AnchoredClock startupClock;
    private boolean uiInitStarted;
    private boolean uiInitTooLate;

    AppStartupTimer() {
        RumInitializer.AnchoredClock anchoredClockCreate = RumInitializer.AnchoredClock.create(Clock.getDefault());
        this.startupClock = anchoredClockCreate;
        this.firstPossibleTimestamp = anchoredClockCreate.now();
        this.overallAppStartSpan = null;
        this.completionCallback = null;
        this.uiInitStarted = false;
        this.uiInitTooLate = false;
        this.isStartedFromBackground = false;
    }

    Span start(Tracer tracer) {
        if (this.overallAppStartSpan != null) {
            return this.overallAppStartSpan;
        }
        Span spanStartSpan = tracer.spanBuilder("AppStart").setStartTimestamp(this.firstPossibleTimestamp, TimeUnit.NANOSECONDS).setAttribute(SplunkRum.COMPONENT_KEY, "appstart").setAttribute(SplunkRum.START_TYPE_KEY, "cold").startSpan();
        this.overallAppStartSpan = spanStartSpan;
        return spanStartSpan;
    }

    void startUiInit() {
        if (this.uiInitStarted || this.isStartedFromBackground) {
            return;
        }
        this.uiInitStarted = true;
        if (this.firstPossibleTimestamp + MAX_TIME_TO_UI_INIT < this.startupClock.now()) {
            Log.d("SplunkRum", "Max time to UI init exceeded");
            this.uiInitTooLate = true;
            clear();
        }
    }

    void setCompletionCallback(Runnable runnable) {
        this.completionCallback = runnable;
    }

    void end() {
        Span span = this.overallAppStartSpan;
        if (span != null && !this.uiInitTooLate && !this.isStartedFromBackground) {
            runCompletionCallback();
            span.end(this.startupClock.now(), TimeUnit.NANOSECONDS);
        }
        clear();
    }

    Span getStartupSpan() {
        return this.overallAppStartSpan;
    }

    void runCompletionCallback() {
        Runnable runnable = this.completionCallback;
        if (runnable != null) {
            runnable.run();
        }
    }

    private void clear() {
        this.overallAppStartSpan = null;
        this.completionCallback = null;
    }

    void detectBackgroundStart(Handler handler) {
        handler.post(new StartFromBackgroundRunnable(this));
    }

    private static class StartFromBackgroundRunnable implements Runnable {
        private final AppStartupTimer startupTimer;

        public StartFromBackgroundRunnable(AppStartupTimer appStartupTimer) {
            this.startupTimer = appStartupTimer;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.startupTimer.uiInitStarted) {
                return;
            }
            Log.d("SplunkRum", "Detected background app start");
            this.startupTimer.isStartedFromBackground = true;
        }
    }
}
