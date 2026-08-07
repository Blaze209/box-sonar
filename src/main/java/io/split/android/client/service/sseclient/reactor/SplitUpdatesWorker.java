package io.split.android.client.service.sseclient.reactor;

import io.split.android.client.common.CompressionUtilProvider;
import io.split.android.client.dtos.Helper;
import io.split.android.client.dtos.RuleBasedSegment;
import io.split.android.client.dtos.Split;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskExecutionListener;
import io.split.android.client.service.executor.SplitTaskExecutionStatus;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.service.executor.SplitTaskFactory;
import io.split.android.client.service.sseclient.notifications.InstantUpdateChangeNotification;
import io.split.android.client.service.sseclient.notifications.NotificationType;
import io.split.android.client.service.synchronizer.Synchronizer;
import io.split.android.client.storage.rbs.RuleBasedSegmentStorage;
import io.split.android.client.storage.splits.SplitsStorage;
import io.split.android.client.utils.Base64Util;
import io.split.android.client.utils.CompressionUtil;
import io.split.android.client.utils.Json;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: loaded from: classes4.dex */
public class SplitUpdatesWorker extends UpdateWorker {
    private final Base64Decoder mBase64Decoder;
    private final CompressionUtilProvider mCompressionUtilProvider;
    private final BlockingQueue<InstantUpdateChangeNotification> mNotificationsQueue;
    private final RuleBasedSegmentStorage mRuleBasedSegmentStorage;
    private final SplitTaskExecutor mSplitTaskExecutor;
    private final SplitTaskFactory mSplitTaskFactory;
    private final SplitsStorage mSplitsStorage;
    private final Synchronizer mSynchronizer;

    public interface Base64Decoder {
        byte[] decode(String data);
    }

    public SplitUpdatesWorker(Synchronizer synchronizer, BlockingQueue<InstantUpdateChangeNotification> notificationsQueue, SplitsStorage splitsStorage, RuleBasedSegmentStorage ruleBasedSegmentStorage, CompressionUtilProvider compressionUtilProvider, SplitTaskExecutor splitTaskExecutor, SplitTaskFactory splitTaskFactory) {
        this(synchronizer, notificationsQueue, splitsStorage, ruleBasedSegmentStorage, compressionUtilProvider, splitTaskExecutor, splitTaskFactory, new Base64DecoderImpl());
    }

    public SplitUpdatesWorker(Synchronizer synchronizer, BlockingQueue<InstantUpdateChangeNotification> notificationsQueue, SplitsStorage splitsStorage, RuleBasedSegmentStorage ruleBasedSegmentStorage, CompressionUtilProvider compressionUtilProvider, SplitTaskExecutor splitTaskExecutor, SplitTaskFactory splitTaskFactory, Base64Decoder base64Decoder) {
        this.mSynchronizer = (Synchronizer) Utils.checkNotNull(synchronizer);
        this.mNotificationsQueue = (BlockingQueue) Utils.checkNotNull(notificationsQueue);
        this.mSplitsStorage = (SplitsStorage) Utils.checkNotNull(splitsStorage);
        this.mRuleBasedSegmentStorage = (RuleBasedSegmentStorage) Utils.checkNotNull(ruleBasedSegmentStorage);
        this.mCompressionUtilProvider = (CompressionUtilProvider) Utils.checkNotNull(compressionUtilProvider);
        this.mSplitTaskExecutor = (SplitTaskExecutor) Utils.checkNotNull(splitTaskExecutor);
        this.mSplitTaskFactory = (SplitTaskFactory) Utils.checkNotNull(splitTaskFactory);
        this.mBase64Decoder = (Base64Decoder) Utils.checkNotNull(base64Decoder);
    }

    @Override // io.split.android.client.service.sseclient.reactor.UpdateWorker
    protected void onWaitForNotificationLoop() throws InterruptedException {
        try {
            InstantUpdateChangeNotification instantUpdateChangeNotificationTake = this.mNotificationsQueue.take();
            String str = instantUpdateChangeNotificationTake.getType() == NotificationType.SPLIT_UPDATE ? "feature flags" : "rule based segments";
            Logger.d("A new notification to update " + str + " has been received");
            long storageChangeNumber = getStorageChangeNumber(instantUpdateChangeNotificationTake.getType());
            if (instantUpdateChangeNotificationTake.getChangeNumber() <= storageChangeNumber) {
                Logger.d("Notification for " + str + " change number (" + instantUpdateChangeNotificationTake.getChangeNumber() + ") is lower than the current one (" + storageChangeNumber + "). Ignoring notification");
                return;
            }
            if (!isLegacyNotification(instantUpdateChangeNotificationTake) && !isInvalidChangeNumber(instantUpdateChangeNotificationTake, storageChangeNumber)) {
                handleNotification(instantUpdateChangeNotificationTake);
                return;
            }
            handleLegacyNotification(instantUpdateChangeNotificationTake);
        } catch (InterruptedException e) {
            Logger.d("Feature flags update worker has been interrupted");
            throw e;
        }
    }

