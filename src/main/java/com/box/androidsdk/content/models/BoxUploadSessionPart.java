package com.box.androidsdk.content.models;

import com.eclipsesource.json.JsonObject;

/* JADX INFO: loaded from: classes13.dex */
public class BoxUploadSessionPart extends BoxJsonObject {
    public static final String FIELD_OFFSET = "offset";
    public static final String FIELD_PART = "part";
    public static final String FIELD_PART_ID = "part_id";
    public static final String FIELD_SHA1 = "sha1";
    public static final String FIELD_SIZE = "size";

    public BoxUploadSessionPart(JsonObject jsonObject) {
        super(jsonObject);
    }

    @Override // com.box.androidsdk.content.models.BoxJsonObject
    public void createFromJson(JsonObject jsonObject) {
        if (jsonObject.get(FIELD_PART) != null) {
            jsonObject = jsonObject.get(FIELD_PART).asObject();
        }
        super.createFromJson(jsonObject);
    }

    public BoxUploadSessionPart() {
    }

    public String getSha1() {
        return getPropertyAsString("sha1");
    }

    public String getPartId() {
        return getPropertyAsString(FIELD_PART_ID);
    }

    public long getOffset() {
        return getPropertyAsLong("offset").longValue();
    }

    public long getSize() {
        return getPropertyAsLong("size").longValue();
    }
}
