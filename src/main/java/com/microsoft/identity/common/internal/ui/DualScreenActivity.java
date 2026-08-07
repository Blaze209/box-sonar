package com.microsoft.identity.common.internal.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import androidx.activity.EdgeToEdge;
import androidx.activity.SystemBarStyle;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.microsoft.device.display.DisplayMask;
import com.microsoft.identity.common.R;
import com.microsoft.identity.common.java.flighting.CommonFlight;
import com.microsoft.identity.common.java.flighting.CommonFlightsManager;
import com.microsoft.identity.common.logging.Logger;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public class DualScreenActivity extends FragmentActivity {
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        super.onMAMCreate(bundle);
        if (CommonFlightsManager.INSTANCE.getFlightsProvider().isFlightEnabled(CommonFlight.ENABLE_HANDLING_FOR_EDGE_TO_EDGE)) {
            setTheme(getThemeResId());
            setEdgeToEdge();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i) {
        initializeContentView();
        LayoutInflater.from(this).inflate(i, (RelativeLayout) findViewById(R.id.dual_screen_content));
    }

    private void initializeContentView() {
        super.setContentView(R.layout.dual_screen_layout);
        if (CommonFlightsManager.INSTANCE.getFlightsProvider().isFlightEnabled(CommonFlight.ENABLE_HANDLING_FOR_EDGE_TO_EDGE)) {
            try {
                ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content), new OnApplyWindowInsetsListener() { // from class: com.microsoft.identity.common.internal.ui.DualScreenActivity$$ExternalSyntheticLambda0
                    @Override // androidx.core.view.OnApplyWindowInsetsListener
                    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                        return DualScreenActivity.lambda$initializeContentView$0(view, windowInsetsCompat);
                    }
                });
            } catch (Throwable unused) {
                Logger.warn("DualScreenActivity:initializeContentView", "Failed to set OnApplyWindowInsetsListener");
            }
        }
        adjustLayoutForDualScreenActivity();
    }

    static /* synthetic */ WindowInsetsCompat lambda$initializeContentView$0(View view, WindowInsetsCompat windowInsetsCompat) {
        Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout() | WindowInsetsCompat.Type.ime());
        view.setPadding(insets.left, insets.top, insets.right, insets.bottom);
        return WindowInsetsCompat.CONSUMED;
    }

    public void setFragment(Fragment fragment) {
        initializeContentView();
        getSupportFragmentManager().beginTransaction().setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE).replace(R.id.dual_screen_content, fragment).commit();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        adjustLayoutForDualScreenActivity();
    }

    private void adjustLayoutForDualScreenActivity() {
        int rotation = getRotation(this);
        boolean zIsAppSpanned = isAppSpanned(this);
        boolean z = rotation == 0 || rotation == 2;
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.connect(R.id.dual_screen_content, 1, R.id.dual_screen_layout, 1, 0);
        constraintSet.connect(R.id.dual_screen_content, 2, R.id.dual_screen_layout, 2, 0);
        constraintSet.connect(R.id.dual_screen_content, 3, R.id.dual_screen_layout, 3, 0);
        constraintSet.connect(R.id.dual_screen_content, 4, R.id.dual_screen_layout, 4, 0);
        constraintSet.connect(R.id.dual_screen_empty_view, 1, R.id.dual_screen_layout, 1, 0);
        constraintSet.connect(R.id.dual_screen_empty_view, 2, R.id.dual_screen_layout, 2, 0);
        constraintSet.connect(R.id.dual_screen_empty_view, 3, R.id.dual_screen_layout, 3, 0);
        constraintSet.connect(R.id.dual_screen_empty_view, 4, R.id.dual_screen_layout, 4, 0);
        getWindow().setSoftInputMode(16);
        if (!zIsAppSpanned) {
            constraintSet.clear(R.id.dual_screen_empty_view);
        } else if (z) {
            constraintSet.connect(R.id.dual_screen_content, 1, R.id.vertical_guideline, 2, getHinge(this, rotation).width() / 2);
            constraintSet.connect(R.id.dual_screen_empty_view, 2, R.id.vertical_guideline, 1, 0);
        } else {
            constraintSet.connect(R.id.dual_screen_content, 4, R.id.horizontal_guideline, 3, getHinge(this, rotation).height() / 2);
            constraintSet.connect(R.id.dual_screen_empty_view, 3, R.id.horizontal_guideline, 4, 0);
            getWindow().setSoftInputMode(48);
        }
        ((ConstraintLayout) findViewById(R.id.dual_screen_layout)).setConstraintSet(constraintSet);
    }

    public boolean isAppSpanned(Activity activity) {
        if (!isDualScreenDevice(activity)) {
            return false;
        }
        Rect hinge = getHinge(activity, getRotation(activity));
        Rect windowRect = getWindowRect(activity);
        if (windowRect.width() <= 0 || windowRect.height() <= 0) {
            return false;
        }
        return hinge.intersect(windowRect);
    }

    public int getRotation(Activity activity) {
        WindowManager windowManager = (WindowManager) activity.getSystemService("window");
        if (windowManager != null) {
            return windowManager.getDefaultDisplay().getRotation();
        }
        return 0;
    }

    private boolean isDualScreenDevice(Context context) {
        return context.getPackageManager().hasSystemFeature("com.microsoft.device.display.displaymask");
    }

    private Rect getHinge(Context context, int i) {
        try {
            List boundingRectsForRotation = DisplayMask.fromResourcesRect(context).getBoundingRectsForRotation(i);
            if (boundingRectsForRotation.size() == 0) {
                return new Rect(0, 0, 0, 0);
            }
            return (Rect) boundingRectsForRotation.get(0);
        } catch (Throwable th) {
            Logger.error("DualScreenActivity:getHinge", "Failed to get hinge rect", th);
            return new Rect(0, 0, 0, 0);
        }
    }

    private Rect getWindowRect(Activity activity) {
        Rect rect = new Rect();
        activity.getWindowManager().getDefaultDisplay().getRectSize(rect);
        return rect;
    }

    protected int getThemeResId() {
        return R.style.DualScreenActivityTheme;
    }

    protected void setEdgeToEdge() {
        EdgeToEdge.enable(this, SystemBarStyle.light(0, 0), SystemBarStyle.light(0, 0));
    }
}
