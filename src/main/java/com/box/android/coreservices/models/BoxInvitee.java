package com.box.android.coreservices.models;

import com.box.androidsdk.content.models.BoxJsonObject;
import com.eclipsesource.json.JsonObject;

/* JADX INFO: loaded from: classes9.dex */
public class BoxInvitee extends BoxJsonObject {
    public static final String FIELD_EMAIL = "email";
    public static final String FIELD_NAME = "name";
    private static final long serialVersionUID = -7334617777668107716L;

    public BoxInvitee() {
    }

    public BoxInvitee(JsonObject jsonObject) {
        super(jsonObject);
    }

    public static BoxInvitee createEntityFromJson(JsonObject jsonObject) {
        BoxInvitee boxInvitee = new BoxInvitee();
        if (jsonObject == null) {
            return null;
        }
        boxInvitee.createFromJson(jsonObject);
        return boxInvitee;
    }

    public String getName() {
        return getPropertyAsString("name");
    }

    public String getEmail() {
        return getPropertyAsString("email");
    }

    public String toString() {
        return getEmail();
    }
}
