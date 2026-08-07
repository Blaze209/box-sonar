package com.pspdfkit.internal.jni;

import com.pspdfkit.internal.nv;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeJSAlert {
    final String mMessage;
    final String mTitle;

    public NativeJSAlert(String str, String str2) {
        this.mTitle = str;
        this.mMessage = str2;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String toString() {
        return nv.a(new StringBuilder("NativeJSAlert{mTitle=").append(this.mTitle).append(",mMessage="), this.mMessage, "}");
    }
}
