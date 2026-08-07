package org.jose4j.json;

import java.util.Map;
import org.jose4j.lang.JoseException;

/* JADX INFO: loaded from: classes5.dex */
public class JsonHeaderUtil {
    public static Map<String, Object> parseJson(String str) throws JoseException {
        return JsonUtil.parseJson(str);
    }

    public static String toJson(Map<String, ?> map) {
        return JsonUtil.toJson(map);
    }
}
