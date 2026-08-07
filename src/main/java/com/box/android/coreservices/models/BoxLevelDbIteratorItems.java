package com.box.android.coreservices.models;

import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.localrepo.IKeyValueStore;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxIterator;
import com.box.androidsdk.content.models.BoxIteratorItems;
import com.box.androidsdk.content.models.BoxJsonObject;
import com.box.androidsdk.content.models.BoxOrder;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public final class BoxLevelDbIteratorItems extends BoxIteratorItems implements Serializable {
    private transient IKeyValueStore mKVStore;
    private List<String> mKeys;
    private final IUserContextManager mUserContextManager;

    public BoxLevelDbIteratorItems(IUserContextManager iUserContextManager, JsonObject jsonObject, List<String> list) {
        super(jsonObject);
        this.mUserContextManager = iUserContextManager;
        this.mKeys = list;
        this.mKVStore = iUserContextManager.getCurrentContext().getKVStore();
    }

    @Override // com.box.androidsdk.content.models.BoxIterator
    public int size() {
        return this.mKeys.size();
    }

    @Override // com.box.androidsdk.content.models.BoxIterator
    public ArrayList<BoxItem> getEntries() {
        ArrayList<BoxItem> arrayList = new ArrayList<>(this.mKeys.size());
        for (String str : this.mKeys) {
            if (((BoxItem) this.mKVStore.getBoxJsonObject(str)) != null) {
                arrayList.add((BoxItem) this.mKVStore.getBoxJsonObject(str));
            }
        }
        return arrayList;
    }

    @Override // com.box.androidsdk.content.models.BoxIterator
    public BoxItem get(int i) {
        return getAs((BoxJsonObject.BoxJsonObjectCreator) null, i);
    }

    @Override // com.box.androidsdk.content.models.BoxIteratorBoxEntity, com.box.androidsdk.content.models.BoxIterator
    protected BoxJsonObject.BoxJsonObjectCreator<BoxItem> getObjectCreator() {
        return new BoxJsonObject.BoxJsonObjectCreator<BoxItem>() { // from class: com.box.android.coreservices.models.BoxLevelDbIteratorItems.1
            @Override // com.box.androidsdk.content.models.BoxJsonObject.BoxJsonObjectCreator
            public BoxItem createFromJsonObject(JsonObject jsonObject) {
                return null;
            }
        };
    }

    @Override // com.box.androidsdk.content.models.BoxIterator
    public BoxItem getAs(BoxJsonObject.BoxJsonObjectCreator boxJsonObjectCreator, int i) {
        return (BoxItem) this.mKVStore.getBoxJsonObject(this.mKeys.get(i));
    }

    @Override // com.box.androidsdk.content.models.BoxIterator
    public ArrayList<BoxOrder> getSortOrders() {
        return getPropertyAsJsonObjectArray(BoxJsonObject.getBoxJsonObjectCreator(BoxOrder.class), BoxIterator.FIELD_ORDER);
    }

    @Override // com.box.androidsdk.content.models.BoxIterator, java.lang.Iterable
    public Iterator<BoxItem> iterator() {
        return getEntries().iterator();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.mKeys);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.mKeys = (List) objectInputStream.readObject();
        this.mKVStore = this.mUserContextManager.getCurrentContext().getKVStore();
    }

    @Override // com.box.androidsdk.content.models.BoxJsonObject
    public String toJson() {
        JsonObject from = JsonObject.readFrom(super.toJson());
        JsonArray jsonArray = new JsonArray();
        Iterator<BoxItem> it = getEntries().iterator();
        while (it.hasNext()) {
            jsonArray.add(it.next().toJsonObject());
        }
        from.set("entries", jsonArray);
        return from.toString();
    }
}
