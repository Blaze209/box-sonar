package com.google.androidbrowserhelper.trusted;

import android.content.Intent;
import android.net.Uri;
import androidx.browser.trusted.sharing.ShareData;
import androidx.browser.trusted.sharing.ShareTarget;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.microsoft.identity.common.internal.broker.SerializedNames;
import com.pspdfkit.analytics.Analytics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class SharingUtils {
    private SharingUtils() {
    }

    public static boolean isShareIntent(Intent intent) {
        String action = intent.getAction();
        return "android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action);
    }

    public static ShareData retrieveShareDataFromIntent(Intent intent) {
        List parcelableArrayListExtra = null;
        if (!isShareIntent(intent)) {
            return null;
        }
        if ("android.intent.action.SEND".equals(intent.getAction())) {
            Uri uri = (Uri) intent.getParcelableExtra("android.intent.extra.STREAM");
            if (uri != null) {
                parcelableArrayListExtra = Collections.singletonList(uri);
            }
        } else {
            parcelableArrayListExtra = intent.getParcelableArrayListExtra("android.intent.extra.STREAM");
        }
        return new ShareData(intent.getStringExtra("android.intent.extra.SUBJECT"), intent.getStringExtra("android.intent.extra.TEXT"), parcelableArrayListExtra);
    }

    public static ShareTarget parseShareTargetJson(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        String string = jSONObject.getString(Analytics.Data.ACTION);
        String strOptString = jSONObject.optString(FirebaseAnalytics.Param.METHOD, null);
        String strOptString2 = jSONObject.optString("enctype", null);
        JSONObject jSONObject2 = jSONObject.getJSONObject(SerializedNames.PARAMS);
        return new ShareTarget(string, strOptString, strOptString2, new ShareTarget.Params(jSONObject2.optString("title", "title"), jSONObject2.optString("text", "text"), parseFiles(jSONObject2.optJSONArray("files"))));
    }

    private static List<ShareTarget.FileFormField> parseFiles(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            arrayList.add(new ShareTarget.FileFormField(jSONObject.getString("name"), parseAcceptedTypes(jSONObject.get("accept"))));
        }
        return arrayList;
    }

    private static List<String> parseAcceptedTypes(Object obj) throws JSONException {
        if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            ArrayList arrayList = new ArrayList(jSONArray.length());
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.getString(i));
            }
            return arrayList;
        }
        return Collections.singletonList(obj.toString());
    }
}
