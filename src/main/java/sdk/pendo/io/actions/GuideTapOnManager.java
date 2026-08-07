package sdk.pendo.io.actions;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.microsoft.intune.mam.client.widget.MAMRelativeLayout;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.R;
import sdk.pendo.io.d6.c;
import sdk.pendo.io.j4.a;
import sdk.pendo.io.k3.j;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.s7.b1;
import sdk.pendo.io.s7.e1;

/* JADX INFO: loaded from: classes4.dex */
public final class GuideTapOnManager {
    private static final int DEFAULT_ALPHA = 204;
    private static final int DEFAULT_TRANSPARENT_COLOR = -872415232;
    private static final String TAG = "GuideTapOnManager";
    private static final String TAP_ON_SPINNER_DESCRIPTION = "TAP_ON_SPINNER";
    private static final int TAP_ON_TIMEOUT = 10000;
    private static WeakReference<LinearLayout> sTapOnLinearLayout;
    private static Handler sTimeoutExpiredHandler;
    private static Runnable sTimeoutExpiredRunnable;
    private static final a<Boolean> IS_TAP_ON_TIME_EXPIRED = a.b(Boolean.FALSE);
    private static AtomicBoolean sIsTapIndicationRunning = new AtomicBoolean(false);

    private GuideTapOnManager() {
    }

    public static j<Boolean> getTapOnTimeExpiredObservable() {
        return IS_TAP_ON_TIME_EXPIRED;
    }

    public static boolean getsIsTapIndicationRunning() {
        return sIsTapIndicationRunning.get();
    }

    public static boolean isTapOnLayoutExist() {
        WeakReference<LinearLayout> weakReference = sTapOnLinearLayout;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    public static boolean isTapOnTimeoutExpired() {
        return isTapOnLayoutExist() && IS_TAP_ON_TIME_EXPIRED.n().booleanValue();
    }

    static /* synthetic */ void lambda$removeAddedTapOnLayouts$0(ViewGroup viewGroup) {
        WeakReference<LinearLayout> weakReference = sTapOnLinearLayout;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        sTapOnLinearLayout.get().setVisibility(8);
        viewGroup.removeView(sTapOnLinearLayout.get());
    }

    private static void removeAddedTapOnLayouts() {
        Window window;
        View decorView;
        final ViewGroup viewGroup;
        Activity activityA = c.h().a();
        if (activityA == null || (window = activityA.getWindow()) == null || (decorView = window.getDecorView()) == null || (viewGroup = (ViewGroup) decorView.getRootView()) == null) {
            return;
        }
        activityA.runOnUiThread(new Runnable() { // from class: sdk.pendo.io.actions.GuideTapOnManager$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                GuideTapOnManager.lambda$removeAddedTapOnLayouts$0(viewGroup);
            }
        });
        WeakReference<LinearLayout> weakReference = sTapOnLinearLayout;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        sTapOnLinearLayout.clear();
    }

    public static void removeSpinnerFromLayout() {
        LinearLayout linearLayout;
        WeakReference<LinearLayout> weakReference = sTapOnLinearLayout;
        if (weakReference == null || (linearLayout = weakReference.get()) == null) {
            return;
        }
        View viewFindViewById = linearLayout.findViewById(R.id.pnd_tapOnDialogProgressBar);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(8);
        }
        sIsTapIndicationRunning.set(false);
    }

    public static synchronized void resetTapOn() {
        Runnable runnable;
        try {
            if (isTapOnLayoutExist()) {
                Handler handler = sTimeoutExpiredHandler;
                if (handler != null && (runnable = sTimeoutExpiredRunnable) != null) {
                    handler.removeCallbacks(runnable);
                }
                removeAddedTapOnLayouts();
            }
            removeAddedTapOnLayouts();
            sIsTapIndicationRunning.set(false);
        } catch (Exception e) {
            PendoLogger.e("GuideTapOnManager resetTapOn caught error: " + e + "with message: " + e.getMessage(), new Object[0]);
        }
    }

    public static void runTapOnIndication() {
        try {
            Activity activityA = c.h().a();
            if (activityA != null) {
                ColorDrawable colorDrawable = new ColorDrawable(DEFAULT_TRANSPARENT_COLOR);
                colorDrawable.setAlpha(204);
                LinearLayout linearLayout = new LinearLayout(PendoInternal.o());
                sTapOnLinearLayout = new WeakReference<>(linearLayout);
                linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                linearLayout.setId(R.id.pnd_tapOnDialogLayout);
                linearLayout.setBackground(colorDrawable);
                ProgressBar progressBar = new ProgressBar(activityA, null, android.R.attr.progressBarStyle);
                progressBar.setId(R.id.pnd_tapOnDialogProgressBar);
                progressBar.setContentDescription(TAP_ON_SPINNER_DESCRIPTION);
                progressBar.setIndeterminate(true);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(13);
                MAMRelativeLayout mAMRelativeLayout = new MAMRelativeLayout(PendoInternal.o());
                mAMRelativeLayout.setGravity(17);
                mAMRelativeLayout.addView(progressBar);
                linearLayout.addView(mAMRelativeLayout, layoutParams);
                if (activityA.getWindow() != null) {
                    e1.a aVarA = b1.a.a(activityA, false);
                    View view = aVarA != null ? aVarA.a.get() : null;
                    if (view instanceof ViewGroup) {
                        ((ViewGroup) view).addView(linearLayout);
                    }
                    setTimeoutForTapOn();
                }
            }
        } catch (Exception e) {
            PendoLogger.e("GuideTapOnManager runTapOnIndication caught error: " + e + "with message: " + e.getMessage(), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setTapOnTimeExpired(boolean z) {
        IS_TAP_ON_TIME_EXPIRED.onNext(Boolean.valueOf(z));
    }

    private static void setTimeoutForTapOn() {
        setTapOnTimeExpired(false);
        sTimeoutExpiredHandler = new Handler();
        Runnable runnable = new Runnable() { // from class: sdk.pendo.io.actions.GuideTapOnManager$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                GuideTapOnManager.setTapOnTimeExpired(true);
            }
        };
        sTimeoutExpiredRunnable = runnable;
        sTimeoutExpiredHandler.postDelayed(runnable, 10000L);
    }

    public static void setsIsTapIndicationRunning(boolean z) {
        sIsTapIndicationRunning.set(z);
    }
}
