package com.box.boxandroidlibv2private.requests;

import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.requests.BoxRequest;
import com.box.boxandroidlibv2private.dao.BoxConvertedPushNotificationDevice;

/* JADX INFO: loaded from: classes13.dex */
public class BoxRequestAddPushNotificationDevice extends BoxRequest<BoxConvertedPushNotificationDevice, BoxRequestAddPushNotificationDevice> {
    public static final String URI = "internal_push_notification_devices";

    public BoxRequestAddPushNotificationDevice(String str, String str2, String str3, String str4, BoxSession boxSession) {
        super(BoxConvertedPushNotificationDevice.class, str, boxSession);
        this.mRequestMethod = BoxRequest.Methods.POST;
        this.mBodyMap.put("platform", str2);
        this.mBodyMap.put(BoxConvertedPushNotificationDevice.DEVICE_TOKEN, str3);
        this.mBodyMap.put("language", str4);
    }

    public static String getUri() {
        return URI;
    }

    public String getPlatform() {
        return (String) this.mBodyMap.get("platform");
    }

    public String getDeviceToken() {
        return (String) this.mBodyMap.get(BoxConvertedPushNotificationDevice.DEVICE_TOKEN);
    }

    public String getLanguage() {
        return (String) this.mBodyMap.get("language");
    }
}
