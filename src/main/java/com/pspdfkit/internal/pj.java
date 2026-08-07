package com.pspdfkit.internal;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Size;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.configuration.rendering.PageRenderConfiguration;
import com.pspdfkit.ui.drawable.PdfDrawable;
import com.pspdfkit.utils.PdfLog;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: loaded from: classes3.dex */
public final class pj {
    public m40 a;
    public final int b;
    public final int c;
    public final py d;
    public final float e;
    public final float f;
    public zo g;
    public zo h;
    public float i;
    public final Rect j;
    public final Rect k;
    public final Rect l;
    public final CoroutineScope m;
    public final qy n;
    public final AtomicInteger o;
    public volatile int p;
    public final MutableSharedFlow<Unit> q;
    public final Rect r;
    public Function4<? super Integer, ? super zo, ? super Float, ? super Rect, Unit> s;

    @DebugMetadata(c = "com.pspdfkit.internal.views.page.pageview.data.providers.HighResProvider$1", f = "HighResProvider.kt", i = {}, l = {101}, m = "invokeSuspend", n = {}, nl = {105}, s = {}, v = 2)
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;

        /* JADX INFO: renamed from: com.pspdfkit.internal.pj$a$a, reason: collision with other inner class name */
        public static final class C0281a<T> implements FlowCollector {
            public final /* synthetic */ pj a;

            public C0281a(pj pjVar) {
                this.a = pjVar;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(Object obj, Continuation continuation) {
                Rect rect = new Rect(this.a.r);
                pj pjVar = this.a;
                Function4<? super Integer, ? super zo, ? super Float, ? super Rect, Unit> function4 = pjVar.s;
                if (function4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("capturedRenderingStateCallback");
                    function4 = null;
                }
                pjVar.a(rect, function4);
                return Unit.INSTANCE;
            }
        }

