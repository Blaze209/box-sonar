package com.amplitude.eventexplorer;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.amplitude.R;

/* JADX INFO: loaded from: classes9.dex */
public class EventExplorer {
    private View bubbleView;
    private String instanceName;

    public EventExplorer(String str) {
        this.instanceName = str;
    }

    public void show(final Activity activity) {
        if (this.bubbleView == null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.amplitude.eventexplorer.EventExplorer$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m11183lambda$show$0$comamplitudeeventexplorerEventExplorer(activity);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$show$0$com-amplitude-eventexplorer-EventExplorer, reason: not valid java name */
    /* synthetic */ void m11183lambda$show$0$comamplitudeeventexplorerEventExplorer(Activity activity) {
        WindowManager windowManager = activity.getWindowManager();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (windowManager.getDefaultDisplay() != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        WindowManager.LayoutParams layoutParamsPrepareWindowManagerLayoutParams = prepareWindowManagerLayoutParams(activity, displayMetrics);
        View viewInflate = activity.getLayoutInflater().inflate(R.layout.amp_bubble_view, (ViewGroup) null);
        this.bubbleView = viewInflate;
        windowManager.addView(viewInflate, layoutParamsPrepareWindowManagerLayoutParams);
        this.bubbleView.setOnTouchListener(new EventExplorerTouchHandler(windowManager, layoutParamsPrepareWindowManagerLayoutParams, this.instanceName));
    }

    private WindowManager.LayoutParams prepareWindowManagerLayoutParams(Context context, DisplayMetrics displayMetrics) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        int dimensionPixelSize = identifier > 0 ? resources.getDimensionPixelSize(identifier) : 0;
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2;
        layoutParams.format = -3;
        layoutParams.flags = 40;
        layoutParams.y = (displayMetrics.heightPixels - dimensionPixelSize) / 2;
        layoutParams.x = displayMetrics.widthPixels / 2;
        layoutParams.height = -2;
        layoutParams.width = -2;
        return layoutParams;
    }
}
