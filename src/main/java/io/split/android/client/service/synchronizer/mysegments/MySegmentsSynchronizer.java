package io.split.android.client.service.synchronizer.mysegments;

import io.split.android.client.service.mysegments.MySegmentUpdateParams;

/* JADX INFO: loaded from: classes4.dex */
public interface MySegmentsSynchronizer {
    void destroy();

    void forceMySegmentsSync(MySegmentUpdateParams params);

    void loadMySegmentsFromCache();

    void scheduleSegmentsSyncTask();

    void stopPeriodicFetching();

    void submitMySegmentsLoadingTask();

    void synchronizeMySegments();
}
