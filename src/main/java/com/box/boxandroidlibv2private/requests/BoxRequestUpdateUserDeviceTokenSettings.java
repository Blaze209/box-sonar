package com.box.boxandroidlibv2private.requests;

import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.requests.BoxCacheableRequest;
import com.box.androidsdk.content.requests.BoxRequest;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.boxandroidlibv2private.dao.BoxUserDeviceTokenSettings;

/* JADX INFO: loaded from: classes13.dex */
public class BoxRequestUpdateUserDeviceTokenSettings extends BoxRequest<BoxUserDeviceTokenSettings, BoxRequestUpdateUserDeviceTokenSettings> implements BoxCacheableRequest<BoxUserDeviceTokenSettings> {
    protected static final String FIELD_NOTIFICATION_FLAG = "is_notification_enabled";
    public static final String URI = "user_device_token_settings/%s";

    public BoxRequestUpdateUserDeviceTokenSettings(String str, boolean z, BoxSession boxSession) {
        super(BoxUserDeviceTokenSettings.class, str, boxSession);
        this.mBodyMap.put("is_notification_enabled", Boolean.valueOf(z));
        this.mRequestMethod = BoxRequest.Methods.PUT;
    }

    public static String getUri(String str) {
        return String.format(URI, str);
    }

    public String getUserDeviceTokenId() {
        String[] strArrSplit = this.mRequestUrlString.split("/");
        return strArrSplit[strArrSplit.length - 1];
    }

    public Boolean getNotificationEnabled() {
        return (Boolean) this.mBodyMap.get("is_notification_enabled");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.box.androidsdk.content.requests.BoxRequest
    public BoxUserDeviceTokenSettings onSend() throws BoxException {
        return (BoxUserDeviceTokenSettings) super.onSend();
    }

    @Override // com.box.androidsdk.content.requests.BoxRequest
    protected void onSendCompleted(BoxResponse<BoxUserDeviceTokenSettings> boxResponse) throws BoxException {
        super.handleUpdateCache(boxResponse);
    }

    @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
    public BoxUserDeviceTokenSettings sendForCachedResult() throws BoxException {
        return (BoxUserDeviceTokenSettings) super.handleSendForCachedResult();
    }

    @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
    public BoxFutureTask toTaskForCachedResult() throws BoxException {
        return super.handleToTaskForCachedResult();
    }
}
