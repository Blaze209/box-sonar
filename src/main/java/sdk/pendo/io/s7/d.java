package sdk.pendo.io.s7;

import android.os.Build;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import external.sdk.pendo.io.gson.JsonParser;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.actions.GuidesActionsManager;
import sdk.pendo.io.actions.GuidesManager;
import sdk.pendo.io.actions.PendoCommandAction;
import sdk.pendo.io.actions.VisualGuideBase;
import sdk.pendo.io.analytics.data.IdentifyData;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.GuideModel;
import sdk.pendo.io.models.StepContentModel;
import sdk.pendo.io.network.interfaces.GetAuthToken;
import sdk.pendo.io.utilities.script.PendoNativeBridge;

/* JADX INFO: loaded from: classes5.dex */
public final class d {
    private static JSONObject a;

    private static JSONObject a(sdk.pendo.io.r5.d dVar, sdk.pendo.io.r5.g.b bVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("event", dVar.b());
            jSONObject2.put("device_time", System.currentTimeMillis());
            if (bVar != null) {
                jSONObject2.put(BoxNoteConstants.BOX_NOTE_BRIDGE_KEY_REASON, bVar.b());
            }
            if (jSONObject != null) {
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    jSONObject2.put(next, jSONObject.get(next));
                }
            }
            return jSONObject2;
        } catch (Exception e) {
            PendoLogger.e("Error while generating / sending error event: " + e.getMessage(), new Object[0]);
            return jSONObject2;
        }
    }

    public static void b() throws JSONException {
        if (sdk.pendo.io.w6.a.a.f()) {
            sdk.pendo.io.r5.i.e().d().onNext(new sdk.pendo.io.r5.h().a(sdk.pendo.io.r5.d.APP_OFFLINE_LIMIT_REACHED).a(System.currentTimeMillis()).d(PendoInternal.G()).a(PendoInternal.l()).a());
        }
    }

    public static void c() throws JSONException {
        if (sdk.pendo.io.o6.a.d().g()) {
            PendoLogger.d("Device is in Capture/Test/Preview mode, no need to send AppSessionStart", new Object[0]);
            sdk.pendo.io.f6.g.a.c(true);
        } else {
            sdk.pendo.io.r5.i.e().d().onNext(new sdk.pendo.io.r5.h().a(System.currentTimeMillis()).a(sdk.pendo.io.r5.d.APP_SESSION_START).d(PendoInternal.G()).a(PendoInternal.l()).c(PendoNativeBridge.getOrientation()).a());
        }
    }

    public static void d() {
        if (sdk.pendo.io.o6.a.d().g()) {
            PendoLogger.d("Device is in Capture/Test/Preview mode, no need to send Identify event", new Object[0]);
            return;
        }
        try {
            IdentifyData identifyData = PendoInternal.A().getIdentifyData();
            if (identifyData == null) {
                return;
            }
            sdk.pendo.io.r5.i.e().d().onNext(identifyData.b());
        } catch (Exception e) {
            PendoLogger.w(e, "Error creating identify data", new Object[0]);
        }
    }

    private static synchronized JSONObject a() {
        if (a == null) {
            JSONObject jSONObject = new JSONObject();
            a = jSONObject;
            try {
                jSONObject.put("SDK", Build.VERSION.RELEASE);
                a.put("OsSdkVersion", String.valueOf(Build.VERSION.SDK_INT));
                a.put("Brand", Build.BRAND);
                a.put("Manufacturer", Build.MANUFACTURER);
                a.put(ExifInterface.TAG_MODEL, Build.MODEL);
                a.put("Board", Build.BOARD);
                a.put("Bootloader", Build.BOOTLOADER);
                a.put("DeviceProductName", Build.PRODUCT);
                a.put("IndustrialDesignName", Build.DEVICE);
            } catch (JSONException unused) {
                a = null;
            }
        }
        return a;
    }

    public static void b(String str, String str2) {
        StepContentModel stepContentModel;
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            GuideModel guide = GuidesManager.INSTANCE.getGuide(str);
            if (guide != null && (stepContentModel = guide.getStepContentModel(0)) != null) {
                jSONObject2.put(VisualGuideBase.GUIDE_STEP_ID_PARAMETER_NAME, stepContentModel.getGuideStepId());
            }
            jSONObject2.put("orientation", l.g()).put("language", s0.b()).put("guideId", str).put(PendoCommandAction.PendoCommandGlobalAction.SendPendoGenericAnalyticsConsts.DISMISSED_REASON, sdk.pendo.io.r5.g.a.APP_TERMINATION.b());
            jSONObject.put("props", jSONObject2).put("guideId", str).put("displayDuration", str2).put("type", sdk.pendo.io.r5.d.GUIDE_DISMISSED.b());
        } catch (JSONException e) {
            PendoLogger.e(e, "Can't generate additional info json", new Object[0]);
        }
        sdk.pendo.io.r5.i.f().a(sdk.pendo.io.r5.d.GUIDE_DISMISSED, jSONObject, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(String str, String str2, GetAuthToken.GetAuthTokenResponse getAuthTokenResponse) throws JSONException {
        long jW = PendoInternal.w();
        if (jW <= 0) {
            jW = System.currentTimeMillis();
        }
        sdk.pendo.io.r5.i.e().d().onNext(new sdk.pendo.io.r5.h().a(jW + 1).a(sdk.pendo.io.r5.d.APP_SESSION_END).d(str).a(str2).c(PendoNativeBridge.getOrientation()).a());
        sdk.pendo.io.f6.g.a.c(true);
    }

    public static void b(JSONObject jSONObject) {
        sdk.pendo.io.w6.a.a.a(jSONObject, (JSONObject) null);
    }

    public static String a(String str) {
        return TextUtils.isEmpty(str) ? "" : str.replace("\\u0000", "");
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String strA = a(str);
        if (!strA.startsWith("}|{")) {
            int iIndexOf = strA.indexOf("}|{");
            if (iIndexOf == -1) {
                return "";
            }
            strA = strA.substring(iIndexOf);
        }
        String str2 = strA;
        if (str2.length() <= 3) {
            return "";
        }
        int iLastIndexOf = str2.lastIndexOf("}|{");
        boolean zJ = false;
        if (str2.endsWith("}")) {
            try {
                zJ = JsonParser.a(str2.substring(iLastIndexOf + 3)).j();
            } catch (sdk.pendo.io.a0.q e) {
                PendoLogger.w(e, "Cannot parse trailing object", new Object[0]);
            }
        }
        boolean z = zJ;
        return (iLastIndexOf != 0 || z) ? a(str2, 3, iLastIndexOf, "}|{", ",", z) : "";
    }

    public static void a(boolean z) {
        if (sdk.pendo.io.w6.a.a.f()) {
            sdk.pendo.io.r5.i.e().d().onNext(new sdk.pendo.io.r5.h().a(z ? sdk.pendo.io.r5.d.APP_ONLINE : sdk.pendo.io.r5.d.APP_OFFLINE).a(System.currentTimeMillis()).d(PendoInternal.G()).a(PendoInternal.l()).a());
        }
    }

    public static void a(sdk.pendo.io.w6.b.c cVar) {
        if (sdk.pendo.io.w6.a.a.f()) {
            sdk.pendo.io.r5.i.e().d().onNext(new sdk.pendo.io.r5.h().a(cVar.event).a(System.currentTimeMillis()).d(PendoInternal.G()).a(PendoInternal.l()).c(PendoNativeBridge.getOrientation()).a());
        }
    }

    public static void a(final String str, final String str2) {
        if (sdk.pendo.io.o6.a.d().g() || str == null) {
            return;
        }
        sdk.pendo.io.network.interfaces.a.c().a(sdk.pendo.io.i4.a.d()).f().a(sdk.pendo.io.t6.c.a(new sdk.pendo.io.q3.e() { // from class: sdk.pendo.io.s7.d$$ExternalSyntheticLambda0
            @Override // sdk.pendo.io.q3.e
            public final void accept(Object obj) throws JSONException {
                d.a(str, str2, (GetAuthToken.GetAuthTokenResponse) obj);
            }
        }, "Observer for sending app session ended"));
    }

    public static void a(sdk.pendo.io.r5.g.b bVar, String str, Object... objArr) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("errorMessage", str);
            if (objArr != null && objArr.length > 0) {
                jSONObject.put("errorInfo", objArr[0].toString());
            }
            a(bVar, jSONObject);
        } catch (Exception e) {
            PendoLogger.e(e, e.getMessage(), new Object[0]);
        }
    }

    public static void a(sdk.pendo.io.r5.g.b bVar, JSONObject jSONObject) {
        sdk.pendo.io.f6.a.d().b(a(sdk.pendo.io.r5.d.SDK_ERROR, bVar, jSONObject).toString());
    }

    public static void a(String str, List<String> list) {
        JSONObject jSONObject = new JSONObject();
        try {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i));
                if (i != list.size() - 1) {
                    sb.append(",");
                }
            }
            jSONObject.put("guideId", str);
            jSONObject.put("device_time", System.currentTimeMillis());
            jSONObject.put(BoxNoteConstants.BOX_NOTE_BRIDGE_KEY_REASON, sdk.pendo.io.r5.g.b.ERROR_REASON_IMAGE);
            jSONObject.put("sourcesList", sb.toString());
            sdk.pendo.io.f6.a.d().b(jSONObject.toString());
        } catch (Exception e) {
            PendoLogger.e("Error while generating / sending error event: " + e.getMessage(), new Object[0]);
        }
    }

    public static void a(Throwable th, String str) {
        a(th, str, (String) null);
    }

    public static void a(Throwable th, String str, String str2) {
        StringBuilder sbAppend;
        JSONObject jSONObject = new JSONObject();
        try {
            String message = th.getMessage();
            if (y0.a(th)) {
                if (str2 == null || str2.equals(message)) {
                    sbAppend = (str == null || str.equals(message)) ? new StringBuilder().append("Stacktrace message = '") : new StringBuilder().append(str).append(" = 'Stacktrace message = '");
                } else {
                    sbAppend = new StringBuilder().append("Dev log = '").append(str2).append("', Stacktrace message = '");
                }
                String string = sbAppend.append(message).append("'.").toString();
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("errorInfo", str);
                }
                JSONObject jSONObjectA = a();
                if (jSONObjectA != null) {
                    jSONObject.put("device_info", jSONObjectA);
                }
                jSONObject.put("exceptionType", th.getClass().getCanonicalName());
                jSONObject.put("errorMessage", string);
                jSONObject.put("stackTrace", y0.a(th.getStackTrace()));
                JSONObject jSONObjectA2 = a(sdk.pendo.io.r5.d.SDK_EXCEPTION, (sdk.pendo.io.r5.g.b) null, jSONObject);
                if ("PossibleCrash_androidX".equals(str2)) {
                    sdk.pendo.io.y5.a.a(PendoInternal.o(), jSONObjectA2.toString());
                } else {
                    sdk.pendo.io.f6.a.d().b(jSONObjectA2.toString());
                }
            }
        } catch (Exception e) {
            PendoLogger.d("Error while generating / sending error event: " + e.getMessage(), new Object[0]);
        }
    }

    public static void a(sdk.pendo.io.r5.m mVar, sdk.pendo.io.r5.d dVar, String str) {
        JSONObject jSONObjectA;
        mVar.a(dVar, null, str);
        if (dVar == sdk.pendo.io.r5.d.GUIDE_DISMISSED && (jSONObjectA = mVar.a()) != null && jSONObjectA.has("guideId")) {
            try {
                l0.e(jSONObjectA.getString("guideId"));
            } catch (Exception e) {
                PendoLogger.e(e, e.getMessage(), new Object[0]);
            }
        }
    }

    public static void a(sdk.pendo.io.r5.m mVar, long j, String str, String str2, JSONObject jSONObject) {
        sdk.pendo.io.r5.g gVarB = mVar.b();
        if (gVarB == null || !GuidesActionsManager.getInstance().wasGuideFullyDisplayedAfterAnimation(gVarB.c())) {
            return;
        }
        GuidesActionsManager.getInstance().removeGuideFullyDisplayedAfterAnimation(gVarB.c());
        gVarB.a(j);
        gVarB.a(str);
        mVar.a(sdk.pendo.io.r5.d.GUIDE_DISMISSED, jSONObject, str2);
        l0.e(String.valueOf(gVarB.c()));
    }

    public static void a(sdk.pendo.io.r5.m mVar, sdk.pendo.io.r5.g.b bVar, JSONObject jSONObject) {
        sdk.pendo.io.r5.g gVarB = mVar.b();
        if (gVarB != null) {
            gVarB.a(bVar);
        } else {
            PendoLogger.w("Generics analytics is null!", new Object[0]);
        }
        mVar.a(sdk.pendo.io.r5.d.GUIDE_NOT_DISPLAYED, jSONObject, null);
    }

    public static void a(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("signedData", str);
            jSONObject.put("source", str2);
            jSONObject.put("exceptionMessage", str3);
            a(sdk.pendo.io.r5.g.c.INVALID_SIGNATURE, jSONObject);
        } catch (Exception e) {
            PendoLogger.e("Error while generating / sending error event: " + e.getMessage(), new Object[0]);
        }
    }

    public static void a(sdk.pendo.io.r5.g.c cVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("event", sdk.pendo.io.r5.d.SECURITY_EXCEPTION.b());
            jSONObject2.put("device_time", System.currentTimeMillis());
            if (cVar != null) {
                jSONObject2.put(BoxNoteConstants.BOX_NOTE_BRIDGE_KEY_REASON, cVar.b());
            }
            if (jSONObject != null) {
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    jSONObject2.put(next, jSONObject.get(next));
                }
            }
        } catch (Exception e) {
            PendoLogger.e("Error while generating / sending error event: " + e.getMessage(), new Object[0]);
        }
        sdk.pendo.io.f6.a.d().b(jSONObject2.toString());
    }

    public static String a(String str, int i, int i2, String str2, String str3, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return (z ? str.substring(i) : str.substring(i, i2)).replace(str2, str3);
    }

    public static void a(JSONObject jSONObject) {
        sdk.pendo.io.w6.a.a.a((JSONObject) null, jSONObject);
    }
}
