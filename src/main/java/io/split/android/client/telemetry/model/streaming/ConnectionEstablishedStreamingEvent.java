package io.split.android.client.telemetry.model.streaming;

import io.split.android.client.telemetry.model.EventTypeEnum;

/* JADX INFO: loaded from: classes4.dex */
public class ConnectionEstablishedStreamingEvent extends StreamingEvent {
    public ConnectionEstablishedStreamingEvent(long timestamp) {
        super(EventTypeEnum.CONNECTION_ESTABLISHED, null, timestamp);
    }
}
