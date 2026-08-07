package sdk.pendo.io.p6;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.actions.ActivationManager;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.network.interfaces.GetAuthToken;
import sdk.pendo.io.q3.e;
import sdk.pendo.io.s7.j0;
import sdk.pendo.io.s7.s0;
import sdk.pendo.io.s7.v0;
import sdk.pendo.io.t6.c;
import sdk.pendo.io.t6.d;
import sdk.pendo.io.w1.g;

/* JADX INFO: loaded from: classes4.dex */
public final class b {
    private static String a;
    private static final AtomicBoolean b = new AtomicBoolean(false);
    private static JSONObject c = null;

    public static void a(JSONObject jSONObject, boolean z) {
        try {
            jSONObject.put(sdk.pendo.io.m6.a.EVENT_SUCCESS, z);
        } catch (JSONException unused) {
        }
    }

    public static void b(JSONObject jSONObject) {
        a(sdk.pendo.io.m6.a.EVENT_DEBUG_MODE_LOG.b(), jSONObject);
    }

    public static String c() {
        return PendoInternal.o().getSharedPreferences("socketInfo", 0).getString("sessionToken=", null);
    }

    public static void d() {
        a((String) null);
    }

    private static void e() {
        sdk.pendo.io.k6.a aVar = sdk.pendo.io.k6.a.a;
        aVar.f();
        aVar.b();
        aVar.c();
    }

    public static void a(JSONObject jSONObject) {
        if (sdk.pendo.io.o6.a.d().h()) {
            if (jSONObject != null && jSONObject != c) {
                a(sdk.pendo.io.m6.a.EVENT_DEBUG_MODE_EVENT.b(), jSONObject);
            }
            c = jSONObject;
        }
    }

    public static Uri b() {
        return j0.a.a();
    }

    private static JSONObject c(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("data", jSONObject);
        return jSONObject2;
    }

    public static void a(String str, JSONArray jSONArray) {
        a(str, (Object) jSONArray);
    }

    public static void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Uri uri = Uri.parse(str);
        if (uri == null) {
            PendoLogger.e("Can't read QR code data", new Object[0]);
            return;
        }
        String queryParameter = uri.getQueryParameter("sessionToken");
        PendoLogger.d("got this sessionId: " + queryParameter, new Object[0]);
        if (!TextUtils.isEmpty(queryParameter)) {
            a(queryParameter);
        }
        String queryParameter2 = uri.getQueryParameter(CmcdConfiguration.KEY_SESSION_ID);
        if (TextUtils.isEmpty(queryParameter2)) {
            return;
        }
        a = queryParameter2;
        PendoLogger.d("got this sid: " + a, new Object[0]);
    }

    public static void a(String str, JSONObject jSONObject) {
        a(str, (Object) jSONObject);
    }

    private static void a(String str, Object obj) {
        JSONObject jSONObjectA;
        try {
            if (obj instanceof JSONObject) {
                jSONObjectA = c((JSONObject) obj);
            } else {
                if (!(obj instanceof JSONArray)) {
                    throw new IllegalArgumentException("Unsupported data type for socket emission.");
                }
                jSONObjectA = a((JSONArray) obj);
            }
            if (!TextUtils.isEmpty(a)) {
                jSONObjectA.put(CmcdConfiguration.KEY_SESSION_ID, a);
            }
            jSONObjectA.put("version", AuthenticationConstants.Broker.BROKER_PROTOCOL_VERSION);
            sdk.pendo.io.k6.a.a.a(str, jSONObjectA);
        } catch (JSONException e) {
            PendoLogger.e(e, e.getMessage(), "command: " + str);
        }
    }

    public static JSONObject a(JSONObject jSONObject, JSONArray jSONArray, Bitmap bitmap, JSONArray jSONArray2) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("deviceName", Build.MANUFACTURER + " - " + Build.MODEL);
        jSONObject2.put("image", s0.a(bitmap));
        jSONObject2.put("image_height", bitmap.getHeight());
        jSONObject2.put("image_width", bitmap.getWidth());
        jSONObject2.put("tree", jSONArray);
        jSONObject2.put(ActivationManager.SCREEN_DATA_KEY, jSONObject);
        if (jSONArray2 != null) {
            jSONObject2.put("verifiedElements", jSONArray2);
            PendoLogger.d("verifiedElements" + jSONArray2, new Object[0]);
        }
        return jSONObject2;
    }

    public static boolean a() {
        return b.getAndSet(false);
    }

    public static void a(boolean z, boolean z2) {
        sdk.pendo.io.f6.a.d().i();
        e eVar = new e() { // from class: sdk.pendo.io.p6.b$$ExternalSyntheticLambda0
            @Override // sdk.pendo.io.q3.e
            public final void accept(Object obj) {
                b.a((GetAuthToken.GetAuthTokenResponse) obj);
            }
        };
        if (z) {
            sdk.pendo.io.network.interfaces.a.c().b(1L).a(d.a(eVar, "SocketIOUtils access token skip first observer"));
        } else {
            sdk.pendo.io.network.interfaces.a.c().f().a(c.a(eVar, "SocketIOUtils access token observer"));
        }
    }

    public static boolean a(Object[] objArr) {
        if (objArr != null && objArr.length > 0) {
            Object obj = objArr[0];
            if (obj instanceof String) {
                String str = (String) obj;
                if (!TextUtils.isEmpty(str) && g.a(str, "Unauthorized. Invalid access token.")) {
                    a(true, false);
                    return true;
                }
                if (!TextUtils.isEmpty(str) && g.a(str, "Unauthorized. Invalid session token")) {
                    d();
                    e();
                    sdk.pendo.io.f6.a.d().e(true);
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(GetAuthToken.GetAuthTokenResponse getAuthTokenResponse) {
        if (v0.a(getAuthTokenResponse.accessToken) || a()) {
            return;
        }
        PendoLogger.d("trying to connect to socket...", new Object[0]);
        sdk.pendo.io.k6.a.a.a();
    }

    private static void a(String str) {
        PendoLogger.d("save session token: " + str, new Object[0]);
        SharedPreferences.Editor editorEdit = PendoInternal.o().getSharedPreferences("socketInfo", 0).edit();
        editorEdit.putString("sessionToken=", str);
        editorEdit.apply();
    }

    public static void a(sdk.pendo.io.m6.a aVar, JSONObject jSONObject, JSONArray jSONArray, Bitmap bitmap, JSONArray jSONArray2) throws JSONException {
        a(aVar.b(), a(jSONObject, jSONArray, bitmap, jSONArray2));
    }

    public static void a(boolean z) {
        b.set(z);
    }

    private static JSONObject a(JSONArray jSONArray) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("data", jSONArray);
        return jSONObject;
    }
}
