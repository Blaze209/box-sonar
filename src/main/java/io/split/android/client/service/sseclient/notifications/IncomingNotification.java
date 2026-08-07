package io.split.android.client.service.sseclient.notifications;

/* JADX INFO: loaded from: classes4.dex */
public class IncomingNotification extends IncomingNotificationType {
    protected String channel;
    private String jsonData;
    protected long timestamp;

    public IncomingNotification() {
    }

    public IncomingNotification(NotificationType type, String channel, String jsonData, long timestamp) {
        this.type = type;
        this.channel = channel;
        this.jsonData = jsonData;
        this.timestamp = timestamp;
    }

    @Override // io.split.android.client.service.sseclient.notifications.IncomingNotificationType
    public NotificationType getType() {
        return this.type;
    }

    public String getJsonData() {
        return this.jsonData;
    }

    public String getChannel() {
        return this.channel;
    }

    public long getTimestamp() {
        return this.timestamp;
    }
}
