package io.split.android.client.service.mysegments;

import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public interface MySegmentsTaskFactory {
    LoadMySegmentsTask createLoadMySegmentsTask();

    MySegmentsUpdateTask createMyLargeSegmentsUpdateTask(boolean add, Set<String> segmentNames, Long changeNumber);

    MySegmentsSyncTask createMySegmentsSyncTask(boolean avoidCache, Long targetSegmentsCn, Long targetLargeSegmentsCn);

    MySegmentsUpdateTask createMySegmentsUpdateTask(boolean add, Set<String> segmentNames, Long changeNumber);
}
