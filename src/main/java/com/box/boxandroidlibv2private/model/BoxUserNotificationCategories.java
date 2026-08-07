package com.box.boxandroidlibv2private.model;

import com.box.androidsdk.content.models.BoxEntity;
import com.box.androidsdk.content.models.BoxJsonObject;
import com.eclipsesource.json.JsonObject;

/* JADX INFO: loaded from: classes13.dex */
public class BoxUserNotificationCategories extends BoxJsonObject {
    private static final String FIELD_MENTIONS = "MENTIONS";
    private static final String FIELD_RELEVANT_UPDATES = "RELEVANT_UPDATES";
    private static final String FIELD_SHARING = "SHARING";
    private static final String FIELD_TASKS = "TASKS";
    public static final String USER_NOTIFICATION_CATEGORIES = "notification_categories";

    public static class BoxUserNotificationCategory extends BoxJsonObject {
        private static final String FIELD_IS_NOTIFICATION_ENABLED = "is_notification_enabled";

        public boolean getIsNotificationEnabled() {
            Boolean propertyAsBoolean = getPropertyAsBoolean("is_notification_enabled");
            if (propertyAsBoolean == null) {
                return true;
            }
            return propertyAsBoolean.booleanValue();
        }
    }

    public BoxUserNotificationCategories() {
    }

    public BoxUserNotificationCategories(JsonObject jsonObject) {
        super(jsonObject);
    }

    public Boolean getUserNotificationSharingSetting() {
        BoxUserNotificationCategory boxUserNotificationCategory = (BoxUserNotificationCategory) getPropertyAsJsonObject(BoxEntity.getBoxJsonObjectCreator(BoxUserNotificationCategory.class), FIELD_SHARING);
        if (boxUserNotificationCategory != null) {
            return Boolean.valueOf(boxUserNotificationCategory.getIsNotificationEnabled());
        }
        return true;
    }

    public Boolean getUserNotificationMentionsSetting() {
        BoxUserNotificationCategory boxUserNotificationCategory = (BoxUserNotificationCategory) getPropertyAsJsonObject(BoxEntity.getBoxJsonObjectCreator(BoxUserNotificationCategory.class), FIELD_MENTIONS);
        if (boxUserNotificationCategory != null) {
            return Boolean.valueOf(boxUserNotificationCategory.getIsNotificationEnabled());
        }
        return true;
    }

    public Boolean getUserNotificationTasksSetting() {
        BoxUserNotificationCategory boxUserNotificationCategory = (BoxUserNotificationCategory) getPropertyAsJsonObject(BoxEntity.getBoxJsonObjectCreator(BoxUserNotificationCategory.class), FIELD_TASKS);
        if (boxUserNotificationCategory != null) {
            return Boolean.valueOf(boxUserNotificationCategory.getIsNotificationEnabled());
        }
        return true;
    }

    public Boolean getUserNotificationUpdatesSetting() {
        BoxUserNotificationCategory boxUserNotificationCategory = (BoxUserNotificationCategory) getPropertyAsJsonObject(BoxEntity.getBoxJsonObjectCreator(BoxUserNotificationCategory.class), FIELD_RELEVANT_UPDATES);
        if (boxUserNotificationCategory != null) {
            return Boolean.valueOf(boxUserNotificationCategory.getIsNotificationEnabled());
        }
        return true;
    }

    public static BoxUserNotificationCategory createFromNotificationStatus(boolean z) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("is_notification_enabled", z);
        BoxUserNotificationCategory boxUserNotificationCategory = new BoxUserNotificationCategory();
        boxUserNotificationCategory.createFromJson(jsonObject);
        return boxUserNotificationCategory;
    }
}
