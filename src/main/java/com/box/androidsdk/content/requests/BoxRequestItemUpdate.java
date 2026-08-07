package com.box.androidsdk.content.requests;

import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.models.BoxSharedLink;
import com.box.androidsdk.content.requests.BoxRequest;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes13.dex */
public abstract class BoxRequestItemUpdate<E extends BoxItem, R extends BoxRequest<E, R>> extends BoxRequestItem<E, R> {
    public abstract BoxRequestUpdateSharedItem updateSharedLink();

    protected BoxRequestItemUpdate(Class<E> cls, String str, String str2, BoxSession boxSession) {
        super(cls, str, str2, boxSession);
        this.mRequestMethod = BoxRequest.Methods.PUT;
    }

    protected BoxRequestItemUpdate(BoxRequestItemUpdate boxRequestItemUpdate) {
        super(boxRequestItemUpdate);
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

    public BoxSharedLink getSharedLink() {
        if (this.mBodyMap.containsKey("shared_link")) {
            return (BoxSharedLink) this.mBodyMap.get("shared_link");
        }
        return null;
    }

    public R setSharedLink(BoxSharedLink boxSharedLink) {
        this.mBodyMap.put("shared_link", boxSharedLink);
        return this;
    }

    @Override // com.box.androidsdk.content.requests.BoxRequest
    public R setIfMatchEtag(String str) {
        return (R) super.setIfMatchEtag(str);
    }

    @Override // com.box.androidsdk.content.requests.BoxRequest
    public String getIfMatchEtag() {
        return super.getIfMatchEtag();
    }

    public List<String> getTags() {
        if (this.mBodyMap.containsKey("tags")) {
            return (List) this.mBodyMap.get("tags");
        }
        return null;
    }

    public R setTags(List<String> list) {
        JsonArray jsonArray = new JsonArray();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            jsonArray.add(it.next());
        }
        this.mBodyMap.put("tags", jsonArray);
        return this;
    }

    @Override // com.box.androidsdk.content.requests.BoxRequest
    protected void parseHashMapEntry(JsonObject jsonObject, Map.Entry<String, Object> entry) {
        if (entry.getKey().equals("parent")) {
            jsonObject.add(entry.getKey(), parseJsonObject(entry.getValue()));
            return;
        }
        if (entry.getKey().equals("shared_link")) {
            if (entry.getValue() == null) {
                jsonObject.add(entry.getKey(), (String) null);
                return;
            } else {
                jsonObject.add(entry.getKey(), parseJsonObject(entry.getValue()));
                return;
            }
        }
        super.parseHashMapEntry(jsonObject, entry);
    }
}
