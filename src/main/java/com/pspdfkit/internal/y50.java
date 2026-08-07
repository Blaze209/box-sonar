package com.pspdfkit.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import com.pspdfkit.R;
import com.pspdfkit.analytics.Analytics;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.BaseRectsAnnotation;
import com.pspdfkit.annotations.BlendMode;
import com.pspdfkit.annotations.HighlightAnnotation;
import com.pspdfkit.annotations.RedactionAnnotation;
import com.pspdfkit.annotations.StrikeOutAnnotation;
import com.pspdfkit.annotations.UnderlineAnnotation;
import com.pspdfkit.annotations.defaults.AnnotationPreferencesManager;
import com.pspdfkit.configuration.rendering.PageRenderConfiguration;
import com.pspdfkit.datastructures.Range;
import com.pspdfkit.datastructures.TextSelection;
import com.pspdfkit.datastructures.TextSelectionRectangles;
import com.pspdfkit.internal.jni.NativeTextParser;
import com.pspdfkit.internal.jni.NativeTextRange;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import com.pspdfkit.ui.special_mode.manager.TextSelectionManager;
import com.pspdfkit.utils.PageRect;
import com.pspdfkit.utils.PdfLog;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleEmitter;
import io.reactivex.rxjava3.core.SingleOnSubscribe;
import io.reactivex.rxjava3.functions.Cancellable;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class y50 implements gu, tk {
    public float A;
    public b B;
    public float C;
    public ValueAnimator D;
    public ValueAnimator E;
    public float F;
    public ValueAnimator G;
    public final Handler H;
    public final c I;
    public final GestureDetector J;
    public Job K;
    public TextSelection a;
    public final a60 b;
    public final Paint c;
    public final PointF d;
    public final RectF e;
    public final ArrayList f;
    public final b60 g;
    public final d00 h;
    public final RectF i;
    public final RectF j;
    public final int k;
    public au l;
    public Drawable m;
    public Drawable n;
    public final PointF o;
    public final PointF p;
    public zd q;
    public Function0<Unit> r;
    public int s;
    public b t;
    public Matrix u;
    public boolean v;
    public vo w;
    public Float x;
    public float y;
    public float z;

    public static final class a {
        public final int a;
        public final int b;
        public final b c;

        public a(int i, int i2, b bVar) {
            this.a = i;
            this.b = i2;
            this.c = bVar;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.b == aVar.b && this.c == aVar.c;
        }

        public final int hashCode() {
            return this.c.hashCode() + nd.a(this.b, Integer.hashCode(this.a) * 31, 31);
        }

        public final String toString() {
            return "DragSelectionUpdate(selectionStart=" + this.a + ", selectionEnd=" + this.b + ", dragStatus=" + this.c + ")";
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.pspdfkit.internal.y50$b[], still in use, count: 1, list:
      (r0v1 com.pspdfkit.internal.y50$b[]) from 0x0024: INVOKE (r0v1 com.pspdfkit.internal.y50$b[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
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
        NO_DRAG,
        DRAGGING_LEFT,
        DRAGGING_RIGHT;

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
            return (b[]) d.clone();
        }
    }

    public final class c extends GestureDetector.SimpleOnGestureListener {
        public float a;
        public float b;
        public boolean c;

        public c() {
        }

        public static final void a(y50 y50Var, TextSelectionRectangles textSelectionRectangles) {
            au auVar;
            m40 state;
            m40 state2;
            y50Var.K = null;
            if (textSelectionRectangles == null || (auVar = y50Var.l) == null || (state = auVar.getState()) == null) {
                return;
            }
            lm lmVar = state.a;
            au auVar2 = y50Var.l;
            if (auVar2 == null || (state2 = auVar2.getState()) == null) {
                return;
            }
            y50Var.a(TextSelection.fromTextRects(lmVar, state2.b, textSelectionRectangles), b.NO_DRAG);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onDown(MotionEvent motionEvent) {
            motionEvent.getClass();
            y50 y50Var = y50.this;
            Job job = y50Var.K;
            if (job != null) {
                job.cancel((CancellationException) null);
            }
            y50Var.K = null;
            this.c = !(y50.this.t != b.NO_DRAG);
            this.a = motionEvent.getX();
            this.b = motionEvent.getY();
            return this.c;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final void onLongPress(MotionEvent motionEvent) {
            m40 state;
            m40 state2;
            motionEvent.getClass();
            if (this.c) {
                y50 y50Var = y50.this;
                if (y50Var.t != b.NO_DRAG || y50Var.l == null || y50Var.u == null) {
                    return;
                }
                Job job = y50Var.K;
                if (job != null) {
                    job.cancel((CancellationException) null);
                }
                y50Var.K = null;
                au auVar = y50.this.l;
                if (auVar == null || (state = auVar.getState()) == null) {
                    return;
                }
                lm lmVar = state.a;
                au auVar2 = y50.this.l;
                if (auVar2 == null || (state2 = auVar2.getState()) == null) {
                    return;
                }
                int i = state2.b;
                final y50 y50Var2 = y50.this;
                Matrix matrix = y50Var2.u;
                if (matrix == null) {
                    return;
                }
                y50Var2.K = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new v50(new u50() { // from class: com.pspdfkit.internal.y50$c$$ExternalSyntheticLambda0
                    @Override // com.pspdfkit.internal.u50
                    public final void a(TextSelectionRectangles textSelectionRectangles) {
                        y50.c.a(y50Var2, textSelectionRectangles);
                    }
                }, this.a, this.b, y50Var2.k, lmVar, i, matrix, null), 3, null);
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            motionEvent.getClass();
            if (!this.c) {
                return false;
            }
            y50 y50Var = y50.this;
            y50Var.a((TextSelection) null, y50Var.t);
            this.c = false;
            return true;
        }
    }

    public static final /* synthetic */ class d {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            try {
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b bVar = b.NO_DRAG;
                iArr[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b bVar2 = b.NO_DRAG;
                iArr[0] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[AnnotationType.values().length];
            try {
                iArr2[AnnotationType.REDACT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[AnnotationType.HIGHLIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[AnnotationType.STRIKEOUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[AnnotationType.UNDERLINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            a = iArr2;
        }
    }

    public static final class e extends AnimatorListenerAdapter {
        public e() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            animator.getClass();
            y50 y50Var = y50.this;
            y50Var.x = null;
            y50Var.y = 0.0f;
            y50Var.B = b.NO_DRAG;
            au auVar = y50Var.l;
            if (auVar != null) {
                int i = au.b0;
                auVar.a(false);
            }
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.views.page.handler.TextSelectionModeHandler$createAnnotationForSelectedText$1$job$1", f = "TextSelectionModeHandler.kt", i = {2}, l = {950, 951, 958}, m = "invokeSuspend", n = {"t"}, nl = {951, 957, 964}, s = {"L$0"}, v = 2)
    public static final class f extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public Object a;
        public int b;
        public final /* synthetic */ o3 c;
        public final /* synthetic */ BaseRectsAnnotation d;
        public final /* synthetic */ i4 e;
        public final /* synthetic */ SingleEmitter<BaseRectsAnnotation> f;

        @DebugMetadata(c = "com.pspdfkit.internal.views.page.handler.TextSelectionModeHandler$createAnnotationForSelectedText$1$job$1$1", f = "TextSelectionModeHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public final /* synthetic */ i4 a;
            public final /* synthetic */ BaseRectsAnnotation b;
            public final /* synthetic */ SingleEmitter<BaseRectsAnnotation> c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(i4 i4Var, BaseRectsAnnotation baseRectsAnnotation, SingleEmitter<BaseRectsAnnotation> singleEmitter, Continuation<? super a> continuation) {
                super(2, continuation);
                this.a = i4Var;
                this.b = baseRectsAnnotation;
                this.c = singleEmitter;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(this.a, this.b, this.c, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                ResultKt.throwOnFailure(obj);
                this.a.a(CollectionsKt.listOf(this.b), false, (Function0<Unit>) null);
                if (!this.c.isDisposed()) {
                    this.c.onSuccess(this.b);
                }
                return Unit.INSTANCE;
            }
        }

        @DebugMetadata(c = "com.pspdfkit.internal.views.page.handler.TextSelectionModeHandler$createAnnotationForSelectedText$1$job$1$2", f = "TextSelectionModeHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public final /* synthetic */ SingleEmitter<BaseRectsAnnotation> a;
            public final /* synthetic */ Throwable b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(SingleEmitter<BaseRectsAnnotation> singleEmitter, Throwable th, Continuation<? super b> continuation) {
                super(2, continuation);
                this.a = singleEmitter;
                this.b = th;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new b(this.a, this.b, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return new b(this.a, this.b, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                ResultKt.throwOnFailure(obj);
                if (!this.a.isDisposed()) {
                    this.a.onError(this.b);
                }
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(o3 o3Var, BaseRectsAnnotation baseRectsAnnotation, i4 i4Var, SingleEmitter<BaseRectsAnnotation> singleEmitter, Continuation<? super f> continuation) {
            super(2, continuation);
            this.c = o3Var;
            this.d = baseRectsAnnotation;
            this.e = i4Var;
            this.f = singleEmitter;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new f(this.c, this.d, this.e, this.f, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((f) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x0051, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(r9, r1, r8) == r0) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x006b, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(r1, r4, r8) == r0) goto L24;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r8.b
                r2 = 0
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L2c
                if (r1 == r5) goto L26
                if (r1 == r4) goto L22
                if (r1 != r3) goto L1a
                java.lang.Object r8 = r8.a
                java.lang.Throwable r8 = (java.lang.Throwable) r8
                kotlin.ResultKt.throwOnFailure(r9)
                goto L6e
            L1a:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L22:
                kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Throwable -> L2a
                goto L6e
            L26:
                kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Throwable -> L2a
                goto L3c
            L2a:
                r9 = move-exception
                goto L54
            L2c:
                kotlin.ResultKt.throwOnFailure(r9)
                com.pspdfkit.internal.o3 r9 = r8.c     // Catch: java.lang.Throwable -> L2a
                com.pspdfkit.annotations.BaseRectsAnnotation r1 = r8.d     // Catch: java.lang.Throwable -> L2a
                r8.b = r5     // Catch: java.lang.Throwable -> L2a
                java.lang.Object r9 = r9.addAnnotationToPage(r1, r8)     // Catch: java.lang.Throwable -> L2a
                if (r9 != r0) goto L3c
                goto L6d
            L3c:
                kotlinx.coroutines.MainCoroutineDispatcher r9 = kotlinx.coroutines.Dispatchers.getMain()     // Catch: java.lang.Throwable -> L2a
                com.pspdfkit.internal.y50$f$a r1 = new com.pspdfkit.internal.y50$f$a     // Catch: java.lang.Throwable -> L2a
                com.pspdfkit.internal.i4 r5 = r8.e     // Catch: java.lang.Throwable -> L2a
                com.pspdfkit.annotations.BaseRectsAnnotation r6 = r8.d     // Catch: java.lang.Throwable -> L2a
                io.reactivex.rxjava3.core.SingleEmitter<com.pspdfkit.annotations.BaseRectsAnnotation> r7 = r8.f     // Catch: java.lang.Throwable -> L2a
                r1.<init>(r5, r6, r7, r2)     // Catch: java.lang.Throwable -> L2a
                r8.b = r4     // Catch: java.lang.Throwable -> L2a
                java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r9, r1, r8)     // Catch: java.lang.Throwable -> L2a
                if (r8 != r0) goto L6e
                goto L6d
            L54:
                kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getMain()
                com.pspdfkit.internal.y50$f$b r4 = new com.pspdfkit.internal.y50$f$b
                io.reactivex.rxjava3.core.SingleEmitter<com.pspdfkit.annotations.BaseRectsAnnotation> r5 = r8.f
                r4.<init>(r5, r9, r2)
                java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
                r8.a = r9
                r8.b = r3
                java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r1, r4, r8)
                if (r8 != r0) goto L6e
            L6d:
                return r0
            L6e:
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.pspdfkit.internal.y50.f.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    static {
        Paint paint = new Paint();
        Paint paint2 = new Paint();
        paint.setColor(-16711936);
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        paint.setStrokeWidth(10.0f);
        paint2.setColor(-65281);
        paint2.setStyle(style);
        paint2.setStrokeWidth(20.0f);
    }

    public y50(TextSelection textSelection, a60 a60Var) {
        a60Var.getClass();
        this.a = textSelection;
        this.b = a60Var;
        Paint paint = new Paint();
        this.c = paint;
        this.d = new PointF();
        this.e = new RectF();
        new PointF();
        new RectF();
        this.f = new ArrayList();
        b60 b60Var = new b60(a60Var.f.requireContext());
        this.g = b60Var;
        d00 d00Var = new d00(a60Var.f.getParentFragmentManager(), "com.pspdfkit.internal.TextSelectionModeHandler.SAVED_STATE_FRAGMENT_TAG", this);
        this.h = d00Var;
        this.i = new RectF();
        this.j = new RectF();
        this.k = a60Var.f.requireContext().getResources().getDimensionPixelSize(R.dimen.pspdf__min_selectable_text_size);
        this.o = new PointF();
        this.p = new PointF();
        b bVar = b.NO_DRAG;
        this.t = bVar;
        this.B = bVar;
        this.C = 1.0f;
        this.H = new Handler(Looper.getMainLooper());
        c cVar = new c();
        this.I = cVar;
        this.J = new GestureDetector(a60Var.f.requireContext(), cVar);
        paint.setStyle(Paint.Style.FILL);
        gf.a(paint, a60Var.f.getConfiguration().isInvertColors() ? BlendMode.SCREEN : BlendMode.MULTIPLY);
        paint.setColor(b60Var.a);
        d00Var.a();
    }

    /* JADX WARN: Type inference failed for: r5v13, types: [com.pspdfkit.internal.tk, java.lang.Object] */
    @Override // com.pspdfkit.internal.gu
    public final void a(q30 q30Var) {
        Context context;
        q30Var.getClass();
        this.l = q30Var.getParentView();
        TextSelection textSelection = this.a;
        if (textSelection == null) {
            PdfLog.w("Nutri.TextSelModeHand", "Text selection mode was launched without selection. Leaving now.", new Object[0]);
            this.b.b.exitCurrentlyActiveMode();
            return;
        }
        if (!this.b.a(textSelection, (TextSelection) null)) {
            this.a = null;
            PdfLog.d("Nutri.TextSelModeHand", "Canceling attempted selection from listener.", new Object[0]);
            this.b.b.exitCurrentlyActiveMode();
            return;
        }
        au auVar = this.l;
        if (auVar == null || (context = auVar.getContext()) == null) {
            return;
        }
        this.s = (int) un.a(context, 1, 1);
        Drawable drawable = AppCompatResources.getDrawable(context, R.drawable.pspdf__text_select_handle_left);
        if (drawable == null) {
            throw new IllegalStateException("Left selection handle drawable is missing.");
        }
        int i = this.g.b;
        Drawable drawableWrap = DrawableCompat.wrap(drawable);
        drawableWrap.getClass();
        DrawableCompat.setTint(drawableWrap, i);
        this.m = drawableWrap;
        Drawable drawable2 = AppCompatResources.getDrawable(context, R.drawable.pspdf__text_select_handle_right);
        if (drawable2 == null) {
            throw new IllegalStateException("Right selection handle drawable is missing.");
        }
        int i2 = this.g.c;
        Drawable drawableWrap2 = DrawableCompat.wrap(drawable2);
        drawableWrap2.getClass();
        DrawableCompat.setTint(drawableWrap2, i2);
        this.n = drawableWrap2;
        k();
        j();
        if (this.r == null) {
            a60 a60Var = this.b;
            a60Var.k = this;
            this.q = a60Var.o;
            vo voVar = a60Var.i;
            voVar.getClass();
            this.w = voVar;
            x50 x50Var = (x50) a60Var.d;
            x50Var.getClass();
            if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                throw new IllegalStateException("Text selection listeners touched on non ui thread.");
            }
            Iterator<TextSelectionManager.OnTextSelectionModeChangeListener> it = x50Var.a.iterator();
            while (it.hasNext()) {
                it.next().onEnterTextSelectionMode(a60Var);
            }
            TextSelection textSelection2 = this.a;
            if (textSelection2 != null) {
                i0 i0VarA = ar.a();
                Bundle bundleA = z50.a(i0VarA);
                bundleA.putInt(Analytics.Data.PAGE_INDEX, textSelection2.pageIndex);
                i0VarA.a(Analytics.Event.SELECT_TEXT, bundleA);
            }
        }
        d00 d00Var = this.h;
        sk skVar = (sk) d00Var.a.findFragmentByTag(d00Var.b);
        if (skVar != null) {
            ?? r5 = d00Var.c;
            skVar.a = r5;
            Bundle bundle = skVar.b;
            if (bundle != null) {
                skVar.b = bundle;
                if (r5.onRestoreInstanceState(bundle)) {
                    skVar.b = null;
                }
            }
        }
        if (this.v) {
            this.b.createLinkAboveSelectedText();
        }
    }

    public final void b(float f2) {
        Matrix matrix;
        View view;
        b bVar = this.t;
        if (bVar == b.NO_DRAG || (matrix = this.u) == null || this.w == null) {
            return;
        }
        RectF rectF = bVar == b.DRAGGING_LEFT ? this.i : this.j;
        RectF rectF2 = this.e;
        rectF2.set(rectF);
        matrix.mapRect(rectF2);
        int[] iArr = new int[2];
        au auVar = this.l;
        if (auVar != null) {
            auVar.getLocationInWindow(iArr);
        }
        int[] iArr2 = new int[2];
        vo voVar = this.w;
        if (voVar != null && (view = voVar.a) != null) {
            view.getLocationInWindow(iArr2);
        }
        float f3 = (f2 + iArr[0]) - iArr2[0];
        float fCenterY = (this.e.centerY() + iArr[1]) - iArr2[1];
        vo voVar2 = this.w;
        if (voVar2 != null) {
            Context contextRequireContext = this.b.f.requireContext();
            contextRequireContext.getClass();
            wo.a(voVar2, contextRequireContext, f3, fCenterY, 1.25f);
        }
    }

    @Override // com.pspdfkit.internal.gu
    public final boolean c() {
        return true;
    }

    @Override // com.pspdfkit.internal.gu
    public final boolean d() {
        PdfLog.d("Nutri.TextSelModeHand", "Leaving text selection mode.", new Object[0]);
        i();
        TextSelection textSelection = this.a;
        if (textSelection != null) {
            if (!this.b.a((TextSelection) null, textSelection)) {
                this.b.f.enterTextSelectionMode(textSelection.pageIndex, textSelection.textRange);
                return false;
            }
            this.a = null;
            this.l = null;
        }
        a60 a60Var = this.b;
        x50 x50Var = (x50) a60Var.d;
        x50Var.getClass();
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            throw new IllegalStateException("Text selection listeners touched on non ui thread.");
        }
        Iterator<TextSelectionManager.OnTextSelectionModeChangeListener> it = x50Var.a.iterator();
        while (it.hasNext()) {
            it.next().onExitTextSelectionMode(a60Var);
        }
        a60Var.k = null;
        return true;
    }

    @Override // com.pspdfkit.internal.gu
    public final int f() {
        return 23;
    }

    @Override // com.pspdfkit.internal.gu
    public final void g() {
        PdfLog.d("Nutri.TextSelModeHand", "Leaving text selection mode.", new Object[0]);
        i();
        this.b.a((TextSelection) null, this.a);
        this.a = null;
        this.l = null;
        a60 a60Var = this.b;
        x50 x50Var = (x50) a60Var.d;
        x50Var.getClass();
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            throw new IllegalStateException("Text selection listeners touched on non ui thread.");
        }
        Iterator<TextSelectionManager.OnTextSelectionModeChangeListener> it = x50Var.a.iterator();
        while (it.hasNext()) {
            it.next().onExitTextSelectionMode(a60Var);
        }
        a60Var.k = null;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0042  */
    public final void h() {
        Float fValueOf;
        Rect bounds;
        Rect bounds2;
        Float f2 = this.x;
        if (f2 != null) {
            final float fFloatValue = f2.floatValue();
            final float f3 = this.y;
            int iOrdinal = this.t.ordinal();
            if (iOrdinal == 0) {
                fValueOf = null;
            } else if (iOrdinal == 1) {
                Drawable drawable = this.m;
                if (drawable == null || (bounds = drawable.getBounds()) == null) {
                    fValueOf = null;
                } else {
                    fValueOf = Float.valueOf(bounds.right);
                }
            } else {
                if (iOrdinal != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                Drawable drawable2 = this.n;
                if (drawable2 == null || (bounds2 = drawable2.getBounds()) == null) {
                    fValueOf = null;
                } else {
                    fValueOf = Float.valueOf(bounds2.left);
                }
            }
            if (fValueOf != null) {
                final float fFloatValue2 = fValueOf.floatValue();
                ValueAnimator valueAnimator = this.E;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                }
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
                valueAnimatorOfFloat.setDuration(200L);
                valueAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
                valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.pspdfkit.internal.y50$$ExternalSyntheticLambda0
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                        y50.a(this.f$0, fFloatValue2, fFloatValue, f3, valueAnimator2);
                    }
                });
                valueAnimatorOfFloat.addListener(new e());
                valueAnimatorOfFloat.start();
                this.E = valueAnimatorOfFloat;
            }
        }
    }

    public final void i() {
        this.H.removeCallbacksAndMessages(null);
        ValueAnimator valueAnimator = this.G;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.G = null;
        ValueAnimator valueAnimator2 = this.D;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        this.D = null;
        ValueAnimator valueAnimator3 = this.E;
        if (valueAnimator3 != null) {
            valueAnimator3.cancel();
        }
        this.E = null;
        this.x = null;
        this.y = 0.0f;
        this.C = 1.0f;
        this.F = 0.0f;
        this.B = b.NO_DRAG;
    }

    public final void j() {
        this.F = 0.0f;
        this.H.postDelayed(new Runnable() { // from class: com.pspdfkit.internal.y50$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                y50.a(this.f$0);
            }
        }, 300L);
    }

    public final void k() {
        m40 state;
        String str;
        TextSelection textSelection = this.a;
        if (textSelection == null) {
            PdfLog.e("Nutri.TextSelModeHand", new IllegalStateException(), "Can't update selection UI without a selection.", new Object[0]);
            return;
        }
        List<RectF> list = textSelection.textBlocks;
        list.getClass();
        int size = list.size();
        while (this.f.size() < size) {
            this.f.add(new PageRect());
        }
        while (this.f.size() > size) {
            this.f.remove(0);
        }
        for (int i = 0; i < size; i++) {
            PageRect pageRect = (PageRect) this.f.get(i);
            RectF rectF = list.get(i);
            pageRect.set(rectF.left - 1.0f, rectF.top + 1.0f, rectF.right + 1.0f, rectF.bottom - 1.0f);
        }
        if (size <= 0 || textSelection.textRange.getLength() <= 0 || (str = textSelection.text) == null || new Regex("[\r\n]").replace(str, "").length() == 0) {
            au auVar = this.l;
            if (auVar == null || (state = auVar.getState()) == null) {
                return;
            }
            lm lmVar = state.a;
            if (textSelection.textRange.getStartPosition() == lmVar.getPageTextLength(textSelection.pageIndex) || StringsKt.contains$default((CharSequence) "\n\r", (CharSequence) lmVar.getPageText(textSelection.pageIndex, textSelection.textRange.getStartPosition(), 1), false, 2, (Object) null)) {
                List<RectF> pageTextRects = lmVar.getPageTextRects(textSelection.pageIndex, textSelection.textRange.getStartPosition() - 1, 1, false);
                pageTextRects.getClass();
                if (!pageTextRects.isEmpty()) {
                    RectF rectF2 = pageTextRects.get(0);
                    this.j.set(rectF2);
                    this.i.set(rectF2);
                }
            } else {
                List<RectF> pageTextRects2 = lmVar.getPageTextRects(textSelection.pageIndex, textSelection.textRange.getStartPosition(), 1, false);
                pageTextRects2.getClass();
                if (!pageTextRects2.isEmpty()) {
                    RectF rectF3 = pageTextRects2.get(0);
                    this.i.set(rectF3);
                    this.j.set(rectF3);
                }
            }
        } else {
            RectF rectF4 = list.get(0);
            RectF rectF5 = list.get(size - 1);
            this.i.set(rectF4);
            this.j.set(rectF5);
        }
        PointF pointF = this.o;
        RectF rectF6 = this.i;
        pointF.set(rectF6.left, rectF6.bottom);
        PointF pointF2 = this.p;
        RectF rectF7 = this.j;
        pointF2.set(rectF7.right, rectF7.bottom);
        au auVar2 = this.l;
        if (auVar2 != null) {
            int i2 = au.b0;
            auVar2.a(false);
        }
    }

    @Override // com.pspdfkit.internal.tk
    public final boolean onRestoreInstanceState(Bundle bundle) {
        bundle.getClass();
        boolean z = bundle.getBoolean("isLinkCreationDialogShown");
        this.v = z;
        if (!z) {
            return false;
        }
        this.b.m = bundle.getString("linkCreationDialogText");
        return true;
    }

    @Override // com.pspdfkit.internal.tk
    public final void onSaveInstanceState(Bundle bundle) {
        bundle.getClass();
        bundle.putBoolean("isLinkCreationDialogShown", this.b.n);
        String str = this.b.m;
        if (str == null) {
            str = "";
        }
        bundle.putString("linkCreationDialogText", str);
    }

    public static final void b(y50 y50Var, ValueAnimator valueAnimator) {
        valueAnimator.getClass();
        Object animatedValue = valueAnimator.getAnimatedValue();
        animatedValue.getClass();
        y50Var.F = ((Float) animatedValue).floatValue();
        au auVar = y50Var.l;
        if (auVar != null) {
            int i = au.b0;
            auVar.a(false);
        }
    }

    public final BaseRectsAnnotation b(AnnotationType annotationType) {
        TextSelection textSelection = this.a;
        if (textSelection != null) {
            int i = d.a[annotationType.ordinal()];
            if (i == 1) {
                return new RedactionAnnotation(textSelection.pageIndex, textSelection.textBlocks);
            }
            if (i == 2) {
                return new HighlightAnnotation(textSelection.pageIndex, textSelection.textBlocks);
            }
            if (i == 3) {
                return new StrikeOutAnnotation(textSelection.pageIndex, textSelection.textBlocks);
            }
            if (i != 4) {
                throw new IllegalArgumentException("Passed annotation type " + annotationType + " is not supported.");
            }
            return new UnderlineAnnotation(textSelection.pageIndex, textSelection.textBlocks);
        }
        throw new IllegalStateException("createAnnotationForType: No selection found.");
    }

    /* JADX WARN: Code duplicated, block: B:118:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:172:0x030d  */
    /* JADX WARN: Code duplicated, block: B:174:0x0311  */
    /* JADX WARN: Code duplicated, block: B:177:0x031d  */
    /* JADX WARN: Code duplicated, block: B:178:0x0324  */
    /* JADX WARN: Code duplicated, block: B:41:0x0078  */
    /* JADX WARN: Code duplicated, block: B:76:0x0121  */
    @Override // com.pspdfkit.internal.gu
    public final boolean a(MotionEvent motionEvent) {
        Context context;
        Drawable drawable;
        boolean z;
        ValueAnimator valueAnimator;
        int i;
        boolean z2;
        float f2;
        m40 state;
        Drawable drawable2;
        int intrinsicWidth;
        int intrinsicHeight;
        RectF rectF;
        float f3;
        String strTextForRange;
        a aVar;
        a aVar2;
        if (this.l == null) {
            return false;
        }
        if (motionEvent.getPointerCount() > 1) {
            this.I.c = false;
            return false;
        }
        au auVar = this.l;
        if (auVar == null || (context = auVar.getContext()) == null) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                b bVar = this.t;
                b bVar2 = b.NO_DRAG;
                if (bVar != bVar2) {
                    h();
                    a(1.0f);
                    this.t = bVar2;
                    zd zdVar = this.q;
                    if (zdVar != null) {
                        zdVar.a(bVar2);
                    }
                } else {
                    this.x = null;
                    this.y = 0.0f;
                }
                vo voVar = this.w;
                if (voVar != null) {
                    voVar.d();
                }
            } else if (actionMasked == 2) {
                b bVar3 = this.t;
                b bVar4 = b.NO_DRAG;
                if (bVar3 != bVar4) {
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    if (this.a != null && bVar3 != bVar4) {
                        au auVar2 = this.l;
                        if (auVar2 == null || (state = auVar2.getState()) == null) {
                            f2 = 0.0f;
                        } else {
                            lm lmVar = state.a;
                            int i2 = state.b;
                            Matrix matrixA = auVar2.a((Matrix) null);
                            Drawable drawable3 = this.m;
                            if (drawable3 == null || (drawable2 = this.n) == null) {
                                f2 = 0.0f;
                            } else {
                                f2 = 0.0f;
                                b bVar5 = b.DRAGGING_LEFT;
                                if (bVar3 == bVar5) {
                                    intrinsicWidth = drawable3.getIntrinsicWidth() / 2;
                                } else {
                                    intrinsicWidth = (-drawable2.getIntrinsicWidth()) / 2;
                                }
                                if (bVar3 == bVar5) {
                                    intrinsicHeight = drawable3.getIntrinsicHeight();
                                } else {
                                    intrinsicHeight = drawable2.getIntrinsicHeight();
                                }
                                PointF pointF = new PointF(x + intrinsicWidth, y + (-intrinsicHeight));
                                l4.a(matrixA, pointF);
                                if (bVar3 == bVar5) {
                                    rectF = this.i;
                                } else {
                                    rectF = this.j;
                                }
                                float f4 = rectF.top;
                                float f5 = rectF.bottom;
                                int charIndexAt = lmVar.getCharIndexAt(i2, pointF.x, pointF.y);
                                float f6 = 2.0f;
                                if (charIndexAt < 0) {
                                    float f7 = (f4 + f5) / 2.0f;
                                    float f8 = pointF.y - f7;
                                    if (f8 != 0.0f) {
                                        int iCoerceAtLeast = RangesKt.coerceAtLeast((int) (Math.abs(f8) / RangesKt.coerceAtMost(RangesKt.coerceAtLeast(Math.abs(f5 - f4) / 2.0f, 2.0f), 12.0f)), 1);
                                        if (1 <= iCoerceAtLeast) {
                                            int i3 = 1;
                                            while (true) {
                                                f3 = f6;
                                                int charIndexAt2 = lmVar.getCharIndexAt(i2, pointF.x, pointF.y - ((i3 * f8) / (iCoerceAtLeast + 1)));
                                                if (charIndexAt2 >= 0) {
                                                    charIndexAt = charIndexAt2;
                                                    break;
                                                }
                                                if (i3 != iCoerceAtLeast) {
                                                    i3++;
                                                    f6 = f3;
                                                }
                                            }
                                        } else {
                                            f3 = 2.0f;
                                        }
                                        charIndexAt = lmVar.getCharIndexAt(i2, pointF.x, f7);
                                        break;
                                    } else {
                                        f3 = 2.0f;
                                        charIndexAt = lmVar.getCharIndexAt(i2, pointF.x, f7);
                                        break;
                                    }
                                } else {
                                    f3 = 2.0f;
                                }
                                if (charIndexAt >= 0) {
                                    NativeTextParser nativeTextParserA = lmVar.c.b(i2).a();
                                    if (nativeTextParserA == null) {
                                        strTextForRange = "";
                                    } else {
                                        strTextForRange = nativeTextParserA.textForRange(charIndexAt, 1);
                                        strTextForRange.getClass();
                                    }
                                    if (!StringsKt.contains$default((CharSequence) IOUtils.LINE_SEPARATOR_WINDOWS, (CharSequence) strTextForRange, false, 2, (Object) null)) {
                                        NativeTextParser nativeTextParserA2 = lmVar.c.b(i2).a();
                                        NativeTextRange nativeTextRangeTextRectsForRange = nativeTextParserA2 == null ? null : nativeTextParserA2.textRectsForRange(charIndexAt, 1);
                                        if (nativeTextRangeTextRectsForRange != null && !nativeTextRangeTextRectsForRange.getRects().isEmpty()) {
                                            RectF rect = nativeTextRangeTextRectsForRange.getRects().get(0).getRect();
                                            rect.getClass();
                                            if (pointF.x > (rect.width() / f3) + rect.left) {
                                                charIndexAt++;
                                            }
                                            TextSelection textSelection = this.a;
                                            if (textSelection != null) {
                                                int startPosition = textSelection.textRange.getStartPosition();
                                                int endPosition = textSelection.textRange.getEndPosition();
                                                bVar3.getClass();
                                                int iOrdinal = bVar3.ordinal();
                                                if (iOrdinal == 0) {
                                                    aVar = null;
                                                } else if (iOrdinal != 1) {
                                                    if (iOrdinal != 2) {
                                                        throw new NoWhenBranchMatchedException();
                                                    }
                                                    if (charIndexAt == startPosition) {
                                                        aVar = null;
                                                    } else if (charIndexAt > startPosition) {
                                                        aVar = new a(startPosition, charIndexAt, b.DRAGGING_RIGHT);
                                                    } else {
                                                        aVar = new a(charIndexAt, startPosition, b.DRAGGING_LEFT);
                                                    }
                                                } else if (charIndexAt == endPosition) {
                                                    aVar = null;
                                                } else {
                                                    if (charIndexAt < endPosition) {
                                                        aVar2 = new a(charIndexAt, endPosition, b.DRAGGING_LEFT);
                                                    } else {
                                                        aVar2 = new a(endPosition, charIndexAt, b.DRAGGING_RIGHT);
                                                    }
                                                    aVar = aVar2;
                                                }
                                                if (aVar != null) {
                                                    int i4 = aVar.a;
                                                    int i5 = aVar.b;
                                                    b bVar6 = aVar.c;
                                                    if (i4 != textSelection.textRange.getStartPosition() || i5 != textSelection.textRange.getEndPosition()) {
                                                        a(TextSelection.fromTextRange(lmVar, i2, new Range(i4, i5 - i4)), bVar6);
                                                    }
                                                }
                                            }
                                        } else {
                                            PdfLog.e("Nutri.TextSelModeHand", "Could not extract character rect for previously fetched touched index.", new Object[0]);
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        f2 = 0.0f;
                        PdfLog.e("Nutri.TextSelModeHand", new IllegalStateException(), "Invalid state while trying to drag selection.", new Object[0]);
                    }
                    if (this.t != bVar3) {
                        float f9 = f2;
                        this.z = f9;
                        this.A = motionEvent.getY();
                        this.y = f9;
                        b bVar7 = this.t;
                        this.B = bVar7;
                        zd zdVar2 = this.q;
                        if (zdVar2 != null) {
                            zdVar2.a(bVar7);
                        }
                    }
                    this.x = Float.valueOf(motionEvent.getX() - this.z);
                    float fA = (int) un.a(context, 1, 15);
                    this.y = RangesKt.coerceIn(motionEvent.getY() - this.A, -fA, fA);
                    this.A = motionEvent.getY() - this.y;
                    au auVar3 = this.l;
                    if (auVar3 != null) {
                        auVar3.a(false);
                    }
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    float x2 = motionEvent.getX();
                    motionEvent.getY();
                    b(x2);
                }
                z = z2;
            } else if (actionMasked != 3) {
                z = false;
            } else {
                b bVar8 = this.t;
                b bVar9 = b.NO_DRAG;
                if (bVar8 != bVar9) {
                    h();
                    a(1.0f);
                    this.t = bVar9;
                    zd zdVar3 = this.q;
                    if (zdVar3 != null) {
                        zdVar3.a(bVar9);
                    }
                } else {
                    this.x = null;
                    this.y = 0.0f;
                }
                vo voVar2 = this.w;
                if (voVar2 != null) {
                    voVar2.d();
                }
                this.I.c = false;
            }
            z = true;
        } else {
            int iA = (int) un.a(context, 1, 4);
            Rect rect2 = new Rect(((int) motionEvent.getX()) - iA, ((int) motionEvent.getY()) - iA, ((int) motionEvent.getX()) + iA, ((int) motionEvent.getY()) + iA);
            Drawable drawable4 = this.m;
            if (drawable4 == null || (drawable = this.n) == null) {
                return false;
            }
            if (Rect.intersects(drawable4.getBounds(), rect2)) {
                b bVar10 = b.DRAGGING_LEFT;
                this.t = bVar10;
                zd zdVar4 = this.q;
                if (zdVar4 != null) {
                    zdVar4.a(bVar10);
                }
            } else {
                if (Rect.intersects(drawable.getBounds(), rect2)) {
                    b bVar11 = b.DRAGGING_RIGHT;
                    this.t = bVar11;
                    zd zdVar5 = this.q;
                    if (zdVar5 != null) {
                        zdVar5.a(bVar11);
                    }
                } else {
                    z = false;
                }
                if (z) {
                    valueAnimator = this.E;
                    if (valueAnimator != null) {
                        valueAnimator.cancel();
                    }
                    this.E = null;
                    if (this.t == b.DRAGGING_LEFT) {
                        i = drawable4.getBounds().right;
                    } else {
                        i = drawable.getBounds().left;
                    }
                    float f10 = i;
                    this.z = motionEvent.getX() - f10;
                    this.A = motionEvent.getY();
                    this.x = Float.valueOf(f10);
                    this.y = 0.0f;
                    this.B = this.t;
                    a(1.5f);
                    float x3 = motionEvent.getX();
                    motionEvent.getY();
                    b(x3);
                }
            }
            z = true;
            if (z) {
                valueAnimator = this.E;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                }
                this.E = null;
                if (this.t == b.DRAGGING_LEFT) {
                    i = drawable4.getBounds().right;
                } else {
                    i = drawable.getBounds().left;
                }
                float f11 = i;
                this.z = motionEvent.getX() - f11;
                this.A = motionEvent.getY();
                this.x = Float.valueOf(f11);
                this.y = 0.0f;
                this.B = this.t;
                a(1.5f);
                float x4 = motionEvent.getX();
                motionEvent.getY();
                b(x4);
            }
        }
        return this.J.onTouchEvent(motionEvent) || z;
    }

    public static final void a(y50 y50Var, float f2, float f3, float f4, ValueAnimator valueAnimator) {
        valueAnimator.getClass();
        Object animatedValue = valueAnimator.getAnimatedValue();
        animatedValue.getClass();
        float fFloatValue = ((Float) animatedValue).floatValue();
        y50Var.x = Float.valueOf(((f3 - f2) * fFloatValue) + f2);
        y50Var.y = f4 * fFloatValue;
        au auVar = y50Var.l;
        if (auVar != null) {
            int i = au.b0;
            auVar.a(false);
        }
    }

    @Override // com.pspdfkit.internal.gu
    public final void a(Matrix matrix) {
        List<RectF> list;
        IntRange indices;
        Drawable drawable;
        this.u = matrix;
        TextSelection textSelection = this.a;
        if (textSelection == null || (list = textSelection.textBlocks) == null || (indices = CollectionsKt.getIndices(list)) == null) {
            return;
        }
        int first = indices.getFirst();
        int last = indices.getLast();
        if (first <= last) {
            while (true) {
                ((PageRect) this.f.get(first)).updateScreenRect(matrix);
                if (first == last) {
                    break;
                } else {
                    first++;
                }
            }
        }
        Drawable drawable2 = this.m;
        if (drawable2 == null || (drawable = this.n) == null) {
            return;
        }
        PointF pointF = this.o;
        PointF pointF2 = this.d;
        pointF2.set(pointF);
        s60.a(pointF2, matrix);
        int intrinsicWidth = (int) (this.d.x - drawable2.getIntrinsicWidth());
        PointF pointF3 = this.d;
        float f2 = pointF3.y;
        drawable2.setBounds(intrinsicWidth, (int) f2, (int) pointF3.x, (int) (f2 + drawable2.getIntrinsicHeight()));
        PointF pointF4 = this.p;
        PointF pointF5 = this.d;
        pointF5.set(pointF4);
        s60.a(pointF5, matrix);
        PointF pointF6 = this.d;
        int i = (int) pointF6.x;
        drawable.setBounds(i, (int) pointF6.y, drawable.getIntrinsicWidth() + i, (int) (this.d.y + drawable.getIntrinsicHeight()));
    }

    @Override // com.pspdfkit.internal.gu
    public final void a(Canvas canvas) {
        canvas.getClass();
        if (this.a == null) {
            return;
        }
        int size = this.f.size();
        for (int i = 0; i < size; i++) {
            RectF screenRect = ((PageRect) this.f.get(i)).getScreenRect();
            float f2 = this.s;
            canvas.drawRoundRect(screenRect, f2, f2, this.c);
        }
        if (this.F <= 0.0f) {
            return;
        }
        Float f3 = this.x;
        b bVar = this.t;
        if (bVar == b.NO_DRAG) {
            bVar = this.B;
        }
        if (f3 != null && bVar == b.DRAGGING_LEFT) {
            a(canvas, this.m, f3.floatValue(), this.y, true);
            a(canvas, this.n, false);
        } else if (f3 != null && bVar == b.DRAGGING_RIGHT) {
            a(canvas, this.m, true);
            a(canvas, this.n, f3.floatValue(), this.y, false);
        } else {
            a(canvas, this.m, true);
            a(canvas, this.n, false);
        }
    }

    public final void a(Canvas canvas, Drawable drawable, boolean z) {
        if (drawable == null) {
            return;
        }
        if (this.F >= 1.0f) {
            drawable.draw(canvas);
            return;
        }
        Rect bounds = drawable.getBounds();
        bounds.getClass();
        float f2 = z ? bounds.right : bounds.left;
        int iSave = canvas.save();
        try {
            float f3 = this.F;
            canvas.scale(f3, f3, f2, bounds.top);
            drawable.draw(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public final void a(Canvas canvas, Drawable drawable, float f2, float f3, boolean z) {
        int i;
        if (drawable == null) {
            return;
        }
        Rect bounds = drawable.getBounds();
        bounds.getClass();
        int iSave = canvas.save();
        try {
            if (z) {
                i = bounds.right;
            } else {
                i = bounds.left;
            }
            float f4 = i;
            canvas.translate(f2 - f4, f3);
            float f5 = this.C * this.F;
            canvas.scale(f5, f5, f4, bounds.top);
            drawable.draw(canvas);
            canvas.restoreToCount(iSave);
        } catch (Throwable th) {
            canvas.restoreToCount(iSave);
            throw th;
        }
    }

    public static final void a(final y50 y50Var) {
        ValueAnimator valueAnimator = y50Var.G;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(200L);
        valueAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.pspdfkit.internal.y50$$ExternalSyntheticLambda1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                y50.b(this.f$0, valueAnimator2);
            }
        });
        valueAnimatorOfFloat.start();
        y50Var.G = valueAnimatorOfFloat;
    }

    public final void a(float f2) {
        ValueAnimator valueAnimator = this.D;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.C, f2);
        valueAnimatorOfFloat.setDuration(200L);
        valueAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.pspdfkit.internal.y50$$ExternalSyntheticLambda4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                y50.a(this.f$0, valueAnimator2);
            }
        });
        valueAnimatorOfFloat.start();
        this.D = valueAnimatorOfFloat;
    }

    public static final void a(y50 y50Var, ValueAnimator valueAnimator) {
        valueAnimator.getClass();
        Object animatedValue = valueAnimator.getAnimatedValue();
        animatedValue.getClass();
        y50Var.C = ((Float) animatedValue).floatValue();
        au auVar = y50Var.l;
        if (auVar != null) {
            int i = au.b0;
            auVar.a(false);
        }
    }

    public final void a(TextSelection textSelection, b bVar) {
        if (this.b.a(textSelection, this.a)) {
            TextSelection textSelection2 = this.a;
            if (textSelection != null && textSelection2 != null && bVar == b.NO_DRAG) {
                this.H.removeCallbacksAndMessages(null);
                ValueAnimator valueAnimator = this.G;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                }
                this.F = 0.0f;
                j();
            }
            this.a = textSelection;
            this.t = bVar;
            if (textSelection != null) {
                k();
            }
            a60 a60Var = this.b;
            TextSelection textSelection3 = this.a;
            x50 x50Var = (x50) a60Var.d;
            x50Var.getClass();
            if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                Iterator<TextSelectionManager.OnTextSelectionChangeListener> it = x50Var.b.iterator();
                while (it.hasNext()) {
                    it.next().onAfterTextSelectionChange(textSelection3, textSelection2);
                }
                if (this.a != null || this.l == null) {
                    return;
                }
                Function0<Unit> function0 = this.r;
                if (function0 != null) {
                    function0.invoke();
                    return;
                } else {
                    this.b.b.exitCurrentlyActiveMode();
                    return;
                }
            }
            throw new IllegalStateException("Text selection listeners touched on non ui thread.");
        }
    }

    public final Single<BaseRectsAnnotation> a(AnnotationType annotationType, boolean z) {
        int color;
        float alpha;
        AnnotationType annotationType2;
        BaseRectsAnnotation baseRectsAnnotationA;
        annotationType.getClass();
        TextSelection textSelection = this.a;
        if (textSelection != null && (textSelection.textRange.getLength() != 0 || !textSelection.textBlocks.isEmpty())) {
            au auVar = this.l;
            if (auVar == null) {
                Single<BaseRectsAnnotation> singleError = Single.error(new IllegalStateException("No page layout available."));
                singleError.getClass();
                return singleError;
            }
            m40 state = auVar.getState();
            if (state == null) {
                Single<BaseRectsAnnotation> singleError2 = Single.error(new IllegalStateException("No page layout state available."));
                singleError2.getClass();
                return singleError2;
            }
            final lm lmVar = state.a;
            a60 a60Var = this.b;
            if (z) {
                Context contextRequireContext = a60Var.f.requireContext();
                contextRequireContext.getClass();
                bp bpVar = new bp(contextRequireContext, AnnotationTool.INSTANT_HIGHLIGHT_COMMENT);
                bpVar.a();
                j1 j1Var = bpVar.a;
                j1Var.getClass();
                Object obj = j1Var.a.get(i1.d);
                color = ((Number) (obj != null ? obj : 0)).intValue();
                i1<Float> i1Var = i1.q;
                Object objValueOf = Float.valueOf(1.0f);
                Object obj2 = j1Var.a.get(i1Var);
                if (obj2 != null) {
                    objValueOf = obj2;
                }
                alpha = ((Number) objValueOf).floatValue();
            } else {
                color = a60Var.g.getColor(a(annotationType));
                alpha = this.b.g.getAlpha(a(annotationType));
            }
            float f2 = alpha;
            int i = color;
            if (z) {
                baseRectsAnnotationA = null;
                annotationType2 = annotationType;
            } else {
                EnumSet<AnnotationType> enumSet = hp.a;
                int i2 = textSelection.pageIndex;
                List<RectF> list = textSelection.textBlocks;
                list.getClass();
                annotationType2 = annotationType;
                baseRectsAnnotationA = hp.a(lmVar, i2, annotationType2, i, f2, list);
            }
            final BaseRectsAnnotation baseRectsAnnotationB = (baseRectsAnnotationA == null || Intrinsics.areEqual(baseRectsAnnotationA.getName(), "com.pspdfkit.internal.annotations.markup.default-rect-name")) ? b(annotationType2) : baseRectsAnnotationA;
            if (!z && baseRectsAnnotationA != null && !Intrinsics.areEqual(baseRectsAnnotationA.getName(), "com.pspdfkit.internal.annotations.markup.default-rect-name")) {
                at atVar = this.b.c;
                atVar.getClass();
                i3 i3Var = new i3(CollectionsKt.listOf(baseRectsAnnotationB), atVar);
                i3Var.b();
                EnumSet<AnnotationType> enumSet2 = hp.a;
                List<RectF> list2 = textSelection.textBlocks;
                list2.getClass();
                hp.a(baseRectsAnnotationB, list2);
                i3Var.c();
                this.b.f.notifyAnnotationHasChanged(baseRectsAnnotationB);
                Single<BaseRectsAnnotation> singleJust = Single.just(baseRectsAnnotationB);
                singleJust.getClass();
                return singleJust;
            }
            if (z) {
                baseRectsAnnotationB.getInternal().markAsInstantCommentRoot();
            }
            AnnotationPreferencesManager annotationPreferencesManager = this.b.g;
            annotationPreferencesManager.getClass();
            ww.a(annotationPreferencesManager, baseRectsAnnotationB);
            baseRectsAnnotationB.setColor(i);
            if (baseRectsAnnotationB instanceof RedactionAnnotation) {
                AnnotationPreferencesManager annotationPreferencesManager2 = this.b.g;
                annotationPreferencesManager2.getClass();
                RedactionAnnotation redactionAnnotation = (RedactionAnnotation) baseRectsAnnotationB;
                AnnotationTool annotationTool = AnnotationTool.REDACTION;
                redactionAnnotation.setOverlayText(annotationPreferencesManager2.getOverlayText(annotationTool));
                redactionAnnotation.setRepeatOverlayText(annotationPreferencesManager2.getRepeatOverlayText(annotationTool));
                redactionAnnotation.setOutlineColor(annotationPreferencesManager2.getOutlineColor(annotationTool));
                baseRectsAnnotationB.setFillColor(annotationPreferencesManager2.getFillColor(annotationTool));
            }
            i0 i0VarA = ar.a();
            Bundle bundleA = z50.a(i0VarA);
            bundleA.putString(Analytics.Data.ANNOTATION_TYPE, baseRectsAnnotationB.getType().name());
            bundleA.putInt(Analytics.Data.PAGE_INDEX, baseRectsAnnotationB.getPageIndex());
            i0VarA.a(Analytics.Event.CREATE_ANNOTATION, bundleA);
            final o3 annotationProvider = lmVar.getAnnotationProvider();
            final i4 annotationRenderingCoordinator = auVar.getAnnotationRenderingCoordinator();
            Single<BaseRectsAnnotation> singleCreate = Single.create(new SingleOnSubscribe() { // from class: com.pspdfkit.internal.y50$$ExternalSyntheticLambda3
                @Override // io.reactivex.rxjava3.core.SingleOnSubscribe
                public final void subscribe(SingleEmitter singleEmitter) {
                    y50.a(lmVar, annotationProvider, baseRectsAnnotationB, annotationRenderingCoordinator, singleEmitter);
                }
            });
            singleCreate.getClass();
            return singleCreate;
        }
        Single<BaseRectsAnnotation> singleError3 = Single.error(new IllegalStateException("No selection found."));
        singleError3.getClass();
        return singleError3;
    }

    public static final void a(lm lmVar, o3 o3Var, BaseRectsAnnotation baseRectsAnnotation, i4 i4Var, SingleEmitter singleEmitter) {
        singleEmitter.getClass();
        f fVar = new f(o3Var, baseRectsAnnotation, i4Var, singleEmitter, null);
        PageRenderConfiguration pageRenderConfiguration = lm.Q;
        final Job jobA = lmVar.a(EmptyCoroutineContext.INSTANCE, fVar);
        singleEmitter.setCancellable(new Cancellable() { // from class: com.pspdfkit.internal.y50$$ExternalSyntheticLambda2
            @Override // io.reactivex.rxjava3.functions.Cancellable
            public final void cancel() {
                y50.a(jobA);
            }
        });
    }

    public static final void a(Job job) {
        Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
    }

    public static AnnotationTool a(AnnotationType annotationType) {
        int i = d.a[annotationType.ordinal()];
        if (i == 1) {
            return AnnotationTool.REDACTION;
        }
        if (i == 2) {
            return AnnotationTool.HIGHLIGHT;
        }
        if (i == 3) {
            return AnnotationTool.STRIKEOUT;
        }
        if (i != 4) {
            throw new IllegalArgumentException("Passed annotation type " + annotationType + " is not supported.");
        }
        return AnnotationTool.UNDERLINE;
    }
}
