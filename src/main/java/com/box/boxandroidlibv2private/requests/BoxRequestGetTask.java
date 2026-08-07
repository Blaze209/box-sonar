package com.box.boxandroidlibv2private.requests;

import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.requests.BoxCacheableRequest;
import com.box.androidsdk.content.requests.BoxRequest;
import com.box.androidsdk.content.requests.BoxRequestItem;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.boxandroidlibv2private.model.BoxTask;

/* JADX INFO: loaded from: classes13.dex */
public class BoxRequestGetTask extends BoxRequestItem<BoxTask, BoxRequestGetTask> implements BoxCacheableRequest<BoxTask> {
    public static final String URI = "undoc/tasks/%s";

    public BoxRequestGetTask(String str, String str2, BoxSession boxSession) {
        super(BoxTask.class, str2, str, boxSession);
        this.mRequestMethod = BoxRequest.Methods.GET;
    }

    public static String getUri(String str) {
        return String.format("undoc/tasks/%s", str);
    }

    @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
    public BoxTask sendForCachedResult() throws BoxException {
        return (BoxTask) super.handleSendForCachedResult();
    }

    @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
    public BoxFutureTask<BoxTask> toTaskForCachedResult() throws BoxException {
        return super.handleToTaskForCachedResult();
    }

    @Override // com.box.androidsdk.content.requests.BoxRequestItem, com.box.androidsdk.content.requests.BoxRequest
    protected void onSendCompleted(BoxResponse<BoxTask> boxResponse) throws BoxException {
        super.onSendCompleted(boxResponse);
        super.handleUpdateCache(boxResponse);
    }
}
