package com.pspdfkit.internal.jni;

import com.pspdfkit.internal.nv;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeJSMail {
    final String mBcc;
    final String mCc;
    final String mMessage;
    final String mSubject;
    final String mTo;
    final Boolean mUi;

    public NativeJSMail(Boolean bool, String str, String str2, String str3, String str4, String str5) {
        this.mUi = bool;
        this.mTo = str;
        this.mCc = str2;
        this.mBcc = str3;
        this.mSubject = str4;
        this.mMessage = str5;
    }

    public String getBcc() {
        return this.mBcc;
    }

    public String getCc() {
        return this.mCc;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public String getSubject() {
        return this.mSubject;
    }

    public String getTo() {
        return this.mTo;
    }

    public Boolean getUi() {
        return this.mUi;
    }

    public String toString() {
        return nv.a(new StringBuilder("NativeJSMail{mUi=").append(this.mUi).append(",mTo=").append(this.mTo).append(",mCc=").append(this.mCc).append(",mBcc=").append(this.mBcc).append(",mSubject=").append(this.mSubject).append(",mMessage="), this.mMessage, "}");
    }
}
