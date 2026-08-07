package com.box.androidsdk.content.models;

import com.eclipsesource.json.JsonObject;

/* JADX INFO: loaded from: classes13.dex */
@Deprecated
public class BoxBookmark extends BoxItem {
    public static final String[] ALL_FIELDS = {"description", "type", "id", BoxItem.FIELD_ETAG, "name", "url", "created_at", "modified_at", BoxItem.FIELD_PATH_COLLECTION, "modified_by", BoxItem.FIELD_OWNED_BY, "shared_link", "parent", BoxItem.FIELD_ITEM_STATUS, "permissions", "comment_count"};
    public static final String FIELD_COMMENT_COUNT = "comment_count";
    public static final String FIELD_URL = "url";
    public static final String TYPE = "web_link";
    private static final long serialVersionUID = 2628881847260043250L;

    @Override // com.box.androidsdk.content.models.BoxItem
    public Long getSize() {
        return null;
    }

    public BoxBookmark() {
    }

    public BoxBookmark(JsonObject jsonObject) {
        super(jsonObject);
    }

    public static BoxBookmark createFromId(String str) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("id", str);
        jsonObject.add("type", TYPE);
        return new BoxBookmark(jsonObject);
    }

    public static BoxBookmark createFromIdAndName(String str, String str2) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("id", str);
        jsonObject.add("type", TYPE);
        jsonObject.add("name", str2);
        return new BoxBookmark(jsonObject);
    }

    public String getUrl() {
        return getPropertyAsString("url");
    }
}
