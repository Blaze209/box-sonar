package com.box.boxandroidlibv2private.model;

import android.os.Bundle;
import android.text.TextUtils;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxUser;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiCollections;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import java.util.Random;
import java.util.Set;

/* JADX INFO: loaded from: classes13.dex */
public class BoxPushNotification extends BoxItem {
    public static final String ANONYMOUS_USER = "-1";
    protected static final String COMMENT_MESSAGE = "comment_message";
    protected static final String DISPLAY_MESSAGE = "display_message";
    protected static final String DISPLAY_TITLE = "display_title";
    protected static final String EVENT_TAG = "event_tag";
    protected static final String FIELD_COMMENT_ID = "comment_id";
    public static final String FIELD_IS_DISMISSED = "IS_DISMISSED";
    public static final String FIELD_IS_PROCESSED = "IS_PROCESSED";
    public static final String FIELD_MUTE_TYPES = "mute_types";
    public static final String FIREBASE_SENT_TIME = "firebase.sent_time";
    protected static final String GOOGLE_SENT_TIME = "google.sent_time";
    public static final String MENTIONED_NOTIFICATION_TAG = "WAS_MENTIONED";
    protected static final String MESSAGE = "message";
    protected static final String NOTIF_TYPE = "event_type";
    protected static final String PLURAL_FORMAT = "plural_format";
    public static final String PREVIOUS_DISMISS_TIME = "PREVIOUS_DISMISS_TIME";
    protected static final String SOURCE_USER_ID = "source_user_id";
    protected static final String SOURCE_USER_LOGIN = "source_user_login";
    protected static final String SOURCE_USER_NAME = "source_user_name";
    protected static final String TARGET_RESOURCE_ID = "target_resource_id";
    protected static final String TARGET_RESOURCE_NAME = "target_resource_name";
    protected static final String TARGET_RESOURCE_TYPE = "target_resource_type";
    protected static final String TARGET_USER_ID = "target_user_id";
    public static final String TYPE_PUSH_NOTIFICATION = "push_notification";
    public static final String UNFILTERED_UPDATE_TAG = "unfiltered_updates";
    private static final Random random = new Random();

    public BoxPushNotification() {
    }

    public BoxPushNotification(JsonObject jsonObject) {
        createFromJson(jsonObject);
    }

