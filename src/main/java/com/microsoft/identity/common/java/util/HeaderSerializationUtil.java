package com.microsoft.identity.common.java.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public class HeaderSerializationUtil {
    public static String toJson(Map<String, List<String>> map) {
        if (map == null) {
            throw new NullPointerException("headersIn is marked non-null but is null");
        }
        return new Gson().toJson(map);
    }

    public static HashMap<String, List<String>> fromJson(String str) {
        if (str == null) {
            throw new NullPointerException("jsonIn is marked non-null but is null");
        }
        return (HashMap) new Gson().fromJson(str, TypeToken.getParameterized(HashMap.class, String.class, TypeToken.getParameterized(List.class, String.class).getRawType()).getType());
    }
}
