package sdk.pendo.io.o6;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import kotlin.Lazy;
import org.json.JSONException;
import org.json.JSONObject;
import sdk.pendo.io.actions.GuidePreparationManager;
import sdk.pendo.io.actions.GuidesActionsManager;
import sdk.pendo.io.actions.GuidesManager;
import sdk.pendo.io.actions.StepSeenManager;
import sdk.pendo.io.actions.VisualGuidesManager;
import sdk.pendo.io.l5.h;
import sdk.pendo.io.l5.i;
import sdk.pendo.io.l5.j;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.GuideModel;
import sdk.pendo.io.models.StepGuideModel;
import sdk.pendo.io.network.responses.validators.JsonWebTokenValidator;
import sdk.pendo.io.network.socketio.configuration.TestModeDetails;
import sdk.pendo.io.s7.k0;
import sdk.pendo.io.views.listener.FloatingListenerButton;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private static volatile a h;
    private static final Object i = new Object();
    private static sdk.pendo.io.j4.a<Boolean> j;
    private static sdk.pendo.io.j4.a<Boolean> k;
    private static sdk.pendo.io.j4.a<Boolean> l;
    private static sdk.pendo.io.j4.a<Boolean> m;
    private static sdk.pendo.io.j4.a<Boolean> n;
    private static sdk.pendo.io.j4.a<Boolean> o;
    private sdk.pendo.io.p6.a a;
    private e b;
    private sdk.pendo.io.l5.b<e> c;
    private StepGuideModel f;
    private Handler d = new Handler(Looper.getMainLooper());
    private Runnable e = null;
    private final Lazy<k0> g = sdk.pendo.io.w5.b.a(k0.class);

    /* JADX INFO: renamed from: sdk.pendo.io.o6.a$a, reason: collision with other inner class name */
    class RunnableC0445a implements Runnable {
        RunnableC0445a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PendoLogger.d("StateFSM - showing capture fail dialog", new Object[0]);
            a.this.a.a();
        }
    }

    class b implements sdk.pendo.io.m5.a<i> {
        b() {
        }

        private void b(i iVar) {
            Runnable runnable;
            try {
                a aVar = a.this;
                Handler handler = aVar.d;
                if (handler != null && (runnable = aVar.e) != null) {
                    handler.removeCallbacks(runnable);
                }
                sdk.pendo.io.x5.b progressDialog = FloatingListenerButton.getProgressDialog();
                if (progressDialog == null || progressDialog.getDialog() == null || !progressDialog.getDialog().isShowing() || iVar.a().equals(d.EVENT_CAPTURE_MODE_SCREEN_RECEIVED) || iVar.a().equals(d.EVENT_CAPTURE_MODE_SCREEN_CAPTURED)) {
                    return;
                }
                PendoLogger.d("StateFSM - dismissing dialog", new Object[0]);
                FloatingListenerButton.clearDialogFragment();
            } catch (Exception e) {
                PendoLogger.e(e, e.getMessage(), a.a(iVar));
            }
        }

        @Override // sdk.pendo.io.m5.a
        public void a(i iVar) {
            try {
                if (iVar.a().equals(d.EVENT_CAPTURE_MODE_EXIT)) {
                    a.this.u();
                }
                a.j.onNext(Boolean.FALSE);
                b(iVar);
                PendoLogger.d("StateFSM - Leaving capture mode.", new Object[0]);
            } catch (Exception e) {
                PendoLogger.e(e, e.getMessage(), a.a(iVar));
            }
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                GuidesManager.INSTANCE.showPreview();
            } catch (Exception e) {
                sdk.pendo.io.s7.d.a(sdk.pendo.io.r5.g.b.ERROR_REASON_RUN_PREVIEW_GUIDE, e.getMessage(), new Object[0]);
            }
            a.this.a(d.EVENT_PREVIEW_DISPLAYED, new Object[0]);
        }
    }

    public enum d implements sdk.pendo.io.l5.c {
        EVENT_SOCKET_CONNECTED,
        EVENT_SOCKET_DISCONNECTED,
        EVENT_PAIR_MODE_UPDATE,
        EVENT_CAPTURE_MODE_ENTER,
        EVENT_CAPTURE_MODE_EXIT,
        EVENT_CAPTURE_MODE_SCREEN_CAPTURED,
        EVENT_CAPTURE_MODE_SCREEN_RECEIVED,
        EVENT_PREVIEW_ON_DEVICE,
        EVENT_PREVIEW_DISPLAYED,
        EVENT_TEST_MODE_ENTER,
        EVENT_TEST_MODE_EXIT,
        EVENT_RESET_STATE,
        EVENT_DEBUG_MODE_ENTER,
        EVENT_DEBUG_MODE_EXIT
    }

    private static class e extends i {
        private Object i;

        private e() {
        }
    }

    public static final class f implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            runnable.run();
        }
    }

    public enum g implements h {
        STATE_NOT_PAIRED,
        STATE_PAIRED,
        STATE_CAPTURE_MODE,
        STATE_PREVIEW,
        STATE_TEST_MODE,
        STATE_DEBUG_MODE
    }

    static {
        Boolean bool = Boolean.FALSE;
        j = sdk.pendo.io.j4.a.b(bool);
        k = sdk.pendo.io.j4.a.b(bool);
        l = sdk.pendo.io.j4.a.b(bool);
        m = sdk.pendo.io.j4.a.m();
        n = sdk.pendo.io.j4.a.b(bool);
        o = sdk.pendo.io.j4.a.b(bool);
    }

    private a(sdk.pendo.io.p6.a aVar) {
        j().b(new sdk.pendo.io.q3.e() { // from class: sdk.pendo.io.o6.a$$ExternalSyntheticLambda2
            @Override // sdk.pendo.io.q3.e
            public final void accept(Object obj) {
                a.b((Boolean) obj);
            }
        });
        this.a = aVar;
        b();
        a();
        e eVar = new e();
        this.b = eVar;
        eVar.a(g.STATE_NOT_PAIRED);
        this.c.a(true, this.b);
    }

    private void a() {
        this.c.a(g.STATE_NOT_PAIRED, new sdk.pendo.io.m5.a() { // from class: sdk.pendo.io.o6.a$$ExternalSyntheticLambda4
            @Override // sdk.pendo.io.m5.a
            public final void a(i iVar) {
                a.b(iVar);
            }
        });
        this.c.a(g.STATE_PAIRED, new sdk.pendo.io.m5.a() { // from class: sdk.pendo.io.o6.a$$ExternalSyntheticLambda5
            @Override // sdk.pendo.io.m5.a
            public final void a(i iVar) {
                a.e(iVar);
            }
        });
        sdk.pendo.io.l5.b<e> bVar = this.c;
        g gVar = g.STATE_CAPTURE_MODE;
        bVar.a(gVar, new sdk.pendo.io.m5.a() { // from class: sdk.pendo.io.o6.a$$ExternalSyntheticLambda6
            @Override // sdk.pendo.io.m5.a
            public final void a(i iVar) {
                this.f$0.f(iVar);
            }
        });
        this.c.b(gVar, new b());
        sdk.pendo.io.l5.b<e> bVar2 = this.c;
        g gVar2 = g.STATE_PREVIEW;
        bVar2.a(gVar2, new sdk.pendo.io.m5.a() { // from class: sdk.pendo.io.o6.a$$ExternalSyntheticLambda7
            @Override // sdk.pendo.io.m5.a
            public final void a(i iVar) {
                this.f$0.g(iVar);
            }
        });
        this.c.b(gVar2, new sdk.pendo.io.m5.a() { // from class: sdk.pendo.io.o6.a$$ExternalSyntheticLambda8
            @Override // sdk.pendo.io.m5.a
            public final void a(i iVar) {
                a.h(iVar);
            }
        });
        sdk.pendo.io.l5.b<e> bVar3 = this.c;
        g gVar3 = g.STATE_DEBUG_MODE;
        bVar3.a(gVar3, new sdk.pendo.io.m5.a() { // from class: sdk.pendo.io.o6.a$$ExternalSyntheticLambda9
            @Override // sdk.pendo.io.m5.a
            public final void a(i iVar) {
                a.i(iVar);
            }
        });
        this.c.b(gVar3, new sdk.pendo.io.m5.a() { // from class: sdk.pendo.io.o6.a$$ExternalSyntheticLambda10
            @Override // sdk.pendo.io.m5.a
            public final void a(i iVar) {
                a.j(iVar);
            }
        });
        sdk.pendo.io.l5.b<e> bVar4 = this.c;
        g gVar4 = g.STATE_TEST_MODE;
        bVar4.a(gVar4, new sdk.pendo.io.m5.a() { // from class: sdk.pendo.io.o6.a$$ExternalSyntheticLambda11
            @Override // sdk.pendo.io.m5.a
            public final void a(i iVar) {
                this.f$0.c(iVar);
            }
        });
        this.c.b(gVar4, new sdk.pendo.io.m5.a() { // from class: sdk.pendo.io.o6.a$$ExternalSyntheticLambda1
            @Override // sdk.pendo.io.m5.a
            public final void a(i iVar) {
                this.f$0.d(iVar);
            }
        });
    }

    private void b() {
        if (this.c != null) {
            return;
        }
        sdk.pendo.io.l5.d dVarA = sdk.pendo.io.l5.d.a(g.STATE_NOT_PAIRED);
        sdk.pendo.io.l5.d.a aVarA = sdk.pendo.io.l5.d.a(d.EVENT_SOCKET_CONNECTED);
        g gVar = g.STATE_PAIRED;
        j jVarA = aVarA.a(gVar);
        sdk.pendo.io.l5.d.a aVarA2 = sdk.pendo.io.l5.d.a(d.EVENT_CAPTURE_MODE_ENTER);
        g gVar2 = g.STATE_CAPTURE_MODE;
        j jVarA2 = aVarA2.a(gVar2);
        d dVar = d.EVENT_PAIR_MODE_UPDATE;
        d dVar2 = d.EVENT_RESET_STATE;
        j[] jVarArr = {sdk.pendo.io.l5.d.a(d.EVENT_CAPTURE_MODE_EXIT).a(gVar), sdk.pendo.io.l5.d.a(dVar).a(gVar2), sdk.pendo.io.l5.d.a(d.EVENT_SOCKET_DISCONNECTED).a(gVar), sdk.pendo.io.l5.d.a(dVar2).a(gVar), sdk.pendo.io.l5.d.a(d.EVENT_CAPTURE_MODE_SCREEN_RECEIVED).a(gVar2), sdk.pendo.io.l5.d.a(d.EVENT_CAPTURE_MODE_SCREEN_CAPTURED).a(gVar2)};
        sdk.pendo.io.l5.d.a aVarA3 = sdk.pendo.io.l5.d.a(d.EVENT_PREVIEW_ON_DEVICE);
        g gVar3 = g.STATE_PREVIEW;
        j jVarA3 = aVarA3.a(gVar3);
        j[] jVarArr2 = {sdk.pendo.io.l5.d.a(d.EVENT_PREVIEW_DISPLAYED).a(gVar)};
        sdk.pendo.io.l5.d.a aVarA4 = sdk.pendo.io.l5.d.a(d.EVENT_TEST_MODE_ENTER);
        g gVar4 = g.STATE_TEST_MODE;
        this.c = dVarA.a(jVarA.a(jVarA2.a(jVarArr), jVarA3.a(jVarArr2), sdk.pendo.io.l5.d.a(dVar).a(gVar3), aVarA4.a(gVar4).a(sdk.pendo.io.l5.d.a(d.EVENT_TEST_MODE_EXIT).a(gVar), sdk.pendo.io.l5.d.a(dVar2).a(gVar)), sdk.pendo.io.l5.d.a(d.EVENT_DEBUG_MODE_ENTER).a(g.STATE_DEBUG_MODE).a(sdk.pendo.io.l5.d.a(d.EVENT_DEBUG_MODE_EXIT).a(gVar), sdk.pendo.io.l5.d.a(dVar2).a(gVar)), sdk.pendo.io.l5.d.a(dVar).a(gVar4), sdk.pendo.io.l5.d.a(dVar).a(gVar))).a(new f());
    }

    public static a d() {
        return a(new sdk.pendo.io.p6.a());
    }

    public static synchronized sdk.pendo.io.k3.j<Boolean> i() {
        return j;
    }

    public static synchronized sdk.pendo.io.k3.j<Boolean> j() {
        return n;
    }

    public static synchronized sdk.pendo.io.k3.j<Boolean> k() {
        return k;
    }

    public static synchronized sdk.pendo.io.k3.j<Boolean> l() {
        return l;
    }

    public static synchronized sdk.pendo.io.k3.j<Boolean> p() {
        return o;
    }

    public static synchronized Boolean q() {
        return Boolean.valueOf(m.p() && m.n().booleanValue());
    }

    public static synchronized sdk.pendo.io.k3.j<Boolean> r() {
        return m;
    }

    private synchronized void t() {
        sdk.pendo.io.j4.a<Boolean> aVar = k;
        Boolean bool = Boolean.FALSE;
        aVar.onNext(bool);
        j.onNext(bool);
        l.onNext(bool);
        n.onNext(bool);
        o.onNext(bool);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void u() {
        if (f() || s()) {
            GuidesActionsManager.getInstance().dismissVisibleGuides();
            StepSeenManager.getInstance().reset();
            GuidesManager.INSTANCE.activateSessionGuides();
        }
    }

    public h c() {
        return this.b.b();
    }

    public GuideModel e() {
        GuideModel guideModelGuideFactory = GuideModel.guideFactory(this.f);
        guideModelGuideFactory.setReady();
        return guideModelGuideFactory;
    }

    public boolean f() {
        return this.b.b().equals(g.STATE_CAPTURE_MODE);
    }

    public boolean g() {
        return f() || s() || o();
    }

    public boolean h() {
        return this.b.b().equals(g.STATE_DEBUG_MODE);
    }

    public boolean m() {
        return this.b.b().equals(g.STATE_NOT_PAIRED);
    }

    public boolean n() {
        return this.b.b().equals(g.STATE_PAIRED);
    }

    public boolean o() {
        return this.b.b().equals(g.STATE_PREVIEW);
    }

    public boolean s() {
        return this.b.b().equals(g.STATE_TEST_MODE);
    }

    public synchronized void v() {
        u();
        t();
        this.b.a(g.STATE_NOT_PAIRED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String a(@Nullable i iVar) {
        StringBuilder sb = new StringBuilder();
        if (iVar != null) {
            sdk.pendo.io.l5.c cVarA = iVar.a();
            if (cVarA != null) {
                sb.append("lastEvent: ").append(cVarA.name()).append("\n");
            }
            h hVarB = iVar.b();
            if (hVarB != null) {
                sb.append("state: ").append(hVarB.name());
            }
        }
        return sb.toString();
    }

    private void b(e eVar) {
        Object obj = eVar.i;
        if (obj == null) {
            return;
        }
        String string = obj.toString();
        PendoLogger.d("StateFSM - Got json from socket: " + string, new Object[0]);
        if (TextUtils.isEmpty(string)) {
            return;
        }
        TestModeDetails testModeDetails = (TestModeDetails) this.g.getValue().a().a(string, TestModeDetails.class);
        if (!a(testModeDetails)) {
            PendoLogger.i("init model is null", new Object[0]);
        } else {
            GuidesManager.INSTANCE.activateNonSessionGuide(testModeDetails.data);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(final i iVar) {
        try {
            PendoLogger.d("StateFSM - Mobile in test mode.", new Object[0]);
            if (d.EVENT_PAIR_MODE_UPDATE.equals(iVar.a())) {
                a((e) iVar);
                return;
            }
            GuidesActionsManager.getInstance().dismissVisibleGuides();
            l.onNext(Boolean.TRUE);
            try {
                VisualGuidesManager.getInstance().getIsAnyGuideDisplayedObservable().a(new sdk.pendo.io.q3.j() { // from class: sdk.pendo.io.o6.a$$ExternalSyntheticLambda0
                    @Override // sdk.pendo.io.q3.j
                    public final boolean test(Object obj) {
                        return a.a((Boolean) obj);
                    }
                }).f().a(sdk.pendo.io.t6.c.a(new sdk.pendo.io.q3.e() { // from class: sdk.pendo.io.o6.a$$ExternalSyntheticLambda3
                    @Override // sdk.pendo.io.q3.e
                    public final void accept(Object obj) {
                        this.f$0.a(iVar, (Boolean) obj);
                    }
                }, "SocketEventFSM full screen guide showing observer"));
            } catch (Exception e2) {
                sdk.pendo.io.s7.d.a(sdk.pendo.io.r5.g.b.ERROR_REASON_ENTER_TEST_MODE, e2.getMessage(), new Object[0]);
            }
        } catch (Exception e3) {
            PendoLogger.e(e3, e3.getMessage(), a(iVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(i iVar) {
        try {
            u();
            l.onNext(Boolean.FALSE);
            PendoLogger.d("StateFSM - Leaving test mode mode.", new Object[0]);
        } catch (Exception e2) {
            PendoLogger.e(e2, e2.getMessage(), a(iVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(i iVar) {
        try {
            PendoLogger.d("StateFSM - Entered Paired mode", new Object[0]);
            if (d.EVENT_PAIR_MODE_UPDATE.equals(iVar.a())) {
                PendoLogger.d("StateFSM - last event was update pair mode", new Object[0]);
            } else if (d.EVENT_TEST_MODE_EXIT.equals(iVar.a())) {
                PendoLogger.d("StateFSM - last event was test mode exit...", new Object[0]);
            } else {
                PendoLogger.d("StateFSM - Mobile is now paired", new Object[0]);
                k.onNext(Boolean.TRUE);
            }
        } catch (Exception e2) {
            PendoLogger.e(e2.getMessage(), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(i iVar) {
        Runnable runnable;
        try {
            PendoLogger.d("StateFSM - Entered capture mode.", new Object[0]);
            if (d.EVENT_CAPTURE_MODE_SCREEN_CAPTURED.equals(iVar.a())) {
                PendoLogger.d("StateFSM - last event was screen captured.", new Object[0]);
                RunnableC0445a runnableC0445a = new RunnableC0445a();
                this.e = runnableC0445a;
                this.d.postDelayed(runnableC0445a, 20000L);
                return;
            }
            if (!d.EVENT_CAPTURE_MODE_SCREEN_RECEIVED.equals(iVar.a())) {
                if (d.EVENT_PAIR_MODE_UPDATE.equals(iVar.a())) {
                    a((e) iVar);
                    return;
                } else {
                    GuidesManager.INSTANCE.activateNonSessionGuide(null);
                    j.onNext(Boolean.TRUE);
                    return;
                }
            }
            PendoLogger.d("StateFSM - last event was screen received.", new Object[0]);
            Handler handler = this.d;
            if (handler != null && (runnable = this.e) != null) {
                handler.removeCallbacks(runnable);
            }
            this.a.b();
        } catch (Exception e2) {
            PendoLogger.e(e2, e2.getMessage(), a(iVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(i iVar) {
        try {
            if (d.EVENT_PAIR_MODE_UPDATE.equals(iVar.a())) {
                a((e) iVar);
                return;
            }
            GuidesManager.INSTANCE.activateNonSessionGuide(null);
            o.onNext(Boolean.TRUE);
            PendoLogger.d("StateFSM - UI requests preview on device.", new Object[0]);
            c((e) iVar);
        } catch (Exception e2) {
            PendoLogger.e(e2, e2.getMessage(), a(iVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(i iVar) {
        PendoLogger.d("StateFSM - exiting STATE_PREVIEW", new Object[0]);
        GuidesManager.INSTANCE.activateSessionGuides();
        o.onNext(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i(i iVar) {
        PendoLogger.d("StateFSM - In Debug Mode.", new Object[0]);
        n.onNext(Boolean.TRUE);
        sdk.pendo.io.f6.a.d().e(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j(i iVar) {
        PendoLogger.d("StateFSM - Leaving Debug Mode.", new Object[0]);
        n.onNext(Boolean.FALSE);
    }

    public static a a(sdk.pendo.io.p6.a aVar) {
        a aVar2;
        a aVar3 = h;
        if (aVar3 != null) {
            return aVar3;
        }
        synchronized (i) {
            aVar2 = h;
            if (aVar2 == null) {
                aVar2 = new a(aVar);
                h = aVar2;
            }
        }
        return aVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(i iVar) {
        PendoLogger.d("StateFSM - Mobile not paired", new Object[0]);
        k.onNext(Boolean.FALSE);
    }

    private void c(e eVar) {
        String string;
        Activity activityA = sdk.pendo.io.d6.c.h().a();
        if (activityA == null) {
            PendoLogger.e("Activity is null! Not displaying preview.", new Object[0]);
            sdk.pendo.io.s7.d.a(sdk.pendo.io.r5.g.b.ERROR_REASON_RUN_PREVIEW_GUIDE, "Activity is null! Not displaying preview.", new Object[0]);
            a(d.EVENT_PREVIEW_DISPLAYED, new Object[0]);
            return;
        }
        Object obj = eVar.i;
        if (obj instanceof JSONObject) {
            try {
                string = ((JSONObject) obj).get("data").toString();
            } catch (JSONException e2) {
                PendoLogger.e(e2, e2.getMessage(), a((i) eVar));
                string = null;
            }
        } else {
            string = null;
        }
        if (string == null) {
            return;
        }
        StepGuideModel stepGuideModel = (StepGuideModel) this.g.getValue().a().a(string, StepGuideModel.class);
        this.f = stepGuideModel;
        List<String> images = new GuideModel(stepGuideModel).getImages();
        GuidePreparationManager.getInstance().prepareGuideImages(images.size(), GuideModel.PREVIEW_GUIDE_STEP_ID);
        GuidePreparationManager.getInstance().fetchImages(GuideModel.PREVIEW_GUIDE_STEP_ID, images);
        activityA.runOnUiThread(new c());
    }

    public static JSONObject a(JSONObject jSONObject) throws external.sdk.pendo.io.jose4j.jwt.consumer.c {
        String strOptString = jSONObject.optString("data");
        try {
            String strValidate = JsonWebTokenValidator.INSTANCE.validate(strOptString);
            if (strValidate == null) {
                throw new external.sdk.pendo.io.jose4j.jwt.consumer.c("Socket cannot validate data = '" + strOptString + "'.", null, null);
            }
            JSONObject jSONObject2 = new JSONObject(jSONObject.toString());
            jSONObject2.put("data", new JSONObject(strValidate));
            return jSONObject2;
        } catch (JSONException e2) {
            PendoLogger.e(e2, e2.getMessage(), new Object[0]);
            throw new external.sdk.pendo.io.jose4j.jwt.consumer.c("Something went wrong, response = '" + jSONObject + "'.", null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(Boolean bool) {
        if (bool.booleanValue()) {
            PendoLogger.plant(sdk.pendo.io.logging.e.INSTANCE.a());
        } else {
            PendoLogger.uproot(sdk.pendo.io.logging.e.INSTANCE.a());
        }
    }

    public static synchronized void c(Boolean bool) {
        m.onNext(bool);
    }

    private void a(e eVar) {
        String string = eVar.i.toString();
        if (TextUtils.isEmpty(string)) {
            return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean a(Boolean bool) {
        return !bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(i iVar, Boolean bool) {
        b((e) iVar);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x00a6 A[Catch: all -> 0x00b0, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x003e, B:8:0x0041, B:10:0x0047, B:11:0x0049, B:13:0x0051, B:14:0x007a, B:16:0x0082, B:18:0x0088, B:19:0x008e, B:20:0x00a6, B:21:0x00ae), top: B:26:0x0009, inners: #1, #2 }] */
    public boolean a(sdk.pendo.io.l5.c cVar, Object... objArr) {
        boolean zA;
        synchronized (i) {
            PendoLogger.i("Flow: " + this.c + " Current: " + c() + " Event: " + cVar, new Object[0]);
            e eVar = this.b;
            eVar.i = null;
            if (objArr == null || objArr.length <= 0) {
                zA = this.c.a(cVar, this.b);
            } else {
                Object obj = objArr[0];
                if (obj instanceof JSONObject) {
                    JSONObject jSONObject = (JSONObject) obj;
                    try {
                        try {
                            eVar.i = a(jSONObject);
                        } catch (external.sdk.pendo.io.jose4j.jwt.consumer.c unused) {
                            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
                            if (jSONObjectOptJSONObject == null || jSONObjectOptJSONObject.length() != 0) {
                                PendoLogger.e("JWT is not valid data = '" + jSONObjectOptJSONObject + "'.", new Object[0]);
                            } else {
                                this.b.i = jSONObject;
                            }
                        }
                    } catch (Exception unused2) {
                        PendoLogger.i("Invalid event: " + cVar.name() + " message: '" + objArr[0] + "'.", new Object[0]);
                    }
                    zA = this.c.a(cVar, this.b);
                } else {
                    zA = this.c.a(cVar, this.b);
                }
            }
            throw th;
        }
        return zA;
    }

    private boolean a(TestModeDetails testModeDetails) {
        return (testModeDetails == null || testModeDetails.data == null) ? false : true;
    }
}
