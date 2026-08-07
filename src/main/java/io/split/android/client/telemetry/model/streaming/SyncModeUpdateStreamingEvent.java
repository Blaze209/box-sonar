package io.split.android.client.telemetry.model.streaming;

import io.split.android.client.telemetry.model.EventTypeEnum;

/* JADX INFO: loaded from: classes4.dex */
public class SyncModeUpdateStreamingEvent extends StreamingEvent {
    public SyncModeUpdateStreamingEvent(Mode mode, long timestamp) {
        super(EventTypeEnum.SYNC_MODE_UPDATE, Long.valueOf(mode.getNumericValue()), timestamp);
    }

    public enum Mode {
        STREAMING(0),
        POLLING(1);

        private final int numericValue;

        Mode(int numericValue) {
            this.numericValue = numericValue;
        }

        public int getNumericValue() {
            return this.numericValue;
        }
    }
}
