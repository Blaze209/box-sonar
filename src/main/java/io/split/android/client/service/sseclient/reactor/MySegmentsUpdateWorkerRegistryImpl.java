package io.split.android.client.service.sseclient.reactor;

import io.split.android.client.utils.logger.Logger;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public class MySegmentsUpdateWorkerRegistryImpl implements MySegmentsUpdateWorkerRegistry {
    private final AtomicBoolean mStarted = new AtomicBoolean(false);
    private final ConcurrentMap<String, MySegmentsUpdateWorker> mMySegmentUpdateWorkers = new ConcurrentHashMap();

    @Override // io.split.android.client.service.sseclient.reactor.MySegmentsUpdateWorkerRegistry
    public synchronized void registerMySegmentsUpdateWorker(String matchingKey, MySegmentsUpdateWorker mySegmentsUpdateWorker) {
        this.mMySegmentUpdateWorkers.put(matchingKey, mySegmentsUpdateWorker);
        startIfNeeded(mySegmentsUpdateWorker);
    }

    @Override // io.split.android.client.service.sseclient.reactor.MySegmentsUpdateWorkerRegistry
    public synchronized void unregisterMySegmentsUpdateWorker(String matchingKey) {
        MySegmentsUpdateWorker mySegmentsUpdateWorker = this.mMySegmentUpdateWorkers.get(matchingKey);
        if (mySegmentsUpdateWorker != null) {
            mySegmentsUpdateWorker.stop();
        }
        this.mMySegmentUpdateWorkers.remove(matchingKey);
    }

    @Override // io.split.android.client.service.sseclient.reactor.MySegmentsUpdateWorkerRegistry
    public void start() {
        if (this.mStarted.getAndSet(true)) {
            return;
        }
        if (this.mMySegmentUpdateWorkers.isEmpty()) {
            Logger.d("No MySegmentsUpdateWorkers have been registered");
        }
        Iterator<MySegmentsUpdateWorker> it = this.mMySegmentUpdateWorkers.values().iterator();
        while (it.hasNext()) {
            it.next().start();
        }
    }

    @Override // io.split.android.client.service.sseclient.reactor.MySegmentsUpdateWorkerRegistry
    public void stop() {
        if (this.mStarted.getAndSet(false)) {
            Iterator<MySegmentsUpdateWorker> it = this.mMySegmentUpdateWorkers.values().iterator();
            while (it.hasNext()) {
                it.next().stop();
            }
        }
    }

    private void startIfNeeded(MySegmentsUpdateWorker mySegmentsUpdateWorker) {
        if (this.mStarted.get()) {
            mySegmentsUpdateWorker.start();
        }
    }
}
