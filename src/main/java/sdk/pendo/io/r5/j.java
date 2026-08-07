package sdk.pendo.io.r5;

import android.text.TextUtils;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.actions.ActivationManager;
import sdk.pendo.io.actions.PendoCommandAction;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.s7.u0;

/* JADX INFO: loaded from: classes4.dex */
public class j {
    private final d a;
    private long b;
    private final JSONObject c;
    private g d;
    private JSONObject e;
    private String f;

    public j(JSONObject jSONObject, m.a aVar) {
        this.b = -1L;
        this.e = jSONObject;
        this.a = aVar.b();
        this.c = aVar.c();
        this.f = aVar.a();
        this.b = aVar.d();
    }

    public JSONObject a() {
        Iterator<String> itKeys;
        Iterator<String> itKeys2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("device_time", this.b);
            jSONObject.put("sdkVersion", u0.a());
            d dVar = this.a;
            if (dVar != null && !dVar.equals(d.TRACK_EVENT) && !this.a.equals(d.UNKNOWN)) {
                jSONObject.put("event", this.a.b());
            }
            JSONObject jSONObject2 = this.e;
            if (jSONObject2 != null && jSONObject2.toString().contains(ActivationManager.SCREEN_DATA_KEY)) {
                jSONObject.put("retroactiveScreenId", PendoInternal.z().getCurrentScreenId());
            }
            g gVar = this.d;
            if (gVar != null) {
                gVar.a(jSONObject, this.a);
            }
            JSONObject jSONObject3 = this.e;
            if (jSONObject3 != null && (itKeys2 = jSONObject3.keys()) != null) {
                while (itKeys2.hasNext()) {
                    String next = itKeys2.next();
                    jSONObject.put(next, this.e.get(next));
                }
            }
            JSONObject jSONObject4 = this.c;
            if (jSONObject4 != null && (itKeys = jSONObject4.keys()) != null) {
                while (itKeys.hasNext()) {
                    String next2 = itKeys.next();
                    jSONObject.put(next2, this.c.get(next2));
                }
            }
            if (!TextUtils.isEmpty(this.f)) {
                jSONObject.put(PendoCommandAction.PendoCommandGlobalAction.PendoInfoConsts.EXTERNAL_ENDPOINT_URL, this.f);
            }
            return jSONObject;
        } catch (JSONException e) {
            PendoLogger.e(e.getMessage(), new Object[0]);
            return null;
        }
    }

    public j(g gVar, m.a aVar) {
        this.b = -1L;
        this.d = gVar;
        this.a = aVar.b();
        this.c = aVar.c();
        this.f = aVar.a();
        this.b = aVar.d();
    }
}
