package io.split.android.client.service.synchronizer;

import io.split.android.client.dtos.Event;
import io.split.android.client.impressions.DecoratedImpression;
import io.split.android.client.lifecycle.SplitLifecycleAware;

/* JADX INFO: loaded from: classes4.dex */
public interface Synchronizer extends SplitLifecycleAware {
    void destroy();

    void flush();

    void loadAndSynchronizeSplits();

    void loadAttributesFromCache();

    void loadMySegmentsFromCache();

    void pushEvent(Event event);

    void pushImpression(DecoratedImpression impression);

    void startPeriodicFetching();

    void startPeriodicRecording();

    void stopPeriodicFetching();

    void stopPeriodicRecording();

    void synchronizeMySegments();

    void synchronizeRuleBasedSegments(long changeNumber);

    void synchronizeSplits();

    void synchronizeSplits(long since);
}
