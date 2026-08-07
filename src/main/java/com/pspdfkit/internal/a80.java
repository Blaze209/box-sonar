package com.pspdfkit.internal;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.pspdfkit.R;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes3.dex */
public final class a80 {
    @JvmStatic
    public static final int a(Context context, int i) {
        context.getClass();
        return (int) un.a(context, 1, i);
    }

    @JvmStatic
    public static final Drawable b(Context context, int i) {
        if (i == 0) {
            return null;
        }
        context.getClass();
        Drawable drawable = AppCompatResources.getDrawable(context, i);
        if (drawable == null) {
            return null;
        }
        return DrawableCompat.wrap(drawable.mutate());
    }

    @JvmStatic
    public static final boolean c(Context context) {
        return context != null && context.getResources().getConfiguration().getLayoutDirection() == 1;
    }

    @JvmStatic
    public static final float a(Context context, float f) {
        context.getClass();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        displayMetrics.getClass();
        displayMetrics.getClass();
        return TypedValue.applyDimension(1, f, displayMetrics);
    }

    @JvmStatic
    public static final FragmentManager b(Context context) {
        context.getClass();
        Activity activityA = a(context);
        if (activityA instanceof FragmentActivity) {
            return ((FragmentActivity) activityA).getSupportFragmentManager();
        }
        return null;
    }

    @JvmStatic
    public static final boolean b(View view, MotionEvent motionEvent) {
        view.getClass();
        motionEvent.getClass();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        return x >= ((float) view.getLeft()) && x < ((float) view.getRight()) && y >= ((float) view.getTop()) && y < ((float) view.getBottom());
    }

    public static float a(float f, Context context) {
        context.getClass();
        return f / (context.getResources().getDisplayMetrics().densityDpi / 160);
    }

    @JvmStatic
    public static final void a(ViewGroup viewGroup) {
        viewGroup.getClass();
        viewGroup.setLayoutDirection(0);
    }

    @JvmStatic
    public static final void a(View view, ColorDrawable colorDrawable) {
        view.getClass();
        Drawable background = view.getBackground();
        if (background == null) {
            background = new ColorDrawable(0);
        }
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{background, colorDrawable});
        transitionDrawable.startTransition(300);
        view.setBackground(transitionDrawable);
    }

    @JvmStatic
    public static final void a(View view, int i, float[] fArr) {
        view.getClass();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadii(fArr);
        gradientDrawable.setColor(i);
        view.setBackground(gradientDrawable);
    }

    @JvmStatic
    public static final void a(Dialog dialog) {
        dialog.getClass();
        if (dialog.getWindow() == null) {
            return;
        }
        int dimensionPixelOffset = dialog.getContext().getResources().getDimensionPixelOffset(R.dimen.pspdf__alert_dialog_inset);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(0);
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(0.0f);
        Window window = dialog.getWindow();
        window.getClass();
        window.setBackgroundDrawable(new InsetDrawable((Drawable) gradientDrawable, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
    }

    @JvmStatic
    public static final Drawable a(Context context, int i, int i2) {
        if (i == 0) {
            return null;
        }
        context.getClass();
        Drawable drawable = AppCompatResources.getDrawable(context, i);
        if (drawable == null) {
            return null;
        }
        Drawable drawableMutate = drawable.mutate();
        drawableMutate.getClass();
        drawableMutate.getClass();
        Drawable drawableWrap = DrawableCompat.wrap(drawableMutate);
        drawableWrap.getClass();
        DrawableCompat.setTint(drawableWrap, i2);
        return drawableWrap;
    }

    @JvmStatic
    public static final void a(View view, int i) {
        view.getClass();
        Drawable background = view.getBackground();
        background.getClass();
        background.getClass();
        Drawable drawableWrap = DrawableCompat.wrap(background);
        drawableWrap.getClass();
        DrawableCompat.setTint(drawableWrap, i);
        view.setBackground(drawableWrap);
    }

    @JvmStatic
    public static final boolean a(Context context, int i, int i2, int i3, int i4) {
        context.getClass();
        return Math.sqrt(Math.pow((double) (i3 - i), 2.0d) + Math.pow((double) (i4 - i2), 2.0d)) > ((double) ViewConfiguration.get(context).getScaledTouchSlop());
    }

    @JvmStatic
    public static final Activity a(Context context) {
        context.getClass();
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
            context.getClass();
        }
        return null;
    }

    @JvmStatic
    public static final Activity a(View view) {
        view.getClass();
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        throw new IllegalStateException("Can't retrieve activity from view context.");
    }

    @JvmStatic
    public static final long a() {
        return new ValueAnimator().getDuration();
    }

    @JvmStatic
    public static final boolean a(View view, MotionEvent motionEvent) {
        view.getClass();
        if (view.getParent() == null) {
            return false;
        }
        if (motionEvent.getActionMasked() == 0) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
        }
        float f = -view.getLeft();
        float f2 = -view.getTop();
        motionEvent.offsetLocation(f, f2);
        boolean zDispatchTouchEvent = view.dispatchTouchEvent(motionEvent);
        motionEvent.offsetLocation(-f, -f2);
        return zDispatchTouchEvent;
    }
}
