package io.split.android.client.service.sseclient.notifications.memberships;

import com.box.androidsdk.content.requests.BoxRequestsFile;
import io.split.android.client.common.CompressionType;
import io.split.android.client.common.CompressionUtilProvider;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.service.mysegments.MySegmentUpdateParams;
import io.split.android.client.service.mysegments.MySegmentsUpdateTask;
import io.split.android.client.service.sseclient.notifications.KeyList;
import io.split.android.client.service.sseclient.notifications.MembershipNotification;
import io.split.android.client.service.sseclient.notifications.MySegmentUpdateStrategy;
import io.split.android.client.service.sseclient.notifications.MySegmentsV2PayloadDecoder;
import io.split.android.client.service.sseclient.notifications.NotificationParser;
import io.split.android.client.service.sseclient.notifications.NotificationType;
import io.split.android.client.service.sseclient.notifications.mysegments.MySegmentsNotificationProcessorConfiguration;
import io.split.android.client.service.sseclient.notifications.mysegments.SyncDelayCalculator;
import io.split.android.client.utils.logger.Logger;
import java.util.Set;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: loaded from: classes4.dex */
public class MembershipsNotificationProcessorImpl implements MembershipsNotificationProcessor {
    private final CompressionUtilProvider mCompressionProvider;
    private final MySegmentsNotificationProcessorConfiguration mConfiguration;
    private final MySegmentsV2PayloadDecoder mMySegmentsPayloadDecoder;
    private final NotificationParser mNotificationParser;
    private final SplitTaskExecutor mSplitTaskExecutor;
    private final SyncDelayCalculator mSyncDelayCalculator;

    public MembershipsNotificationProcessorImpl(NotificationParser notificationParser, SplitTaskExecutor splitTaskExecutor, MySegmentsV2PayloadDecoder mySegmentsPayloadDecoder, CompressionUtilProvider compressionProvider, MySegmentsNotificationProcessorConfiguration configuration, SyncDelayCalculator syncDelayCalculator) {
        this.mNotificationParser = notificationParser;
        this.mSplitTaskExecutor = splitTaskExecutor;
        this.mMySegmentsPayloadDecoder = mySegmentsPayloadDecoder;
        this.mCompressionProvider = compressionProvider;
        this.mConfiguration = configuration;
        this.mSyncDelayCalculator = syncDelayCalculator;
    }

    @Override // io.split.android.client.service.sseclient.notifications.memberships.MembershipsNotificationProcessor
    public void process(MembershipNotification notification) {
        if (notification == null) {
            notifyMySegmentRefreshNeeded(this.mConfiguration.getNotificationsQueue(), 0L, null, null);
        } else {
            processUpdate(notification.getType(), notification.getUpdateStrategy(), notification.getData(), notification.getCompression(), notification.getNames(), notification.getChangeNumber(), this.mConfiguration.getNotificationsQueue(), this.mSyncDelayCalculator.calculateSyncDelay(this.mConfiguration.getUserKey(), notification.getUpdateIntervalMs(), notification.getAlgorithmSeed(), notification.getUpdateStrategy(), notification.getHashingAlgorithm()));
        }
    }

