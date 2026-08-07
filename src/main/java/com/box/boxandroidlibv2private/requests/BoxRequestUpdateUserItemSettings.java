package com.box.boxandroidlibv2private.requests;

import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.requests.BoxCacheableRequest;
import com.box.androidsdk.content.requests.BoxRequest;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.boxandroidlibv2private.dao.BoxUserItemSettings;

/* JADX INFO: loaded from: classes13.dex */
public class BoxRequestUpdateUserItemSettings extends BoxRequest<BoxUserItemSettings, BoxRequestUpdateUserItemSettings> implements BoxCacheableRequest<BoxUserItemSettings> {
    protected static final String FIELD_NOTIFICATION_FLAG = "is_notification_enabled";
    public static final String URI = "user_item_settings/%s";

    public BoxRequestUpdateUserItemSettings(String str, boolean z, BoxSession boxSession) {
        super(BoxUserItemSettings.class, str, boxSession);
        this.mBodyMap.put("is_notification_enabled", Boolean.valueOf(z));
        this.mRequestMethod = BoxRequest.Methods.PUT;
    }

    public static String getUri(String str) {
        return String.format(URI, str);
    }

    public Boolean getNotificationEnabled() {
        return (Boolean) this.mBodyMap.get("is_notification_enabled");
    }

    public String getUserItemId() {
        String[] strArrSplit = this.mRequestUrlString.split("/");
        return strArrSplit[strArrSplit.length - 1];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.box.androidsdk.content.requests.BoxRequest
    public BoxUserItemSettings onSend() throws BoxException {
        return (BoxUserItemSettings) super.onSend();
    }

    @Override // com.box.androidsdk.content.requests.BoxRequest
    protected void onSendCompleted(BoxResponse<BoxUserItemSettings> boxResponse) throws BoxException {
        super.handleUpdateCache(boxResponse);
    }

    @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
    public BoxUserItemSettings sendForCachedResult() throws BoxException {
        return (BoxUserItemSettings) super.handleSendForCachedResult();
    }

    @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
    public BoxFutureTask toTaskForCachedResult() throws BoxException {
        return super.handleToTaskForCachedResult();
    }
}
