package com.box.boxandroidlibv2private.requests;

import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.requests.BoxCacheableRequest;
import com.box.androidsdk.content.requests.BoxRequest;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.boxandroidlibv2private.model.BoxUserNotificationCategories;

/* JADX INFO: loaded from: classes13.dex */
public class BoxRequestGetNotificationCategories extends BoxRequest<BoxUserNotificationCategories, BoxRequestGetNotificationCategories> implements BoxCacheableRequest<BoxUserNotificationCategories> {
    public static final String URI = "settings/users/notification_categories";

    public BoxRequestGetNotificationCategories(String str, BoxSession boxSession) {
        super(BoxUserNotificationCategories.class, str, boxSession);
        this.mRequestMethod = BoxRequest.Methods.GET;
    }

    public static String getUri() {
        return "settings/users/notification_categories";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.box.androidsdk.content.requests.BoxRequest
    public BoxUserNotificationCategories onSend() throws BoxException {
        return (BoxUserNotificationCategories) super.onSend();
    }

    @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
    public BoxUserNotificationCategories sendForCachedResult() throws BoxException {
        return (BoxUserNotificationCategories) super.handleSendForCachedResult();
    }

    @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
    public BoxFutureTask toTaskForCachedResult() throws BoxException {
        return super.handleToTaskForCachedResult();
    }

    @Override // com.box.androidsdk.content.requests.BoxRequest
    protected void onSendCompleted(BoxResponse<BoxUserNotificationCategories> boxResponse) throws BoxException {
        super.onSendCompleted(boxResponse);
        super.handleUpdateCache(boxResponse);
    }
}
