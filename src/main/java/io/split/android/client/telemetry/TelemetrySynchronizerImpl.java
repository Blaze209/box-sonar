package io.split.android.client.telemetry;

import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskExecutionListener;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.service.sseclient.FixedIntervalBackoffCounter;
import io.split.android.client.service.sseclient.sseclient.RetryBackoffCounterTimer;
import io.split.android.client.service.telemetry.TelemetryTaskFactory;
import io.split.android.client.utils.Utils;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public class TelemetrySynchronizerImpl implements TelemetrySynchronizer {
    private final RetryBackoffCounterTimer mConfigTimer;
    private final AtomicBoolean mIsSynchronizing;
    private final SplitTaskExecutionListener mTaskExecutionListener;
    private final SplitTaskExecutor mTaskExecutor;
    private final TelemetryTaskFactory mTaskFactory;
    private final long mTelemetrySyncPeriod;
    private String statsTaskId;

    public TelemetrySynchronizerImpl(SplitTaskExecutor splitTaskExecutor, TelemetryTaskFactory telemetryTaskFactory, long telemetrySyncPeriod) {
        this(splitTaskExecutor, telemetryTaskFactory, new RetryBackoffCounterTimer(splitTaskExecutor, new FixedIntervalBackoffCounter(1L), 3), telemetrySyncPeriod);
    }

    public TelemetrySynchronizerImpl(SplitTaskExecutor splitTaskExecutor, TelemetryTaskFactory telemetryTaskFactory, RetryBackoffCounterTimer configTimer, long telemetrySyncPeriod) {
        this.mIsSynchronizing = new AtomicBoolean(true);
        this.statsTaskId = null;
        this.mTaskExecutor = (SplitTaskExecutor) Utils.checkNotNull(splitTaskExecutor);
        this.mTaskFactory = (TelemetryTaskFactory) Utils.checkNotNull(telemetryTaskFactory);
        this.mConfigTimer = (RetryBackoffCounterTimer) Utils.checkNotNull(configTimer);
        this.mTelemetrySyncPeriod = telemetrySyncPeriod;
        this.mTaskExecutionListener = new SplitTaskExecutionListener() { // from class: io.split.android.client.telemetry.TelemetrySynchronizerImpl.1
            @Override // io.split.android.client.service.executor.SplitTaskExecutionListener
            public void taskExecuted(SplitTaskExecutionInfo taskInfo) {
                if (Boolean.TRUE.equals(taskInfo.getBoolValue(SplitTaskExecutionInfo.DO_NOT_RETRY))) {
                    TelemetrySynchronizerImpl.this.mIsSynchronizing.set(false);
                    TelemetrySynchronizerImpl.this.stopStatsSynchronization();
                }
            }
        };
    }

    @Override // io.split.android.client.telemetry.TelemetrySynchronizer
    public void synchronizeConfig() {
        if (this.mIsSynchronizing.get()) {
            this.mConfigTimer.setTask(this.mTaskFactory.getTelemetryConfigRecorderTask(), this.mTaskExecutionListener);
            this.mConfigTimer.start();
        }
    }

    @Override // io.split.android.client.telemetry.TelemetrySynchronizer
    public void synchronizeStats() {
        String str = this.statsTaskId;
        if (str != null) {
            this.mTaskExecutor.stopTask(str);
        }
        this.statsTaskId = this.mTaskExecutor.schedule(this.mTaskFactory.getTelemetryStatsRecorderTask(), 5L, this.mTelemetrySyncPeriod, this.mTaskExecutionListener);
    }

    @Override // io.split.android.client.telemetry.TelemetrySynchronizer
    public void destroy() {
        this.mConfigTimer.stop();
        stopStatsSynchronization();
    }

    @Override // io.split.android.client.telemetry.TelemetrySynchronizer
    public void flush() {
        if (this.mIsSynchronizing.get()) {
            this.mTaskExecutor.submit(this.mTaskFactory.getTelemetryStatsRecorderTask(), this.mTaskExecutionListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopStatsSynchronization() {
        String str = this.statsTaskId;
        if (str != null) {
            this.mTaskExecutor.stopTask(str);
            this.statsTaskId = null;
        }
    }
}
