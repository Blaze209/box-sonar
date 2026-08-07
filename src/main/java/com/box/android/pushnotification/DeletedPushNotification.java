package com.box.android.pushnotification;

import com.box.boxandroidlibv2private.model.BoxPushNotification;
import com.eclipsesource.json.JsonValue;

/* JADX INFO: loaded from: classes12.dex */
public class DeletedPushNotification extends BoxPushNotification {
    private static final String FIELD_IS_DELETED = "is_deleted";

    public DeletedPushNotification(BoxPushNotification boxPushNotification) {
        super(boxPushNotification.toJsonObject());
    }

    public void setDeleted(boolean z) {
        set(FIELD_IS_DELETED, Boolean.valueOf(z));
    }

    public boolean isDeleted() {
        Boolean propertyAsBoolean = getPropertyAsBoolean(FIELD_IS_DELETED);
        return propertyAsBoolean != null && propertyAsBoolean.booleanValue();
    }

    public static boolean isDeletedNotification(BoxPushNotification boxPushNotification) {
        if (boxPushNotification instanceof DeletedPushNotification) {
            return ((DeletedPushNotification) boxPushNotification).isDeleted();
        }
        JsonValue propertyValue = boxPushNotification.getPropertyValue(FIELD_IS_DELETED);
        if (propertyValue != null) {
            return propertyValue.asBoolean();
        }
        return false;
    }
}
