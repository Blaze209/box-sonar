package com.box.androidsdk.content.models;

import com.eclipsesource.json.JsonObject;
import java.util.Date;

/* JADX INFO: loaded from: classes13.dex */
public class BoxFileVersion extends BoxEntity {
    public static final String FIELD_CREATED_AT = "created_at";
    public static final String FIELD_MODIFIED_AT = "modified_at";
    public static final String FIELD_MODIFIED_BY = "modified_by";
    public static final String FIELD_NAME = "name";
    public static final String FIELD_SHA1 = "sha1";
    public static final String FIELD_SIZE = "size";
    public static final String FIELD_UPLOADER_DISPLAY_NAME = "uploader_display_name";
    public static final String TYPE = "file_version";
    private static final long serialVersionUID = -1013756375421636876L;
    public static final String FIELD_DELETED_AT = "deleted_at";
    public static final String[] ALL_FIELDS = {"name", "size", "sha1", "uploader_display_name", "modified_by", "created_at", "modified_at", FIELD_DELETED_AT};

    public String getName() {
        return getPropertyAsString("name");
    }

    public String getUploaderDisplayName() {
        return getPropertyAsString("uploader_display_name");
    }

    public Date getCreatedAt() {
        return getPropertyAsDate("created_at");
    }

    public Date getModifiedAt() {
        return getPropertyAsDate("modified_at");
    }

    public String getSha1() {
        return getPropertyAsString("sha1");
    }

    public Date getDeletedAt() {
        return getPropertyAsDate(FIELD_DELETED_AT);
    }

    public Long getSize() {
        return getPropertyAsLong("size");
    }

    public BoxUser getModifiedBy() {
        return (BoxUser) getPropertyAsJsonObject(BoxEntity.getBoxJsonObjectCreator(), "modified_by");
    }

    private BoxUser parseUserInfo(JsonObject jsonObject) {
        BoxUser boxUser = new BoxUser();
        boxUser.createFromJson(jsonObject);
        return boxUser;
    }
}
