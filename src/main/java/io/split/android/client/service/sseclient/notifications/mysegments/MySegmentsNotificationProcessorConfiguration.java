package io.split.android.client.service.sseclient.notifications.mysegments;

import io.split.android.client.service.mysegments.MySegmentUpdateParams;
import io.split.android.client.service.mysegments.MySegmentsTaskFactory;
import io.split.android.client.utils.Utils;
import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/* JADX INFO: loaded from: classes4.dex */
public class MySegmentsNotificationProcessorConfiguration {
    private final BigInteger mHashedUserKey;
    private final MySegmentsTaskFactory mMySegmentsTaskFactory;
    private final BlockingQueue<MySegmentUpdateParams> mNotificationsQueue;
    private final String mUserKey;

    public MySegmentsNotificationProcessorConfiguration(MySegmentsTaskFactory mySegmentsTaskFactory, LinkedBlockingDeque<MySegmentUpdateParams> mySegmentUpdateNotificationsQueue, String userKey, BigInteger hashedUserKey) {
        this.mMySegmentsTaskFactory = (MySegmentsTaskFactory) Utils.checkNotNull(mySegmentsTaskFactory);
        this.mNotificationsQueue = (BlockingQueue) Utils.checkNotNull(mySegmentUpdateNotificationsQueue);
        this.mUserKey = (String) Utils.checkNotNull(userKey);
        this.mHashedUserKey = (BigInteger) Utils.checkNotNull(hashedUserKey);
    }

    public MySegmentsTaskFactory getMySegmentsTaskFactory() {
        return this.mMySegmentsTaskFactory;
    }

    public BlockingQueue<MySegmentUpdateParams> getNotificationsQueue() {
        return this.mNotificationsQueue;
    }

    public String getUserKey() {
        return this.mUserKey;
    }

    public BigInteger getHashedUserKey() {
        return this.mHashedUserKey;
    }
}
