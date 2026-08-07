package com.pspdfkit.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.pspdfkit.R;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class h9 extends FrameLayout {
    public List<Integer> a;
    public boolean b;
    public int c;
    public a d;
    public boolean e;
    public int f;
    public Drawable g;

    public interface a {
        void a(h9 h9Var, int i);
    }

    public h9(Context context, List<Integer> list, boolean z) {
        super(context);
        this.c = 0;
        a(context, list, z);
    }

    public final void a(Context context, List<Integer> list, boolean z) {
        this.b = z;
        this.a = list;
        for (Integer num : list) {
            final int iIntValue = num.intValue();
            ImageView imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            g9 g9Var = new g9(context, iIntValue, 2);
            ViewCompat.setBackground(imageView, g9Var);
            imageView.setBackground(new RippleDrawable(ColorStateList.valueOf(Color.argb(66, 255, 255, 255)), g9Var, null));
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.internal.h9$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.a(iIntValue, view);
                }
            });
            imageView.setClickable(true);
            imageView.setTag(num);
            addView(imageView);
        }
        a();
    }

    public List<Integer> getAvailableColors() {
        return this.a;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth;
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            int measuredHeight = 10;
            if (this.b) {
                measuredWidth = ((childAt.getMeasuredWidth() + 10) * i5) + 10;
            } else {
                int measuredWidth2 = ((childAt.getMeasuredWidth() + 10) * (i5 % 5)) + 10;
                measuredHeight = 10 + ((childAt.getMeasuredHeight() + 10) * (i5 / 5));
                measuredWidth = measuredWidth2;
            }
            childAt.layout(measuredWidth, measuredHeight, childAt.getMeasuredWidth() + measuredWidth, childAt.getMeasuredHeight() + measuredHeight);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        int defaultSize = View.getDefaultSize(0, i);
        int i3 = this.c;
        if (i3 == 0) {
            i3 = this.b ? (int) ((((double) (defaultSize - 10)) / 5.5d) - 10.0d) : ((defaultSize - 10) / 5) - 10;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
        measureChildren(iMakeMeasureSpec, iMakeMeasureSpec);
        if (this.b) {
            setMeasuredDimension((getChildCount() * (i3 + 10)) + 10, i3 + 20);
        } else {
            setMeasuredDimension(defaultSize, ((i3 + 10) * ((int) Math.ceil(getChildCount() / 5.0f))) + 10);
        }
    }

    public void setBlockWidthDimension(int i) {
        this.c = i;
    }

    public void setOnColorPickedListener(a aVar) {
        this.d = aVar;
    }

    public void setShowSelectionIndicator(boolean z) {
        this.e = z;
        a();
    }

    public final void a(int i, View view) {
        if (this.f == i) {
            return;
        }
        this.f = i;
        a();
        a aVar = this.d;
        if (aVar != null) {
            aVar.a(this, i);
        }
    }

    public final void a() {
        if (this.g == null) {
            this.g = a80.a(getContext(), R.drawable.pspdf__ic_done, -1);
        }
        if (this.e) {
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if ((childAt instanceof ImageView) && (childAt.getTag() instanceof Integer)) {
                    if (((Integer) childAt.getTag()).intValue() == this.f) {
                        Drawable drawable = this.g;
                        Context context = getContext();
                        int iIntValue = ((Integer) childAt.getTag()).intValue();
                        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{android.R.attr.colorForeground, android.R.attr.colorForegroundInverse});
                        int color = typedArrayObtainStyledAttributes.getColor(0, -16777216);
                        int color2 = typedArrayObtainStyledAttributes.getColor(1, -1);
                        typedArrayObtainStyledAttributes.recycle();
                        int iArgb = Color.argb(255, Color.red(iIntValue), Color.green(iIntValue), Color.blue(iIntValue));
                        if (ColorUtils.calculateContrast(color, iArgb) <= ColorUtils.calculateContrast(color2, iArgb)) {
                            color = color2;
                        }
                        int iCalculateMinimumAlpha = ColorUtils.calculateMinimumAlpha(color, iArgb, 7.0f);
                        if (iCalculateMinimumAlpha >= 0) {
                            color = ColorUtils.setAlphaComponent(color, iCalculateMinimumAlpha);
                        }
                        PorterDuff.Mode mode = PorterDuff.Mode.MULTIPLY;
                        drawable.getClass();
                        Drawable drawableWrap = DrawableCompat.wrap(drawable);
                        drawableWrap.getClass();
                        DrawableCompat.setTint(drawableWrap, color);
                        DrawableCompat.setTintMode(drawableWrap, mode);
                        ((ImageView) childAt).setImageDrawable(drawableWrap);
                    } else {
                        ((ImageView) childAt).setImageDrawable(null);
                    }
                }
            }
            return;
        }
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt2 = getChildAt(i2);
            if (childAt2 instanceof ImageView) {
                ((ImageView) childAt2).setImageDrawable(null);
            }
        }
    }
}
