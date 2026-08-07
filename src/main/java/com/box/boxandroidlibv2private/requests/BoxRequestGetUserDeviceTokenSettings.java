package com.box.boxandroidlibv2private.requests;

import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.requests.BoxCacheableRequest;
import com.box.androidsdk.content.requests.BoxRequest;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.boxandroidlibv2private.dao.BoxUserDeviceTokenSettings;

/* JADX INFO: loaded from: classes13.dex */
public class BoxRequestGetUserDeviceTokenSettings extends BoxRequest<BoxUserDeviceTokenSettings, BoxRequestGetUserDeviceTokenSettings> implements BoxCacheableRequest<BoxUserDeviceTokenSettings> {
    protected static final String FIELD_DEVICE_TOKEN = "device_token";
    public static final String URI = "user_device_token_settings";

    public BoxRequestGetUserDeviceTokenSettings(String str, String str2, BoxSession boxSession) {
        super(BoxUserDeviceTokenSettings.class, str, boxSession);
        this.mQueryMap.put("device_token", str2);
        this.mRequestMethod = BoxRequest.Methods.GET;
    }

    protected BoxRequestGetUserDeviceTokenSettings(BoxRequestGetInbox boxRequestGetInbox) {
        super(boxRequestGetInbox);
    }

    public static String getUri() {
        return URI;
    }

    public String getFieldDeviceToken() {
        return this.mQueryMap.get("device_token");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.box.androidsdk.content.requests.BoxRequest
    public BoxUserDeviceTokenSettings onSend() throws BoxException {
        return (BoxUserDeviceTokenSettings) super.onSend();
    }

    @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
    public BoxUserDeviceTokenSettings sendForCachedResult() throws BoxException {
        return (BoxUserDeviceTokenSettings) super.handleSendForCachedResult();
    }

    @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
    public BoxFutureTask toTaskForCachedResult() throws BoxException {
        return super.handleToTaskForCachedResult();
    }

    @Override // com.box.androidsdk.content.requests.BoxRequest
    protected void onSendCompleted(BoxResponse<BoxUserDeviceTokenSettings> boxResponse) throws BoxException {
        super.onSendCompleted(boxResponse);
        super.handleUpdateCache(boxResponse);
    }
}
