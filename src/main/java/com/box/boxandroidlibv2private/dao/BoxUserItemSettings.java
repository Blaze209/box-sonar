package com.box.boxandroidlibv2private.dao;

import android.util.Base64;
import com.box.androidsdk.content.models.BoxEntity;
import com.eclipsesource.json.JsonObject;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes13.dex */
public class BoxUserItemSettings extends BoxEntity {
    public static final String FIELD_IS_NOTIFICATION_ENABLED = "is_notification_enabled";

    public BoxUserItemSettings() {
    }

    public BoxUserItemSettings(JsonObject jsonObject) {
        super(jsonObject);
    }

    public static String createUserItemIdKey(String str, String str2) {
        return Base64.encodeToString((str + "_" + str2).getBytes(), 0).replaceAll(StringUtils.CR, "").replaceAll("\n", "");
    }

    public Boolean getIsNotificationEnabled() {
        return getPropertyAsBoolean("is_notification_enabled");
    }

    public String getUserItemId() {
        return getPropertyAsString("id");
    }

    public String getUserItemType() {
        return getPropertyAsString("type");
    }
}
