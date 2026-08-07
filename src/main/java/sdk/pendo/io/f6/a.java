package sdk.pendo.io.f6;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import external.sdk.pendo.io.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BooleanSupplier;
import org.json.JSONException;
import org.json.JSONObject;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.actions.ActivationManager;
import sdk.pendo.io.e2.c0;
import sdk.pendo.io.e2.e0;
import sdk.pendo.io.k3.j;
import sdk.pendo.io.k3.m;
import sdk.pendo.io.k3.n;
import sdk.pendo.io.k3.p;
import sdk.pendo.io.l4.r;
import sdk.pendo.io.l4.s;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.InitModel;
import sdk.pendo.io.models.InitModelImporter;
import sdk.pendo.io.models.JWTSessionData;
import sdk.pendo.io.models.SessionData;
import sdk.pendo.io.models.networkReponses.RegisterDeviceResponse;
import sdk.pendo.io.network.interfaces.AnalyticsData;
import sdk.pendo.io.network.interfaces.ErrorData;
import sdk.pendo.io.network.interfaces.GetAuthToken;
import sdk.pendo.io.network.interfaces.Init;
import sdk.pendo.io.network.interfaces.RegisterDevice;
import sdk.pendo.io.network.interfaces.SetupProcess;
import sdk.pendo.io.network.responses.converters.gson.PendoGsonRequestBodyConverter;
import sdk.pendo.io.network.responses.validators.JsonWebTokenValidator;
import sdk.pendo.io.s7.j0;
import sdk.pendo.io.s7.q0;
import sdk.pendo.io.s7.u0;
import sdk.pendo.io.sdk.react.PlatformStateManager;
import sdk.pendo.io.utilities.AndroidUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private static int f = 0;
    private static boolean g = false;
    private static final AtomicBoolean h = new AtomicBoolean(true);
    private static volatile a i;
    private int a = 0;
    private volatile AtomicBoolean b = new AtomicBoolean(true);
    private volatile AtomicBoolean c = new AtomicBoolean(false);
    private List<sdk.pendo.io.f6.d> d = new ArrayList();
    private sdk.pendo.io.o3.b e;

    /* JADX INFO: renamed from: sdk.pendo.io.f6.a$a, reason: collision with other inner class name */
    class C0385a implements sdk.pendo.io.q3.e<Boolean> {
        C0385a() {
        }

        @Override // sdk.pendo.io.q3.e
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Boolean bool) {
            if (sdk.pendo.io.p6.b.c() != null) {
                PendoLogger.d("session token is not null, ", new Object[0]);
                sdk.pendo.io.p6.b.a(true, true);
            } else {
                a.this.e(false);
            }
            a.this.e.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class b extends sdk.pendo.io.i6.a {
        private final JSONObject a;

        b(JSONObject jSONObject) {
            this.a = jSONObject;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(GetAuthToken.GetAuthTokenResponse getAuthTokenResponse) {
            sdk.pendo.io.s7.a aVar = sdk.pendo.io.s7.a.a;
            c0 c0VarA = aVar.a(this.a.toString());
            if (c0VarA == null) {
                return;
            }
            s sVarD = sdk.pendo.io.network.interfaces.a.d();
            if (sVarD == null) {
                PendoLogger.w("Cannot create retrofit.", new Object[0]);
                return;
            }
            r rVarB = a.this.b(((SetupProcess) sVarD.a(SetupProcess.class)).sendDebugData(c0VarA));
            if (rVarB.d()) {
                PendoLogger.i("Sent, status code: " + rVarB.b(), new Object[0]);
                return;
            }
            aVar.a(rVarB, "Response<DebugDataResultAction>");
            if (rVarB.b() == 451) {
                sdk.pendo.io.j6.a.a(rVarB.c());
            } else if (rVarB.b() == 401 && a.this.b()) {
                a.this.a(this.a);
            }
        }

        @Override // sdk.pendo.io.i6.a
        protected void execute() {
            try {
                sdk.pendo.io.network.interfaces.a.c().f().a(sdk.pendo.io.t6.c.a(new sdk.pendo.io.q3.e() { // from class: sdk.pendo.io.f6.a$b$$ExternalSyntheticLambda0
                    @Override // sdk.pendo.io.q3.e
                    public final void accept(Object obj) {
                        this.f$0.a((GetAuthToken.GetAuthTokenResponse) obj);
                    }
                }, "BackendApiManager DebugDataResultAction access token observer"));
            } catch (Exception e) {
                PendoLogger.w(e, "Exception in executing DebugDataResultAction with: %s", this.a.toString());
            }
        }
    }

    protected class c extends sdk.pendo.io.i6.a {
        private p a;

        public c(p pVar) {
            this.a = pVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(Boolean bool) {
            sdk.pendo.io.network.interfaces.a.EnumC0439a enumC0439a;
            if (a.this.c()) {
                PendoLogger.v("Execute init from backend successful", new Object[0]);
                enumC0439a = sdk.pendo.io.network.interfaces.a.EnumC0439a.SUCCESS;
            } else {
                PendoLogger.v("Execute init from backend failed", new Object[0]);
                enumC0439a = sdk.pendo.io.network.interfaces.a.EnumC0439a.FAILED;
            }
            sdk.pendo.io.network.interfaces.a.a(enumC0439a);
        }

        @Override // sdk.pendo.io.i6.a
        public void execute() {
            try {
                if (!PendoInternal.Q()) {
                    a.this.b();
                } else if (a.this.b()) {
                    sdk.pendo.io.f6.g gVar = sdk.pendo.io.f6.g.a;
                    j.a(gVar.a().a(new sdk.pendo.io.q3.j() { // from class: sdk.pendo.io.f6.a$c$$ExternalSyntheticLambda0
                        @Override // sdk.pendo.io.q3.j
                        public final boolean test(Object obj) {
                            return ((Boolean) obj).booleanValue();
                        }
                    }), gVar.b().a(new sdk.pendo.io.q3.j() { // from class: sdk.pendo.io.f6.a$c$$ExternalSyntheticLambda1
                        @Override // sdk.pendo.io.q3.j
                        public final boolean test(Object obj) {
                            return ((Boolean) obj).booleanValue();
                        }
                    }), gVar.c().a(new sdk.pendo.io.q3.j() { // from class: sdk.pendo.io.f6.a$c$$ExternalSyntheticLambda2
                        @Override // sdk.pendo.io.q3.j
                        public final boolean test(Object obj) {
                            return ((Boolean) obj).booleanValue();
                        }
                    }), new sdk.pendo.io.q3.f() { // from class: sdk.pendo.io.f6.a$c$$ExternalSyntheticLambda3
                        @Override // sdk.pendo.io.q3.f
                        public final Object a(Object obj, Object obj2, Object obj3) {
                            return a.c.a((Boolean) obj, (Boolean) obj2, (Boolean) obj3);
                        }
                    }).f().a(this.a).a(sdk.pendo.io.t6.c.a(new sdk.pendo.io.q3.e() { // from class: sdk.pendo.io.f6.a$c$$ExternalSyntheticLambda4
                        @Override // sdk.pendo.io.q3.e
                        public final void accept(Object obj) {
                            this.f$0.d((Boolean) obj);
                        }
                    }, "BackendApiManager FullBackendInitAction account data sent, user data sent, finished init actions, pending analytics sent observer"));
                }
            } catch (Exception e) {
                PendoLogger.w(e, "Exception in executing FullBackendInitAction: ", new Object[0]);
                sdk.pendo.io.network.interfaces.a.a(sdk.pendo.io.network.interfaces.a.EnumC0439a.FAILED);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Boolean a(Boolean bool, Boolean bool2, Boolean bool3) {
            return Boolean.valueOf(bool.booleanValue() && bool2.booleanValue() && bool3.booleanValue());
        }
    }

    protected class d extends sdk.pendo.io.i6.a {
        protected d() {
        }

        @Override // sdk.pendo.io.i6.a
        protected void execute() {
            a.this.b();
        }
    }

    public class e extends sdk.pendo.io.i6.a {
        private String a;
        private boolean b;
        private String c;

        e(String str, boolean z, String str2) {
            this.a = str;
            this.b = z;
            this.c = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(GetAuthToken.GetAuthTokenResponse getAuthTokenResponse) {
            a.this.a(this.a, false, this.c);
        }

        @Override // sdk.pendo.io.i6.a
        protected void execute() {
            sdk.pendo.io.r5.b bVarF;
            try {
                String str = this.a;
                if (str == null || str.isEmpty()) {
                    return;
                }
                s sVarD = sdk.pendo.io.network.interfaces.a.d();
                if (sVarD == null) {
                    PendoLogger.e("BackendAPIManager", "Analytics retrofit instantiation failed at SendAnalyticsAction");
                    bVarF = sdk.pendo.io.r5.b.f();
                } else {
                    if (TextUtils.isEmpty(this.c)) {
                        this.c = "v2/devices/analyticsData";
                    }
                    if (TextUtils.isEmpty(sdk.pendo.io.network.interfaces.a.b())) {
                        PendoLogger.d("accessToken is empty!", new Object[0]);
                        sdk.pendo.io.network.interfaces.a.c().f().a(sdk.pendo.io.t6.c.a(new sdk.pendo.io.q3.e() { // from class: sdk.pendo.io.f6.a$e$$ExternalSyntheticLambda0
                            @Override // sdk.pendo.io.q3.e
                            public final void accept(Object obj) {
                                this.f$0.a((GetAuthToken.GetAuthTokenResponse) obj);
                            }
                        }, "BackendApiManager SendAnalyticsAction access token observer"));
                        return;
                    }
                    AnalyticsData analyticsData = (AnalyticsData) sVarD.a(AnalyticsData.class);
                    sdk.pendo.io.s7.a aVar = sdk.pendo.io.s7.a.a;
                    c0 c0VarA = aVar.a("[" + this.a + "]");
                    if (c0VarA == null) {
                        PendoLogger.e("BackendAPIManager", "Failed getting requestBody at SendAnalyticsAction");
                        bVarF = sdk.pendo.io.r5.b.f();
                    } else {
                        r rVarB = a.this.b(analyticsData.send(this.c, c0VarA));
                        if (rVarB.d()) {
                            sdk.pendo.io.r5.b.f().a(true);
                            return;
                        }
                        aVar.a(rVarB, "Response<SendAnalyticsAction>");
                        if (rVarB.b() == 451) {
                            if (sdk.pendo.io.j6.a.a(rVarB.c())) {
                                return;
                            } else {
                                PendoLogger.d("Received invalid KillSwitch response. Moving to backoff.. ", new Object[0]);
                            }
                        } else if (rVarB.b() == 500) {
                            PendoLogger.d("POST Setup response is not successful (500), Moving to backoff.. ", new Object[0]);
                        } else if (this.b && (TextUtils.isEmpty(sdk.pendo.io.network.interfaces.a.b()) || rVarB.b() == 401)) {
                            String strValidate = "";
                            try {
                                try {
                                    strValidate = JsonWebTokenValidator.INSTANCE.validate(aVar.a(rVarB.c()));
                                    if (a.this.b()) {
                                        a.this.a(this.a, false, this.c);
                                        return;
                                    }
                                    return;
                                } catch (IOException e) {
                                    PendoLogger.e("BackendAPIManager", e, e.getMessage());
                                    return;
                                }
                            } catch (external.sdk.pendo.io.jose4j.jwt.consumer.c e2) {
                                sdk.pendo.io.s7.d.a(strValidate, "Analytics", e2.getMessage());
                                return;
                            }
                        }
                        bVarF = sdk.pendo.io.r5.b.f();
                    }
                }
                bVarF.a(false);
            } catch (Exception e3) {
                PendoLogger.w(e3, "Exception in executing SendAnalyticsAction", new Object[0]);
            }
        }
    }

    public class f extends sdk.pendo.io.i6.a {
        private final String a;
        private final boolean b;
        private final JWTSessionData c;
        private String d;

        f(JWTSessionData jWTSessionData, String str, boolean z, String str2) {
            this.a = str;
            this.b = z;
            this.d = str2;
            this.c = jWTSessionData;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(GetAuthToken.GetAuthTokenResponse getAuthTokenResponse) {
            a.this.a(this.c, this.a, false, this.d);
        }

        @Override // sdk.pendo.io.i6.a
        protected void execute() {
            try {
                if (TextUtils.isEmpty(this.a)) {
                    return;
                }
                s sVarD = sdk.pendo.io.network.interfaces.a.d();
                if (sVarD == null) {
                    PendoLogger.e("SendAnalyticsForPreviousVisitorAction", "Analytics retrofit instantiation failed at SendAnalyticsForPreviousVisitorAction");
                    return;
                }
                if (TextUtils.isEmpty(this.d)) {
                    this.d = "v2/devices/analyticsData";
                }
                if (TextUtils.isEmpty(sdk.pendo.io.network.interfaces.a.b())) {
                    PendoLogger.d("accessToken is empty!", new Object[0]);
                    sdk.pendo.io.network.interfaces.a.c().f().a(sdk.pendo.io.t6.c.a(new sdk.pendo.io.q3.e() { // from class: sdk.pendo.io.f6.a$f$$ExternalSyntheticLambda0
                        @Override // sdk.pendo.io.q3.e
                        public final void accept(Object obj) {
                            this.f$0.a((GetAuthToken.GetAuthTokenResponse) obj);
                        }
                    }, "SendAnalyticsForPreviousVisitorAction BackendApiManager access token observer"));
                    return;
                }
                AnalyticsData analyticsData = (AnalyticsData) sVarD.a(AnalyticsData.class);
                sdk.pendo.io.s7.a aVar = sdk.pendo.io.s7.a.a;
                c0 c0VarA = aVar.a("[" + this.a + "]");
                if (c0VarA == null) {
                    PendoLogger.e("SendAnalyticsForPreviousVisitorAction", "Failed getting requestBody at SendAnalyticsForPreviousVisitorAction");
                    return;
                }
                r rVarB = a.this.b(analyticsData.send(this.d, c0VarA, this.c.getJwt(), this.c.getSigningKeyName()));
                if (rVarB.d()) {
                    return;
                }
                aVar.a(rVarB, "Response<SendAnalyticsForPreviousVisitorAction>");
                if (rVarB.b() == 451) {
                    if (sdk.pendo.io.j6.a.a(rVarB.c())) {
                        return;
                    }
                    PendoLogger.d("SendAnalyticsForPreviousVisitorAction Received invalid KillSwitch response.", new Object[0]);
                    return;
                }
                if (this.b) {
                    if (TextUtils.isEmpty(sdk.pendo.io.network.interfaces.a.b()) || rVarB.b() == 401) {
                        String strValidate = "";
                        try {
                            try {
                                strValidate = JsonWebTokenValidator.INSTANCE.validate(aVar.a(rVarB.c()));
                                if (a.this.b()) {
                                    a.this.a(this.c, this.a, false, this.d);
                                }
                            } catch (IOException e) {
                                PendoLogger.e("SendAnalyticsForPreviousVisitorAction", e, e.getMessage());
                            }
                        } catch (external.sdk.pendo.io.jose4j.jwt.consumer.c e2) {
                            sdk.pendo.io.s7.d.a(strValidate, "Analytics", e2.getMessage());
                        }
                    }
                }
            } catch (Exception e3) {
                PendoLogger.w(e3, "Exception in executing SendAnalyticsAction", new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class g extends sdk.pendo.io.i6.a {
        private String a;

        g(String str) {
            this.a = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(GetAuthToken.GetAuthTokenResponse getAuthTokenResponse) {
            a.this.a(this.a);
        }

        @Override // sdk.pendo.io.i6.a
        protected void execute() {
            if (TextUtils.isEmpty(sdk.pendo.io.network.interfaces.a.b())) {
                sdk.pendo.io.network.interfaces.a.c().f().a(sdk.pendo.io.t6.c.a(new sdk.pendo.io.q3.e() { // from class: sdk.pendo.io.f6.a$g$$ExternalSyntheticLambda0
                    @Override // sdk.pendo.io.q3.e
                    public final void accept(Object obj) {
                        this.f$0.a((GetAuthToken.GetAuthTokenResponse) obj);
                    }
                }, "BackendApiManager SendErrorReportAction access token observer"));
            } else {
                a.this.a(this.a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class h extends sdk.pendo.io.i6.a {
        private final c0 a;
        private final boolean b;
        private final boolean c;
        private SessionData d;

        h(SessionData sessionData, c0 c0Var, boolean z, boolean z2) {
            this.a = c0Var;
            this.b = z;
            this.c = z2;
            this.d = sessionData;
        }

        protected void a(r<e0> rVar) {
            if (!PendoInternal.S()) {
                PendoLogger.d("BackendAPIManager", "SetupResultAction response ignored - session has already ended");
                return;
            }
            int iB = rVar.b();
            if (rVar.d()) {
                PendoLogger.i("BE setup has been sent and finished - status code: " + iB, new Object[0]);
                if (this.b) {
                    sdk.pendo.io.f6.g.a.a(true);
                }
                if (this.c) {
                    sdk.pendo.io.f6.g.a.b(true);
                }
                a();
                PendoInternal.e(true);
                ActivationManager.INSTANCE.setIsInitedObservable(true);
                return;
            }
            sdk.pendo.io.s7.a.a.a(rVar, "Response<SendSetupResultAction>");
            if (iB == 451) {
                if (sdk.pendo.io.j6.a.a(rVar.c())) {
                    return;
                }
                PendoLogger.d("Received invalid KillSwitch response. Will carry on.. ", new Object[0]);
                a.this.h();
                return;
            }
            if (iB == 401) {
                if (a.this.b()) {
                    a.this.a(this.d, this.a, this.b, this.c);
                }
            } else if (iB == 403) {
                PendoLogger.d("Start session failure. Confirm the signing key name passed is the name of the key used to sign the token.", new Object[0]);
                PendoInternal.i();
            } else if (iB == 406) {
                PendoLogger.d("Updating session info failed. JWT verification failed. Confirm the signing key name passed is the name of the key used to sign the token.\nThe session will continue without changes to the visitor or account data", new Object[0]);
            } else {
                PendoLogger.d("POST Setup response is not successful (network error), will proceed to init, nonetheless..", new Object[0]);
                a.this.h();
            }
        }

        @Override // sdk.pendo.io.i6.a
        protected void execute() {
            try {
                sdk.pendo.io.network.interfaces.a.c().f().a(sdk.pendo.io.t6.c.a(new sdk.pendo.io.q3.e() { // from class: sdk.pendo.io.f6.a$h$$ExternalSyntheticLambda0
                    @Override // sdk.pendo.io.q3.e
                    public final void accept(Object obj) {
                        this.f$0.a((GetAuthToken.GetAuthTokenResponse) obj);
                    }
                }, "BackendApiManager SendSetupResultAction access token observer"));
            } catch (Exception e) {
                PendoLogger.w(e, "Exception in executing SendSetupResultAction", new Object[0]);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(GetAuthToken.GetAuthTokenResponse getAuthTokenResponse) {
            s.b bVarQ = sdk.pendo.io.network.interfaces.a.q();
            if (bVarQ == null) {
                PendoLogger.w("Cannot create a retrofit builder.", new Object[0]);
            } else {
                a(a.this.b(((SetupProcess) bVarQ.a().a(SetupProcess.class)).send(this.a)));
            }
        }

        private void a() {
            if (PendoInternal.R()) {
                boolean zEquals = PendoInternal.G().equals("");
                boolean zEquals2 = PendoInternal.G().equals(this.d.getVisitorId());
                boolean zEquals3 = PendoInternal.l().equals(this.d.getAccountId());
                if (this.c && (zEquals || zEquals2)) {
                    PendoInternal.f(this.d);
                }
                if (this.b) {
                    if (zEquals || zEquals3) {
                        PendoInternal.e(this.d);
                    }
                }
            }
        }
    }

    private a() {
        PendoLogger.d("CTOR backendapimanager", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> r<T> b(j<r<T>> jVar) {
        return jVar.d(new sdk.pendo.io.q3.h() { // from class: sdk.pendo.io.f6.a$$ExternalSyntheticLambda3
            @Override // sdk.pendo.io.q3.h
            public final Object apply(Object obj) {
                return a.a((Throwable) obj);
            }
        }).b(sdk.pendo.io.i4.a.b()).b();
    }

    public static synchronized a d() {
        if (i == null) {
            i = new a();
        }
        return i;
    }

    private <T> n<r<T>, r<T>> e() {
        return new n() { // from class: sdk.pendo.io.f6.a$$ExternalSyntheticLambda1
            @Override // sdk.pendo.io.k3.n
            public final m a(j jVar) {
                return a.c(jVar);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean g() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        sdk.pendo.io.f6.g gVar = sdk.pendo.io.f6.g.a;
        gVar.a(true);
        gVar.b(true);
    }

    private void j() {
        if (h.getAndSet(false)) {
            q0.a(new c(sdk.pendo.io.i4.a.b()));
        } else {
            PendoLogger.d("Test - Tried to init again.", new Object[0]);
        }
    }

    public void a(sdk.pendo.io.f6.d dVar) {
        this.d.add(dVar);
    }

    protected boolean c() {
        Init init;
        PendoLogger.i("Initializing SDK against the backend.", new Object[0]);
        try {
            s sVarN = sdk.pendo.io.network.interfaces.a.n();
            if (sVarN == null || (init = (Init) sVarN.a(Init.class)) == null) {
                return false;
            }
            return b(a(init.initSdk(f)));
        } catch (Exception e2) {
            PendoLogger.e("BackendAPIManager", e2, e2.getMessage());
            return false;
        }
    }

    public boolean f() {
        return this.b.get();
    }

    public void i() {
        q0.a(new d());
    }

    private boolean c(r<GetAuthToken.GetAuthTokenResponse> rVar) {
        try {
            GetAuthToken.GetAuthTokenResponse getAuthTokenResponse = (GetAuthToken.GetAuthTokenResponse) new Gson().a(JsonWebTokenValidator.INSTANCE.validate(sdk.pendo.io.s7.a.a.a(rVar.c())), GetAuthToken.GetAuthTokenResponse.class);
            if (getAuthTokenResponse == null) {
                PendoLogger.w("BackendAPIManagerError redirecting, redirectionToken is null", new Object[0]);
                return false;
            }
            if (getAuthTokenResponse.getRedirectionDatacenter() != null) {
                j0.a(getAuthTokenResponse.getRedirectionDatacenter(), true);
            } else if (getAuthTokenResponse.getRedirectionHost() != null) {
                j0.b(getAuthTokenResponse.getRedirectionHost(), true);
            } else {
                PendoLogger.w("BackendAPIManagerhandleRedirection, Error redirecting, both datacenter and host are null", new Object[0]);
            }
            sdk.pendo.io.network.interfaces.a.a();
            sdk.pendo.io.network.interfaces.a.a(Boolean.TRUE);
            sdk.pendo.io.network.interfaces.a.a(getAuthTokenResponse.getRedirectionKey());
            return true;
        } catch (Exception e2) {
            PendoLogger.e(e2, "BackendAPIManagerError redirecting, " + e2.getMessage(), new Object[0]);
            return false;
        }
    }

    private boolean d(r<RegisterDeviceResponse> rVar) {
        boolean zD = rVar.d();
        if (zD) {
            PendoLogger.d("Registered the device, got id: " + rVar.a().getId(), new Object[0]);
            b(true);
            return b();
        }
        sdk.pendo.io.s7.a.a.a(rVar, "Response<RegisterDeviceResponse>");
        if (rVar.b() == 451) {
            zD = sdk.pendo.io.j6.a.a().a(rVar.c(), new BooleanSupplier() { // from class: sdk.pendo.io.f6.a$$ExternalSyntheticLambda4
                @Override // java.util.function.BooleanSupplier
                public final boolean getAsBoolean() {
                    return this.f$0.a();
                }
            });
        }
        if (!zD) {
            a(false);
            b(false);
        }
        return zD;
    }

    protected <T> r<T> a(j<r<T>> jVar) {
        return (r) jVar.a(e()).b();
    }

    protected boolean b() {
        boolean zA = false;
        try {
            PendoLogger.i("Init against the backend.", new Object[0]);
            s sVarM = sdk.pendo.io.network.interfaces.a.m();
            if (sVarM != null) {
                zA = a(a(((GetAuthToken) sVarM.a(GetAuthToken.class)).getAccessTokenSigned()));
            }
        } catch (Exception e2) {
            PendoLogger.w(e2, "exception in executeGetAuthToken", new Object[0]);
        }
        if (!zA) {
            sdk.pendo.io.network.interfaces.a.a(sdk.pendo.io.network.interfaces.a.EnumC0439a.FAILED);
        }
        return zA;
    }

    public void e(boolean z) {
        if (z) {
            h.set(true);
        }
        if (sdk.pendo.io.s7.j.a()) {
            j();
        } else {
            this.e = sdk.pendo.io.s7.j.a(new C0385a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a() {
        s sVarP;
        JSONObject jSONObject = new JSONObject();
        if (PendoInternal.o() != null) {
            sdk.pendo.io.a6.b.INSTANCE.a().a(jSONObject);
            try {
                c0 c0VarA = sdk.pendo.io.s7.a.a.a(jSONObject.getJSONObject("device_info").toString());
                if (c0VarA == null || (sVarP = sdk.pendo.io.network.interfaces.a.p()) == null) {
                    return false;
                }
                return d(a(((RegisterDevice) sVarP.a(RegisterDevice.class)).registerDevice(c0VarA)));
            } catch (Exception e2) {
                PendoLogger.e(e2, "BackendAPIManager", e2.getMessage());
            }
        } else {
            PendoLogger.e("Application context is null.", new Object[0]);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ m c(j jVar) {
        return jVar.e(new sdk.pendo.io.s6.a(3, 3000)).d(new sdk.pendo.io.q3.h() { // from class: sdk.pendo.io.f6.a$$ExternalSyntheticLambda6
            @Override // sdk.pendo.io.q3.h
            public final Object apply(Object obj) {
                return a.b((Throwable) obj);
            }
        }).b(sdk.pendo.io.i4.a.b());
    }

    public static void d(boolean z) {
        g = z;
    }

    protected boolean b(r<InitModel> rVar) {
        boolean z = false;
        if (!PendoInternal.S()) {
            PendoLogger.d("BackendAPIManager", "handleInitResponse ignored - session has already ended");
            return false;
        }
        boolean zD = rVar.d();
        if (!zD) {
            sdk.pendo.io.s7.a.a.a(rVar, "Response<InitModel>");
            if (rVar.b() == 451) {
                return sdk.pendo.io.j6.a.a().a(rVar.c(), new BooleanSupplier() { // from class: sdk.pendo.io.f6.a$$ExternalSyntheticLambda0
                    @Override // java.util.function.BooleanSupplier
                    public final boolean getAsBoolean() {
                        return this.f$0.c();
                    }
                });
            }
            return (rVar.b() == 401 && b()) ? c() : zD;
        }
        InitModel initModelA = rVar.a();
        if (g) {
            initModelA = new InitModelImporter().getInitModelFromJSONAssetFile();
        }
        if (initModelA == null) {
            PendoLogger.e("handleInitResponse: body is null", new Object[0]);
        } else if (PendoInternal.a(false, "startSession")) {
            PendoLogger.w("BackendAPIManager", "startSession API was not properly called - please exit test/preview/capture mode and start the app again.");
        } else {
            PendoInternal.a(initModelA);
            initModelA.init();
            z = zD;
        }
        try {
            PendoLogger.d("BackendAPIManager", "InitModel JSON: " + new Gson().a(initModelA));
        } catch (Exception e2) {
            PendoLogger.i("BackendAPIManager", "Failed to convert InitModel to JSON: " + e2.getMessage());
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        try {
            if (f()) {
                s sVarD = sdk.pendo.io.network.interfaces.a.d();
                if (sVarD == null) {
                    PendoLogger.d("Cannot get analytics retrofit.", new Object[0]);
                    return;
                }
                ErrorData errorData = (ErrorData) sVarD.a(ErrorData.class);
                c0 c0VarA = sdk.pendo.io.s7.a.a.a(str);
                if (c0VarA == null) {
                    return;
                }
                a(a(errorData.send(c0VarA)), str);
            }
        } catch (Exception e2) {
            PendoLogger.w(e2, "Exception in executing executeErrorReport with: %s", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ r b(Throwable th) {
        return r.a(InputDeviceCompat.SOURCE_DPAD, e0.a("{error: \"Server is not available?\"}", PendoGsonRequestBodyConverter.JSON_MEDIA_TYPE));
    }

    public static void c(boolean z) {
        f = z ? 1 : 0;
    }

    void a(r<e0> rVar, String str) {
        if (rVar == null) {
            PendoLogger.d("Response is null. Cannot send error.", new Object[0]);
            return;
        }
        if (rVar.d()) {
            sdk.pendo.io.y5.a.a(PendoInternal.o());
            return;
        }
        sdk.pendo.io.s7.a.a.a(rVar, "Response<SendErrorResponseAction>");
        if (rVar.b() == 451) {
            sdk.pendo.io.j6.a.a().a(rVar.c(), new BooleanSupplier() { // from class: sdk.pendo.io.f6.a$$ExternalSyntheticLambda7
                @Override // java.util.function.BooleanSupplier
                public final boolean getAsBoolean() {
                    return a.g();
                }
            });
        }
    }

    public void b(final String str) {
        if (sdk.pendo.io.j6.a.d() || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            sdk.pendo.io.network.interfaces.a.c().f().a(sdk.pendo.io.t6.c.a(new sdk.pendo.io.q3.e() { // from class: sdk.pendo.io.f6.a$$ExternalSyntheticLambda5
                @Override // sdk.pendo.io.q3.e
                public final void accept(Object obj) {
                    this.f$0.a(str, (GetAuthToken.GetAuthTokenResponse) obj);
                }
            }, "BackendApiManager sendErrorReport access token observer"));
        } catch (Exception e2) {
            PendoLogger.w(e2, "Cannot get access token, not sending '" + str + "'.", new Object[0]);
        }
    }

    private void b(boolean z) {
        this.c.set(z);
    }

    protected boolean a(r<GetAuthToken.GetAuthTokenResponse> rVar) {
        boolean zA;
        boolean z = false;
        if (rVar == null) {
            a(false);
            b(false);
            return false;
        }
        if (rVar.b() == 301) {
            int i2 = this.a + 1;
            this.a = i2;
            if (i2 > 3) {
                PendoLogger.w("BackendAPIManagerhandleGetAccessTokenResponse tried executing more than 3redirections.", new Object[0]);
                return false;
            }
            if (c(rVar)) {
                return b();
            }
            return false;
        }
        this.a = 0;
        GetAuthToken.GetAuthTokenResponse getAuthTokenResponseA = rVar.a();
        if (!rVar.d() || getAuthTokenResponseA == null) {
            try {
                int iB = rVar.b();
                sdk.pendo.io.s7.a.a.a(rVar, "Response<GetAuthToken.GetAuthTokenResponse>");
                if (iB == 451) {
                    zA = sdk.pendo.io.j6.a.a().a(rVar.c(), new BooleanSupplier() { // from class: sdk.pendo.io.f6.a$$ExternalSyntheticLambda2
                        @Override // java.util.function.BooleanSupplier
                        public final boolean getAsBoolean() {
                            return this.f$0.b();
                        }
                    });
                } else if (iB == 401) {
                    zA = a();
                }
                z = zA;
            } catch (Exception e2) {
                PendoLogger.e("BackendAPIManager", e2, e2.getMessage());
            }
        } else {
            String str = getAuthTokenResponseA.accessToken;
            SessionData.INSTANCE.onGetAccessTokenResponseReceived(getAuthTokenResponseA);
            a(rVar.a());
            sdk.pendo.io.network.interfaces.a.a(getAuthTokenResponseA);
            z = !TextUtils.isEmpty(str);
            String pluginVersion = PlatformStateManager.INSTANCE.getPluginVersion();
            String str2 = "Pendo Mobile SDK was successfully integrated and connected to the server. Start a session to track user interactions and trigger guides. App version identified: '" + AndroidUtils.d() + "', SDK version identified: '" + u0.a();
            if (pluginVersion != null) {
                str2 = str2 + ", Plugin version identified: '" + pluginVersion;
            }
            Log.i("BackendAPIManager", str2 + "'.");
        }
        a(z);
        b(z);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ r a(Throwable th) {
        return r.a(InputDeviceCompat.SOURCE_DPAD, e0.a(PendoGsonRequestBodyConverter.JSON_MEDIA_TYPE, "{error: \"Server is not available?\"}"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, GetAuthToken.GetAuthTokenResponse getAuthTokenResponse) {
        q0.a(new g(str));
    }

    private void a(GetAuthToken.GetAuthTokenResponse getAuthTokenResponse) {
        try {
            Iterator<sdk.pendo.io.f6.d> it = this.d.iterator();
            while (it.hasNext()) {
                it.next().onGetAccessTokenResponseReceived(getAuthTokenResponse);
            }
        } catch (Exception e2) {
            PendoLogger.i(e2, "error in notifyGetAccessTokenResponseListeners: ", new Object[0]);
        }
    }

    public void a(String str, boolean z, String str2) {
        if (sdk.pendo.io.j6.a.d()) {
            return;
        }
        q0.a(new e(str, z, str2));
    }

    public void a(JWTSessionData jWTSessionData, String str, boolean z, String str2) {
        if (sdk.pendo.io.j6.a.d()) {
            return;
        }
        q0.a(new f(jWTSessionData, str, z, str2));
    }

    public void a(JSONObject jSONObject) {
        if (sdk.pendo.io.j6.a.d()) {
            return;
        }
        q0.a(new b(jSONObject));
    }

    public void a(SessionData sessionData, JSONObject jSONObject, boolean z, boolean z2) {
        if (sdk.pendo.io.j6.a.d()) {
            return;
        }
        try {
            jSONObject.put("device_time", System.currentTimeMillis());
        } catch (JSONException e2) {
            PendoLogger.e("BackendAPIManager", e2, e2.getMessage());
        }
        c0 c0VarA = sdk.pendo.io.s7.a.a.a(jSONObject.toString());
        if (c0VarA != null) {
            a(sessionData, c0VarA, z, z2);
        } else {
            PendoLogger.e("BackendAPIManager", "Failed getting requestBody at sendSetupResult, json used: " + jSONObject, (Throwable) null);
        }
    }

    void a(SessionData sessionData, c0 c0Var, boolean z, boolean z2) {
        if (sdk.pendo.io.j6.a.d()) {
            return;
        }
        q0.a(new h(sessionData, c0Var, z, z2));
    }

    private void a(boolean z) {
        this.b.set(z);
    }
}
