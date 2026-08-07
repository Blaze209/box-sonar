package io.split.android.client.service.synchronizer.mysegments;

import androidx.core.util.Consumer;
import io.split.android.client.api.Key;
import io.split.android.client.service.mysegments.MySegmentUpdateParams;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public class MySegmentsSynchronizerRegistryImpl implements MySegmentsSynchronizerRegistry, MySegmentsSynchronizer {
    private final AtomicBoolean mLoadedFromCache = new AtomicBoolean(false);
    private final AtomicBoolean mSynchronizedSegments = new AtomicBoolean(false);
    private final AtomicBoolean mScheduledSegmentsSyncTask = new AtomicBoolean(false);
    private final AtomicBoolean mStoppedPeriodicFetching = new AtomicBoolean(false);
    private final ConcurrentMap<Key, MySegmentsSynchronizer> mMySegmentsSynchronizers = new ConcurrentHashMap();

    @Override // io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizerRegistry
    public synchronized void registerMySegmentsSynchronizer(Key key, MySegmentsSynchronizer mySegmentsSynchronizer) {
        this.mMySegmentsSynchronizers.put(key, mySegmentsSynchronizer);
        triggerPendingActions(mySegmentsSynchronizer);
    }

    @Override // io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizerRegistry
    public synchronized void unregisterMySegmentsSynchronizer(Key key) {
        MySegmentsSynchronizer mySegmentsSynchronizer = this.mMySegmentsSynchronizers.get(key);
        if (mySegmentsSynchronizer != null) {
            mySegmentsSynchronizer.stopPeriodicFetching();
            mySegmentsSynchronizer.destroy();
        }
        this.mMySegmentsSynchronizers.remove(key);
    }

    @Override // io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizer
    public synchronized void loadMySegmentsFromCache() {
        executeForAll(new Consumer() { // from class: io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizerRegistryImpl$$ExternalSyntheticLambda5
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                ((MySegmentsSynchronizer) obj).loadMySegmentsFromCache();
            }
        });
        this.mLoadedFromCache.set(true);
    }

    @Override // io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizer
    public void synchronizeMySegments() {
        executeForAll(new Consumer() { // from class: io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizerRegistryImpl$$ExternalSyntheticLambda2
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                ((MySegmentsSynchronizer) obj).synchronizeMySegments();
            }
        });
        this.mSynchronizedSegments.set(true);
    }

    @Override // io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizer
    public void forceMySegmentsSync(final MySegmentUpdateParams params) {
        executeForAll(new Consumer() { // from class: io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizerRegistryImpl$$ExternalSyntheticLambda0
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                ((MySegmentsSynchronizer) obj).forceMySegmentsSync(params);
            }
        });
    }

    @Override // io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizer
    public synchronized void destroy() {
        executeForAll(new Consumer() { // from class: io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizerRegistryImpl$$ExternalSyntheticLambda1
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                ((MySegmentsSynchronizer) obj).destroy();
            }
        });
    }

    @Override // io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizer
    public synchronized void scheduleSegmentsSyncTask() {
        executeForAll(new Consumer() { // from class: io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizerRegistryImpl$$ExternalSyntheticLambda6
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                ((MySegmentsSynchronizer) obj).scheduleSegmentsSyncTask();
            }
        });
        this.mScheduledSegmentsSyncTask.set(true);
    }

    @Override // io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizer
    public void submitMySegmentsLoadingTask() {
        executeForAll(new Consumer() { // from class: io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizerRegistryImpl$$ExternalSyntheticLambda3
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                ((MySegmentsSynchronizer) obj).submitMySegmentsLoadingTask();
            }
        });
    }

    @Override // io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizer
    public synchronized void stopPeriodicFetching() {
        executeForAll(new Consumer() { // from class: io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizerRegistryImpl$$ExternalSyntheticLambda4
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                ((MySegmentsSynchronizer) obj).stopPeriodicFetching();
            }
        });
        this.mScheduledSegmentsSyncTask.set(false);
        this.mStoppedPeriodicFetching.set(true);
    }

    private void triggerPendingActions(MySegmentsSynchronizer mySegmentsSynchronizer) {
        if (this.mLoadedFromCache.get()) {
            mySegmentsSynchronizer.loadMySegmentsFromCache();
        }
        if (this.mSynchronizedSegments.get()) {
            mySegmentsSynchronizer.synchronizeMySegments();
        }
        if (this.mScheduledSegmentsSyncTask.get()) {
            mySegmentsSynchronizer.scheduleSegmentsSyncTask();
        }
    }

    private void executeForAll(Consumer<MySegmentsSynchronizer> consumer) {
        Iterator<MySegmentsSynchronizer> it = this.mMySegmentsSynchronizers.values().iterator();
        while (it.hasNext()) {
            consumer.accept(it.next());
        }
    }
}
