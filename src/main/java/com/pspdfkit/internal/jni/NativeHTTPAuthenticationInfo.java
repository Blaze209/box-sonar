package com.pspdfkit.internal.jni;

import com.pspdfkit.internal.nv;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeHTTPAuthenticationInfo {
    final String mPassword;
    final String mUser;

    public NativeHTTPAuthenticationInfo(String str, String str2) {
        this.mUser = str;
        this.mPassword = str2;
    }

    public String getPassword() {
        return this.mPassword;
    }

    public String getUser() {
        return this.mUser;
    }

    public String toString() {
        return nv.a(new StringBuilder("NativeHTTPAuthenticationInfo{mUser=").append(this.mUser).append(",mPassword="), this.mPassword, "}");
    }
}
