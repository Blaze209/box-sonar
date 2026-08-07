package io.split.android.client.telemetry.storage;

import io.split.android.client.telemetry.model.EventsDataRecordsEnum;
import io.split.android.client.telemetry.model.ImpressionsDataType;
import io.split.android.client.telemetry.model.OperationType;
import io.split.android.client.telemetry.model.streaming.StreamingEvent;
import io.split.android.client.telemetry.model.streaming.UpdatesFromSSEEnum;

/* JADX INFO: loaded from: classes4.dex */
public interface TelemetryRuntimeProducer {
    void addTag(String tag);

    void recordAuthRejections();

    void recordEventStats(EventsDataRecordsEnum dataType, long count);

    void recordImpressionStats(ImpressionsDataType dataType, long count);

    void recordSessionLength(long sessionLength);

    void recordStreamingEvents(StreamingEvent streamingEvent);

    void recordSuccessfulSync(OperationType resource, long time);

    void recordSyncError(OperationType syncedResource, Integer status);

    void recordSyncLatency(OperationType resource, long latency);

    void recordTokenRefreshes();

    void recordUpdatesFromSSE(UpdatesFromSSEEnum sseUpdate);
}
