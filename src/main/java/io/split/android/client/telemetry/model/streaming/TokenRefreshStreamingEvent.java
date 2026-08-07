package io.split.android.client.telemetry.model.streaming;

import io.split.android.client.telemetry.model.EventTypeEnum;

/* JADX INFO: loaded from: classes4.dex */
public class TokenRefreshStreamingEvent extends StreamingEvent {
    public TokenRefreshStreamingEvent(long tokenExpirationUTC, long timestamp) {
        super(EventTypeEnum.TOKEN_REFRESH, Long.valueOf(tokenExpirationUTC), timestamp);
    }
}
