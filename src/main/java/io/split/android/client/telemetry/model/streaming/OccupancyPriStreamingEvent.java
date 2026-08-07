package io.split.android.client.telemetry.model.streaming;

import io.split.android.client.telemetry.model.EventTypeEnum;

/* JADX INFO: loaded from: classes4.dex */
public class OccupancyPriStreamingEvent extends StreamingEvent {
    public OccupancyPriStreamingEvent(long publishersCount, long timestamp) {
        super(EventTypeEnum.OCCUPANCY_PRI, Long.valueOf(publishersCount), timestamp);
    }
}