        public a(Continuation<? super a> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return pj.this.new a(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return pj.this.new a(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                pj pjVar = pj.this;
                MutableSharedFlow<Unit> mutableSharedFlow = pjVar.q;
                pjVar.d.getClass();
                Flow flowDebounce = FlowKt.debounce(mutableSharedFlow, 100L);
                C0281a c0281a = new C0281a(pj.this);
                this.a = 1;
                if (flowDebounce.collect(c0281a, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.views.page.pageview.data.providers.HighResProvider$renderHighResImmediate$job$1", f = "HighResProvider.kt", i = {0, 0, 1, 1, 1, 1, 1}, l = {238, 267}, m = "invokeSuspend", n = {"$this$launch", "renderOptions", "$this$launch", "renderOptions", "renderedBitmap", "managedBitmap", "unscaledViewportRect"}, nl = {237, 275}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4"}, v = 2)
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public Object a;
        public Object b;
        public Object c;
        public Object d;
        public int e;
        public /* synthetic */ Object f;
        public final /* synthetic */ Rect h;
        public final /* synthetic */ tm i;
        public final /* synthetic */ int j;
        public final /* synthetic */ float k;
        public final /* synthetic */ Rect l;
        public final /* synthetic */ int m;
        public final /* synthetic */ Function4<Integer, zo, Float, Rect, Unit> n;

        @DebugMetadata(c = "com.pspdfkit.internal.views.page.pageview.data.providers.HighResProvider$renderHighResImmediate$job$1$1", f = "HighResProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public final /* synthetic */ Function4<Integer, zo, Float, Rect, Unit> a;
            public final /* synthetic */ zo b;
            public final /* synthetic */ float c;
            public final /* synthetic */ Rect d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(Function4<? super Integer, ? super zo, ? super Float, ? super Rect, Unit> function4, zo zoVar, float f, Rect rect, Continuation<? super a> continuation) {
                super(2, continuation);
                this.a = function4;
                this.b = zoVar;
                this.c = f;
                this.d = rect;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(this.a, this.b, this.c, this.d, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                ResultKt.throwOnFailure(obj);
                this.a.invoke(Boxing.boxInt(2), this.b, Boxing.boxFloat(this.c), this.d);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(Rect rect, tm tmVar, int i, float f, Rect rect2, int i2, Function4<? super Integer, ? super zo, ? super Float, ? super Rect, Unit> function4, Continuation<? super b> continuation) {
            super(2, continuation);
            this.h = rect;
            this.i = tmVar;
            this.j = i;
            this.k = f;
            this.l = rect2;
            this.m = i2;
            this.n = function4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            b bVar = pj.this.new b(this.h, this.i, this.j, this.k, this.l, this.m, this.n, continuation);
            bVar.f = obj;
            return bVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x00f3, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(r12, r5, r13) == r1) goto L25;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                Method dump skipped, instruction units count: 313
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.pspdfkit.internal.pj.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public pj(Size size, m40 m40Var) {
        m40Var.getClass();
        this.a = m40Var;
        this.b = size.getWidth();
        this.c = size.getHeight();
        this.d = new py();
        this.e = 2.0f;
        this.f = 0.15f;
        this.i = 1.0f;
        this.j = new Rect();
        this.k = new Rect();
        this.l = new Rect();
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getDefault()));
        this.m = CoroutineScope;
        this.n = new qy();
        this.o = new AtomicInteger(0);
        this.q = SharedFlowKt.MutableSharedFlow(0, 1, BufferOverflow.DROP_OLDEST);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new a(null), 3, null);
        this.r = new Rect();
    }

    public final boolean a(tm tmVar) {
        int i = tmVar.a;
        if (i > 0 && tmVar.b > 0) {
            return true;
        }
        PdfLog.e("HighResProvider", "Cannot render high-res page " + this.a.b + ": Invalid bitmap size " + i + "x" + tmVar.b, new Object[0]);
        return false;
    }

    public final void a(Rect rect, Function4<? super Integer, ? super zo, ? super Float, ? super Rect, Unit> function4) {
        Pair pair;
        tm tmVar;
        m40 m40Var = this.a;
        float f = m40Var.f;
        int i = m40Var.b;
        if (rect.isEmpty()) {
            PdfLog.w("HighResProvider", "Empty viewport, skipping render", new Object[0]);
            return;
        }
        com.pspdfkit.utils.Size size = this.a.g;
        float f2 = size.width * f;
        float f3 = size.height * f;
        float f4 = rect.left;
        float f5 = rect.top;
        float f6 = rect.right;
        float f7 = rect.bottom;
        float f8 = this.e - 1.0f;
        float f9 = ((f6 - f4) * f8) / 2.0f;
        float f10 = (f8 * (f7 - f5)) / 2.0f;
        Rect rect2 = new Rect((int) Math.max(0.0f, f4 - f9), (int) Math.max(0.0f, f5 - f10), (int) Math.min(f2, f6 + f9), (int) Math.min(f3, f7 + f10));
        float fCoerceAtLeast = (RangesKt.coerceAtLeast(rect2.width(), 1) / RangesKt.coerceAtLeast(f, 0.1f)) / RangesKt.coerceAtLeast(RangesKt.coerceAtLeast(rect2.height(), 1) / RangesKt.coerceAtLeast(f, 0.1f), 0.1f);
        int iMax = (int) (Math.max(this.b * 0.5f, this.c * 0.5f) * this.e);
        if (fCoerceAtLeast > 1.0f) {
            pair = TuplesKt.to(Integer.valueOf(iMax), Integer.valueOf((int) (iMax / fCoerceAtLeast)));
        } else {
            pair = TuplesKt.to(Integer.valueOf((int) (iMax * fCoerceAtLeast)), Integer.valueOf(iMax));
        }
        int iIntValue = ((Number) pair.component1()).intValue();
        int iIntValue2 = ((Number) pair.component2()).intValue();
        int i2 = this.b;
        int i3 = this.c;
        int iCoerceAtMost = RangesKt.coerceAtMost(iIntValue, i2);
        int iCoerceAtMost2 = RangesKt.coerceAtMost(iIntValue2, i3);
        if (iCoerceAtMost >= iIntValue && iCoerceAtMost2 >= iIntValue2) {
            tmVar = new tm(iIntValue, iIntValue2);
        } else {
            float f11 = iIntValue;
            float f12 = iIntValue2;
            float fMin = Math.min(iCoerceAtMost / f11, iCoerceAtMost2 / f12);
            tmVar = new tm((int) (f11 * fMin), (int) (f12 * fMin));
        }
        if (!a(tmVar)) {
            PdfLog.e("HighResProvider", "Invalid viewport render size: " + tmVar.a + "x" + tmVar.b, new Object[0]);
            function4.invoke(0, null, null, null);
            return;
        }
        synchronized (this) {
            zo zoVar = this.g;
            if (zoVar == null) {
                zoVar = this.h;
            }
            this.h = zoVar;
            this.g = null;
            Unit unit = Unit.INSTANCE;
        }
        this.i = f;
        this.j.set(rect2);
        this.k.set(rect);
        this.l.set((int) (rect2.left / f), (int) (rect2.top / f), (int) (rect2.right / f), (int) (rect2.bottom / f));
        int iIncrementAndGet = this.o.incrementAndGet();
        this.p = iIncrementAndGet;
        this.n.a(i, BuildersKt__Builders_commonKt.launch$default(this.m, null, null, new b(rect2, tmVar, iIncrementAndGet, f, rect, i, function4, null), 3, null));
    }

    public static final jm a(pj pjVar, Rect rect, tm tmVar, boolean z) {
        float f = pjVar.a.f;
        com.pspdfkit.utils.Size size = pjVar.a.g;
        Size size2 = new Size((int) (size.width * f), (int) (size.height * f));
        float fMin = Math.min(tmVar.a / rect.width(), tmVar.b / rect.height());
        oy oyVar = new oy(new Point((int) ((-rect.left) * fMin), (int) ((-rect.top) * fMin)), new Size((int) (size2.getWidth() * fMin), (int) (size2.getHeight() * fMin)));
        y7 y7Var = q10.c;
        if (y7Var == null) {
            y7Var = new y7();
            q10.c = y7Var;
        }
        Bitmap bitmapA = y7Var.a(tmVar.a, tmVar.b);
        bitmapA.getClass();
        m40 m40Var = pjVar.a;
        ou ouVar = m40Var.a.c;
        int i = m40Var.b;
        Size size3 = new Size(tmVar.a, tmVar.b);
        PageRenderConfiguration pageRenderConfiguration = pjVar.a.c;
        ouVar.getClass();
        pageRenderConfiguration.getClass();
        oy oyVar2 = pageRenderConfiguration.renderRegion ? new oy(new Point(pageRenderConfiguration.regionX, pageRenderConfiguration.regionY), new Size(pageRenderConfiguration.regionFullPageWidth, pageRenderConfiguration.regionFullPageHeight)) : null;
        Bitmap bitmap = pageRenderConfiguration.reuseBitmap;
        int i2 = pageRenderConfiguration.paperColor;
        Integer num = pageRenderConfiguration.formHighlightColor;
        Integer num2 = pageRenderConfiguration.formItemHighlightColor;
        Integer num3 = pageRenderConfiguration.formRequiredFieldBorderColor;
        Integer num4 = pageRenderConfiguration.signHereOverlayBackgroundColor;
        boolean z2 = pageRenderConfiguration.toGrayscale;
        boolean z3 = pageRenderConfiguration.invertColors;
        boolean z4 = pageRenderConfiguration.redactionAnnotationPreviewEnabled;
        List<PdfDrawable> list = pageRenderConfiguration.renderedDrawables;
        list.getClass();
        boolean z5 = pageRenderConfiguration.showSignHereOverlay;
        boolean z6 = pageRenderConfiguration.useCache;
        List<Integer> list2 = pageRenderConfiguration.excludedAnnotations;
        list2.getClass();
        List<AnnotationType> list3 = pageRenderConfiguration.excludedAnnotationTypes;
        list3.getClass();
        jm jmVar = new jm(ouVar, i, bitmap, size3, z6, null, oyVar2, 3, i2, num, num2, num3, num4, z3, z2, list2, list3, list, z4, z5, true);
        int i3 = (!z || f <= 1.0f) ? 3 : 15;
        List list4 = (List) pjVar.a.p.getValue();
        m40 m40Var2 = pjVar.a;
        return jm.a(jmVar, bitmapA, null, oyVar, i3, null, list4, m40Var2.m, null, m40Var2.h, !m40Var2.i, 687931);
    }

    public final void a() {
        qy qyVar = this.n;
        Collection<Job> collectionValues = qyVar.a.values();
        collectionValues.getClass();
        for (Job job : collectionValues) {
            job.getClass();
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        qyVar.a.clear();
        zo zoVar = this.g;
        if (zoVar != null) {
            zoVar.b();
        }
        zo zoVar2 = this.h;
        if (zoVar2 != null) {
            zoVar2.b();
        }
        this.g = null;
        this.h = null;
    }
}
