package io.split.android.client.service.sseclient.notifications.mysegments;

import io.split.android.client.common.CompressionUtilProvider;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.service.sseclient.notifications.MySegmentsV2PayloadDecoder;
import io.split.android.client.service.sseclient.notifications.NotificationParser;
import io.split.android.client.service.sseclient.notifications.memberships.MembershipsNotificationProcessor;
import io.split.android.client.service.sseclient.notifications.memberships.MembershipsNotificationProcessorImpl;
import io.split.android.client.utils.Utils;

/* JADX INFO: loaded from: classes4.dex */
public class MembershipsNotificationProcessorFactoryImpl implements MembershipsNotificationProcessorFactory {
    private final CompressionUtilProvider mCompressionProvider;
    private final MySegmentsV2PayloadDecoder mMySegmentsPayloadDecoder;
    private final NotificationParser mNotificationParser;
    private final SplitTaskExecutor mSplitTaskExecutor;

    public MembershipsNotificationProcessorFactoryImpl(NotificationParser notificationParser, SplitTaskExecutor splitTaskExecutor, MySegmentsV2PayloadDecoder mySegmentsPayloadDecoder, CompressionUtilProvider compressionProvider) {
        this.mNotificationParser = (NotificationParser) Utils.checkNotNull(notificationParser);
        this.mSplitTaskExecutor = (SplitTaskExecutor) Utils.checkNotNull(splitTaskExecutor);
        this.mMySegmentsPayloadDecoder = (MySegmentsV2PayloadDecoder) Utils.checkNotNull(mySegmentsPayloadDecoder);
        this.mCompressionProvider = (CompressionUtilProvider) Utils.checkNotNull(compressionProvider);
    }

    @Override // io.split.android.client.service.sseclient.notifications.mysegments.MembershipsNotificationProcessorFactory
    public MembershipsNotificationProcessor getProcessor(MySegmentsNotificationProcessorConfiguration configuration) {
        return new MembershipsNotificationProcessorImpl(this.mNotificationParser, this.mSplitTaskExecutor, this.mMySegmentsPayloadDecoder, this.mCompressionProvider, configuration, new SyncDelayCalculatorImpl());
    }
}