    private static boolean isInvalidChangeNumber(InstantUpdateChangeNotification notification, long storageChangeNumber) {
        return notification.getPreviousChangeNumber() == null || notification.getPreviousChangeNumber().longValue() == 0 || storageChangeNumber != notification.getPreviousChangeNumber().longValue();
    }

    private static boolean isLegacyNotification(InstantUpdateChangeNotification notification) {
        return notification.getData() == null || notification.getCompressionType() == null;
    }

    private long getStorageChangeNumber(NotificationType type) {
        if (type == NotificationType.RULE_BASED_SEGMENT_UPDATE) {
            return this.mRuleBasedSegmentStorage.getChangeNumber();
        }
        return this.mSplitsStorage.getTill();
    }

    private void handleNotification(InstantUpdateChangeNotification notification) {
        String strDecompressData = decompressData(notification.getData(), this.mCompressionUtilProvider.get(notification.getCompressionType()));
        if (strDecompressData == null) {
            handleLegacyNotification(notification);
            return;
        }
        try {
            inPlaceUpdate(notification, strDecompressData);
        } catch (Exception unused) {
            Logger.e("Could not parse instant update notification");
            handleLegacyNotification(notification);
        }
    }

    private void inPlaceUpdate(final InstantUpdateChangeNotification notification, String decompressed) {
        SplitTaskExecutionListener splitTaskExecutionListener = new SplitTaskExecutionListener() { // from class: io.split.android.client.service.sseclient.reactor.SplitUpdatesWorker.1
            @Override // io.split.android.client.service.executor.SplitTaskExecutionListener
            public void taskExecuted(SplitTaskExecutionInfo taskInfo) {
                if (taskInfo.getStatus() == SplitTaskExecutionStatus.ERROR) {
                    SplitUpdatesWorker.this.handleLegacyNotification(notification);
                }
            }
        };
        if (notification.getType() == NotificationType.RULE_BASED_SEGMENT_UPDATE) {
            inPlaceRbsUpdate(notification, (RuleBasedSegment) Json.fromJson(decompressed, RuleBasedSegment.class), notification.getChangeNumber(), splitTaskExecutionListener);
        } else {
            inPlaceSplitsUpdate(notification, (Split) Json.fromJson(decompressed, Split.class), notification.getChangeNumber(), splitTaskExecutionListener);
        }
    }

    private void inPlaceRbsUpdate(InstantUpdateChangeNotification notification, RuleBasedSegment ruleBasedSegment, long changeNumber, SplitTaskExecutionListener executionListener) {
        if (this.mRuleBasedSegmentStorage.contains(Helper.getReferencedRuleBasedSegments(ruleBasedSegment.getConditions()))) {
            this.mSplitTaskExecutor.submit(this.mSplitTaskFactory.createRuleBasedSegmentUpdateTask(ruleBasedSegment, changeNumber), executionListener);
        } else {
            Logger.d("Referenced rule based segment not found in storage. Forcing sync");
            handleLegacyNotification(notification);
        }
    }

    private void inPlaceSplitsUpdate(InstantUpdateChangeNotification notification, Split split, long changeNumber, SplitTaskExecutionListener executionListener) {
        if (this.mRuleBasedSegmentStorage.contains(Helper.getReferencedRuleBasedSegments(split.conditions))) {
            this.mSplitTaskExecutor.submit(this.mSplitTaskFactory.createSplitsUpdateTask(split, changeNumber), executionListener);
        } else {
            Logger.d("Referenced rule based segment not found in storage. Forcing sync");
            handleLegacyNotification(notification);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleLegacyNotification(InstantUpdateChangeNotification notification) {
        if (notification.getType() == NotificationType.RULE_BASED_SEGMENT_UPDATE) {
            this.mSynchronizer.synchronizeRuleBasedSegments(notification.getChangeNumber());
        } else {
            this.mSynchronizer.synchronizeSplits(notification.getChangeNumber());
        }
        Logger.d("Enqueuing polling task");
    }

    private String decompressData(String data, CompressionUtil compressionUtil) {
        try {
            if (compressionUtil == null) {
                Logger.e("Compression type not supported");
                return null;
            }
            byte[] bArrDecode = this.mBase64Decoder.decode(data);
            if (bArrDecode == null) {
                Logger.e("Could not decode payload");
                return null;
            }
            byte[] bArrDecompress = compressionUtil.decompress(bArrDecode);
            if (bArrDecompress == null) {
                Logger.e("Decompressed payload is null");
                return null;
            }
            return new String(bArrDecompress);
        } catch (Exception unused) {
            Logger.e("Could not decompress payload");
            return null;
        }
    }

    private static class Base64DecoderImpl implements Base64Decoder {
        private Base64DecoderImpl() {
        }

        @Override // io.split.android.client.service.sseclient.reactor.SplitUpdatesWorker.Base64Decoder
        public byte[] decode(String data) {
            return Base64Util.bytesDecode(data);
        }
    }
}
