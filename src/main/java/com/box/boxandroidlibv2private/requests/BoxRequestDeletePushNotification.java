package com.box.boxandroidlibv2private.requests;

import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.requests.BoxCacheableRequest;
import com.box.androidsdk.content.requests.BoxRequest;
import com.box.boxandroidlibv2private.model.BoxPushNotification;

/* JADX INFO: loaded from: classes13.dex */
public class BoxRequestDeletePushNotification extends BoxRequest<BoxPushNotification, BoxRequestDeletePushNotification> implements BoxCacheableRequest<BoxPushNotification> {
    protected static final String FILTER_EVENT_TYPE = "filterEventType";
    private BoxPushNotification mPushNotification;

    public BoxRequestDeletePushNotification(BoxSession boxSession, BoxPushNotification boxPushNotification) {
        super(BoxPushNotification.class, null, boxSession);
        this.mPushNotification = boxPushNotification;
    }

    public BoxPushNotification getPushNotification() {
        return this.mPushNotification;
    }

    @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
    public BoxPushNotification sendForCachedResult() throws BoxException {
        return (BoxPushNotification) super.handleSendForCachedResult();
    }

    @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
    public BoxFutureTask toTaskForCachedResult() throws BoxException {
        return super.handleToTaskForCachedResult();
    }
}
