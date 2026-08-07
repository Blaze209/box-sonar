package com.pspdfkit.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.content.ContextCompat;
import com.pspdfkit.R;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.contentediting.models.Alignment;
import com.pspdfkit.contentediting.models.StyleInfo;
import com.pspdfkit.exceptions.ContentEditingException;
import com.pspdfkit.internal.jni.NativeContentEditor;
import com.pspdfkit.internal.views.document.DocumentView;
import com.pspdfkit.listeners.OnPreparePopupToolbarListener;
import com.pspdfkit.ui.PopupToolbar;
import com.pspdfkit.ui.inspector.PropertyInspector;
import com.pspdfkit.ui.inspector.PropertyInspectorCoordinatorLayoutController;
import com.pspdfkit.ui.inspector.contentediting.DefaultContentEditingInspectorController;
import com.pspdfkit.ui.special_mode.controller.ContentEditingInspectorController;
import com.pspdfkit.ui.special_mode.manager.ContentEditingManager;
import com.pspdfkit.ui.toolbar.popup.PopupToolbarMenuItem;
import com.pspdfkit.undo.UndoManager;
import com.pspdfkit.undo.edit.contentediting.ContentEditingEdit;
import com.pspdfkit.undo.edit.contentediting.ContentEditingNativeChangeEdit;
import com.pspdfkit.undo.edit.contentediting.ContentEditingTextBlockMoveAndResizeEdit;
import com.pspdfkit.utils.PageRect;
import com.pspdfkit.utils.PdfLog;
import com.pspdfkit.utils.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes3.dex */
public final class ta implements gu, tk, PropertyInspectorCoordinatorLayoutController.PropertyInspectorLifecycleListener, sa {
    public static final long Q = DurationKt.toDuration(200L, DurationUnit.MILLISECONDS);
    public static final Matrix R = new Matrix();
    public static final List<Float> S;
    public CoroutineScope A;
    public q30 B;
    public Size C;
    public boolean D;
    public final float E;
    public boolean F;
    public float G;
    public final RectF H;
    public final Matrix I;
    public final RectF J;
    public Boolean K;
    public final HashMap<d, PointF> L;
    public final lf<ContentEditingEdit> M;
    public e N;
    public e O;
    public final PointF P;
    public final ab a;
    public final Context b;
    public final int c;
    public final Lazy d;
    public final Paint e;
    public final float f;
    public final Paint g;
    public final float h;
    public final Paint i;
    public final Paint j;
    public final PointF k;
    public final PdfConfiguration l;
    public final d00 m;
    public au n;
    public Job o;
    public gb p;
    public String q;
    public final GestureDetector r;
    public final float[] s;
    public Matrix t;
    public long u;
    public final long v;
    public final ox<String, g> w;
    public HashMap<String, k50> x;
    public Map<String, i50> y;
    public a z;

    public static final class a {
        public final Matrix a;
        public final Size b;
        public Job c;

        public a(Matrix matrix, Size size, Job job) {
            size.getClass();
            this.a = matrix;
            this.b = size;
            this.c = job;
        }
    }

    public static final class b {
    }

    public final class c extends GestureDetector.SimpleOnGestureListener {
        public Point a;

        public c() {
        }

        public static final Unit a(ta taVar) {
            Matrix matrix = ta.R;
            taVar.a((String) null);
            return Unit.INSTANCE;
        }

