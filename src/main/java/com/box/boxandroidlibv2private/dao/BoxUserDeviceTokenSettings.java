package com.box.boxandroidlibv2private.dao;

import com.box.androidsdk.content.models.BoxEntity;
import com.eclipsesource.json.JsonObject;

/* JADX INFO: loaded from: classes13.dex */
public class BoxUserDeviceTokenSettings extends BoxEntity {
    public static final String FIELD_IS_NOTIFICATION_ENABLED = "is_notification_enabled";

    public BoxUserDeviceTokenSettings() {
    }

    public BoxUserDeviceTokenSettings(JsonObject jsonObject) {
        super(jsonObject);
    }

    public Boolean getIsNotificationEnabled() {
        return getPropertyAsBoolean("is_notification_enabled");
    }

    public String getUserDeviceTokenId() {
        return getPropertyAsString("id");
    }

    public String getUserDeviceTokenType() {
        return getPropertyAsString("type");
    }
}
