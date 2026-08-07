package com.box.boxandroidlibv2private.model;

import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxJsonObject;
import com.box.androidsdk.content.models.BoxRecentItem;

/* JADX INFO: loaded from: classes13.dex */
public final class BoxRecentBoxFile extends BoxFile implements IBoxRecentHolder {
    private static final String FIELD_RECENT_ITEM = "recent_item";
    public static final String RECENT_INTERACTION_TYPE_COMMENT = "item_comment";
    public static final String RECENT_INTERACTION_TYPE_MODIFY = "item_modify";
    public static final String RECENT_INTERACTION_TYPE_OPEN = "item_open";
    public static final String RECENT_INTERACTION_TYPE_PREVIEW = "item_preview";
    public static final String RECENT_INTERACTION_TYPE_UPLOAD = "item_upload";

    public BoxRecentBoxFile(BoxFile boxFile, BoxRecentItem boxRecentItem) {
        super(boxFile.toJsonObject());
        setRecentItem(boxRecentItem);
    }

    private void setRecentItem(BoxRecentItem boxRecentItem) {
        set(FIELD_RECENT_ITEM, boxRecentItem.toJsonObject());
    }

    @Override // com.box.boxandroidlibv2private.model.IBoxRecentHolder
    public BoxRecentItem getRecentItem() {
        return (BoxRecentItem) getPropertyAsJsonObject(BoxJsonObject.getBoxJsonObjectCreator(BoxRecentItem.class), FIELD_RECENT_ITEM);
    }
}
