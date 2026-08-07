package io.split.android.client.service.sseclient.feedbackchannel;

/* JADX INFO: loaded from: classes4.dex */
public class DelayStatusEvent extends PushStatusEvent {
    private final long mDelay;

    public DelayStatusEvent(long delay) {
        super(PushStatusEvent.EventType.PUSH_DELAY_RECEIVED);
        this.mDelay = delay;
    }

    public Long getDelay() {
        return Long.valueOf(this.mDelay);
    }
}
