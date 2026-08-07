package com.box.boxandroidlibv2private.dao;

import com.box.androidsdk.content.models.BoxEntity;
import com.box.androidsdk.content.models.BoxFile;
import com.eclipsesource.json.JsonObject;

/* JADX INFO: loaded from: classes13.dex */
public class BoxNoteCreation extends BoxEntity {
    public static final String ERROR_INVALID_OAUTH_TOKEN = "Invalid OAuth2 Access Token";
    public static final String ERROR_NAME_CONFLICT = "File name conflict.";
    public static final String FIELD_ACTION_ID = "action_id";
    public static final String FIELD_MESSAGE = "message";
    public static final String FIELD_NEW_ITEM = "new_item";
    public static final String FIELD_SUCCESS = "success";

    public BoxNoteCreation() {
    }

    public BoxNoteCreation(JsonObject jsonObject) {
        super(jsonObject);
    }

    public BoxFile getNewNote() {
        return (BoxFile) getPropertyAsJsonObject(BoxEntity.getBoxJsonObjectCreator(), FIELD_NEW_ITEM);
    }

    public Boolean getSuccess() {
        return getPropertyAsBoolean("success");
    }

    public Integer getActionId() {
        return getPropertyAsInt(FIELD_ACTION_ID);
    }

    public String getErrorMessage() {
        return getPropertyAsString("message");
    }
}
