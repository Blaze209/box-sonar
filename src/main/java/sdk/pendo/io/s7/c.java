package sdk.pendo.io.s7;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.util.Patterns;
import android.widget.Toast;
import sdk.pendo.io.R;
import sdk.pendo.io.actions.GuidePreparationManager;
import sdk.pendo.io.actions.GuidesManager;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.GuideModel;

/* JADX INFO: loaded from: classes5.dex */
public final class c {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Activity a(Activity activity, Boolean bool) {
        return activity;
    }

    public static Activity a(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return a(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static boolean a() {
        return true;
    }

    public static boolean b(final Intent intent, final Activity activity) {
        if (activity == null || activity.isDestroyed() || activity.isFinishing()) {
            return false;
        }
        String dataString = intent.getDataString();
        if (intent.resolveActivity(activity.getPackageManager()) != null || Patterns.WEB_URL.matcher(dataString).matches()) {
            activity.runOnUiThread(new Runnable() { // from class: sdk.pendo.io.s7.c$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    c.a(activity, intent);
                }
            });
            return true;
        }
        PendoLogger.w("An incorrect link was used.", new Object[0]);
        if (sdk.pendo.io.o6.a.d().n() || sdk.pendo.io.o6.a.d().s() || sdk.pendo.io.o6.a.d().h()) {
            Toast.makeText(activity, R.string.pnd_wrong_link_used, 1).show();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Activity activity, Intent intent) {
        try {
            activity.startActivity(intent);
        } catch (Exception e) {
            PendoLogger.e(e, e.getMessage(), "ActivityUtils -> Failed to start the activity");
        }
    }

    public static boolean a(final Intent intent, String str, Integer num, Boolean bool) {
        Activity activityA = sdk.pendo.io.d6.c.h().a();
        sdk.pendo.io.k3.g<Activity> gVarF = (activityA != null ? sdk.pendo.io.k3.j.a(activityA) : sdk.pendo.io.d6.c.h().a(sdk.pendo.io.t4.a.PAUSE)).f();
        GuideModel guideModelE = bool.booleanValue() ? sdk.pendo.io.o6.a.d().e() : GuidesManager.INSTANCE.getGuide(str);
        if (guideModelE == null) {
            return false;
        }
        String guideStepId = guideModelE.getGuideStepId(num.intValue());
        if (!guideStepId.equals("") && GuidePreparationManager.getInstance().getHasImages(guideStepId)) {
            gVarF = sdk.pendo.io.k3.g.a(gVarF, GuidePreparationManager.getInstance().getImagesLoadedAsObservable(guideStepId).a(new sdk.pendo.io.q3.j() { // from class: sdk.pendo.io.s7.c$$ExternalSyntheticLambda1
                @Override // sdk.pendo.io.q3.j
                public final boolean test(Object obj) {
                    return ((Boolean) obj).booleanValue();
                }
            }).f(), new sdk.pendo.io.q3.b() { // from class: sdk.pendo.io.s7.c$$ExternalSyntheticLambda2
                @Override // sdk.pendo.io.q3.b
                public final Object a(Object obj, Object obj2) {
                    return c.a((Activity) obj, (Boolean) obj2);
                }
            });
        }
        gVarF.a(sdk.pendo.io.n3.a.a()).a(sdk.pendo.io.t6.c.a(new sdk.pendo.io.q3.e() { // from class: sdk.pendo.io.s7.c$$ExternalSyntheticLambda3
            @Override // sdk.pendo.io.q3.e
            public final void accept(Object obj) {
                ((Activity) obj).startActivity(intent);
            }
        }, "ActivityUtils visible activity and images loaded observer"));
        return true;
    }
}
