package com.pspdfkit.internal.views.inspector.bottomsheet;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.window.core.layout.WindowSizeClass;
import com.pspdfkit.R;
import com.pspdfkit.internal.a80;
import com.pspdfkit.internal.ex;
import com.pspdfkit.internal.n8;
import com.pspdfkit.internal.o8;
import com.pspdfkit.internal.un;
import com.pspdfkit.internal.z70;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class d<V extends View & o8> extends FrameLayout {
    public final n8 a;
    public a b;
    public int c;
    public final int d;
    public final int e;
    public int f;
    public int g;
    public final BottomSheetBehavior<d<V>> h;
    public V i;

    public interface a {
        void onHide(d<?> dVar);

        void onShow(d<?> dVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context) {
        super(context);
        context.getClass();
        this.a = new n8(this);
        this.c = Integer.MAX_VALUE;
        Context context2 = getContext();
        context2.getClass();
        int[] iArr = ex.a;
        TypedArray typedArrayObtainStyledAttributes = context2.getTheme().obtainStyledAttributes(null, ex.a, ex.b, ex.c);
        typedArrayObtainStyledAttributes.getClass();
        int i = R.styleable.pspdf__PropertyInspector_pspdf__minHeight;
        Context context3 = getContext();
        context3.getClass();
        this.d = typedArrayObtainStyledAttributes.getDimensionPixelSize(i, (int) un.a(context3, 1, 100));
        int i2 = R.styleable.pspdf__PropertyInspector_pspdf__maxHeight;
        Context context4 = getContext();
        context4.getClass();
        this.e = typedArrayObtainStyledAttributes.getDimensionPixelSize(i2, (int) un.a(context4, 1, 400));
        int i3 = R.styleable.pspdf__PropertyInspector_pspdf__maxWidth;
        Context context5 = getContext();
        context5.getClass();
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(i3, (int) un.a(context5, 1, WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND));
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__PropertyInspector_pspdf__backgroundColor, -1);
        typedArrayObtainStyledAttributes.recycle();
        Context context6 = getContext();
        context6.getClass();
        ViewCompat.setElevation(this, (int) un.a(context6, 1, 16));
        int i4 = getResources().getDisplayMetrics().widthPixels;
        if (i4 < dimensionPixelSize) {
            setBackgroundColor(color);
        } else {
            float dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.pspdf__inspector_corner_radius) + 2;
            a80.a(this, color, new float[]{dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2, 0.0f, 0.0f, 0.0f, 0.0f});
        }
        CoordinatorLayout.LayoutParams layoutParams = new CoordinatorLayout.LayoutParams(i4 < dimensionPixelSize ? -1 : dimensionPixelSize, -2);
        layoutParams.gravity = 1;
        this.h = new BottomSheetBehavior<>(getContext(), null);
        getBehavior().a(true);
        BottomSheetBehavior<d<V>> behavior = getBehavior();
        if (!behavior.b) {
            behavior.b = true;
            if (behavior.A != null) {
                int iMax = behavior.e ? Math.max(behavior.f, behavior.z - ((behavior.y * 9) / 16)) : behavior.d;
                boolean z = behavior.b;
                int i5 = behavior.z;
                if (z) {
                    behavior.p = Math.max(i5 - iMax, behavior.m);
                } else {
                    behavior.p = i5 - iMax;
                }
            }
            behavior.d((behavior.b && behavior.t == 6) ? 3 : behavior.t);
            behavior.b();
        }
        getBehavior().s = true;
        BottomSheetBehavior<d<V>> behavior2 = getBehavior();
        e eVar = new e(this);
        if (!behavior2.C.contains(eVar)) {
            behavior2.C.add(eVar);
        }
        layoutParams.setBehavior(getBehavior());
        setLayoutParams(layoutParams);
        setId(R.id.pspdf__bottom_sheet_layout);
    }

    private final int getMaxHeight() {
        V v = this.i;
        if (v == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
            v = null;
        }
        return RangesKt.coerceAtMost(Math.min(this.e, v.getMaximumHeight()), this.c);
    }

    private final int getMinHeight() {
        int i = this.d + this.f;
        V v = this.i;
        if (v == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
            v = null;
        }
        return Math.min(Math.max(i, v.getMinimumHeight()), getMaxHeight());
    }

    public final void a(boolean z) {
        setVisibility(0);
        getBehavior().t = 3;
        if (z) {
            getViewTreeObserver().addOnPreDrawListener(new z70(this, new ViewTreeObserver.OnPreDrawListener() { // from class: com.pspdfkit.internal.views.inspector.bottomsheet.d$$ExternalSyntheticLambda0
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public final boolean onPreDraw() {
                    return d.a(this.f$0);
                }
            }));
            return;
        }
        this.a.c();
        setTranslationY(0.0f);
        a aVar = this.b;
        if (aVar != null) {
            aVar.onShow(this);
        }
    }

    public final BottomSheetBehavior<d<V>> getBehavior() {
        BottomSheetBehavior<d<V>> bottomSheetBehavior = this.h;
        if (bottomSheetBehavior != null) {
            return bottomSheetBehavior;
        }
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        return null;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        int i3;
        int size = View.MeasureSpec.getSize(i);
        Object parent = getParent();
        parent.getClass();
        View view = (View) parent;
        if (view.getWidth() < size) {
            i = View.MeasureSpec.makeMeasureSpec(view.getWidth(), View.MeasureSpec.getMode(i));
        }
        int size2 = View.MeasureSpec.getSize(i2);
        this.c = size2;
        V v = this.i;
        V v2 = null;
        if (v == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
            v = null;
        }
        v.measure(i, View.MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE));
        int measuredHeight = getMeasuredHeight();
        int iMax = Math.max(getMinHeight(), Math.min(getMaxHeight(), size2));
        V v3 = this.i;
        if (v3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
        } else {
            v2 = v3;
        }
        v2.measure(i, View.MeasureSpec.makeMeasureSpec(iMax, 1073741824));
        if (measuredHeight == 0 || measuredHeight == iMax || getBehavior().t != 3) {
            i3 = iMax;
        } else {
            i3 = iMax < measuredHeight ? measuredHeight : iMax;
            if (this.g != iMax) {
                this.a.a(measuredHeight, iMax);
            }
        }
        this.g = iMax;
        setMeasuredDimension(View.getDefaultSize(getSuggestedMinimumWidth(), i), Math.max(getSuggestedMinimumHeight(), Math.min(i3, this.c)));
    }

    public final void setBottomInset(int i) {
        if (this.f == i) {
            return;
        }
        this.f = i;
        this.g = 0;
        requestLayout();
    }

    public final void setCallback(a aVar) {
        this.b = aVar;
    }

    public final void setContentView(V v) {
        v.getClass();
        this.i = v;
        removeAllViews();
        this.g = 0;
        setMeasuredDimension(0, 0);
        addView(v);
    }

    public final void setMeasuredHeight$sdk_nutrient(int i) {
        setMeasuredDimension(getMeasuredWidth(), i);
        requestLayout();
    }

    public static final boolean a(d dVar) {
        dVar.a.b();
        return true;
    }
}
