package sdk.pendo.io.r5;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.core.util.Pair;
import external.sdk.pendo.io.gson.Gson;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.h7.t;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.AnalyticsConfigurationModel;
import sdk.pendo.io.models.JWTSessionData;
import sdk.pendo.io.s7.n0;

/* JADX INFO: loaded from: classes4.dex */
public class b {
    private static final Object l = new Object();
    private static volatile b m;
    public a a;
    public a b;
    private sdk.pendo.io.o3.b g;
    private int i;
    private int j;
    private sdk.pendo.io.a0.f k;
    private int c = 0;
    private int d = 0;
    private boolean e = false;
    private boolean f = false;
    private int h = 10485760;

    private b() {
        h();
        i();
        this.a = new a("TemporaryAnalyticEventsBuffer", 5, 5, -1.0f, 0.8f, new a.d() { // from class: sdk.pendo.io.r5.b$$ExternalSyntheticLambda1
            @Override // sdk.pendo.io.r5.a.d
            public final void a(boolean z) {
                this.f$0.b(z);
            }
        });
        this.b = new a("MainAnalyticEventsBuffer", this.i, this.j, this.h, 0.8f, new a.d() { // from class: sdk.pendo.io.r5.b$$ExternalSyntheticLambda2
            @Override // sdk.pendo.io.r5.a.d
            public final void a(boolean z) {
                this.f$0.c(z);
            }
        });
    }

    private String c() {
        String str = "";
        if (this.a.i() > 0) {
            str = "" + this.a.l();
            this.a.b();
        }
        if (this.b.i() <= 0) {
            return str;
        }
        String str2 = str + this.b.l();
        this.b.b();
        return str2;
    }

    public static b f() {
        if (m == null) {
            synchronized (l) {
                if (m == null) {
                    m = new b();
                }
            }
        }
        return m;
    }

    private void h() {
        try {
            SharedPreferences sharedPreferencesA = n0.a("IMMEDIATE_EVENTS_PARAMS");
            String string = sharedPreferencesA != null ? sharedPreferencesA.getString("IMMEDIATE_EVENTS_LIST", "['guideDismissed', 'guideSnoozed', 'AppSessionEnd', 'AppInBackground']") : "";
            this.k = (sdk.pendo.io.a0.f) ((string == null || string.isEmpty()) ? new Gson().a("['guideDismissed', 'guideSnoozed', 'AppSessionEnd', 'AppInBackground']", sdk.pendo.io.a0.f.class) : new Gson().a(string, sdk.pendo.io.a0.f.class));
        } catch (Exception e) {
            PendoLogger.e("AnalyticEventsManager", "Failed to initializeDefaultImmediateEventsList", e);
        }
    }

    private void i() {
        SharedPreferences sharedPreferencesA = n0.a("MAIN_BUFFER_PARAMS");
        if (sharedPreferencesA != null) {
            this.i = sharedPreferencesA.getInt("BUFFER_TIMEOUT", 30);
            this.j = sharedPreferencesA.getInt("BUFFER_QUEUE_SIZE", 15);
            this.h = sharedPreferencesA.getInt("BUFFER_MAX_STORAGE", 10485760);
        } else {
            this.i = 30;
            this.j = 15;
            this.h = 10485760;
        }
    }

    private void j() {
        if (!sdk.pendo.io.s7.j.a()) {
            if (this.e) {
                d(false);
            }
            if (this.g == null) {
                this.g = sdk.pendo.io.s7.j.a((sdk.pendo.io.q3.e<Boolean>) new sdk.pendo.io.q3.e() { // from class: sdk.pendo.io.r5.b$$ExternalSyntheticLambda0
                    @Override // sdk.pendo.io.q3.e
                    public final void accept(Object obj) {
                        this.f$0.a((Boolean) obj);
                    }
                });
            }
            this.b.j();
            return;
        }
        String strH = this.b.h();
        if (strH.isEmpty()) {
            a(true);
            return;
        }
        if (strH.length() > 3) {
            strH = sdk.pendo.io.s7.d.b(strH);
        }
        sdk.pendo.io.f6.a.d().a(strH, true, null);
    }

    private void k() {
        this.e = true;
        int i = this.d + 1;
        this.d = i;
        if (i >= 10) {
            d(false);
            return;
        }
        int i2 = this.c;
        this.c = i2 == 0 ? 30 : i2 * 2;
        if (this.f || this.c > 600) {
            this.c = 600;
        }
        this.b.a(this.c);
    }

    public void a() {
        this.a.d();
        this.b.d();
    }

    public void b() {
        if (this.a.i() > 0) {
            this.a.b(true);
        } else if (this.b.i() > 0) {
            this.b.b(true);
        } else {
            sdk.pendo.io.f6.g.a.c(true);
        }
    }

    public int d() {
        return this.i;
    }

    public int e() {
        return this.j;
    }

