package io.split.android.client.telemetry.model.streaming;

import io.split.android.client.telemetry.model.EventTypeEnum;

/* JADX INFO: loaded from: classes4.dex */
public class SseConnectionErrorStreamingEvent extends StreamingEvent {
    public SseConnectionErrorStreamingEvent(Status eventData, long timestamp) {
        super(EventTypeEnum.SSE_CONNECTION_ERROR, Long.valueOf(eventData.getNumericValue()), timestamp);
    }

    public enum Status {
        REQUESTED(0),
        NON_REQUESTED(1);

        private final int numericValue;

        Status(int numericValue) {
            this.numericValue = numericValue;
        }

        public int getNumericValue() {
            return this.numericValue;
        }
    }
}
