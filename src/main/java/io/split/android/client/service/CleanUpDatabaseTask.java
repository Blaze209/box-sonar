package io.split.android.client.service;

import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.service.impressions.observer.PersistentImpressionsObserverCacheStorage;
import io.split.android.client.storage.events.PersistentEventsStorage;
import io.split.android.client.storage.impressions.PersistentImpressionsCountStorage;
import io.split.android.client.storage.impressions.PersistentImpressionsStorage;
import io.split.android.client.storage.impressions.PersistentImpressionsUniqueStorage;
import io.split.android.client.utils.Utils;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public class CleanUpDatabaseTask implements SplitTask {
    private final PersistentEventsStorage mEventsStorage;
    private final PersistentImpressionsCountStorage mImpressionsCountStorage;
    private final PersistentImpressionsObserverCacheStorage mImpressionsObserverCacheStorage;
    private final PersistentImpressionsStorage mImpressionsStorage;
    private final PersistentImpressionsUniqueStorage mImpressionsUniqueStorage;
    private final long mMaxTimestamp;

    public CleanUpDatabaseTask(PersistentEventsStorage eventsStorage, PersistentImpressionsStorage impressionsStorage, PersistentImpressionsCountStorage persistentImpressionsCountStorage, PersistentImpressionsUniqueStorage persistentImpressionsUniqueStorage, PersistentImpressionsObserverCacheStorage persistentImpressionsObserverCacheStorage, long maxTimestamp) {
        this.mEventsStorage = (PersistentEventsStorage) Utils.checkNotNull(eventsStorage);
        this.mImpressionsStorage = (PersistentImpressionsStorage) Utils.checkNotNull(impressionsStorage);
        this.mImpressionsCountStorage = (PersistentImpressionsCountStorage) Utils.checkNotNull(persistentImpressionsCountStorage);
        this.mImpressionsUniqueStorage = (PersistentImpressionsUniqueStorage) Utils.checkNotNull(persistentImpressionsUniqueStorage);
        this.mImpressionsObserverCacheStorage = (PersistentImpressionsObserverCacheStorage) Utils.checkNotNull(persistentImpressionsObserverCacheStorage);
        this.mMaxTimestamp = maxTimestamp;
    }

    @Override // io.split.android.client.service.executor.SplitTask
    public SplitTaskExecutionInfo execute() {
        try {
            this.mEventsStorage.deleteInvalid(this.mMaxTimestamp);
            this.mImpressionsStorage.deleteInvalid(this.mMaxTimestamp);
            this.mImpressionsCountStorage.deleteInvalid(this.mMaxTimestamp);
            this.mImpressionsUniqueStorage.deleteInvalid(this.mMaxTimestamp);
            this.mImpressionsObserverCacheStorage.deleteOutdated(TimeUnit.SECONDS.toMillis(this.mMaxTimestamp));
            return SplitTaskExecutionInfo.success(SplitTaskType.CLEAN_UP_DATABASE);
        } catch (Throwable unused) {
            return SplitTaskExecutionInfo.error(SplitTaskType.CLEAN_UP_DATABASE);
        }
    }
}
