package com.amplitude.api;

import android.app.Activity;
import android.content.Context;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class Utils {
    private static final String TAG = "com.amplitude.api.Utils";
    private static AmplitudeLog logger = AmplitudeLog.getLogger();

    static JSONObject cloneJSONObject(JSONObject jSONObject) {
        JSONArray jSONArrayNames;
        if (jSONObject == null) {
            return null;
        }
        if (jSONObject.length() == 0) {
            return new JSONObject();
        }
        try {
            jSONArrayNames = jSONObject.names();
        } catch (ArrayIndexOutOfBoundsException e) {
            logger.e(TAG, e.toString());
            jSONArrayNames = null;
        }
        int length = jSONArrayNames != null ? jSONArrayNames.length() : 0;
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            strArr[i] = jSONArrayNames.optString(i);
        }
        try {
            return new JSONObject(jSONObject, strArr);
        } catch (JSONException e2) {
            logger.e(TAG, e2.toString());
            return null;
        }
    }

    static boolean compareJSONObjects(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == jSONObject2) {
            return true;
        }
        if ((jSONObject != null && jSONObject2 == null) || (jSONObject == null && jSONObject2 != null)) {
            return false;
        }
        try {
            if (jSONObject.length() != jSONObject2.length()) {
                return false;
            }
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (!jSONObject2.has(next)) {
                    return false;
                }
                Object obj = jSONObject.get(next);
                Object obj2 = jSONObject2.get(next);
                if (!obj.getClass().equals(obj2.getClass())) {
                    return false;
                }
                if (obj.getClass() == JSONObject.class) {
                    if (!compareJSONObjects((JSONObject) obj, (JSONObject) obj2)) {
                        return false;
                    }
                } else if (!obj.equals(obj2)) {
                    return false;
                }
            }
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }

    public static boolean isEmptyString(String str) {
        return str == null || str.length() == 0;
    }

    static String normalizeInstanceName(String str) {
        if (isEmptyString(str)) {
            str = Constants.DEFAULT_INSTANCE;
        }
        return str.toLowerCase();
    }

    static boolean checkLocationPermissionAllowed(Context context) {
        return checkPermissionAllowed(context, "android.permission.ACCESS_COARSE_LOCATION") || checkPermissionAllowed(context, "android.permission.ACCESS_FINE_LOCATION");
    }

    static boolean checkPermissionAllowed(Context context, String str) {
        try {
            return Integer.parseInt(Activity.class.getMethod("checkSelfPermission", String.class).invoke(context, str).toString()) == 0;
        } catch (Exception unused) {
        }
    }
}
