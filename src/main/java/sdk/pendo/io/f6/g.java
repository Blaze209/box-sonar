package sdk.pendo.io.f6;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.JWTSessionData;
import sdk.pendo.io.models.SessionData;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u001a\u0010\u0006\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J7\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\u00102\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\fH\u0000¢\u0006\u0004\b\u0006\u0010\u0011R(\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\b\u0010\u0014\"\u0004\b\u0015\u0010\u0016R(\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0005\u0010\u0014\"\u0004\b\u0018\u0010\u0016R(\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u0006\u0010\u0014\"\u0004\b\u001b\u0010\u0016¨\u0006\u001f"}, d2 = {"Lsdk/pendo/io/f6/g;", "Lsdk/pendo/io/f6/h;", "", "wasSent", "", "b", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "finishedSendingPersistedAnalytics", "c", "Lsdk/pendo/io/models/SessionData;", "sessionData", "shouldSendDeviceInfo", "", "", "", "map", "", "(Ljava/util/Map;)Ljava/util/Map;", "Lsdk/pendo/io/j4/a;", "Lsdk/pendo/io/j4/a;", "()Lsdk/pendo/io/j4/a;", "setFinishedSendingPersistedAnalytics", "(Lsdk/pendo/io/j4/a;)V", "isFinishedSendingPersistedAnalytics", "setVisitorDataSent", "visitorDataSent", "d", "setAccountDataSent", "accountDataSent", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class g implements h {
    public static final g a = new g();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private static sdk.pendo.io.j4.a<Boolean> isFinishedSendingPersistedAnalytics;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private static sdk.pendo.io.j4.a<Boolean> visitorDataSent;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private static sdk.pendo.io.j4.a<Boolean> accountDataSent;

    static {
        Boolean bool = Boolean.FALSE;
        sdk.pendo.io.j4.a<Boolean> aVarB = sdk.pendo.io.j4.a.b(bool);
        Intrinsics.checkNotNullExpressionValue(aVarB, "createDefault(...)");
        isFinishedSendingPersistedAnalytics = aVarB;
        sdk.pendo.io.j4.a<Boolean> aVarB2 = sdk.pendo.io.j4.a.b(bool);
        Intrinsics.checkNotNullExpressionValue(aVarB2, "createDefault(...)");
        visitorDataSent = aVarB2;
        sdk.pendo.io.j4.a<Boolean> aVarB3 = sdk.pendo.io.j4.a.b(bool);
        Intrinsics.checkNotNullExpressionValue(aVarB3, "createDefault(...)");
        accountDataSent = aVarB3;
    }

    private g() {
    }

    public final sdk.pendo.io.j4.a<Boolean> a() {
        return accountDataSent;
    }

    public final sdk.pendo.io.j4.a<Boolean> b() {
        return visitorDataSent;
    }

    public final sdk.pendo.io.j4.a<Boolean> c() {
        return isFinishedSendingPersistedAnalytics;
    }

    @Override // sdk.pendo.io.f6.h
    public void a(SessionData sessionData) {
        h.a.a(this, sessionData);
    }

    @Override // sdk.pendo.io.f6.h
    public void b(boolean wasSent) {
        visitorDataSent.onNext(Boolean.valueOf(wasSent));
    }

    public void c(boolean finishedSendingPersistedAnalytics) {
        isFinishedSendingPersistedAnalytics.onNext(Boolean.valueOf(finishedSendingPersistedAnalytics));
    }

    @Override // sdk.pendo.io.f6.h
    public void a(SessionData sessionData, boolean shouldSendDeviceInfo) {
        Map<String, Object> mapA;
        Map<String, Object> mapA2;
        if (sessionData == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (shouldSendDeviceInfo) {
                JSONObject jSONObject2 = new JSONObject();
                sdk.pendo.io.a6.b.INSTANCE.a().a(jSONObject2);
                JSONObject jSONObject3 = jSONObject2.getJSONObject("device_info");
                Intrinsics.checkNotNullExpressionValue(jSONObject3, "getJSONObject(...)");
                jSONObject.put("deviceInfo", jSONObject3);
            }
            boolean z = true;
            boolean z2 = sessionData.getVisitorData() != null;
            if (sessionData.getAccountData() == null) {
                z = false;
            }
            if (sessionData instanceof JWTSessionData) {
                jSONObject.put("jwt", ((JWTSessionData) sessionData).getJwt());
                jSONObject.put("signingKeyName", ((JWTSessionData) sessionData).getSigningKeyName());
            } else {
                SessionData sessionDataRemoveDuplicatesKeepingOriginalKeys = sessionData.removeDuplicatesKeepingOriginalKeys();
                if (z2 && (mapA2 = a(sessionDataRemoveDuplicatesKeepingOriginalKeys.getVisitorData())) != null && !mapA2.isEmpty()) {
                    jSONObject.put("userAttr", new JSONObject(mapA2));
                }
                if (z && (mapA = a(sessionDataRemoveDuplicatesKeepingOriginalKeys.getAccountData())) != null && !mapA.isEmpty()) {
                    jSONObject.put("accountAttr", new JSONObject(mapA));
                }
            }
            a.d().a(sessionData, jSONObject, z, z2);
        } catch (JSONException e) {
            PendoLogger.e("SetupManager", "sendVisitorAndAccountData", e);
        }
    }

    @Override // sdk.pendo.io.f6.h
    public void a(boolean wasSent) {
        accountDataSent.onNext(Boolean.valueOf(wasSent));
    }

    public final Map<String, Object> a(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            boolean z = true;
            try {
                boolean z2 = new JSONObject(MapsKt.mapOf(TuplesKt.to(key, value))).toString() == null;
                if (z2) {
                    PendoLogger.e("SetupManager", "Invalid attribute was detected. Key: " + key + ", value: " + value + ". Valid values are text, boolean, int, float, date and list.", (Throwable) null);
                }
                z = z2;
            } catch (Exception e) {
                PendoLogger.e("SetupManager", "verifyFields exception for Key: " + key + ", value: " + value + ".", e);
            }
            if (!z) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }
}
