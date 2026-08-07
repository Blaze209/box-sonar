package com.box.androidsdk.content.models;

import com.eclipsesource.json.JsonObject;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public class BoxUser extends BoxCollaborator {
    public static final String FIELD_AVATAR_URL = "avatar_url";
    public static final String FIELD_ENTERPRISE = "enterprise";
    public static final String FIELD_IS_BOXNOTE_CREATION_ENABLED = "is_boxnotes_creation_enabled";
    public static final String FIELD_LOGIN = "login";
    public static final String TYPE = "user";
    private static final long serialVersionUID = -9176113409457879123L;
    public static final String FIELD_SPACE_AMOUNT = "space_amount";
    public static final String FIELD_SPACE_USED = "space_used";
    public static final String FIELD_MAX_UPLOAD_SIZE = "max_upload_size";
    public static final String FIELD_HOSTNAME = "hostname";
    public static final String FIELD_MY_TAGS = "my_tags";
    public static final String[] ALL_FIELDS = {"type", "id", "name", "login", "created_at", "modified_at", FIELD_SPACE_AMOUNT, FIELD_SPACE_USED, FIELD_MAX_UPLOAD_SIZE, "avatar_url", "enterprise", FIELD_HOSTNAME, FIELD_MY_TAGS};

    public BoxUser() {
    }

    public BoxUser(JsonObject jsonObject) {
        super(jsonObject);
    }

    public static BoxUser createFromId(String str) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("id", str);
        jsonObject.add("type", "user");
        BoxUser boxUser = new BoxUser();
        boxUser.createFromJson(jsonObject);
        return boxUser;
    }

    @Override // com.box.androidsdk.content.models.BoxCollaborator
    public String getLogin() {
        return getPropertyAsString("login");
    }

    public Long getSpaceAmount() {
        return getPropertyAsLong(FIELD_SPACE_AMOUNT);
    }

    public Long getSpaceUsed() {
        return getPropertyAsLong(FIELD_SPACE_USED);
    }

    public Long getMaxUploadSize() {
        return getPropertyAsLong(FIELD_MAX_UPLOAD_SIZE);
    }

    @Deprecated
    public String getAvatarURL() {
        return getPropertyAsString("avatar_url");
    }

    public BoxEnterprise getEnterprise() {
        return (BoxEnterprise) getPropertyAsJsonObject(BoxJsonObject.getBoxJsonObjectCreator(BoxEnterprise.class), "enterprise");
    }

    public String getHostname() {
        return getPropertyAsString(FIELD_HOSTNAME);
    }

    public List<String> getMyTags() {
        return getPropertyAsStringArray(FIELD_MY_TAGS);
    }

    public boolean isBoxNoteCreationEnabled() {
        Boolean propertyAsBoolean = getPropertyAsBoolean(FIELD_IS_BOXNOTE_CREATION_ENABLED);
        return propertyAsBoolean == null || propertyAsBoolean.booleanValue();
    }
}
