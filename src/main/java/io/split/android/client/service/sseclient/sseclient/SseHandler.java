package io.split.android.client.service.sseclient.sseclient;

import com.google.gson.JsonSyntaxException;
import io.split.android.client.service.sseclient.feedbackchannel.PushManagerEventBroadcaster;
import io.split.android.client.service.sseclient.feedbackchannel.PushStatusEvent;
import io.split.android.client.service.sseclient.notifications.ControlNotification;
import io.split.android.client.service.sseclient.notifications.IncomingNotification;
import io.split.android.client.service.sseclient.notifications.NotificationParser;
import io.split.android.client.service.sseclient.notifications.NotificationProcessor;
import io.split.android.client.service.sseclient.notifications.NotificationType;
import io.split.android.client.service.sseclient.notifications.OccupancyNotification;
import io.split.android.client.service.sseclient.notifications.StreamingError;
import io.split.android.client.telemetry.model.streaming.AblyErrorStreamingEvent;
import io.split.android.client.telemetry.model.streaming.SseConnectionErrorStreamingEvent;
import io.split.android.client.telemetry.storage.TelemetryRuntimeProducer;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class SseHandler {
    private final PushManagerEventBroadcaster mBroadcasterChannel;
    private final NotificationManagerKeeper mNotificationManagerKeeper;
    private final NotificationParser mNotificationParser;
    private final NotificationProcessor mNotificationProcessor;
    private final TelemetryRuntimeProducer mTelemetryRuntimeProducer;

    public SseHandler(NotificationParser notificationParser, NotificationProcessor notificationProcessor, TelemetryRuntimeProducer telemetryRuntimeProducer, PushManagerEventBroadcaster broadcasterChannel) {
        this(notificationParser, notificationProcessor, new NotificationManagerKeeper(broadcasterChannel, telemetryRuntimeProducer), broadcasterChannel, telemetryRuntimeProducer);
    }

    public SseHandler(NotificationParser notificationParser, NotificationProcessor notificationProcessor, NotificationManagerKeeper managerKeeper, PushManagerEventBroadcaster broadcasterChannel, TelemetryRuntimeProducer telemetryRuntimeProducer) {
        this.mNotificationParser = (NotificationParser) Utils.checkNotNull(notificationParser);
        this.mNotificationProcessor = (NotificationProcessor) Utils.checkNotNull(notificationProcessor);
        this.mBroadcasterChannel = (PushManagerEventBroadcaster) Utils.checkNotNull(broadcasterChannel);
        this.mNotificationManagerKeeper = (NotificationManagerKeeper) Utils.checkNotNull(managerKeeper);
        this.mTelemetryRuntimeProducer = (TelemetryRuntimeProducer) Utils.checkNotNull(telemetryRuntimeProducer);
    }

    public boolean isConnectionConfirmed(Map<String, String> values) {
        if (values.get("data") != null && values.get("data") == null && values.get("event") == null) {
            return true;
        }
        return (values.get("data") == null || this.mNotificationParser.isError(values)) ? false : true;
    }

    public void handleIncomingMessage(Map<String, String> values) {
        String str = values.get("data");
        if (str != null) {
            if (this.mNotificationParser.isError(values)) {
                handleError(str);
            }
            IncomingNotification incoming = this.mNotificationParser.parseIncoming(str);
            if (incoming == null) {
                return;
            }
            switch (AnonymousClass1.$SwitchMap$io$split$android$client$service$sseclient$notifications$NotificationType[incoming.getType().ordinal()]) {
                case 1:
                    handleControlNotification(incoming);
                    break;
                case 2:
                    handleOccupancyNotification(incoming);
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    if (this.mNotificationManagerKeeper.isStreamingActive()) {
                        this.mNotificationProcessor.process(incoming);
                    }
                    break;
                default:
                    Logger.w("SSE Handler: Unknown notification: " + incoming.getType());
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: io.split.android.client.service.sseclient.sseclient.SseHandler$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$split$android$client$service$sseclient$notifications$NotificationType;

        static {
            int[] iArr = new int[NotificationType.values().length];
            $SwitchMap$io$split$android$client$service$sseclient$notifications$NotificationType = iArr;
            try {
                iArr[NotificationType.CONTROL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$split$android$client$service$sseclient$notifications$NotificationType[NotificationType.OCCUPANCY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$split$android$client$service$sseclient$notifications$NotificationType[NotificationType.SPLIT_KILL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$split$android$client$service$sseclient$notifications$NotificationType[NotificationType.SPLIT_UPDATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$split$android$client$service$sseclient$notifications$NotificationType[NotificationType.RULE_BASED_SEGMENT_UPDATE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$split$android$client$service$sseclient$notifications$NotificationType[NotificationType.MEMBERSHIPS_MS_UPDATE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$split$android$client$service$sseclient$notifications$NotificationType[NotificationType.MEMBERSHIPS_LS_UPDATE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public void handleError(boolean retryable) {
        this.mBroadcasterChannel.pushMessage(new PushStatusEvent(retryable ? PushStatusEvent.EventType.PUSH_RETRYABLE_ERROR : PushStatusEvent.EventType.PUSH_NON_RETRYABLE_ERROR));
        this.mTelemetryRuntimeProducer.recordStreamingEvents(new SseConnectionErrorStreamingEvent(retryable ? SseConnectionErrorStreamingEvent.Status.REQUESTED : SseConnectionErrorStreamingEvent.Status.NON_REQUESTED, System.currentTimeMillis()));
    }

    public boolean isRetryableError(Map<String, String> values) {
        String str = values.get("data");
        if (str == null) {
            return true;
        }
        try {
            return this.mNotificationParser.parseError(str).isRetryable();
        } catch (JsonSyntaxException unused) {
            Logger.e("Could no parse ably error: " + str);
            return true;
        }
    }

    private void handleControlNotification(IncomingNotification incomingNotification) {
        try {
            ControlNotification control = this.mNotificationParser.parseControl(incomingNotification.getJsonData());
            control.setTimestamp(incomingNotification.getTimestamp());
            this.mNotificationManagerKeeper.handleControlNotification(control);
        } catch (JsonSyntaxException e) {
            Logger.e("Could not parse control notification: " + incomingNotification.getJsonData() + " -> " + e.getLocalizedMessage());
        } catch (Exception e2) {
            Logger.e("Unexpected error while processing control notification: " + e2.getLocalizedMessage());
        }
    }

    private void handleOccupancyNotification(IncomingNotification incomingNotification) {
        try {
            OccupancyNotification occupancy = this.mNotificationParser.parseOccupancy(incomingNotification.getJsonData());
            occupancy.setChannel(incomingNotification.getChannel());
            occupancy.setTimestamp(incomingNotification.getTimestamp());
            this.mNotificationManagerKeeper.handleOccupancyNotification(occupancy);
        } catch (JsonSyntaxException e) {
            Logger.e("Could not parse occupancy notification: " + incomingNotification.getJsonData() + " -> " + e.getLocalizedMessage());
        } catch (Exception e2) {
            Logger.e("Unexpected error while processing occupancy notification: " + e2.getLocalizedMessage());
        }
    }

    private void handleError(String jsonData) {
        try {
            StreamingError error = this.mNotificationParser.parseError(jsonData);
            Logger.w("Streaming error notification received: " + error.getMessage());
            if (error.shouldBeIgnored()) {
                Logger.w("Error ignored");
            } else {
                this.mTelemetryRuntimeProducer.recordStreamingEvents(new AblyErrorStreamingEvent(error.getCode(), System.currentTimeMillis()));
                this.mBroadcasterChannel.pushMessage(new PushStatusEvent(error.isRetryable() ? PushStatusEvent.EventType.PUSH_RETRYABLE_ERROR : PushStatusEvent.EventType.PUSH_NON_RETRYABLE_ERROR));
            }
        } catch (JsonSyntaxException e) {
            Logger.e("Could not parse occupancy notification: " + jsonData + " -> " + e.getLocalizedMessage());
        } catch (Exception e2) {
            Logger.e("Unexpected error while processing occupancy notification: " + e2.getLocalizedMessage());
        }
    }
}
