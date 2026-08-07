package io.split.android.client.service.sseclient.sseclient;

import com.google.gson.JsonSyntaxException;
import io.split.android.client.service.sseclient.feedbackchannel.PushManagerEventBroadcaster;
import io.split.android.client.service.sseclient.feedbackchannel.PushStatusEvent;
import io.split.android.client.service.sseclient.notifications.ControlNotification;
import io.split.android.client.service.sseclient.notifications.OccupancyNotification;
import io.split.android.client.telemetry.model.streaming.OccupancyPriStreamingEvent;
import io.split.android.client.telemetry.model.streaming.OccupancySecStreamingEvent;
import io.split.android.client.telemetry.model.streaming.StreamingStatusStreamingEvent;
import io.split.android.client.telemetry.storage.TelemetryRuntimeProducer;
import io.split.android.client.utils.logger.Logger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes4.dex */
public class NotificationManagerKeeper {
    private static final String CHANNEL_PRI_KEY = "PRI";
    private static final String CHANNEL_SEC_KEY = "SEC";
    private final PushManagerEventBroadcaster mBroadcasterChannel;
    private final TelemetryRuntimeProducer mTelemetryRuntimeProducer;
    Map<String, Publisher> mPublishers = new ConcurrentHashMap();
    private final AtomicLong mLastControlTimestamp = new AtomicLong(0);
    private final AtomicBoolean mIsStreamingActive = new AtomicBoolean(true);

    private static class Publisher {
        int count;
        long lastTimestamp;

        public Publisher(int count, long lastTimestamp) {
            this.count = count;
            this.lastTimestamp = lastTimestamp;
        }
    }

    public NotificationManagerKeeper(PushManagerEventBroadcaster broadcasterChannel, TelemetryRuntimeProducer telemetryRuntimeProducer) {
        this.mBroadcasterChannel = broadcasterChannel;
        this.mTelemetryRuntimeProducer = telemetryRuntimeProducer;
        this.mPublishers.put(CHANNEL_PRI_KEY, new Publisher(1, 0L));
        this.mPublishers.put(CHANNEL_SEC_KEY, new Publisher(0, 0L));
    }

    public void handleControlNotification(ControlNotification notification) {
        if (this.mLastControlTimestamp.get() >= notification.getTimestamp()) {
            return;
        }
        this.mLastControlTimestamp.set(notification.getTimestamp());
        try {
            int i = AnonymousClass1.$SwitchMap$io$split$android$client$service$sseclient$notifications$ControlNotification$ControlType[notification.getControlType().ordinal()];
            if (i == 1) {
                this.mIsStreamingActive.set(false);
                this.mBroadcasterChannel.pushMessage(new PushStatusEvent(PushStatusEvent.EventType.PUSH_SUBSYSTEM_DOWN));
                this.mTelemetryRuntimeProducer.recordStreamingEvents(new StreamingStatusStreamingEvent(StreamingStatusStreamingEvent.Status.PAUSED, System.currentTimeMillis()));
                return;
            }
            if (i == 2) {
                this.mIsStreamingActive.set(false);
                this.mBroadcasterChannel.pushMessage(new PushStatusEvent(PushStatusEvent.EventType.PUSH_DISABLED));
                this.mTelemetryRuntimeProducer.recordStreamingEvents(new StreamingStatusStreamingEvent(StreamingStatusStreamingEvent.Status.DISABLED, System.currentTimeMillis()));
            } else {
                if (i != 3) {
                    if (i == 4) {
                        this.mBroadcasterChannel.pushMessage(new PushStatusEvent(PushStatusEvent.EventType.PUSH_RESET));
                        return;
                    } else {
                        Logger.e("Unknown message received " + notification.getControlType());
                        return;
                    }
                }
                this.mIsStreamingActive.set(true);
                if (publishersCount() > 0) {
                    this.mBroadcasterChannel.pushMessage(new PushStatusEvent(PushStatusEvent.EventType.PUSH_SUBSYSTEM_UP));
                    this.mTelemetryRuntimeProducer.recordStreamingEvents(new StreamingStatusStreamingEvent(StreamingStatusStreamingEvent.Status.ENABLED, System.currentTimeMillis()));
                }
            }
        } catch (JsonSyntaxException e) {
            Logger.e("Could not parse control notification: " + notification.getJsonData() + " -> " + e.getLocalizedMessage());
        } catch (Exception e2) {
            Logger.e("Unexpected error while processing control notification: " + e2.getLocalizedMessage());
        }
    }

