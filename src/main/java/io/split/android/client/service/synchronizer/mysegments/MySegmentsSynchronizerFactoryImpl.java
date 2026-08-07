package io.split.android.client.service.synchronizer.mysegments;

import io.split.android.client.RetryBackoffCounterTimerFactory;
import io.split.android.client.events.SplitEventsManager;
import io.split.android.client.events.SplitInternalEvent;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.service.mysegments.MySegmentsTaskFactory;
import io.split.android.client.utils.Utils;

/* JADX INFO: loaded from: classes4.dex */
public class MySegmentsSynchronizerFactoryImpl implements MySegmentsSynchronizerFactory {
    private static final int BACKOFF_BASE = 1;
    private final RetryBackoffCounterTimerFactory mRetryBackoffCounterTimerFactory;
    private final SplitTaskExecutor mSplitTaskExecutor;

    public MySegmentsSynchronizerFactoryImpl(RetryBackoffCounterTimerFactory retryBackoffCounterTimerFactory, SplitTaskExecutor splitTaskExecutor) {
        this.mRetryBackoffCounterTimerFactory = (RetryBackoffCounterTimerFactory) Utils.checkNotNull(retryBackoffCounterTimerFactory);
        this.mSplitTaskExecutor = (SplitTaskExecutor) Utils.checkNotNull(splitTaskExecutor);
    }

    @Override // io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizerFactory
    public MySegmentsSynchronizer getSynchronizer(MySegmentsTaskFactory mySegmentsTaskFactory, SplitEventsManager splitEventsManager, SplitInternalEvent loadedFromStorageInternalEvent, int segmentsRefreshRate) {
        return new MySegmentsSynchronizerImpl(this.mRetryBackoffCounterTimerFactory.create(this.mSplitTaskExecutor, 1), this.mSplitTaskExecutor, splitEventsManager, mySegmentsTaskFactory, segmentsRefreshRate, loadedFromStorageInternalEvent);
    }
}
