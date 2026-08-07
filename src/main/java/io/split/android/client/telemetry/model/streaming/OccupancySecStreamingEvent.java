package io.split.android.client.telemetry.model.streaming;

import io.split.android.client.telemetry.model.EventTypeEnum;

/* JADX INFO: loaded from: classes4.dex */
public class OccupancySecStreamingEvent extends StreamingEvent {
    public OccupancySecStreamingEvent(long publishersCount, long timestamp) {
        super(EventTypeEnum.OCCUPANCY_SEC, Long.valueOf(publishersCount), timestamp);
    }
}
