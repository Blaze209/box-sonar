package sdk.pendo.io;

import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.os.UserManagerCompat;
import com.microsoft.intune.mam.client.content.MAMBroadcastReceiver;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import org.json.JSONException;
import org.json.JSONObject;
import sdk.pendo.io.actions.ActivationManager;
import sdk.pendo.io.actions.GuidesActionsManager;
import sdk.pendo.io.actions.GuidesConfigurationManager;
import sdk.pendo.io.actions.GuidesManager;
import sdk.pendo.io.actions.PendoCommandDispatcher;
import sdk.pendo.io.actions.StepSeenManager;
import sdk.pendo.io.actions.VisualGuideBase;
import sdk.pendo.io.actions.VisualGuidesManager;
import sdk.pendo.io.actions.VisualGuidesManagerInterface;
import sdk.pendo.io.analytics.data.AnonDataForIdentifyEvent;
import sdk.pendo.io.f6.d;
import sdk.pendo.io.f6.h;
import sdk.pendo.io.h7.t;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.AppKeyData;
import sdk.pendo.io.models.InitModel;
import sdk.pendo.io.models.JWTSessionData;
import sdk.pendo.io.models.MetadataModel;
import sdk.pendo.io.models.SessionData;
import sdk.pendo.io.network.interfaces.GetAuthToken;
import sdk.pendo.io.network.interfaces.a;
import sdk.pendo.io.network.responses.validators.JsonWebTokenValidator;
import sdk.pendo.io.o7.g;
import sdk.pendo.io.q3.e;
import sdk.pendo.io.q3.j;
import sdk.pendo.io.r5.i;
import sdk.pendo.io.s7.b1;
import sdk.pendo.io.s7.j0;
import sdk.pendo.io.s7.k0;
import sdk.pendo.io.s7.l0;
import sdk.pendo.io.s7.u0;
import sdk.pendo.io.s7.v;
import sdk.pendo.io.s7.v0;
import sdk.pendo.io.s7.w;
import sdk.pendo.io.s7.y0;
import sdk.pendo.io.s7.z0;
import sdk.pendo.io.sdk.react.PlatformStateManager;
import sdk.pendo.io.t6.c;
import sdk.pendo.io.utilities.AndroidUtils;
import sdk.pendo.io.x6.k;
import sdk.pendo.io.y5.m;

