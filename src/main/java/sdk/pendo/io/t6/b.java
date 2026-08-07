package sdk.pendo.io.t6;

import android.app.Activity;
import java.util.concurrent.TimeUnit;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.actions.ActivationManager;
import sdk.pendo.io.activities.PendoGateActivity;
import sdk.pendo.io.activities.PendoGuideVisualActivity;
import sdk.pendo.io.k3.j;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.q3.g;
import sdk.pendo.io.s7.r;
import sdk.pendo.io.views.listener.FloatingListenerButton;

/* JADX INFO: loaded from: classes5.dex */
public final class b {
    private static final Object g = new Object();
    private static final Long h = 10L;
    private sdk.pendo.io.o3.b a;
    private sdk.pendo.io.o3.b b;
    private sdk.pendo.io.o3.b c;
    private sdk.pendo.io.o3.b d;
    private sdk.pendo.io.o3.b e;
    private j<Boolean> f;

    class a implements g<Boolean, Boolean, Boolean, Boolean, Boolean> {
        a() {
        }

        @Override // sdk.pendo.io.q3.g
        public Boolean a(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4) {
            return Boolean.valueOf(bool.booleanValue() || bool2.booleanValue() || bool3.booleanValue() || bool4.booleanValue());
        }
    }

    /* JADX INFO: renamed from: sdk.pendo.io.t6.b$b, reason: collision with other inner class name */
    class C0491b implements sdk.pendo.io.q3.b<sdk.pendo.io.t4.a, Boolean, Boolean> {
        C0491b() {
        }

        @Override // sdk.pendo.io.q3.b
        public Boolean a(sdk.pendo.io.t4.a aVar, Boolean bool) {
            return bool;
        }
    }

    private static class c implements sdk.pendo.io.q3.e<Object> {
        private c() {
        }

        @Override // sdk.pendo.io.q3.e
        public void accept(Object obj) {
            Activity activityA = sdk.pendo.io.d6.c.h().a();
            if (activityA == null || (activityA instanceof PendoGuideVisualActivity)) {
                return;
            }
            PendoInternal.z().onActivityPaused(activityA);
            FloatingListenerButton.Builder.removeActiveInstances();
        }
    }

    private static class d implements sdk.pendo.io.q3.e<Boolean> {
        private d() {
        }

        @Override // sdk.pendo.io.q3.e
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Boolean bool) {
            if (sdk.pendo.io.j6.a.d()) {
                return;
            }
            Activity activityA = sdk.pendo.io.d6.c.h().a();
            if (activityA == null) {
                PendoLogger.d("InsertActivityOnResumeAndEventsManagerInitedAction received null activity", new Object[0]);
                return;
            }
            PendoLogger.d("PendoApplicationObservers -> activity resumed and SDK ready to scan a screen: " + bool, new Object[0]);
            if (bool.booleanValue()) {
                if ((activityA instanceof PendoGateActivity) || (activityA instanceof PendoGuideVisualActivity)) {
                    PendoLogger.i(activityA.getClass().getSimpleName() + " started.", new Object[0]);
                } else if (sdk.pendo.io.f6.a.d().f()) {
                    PendoInternal.z().onActivityResumed(activityA);
                }
            }
        }
    }

    private static class e implements sdk.pendo.io.q3.e<Object> {
        private e() {
        }

        @Override // sdk.pendo.io.q3.e
        public void accept(Object obj) {
            Activity activityA = sdk.pendo.io.d6.c.h().a();
            if (activityA == null || r.a(activityA.getLocalClassName())) {
                return;
            }
            FloatingListenerButton.Builder.removeActiveInstances();
            if (sdk.pendo.io.p6.b.c() == null || sdk.pendo.io.o6.a.d().m()) {
                return;
            }
            new FloatingListenerButton.Builder().create();
        }
    }

    private static class f implements sdk.pendo.io.q3.e<Object> {
        private f() {
        }

        @Override // sdk.pendo.io.q3.e
        public void accept(Object obj) {
            Activity activityI = sdk.pendo.io.d6.c.h().i();
            if (activityI == null || (activityI instanceof PendoGuideVisualActivity)) {
                return;
            }
            PendoInternal.z().onActivityDestroyed(activityI);
        }
    }

    public b(j<sdk.pendo.io.t4.a> jVar, j<sdk.pendo.io.t4.a> jVar2, j<sdk.pendo.io.t4.a> jVar3) {
        j<Boolean> jVarI = sdk.pendo.io.o6.a.i();
        j<Boolean> jVarL = sdk.pendo.io.o6.a.l();
        j<Boolean> jVarP = sdk.pendo.io.o6.a.p();
        ActivationManager activationManager = ActivationManager.INSTANCE;
        j jVarA = j.a(jVarI, jVarL, jVarP, activationManager.isInitedObservable(), new a());
        long jLongValue = h.longValue();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        j<Boolean> jVarA2 = jVarA.a(jLongValue, timeUnit);
        this.f = jVarA2;
        this.b = (sdk.pendo.io.o3.b) j.a(jVar, jVarA2, new C0491b()).a(sdk.pendo.io.i4.a.b()).c(sdk.pendo.io.t6.d.a(new d(), "PendoApplicationObservers onResumeObservable and ActivationManagerInitedObservable observer"));
        this.c = (sdk.pendo.io.o3.b) jVar2.c(sdk.pendo.io.t6.d.a(new c(), "PendoApplicationObservers activityOnPauseObservable"));
        this.d = (sdk.pendo.io.o3.b) jVar3.c(sdk.pendo.io.t6.d.a(new f(), "PendoApplicationObservers activityOnDestroyObservable"));
        this.e = (sdk.pendo.io.o3.b) j.a(jVar, sdk.pendo.io.o6.a.k(), sdk.pendo.io.o6.a.l(), sdk.pendo.io.o6.a.i(), sdk.pendo.io.o6.a.r(), sdk.pendo.io.o6.a.j(), activationManager.isInitedObservable()).c(500L, timeUnit).c(sdk.pendo.io.t6.d.a(new e(), "PendoApplicationObservers merged activityOnResume, isInPairedMode, isInTestMode, isInCaptureMode, isSocketConnected, isActivationManagerInited observer"));
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean a(Object obj) {
        return ActivationManager.INSTANCE.isInited();
    }

    public void a() {
        sdk.pendo.io.o3.b bVar = this.a;
        if (bVar != null && !bVar.isDisposed()) {
            this.a.dispose();
        }
        this.a = (sdk.pendo.io.o3.b) j.a(sdk.pendo.io.w6.b.e().c(), ActivationManager.INSTANCE.isInitedObservable()).a(new sdk.pendo.io.q3.j() { // from class: sdk.pendo.io.t6.b$$ExternalSyntheticLambda0
            @Override // sdk.pendo.io.q3.j
            public final boolean test(Object obj) {
                return b.a(obj);
            }
        }).c(sdk.pendo.io.t6.d.a(new sdk.pendo.io.t6.a(), "PendoApplicationObservers ActivationManagerInited and getAppFlowChanges observer"));
    }
}
