package com.pspdfkit.internal;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.appcompat.widget.AppCompatImageView;
import com.microsoft.intune.mam.client.widget.MAMPopupWindow;
import com.pspdfkit.utils.PdfLog;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class s00 {
    public final gb a;
    public final Context b;
    public final Drawable c;
    public final Drawable d;
    public final Drawable e;
    public final PopupWindow f;
    public final PopupWindow g;
    public final PopupWindow h;
    public boolean i;
    public boolean j;
    public vo k;

    public s00(gb gbVar) {
        this.a = gbVar;
        Context context = gbVar.getContext();
        context.getClass();
        this.b = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new int[]{R.attr.textSelectHandle, R.attr.textSelectHandleLeft, R.attr.textSelectHandleRight});
        typedArrayObtainStyledAttributes.getClass();
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(0);
        this.c = drawable;
        Drawable drawable2 = typedArrayObtainStyledAttributes.getDrawable(1);
        this.d = drawable2;
        Drawable drawable3 = typedArrayObtainStyledAttributes.getDrawable(2);
        this.e = drawable3;
        typedArrayObtainStyledAttributes.recycle();
        AppCompatImageView appCompatImageView = new AppCompatImageView(context);
        appCompatImageView.setImageDrawable(drawable);
        if (drawable != null) {
            appCompatImageView.setLayoutParams(new WindowManager.LayoutParams(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight()));
        }
        AppCompatImageView appCompatImageView2 = new AppCompatImageView(context);
        appCompatImageView2.setImageDrawable(drawable2);
        if (drawable2 != null) {
            appCompatImageView2.setLayoutParams(new WindowManager.LayoutParams(drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight()));
        }
        AppCompatImageView appCompatImageView3 = new AppCompatImageView(context);
        appCompatImageView3.setImageDrawable(drawable3);
        if (drawable3 != null) {
            appCompatImageView3.setLayoutParams(new WindowManager.LayoutParams(drawable3.getIntrinsicWidth(), drawable3.getIntrinsicHeight()));
        }
        b(appCompatImageView);
        a(appCompatImageView2, true);
        a(appCompatImageView3, false);
        this.f = a(appCompatImageView);
        this.g = a(appCompatImageView2);
        this.h = a(appCompatImageView3);
        PdfLog.d("SelectionHandleController", "SelectionHandleController initialized", new Object[0]);
    }

    public final PopupWindow a(AppCompatImageView appCompatImageView) {
        MAMPopupWindow mAMPopupWindow = new MAMPopupWindow(this.b, (AttributeSet) null, R.attr.textSelectHandleWindowStyle);
        mAMPopupWindow.setContentView(appCompatImageView);
        mAMPopupWindow.setWidth(-2);
        mAMPopupWindow.setHeight(-2);
        mAMPopupWindow.setClippingEnabled(false);
        mAMPopupWindow.setWindowLayoutType(1002);
        mAMPopupWindow.setFocusable(false);
        mAMPopupWindow.setTouchable(true);
        return mAMPopupWindow;
    }

    public final void b(final AppCompatImageView appCompatImageView) {
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        final Ref.FloatRef floatRef = new Ref.FloatRef();
        final Ref.FloatRef floatRef2 = new Ref.FloatRef();
        final Ref.IntRef intRef = new Ref.IntRef();
        appCompatImageView.setOnTouchListener(new View.OnTouchListener() { // from class: com.pspdfkit.internal.s00$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return s00.a(booleanRef, floatRef, floatRef2, this, intRef, appCompatImageView, view, motionEvent);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00be A[Catch: Exception -> 0x00d0, TRY_ENTER, TryCatch #0 {Exception -> 0x00d0, blocks: (B:16:0x0046, B:18:0x0069, B:20:0x006f, B:22:0x007a, B:34:0x009b, B:36:0x00a3, B:25:0x0088, B:27:0x008e, B:29:0x0092, B:31:0x0096, B:37:0x00a9, B:40:0x00be, B:41:0x00c6), top: B:111:0x0046 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00c6 A[Catch: Exception -> 0x00d0, TRY_LEAVE, TryCatch #0 {Exception -> 0x00d0, blocks: (B:16:0x0046, B:18:0x0069, B:20:0x006f, B:22:0x007a, B:34:0x009b, B:36:0x00a3, B:25:0x0088, B:27:0x008e, B:29:0x0092, B:31:0x0096, B:37:0x00a9, B:40:0x00be, B:41:0x00c6), top: B:111:0x0046 }] */
    public final void c() {
        int iB;
        int iB2;
        int[] iArr;
        boolean zIsShowing;
        PopupWindow popupWindow;
        if (this.i) {
            return;
        }
        gb gbVar = this.a;
        if (gbVar.r != -1) {
            a();
            b();
            this.a.e();
            this.j = false;
            return;
        }
        q00 selection = gbVar.getSelection();
        if (selection.a()) {
            if (this.j) {
                b();
                int i = selection.a;
                if (this.a.getTextBlock$sdk_nutrient().e.f.a.size() != 0) {
                    try {
                        int iB3 = this.a.b(i);
                        float fA = this.a.a(i);
                        float fE = this.a.e(iB3);
                        float f = this.a.getTextMetrics$sdk_nutrient().b(iB3).a;
                        Drawable drawable = this.c;
                        float intrinsicWidth = fA - ((drawable != null ? drawable.getIntrinsicWidth() : 0) / 2.0f);
                        float f2 = fE + f;
                        if (this.i) {
                            iArr = new int[]{(int) intrinsicWidth, (int) f2};
                            this.a.a(iArr);
                            zIsShowing = this.f.isShowing();
                            popupWindow = this.f;
                            if (zIsShowing) {
                                popupWindow.update(iArr[0], iArr[1], -1, -1);
                            } else {
                                popupWindow.showAtLocation(this.a, 0, iArr[0], iArr[1]);
                            }
                        } else {
                            gb gbVar2 = this.a;
                            Rect rect = new Rect();
                            if (gbVar2.getLocalVisibleRect(rect)) {
                                int i2 = (int) fA;
                                int i3 = (int) f2;
                                if (i2 >= rect.left && i2 <= rect.right && i3 >= rect.top && i3 <= rect.bottom) {
                                    iArr = new int[]{(int) intrinsicWidth, (int) f2};
                                    this.a.a(iArr);
                                    zIsShowing = this.f.isShowing();
                                    popupWindow = this.f;
                                    if (zIsShowing) {
                                        popupWindow.update(iArr[0], iArr[1], -1, -1);
                                    } else {
                                        popupWindow.showAtLocation(this.a, 0, iArr[0], iArr[1]);
                                    }
                                }
                            }
                            if (this.f.isShowing()) {
                                this.f.dismiss();
                            }
                        }
                    } catch (Exception e) {
                        PdfLog.w("SelectionHandleController", "Failed to show insertion handle", e);
                    }
                }
            } else {
                a();
                b();
            }
            gb gbVar3 = this.a;
            if (gbVar3.E && gbVar3.q.a()) {
                this.a.k();
                return;
            } else {
                this.a.e();
                return;
            }
        }
        a();
        int i4 = selection.a;
        int i5 = selection.b;
        if (this.a.getTextBlock$sdk_nutrient().e.f.a.size() != 0) {
            try {
                int iB4 = this.a.b(i4);
                float fA2 = this.a.a(i4);
                float fE2 = this.a.e(iB4);
                float f3 = this.a.getTextMetrics$sdk_nutrient().b(iB4).a;
                Drawable drawable2 = this.d;
                int[] iArr2 = {(int) (fA2 - (((drawable2 != null ? drawable2.getIntrinsicWidth() : 0) * 3.0f) / 4.0f)), (int) (fE2 + f3)};
                this.a.a(iArr2);
                if (this.i || this.a.f(iB4)) {
                    boolean zIsShowing2 = this.g.isShowing();
                    PopupWindow popupWindow2 = this.g;
                    if (zIsShowing2) {
                        popupWindow2.update(iArr2[0], iArr2[1], -1, -1);
                    } else {
                        popupWindow2.showAtLocation(this.a, 0, iArr2[0], iArr2[1]);
                    }
                } else if (this.g.isShowing()) {
                    this.g.dismiss();
                }
                int iB5 = this.a.b(i5);
                float fA3 = this.a.a(i5);
                float fE3 = this.a.e(iB5);
                float f4 = this.a.getTextMetrics$sdk_nutrient().b(iB5).a;
                Drawable drawable3 = this.e;
                int[] iArr3 = {(int) (fA3 - ((drawable3 != null ? drawable3.getIntrinsicWidth() : 0) / 4.0f)), (int) (fE3 + f4)};
                this.a.a(iArr3);
                if (this.i || this.a.f(iB5)) {
                    boolean zIsShowing3 = this.h.isShowing();
                    PopupWindow popupWindow3 = this.h;
                    if (zIsShowing3) {
                        popupWindow3.update(iArr3[0], iArr3[1], -1, -1);
                    } else {
                        popupWindow3.showAtLocation(this.a, 0, iArr3[0], iArr3[1]);
                    }
                } else if (this.h.isShowing()) {
                    this.h.dismiss();
                }
            } catch (Exception e2) {
                PdfLog.w("SelectionHandleController", "Failed to show selection handles", e2);
            }
        }
        this.j = false;
        gb gbVar4 = this.a;
        if (!gbVar4.q.a() && gbVar4.b.e.f.a.size() != 0) {
            Rect rect2 = new Rect();
            if (gbVar4.getLocalVisibleRect(rect2) && (iB = gbVar4.b(gbVar4.q.a)) <= (iB2 = gbVar4.b(gbVar4.q.b))) {
                while (true) {
                    float fE4 = gbVar4.e(iB);
                    if (gbVar4.e.b(iB).a + fE4 > rect2.top && fE4 < rect2.bottom) {
                        this.a.k();
                        return;
                    } else if (iB != iB2) {
                        iB++;
                    }
                }
            }
        }
        this.a.e();
    }

    public final void b() {
        if (this.g.isShowing()) {
            this.g.dismiss();
        }
        if (this.h.isShowing()) {
            this.h.dismiss();
        }
    }

    public static final boolean a(Ref.BooleanRef booleanRef, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, s00 s00Var, Ref.IntRef intRef, View view, View view2, MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (!booleanRef.element) {
                        view.setVisibility(4);
                        s00Var.a.e();
                        s00Var.a.setSuppressCursorBlink$sdk_nutrient(true);
                        gb gbVar = s00Var.a;
                        gbVar.K.removeCallbacks(gbVar.L);
                        gbVar.I = true;
                        booleanRef.element = true;
                        s00Var.i = true;
                    }
                    float rawX = motionEvent.getRawX() - floatRef.element;
                    float rawY = motionEvent.getRawY() - floatRef2.element;
                    int iB = s00Var.a.b(intRef.element);
                    float fA = s00Var.a.a(intRef.element) + rawX;
                    int iA = s00Var.a.a(fA, RangesKt.coerceAtLeast((s00Var.a.getTextMetrics$sdk_nutrient().b(iB).a / 2.0f) + s00Var.a.e(iB) + rawY, 0.0f));
                    s00Var.a.a(iA, iA, true);
                    s00Var.a.invalidate();
                    Pair<Float, Float> pairA = s00Var.a(fA, iA);
                    if (pairA != null) {
                        s00Var.a(pairA.getFirst().floatValue(), pairA.getSecond().floatValue());
                    } else {
                        vo voVar = s00Var.k;
                        if (voVar != null) {
                            voVar.d();
                        }
                    }
                    return true;
                }
                if (actionMasked != 3) {
                    return false;
                }
            }
            vo voVar2 = s00Var.k;
            if (voVar2 != null) {
                voVar2.d();
            }
            if (booleanRef.element) {
                view.setVisibility(0);
                s00Var.j = true;
                s00Var.i = false;
                s00Var.c();
                s00Var.a.setSuppressCursorBlink$sdk_nutrient(false);
                s00Var.a.l();
                booleanRef.element = false;
            } else {
                view.performClick();
            }
            return true;
        }
        booleanRef.element = false;
        floatRef.element = motionEvent.getRawX();
        floatRef2.element = motionEvent.getRawY();
        intRef.element = s00Var.a.getSelection().a;
        return true;
    }

    public final void a(final AppCompatImageView appCompatImageView, final boolean z) {
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        final Ref.FloatRef floatRef = new Ref.FloatRef();
        final Ref.FloatRef floatRef2 = new Ref.FloatRef();
        final Ref.IntRef intRef = new Ref.IntRef();
        appCompatImageView.setOnTouchListener(new View.OnTouchListener() { // from class: com.pspdfkit.internal.s00$$ExternalSyntheticLambda1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return s00.a(this.f$0, booleanRef, floatRef, floatRef2, intRef, z, appCompatImageView, view, motionEvent);
            }
        });
    }

    public static final boolean a(s00 s00Var, Ref.BooleanRef booleanRef, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, Ref.IntRef intRef, boolean z, View view, View view2, MotionEvent motionEvent) {
        int i;
        int iCoerceAtLeast;
        int iCoerceAtMost;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (!booleanRef.element) {
                        view.setVisibility(4);
                        s00Var.a.e();
                        booleanRef.element = true;
                        s00Var.i = true;
                    }
                    float rawX = motionEvent.getRawX() - floatRef.element;
                    float rawY = motionEvent.getRawY() - floatRef2.element;
                    int iB = s00Var.a.b(intRef.element);
                    float fA = s00Var.a.a(intRef.element) + rawX;
                    int iA = s00Var.a.a(fA, RangesKt.coerceAtLeast((s00Var.a.getTextMetrics$sdk_nutrient().b(iB).a / 2.0f) + s00Var.a.e(iB) + rawY, 0.0f));
                    q00 selection = s00Var.a.getSelection();
                    if (z) {
                        iCoerceAtLeast = selection.b;
                    } else {
                        iCoerceAtLeast = selection.a;
                    }
                    if (z) {
                        int i2 = iCoerceAtLeast;
                        iCoerceAtLeast = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(iA, iCoerceAtLeast - 1), 0);
                        iCoerceAtMost = i2;
                    } else {
                        iCoerceAtMost = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(iA, iCoerceAtLeast + 1), ((String) s00Var.a.getTextBlock$sdk_nutrient().e.i.getValue()).length());
                    }
                    s00Var.a.a(iCoerceAtLeast, iCoerceAtMost, true);
                    s00Var.a.invalidate();
                    if (!z) {
                        iCoerceAtLeast = iCoerceAtMost;
                    }
                    Pair<Float, Float> pairA = s00Var.a(fA, iCoerceAtLeast);
                    if (pairA != null) {
                        s00Var.a(pairA.getFirst().floatValue(), pairA.getSecond().floatValue());
                    } else {
                        vo voVar = s00Var.k;
                        if (voVar != null) {
                            voVar.d();
                        }
                    }
                    return true;
                }
                if (actionMasked != 3) {
                    return false;
                }
            }
            vo voVar2 = s00Var.k;
            if (voVar2 != null) {
                voVar2.d();
            }
            if (booleanRef.element) {
                view.setVisibility(0);
                s00Var.i = false;
                s00Var.c();
                booleanRef.element = false;
            } else {
                view.performClick();
            }
            return true;
        }
        q00 selection2 = s00Var.a.getSelection();
        booleanRef.element = false;
        floatRef.element = motionEvent.getRawX();
        floatRef2.element = motionEvent.getRawY();
        if (z) {
            i = selection2.a;
        } else {
            i = selection2.b;
        }
        intRef.element = i;
        return true;
    }

    public final void a() {
        if (this.f.isShowing()) {
            this.f.dismiss();
        }
    }

    public final Pair<Float, Float> a(float f, int i) {
        vo voVar = this.k;
        if (voVar == null) {
            return null;
        }
        int iB = this.a.b(i);
        int i2 = this.a.getTextMetrics$sdk_nutrient().b(iB).a;
        if (i2 >= this.a.getMinLineHeightForMagnifier$sdk_nutrient() && i2 <= this.a.getMaxLineHeightForMagnifier$sdk_nutrient()) {
            Iterator<Integer> it = RangesKt.until(0, iB).iterator();
            int iIntValue = 0;
            while (it.hasNext()) {
                iIntValue += ((Number) this.a.getTextBlock$sdk_nutrient().c(((IntIterator) it).nextInt()).d.getValue()).intValue();
            }
            int iIntValue2 = ((Number) this.a.getTextBlock$sdk_nutrient().c(iB).d.getValue()).intValue();
            int i3 = iIntValue + iIntValue2;
            String str = (String) this.a.getTextBlock$sdk_nutrient().e.i.getValue();
            if (i3 > 0 && i3 <= str.length() && str.charAt(i3 - 1) == '\n') {
                iIntValue2--;
            }
            float fA = this.a.a(iIntValue);
            float fA2 = fA;
            for (int i4 = 0; i4 < iIntValue2; i4++) {
                fA2 += this.a.getTextMetrics$sdk_nutrient().a(iIntValue + i4);
            }
            float fH = (voVar.h() / 1.25f) / 2.0f;
            float f2 = fA - fH;
            float f3 = fH + fA2;
            if (f2 <= f && f <= f3) {
                float fCoerceIn = RangesKt.coerceIn(f, fA, fA2);
                float fE = this.a.e(iB);
                return new Pair<>(Float.valueOf(fCoerceIn), Float.valueOf(((this.a.getTextMetrics$sdk_nutrient().b(iB).a + fE) + fE) / 2.0f));
            }
        }
        return null;
    }

    public final void a(float f, float f2) {
        vo voVar = this.k;
        if (voVar == null) {
            return;
        }
        int[] iArr = new int[2];
        this.a.getLocationInWindow(iArr);
        int[] iArr2 = new int[2];
        voVar.a.getLocationInWindow(iArr2);
        wo.a(voVar, this.b, (f + iArr[0]) - iArr2[0], (f2 + iArr[1]) - iArr2[1], 1.25f);
    }
}
