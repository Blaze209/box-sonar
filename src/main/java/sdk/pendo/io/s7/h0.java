package sdk.pendo.io.s7;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import sdk.pendo.io.R;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.views.listener.FloatingListenerButton;

/* JADX INFO: loaded from: classes5.dex */
public final class h0 {
    public static void a(final FloatingListenerButton floatingListenerButton) {
        final Activity activityA = sdk.pendo.io.d6.c.h().a();
        if (activityA == null) {
            return;
        }
        sdk.pendo.io.u5.a aVar = new sdk.pendo.io.u5.a(new sdk.pendo.io.u5.a.InterfaceC0496a() { // from class: sdk.pendo.io.s7.h0$$ExternalSyntheticLambda1
            @Override // sdk.pendo.io.u5.a.InterfaceC0496a
            public final void a() {
                h0.a(floatingListenerButton, activityA);
            }
        });
        floatingListenerButton.setVisibility(8);
        aVar.a(activityA);
    }

    public static void b(final Activity activity) {
        if (activity == null) {
            PendoLogger.e("Can't showFlash on null activity", new Object[0]);
        } else {
            activity.runOnUiThread(new Runnable() { // from class: sdk.pendo.io.s7.h0$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    h0.a(activity);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(FloatingListenerButton floatingListenerButton, Activity activity) {
        floatingListenerButton.setVisibility(0);
        sdk.pendo.io.x5.b bVar = new sdk.pendo.io.x5.b();
        bVar.show(activity.getFragmentManager(), FloatingListenerButton.SCREEN_SEND_MODE_TAG);
        FloatingListenerButton.setProgressDialog(bVar);
    }

    public static void b() {
        View viewFindViewById;
        Activity activityA = sdk.pendo.io.d6.c.h().a();
        if (activityA == null || (viewFindViewById = activityA.findViewById(R.id.pnd_pairingButton)) == null) {
            return;
        }
        viewFindViewById.performClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Activity activity) {
        FloatingListenerButton floatingListenerButton = (FloatingListenerButton) ((ViewGroup) activity.findViewById(android.R.id.content)).findViewWithTag(activity.getString(R.string.pnd_pairing_button_name_tag));
        FloatingListenerButton.Builder.removeActiveInstances();
        e1.a aVarA = b1.a.a(activity, true);
        if (aVarA == null || aVarA.a.get() == null) {
            PendoLogger.w("Show flash -> root view is null", new Object[0]);
        } else {
            new sdk.pendo.io.a8.a(activity).a(aVarA.a.get(), floatingListenerButton);
        }
    }

    public static void a() {
        PendoLogger.d("Floating Button - FLASH STATE", new Object[0]);
        Activity activityA = sdk.pendo.io.d6.c.h().a();
        if (activityA == null) {
            return;
        }
        b(activityA);
    }
}
