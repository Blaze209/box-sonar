package io.split.android.client.service.sseclient.notifications;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class ControlNotification extends IncomingNotification {

    @SerializedName("controlType")
    private ControlType controlType;

    public enum ControlType {
        STREAMING_RESUMED,
        STREAMING_DISABLED,
        STREAMING_PAUSED,
        STREAMING_RESET
    }

    public ControlType getControlType() {
        return this.controlType;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