    /* JADX INFO: renamed from: io.split.android.client.service.sseclient.notifications.memberships.MembershipsNotificationProcessorImpl$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$split$android$client$service$sseclient$notifications$MySegmentUpdateStrategy;

        static {
            int[] iArr = new int[MySegmentUpdateStrategy.values().length];
            $SwitchMap$io$split$android$client$service$sseclient$notifications$MySegmentUpdateStrategy = iArr;
            try {
                iArr[MySegmentUpdateStrategy.UNBOUNDED_FETCH_REQUEST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$split$android$client$service$sseclient$notifications$MySegmentUpdateStrategy[MySegmentUpdateStrategy.BOUNDED_FETCH_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$split$android$client$service$sseclient$notifications$MySegmentUpdateStrategy[MySegmentUpdateStrategy.KEY_LIST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$split$android$client$service$sseclient$notifications$MySegmentUpdateStrategy[MySegmentUpdateStrategy.SEGMENT_REMOVAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private void processUpdate(NotificationType notificationType, MySegmentUpdateStrategy updateStrategy, String data, CompressionType compression, Set<String> names, Long changeNumber, BlockingQueue<MySegmentUpdateParams> notificationsQueue, long syncDelay) {
        try {
            int i = AnonymousClass1.$SwitchMap$io$split$android$client$service$sseclient$notifications$MySegmentUpdateStrategy[updateStrategy.ordinal()];
            if (i == 1) {
                Logger.d("Received Unbounded membership fetch request");
                notifyMySegmentRefreshNeeded(notificationsQueue, syncDelay, notificationType, changeNumber);
                return;
            }
            if (i == 2) {
                Logger.d("Received Bounded membership fetch request");
                executeBoundedFetch(this.mMySegmentsPayloadDecoder.decodeAsBytes(data, this.mCompressionProvider.get(compression)), syncDelay, notificationType, changeNumber);
            } else if (i == 3) {
                Logger.d("Received KeyList membership fetch request");
                updateSegments(notificationType, this.mMySegmentsPayloadDecoder.decodeAsString(data, this.mCompressionProvider.get(compression)), names, changeNumber);
            } else if (i == 4) {
                Logger.d("Received membership removal request");
                removeSegment(notificationType, names, changeNumber);
            } else {
                notifyMySegmentRefreshNeeded(notificationsQueue, syncDelay, notificationType, changeNumber);
                Logger.w("Unknown membership change notification type: " + updateStrategy);
            }
        } catch (Exception e) {
            Logger.e("Executing unbounded fetch because an error has occurred processing my " + (notificationType == NotificationType.MEMBERSHIPS_LS_UPDATE ? BoxRequestsFile.DownloadAvatar.LARGE : "") + " segment notification: " + e.getLocalizedMessage());
            notifyMySegmentRefreshNeeded(notificationsQueue, syncDelay, notificationType, changeNumber);
        }
    }

    private void notifyMySegmentRefreshNeeded(BlockingQueue<MySegmentUpdateParams> notificationsQueue, long syncDelay, NotificationType notificationType, Long changeNumber) {
        Long l = notificationType == NotificationType.MEMBERSHIPS_MS_UPDATE ? changeNumber : null;
        if (notificationType != NotificationType.MEMBERSHIPS_LS_UPDATE) {
            changeNumber = null;
        }
        notificationsQueue.offer(new MySegmentUpdateParams(Long.valueOf(syncDelay), l, changeNumber));
    }

    private void removeSegment(NotificationType notificationType, Set<String> segmentNames, Long changeNumber) {
        MySegmentsUpdateTask mySegmentsUpdateTaskCreateMySegmentsUpdateTask;
        if (segmentNames == null) {
            return;
        }
        if (notificationType == NotificationType.MEMBERSHIPS_LS_UPDATE) {
            mySegmentsUpdateTaskCreateMySegmentsUpdateTask = this.mConfiguration.getMySegmentsTaskFactory().createMyLargeSegmentsUpdateTask(false, segmentNames, changeNumber);
        } else {
            mySegmentsUpdateTaskCreateMySegmentsUpdateTask = this.mConfiguration.getMySegmentsTaskFactory().createMySegmentsUpdateTask(false, segmentNames, changeNumber);
        }
        this.mSplitTaskExecutor.submit(mySegmentsUpdateTaskCreateMySegmentsUpdateTask, null);
    }

    private void executeBoundedFetch(byte[] keyMap, long syncDelay, NotificationType notificationType, Long changeNumber) {
        if (this.mMySegmentsPayloadDecoder.isKeyInBitmap(keyMap, this.mMySegmentsPayloadDecoder.computeKeyIndex(this.mConfiguration.getHashedUserKey(), keyMap.length))) {
            Logger.d("Executing Bounded membership fetch request");
            notifyMySegmentRefreshNeeded(this.mConfiguration.getNotificationsQueue(), syncDelay, notificationType, changeNumber);
        }
    }

    private void updateSegments(NotificationType notificationType, String keyListString, Set<String> segmentNames, Long changeNumber) {
        MySegmentsUpdateTask mySegmentsUpdateTaskCreateMySegmentsUpdateTask;
        if (segmentNames == null) {
            return;
        }
        KeyList.Action keyListAction = this.mMySegmentsPayloadDecoder.getKeyListAction(this.mNotificationParser.parseKeyList(keyListString), this.mConfiguration.getHashedUserKey());
        boolean z = keyListAction != KeyList.Action.REMOVE;
        if (keyListAction == KeyList.Action.NONE) {
            return;
        }
        boolean z2 = notificationType == NotificationType.MEMBERSHIPS_LS_UPDATE;
        Logger.d("Executing KeyList my " + (z2 ? "large " : "") + "segment fetch request: Adding = " + z);
        if (z2) {
            mySegmentsUpdateTaskCreateMySegmentsUpdateTask = this.mConfiguration.getMySegmentsTaskFactory().createMyLargeSegmentsUpdateTask(z, segmentNames, changeNumber);
        } else {
            mySegmentsUpdateTaskCreateMySegmentsUpdateTask = this.mConfiguration.getMySegmentsTaskFactory().createMySegmentsUpdateTask(z, segmentNames, changeNumber);
        }
        this.mSplitTaskExecutor.submit(mySegmentsUpdateTaskCreateMySegmentsUpdateTask, null);
    }
}
