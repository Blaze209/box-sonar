package com.microsoft.identity.common.java.jwt;

import com.google.gson.Gson;
import com.microsoft.identity.common.java.AuthenticationConstants;
import com.microsoft.identity.common.java.base64.Base64Util;
import com.microsoft.identity.common.java.logging.Logger;

/* JADX INFO: loaded from: classes14.dex */
public final class JwtUtils {
    private static final String TAG = "JwtUtils";

    private JwtUtils() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static String generateJWT(JwtRequestHeader jwtRequestHeader, JwtRequestBody jwtRequestBody) {
        if (jwtRequestHeader == null) {
            throw new NullPointerException("header is marked non-null but is null");
        }
        if (jwtRequestBody == null) {
            throw new NullPointerException("body is marked non-null but is null");
        }
        Logger.verbose(TAG + ":generateJWT", "Generating JWT.");
        return Base64Util.encodeUrlSafeString(new Gson().toJson(jwtRequestHeader).getBytes(AuthenticationConstants.ENCODING_UTF8)) + "." + Base64Util.encodeUrlSafeString(new Gson().toJson(jwtRequestBody).getBytes(AuthenticationConstants.ENCODING_UTF8));
    }
}
