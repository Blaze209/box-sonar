package com.pspdfkit.internal.views.inspector.bottomsheet;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import com.google.android.material.R;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    public static final int J = R.style.Widget_Design_BottomSheet_Modal;
    public WeakReference<V> A;
    public WeakReference<View> B;
    public final ArrayList<b> C;
    public VelocityTracker D;
    public int E;
    public int F;
    public boolean G;
    public HashMap H;
    public final a I;
    public final int a;
    public boolean b;
    public final float c;
    public int d;
    public boolean e;
    public int f;
    public final boolean g;
    public MaterialShapeDrawable h;
    public ShapeAppearanceModel i;
    public boolean j;
    public final ValueAnimator k;
    public final int l;
    public int m;
    public int n;
    public final float o;
    public int p;
    public final float q;
    public boolean r;
    public boolean s;
    public int t;
    public ViewDragHelper u;
    public boolean v;
    public int w;
    public boolean x;
    public int y;
    public int z;

    public class a extends ViewDragHelper.Callback {
        public a() {
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final int clampViewPositionHorizontal(View view, int i, int i2) {
            return view.getLeft();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final int clampViewPositionVertical(View view, int i, int i2) {
            int iA = BottomSheetBehavior.this.a();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return MathUtils.clamp(i, iA, bottomSheetBehavior.r ? bottomSheetBehavior.z : bottomSheetBehavior.p);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final int getViewVerticalDragRange(View view) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return bottomSheetBehavior.r ? bottomSheetBehavior.z : bottomSheetBehavior.p;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final void onViewDragStateChanged(int i) {
            if (i == 1) {
                BottomSheetBehavior.this.d(1);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            BottomSheetBehavior.this.a(i2);
        }

        /* JADX WARN: Code duplicated, block: B:32:0x0088  */
        /* JADX WARN: Code duplicated, block: B:52:0x00fb  */
        /* JADX WARN: Code duplicated, block: B:54:0x0105  */
        /* JADX WARN: Code duplicated, block: B:56:0x011a  */
        /* JADX WARN: Code duplicated, block: B:57:0x011e  */
        /* JADX WARN: Code duplicated, block: B:59:0x0122  */
        /* JADX WARN: Code duplicated, block: B:61:0x0126  */
        /* JADX WARN: Code duplicated, block: B:63:0x0132  */
        /* JADX WARN: Code duplicated, block: B:64:0x0136  */
        /* JADX WARN: Code duplicated, block: B:65:0x0139  */
        /* JADX WARN: Code duplicated, block: B:67:0x014c  */
        /* JADX WARN: Code duplicated, block: B:68:0x014f  */
        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final void onViewReleased(View view, float f, float f2) {
            int top;
            BottomSheetBehavior bottomSheetBehavior;
            int i;
            int iAbs;
            int iAbs2;
            BottomSheetBehavior bottomSheetBehavior2;
            int i2;
            int iAbs3;
            BottomSheetBehavior bottomSheetBehavior3;
            int iAbs4;
            int iAbs5;
            BottomSheetBehavior bottomSheetBehavior4;
            BottomSheetBehavior bottomSheetBehavior5 = BottomSheetBehavior.this;
            int i3 = 6;
            if (f2 < 0.0f) {
                if (bottomSheetBehavior5.b) {
                    i2 = bottomSheetBehavior5.m;
                } else {
                    int top2 = view.getTop();
                    BottomSheetBehavior bottomSheetBehavior6 = BottomSheetBehavior.this;
                    int i4 = bottomSheetBehavior6.n;
                    if (top2 > i4) {
                        i2 = i4;
                    } else {
                        i2 = bottomSheetBehavior6.l;
                    }
                }
                i3 = 3;
            } else if (bottomSheetBehavior5.r) {
                if (!bottomSheetBehavior5.s) {
                    if (view.getTop() >= bottomSheetBehavior5.p) {
                        if (Math.abs(((0.1f * f2) + view.getTop()) - bottomSheetBehavior5.p) / (bottomSheetBehavior5.e ? Math.max(bottomSheetBehavior5.f, bottomSheetBehavior5.z - ((bottomSheetBehavior5.y * 9) / 16)) : bottomSheetBehavior5.d) > 0.5f) {
                        }
                    }
                    if (f2 != 0.0f) {
                        top = view.getTop();
                        bottomSheetBehavior = BottomSheetBehavior.this;
                        if (bottomSheetBehavior.b) {
                            iAbs4 = Math.abs(top - bottomSheetBehavior.m);
                            iAbs5 = Math.abs(top - BottomSheetBehavior.this.p);
                            bottomSheetBehavior4 = BottomSheetBehavior.this;
                            if (iAbs4 < iAbs5) {
                                i2 = bottomSheetBehavior4.m;
                                i3 = 3;
                            } else {
                                i2 = bottomSheetBehavior4.p;
                                i3 = 4;
                            }
                        } else {
                            i = bottomSheetBehavior.n;
                            if (top < i) {
                                iAbs3 = Math.abs(top - bottomSheetBehavior.p);
                                bottomSheetBehavior3 = BottomSheetBehavior.this;
                                if (top < iAbs3) {
                                    i2 = bottomSheetBehavior3.l;
                                    i3 = 3;
                                } else {
                                    i2 = bottomSheetBehavior3.n;
                                }
                            } else {
                                iAbs = Math.abs(top - i);
                                iAbs2 = Math.abs(top - BottomSheetBehavior.this.p);
                                bottomSheetBehavior2 = BottomSheetBehavior.this;
                                if (iAbs < iAbs2) {
                                    i2 = bottomSheetBehavior2.n;
                                } else {
                                    i2 = bottomSheetBehavior2.p;
                                    i3 = 4;
                                }
                            }
                        }
                    } else {
                        top = view.getTop();
                        bottomSheetBehavior = BottomSheetBehavior.this;
                        if (bottomSheetBehavior.b) {
                            iAbs4 = Math.abs(top - bottomSheetBehavior.m);
                            iAbs5 = Math.abs(top - BottomSheetBehavior.this.p);
                            bottomSheetBehavior4 = BottomSheetBehavior.this;
                            if (iAbs4 < iAbs5) {
                                i2 = bottomSheetBehavior4.m;
                                i3 = 3;
                            } else {
                                i2 = bottomSheetBehavior4.p;
                                i3 = 4;
                            }
                        } else {
                            i = bottomSheetBehavior.n;
                            if (top < i) {
                                iAbs3 = Math.abs(top - bottomSheetBehavior.p);
                                bottomSheetBehavior3 = BottomSheetBehavior.this;
                                if (top < iAbs3) {
                                    i2 = bottomSheetBehavior3.l;
                                    i3 = 3;
                                } else {
                                    i2 = bottomSheetBehavior3.n;
                                }
                            } else {
                                iAbs = Math.abs(top - i);
                                iAbs2 = Math.abs(top - BottomSheetBehavior.this.p);
                                bottomSheetBehavior2 = BottomSheetBehavior.this;
                                if (iAbs < iAbs2) {
                                    i2 = bottomSheetBehavior2.n;
                                } else {
                                    i2 = bottomSheetBehavior2.p;
                                    i3 = 4;
                                }
                            }
                        }
                    }
                }
                if (Math.abs(f) >= Math.abs(f2) || f2 <= 500.0f) {
                    int top3 = view.getTop();
                    BottomSheetBehavior bottomSheetBehavior7 = BottomSheetBehavior.this;
                    if (top3 > (bottomSheetBehavior7.a() + bottomSheetBehavior7.z) / 2) {
                        i2 = BottomSheetBehavior.this.z;
                        i3 = 5;
                    } else {
                        BottomSheetBehavior bottomSheetBehavior8 = BottomSheetBehavior.this;
                        if (bottomSheetBehavior8.b) {
                            i2 = bottomSheetBehavior8.m;
                        } else {
                            int iAbs6 = Math.abs(view.getTop() - BottomSheetBehavior.this.l);
                            int iAbs7 = Math.abs(view.getTop() - BottomSheetBehavior.this.n);
                            BottomSheetBehavior bottomSheetBehavior9 = BottomSheetBehavior.this;
                            if (iAbs6 < iAbs7) {
                                i2 = bottomSheetBehavior9.l;
                            } else {
                                i2 = bottomSheetBehavior9.n;
                            }
                        }
                        i3 = 3;
                    }
                } else {
                    i2 = BottomSheetBehavior.this.z;
                    i3 = 5;
                }
            } else if (f2 != 0.0f || Math.abs(f) > Math.abs(f2)) {
                top = view.getTop();
                bottomSheetBehavior = BottomSheetBehavior.this;
                if (bottomSheetBehavior.b) {
                    iAbs4 = Math.abs(top - bottomSheetBehavior.m);
                    iAbs5 = Math.abs(top - BottomSheetBehavior.this.p);
                    bottomSheetBehavior4 = BottomSheetBehavior.this;
                    if (iAbs4 < iAbs5) {
                        i2 = bottomSheetBehavior4.m;
                        i3 = 3;
                    } else {
                        i2 = bottomSheetBehavior4.p;
                        i3 = 4;
                    }
                } else {
                    i = bottomSheetBehavior.n;
                    if (top < i) {
                        iAbs3 = Math.abs(top - bottomSheetBehavior.p);
                        bottomSheetBehavior3 = BottomSheetBehavior.this;
                        if (top < iAbs3) {
                            i2 = bottomSheetBehavior3.l;
                            i3 = 3;
                        } else {
                            i2 = bottomSheetBehavior3.n;
                        }
                    } else {
                        iAbs = Math.abs(top - i);
                        iAbs2 = Math.abs(top - BottomSheetBehavior.this.p);
                        bottomSheetBehavior2 = BottomSheetBehavior.this;
                        if (iAbs < iAbs2) {
                            i2 = bottomSheetBehavior2.n;
                        } else {
                            i2 = bottomSheetBehavior2.p;
                            i3 = 4;
                        }
                    }
                }
            } else {
                BottomSheetBehavior bottomSheetBehavior10 = BottomSheetBehavior.this;
                if (bottomSheetBehavior10.b) {
                    i2 = bottomSheetBehavior10.p;
                } else {
                    int top4 = view.getTop();
                    int iAbs8 = Math.abs(top4 - BottomSheetBehavior.this.n);
                    int iAbs9 = Math.abs(top4 - BottomSheetBehavior.this.p);
                    BottomSheetBehavior bottomSheetBehavior11 = BottomSheetBehavior.this;
                    if (iAbs8 < iAbs9) {
                        i2 = bottomSheetBehavior11.n;
                    } else {
                        i2 = bottomSheetBehavior11.p;
                    }
                }
                i3 = 4;
            }
            BottomSheetBehavior.this.a(view, i3, i2, true);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final boolean tryCaptureView(View view, int i) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i2 = bottomSheetBehavior.t;
            if (i2 == 1 || bottomSheetBehavior.G) {
                return false;
            }
            if (i2 == 3 && bottomSheetBehavior.E == i) {
                WeakReference<View> weakReference = bottomSheetBehavior.B;
                View view2 = weakReference != null ? weakReference.get() : null;
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            WeakReference<V> weakReference2 = BottomSheetBehavior.this.A;
            return weakReference2 != null && weakReference2.get() == view;
        }
    }

    public static abstract class b {
        public abstract void a(View view);

        public abstract void a(View view, int i);
    }

    public class d implements Runnable {
        public final View a;
        public final int b;

        public d(View view, int i) {
            this.a = view;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ViewDragHelper viewDragHelper = BottomSheetBehavior.this.u;
            if (viewDragHelper != null && viewDragHelper.continueSettling(true)) {
                ViewCompat.postOnAnimation(this.a, this);
                return;
            }
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            if (bottomSheetBehavior.t == 2) {
                bottomSheetBehavior.d(this.b);
            }
        }
    }

    public BottomSheetBehavior() {
        this.a = 0;
        this.b = true;
        this.o = 0.5f;
        this.q = -1.0f;
        this.t = 4;
        this.C = new ArrayList<>();
        this.I = new a();
    }

    public final void a(boolean z) {
        int i;
        if (this.r != z) {
            this.r = z;
            if (!z && (i = this.t) == 5 && 4 != i) {
                WeakReference<V> weakReference = this.A;
                if (weakReference == null) {
                    this.t = 4;
                } else {
                    V v = weakReference.get();
                    if (v != null) {
                        ViewParent parent = v.getParent();
                        if (parent != null && parent.isLayoutRequested() && v.isAttachedToWindow()) {
                            v.post(new com.pspdfkit.internal.views.inspector.bottomsheet.a(this, v, 4));
                        } else {
                            a(v, 4);
                        }
                    }
                }
            }
            b();
        }
    }

    public final void b(int i) {
        V v;
        boolean z = this.e;
        if (i == -1) {
            if (z) {
                return;
            } else {
                this.e = true;
            }
        } else {
            if (!z && this.d == i) {
                return;
            }
            this.e = false;
            this.d = Math.max(0, i);
        }
        if (this.A != null) {
            int iMax = this.e ? Math.max(this.f, this.z - ((this.y * 9) / 16)) : this.d;
            boolean z2 = this.b;
            int i2 = this.z;
            if (z2) {
                this.p = Math.max(i2 - iMax, this.m);
            } else {
                this.p = i2 - iMax;
            }
            if (this.t != 4 || (v = this.A.get()) == null) {
                return;
            }
            v.requestLayout();
        }
    }

    public final void c(int i) {
        if (i == this.t) {
            return;
        }
        WeakReference<V> weakReference = this.A;
        if (weakReference == null) {
            if (i == 4 || i == 3 || i == 6 || (this.r && i == 5)) {
                this.t = i;
                return;
            }
            return;
        }
        V v = weakReference.get();
        if (v == null) {
            return;
        }
        ViewParent parent = v.getParent();
        if (parent != null && parent.isLayoutRequested() && v.isAttachedToWindow()) {
            v.post(new com.pspdfkit.internal.views.inspector.bottomsheet.a(this, v, i));
        } else {
            a(v, i);
        }
    }

    public final void d(int i) {
        V v;
        if (this.t == i) {
            return;
        }
        this.t = i;
        WeakReference<V> weakReference = this.A;
        if (weakReference == null || (v = weakReference.get()) == null) {
            return;
        }
        if (i == 3) {
            b(true);
        } else if (i == 6 || i == 5 || i == 4) {
            b(false);
        }
        e(i);
        for (int i2 = 0; i2 < this.C.size(); i2++) {
            this.C.get(i2).a(v, i);
        }
        b();
    }

    public final void e(int i) {
        ValueAnimator valueAnimator;
        if (i == 2) {
            return;
        }
        boolean z = i == 3;
        if (this.j != z) {
            this.j = z;
            if (this.h == null || (valueAnimator = this.k) == null) {
                return;
            }
            if (valueAnimator.isRunning()) {
                this.k.reverse();
                return;
            }
            float f = z ? 0.0f : 1.0f;
            this.k.setFloatValues(1.0f - f, f);
            this.k.start();
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        this.A = null;
        this.u = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.A = null;
        this.u = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        ViewDragHelper viewDragHelper;
        if (!v.isShown()) {
            this.v = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.E = -1;
            VelocityTracker velocityTracker = this.D;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.D = null;
            }
        }
        if (this.D == null) {
            this.D = VelocityTracker.obtain();
        }
        this.D.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x = (int) motionEvent.getX();
            this.F = (int) motionEvent.getY();
            if (this.t != 2) {
                WeakReference<View> weakReference = this.B;
                View view = weakReference != null ? weakReference.get() : null;
                if (view != null && coordinatorLayout.isPointInChildBounds(view, x, this.F)) {
                    this.E = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.G = true;
                }
            }
            this.v = this.E == -1 && !coordinatorLayout.isPointInChildBounds(v, x, this.F);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.G = false;
            this.E = -1;
            if (this.v) {
                this.v = false;
                return false;
            }
        }
        if (!this.v && (viewDragHelper = this.u) != null && viewDragHelper.shouldInterceptTouchEvent(motionEvent)) {
            return true;
        }
        WeakReference<View> weakReference2 = this.B;
        View view2 = weakReference2 != null ? weakReference2.get() : null;
        return (actionMasked != 2 || view2 == null || this.v || this.t == 1 || coordinatorLayout.isPointInChildBounds(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.u == null || Math.abs(((float) this.F) - motionEvent.getY()) <= ((float) this.u.getTouchSlop())) ? false : true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int i) {
        MaterialShapeDrawable materialShapeDrawable;
        if (ViewCompat.getFitsSystemWindows(coordinatorLayout) && !ViewCompat.getFitsSystemWindows(v)) {
            v.setFitsSystemWindows(true);
        }
        if (this.A == null) {
            this.f = coordinatorLayout.getResources().getDimensionPixelSize(com.pspdfkit.R.dimen.pspdf__design_bottom_sheet_peek_height_min);
            this.A = new WeakReference<>(v);
            if (this.g && (materialShapeDrawable = this.h) != null) {
                ViewCompat.setBackground(v, materialShapeDrawable);
            }
            MaterialShapeDrawable materialShapeDrawable2 = this.h;
            if (materialShapeDrawable2 != null) {
                float elevation = this.q;
                if (elevation == -1.0f) {
                    elevation = ViewCompat.getElevation(v);
                }
                materialShapeDrawable2.setElevation(elevation);
                boolean z = this.t == 3;
                this.j = z;
                this.h.setInterpolation(z ? 0.0f : 1.0f);
            }
            b();
            if (ViewCompat.getImportantForAccessibility(v) == 0) {
                ViewCompat.setImportantForAccessibility(v, 1);
            }
        }
        if (this.u == null) {
            this.u = ViewDragHelper.create(coordinatorLayout, this.I);
        }
        int top = v.getTop();
        coordinatorLayout.onLayoutChild(v, i);
        this.y = coordinatorLayout.getWidth();
        int height = coordinatorLayout.getHeight();
        this.z = height;
        this.m = Math.max(0, height - v.getHeight());
        int i2 = this.z;
        this.n = (int) ((1.0f - this.o) * i2);
        int iMax = this.e ? Math.max(this.f, i2 - ((this.y * 9) / 16)) : this.d;
        boolean z2 = this.b;
        int i3 = this.z;
        if (z2) {
            this.p = Math.max(i3 - iMax, this.m);
        } else {
            this.p = i3 - iMax;
        }
        int i4 = this.t;
        if (i4 == 3) {
            ViewCompat.offsetTopAndBottom(v, a());
        } else if (i4 == 6) {
            ViewCompat.offsetTopAndBottom(v, this.n);
        } else if (this.r && i4 == 5) {
            ViewCompat.offsetTopAndBottom(v, this.z);
        } else if (i4 == 4) {
            ViewCompat.offsetTopAndBottom(v, this.p);
        } else if (i4 == 1 || i4 == 2) {
            ViewCompat.offsetTopAndBottom(v, top - v.getTop());
        }
        this.B = new WeakReference<>(a(v));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
        WeakReference<View> weakReference = this.B;
        return weakReference != null && view == weakReference.get() && (this.t != 3 || super.onNestedPreFling(coordinatorLayout, v, view, f, f2));
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr, int i3) {
        if (i3 == 1) {
            return;
        }
        WeakReference<View> weakReference = this.B;
        if (view != (weakReference != null ? weakReference.get() : null)) {
            return;
        }
        int top = v.getTop();
        int i4 = top - i2;
        if (i2 > 0) {
            if (i4 < a()) {
                int iA = top - a();
                iArr[1] = iA;
                ViewCompat.offsetTopAndBottom(v, -iA);
                d(3);
            } else {
                iArr[1] = i2;
                ViewCompat.offsetTopAndBottom(v, -i2);
                d(1);
            }
        } else if (i2 < 0 && !view.canScrollVertically(-1)) {
            int i5 = this.p;
            if (i4 <= i5 || this.r) {
                iArr[1] = i2;
                ViewCompat.offsetTopAndBottom(v, -i2);
                d(1);
            } else {
                int i6 = top - i5;
                iArr[1] = i6;
                ViewCompat.offsetTopAndBottom(v, -i6);
                d(4);
            }
        }
        a(v.getTop());
        this.w = i2;
        this.x = true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        c cVar = (c) parcelable;
        super.onRestoreInstanceState(coordinatorLayout, v, cVar.getSuperState());
        int i = this.a;
        if (i != 0) {
            if (i == -1 || (i & 1) == 1) {
                this.d = cVar.b;
            }
            if (i == -1 || (i & 2) == 2) {
                this.b = cVar.c;
            }
            if (i == -1 || (i & 4) == 4) {
                this.r = cVar.d;
            }
            if (i == -1 || (i & 8) == 8) {
                this.s = cVar.e;
            }
        }
        int i2 = cVar.a;
        if (i2 == 1 || i2 == 2) {
            this.t = 4;
        } else {
            this.t = i2;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v) {
        return new c(super.onSaveInstanceState(coordinatorLayout, v), (BottomSheetBehavior<?>) this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
        this.w = 0;
        this.x = false;
        return (i & 2) != 0;
    }

    /* JADX WARN: Code duplicated, block: B:44:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:54:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:56:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:58:0x0101  */
    /* JADX WARN: Code duplicated, block: B:59:0x0104  */
    /* JADX WARN: Code duplicated, block: B:60:0x0107  */
    /* JADX WARN: Code duplicated, block: B:62:0x010b  */
    /* JADX WARN: Code duplicated, block: B:64:0x0115  */
    /* JADX WARN: Code duplicated, block: B:65:0x0118  */
    /* JADX WARN: Code duplicated, block: B:66:0x011b  */
    /* JADX WARN: Code duplicated, block: B:68:0x012a  */
    /* JADX WARN: Code duplicated, block: B:69:0x012d  */
    /* JADX WARN: Code duplicated, block: B:70:0x0130  */
    /* JADX WARN: Code duplicated, block: B:72:0x0134  */
    /* JADX WARN: Code duplicated, block: B:74:0x0138  */
    /* JADX WARN: Code duplicated, block: B:76:0x014d  */
    /* JADX WARN: Code duplicated, block: B:78:0x0151  */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i) {
        float xVelocity;
        int top;
        int iA;
        int top2;
        int i2;
        int i3 = 3;
        if (v.getTop() == a()) {
            d(3);
            return;
        }
        WeakReference<View> weakReference = this.B;
        if (weakReference != null && view == weakReference.get() && this.x) {
            VelocityTracker velocityTracker = this.D;
            float yVelocity = 0.0f;
            if (velocityTracker == null) {
                xVelocity = 0.0f;
            } else {
                velocityTracker.computeCurrentVelocity(1000, this.c);
                xVelocity = this.D.getXVelocity(this.E);
            }
            VelocityTracker velocityTracker2 = this.D;
            if (velocityTracker2 != null) {
                velocityTracker2.computeCurrentVelocity(1000, this.c);
                yVelocity = this.D.getYVelocity(this.E);
            }
            if (this.w > 0) {
                iA = a();
            } else if (this.r) {
                if (!this.s) {
                    if (v.getTop() >= this.p) {
                        if (Math.abs(((0.1f * yVelocity) + v.getTop()) - this.p) / (this.e ? Math.max(this.f, this.z - ((this.y * 9) / 16)) : this.d) > 0.5f) {
                        }
                    }
                    if (this.w == 0) {
                        top2 = v.getTop();
                        if (this.b) {
                            i2 = this.n;
                            if (top2 < i2) {
                                if (top2 < Math.abs(top2 - this.p)) {
                                    iA = this.l;
                                } else {
                                    iA = this.n;
                                }
                            } else if (Math.abs(top2 - i2) < Math.abs(top2 - this.p)) {
                                iA = this.n;
                            } else {
                                iA = this.p;
                                i3 = 4;
                            }
                            i3 = 6;
                        } else if (Math.abs(top2 - this.m) < Math.abs(top2 - this.p)) {
                            iA = this.m;
                        } else {
                            iA = this.p;
                            i3 = 4;
                        }
                    } else {
                        if (this.b) {
                            iA = this.p;
                        } else {
                            top = v.getTop();
                            if (Math.abs(top - this.n) < Math.abs(top - this.p)) {
                                iA = this.n;
                                i3 = 6;
                            } else {
                                iA = this.p;
                            }
                        }
                        i3 = 4;
                    }
                }
                if (Math.abs(xVelocity) >= Math.abs(yVelocity) || yVelocity <= 500.0f) {
                    if (v.getTop() > (a() + this.z) / 2) {
                        iA = this.z;
                        i3 = 5;
                    } else if (this.b) {
                        iA = this.m;
                    } else if (Math.abs(v.getTop() - this.l) < Math.abs(v.getTop() - this.n)) {
                        iA = this.l;
                    } else {
                        iA = this.n;
                        i3 = 6;
                    }
                } else {
                    iA = this.z;
                    i3 = 5;
                }
            } else if (this.w == 0) {
                top2 = v.getTop();
                if (this.b) {
                    i2 = this.n;
                    if (top2 < i2) {
                        if (top2 < Math.abs(top2 - this.p)) {
                            iA = this.l;
                        } else {
                            iA = this.n;
                        }
                    } else if (Math.abs(top2 - i2) < Math.abs(top2 - this.p)) {
                        iA = this.n;
                    } else {
                        iA = this.p;
                        i3 = 4;
                    }
                    i3 = 6;
                } else if (Math.abs(top2 - this.m) < Math.abs(top2 - this.p)) {
                    iA = this.m;
                } else {
                    iA = this.p;
                    i3 = 4;
                }
            } else {
                if (this.b) {
                    iA = this.p;
                } else {
                    top = v.getTop();
                    if (Math.abs(top - this.n) < Math.abs(top - this.p)) {
                        iA = this.n;
                        i3 = 6;
                    } else {
                        iA = this.p;
                    }
                }
                i3 = 4;
            }
            a((View) v, i3, iA, false);
            this.x = false;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.t == 1 && actionMasked == 0) {
            return true;
        }
        ViewDragHelper viewDragHelper = this.u;
        if (viewDragHelper != null) {
            viewDragHelper.processTouchEvent(motionEvent);
        }
        if (actionMasked == 0) {
            this.E = -1;
            VelocityTracker velocityTracker = this.D;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.D = null;
            }
        }
        if (this.D == null) {
            this.D = VelocityTracker.obtain();
        }
        this.D.addMovement(motionEvent);
        if (actionMasked == 2 && !this.v && Math.abs(this.F - motionEvent.getY()) > this.u.getTouchSlop()) {
            this.u.captureChildView(v, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.v;
    }

    public static class c extends AbsSavedState {
        public static final Parcelable.Creator<c> CREATOR = new a();
        public final int a;
        public final int b;
        public final boolean c;
        public final boolean d;
        public final boolean e;

        public class a implements Parcelable.ClassLoaderCreator<c> {
            @Override // android.os.Parcelable.ClassLoaderCreator
            public final c createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new c(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int i) {
                return new c[i];
            }

            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel parcel) {
                return new c(parcel, (ClassLoader) null);
            }
        }

        public c(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.a = parcel.readInt();
            this.b = parcel.readInt();
            this.c = parcel.readInt() == 1;
            this.d = parcel.readInt() == 1;
            this.e = parcel.readInt() == 1;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c ? 1 : 0);
            parcel.writeInt(this.d ? 1 : 0);
            parcel.writeInt(this.e ? 1 : 0);
        }

        public c(Parcelable parcelable, BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.a = bottomSheetBehavior.t;
            this.b = bottomSheetBehavior.d;
            this.c = bottomSheetBehavior.b;
            this.d = bottomSheetBehavior.r;
            this.e = bottomSheetBehavior.s;
        }
    }

    public static View a(View view) {
        if (ViewCompat.isNestedScrollingEnabled(view)) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View viewA = a(viewGroup.getChildAt(i));
            if (viewA != null) {
                return viewA;
            }
        }
        return null;
    }

    public final void b(boolean z) {
        WeakReference<V> weakReference = this.A;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = weakReference.get().getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z) {
                if (this.H != null) {
                    return;
                } else {
                    this.H = new HashMap(childCount);
                }
            }
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if (childAt != this.A.get() && z) {
                    this.H.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                }
            }
            if (z) {
                return;
            }
            this.H = null;
        }
    }

    public final void a(Context context, AttributeSet attributeSet, boolean z, ColorStateList colorStateList) {
        if (this.g) {
            this.i = ShapeAppearanceModel.builder(context, attributeSet, R.attr.bottomSheetStyle, J).build();
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this.i);
            this.h = materialShapeDrawable;
            materialShapeDrawable.initializeElevationOverlay(context);
            if (z && colorStateList != null) {
                this.h.setFillColor(colorStateList);
                return;
            }
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(android.R.attr.colorBackground, typedValue, true);
            this.h.setTint(typedValue.data);
        }
    }

    public final int a() {
        return this.b ? this.m : this.l;
    }

    public final void a(View view, int i) {
        int iA;
        int i2;
        if (i == 4) {
            iA = this.p;
        } else if (i == 6) {
            iA = this.n;
            if (this.b && iA <= (i2 = this.m)) {
                i = 3;
                iA = i2;
            }
        } else if (i == 3) {
            iA = a();
        } else if (this.r && i == 5) {
            iA = this.z;
        } else {
            throw new IllegalArgumentException("Illegal state argument: " + i);
        }
        a(view, i, iA, false);
    }

    public final void a(View view, int i, int i2, boolean z) {
        boolean zSmoothSlideViewTo;
        ViewDragHelper viewDragHelper = this.u;
        if (z) {
            zSmoothSlideViewTo = viewDragHelper.settleCapturedViewAt(view.getLeft(), i2);
        } else {
            zSmoothSlideViewTo = viewDragHelper.smoothSlideViewTo(view, view.getLeft(), i2);
        }
        if (zSmoothSlideViewTo) {
            d(2);
            e(i);
            ViewCompat.postOnAnimation(view, new d(view, i));
            return;
        }
        d(i);
    }

    public final void a(int i) {
        V v = this.A.get();
        if (v == null || this.C.isEmpty()) {
            return;
        }
        if (i <= this.p) {
            a();
        }
        for (int i2 = 0; i2 < this.C.size(); i2++) {
            this.C.get(i2).a(v);
        }
    }

    public final void b() {
        V v;
        WeakReference<V> weakReference = this.A;
        if (weakReference == null || (v = weakReference.get()) == null) {
            return;
        }
        ViewCompat.removeAccessibilityAction(v, 524288);
        ViewCompat.removeAccessibilityAction(v, 262144);
        ViewCompat.removeAccessibilityAction(v, 1048576);
        if (this.r && this.t != 5) {
            ViewCompat.replaceAccessibilityAction(v, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, null, new com.pspdfkit.internal.views.inspector.bottomsheet.c(this, 5));
        }
        int i = this.t;
        if (i == 3) {
            ViewCompat.replaceAccessibilityAction(v, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, null, new com.pspdfkit.internal.views.inspector.bottomsheet.c(this, this.b ? 4 : 6));
            return;
        }
        if (i == 4) {
            ViewCompat.replaceAccessibilityAction(v, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, null, new com.pspdfkit.internal.views.inspector.bottomsheet.c(this, this.b ? 3 : 6));
        } else {
            if (i != 6) {
                return;
            }
            ViewCompat.replaceAccessibilityAction(v, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, null, new com.pspdfkit.internal.views.inspector.bottomsheet.c(this, 4));
            ViewCompat.replaceAccessibilityAction(v, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, null, new com.pspdfkit.internal.views.inspector.bottomsheet.c(this, 3));
        }
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        int iMax;
        int i;
        int i2;
        super(context, attributeSet);
        this.a = 0;
        this.b = true;
        this.o = 0.5f;
        this.q = -1.0f;
        this.t = 4;
        this.C = new ArrayList<>();
        this.I = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BottomSheetBehavior_Layout);
        this.g = typedArrayObtainStyledAttributes.hasValue(R.styleable.BottomSheetBehavior_Layout_shapeAppearance);
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.BottomSheetBehavior_Layout_backgroundTint)) {
            a(context, attributeSet, true, MaterialResources.getColorStateList(context, typedArrayObtainStyledAttributes, R.styleable.BottomSheetBehavior_Layout_backgroundTint));
        } else {
            a(context, attributeSet, false, (ColorStateList) null);
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.k = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(500L);
        valueAnimatorOfFloat.addUpdateListener(new com.pspdfkit.internal.views.inspector.bottomsheet.b(this));
        this.q = typedArrayObtainStyledAttributes.getDimension(R.styleable.BottomSheetBehavior_Layout_android_elevation, -1.0f);
        TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight);
        if (typedValuePeekValue != null && (i2 = typedValuePeekValue.data) == -1) {
            b(i2);
        } else {
            b(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
        }
        boolean z = typedArrayObtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false);
        if (this.r != z) {
            this.r = z;
            if (!z && (i = this.t) == 5 && 4 != i) {
                WeakReference<V> weakReference = this.A;
                if (weakReference == null) {
                    this.t = 4;
                } else {
                    V v = weakReference.get();
                    if (v != null) {
                        ViewParent parent = v.getParent();
                        if (parent != null && parent.isLayoutRequested() && v.isAttachedToWindow()) {
                            v.post(new com.pspdfkit.internal.views.inspector.bottomsheet.a(this, v, 4));
                        } else {
                            a(v, 4);
                        }
                    }
                }
            }
            b();
        }
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true);
        if (this.b != z2) {
            this.b = z2;
            if (this.A != null) {
                if (this.e) {
                    iMax = Math.max(this.f, this.z - ((this.y * 9) / 16));
                } else {
                    iMax = this.d;
                }
                boolean z3 = this.b;
                int i3 = this.z;
                if (z3) {
                    this.p = Math.max(i3 - iMax, this.m);
                } else {
                    this.p = i3 - iMax;
                }
            }
            d((this.b && this.t == 6) ? 3 : this.t);
            b();
        }
        this.s = typedArrayObtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false);
        this.a = typedArrayObtainStyledAttributes.getInt(R.styleable.BottomSheetBehavior_Layout_behavior_saveFlags, 0);
        float f = typedArrayObtainStyledAttributes.getFloat(R.styleable.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, 0.5f);
        if (f > 0.0f && f < 1.0f) {
            this.o = f;
            if (this.A != null) {
                this.n = (int) ((1.0f - f) * this.z);
            }
            int i4 = typedArrayObtainStyledAttributes.getInt(R.styleable.BottomSheetBehavior_Layout_behavior_expandedOffset, 0);
            if (i4 >= 0) {
                this.l = i4;
                typedArrayObtainStyledAttributes.recycle();
                this.c = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
                return;
            }
            throw new IllegalArgumentException("offset must be greater than or equal to 0");
        }
        throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
    }
}
