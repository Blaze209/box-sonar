package io.split.android.client.service.sseclient.feedbackchannel;

/* JADX INFO: loaded from: classes4.dex */
public class PushStatusEvent {
    private final EventType mMessage;

    public enum EventType {
        PUSH_SUBSYSTEM_UP,
        PUSH_SUBSYSTEM_DOWN,
        PUSH_RETRYABLE_ERROR,
        PUSH_NON_RETRYABLE_ERROR,
        PUSH_DISABLED,
        PUSH_RESET,
        SUCCESSFUL_SYNC,
        PUSH_DELAY_RECEIVED
    }

    public PushStatusEvent(EventType message) {
        this.mMessage = message;
    }

    public EventType getMessage() {
        return this.mMessage;
    }
}
