package io.split.android.client.telemetry.storage;

import android.os.Build;
import io.split.android.client.storage.mysegments.MySegmentsStorageContainer;
import io.split.android.client.storage.splits.SplitsStorage;
import io.split.android.client.telemetry.model.EventsDataRecordsEnum;
import io.split.android.client.telemetry.model.ImpressionsDataType;
import io.split.android.client.telemetry.model.Stats;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;

/* JADX INFO: loaded from: classes4.dex */
public class TelemetryStatsProviderImpl implements TelemetryStatsProvider {
    private final MySegmentsStorageContainer mMyLargeSegmentsStorageContainer;
    private final MySegmentsStorageContainer mMySegmentsStorageContainer;
    private final SplitsStorage mSplitsStorage;
    private final TelemetryStorageConsumer mTelemetryStorageConsumer;
    private volatile Stats pendingStats = null;
    private final Object mLock = new Object();

    public TelemetryStatsProviderImpl(TelemetryStorageConsumer telemetryStorageConsumer, SplitsStorage splitsStorage, MySegmentsStorageContainer mySegmentsStorage, MySegmentsStorageContainer myLargeSegmentsStorage) {
        this.mTelemetryStorageConsumer = (TelemetryStorageConsumer) Utils.checkNotNull(telemetryStorageConsumer);
        this.mSplitsStorage = (SplitsStorage) Utils.checkNotNull(splitsStorage);
        this.mMySegmentsStorageContainer = (MySegmentsStorageContainer) Utils.checkNotNull(mySegmentsStorage);
        this.mMyLargeSegmentsStorageContainer = myLargeSegmentsStorage;
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryStatsProvider
    public Stats getTelemetryStats() {
        if (this.pendingStats == null) {
            synchronized (this.mLock) {
                if (this.pendingStats == null) {
                    this.pendingStats = buildStats();
                }
            }
        }
        return this.pendingStats;
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryStatsProvider
    public void clearStats() {
        this.pendingStats = null;
    }

    private Stats buildStats() {
        Stats stats = new Stats();
        addDefaultTags();
        stats.setStreamingEvents(this.mTelemetryStorageConsumer.popStreamingEvents());
        stats.setSplitCount(this.mSplitsStorage.getAll().size());
        stats.setTags(this.mTelemetryStorageConsumer.popTags());
        stats.setMethodLatencies(this.mTelemetryStorageConsumer.popLatencies());
        stats.setSegmentCount(this.mMySegmentsStorageContainer.getUniqueAmount());
        MySegmentsStorageContainer mySegmentsStorageContainer = this.mMyLargeSegmentsStorageContainer;
        if (mySegmentsStorageContainer != null) {
            stats.setLargeSegmentCount(mySegmentsStorageContainer.getUniqueAmount());
        }
        stats.setSessionLengthMs(this.mTelemetryStorageConsumer.getSessionLength());
        stats.setLastSynchronizations(this.mTelemetryStorageConsumer.getLastSynchronization());
        stats.setImpressionsDropped(this.mTelemetryStorageConsumer.getImpressionsStats(ImpressionsDataType.IMPRESSIONS_DROPPED));
        stats.setImpressionsQueued(this.mTelemetryStorageConsumer.getImpressionsStats(ImpressionsDataType.IMPRESSIONS_QUEUED));
        stats.setImpressionsDeduped(this.mTelemetryStorageConsumer.getImpressionsStats(ImpressionsDataType.IMPRESSIONS_DEDUPED));
        stats.setMethodExceptions(this.mTelemetryStorageConsumer.popExceptions());
        stats.setHttpLatencies(this.mTelemetryStorageConsumer.popHttpLatencies());
        stats.setHttpErrors(this.mTelemetryStorageConsumer.popHttpErrors());
        stats.setTokenRefreshes(this.mTelemetryStorageConsumer.popTokenRefreshes());
        stats.setAuthRejections(this.mTelemetryStorageConsumer.popAuthRejections());
        stats.setEventsQueued(this.mTelemetryStorageConsumer.getEventsStats(EventsDataRecordsEnum.EVENTS_QUEUED));
        stats.setEventsDropped(this.mTelemetryStorageConsumer.getEventsStats(EventsDataRecordsEnum.EVENTS_DROPPED));
        stats.setUpdatesFromSSE(this.mTelemetryStorageConsumer.popUpdatesFromSSE());
        return stats;
    }

    private void addDefaultTags() {
        try {
            ((TelemetryRuntimeProducer) this.mTelemetryStorageConsumer).addTag("av:" + Build.VERSION.SDK_INT);
        } catch (ClassCastException unused) {
            Logger.d("Telemetry storage is not a producer");
        }
    }
}
