package com.box.boxandroidlibv2private.dao;

import com.box.androidsdk.content.models.BoxEntity;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;

/* JADX INFO: loaded from: classes13.dex */
public class BoxConvertedPushNotificationDevice extends BoxEntity {
    public static final String CONFLICTS = "conflicts";
    public static final String CONTEXT_INFO = "context_info";
    public static final String DEVICE_TOKEN = "device_token";
    public static final String EVENTS = "events";
    public static final String LANGUAGE = "language";
    public static final String PLATFORM = "platform";
    public static final String TYPE = "push_notification_device";

    @Override // com.box.androidsdk.content.models.BoxJsonObject
    protected void parseJSONMember(JsonObject.Member member) {
        String name = member.getName();
        JsonValue value = member.getValue();
        if (name.equals("language")) {
            set("language", value.asString());
            return;
        }
        if (name.equals("platform")) {
            set("platform", value.asString());
            return;
        }
        if (name.equals(DEVICE_TOKEN)) {
            set(DEVICE_TOKEN, value.asString());
        } else {
            if (name.equals(EVENTS)) {
                BoxEntity boxEntity = new BoxEntity();
                boxEntity.createFromJson(value.asObject());
                set(EVENTS, boxEntity);
                return;
            }
            super.parseJSONMember(member);
        }
    }

    public String getLanguage() {
        return getPropertyAsString("language");
    }

    public String getPlatform() {
        return getPropertyAsString("platform");
    }

    public String getDeviceToken() {
        return getPropertyAsString(DEVICE_TOKEN);
    }

    public BoxEntity getEvents() {
        return (BoxEntity) getPropertyAsJsonObject(BoxEntity.getBoxJsonObjectCreator(), EVENTS);
    }
}
