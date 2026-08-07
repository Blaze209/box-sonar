package com.box.androidsdk.content.requests;

import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.models.BoxUser;
import com.box.androidsdk.content.requests.BoxRequest;

/* JADX INFO: loaded from: classes13.dex */
abstract class BoxRequestUserUpdate<E extends BoxUser, R extends BoxRequest<E, R>> extends BoxRequestItem<E, R> {
    protected BoxRequestUserUpdate(Class<E> cls, String str, String str2, BoxSession boxSession) {
        super(cls, str, str2, boxSession);
    }

    public String getName() {
        return (String) this.mBodyMap.get("name");
    }

    public R setName(String str) {
        this.mBodyMap.put("name", str);
        return this;
    }

    public double getSpaceAmount() {
        return ((Double) this.mBodyMap.get(BoxUser.FIELD_SPACE_AMOUNT)).doubleValue();
    }

    public R setSpaceAmount(double d) {
        this.mBodyMap.put(BoxUser.FIELD_SPACE_AMOUNT, Double.valueOf(d));
        return this;
    }
}
