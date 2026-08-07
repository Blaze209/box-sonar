package com.pspdfkit.internal;

import android.animation.ObjectAnimator;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.Property;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.DecelerateInterpolator;
import androidx.core.view.ViewGroupKt;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class qx implements RecyclerView.OnItemTouchListener {
    public int A;
    public int B;
    public final ArrayList C;
    public c D;
    public e E;
    public boolean F;
    public boolean G;
    public final Runnable H;
    public final RecyclerView a;
    public final Handler b;
    public final ArrayList c;
    public final ArrayList d;
    public final LinkedHashSet e;
    public final LinkedHashSet f;
    public final LinkedHashSet g;
    public final int h;
    public final int i;
    public final int j;
    public int k;
    public float l;
    public float m;
    public boolean n;
    public int o;
    public VelocityTracker p;
    public int q;
    public View r;
    public boolean s;
    public boolean t;
    public boolean u;
    public int v;
    public View w;
    public boolean x;
    public View y;
    public View z;

    public static final class a extends RecyclerView.OnScrollListener {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
            recyclerView.getClass();
            qx qxVar = qx.this;
            qxVar.s = !(i != 1);
            qxVar.x = i != 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
            recyclerView.getClass();
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.pspdfkit.internal.qx$b[], still in use, count: 1, list:
      (r0v1 com.pspdfkit.internal.qx$b[]) from 0x001a: INVOKE (r0v1 com.pspdfkit.internal.qx$b[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
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
        OPEN,
        CLOSE;

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
            return (b[]) c.clone();
        }
    }

    public interface c {
        void onIndependentViewClicked(int i, int i2);

        void onRowClicked(int i);
    }

    public interface d {
        default void a() {
        }
    }

    public interface e {
        void a(int i, int i2);
    }

    public static final class f implements d {
        public final /* synthetic */ View a;

        public f(View view) {
            this.a = view;
        }

        @Override // com.pspdfkit.internal.qx.d
        public final void a() {
            View view = this.a;
            if (view != null) {
                view.setVisibility(0);
            }
        }
    }

    public static final class g implements d {
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;

        public g(int i, int i2) {
            this.b = i;
            this.c = i2;
        }

        @Override // com.pspdfkit.internal.qx.d
        public final void a() {
            e eVar = qx.this.E;
            if (eVar != null) {
                eVar.a(this.b, this.c);
            }
        }
    }

    public qx(RecyclerView recyclerView) {
        recyclerView.getClass();
        this.a = recyclerView;
        this.b = new Handler(Looper.getMainLooper());
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = new LinkedHashSet();
        this.f = new LinkedHashSet();
        this.g = new LinkedHashSet();
        this.k = 1;
        this.C = new ArrayList();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(recyclerView.getContext());
        this.h = viewConfiguration.getScaledTouchSlop();
        this.i = viewConfiguration.getScaledMinimumFlingVelocity() * 16;
        this.j = viewConfiguration.getScaledMaximumFlingVelocity();
        this.t = false;
        this.v = -1;
        this.w = null;
        this.u = false;
        this.x = false;
        recyclerView.addOnScrollListener(new a());
        this.H = new Runnable() { // from class: com.pspdfkit.internal.qx$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                qx.a(this.f$0);
            }
        };
    }

    public static final void a(qx qxVar) {
        qxVar.getClass();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public final boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        recyclerView.getClass();
        motionEvent.getClass();
        return a(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public final void onRequestDisallowInterceptTouchEvent(boolean z) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public final void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        recyclerView.getClass();
        motionEvent.getClass();
        this.a.requestDisallowInterceptTouchEvent(true);
        a(motionEvent);
    }

    public final int a(ArrayList arrayList, MotionEvent motionEvent) {
        Object obj;
        boolean zContains;
        View view = this.r;
        if (view == null) {
            return -1;
        }
        Rect rect = new Rect();
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        int size = arrayList.size();
        int i = 0;
        do {
            if (i >= size) {
                obj = null;
                break;
            }
            obj = arrayList.get(i);
            i++;
            View viewFindViewById = view.findViewById(((Number) obj).intValue());
            if (viewFindViewById != null) {
                viewFindViewById.getGlobalVisibleRect(rect);
                zContains = rect.contains(rawX, rawY);
            } else {
                zContains = false;
            }
        } while (!zContains);
        Integer num = (Integer) obj;
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    public final void a(View view, float f2, long j) {
        ArrayList arrayList = this.C;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            View viewFindViewById = view.findViewById(((Number) obj).intValue());
            if (viewFindViewById != null) {
                viewFindViewById.animate().alpha(f2).setDuration(j);
            }
        }
    }

    public final void a(View view, b bVar, f fVar) {
        ObjectAnimator objectAnimatorOfFloat;
        int iOrdinal = bVar.ordinal();
        if (iOrdinal == 0) {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.y, (Property<View, Float>) View.TRANSLATION_X, -this.k);
            objectAnimatorOfFloat.getClass();
            objectAnimatorOfFloat.setDuration(300L);
            objectAnimatorOfFloat.setInterpolator(new DecelerateInterpolator(1.5f));
            objectAnimatorOfFloat.start();
            a(view, 0.0f, 300L);
        } else if (iOrdinal == 1) {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.y, (Property<View, Float>) View.TRANSLATION_X, 0.0f);
            objectAnimatorOfFloat.getClass();
            objectAnimatorOfFloat.setDuration(300L);
            objectAnimatorOfFloat.setInterpolator(new DecelerateInterpolator(1.5f));
            objectAnimatorOfFloat.start();
            a(view, 1.0f, 300L);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        if (fVar != null) {
            objectAnimatorOfFloat.addListener(new rx(bVar, fVar));
        }
    }

    public final boolean a(MotionEvent motionEvent) {
        View next;
        VelocityTracker velocityTracker;
        boolean z;
        boolean z2;
        float f2;
        boolean z3;
        boolean z4;
        int iA;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        View view;
        View view2;
        int actionMasked = motionEvent.getActionMasked();
        int i6 = 0;
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                this.b.removeCallbacks(this.H);
                View view3 = this.r;
                if (view3 != null && (!((velocityTracker = this.p) == null && this.G) && this.q >= 0)) {
                    float rawX = motionEvent.getRawX() - this.l;
                    if (this.n) {
                        z = rawX < 0.0f;
                        z2 = rawX > 0.0f;
                    } else {
                        z = false;
                        z2 = false;
                    }
                    f2 = 0.0f;
                    if (Math.abs(rawX) <= this.k / 2 || !this.n) {
                        if (this.G && velocityTracker != null) {
                            velocityTracker.addMovement(motionEvent);
                            velocityTracker.computeCurrentVelocity(1000);
                            float xVelocity = velocityTracker.getXVelocity();
                            float fAbs = Math.abs(xVelocity);
                            float fAbs2 = Math.abs(velocityTracker.getYVelocity());
                            if (this.i <= fAbs && fAbs <= this.j && fAbs2 < fAbs && this.n) {
                                boolean z5 = ((xVelocity > 0.0f ? 1 : (xVelocity == 0.0f ? 0 : -1)) < 0) == ((rawX > 0.0f ? 1 : (rawX == 0.0f ? 0 : -1)) < 0);
                                if ((xVelocity > 0.0f) == (rawX > 0.0f)) {
                                    z4 = z5;
                                } else {
                                    z4 = z5;
                                }
                            }
                        }
                        z3 = false;
                        z4 = false;
                    } else {
                        z4 = rawX < 0.0f;
                        z3 = rawX > 0.0f;
                    }
                    if (this.G && !z2 && z4 && (i5 = this.q) != -1 && !this.f.contains(Integer.valueOf(i5)) && !this.t) {
                        int i7 = this.q;
                        a(view3, b.OPEN, (f) null);
                        this.t = true;
                        this.w = this.y;
                        this.v = i7;
                    } else if (this.G && !z && z3 && (i4 = this.q) != -1 && !this.f.contains(Integer.valueOf(i4)) && this.t) {
                        a(view3, b.CLOSE, (f) null);
                        this.t = false;
                        this.w = null;
                        this.v = -1;
                    } else {
                        boolean z6 = this.G;
                        if (z6 && z && !this.t) {
                            a(view3, b.CLOSE, new f(this.z));
                            this.t = false;
                            this.w = null;
                            this.v = -1;
                        } else if (z6 && z2) {
                            if (this.t) {
                                a(view3, b.OPEN, (f) null);
                                this.t = true;
                                this.w = this.y;
                                this.v = this.q;
                            } else {
                                a(view3, b.CLOSE, (f) null);
                                this.t = false;
                                this.w = null;
                                this.v = -1;
                            }
                        } else if (z6 && z && this.t) {
                            a(view3, b.OPEN, (f) null);
                            this.t = true;
                            this.w = this.y;
                            this.v = this.q;
                        } else if (!z2 && !z) {
                            if (z6 && this.u) {
                                a(view3, b.CLOSE, (f) null);
                                this.t = false;
                                this.w = null;
                                this.v = -1;
                            } else if (this.F && !this.t && (i3 = this.q) >= 0 && !this.e.contains(Integer.valueOf(i3)) && a(this.c, motionEvent) == -1 && !this.x) {
                                c cVar = this.D;
                                if (cVar != null) {
                                    cVar.onRowClicked(this.q);
                                }
                            } else if (this.F && !this.t && (i2 = this.q) >= 0 && !this.e.contains(Integer.valueOf(i2)) && a(this.c, motionEvent) != -1 && !this.x) {
                                int iA2 = a(this.c, motionEvent);
                                Integer numValueOf = Integer.valueOf(iA2);
                                if (iA2 < 0) {
                                    numValueOf = null;
                                }
                                if (numValueOf != null) {
                                    int iIntValue = numValueOf.intValue();
                                    c cVar2 = this.D;
                                    if (cVar2 != null) {
                                        cVar2.onIndependentViewClicked(iIntValue, this.q);
                                    }
                                }
                            } else if (this.G && this.t && !this.u && (iA = a(this.d, motionEvent)) >= 0 && (i = this.q) >= 0) {
                                g gVar = new g(iA, i);
                                View view4 = this.w;
                                if (view4 == null) {
                                    Log.e("RecyclerTouchListener", "No rows found for which background options are visible");
                                } else {
                                    ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view4, (Property<View, Float>) View.TRANSLATION_X, 0.0f);
                                    objectAnimatorOfFloat.setDuration(150L);
                                    objectAnimatorOfFloat.addListener(new sx(gVar, objectAnimatorOfFloat));
                                    objectAnimatorOfFloat.start();
                                    a(view4, 1.0f, 150L);
                                    this.t = false;
                                    this.w = null;
                                    this.v = -1;
                                }
                            }
                        }
                    }
                } else {
                    f2 = 0.0f;
                }
                if (this.G) {
                    VelocityTracker velocityTracker2 = this.p;
                    if (velocityTracker2 != null) {
                        velocityTracker2.recycle();
                    }
                    this.p = null;
                }
                float f3 = f2;
                this.l = f3;
                this.m = f3;
                this.r = null;
                this.q = -1;
                this.n = false;
                this.z = null;
            } else if (actionMasked == 2) {
                VelocityTracker velocityTracker3 = this.p;
                if (velocityTracker3 != null && !this.s && this.G && (view = this.r) != null) {
                    velocityTracker3.addMovement(motionEvent);
                    float rawX2 = motionEvent.getRawX() - this.l;
                    float rawY = motionEvent.getRawY() - this.m;
                    if (!this.n && Math.abs(rawX2) > this.h && Math.abs(rawY) < Math.abs(rawX2) / 2) {
                        this.b.removeCallbacks(this.H);
                        this.n = true;
                        int i8 = this.h;
                        if (rawX2 <= 0.0f) {
                            i8 = -i8;
                        }
                        this.o = i8;
                    }
                    if (this.G && this.n && !this.f.contains(Integer.valueOf(this.q))) {
                        if (this.z == null) {
                            View viewFindViewById = view.findViewById(this.B);
                            this.z = viewFindViewById;
                            if (viewFindViewById != null) {
                                viewFindViewById.setVisibility(0);
                            }
                        }
                        if (rawX2 < this.h && !this.t) {
                            float f4 = rawX2 - this.o;
                            View view5 = this.y;
                            if (view5 != null) {
                                float fAbs3 = Math.abs(f4);
                                float f5 = this.k;
                                view5.setTranslationX(Math.min(0.0f, fAbs3 > f5 ? -f5 : f4));
                            }
                            float fAbs4 = 1 - (Math.abs(f4) / this.k);
                            ArrayList arrayList = this.C;
                            int size = arrayList.size();
                            while (i6 < size) {
                                Object obj = arrayList.get(i6);
                                i6++;
                                View viewFindViewById2 = view.findViewById(((Number) obj).intValue());
                                if (viewFindViewById2 != null) {
                                    viewFindViewById2.setAlpha(fAbs4);
                                }
                            }
                        } else if (rawX2 > 0.0f && this.t) {
                            float f6 = (rawX2 - this.o) - this.k;
                            View view6 = this.y;
                            if (view6 != null) {
                                view6.setTranslationX(f6 <= 0.0f ? f6 : 0.0f);
                            }
                            float fAbs5 = 1 - (Math.abs(f6) / this.k);
                            ArrayList arrayList2 = this.C;
                            int size2 = arrayList2.size();
                            while (i6 < size2) {
                                Object obj2 = arrayList2.get(i6);
                                i6++;
                                View viewFindViewById3 = view.findViewById(((Number) obj2).intValue());
                                if (viewFindViewById3 != null) {
                                    viewFindViewById3.setAlpha(fAbs5);
                                }
                            }
                        }
                        return true;
                    }
                    if (this.G && this.n && this.f.contains(Integer.valueOf(this.q))) {
                        if (rawX2 < this.h && !this.t) {
                            float f7 = rawX2 - this.o;
                            if (this.z == null) {
                                this.z = view.findViewById(this.B);
                            }
                            View view7 = this.z;
                            if (view7 != null) {
                                view7.setVisibility(8);
                            }
                            View view8 = this.y;
                            if (view8 != null) {
                                view8.setTranslationX(Math.min(0.0f, f7 / 5));
                            }
                        }
                        return true;
                    }
                }
            } else if (actionMasked == 3) {
                this.b.removeCallbacks(this.H);
                if (this.p != null) {
                    if (this.G) {
                        if (this.n && (view2 = this.r) != null) {
                            a(view2, b.CLOSE, (f) null);
                        }
                        VelocityTracker velocityTracker4 = this.p;
                        if (velocityTracker4 != null) {
                            velocityTracker4.recycle();
                        }
                        this.p = null;
                        this.n = false;
                        this.z = null;
                    }
                    this.l = 0.0f;
                    this.m = 0.0f;
                    this.r = null;
                    this.q = -1;
                }
            }
        } else if (!this.s) {
            Rect rect = new Rect();
            int[] iArr = new int[2];
            this.a.getLocationOnScreen(iArr);
            int rawX3 = ((int) motionEvent.getRawX()) - iArr[0];
            int rawY2 = ((int) motionEvent.getRawY()) - iArr[1];
            Iterator<View> it = ViewGroupKt.getChildren(this.a).iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                next.getHitRect(rect);
            } while (!rect.contains(rawX3, rawY2));
            View view9 = next;
            this.r = view9;
            if (view9 != null) {
                this.l = motionEvent.getRawX();
                this.m = motionEvent.getRawY();
                int childAdapterPosition = this.a.getChildAdapterPosition(view9);
                this.q = childAdapterPosition;
                RecyclerView.Adapter adapter = this.a.getAdapter();
                if (adapter != null ? this.g.contains(Integer.valueOf(adapter.getItemViewType(childAdapterPosition))) : true) {
                    this.q = -1;
                    return false;
                }
                if (this.G) {
                    VelocityTracker velocityTrackerObtain = VelocityTracker.obtain();
                    velocityTrackerObtain.addMovement(motionEvent);
                    this.p = velocityTrackerObtain;
                    View viewFindViewById4 = view9.findViewById(this.A);
                    View viewFindViewById5 = view9.findViewById(this.B);
                    if (viewFindViewById4 != null) {
                        int height = viewFindViewById4.getHeight();
                        if (viewFindViewById5 != null) {
                            viewFindViewById5.setMinimumHeight(height);
                        }
                    }
                    this.y = viewFindViewById4;
                    this.z = viewFindViewById5;
                    if (viewFindViewById5 != null) {
                        this.k = viewFindViewById5.getWidth();
                    }
                    if (this.t && this.y != null) {
                        this.b.removeCallbacks(this.H);
                        int rawX4 = (int) motionEvent.getRawX();
                        int rawY3 = (int) motionEvent.getRawY();
                        View view10 = this.y;
                        if (view10 != null) {
                            view10.getGlobalVisibleRect(rect);
                        }
                        this.u = rect.contains(rawX4, rawY3);
                    } else {
                        this.u = false;
                    }
                }
            }
            motionEvent.getRawX();
            motionEvent.getRawY();
            this.a.getHitRect(rect);
            if (this.G && this.t && this.q != this.v) {
                this.b.removeCallbacks(this.H);
                View view11 = this.w;
                if (view11 == null) {
                    Log.e("RecyclerTouchListener", "No rows found for which background options are visible");
                } else {
                    ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view11, (Property<View, Float>) View.TRANSLATION_X, 0.0f);
                    objectAnimatorOfFloat2.setDuration(150L);
                    objectAnimatorOfFloat2.addListener(new sx(null, objectAnimatorOfFloat2));
                    objectAnimatorOfFloat2.start();
                    a(view11, 1.0f, 150L);
                    this.t = false;
                    this.w = null;
                    this.v = -1;
                }
            }
        }
        return false;
    }
}
