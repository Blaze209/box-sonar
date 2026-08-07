package sdk.pendo.io.l6;

import android.graphics.Bitmap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.n6.g;
import sdk.pendo.io.p6.b;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: sdk.pendo.io.l6.a$a, reason: collision with other inner class name */
    class C0415a extends g {
        final /* synthetic */ JSONObject a;
        final /* synthetic */ JSONArray b;
        final /* synthetic */ Bitmap c;

        C0415a(JSONObject jSONObject, JSONArray jSONArray, Bitmap bitmap) {
            this.a = jSONObject;
            this.b = jSONArray;
            this.c = bitmap;
        }

        @Override // sdk.pendo.io.a5.a.InterfaceC0343a
        public void call(Object... objArr) {
            try {
                b.a(sdk.pendo.io.m6.a.EVENT_SCREEN_CAPTURED, this.a, this.b, this.c, null);
                sdk.pendo.io.o6.a.d().a(sdk.pendo.io.o6.a.d.EVENT_CAPTURE_MODE_SCREEN_CAPTURED, new Object[0]);
            } catch (JSONException e) {
                PendoLogger.e(e, e.getMessage(), new Object[0]);
            }
        }
    }

    public static void a(JSONObject jSONObject, JSONArray jSONArray, Bitmap bitmap) {
        sdk.pendo.io.k6.a aVar = sdk.pendo.io.k6.a.a;
        sdk.pendo.io.m6.a aVar2 = sdk.pendo.io.m6.a.EVENT_READY_TO_RECEIVE_SCREEN;
        aVar.a(aVar2.b());
        b.a(sdk.pendo.io.m6.a.EVENT_PREPARE_TO_RECEIVE_SCREEN.b(), new JSONObject());
        aVar.a(aVar2.b(), new C0415a(jSONObject, jSONArray, bitmap));
    }
}
