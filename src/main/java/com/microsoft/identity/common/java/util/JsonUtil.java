package com.microsoft.identity.common.java.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public class JsonUtil {
    public static Map<String, String> extractJsonObjectIntoMap(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        Iterator<String> itKeys = jSONObject.keys();
        HashMap map = new HashMap();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object obj = jSONObject.get(next);
            if (obj == null) {
                map.put(next, null);
            } else {
                map.put(next, obj.toString());
            }
        }
        return map;
    }
}