    /* JADX INFO: renamed from: io.split.android.client.service.sseclient.sseclient.NotificationManagerKeeper$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$split$android$client$service$sseclient$notifications$ControlNotification$ControlType;

        static {
            int[] iArr = new int[ControlNotification.ControlType.values().length];
            $SwitchMap$io$split$android$client$service$sseclient$notifications$ControlNotification$ControlType = iArr;
            try {
                iArr[ControlNotification.ControlType.STREAMING_PAUSED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$split$android$client$service$sseclient$notifications$ControlNotification$ControlType[ControlNotification.ControlType.STREAMING_DISABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$split$android$client$service$sseclient$notifications$ControlNotification$ControlType[ControlNotification.ControlType.STREAMING_RESUMED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$split$android$client$service$sseclient$notifications$ControlNotification$ControlType[ControlNotification.ControlType.STREAMING_RESET.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public void handleOccupancyNotification(OccupancyNotification notification) {
        String channelKey = getChannelKey(notification);
        if (channelKey == null || isOldTimestamp(notification, channelKey)) {
            return;
        }
        int iPublishersCount = publishersCount();
        updateChannelInfo(channelKey, notification.getMetrics().getPublishers(), notification.getTimestamp());
        if (CHANNEL_PRI_KEY.equals(channelKey)) {
            this.mTelemetryRuntimeProducer.recordStreamingEvents(new OccupancyPriStreamingEvent(publishersCount(), System.currentTimeMillis()));
        } else if (CHANNEL_SEC_KEY.equals(channelKey)) {
            this.mTelemetryRuntimeProducer.recordStreamingEvents(new OccupancySecStreamingEvent(publishersCount(), System.currentTimeMillis()));
        }
        if (publishersCount() == 0 && iPublishersCount > 0) {
            this.mBroadcasterChannel.pushMessage(new PushStatusEvent(PushStatusEvent.EventType.PUSH_SUBSYSTEM_DOWN));
        } else if (publishersCount() > 0 && iPublishersCount == 0 && this.mIsStreamingActive.get()) {
            this.mBroadcasterChannel.pushMessage(new PushStatusEvent(PushStatusEvent.EventType.PUSH_SUBSYSTEM_UP));
        }
    }

    public boolean isStreamingActive() {
        return this.mIsStreamingActive.get();
    }

    private synchronized int publishersCount() {
        return this.mPublishers.get(CHANNEL_PRI_KEY).count + this.mPublishers.get(CHANNEL_SEC_KEY).count;
    }

    private String getChannelKey(OccupancyNotification notification) {
        if (notification.isControlPriChannel()) {
            return CHANNEL_PRI_KEY;
        }
        if (notification.isControlSecChannel()) {
            return CHANNEL_SEC_KEY;
        }
        Logger.w("Unknown occupancy channel " + notification.getChannel());
        return null;
    }

    private synchronized boolean isOldTimestamp(OccupancyNotification notification, String channelKey) {
        return this.mPublishers.get(channelKey).lastTimestamp >= notification.getTimestamp();
    }

    private synchronized void updateChannelInfo(String channelKey, int publishersCount, long timestamp) {
        Publisher publisher = this.mPublishers.get(channelKey);
        if (publisher == null) {
            return;
        }
        publisher.lastTimestamp = timestamp;
        publisher.count = publishersCount;
    }
}