    public BoxPushNotification(Bundle bundle) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("id", generateId());
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj instanceof String) {
                jsonObject.add(str, (String) obj);
            } else if (obj instanceof Long) {
                jsonObject.add(str, ((Long) obj).longValue());
            }
        }
        jsonObject.add("type", TYPE_PUSH_NOTIFICATION);
        createFromJson(jsonObject);
    }

    public String getTargetResourceId() {
        return getPropertyAsString(TARGET_RESOURCE_ID);
    }

    public String getTargetResourceType() {
        return getPropertyAsString(TARGET_RESOURCE_TYPE);
    }

    public String getTargetResourceName() {
        return getPropertyAsString(TARGET_RESOURCE_NAME);
    }

    public void setTargetResourceName(String str) {
        set(TARGET_RESOURCE_NAME, str);
    }

    public String getPluralFormat() {
        return getPropertyAsString(PLURAL_FORMAT);
    }

    public String getSourceUserId() {
        String propertyAsString = getPropertyAsString(SOURCE_USER_ID);
        return TextUtils.isEmpty(propertyAsString) ? "-1" : propertyAsString;
    }

    public boolean isAnonymousNotification() {
        String propertyAsString = getPropertyAsString(SOURCE_USER_ID);
        return TextUtils.isEmpty(propertyAsString) || "-1".equals(propertyAsString);
    }

    public void setSourceUserId(String str) {
        set(SOURCE_USER_ID, str);
    }

    public String getSourceUserName() {
        return getPropertyAsString(SOURCE_USER_NAME);
    }

    public void setSourceUserName(String str) {
        set(SOURCE_USER_NAME, str);
    }

    public String getCommentId() {
        return getPropertyAsString(FIELD_COMMENT_ID);
    }

    public String getCommentMessage() {
        return getPropertyAsString(COMMENT_MESSAGE);
    }

    public String getNotifTypeString() {
        return getPropertyAsString("event_type");
    }

    public Long getSentTime() {
        Long propertyAsLong = getPropertyAsLong(GOOGLE_SENT_TIME);
        if (propertyAsLong == null) {
            try {
                return Long.valueOf(getPropertyAsString(FIREBASE_SENT_TIME));
            } catch (NumberFormatException e) {
                BoxLogUtils.e("Error formatting sentTime", e);
            }
        }
        return propertyAsLong;
    }

    public PushNotifType getNotifType() {
        return PushNotifType.valueOf(getNotifTypeString());
    }

    protected void setId(String str) {
        set("id", str);
    }

    public String getMessage() {
        return getPropertyAsString("message");
    }

    public void setMessage(String str) {
        set("message", str);
    }

    public String getDisplayTitle() {
        String propertyAsString = getPropertyAsString(DISPLAY_TITLE);
        return propertyAsString == null ? "" : propertyAsString;
    }

    public void setDisplayTitle(String str) {
        set(DISPLAY_TITLE, str);
    }

    public String getDisplayMessage() {
        String propertyAsString = getPropertyAsString(DISPLAY_MESSAGE);
        return propertyAsString == null ? getMessage() : propertyAsString;
    }

    public void setDisplayMessage(String str) {
        set(DISPLAY_MESSAGE, str);
    }

    public String getTargetUserId() {
        return getPropertyAsString(TARGET_USER_ID);
    }

    public String getEventTag() {
        return getPropertyAsString(EVENT_TAG);
    }

    public BoxUser getDisplayUser() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("id", getSourceUserId());
        jsonObject.add("type", "user");
        jsonObject.add("name", getSourceUserName());
        BoxUser boxUser = new BoxUser();
        boxUser.createFromJson(jsonObject);
        return boxUser;
    }

    public void addMuteType(String str) {
        JsonArray propertyAsJsonArray = getPropertyAsJsonArray(FIELD_MUTE_TYPES);
        if (propertyAsJsonArray == null) {
            propertyAsJsonArray = new JsonArray();
        }
        if (getMuteTypes() == null || !getMuteTypes().contains(str)) {
            propertyAsJsonArray.add(str);
            set(FIELD_MUTE_TYPES, propertyAsJsonArray);
        }
    }

    public Set<String> getMuteTypes() {
        return getPropertyAsStringHashSet(FIELD_MUTE_TYPES);
    }

    public void clearMuteTypes() {
        set(FIELD_MUTE_TYPES, new JsonArray());
    }

    public void setIsDismissed() {
        set(FIELD_IS_DISMISSED, (Boolean) true);
    }

    public Long getPreviousDismissTime() {
        return getPropertyAsLong(PREVIOUS_DISMISS_TIME);
    }

    public void setPreviousDismissTime(long j) {
        set(PREVIOUS_DISMISS_TIME, Long.valueOf(j));
    }

    public Boolean isDismissed() {
        Boolean propertyAsBoolean = getPropertyAsBoolean(FIELD_IS_DISMISSED);
        if (propertyAsBoolean == null) {
            return false;
        }
        return propertyAsBoolean;
    }

    public void setIsProcessed() {
        set(FIELD_IS_PROCESSED, (Boolean) true);
    }

    public boolean isProcessed() {
        Boolean propertyAsBoolean = getPropertyAsBoolean(FIELD_IS_PROCESSED);
        if (propertyAsBoolean == null) {
            return false;
        }
        return propertyAsBoolean.booleanValue();
    }

    public static BoxPushNotification readFrom(String str) {
        return new BoxPushNotification(JsonObject.readFrom(str));
    }

    private static String generateId() {
        return Long.toString(System.currentTimeMillis()) + random.nextFloat();
    }

    public enum PushNotifType {
        COLLAB_INVITE_COLLABORATOR(""),
        COMMENT_CREATE(BoxExtendedApiCollections.COLLECTION_TYPE_MUTE_CONVERSATIONS),
        ITEM_UPLOAD(BoxExtendedApiCollections.COLLECTION_TYPE_MUTE_UPDATES),
        ITEM_MODIFY(BoxExtendedApiCollections.COLLECTION_TYPE_MUTE_UPDATES);

        private final String mCollectionType;

        PushNotifType(String str) {
            this.mCollectionType = str;
        }

        public String getMuteCollectionType() {
            return this.mCollectionType;
        }
    }
}
