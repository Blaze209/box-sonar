package com.box.androidsdk.content.requests;

import com.box.androidsdk.content.models.BoxObject;

/* JADX INFO: loaded from: classes13.dex */
public class BoxResponsePartial<E extends BoxObject> extends BoxResponse<E> {
    public BoxResponsePartial(E e, Exception exc, BoxRequest boxRequest) {
        super(e, exc, boxRequest);
    }
}
