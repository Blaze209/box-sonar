package com.box.androidsdk.content.models;

import com.eclipsesource.json.JsonObject;

/* JADX INFO: loaded from: classes13.dex */
public class BoxSimpleMessage extends BoxJsonObject {
    public static final String FIELD_MESSAGE = "message";
    public static final String MESSAGE_NEW_CHANGE = "new_change";
    public static final String MESSAGE_RECONNECT = "reconnect";
    private static final long serialVersionUID = 1626798809346520004L;

    public String getMessage() {
        return getPropertyAsString("message");
    }

    public BoxSimpleMessage() {
    }

    public BoxSimpleMessage(JsonObject jsonObject) {
        super(jsonObject);
    }
}