        /* JADX WARN: Code duplicated, block: B:17:0x0096 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:18:0x0098  */
        /* JADX WARN: Code duplicated, block: B:20:0x00b1  */
        /* JADX WARN: Code duplicated, block: B:21:0x00b3  */
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onDown(MotionEvent motionEvent) {
            d dVar;
            RectF rectF;
            ViewParent parent;
            motionEvent.getClass();
            ContentEditingInspectorController contentEditingInspectorController = ta.this.a.j;
            if (contentEditingInspectorController != null && contentEditingInspectorController.isContentEditingInspectorVisible()) {
                ta.this.K = Boolean.FALSE;
            }
            ta.this.h();
            this.a = new Point((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
            ta taVar = ta.this;
            taVar.F = false;
            i50 i50VarL = taVar.l();
            if (i50VarL == null || !i50VarL.e.a.getScreenRect().contains(motionEvent.getX(), motionEvent.getY())) {
                HashMap<d, PointF> map = taVar.L;
                dVar = d.LEFT_BORDER;
                PointF pointF = map.get(dVar);
                HashMap<d, PointF> map2 = taVar.L;
                d dVar2 = d.RIGHT_BORDER;
                PointF pointF2 = map2.get(dVar2);
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                float f = taVar.E;
                RectF rectF2 = new RectF(x, y, x, y);
                float f2 = -f;
                rectF2.inset(f2, f2);
                if (pointF != null) {
                    float fA = a80.a(taVar.b, 12.0f);
                    float f3 = pointF.x;
                    float f4 = pointF.y;
                    RectF rectF3 = new RectF(f3, f4, f3, f4);
                    float f5 = -fA;
                    rectF3.inset(f5, f5);
                    if (!RectF.intersects(rectF2, rectF3)) {
                        if (pointF2 != null) {
                            float fA2 = a80.a(taVar.b, 12.0f);
                            float f6 = pointF2.x;
                            float f7 = pointF2.y;
                            rectF = new RectF(f6, f7, f6, f7);
                            float f8 = -fA2;
                            rectF.inset(f8, f8);
                            if (RectF.intersects(rectF2, rectF)) {
                                dVar = dVar2;
                            } else {
                                dVar = null;
                            }
                        } else {
                            dVar = null;
                        }
                    }
                } else if (pointF2 != null) {
                    float fA3 = a80.a(taVar.b, 12.0f);
                    float f9 = pointF2.x;
                    float f10 = pointF2.y;
                    rectF = new RectF(f9, f10, f9, f10);
                    float f11 = -fA3;
                    rectF.inset(f11, f11);
                    if (RectF.intersects(rectF2, rectF)) {
                        dVar = dVar2;
                    } else {
                        dVar = null;
                    }
                } else {
                    dVar = null;
                }
            } else {
                dVar = null;
            }
            if (dVar != null) {
                PdfLog.d("Nutri.ContEditModeHand", "Touched resize handle " + dVar, new Object[0]);
                au auVar = ta.this.n;
                if (auVar != null && (parent = auVar.getParent()) != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                ta taVar2 = ta.this;
                ta.a(taVar2, taVar2.y.get(taVar2.q), dVar);
                return true;
            }
            ta taVar3 = ta.this;
            j50 j50VarA = taVar3.a(motionEvent, taVar3.n().values());
            String strA = j50VarA != null ? j50VarA.a() : null;
            if (strA != null) {
                boolean zAreEqual = Intrinsics.areEqual(strA, ta.this.k());
                ta taVar4 = ta.this;
                if (zAreEqual) {
                    taVar4.K = Boolean.TRUE;
                    gb gbVar = taVar4.p;
                    taVar4.F = ta.a((View) (gbVar != null ? gbVar : null), motionEvent);
                    ta taVar5 = ta.this;
                    ta.a(taVar5, taVar5.y.get(taVar5.k()), d.MOVING);
                } else if (Intrinsics.areEqual(strA, taVar4.q)) {
                    ta taVar6 = ta.this;
                    ta.a(taVar6, taVar6.y.get(taVar6.q), d.MOVING);
                }
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final void onLongPress(MotionEvent motionEvent) {
            motionEvent.getClass();
            ta taVar = ta.this;
            if (taVar.p != null) {
                taVar.O = null;
                return;
            }
            j50 j50VarA = taVar.a(motionEvent, taVar.n().values());
            ta taVar2 = ta.this;
            if (j50VarA == null) {
                PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
                Matrix matrix = taVar2.t;
                Matrix matrix2 = new Matrix();
                matrix.invert(matrix2);
                s60.a(pointF, matrix2);
                taVar2.a(taVar2.b(pointF), pointF);
                return;
            }
            taVar2.a(j50VarA.a());
            PointF pointF2 = new PointF(motionEvent.getX(), motionEvent.getY());
            Matrix matrix3 = taVar2.t;
            Matrix matrix4 = new Matrix();
            matrix3.invert(matrix4);
            s60.a(pointF2, matrix4);
            taVar2.a(taVar2.c(pointF2), pointF2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            motionEvent.getClass();
            PdfLog.d("Nutri.ContEditModeHand", "onSingleTapConfirmed: event=" + motionEvent, new Object[0]);
            ta taVar = ta.this;
            Point point = this.a;
            if (point == null) {
                PdfLog.d("Nutri.ContEditModeHand", "onSingleTapConfirmed: no lastDownEvent, returning false", new Object[0]);
                return false;
            }
            if (a80.a(taVar.b, point.x, point.y, (int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                PdfLog.d("Nutri.ContEditModeHand", "onSingleTapConfirmed: slop threshold hit, returning false", new Object[0]);
                return false;
            }
            ta taVar2 = ta.this;
            j50 j50VarA = taVar2.a(motionEvent, taVar2.n().values());
            String strA = j50VarA != null ? j50VarA.a() : null;
            PdfLog.d("Nutri.ContEditModeHand", "onSingleTapConfirmed: tappedBlockId=" + strA, new Object[0]);
            if (strA == null) {
                PdfLog.d("Nutri.ContEditModeHand", "onSingleTapConfirmed: tapped empty space, clearing selection", new Object[0]);
                ta.this.b(false);
                final ta taVar3 = ta.this;
                lf<ContentEditingEdit> lfVar = taVar3.M;
                Function0<? extends R> function0 = new Function0() { // from class: com.pspdfkit.internal.ta$c$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ta.c.a(taVar3);
                    }
                };
                lfVar.getClass();
                try {
                    lfVar.a(function0);
                } catch (Exception unused) {
                }
                return false;
            }
            boolean zAreEqual = Intrinsics.areEqual(strA, ta.this.k());
            ta taVar4 = ta.this;
            if (zAreEqual) {
                taVar4.K = Boolean.TRUE;
                return true;
            }
            boolean zAreEqual2 = Intrinsics.areEqual(strA, taVar4.q);
            ta taVar5 = ta.this;
            if (!zAreEqual2) {
                taVar5.b(false);
                ta.this.a(strA);
                return true;
            }
            taVar5.a(strA, (Integer) null, (Integer) null);
            ta taVar6 = ta.this;
            gb gbVar = taVar6.p;
            taVar6.a(gbVar != null ? gbVar : null, motionEvent);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) throws Throwable {
            motionEvent2.getClass();
            PdfLog.d("Nutri.ContEditModeHand", "onScroll: e1=" + motionEvent + ", e2.action=" + motionEvent2.getAction() + ", pendingDrag=" + (ta.this.O != null) + ", dx=" + f + ", dy=" + f2, new Object[0]);
            if (motionEvent == null) {
                return false;
            }
            ta taVar = ta.this;
            e eVar = taVar.O;
            if (eVar != null) {
                taVar.h();
                ta.this.a(eVar.a, eVar.b, new PointF(motionEvent.getX(), motionEvent.getY()), new PointF(motionEvent2.getX(), motionEvent2.getY()));
                PdfLog.d("Nutri.ContEditModeHand", "Started " + eVar.b + " from (" + ((int) motionEvent.getX()) + "," + ((int) motionEvent.getY()) + " by dx=" + f + " dy=" + f2 + ")", new Object[0]);
            } else {
                taVar.d(new PointF(motionEvent2.getX(), motionEvent2.getY()));
            }
            return true;
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.pspdfkit.internal.ta$d[], still in use, count: 1, list:
      (r0v1 com.pspdfkit.internal.ta$d[]) from 0x0024: INVOKE (r0v1 com.pspdfkit.internal.ta$d[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
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
    public static final class d {
        MOVING,
        LEFT_BORDER,
        RIGHT_BORDER;

        static {
            EnumEntriesKt.enumEntries(dVarArr);
        }

        public d() {
            super(str, i);
        }

        public static d valueOf(String str) {
            return (d) Enum.valueOf(d.class, str);
        }

        public static d[] values() {
            return (d[]) d.clone();
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.pspdfkit.internal.ta$f[], still in use, count: 1, list:
      (r0v1 com.pspdfkit.internal.ta$f[]) from 0x0022: INVOKE (r0v1 com.pspdfkit.internal.ta$f[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
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
    public static final class f {
        DONT,
        IF_NEEDED,
        /* JADX INFO: Fake field, exist only in values array */
        ALWAYS;

        static {
            EnumEntriesKt.enumEntries(fVarArr);
        }

        public f() {
            super(str, i);
        }

        public static f valueOf(String str) {
            return (f) Enum.valueOf(f.class, str);
        }

        public static f[] values() {
            return (f[]) c.clone();
        }
    }

    public static final class g implements nx {
        public final ty a;
        public final long b;

        public g(ty tyVar, long j) {
            tyVar.getClass();
            this.a = tyVar;
            this.b = j;
        }

        @Override // com.pspdfkit.internal.nx
        public final void recycle() {
            this.a.recycle();
        }
    }

    public static final class h implements dt {
        @Override // com.pspdfkit.internal.dt
        public final void a(uy uyVar) {
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.views.page.handler.ContentEditingModeHandler$onScrollTo$1", f = "ContentEditingModeHandler.kt", i = {}, l = {464, 465}, m = "invokeSuspend", n = {}, nl = {465, 468}, s = {}, v = 2)
    public static final class i extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ au b;
        public final /* synthetic */ RectF c;

        @DebugMetadata(c = "com.pspdfkit.internal.views.page.handler.ContentEditingModeHandler$onScrollTo$1$1", f = "ContentEditingModeHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public final /* synthetic */ au a;
            public final /* synthetic */ RectF b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(au auVar, RectF rectF, Continuation<? super a> continuation) {
                super(2, continuation);
                this.a = auVar;
                this.b = rectF;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(this.a, this.b, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return new a(this.a, this.b, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                ResultKt.throwOnFailure(obj);
                au auVar = this.a;
                RectF rectF = this.b;
                auVar.getClass();
                rectF.getClass();
                m40 state = auVar.getState();
                if (state != null) {
                    int i = state.b;
                    long j = 200;
                    ln lnVar = auVar.getParentView().C;
                    if (lnVar != null) {
                        lnVar.a(rectF, i, j, false);
                    }
                }
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(au auVar, RectF rectF, Continuation<? super i> continuation) {
            super(2, continuation);
            this.b = auVar;
            this.c = rectF;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new i(this.b, this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return new i(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0040, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(r7, r1, r6) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r6.a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.ResultKt.throwOnFailure(r7)
                goto L43
            L12:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L1a:
                kotlin.ResultKt.throwOnFailure(r7)
                goto L2c
            L1e:
                kotlin.ResultKt.throwOnFailure(r7)
                r6.a = r3
                r3 = 200(0xc8, double:9.9E-322)
                java.lang.Object r7 = kotlinx.coroutines.DelayKt.delay(r3, r6)
                if (r7 != r0) goto L2c
                goto L42
            L2c:
                kotlinx.coroutines.MainCoroutineDispatcher r7 = kotlinx.coroutines.Dispatchers.getMain()
                com.pspdfkit.internal.ta$i$a r1 = new com.pspdfkit.internal.ta$i$a
                com.pspdfkit.internal.au r3 = r6.b
                android.graphics.RectF r4 = r6.c
                r5 = 0
                r1.<init>(r3, r4, r5)
                r6.a = r2
                java.lang.Object r6 = kotlinx.coroutines.BuildersKt.withContext(r7, r1, r6)
                if (r6 != r0) goto L43
            L42:
                return r0
            L43:
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.pspdfkit.internal.ta.i.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.views.page.handler.ContentEditingModeHandler$startEditingForTextBlockId$2", f = "ContentEditingModeHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    public static final class j extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public j(Continuation<? super j> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ta.this.new j(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ta.this.new j(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            ta taVar = ta.this;
            Matrix matrix = ta.R;
            taVar.a(Duration.INSTANCE.m16251getZEROUwyO8pc());
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.views.page.handler.ContentEditingModeHandler$updateTextBlockRenderings$job$1", f = "ContentEditingModeHandler.kt", i = {1, 1}, l = {859, 897}, m = "invokeSuspend", n = {"renderedCount", "total"}, nl = {861, 898}, s = {"L$0", "I$0"}, v = 2)
    public static final class k extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public Object a;
        public int b;
        public final /* synthetic */ long c;
        public final /* synthetic */ ta d;
        public final /* synthetic */ List<i50> e;
        public final /* synthetic */ Matrix f;
        public final /* synthetic */ Size g;
        public final /* synthetic */ long h;

        @DebugMetadata(c = "com.pspdfkit.internal.views.page.handler.ContentEditingModeHandler$updateTextBlockRenderings$job$1$2", f = "ContentEditingModeHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        public static final class a extends SuspendLambda implements Function2<ya<ty>, Continuation<? super Unit>, Object> {
            public /* synthetic */ Object a;
            public final /* synthetic */ Ref.IntRef b;
            public final /* synthetic */ ta c;
            public final /* synthetic */ long d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Ref.IntRef intRef, ta taVar, long j, Continuation<? super a> continuation) {
                super(2, continuation);
                this.b = intRef;
                this.c = taVar;
                this.d = j;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                a aVar = new a(this.b, this.c, this.d, continuation);
                aVar.a = obj;
                return aVar;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(ya<ty> yaVar, Continuation<? super Unit> continuation) {
                return ((a) create(yaVar, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                au auVar;
                ya yaVar = (ya) this.a;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                ResultKt.throwOnFailure(obj);
                this.b.element++;
                ox<String, g> oxVar = this.c.w;
                ty tyVar = (ty) yaVar.a;
                String str = tyVar.d;
                g gVar = new g(tyVar, this.d);
                oxVar.getClass();
                oxVar.a(str, gVar);
                ta taVar = this.c;
                q30 q30Var = taVar.B;
                if (q30Var != null && (auVar = taVar.n) != null && auVar.v) {
                    q30Var.c();
                }
                return Unit.INSTANCE;
            }
        }

        @DebugMetadata(c = "com.pspdfkit.internal.views.page.handler.ContentEditingModeHandler$updateTextBlockRenderings$job$1$3", f = "ContentEditingModeHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        public static final class b extends SuspendLambda implements Function3<FlowCollector<? super ya<ty>>, Throwable, Continuation<? super Unit>, Object> {
            public /* synthetic */ Throwable a;
            public final /* synthetic */ ta b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(ta taVar, Continuation<? super b> continuation) {
                super(3, continuation);
                this.b = taVar;
            }

            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(FlowCollector<? super ya<ty>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
                b bVar = new b(this.b, continuation);
                bVar.a = th;
                return bVar.invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Throwable th = this.a;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                ResultKt.throwOnFailure(obj);
                PdfLog.e("Nutri.ContEditModeHand", "Error on textblock rendering page " + this.b.c + ": " + th, new Object[0]);
                return Unit.INSTANCE;
            }
        }

        @DebugMetadata(c = "com.pspdfkit.internal.views.page.handler.ContentEditingModeHandler$updateTextBlockRenderings$job$1$4", f = "ContentEditingModeHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        public static final class c extends SuspendLambda implements Function3<FlowCollector<? super ya<ty>>, Throwable, Continuation<? super Unit>, Object> {
            public /* synthetic */ Throwable a;
            public final /* synthetic */ ta b;
            public final /* synthetic */ Ref.IntRef c;
            public final /* synthetic */ int d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(ta taVar, Ref.IntRef intRef, int i, Continuation<? super c> continuation) {
                super(3, continuation);
                this.b = taVar;
                this.c = intRef;
                this.d = i;
            }

            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(FlowCollector<? super ya<ty>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
                c cVar = new c(this.b, this.c, this.d, continuation);
                cVar.a = th;
                return cVar.invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Throwable th = this.a;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                ResultKt.throwOnFailure(obj);
                if (th == null) {
                    PdfLog.d("Nutri.ContEditModeHand", "Completed textblock rendering page " + this.b.c + " (rendered " + this.c.element + "/" + this.d + ")", new Object[0]);
                    this.b.a(false);
                } else if (th instanceof CancellationException) {
                    PdfLog.d("Nutri.ContEditModeHand", "Completed textblock rendering page " + this.b.c + " by cancellation (rendered " + this.c.element + "/" + this.d + ")", new Object[0]);
                }
                return Unit.INSTANCE;
            }
        }

        public static final class d implements Flow<ya<ty>> {
            public final /* synthetic */ Flow a;
            public final /* synthetic */ ta b;
            public final /* synthetic */ Matrix c;
            public final /* synthetic */ Size d;

            public static final class a<T> implements FlowCollector {
                public final /* synthetic */ FlowCollector a;
                public final /* synthetic */ ta b;
                public final /* synthetic */ Matrix c;
                public final /* synthetic */ Size d;

                /* JADX INFO: renamed from: com.pspdfkit.internal.ta$k$d$a$a, reason: collision with other inner class name */
                @DebugMetadata(c = "com.pspdfkit.internal.views.page.handler.ContentEditingModeHandler$updateTextBlockRenderings$job$1$invokeSuspend$$inlined$map$1$2", f = "ContentEditingModeHandler.kt", i = {0, 0, 0, 0, 0}, l = {50}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, nl = {49}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 2)
                public static final class C0288a extends ContinuationImpl {
                    public /* synthetic */ Object a;
                    public int b;
                    public Object c;
                    public Object e;
                    public Object f;
                    public Object g;

                    public C0288a(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= Integer.MIN_VALUE;
                        return a.this.emit(null, this);
                    }
                }

                public a(FlowCollector flowCollector, ta taVar, Matrix matrix, Size size) {
                    this.a = flowCollector;
                    this.b = taVar;
                    this.c = matrix;
                    this.d = size;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Object obj, Continuation continuation) {
                    C0288a c0288a;
                    if (continuation instanceof C0288a) {
                        c0288a = (C0288a) continuation;
                        int i = c0288a.b;
                        if ((i & Integer.MIN_VALUE) != 0) {
                            c0288a.b = i - Integer.MIN_VALUE;
                        } else {
                            c0288a = new C0288a(continuation);
                        }
                    } else {
                        c0288a = new C0288a(continuation);
                    }
                    Object obj2 = c0288a.a;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i2 = c0288a.b;
                    if (i2 == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.a;
                        i50 i50Var = (i50) obj;
                        ta taVar = this.b;
                        Matrix matrix = this.c;
                        Size size = this.d;
                        Matrix matrix2 = ta.R;
                        boolean zIsInvertColors = taVar.l.isInvertColors();
                        ab abVar = taVar.a;
                        int i3 = taVar.c;
                        abVar.getClass();
                        i50Var.getClass();
                        size.getClass();
                        ya yaVarA = abVar.a(new ry(i3, i50Var, matrix, size, zIsInvertColors, null, null));
                        c0288a.c = SpillingKt.nullOutSpilledVariable(obj);
                        c0288a.e = SpillingKt.nullOutSpilledVariable(c0288a);
                        c0288a.f = SpillingKt.nullOutSpilledVariable(obj);
                        c0288a.g = SpillingKt.nullOutSpilledVariable(flowCollector);
                        c0288a.b = 1;
                        if (flowCollector.emit(yaVarA, c0288a) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i2 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            public d(Flow flow, ta taVar, Matrix matrix, Size size) {
                this.a = flow;
                this.b = taVar;
                this.c = matrix;
                this.d = size;
            }

            @Override // kotlinx.coroutines.flow.Flow
            public final Object collect(FlowCollector<? super ya<ty>> flowCollector, Continuation continuation) {
                Object objCollect = this.a.collect(new a(flowCollector, this.b, this.c, this.d), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(long j, ta taVar, List<i50> list, Matrix matrix, Size size, long j2, Continuation<? super k> continuation) {
            super(2, continuation);
            this.c = j;
            this.d = taVar;
            this.e = list;
            this.f = matrix;
            this.g = size;
            this.h = j2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new k(this.c, this.d, this.e, this.f, this.g, this.h, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((k) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x00a5, code lost:
        
            if (kotlinx.coroutines.flow.FlowKt.collect(r12, r11) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r11.b
                r2 = 1
                r3 = 2
                if (r1 == 0) goto L23
                if (r1 == r2) goto L1f
                if (r1 != r3) goto L17
                java.lang.Object r11 = r11.a
                kotlin.jvm.internal.Ref$IntRef r11 = (kotlin.jvm.internal.Ref.IntRef) r11
                kotlin.ResultKt.throwOnFailure(r12)
                goto La8
            L17:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r12)
                throw r11
            L1f:
                kotlin.ResultKt.throwOnFailure(r12)
                goto L31
            L23:
                kotlin.ResultKt.throwOnFailure(r12)
                long r4 = r11.c
                r11.b = r2
                java.lang.Object r12 = kotlinx.coroutines.DelayKt.m16309delayVtjQ1oo(r4, r11)
                if (r12 != r0) goto L31
                goto La7
            L31:
                com.pspdfkit.internal.ta r12 = r11.d
                int r12 = r12.c
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                java.lang.String r2 = "Entered coroutine rendering page "
                r1.<init>(r2)
                java.lang.StringBuilder r12 = r1.append(r12)
                java.lang.String r12 = r12.toString()
                r1 = 0
                java.lang.Object[] r2 = new java.lang.Object[r1]
                java.lang.String r4 = "Nutri.ContEditModeHand"
                com.pspdfkit.utils.PdfLog.d(r4, r12, r2)
                java.util.List<com.pspdfkit.internal.i50> r12 = r11.e
                int r12 = r12.size()
                kotlin.jvm.internal.Ref$IntRef r5 = new kotlin.jvm.internal.Ref$IntRef
                r5.<init>()
                java.util.List<com.pspdfkit.internal.i50> r2 = r11.e
                kotlinx.coroutines.flow.Flow r2 = kotlinx.coroutines.flow.FlowKt.asFlow(r2)
                r10 = 0
                kotlinx.coroutines.flow.Flow r1 = kotlinx.coroutines.flow.FlowKt.buffer$default(r2, r1, r10, r3, r10)
                com.pspdfkit.internal.ta r2 = r11.d
                android.graphics.Matrix r4 = r11.f
                com.pspdfkit.utils.Size r6 = r11.g
                com.pspdfkit.internal.ta$k$d r7 = new com.pspdfkit.internal.ta$k$d
                r7.<init>(r1, r2, r4, r6)
                kotlinx.coroutines.CoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getDefault()
                kotlinx.coroutines.flow.Flow r1 = kotlinx.coroutines.flow.FlowKt.flowOn(r7, r1)
                com.pspdfkit.internal.ta$k$a r4 = new com.pspdfkit.internal.ta$k$a
                com.pspdfkit.internal.ta r6 = r11.d
                long r7 = r11.h
                r9 = 0
                r4.<init>(r5, r6, r7, r9)
                kotlinx.coroutines.flow.Flow r1 = kotlinx.coroutines.flow.FlowKt.onEach(r1, r4)
                com.pspdfkit.internal.ta$k$b r2 = new com.pspdfkit.internal.ta$k$b
                com.pspdfkit.internal.ta r4 = r11.d
                r2.<init>(r4, r10)
                kotlinx.coroutines.flow.Flow r1 = kotlinx.coroutines.flow.FlowKt.m16356catch(r1, r2)
                com.pspdfkit.internal.ta$k$c r2 = new com.pspdfkit.internal.ta$k$c
                com.pspdfkit.internal.ta r4 = r11.d
                r2.<init>(r4, r5, r12, r10)
                kotlinx.coroutines.flow.Flow r12 = kotlinx.coroutines.flow.FlowKt.onCompletion(r1, r2)
                java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
                r11.a = r1
                r11.b = r3
                java.lang.Object r11 = kotlinx.coroutines.flow.FlowKt.collect(r12, r11)
                if (r11 != r0) goto La8
            La7:
                return r0
            La8:
                kotlin.Unit r11 = kotlin.Unit.INSTANCE
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.pspdfkit.internal.ta.k.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    static {
        Float fValueOf = Float.valueOf(4.0f);
        S = CollectionsKt.listOf((Object[]) new Float[]{fValueOf, fValueOf});
    }

    public ta(ab abVar, Context context, int i2) {
        abVar.getClass();
        context.getClass();
        this.a = abVar;
        this.b = context;
        this.c = i2;
        this.d = LazyKt.lazy(new Function0() { // from class: com.pspdfkit.internal.ta$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ta.a(this.f$0);
            }
        });
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        displayMetrics.getClass();
        float fApplyDimension = TypedValue.applyDimension(1, 1.0f, displayMetrics);
        this.f = fApplyDimension;
        DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
        displayMetrics2.getClass();
        this.h = TypedValue.applyDimension(1, 1.0f, displayMetrics2);
        DisplayMetrics displayMetrics3 = context.getResources().getDisplayMetrics();
        displayMetrics3.getClass();
        this.k = new PointF(TypedValue.applyDimension(1, 12.0f, displayMetrics3), 0.0f);
        PdfConfiguration configuration = abVar.e.getConfiguration();
        configuration.getClass();
        this.l = configuration;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, R.styleable.pspdf__ContentEditing, R.attr.pspdf__contentEditingStyle, R.style.PSPDFKit_ContentEditing);
        typedArrayObtainStyledAttributes.getClass();
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__ContentEditing_pspdf__textBlockFrameColor, f60.a(context, androidx.appcompat.R.attr.colorPrimary));
        int color2 = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__ContentEditing_pspdf__editedTextBlockFrameColor, f60.a(context, androidx.appcompat.R.attr.colorPrimary));
        int color3 = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__ContentEditing_pspdf__textBlockFrameColorInvertedMode, ff.a(color));
        int color4 = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__ContentEditing_pspdf__editedTextBlockFrameColorInvertedMode, ff.a(color2));
        typedArrayObtainStyledAttributes.recycle();
        d00 d00Var = new d00(abVar.e.getParentFragmentManager(), "{" + i2 + "}__com.pspdfkit.internal.ContentModeHandler.SAVED_STATE_FRAGMENT_TAG", this);
        ((kb) abVar.f.getValue()).c.put(Integer.valueOf(i2), d00Var);
        this.m = d00Var;
        this.s = new float[9];
        Matrix matrix = R;
        this.t = matrix;
        this.u = u40.a(matrix.toShortString());
        this.v = 52428800L;
        this.w = new ox<>();
        this.x = new HashMap<>();
        this.y = new HashMap();
        this.z = new a(new Matrix(), new Size(0.0f, 0.0f), null);
        color = configuration.isInvertColors() ? color3 : color;
        Paint.Style style = Paint.Style.STROKE;
        Paint paint = new Paint();
        paint.setStyle(style);
        paint.setColor(color);
        this.e = paint;
        color2 = configuration.isInvertColors() ? color4 : color2;
        Paint paint2 = new Paint();
        paint2.setStyle(style);
        paint2.setColor(color2);
        this.g = paint2;
        Paint paint3 = new Paint(paint2);
        paint3.setStrokeWidth(0.0f);
        Paint.Style style2 = Paint.Style.FILL;
        paint3.setStyle(style2);
        this.j = paint3;
        Paint paint4 = new Paint();
        paint4.setStyle(style2);
        paint4.setColor(Color.argb(MathKt.roundToInt(25.5f), Color.red(color2), Color.green(color2), Color.blue(color2)));
        this.i = paint4;
        float f2 = this.G;
        List<Float> list = S;
        paint.setStrokeWidth(fApplyDimension);
        if (list != null) {
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Float.valueOf(((Number) it.next()).floatValue() * f2));
            }
            paint.setPathEffect(new DashPathEffect(CollectionsKt.toFloatArray(arrayList), 0.0f));
        }
        this.g.setStrokeWidth(this.h);
        d00Var.a();
        this.r = new GestureDetector(context, new c());
        DisplayMetrics displayMetrics4 = context.getResources().getDisplayMetrics();
        displayMetrics4.getClass();
        this.E = TypedValue.applyDimension(1, 4.0f, displayMetrics4);
        this.G = 1.0f;
        this.H = new RectF();
        this.I = new Matrix();
        this.J = new RectF();
        HashMap<d, PointF> map = new HashMap<>(2);
        map.put(d.LEFT_BORDER, new PointF());
        map.put(d.RIGHT_BORDER, new PointF());
        this.L = map;
        at atVar = abVar.c;
        atVar.getClass();
        this.M = new lf<>(atVar);
        this.P = new PointF();
    }

    public final void a(i50 i50Var) {
        PdfLog.d("Nutri.ContEditModeHand", "Clearing textblock content " + i50Var.c, new Object[0]);
        if (((String) i50Var.e.i.getValue()).length() == 0) {
            return;
        }
        g70 g70Var = i50Var.e;
        g70Var.getClass();
        x60 x60Var = new x60(g70Var.g, g70Var.h, g70Var.d);
        ab abVar = this.a;
        abVar.getClass();
        abVar.a(new qc(i50Var, abVar.a(i50Var), 0, -1));
        a(i50Var, x60Var, (Boolean) null);
        a(i50Var, false, false, false);
        o();
    }

    public final void b(i50 i50Var) {
        PdfLog.d("Nutri.ContEditModeHand", "Copying textblock " + i50Var.c + " to clipboard", new Object[0]);
        fa.a((fa) this.d.getValue(), i50Var);
    }

    public final void c(i50 i50Var) {
        PdfLog.d("Nutri.ContEditModeHand", "Deleting textblock " + i50Var.c, new Object[0]);
        if (i50Var.b) {
            PdfLog.d("Nutri.ContEditModeHand", "Textblock " + i50Var.c + " is already deleted", new Object[0]);
            return;
        }
        a(i50Var);
        i50Var.b = true;
        g70 g70Var = i50Var.e;
        g70Var.getClass();
        a(i50Var, new x60(g70Var.g, g70Var.h, g70Var.d), Boolean.valueOf(i50Var.b));
        a(i50Var, false, false, false);
        o();
    }

    @Override // com.pspdfkit.internal.gu
    public final boolean c() {
        return true;
    }

    @Override // com.pspdfkit.internal.gu
    public final boolean d() {
        PdfLog.d("Nutri.ContEditModeHand", "Leaving content editing mode page " + this.c + ".", new Object[0]);
        this.B = null;
        a aVar = this.z;
        Job job = aVar.c;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        aVar.c = null;
        CoroutineScope coroutineScope = this.A;
        if (coroutineScope != null) {
            CoroutineScopeKt.cancel$default(coroutineScope, null, 1, null);
        }
        this.A = null;
        this.o = null;
        h();
        j();
        a(true);
        if (this.D) {
            this.D = false;
            Function0<Unit> function0 = this.a.n;
            if (function0 != null) {
                function0.invoke();
            }
        }
        this.w.clear();
        this.y.clear();
        this.x.clear();
        this.n = null;
        ab abVar = this.a;
        abVar.getClass();
        abVar.i.remove(this);
        if (abVar.i.isEmpty()) {
            nb nbVar = (nb) abVar.d;
            nbVar.getClass();
            Iterator<ContentEditingManager.OnContentEditingModeChangeListener> it = nbVar.a.iterator();
            while (it.hasNext()) {
                it.next().onExitContentEditingMode(abVar);
            }
            ((kb) abVar.f.getValue()).a();
        }
        return true;
    }

    @Override // com.pspdfkit.internal.gu
    public final int f() {
        return 23;
    }

    @Override // com.pspdfkit.internal.gu
    public final void g() {
        PdfLog.d("Nutri.ContEditModeHand", "Leaving content editing mode page " + this.c + ".", new Object[0]);
        j();
        ab abVar = this.a;
        abVar.getClass();
        abVar.i.remove(this);
        abVar.i.isEmpty();
        Job job = this.o;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.o = null;
        this.n = null;
    }

    public final void h() {
        DocumentView documentViewM = m();
        if (documentViewM != null) {
            documentViewM.a.a();
        }
    }

    public final void i() {
        gb gbVar;
        final e eVar = this.N;
        if (eVar != null) {
            lf<ContentEditingEdit> lfVar = this.M;
            Function0<? extends R> function0 = new Function0() { // from class: com.pspdfkit.internal.ta$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ta.a(eVar, this);
                }
            };
            lfVar.getClass();
            try {
                lfVar.a(function0);
            } catch (Exception unused) {
            }
            e eVar2 = this.N;
            if (eVar2 != null && Intrinsics.areEqual(eVar2.a.c, k()) && (gbVar = this.p) != null) {
                gbVar.requestFocus();
            }
            this.N = null;
            o();
        }
    }

    public final void j() {
        boolean zAreEqual = Intrinsics.areEqual(k(), this.q);
        gb gbVar = this.p;
        if (gbVar != null) {
            i50 textBlock = gbVar.getTextBlock();
            String str = textBlock.c;
            hn.a(gbVar.getContext(), gbVar.G);
            hn.c(gbVar);
            gbVar.setOnFocusChangeListener(null);
            au auVar = this.n;
            if (auVar != null) {
                auVar.removeView(gbVar);
            }
            o();
            gbVar.K.removeCallbacks(gbVar.L);
            s00 s00Var = gbVar.k;
            vo voVar = s00Var.k;
            if (voVar != null) {
                voVar.d();
            }
            s00Var.a();
            s00Var.b();
            s00Var.f.dismiss();
            s00Var.g.dismiss();
            s00Var.h.dismiss();
            PdfLog.d("SelectionHandleController", "SelectionHandleController destroyed", new Object[0]);
            hn.c cVar = gbVar.H;
            if (cVar != null) {
                cVar.b();
            }
            gbVar.H = null;
            this.a.onFinishEditingContentBlock(str);
            a(textBlock, false);
        }
        if (zAreEqual) {
            a((String) null);
        }
        this.p = null;
    }

    public final String k() {
        i50 i50VarL = l();
        if (i50VarL != null) {
            return i50VarL.c;
        }
        return null;
    }

    public final i50 l() {
        gb gbVar = this.p;
        if (gbVar != null) {
            return gbVar.getTextBlock();
        }
        return null;
    }

    public final DocumentView m() {
        au auVar = this.n;
        if (auVar != null) {
            return auVar.getParentView();
        }
        return null;
    }

    public final Map<String, ? extends j50> n() {
        Map<String, i50> map = this.y;
        if (map.isEmpty()) {
            map = null;
        }
        return map == null ? this.x : map;
    }

    public final void o() {
        q30 q30Var = this.B;
        if (q30Var != null) {
            if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                q30Var.postInvalidate();
                return;
            }
            if (this.p != null) {
                PdfLog.d("Nutri.ContEditModeHand", "Invalidating edited view", new Object[0]);
            }
            q30Var.invalidate();
        }
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorCoordinatorLayoutController.PropertyInspectorLifecycleListener
    public final void onDisplayPropertyInspector(PropertyInspector propertyInspector) {
        propertyInspector.getClass();
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorCoordinatorLayoutController.PropertyInspectorLifecycleListener
    public final void onPreparePropertyInspector(PropertyInspector propertyInspector) {
        propertyInspector.getClass();
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorCoordinatorLayoutController.PropertyInspectorLifecycleListener
    public final void onRemovePropertyInspector(PropertyInspector propertyInspector) {
        gb gbVar;
        propertyInspector.getClass();
        i50 i50VarL = l();
        if (i50VarL != null) {
            a(i50VarL, false);
            if (this.K == null && (propertyInspector instanceof DefaultContentEditingInspectorController.ContentEditingPropertyInspector)) {
                DefaultContentEditingInspectorController.ContentEditingPropertyInspector contentEditingPropertyInspector = (DefaultContentEditingInspectorController.ContentEditingPropertyInspector) propertyInspector;
                if (contentEditingPropertyInspector.wasClosedByCloseButton()) {
                    b(false);
                } else if (contentEditingPropertyInspector.wasClosedByBackButton()) {
                    this.K = Boolean.TRUE;
                }
            }
        }
        if (Intrinsics.areEqual(this.K, Boolean.TRUE) && (gbVar = this.p) != null) {
            gbVar.requestFocus();
        }
        this.K = null;
    }

    @Override // com.pspdfkit.internal.tk
    public final boolean onRestoreInstanceState(Bundle bundle) {
        bundle.getClass();
        String string = bundle.getString("com.pspdfkit.internal.ContentModeHandler.EDITED_TEXTBLOCK_ID");
        if (string != null) {
            a(string, bundle.containsKey("com.pspdfkit.internal.ContentModeHandler.EDITED_TEXTBLOCK_SELECTION_START") ? Integer.valueOf(bundle.getInt("com.pspdfkit.internal.ContentModeHandler.EDITED_TEXTBLOCK_SELECTION_START")) : null, bundle.containsKey("com.pspdfkit.internal.ContentModeHandler.EDITED_TEXTBLOCK_SELECTION_END") ? Integer.valueOf(bundle.getInt("com.pspdfkit.internal.ContentModeHandler.EDITED_TEXTBLOCK_SELECTION_END")) : null);
            return true;
        }
        String string2 = bundle.getString("com.pspdfkit.internal.ContentModeHandler.SELECTED_TEXTBLOCK_ID");
        if (string2 == null) {
            return false;
        }
        a(string2);
        return true;
    }

    @Override // com.pspdfkit.internal.tk
    public final void onSaveInstanceState(Bundle bundle) {
        bundle.getClass();
        gb gbVar = this.p;
        if (gbVar != null) {
            bundle.putString("com.pspdfkit.internal.ContentModeHandler.EDITED_TEXTBLOCK_ID", gbVar.getTextBlock().c);
            bundle.putInt("com.pspdfkit.internal.ContentModeHandler.EDITED_TEXTBLOCK_SELECTION_START", gbVar.getSelectionStart());
            bundle.putInt("com.pspdfkit.internal.ContentModeHandler.EDITED_TEXTBLOCK_SELECTION_END", gbVar.getSelectionEnd());
        }
        bundle.putString("com.pspdfkit.internal.ContentModeHandler.SELECTED_TEXTBLOCK_ID", this.q);
    }

    public final void b(boolean z) {
        ArrayList<ta> arrayList = this.a.i;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            ta taVar = arrayList.get(i2);
            i2++;
            ta taVar2 = taVar;
            if (!z || !Intrinsics.areEqual(taVar2, this)) {
                taVar2.j();
            }
        }
    }

    public final PopupToolbar b(PointF pointF) {
        DocumentView documentViewM = m();
        if (documentViewM != null) {
            zd zdVar = documentViewM.a;
            PopupToolbar popupToolbar = zdVar.a.getContext() == null ? null : new PopupToolbar(zdVar.a);
            if (popupToolbar != null) {
                ArrayList arrayList = new ArrayList();
                if (((fa) this.d.getValue()).a()) {
                    arrayList.add(new PopupToolbarMenuItem(R.id.pspdf__content_editing_popuptoolbar_paste, R.string.pspdf__paste, R.drawable.pspdf__ic_content_paste, true));
                }
                arrayList.add(new PopupToolbarMenuItem(R.id.pspdf__content_editing_popuptoolbar_add_textblock, R.string.pspdf__content_editing_add_text_block, R.drawable.pspdf__ic_add_text_block, true));
                popupToolbar.setMenuItems(arrayList);
                popupToolbar.setDefaultItemHandler(new PopupToolbar.DefaultItemHandler() { // from class: com.pspdfkit.internal.ta$$ExternalSyntheticLambda6
                    @Override // com.pspdfkit.ui.PopupToolbar.DefaultItemHandler
                    public final boolean onItemClicked(PopupToolbarMenuItem popupToolbarMenuItem) {
                        return ta.a(this.f$0, popupToolbarMenuItem);
                    }
                });
                DocumentView documentViewM2 = m();
                if (documentViewM2 != null) {
                    int i2 = this.c;
                    zd zdVar2 = documentViewM2.a;
                    zdVar2.getClass();
                    OnPreparePopupToolbarListener onPreparePopupToolbarListener = zdVar2.i;
                    if (onPreparePopupToolbarListener != null) {
                        onPreparePopupToolbarListener.onPrepareContentEditingPopupToolbar(popupToolbar, i2, pointF);
                    }
                }
                popupToolbar.getMenuItems().isEmpty();
                return popupToolbar;
            }
        }
        return null;
    }

    public static final void a(ta taVar, i50 i50Var) {
        taVar.a(i50Var.c, (Integer) null, (Integer) null);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x001a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:12:0x001c A[Catch: all -> 0x0013, TryCatch #0 {all -> 0x0013, blocks: (B:4:0x0007, B:12:0x001c, B:14:0x0021, B:13:0x001f), top: B:41:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:13:0x001f A[Catch: all -> 0x0013, TryCatch #0 {all -> 0x0013, blocks: (B:4:0x0007, B:12:0x001c, B:14:0x0021, B:13:0x001f), top: B:41:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:16:0x0026  */
    /* JADX WARN: Code duplicated, block: B:18:0x0029 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:19:0x002b  */
    /* JADX WARN: Code duplicated, block: B:23:0x0062 A[Catch: all -> 0x0086, TryCatch #1 {all -> 0x0086, blocks: (B:21:0x002f, B:23:0x0062, B:24:0x0067, B:26:0x006f, B:28:0x0073, B:32:0x007d), top: B:43:0x002f }] */
    /* JADX WARN: Code duplicated, block: B:34:0x0082  */
    /* JADX WARN: Code duplicated, block: B:43:0x002f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:9:0x0017  */
    public final void a(i50 i50Var, PointF pointF, Float f2) throws Throwable {
        boolean z;
        Throwable th;
        boolean z2;
        lf<ContentEditingEdit> lfVar;
        ContentEditingTextBlockMoveAndResizeEdit contentEditingTextBlockMoveAndResizeEdit;
        Alignment alignment;
        f fVar;
        i50Var.getClass();
        boolean z3 = true;
        boolean z4 = false;
        if (f2 == null) {
            z = false;
            if (pointF != null) {
                if (z) {
                    fVar = f.DONT;
                } else {
                    fVar = f.IF_NEEDED;
                }
                a(i50Var, pointF, fVar);
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z) {
                if (z2) {
                    o();
                    return;
                }
                return;
            }
            List<qn> list = i50Var.e.f.a;
            Float f3 = i50Var.d.f;
            ab abVar = this.a;
            abVar.getClass();
            abVar.a(new y00(i50Var, abVar.a(i50Var), f2));
            lfVar = this.M;
            contentEditingTextBlockMoveAndResizeEdit = new ContentEditingTextBlockMoveAndResizeEdit(this.c, i50Var.c, null, null, f3, i50Var.d.f);
            lfVar.getClass();
            if (lfVar.b) {
                lfVar.c.add(contentEditingTextBlockMoveAndResizeEdit);
            }
            alignment = i50Var.d.b;
            if (alignment != Alignment.JUSTIFIED) {
                z3 = false;
            }
            a(i50Var, false, z3, false);
            if (z3) {
                return;
            }
            o();
            return;
        }
        try {
            if (Intrinsics.areEqual(f2, i50Var.d.f)) {
                z = false;
            } else {
                z = true;
            }
            if (pointF != null) {
                if (z) {
                    fVar = f.DONT;
                } else {
                    fVar = f.IF_NEEDED;
                }
                a(i50Var, pointF, fVar);
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z) {
                if (z2) {
                    o();
                    return;
                }
                return;
            }
            try {
                List<qn> list2 = i50Var.e.f.a;
                Float f4 = i50Var.d.f;
                ab abVar2 = this.a;
                abVar2.getClass();
                abVar2.a(new y00(i50Var, abVar2.a(i50Var), f2));
                lfVar = this.M;
                contentEditingTextBlockMoveAndResizeEdit = new ContentEditingTextBlockMoveAndResizeEdit(this.c, i50Var.c, null, null, f4, i50Var.d.f);
                lfVar.getClass();
                if (lfVar.b) {
                    lfVar.c.add(contentEditingTextBlockMoveAndResizeEdit);
                }
                alignment = i50Var.d.b;
                if (alignment != Alignment.JUSTIFIED && alignment != Alignment.CENTER && i50Var.e.a(list2) == 0) {
                    z3 = false;
                }
                a(i50Var, false, z3, false);
                if (z3) {
                    o();
                    return;
                }
                return;
            } catch (Throwable th2) {
                th = th2;
                z4 = z2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
        if (!z4) {
            throw th;
        }
        o();
        throw th;
    }

    public final PopupToolbar c(PointF pointF) {
        DocumentView documentViewM;
        final i50 i50Var = this.y.get(this.q);
        if (i50Var != null && (documentViewM = m()) != null) {
            zd zdVar = documentViewM.a;
            PopupToolbar popupToolbar = zdVar.a.getContext() == null ? null : new PopupToolbar(zdVar.a);
            if (popupToolbar != null) {
                PopupToolbarMenuItem popupToolbarMenuItem = new PopupToolbarMenuItem(R.id.pspdf__content_editing_popuptoolbar_cut, R.string.pspdf__cut, R.drawable.pspdf__ic_content_cut, true);
                PopupToolbarMenuItem popupToolbarMenuItem2 = new PopupToolbarMenuItem(R.id.pspdf__content_editing_popuptoolbar_copy, R.string.pspdf__copy, R.drawable.pspdf__ic_content_copy, true);
                PopupToolbarMenuItem popupToolbarMenuItem3 = new PopupToolbarMenuItem(R.id.pspdf__content_editing_popuptoolbar_delete, R.string.pspdf__delete, R.drawable.pspdf__ic_delete, true);
                popupToolbarMenuItem3.setTintColor(ContextCompat.getColor(this.b, R.color.pspdf__inspector_error_color));
                Unit unit = Unit.INSTANCE;
                popupToolbar.setMenuItems(CollectionsKt.mutableListOf(popupToolbarMenuItem, popupToolbarMenuItem2, popupToolbarMenuItem3, new PopupToolbarMenuItem(R.id.pspdf__content_editing_popuptoolbar_duplicate, R.string.pspdf__content_editing_duplicate_text_block, R.drawable.pspdf__ic_duplicate, true), new PopupToolbarMenuItem(R.id.pspdf__content_editing_popuptoolbar_edit, R.string.pspdf__edit, R.drawable.pspdf__ic_edit, true), new PopupToolbarMenuItem(R.id.pspdf__content_editing_popuptoolbar_clear, R.string.pspdf__clear, R.drawable.pspdf__ic_eraser, true)));
                popupToolbar.setDefaultItemHandler(new PopupToolbar.DefaultItemHandler() { // from class: com.pspdfkit.internal.ta$$ExternalSyntheticLambda10
                    @Override // com.pspdfkit.ui.PopupToolbar.DefaultItemHandler
                    public final boolean onItemClicked(PopupToolbarMenuItem popupToolbarMenuItem4) {
                        return ta.a(this.f$0, i50Var, popupToolbarMenuItem4);
                    }
                });
                DocumentView documentViewM2 = m();
                if (documentViewM2 != null) {
                    int i2 = this.c;
                    zd zdVar2 = documentViewM2.a;
                    zdVar2.getClass();
                    OnPreparePopupToolbarListener onPreparePopupToolbarListener = zdVar2.i;
                    if (onPreparePopupToolbarListener != null) {
                        onPreparePopupToolbarListener.onPrepareContentEditingPopupToolbar(popupToolbar, i2, pointF);
                    }
                }
                popupToolbar.getMenuItems().isEmpty();
                return popupToolbar;
            }
        }
        return null;
    }

    public static final class e {
        public final i50 a;
        public final d b;
        public final Matrix c;
        public final PointF d;
        public final PointF e;
        public final PointF f;
        public final PointF g;
        public final PointF h;
        public final float i;
        public final t70 j;
        public final PointF k;
        public final PointF l;

        public static final /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[Alignment.values().length];
                try {
                    iArr[Alignment.BEGIN.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Alignment.JUSTIFIED.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Alignment.CENTER.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[Alignment.END.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                a = iArr;
                int[] iArr2 = new int[d.values().length];
                try {
                    iArr2[0] = 1;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    d dVar = d.MOVING;
                    iArr2[1] = 2;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    d dVar2 = d.MOVING;
                    iArr2[2] = 3;
                } catch (NoSuchFieldError unused7) {
                }
            }
        }

        public e(i50 i50Var, PointF pointF, d dVar, Size size, Matrix matrix) {
            i50Var.getClass();
            size.getClass();
            matrix.getClass();
            this.a = i50Var;
            this.b = dVar;
            this.c = matrix;
            PointF pointF2 = new PointF(pointF.x, pointF.y);
            l4.a(matrix, pointF2);
            this.d = pointF2;
            this.e = new PointF(pointF2.x, pointF2.y);
            this.f = new PointF(pointF2.x, pointF2.y);
            this.g = new PointF();
            this.h = new PointF();
            Float f = i50Var.d.f;
            this.i = f != null ? f.floatValue() : i50Var.e.a.getPageRect().width();
            this.j = i50Var.d.a;
            int iOrdinal = dVar.ordinal();
            if (iOrdinal != 0) {
                if (iOrdinal == 1) {
                    float f2 = pointF2.x - i50Var.e.a.getPageRect().left;
                    this.k = new PointF(f2, pointF2.y);
                    this.l = new PointF((i50Var.e.a.getPageRect().right - ((Number) i50Var.e.j.getValue()).floatValue()) + f2, pointF2.y);
                    return;
                } else {
                    if (iOrdinal != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    this.k = new PointF(((Number) i50Var.e.j.getValue()).floatValue() + i50Var.e.a.getPageRect().left + (pointF2.x - i50Var.e.a.getPageRect().right), pointF2.y);
                    this.l = new PointF((pointF2.x + size.width) - i50Var.e.a.getPageRect().right, pointF2.y);
                    return;
                }
            }
            PointF pointF3 = new PointF(pointF2.x - i50Var.e.a.getPageRect().left, pointF2.y - i50Var.e.a.getPageRect().bottom);
            this.k = pointF3;
            PointF pointF4 = new PointF((pointF2.x + size.width) - i50Var.e.a.getPageRect().right, (pointF2.y + size.height) - i50Var.e.a.getPageRect().top);
            this.l = pointF4;
            if (i50Var.e.a.getPageRect().bottom < 0.0f) {
                pointF3.y = pointF2.y;
            }
            if (i50Var.e.a.getPageRect().top > size.height) {
                pointF4.y = pointF2.y;
            }
            float f3 = pointF4.y;
            float f4 = pointF3.y;
            if (f3 < f4) {
                pointF4.y = f4;
                pointF3.y = f3;
            }
        }

        public final t70 a() {
            int iOrdinal = this.b.ordinal();
            if (iOrdinal == 0) {
                t70 t70Var = this.j;
                float f = t70Var.a;
                PointF pointF = this.g;
                return new t70(f + pointF.x, t70Var.b - pointF.y);
            }
            if (iOrdinal == 1) {
                int i = a.a[this.a.d.b.ordinal()];
                if (i == 1 || i == 2) {
                    t70 t70Var2 = this.j;
                    return new t70(t70Var2.a + this.g.x, t70Var2.b);
                }
                if (i != 3) {
                    if (i == 4) {
                        return null;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                t70 t70Var3 = this.j;
                return new t70((this.g.x / 2) + t70Var3.a, t70Var3.b);
            }
            if (iOrdinal != 2) {
                throw new NoWhenBranchMatchedException();
            }
            int i2 = a.a[this.a.d.b.ordinal()];
            if (i2 == 1 || i2 == 2) {
                return null;
            }
            if (i2 == 3) {
                t70 t70Var4 = this.j;
                return new t70((this.g.x / 2) + t70Var4.a, t70Var4.b);
            }
            if (i2 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            t70 t70Var5 = this.j;
            return new t70(t70Var5.a + this.g.x, t70Var5.b);
        }

        public final Float b() {
            d dVar = this.b;
            if (dVar == d.MOVING) {
                return null;
            }
            int i = dVar == d.LEFT_BORDER ? -1 : 1;
            Alignment alignment = this.a.d.b;
            Alignment alignment2 = Alignment.CENTER;
            float f = this.i;
            PointF pointF = this.g;
            return Float.valueOf(((alignment == alignment2 ? pointF.x : pointF.x) * i) + f);
        }

        public final void c() {
            try {
                PointF pointF = this.e;
                pointF.x = RangesKt.coerceIn(pointF.x, this.k.x, this.l.x);
            } catch (IllegalArgumentException e) {
                PdfLog.e("Nutri.ContEditModeHand", "Error while keeping drag position x within page bounds: " + e, new Object[0]);
            }
            try {
                PointF pointF2 = this.e;
                pointF2.y = RangesKt.coerceIn(pointF2.y, this.k.y, this.l.y);
            } catch (IllegalArgumentException e2) {
                PdfLog.e("Nutri.ContEditModeHand", "Error while keeping drag position y within page bounds: " + e2, new Object[0]);
            }
        }

        public final void a(PointF pointF) {
            this.f.set(this.e);
            PointF pointF2 = this.e;
            pointF2.set(pointF);
            Matrix matrix = this.c;
            Matrix matrix2 = new Matrix();
            matrix.invert(matrix2);
            s60.a(pointF2, matrix2);
            c();
            PointF pointF3 = this.g;
            PointF pointF4 = this.e;
            float f = pointF4.x;
            PointF pointF5 = this.d;
            pointF3.set(f - pointF5.x, pointF4.y - pointF5.y);
            PointF pointF6 = this.h;
            PointF pointF7 = this.e;
            float f2 = pointF7.x;
            PointF pointF8 = this.f;
            pointF6.set(f2 - pointF8.x, pointF7.y - pointF8.y);
        }
    }

    public final void d(PointF pointF) throws Throwable {
        e eVar = this.N;
        if (eVar != null) {
            eVar.a(pointF);
            PdfLog.d("Nutri.ContEditModeHand", "Updated dragging " + eVar.b + " from " + eVar.d + " to (" + eVar.e + ")", new Object[0]);
            int iOrdinal = eVar.b.ordinal();
            if (iOrdinal == 0) {
                t70 t70VarA = eVar.a();
                if (t70VarA != null) {
                    a(eVar.a, new PointF(t70VarA.a, t70VarA.b), f.IF_NEEDED);
                    return;
                }
                return;
            }
            if (iOrdinal != 1 && iOrdinal != 2) {
                throw new NoWhenBranchMatchedException();
            }
            i50 i50Var = eVar.a;
            t70 t70VarA2 = eVar.a();
            a(i50Var, t70VarA2 != null ? new PointF(t70VarA2.a, t70VarA2.b) : null, eVar.b());
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0039  */
    public static final Unit a(qb qbVar, String str, ta taVar, i50 i50Var) {
        i50 i50Var2;
        i50Var.getClass();
        g70 g70Var = i50Var.e;
        g70Var.getClass();
        x60 x60Var = new x60(g70Var.g, g70Var.h, g70Var.d);
        if (qbVar != null) {
            try {
                ab abVar = taVar.a;
                String str2 = qbVar.a;
                int i2 = qbVar.b;
                b9 b9Var = qbVar.c;
                abVar.getClass();
                str2.getClass();
                i50Var2 = i50Var;
                try {
                    abVar.a(new ok(i50Var2, abVar.a(i50Var), str2, i2, b9Var));
                } catch (ContentEditingException unused) {
                    if (str.length() > 0) {
                        taVar.a.a(i50Var2, str, (Integer) null);
                    }
                }
            } catch (ContentEditingException unused2) {
                i50Var2 = i50Var;
            }
        } else {
            i50Var2 = i50Var;
            if (str.length() > 0) {
                taVar.a.a(i50Var2, str, (Integer) null);
            }
        }
        taVar.a(i50Var2, x60Var, (Boolean) null);
        return Unit.INSTANCE;
    }

    @Override // com.pspdfkit.internal.sa
    public final void a(final i50 i50Var, final boolean z, boolean z2, final boolean z3) {
        i50Var.getClass();
        i50Var.e.a.updateScreenRect(this.t);
        ab abVar = this.a;
        int i2 = this.c;
        abVar.getClass();
        boolean z4 = false;
        if (abVar.g.a == null) {
            PdfLog.w("Nutri.CEditingSMHandler", "Tried to register a changed text block, but the content editor is not initialized.", new Object[0]);
        } else {
            HashMap map = abVar.h.b;
            Integer numValueOf = Integer.valueOf(i2);
            Object map2 = map.get(numValueOf);
            if (map2 == null) {
                map2 = new HashMap();
                map.put(numValueOf, map2);
            }
            ((Map) map2).put(i50Var.c, i50Var);
            abVar.onContentChange(i50Var.c);
        }
        if (i50Var.b) {
            j();
            if (Intrinsics.areEqual(this.q, i50Var.c)) {
                a((String) null);
            }
        }
        if (z2) {
            ContentEditingInspectorController contentEditingInspectorController = this.a.j;
            if (contentEditingInspectorController != null && contentEditingInspectorController.isContentEditingInspectorVisible() && this.p == null) {
                z4 = true;
            }
            a(i50Var, z4);
        }
        h60.a(new Runnable() { // from class: com.pspdfkit.internal.ta$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                ta.a(this.f$0, i50Var, z, z3);
            }
        });
    }

    public static final fa a(ta taVar) {
        return new fa(taVar.b);
    }

    public final void a(String str) {
        if (Intrinsics.areEqual(this.q, str)) {
            return;
        }
        i50 i50Var = this.y.get(this.q);
        if (i50Var != null && i50Var.c().c().length() == 0) {
            c(i50Var);
        }
        this.q = str;
        o();
    }

    /* JADX WARN: Code duplicated, block: B:36:0x01ec  */
    public final Matrix a(Collection<i50> collection, Matrix matrix) {
        long jHeight;
        long jHeight2;
        Object obj;
        double d2;
        long jWidth;
        String str;
        if (!collection.isEmpty()) {
            Iterator<T> it = collection.iterator();
            if (it.hasNext()) {
                Object next = it.next();
                if (it.hasNext()) {
                    i50 i50Var = (i50) next;
                    g gVar = this.w.get(i50Var.c);
                    if (gVar != null) {
                        ty tyVar = gVar.a;
                        jHeight = ((long) tyVar.a().getWidth()) * ((long) tyVar.a().getHeight());
                    } else {
                        RectF pageRect = i50Var.e.a.getPageRect();
                        pageRect.getClass();
                        jHeight = (long) (pageRect.height() * pageRect.width());
                    }
                    do {
                        Object next2 = it.next();
                        i50 i50Var2 = (i50) next2;
                        g gVar2 = this.w.get(i50Var2.c);
                        if (gVar2 != null) {
                            ty tyVar2 = gVar2.a;
                            jHeight2 = ((long) tyVar2.a().getWidth()) * ((long) tyVar2.a().getHeight());
                        } else {
                            RectF pageRect2 = i50Var2.e.a.getPageRect();
                            pageRect2.getClass();
                            jHeight2 = (long) (pageRect2.height() * pageRect2.width());
                        }
                        if (jHeight < jHeight2) {
                            next = next2;
                            jHeight = jHeight2;
                        }
                    } while (it.hasNext());
                }
                obj = next;
            } else {
                obj = null;
            }
            i50 i50Var3 = (i50) obj;
            if (i50Var3 != null) {
                g gVar3 = this.w.get(i50Var3.c);
                if (gVar3 != null) {
                    float f2 = gVar3.a.c;
                    matrix.getValues(this.s);
                    float f3 = this.s[0] / f2;
                    long width = ((long) (gVar3.a.a().getWidth() * f3)) * ((long) (gVar3.a.a().getHeight() * f3));
                    long j2 = 4;
                    RectF pageRect3 = i50Var3.e.a.getPageRect();
                    pageRect3.getClass();
                    RectF rectF = new RectF(pageRect3);
                    matrix.mapRect(rectF);
                    d2 = 1.5d;
                    jWidth = Math.max(width * j2, (long) (((long) rectF.width()) * ((long) rectF.height()) * j2 * 1.5d));
                } else {
                    d2 = 1.5d;
                    RectF pageRect4 = i50Var3.e.a.getPageRect();
                    pageRect4.getClass();
                    RectF rectF2 = new RectF(pageRect4);
                    matrix.mapRect(rectF2);
                    jWidth = (long) (((long) rectF2.width()) * ((long) rectF2.height()) * ((long) 4) * 1.5d);
                }
                g gVar4 = this.w.get(i50Var3.c);
                if (gVar4 != null) {
                    float f4 = gVar4.a.c;
                    matrix.getValues(this.s);
                    float f5 = this.s[0] / f4;
                    long j3 = 4;
                    long width2 = ((long) (gVar4.a.a().getWidth() * f5)) * ((long) (gVar4.a.a().getHeight() * f5)) * j3;
                    RectF pageRect5 = i50Var3.e.a.getPageRect();
                    pageRect5.getClass();
                    RectF rectF3 = new RectF(pageRect5);
                    matrix.mapRect(rectF3);
                    long jWidth2 = (long) (((long) rectF3.width()) * ((long) rectF3.height()) * j3 * d2);
                    long j4 = 1048576;
                    str = "Max(PrevRender=" + (width2 / j4) + "MB, PageRect=" + (jWidth2 / j4) + "MB) from " + gVar4.a.a().getWidth() + "x" + gVar4.a.a().getHeight() + " @ zoom " + gVar4.a.c;
                    if (str == null) {
                        RectF rectF4 = new RectF(i50Var3.e.a.getPageRect());
                        matrix.mapRect(rectF4);
                        str = "PageRect(" + ((int) rectF4.width()) + "x" + ((int) rectF4.height()) + " with 1.5x safety)";
                    }
                } else {
                    RectF rectF5 = new RectF(i50Var3.e.a.getPageRect());
                    matrix.mapRect(rectF5);
                    str = "PageRect(" + ((int) rectF5.width()) + "x" + ((int) rectF5.height()) + " with 1.5x safety)";
                }
                String str2 = i50Var3.c;
                long j5 = 1048576;
                long j6 = jWidth / j5;
                long j7 = this.v;
                PdfLog.d("Nutri.ContEditModeHand", "Bitmap size estimation for block " + str2 + ": Source=" + str + ", Estimated=" + j6 + "MB, Limit=" + (j7 / j5) + "MB, WillClamp=" + (jWidth > j7), new Object[0]);
                long j8 = this.v;
                if (jWidth > j8) {
                    long j9 = (long) (j8 * 0.95d);
                    float fSqrt = (float) Math.sqrt(j9 / jWidth);
                    Matrix matrix2 = new Matrix(matrix);
                    matrix2.postScale(fSqrt, fSqrt);
                    matrix.getValues(this.s);
                    float f6 = this.s[0];
                    PdfLog.d("Nutri.ContEditModeHand", "Clamping rendering matrix: original zoom=" + f6 + ", clamped zoom=" + (fSqrt * f6) + ". Estimated bitmap: " + j6 + "MB -> " + (j9 / j5) + "MB target (95% of " + (this.v / j5) + "MB max)", new Object[0]);
                    return matrix2;
                }
            }
        }
        return matrix;
    }

    @Override // com.pspdfkit.internal.sa
    public final void a(RectF rectF) {
        rectF.getClass();
        au auVar = this.n;
        if (auVar == null) {
            return;
        }
        Job job = this.o;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        CoroutineScope coroutineScope = this.A;
        this.o = coroutineScope != null ? BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new i(auVar, rectF, null), 3, null) : null;
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [com.pspdfkit.internal.tk, java.lang.Object] */
    @Override // com.pspdfkit.internal.gu
    public final void a(q30 q30Var) {
        m40 state;
        q30Var.getClass();
        this.B = q30Var;
        d00 d00Var = this.m;
        sk skVar = (sk) d00Var.a.findFragmentByTag(d00Var.b);
        if (skVar != null) {
            ?? r0 = d00Var.c;
            skVar.a = r0;
            Bundle bundle = skVar.b;
            if (bundle != null) {
                skVar.b = bundle;
                if (r0.onRestoreInstanceState(bundle)) {
                    skVar.b = null;
                }
            }
        }
        au parentView = q30Var.getParentView();
        if (parentView == null || (state = parentView.getState()) == null) {
            return;
        }
        this.C = state.a.getPageSize(this.c);
        this.n = parentView;
        lm lmVar = state.a;
        MainCoroutineDispatcher main = Dispatchers.getMain();
        main.getClass();
        this.A = CoroutineScopeKt.CoroutineScope(lmVar.b.getCoroutineContext().plus(main).plus(SupervisorKt.SupervisorJob((Job) lmVar.b.getCoroutineContext().get(Job.INSTANCE))));
        Size size = this.C;
        if (size != null) {
            Map mapEmptyMap = (Map) this.a.h.b.get(Integer.valueOf(this.c));
            if (mapEmptyMap == null) {
                mapEmptyMap = MapsKt.emptyMap();
            }
            List list = CollectionsKt.toList(mapEmptyMap.values());
            list.getClass();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((j50) it.next()).a(size);
            }
        }
        PdfLog.d("Nutri.ContEditModeHand", "Entering content editing mode page " + this.c + ".", new Object[0]);
        ab abVar = this.a;
        lm lmVar2 = state.a;
        abVar.getClass();
        if (!abVar.i.contains(this)) {
            abVar.i.add(this);
            if (abVar.g.a == null) {
                UndoManager contentEditingUndoManager = abVar.e.getContentEditingUndoManager();
                contentEditingUndoManager.getClass();
                contentEditingUndoManager.clearHistory();
                PdfLog.d("Nutri.CEditingSMHandler", "Creating native content editor", new Object[0]);
                abVar.g.a = NativeContentEditor.create(lmVar2.y);
                abVar.c();
            }
            if (abVar.i.size() == 1) {
                nb nbVar = (nb) abVar.d;
                nbVar.getClass();
                Iterator<ContentEditingManager.OnContentEditingModeChangeListener> it2 = nbVar.a.iterator();
                while (it2.hasNext()) {
                    it2.next().onEnterContentEditingMode(abVar);
                }
            }
        }
        CoroutineScope coroutineScope = this.A;
        if (coroutineScope != null) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new va(this, null), 3, null);
        }
    }

    public final i50 a(PointF pointF) {
        m40 state;
        if (this.D) {
            au auVar = this.n;
            if (((auVar == null || (state = auVar.getState()) == null) ? null : state.a) != null) {
                try {
                    return a(pointF, (Function1<? super i50, Unit>) null);
                } catch (ContentEditingException e2) {
                    PdfLog.e("Nutri.ContEditModeHand", "Error while creating new textblock: " + e2.getMessage(), new Object[0]);
                }
            }
        }
        return null;
    }

    public final void a(PopupToolbar popupToolbar, PointF pointF) {
        m40 state;
        if (this.D) {
            au auVar = this.n;
            if (((auVar == null || (state = auVar.getState()) == null) ? null : state.a) == null || popupToolbar == null || popupToolbar.getMenuItems().isEmpty()) {
                return;
            }
            this.P.set(pointF);
            DocumentView documentViewM = m();
            if (documentViewM != null) {
                int i2 = this.c;
                float f2 = pointF.x;
                float f3 = pointF.y;
                DocumentView documentViewM2 = m();
                ViewGroup.LayoutParams layoutParams = documentViewM2 != null ? documentViewM2.getLayoutParams() : null;
                ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
                float fA = f3 - s60.a(marginLayoutParams != null ? marginLayoutParams.topMargin : 0, this.t);
                zd zdVar = documentViewM.a;
                zdVar.getClass();
                zdVar.a();
                popupToolbar.show(i2, f2, fA);
                zdVar.h = popupToolbar;
            }
        }
    }

    public final void a(Map<String, i50> map) {
        if (this.n == null) {
            return;
        }
        Map<String, i50> mutableMap = MapsKt.toMutableMap(map);
        this.y = mutableMap;
        for (i50 i50Var : mutableMap.values()) {
            PdfLog.d("Nutri.ContEditModeHand", i50Var.c + " - " + ((String) i50Var.e.i.getValue()), new Object[0]);
            i50Var.e.a.updateScreenRect(this.t);
        }
        this.x.clear();
        au auVar = this.n;
        if (auVar == null || !auVar.v) {
            return;
        }
        a(Duration.INSTANCE.m16251getZEROUwyO8pc());
    }

    public static final void a(ta taVar, i50 i50Var, boolean z, boolean z2) {
        gb gbVar = taVar.p;
        if (gbVar != null) {
            if (Intrinsics.areEqual(gbVar.getTextBlock().c, i50Var.c)) {
                taVar.a(taVar.p);
                if (z) {
                    return;
                }
                gbVar.a(i50Var, z2);
                return;
            }
            taVar.j();
        }
    }

    @Override // com.pspdfkit.internal.sa
    public final void a(i50 i50Var, StyleInfo styleInfo, int i2, int i3, boolean z) {
        i50Var.getClass();
        this.a.onContentSelectionChange(i50Var.c, i2, i3, styleInfo, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(i50 i50Var, boolean z) {
        r00 r00Var;
        ec ecVar;
        i50 i50Var2;
        Size size = this.C;
        if (size == null) {
            return;
        }
        Matrix matrixA = a(CollectionsKt.listOf(i50Var), this.t);
        long jA = u40.a(matrixA.toShortString());
        if (z) {
            int color = ContextCompat.getColor(this.b, R.color.pspdf__outlineVariantLight);
            r00Var = new r00(color);
            ecVar = new ec(color);
        } else {
            r00Var = null;
            ecVar = null;
        }
        try {
            boolean zIsInvertColors = this.l.isInvertColors();
            ab abVar = this.a;
            int i2 = this.c;
            abVar.getClass();
            i50Var.getClass();
            i50Var2 = i50Var;
            try {
                ya yaVarA = abVar.a(new ry(i2, i50Var2, matrixA, size, zIsInvertColors, r00Var, ecVar));
                ox<String, g> oxVar = this.w;
                String str = i50Var2.c;
                g gVar = new g((ty) yaVarA.a, jA);
                oxVar.getClass();
                oxVar.a(str, gVar);
                Bitmap bitmapA = ((ty) yaVarA.a).a();
                long byteCount = ((long) bitmapA.getByteCount()) / ((long) 1048576);
                if (byteCount > 25) {
                    PdfLog.w("Nutri.ContEditModeHand", "Unexpectedly large bitmap rendered for block " + i50Var2.c + ": " + byteCount + "MB (" + bitmapA.getWidth() + "x" + bitmapA.getHeight() + "). Zoom scale: " + this.G + ". This should have been clamped.", new Object[0]);
                }
                o();
            } catch (Exception e2) {
                e = e2;
                Exception exc = e;
                PdfLog.e("Nutri.ContEditModeHand", "Error rendering text block " + i50Var2.c + " on page " + this.c + ": " + exc.getMessage(), exc);
            }
        } catch (Exception e3) {
            e = e3;
            i50Var2 = i50Var;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.util.ArrayList] */
    public final void a(long j2) {
        ?? EmptyList;
        Job job;
        List mutableList;
        i50 i50Var;
        Size size = this.C;
        if (size == null || this.y.isEmpty()) {
            return;
        }
        if (this.A == null) {
            PdfLog.d("Nutri.ContEditModeHand", "Skipping textblock rendering page " + this.c + " - content editing scope is null", new Object[0]);
            return;
        }
        Matrix matrixA = a(this.y.values(), this.t);
        long jA = u40.a(matrixA.toShortString());
        Collection<i50> collectionValues = this.y.values();
        if (collectionValues.isEmpty()) {
            collectionValues = null;
        }
        if (collectionValues != null && (mutableList = CollectionsKt.toMutableList((Collection) collectionValues)) != null) {
            String strK = k();
            if (strK != null && (i50Var = this.y.get(strK)) != null && mutableList.remove(i50Var)) {
                mutableList.add(0, i50Var);
            }
            EmptyList = new ArrayList();
            for (Object obj : mutableList) {
                g gVar = this.w.get(((i50) obj).c);
                if (gVar == null || gVar.b != jA) {
                    EmptyList.add(obj);
                }
            }
        } else {
            EmptyList = CollectionsKt.emptyList();
        }
        if (EmptyList.isEmpty()) {
            return;
        }
        a aVar = this.z;
        aVar.getClass();
        if (Intrinsics.areEqual(aVar.a, matrixA) && Intrinsics.areEqual(aVar.b, size) && (job = aVar.c) != null && job.isActive()) {
            PdfLog.d("Nutri.ContEditModeHand", "Ignoring textblock rendering page " + this.c + " with same parameters as active job", new Object[0]);
            return;
        }
        a aVar2 = this.z;
        Job job2 = aVar2.c;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
        aVar2.c = null;
        boolean z = !Intrinsics.areEqual(matrixA, this.t);
        matrixA.getValues(this.s);
        PdfLog.d("Nutri.ContEditModeHand", "Starting textblock rendering page " + this.c + " (requested zoom: " + this.G + ", actual zoom: " + this.s[0] + ", clamped: " + z + ")", new Object[0]);
        CoroutineScope coroutineScope = this.A;
        this.z = new a(matrixA, size, coroutineScope != null ? BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new k(j2, this, EmptyList, matrixA, size, jA, null), 3, null) : null);
    }

    public final void a(boolean z) {
        m40 state;
        final boolean z2 = !z;
        au auVar = this.n;
        if (auVar == null || (state = auVar.getState()) == null || state.i == z2) {
            return;
        }
        auVar.a(new Function1() { // from class: com.pspdfkit.internal.ta$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ta.a(z2, (m40) obj);
            }
        });
        state.a.invalidateCacheForPage(this.c);
        auVar.a(new h());
    }

    public static final m40 a(boolean z, m40 m40Var) {
        m40Var.getClass();
        return m40.a(m40Var, false, null, 0.0f, z, false, null, null, null, 16127);
    }

    public final j50 a(MotionEvent motionEvent, Collection<? extends j50> collection) {
        Object obj = null;
        if (collection.isEmpty()) {
            return null;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        float f2 = this.E;
        RectF rectF = new RectF(x, y, x, y);
        float f3 = -f2;
        rectF.inset(f3, f3);
        i50 i50VarL = l();
        if (i50VarL != null) {
            this.H.set(i50VarL.c().a.getScreenRect());
            RectF rectF2 = this.H;
            PointF pointF = this.k;
            rectF2.inset(-pointF.x, -pointF.y);
            if (RectF.intersects(rectF, this.H)) {
                return i50VarL;
            }
        }
        j50 j50Var = n().get(this.q);
        if (j50Var != null) {
            this.H.set(j50Var.c().a.getScreenRect());
            RectF rectF3 = this.H;
            PointF pointF2 = this.k;
            rectF3.inset(-pointF2.x, -pointF2.y);
            if (RectF.intersects(rectF, this.H)) {
                return j50Var;
            }
        }
        PdfLog.d("Nutri.ContEditModeHand", "fingerrect " + rectF + " " + this.c, new Object[0]);
        for (Object obj2 : collection) {
            j50 j50Var2 = (j50) obj2;
            if (!j50Var2.b && RectF.intersects(rectF, j50Var2.c().a.getScreenRect())) {
                obj = obj2;
                break;
            }
        }
        return (j50) obj;
    }

    @Override // com.pspdfkit.internal.gu
    public final boolean a(MotionEvent motionEvent) {
        ViewParent parent;
        gb gbVar;
        ViewParent parent2;
        PdfLog.d("Nutri.ContEditModeHand", "onTouchEvent: action=" + motionEvent.getAction() + ", actionString=" + MotionEvent.actionToString(motionEvent.getAction()) + ", pendingDrag=" + (this.O != null), new Object[0]);
        int action = motionEvent.getAction();
        if (action == 1) {
            this.O = null;
            gb gbVar2 = this.p;
            if (gbVar2 != null && this.F) {
                a((View) gbVar2, motionEvent);
                this.F = false;
            }
            i();
            au auVar = this.n;
            if (auVar != null && (parent = auVar.getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(false);
            }
        } else if (action != 2) {
            if (action == 3) {
                PdfLog.d("Nutri.ContEditModeHand", "Touch gesture cancelled, cleaning up state", new Object[0]);
                this.O = null;
                gb gbVar3 = this.p;
                if (gbVar3 != null && this.F) {
                    a((View) gbVar3, motionEvent);
                    this.F = false;
                }
                i();
                au auVar2 = this.n;
                if (auVar2 != null && (parent2 = auVar2.getParent()) != null) {
                    parent2.requestDisallowInterceptTouchEvent(false);
                }
            }
        } else if (this.F && (gbVar = this.p) != null) {
            a((View) gbVar, motionEvent);
        }
        return this.r.onTouchEvent(motionEvent);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void a(String str, Integer num, Integer num2) {
        i50 i50Var;
        gb gbVar;
        au auVar;
        if (this.w.get(str) == null) {
            a aVar = this.z;
            Job job = aVar.c;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            aVar.c = null;
            i50 i50Var2 = this.y.get(str);
            if (i50Var2 != null) {
                a(i50Var2, false);
            }
            CoroutineScope coroutineScope = this.A;
            if (coroutineScope != null) {
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new j(null), 3, null);
            }
        }
        if (this.w.get(str) == null || (i50Var = this.y.get(str)) == null) {
            return;
        }
        i50 i50Var3 = this.y.get(str);
        if (i50Var3 == null || (auVar = this.n) == null) {
            gbVar = null;
        } else {
            PdfLog.i("ContentEditingModeHandler", "Creating content editing view", new Object[0]);
            gb gbVar2 = new gb(this.b, this.c, i50Var3, this.a, this.G);
            gbVar2.setListener(this);
            gbVar2.setEditRecordedListener(this.a.c);
            DocumentView documentViewM = m();
            gbVar2.setMagnifierManager(documentViewM != null ? documentViewM.getMagnifierManager() : null);
            a(gbVar2);
            auVar.addView(gbVar2);
            gbVar = gbVar2;
        }
        if (gbVar == null) {
            return;
        }
        b(true);
        a(gbVar);
        gbVar.I = true;
        gbVar.requestFocus();
        if (((String) gbVar.b.e.i.getValue()).length() > 0) {
            gbVar.a(((String) gbVar.b.e.i.getValue()).length(), ((String) gbVar.b.e.i.getValue()).length(), true);
        }
        gbVar.i();
        WeakHashMap weakHashMap = hn.a;
        gbVar.H = new hn.c(a80.a(gbVar), gbVar);
        gbVar.G = hn.a(gbVar.getContext(), 16);
        hn.a(gbVar, (f7) null);
        gbVar.setOnFocusChangeListener(gbVar);
        this.p = gbVar;
        this.a.onStartEditingContentBlock(str);
        if (num != null) {
            int iCoerceAtMost = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(num.intValue(), 0), ((String) i50Var.e.i.getValue()).length());
            gbVar.a(iCoerceAtMost, num2 != null ? RangesKt.coerceAtMost(RangesKt.coerceAtLeast(num2.intValue(), 0), ((String) i50Var.e.i.getValue()).length()) : iCoerceAtMost, true);
        }
        this.a.onContentSelectionChange(str, gbVar.getSelectionStart(), gbVar.getSelectionEnd(), i50Var.d(), true);
    }

    @Override // com.pspdfkit.internal.gu
    public final void a(Matrix matrix) {
        boolean z;
        au auVar = this.n;
        if (auVar == null || !auVar.v) {
            z = false;
        } else {
            z = Intrinsics.areEqual(this.t, R) ? true : !Intrinsics.areEqual(matrix, this.t);
        }
        if (z) {
            this.t = matrix;
            this.u = u40.a(matrix.toShortString());
            this.t.getValues(this.s);
            float f2 = this.s[0];
            this.G = f2;
            au auVar2 = this.n;
            if (auVar2 == null) {
                return;
            }
            if (f2 > 20.0f) {
                PdfLog.w("Nutri.ContEditModeHand", "Very high zoom scale detected: " + f2 + " (threshold: 20.0). PageScale = " + Float.valueOf(auVar2.getZoomScale()) + ", isDragging = " + (this.N != null) + ". Matrix values: " + matrix.toShortString(), new Object[0]);
            }
            int i2 = this.c;
            au auVar3 = this.n;
            PdfLog.d("Nutri.ContEditModeHand", "onPageViewUpdated page=" + i2 + ", zoomScale = " + f2 + ", PageScale = " + (auVar3 != null ? Float.valueOf(auVar3.getZoomScale()) : null), new Object[0]);
            Paint paint = this.e;
            float f3 = this.f;
            float f4 = this.G;
            List<Float> list = S;
            paint.setStrokeWidth(f3);
            if (list != null) {
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(Float.valueOf(((Number) it.next()).floatValue() * f4));
                }
                paint.setPathEffect(new DashPathEffect(CollectionsKt.toFloatArray(arrayList), 0.0f));
            }
            this.g.setStrokeWidth(this.h);
            for (j50 j50Var : n().values()) {
                j50Var.c().a.updateScreenRect(matrix);
                if (Intrinsics.areEqual(j50Var.a(), k())) {
                    gb gbVar = this.p;
                    if (gbVar != null) {
                        auVar2.getZoomScale();
                        float[] fArr = new float[9];
                        matrix.getValues(fArr);
                        float f5 = fArr[0];
                        gbVar.d = f5;
                        t50 t50Var = gbVar.e;
                        if (f5 != t50Var.b) {
                            t50Var.b = f5;
                            t50Var.b();
                        }
                        gbVar.invalidate();
                    }
                    a(this.p);
                }
            }
            a(Q);
            o();
            q30 q30Var = this.B;
            Integer numValueOf = q30Var != null ? Integer.valueOf(q30Var.getWidth()) : null;
            q30 q30Var2 = this.B;
            PdfLog.d("Nutri.ContEditModeHand", "viewsize = " + numValueOf + "x" + (q30Var2 != null ? Integer.valueOf(q30Var2.getHeight()) : null), new Object[0]);
        }
    }

    public final void a(gb gbVar) {
        j50 j50Var;
        float fFloatValue;
        if (gbVar == null || (j50Var = n().get(gbVar.getTextBlock().c)) == null) {
            return;
        }
        if (j50Var.c().a().b.a == 0.0f) {
            Float fC = j50Var.b().c();
            fFloatValue = fC != null ? fC.floatValue() : 100.0f;
        } else {
            fFloatValue = j50Var.c().a().b.a;
        }
        RectF rectF = new RectF(j50Var.c().a.getScreenRect().left - (j50Var.c().b * this.G), j50Var.c().a.getScreenRect().top, j50Var.c().a.getScreenRect().left + (s60.a(this.t) * fFloatValue * 1.0f), j50Var.c().a.getScreenRect().top + (s60.a(this.t) * j50Var.c().a().b.b));
        float f2 = rectF.left;
        if (gbVar.getX() != f2) {
            gbVar.setX(f2);
        }
        float f3 = rectF.top;
        if (gbVar.getY() != f3) {
            gbVar.setY(f3);
        }
        int iRoundToInt = MathKt.roundToInt(rectF.width());
        int iRoundToInt2 = MathKt.roundToInt(rectF.height());
        if (gbVar.getLayoutParams() == null) {
            gbVar.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
        }
        if (iRoundToInt == gbVar.getLayoutParams().width && iRoundToInt2 == gbVar.getLayoutParams().height) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = gbVar.getLayoutParams();
        gbVar.getLayoutParams().width = iRoundToInt;
        gbVar.getLayoutParams().height = iRoundToInt2;
        gbVar.setLayoutParams(layoutParams);
    }

    @Override // com.pspdfkit.internal.gu
    public final void a(Canvas canvas) {
        int iSave;
        RectF rectF;
        float fHeight;
        canvas.getClass();
        String strK = this.q;
        if (strK == null) {
            strK = k();
        }
        if (strK != null) {
            Intrinsics.areEqual(strK, k());
        }
        j50 j50Var = n().get(strK);
        Boolean bool = null;
        if (j50Var != null) {
            a(canvas, j50Var);
            this.H.set(j50Var.c().a.getScreenRect());
            RectF rectF2 = this.H;
            PointF pointF = this.k;
            rectF2.inset(-pointF.x, -pointF.y);
            rectF = this.H;
            e eVar = this.N;
            if ((eVar != null ? eVar.b : null) == d.MOVING) {
                canvas.drawRect(rectF, this.i);
            }
            iSave = canvas.save();
            canvas.clipOutRect(rectF);
        } else {
            iSave = -1;
            rectF = null;
        }
        for (j50 j50Var2 : n().values()) {
            if (!Intrinsics.areEqual(j50Var2.a(), strK) && !j50Var2.b) {
                a(canvas, j50Var2);
                canvas.drawRect(j50Var2.c().a.getScreenRect(), this.e);
            }
        }
        if (rectF != null) {
            canvas.restoreToCount(iSave);
            au auVar = this.n;
            if (auVar == null) {
                return;
            }
            this.J.set(auVar.getLocalVisibleRect());
            if (this.J.intersect(rectF)) {
                canvas.drawRect(rectF, this.g);
                float f2 = rectF.top;
                RectF rectF3 = this.J;
                if (f2 < rectF3.top) {
                    bool = Boolean.TRUE;
                } else if (rectF.bottom > rectF3.bottom) {
                    bool = Boolean.FALSE;
                }
                rectF3.left = rectF.left;
                rectF3.right = rectF.right;
                float fA = a80.a(this.b, 12.0f);
                float f3 = this.f;
                if (bool != null && 2 * fA > rectF3.height() + f3) {
                    if (bool.booleanValue()) {
                        fHeight = (rectF3.bottom + f3) - fA;
                    } else {
                        fHeight = (rectF3.top - f3) + fA;
                    }
                } else {
                    fHeight = (rectF3.height() / 2) + rectF3.top;
                }
                canvas.drawCircle(rectF3.left, fHeight, fA, this.j);
                canvas.drawCircle(rectF3.right, fHeight, fA, this.j);
                PointF pointF2 = this.L.get(d.LEFT_BORDER);
                if (pointF2 != null) {
                    pointF2.set(rectF3.left, fHeight);
                }
                PointF pointF3 = this.L.get(d.RIGHT_BORDER);
                if (pointF3 != null) {
                    pointF3.set(rectF3.right, fHeight);
                }
            }
        }
    }

    public final void a(Canvas canvas, j50 j50Var) {
        g gVar = this.w.get(j50Var.a());
        if (gVar != null) {
            Bitmap bitmapA = gVar.a.a();
            long byteCount = bitmapA.getByteCount();
            if (byteCount > this.v) {
                PdfLog.e("Nutri.ContEditModeHand", "UNEXPECTED: Oversized bitmap for block " + j50Var.a() + ": " + (byteCount / ((long) 1048576)) + "MB (" + bitmapA.getWidth() + "x" + bitmapA.getHeight() + "). Current zoom: " + this.G + ". This should have been prevented by matrix clamping.", new Object[0]);
                return;
            }
            if (gVar.b == this.u) {
                u70 u70Var = gVar.a.a.a;
                canvas.drawBitmap(bitmapA, u70Var.a, u70Var.b, (Paint) null);
                return;
            }
            float f2 = this.G / gVar.a.c;
            this.I.setScale(f2, f2);
            Matrix matrix = this.I;
            u70 u70Var2 = gVar.a.a.a;
            matrix.postTranslate(u70Var2.a * f2, u70Var2.b * f2);
            canvas.drawBitmap(gVar.a.a(), this.I, null);
        }
    }

    public static final Unit a(e eVar, ta taVar) {
        PdfLog.d("Nutri.ContEditModeHand", "Ended dragging " + eVar.b + " from " + eVar.d + ")", new Object[0]);
        ab abVar = taVar.a;
        int i2 = taVar.c;
        i50 i50Var = eVar.a;
        abVar.getClass();
        i50Var.getClass();
        if (abVar.g.a == null) {
            PdfLog.w("Nutri.CEditingSMHandler", "Tried to register a changed text block, but the content editor is not initialized.", new Object[0]);
        } else {
            HashMap map = abVar.h.b;
            Integer numValueOf = Integer.valueOf(i2);
            Object map2 = map.get(numValueOf);
            if (map2 == null) {
                map2 = new HashMap();
                map.put(numValueOf, map2);
            }
            ((Map) map2).put(i50Var.c, i50Var);
            abVar.onContentChange(i50Var.c);
        }
        lf<ContentEditingEdit> lfVar = taVar.M;
        int i3 = taVar.c;
        i50 i50Var2 = eVar.a;
        ContentEditingTextBlockMoveAndResizeEdit contentEditingTextBlockMoveAndResizeEdit = new ContentEditingTextBlockMoveAndResizeEdit(i3, i50Var2.c, eVar.j, i50Var2.d.a, Float.valueOf(eVar.i), eVar.b());
        lfVar.getClass();
        if (lfVar.b) {
            lfVar.c.add(contentEditingTextBlockMoveAndResizeEdit);
        }
        return Unit.INSTANCE;
    }

    public static final void a(ta taVar, i50 i50Var, d dVar) {
        if (i50Var == null) {
            return;
        }
        taVar.N = null;
        taVar.O = new e(i50Var, new PointF(), dVar, new Size(0.0f, 0.0f), taVar.t);
        taVar.o();
    }

    public final void a(i50 i50Var, d dVar, PointF pointF, PointF pointF2) {
        this.O = null;
        Size size = this.C;
        if (size == null) {
            return;
        }
        e eVar = new e(i50Var, pointF, dVar, size, this.t);
        eVar.a(pointF2);
        this.N = eVar;
        PdfLog.d("Nutri.ContEditModeHand", "Started dragging from " + pointF + " to " + pointF2, new Object[0]);
        o();
    }

    /* JADX WARN: Code duplicated, block: B:26:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:28:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:30:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:32:0x00e5  */
    public final void a(i50 i50Var, PointF pointF, f fVar) {
        g gVar;
        float f2;
        Float fValueOf;
        PageRect pageRect = new PageRect(i50Var.e.a.getPageRect());
        t70 t70Var = i50Var.d.a;
        pointF.getClass();
        float f3 = pointF.x;
        t70 t70Var2 = i50Var.d.a;
        PointF pointF2 = new PointF(f3 - t70Var2.a, t70Var2.b - pointF.y);
        l50 l50Var = i50Var.d;
        t70 t70Var3 = new t70(pointF.x, pointF.y);
        l50Var.getClass();
        l50Var.a = t70Var3;
        i50Var.c().a.getPageRect().offset(pointF2.x, pointF2.y);
        lf<ContentEditingEdit> lfVar = this.M;
        ContentEditingTextBlockMoveAndResizeEdit contentEditingTextBlockMoveAndResizeEdit = new ContentEditingTextBlockMoveAndResizeEdit(this.c, i50Var.c, t70Var, i50Var.d.a, null, null);
        lfVar.getClass();
        if (lfVar.b) {
            lfVar.c.add(contentEditingTextBlockMoveAndResizeEdit);
        }
        i50Var.e.a.updateScreenRect(this.t);
        int iOrdinal = fVar.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                Size size = this.C;
                if (size == null || ((pageRect.getPageRect().bottom >= 0.0f || pageRect.getPageRect().bottom >= i50Var.e.a.getPageRect().bottom) && (pageRect.getPageRect().top <= size.height || pageRect.getPageRect().top <= i50Var.e.a.getPageRect().top))) {
                    gVar = this.w.get(i50Var.c);
                    if (gVar != null) {
                        f2 = i50Var.e.b;
                        fValueOf = Float.valueOf(f2);
                        if (f2 == 0.0f) {
                            fValueOf = null;
                        }
                        u70 u70Var = new u70(MathKt.roundToInt(i50Var.e.a.getScreenRect().left + (fValueOf != null ? (-fValueOf.floatValue()) * s60.a(this.t) : 0.0f)), MathKt.roundToInt(i50Var.e.a.getScreenRect().top));
                        ty tyVar = gVar.a;
                        tyVar.getClass();
                        tyVar.a = new pb(u70Var, tyVar.a.b);
                    }
                }
            } else if (iOrdinal != 2) {
                throw new NoWhenBranchMatchedException();
            }
            a(i50Var, false);
        } else {
            gVar = this.w.get(i50Var.c);
            if (gVar != null) {
                f2 = i50Var.e.b;
                fValueOf = Float.valueOf(f2);
                if (f2 == 0.0f) {
                    fValueOf = null;
                }
                u70 u70Var2 = new u70(MathKt.roundToInt(i50Var.e.a.getScreenRect().left + (fValueOf != null ? (-fValueOf.floatValue()) * s60.a(this.t) : 0.0f)), MathKt.roundToInt(i50Var.e.a.getScreenRect().top));
                ty tyVar2 = gVar.a;
                tyVar2.getClass();
                tyVar2.a = new pb(u70Var2, tyVar2.a.b);
            }
        }
        if (Intrinsics.areEqual(i50Var.c, k())) {
            a(this.p);
        }
        o();
    }

    public static final boolean a(final ta taVar, final PopupToolbarMenuItem popupToolbarMenuItem) {
        popupToolbarMenuItem.getClass();
        taVar.h();
        lf<ContentEditingEdit> lfVar = taVar.M;
        Function0<? extends R> function0 = new Function0() { // from class: com.pspdfkit.internal.ta$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ta.a(popupToolbarMenuItem, taVar);
            }
        };
        lfVar.getClass();
        try {
            lfVar.a(function0);
            return true;
        } catch (Exception unused) {
            return true;
        }
    }

    public static final Unit a(PopupToolbarMenuItem popupToolbarMenuItem, ta taVar) {
        int id = popupToolbarMenuItem.getId();
        if (id == R.id.pspdf__content_editing_popuptoolbar_paste) {
            if (((fa) taVar.d.getValue()).a()) {
                PointF pointF = taVar.P;
                fa.a aVarB = ((fa) taVar.d.getValue()).b();
                if (aVarB != null) {
                    taVar.a(pointF, aVarB.b, aVarB.a);
                }
            }
        } else if (id == R.id.pspdf__content_editing_popuptoolbar_add_textblock) {
            taVar.a(taVar.P);
        }
        return Unit.INSTANCE;
    }

    public static final boolean a(final ta taVar, final i50 i50Var, final PopupToolbarMenuItem popupToolbarMenuItem) {
        popupToolbarMenuItem.getClass();
        taVar.h();
        lf<ContentEditingEdit> lfVar = taVar.M;
        Function0<? extends R> function0 = new Function0() { // from class: com.pspdfkit.internal.ta$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ta.a(popupToolbarMenuItem, taVar, i50Var);
            }
        };
        lfVar.getClass();
        try {
            lfVar.a(function0);
            return true;
        } catch (Exception unused) {
            return true;
        }
    }

    public static final Unit a(PopupToolbarMenuItem popupToolbarMenuItem, ta taVar, i50 i50Var) {
        int id = popupToolbarMenuItem.getId();
        if (id == R.id.pspdf__content_editing_popuptoolbar_cut) {
            taVar.b(i50Var);
            taVar.c(i50Var);
        } else if (id == R.id.pspdf__content_editing_popuptoolbar_copy) {
            taVar.b(i50Var);
        } else if (id == R.id.pspdf__content_editing_popuptoolbar_delete) {
            taVar.c(i50Var);
        } else if (id == R.id.pspdf__content_editing_popuptoolbar_duplicate) {
            taVar.a(taVar.P, i50Var);
        } else if (id == R.id.pspdf__content_editing_popuptoolbar_edit) {
            taVar.a(i50Var.c, (Integer) null, (Integer) null);
        } else if (id == R.id.pspdf__content_editing_popuptoolbar_clear) {
            taVar.a(i50Var);
        }
        return Unit.INSTANCE;
    }

    public final void a(PointF pointF, i50 i50Var) {
        try {
            a(pointF, new qb(i50Var.c, i50Var.e.g, null), (String) i50Var.e.i.getValue());
        } catch (ContentEditingException e2) {
            PdfLog.e("Nutri.ContEditModeHand", "Error while duplicating textblock " + i50Var.c + ": " + e2.getMessage(), new Object[0]);
        }
    }

    public final void a(PointF pointF, final qb qbVar, final String str) {
        a(pointF, new Function1() { // from class: com.pspdfkit.internal.ta$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ta.a(qbVar, str, this, (i50) obj);
            }
        });
    }

    public final i50 a(final PointF pointF, final Function1<? super i50, Unit> function1) {
        final i50 i50Var = (i50) this.M.a(new Function0() { // from class: com.pspdfkit.internal.ta$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ta.a(this.f$0, function1, pointF);
            }
        });
        a(i50Var, false, true, false);
        a(i50Var.c);
        o();
        q30 q30Var = this.B;
        if (q30Var != null) {
            q30Var.post(new Runnable() { // from class: com.pspdfkit.internal.ta$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    ta.a(this.f$0, i50Var);
                }
            });
        }
        return i50Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final i50 a(ta taVar, Function1 function1, PointF pointF) throws Throwable {
        ta taVar2;
        RectF rectF;
        ab abVar = taVar.a;
        int i2 = taVar.c;
        ArrayList<ta> arrayList = abVar.i;
        int size = arrayList.size();
        int i3 = 0;
        do {
            if (i3 >= size) {
                taVar2 = null;
                break;
            }
            taVar2 = arrayList.get(i3);
            i3++;
        } while (taVar2.c != i2);
        ta taVar3 = taVar2;
        i50 i50Var = (i50) abVar.a(new cc(i2, taVar3 != null ? taVar3.C : null)).a;
        taVar.a(i50Var, jb.a(i50Var), Boolean.valueOf(i50Var.b));
        taVar.y.put(i50Var.c, i50Var);
        if (function1 != null) {
            function1.invoke(i50Var);
        }
        Size size2 = taVar.C;
        if (size2 != null) {
            if (pointF == null) {
                au auVar = taVar.n;
                if (auVar == null) {
                    Size size3 = taVar.C;
                    rectF = new RectF(0.0f, size3 != null ? size3.height : 0.0f, size3 != null ? size3.width : 0.0f, 0.0f);
                } else {
                    RectF rectF2 = new RectF(auVar.getLocalVisibleRect());
                    s60.a(rectF2, taVar.t);
                    rectF = rectF2;
                }
                float f2 = 20;
                pointF = new PointF(rectF.left + f2, rectF.top - f2);
            }
            PointF pointF2 = new PointF(pointF.x, size2.height - pointF.y);
            float fWidth = 100.0f;
            if (i50Var.d.f == null) {
                fWidth = ((String) i50Var.e.i.getValue()).length() > 0 ? i50Var.e.a.getPageRect().width() : 100.0f;
                float f3 = pointF2.x + fWidth;
                float f4 = size2.width;
                if (f3 > f4) {
                    pointF2.x = f4 - fWidth;
                }
            }
            DocumentView documentViewM = taVar.m();
            if (documentViewM != null) {
                List<Integer> visiblePages = documentViewM.getVisiblePages();
                visiblePages.getClass();
                if (uc.d(taVar.b) && visiblePages.size() > 1) {
                    Integer num = (Integer) CollectionsKt.last((List) visiblePages);
                    int i4 = taVar.c;
                    if (num != null && num.intValue() == i4) {
                        pointF2.x = (size2.width - 20) - fWidth;
                    }
                }
            }
            taVar.a(i50Var, (PointF) null, Float.valueOf(fWidth));
            pointF2.y -= i50Var.e.a.getPageRect().height();
            taVar.a(i50Var, pointF2, (Float) null);
        }
        return i50Var;
    }

    public final void a(i50 i50Var, x60 x60Var, Boolean bool) {
        lf<ContentEditingEdit> lfVar = this.M;
        int i2 = this.c;
        String str = i50Var.c;
        g70 g70Var = i50Var.e;
        g70Var.getClass();
        ContentEditingNativeChangeEdit contentEditingNativeChangeEdit = new ContentEditingNativeChangeEdit(i2, str, x60Var, new x60(g70Var.g, g70Var.h, g70Var.d), i50Var.e(), bool);
        lfVar.getClass();
        if (lfVar.b) {
            lfVar.c.add(contentEditingNativeChangeEdit);
        }
    }

    public static boolean a(View view, MotionEvent motionEvent) {
        motionEvent.getClass();
        if (view == null) {
            return false;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.offsetLocation(-view.getX(), -view.getY());
        boolean zDispatchTouchEvent = view.dispatchTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
        return zDispatchTouchEvent;
    }

    public final void a(final gb gbVar, MotionEvent motionEvent) {
        if (gbVar == null) {
            return;
        }
        final MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        gbVar.post(new Runnable() { // from class: com.pspdfkit.internal.ta$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                ta.a(this.f$0, gbVar, motionEventObtain);
            }
        });
    }

    public static final void a(final ta taVar, final View view, final MotionEvent motionEvent) {
        motionEvent.getClass();
        taVar.getClass();
        a(view, motionEvent);
        view.post(new Runnable() { // from class: com.pspdfkit.internal.ta$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                ta.a(motionEvent, taVar, view);
            }
        });
    }

    public static final void a(MotionEvent motionEvent, ta taVar, View view) {
        motionEvent.setAction(1);
        taVar.getClass();
        a(view, motionEvent);
        motionEvent.recycle();
    }
}
