package com.pspdfkit.internal.jni;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeJSScriptDescriptor {
    final String mContents;
    final NativeJSEnvironment mEvaluationEnvironment;
    final String mFilePath;
    final String mUuid;

    public NativeJSScriptDescriptor(String str, String str2, String str3, NativeJSEnvironment nativeJSEnvironment) {
        this.mUuid = str;
        this.mContents = str2;
        this.mFilePath = str3;
        this.mEvaluationEnvironment = nativeJSEnvironment;
    }

    public String getContents() {
        return this.mContents;
    }

    public NativeJSEnvironment getEvaluationEnvironment() {
        return this.mEvaluationEnvironment;
    }

    public String getFilePath() {
        return this.mFilePath;
    }

    public String getUuid() {
        return this.mUuid;
    }

    public String toString() {
        return "NativeJSScriptDescriptor{mUuid=" + this.mUuid + ",mContents=" + this.mContents + ",mFilePath=" + this.mFilePath + ",mEvaluationEnvironment=" + this.mEvaluationEnvironment + "}";
    }
}
