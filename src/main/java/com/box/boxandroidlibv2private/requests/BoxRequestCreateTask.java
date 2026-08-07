package com.box.boxandroidlibv2private.requests;

import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.requests.BoxCacheableRequest;
import com.box.androidsdk.content.requests.BoxRequest;
import com.box.boxandroidlibv2private.model.BoxTask;

/* JADX INFO: loaded from: classes13.dex */
public class BoxRequestCreateTask extends BoxRequest<BoxTask, BoxRequestCreateTask> implements BoxCacheableRequest<BoxTask> {
    protected static final String FIELD_DESCRIPTION = "description";
    public static final String URI = "undoc/tasks";

    public BoxRequestCreateTask(String str, String str2, BoxSession boxSession) {
        super(BoxTask.class, str, boxSession);
        this.mRequestMethod = BoxRequest.Methods.POST;
        setDescription(str2);
    }

    public static String getUri() {
        return URI;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.box.androidsdk.content.requests.BoxRequest
    public BoxTask onSend() throws BoxException {
        return (BoxTask) super.onSend();
    }

    private BoxRequestCreateTask setDescription(String str) {
        this.mBodyMap.put("description", str);
        return this;
    }

    public String getDescription() {
        return (String) this.mBodyMap.get("description");
    }

    @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
    public BoxTask sendForCachedResult() throws BoxException {
        return (BoxTask) super.handleSendForCachedResult();
    }

    @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
    public BoxFutureTask<BoxTask> toTaskForCachedResult() throws BoxException {
        return super.handleToTaskForCachedResult();
    }
}
