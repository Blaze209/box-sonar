package com.box.boxandroidlibv2private.requests.requestobjects;

import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxIteratorItems;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import java.io.Serializable;
import java.util.Iterator;

/* JADX INFO: loaded from: classes13.dex */
public class BoxFullFolder extends BoxFolder implements Serializable {
    private static final long serialVersionUID = 5700988784420491722L;
    JsonArray mChildren;

    public BoxFullFolder(BoxFolder boxFolder) {
        super(boxFolder.toJsonObject());
        this.mChildren = new JsonArray();
    }

    public void addChildren(BoxIteratorItems boxIteratorItems) {
        Iterator<E> it = boxIteratorItems.iterator();
        while (it.hasNext()) {
            this.mChildren.add(((BoxItem) it.next()).toJsonObject());
        }
    }

    public BoxIteratorItems getChildren() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.set("entries", this.mChildren);
        return new BoxIteratorItems(jsonObject);
    }
}
