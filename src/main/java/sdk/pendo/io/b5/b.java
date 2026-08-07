package sdk.pendo.io.b5;

import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class b {
    public String a;
    public String[] b;
    public long c;
    public long d;

    b(String str) {
        this(new JSONObject(str));
    }

    b(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = jSONObject.getJSONArray("upgrades");
        int length = jSONArray.length();
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            strArr[i] = jSONArray.getString(i);
        }
        this.a = jSONObject.getString(CmcdConfiguration.KEY_SESSION_ID);
        this.b = strArr;
        this.c = jSONObject.getLong("pingInterval");
        this.d = jSONObject.getLong("pingTimeout");
    }
}
