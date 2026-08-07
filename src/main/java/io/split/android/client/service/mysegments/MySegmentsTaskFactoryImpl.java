package io.split.android.client.service.mysegments;

import io.split.android.client.telemetry.storage.TelemetryRuntimeProducer;
import io.split.android.client.utils.Utils;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class MySegmentsTaskFactoryImpl implements MySegmentsTaskFactory {
    private final MySegmentsTaskFactoryConfiguration mConfiguration;
    private final TelemetryRuntimeProducer mTelemetryRuntimeProducer;

    public MySegmentsTaskFactoryImpl(MySegmentsTaskFactoryConfiguration configuration, TelemetryRuntimeProducer telemetryRuntimeProducer) {
        this.mConfiguration = (MySegmentsTaskFactoryConfiguration) Utils.checkNotNull(configuration);
        this.mTelemetryRuntimeProducer = (TelemetryRuntimeProducer) Utils.checkNotNull(telemetryRuntimeProducer);
    }

    @Override // io.split.android.client.service.mysegments.MySegmentsTaskFactory
    public MySegmentsSyncTask createMySegmentsSyncTask(boolean avoidCache, Long targetSegmentsCn, Long targetLargeSegmentsCn) {
        return new MySegmentsSyncTask(this.mConfiguration.getHttpFetcher(), this.mConfiguration.getMySegmentsStorage(), this.mConfiguration.getMyLargeSegmentsStorage(), avoidCache, this.mConfiguration.getEventsManager(), this.mTelemetryRuntimeProducer, this.mConfiguration.getMySegmentsSyncTaskConfig(), targetSegmentsCn, targetLargeSegmentsCn);
    }

    @Override // io.split.android.client.service.mysegments.MySegmentsTaskFactory
    public LoadMySegmentsTask createLoadMySegmentsTask() {
        return new LoadMySegmentsTask(this.mConfiguration.getMySegmentsStorage(), this.mConfiguration.getMyLargeSegmentsStorage(), this.mConfiguration.getLoadMySegmentsTaskConfig());
    }

    @Override // io.split.android.client.service.mysegments.MySegmentsTaskFactory
    public MySegmentsUpdateTask createMySegmentsUpdateTask(boolean add, Set<String> segmentNames, Long changeNumber) {
        return new MySegmentsUpdateTask(this.mConfiguration.getMySegmentsStorage(), add, segmentNames, changeNumber, this.mConfiguration.getEventsManager(), this.mTelemetryRuntimeProducer, this.mConfiguration.getMySegmentsUpdateTaskConfig());
    }

    @Override // io.split.android.client.service.mysegments.MySegmentsTaskFactory
    public MySegmentsUpdateTask createMyLargeSegmentsUpdateTask(boolean add, Set<String> segmentNames, Long changeNumber) {
        return new MySegmentsUpdateTask(this.mConfiguration.getMyLargeSegmentsStorage(), add, segmentNames, changeNumber, this.mConfiguration.getEventsManager(), this.mTelemetryRuntimeProducer, this.mConfiguration.getMyLargeSegmentsUpdateTaskConfig());
    }
}
