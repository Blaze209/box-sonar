package io.split.android.client.service.sseclient.sseclient;

import io.split.android.client.service.sseclient.feedbackchannel.PushManagerEventBroadcaster;
import io.split.android.client.service.sseclient.notifications.InstantUpdateChangeNotification;
import io.split.android.client.service.sseclient.notifications.NotificationParser;
import io.split.android.client.service.sseclient.notifications.NotificationProcessor;
import io.split.android.client.service.synchronizer.SyncGuardian;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: loaded from: classes4.dex */
public class StreamingComponents {
    private NotificationParser mNotificationParser;
    private NotificationProcessor mNotificationProcessor;
    private PushManagerEventBroadcaster mPushManagerEventBroadcaster;
    private PushNotificationManager mPushNotificationManager;
    private BlockingQueue<InstantUpdateChangeNotification> mSplitsUpdateNotificationQueue;
    private SseAuthenticator mSseAuthenticator;
    private SyncGuardian mSyncGuardian;

    public StreamingComponents() {
    }

    public StreamingComponents(PushNotificationManager pushNotificationManager, BlockingQueue<InstantUpdateChangeNotification> splitsUpdateNotificationQueue, NotificationParser notificationParser, NotificationProcessor notificationProcessor, SseAuthenticator sseAuthenticator, PushManagerEventBroadcaster pushManagerEventBroadcaster, SyncGuardian syncManager) {
        this.mPushNotificationManager = pushNotificationManager;
        this.mSplitsUpdateNotificationQueue = splitsUpdateNotificationQueue;
        this.mNotificationParser = notificationParser;
        this.mNotificationProcessor = notificationProcessor;
        this.mSseAuthenticator = sseAuthenticator;
        this.mPushManagerEventBroadcaster = pushManagerEventBroadcaster;
        this.mSyncGuardian = syncManager;
    }

    public PushNotificationManager getPushNotificationManager() {
        return this.mPushNotificationManager;
    }

    public BlockingQueue<InstantUpdateChangeNotification> getSplitsUpdateNotificationQueue() {
        return this.mSplitsUpdateNotificationQueue;
    }

    public PushManagerEventBroadcaster getPushManagerEventBroadcaster() {
        return this.mPushManagerEventBroadcaster;
    }

    public NotificationParser getNotificationParser() {
        return this.mNotificationParser;
    }

    public NotificationProcessor getNotificationProcessor() {
        return this.mNotificationProcessor;
    }

    public SseAuthenticator getSseAuthenticator() {
        return this.mSseAuthenticator;
    }

    public SyncGuardian getSyncGuardian() {
        return this.mSyncGuardian;
    }
}
