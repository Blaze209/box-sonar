package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import com.microsoft.intune.mam.client.view.MAMViewGroup;
import com.pspdfkit.ui.overlay.OverlayLayoutParams;
import com.pspdfkit.utils.PageRect;
import com.pspdfkit.utils.Size;

/* JADX INFO: loaded from: classes3.dex */
public abstract class dw extends MAMViewGroup {
    public final Matrix a;
    public float b;
    public final Rect c;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[OverlayLayoutParams.SizingMode.values().length];
            a = iArr;
            try {
                iArr[OverlayLayoutParams.SizingMode.LAYOUT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[OverlayLayoutParams.SizingMode.SCALING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public dw(Context context) {
        super(context, null, 0);
        this.a = new Matrix();
        this.c = new Rect();
    }

    public abstract Matrix a(Matrix matrix);

    public final void a(int i, int i2) {
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            Rect rectA = a(childAt, this.c);
            childAt.layout(rectA.left - i, rectA.top - i2, rectA.right - i, rectA.bottom - i2);
        }
    }

    public abstract RectF getPdfRect();

    public abstract float getZoomScale();

    @Override // android.view.ViewGroup
    public final void measureChild(View view, int i, int i2) {
        int iHeight;
        int i3;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof OverlayLayoutParams)) {
            super.measureChild(view, i, i2);
            return;
        }
        OverlayLayoutParams overlayLayoutParams = (OverlayLayoutParams) layoutParams;
        PageRect pageRect = overlayLayoutParams.pageRect;
        Matrix matrix = this.a;
        float f = this.b;
        Size size = overlayLayoutParams.fixedScreenSize;
        if (size == null) {
            if (overlayLayoutParams.noZoom) {
                pageRect.updateScreenRect(matrix);
                float fMax = Math.max(1.0f, f);
                size = new Size(Math.max(overlayLayoutParams.minSize.width, overlayLayoutParams.pageRect.getScreenRect().width() / fMax), Math.max(overlayLayoutParams.minSize.height, overlayLayoutParams.pageRect.getScreenRect().height() / fMax));
            } else {
                size = null;
            }
        }
        if (size != null) {
            i3 = (int) size.width;
            iHeight = (int) size.height;
        } else {
            int i4 = a.a[overlayLayoutParams.sizingMode.ordinal()];
            if (i4 == 1) {
                pageRect.updateScreenRect(this.a);
                RectF screenRect = pageRect.getScreenRect();
                int iWidth = (int) screenRect.width();
                iHeight = (int) screenRect.height();
                i3 = iWidth;
            } else {
                if (i4 != 2) {
                    throw new IllegalArgumentException("Invalid layout space received.");
                }
                pageRect.updateScreenRect(this.a);
                int iWidth2 = (int) (pageRect.getScreenRect().width() / this.b);
                float fHeight = pageRect.getScreenRect().height();
                float f2 = this.b;
                iHeight = (int) (fHeight / f2);
                view.setScaleX(f2);
                view.setScaleY(this.b);
                if (overlayLayoutParams.layoutPosition == OverlayLayoutParams.LayoutPosition.CENTER) {
                    view.setPivotX(iWidth2 / 2.0f);
                    view.setPivotY(iHeight / 2.0f);
                } else {
                    view.setPivotX(0.0f);
                    view.setPivotY(0.0f);
                }
                i3 = iWidth2;
            }
        }
        view.measure(ViewGroup.getChildMeasureSpec(i, 0, (int) Math.max(overlayLayoutParams.minSize.width, i3)), ViewGroup.getChildMeasureSpec(i2, 0, (int) Math.max(overlayLayoutParams.minSize.height, iHeight)));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        a(0, 0);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        a(this.a);
        this.b = getZoomScale();
        measureChildren(i, i2);
        super.onMeasure(i, i2);
    }

    public final Rect a(View view, Rect rect) {
        int measuredWidth;
        int measuredHeight;
        int i;
        int i2;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof OverlayLayoutParams) {
            OverlayLayoutParams overlayLayoutParams = (OverlayLayoutParams) layoutParams;
            overlayLayoutParams.pageRect.updateScreenRect(this.a);
            RectF screenRect = overlayLayoutParams.pageRect.getScreenRect();
            if (overlayLayoutParams.layoutPosition == OverlayLayoutParams.LayoutPosition.CENTER) {
                int iCenterX = (int) screenRect.centerX();
                int iCenterY = (int) screenRect.centerY();
                int measuredWidth2 = view.getMeasuredWidth() / 2;
                int measuredHeight2 = view.getMeasuredHeight() / 2;
                i = iCenterX - measuredWidth2;
                i2 = iCenterY - measuredHeight2;
                measuredWidth = iCenterX + measuredWidth2;
                measuredHeight = iCenterY + measuredHeight2;
            } else {
                i = (int) screenRect.left;
                i2 = (int) screenRect.top;
                measuredWidth = view.getMeasuredWidth() + i;
                measuredHeight = view.getMeasuredHeight() + i2;
            }
        } else {
            measuredWidth = view.getMeasuredWidth();
            measuredHeight = view.getMeasuredHeight();
            i = 0;
            i2 = 0;
        }
        if (rect == null) {
            return new Rect(i, i2, measuredWidth, measuredHeight);
        }
        rect.set(i, i2, measuredWidth, measuredHeight);
        return rect;
    }
}
