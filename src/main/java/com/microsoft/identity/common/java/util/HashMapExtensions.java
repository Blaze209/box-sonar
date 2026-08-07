package com.microsoft.identity.common.java.util;

import com.microsoft.identity.common.java.net.HttpResponse;
import com.microsoft.identity.common.java.opentelemetry.AttributeName;
import com.microsoft.identity.common.java.opentelemetry.SpanExtension;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public class HashMapExtensions {
    public static HashMap<String, String> getJsonResponse(HttpResponse httpResponse) throws JSONException {
        if (httpResponse != null && !StringUtil.isNullOrEmpty(httpResponse.getBody())) {
            return getJsonResponseFromResponseBody(httpResponse.getBody());
        }
        return new HashMap<>();
    }

    public static HashMap<String, String> getJsonResponseFromResponseBody(String str) throws JSONException {
        HashMap<String, String> map = new HashMap<>();
        SpanExtension.current().setAttribute(AttributeName.response_body_length.name(), str.length());
        if (!StringUtil.isNullOrEmpty(str)) {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObject.get(next).toString());
            }
        }
        return map;
    }
}
