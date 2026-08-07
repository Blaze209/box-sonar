package com.pspdfkit.internal;

import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes3.dex */
public final class ll {
    public static String a(String str) {
        HttpUrl httpUrl = HttpUrl.parse(str);
        if (httpUrl == null) {
            throw new IllegalArgumentException("Server url is not a valid HTTP/HTTPS url: " + str);
        }
        String strEncodedPath = httpUrl.encodedPath();
        if (strEncodedPath.startsWith("/")) {
            strEncodedPath = strEncodedPath.substring(1);
        }
        return new HttpUrl.Builder().scheme(httpUrl.scheme()).host(httpUrl.host()).port(httpUrl.port()).addPathSegments(strEncodedPath).toString();
    }
}
