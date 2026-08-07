package com.pspdfkit.internal.jni;

import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeNotification {
    final HashMap<String, NativeNotificationValue> mInfo;
    final String mName;

    public NativeNotification(String str, HashMap<String, NativeNotificationValue> map) {
        this.mName = str;
        this.mInfo = map;
    }

    public HashMap<String, NativeNotificationValue> getInfo() {
        return this.mInfo;
    }

    public String getName() {
        return this.mName;
    }

    public String toString() {
        return "NativeNotification{mName=" + this.mName + ",mInfo=" + this.mInfo + "}";
    }
}
