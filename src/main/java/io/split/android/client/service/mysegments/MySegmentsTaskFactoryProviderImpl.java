package io.split.android.client.service.mysegments;

import io.split.android.client.telemetry.storage.TelemetryRuntimeProducer;
import io.split.android.client.utils.Utils;

/* JADX INFO: loaded from: classes4.dex */
public class MySegmentsTaskFactoryProviderImpl implements MySegmentsTaskFactoryProvider {
    private final TelemetryRuntimeProducer mTelemetryRuntimeProducer;

    public MySegmentsTaskFactoryProviderImpl(TelemetryRuntimeProducer telemetryRuntimeProducer) {
        this.mTelemetryRuntimeProducer = (TelemetryRuntimeProducer) Utils.checkNotNull(telemetryRuntimeProducer);
    }

    @Override // io.split.android.client.service.mysegments.MySegmentsTaskFactoryProvider
    public MySegmentsTaskFactory getFactory(MySegmentsTaskFactoryConfiguration configuration) {
        return new MySegmentsTaskFactoryImpl(configuration, this.mTelemetryRuntimeProducer);
    }
}
