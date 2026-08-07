package com.pspdfkit.internal.jni;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeSignatureBiometricProperties {
    final NativeSignatureInputMethod mInputMethod;
    final ArrayList<Float> mPressureList;
    final ArrayList<Float> mTimePointsList;
    final Float mTouchRadius;

    public NativeSignatureBiometricProperties(ArrayList<Float> arrayList, ArrayList<Float> arrayList2, Float f, NativeSignatureInputMethod nativeSignatureInputMethod) {
        this.mPressureList = arrayList;
        this.mTimePointsList = arrayList2;
        this.mTouchRadius = f;
        this.mInputMethod = nativeSignatureInputMethod;
    }

    public NativeSignatureInputMethod getInputMethod() {
        return this.mInputMethod;
    }

    public ArrayList<Float> getPressureList() {
        return this.mPressureList;
    }

    public ArrayList<Float> getTimePointsList() {
        return this.mTimePointsList;
    }

    public Float getTouchRadius() {
        return this.mTouchRadius;
    }

    public String toString() {
        return "NativeSignatureBiometricProperties{mPressureList=" + this.mPressureList + ",mTimePointsList=" + this.mTimePointsList + ",mTouchRadius=" + this.mTouchRadius + ",mInputMethod=" + this.mInputMethod + "}";
    }
}
