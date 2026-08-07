package com.box.android.observability;

import com.box.android.domain.services.IAppInBackgroundService;
import com.box.android.workers.MetricsUploadWorker;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MetricsUploadScheduler.kt */
/* JADX INFO: loaded from: classes12.dex */
@Singleton
@Metadata(d1 = {"\u00005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0012\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0016\u001a\u00020\u0017H\u0002R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\n8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/box/android/observability/MetricsUploadScheduler;", "", "appInBackgroundService", "Lcom/box/android/domain/services/IAppInBackgroundService;", "<init>", "(Lcom/box/android/domain/services/IAppInBackgroundService;)V", "backgroundExecutor", "Ljava/util/concurrent/ScheduledExecutorService;", "kotlin.jvm.PlatformType", "currentScheduled", "Ljava/util/concurrent/ScheduledFuture;", "getCurrentScheduled$box_generalProdRelease$annotations", "()V", "getCurrentScheduled$box_generalProdRelease", "()Ljava/util/concurrent/ScheduledFuture;", "setCurrentScheduled$box_generalProdRelease", "(Ljava/util/concurrent/ScheduledFuture;)V", "appStateListener", "com/box/android/observability/MetricsUploadScheduler$appStateListener$1", "Lcom/box/android/observability/MetricsUploadScheduler$appStateListener$1;", "uploadMetricsRunnable", "Ljava/lang/Runnable;", "scheduleNextUpload", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MetricsUploadScheduler {
    public static final int $stable = 8;
    private final MetricsUploadScheduler$appStateListener$1 appStateListener;
    private final ScheduledExecutorService backgroundExecutor;
    private ScheduledFuture<?> currentScheduled;
    private final Runnable uploadMetricsRunnable;

    public static /* synthetic */ void getCurrentScheduled$box_generalProdRelease$annotations() {
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.box.android.observability.MetricsUploadScheduler$appStateListener$1] */
    @Inject
    public MetricsUploadScheduler(IAppInBackgroundService appInBackgroundService) {
        Intrinsics.checkNotNullParameter(appInBackgroundService, "appInBackgroundService");
        this.backgroundExecutor = Executors.newSingleThreadScheduledExecutor();
        ?? r0 = new IAppInBackgroundService.Listener() { // from class: com.box.android.observability.MetricsUploadScheduler$appStateListener$1
            @Override // com.box.android.domain.services.IAppInBackgroundService.Listener
            public void onMoveToBackground() {
                ScheduledFuture<?> currentScheduled$box_generalProdRelease = this.this$0.getCurrentScheduled$box_generalProdRelease();
                if (currentScheduled$box_generalProdRelease != null) {
                    currentScheduled$box_generalProdRelease.cancel(true);
                }
                MetricsUploadWorker.INSTANCE.schedule();
            }

            @Override // com.box.android.domain.services.IAppInBackgroundService.Listener
            public void onMoveToForeground() {
                this.this$0.scheduleNextUpload();
            }
        };
        this.appStateListener = r0;
        appInBackgroundService.add((IAppInBackgroundService.Listener) r0);
        this.uploadMetricsRunnable = new Runnable() { // from class: com.box.android.observability.MetricsUploadScheduler$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                MetricsUploadScheduler.uploadMetricsRunnable$lambda$0(this.f$0);
            }
        };
    }

    public final ScheduledFuture<?> getCurrentScheduled$box_generalProdRelease() {
        return this.currentScheduled;
    }

    public final void setCurrentScheduled$box_generalProdRelease(ScheduledFuture<?> scheduledFuture) {
        this.currentScheduled = scheduledFuture;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void uploadMetricsRunnable$lambda$0(MetricsUploadScheduler metricsUploadScheduler) {
        MetricsUploadWorker.INSTANCE.schedule();
        metricsUploadScheduler.scheduleNextUpload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void scheduleNextUpload() {
        this.currentScheduled = this.backgroundExecutor.schedule(this.uploadMetricsRunnable, 60L, TimeUnit.SECONDS);
    }
}
