package com.box.androidsdk.content.requests;

import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.requests.BoxRequest;
import com.eclipsesource.json.JsonObject;
import java.util.Map;

/* JADX INFO: loaded from: classes13.dex */
abstract class BoxRequestItemCopy<E extends BoxItem, R extends BoxRequest<E, R>> extends BoxRequestItem<E, R> {
    protected BoxRequestItemCopy(Class<E> cls, String str, String str2, String str3, BoxSession boxSession) {
        super(cls, str, str3, boxSession);
        this.mRequestMethod = BoxRequest.Methods.POST;
        setParentId(str2);
    }

    public String getName() {
        if (this.mBodyMap.containsKey("name")) {
            return (String) this.mBodyMap.get("name");
        }
        return null;
    }

    public R setName(String str) {
        this.mBodyMap.put("name", str);
        return this;
    }

    public String getParentId() {
        if (this.mBodyMap.containsKey("parent")) {
            return ((BoxFolder) this.mBodyMap.get("parent")).getUserId();
        }
        return null;
    }

    public R setParentId(String str) {
        this.mBodyMap.put("parent", BoxFolder.createFromId(str));
        return this;
    }

    @Override // com.box.androidsdk.content.requests.BoxRequest
    protected void parseHashMapEntry(JsonObject jsonObject, Map.Entry<String, Object> entry) {
        if (entry.getKey().equals("parent")) {
            jsonObject.add(entry.getKey(), parseJsonObject(entry.getValue()));
        } else {
            super.parseHashMapEntry(jsonObject, entry);
        }
    }
}
