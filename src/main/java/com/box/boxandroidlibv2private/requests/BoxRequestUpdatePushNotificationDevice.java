package com.box.boxandroidlibv2private.requests;

import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.requests.BoxRequest;
import com.box.boxandroidlibv2private.dao.BoxConvertedPushNotificationDevice;

/* JADX INFO: loaded from: classes13.dex */
public class BoxRequestUpdatePushNotificationDevice extends BoxRequest<BoxConvertedPushNotificationDevice, BoxRequestUpdatePushNotificationDevice> {
    public static final String URI = "internal_push_notification_devices/%s";

    public BoxRequestUpdatePushNotificationDevice(String str, BoxSession boxSession) {
        super(BoxConvertedPushNotificationDevice.class, str, boxSession);
        this.mRequestMethod = BoxRequest.Methods.PUT;
    }

    public BoxRequestUpdatePushNotificationDevice setPlatform(String str) {
        this.mBodyMap.put("platform", str);
        return this;
    }

    public BoxRequestUpdatePushNotificationDevice setDeviceToken(String str) {
        this.mBodyMap.put(BoxConvertedPushNotificationDevice.DEVICE_TOKEN, str);
        return this;
    }

    public BoxRequestUpdatePushNotificationDevice setLanguage(String str) {
        this.mBodyMap.put("language", str);
        return this;
    }

    public static String getUri(String str) {
        return String.format(URI, str);
    }
}
