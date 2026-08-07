package com.pspdfkit.internal.jni;

import com.pspdfkit.internal.nv;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeTimestampAuthorityInfo {
    final String mPassword;
    final String mUrl;
    final String mUser;

    public NativeTimestampAuthorityInfo(String str, String str2, String str3) {
        this.mUrl = str;
        this.mUser = str2;
        this.mPassword = str3;
    }

    public String getPassword() {
        return this.mPassword;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public String getUser() {
        return this.mUser;
    }

    public String toString() {
        return nv.a(new StringBuilder("NativeTimestampAuthorityInfo{mUrl=").append(this.mUrl).append(",mUser=").append(this.mUser).append(",mPassword="), this.mPassword, "}");
    }
}
