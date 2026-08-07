package io.split.android.client.telemetry.model.streaming;

import com.google.gson.annotations.SerializedName;
import io.split.android.client.telemetry.model.EventTypeEnum;

/* JADX INFO: loaded from: classes4.dex */
public class StreamingEvent {

    @SerializedName("d")
    private final Long eventData;

    @SerializedName("e")
    private final int eventType;

    @SerializedName("t")
    private final long timestamp;

    public StreamingEvent(EventTypeEnum eventType, Long eventData, long timestamp) {
        this.eventType = eventType.getNumericValue();
        this.eventData = eventData;
        this.timestamp = timestamp;
    }

    public int getEventType() {
        return this.eventType;
    }

    public Long getEventData() {
        return this.eventData;
    }

    public long getTimestamp() {
        return this.timestamp;
    }
}
