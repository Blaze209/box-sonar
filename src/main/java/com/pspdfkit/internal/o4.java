package com.pspdfkit.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewGroupKt;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.FreeTextAnnotation;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.configuration.theming.AnnotationSelectionViewThemeConfiguration;
import com.pspdfkit.ui.overlay.OverlayLayoutParams;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class o4 extends dw {
    public static final /* synthetic */ int N = 0;
    public final a A;
    public final ArrayList B;
    public boolean C;
    public boolean D;
    public float E;
    public int F;
    public float G;
    public boolean H;
    public final Rect I;
    public boolean J;
    public final Rect K;
    public final Rect L;
    public final Lazy M;
    public final dw d;
    public int e;
    public q4 f;
    public final Paint g;
    public Drawable h;
    public Drawable i;
    public Integer j;
    public final u00 k;
    public final jz l;
    public n0 m;
    public final EnumMap n;
    public final Paint o;
    public final Paint p;
    public final Paint q;
    public int r;
    public b s;
    public float t;
    public final PointF u;
    public final float v;
    public ValueAnimator w;
    public final EnumMap x;
    public final int y;
    public int z;

    public static final class a extends Handler {
        public final WeakReference<o4> a;

        public a(o4 o4Var) {
            super(Looper.getMainLooper());
            this.a = new WeakReference<>(o4Var);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            message.getClass();
            if (message.what != 1) {
                super.handleMessage(message);
                return;
            }
            o4 o4Var = this.a.get();
            if (o4Var != null) {
                o4Var.a();
            }
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.pspdfkit.internal.o4$b[], still in use, count: 1, list:
      (r0v1 com.pspdfkit.internal.o4$b[]) from 0x0061: INVOKE (r0v1 com.pspdfkit.internal.o4$b[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
    	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
    	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:257)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:187)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class b {
        TOP_LEFT,
        TOP_CENTER,
        TOP_RIGHT,
        CENTER_LEFT,
        CENTER_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_CENTER,
        BOTTOM_RIGHT,
        ROTATION;

        static {
            EnumEntriesKt.enumEntries(bVarArr);
        }

        public b() {
            super(str, i);
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) j.clone();
        }
    }

    public static final class c extends AnimatorListenerAdapter {
        public final /* synthetic */ boolean b;

        public c(boolean z) {
            this.b = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator animator) {
            animator.getClass();
            o4 o4Var = o4.this;
            if (o4Var.w != animator) {
                return;
            }
            if (this.b) {
                o4Var.r = -1;
                o4Var.s = null;
                o4Var.t = 0.0f;
                o4Var.invalidate();
            }
            o4.this.w = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            animator.getClass();
            o4 o4Var = o4.this;
            if (o4Var.w != animator) {
                return;
            }
            if (this.b) {
                o4Var.r = -1;
                o4Var.s = null;
                o4Var.t = 0.0f;
                o4Var.invalidate();
            }
            o4.this.w = null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o4(dw dwVar, PdfConfiguration pdfConfiguration, w4 w4Var) {
        super(dwVar.getContext());
        pdfConfiguration.getClass();
        w4Var.getClass();
        this.d = dwVar;
        Paint paint = new Paint(1);
        this.g = paint;
        this.l = new jz(this, pdfConfiguration);
        Context context = dwVar.getContext();
        context.getClass();
        this.m = new n0(context);
        Paint paint2 = new Paint(1);
        this.q = paint2;
        this.r = -1;
        this.u = new PointF();
        this.A = new a(this);
        this.B = new ArrayList();
        this.H = true;
        this.I = new Rect();
        this.J = true;
        this.K = new Rect();
        this.L = new Rect();
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        Paint paint3 = new Paint(1);
        this.o = paint3;
        Paint.Style style2 = Paint.Style.FILL;
        paint3.setStyle(style2);
        Paint paint4 = new Paint(1);
        this.p = paint4;
        paint4.setStyle(style2);
        paint2.setStyle(style);
        Context context2 = dwVar.getContext();
        context2.getClass();
        DisplayMetrics displayMetrics = context2.getResources().getDisplayMetrics();
        displayMetrics.getClass();
        paint2.setStrokeWidth(TypedValue.applyDimension(1, 2.0f, displayMetrics));
        EnumMap enumMap = new EnumMap(b.class);
        this.x = enumMap;
        enumMap.put(b.TOP_LEFT, new Point());
        enumMap.put(b.TOP_CENTER, new Point());
        enumMap.put(b.TOP_RIGHT, new Point());
        enumMap.put(b.CENTER_LEFT, new Point());
        enumMap.put(b.CENTER_RIGHT, new Point());
        enumMap.put(b.BOTTOM_LEFT, new Point());
        enumMap.put(b.BOTTOM_CENTER, new Point());
        enumMap.put(b.BOTTOM_RIGHT, new Point());
        enumMap.put(b.ROTATION, new Point());
        this.n = new EnumMap(b.class);
        Context context3 = dwVar.getContext();
        context3.getClass();
        this.y = (int) un.a(context3, 1, 24);
        Context context4 = dwVar.getContext();
        context4.getClass();
        DisplayMetrics displayMetrics2 = context4.getResources().getDisplayMetrics();
        displayMetrics2.getClass();
        this.v = TypedValue.applyDimension(1, 2.0f, displayMetrics2);
        setWillNotDraw(false);
        this.k = new u00(this);
        a(w4Var);
        setFocusable(true);
        setFocusableInTouchMode(true);
        OverlayLayoutParams overlayLayoutParams = new OverlayLayoutParams();
        overlayLayoutParams.layoutPosition = OverlayLayoutParams.LayoutPosition.CENTER;
        setLayoutParams(overlayLayoutParams);
        this.M = LazyKt.lazy(new Function0() { // from class: com.pspdfkit.internal.o4$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Float.valueOf(o4.a(this.f$0));
            }
        });
    }

    private final float getEditHandleTouchTargetRadiusPx() {
        return ((Number) this.M.getValue()).floatValue();
    }

    private final double getRotationHandleRadius() {
        Drawable drawable = (Drawable) this.n.get(b.ROTATION);
        if (drawable == null) {
            drawable = this.i;
        }
        return drawable != null ? Math.max(0.0d, (((double) Math.min(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight())) / ((double) 2)) - (((double) this.g.getStrokeWidth()) / 2.0d)) : this.z;
    }

    private final Rect getSelectionBoundingBox() {
        Rect rect = new Rect();
        Rect rect2 = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            Rect rectA = a(getChildAt(i), rect);
            rect2.left = Math.min(rectA.left, rect2.left);
            rect2.top = Math.min(rectA.top, rect2.top);
            rect2.bottom = Math.max(rectA.bottom, rect2.bottom);
            rect2.right = Math.max(rectA.right, rect2.right);
        }
        return rect2;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0012  */
    private final float getTouchedHandleVisualRadiusPx() {
        Drawable drawable;
        b bVar = this.s;
        if (bVar == null) {
            drawable = this.i;
        } else {
            drawable = (Drawable) this.n.get(bVar);
            if (drawable == null) {
                drawable = this.i;
            }
            if (drawable == null) {
                drawable = this.i;
            }
        }
        return (drawable == null || drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) ? this.z : Math.min(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight()) / 2.0f;
    }

    public final void a(w4 w4Var) {
        w4Var.getClass();
        this.g.setColor(w4Var.b);
        this.g.setStrokeWidth(w4Var.a);
        this.o.setColor(w4Var.c);
        this.p.setColor(w4Var.d);
        this.i = a(w4Var.e);
        this.j = null;
        this.n.put(b.TOP_LEFT, a(w4Var.n));
        this.n.put(b.TOP_CENTER, a(w4Var.o));
        this.n.put(b.TOP_RIGHT, a(w4Var.p));
        this.n.put(b.CENTER_LEFT, a(w4Var.q));
        this.n.put(b.CENTER_RIGHT, a(w4Var.r));
        this.n.put(b.BOTTOM_LEFT, a(w4Var.s));
        this.n.put(b.BOTTOM_CENTER, a(w4Var.t));
        this.n.put(b.BOTTOM_RIGHT, a(w4Var.u));
        this.n.put(b.ROTATION, a(w4Var.v));
        this.h = a(w4Var.w);
        int i = w4Var.f;
        setPadding(i, i, i, i);
        setClipToPadding(false);
        int i2 = i / 2;
        this.z = i2;
        u00 u00Var = this.k;
        u00Var.g = i2;
        u00Var.h = true;
    }

    public final z4 b() {
        if (getChildCount() < 1 || getChildCount() <= 0) {
            return null;
        }
        KeyEvent.Callback childAt = getChildAt(0);
        childAt.getClass();
        return (z4) childAt;
    }

    public final List<z4<Annotation>> c() {
        if (this.A.hasMessages(1)) {
            a();
            this.A.removeMessages(1);
        }
        u00 u00Var = this.k;
        u00Var.getClass();
        u00Var.f = CollectionsKt.emptyList();
        u00Var.l.setEmpty();
        List<z4<Annotation>> list = SequencesKt.toList(SequencesKt.mapNotNull(ViewGroupKt.getChildren(this), new Function1() { // from class: com.pspdfkit.internal.o4$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return o4.a((View) obj);
            }
        }));
        q4 q4Var = this.f;
        if (q4Var != null) {
            q4Var.k();
        }
        list.getClass();
        return list;
    }

    public final void d() {
        OverlayLayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            layoutParams.pageRect.getScreenRect().set(getSelectionBoundingBox());
            layoutParams.pageRect.updatePageRect(this.a);
        } else {
            layoutParams = null;
        }
        setLayoutParams(layoutParams);
    }

    /* JADX WARN: Code duplicated, block: B:61:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:83:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:85:0x0204  */
    /* JADX WARN: Code duplicated, block: B:93:0x021b  */
    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        int i;
        Point point;
        int i2;
        Integer numValueOf;
        PointF pointF;
        q4 q4Var;
        q4 q4Var2;
        Drawable drawable;
        q4 q4Var3;
        canvas.getClass();
        super.dispatchDraw(canvas);
        q4 q4Var4 = this.f;
        if (q4Var4 == null) {
            return;
        }
        boolean z = (this.h == null || q4Var4.j() || (q4Var3 = this.f) == null || !q4Var3.f() || !q4Var3.d() || q4Var3.c()) ? false : true;
        if (z && (q4Var2 = this.f) != null && (drawable = this.h) != null) {
            u00 u00Var = this.k;
            Rect rect = this.I;
            int width = getWidth();
            int height = getHeight();
            u00Var.getClass();
            rect.getClass();
            int i3 = width / 2;
            int i4 = height / 2;
            RectF rectF = u00Var.l;
            double dSqrt = Math.sqrt(Math.pow((((double) rectF.height()) / 2.0d) + ((double) u00Var.g), 2.0d) + Math.pow((((double) rectF.width()) / 2.0d) + ((double) u00Var.g), 2.0d));
            double dAtan2 = Math.atan2((((double) rectF.height()) / 2.0d) + ((double) u00Var.g), (((double) rectF.width()) / 2.0d) + ((double) u00Var.g)) - 3.141592653589793d;
            int iCos = (int) (Math.cos(dAtan2) * dSqrt);
            int iSin = (int) (Math.sin(dAtan2) * dSqrt);
            rect.set(i3 + iCos, i4 + iSin, i3 - iCos, i4 - iSin);
            Rect rect2 = this.I;
            drawable.setBounds(rect2.left, rect2.top, rect2.right, rect2.bottom);
            float fCenterX = this.I.centerX();
            float fCenterY = this.I.centerY();
            float pageRotation = this.E + q4Var2.getPageRotation();
            int iSave = canvas.save();
            canvas.rotate(pageRotation, fCenterX, fCenterY);
            try {
                drawable.draw(canvas);
                canvas.restoreToCount(iSave);
            } catch (Throwable th) {
                canvas.restoreToCount(iSave);
                throw th;
            }
        }
        if (getChildCount() > 1) {
            int i5 = this.z / 2;
            for (View view : ViewGroupKt.getChildren(this)) {
                int x = (int) view.getX();
                int y = (int) view.getY();
                this.L.set(x, y, view.getWidth() + x, view.getHeight() + y);
                int i6 = -i5;
                this.L.inset(i6, i6);
                canvas.drawRect(this.L, this.g);
            }
        }
        jz jzVar = this.l;
        Path path = jzVar.e;
        if (path != null) {
            canvas.drawPath(path, jzVar.d);
        }
        if (z || (q4Var = this.f) == null || !q4Var.f() || !q4Var.d() || q4Var.c()) {
            i = 0;
        } else {
            canvas.drawRect(this.K, this.g);
            u00 u00Var2 = this.k;
            Paint paint = this.g;
            u00Var2.getClass();
            paint.getClass();
            if (u00Var2.a()) {
                i = 0;
                List<PointF> listB = u00Var2.b(u00Var2.f.get(0));
                int size = listB.size();
                int i7 = 0;
                while (i7 < size) {
                    PointF pointF2 = listB.get(i7 % listB.size());
                    int i8 = i7 + 1;
                    PointF pointF3 = listB.get(i8 % listB.size());
                    canvas.drawLine(pointF2.x, pointF2.y, pointF3.x, pointF3.y, paint);
                    i7 = i8;
                }
            } else {
                i = 0;
            }
        }
        if (this.J && this.t > 0.0f) {
            b bVar = this.s;
            Integer num = null;
            if (bVar == null) {
                i2 = this.r;
                numValueOf = Integer.valueOf(i2);
                if (i2 >= 0 && i2 < this.B.size() && q4Var4.e() && q4Var4.b(i2)) {
                    num = numValueOf;
                }
                if (num != null) {
                    pointF = (PointF) this.B.get(num.intValue());
                    this.q.setColor(this.o.getColor());
                    canvas.drawCircle(pointF.x, pointF.y, this.t, this.q);
                }
            } else {
                if (!q4Var4.g() || !q4Var4.a(bVar)) {
                    bVar = null;
                }
                if (bVar == null) {
                    i2 = this.r;
                    numValueOf = Integer.valueOf(i2);
                    if (i2 >= 0) {
                        num = numValueOf;
                    }
                    if (num != null) {
                        pointF = (PointF) this.B.get(num.intValue());
                        this.q.setColor(this.o.getColor());
                        canvas.drawCircle(pointF.x, pointF.y, this.t, this.q);
                    }
                } else {
                    Point point2 = (Point) this.x.get(bVar);
                    if (point2 != null) {
                        this.u.set(point2.x, point2.y);
                        pointF = this.u;
                        if (pointF != null) {
                            this.q.setColor(this.o.getColor());
                            canvas.drawCircle(pointF.x, pointF.y, this.t, this.q);
                        } else {
                            i2 = this.r;
                            numValueOf = Integer.valueOf(i2);
                            if (i2 >= 0) {
                                num = numValueOf;
                            }
                            if (num != null) {
                                pointF = (PointF) this.B.get(num.intValue());
                                this.q.setColor(this.o.getColor());
                                canvas.drawCircle(pointF.x, pointF.y, this.t, this.q);
                            }
                        }
                    }
                }
            }
        }
        q4 q4Var5 = this.f;
        if (q4Var5 != null) {
            int width2 = canvas.getWidth();
            int height2 = canvas.getHeight();
            int i9 = this.z * 2;
            int iMin = Math.min(width2 - i9, height2 - i9) / 4;
            Context context = getContext();
            context.getClass();
            this.F = Math.min(iMin, (int) un.a(context, 1, 28));
            if (q4Var5.g()) {
                a(canvas, b.TOP_LEFT);
                a(canvas, b.TOP_RIGHT);
                a(canvas, b.BOTTOM_LEFT);
                a(canvas, b.BOTTOM_RIGHT);
                if (this.C) {
                    a(canvas, b.TOP_CENTER);
                    a(canvas, b.BOTTOM_CENTER);
                }
                if (this.D) {
                    a(canvas, b.CENTER_LEFT);
                    a(canvas, b.CENTER_RIGHT);
                }
                if (q4Var5.m()) {
                    if (this.g.getColor() == 0) {
                        a(canvas, b.ROTATION);
                    } else {
                        Point point3 = (Point) this.x.get(b.TOP_CENTER);
                        if (point3 != null && (point = (Point) this.x.get(b.ROTATION)) != null) {
                            double rotationHandleRadius = getRotationHandleRadius();
                            if (rotationHandleRadius < 0.0d) {
                                throw new IllegalArgumentException("Length must be a non-negative value, was: " + rotationHandleRadius);
                            }
                            double length = PointF.length(point.x - point3.x, point.y - point3.y);
                            double d = (length - rotationHandleRadius) / length;
                            double d2 = 1.0d - d;
                            Point point4 = new Point((int) ((((double) point.x) * d) + (((double) point3.x) * d2)), (int) ((d * ((double) point.y)) + (d2 * ((double) point3.y))));
                            canvas.drawLine(point3.x, point3.y, point4.x, point4.y, this.g);
                            a(canvas, b.ROTATION);
                        }
                    }
                }
            }
        }
        if (q4Var4.e()) {
            ArrayList arrayList = this.B;
            int size2 = arrayList.size();
            int i10 = i;
            while (i10 < size2) {
                Object obj = arrayList.get(i10);
                i10++;
                int i11 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                PointF pointF4 = (PointF) obj;
                if (q4Var4.b(i)) {
                    Paint paint2 = this.o;
                    if (this.J && i == this.r) {
                        canvas.drawCircle(pointF4.x, pointF4.y, Math.max(this.v, this.z / 3.0f), paint2);
                    } else {
                        Drawable drawable2 = this.i;
                        if (drawable2 != null) {
                            int intrinsicWidth = drawable2.getIntrinsicWidth() / 2;
                            int intrinsicHeight = drawable2.getIntrinsicHeight() / 2;
                            if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
                                canvas.drawCircle(pointF4.x, pointF4.y, this.z, paint2);
                            } else {
                                Integer num2 = this.j;
                                int color = paint2.getColor();
                                if (num2 == null || num2.intValue() != color) {
                                    drawable2.mutate().setTint(paint2.getColor());
                                    this.j = Integer.valueOf(paint2.getColor());
                                }
                                int i12 = (int) pointF4.x;
                                int i13 = (int) pointF4.y;
                                drawable2.setBounds(i12 - intrinsicWidth, i13 - intrinsicHeight, i12 + intrinsicWidth, i13 + intrinsicHeight);
                                drawable2.draw(canvas);
                            }
                        } else {
                            canvas.drawCircle(pointF4.x, pointF4.y, this.z, paint2);
                        }
                    }
                }
                i = i11;
            }
        }
        n0 n0Var = this.m;
        Rect rect3 = new Rect();
        this.d.getLocalVisibleRect(rect3);
        Unit unit = Unit.INSTANCE;
        rect3.left -= getLeft();
        rect3.top -= getTop();
        n0Var.getClass();
        if (n0Var.f.isEmpty()) {
            return;
        }
        canvas.save();
        canvas.clipRect(rect3);
        canvas.drawPath(n0Var.f, n0Var.g);
        canvas.restore();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        motionEvent.getClass();
        q4 q4Var = this.f;
        if (q4Var == null || !q4Var.i() || getParent() == null || getChildCount() != 1) {
            return false;
        }
        if (motionEvent.getActionMasked() == 0) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        float f = -getLeft();
        float f2 = -getTop();
        motionEvent.offsetLocation(f, f2);
        boolean zDispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        motionEvent.offsetLocation(-f, -f2);
        return zDispatchTouchEvent;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        OverlayLayoutParams overlayLayoutParams = new OverlayLayoutParams();
        overlayLayoutParams.layoutPosition = OverlayLayoutParams.LayoutPosition.CENTER;
        return overlayLayoutParams;
    }

    public final n0 getAngularGuidesHelper() {
        return this.m;
    }

    public final AnnotationSelectionViewThemeConfiguration getAnnotationSelectionViewThemeConfiguration() {
        return new AnnotationSelectionViewThemeConfiguration.Builder().setSelectionBorderColor(this.g.getColor()).setSelectionBorderWidth((int) this.g.getStrokeWidth()).setSelectionScaleHandleColor(this.o.getColor()).setSelectionEditHandleColor(this.p.getColor()).setEditHandleDrawable(this.i).setHandleTouchFeedbackAnimationEnabled(this.J).setTopLeftScaleHandleDrawable((Drawable) this.n.get(b.TOP_LEFT)).setTopCenterScaleHandleDrawable((Drawable) this.n.get(b.TOP_CENTER)).setTopRightScaleHandleDrawable((Drawable) this.n.get(b.TOP_RIGHT)).setCenterLeftScaleHandleDrawable((Drawable) this.n.get(b.CENTER_LEFT)).setCenterRightScaleHandleDrawable((Drawable) this.n.get(b.CENTER_RIGHT)).setBottomLeftScaleHandleDrawable((Drawable) this.n.get(b.BOTTOM_LEFT)).setBottomCenterScaleHandleDrawable((Drawable) this.n.get(b.BOTTOM_CENTER)).setBottomRightScaleHandleDrawable((Drawable) this.n.get(b.BOTTOM_RIGHT)).setRotationHandleDrawable((Drawable) this.n.get(b.ROTATION)).setBackgroundDrawable(this.h).setSelectionPadding(getPaddingTop()).build();
    }

    public final int getBorderColor() {
        return this.g.getColor();
    }

    public final int getCurrentEditHandlerIndex() {
        return this.e;
    }

    public final List<PointF> getEditHandleCenters() {
        return this.B;
    }

    @Override // com.pspdfkit.internal.dw
    public RectF getPdfRect() {
        RectF pdfRect = this.d.getPdfRect();
        pdfRect.getClass();
        return pdfRect;
    }

    public final Matrix getPdfToViewTransformation() {
        Matrix matrix = this.a;
        matrix.getClass();
        return matrix;
    }

    public final dw getPdfViewGroup() {
        return this.d;
    }

    public final q4 getPresenter() {
        return this.f;
    }

    public final u00 getRotationHandler() {
        return this.k;
    }

    public final int getScaleHandleColor() {
        return this.o.getColor();
    }

    public final Map<b, Drawable> getScaleHandleDrawables() {
        return this.n;
    }

    public final boolean getScaleHandleDrawablesSupportRotation() {
        return this.H;
    }

    public final int getScaleHandleRadius() {
        return this.z;
    }

    public final Drawable getSelectionBackgroundDrawable() {
        return this.h;
    }

    public final Handler getSelectionLayoutHandler() {
        return this.A;
    }

    @Override // com.pspdfkit.internal.dw
    public float getZoomScale() {
        return this.d.getZoomScale();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.w;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.w = null;
    }

    @Override // com.pspdfkit.internal.dw, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        q4 q4Var;
        this.d.a(this.a).getClass();
        this.b = getZoomScale();
        if (getChildCount() == 0) {
            return;
        }
        float zoomScale = getZoomScale();
        int childCount = getChildCount();
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            KeyEvent.Callback childAt = getChildAt(i6);
            if (childAt instanceof z4) {
                z4 z4Var = (z4) childAt;
                z4Var.a(this.a, zoomScale);
                Annotation annotation = z4Var.getAnnotation();
                if (annotation != null && (q4Var = this.f) != null) {
                    q4Var.a(annotation.getInternal().getPageRotation());
                }
            }
        }
        a(i, i2);
        u00 u00Var = this.k;
        if (u00Var.f.size() == 1) {
            u00Var.l.set(u00Var.c(u00Var.f.get(0)));
        }
        a(i, i2, i3, i4);
        b(i, i2);
        this.l.a();
        if (this.B.size() >= 2 && this.e <= CollectionsKt.getLastIndex(this.B)) {
            int i7 = this.e;
            if (i7 == 0) {
                i5 = 1;
            } else if (i7 >= 1) {
                i5 = i7 - 1;
            }
            PointF pointF = (PointF) this.B.get(i5);
            PointF pointF2 = (PointF) this.B.get(this.e);
            this.m.b(pointF, pointF2);
            this.m.a(pointF, pointF2, this.B);
        }
    }

    @Override // com.pspdfkit.internal.dw, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        q4 q4Var = this.f;
        if (q4Var != null) {
            q4Var.l();
        }
        OverlayLayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        RectF screenRect = layoutParams.pageRect.getScreenRect();
        screenRect.getClass();
        setMeasuredDimension(getPaddingRight() + getPaddingLeft() + ((int) screenRect.width()), getPaddingBottom() + getPaddingTop() + ((int) screenRect.height()));
    }

    public final void setAngularGuidesHelper(n0 n0Var) {
        n0Var.getClass();
        this.m = n0Var;
    }

    public final void setAnnotationSelectionViewThemeConfiguration(AnnotationSelectionViewThemeConfiguration annotationSelectionViewThemeConfiguration) {
        annotationSelectionViewThemeConfiguration.getClass();
        Integer selectionBorderColor = annotationSelectionViewThemeConfiguration.getSelectionBorderColor();
        if (selectionBorderColor != null) {
            this.g.setColor(selectionBorderColor.intValue());
        }
        Integer selectionBorderWidth = annotationSelectionViewThemeConfiguration.getSelectionBorderWidth();
        if (selectionBorderWidth != null) {
            int iIntValue = selectionBorderWidth.intValue();
            this.g.setStrokeWidth(iIntValue);
            q4 q4Var = this.f;
            if (q4Var != null) {
                q4Var.a(iIntValue >= 1);
            }
        }
        Integer selectionScaleHandleColor = annotationSelectionViewThemeConfiguration.getSelectionScaleHandleColor();
        if (selectionScaleHandleColor != null) {
            this.o.setColor(selectionScaleHandleColor.intValue());
        }
        Integer selectionEditHandleColor = annotationSelectionViewThemeConfiguration.getSelectionEditHandleColor();
        if (selectionEditHandleColor != null) {
            this.p.setColor(selectionEditHandleColor.intValue());
        }
        Boolean handleTouchFeedbackAnimationEnabled = annotationSelectionViewThemeConfiguration.getHandleTouchFeedbackAnimationEnabled();
        if (handleTouchFeedbackAnimationEnabled != null) {
            boolean zBooleanValue = handleTouchFeedbackAnimationEnabled.booleanValue();
            this.J = zBooleanValue;
            if (!zBooleanValue) {
                ValueAnimator valueAnimator = this.w;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                }
                this.w = null;
                this.r = -1;
                this.s = null;
                this.t = 0.0f;
                invalidate();
            }
        }
        this.i = annotationSelectionViewThemeConfiguration.getEditHandleDrawable();
        this.j = null;
        this.n.put(b.TOP_LEFT, annotationSelectionViewThemeConfiguration.getTopLeftScaleHandleDrawable());
        this.n.put(b.TOP_CENTER, annotationSelectionViewThemeConfiguration.getTopCenterScaleHandleDrawable());
        this.n.put(b.TOP_RIGHT, annotationSelectionViewThemeConfiguration.getTopRightScaleHandleDrawable());
        this.n.put(b.CENTER_LEFT, annotationSelectionViewThemeConfiguration.getCenterLeftScaleHandleDrawable());
        this.n.put(b.CENTER_RIGHT, annotationSelectionViewThemeConfiguration.getCenterRightScaleHandleDrawable());
        this.n.put(b.BOTTOM_LEFT, annotationSelectionViewThemeConfiguration.getBottomLeftScaleHandleDrawable());
        this.n.put(b.BOTTOM_CENTER, annotationSelectionViewThemeConfiguration.getBottomCenterScaleHandleDrawable());
        this.n.put(b.BOTTOM_RIGHT, annotationSelectionViewThemeConfiguration.getBottomRightScaleHandleDrawable());
        this.n.put(b.ROTATION, annotationSelectionViewThemeConfiguration.getRotationHandleDrawable());
        this.h = annotationSelectionViewThemeConfiguration.getBackgroundDrawable();
        Integer selectionPadding = annotationSelectionViewThemeConfiguration.getSelectionPadding();
        if (selectionPadding != null) {
            int iIntValue2 = selectionPadding.intValue();
            setPadding(iIntValue2, iIntValue2, iIntValue2, iIntValue2);
            this.z = iIntValue2 / 2;
        }
    }

    public final void setCurrentEditHandlerIndex(int i) {
        this.e = i;
    }

    public final void setPresenter(q4 q4Var) {
        this.f = q4Var;
    }

    public final void setScaleHandleDrawableInitialRotation(float f) {
        this.G = f;
    }

    public final void setScaleHandleDrawableRotation(float f) {
        this.E = f + this.G;
    }

    public final void setScaleHandleDrawablesSupportRotation(boolean z) {
        this.H = z;
    }

    public final void setTouchedHandleForFeedback(kf kfVar) {
        kfVar.getClass();
        int i = kfVar.b;
        b bVar = kfVar.a;
        if (!this.J) {
            ValueAnimator valueAnimator = this.w;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            this.w = null;
            this.r = -1;
            this.s = null;
            this.t = 0.0f;
            invalidate();
            return;
        }
        if (i == -1 && bVar == null) {
            if (this.r == -1 && this.s == null) {
                return;
            }
            a(getTouchedHandleVisualRadiusPx(), true);
            return;
        }
        this.r = i;
        this.s = bVar;
        if (this.t <= 0.0f) {
            this.t = getTouchedHandleVisualRadiusPx();
        }
        a(getEditHandleTouchTargetRadiusPx(), false);
    }

    @Override // android.view.View
    public OverlayLayoutParams getLayoutParams() {
        return (OverlayLayoutParams) super.getLayoutParams();
    }

    public final void b(int i, int i2) {
        z4 z4Var;
        Annotation annotation;
        List<PointF> listE;
        this.B.clear();
        if (getChildCount() != 1 || (z4Var = (z4) getChildAt(0)) == null || (annotation = z4Var.getAnnotation()) == null) {
            return;
        }
        if (annotation.getType() == AnnotationType.FREETEXT) {
            List<PointF> listE2 = ww.e(annotation);
            if (listE2.size() >= 3) {
                listE = CollectionsKt.take(listE2, 2);
            } else if (listE2.isEmpty()) {
                return;
            } else {
                listE = CollectionsKt.take(listE2, 1);
            }
        } else {
            listE = ww.e(annotation);
        }
        for (PointF pointF : listE) {
            PointF pointF2 = new PointF();
            Matrix matrix = this.a;
            pointF2.set(pointF);
            s60.a(pointF2, matrix);
            pointF2.offset(-i, -i2);
            this.B.add(pointF2);
        }
        invalidate();
    }

    public final Drawable a(int i) {
        if (i == -1) {
            return null;
        }
        return AppCompatResources.getDrawable(getContext(), i);
    }

    @Override // com.pspdfkit.internal.dw
    public final Matrix a(Matrix matrix) {
        Matrix matrixA = this.d.a(matrix);
        matrixA.getClass();
        return matrixA;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0023  */
    /* JADX WARN: Code duplicated, block: B:19:0x0044  */
    /* JADX WARN: Code duplicated, block: B:83:0x01df  */
    public final void a(int i, int i2, int i3, int i4) {
        boolean z;
        boolean z2;
        double radians;
        float fHeight;
        float fWidth;
        int i5;
        q4 q4Var = this.f;
        if (q4Var != null && q4Var.h()) {
            z = false;
        } else if (((i3 - i) - (getPaddingLeft() + getPaddingRight())) / 2 >= this.y) {
            z = true;
        } else {
            z = false;
        }
        this.C = z;
        q4 q4Var2 = this.f;
        if (q4Var2 != null && q4Var2.h()) {
            z2 = false;
        } else if (((i4 - i2) - (getPaddingBottom() + getPaddingTop())) / 2 >= this.y) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.D = z2;
        EnumMap enumMap = this.x;
        b bVar = b.TOP_LEFT;
        Point point = (Point) enumMap.get(bVar);
        if (point != null) {
            int i6 = this.z;
            point.set(i6, i6);
        }
        EnumMap enumMap2 = this.x;
        b bVar2 = b.TOP_RIGHT;
        Point point2 = (Point) enumMap2.get(bVar2);
        if (point2 != null) {
            int i7 = this.z;
            point2.set((i3 - i) - i7, i7);
        }
        EnumMap enumMap3 = this.x;
        b bVar3 = b.BOTTOM_LEFT;
        Point point3 = (Point) enumMap3.get(bVar3);
        if (point3 != null) {
            int i8 = this.z;
            point3.set(i8, (i4 - i2) - i8);
        }
        EnumMap enumMap4 = this.x;
        b bVar4 = b.BOTTOM_RIGHT;
        Point point4 = (Point) enumMap4.get(bVar4);
        if (point4 != null) {
            int i9 = this.z;
            point4.set((i3 - i) - i9, (i4 - i2) - i9);
        }
        Point point5 = (Point) this.x.get(b.TOP_CENTER);
        if (point5 != null) {
            point5.set((i3 - i) / 2, this.z);
        }
        Point point6 = (Point) this.x.get(b.BOTTOM_CENTER);
        if (point6 != null) {
            point6.set((i3 - i) / 2, (i4 - i2) - this.z);
        }
        Point point7 = (Point) this.x.get(b.CENTER_LEFT);
        if (point7 != null) {
            point7.set(this.z, (i4 - i2) / 2);
        }
        Point point8 = (Point) this.x.get(b.CENTER_RIGHT);
        if (point8 != null) {
            point8.set((i3 - i) - this.z, (i4 - i2) / 2);
        }
        u00 u00Var = this.k;
        EnumMap enumMap5 = this.x;
        u00Var.getClass();
        enumMap5.getClass();
        if (u00Var.a()) {
            int measuredWidth = u00Var.a.getMeasuredWidth() / 2;
            int measuredHeight = u00Var.a.getMeasuredHeight() / 2;
            z4<Annotation> z4Var = u00Var.f.get(0);
            Annotation annotation = z4Var.getAnnotation();
            if (annotation != null) {
                if (Double.isNaN(u00Var.i)) {
                    radians = Math.toRadians(annotation.getInternal().getRotation());
                } else {
                    radians = u00Var.i;
                }
                int pageRotation = annotation.getInternal().getPageRotation();
                RectF rectF = u00Var.l;
                if (annotation.getInternal().needsFlippedContentSize()) {
                    fHeight = rectF.width();
                    fWidth = rectF.height();
                } else {
                    fHeight = rectF.height();
                    fWidth = rectF.width();
                }
                double d = measuredWidth;
                double d2 = radians - 1.5707963267948966d;
                float f = fWidth;
                float f2 = 2;
                float f3 = fHeight / f2;
                double dCos = (Math.cos(d2) * ((double) ((u00Var.a() ? (int) (u00Var.g * 6.0f) : 0) + f3))) + d;
                double d3 = measuredHeight;
                double dSin = (Math.sin(d2) * ((double) ((u00Var.a() ? (int) (u00Var.g * 6.0f) : 0) + f3))) + d3;
                Point point9 = (Point) enumMap5.get(b.ROTATION);
                if (point9 != null) {
                    point9.set((int) dCos, (int) dSin);
                }
                List<PointF> listB = u00Var.b(z4Var);
                if (annotation instanceof FreeTextAnnotation) {
                    List<b> list = tz.a;
                    if (pageRotation == 0) {
                        i5 = 0;
                    } else if (pageRotation == 90) {
                        i5 = 3;
                    } else if (pageRotation == 180) {
                        i5 = 2;
                    } else if (pageRotation != 270) {
                        i5 = 0;
                    } else {
                        i5 = 1;
                    }
                    Point point10 = (Point) enumMap5.get(bVar);
                    if (point10 != null) {
                        int i10 = i5 % 4;
                        point10.set((int) listB.get(i10).x, (int) listB.get(i10).y);
                    }
                    Point point11 = (Point) enumMap5.get(bVar2);
                    if (point11 != null) {
                        int i11 = (i5 + 1) % 4;
                        point11.set((int) listB.get(i11).x, (int) listB.get(i11).y);
                    }
                    Point point12 = (Point) enumMap5.get(bVar4);
                    if (point12 != null) {
                        int i12 = (i5 + 2) % 4;
                        point12.set((int) listB.get(i12).x, (int) listB.get(i12).y);
                    }
                    Point point13 = (Point) enumMap5.get(bVar3);
                    if (point13 != null) {
                        int i13 = (i5 + 3) % 4;
                        point13.set((int) listB.get(i13).x, (int) listB.get(i13).y);
                    }
                } else {
                    float fMin = listB.get(0).x;
                    float fMin2 = listB.get(0).y;
                    float fMax = listB.get(0).x;
                    float fMax2 = listB.get(0).y;
                    for (PointF pointF : listB) {
                        fMin = Math.min(pointF.x, fMin);
                        fMin2 = Math.min(pointF.y, fMin2);
                        fMax = Math.max(pointF.x, fMax);
                        fMax2 = Math.max(pointF.y, fMax2);
                    }
                    Point point14 = (Point) enumMap5.get(b.TOP_LEFT);
                    if (point14 != null) {
                        point14.set((int) fMin, (int) fMin2);
                    }
                    Point point15 = (Point) enumMap5.get(b.TOP_RIGHT);
                    if (point15 != null) {
                        point15.set((int) fMax, (int) fMin2);
                    }
                    Point point16 = (Point) enumMap5.get(b.BOTTOM_LEFT);
                    if (point16 != null) {
                        point16.set((int) fMin, (int) fMax2);
                    }
                    Point point17 = (Point) enumMap5.get(b.BOTTOM_RIGHT);
                    if (point17 != null) {
                        point17.set((int) fMax, (int) fMax2);
                    }
                }
                double dCos2 = Math.cos(d2) * ((double) (u00Var.g + f3));
                double dSin2 = Math.sin(d2) * ((double) (u00Var.g + f3));
                Point point18 = (Point) enumMap5.get(b.TOP_CENTER);
                if (point18 != null) {
                    point18.set((int) (d + dCos2), (int) (d3 + dSin2));
                }
                Point point19 = (Point) enumMap5.get(b.BOTTOM_CENTER);
                if (point19 != null) {
                    point19.set((int) (d - dCos2), (int) (d3 - dSin2));
                }
                float f4 = f / f2;
                double dCos3 = Math.cos(radians) * ((double) (u00Var.g + f4));
                double dSin3 = Math.sin(radians) * ((double) (u00Var.g + f4));
                Point point20 = (Point) enumMap5.get(b.CENTER_LEFT);
                if (point20 != null) {
                    point20.set((int) (d - dCos3), (int) (d3 - dSin3));
                }
                Point point21 = (Point) enumMap5.get(b.CENTER_RIGHT);
                if (point21 != null) {
                    point21.set((int) (d + dCos3), (int) (d3 + dSin3));
                }
            }
        }
        Object obj = this.x.get(b.TOP_LEFT);
        if (obj != null) {
            Point point22 = (Point) obj;
            Object obj2 = this.x.get(b.BOTTOM_RIGHT);
            if (obj2 != null) {
                Point point23 = (Point) obj2;
                this.K.set(point22.x, point22.y, point23.x, point23.y);
                invalidate();
                return;
            }
            throw new IllegalArgumentException("Required value was null.");
        }
        throw new IllegalArgumentException("Required value was null.");
    }

    public final void a(Canvas canvas, b bVar) {
        q4 q4Var = this.f;
        if (q4Var == null || q4Var.a(bVar)) {
            Drawable drawable = (Drawable) this.n.get(bVar);
            Drawable drawable2 = drawable == null ? this.i : drawable;
            if (this.o.getColor() == 0 && drawable2 == null) {
                return;
            }
            Point point = (Point) this.x.get(bVar);
            if (point != null) {
                if (this.J && bVar == this.s) {
                    canvas.drawCircle(point.x, point.y, Math.max(this.v, this.z / 3.0f), this.o);
                    return;
                }
                if (drawable2 != null) {
                    if (drawable == null) {
                        Integer num = this.j;
                        int color = this.o.getColor();
                        if (num == null || num.intValue() != color) {
                            drawable2.mutate().setTint(this.o.getColor());
                            this.j = Integer.valueOf(this.o.getColor());
                        }
                    }
                    int intrinsicWidth = drawable2.getIntrinsicWidth() / 2;
                    int intrinsicHeight = drawable2.getIntrinsicHeight() / 2;
                    int i = point.x;
                    int i2 = point.y;
                    drawable2.setBounds(i - intrinsicWidth, i2 - intrinsicHeight, i + intrinsicWidth, i2 + intrinsicHeight);
                    boolean z = bVar != b.ROTATION && this.H;
                    if (z) {
                        canvas.rotate(this.E, point.x, point.y);
                    }
                    drawable2.draw(canvas);
                    if (z) {
                        canvas.rotate(-this.E, point.x, point.y);
                        return;
                    }
                    return;
                }
                canvas.drawCircle(point.x, point.y, this.z, this.o);
                return;
            }
            throw new AssertionError("Scale handle" + bVar + " must be part of scaleHandleCenters map.");
        }
    }

    public final boolean a(MotionEvent motionEvent) {
        motionEvent.getClass();
        q4 q4Var = this.f;
        if (q4Var != null && q4Var.m()) {
            b bVar = b.TOP_LEFT;
            List listListOf = CollectionsKt.listOf((Object[]) new b[]{bVar, b.TOP_RIGHT, b.BOTTOM_RIGHT, b.BOTTOM_LEFT, bVar});
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listListOf, 10));
            Iterator it = listListOf.iterator();
            while (it.hasNext()) {
                Object obj = this.x.get((b) it.next());
                if (obj != null) {
                    arrayList.add(new PointF((Point) obj));
                } else {
                    throw new IllegalArgumentException("Required value was null.");
                }
            }
            PointF pointF = new PointF(motionEvent.getX() - getLeft(), motionEvent.getY() - getTop());
            double dMin = ((PointF) arrayList.get(0)).x;
            double dMax = ((PointF) arrayList.get(0)).x;
            double dMin2 = ((PointF) arrayList.get(0)).y;
            double dMax2 = ((PointF) arrayList.get(0)).y;
            for (int i = 1; i < arrayList.size(); i++) {
                PointF pointF2 = (PointF) arrayList.get(i);
                dMin = Math.min(pointF2.x, dMin);
                dMax = Math.max(pointF2.x, dMax);
                dMin2 = Math.min(pointF2.y, dMin2);
                dMax2 = Math.max(pointF2.y, dMax2);
            }
            double d = pointF.x;
            if (d >= dMin && d <= dMax) {
                double d2 = pointF.y;
                if (d2 >= dMin2 && d2 <= dMax2) {
                    int size = arrayList.size() - 1;
                    boolean z = false;
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        PointF pointF3 = (PointF) arrayList.get(i2);
                        PointF pointF4 = (PointF) arrayList.get(size);
                        float f = pointF3.y;
                        float f2 = pointF.y;
                        boolean z2 = f > f2;
                        float f3 = pointF4.y;
                        if (z2 != (f3 > f2)) {
                            float f4 = pointF.x;
                            float f5 = pointF4.x;
                            float f6 = pointF3.x;
                            if (f4 < (((f2 - f) * (f5 - f6)) / (f3 - f)) + f6) {
                                z = !z;
                            }
                        }
                        size = i2;
                    }
                    return z;
                }
            }
            return false;
        }
        return a80.b(this, motionEvent);
    }

    public final boolean b(MotionEvent motionEvent) {
        motionEvent.getClass();
        Rect rect = this.K;
        PointF pointF = new PointF(motionEvent.getX() - getLeft(), motionEvent.getY() - getTop());
        Rect rect2 = new Rect();
        int i = (int) pointF.x;
        int i2 = this.F;
        int i3 = (int) pointF.y;
        rect2.set(i - i2, i3 - i2, i + i2, i3 + i2);
        return Rect.intersects(rect, rect2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final z4 a(View view) {
        view.getClass();
        if (view instanceof z4) {
            return (z4) view;
        }
        return null;
    }

    public final void a() {
        q4 q4Var;
        boolean z = false;
        for (KeyEvent.Callback callback : ViewGroupKt.getChildren(this)) {
            callback.getClass();
            z4<?> z4Var = (z4) callback;
            if (!this.k.a(z4Var)) {
                q4 q4Var2 = this.f;
                if (q4Var2 != null && q4Var2.a(z4Var, null)) {
                    z4Var.b();
                }
            }
            z = true;
        }
        if (!z || (q4Var = this.f) == null) {
            return;
        }
        q4Var.b();
    }

    public static final float a(o4 o4Var) {
        Context context = o4Var.getContext();
        context.getClass();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        displayMetrics.getClass();
        return TypedValue.applyDimension(1, 48.0f, displayMetrics) / 2.0f;
    }

    public final void a(float f, boolean z) {
        if (this.t == f) {
            if (z) {
                this.r = -1;
                this.s = null;
                this.t = 0.0f;
                invalidate();
                return;
            }
            return;
        }
        ValueAnimator valueAnimator = this.w;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        float f2 = this.t;
        boolean z2 = f > f2;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f2, f);
        valueAnimatorOfFloat.setDuration(z2 ? 200L : 100L);
        valueAnimatorOfFloat.setInterpolator(z2 ? new OvershootInterpolator() : new DecelerateInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.pspdfkit.internal.o4$$ExternalSyntheticLambda2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                o4.a(this.f$0, valueAnimator2);
            }
        });
        valueAnimatorOfFloat.addListener(new c(z));
        valueAnimatorOfFloat.start();
        this.w = valueAnimatorOfFloat;
    }

    public static final void a(o4 o4Var, ValueAnimator valueAnimator) {
        valueAnimator.getClass();
        Object animatedValue = valueAnimator.getAnimatedValue();
        animatedValue.getClass();
        o4Var.t = ((Float) animatedValue).floatValue();
        o4Var.invalidate();
    }
}
