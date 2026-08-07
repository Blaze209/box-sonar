package com.box.android.coreservices.models;

import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxIteratorItems;
import com.eclipsesource.json.JsonObject;

/* JADX INFO: loaded from: classes9.dex */
public final class BoxLevelDbFolder extends BoxFolder {
    private BoxLevelDbIteratorItems mBoxLevelDbIteratorItems;

    public BoxLevelDbFolder(JsonObject jsonObject) {
        super(jsonObject);
    }

    @Override // com.box.androidsdk.content.models.BoxFolder
    public BoxIteratorItems getItemCollection() {
        BoxLevelDbIteratorItems boxLevelDbIteratorItems = this.mBoxLevelDbIteratorItems;
        return boxLevelDbIteratorItems != null ? boxLevelDbIteratorItems : super.getItemCollection();
    }

    public void setItemCollection(BoxLevelDbIteratorItems boxLevelDbIteratorItems) {
        this.mBoxLevelDbIteratorItems = boxLevelDbIteratorItems;
    }
}
