package io.split.android.client.service.sseclient.notifications;

import com.google.gson.JsonSyntaxException;
import io.split.android.client.dtos.Split;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.service.executor.SplitTaskFactory;
import io.split.android.client.service.sseclient.notifications.memberships.MembershipsNotificationProcessor;
import io.split.android.client.service.sseclient.notifications.mysegments.MySegmentsNotificationProcessorRegistry;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes4.dex */
public class NotificationProcessor implements MySegmentsNotificationProcessorRegistry {
    private final ConcurrentMap<String, MembershipsNotificationProcessor> mMembershipsNotificationProcessors = new ConcurrentHashMap();
    private final NotificationParser mNotificationParser;
    private final SplitTaskExecutor mSplitTaskExecutor;
    private final SplitTaskFactory mSplitTaskFactory;
    private final BlockingQueue<InstantUpdateChangeNotification> mSplitsUpdateNotificationsQueue;

    public NotificationProcessor(SplitTaskExecutor splitTaskExecutor, SplitTaskFactory splitTaskFactory, NotificationParser notificationParser, BlockingQueue<InstantUpdateChangeNotification> splitsUpdateNotificationsQueue) {
        this.mSplitTaskExecutor = (SplitTaskExecutor) Utils.checkNotNull(splitTaskExecutor);
        this.mSplitTaskFactory = (SplitTaskFactory) Utils.checkNotNull(splitTaskFactory);
        this.mNotificationParser = (NotificationParser) Utils.checkNotNull(notificationParser);
        this.mSplitsUpdateNotificationsQueue = (BlockingQueue) Utils.checkNotNull(splitsUpdateNotificationsQueue);
    }

    /* JADX INFO: renamed from: io.split.android.client.service.sseclient.notifications.NotificationProcessor$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$split$android$client$service$sseclient$notifications$NotificationType;

        static {
            int[] iArr = new int[NotificationType.values().length];
            $SwitchMap$io$split$android$client$service$sseclient$notifications$NotificationType = iArr;
            try {
                iArr[NotificationType.SPLIT_UPDATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$split$android$client$service$sseclient$notifications$NotificationType[NotificationType.RULE_BASED_SEGMENT_UPDATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$split$android$client$service$sseclient$notifications$NotificationType[NotificationType.SPLIT_KILL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$split$android$client$service$sseclient$notifications$NotificationType[NotificationType.MEMBERSHIPS_MS_UPDATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$split$android$client$service$sseclient$notifications$NotificationType[NotificationType.MEMBERSHIPS_LS_UPDATE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public void process(IncomingNotification incomingNotification) {
        try {
            String jsonData = incomingNotification.getJsonData();
            int i = AnonymousClass1.$SwitchMap$io$split$android$client$service$sseclient$notifications$NotificationType[incomingNotification.getType().ordinal()];
            if (i == 1) {
                processSplitUpdate(this.mNotificationParser.parseSplitUpdate(jsonData));
                return;
            }
            if (i == 2) {
                processRuleBasedSegmentUpdate(this.mNotificationParser.parseRuleBasedSegmentUpdate(jsonData));
                return;
            }
            if (i == 3) {
                processSplitKill(this.mNotificationParser.parseSplitKill(jsonData));
            } else if (i == 4 || i == 5) {
                processMembershipsUpdate(this.mNotificationParser.parseMembershipNotification(jsonData));
            } else {
                Logger.e("Unknown notification arrived: " + jsonData);
            }
        } catch (JsonSyntaxException e) {
            Logger.e("Error processing incoming push notification: " + e.getLocalizedMessage());
        } catch (Exception e2) {
            Logger.e("Unknown error while processing incoming push notification: " + e2.getLocalizedMessage());
        }
    }

    @Override // io.split.android.client.service.sseclient.notifications.mysegments.MySegmentsNotificationProcessorRegistry
    public void registerMembershipsNotificationProcessor(String matchingKey, MembershipsNotificationProcessor processor) {
        this.mMembershipsNotificationProcessors.put(matchingKey, processor);
    }

    @Override // io.split.android.client.service.sseclient.notifications.mysegments.MySegmentsNotificationProcessorRegistry
    public void unregisterMembershipsProcessor(String matchingKey) {
        this.mMembershipsNotificationProcessors.remove(matchingKey);
    }

    private void processSplitUpdate(SplitsChangeNotification notification) {
        Logger.d("Received feature flag change notification");
        this.mSplitsUpdateNotificationsQueue.offer(notification);
    }

    private void processRuleBasedSegmentUpdate(RuleBasedSegmentChangeNotification notification) {
        Logger.d("Received rule based segment change notification");
        this.mSplitsUpdateNotificationsQueue.offer(notification);
    }

    private void processSplitKill(SplitKillNotification notification) {
        Split split = new Split();
        split.name = notification.getSplitName();
        split.defaultTreatment = notification.getDefaultTreatment();
        split.changeNumber = notification.getChangeNumber();
        this.mSplitTaskExecutor.submit(this.mSplitTaskFactory.createSplitKillTask(split), null);
        this.mSplitsUpdateNotificationsQueue.offer(new SplitsChangeNotification(split.changeNumber));
    }

    private void processMembershipsUpdate(MembershipNotification notification) {
        Iterator<MembershipsNotificationProcessor> it = this.mMembershipsNotificationProcessors.values().iterator();
        while (it.hasNext()) {
            it.next().process(notification);
        }
    }
}
