package com.nimbusds.jose.util;

import com.nimbusds.jose.shaded.gson.Gson;

/* JADX INFO: loaded from: classes3.dex */
public class JSONStringUtils {
    public static String toJSONString(String str) {
        return new Gson().toJson(str);
    }

    private JSONStringUtils() {
    }
}
