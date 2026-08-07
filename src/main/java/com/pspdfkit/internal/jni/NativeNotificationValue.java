package com.pspdfkit.internal.jni;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeNotificationValue {
    final Boolean mBooleanValue;
    final Long mIntegerValue;
    final String mStringValue;

    public NativeNotificationValue(String str, Long l, Boolean bool) {
        this.mStringValue = str;
        this.mIntegerValue = l;
        this.mBooleanValue = bool;
    }

    public Boolean getBooleanValue() {
        return this.mBooleanValue;
    }

    public Long getIntegerValue() {
        return this.mIntegerValue;
    }

    public String getStringValue() {
        return this.mStringValue;
    }

    public String toString() {
        return "NativeNotificationValue{mStringValue=" + this.mStringValue + ",mIntegerValue=" + this.mIntegerValue + ",mBooleanValue=" + this.mBooleanValue + "}";
    }
}
