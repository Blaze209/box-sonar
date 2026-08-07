package sdk.pendo.io.o5;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.ViewCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import sdk.pendo.io.actions.VisualGuidesManager;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.s7.e1;
import sdk.pendo.io.s7.i0;
import sdk.pendo.io.s7.w0;
import sdk.pendo.io.views.custom.PendoFloatingVisualGuideView;
import sdk.pendo.io.views.custom.PendoLinearLayout;

/* JADX INFO: loaded from: classes4.dex */
public class e extends PendoFloatingVisualGuideView {
    private static final List<Integer> p = new ArrayList(PendoFloatingVisualGuideView.GRAVITY_LIST);
    private final int[] a;
    private int[] b;
    private Rect c;
    private Rect d;
    private Rect e;
    private final boolean f;
    private final Point g;
    private final int h;
    private final int i;
    private int j;
    private a k;
    protected ViewTreeObserver.OnGlobalLayoutListener l;
    private final ViewTreeObserver.OnPreDrawListener m;
    private final ViewTreeObserver.OnGlobalLayoutListener n;
    private final i0.a o;

    public e(Context context, c.a aVar) {
        super(context, aVar);
        int[] iArr = new int[2];
        this.a = iArr;
        this.d = new Rect();
        this.e = new Rect();
        this.g = new Point();
        this.j = 4;
        this.m = new ViewTreeObserver.OnPreDrawListener() { // from class: sdk.pendo.io.o5.e$$ExternalSyntheticLambda5
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                return this.f$0.a();
            }
        };
        this.n = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: sdk.pendo.io.o5.e$$ExternalSyntheticLambda6
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                this.f$0.b();
            }
        };
        this.o = new i0.a() { // from class: sdk.pendo.io.o5.e$$ExternalSyntheticLambda7
            @Override // sdk.pendo.io.s7.i0.a
            public final void a(i0.b bVar) {
                e.a(bVar);
            }
        };
        this.h = aVar.caretWidthPx;
        this.i = aVar.caretHeightPx;
        this.f = aVar.getIsHideArrow();
        ViewCompat.setAccessibilityPaneTitle(this, aVar.getPaneTitle());
        setClipChildren(false);
        setClipToPadding(false);
        final View anchorView = aVar.getAnchorView();
        if (anchorView != null) {
            this.c = new Rect();
            this.d = e1.a(anchorView);
            anchorView.getLocationInWindow(iArr);
            this.c.set(this.d);
            this.c.offsetTo(iArr[0], iArr[1]);
            this.mAnchorViewWeakRef = new WeakReference<>(anchorView);
            if (anchorView.getViewTreeObserver() == null || !anchorView.getViewTreeObserver().isAlive()) {
                return;
            }
            sdk.pendo.io.u7.a.a.a(new Runnable() { // from class: sdk.pendo.io.o5.e$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(anchorView);
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0053 A[Catch: Exception -> 0x0061, TryCatch #0 {Exception -> 0x0061, blocks: (B:2:0x0000, B:4:0x0033, B:6:0x003e, B:10:0x0046, B:11:0x0049, B:13:0x0053, B:17:0x005d, B:14:0x0055, B:16:0x005b, B:7:0x0040, B:9:0x0044), top: B:22:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:14:0x0055 A[Catch: Exception -> 0x0061, TryCatch #0 {Exception -> 0x0061, blocks: (B:2:0x0000, B:4:0x0033, B:6:0x003e, B:10:0x0046, B:11:0x0049, B:13:0x0053, B:17:0x005d, B:14:0x0055, B:16:0x005b, B:7:0x0040, B:9:0x0044), top: B:22:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:16:0x005b A[Catch: Exception -> 0x0061, TryCatch #0 {Exception -> 0x0061, blocks: (B:2:0x0000, B:4:0x0033, B:6:0x003e, B:10:0x0046, B:11:0x0049, B:13:0x0053, B:17:0x005d, B:14:0x0055, B:16:0x005b, B:7:0x0040, B:9:0x0044), top: B:22:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:25:? A[RETURN, SYNTHETIC] */
    private void b(int i, int i2, int i3) {
        int i4;
        Rect rect;
        int i5;
        Rect rect2;
        int i6;
        int i7;
        int i8;
        int i9;
        try {
            this.mDrawRect.set(this.c.centerX() - (i2 / 2), this.c.centerY() - (i3 / 2), this.c.centerX() + (i2 / 2), this.c.centerY() + (i3 / 2));
            if (w0.a(this.mScreenRectWithoutMargins, this.mDrawRect)) {
                return;
            }
            Rect rect3 = this.mDrawRect;
            int i10 = rect3.bottom;
            int i11 = this.mScreenRectWithoutMargins.bottom;
            if (i10 <= i11) {
                int i12 = rect3.top;
                if (i12 < i) {
                    i4 = i - i12;
                }
                rect = this.mDrawRect;
                i5 = rect.right;
                rect2 = this.mScreenRectWithoutMargins;
                i6 = rect2.right;
                if (i5 > i6) {
                    i9 = i6 - i5;
                } else {
                    i7 = rect.left;
                    i8 = rect2.left;
                    if (i7 < i8) {
                        return;
                    } else {
                        i9 = i8 - i7;
                    }
                }
                rect.offset(i9, 0);
            }
            i4 = i11 - i10;
            rect3.offset(0, i4);
            rect = this.mDrawRect;
            i5 = rect.right;
            rect2 = this.mScreenRectWithoutMargins;
            i6 = rect2.right;
            if (i5 > i6) {
                i9 = i6 - i5;
            } else {
                i7 = rect.left;
                i8 = rect2.left;
                if (i7 < i8) {
                    return;
                } else {
                    i9 = i8 - i7;
                }
            }
            rect.offset(i9, 0);
        } catch (Exception e) {
            PendoLogger.w(e, e.getMessage(), "PendoTooltipView calculatePositionCenter");
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x004b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:16:0x004d A[Catch: Exception -> 0x0058, TryCatch #0 {Exception -> 0x0058, blocks: (B:3:0x0001, B:5:0x002c, B:7:0x0036, B:11:0x003e, B:12:0x0041, B:16:0x004d, B:18:0x0053, B:8:0x0038, B:10:0x003c), top: B:23:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:18:0x0053 A[Catch: Exception -> 0x0058, TRY_LEAVE, TryCatch #0 {Exception -> 0x0058, blocks: (B:3:0x0001, B:5:0x002c, B:7:0x0036, B:11:0x003e, B:12:0x0041, B:16:0x004d, B:18:0x0053, B:8:0x0038, B:10:0x003c), top: B:23:0x0001 }] */
    private boolean c(int i, int i2, int i3, int i4) {
        int i5;
        Rect rect;
        int i6;
        Rect rect2;
        int i7;
        int i8;
        try {
            Rect rect3 = this.mDrawRect;
            Rect rect4 = this.c;
            int i9 = rect4.right + i;
            int iCenterY = rect4.centerY() - (i4 / 2);
            Rect rect5 = this.c;
            rect3.set(i9, iCenterY, rect5.right + i3 + this.i + i, rect5.centerY() + (i4 / 2));
            if (!w0.a(this.mScreenRectWithoutMargins, this.mDrawRect)) {
                Rect rect6 = this.mDrawRect;
                int i10 = rect6.bottom;
                int i11 = this.mScreenRectWithoutMargins.bottom;
                if (i10 > i11) {
                    i5 = i11 - i10;
                } else {
                    int i12 = rect6.top;
                    if (i12 < i2) {
                        i5 = i2 - i12;
                    } else {
                        rect = this.mDrawRect;
                        i6 = rect.right;
                        rect2 = this.mScreenRectWithoutMargins;
                        if (i6 > rect2.right) {
                            return true;
                        }
                        i7 = rect.left;
                        i8 = rect2.left;
                        if (i7 < i8) {
                            rect.offset(i8 - i7, 0);
                        }
                    }
                }
                rect6.offset(0, i5);
                rect = this.mDrawRect;
                i6 = rect.right;
                rect2 = this.mScreenRectWithoutMargins;
                if (i6 > rect2.right) {
                    return true;
                }
                i7 = rect.left;
                i8 = rect2.left;
                if (i7 < i8) {
                    rect.offset(i8 - i7, 0);
                }
            }
        } catch (Exception e) {
            PendoLogger.w(e, e.getMessage(), "PendoTooltipView calculatePositionRight");
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x004b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:16:0x004d A[Catch: Exception -> 0x005a, TryCatch #0 {Exception -> 0x005a, blocks: (B:3:0x0001, B:5:0x002e, B:7:0x0038, B:11:0x0042, B:12:0x0045, B:16:0x004d, B:18:0x0055, B:8:0x003a, B:10:0x0040), top: B:23:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:18:0x0055 A[Catch: Exception -> 0x005a, TRY_LEAVE, TryCatch #0 {Exception -> 0x005a, blocks: (B:3:0x0001, B:5:0x002e, B:7:0x0038, B:11:0x0042, B:12:0x0045, B:16:0x004d, B:18:0x0055, B:8:0x003a, B:10:0x0040), top: B:23:0x0001 }] */
    private boolean d(int i, int i2, int i3, int i4) {
        int i5;
        Rect rect;
        int i6;
        int i7;
        try {
            Rect rect2 = this.mDrawRect;
            int iCenterX = this.c.centerX() - (i3 / 2);
            Rect rect3 = this.c;
            rect2.set(iCenterX, ((rect3.top - i4) - i) - this.i, rect3.centerX() + (i3 / 2), this.c.top - i);
            if (!w0.a(this.mScreenRectWithoutMargins, this.mDrawRect)) {
                Rect rect4 = this.mDrawRect;
                int i8 = rect4.right;
                Rect rect5 = this.mScreenRectWithoutMargins;
                int i9 = rect5.right;
                if (i8 > i9) {
                    i5 = i9 - i8;
                } else {
                    int i10 = rect4.left;
                    int i11 = rect5.left;
                    if (i10 < i11) {
                        i5 = i11 - i10;
                    } else {
                        rect = this.mDrawRect;
                        if (rect.top < i2) {
                            return true;
                        }
                        i6 = rect.bottom;
                        i7 = this.mScreenRectWithoutMargins.bottom;
                        if (i6 > i7) {
                            rect.offset(0, i7 - i6);
                        }
                    }
                }
                rect4.offset(i5, 0);
                rect = this.mDrawRect;
                if (rect.top < i2) {
                    return true;
                }
                i6 = rect.bottom;
                i7 = this.mScreenRectWithoutMargins.bottom;
                if (i6 > i7) {
                    rect.offset(0, i7 - i6);
                }
            }
        } catch (Exception e) {
            PendoLogger.w(e, e.getMessage(), "PendoTooltipView calculatePositionTop");
        }
        return false;
    }

    private List<Integer> getGravitiesOrderedAccordingToPreference() {
        ArrayList arrayList = new ArrayList(p);
        try {
            arrayList.remove(this.mGravity);
            arrayList.add(0, Integer.valueOf(this.mGravity));
            return arrayList;
        } catch (Exception e) {
            PendoLogger.w(e, e.getMessage(), "PendoTooltipView getGravitiesOrderedAccordingToPreference");
            return arrayList;
        }
    }

    public void a(int i, int i2, int i3) {
        if (i3 == i) {
            return;
        }
        int paddingLeft = this.mGuideView.getPaddingLeft();
        int paddingTop = this.mGuideView.getPaddingTop();
        int paddingRight = this.mGuideView.getPaddingRight();
        int paddingBottom = this.mGuideView.getPaddingBottom();
        if (i3 == 0) {
            paddingRight -= i2;
        } else if (i3 == 1) {
            paddingLeft -= i2;
        } else if (i3 == 2) {
            paddingBottom -= i2;
        } else if (i3 == 3) {
            paddingTop -= i2;
        }
        if (i == 0) {
            paddingRight += i2;
            setTooltipPosition(0);
        } else if (i == 1) {
            paddingLeft += i2;
            setTooltipPosition(1);
        } else if (i == 2) {
            paddingBottom += i2;
            setTooltipPosition(2);
        } else if (i == 3) {
            paddingTop += i2;
            setTooltipPosition(3);
        } else if (i == 4) {
            setTooltipPosition(4);
        }
        this.mGuideView.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    @Override // sdk.pendo.io.views.custom.PendoFloatingVisualGuideView
    public boolean consumeTouchEventIfOnPendoView(MotionEvent motionEvent) {
        View view;
        if (!isAttached() || !isShown()) {
            return false;
        }
        if (e1.a(motionEvent, this.mGuideView, this.mWindowMarginX, this.mWindowMarginY).booleanValue()) {
            return true;
        }
        if (this.k == null) {
            touchOutsideOfFloatingGuide();
            return !this.mTouchPassThrough;
        }
        if (!this.mSeeThrough || (view = this.mAnchorViewWeakRef.get()) == null || !e1.a(motionEvent, view, this.mWindowMarginX, this.mWindowMarginY).booleanValue()) {
            return true;
        }
        touchOutsideOfFloatingGuide();
        return false;
    }

    protected void e(final View view) {
        WeakReference<View> weakReference;
        if (view != null && (weakReference = this.mAnchorViewWeakRef) != null) {
            view = weakReference.get();
        }
        if (view == null || view.getViewTreeObserver() == null || !view.getViewTreeObserver().isAlive()) {
            PendoLogger.e("PendoTooltipView removePreDrawObserver failed", new Object[0]);
        } else {
            sdk.pendo.io.u7.a.a.a(new Runnable() { // from class: sdk.pendo.io.o5.e$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.c(view);
                }
            });
        }
    }

    @Override // sdk.pendo.io.views.custom.PendoFloatingVisualGuideView
    public ViewGroup getViewGroupToTraverse() {
        return (ViewGroup) this.mGuideView;
    }

    @Override // sdk.pendo.io.views.custom.PendoFloatingVisualGuideView
    public boolean isAttached() {
        return this.mAttached;
    }

    @Override // sdk.pendo.io.views.custom.PendoFloatingVisualGuideView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mAttached) {
            super.onDraw(canvas);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (this.mAccessibilityManager.isTouchExplorationEnabled() && motionEvent.getPointerCount() == 1) {
            return onTouchEvent(sdk.pendo.io.s7.b.a(motionEvent));
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View view;
        View view2 = this.mGuideView;
        if (view2 != null) {
            view2.layout(view2.getLeft(), this.mGuideView.getTop(), this.mGuideView.getMeasuredWidth(), this.mGuideView.getMeasuredHeight());
        }
        if (z) {
            WeakReference<View> weakReference = this.mAnchorViewWeakRef;
            if (weakReference != null && (view = weakReference.get()) != null) {
                this.e = e1.a(view);
                view.getLocationInWindow(this.a);
                Rect rect = this.e;
                int[] iArr = this.a;
                rect.offsetTo(iArr[0], iArr[1]);
                this.c.set(this.e);
            }
            Rect rect2 = this.mScreenRectWithoutMargins;
            float f = rect2.right - rect2.left;
            View view3 = this.mGuideView;
            if (view3 == null || view3.getWidth() > f) {
                a(getGravitiesOrderedAccordingToPreference(), (int) f);
            } else {
                a(getGravitiesOrderedAccordingToPreference());
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        Object parent = getParent();
        if (!(parent instanceof View) || this.mGuideView == null) {
            return;
        }
        View view = (View) parent;
        int measuredWidth = view.getMeasuredWidth();
        setMeasuredDimension(measuredWidth, view.getMeasuredHeight());
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int paddingTop = (measuredWidth - getPaddingTop()) - getPaddingBottom();
        this.mGuideView.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(paddingTop, Integer.MIN_VALUE));
    }

    @Override // sdk.pendo.io.views.custom.PendoFloatingVisualGuideView
    public void removeFromParent() {
        ViewParent parent = getParent();
        if (parent == null || !isAttached()) {
            return;
        }
        c();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this);
        }
    }

    @Override // sdk.pendo.io.views.custom.PendoFloatingVisualGuideView
    protected void removeViewListeners(View view) {
        e(view);
        d(view);
        super.removeViewListeners(view);
    }

    void setBackDrop(a aVar) {
        this.k = aVar;
    }

    public void setTooltipPosition(int i) {
        this.j = i;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x004f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:16:0x0051 A[Catch: Exception -> 0x005a, TryCatch #0 {Exception -> 0x005a, blocks: (B:3:0x0001, B:5:0x002e, B:7:0x0038, B:11:0x0042, B:12:0x0045, B:16:0x0051, B:18:0x0055, B:8:0x003a, B:10:0x0040), top: B:23:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:18:0x0055 A[Catch: Exception -> 0x005a, TRY_LEAVE, TryCatch #0 {Exception -> 0x005a, blocks: (B:3:0x0001, B:5:0x002e, B:7:0x0038, B:11:0x0042, B:12:0x0045, B:16:0x0051, B:18:0x0055, B:8:0x003a, B:10:0x0040), top: B:23:0x0001 }] */
    private boolean a(int i, int i2, int i3, int i4) {
        int i5;
        Rect rect;
        int i6;
        try {
            Rect rect2 = this.mDrawRect;
            int iCenterX = this.c.centerX() - (i3 / 2);
            Rect rect3 = this.c;
            rect2.set(iCenterX, rect3.bottom + i, rect3.centerX() + (i3 / 2), this.c.bottom + i4 + i + this.i);
            if (!w0.a(this.mScreenRectWithoutMargins, this.mDrawRect)) {
                Rect rect4 = this.mDrawRect;
                int i7 = rect4.right;
                Rect rect5 = this.mScreenRectWithoutMargins;
                int i8 = rect5.right;
                if (i7 > i8) {
                    i5 = i8 - i7;
                } else {
                    int i9 = rect4.left;
                    int i10 = rect5.left;
                    if (i9 < i10) {
                        i5 = i10 - i9;
                    } else {
                        rect = this.mDrawRect;
                        if (rect.bottom > this.mScreenRectWithoutMargins.bottom) {
                            return true;
                        }
                        i6 = rect.top;
                        if (i6 < i2) {
                            rect.offset(0, i2 - i6);
                        }
                    }
                }
                rect4.offset(i5, 0);
                rect = this.mDrawRect;
                if (rect.bottom > this.mScreenRectWithoutMargins.bottom) {
                    return true;
                }
                i6 = rect.top;
                if (i6 < i2) {
                    rect.offset(0, i2 - i6);
                }
            }
        } catch (Exception e) {
            PendoLogger.w(e, e.getMessage(), "PendoTooltipView calculatePositionBottom");
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x004b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:16:0x004d A[Catch: Exception -> 0x0058, TryCatch #0 {Exception -> 0x0058, blocks: (B:3:0x0001, B:5:0x002c, B:7:0x0036, B:11:0x003e, B:12:0x0041, B:16:0x004d, B:18:0x0053, B:8:0x0038, B:10:0x003c), top: B:23:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:18:0x0053 A[Catch: Exception -> 0x0058, TRY_LEAVE, TryCatch #0 {Exception -> 0x0058, blocks: (B:3:0x0001, B:5:0x002c, B:7:0x0036, B:11:0x003e, B:12:0x0041, B:16:0x004d, B:18:0x0053, B:8:0x0038, B:10:0x003c), top: B:23:0x0001 }] */
    private boolean b(int i, int i2, int i3, int i4) {
        int i5;
        Rect rect;
        int i6;
        Rect rect2;
        int i7;
        int i8;
        try {
            Rect rect3 = this.mDrawRect;
            Rect rect4 = this.c;
            int i9 = ((rect4.left - i3) - i) - this.i;
            int iCenterY = rect4.centerY() - (i4 / 2);
            Rect rect5 = this.c;
            rect3.set(i9, iCenterY, rect5.left - i, rect5.centerY() + (i4 / 2));
            if (!w0.a(this.mScreenRectWithoutMargins, this.mDrawRect)) {
                Rect rect6 = this.mDrawRect;
                int i10 = rect6.bottom;
                int i11 = this.mScreenRectWithoutMargins.bottom;
                if (i10 > i11) {
                    i5 = i11 - i10;
                } else {
                    int i12 = rect6.top;
                    if (i12 < i2) {
                        i5 = i2 - i12;
                    } else {
                        rect = this.mDrawRect;
                        i6 = rect.left;
                        rect2 = this.mScreenRectWithoutMargins;
                        if (i6 < rect2.left) {
                            return true;
                        }
                        i7 = rect.right;
                        i8 = rect2.right;
                        if (i7 > i8) {
                            rect.offset(i8 - i7, 0);
                        }
                    }
                }
                rect6.offset(0, i5);
                rect = this.mDrawRect;
                i6 = rect.left;
                rect2 = this.mScreenRectWithoutMargins;
                if (i6 < rect2.left) {
                    return true;
                }
                i7 = rect.right;
                i8 = rect2.right;
                if (i7 > i8) {
                    rect.offset(i8 - i7, 0);
                }
            }
        } catch (Exception e) {
            PendoLogger.w(e, e.getMessage(), "PendoTooltipView calculatePositionLeft");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        view.getViewTreeObserver().removeOnPreDrawListener(this.m);
    }

    protected void d(final View view) {
        WeakReference<View> weakReference;
        if (view != null && (weakReference = this.mAnchorViewWeakRef) != null) {
            view = weakReference.get();
        }
        if (view == null || view.getViewTreeObserver() == null || !view.getViewTreeObserver().isAlive()) {
            PendoLogger.e("PendoTooltipView removeGlobalLayoutObserver failed", new Object[0]);
        } else {
            sdk.pendo.io.u7.a.a.a(new Runnable() { // from class: sdk.pendo.io.o5.e$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.b(view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b() {
        if (!this.mAttached) {
            d(null);
            return;
        }
        WeakReference<View> weakReference = this.mAnchorViewWeakRef;
        if (weakReference != null) {
            View view = weakReference.get();
            if (view == null) {
                PendoLogger.w("PendoTooltipView AnchorView is null", new Object[0]);
                return;
            }
            this.e = e1.a(view);
            view.getLocationInWindow(this.a);
            if (this.e.equals(this.d)) {
                return;
            }
            this.d.set(this.e);
            Rect rect = this.e;
            int[] iArr = this.a;
            rect.offsetTo(iArr[0], iArr[1]);
            this.c.set(this.e);
            a(getGravitiesOrderedAccordingToPreference());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(final List list) {
        sdk.pendo.io.u7.a.a.a(new Runnable() { // from class: sdk.pendo.io.o5.e$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(list);
            }
        });
    }

    private void d() {
        this.mScreenRect = e1.a(this.mRootView);
        updateScreenRectIgnoringMargins();
        Rect rect = this.e;
        int[] iArr = this.a;
        rect.offsetTo(iArr[0], iArr[1]);
        this.c.set(this.e);
        a(getGravitiesOrderedAccordingToPreference());
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0095 A[Catch: Exception -> 0x0119, TryCatch #0 {Exception -> 0x0119, blocks: (B:3:0x0002, B:7:0x000c, B:10:0x0014, B:12:0x0023, B:14:0x0032, B:16:0x0049, B:18:0x004f, B:32:0x0087, B:37:0x0091, B:39:0x0095, B:40:0x00b5, B:42:0x00d5, B:53:0x00f8, B:52:0x00f5, B:49:0x00ee, B:46:0x00e7, B:54:0x00fb, B:56:0x0104, B:20:0x0059, B:22:0x005f, B:25:0x006a, B:27:0x0070, B:29:0x007a, B:31:0x0080, B:36:0x008e, B:58:0x010c, B:60:0x0110, B:61:0x0113), top: B:66:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x00d5 A[Catch: Exception -> 0x0119, TryCatch #0 {Exception -> 0x0119, blocks: (B:3:0x0002, B:7:0x000c, B:10:0x0014, B:12:0x0023, B:14:0x0032, B:16:0x0049, B:18:0x004f, B:32:0x0087, B:37:0x0091, B:39:0x0095, B:40:0x00b5, B:42:0x00d5, B:53:0x00f8, B:52:0x00f5, B:49:0x00ee, B:46:0x00e7, B:54:0x00fb, B:56:0x0104, B:20:0x0059, B:22:0x005f, B:25:0x006a, B:27:0x0070, B:29:0x007a, B:31:0x0080, B:36:0x008e, B:58:0x010c, B:60:0x0110, B:61:0x0113), top: B:66:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:46:0x00e7 A[Catch: Exception -> 0x0119, TryCatch #0 {Exception -> 0x0119, blocks: (B:3:0x0002, B:7:0x000c, B:10:0x0014, B:12:0x0023, B:14:0x0032, B:16:0x0049, B:18:0x004f, B:32:0x0087, B:37:0x0091, B:39:0x0095, B:40:0x00b5, B:42:0x00d5, B:53:0x00f8, B:52:0x00f5, B:49:0x00ee, B:46:0x00e7, B:54:0x00fb, B:56:0x0104, B:20:0x0059, B:22:0x005f, B:25:0x006a, B:27:0x0070, B:29:0x007a, B:31:0x0080, B:36:0x008e, B:58:0x010c, B:60:0x0110, B:61:0x0113), top: B:66:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:49:0x00ee A[Catch: Exception -> 0x0119, TryCatch #0 {Exception -> 0x0119, blocks: (B:3:0x0002, B:7:0x000c, B:10:0x0014, B:12:0x0023, B:14:0x0032, B:16:0x0049, B:18:0x004f, B:32:0x0087, B:37:0x0091, B:39:0x0095, B:40:0x00b5, B:42:0x00d5, B:53:0x00f8, B:52:0x00f5, B:49:0x00ee, B:46:0x00e7, B:54:0x00fb, B:56:0x0104, B:20:0x0059, B:22:0x005f, B:25:0x006a, B:27:0x0070, B:29:0x007a, B:31:0x0080, B:36:0x008e, B:58:0x010c, B:60:0x0110, B:61:0x0113), top: B:66:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x00f5 A[Catch: Exception -> 0x0119, TryCatch #0 {Exception -> 0x0119, blocks: (B:3:0x0002, B:7:0x000c, B:10:0x0014, B:12:0x0023, B:14:0x0032, B:16:0x0049, B:18:0x004f, B:32:0x0087, B:37:0x0091, B:39:0x0095, B:40:0x00b5, B:42:0x00d5, B:53:0x00f8, B:52:0x00f5, B:49:0x00ee, B:46:0x00e7, B:54:0x00fb, B:56:0x0104, B:20:0x0059, B:22:0x005f, B:25:0x006a, B:27:0x0070, B:29:0x007a, B:31:0x0080, B:36:0x008e, B:58:0x010c, B:60:0x0110, B:61:0x0113), top: B:66:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x0104 A[Catch: Exception -> 0x0119, TryCatch #0 {Exception -> 0x0119, blocks: (B:3:0x0002, B:7:0x000c, B:10:0x0014, B:12:0x0023, B:14:0x0032, B:16:0x0049, B:18:0x004f, B:32:0x0087, B:37:0x0091, B:39:0x0095, B:40:0x00b5, B:42:0x00d5, B:53:0x00f8, B:52:0x00f5, B:49:0x00ee, B:46:0x00e7, B:54:0x00fb, B:56:0x0104, B:20:0x0059, B:22:0x005f, B:25:0x006a, B:27:0x0070, B:29:0x007a, B:31:0x0080, B:36:0x008e, B:58:0x010c, B:60:0x0110, B:61:0x0113), top: B:66:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:68:? A[RETURN, SYNTHETIC] */
    protected void a(List<Integer> list) {
        int backDropPaddingTop;
        int backDropPaddingRight;
        int i;
        boolean z;
        Point point;
        int i2;
        try {
            if (isAttached()) {
                if (list != null && !list.isEmpty()) {
                    int iIntValue = list.remove(0).intValue();
                    a aVar = this.k;
                    if (aVar != null) {
                        backDropPaddingTop = (int) aVar.getBackDropPaddingTop();
                        backDropPaddingRight = (int) this.k.getBackDropPaddingRight();
                    } else {
                        backDropPaddingTop = 0;
                        backDropPaddingRight = 0;
                    }
                    int i3 = this.mScreenRectWithoutMargins.top + this.mTopRule;
                    int width = this.mGuideView.getWidth();
                    int height = this.mGuideView.getHeight();
                    if (iIntValue == 3) {
                        if (a(backDropPaddingTop, i3, width, height)) {
                            PendoLogger.w("PendoTooltipView not enough space for BOTTOM", new Object[0]);
                            a(list);
                            return;
                        }
                        if (iIntValue != this.mGravity) {
                            PendoLogger.w("PendoTooltipView gravity changed from " + this.mGravity + " to " + iIntValue, new Object[0]);
                            this.mGravity = iIntValue;
                        }
                        this.mGuideView.setTranslationX(this.mDrawRect.left - this.mWindowMarginX);
                        this.mGuideView.setTranslationY(this.mDrawRect.top - this.mWindowMarginY);
                        if (this.mDrawable != null) {
                            a(iIntValue, this.g);
                            d dVar = this.mDrawable;
                            int i4 = this.mBorderPadding / 2;
                            z = this.f;
                            if (z) {
                                point = null;
                            } else {
                                point = this.g;
                            }
                            Point point2 = point;
                            if (z) {
                                i2 = 0;
                            } else {
                                i2 = this.i;
                            }
                            dVar.a(iIntValue, i4, point2, i2, z ? 0 : this.h);
                        }
                        Rect rect = this.mScreenRectWithoutMargins;
                        i = rect.right - rect.left;
                        if (i > 0) {
                            ((PendoLinearLayout) this.mGuideView).setLayoutMaxWidth(i);
                            return;
                        }
                        return;
                    }
                    if (iIntValue == 2) {
                        if (d(backDropPaddingTop, i3, width, height)) {
                            PendoLogger.w("PendoTooltipView not enough space for TOP", new Object[0]);
                            a(list);
                            return;
                        }
                        if (iIntValue != this.mGravity) {
                            PendoLogger.w("PendoTooltipView gravity changed from " + this.mGravity + " to " + iIntValue, new Object[0]);
                            this.mGravity = iIntValue;
                        }
                        this.mGuideView.setTranslationX(this.mDrawRect.left - this.mWindowMarginX);
                        this.mGuideView.setTranslationY(this.mDrawRect.top - this.mWindowMarginY);
                        if (this.mDrawable != null) {
                            a(iIntValue, this.g);
                            d dVar2 = this.mDrawable;
                            int i5 = this.mBorderPadding / 2;
                            z = this.f;
                            if (z) {
                                point = null;
                            } else {
                                point = this.g;
                            }
                            Point point3 = point;
                            if (z) {
                                i2 = 0;
                            } else {
                                i2 = this.i;
                            }
                            dVar2.a(iIntValue, i5, point3, i2, z ? 0 : this.h);
                        }
                        Rect rect2 = this.mScreenRectWithoutMargins;
                        i = rect2.right - rect2.left;
                        if (i > 0) {
                            ((PendoLinearLayout) this.mGuideView).setLayoutMaxWidth(i);
                            return;
                        }
                        return;
                    }
                    if (iIntValue == 1) {
                        if (c(backDropPaddingRight, i3, width, height)) {
                            PendoLogger.w("PendoTooltipView not enough space for RIGHT", new Object[0]);
                            a(list);
                            return;
                        }
                        if (iIntValue != this.mGravity) {
                            PendoLogger.w("PendoTooltipView gravity changed from " + this.mGravity + " to " + iIntValue, new Object[0]);
                            this.mGravity = iIntValue;
                        }
                        this.mGuideView.setTranslationX(this.mDrawRect.left - this.mWindowMarginX);
                        this.mGuideView.setTranslationY(this.mDrawRect.top - this.mWindowMarginY);
                        if (this.mDrawable != null) {
                            a(iIntValue, this.g);
                            d dVar3 = this.mDrawable;
                            int i6 = this.mBorderPadding / 2;
                            z = this.f;
                            if (z) {
                                point = null;
                            } else {
                                point = this.g;
                            }
                            Point point4 = point;
                            if (z) {
                                i2 = 0;
                            } else {
                                i2 = this.i;
                            }
                            dVar3.a(iIntValue, i6, point4, i2, z ? 0 : this.h);
                        }
                        Rect rect3 = this.mScreenRectWithoutMargins;
                        i = rect3.right - rect3.left;
                        if (i > 0) {
                            ((PendoLinearLayout) this.mGuideView).setLayoutMaxWidth(i);
                            return;
                        }
                        return;
                    }
                    if (iIntValue == 0) {
                        if (b(backDropPaddingRight, i3, width, height)) {
                            PendoLogger.w("PendoTooltipView not enough space for LEFT", new Object[0]);
                            a(list);
                            return;
                        }
                    } else if (iIntValue == 4) {
                        b(i3, width, height);
                    }
                    if (iIntValue != this.mGravity) {
                        PendoLogger.w("PendoTooltipView gravity changed from " + this.mGravity + " to " + iIntValue, new Object[0]);
                        this.mGravity = iIntValue;
                    }
                    this.mGuideView.setTranslationX(this.mDrawRect.left - this.mWindowMarginX);
                    this.mGuideView.setTranslationY(this.mDrawRect.top - this.mWindowMarginY);
                    if (this.mDrawable != null) {
                        a(iIntValue, this.g);
                        d dVar4 = this.mDrawable;
                        int i7 = this.mBorderPadding / 2;
                        z = this.f;
                        if (z) {
                            point = null;
                        } else {
                            point = this.g;
                        }
                        Point point5 = point;
                        if (z) {
                            i2 = 0;
                        } else {
                            i2 = this.i;
                        }
                        dVar4.a(iIntValue, i7, point5, i2, z ? 0 : this.h);
                    }
                    Rect rect4 = this.mScreenRectWithoutMargins;
                    i = rect4.right - rect4.left;
                    if (i > 0) {
                        ((PendoLinearLayout) this.mGuideView).setLayoutMaxWidth(i);
                        return;
                    }
                    return;
                }
                PendoFloatingVisualGuideView.OnFloatingGuideListener onFloatingGuideListener = this.mFloatingGuideListener;
                if (onFloatingGuideListener != null) {
                    onFloatingGuideListener.onShowFailed(this);
                }
                setVisibility(8);
            }
        } catch (Exception e) {
            PendoLogger.w(e, e.getMessage(), "PendoTooltipView calculatePositions");
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x005a  */
    /* JADX WARN: Code duplicated, block: B:25:0x006a A[Catch: Exception -> 0x0078, TryCatch #0 {Exception -> 0x0078, blocks: (B:4:0x0005, B:16:0x0044, B:17:0x0046, B:26:0x0070, B:24:0x0063, B:25:0x006a, B:6:0x0014, B:8:0x0023, B:9:0x0027, B:15:0x0040, B:11:0x002c, B:12:0x0031, B:14:0x0036), top: B:31:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:33:? A[RETURN, SYNTHETIC] */
    private void a(int i, Point point) {
        Rect rect;
        int i2;
        int iCenterY;
        int i3;
        try {
            if (i == 3) {
                point.x = this.c.centerX();
                iCenterY = this.c.bottom;
            } else if (i == 2) {
                point.x = this.c.centerX();
                iCenterY = this.c.top;
            } else {
                if (i != 1) {
                    if (i == 0) {
                        rect = this.c;
                        i2 = rect.left;
                    } else if (this.mGravity == 4) {
                        point.x = this.c.centerX();
                        rect = this.c;
                        iCenterY = rect.centerY();
                    }
                    int i4 = point.x;
                    Rect rect2 = this.mDrawRect;
                    int i5 = i4 - rect2.left;
                    point.x = i5;
                    i3 = point.y - rect2.top;
                    point.y = i3;
                    if (this.f) {
                    }
                    if (i != 0 || i == 1) {
                        point.y = i3 - (this.mBorderPadding / 2);
                    } else if (i == 2 || i == 3) {
                        point.x = i5 - (this.mBorderPadding / 2);
                    }
                    a(i, this.i, this.j);
                }
                rect = this.c;
                i2 = rect.right;
                point.x = i2;
                iCenterY = rect.centerY();
            }
            point.y = iCenterY;
            int i6 = point.x;
            Rect rect3 = this.mDrawRect;
            int i7 = i6 - rect3.left;
            point.x = i7;
            i3 = point.y - rect3.top;
            point.y = i3;
            if (this.f) {
                if (i != 0) {
                    point.y = i3 - (this.mBorderPadding / 2);
                } else {
                    point.y = i3 - (this.mBorderPadding / 2);
                }
                a(i, this.i, this.j);
            }
        } catch (Exception e) {
            PendoLogger.w(e, e.getMessage(), "PendoTooltipView getAnchorPoint");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        view.getViewTreeObserver().removeOnGlobalLayoutListener(this.n);
    }

    private void c() {
        a aVar;
        View viewFindViewById = getRootView().findViewById(R.id.content);
        if (!(viewFindViewById instanceof ViewGroup) || (aVar = this.k) == null) {
            return;
        }
        ((ViewGroup) viewFindViewById).removeView(aVar);
        this.k = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:20:0x0043 A[PHI: r3
      0x0043: PHI (r3v4 sdk.pendo.io.views.custom.PendoFloatingVisualGuideView$OnFloatingGuideListener) = 
      (r3v3 sdk.pendo.io.views.custom.PendoFloatingVisualGuideView$OnFloatingGuideListener)
      (r3v10 sdk.pendo.io.views.custom.PendoFloatingVisualGuideView$OnFloatingGuideListener)
     binds: [B:19:0x0041, B:12:0x002d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:31:0x0074  */
    public /* synthetic */ boolean a() {
        PendoFloatingVisualGuideView.OnFloatingGuideListener onFloatingGuideListener;
        boolean z;
        a aVar;
        if (this.mAttached) {
            WeakReference<View> weakReference = this.mAnchorViewWeakRef;
            if (weakReference != null && weakReference.get() != null) {
                View view = this.mAnchorViewWeakRef.get();
                if (e1.a(view, 0)) {
                    AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain();
                    view.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoObtain);
                    if (accessibilityNodeInfoObtain != null && !accessibilityNodeInfoObtain.isVisibleToUser() && (onFloatingGuideListener = this.mFloatingGuideListener) != null) {
                        onFloatingGuideListener.onShowFailed(this);
                    }
                } else {
                    onFloatingGuideListener = this.mFloatingGuideListener;
                    if (onFloatingGuideListener != null) {
                        onFloatingGuideListener.onShowFailed(this);
                    }
                }
                view.getLocationInWindow(this.a);
                if (this.b == null) {
                    int[] iArr = this.a;
                    this.b = new int[]{iArr[0], iArr[1]};
                }
                if (this.mGuideView != null) {
                    int[] iArr2 = this.a;
                    int i = iArr2[0];
                    int[] iArr3 = this.b;
                    if (i == iArr3[0] && iArr2[1] == iArr3[1]) {
                        z = false;
                    } else {
                        d();
                        z = true;
                    }
                } else {
                    z = false;
                }
                int[] iArr4 = this.b;
                int[] iArr5 = this.a;
                iArr4[0] = iArr5[0];
                iArr4[1] = iArr5[1];
                if (z && (aVar = this.k) != null) {
                    aVar.b();
                }
            }
        } else {
            PendoLogger.w("PendoTooltipView onPreDraw. not attached", new Object[0]);
            e(null);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(List list) {
        this.mGuideView.getViewTreeObserver().removeOnGlobalLayoutListener(this.l);
        a((List<Integer>) list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(i0.b bVar) {
        if (bVar == i0.b.DISABLED) {
            VisualGuidesManager.getInstance().removeShowingGuide();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.n);
        view.getViewTreeObserver().addOnPreDrawListener(this.m);
        view.addOnAttachStateChangeListener(this.mAnchorViewAttachedStateListener);
        if (view instanceof i0) {
            ((i0) view).a(this.o);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i) {
        this.mGuideView.getViewTreeObserver().addOnGlobalLayoutListener(this.l);
        ((PendoLinearLayout) this.mGuideView).setLayoutMaxWidth(i);
        this.mGuideView.requestLayout();
    }

    private void a(final List<Integer> list, final int i) {
        if (i <= 0) {
            return;
        }
        try {
            this.l = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: sdk.pendo.io.o5.e$$ExternalSyntheticLambda0
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public final void onGlobalLayout() {
                    this.f$0.c(list);
                }
            };
            sdk.pendo.io.u7.a.a.a(new Runnable() { // from class: sdk.pendo.io.o5.e$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(i);
                }
            });
        } catch (Exception e) {
            PendoLogger.w(e, e.getMessage(), "PendoTooltipView resizeAndCalcPositions");
        }
    }
}
