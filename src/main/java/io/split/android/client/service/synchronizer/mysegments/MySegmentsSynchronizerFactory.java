package io.split.android.client.service.synchronizer.mysegments;

import io.split.android.client.events.SplitEventsManager;
import io.split.android.client.events.SplitInternalEvent;
import io.split.android.client.service.mysegments.MySegmentsTaskFactory;

/* JADX INFO: loaded from: classes4.dex */
public interface MySegmentsSynchronizerFactory {
    MySegmentsSynchronizer getSynchronizer(MySegmentsTaskFactory mySegmentsTaskFactory, SplitEventsManager splitEventsManager, SplitInternalEvent loadedFromStorageInternalEvent, int segmentsRefreshRate);
}
