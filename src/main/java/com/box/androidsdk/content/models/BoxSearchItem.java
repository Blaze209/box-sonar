package com.box.androidsdk.content.models;

import com.eclipsesource.json.JsonObject;

/* JADX INFO: loaded from: classes13.dex */
public class BoxSearchItem extends BoxItem {
    private static final String FIELD_ITEM = "item";
    private static final String FIELD_SHARED_LINK_ACCESSIBLE = "accessible_via_shared_link";
    public static final String TYPE = "search_result";

    public BoxSearchItem() {
    }

    public BoxSearchItem(JsonObject jsonObject) {
        super(jsonObject);
    }

    public String getAccessibleSharedLink() {
        return getPropertyAsString(FIELD_SHARED_LINK_ACCESSIBLE);
    }

    public BoxItem getItem() {
        return (BoxItem) getPropertyAsJsonObject(BoxEntity.getBoxJsonObjectCreator(), "item");
    }

    public static BoxSearchItem createBoxSearchItemFromJson(JsonObject jsonObject) {
        return new BoxSearchItem(jsonObject);
    }

    @Override // com.box.androidsdk.content.models.BoxEntity
    /* JADX INFO: renamed from: getId */
    public String getUserId() {
        return getItem().getUserId();
    }

    @Override // com.box.androidsdk.content.models.BoxItem
    public String getName() {
        return getItem().getName();
    }
}
