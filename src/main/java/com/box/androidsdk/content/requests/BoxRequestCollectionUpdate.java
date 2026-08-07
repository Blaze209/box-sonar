package com.box.androidsdk.content.requests;

import android.text.TextUtils;
import com.box.androidsdk.content.models.BoxCollection;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.requests.BoxRequest;
import com.eclipsesource.json.JsonArray;

/* JADX INFO: loaded from: classes13.dex */
public abstract class BoxRequestCollectionUpdate<E extends BoxItem, R extends BoxRequest<E, R>> extends BoxRequestItem<E, R> {
    protected static final String FIELD_COLLECTIONS = "collections";

    protected BoxRequestCollectionUpdate(Class<E> cls, String str, String str2, BoxSession boxSession) {
        super(cls, str, str2, boxSession);
        this.mRequestMethod = BoxRequest.Methods.PUT;
    }

    protected R setCollectionId(String str) {
        JsonArray jsonArray = new JsonArray();
        if (!TextUtils.isEmpty(str)) {
            jsonArray.add(BoxCollection.createFromId(str).toJsonObject());
        }
        this.mBodyMap.put("collections", jsonArray);
        return this;
    }
}
