package io.split.android.client.service.telemetry;

import io.split.android.client.SplitClientConfig;
import io.split.android.client.service.http.HttpRecorder;
import io.split.android.client.storage.mysegments.MySegmentsStorageContainer;
import io.split.android.client.storage.splits.SplitsStorage;
import io.split.android.client.telemetry.model.Config;
import io.split.android.client.telemetry.model.Stats;
import io.split.android.client.telemetry.storage.TelemetryConfigProvider;
import io.split.android.client.telemetry.storage.TelemetryConfigProviderImpl;
import io.split.android.client.telemetry.storage.TelemetryRuntimeProducer;
import io.split.android.client.telemetry.storage.TelemetryStatsProvider;
import io.split.android.client.telemetry.storage.TelemetryStatsProviderImpl;
import io.split.android.client.telemetry.storage.TelemetryStorage;

/* JADX INFO: loaded from: classes4.dex */
public class TelemetryTaskFactoryImpl implements TelemetryTaskFactory {
    private final TelemetryConfigProvider mTelemetryConfigProvider;
    private final HttpRecorder<Config> mTelemetryConfigRecorder;
    private final TelemetryRuntimeProducer mTelemetryRuntimeProducer;
    private final TelemetryStatsProvider mTelemetryStatsProvider;
    private final HttpRecorder<Stats> mTelemetryStatsRecorder;

    public TelemetryTaskFactoryImpl(HttpRecorder<Config> telemetryConfigRecorder, HttpRecorder<Stats> telemetryStatsRecorder, TelemetryStorage telemetryStorage, SplitClientConfig splitClientConfig, SplitsStorage splitsStorage, MySegmentsStorageContainer mySegmentsStorageContainer, MySegmentsStorageContainer myLargeSegmentsStorageContainer, int flagSetCount, int invalidFlagSetCount) {
        this.mTelemetryConfigRecorder = telemetryConfigRecorder;
        this.mTelemetryConfigProvider = new TelemetryConfigProviderImpl(telemetryStorage, splitClientConfig, flagSetCount, invalidFlagSetCount);
        this.mTelemetryStatsRecorder = telemetryStatsRecorder;
        this.mTelemetryStatsProvider = new TelemetryStatsProviderImpl(telemetryStorage, splitsStorage, mySegmentsStorageContainer, myLargeSegmentsStorageContainer);
        this.mTelemetryRuntimeProducer = telemetryStorage;
    }

    @Override // io.split.android.client.service.telemetry.TelemetryTaskFactory
    public TelemetryConfigRecorderTask getTelemetryConfigRecorderTask() {
        return new TelemetryConfigRecorderTask(this.mTelemetryConfigRecorder, this.mTelemetryConfigProvider, this.mTelemetryRuntimeProducer);
    }

    @Override // io.split.android.client.service.telemetry.TelemetryTaskFactory
    public TelemetryStatsRecorderTask getTelemetryStatsRecorderTask() {
        return new TelemetryStatsRecorderTask(this.mTelemetryStatsRecorder, this.mTelemetryStatsProvider, this.mTelemetryRuntimeProducer);
    }
}
