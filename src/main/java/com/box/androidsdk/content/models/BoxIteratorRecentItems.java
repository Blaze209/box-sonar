package com.box.androidsdk.content.models;

import com.eclipsesource.json.JsonObject;

/* JADX INFO: loaded from: classes13.dex */
public class BoxIteratorRecentItems extends BoxIterator<BoxRecentItem> {
    private static final long serialVersionUID = -2642748896882484555L;
    private transient BoxJsonObject.BoxJsonObjectCreator<BoxRecentItem> representationCreator;

    public BoxIteratorRecentItems() {
    }

    public BoxIteratorRecentItems(JsonObject jsonObject) {
        super(jsonObject);
    }

    @Override // com.box.androidsdk.content.models.BoxIterator
    protected BoxJsonObject.BoxJsonObjectCreator<BoxRecentItem> getObjectCreator() {
        BoxJsonObject.BoxJsonObjectCreator<BoxRecentItem> boxJsonObjectCreator = this.representationCreator;
        if (boxJsonObjectCreator != null) {
            return boxJsonObjectCreator;
        }
        BoxJsonObject.BoxJsonObjectCreator<BoxRecentItem> boxJsonObjectCreator2 = BoxJsonObject.getBoxJsonObjectCreator(BoxRecentItem.class);
        this.representationCreator = boxJsonObjectCreator2;
        return boxJsonObjectCreator2;
    }
}
