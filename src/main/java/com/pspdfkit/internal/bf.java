package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import com.pspdfkit.ui.drawable.PdfDrawable;
import com.pspdfkit.ui.drawable.PdfDrawableProvider;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: loaded from: classes3.dex */
public final class bf implements PdfDrawableProvider.DrawableProviderObserver {
    public final au a;
    public final Function0<Matrix> b;
    public final Function0<Unit> c;
    public m40 d;
    public final MutableStateFlow<Map<PdfDrawableProvider, List<PdfDrawable>>> e;
    public final MutableStateFlow f;
    public final CoroutineScope g;
    public Job h;

    @DebugMetadata(c = "com.pspdfkit.internal.views.page.pageview.data.providers.DrawableStateProvider$onDrawablesChanged$1", f = "DrawableStateProvider.kt", i = {1}, l = {Token.DOTDOT, Token.GET}, m = "invokeSuspend", n = {"drawables"}, nl = {Token.SET_REF_OP, Token.LAST_TOKEN}, s = {"L$0"}, v = 2)
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public Object a;
        public int b;
        public final /* synthetic */ PdfDrawableProvider c;
        public final /* synthetic */ bf d;
        public final /* synthetic */ m40 e;

        /* JADX INFO: renamed from: com.pspdfkit.internal.bf$a$a, reason: collision with other inner class name */
        @DebugMetadata(c = "com.pspdfkit.internal.views.page.pageview.data.providers.DrawableStateProvider$onDrawablesChanged$1$1", f = "DrawableStateProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        public static final class C0253a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public final /* synthetic */ bf a;
            public final /* synthetic */ List<PdfDrawable> b;
            public final /* synthetic */ PdfDrawableProvider c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C0253a(bf bfVar, List<? extends PdfDrawable> list, PdfDrawableProvider pdfDrawableProvider, Continuation<? super C0253a> continuation) {
                super(2, continuation);
                this.a = bfVar;
                this.b = list;
                this.c = pdfDrawableProvider;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C0253a(this.a, this.b, this.c, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C0253a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                ResultKt.throwOnFailure(obj);
                Matrix matrixInvoke = this.a.b.invoke();
                List<PdfDrawable> list = this.b;
                bf bfVar = this.a;
                for (PdfDrawable pdfDrawable : list) {
                    pdfDrawable.setCallback(bfVar.a);
                    pdfDrawable.updatePdfToViewTransformation(matrixInvoke);
                }
                MutableStateFlow<Map<PdfDrawableProvider, List<PdfDrawable>>> mutableStateFlow = this.a.e;
                Map<PdfDrawableProvider, List<PdfDrawable>> mutableMap = MapsKt.toMutableMap(mutableStateFlow.getValue());
                mutableMap.put(this.c, this.b);
                mutableStateFlow.setValue(mutableMap);
                this.a.c.invoke();
                return Unit.INSTANCE;
            }
        }

        @DebugMetadata(c = "com.pspdfkit.internal.views.page.pageview.data.providers.DrawableStateProvider$onDrawablesChanged$1$drawables$1", f = "DrawableStateProvider.kt", i = {}, l = {Token.COLONCOLON}, m = "invokeSuspend", n = {}, nl = {Token.XMLEND}, s = {}, v = 2)
        public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends PdfDrawable>>, Object> {
            public int a;
            public final /* synthetic */ PdfDrawableProvider b;
            public final /* synthetic */ bf c;
            public final /* synthetic */ m40 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(PdfDrawableProvider pdfDrawableProvider, bf bfVar, m40 m40Var, Continuation<? super b> continuation) {
                super(2, continuation);
                this.b = pdfDrawableProvider;
                this.c = bfVar;
                this.d = m40Var;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new b(this.b, this.c, this.d, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends PdfDrawable>> continuation) {
                return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    PdfDrawableProvider pdfDrawableProvider = this.b;
                    Context context = this.c.a.getContext();
                    context.getClass();
                    m40 m40Var = this.d;
                    lm lmVar = m40Var.a;
                    int i2 = m40Var.b;
                    this.a = 1;
                    obj = pdfDrawableProvider.getDrawablesForPage(context, lmVar, i2, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                List list = (List) obj;
                return list == null ? CollectionsKt.emptyList() : list;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PdfDrawableProvider pdfDrawableProvider, bf bfVar, m40 m40Var, Continuation<? super a> continuation) {
            super(2, continuation);
            this.c = pdfDrawableProvider;
            this.d = bfVar;
            this.e = m40Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.c, this.d, this.e, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0059, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(r1, r3, r8) == r0) goto L15;
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
                r2 = 2
                r3 = 1
                r4 = 0
                if (r1 == 0) goto L23
                if (r1 == r3) goto L1f
                if (r1 != r2) goto L17
                java.lang.Object r8 = r8.a
                java.util.List r8 = (java.util.List) r8
                kotlin.ResultKt.throwOnFailure(r9)
                goto L5c
            L17:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L1f:
                kotlin.ResultKt.throwOnFailure(r9)
                goto L3e
            L23:
                kotlin.ResultKt.throwOnFailure(r9)
                kotlinx.coroutines.CoroutineDispatcher r9 = kotlinx.coroutines.Dispatchers.getIO()
                com.pspdfkit.internal.bf$a$b r1 = new com.pspdfkit.internal.bf$a$b
                com.pspdfkit.ui.drawable.PdfDrawableProvider r5 = r8.c
                com.pspdfkit.internal.bf r6 = r8.d
                com.pspdfkit.internal.m40 r7 = r8.e
                r1.<init>(r5, r6, r7, r4)
                r8.b = r3
                java.lang.Object r9 = kotlinx.coroutines.BuildersKt.withContext(r9, r1, r8)
                if (r9 != r0) goto L3e
                goto L5b
            L3e:
                java.util.List r9 = (java.util.List) r9
                kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getMain()
                com.pspdfkit.internal.bf$a$a r3 = new com.pspdfkit.internal.bf$a$a
                com.pspdfkit.internal.bf r5 = r8.d
                com.pspdfkit.ui.drawable.PdfDrawableProvider r6 = r8.c
                r3.<init>(r5, r9, r6, r4)
                java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
                r8.a = r9
                r8.b = r2
                java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r1, r3, r8)
                if (r8 != r0) goto L5c
            L5b:
                return r0
            L5c:
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.pspdfkit.internal.bf.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public bf(au auVar, Function0<? extends Matrix> function0, Function0<Unit> function1) {
        function0.getClass();
        function1.getClass();
        this.a = auVar;
        this.b = function0;
        this.c = function1;
        MutableStateFlow<Map<PdfDrawableProvider, List<PdfDrawable>>> MutableStateFlow = StateFlowKt.MutableStateFlow(MapsKt.emptyMap());
        this.e = MutableStateFlow;
        this.f = MutableStateFlow;
        this.g = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain().getImmediate()));
    }

    @Override // com.pspdfkit.ui.drawable.PdfDrawableProvider.DrawableProviderObserver
    public final void onDrawablesChanged(PdfDrawableProvider pdfDrawableProvider) {
        pdfDrawableProvider.getClass();
        m40 m40Var = this.d;
        if (m40Var == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(this.g, null, null, new a(pdfDrawableProvider, this, m40Var, null), 3, null);
    }

    public final void a() {
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            throw new IllegalStateException("Page drawables touched from non-main thread.");
        }
        Job job = this.h;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.h = null;
        Iterator<PdfDrawableProvider> it = this.e.getValue().keySet().iterator();
        while (it.hasNext()) {
            it.next().unregisterDrawableProviderObserver(this);
        }
        this.e.setValue(MapsKt.emptyMap());
        this.c.invoke();
    }

    @Override // com.pspdfkit.ui.drawable.PdfDrawableProvider.DrawableProviderObserver
    public final void onDrawablesChanged(PdfDrawableProvider pdfDrawableProvider, int i) {
        pdfDrawableProvider.getClass();
        m40 m40Var = this.d;
        if (m40Var != null && i == m40Var.b) {
            onDrawablesChanged(pdfDrawableProvider);
        }
    }

    public final boolean a(Drawable drawable) {
        drawable.getClass();
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            Iterator it = ((Map) this.f.getValue()).values().iterator();
            while (it.hasNext()) {
                Iterator it2 = ((List) it.next()).iterator();
                while (it2.hasNext()) {
                    if (((PdfDrawable) it2.next()) == drawable) {
                        return true;
                    }
                }
            }
            return false;
        }
        throw new IllegalStateException("Page drawables touched from non-main thread.");
    }
}
