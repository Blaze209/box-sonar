package sdk.pendo.io.d6;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import sdk.pendo.io.Pendo;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.activities.PendoGateActivity;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.s7.j;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements Application.ActivityLifecycleCallbacks {
    private static volatile a a;
    private static final AtomicInteger b = new AtomicInteger(0);
    private static final AtomicBoolean c = new AtomicBoolean(false);
    private static volatile Boolean d = Boolean.FALSE;

    private a() {
    }

    public static synchronized a a(Pendo.PendoOptions pendoOptions) {
        if (a == null) {
            a = new a();
            d = Boolean.valueOf(pendoOptions.getEnableAutoSessionEndDetection());
        }
        return a;
    }

    boolean b(Activity activity) {
        try {
            if (sdk.pendo.io.s7.c.a() && activity.isInPictureInPictureMode()) {
                return a(activity);
            }
            return true;
        } catch (Exception e) {
            PendoLogger.d("ActivityLifeCycleListener shouldHandleActivityLifecycleEvent exception: " + e, new Object[0]);
            return true;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        PendoLogger.i("ActivityLifeCycleListener onActivityCreated " + activity.getLocalClassName(), new Object[0]);
        if (b(activity)) {
            if (activity.getLocalClassName().contains("PendoGateActivity")) {
                sdk.pendo.io.p6.b.a(true);
            }
            c cVarH = c.h();
            sdk.pendo.io.t4.a aVar = sdk.pendo.io.t4.a.CREATE;
            cVarH.c(aVar);
            b.a().a(activity, aVar);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        PendoLogger.i("ActivityLifeCycleListener onActivityDestroyed " + activity.getLocalClassName(), new Object[0]);
        if (b(activity)) {
            if (!(activity instanceof PendoGateActivity)) {
                c.h().c(sdk.pendo.io.t4.a.DESTROY);
            }
            c.h().a(activity.getLocalClassName());
            b.a().a(activity, sdk.pendo.io.t4.a.DESTROY);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        PendoLogger.i("ActivityLifeCycleListener onActivityPaused " + activity.getLocalClassName(), new Object[0]);
        if (b(activity)) {
            c cVarH = c.h();
            sdk.pendo.io.t4.a aVar = sdk.pendo.io.t4.a.PAUSE;
            cVarH.c(aVar);
            c.h().b(activity);
            b.decrementAndGet();
            b.a().a(activity, aVar);
            j.c(activity.getApplicationContext());
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (b(activity)) {
            a(activity, false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        PendoLogger.i(activity.getLocalClassName(), new Object[0]);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        PendoLogger.i("ActivityLifeCycleListener onActivityStarted " + activity.getLocalClassName(), new Object[0]);
        if (b(activity)) {
            sdk.pendo.io.w6.b.e().b();
            c cVarH = c.h();
            sdk.pendo.io.t4.a aVar = sdk.pendo.io.t4.a.START;
            cVarH.c(aVar);
            b.a().a(activity, aVar);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        PendoLogger.i("ActivityLifeCycleListener onActivityStopped " + activity.getLocalClassName(), new Object[0]);
        if (b(activity)) {
            c cVarH = c.h();
            sdk.pendo.io.t4.a aVar = sdk.pendo.io.t4.a.STOP;
            cVarH.c(aVar);
            b.a().a(activity, aVar);
            if (b.get() != 0 || activity.isChangingConfigurations()) {
                return;
            }
            sdk.pendo.io.w6.b.e().a();
            if (d.booleanValue()) {
                PendoInternal.i();
            }
        }
    }

    private boolean a(Activity activity) {
        try {
            if (activity == c.h().i()) {
                return true;
            }
            return c.h().f().contains(activity);
        } catch (Exception e) {
            PendoLogger.d("ActivityLifeCycleListener isActivityAPartOfVisibleActivities exception: " + e, new Object[0]);
            return true;
        }
    }

    public void a(Activity activity, boolean z) {
        PendoLogger.i("ActivityLifeCycleListener onActivityResumed " + activity.getLocalClassName(), new Object[0]);
        Activity activityA = c.h().a();
        AtomicBoolean atomicBoolean = c;
        if (atomicBoolean.getAndSet(false) && activityA != null && activityA == activity) {
            return;
        }
        c.h().a(activity);
        b.incrementAndGet();
        c cVarH = c.h();
        sdk.pendo.io.t4.a aVar = sdk.pendo.io.t4.a.RESUME;
        cVarH.c(aVar);
        b.a().a(activity, aVar);
        j.b(activity.getApplicationContext());
        atomicBoolean.set(z);
    }
}
