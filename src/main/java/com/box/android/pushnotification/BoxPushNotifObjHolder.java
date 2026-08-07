package com.box.android.pushnotification;

import com.box.android.coreservices.models.BoxPersistableObject;
import com.box.boxandroidlibv2private.model.BoxPushNotification;
import com.eclipsesource.json.JsonObject;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes12.dex */
public class BoxPushNotifObjHolder extends BoxPersistableObject {
    public static final String TYPE = "com.box.android.pushnotification.BoxPushNotifObjHolder";

    public void put(String str, BoxPushNotification boxPushNotification) {
        this.mProperties.put(str, boxPushNotification);
    }

    public void remove(String str) {
        this.mProperties.remove(str);
    }

    public BoxPushNotification getValue(String str) {
        return (BoxPushNotification) super.getPropertyValue(str);
    }

    public Set<Map.Entry<String, BoxPushNotification>> entrySet() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<Map.Entry<String, Object>> it = this.mProperties.entrySet().iterator();
        while (it.hasNext()) {
            linkedHashSet.add(new PushNotifEntry(it.next()));
        }
        return linkedHashSet;
    }

    @Override // com.box.android.coreservices.models.BoxPersistableObject
    protected void parseJSONMember(JsonObject.Member member) {
        BoxPushNotification boxPushNotification = new BoxPushNotification();
        boxPushNotification.createFromJson(member.getValue().asObject());
        this.mProperties.put(member.getName(), boxPushNotification);
    }

    public static class PushNotifEntry implements Map.Entry<String, BoxPushNotification> {
        private final String mKey;
        private BoxPushNotification mValue;

        public PushNotifEntry(Map.Entry<String, Object> entry) {
            this.mKey = entry.getKey();
            this.mValue = (BoxPushNotification) entry.getValue();
        }

        @Override // java.util.Map.Entry
        public String getKey() {
            return this.mKey;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Map.Entry
        public BoxPushNotification getValue() {
            return this.mValue;
        }

        @Override // java.util.Map.Entry
        public BoxPushNotification setValue(BoxPushNotification boxPushNotification) {
            BoxPushNotification boxPushNotification2 = this.mValue;
            this.mValue = boxPushNotification;
            return boxPushNotification2;
        }
    }
}
