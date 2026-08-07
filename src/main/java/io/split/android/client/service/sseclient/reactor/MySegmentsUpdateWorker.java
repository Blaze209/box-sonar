package io.split.android.client.service.sseclient.reactor;

import io.split.android.client.service.mysegments.MySegmentUpdateParams;
import io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizer;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: loaded from: classes4.dex */
public class MySegmentsUpdateWorker extends UpdateWorker {
    private final BlockingQueue<MySegmentUpdateParams> mNotificationsQueue;
    private final MySegmentsSynchronizer mSynchronizer;

    public MySegmentsUpdateWorker(MySegmentsSynchronizer synchronizer, BlockingQueue<MySegmentUpdateParams> notificationsQueue) {
        this.mSynchronizer = (MySegmentsSynchronizer) Utils.checkNotNull(synchronizer);
        this.mNotificationsQueue = (BlockingQueue) Utils.checkNotNull(notificationsQueue);
    }

    @Override // io.split.android.client.service.sseclient.reactor.UpdateWorker
    protected void onWaitForNotificationLoop() throws InterruptedException {
        try {
            this.mSynchronizer.forceMySegmentsSync(this.mNotificationsQueue.take());
            Logger.d("A new notification to update segments has been received. Enqueuing polling task.");
        } catch (InterruptedException e) {
            Logger.d("My segments update worker has been interrupted");
            throw e;
        }
    }
}
