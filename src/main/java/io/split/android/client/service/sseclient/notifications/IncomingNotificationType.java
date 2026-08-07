package io.split.android.client.service.sseclient.notifications;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class IncomingNotificationType {

    @SerializedName("type")
    protected NotificationType type;

    public NotificationType getType() {
        return this.type;
    }
}
