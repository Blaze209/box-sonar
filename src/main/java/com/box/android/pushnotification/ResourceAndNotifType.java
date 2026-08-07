package com.box.android.pushnotification;

import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.boxandroidlibv2private.model.BoxPushNotification;

/* JADX INFO: loaded from: classes12.dex */
public class ResourceAndNotifType {
    private static final String DELIMITOR = "-";
    private BoxPushNotification.PushNotifType notifType;
    private String resourceId;
    private String resourceType;

    public ResourceAndNotifType(String str, String str2, BoxPushNotification.PushNotifType pushNotifType) {
        this.resourceId = str;
        this.resourceType = str2;
        this.notifType = pushNotifType;
    }

    public String getResourceId() {
        return this.resourceId;
    }

    public String getResourceType() {
        return this.resourceType;
    }

    public BoxPushNotification.PushNotifType getNotifType() {
        return this.notifType;
    }

    public String toStringIdentifier() {
        return this.resourceId + "-" + this.resourceType.toString() + "-" + this.notifType.name();
    }

    public int toIntIdentifier() {
        long j;
        int iOrdinal = this.notifType.ordinal();
        if (iOrdinal > 16) {
            iOrdinal %= 16;
        }
        try {
            j = Long.parseLong(this.resourceId);
        } catch (NumberFormatException unused) {
            BoxLogUtils.w("Resource id is not numeric:" + this.resourceId + ", resource type: " + this.resourceType.toString());
            j = 0;
        }
        return Long.valueOf(((long) (iOrdinal << 26)) | (j & ((long) 67108863))).intValue();
    }

    public static ResourceAndNotifType fromStringIdentifier(String str) {
        String[] strArrSplit = str.split("-");
        return new ResourceAndNotifType(strArrSplit[0], strArrSplit[1], (BoxPushNotification.PushNotifType) Enum.valueOf(BoxPushNotification.PushNotifType.class, strArrSplit[2]));
    }
}
