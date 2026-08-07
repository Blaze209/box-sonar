package io.split.android.client.telemetry.model.streaming;

import io.split.android.client.telemetry.model.EventTypeEnum;

/* JADX INFO: loaded from: classes4.dex */
public class AblyErrorStreamingEvent extends StreamingEvent {
    public AblyErrorStreamingEvent(long errorCode, long timestamp) {
        super(EventTypeEnum.ABLY_ERROR, Long.valueOf(errorCode), timestamp);
    }
}
