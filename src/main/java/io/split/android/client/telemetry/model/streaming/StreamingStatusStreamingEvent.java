package io.split.android.client.telemetry.model.streaming;

import io.split.android.client.telemetry.model.EventTypeEnum;

/* JADX INFO: loaded from: classes4.dex */
public class StreamingStatusStreamingEvent extends StreamingEvent {
    public StreamingStatusStreamingEvent(Status eventData, long timestamp) {
        super(EventTypeEnum.STREAMING_STATUS, Long.valueOf(eventData.getNumericValue()), timestamp);
    }

    public enum Status {
        DISABLED(0),
        ENABLED(1),
        PAUSED(2);

        private final int numericValue;

        Status(int numericValue) {
            this.numericValue = numericValue;
        }

        public int getNumericValue() {
            return this.numericValue;
        }
    }
}
