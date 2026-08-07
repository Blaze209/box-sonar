package com.box.boxandroidlibv2private.requests;

import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.requests.BoxRequest;
import com.box.boxandroidlibv2private.model.BoxTask;

/* JADX INFO: loaded from: classes13.dex */
public class BoxRequestUpdateAndGetTask extends BoxRequestGetTask {
    private final BoxRequest mRequest;

    public BoxRequestUpdateAndGetTask(String str, String str2, BoxSession boxSession, BoxRequest boxRequest) {
        super(str, str2, boxSession);
        this.mRequest = boxRequest;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.box.androidsdk.content.requests.BoxRequest
    public BoxTask onSend() throws BoxException {
        this.mRequest.send();
        return (BoxTask) super.onSend();
    }

    public BoxRequest getRequest() {
        return this.mRequest;
    }
}
