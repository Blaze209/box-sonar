package com.splunk.rum;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.FrameMetrics;
import android.view.Window;
import io.opentelemetry.api.trace.Tracer;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;

/* JADX INFO: loaded from: classes3.dex */
class SlowRenderingDetectorImpl implements SlowRenderingDetector, Application.ActivityLifecycleCallbacks {
    static final int FROZEN_THRESHOLD_MS = 700;
    private static final int NANOS_PER_MS;
    private static final int NANOS_ROUNDING_VALUE;
    static final int SLOW_THRESHOLD_MS = 16;
    private static final HandlerThread frameMetricsThread;
    private final ConcurrentMap<Activity, PerActivityListener> activities;
    private final ScheduledExecutorService executorService;
    private final Handler frameMetricsHandler;
    private final Duration pollInterval;
    private final Tracer tracer;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    static {
        int nanos = (int) TimeUnit.MILLISECONDS.toNanos(1L);
        NANOS_PER_MS = nanos;
        NANOS_ROUNDING_VALUE = nanos / 2;
        frameMetricsThread = new HandlerThread("FrameMetricsCollector");
    }

    SlowRenderingDetectorImpl(Tracer tracer, Duration duration) {
        this(tracer, Executors.newScheduledThreadPool(1), new Handler(startFrameMetricsLoop()), duration);
    }

    SlowRenderingDetectorImpl(Tracer tracer, ScheduledExecutorService scheduledExecutorService, Handler handler, Duration duration) {
        this.activities = new ConcurrentHashMap();
        this.tracer = tracer;
        this.executorService = scheduledExecutorService;
        this.frameMetricsHandler = handler;
        this.pollInterval = duration;
    }

    private static Looper startFrameMetricsLoop() {
        HandlerThread handlerThread = frameMetricsThread;
        if (!handlerThread.isAlive()) {
            handlerThread.start();
        }
        return handlerThread.getLooper();
    }

    @Override // com.splunk.rum.SlowRenderingDetector
    public void start(Application application) {
        application.registerActivityLifecycleCallbacks(this);
        this.executorService.scheduleAtFixedRate(new Runnable() { // from class: com.splunk.rum.SlowRenderingDetectorImpl$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.reportSlowRenders();
            }
        }, this.pollInterval.toMillis(), this.pollInterval.toMillis(), TimeUnit.MILLISECONDS);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        PerActivityListener perActivityListener = new PerActivityListener(activity);
        if (this.activities.putIfAbsent(activity, perActivityListener) == null) {
            activity.getWindow().addOnFrameMetricsAvailableListener(perActivityListener, this.frameMetricsHandler);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        PerActivityListener perActivityListenerRemove = this.activities.remove(activity);
        if (perActivityListenerRemove != null) {
            activity.getWindow().removeOnFrameMetricsAvailableListener(perActivityListenerRemove);
            reportSlow(perActivityListenerRemove);
        }
    }

    static class PerActivityListener implements Window.OnFrameMetricsAvailableListener {
        private final Activity activity;
        private final Object lock = new Object();
        private SparseIntArray drawDurationHistogram = new SparseIntArray();

        PerActivityListener(Activity activity) {
            this.activity = activity;
        }

        @Override // android.view.Window.OnFrameMetricsAvailableListener
        public void onFrameMetricsAvailable(Window window, FrameMetrics frameMetrics, int i) {
            if (frameMetrics.getMetric(9) == 1) {
                return;
            }
            long metric = frameMetrics.getMetric(4);
            if (metric >= 0) {
                synchronized (this.lock) {
                    int i2 = (int) ((metric + ((long) SlowRenderingDetectorImpl.NANOS_ROUNDING_VALUE)) / ((long) SlowRenderingDetectorImpl.NANOS_PER_MS));
                    this.drawDurationHistogram.put(i2, this.drawDurationHistogram.get(i2) + 1);
                }
            }
        }

        SparseIntArray resetMetrics() {
            SparseIntArray sparseIntArray;
            synchronized (this.lock) {
                sparseIntArray = this.drawDurationHistogram;
                this.drawDurationHistogram = new SparseIntArray();
            }
            return sparseIntArray;
        }

        public String getActivityName() {
            return this.activity.getComponentName().flattenToShortString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportSlowRenders() {
        try {
            this.activities.forEach(new BiConsumer() { // from class: com.splunk.rum.SlowRenderingDetectorImpl$$ExternalSyntheticLambda1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f$0.m14344x1a9c93d((Activity) obj, (SlowRenderingDetectorImpl.PerActivityListener) obj2);
                }
            });
        } catch (Exception e) {
            Log.w("SplunkRum", "Exception while processing frame metrics", e);
        }
    }

    /* JADX INFO: renamed from: lambda$reportSlowRenders$0$com-splunk-rum-SlowRenderingDetectorImpl, reason: not valid java name */
    /* synthetic */ void m14344x1a9c93d(Activity activity, PerActivityListener perActivityListener) {
        reportSlow(perActivityListener);
    }

    private void reportSlow(PerActivityListener perActivityListener) {
        SparseIntArray sparseIntArrayResetMetrics = perActivityListener.resetMetrics();
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < sparseIntArrayResetMetrics.size(); i3++) {
            int iKeyAt = sparseIntArrayResetMetrics.keyAt(i3);
            int i4 = sparseIntArrayResetMetrics.get(iKeyAt);
            if (iKeyAt > 700) {
                Log.d("SplunkRum", "* FROZEN RENDER DETECTED: " + iKeyAt + " ms." + i4 + " times");
                i2 += i4;
            } else if (iKeyAt > 16) {
                Log.d("SplunkRum", "* Slow render detected: " + iKeyAt + " ms. " + i4 + " times");
                i += i4;
            }
        }
        Instant instantNow = Instant.now();
        if (i > 0) {
            makeSpan("slowRenders", perActivityListener.getActivityName(), i, instantNow);
        }
        if (i2 > 0) {
            makeSpan("frozenRenders", perActivityListener.getActivityName(), i2, instantNow);
        }
    }

    private void makeSpan(String str, String str2, int i, Instant instant) {
        this.tracer.spanBuilder(str).setAttribute("count", i).setAttribute("activity.name", str2).setStartTimestamp(instant).startSpan().end(instant);
    }
}
