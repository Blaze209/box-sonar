package com.box.boxandroidlibv2private.requests;

import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.utils.SdkUtils;
import com.box.boxandroidlibv2private.model.BoxIteratorTasks;
import com.box.boxandroidlibv2private.model.BoxTask;
import com.eclipsesource.json.JsonObject;
import java.util.Iterator;

/* JADX INFO: loaded from: classes13.dex */
public class BoxRequestGetAllInbox extends BoxRequestGetInbox {
    private static final int LIMIT = 20;
    public static final int MAX_LIMIT = 40;
    private static final long serialVersionUID = 14691952404L;
    private int mMaxLimit;

    public BoxRequestGetAllInbox(String str, BoxSession boxSession) {
        super(str, boxSession);
        this.mMaxLimit = 40;
        setLimit(20);
    }

    public BoxRequestGetAllInbox setMaxLimit(int i) {
        this.mMaxLimit = i;
        return this;
    }

    @Override // com.box.boxandroidlibv2private.requests.BoxRequestGetInbox, com.box.androidsdk.content.requests.BoxRequest
    public BoxIteratorTasks onSend() throws BoxException {
        int i = 0;
        String nextMarker = null;
        JsonObject jsonObject = null;
        do {
            i++;
            BoxRequestGetInbox boxRequestGetInboxCreateInnerRequest = createInnerRequest();
            if (nextMarker != null) {
                boxRequestGetInboxCreateInnerRequest.setMarker(nextMarker);
            }
            BoxIteratorTasks boxIteratorTasksSend = boxRequestGetInboxCreateInnerRequest.send();
            if (jsonObject != null) {
                Iterator<BoxTask> it = boxIteratorTasksSend.getEntries().iterator();
                while (it.hasNext()) {
                    jsonObject.get("entries").asArray().add(it.next().toJsonObject());
                }
            } else {
                jsonObject = boxIteratorTasksSend.toJsonObject();
            }
            nextMarker = !SdkUtils.isBlank(boxIteratorTasksSend.getNextMarker()) ? boxIteratorTasksSend.getNextMarker() : null;
            if (nextMarker == null) {
                break;
            }
        } while (getLimit().intValue() * i < this.mMaxLimit);
        return new BoxIteratorTasks(jsonObject);
    }

    protected BoxRequestGetInbox createInnerRequest() {
        return new BoxRequestGetInbox(this);
    }

    public int getMaxLimit() {
        return this.mMaxLimit;
    }

    public BoxRequestGetAllInbox setMaximumLimit(int i) {
        this.mMaxLimit = i;
        return this;
    }
}
