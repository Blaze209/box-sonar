package com.box.boxandroidlibv2private.model;

import com.box.androidsdk.content.models.BoxIteratorBoxEntity;
import com.box.androidsdk.content.models.BoxJsonObject;
import com.eclipsesource.json.JsonArray;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes13.dex */
public class BoxIteratorBoxPushNotification extends BoxIteratorBoxEntity<BoxPushNotification> {
    private static final long serialVersionUID = -1642742056723481128L;
    private final ArrayList<BoxPushNotification> mPushNotifs;

    @Override // com.box.androidsdk.content.models.BoxIteratorBoxEntity, com.box.androidsdk.content.models.BoxIterator
    protected BoxJsonObject.BoxJsonObjectCreator<BoxPushNotification> getObjectCreator() {
        return null;
    }

    public BoxIteratorBoxPushNotification(ArrayList<BoxPushNotification> arrayList) {
        this.mPushNotifs = arrayList;
        JsonArray jsonArray = new JsonArray();
        Iterator<BoxPushNotification> it = arrayList.iterator();
        while (it.hasNext()) {
            jsonArray.add(it.next().toJsonObject());
        }
        set("entries", jsonArray);
    }

    @Override // com.box.androidsdk.content.models.BoxIterator, java.lang.Iterable
    public Iterator<BoxPushNotification> iterator() {
        return this.mPushNotifs.iterator();
    }

    @Override // com.box.androidsdk.content.models.BoxIterator
    public ArrayList<BoxPushNotification> getEntries() {
        return this.mPushNotifs;
    }
}
