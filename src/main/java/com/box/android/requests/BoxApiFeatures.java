package com.box.android.requests;

import com.box.androidsdk.content.BoxApi;
import com.box.androidsdk.content.models.BoxSession;

/* JADX INFO: loaded from: classes12.dex */
public class BoxApiFeatures extends BoxApi {
    public BoxApiFeatures(BoxSession boxSession) {
        super(boxSession);
    }

    public BoxRequestFeatures getSupportedFeatures() {
        return new BoxRequestFeatures(this.mSession);
    }
}