    public float g() {
        return this.h / 1048576.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(boolean z) {
        a(this.a, this.b, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(boolean z) {
        j();
    }

    private void d(boolean z) {
        this.f = !z;
        this.e = false;
        this.c = 0;
        this.d = 0;
        if (z) {
            return;
        }
        this.b.n();
    }

    public void a(boolean z) {
        sdk.pendo.io.f6.g.a.c(true);
        if (!z) {
            k();
        } else {
            d(true);
            this.b.d(true);
        }
    }

    public synchronized void a(List<JSONObject> list) {
        if (list != null) {
            if (!list.isEmpty()) {
                t tVarB = PendoInternal.B();
                if (tVarB != null) {
                    try {
                        for (JSONObject jSONObject : list) {
                            jSONObject.put("recordingSessionId", tVarB.getRecordingSessionId());
                            jSONObject.put("recordingId", tVarB.getRecordingId());
                        }
                    } catch (JSONException e) {
                        PendoLogger.e("AnalyticEventsManager", "handleTrackedAnalyticEvents: adding analytics to json failed", e);
                    }
                }
                String str = "";
                StringBuilder sb = new StringBuilder();
                boolean z = false;
                for (JSONObject jSONObject2 : list) {
                    if (jSONObject2 != null) {
                        String string = jSONObject2.toString();
                        PendoLogger.i("AnalyticEventsManager-> handle analytic event: " + string, new Object[0]);
                        sb.append("}|{");
                        sb.append(string);
                        if (!z || str.isEmpty()) {
                            Pair<Boolean, String> pairA = c.a.a(jSONObject2, this.k);
                            if (!z && pairA.first.booleanValue()) {
                                z = true;
                            }
                            if (str.isEmpty() && pairA.second.equals("previous_visitor_end_session_analytics")) {
                                str = "previous_visitor_end_session_analytics";
                            }
                        }
                    }
                }
                if (z && str.equals("previous_visitor_end_session_analytics")) {
                    if (!TextUtils.isEmpty(PendoInternal.u())) {
                        a(sb.toString());
                        return;
                    }
                    PendoInternal.f();
                }
                this.a.b(sb.toString(), list.size(), z);
            }
        }
    }

    public void b(AnalyticsConfigurationModel analyticsConfigurationModel) {
        synchronized (l) {
            if (a(analyticsConfigurationModel.getBufferDuration(), analyticsConfigurationModel.getBufferQueueSize(), analyticsConfigurationModel.getMaxStoragesizeMB())) {
                this.b.a(this.i, this.j, this.h);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Boolean bool) {
        sdk.pendo.io.o3.b bVar = this.g;
        if (bVar != null) {
            bVar.dispose();
            this.g = null;
        }
        a aVar = this.b;
        if (aVar != null) {
            aVar.a(0L);
        }
    }

    private void a(a aVar, a aVar2, boolean z) {
        aVar2.b(aVar.h(), aVar.g(), z);
        aVar.d(false);
    }

    private void a(String str) {
        if (PendoInternal.v() == null) {
            return;
        }
        String strB = c() + str;
        if (strB.isEmpty()) {
            return;
        }
        if (strB.length() > 3) {
            strB = sdk.pendo.io.s7.d.b(strB);
        }
        JWTSessionData jWTSessionData = (JWTSessionData) PendoInternal.v().copy();
        PendoInternal.f();
        sdk.pendo.io.f6.a.d().a(jWTSessionData, strB, true, (String) null);
    }

    public synchronized void a(AnalyticsConfigurationModel analyticsConfigurationModel) {
        if (analyticsConfigurationModel != null) {
            sdk.pendo.io.a0.f immediateEventsArray = analyticsConfigurationModel.getImmediateEventsArray();
            if (immediateEventsArray != null && !immediateEventsArray.toString().equals(this.k.toString())) {
                this.k = immediateEventsArray;
                n0.a("IMMEDIATE_EVENTS_PARAMS", "IMMEDIATE_EVENTS_LIST", immediateEventsArray.toString(), true);
            }
        }
    }

    private boolean a(int i, int i2, float f) {
        boolean z;
        if (i > 300) {
            i = 300;
        }
        if (i2 > 1000) {
            i2 = 1000;
        }
        if (f > 100.0f) {
            f = 100.0f;
        }
        if (i <= 0 || this.i == i) {
            z = false;
        } else {
            this.i = i;
            n0.a("MAIN_BUFFER_PARAMS", "BUFFER_TIMEOUT", i);
            z = true;
        }
        if (i2 > 0 && this.j != i2) {
            this.j = i2;
            n0.a("MAIN_BUFFER_PARAMS", "BUFFER_QUEUE_SIZE", i2);
            z = true;
        }
        if (f <= 0.0f || this.h == ((int) f) * 1048576) {
            return z;
        }
        int i3 = (int) (f * 1048576.0f);
        this.h = i3;
        n0.a("MAIN_BUFFER_PARAMS", "BUFFER_MAX_STORAGE", i3);
        return true;
    }
}
