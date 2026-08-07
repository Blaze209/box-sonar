package com.box.boxandroidlibv2private.model;

import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxIteratorItems;
import com.box.androidsdk.content.models.BoxJsonObject;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes13.dex */
public class BoxIteratorBoxRecentFiles extends BoxIteratorItems {
    private static final long serialVersionUID = -1642742056723484123L;
    private final ArrayList<BoxItem> mRecentsList;

    @Override // com.box.androidsdk.content.models.BoxIteratorBoxEntity, com.box.androidsdk.content.models.BoxIterator
    protected BoxJsonObject.BoxJsonObjectCreator<BoxItem> getObjectCreator() {
        return null;
    }

    public BoxIteratorBoxRecentFiles(ArrayList<BoxItem> arrayList) {
        this.mRecentsList = arrayList;
        JsonObject jsonObject = new JsonObject();
        JsonArray jsonArray = new JsonArray();
        Iterator<BoxItem> it = arrayList.iterator();
        while (it.hasNext()) {
            jsonArray.add(it.next().toJsonObject());
        }
        jsonObject.set("entries", jsonArray);
        createFromJson(jsonObject);
    }

    @Override // com.box.androidsdk.content.models.BoxIterator, java.lang.Iterable
    public Iterator<BoxItem> iterator() {
        return this.mRecentsList.iterator();
    }

    @Override // com.box.androidsdk.content.models.BoxIterator
    public ArrayList<BoxItem> getEntries() {
        return this.mRecentsList;
    }
}
