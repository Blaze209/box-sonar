package com.pspdfkit.internal.jni;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeJSValue {
    final Boolean mBoolValue;
    final Double mNumberValue;
    final String mStringValue;
    final NativeJSType mType;
    final ArrayList<NativeJSValue> mVectorValue;

    public NativeJSValue(NativeJSType nativeJSType, String str, Boolean bool, Double d, ArrayList<NativeJSValue> arrayList) {
        this.mType = nativeJSType;
        this.mStringValue = str;
        this.mBoolValue = bool;
        this.mNumberValue = d;
        this.mVectorValue = arrayList;
    }

    public Boolean getBoolValue() {
        return this.mBoolValue;
    }

    public Double getNumberValue() {
        return this.mNumberValue;
    }

    public String getStringValue() {
        return this.mStringValue;
    }

    public NativeJSType getType() {
        return this.mType;
    }

    public ArrayList<NativeJSValue> getVectorValue() {
        return this.mVectorValue;
    }

    public String toString() {
        return "NativeJSValue{mType=" + this.mType + ",mStringValue=" + this.mStringValue + ",mBoolValue=" + this.mBoolValue + ",mNumberValue=" + this.mNumberValue + ",mVectorValue=" + this.mVectorValue + "}";
    }
}
