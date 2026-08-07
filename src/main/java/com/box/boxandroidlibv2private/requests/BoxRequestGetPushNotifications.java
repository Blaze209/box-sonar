package com.box.boxandroidlibv2private.requests;

import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.requests.BoxCacheableRequest;
import com.box.androidsdk.content.requests.BoxRequestList;
import com.box.boxandroidlibv2private.model.BoxIteratorBoxPushNotification;

/* JADX INFO: loaded from: classes13.dex */
public class BoxRequestGetPushNotifications extends BoxRequestList<BoxIteratorBoxPushNotification, BoxRequestGetPushNotifications> implements BoxCacheableRequest<BoxIteratorBoxPushNotification> {
    public static final String EVENT_TYPE_UPLOADS_AND_ITEM_MODIFIED = "uploads_and_item_modified";
    protected static final String FILTER_EVENT_TYPE = "filterEventType";
    protected static final String NOTIFICATION_ID = "notificationId";
    private boolean mShowNonProcessed;

    public BoxRequestGetPushNotifications(BoxSession boxSession) {
        super(BoxIteratorBoxPushNotification.class, null, null, boxSession);
        this.mShowNonProcessed = false;
    }

    public BoxRequestGetPushNotifications setFilterEventType(String str) {
        this.mQueryMap.put(FILTER_EVENT_TYPE, str);
        return this;
    }

    public BoxRequestGetPushNotifications setNotificationId(String str) {
        this.mQueryMap.put(NOTIFICATION_ID, str);
        return this;
    }

    public String getNotificationId() {
        return this.mQueryMap.get(NOTIFICATION_ID);
    }

    public String getFilterEventType() {
        return this.mQueryMap.get(FILTER_EVENT_TYPE);
    }

    public BoxRequestGetPushNotifications setShowNonProcessed(boolean z) {
        this.mShowNonProcessed = z;
        return this;
    }

    public boolean getShowNonProcessed() {
        return this.mShowNonProcessed;
    }

    @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
    public BoxIteratorBoxPushNotification sendForCachedResult() throws BoxException {
        return (BoxIteratorBoxPushNotification) super.handleSendForCachedResult();
    }

    @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
    public BoxFutureTask toTaskForCachedResult() throws BoxException {
        return super.handleToTaskForCachedResult();
    }
}