/* JADX INFO: loaded from: classes.dex */
public final class PendoInternal implements d, sdk.pendo.io.p5.a {
    public static Context a;
    public static SessionData b;
    public static AnonDataForIdentifyEvent c;
    public static SessionData d;
    private static long e;
    public static PendoPhasesCallbackInterface f;
    public static Boolean g;
    public static Boolean h;
    private static b i;
    private static Application j;
    private static String k;
    private static Long l;
    private static final Lazy<k0> m;
    private static final AtomicBoolean n;
    public static final AtomicBoolean o;
    private static volatile Application p;
    private static boolean q;
    private static boolean r;
    private static String s;
    private static String t;
    private static volatile boolean u;
    private static int v;
    private static final sdk.pendo.io.j4.a<Boolean> w;
    private static h x;
    private static sdk.pendo.io.x6.d y;
    private static g z;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[sdk.pendo.io.network.interfaces.a.EnumC0439a.values().length];
            a = iArr;
            try {
                iArr[sdk.pendo.io.network.interfaces.a.EnumC0439a.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[sdk.pendo.io.network.interfaces.a.EnumC0439a.FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static class b extends MAMBroadcastReceiver {
        Pendo.PendoOptions a;

        public b(Pendo.PendoOptions pendoOptions) {
            this.a = pendoOptions;
        }

        /* JADX WARN: Code duplicated, block: B:12:0x0025  */
        @Override // com.microsoft.intune.mam.client.content.HookedBroadcastReceiver
        public void onMAMReceive(Context context, Intent intent) {
            boolean z;
            Context applicationContext;
            KeyguardManager keyguardManager;
            try {
                if (PendoInternal.j == null) {
                    return;
                }
                boolean z2 = true;
                if (context != null) {
                    if (context.getApplicationContext() == null || !UserManagerCompat.isUserUnlocked(context.getApplicationContext())) {
                        z = false;
                    } else {
                        z = true;
                    }
                } else {
                    z = false;
                }
                if (z || (applicationContext = PendoInternal.j.getApplicationContext()) == null || ((keyguardManager = (KeyguardManager) applicationContext.getSystemService("keyguard")) != null && keyguardManager.inKeyguardRestrictedInputMode())) {
                    z2 = z;
                }
                if (z2) {
                    PendoInternal.a(this.a);
                    PendoInternal.j.unregisterReceiver(this);
                }
            } catch (Exception e) {
                Log.e("PendoInternal", e.getMessage());
            }
        }
    }

    static {
        Boolean bool = Boolean.FALSE;
        g = bool;
        h = bool;
        i = null;
        j = null;
        k = null;
        l = 0L;
        m = sdk.pendo.io.w5.b.a(k0.class);
        n = new AtomicBoolean(false);
        o = new AtomicBoolean(false);
        q = false;
        r = false;
        s = null;
        t = null;
        u = false;
        v = 1800;
        w = sdk.pendo.io.j4.a.b(bool);
        x = sdk.pendo.io.f6.g.a;
    }

    public PendoInternal(Pendo.PendoOptions pendoOptions) {
        try {
            PendoLogger.plant(sdk.pendo.io.logging.d.INSTANCE.a());
            h();
            b(u);
            b(k);
            j0.d(t);
            sdk.pendo.io.network.interfaces.a.a(s);
            d = a(l0.e(), l0.f(), l0.g(), l0.c());
            U();
            i.e();
            a(d);
            sdk.pendo.io.i0.d.b(new sdk.pendo.io.z5.a());
            PendoCommandDispatcher.getInstance().init();
            sdk.pendo.io.c6.a.b();
            sdk.pendo.io.w6.a.a.g();
            c();
            ActivationManager.INSTANCE.start();
            a0();
            L();
        } catch (Exception e2) {
            PendoLogger.e("PendoInternal", "constructor initialization logic failed with error", e2);
            PendoPhasesCallbackInterface pendoPhasesCallbackInterface = f;
            if (pendoPhasesCallbackInterface != null) {
                pendoPhasesCallbackInterface.onInitFailed();
            }
        }
    }

    public static SessionData A() {
        return b;
    }

    public static t B() {
        g gVar = z;
        if (gVar != null) {
            return gVar.b();
        }
        return null;
    }

    public static int C() {
        if (v <= 0) {
            v = 1800;
            PendoLogger.e("PendoInternal session timeout was reset to the 1800 sec, default", new Object[0]);
        }
        return v;
    }

    public static String D() {
        SessionData sessionData = b;
        if (sessionData instanceof JWTSessionData) {
            return ((JWTSessionData) sessionData).getSigningKeyName();
        }
        return null;
    }

    public static synchronized Map<String, Object> E() {
        SessionData sessionData = b;
        if (sessionData == null) {
            return null;
        }
        return sessionData.getVisitorData();
    }

    public static synchronized Map<String, Map<String, Object>> F() {
        SessionData sessionData = b;
        if (sessionData == null) {
            return null;
        }
        return sessionData.getVisitorExternalData();
    }

    public static String G() {
        SessionData sessionData = b;
        return sessionData == null ? "" : sessionData.getVisitorId();
    }

    public static String H() {
        if (a(false, "getVisitorId")) {
            return null;
        }
        return G();
    }

    protected static void I() {
        Log.w("PendoInternal", "The startSession request for an anonymous session was ignored. The application settings in Pendo do not allow tracking of anonymous sessions. No data is being recorded.");
        if (Q()) {
            Log.w("PendoInternal", "Previous session was ended, no data is being recorded.");
            i();
        }
    }

    public static void J() {
        d = a(l0.e(), l0.f(), l0.g(), l0.c());
        sdk.pendo.io.s7.d.a(z().getCurrentScreenData());
        sdk.pendo.io.s7.d.a(x(), t());
        a(0L);
        i.e().c();
        sdk.pendo.io.w6.d.Companion aVar = sdk.pendo.io.w6.d.INSTANCE;
        aVar.a();
        aVar.d();
    }

    static void K() {
        ActivationManager.INSTANCE.isInitedObservable().a(new j() { // from class: sdk.pendo.io.PendoInternal$$ExternalSyntheticLambda4
            @Override // sdk.pendo.io.q3.j
            public final boolean test(Object obj) {
                return ((Boolean) obj).booleanValue();
            }
        }).f().a(sdk.pendo.io.i4.a.b()).a(c.a(new e() { // from class: sdk.pendo.io.PendoInternal$$ExternalSyntheticLambda5
            @Override // sdk.pendo.io.q3.e
            public final void accept(Object obj) {
                PendoInternal.b((Boolean) obj);
            }
        }, "Pendo handleSessionReplayInitialization init completed observer"));
    }

    private static void L() {
        sdk.pendo.io.y5.a.c(o());
    }

    private static void M() {
        new sdk.pendo.io.y5.e(new sdk.pendo.io.y5.j());
    }

    public static synchronized boolean N() {
        return u;
    }

    public static boolean O() {
        if (!o.get()) {
            Log.e("APICallIgnored", "Make sure Pendo's Setup API has been called");
            return true;
        }
        if (sdk.pendo.io.j6.a.d()) {
            PendoLogger.w("PendoInternal", "Track event not sent since killSwitch is on");
            return true;
        }
        if (S() || Z()) {
            return false;
        }
        PendoLogger.w("PendoInternal", "Track event not sent since session is not active and start session has not been called and we're not in preview/test mode");
        return true;
    }

    public static boolean P() {
        return h.booleanValue();
    }

    public static boolean Q() {
        return b != null;
    }

    public static boolean R() {
        SessionData sessionData = b;
        return sessionData != null && sessionData.getIsJwtModeOn();
    }

    public static boolean S() {
        return q;
    }

    public static void T() {
        SessionData sessionData = b;
        if (sessionData == null) {
            return;
        }
        a(sessionData, Boolean.FALSE);
    }

    public static void U() {
        if (f == null || g.booleanValue()) {
            return;
        }
        g = Boolean.TRUE;
        sdk.pendo.io.network.interfaces.a.i().b(new e() { // from class: sdk.pendo.io.PendoInternal$$ExternalSyntheticLambda6
            @Override // sdk.pendo.io.q3.e
            public final void accept(Object obj) {
                PendoInternal.a((a.EnumC0439a) obj);
            }
        });
    }

    static void V() {
        x.b(false);
        x.a(false);
    }

    static synchronized void W() {
        if (a(false, "resumeGuides")) {
            return;
        }
        PendoLogger.d("Resuming guide showing.", new Object[0]);
        n.set(false);
    }

    public static void X() {
        if (!Z()) {
            PendoLogger.w("APICallIgnored", "screenContentChanged -> Session is not active and we're not in test/preview/capture mode, abort screenContentChanged");
            return;
        }
        try {
            PendoLogger.d("PendoInternal", "ScreenContentChanged API called");
            z().handleScreenChanges();
        } catch (Exception e2) {
            PendoLogger.w(e2, "PendoInternal.screenContentChanged", new Object[0]);
        }
    }

    public static void Y() {
        if (Boolean.TRUE.equals(Boolean.valueOf(!r().booleanValue()))) {
            sdk.pendo.io.s7.d.a(x(), t());
        }
    }

    public static synchronized boolean Z() {
        return q() || sdk.pendo.io.o6.a.d().g();
    }

    static void a(JWTSessionData jWTSessionData) {
        Map<String, Object> visitorData = jWTSessionData.getVisitorData();
        Map<String, Object> accountData = jWTSessionData.getAccountData();
        if (visitorData != null && !visitorData.isEmpty()) {
            z0.c(visitorData.keySet());
        }
        if (accountData == null || accountData.isEmpty()) {
            return;
        }
        z0.c(accountData.keySet());
    }

    private void a0() {
        if (sdk.pendo.io.p6.b.c() == null) {
            sdk.pendo.io.f6.a.d().e(true);
        } else {
            PendoLogger.d("session token is not null", new Object[0]);
            sdk.pendo.io.p6.b.a(false, true);
        }
    }

    protected static void b0() {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - l.longValue();
        if (jElapsedRealtime < 5000) {
            PendoLogger.w("Your last startSession call was " + (jElapsedRealtime / 1000.0d) + " seconds ago, please check if this is the desired behaviour.", new Object[0]);
        }
        l = Long.valueOf(SystemClock.elapsedRealtime());
    }

    public static synchronized boolean d() {
        return n.get();
    }

    public static synchronized void e() {
        c = AnonDataForIdentifyEvent.a(b);
        b = null;
        l0.b();
        sdk.pendo.io.w6.a.a.d().clearAndUpdateGlobalEventProperties(null);
    }

    public static void f() {
        d = null;
        if (b == null) {
            l0.b();
        }
    }

    static synchronized void g() {
        if (a(false, VisualGuideBase.DISMISS_VISIBLE_GUIDES)) {
            return;
        }
        GuidesActionsManager.getInstance().dismissVisibleGuides();
    }

    public static void h() {
        u = u || u0.b(o());
    }

    public static void i() {
        if (a(false, "endSession")) {
            sdk.pendo.io.w6.d.INSTANCE.a();
            return;
        }
        try {
            try {
                PendoLogger.uproot(sdk.pendo.io.logging.a.INSTANCE.a());
                e(false);
                f(false);
                ActivationManager.INSTANCE.setIsInitedObservable(false);
                d = a(l0.e(), l0.f(), l0.g(), l0.c());
                if (sdk.pendo.io.j6.a.d()) {
                    sdk.pendo.io.r5.b.f().a();
                } else {
                    sdk.pendo.io.s7.d.a(z().getCurrentScreenData());
                    sdk.pendo.io.s7.d.a(x(), t());
                    i.e().c();
                }
            } catch (Exception e2) {
                PendoLogger.e(e2, "End Session catch" + e2.getMessage(), new Object[0]);
            }
            sdk.pendo.io.w6.d.INSTANCE.a();
            GuidesActionsManager.getInstance().dismissVisibleGuides();
            if (z() != null) {
                z().onSessionEnd();
            }
            sdk.pendo.io.w6.a.a.c();
            GuidesManager.INSTANCE.clear();
            GuidesConfigurationManager.INSTANCE.clear();
            ActivationManager.INSTANCE.clear();
            l0.a(true);
            g gVar = z;
            if (gVar != null) {
                gVar.a();
            }
            PendoLogger.d("PendoInternal", "endSession - analytics paused");
            StepSeenManager.getInstance().reset();
            V();
            e();
        } catch (Throwable th) {
            sdk.pendo.io.w6.d.INSTANCE.a();
            throw th;
        }
    }

    public static synchronized Map<String, Object> j() {
        SessionData sessionData = b;
        if (sessionData == null) {
            return null;
        }
        return sessionData.getAccountData();
    }

    public static synchronized Map<String, Map<String, Object>> k() {
        SessionData sessionData = b;
        if (sessionData == null) {
            return null;
        }
        return sessionData.getAccountExternalData();
    }

    public static String l() {
        SessionData sessionData = b;
        return sessionData == null ? "" : sessionData.getAccountId();
    }

    public static String m() {
        if (a(false, "getAccountId")) {
            return null;
        }
        return l();
    }

    public static Application n() {
        return p;
    }

    public static Context o() {
        return a;
    }

    public static String p() {
        if (a(false, true, "getDeviceId")) {
            return null;
        }
        return AndroidUtils.g();
    }

    public static synchronized boolean q() {
        return r && !sdk.pendo.io.j6.a.d();
    }

    public static Boolean r() {
        return w.n();
    }

    public static String s() {
        SessionData sessionData = b;
        if (sessionData instanceof JWTSessionData) {
            return ((JWTSessionData) sessionData).getJwt();
        }
        return null;
    }

    public static String t() {
        SessionData sessionData = d;
        if (sessionData == null) {
            return null;
        }
        return sessionData.getAccountId();
    }

    public static String u() {
        SessionData sessionData = d;
        if (sessionData instanceof JWTSessionData) {
            return ((JWTSessionData) sessionData).getJwt();
        }
        return null;
    }

    public static SessionData v() {
        return d;
    }

    public static long w() {
        return e;
    }

    public static String x() {
        SessionData sessionData = d;
        if (sessionData == null) {
            return null;
        }
        return sessionData.getVisitorId();
    }

    public static k y() {
        return y.getScreenManagerPolicy();
    }

    public static sdk.pendo.io.x6.d z() {
        return y;
    }

    @Override // sdk.pendo.io.p5.a
    public sdk.pendo.io.x6.d b() {
        return z();
    }

    void c() {
        sdk.pendo.io.f6.a.d().a(sdk.pendo.io.w6.a.a);
        sdk.pendo.io.f6.a.d().a(this);
        sdk.pendo.io.f6.a.d().a(y);
    }

    @Override // sdk.pendo.io.f6.d
    public void onGetAccessTokenResponseReceived(GetAuthToken.GetAuthTokenResponse getAuthTokenResponse) {
        if (getAuthTokenResponse == null) {
            return;
        }
        d(getAuthTokenResponse.isIgnoringAnonymousSessions());
        String apiKey = getAuthTokenResponse.getApiKey();
        if (apiKey != null && z == null) {
            z = sdk.pendo.io.o7.d.a.a(p, apiKey, sdk.pendo.io.network.interfaces.a.g().toString(), PlatformStateManager.INSTANCE.getFramework(), this);
        } else if (apiKey == null) {
            PendoLogger.i("PendoInternal", "Api key is null, not initializing session replay");
        } else {
            PendoLogger.i("PendoInternal", "Session replay already initialized");
        }
    }

    public static SessionData a(String str, String str2, String str3, String str4) {
        if (str != null && str2 != null) {
            return new JWTSessionData(str, str2);
        }
        if (str3 == null || str4 == null) {
            return null;
        }
        return new SessionData(str4, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(Boolean bool) {
        if (z == null) {
            PendoLogger.w("sessionReplayManager is null", new Object[0]);
            return;
        }
        Activity activityA = sdk.pendo.io.d6.c.h().a();
        if (activityA != null) {
            z.a(activityA, b);
        } else {
            PendoLogger.d("PendoInternal", "SR not initialized - activity is null");
        }
    }

    private static void d(boolean z2) {
        h = Boolean.valueOf(z2);
    }

    public static synchronized void e(boolean z2) {
        r = z2;
    }

    public static void f(boolean z2) {
        q = z2;
    }

    public static SessionData g(SessionData sessionData) {
        String visitorId = sessionData.getVisitorId();
        if (v0.a(visitorId)) {
            visitorId = SessionData.retrieveAnonymousVisitorID(AndroidUtils.isGeneratedDeviceIdAfterAppInstall, AndroidUtils.g());
        } else {
            SessionData.generateAndStoreNewAnonymousVisitorID();
        }
        String str = visitorId;
        if (c == null) {
            c = AnonDataForIdentifyEvent.a(b);
        }
        SessionData sessionData2 = new SessionData(sessionData.getAccountId(), str, sessionData.getVisitorData(), sessionData.getAccountData(), false, c);
        c = null;
        return sessionData2;
    }

    public static String a(String str) {
        try {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            int length = stackTrace.length;
            for (StackTraceElement stackTraceElement : stackTrace) {
                String className = stackTraceElement.getClassName();
                if (className != null && className.equalsIgnoreCase("sdk.pendo.io.Pendo")) {
                    return stackTraceElement.getMethodName();
                }
            }
        } catch (Exception unused) {
        }
        return str;
    }

    private static void c(SessionData sessionData) {
        boolean z2 = false;
        boolean z3 = (sessionData.getVisitorData() == null || sessionData.getVisitorData().isEmpty()) ? false : true;
        if (sessionData.getAccountData() != null && !sessionData.getAccountData().isEmpty()) {
            z2 = true;
        }
        if (!z3) {
            x.b(true);
        }
        if (!z2) {
            x.a(true);
        }
        x.a(sessionData, true);
    }

    public static boolean d(String str, String str2) {
        SessionData sessionData = b;
        if (sessionData == null) {
            return false;
        }
        if ((str == null || str.isEmpty()) && sessionData.isAnonymous() && str2.equals(sessionData.getAccountId())) {
            return true;
        }
        return v0.a(sessionData.getVisitorId(), str) && v0.a(sessionData.getAccountId(), str2);
    }

    public static void e(String str, String str2) {
        if (a(true, "startSession")) {
            return;
        }
        if (!a(str, str2)) {
            PendoLogger.w("Could not start the new session. Please verify that the session's JWT is valid and that the signing keyName is correct, or start a non-JWT session using startSession(String visitorId, String accountId, Map<String,Object> visitorData, Map<String,Object> accountData) API call", new Object[0]);
            PendoPhasesCallbackInterface pendoPhasesCallbackInterface = f;
            if (pendoPhasesCallbackInterface != null) {
                pendoPhasesCallbackInterface.onInitFailed();
                return;
            }
            return;
        }
        JWTSessionData jWTSessionDataA = v.a.a(str, str2, 3);
        if (jWTSessionDataA == null) {
            PendoLogger.w("PendoInternal", "Could not start the new session. Please verify that the session's JWT is valid and that the signing keyName is correct, or start a non-JWT session using startSession(String visitorId, String accountId, Map<String,Object> visitorData, Map<String,Object> accountData) API call");
            PendoPhasesCallbackInterface pendoPhasesCallbackInterface2 = f;
            if (pendoPhasesCallbackInterface2 != null) {
                pendoPhasesCallbackInterface2.onInitFailed();
                return;
            }
            return;
        }
        if (!f(jWTSessionDataA.getVisitorId(), jWTSessionDataA.getAccountId())) {
            PendoLogger.i("PendoInternal", "startSession ignored - visitor and account unchanged. Use setVisitorData or setAccountData to update metadata.");
            return;
        }
        a(jWTSessionDataA);
        b0();
        a(jWTSessionDataA, Boolean.FALSE);
    }

    public static void f(SessionData sessionData) {
        if (b != null) {
            sdk.pendo.io.w6.a aVar = sdk.pendo.io.w6.a.a;
            synchronized (aVar.d()) {
                b.setAndMergeVisitorData(sessionData.removeDuplicatesAndTransformKeys().getVisitorData());
                aVar.d().updateVisitorGlobalEventProperties(b.getVisitorData());
            }
        }
    }

    private static synchronized void b(SessionData sessionData) {
        d(sessionData);
        b.persistData();
        c(sessionData);
    }

    static synchronized void c(boolean z2) {
        u = z2;
        b(u);
    }

    private static void d(SessionData sessionData) {
        sdk.pendo.io.w6.a aVar = sdk.pendo.io.w6.a.a;
        synchronized (aVar.d()) {
            b = sessionData.removeDuplicatesAndTransformKeys();
            aVar.d().clearAndUpdateGlobalEventProperties(b);
        }
    }

    public static void e(SessionData sessionData) {
        if (b != null) {
            sdk.pendo.io.w6.a aVar = sdk.pendo.io.w6.a.a;
            synchronized (aVar.d()) {
                b.setAndMergeAccountData(sessionData.removeDuplicatesAndTransformKeys().getAccountData());
                aVar.d().updateAccountGlobalEventProperties(b.getAccountData());
            }
        }
    }

    static boolean f(String str, String str2) {
        if (!d(str, str2)) {
            return true;
        }
        PendoLogger.d("Pendo startSession ignored - same visitorId and accountId are currently used. Please use setVisitorData and setAccountData to update visitor and account metadata.", new Object[0]);
        return false;
    }

    @Override // sdk.pendo.io.p5.a
    public VisualGuidesManagerInterface a() {
        return VisualGuidesManager.getInstance();
    }

    public static void a(SessionData sessionData, boolean z2, boolean z3) {
        if (P() && (sessionData.getVisitorId() == null || sessionData.getVisitorId().isEmpty())) {
            I();
            return;
        }
        if (z3) {
            sessionData = g(sessionData);
        }
        GuidesManager.cancelCurrentGuide();
        n.set(false);
        try {
            Log.i("PendoInternal", "SDK handleStartSession occurred");
            PendoLogger.d("Visitor Switched: visitorID = " + sessionData.getVisitorId() + ", accountID = " + sessionData.getAccountId() + ", visitorData= " + sessionData.getVisitorData() + ", accountData = " + sessionData.getAccountData(), new Object[0]);
            if (z2) {
                J();
                if (z() != null) {
                    z().onSessionEnd();
                }
                g gVar = z;
                if (gVar != null) {
                    gVar.a();
                }
            }
            e(false);
            ActivationManager.INSTANCE.setIsInitedObservable(false);
            GuidesActionsManager.getInstance().dismissVisibleGuides();
            V();
            K();
            b(sessionData);
            sdk.pendo.io.d6.c.h().l();
            sdk.pendo.io.f6.a.d().e(true);
            l0.m();
            l0.j();
            sdk.pendo.io.s7.d.b(z().getCurrentScreenData());
            i.e().c();
            w.onNext(Boolean.TRUE);
        } catch (Exception e2) {
            PendoLogger.e(e2, "handleStartSession catch" + e2.getMessage(), new Object[0]);
        }
    }

    static synchronized void b(String str, String str2) {
        a(str, str2, 2);
    }

    static synchronized void c(String str, String str2) {
        a(str, str2, 1);
    }

    public static void a(SessionData sessionData) {
        if (!(sessionData instanceof JWTSessionData)) {
            sdk.pendo.io.r5.b.f().b();
        } else {
            Y();
            i.e().c();
        }
    }

    public static synchronized void b(boolean z2) {
        if (!o.get()) {
            Log.d("PendoInternal", "setLogTree() - called before setup");
            return;
        }
        if (z2) {
            PendoLogger.plant(sdk.pendo.io.logging.b.INSTANCE.a());
        } else {
            PendoLogger.uproot(sdk.pendo.io.logging.b.INSTANCE.a());
        }
        if (sdk.pendo.io.y7.a.INSTANCE.a().a(a)) {
            sdk.pendo.io.logging.c cVarA = sdk.pendo.io.logging.c.INSTANCE.a();
            cVarA.a("PNDQaLogs.txt", a.getExternalFilesDir(null), new sdk.pendo.io.w7.b.e());
            PendoLogger.plant(cVarA);
        }
        sdk.pendo.io.network.interfaces.a.a(z2);
        Log.d("PendoInternal", "Debug logging " + z2 + ".");
    }

    public static void a(MetadataModel metadataModel) {
        if (b == null) {
            return;
        }
        if (metadataModel == null) {
            Log.d("PendoInternal", "Received null metadata");
            return;
        }
        Map<String, Map<String, Object>> visitorMetaData = metadataModel.getVisitorMetaData();
        Map<String, Map<String, Object>> accountMetaData = metadataModel.getAccountMetaData();
        if (visitorMetaData != null && !visitorMetaData.isEmpty()) {
            b.setVisitorExternalData(visitorMetaData);
        }
        if (accountMetaData == null || accountMetaData.isEmpty()) {
            return;
        }
        b.setAccountExternalData(accountMetaData);
    }

    private static void b(Pendo.PendoOptions pendoOptions) {
        sdk.pendo.io.f6.b environment = pendoOptions.getEnvironment();
        if (environment == null) {
            return;
        }
        Log.i("PendoInternal", "Using override environment: " + environment);
        sdk.pendo.io.f6.c cVarE = environment.getEndPointType();
        JsonWebTokenValidator.INSTANCE.setEnvironmentType(cVarE);
        try {
            if (cVarE != sdk.pendo.io.f6.c.DEV && cVarE != sdk.pendo.io.f6.c.STAGING) {
                return;
            }
            j0.d();
        } catch (Exception unused) {
            Log.d("PendoInternal", "Invalid environment: " + environment);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void a(final Pendo.PendoOptions pendoOptions) {
        M();
        b(pendoOptions);
        p = j;
        j = null;
        final PendoPhasesCallbackInterface pendoPhasesCallbackInterface = f;
        new Thread(new Runnable() { // from class: sdk.pendo.io.PendoInternal$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                PendoInternal.a(pendoOptions, pendoPhasesCallbackInterface);
            }
        }).start();
    }

    static synchronized void b(Map<String, Object> map) {
        PendoLogger.d("PendoInternal", "setVisitorData called, " + map);
        if (a(false, "setVisitorData")) {
            return;
        }
        SessionData sessionData = b;
        if (sessionData == null) {
            return;
        }
        if (sessionData.getIsJwtModeOn()) {
            PendoLogger.d("Pendo setVisitorData ignored - JWT mode api", new Object[0]);
            return;
        }
        if (map == null || map.isEmpty()) {
            x.b(true);
        } else {
            z0.c(map.keySet());
            SessionData sessionData2 = new SessionData();
            sessionData2.setVisitorData(map);
            x.a(sessionData2);
            f(sessionData2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void a(Pendo.PendoOptions pendoOptions, PendoPhasesCallbackInterface pendoPhasesCallbackInterface) {
        if (sdk.pendo.io.j6.a.d()) {
            p = null;
            Log.e("PendoInternal", "Pendo SDK kill switch is on");
            if (pendoPhasesCallbackInterface != null) {
                pendoPhasesCallbackInterface.onInitFailed();
            }
        } else {
            new PendoInternal(pendoOptions);
        }
    }

    static void b(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new sdk.pendo.io.y5.g("Your app key is not valid. App key is empty");
        }
        try {
            AppKeyData appKeyData = (AppKeyData) m.getValue().a().a(JsonWebTokenValidator.INSTANCE.validate(str), AppKeyData.class);
            if (appKeyData == null) {
                throw new sdk.pendo.io.y5.g("Your app key is not valid. AppKeyData is empty");
            }
            s = appKeyData.getKey();
            t = appKeyData.getDataCenter();
        } catch (Exception e2) {
            throw new sdk.pendo.io.y5.g("Your app key is not valid. Original exception: " + e2.getMessage());
        }
    }

    static boolean a(Context context) {
        try {
            context.getApplicationContext().getSharedPreferences("pnd_direct_boot_check", 0);
            return true;
        } catch (IllegalStateException unused) {
            Log.d("PendoInternal", "Device is in direct boot mode, deferring SDK initialization");
            return false;
        } catch (Exception e2) {
            Log.w("PendoInternal", "Unexpected exception in direct boot check, proceeding with init", e2);
            return true;
        }
    }

    static boolean a(String str, String str2) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(sdk.pendo.io.network.interfaces.a.EnumC0439a enumC0439a) {
        if (f != null) {
            int i2 = a.a[enumC0439a.ordinal()];
            if (i2 == 1) {
                f.onInitComplete();
            } else if (i2 != 2) {
                PendoLogger.e("PendoInternal", "Unhandled event type emitted by InitObservable with value: " + enumC0439a);
            } else {
                f.onInitFailed();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(SessionData sessionData, Boolean bool, GetAuthToken.GetAuthTokenResponse getAuthTokenResponse) {
        a(sessionData, false, bool.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(SessionData sessionData, Boolean bool, Boolean bool2) {
        a(sessionData, true, bool.booleanValue());
    }

    static synchronized void a(boolean z2) {
        if (a(false, "pauseGuides")) {
            return;
        }
        PendoLogger.d("Pausing guide showing.", new Object[0]);
        if (z2) {
            GuidesActionsManager.getInstance().dismissVisibleGuides();
        }
        n.set(true);
    }

    static void a(String str, String str2, int i2) {
        SessionData sessionData = b;
        if (sessionData == null) {
            return;
        }
        if (!sessionData.getIsJwtModeOn()) {
            PendoLogger.d("Pendo set visitor or account data for Jwt ignored - check JWT mode api", new Object[0]);
            return;
        }
        if (!a(str, str2)) {
            PendoLogger.d("Pendo jwt/signingKeyName is invalid", new Object[0]);
            return;
        }
        JWTSessionData jWTSessionDataA = v.a.a(str, str2, i2);
        if (jWTSessionDataA != null) {
            a(jWTSessionDataA);
            x.a(jWTSessionDataA);
        }
    }

    static boolean a(View view) {
        if (!Z()) {
            PendoLogger.w("APICallIgnored", "Pendo.sendClickAnalytic API - session must be active");
            return false;
        }
        if (view == null) {
            PendoLogger.w("PendoInternal", "Pendo.sendClickAnalytic API - view must not be null");
            return false;
        }
        if (!view.isClickable()) {
            PendoLogger.w("PendoInternal", "Pendo.sendClickAnalytic API - view must first be set as clickable. Please refer to the Pendo documentation");
            return false;
        }
        if (sdk.pendo.io.d8.b.b(view)) {
            PendoLogger.d("PendoInternal", "Pendo.sendClickAnalytic API - Pendo is already recognizing onTouchEvent, ignoring API");
            return true;
        }
        try {
            JSONObject jSONObjectA = b1.a.a(view);
            sdk.pendo.io.w6.a.a.a(jSONObjectA, true);
            ActivationManager.INSTANCE.handleClick(jSONObjectA, new WeakReference<>(view));
            return true;
        } catch (JSONException e2) {
            PendoLogger.w(e2, e2.getMessage(), "Could not send RAClick event for " + view);
            return false;
        }
    }

    static synchronized void a(Map<String, Object> map) {
        PendoLogger.d("PendoInternal", "setAccountData called, " + map);
        if (a(false, "setAccountData")) {
            return;
        }
        SessionData sessionData = b;
        if (sessionData == null) {
            return;
        }
        if (sessionData.getIsJwtModeOn()) {
            PendoLogger.d("Pendo setAccountData ignored - JWT mode api", new Object[0]);
            return;
        }
        if (map == null || map.isEmpty()) {
            x.a(true);
        } else {
            z0.c(map.keySet());
            SessionData sessionData2 = new SessionData();
            sessionData2.setAccountData(map);
            x.a(sessionData2);
            e(sessionData2);
        }
    }

    public static void a(long j2) {
        e = j2;
    }

    static void a(Context context, String str, Pendo.PendoOptions pendoOptions, PendoPhasesCallbackInterface pendoPhasesCallbackInterface) {
        if (o.getAndSet(true)) {
            Log.e("PendoInternal", o().getString(R.string.pnd_err_already_init));
            return;
        }
        sdk.pendo.io.w6.d.INSTANCE.d();
        try {
            if (context == null) {
                throw new m("Context can't be null, Pendo.setup failed.");
            }
            Application applicationA = AndroidUtils.a(context);
            j = applicationA;
            if (applicationA == null) {
                throw new m("Failed to extract the Application class. \"context.getApplicationContext()\" should not return null, please call Pendo.setup() in the onCreate method");
            }
            Context applicationContext = context.getApplicationContext();
            a = applicationContext;
            sdk.pendo.io.network.interfaces.a.a(applicationContext);
            k = str;
            f = pendoPhasesCallbackInterface;
            if (pendoOptions == null) {
                pendoOptions = new Pendo.PendoOptions();
            }
            sdk.pendo.io.f6.b environment = pendoOptions.getEnvironment();
            if (environment != null) {
                if (environment == sdk.pendo.io.f6.b.Automation) {
                    Log.w("PendoInternal", o().getString(R.string.pnd_automation_env_warning));
                }
                sdk.pendo.io.y7.a.INSTANCE.a().a(environment.getEndPointType());
                j0.c(environment.c());
            }
            sdk.pendo.io.u6.a.a.a(pendoOptions);
            PlatformStateManager platformStateManager = PlatformStateManager.INSTANCE;
            platformStateManager.extractFrameworkDataFromPendoOptions(pendoOptions);
            sdk.pendo.io.network.interfaces.a.a(platformStateManager.getFrameworkAsString(), platformStateManager.getFrameworkTypeAsString(), platformStateManager.getFrameworkVersion(), platformStateManager.getPluginVersion());
            y = sdk.pendo.io.x6.j.a.a(platformStateManager, pendoOptions);
            sdk.pendo.io.f6.a.c(pendoOptions.isIncludeAllGuidesContent());
            sdk.pendo.io.f6.a.d(pendoOptions.isImportInitModelFromLocalFile());
            if (AndroidUtils.d() == null) {
                throw new Exception(o().getString(R.string.pnd_empty_host_app_version_name));
            }
            sdk.pendo.io.d6.a aVarA = sdk.pendo.io.d6.a.a(pendoOptions);
            Activity activityA = sdk.pendo.io.s7.c.a(context);
            if (activityA != null) {
                aVarA.a(activityA, true);
            }
            j.registerActivityLifecycleCallbacks(aVarA);
            if (a(a)) {
                a(pendoOptions);
                return;
            }
            i = new b(pendoOptions);
            ContextCompat.registerReceiver(j, i, new IntentFilter("android.intent.action.USER_PRESENT"), 4);
        } catch (Exception e2) {
            o.set(false);
            Log.e("PendoInternal", e2.getMessage(), e2);
            PendoPhasesCallbackInterface pendoPhasesCallbackInterface2 = f;
            if (pendoPhasesCallbackInterface2 != null) {
                pendoPhasesCallbackInterface2.onInitFailed();
            }
        }
    }

    public static boolean a(boolean z2, String str) {
        return a(z2, false, str);
    }

    public static boolean a(boolean z2, boolean z3, String str) {
        if (!o.get()) {
            Log.e("APICallIgnored", a(str) + " API ignored. Make sure Pendo's Setup API has been called");
            return true;
        }
        if (sdk.pendo.io.o6.a.d().g() && !z3) {
            PendoLogger.w("APICallIgnored", a(str) + " API ignored. SDK is in capture/test/preview mode");
            return true;
        }
        if (z2 || S() || q()) {
            return false;
        }
        PendoLogger.w("APICallIgnored", a(str) + " API ignored. Make sure Pendo's StartSession API has been called");
        return true;
    }

    static void a(String str, String str2, Map<String, Object> map, Map<String, Object> map2) {
        if (a(true, "startSession")) {
            return;
        }
        if (v0.a(str2)) {
            str2 = "";
        }
        if (v0.a(str)) {
            str = "";
        }
        if (f(str, str2)) {
            if (map != null && !map.isEmpty()) {
                z0.c(map.keySet());
            }
            if (map2 != null && !map2.isEmpty()) {
                z0.c(map2.keySet());
            }
            b0();
            ActivationManager.INSTANCE.getTrackEventsBeforeSessionStart().clear();
            n.set(false);
            SessionData sessionData = new SessionData();
            sessionData.setVisitorId(str);
            sessionData.setAccountId(str2);
            sessionData.setVisitorData(map);
            sessionData.setAccountData(map2);
            a(sessionData, Boolean.TRUE);
        }
    }

    public static void a(InitModel initModel) {
        if (initModel == null || initModel.getInitConfiguration() == null) {
            PendoLogger.d("Init model configuration is null in storeSessionTimeout. Response from server is 200.", new Object[0]);
        } else {
            v = initModel.getInitConfiguration().getSessionTimeout();
        }
    }

    static void a(String str, Map<String, Object> map) {
        if (O() || TextUtils.isEmpty(str)) {
            return;
        }
        if (map != null && !map.isEmpty()) {
            z0.a((Collection<String>) map.keySet());
            z0.b((Collection<? extends Object>) map.values());
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("event", str);
            jSONObject.put("type", "track");
            w.a((Map<String, ? extends Object>) map, jSONObject2);
            jSONObject.put("properties", jSONObject2);
            jSONObject.put("sdkVersion", u0.a());
        } catch (JSONException e2) {
            String strA = y0.a(map);
            PendoLogger.e(e2, e2.getMessage(), "Could not send track event");
            PendoLogger.d(e2, e2.getMessage(), "EventName: " + str + "properties: " + strA);
        }
        sdk.pendo.io.w6.a.a.a(jSONObject);
        ActivationManager.INSTANCE.handleTrack(jSONObject);
    }

    static void a(final SessionData sessionData, final Boolean bool) {
        sdk.pendo.io.k3.g<Boolean> gVarA;
        e eVar;
        String str;
        f(true);
        if (A() == null) {
            gVarA = sdk.pendo.io.network.interfaces.a.c().f();
            eVar = new e() { // from class: sdk.pendo.io.PendoInternal$$ExternalSyntheticLambda1
                @Override // sdk.pendo.io.q3.e
                public final void accept(Object obj) {
                    PendoInternal.a(sessionData, bool, (GetAuthToken.GetAuthTokenResponse) obj);
                }
            };
            str = "Pendo verifyAccessTokenAndThenHandleStartSession access token observer";
        } else {
            gVarA = ActivationManager.INSTANCE.isInitedObservable().a(new j() { // from class: sdk.pendo.io.PendoInternal$$ExternalSyntheticLambda2
                @Override // sdk.pendo.io.q3.j
                public final boolean test(Object obj) {
                    return ((Boolean) obj).booleanValue();
                }
            }).f().a(sdk.pendo.io.i4.a.b());
            eVar = new e() { // from class: sdk.pendo.io.PendoInternal$$ExternalSyntheticLambda3
                @Override // sdk.pendo.io.q3.e
                public final void accept(Object obj) {
                    PendoInternal.a(sessionData, bool, (Boolean) obj);
                }
            };
            str = "Pendo verifyAccessTokenAndThenHandleStartSession init completed observer";
        }
        gVarA.a(c.a(eVar, str));
    }
}
