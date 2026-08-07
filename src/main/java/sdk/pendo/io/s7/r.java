package sdk.pendo.io.s7;

import android.app.Activity;
import android.view.View;
import java.lang.ref.WeakReference;
import sdk.pendo.io.actions.FloatingVisualGuide;
import sdk.pendo.io.actions.StepSeenManager;
import sdk.pendo.io.actions.VisualGuide;
import sdk.pendo.io.activities.PendoGuideVisualActivity;
import sdk.pendo.io.logging.PendoLogger;

/* JADX INFO: loaded from: classes5.dex */
public final class r {
    public static boolean a(String str) {
        return str.endsWith(PendoGuideVisualActivity.class.getName());
    }

    public static boolean a(WeakReference<View> weakReference, FloatingVisualGuide floatingVisualGuide, sdk.pendo.io.r5.g gVar, String str) {
        try {
            if (StepSeenManager.getInstance().getCurrentStepId() != null) {
                floatingVisualGuide.init(weakReference, gVar, str);
                return floatingVisualGuide.show();
            }
            PendoLogger.w("GuideUtils", "Not showing floating guide due to stepId being null");
            return false;
        } catch (UnsupportedOperationException e) {
            String message = e.getMessage();
            if (message == null || !message.contains("Cannot add views")) {
                return false;
            }
            PendoLogger.w("GuideUtils", "Jetpack Compose limitation, tooltips are not supported for the current window. " + message);
            return false;
        }
    }

    public static boolean a(Activity activity, VisualGuide visualGuide, sdk.pendo.io.r5.g gVar, String str, String str2) {
        try {
            visualGuide.init(activity, gVar, str);
            visualGuide.show();
            return true;
        } catch (sdk.pendo.io.y5.c e) {
            PendoLogger.e(e, (activity != null ? activity.getLocalClassName() + " " : "") + "guide id: '" + visualGuide.getGuideId() + "'.", new Object[0]);
            return false;
        }
    }
}
