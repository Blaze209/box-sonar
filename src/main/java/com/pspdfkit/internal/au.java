package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.ViewCompositionStrategy;
import androidx.core.view.ViewGroupKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationProvider;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.WidgetAnnotation;
import com.pspdfkit.annotations.actions.ActionResolver;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.configuration.rendering.PageRenderConfiguration;
import com.pspdfkit.datastructures.TextSelection;
import com.pspdfkit.exceptions.NutrientException;
import com.pspdfkit.forms.FormElement;
import com.pspdfkit.forms.FormType;
import com.pspdfkit.forms.SignatureFormElement;
import com.pspdfkit.internal.jni.NativeLicenseFeatures;
import com.pspdfkit.internal.jni.NativePDFSnapper;
import com.pspdfkit.internal.jni.NativeSnapperConfiguration;
import com.pspdfkit.internal.views.document.DocumentView;
import com.pspdfkit.ui.RecyclableFrameLayout;
import com.pspdfkit.ui.annotations.OnAnnotationSelectedListener;
import com.pspdfkit.ui.drawable.PdfDrawable;
import com.pspdfkit.ui.drawable.PdfDrawableProvider;
import com.pspdfkit.ui.overlay.OverlayLayoutParams;
import com.pspdfkit.ui.overlay.OverlayViewProvider;
import com.pspdfkit.ui.special_mode.controller.AnnotationSelectionController;
import com.pspdfkit.ui.special_mode.manager.FormManager;
import com.pspdfkit.utils.PdfLog;
import com.pspdfkit.utils.Size;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.rx3.RxAwaitKt;

/* JADX INFO: loaded from: classes3.dex */
public final class au extends dw implements nx, OnAnnotationSelectedListener, AnnotationProvider.OnAnnotationUpdatedListener, FormManager.OnFormElementUpdatedListener, FormManager.OnFormElementSelectedListener {
    public static final /* synthetic */ int b0 = 0;
    public final MutableStateFlow<az> A;
    public final StateFlow<az> B;
    public final ho C;
    public final ComposeView D;
    public final ArrayList E;
    public final q30 F;
    public Disposable G;
    public Disposable H;
    public final k2 I;
    public View.OnKeyListener J;
    public final st K;
    public final PageRenderConfiguration L;
    public final t1 M;
    public final bf N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public MotionEvent R;
    public final Lazy S;
    public FormElement T;
    public float U;
    public float V;
    public boolean W;
    public final MutableIntState a0;
    public final DocumentView d;
    public final PdfConfiguration e;
    public final vh f;
    public final fu g;
    public final hu<PdfDrawableProvider> h;
    public final hu<OverlayViewProvider> i;
    public final vt j;
    public final mh k;
    public final kq l;
    public final wi m;
    public final wi n;
    public final i4 o;
    public final et p;
    public final CoroutineScope q;
    public Job r;
    public boolean s;
    public final ArrayList t;
    public final Rect u;
    public boolean v;
    public final MutableStateFlow<m40> w;
    public final StateFlow<m40> x;
    public final MutableStateFlow<az> y;
    public final StateFlow<az> z;

    public final class a extends w20 {
        public a() {
        }

        @Override // com.pspdfkit.internal.w20, com.pspdfkit.internal.xi
        public final boolean d(MotionEvent motionEvent) {
            au auVar = au.this;
            boolean zA = vt.a(auVar.j, false, false, 13) | auVar.k.a(false);
            auVar.g.getClass();
            return zA;
        }

        @Override // com.pspdfkit.internal.w20
        public final boolean h(MotionEvent motionEvent) {
            return (au.this.getFormEditor().k == null && au.this.getPageEditor().t.isEmpty()) ? false : true;
        }
    }

    public final class b {
        public b() {
        }
    }

    public final class c extends w20 {
        public c() {
        }

        @Override // com.pspdfkit.internal.w20
        public final boolean f(MotionEvent motionEvent) {
            motionEvent.getClass();
            return true;
        }

        @Override // com.pspdfkit.internal.w20, com.pspdfkit.internal.xi
        public final boolean onLongPress(MotionEvent motionEvent) {
            motionEvent.getClass();
            if (!a80.b(au.this.D, motionEvent)) {
                return false;
            }
            PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
            l4.a(au.this.a((Matrix) null), pointF);
            au auVar = au.this;
            return ((DocumentView.h) auVar.g).b(auVar, motionEvent, pointF, null);
        }
    }

    public final class d extends w20 {
        public d() {
        }

        @Override // com.pspdfkit.internal.w20, com.pspdfkit.internal.xi
        public final boolean d(MotionEvent motionEvent) {
            motionEvent.getClass();
            if (!a80.b(au.this.D, motionEvent)) {
                return false;
            }
            PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
            l4.a(au.this.a((Matrix) null), pointF);
            au auVar = au.this;
            return ((DocumentView.h) auVar.g).a(auVar, motionEvent, pointF, null);
        }

        @Override // com.pspdfkit.internal.w20
        public final boolean h(MotionEvent motionEvent) {
            motionEvent.getClass();
            return true;
        }
    }

    public final class e implements dt {
        public e() {
        }

        @Override // com.pspdfkit.internal.dt
        public final void a(uy uyVar) {
            m40 state;
            if (uyVar == uy.LowRes) {
                au auVar = au.this;
                ho hoVar = auVar.C;
                hoVar.removeCallbacks(hoVar.c);
                hoVar.setVisibility(8);
                i4 i4Var = auVar.o;
                i4Var.c = true;
                i4Var.l.setVisibility(i4Var.m ? 0 : 4);
                i4Var.l.requestLayout();
                DocumentView.h hVar = (DocumentView.h) auVar.g;
                if (!DocumentView.this.k0.isEmpty() && (state = auVar.getState()) != null && DocumentView.this.k0.remove(Integer.valueOf(state.b))) {
                    DocumentView.this.o();
                }
                mh mhVar = auVar.k;
                if (mhVar.h) {
                    BuildersKt__Builders_commonKt.launch$default(mhVar.j, null, null, new oh(mhVar, null), 3, null);
                }
            }
        }
    }

    public static final class f implements dt {
        public final /* synthetic */ dt b;

        public f(dt dtVar) {
            this.b = dtVar;
        }

        @Override // com.pspdfkit.internal.dt
        public final void a(uy uyVar) {
            if (uyVar == uy.LowRes) {
                au.this.E.remove(this);
                this.b.a(uyVar);
            }
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.views.page.PageLayout$setRedactionAnnotationPreviewEnabled$1", f = "PageLayout.kt", i = {}, l = {873}, m = "invokeSuspend", n = {}, nl = {874}, s = {}, v = 2)
    public static final class g extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ m40 b;
        public final /* synthetic */ au c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(m40 m40Var, au auVar, Continuation<? super g> continuation) {
            super(2, continuation);
            this.b = m40Var;
            this.c = auVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new g(this.b, this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return new g(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    o3 annotationProvider = this.b.a.getAnnotationProvider();
                    int i2 = this.b.b;
                    this.a = 1;
                    obj = annotationProvider.getAnnotations(i2, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : (List) obj) {
                    if (((Annotation) obj2).getType() == AnnotationType.REDACT) {
                        arrayList.add(obj2);
                    }
                }
                au auVar = this.c;
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj3 = arrayList.get(i3);
                    i3++;
                    Annotation annotation = (Annotation) obj3;
                    if (auVar.w.getValue() != null) {
                        auVar.getAnnotationRenderingCoordinator().d(annotation);
                    }
                }
            } catch (Exception e) {
                PdfLog.w("Nutri.PageLayout", e, "Unable to update redaction preview", new Object[0]);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public au(Context context, DocumentView documentView, PdfConfiguration pdfConfiguration, go goVar, z1 z1Var, vh vhVar, c5 c5Var, at atVar, b20 b20Var, DocumentView.h hVar, hu huVar, hu huVar2, et etVar) {
        super(context);
        context.getClass();
        pdfConfiguration.getClass();
        goVar.getClass();
        z1Var.getClass();
        vhVar.getClass();
        c5Var.getClass();
        atVar.getClass();
        b20Var.getClass();
        hVar.getClass();
        huVar.getClass();
        huVar2.getClass();
        etVar.getClass();
        this.q = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        this.t = new ArrayList();
        e eVar = new e();
        this.u = new Rect();
        MutableStateFlow<m40> MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this.w = MutableStateFlow;
        this.x = FlowKt.asStateFlow(MutableStateFlow);
        MutableStateFlow<az> MutableStateFlow2 = StateFlowKt.MutableStateFlow(new az(0));
        this.y = MutableStateFlow2;
        this.z = FlowKt.asStateFlow(MutableStateFlow2);
        MutableStateFlow<az> MutableStateFlow3 = StateFlowKt.MutableStateFlow(new az(0));
        this.A = MutableStateFlow3;
        this.B = FlowKt.asStateFlow(MutableStateFlow3);
        Context context2 = getContext();
        context2.getClass();
        ComposeView composeView = new ComposeView(context2, null, 0, 6, null);
        composeView.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed.INSTANCE);
        this.D = composeView;
        ArrayList arrayList = new ArrayList();
        this.E = arrayList;
        Function0 function0 = new Function0() { // from class: com.pspdfkit.internal.au$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return au.d(this.f$0);
            }
        };
        Function0 function1 = new Function0() { // from class: com.pspdfkit.internal.au$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return au.c(this.f$0);
            }
        };
        this.N = new bf(this, function0, function1);
        this.S = LazyKt.lazy(new Function0() { // from class: com.pspdfkit.internal.au$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(au.e(this.f$0));
            }
        });
        this.a0 = SnapshotIntStateKt.mutableIntStateOf(0);
        lm document = documentView.getDocument();
        if (document == null) {
            throw new IllegalStateException("Document may not be null.");
        }
        ActionResolver actionResolver = documentView.getActionResolver();
        if (actionResolver == null) {
            throw new IllegalStateException("Action resolver may not be null.");
        }
        this.d = documentView;
        this.e = pdfConfiguration;
        this.f = vhVar;
        this.g = hVar;
        this.h = huVar;
        this.i = huVar2;
        this.p = etVar;
        EnumSet<AnnotationType> enumSetA = ca.a(pdfConfiguration);
        enumSetA.getClass();
        k2 k2Var = new k2(context, enumSetA);
        this.I = k2Var;
        w4 w4Var = ca.a;
        if (w4Var == null) {
            throw new NutrientException("Make sure to call ConfigurationUtils#parseThemeConfigurations() before calling getAnnotationThemeConfiguration()");
        }
        vt vtVar = new vt(this, document, pdfConfiguration, goVar, z1Var, atVar, k2Var, w4Var, new b(), actionResolver);
        this.j = vtVar;
        mh mhVar = new mh(this, document, pdfConfiguration, b20Var, vhVar, actionResolver, k2Var);
        this.k = mhVar;
        kq kqVar = new kq(this, document, actionResolver, k2Var);
        this.l = kqVar;
        wi wiVar = new wi(context);
        this.m = wiVar;
        wi wiVar2 = new wi(context);
        this.n = wiVar2;
        this.o = new i4(this, c5Var);
        this.K = new st(context, this);
        PageRenderConfiguration pageRenderConfigurationA = ca.a(pdfConfiguration, document);
        pageRenderConfigurationA.getClass();
        this.L = pageRenderConfigurationA;
        this.M = new t1(actionResolver, function0, function1);
        setSaveEnabled(false);
        setSaveFromParentEnabled(false);
        setClipChildren(false);
        RecyclableFrameLayout recyclableFrameLayout = new RecyclableFrameLayout(context, null, 0, 6, null);
        addView(recyclableFrameLayout, -1, -1);
        b();
        recyclableFrameLayout.addView(composeView, -1, -1);
        q30 q30Var = new q30(context, k2Var);
        this.F = q30Var;
        addView(q30Var, -1, -1);
        ho hoVar = new ho(context, pdfConfiguration.getLoadingProgressDrawable(), pdfConfiguration.getBackgroundColor(), pdfConfiguration.isInvertColors(), pdfConfiguration.isToGrayscale());
        this.C = hoVar;
        hoVar.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        hoVar.removeCallbacks(hoVar.c);
        hoVar.setVisibility(8);
        addView(hoVar);
        vi viVar = vi.Tap;
        wiVar.a(viVar, mhVar.m, vtVar.m, new d(), kqVar.e, new a());
        vi viVar2 = vi.DoubleTap;
        wiVar.a(viVar2, vtVar.m);
        vi viVar3 = vi.LongPress;
        wiVar.a(viVar3, mhVar.m, vtVar.m, new c());
        vi viVar4 = vi.Scroll;
        wiVar.a(viVar4, vtVar.m);
        wiVar2.a(viVar, vtVar.m);
        wiVar2.a(viVar2, vtVar.m);
        wiVar2.a(viVar3, vtVar.m);
        wiVar2.a(viVar4, vtVar.m);
        arrayList.add(eVar);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object a(au auVar, ContinuationImpl continuationImpl) {
        du duVar;
        m40 state;
        if (continuationImpl instanceof du) {
            duVar = (du) continuationImpl;
            int i = duVar.d;
            if ((i & Integer.MIN_VALUE) != 0) {
                duVar.d = i - Integer.MIN_VALUE;
            } else {
                duVar = new du(auVar, continuationImpl);
            }
        } else {
            duVar = new du(auVar, continuationImpl);
        }
        Object objAwait = duVar.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = duVar.d;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objAwait);
            state = auVar.getState();
            if (state == null || !ar.b().a(NativeLicenseFeatures.ACRO_FORMS)) {
                return CollectionsKt.emptyList();
            }
            Single<List<FormElement>> formElementsAsync = state.a.g.getFormElementsAsync();
            formElementsAsync.getClass();
            duVar.a = state;
            duVar.d = 1;
            objAwait = RxAwaitKt.await(formElementsAsync, duVar);
            if (objAwait == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            state = duVar.a;
            ResultKt.throwOnFailure(objAwait);
        }
        objAwait.getClass();
        ArrayList arrayList = new ArrayList();
        for (Object obj : (Iterable) objAwait) {
            FormElement formElement = (FormElement) obj;
            if (formElement.getType() == FormType.SIGNATURE && formElement.getAnnotation().getPageIndex() == state.b) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj2 = arrayList.get(i3);
            i3++;
            if (obj2 instanceof SignatureFormElement) {
                arrayList2.add(obj2);
            }
        }
        return arrayList2;
    }

    public static final Unit b(final au auVar, az azVar) {
        azVar.getClass();
        MutableStateFlow<az> mutableStateFlow = auVar.A;
        while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), azVar)) {
        }
        if (azVar.a == 2) {
            auVar.post(new Runnable() { // from class: com.pspdfkit.internal.au$$ExternalSyntheticLambda9
                @Override // java.lang.Runnable
                public final void run() {
                    au.b(this.f$0);
                }
            });
        }
        return Unit.INSTANCE;
    }

    public static final Unit c(au auVar) {
        auVar.invalidateOutline();
        auVar.invalidate();
        return Unit.INSTANCE;
    }

    public static final Matrix d(au auVar) {
        Matrix matrix = new Matrix();
        auVar.getClass();
        auVar.a(matrix);
        return matrix;
    }

    public static final int e(au auVar) {
        return ViewConfiguration.get(auVar.getContext()).getScaledTouchSlop();
    }

    private final int getTouchSlop() {
        return ((Number) this.S.getValue()).intValue();
    }

    private final void setDrawableProviders(List<? extends PdfDrawableProvider> list) {
        if (this.w.getValue() == null) {
            return;
        }
        bf bfVar = this.N;
        bfVar.getClass();
        list.getClass();
        m40 m40Var = bfVar.d;
        if (m40Var == null) {
            return;
        }
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            throw new IllegalStateException("Page drawables touched from non-main thread.");
        }
        bfVar.a();
        Job job = bfVar.h;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        bfVar.h = BuildersKt__Builders_commonKt.launch$default(bfVar.g, null, null, new cf(list, bfVar, m40Var, null), 3, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View.OnKeyListener onKeyListener;
        keyEvent.getClass();
        boolean zDispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        if (!zDispatchKeyEvent && (onKeyListener = this.J) != null) {
            zDispatchKeyEvent = false;
            if (onKeyListener != null && onKeyListener.onKey(this, keyEvent.getKeyCode(), keyEvent)) {
                return true;
            }
        }
        return zDispatchKeyEvent;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final View focusSearch(View view, int i) {
        View viewFindNextFocus;
        view.getClass();
        return (Intrinsics.areEqual(view, this.D) && i == 2 && (viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this.o.l, null, i)) != null) ? viewFindNextFocus : super.focusSearch(view, i);
    }

    public final t1 getAnnotationDrawableStateProvider() {
        return this.M;
    }

    public final i4 getAnnotationRenderingCoordinator() {
        return this.o;
    }

    public final mh getFormEditor() {
        return this.k;
    }

    public final Rect getLocalVisibleRect() {
        return this.u;
    }

    public final kq getMediaPlayer() {
        return this.l;
    }

    public final vt getPageEditor() {
        return this.j;
    }

    public final DocumentView getParentView() {
        return this.d;
    }

    public final PdfConfiguration getPdfConfiguration() {
        return this.e;
    }

    @Override // com.pspdfkit.internal.dw
    public RectF getPdfRect() {
        RectF rectF;
        m40 state = getState();
        return (state == null || (rectF = (RectF) state.o.getValue()) == null) ? new RectF() : rectF;
    }

    public final q30 getSpecialModeView() {
        return this.F;
    }

    public final m40 getState() {
        return this.w.getValue();
    }

    public final TextSelection getTextSelection() {
        gu currentMode = this.F.getCurrentMode();
        return currentMode instanceof y50 ? ((y50) currentMode).a : this.F.getTextSelectionOverlay();
    }

    @Override // com.pspdfkit.internal.dw
    public float getZoomScale() {
        m40 state = getState();
        if (state != null) {
            return state.f;
        }
        return 1.0f;
    }

    @Override // android.view.View
    public final void invalidate() {
        MutableIntState mutableIntState = this.a0;
        mutableIntState.setIntValue(mutableIntState.getIntValue() + 1);
        super.invalidate();
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        drawable.getClass();
        if (this.N.a(drawable)) {
            invalidate();
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider.OnAnnotationUpdatedListener
    public final void onAnnotationCreated(Annotation annotation) {
        annotation.getClass();
        m40 state = getState();
        if (state != null) {
            BuildersKt__Builders_commonKt.launch$default(this.q, null, null, new cu(state, this, null), 3, null);
        }
        a(annotation);
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider.OnAnnotationUpdatedListener
    public final void onAnnotationRemoved(Annotation annotation) {
        annotation.getClass();
        this.o.c(annotation);
        m40 state = getState();
        if (state != null) {
            BuildersKt__Builders_commonKt.launch$default(this.q, null, null, new cu(state, this, null), 3, null);
        }
        a(annotation);
    }

    @Override // com.pspdfkit.ui.annotations.OnAnnotationSelectedListener
    public final void onAnnotationSelected(Annotation annotation, boolean z) {
        annotation.getClass();
        this.j.onAnnotationSelected(annotation, z);
        this.k.a(true);
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider.OnAnnotationUpdatedListener
    public final void onAnnotationUpdated(Annotation annotation) {
        annotation.getClass();
        a(annotation);
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider.OnAnnotationUpdatedListener
    public final void onAnnotationZOrderChanged(int i, List<Annotation> list, List<Annotation> list2) {
        list.getClass();
        list2.getClass();
        m40 state = getState();
        if (state != null && i == state.b && this.j.t.isEmpty()) {
            i4 i4Var = this.o;
            i4Var.getClass();
            i4Var.a((List<? extends Annotation>) list2);
            i4Var.a((List<? extends Annotation>) list2, true, (Function0<Unit>) null);
        }
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager.OnFormElementSelectedListener
    public final void onFormElementSelected(FormElement formElement) {
        formElement.getClass();
        vt.a(this.j, false, true, 13);
        mh mhVar = this.k;
        mhVar.getClass();
        mhVar.onFormElementClicked(formElement);
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager.OnFormElementUpdatedListener
    public final void onFormElementUpdated(FormElement formElement) {
        formElement.getClass();
        mh mhVar = this.k;
        mhVar.getClass();
        ArrayList arrayList = mhVar.n;
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            if (((uh) obj).getFormElement() == formElement) {
                arrayList2.add(obj);
            }
        }
        int size2 = arrayList2.size();
        while (i < size2) {
            Object obj2 = arrayList2.get(i);
            i++;
            ((uh) obj2).g();
        }
        i4 i4Var = this.o;
        WidgetAnnotation annotation = formElement.getAnnotation();
        annotation.getClass();
        i4Var.d(annotation);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // com.pspdfkit.internal.dw, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        m40 value;
        m40 m40Var;
        m40 state = getState();
        if (z && state != null) {
            float f2 = (i3 - i) / state.g.width;
            if (Math.abs(f2 - state.f) > 1.0E-5f) {
                MutableStateFlow<m40> mutableStateFlow = this.w;
                do {
                    value = mutableStateFlow.getValue();
                    m40Var = value;
                } while (!mutableStateFlow.compareAndSet(value, m40Var != null ? m40.a(m40Var, false, null, f2, false, false, null, null, null, 16351) : null));
            }
        }
        a(0, 0);
    }

    @Override // com.pspdfkit.internal.dw, android.view.View
    public final void onMeasure(int i, int i2) {
        a(this.a);
        this.b = getZoomScale();
        try {
            measureChildren(i, i2);
        } catch (IllegalStateException e2) {
            Log.w("PageLayout", "Failed to measure children, will retry: " + e2.getMessage());
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
    }

    @Override // com.pspdfkit.ui.annotations.OnAnnotationSelectedListener
    public final boolean onPrepareAnnotationSelection(AnnotationSelectionController annotationSelectionController, Annotation annotation, boolean z) {
        annotationSelectionController.getClass();
        annotation.getClass();
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:132:0x0253  */
    /* JADX WARN: Code duplicated, block: B:167:0x02d3  */
    @Override // android.view.View
    public final boolean onTouchEvent(final MotionEvent motionEvent) throws Exception {
        boolean zDispatchTouchEvent;
        boolean z;
        FormElement formElement;
        MotionEvent motionEvent2;
        motionEvent.getClass();
        if (this.w.getValue() == null) {
            return false;
        }
        PdfLog.v("Nutri.PageLayout", new Callable() { // from class: com.pspdfkit.internal.au$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return au.a(motionEvent, this);
            }
        });
        gu currentMode = this.F.getCurrentMode();
        boolean z2 = motionEvent.getActionMasked() == 0;
        boolean z3 = motionEvent.getActionMasked() == 1;
        if (z2) {
            this.U = motionEvent.getX();
            this.V = motionEvent.getY();
            this.W = false;
            this.Q = false;
            MotionEvent motionEvent3 = this.R;
            if (motionEvent3 != null) {
                motionEvent3.recycle();
            }
            this.R = null;
            this.m.e = false;
            float scaleHandleRadius = (int) (this.j.j.getScaleHandleRadius() * 6.0f);
            if (motionEvent.getX() + scaleHandleRadius < 0.0f || motionEvent.getX() - scaleHandleRadius >= getWidth() || motionEvent.getY() + scaleHandleRadius < 0.0f || motionEvent.getY() - scaleHandleRadius >= getHeight()) {
                return false;
            }
            if (getParentView().h()) {
                this.O = true;
            } else if (this.F.a() && currentMode != null) {
                vt vtVar = this.j;
                if (!vtVar.t.isEmpty() && vtVar.k.a(motionEvent) != null) {
                    this.O = true;
                } else if (currentMode.e()) {
                    this.R = MotionEvent.obtain(motionEvent);
                }
            }
            if (this.F.a() && currentMode != null && currentMode.b()) {
                vt vtVar2 = this.j;
                vtVar2.getClass();
                Annotation annotationA = vtVar2.a(motionEvent, true);
                if (annotationA == null || annotationA.getType() == AnnotationType.WIDGET) {
                    mh mhVar = this.k;
                    mhVar.getClass();
                    FormElement formElementA = mhVar.a(motionEvent);
                    if (formElementA == null) {
                        formElementA = null;
                        break;
                    }
                    yh yhVar = (yh) mhVar.e;
                    yhVar.getClass();
                    yh.a();
                    Iterator<FormManager.OnFormElementClickedListener> it = yhVar.e.iterator();
                    while (it.hasNext()) {
                        if (!it.next().isFormElementClickable(formElementA)) {
                            formElementA = null;
                            break;
                        }
                    }
                    this.T = formElementA;
                }
            }
        }
        if (!this.W && (motionEvent.getPointerCount() > 1 || (motionEvent.getActionMasked() == 2 && (Math.abs(motionEvent.getX() - this.U) > getTouchSlop() || Math.abs(motionEvent.getY() - this.V) > getTouchSlop())))) {
            this.W = true;
            this.T = null;
            MotionEvent motionEvent4 = this.R;
            if (motionEvent4 != null) {
                motionEvent4.recycle();
            }
            this.R = null;
            if (motionEvent.getPointerCount() > 1) {
                MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                motionEventObtain.setAction(3);
                this.m.a(motionEventObtain);
                motionEventObtain.recycle();
            }
        }
        if (this.O) {
            zDispatchTouchEvent = this.j.a(motionEvent);
            if (!zDispatchTouchEvent) {
                zDispatchTouchEvent = this.n.a(motionEvent);
            }
        } else if (this.F.a() && currentMode != null) {
            if (z2 && !currentMode.e()) {
                vt.a(this.j, true, true, 12);
            }
            zDispatchTouchEvent = this.F.dispatchTouchEvent(motionEvent);
            if (!zDispatchTouchEvent && z3 && !this.m.e && (motionEvent2 = this.R) != null) {
                motionEvent2.setLocation(motionEvent.getX(), motionEvent.getY());
                if (!this.j.a(motionEvent2)) {
                    this.n.a(motionEvent2);
                }
                if (!this.j.a(motionEvent)) {
                    this.n.a(motionEvent);
                }
            }
            if (!zDispatchTouchEvent && z3 && (formElement = this.T) != null) {
                zDispatchTouchEvent = this.k.b(formElement);
                this.T = null;
            }
            if (!zDispatchTouchEvent && motionEvent.getPointerCount() <= 1) {
                zDispatchTouchEvent = this.m.a(motionEvent);
            }
        } else {
            if (getParentView().i() && getParentView().getTextSelection() != null) {
                return false;
            }
            if (!this.P) {
                zDispatchTouchEvent = false;
            } else if (this.Q) {
                zDispatchTouchEvent = this.K.dispatchTouchEvent(motionEvent);
            } else if (z2) {
                vt vtVar3 = this.j;
                if ((vtVar3.t.isEmpty() || vtVar3.k.a(motionEvent) == null) && this.j.a(motionEvent, false) == null && this.K.dispatchTouchEvent(motionEvent)) {
                    this.Q = true;
                    vt.a(this.j, false, false, 13);
                    zDispatchTouchEvent = true;
                } else {
                    zDispatchTouchEvent = false;
                }
            } else {
                zDispatchTouchEvent = false;
            }
            if (!zDispatchTouchEvent && !this.Q) {
                kq kqVar = this.l;
                kqVar.getClass();
                loop1: while (true) {
                    z = false;
                    for (qq qqVar : kqVar.f.values()) {
                        if (qqVar != null) {
                            if (z || (a80.b(qqVar, motionEvent) && a80.a(qqVar, motionEvent))) {
                                z = true;
                            }
                        }
                    }
                    break loop1;
                }
                if (z) {
                    zDispatchTouchEvent = true;
                } else {
                    mh mhVar2 = this.k;
                    mhVar2.getClass();
                    ArrayList arrayList = mhVar2.n;
                    if (!(arrayList instanceof Collection) || !arrayList.isEmpty()) {
                        int size = arrayList.size();
                        int i = 0;
                        while (true) {
                            if (i < size) {
                                Object obj = arrayList.get(i);
                                i++;
                                uh uhVar = (uh) obj;
                                if (!a80.b(uhVar.a(), motionEvent) || !a80.a(uhVar.a(), motionEvent)) {
                                }
                            } else if (this.j.a(motionEvent) && !this.m.a(motionEvent)) {
                                zDispatchTouchEvent = false;
                            }
                            zDispatchTouchEvent = true;
                        }
                    } else if (this.j.a(motionEvent)) {
                        zDispatchTouchEvent = true;
                    } else {
                        zDispatchTouchEvent = true;
                    }
                }
            }
        }
        if (this.O && (motionEvent.getActionMasked() == 1 || motionEvent.getActionMasked() == 3)) {
            this.O = false;
        }
        if (motionEvent.getActionMasked() != 3 && !z3) {
            return zDispatchTouchEvent;
        }
        this.Q = false;
        this.T = null;
        MotionEvent motionEvent5 = this.R;
        if (motionEvent5 != null) {
            motionEvent5.recycle();
        }
        this.R = null;
        return zDispatchTouchEvent;
    }

    @Override // com.pspdfkit.internal.nx
    public final void recycle() {
        az value;
        az value2;
        o3 annotationProvider;
        Job job = this.r;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.r = null;
        this.s = false;
        this.t.clear();
        ho hoVar = this.C;
        hoVar.removeCallbacks(hoVar.c);
        hoVar.setVisibility(8);
        MutableStateFlow<az> mutableStateFlow = this.A;
        do {
            value = mutableStateFlow.getValue();
            value.getClass();
        } while (!mutableStateFlow.compareAndSet(value, new az(0)));
        MutableStateFlow<az> mutableStateFlow2 = this.y;
        do {
            value2 = mutableStateFlow2.getValue();
            value2.getClass();
        } while (!mutableStateFlow2.compareAndSet(value2, new az(0)));
        if (this.D.getHasComposition()) {
            this.D.disposeComposition();
        }
        this.F.a(true);
        mh mhVar = this.k;
        mhVar.a(false);
        JobKt__JobKt.cancelChildren$default(mhVar.j.getCoroutineContext(), (CancellationException) null, 1, (Object) null);
        ((yh) mhVar.e).d.b(mhVar);
        ((yh) mhVar.e).e.b(mhVar);
        this.j.recycle();
        kq kqVar = this.l;
        kqVar.a();
        kqVar.f.clear();
        JobKt__JobKt.cancelChildren$default(this.q.getCoroutineContext(), (CancellationException) null, 1, (Object) null);
        this.o.recycle();
        yz.a(this.G);
        this.G = null;
        yz.a(this.H);
        this.H = null;
        for (int i = 0; i < getChildCount(); i++) {
            KeyEvent.Callback childAt = getChildAt(i);
            if (childAt instanceof nx) {
                ((nx) childAt).recycle();
            }
        }
        bf bfVar = this.N;
        bfVar.a();
        JobKt__JobKt.cancelChildren$default(bfVar.g.getCoroutineContext(), (CancellationException) null, 1, (Object) null);
        t1 t1Var = this.M;
        m40 m40Var = t1Var.d;
        if (m40Var != null && (annotationProvider = m40Var.a.getAnnotationProvider()) != null) {
            annotationProvider.h.b(t1Var);
        }
        JobKt__JobKt.cancelChildren$default(t1Var.h.getCoroutineContext(), (CancellationException) null, 1, (Object) null);
        t1Var.e.setValue(CollectionsKt.emptyList());
        t1Var.f = null;
        t1Var.i = null;
        t1Var.d = null;
        st stVar = this.K;
        stVar.d.removeView(stVar);
        stVar.a();
        stVar.e = null;
        this.d.i.b(this);
        o3 annotationProvider2 = this.d.r().getAnnotationProvider();
        annotationProvider2.getClass();
        annotationProvider2.h.b(this);
        ((yh) this.f).c.b(this);
        ((yh) this.f).a.b(this);
        MutableStateFlow<m40> mutableStateFlow3 = this.w;
        while (!mutableStateFlow3.compareAndSet(mutableStateFlow3.getValue(), null)) {
        }
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        drawable.getClass();
        runnable.getClass();
        if (this.N.a(drawable)) {
            drawable.scheduleSelf(runnable, j);
        } else {
            super.scheduleDrawable(drawable, runnable, j);
        }
    }

    public final void setAnnotationOverlayAboveOverlayViews(boolean z) {
        this.P = z;
        if (z) {
            this.o.l.bringToFront();
        } else {
            this.K.bringToFront();
        }
        if (this.j.j.getParent() == this) {
            this.j.j.bringToFront();
        }
        this.F.bringToFront();
        this.C.bringToFront();
    }

    public final void setAnnotationOverlayEnabled(boolean z) {
        i4 i4Var = this.o;
        if (i4Var.m != z) {
            i4Var.m = z;
            if (i4Var.c) {
                i4Var.l.setVisibility(z ? 0 : 4);
            }
        }
        a();
    }

    @Override // android.view.View
    public void setOnKeyListener(View.OnKeyListener onKeyListener) {
        onKeyListener.getClass();
        this.J = onKeyListener;
        this.D.setOnKeyListener(onKeyListener);
        this.j.j.setOnKeyListener(onKeyListener);
    }

    public final void setRedactionAnnotationPreviewEnabled(boolean z) {
        m40 state = getState();
        if (state == null) {
            return;
        }
        state.h = z;
        if (this.w.getValue() != null) {
            BuildersKt__Builders_commonKt.launch$default(this.q, null, null, new g(state, this, null), 3, null);
        }
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        drawable.getClass();
        runnable.getClass();
        if (this.N.a(drawable)) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleDrawable(drawable, runnable);
        }
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        drawable.getClass();
        return this.N.a(drawable) || super.verifyDrawable(drawable);
    }

    public static final void c(au auVar, List list) {
        list.getClass();
        if (auVar.w.getValue() != null) {
            auVar.K.setCurrentOverlayViewProviders(CollectionsKt.filterNotNull(list));
        }
    }

    public static final void b(au auVar) {
        uy uyVar = uy.LowRes;
        auVar.getClass();
        ArrayList arrayList = new ArrayList(auVar.E);
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((dt) obj).a(uyVar);
        }
    }

    public final void a(lm lmVar, int i) {
        az value;
        az azVar;
        az value2;
        m40 state = getState();
        if (state == null) {
            return;
        }
        mh mhVar = this.k;
        ((yh) mhVar.e).e.addFirst(mhVar);
        ((yh) mhVar.e).d.a(mhVar);
        t1 t1Var = this.M;
        t1Var.getClass();
        t1Var.d = state;
        o3 annotationProvider = state.a.getAnnotationProvider();
        annotationProvider.getClass();
        annotationProvider.h.a(t1Var);
        m40 m40Var = t1Var.d;
        if (m40Var != null) {
            Job job = t1Var.i;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            t1Var.f = null;
            t1Var.i = BuildersKt__Builders_commonKt.launch$default(t1Var.h, null, null, new s1(m40Var, t1Var, null), 3, null);
        }
        this.N.d = state;
        Integer fixedLowResRenderPixelCount = this.e.getFixedLowResRenderPixelCount();
        final int iIntValue = fixedLowResRenderPixelCount != null ? fixedLowResRenderPixelCount.intValue() : uc.b(getContext().getApplicationContext());
        final int iA = ff.a(this.e.getBackgroundColor(), this.e.isToGrayscale(), this.e.isInvertColors());
        int i2 = 0;
        if (this.D.getHasComposition()) {
            this.D.disposeComposition();
            MutableStateFlow<az> mutableStateFlow = this.A;
            do {
                value = mutableStateFlow.getValue();
                azVar = value;
                azVar.getClass();
            } while (!mutableStateFlow.compareAndSet(value, az.a(azVar, 0, null, 14)));
            MutableStateFlow<az> mutableStateFlow2 = this.y;
            do {
                value2 = mutableStateFlow2.getValue();
                value2.getClass();
            } while (!mutableStateFlow2.compareAndSet(value2, new az(0)));
            this.C.a(50L);
        }
        this.D.setContent(ComposableLambdaKt.composableLambdaInstance(1495472400, true, new Function2() { // from class: com.pspdfkit.internal.au$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return au.a(this.f$0, iIntValue, iA, (Composer) obj, ((Integer) obj2).intValue());
            }
        }));
        kq kqVar = this.l;
        kqVar.getClass();
        kqVar.a();
        kqVar.f.clear();
        kqVar.h = BuildersKt__Builders_commonKt.launch$default(kqVar.g, null, null, new oq(kqVar, state, null), 3, null);
        m40 state2 = getState();
        if (state2 != null) {
            BuildersKt__Builders_commonKt.launch$default(this.q, null, null, new cu(state2, this, null), 3, null);
        }
        i4 i4Var = this.o;
        et etVar = this.p;
        i4Var.getClass();
        etVar.getClass();
        i4Var.p = etVar;
        i4Var.o = false;
        i4Var.l.setVisibility(4);
        ViewParent parent = i4Var.l.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(i4Var.l);
        }
        i4Var.a.addView(i4Var.l);
        c5 c5Var = i4Var.b;
        c5.a aVar = i4Var.q;
        c5Var.getClass();
        aVar.getClass();
        c5Var.i.a(aVar);
        i4Var.e();
        i4Var.b();
        hu<PdfDrawableProvider> huVar = this.h;
        this.G = huVar.a.toObservable().map(huVar.a(i)).subscribeOn(huVar.c).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() { // from class: com.pspdfkit.internal.au$$ExternalSyntheticLambda4
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) {
                au.b(this.f$0, (List) obj);
            }
        });
        hu<OverlayViewProvider> huVar2 = this.i;
        this.H = huVar2.a.toObservable().map(huVar2.a(i)).subscribeOn(huVar2.c).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() { // from class: com.pspdfkit.internal.au$$ExternalSyntheticLambda5
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) {
                au.c(this.f$0, (List) obj);
            }
        });
        st stVar = this.K;
        stVar.getClass();
        stVar.e = state;
        if (stVar.getParent() instanceof ViewGroup) {
            ViewParent parent2 = stVar.getParent();
            parent2.getClass();
            ((ViewGroup) parent2).removeView(stVar);
        }
        stVar.d.addView(stVar);
        this.d.i.a(this);
        o3 annotationProvider2 = this.d.r().getAnnotationProvider();
        annotationProvider2.getClass();
        annotationProvider2.h.a(this);
        ((yh) this.f).c.a(this);
        ((yh) this.f).a.a(this);
        if (this.j.j.getParent() == this) {
            this.j.j.bringToFront();
        }
        this.F.bringToFront();
        this.C.bringToFront();
        vt vtVar = this.j;
        vtVar.getClass();
        if (ar.b().f(vtVar.c)) {
            Job job2 = vtVar.q;
            if (job2 != null) {
                Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
            }
            vtVar.q = lmVar.a(EmptyCoroutineContext.INSTANCE, new xt(vtVar, i, lmVar, null));
        }
        this.s = true;
        ArrayList arrayList = this.t;
        int size = arrayList.size();
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            ((Function0) obj).invoke();
        }
        this.t.clear();
    }

    public static final void b(au auVar, List list) {
        list.getClass();
        if (auVar.w.getValue() != null) {
            auVar.setDrawableProviders(list);
        }
    }

    public final void b() {
        boolean localVisibleRect = getLocalVisibleRect(this.u);
        this.v = localVisibleRect;
        st stVar = this.K;
        m40 m40Var = stVar.e;
        if (m40Var != null) {
            if (localVisibleRect != stVar.f) {
                for (Map.Entry entry : stVar.g.entrySet()) {
                    OverlayViewProvider overlayViewProvider = (OverlayViewProvider) entry.getKey();
                    List<View> list = (List) entry.getValue();
                    int i = m40Var.b;
                    if (localVisibleRect) {
                        overlayViewProvider.onViewsShown(i, list);
                    } else {
                        overlayViewProvider.onViewsHidden(i, list);
                    }
                }
            }
            stVar.f = localVisibleRect;
        }
        this.D.setFocusable(this.v);
        setDescendantFocusability(this.v ? 131072 : 393216);
    }

    public static final Unit a(final au auVar, int i, int i2, Composer composer, int i3) {
        if (composer.shouldExecute((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1495472400, i3, -1, "com.pspdfkit.internal.views.page.PageLayout.completeBindPage.<anonymous> (PageLayout.kt:543)");
            }
            State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(auVar.x, (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composer, 0, 7);
            State stateCollectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(auVar.z, (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composer, 0, 7);
            State stateCollectAsStateWithLifecycle3 = FlowExtKt.collectAsStateWithLifecycle(auVar.B, (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composer, 0, 7);
            m40 m40Var = (m40) stateCollectAsStateWithLifecycle.getValue();
            if (m40Var == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                return Unit.INSTANCE;
            }
            az azVar = (az) stateCollectAsStateWithLifecycle2.getValue();
            boolean zChangedInstance = composer.changedInstance(auVar);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.pspdfkit.internal.au$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return au.a(this.f$0, (az) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            az azVar2 = (az) stateCollectAsStateWithLifecycle3.getValue();
            boolean zChangedInstance2 = composer.changedInstance(auVar);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.pspdfkit.internal.au$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return au.b(this.f$0, (az) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            tu.a(i, m40Var, i2, azVar, function1, azVar2, (Function1) objRememberedValue2, composer, 0);
            State stateCollectAsStateWithLifecycle4 = FlowExtKt.collectAsStateWithLifecycle(auVar.M.g, (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composer, 0, 7);
            composer.startMovableGroup(-1665029557, composer.joinKey(composer.joinKey((List) stateCollectAsStateWithLifecycle4.getValue(), Integer.valueOf(auVar.a0.getIntValue())), Integer.valueOf(m40Var.b)));
            r1.a((List) stateCollectAsStateWithLifecycle4.getValue(), composer, 0);
            composer.endMovableGroup();
            State stateCollectAsStateWithLifecycle5 = FlowExtKt.collectAsStateWithLifecycle(auVar.N.f, (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composer, 0, 7);
            composer.startMovableGroup(-1665020771, composer.joinKey(composer.joinKey((Map) stateCollectAsStateWithLifecycle5.getValue(), Integer.valueOf(auVar.a0.getIntValue())), Integer.valueOf(m40Var.b)));
            af.a((Map) stateCollectAsStateWithLifecycle5.getValue(), composer, 0);
            composer.endMovableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(final au auVar, az azVar) {
        azVar.getClass();
        MutableStateFlow<az> mutableStateFlow = auVar.y;
        while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), azVar)) {
        }
        if (azVar.a == 2) {
            auVar.post(new Runnable() { // from class: com.pspdfkit.internal.au$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    au.a(this.f$0);
                }
            });
        }
        return Unit.INSTANCE;
    }

    public static final void a(au auVar) {
        uy uyVar = uy.Detail;
        auVar.getClass();
        ArrayList arrayList = new ArrayList(auVar.E);
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((dt) obj).a(uyVar);
        }
    }

    @Override // com.pspdfkit.internal.dw
    public final Matrix a(Matrix matrix) {
        Matrix matrix2;
        m40 state = getState();
        if (state == null) {
            return matrix == null ? new Matrix() : matrix;
        }
        DocumentView documentView = this.d;
        int i = state.b;
        if (matrix != null) {
            matrix2 = matrix;
        } else {
            documentView.getClass();
            matrix2 = new Matrix();
        }
        ln lnVar = documentView.C;
        return lnVar != null ? lnVar.a(i, matrix) : matrix2;
    }

    public final void a(Annotation annotation) {
        boolean zIsLocked;
        boolean hasLockedContents;
        m40 state = getState();
        if (state != null && annotation.getPageIndex() == state.b) {
            List listUnmodifiableList = Collections.unmodifiableList(this.j.t);
            listUnmodifiableList.getClass();
            if (!listUnmodifiableList.contains(annotation) || !vt.F.contains(annotation.getType())) {
                this.o.d(annotation);
            }
            if (annotation.isSignature()) {
                BuildersKt__Builders_commonKt.launch$default(this.q, null, null, new eu(this, null), 3, null);
            }
            vt vtVar = this.j;
            vtVar.getClass();
            try {
                List<Annotation> listUnmodifiableList2 = Collections.unmodifiableList(vtVar.t);
                listUnmodifiableList2.getClass();
                if (listUnmodifiableList2.contains(annotation)) {
                    if (!vtVar.l.a(annotation)) {
                        List listMinus = CollectionsKt.minus(listUnmodifiableList2, annotation);
                        listMinus.getClass();
                        vtVar.a(false, (Collection<? extends Annotation>) listMinus);
                        return;
                    }
                    Iterator<T> it = vtVar.d().iterator();
                    while (it.hasNext()) {
                        z4 z4Var = (z4) it.next();
                        Annotation annotation2 = z4Var.getAnnotation();
                        if ((annotation2 != null && annotation2.getObjectNumber() == annotation.getObjectNumber()) || z4Var.getAnnotation() == annotation) {
                            ViewGroup.LayoutParams layoutParams = z4Var.a().getLayoutParams();
                            layoutParams.getClass();
                            OverlayLayoutParams overlayLayoutParams = (OverlayLayoutParams) layoutParams;
                            Annotation annotation3 = z4Var.getAnnotation();
                            if (annotation3 != null) {
                                boolean zAreEqual = Intrinsics.areEqual(overlayLayoutParams.pageRect.getPageRect(), annotation3.getBoundingBox());
                                boolean z = vtVar.v;
                                if (zAreEqual) {
                                    if (!z) {
                                        z4Var.n();
                                    }
                                    z4Var.b();
                                } else {
                                    if (!z) {
                                        z4Var.n();
                                    }
                                    vtVar.k.b();
                                    z4Var.b();
                                }
                            }
                        }
                    }
                    if (!listUnmodifiableList2.isEmpty()) {
                        zIsLocked = false;
                        hasLockedContents = false;
                        for (Annotation annotation4 : listUnmodifiableList2) {
                            zIsLocked |= annotation4.isLocked();
                            hasLockedContents |= annotation4.getHasLockedContents();
                            if (zIsLocked && hasLockedContents) {
                                break;
                            }
                        }
                    } else {
                        zIsLocked = false;
                        hasLockedContents = false;
                    }
                    m4 m4Var = vtVar.k;
                    if (m4Var.s != zIsLocked) {
                        m4Var.s = zIsLocked;
                        m4Var.a.invalidate();
                    }
                    m4 m4Var2 = vtVar.k;
                    if (m4Var2.t != hasLockedContents) {
                        m4Var2.t = hasLockedContents;
                        m4Var2.a.invalidate();
                    }
                    if (hasLockedContents) {
                        vtVar.a();
                    }
                    vtVar.k.b();
                }
            } catch (IllegalStateException unused) {
                vt.a(vtVar, false, false, 15);
            }
        }
    }

    public static final void a(au auVar, List list) {
        iq iqVar;
        iq iqVarA;
        k2 k2Var = auVar.I;
        k2Var.getClass();
        list.getClass();
        k2Var.c = CollectionsKt.toList(list);
        synchronized (k2Var) {
            k2Var.e.set(0.0f, 0.0f);
            k2Var.f.clear();
            Unit unit = Unit.INSTANCE;
        }
        kq kqVar = auVar.l;
        kqVar.getClass();
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Annotation annotation = (Annotation) it.next();
                if (kq.o.contains(annotation.getType()) && !kqVar.m) {
                    Iterator it2 = kqVar.f.entrySet().iterator();
                    do {
                        if (!it2.hasNext()) {
                            iqVar = null;
                            break;
                        }
                        iqVar = (iq) ((Map.Entry) it2.next()).getKey();
                    } while (!Intrinsics.areEqual(iqVar.a, annotation));
                    if (iqVar == null) {
                        Iterator it3 = kqVar.f.entrySet().iterator();
                        do {
                            if (!it3.hasNext()) {
                                iqVarA = null;
                                break;
                            }
                            iqVarA = (iq) ((Map.Entry) it3.next()).getKey();
                        } while (!Intrinsics.areEqual(iqVarA.a, annotation));
                        if (iqVarA == null && (iqVarA = iq.a(annotation)) != null) {
                            kqVar.f.put(iqVarA, null);
                        }
                        if (iqVarA != null) {
                            if (iqVarA.e) {
                                qq qqVarA = kqVar.a(iqVarA);
                                if (!qqVarA.i.b()) {
                                    qqVarA.j = 4;
                                    qqVarA.a();
                                }
                            } else if (iqVarA.g != 4) {
                                kqVar.a(iqVarA);
                            }
                        }
                    }
                }
            }
            return;
        }
        throw new IllegalStateException("setTouchableAnnotations must be called on the main thread");
    }

    public final void a(boolean z) {
        az value;
        m40 state = getState();
        if (state == null) {
            return;
        }
        b();
        if (z || this.v) {
            m40 m40VarA = m40.a(state, this.v, this.u, 0.0f, false, getParentView().n0, null, null, null, 15847);
            bf bfVar = this.N;
            bfVar.getClass();
            if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                bfVar.d = m40VarA;
                Matrix matrixInvoke = bfVar.b.invoke();
                Iterator<List<PdfDrawable>> it = bfVar.e.getValue().values().iterator();
                while (it.hasNext()) {
                    Iterator<PdfDrawable> it2 = it.next().iterator();
                    while (it2.hasNext()) {
                        it2.next().updatePdfToViewTransformation(matrixInvoke);
                    }
                }
                t1 t1Var = this.M;
                t1Var.getClass();
                if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                    t1Var.d = m40VarA;
                    Matrix matrixInvoke2 = t1Var.b.invoke();
                    for (q1 q1Var : t1Var.e.getValue()) {
                        q1Var.getClass();
                        matrixInvoke2.getClass();
                        q1Var.b.updateScreenRect(matrixInvoke2);
                    }
                    this.w.tryEmit(m40VarA);
                    this.F.c();
                    vt vtVar = this.j;
                    o4 o4Var = vtVar.j;
                    Matrix matrixA = vtVar.a.a(vtVar.o);
                    float zoomScale = vtVar.a.getZoomScale();
                    o4Var.getClass();
                    if (o4Var.getParent() != null) {
                        int childCount = o4Var.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            KeyEvent.Callback childAt = o4Var.getChildAt(i);
                            childAt.getClass();
                            ((z4) childAt).a(matrixA, zoomScale);
                        }
                    }
                    aq aqVar = vtVar.p;
                    if (aqVar != null) {
                        Matrix matrix = vtVar.o;
                        matrix.getClass();
                        aqVar.a = matrix;
                        float fA = s60.a(aqVar.d, matrix);
                        if (aqVar.e != fA) {
                            aqVar.e = fA;
                            NativePDFSnapper nativePDFSnapper = aqVar.c;
                            float f2 = aqVar.e;
                            nativePDFSnapper.setConfiguration(new NativeSnapperConfiguration(new Size(f2, f2), EnumSet.copyOf((Collection) aq.a.a)));
                        }
                    }
                    c3 c3Var = this.o.l;
                    Matrix matrixA2 = c3Var.d.a(c3Var.f);
                    Sequence sequenceFilter = SequencesKt.filter(ViewGroupKt.getChildren(c3Var), b3.a);
                    sequenceFilter.getClass();
                    Iterator it3 = sequenceFilter.iterator();
                    while (it3.hasNext()) {
                        ((z4) it3.next()).a(matrixA2, c3Var.getZoomScale());
                    }
                    st stVar = this.K;
                    stVar.d.a(stVar.a);
                    stVar.b = stVar.getZoomScale();
                } else {
                    throw new IllegalStateException("Annotation drawables touched from non-main thread.");
                }
            } else {
                throw new IllegalStateException("Page drawables touched from non-main thread.");
            }
        }
        if (!this.v) {
            if (this.y.getValue().a == 2) {
                MutableStateFlow<az> mutableStateFlow = this.y;
                do {
                    value = mutableStateFlow.getValue();
                    value.getClass();
                } while (!mutableStateFlow.compareAndSet(value, new az(0)));
            }
            kq kqVar = this.l;
            if (kqVar.i) {
                kqVar.a();
                kqVar.i = false;
                kqVar.m = true;
                return;
            }
            return;
        }
        kq kqVar2 = this.l;
        kqVar2.i = true;
        kqVar2.b();
    }

    public final void a(dt dtVar) {
        az value;
        az azVar;
        az value2;
        az azVar2;
        if (dtVar != null) {
            this.E.add(new f(dtVar));
        }
        MutableStateFlow<az> mutableStateFlow = this.y;
        do {
            value = mutableStateFlow.getValue();
            azVar = value;
            azVar.getClass();
        } while (!mutableStateFlow.compareAndSet(value, az.a(azVar, 0, null, 14)));
        MutableStateFlow<az> mutableStateFlow2 = this.A;
        do {
            value2 = mutableStateFlow2.getValue();
            azVar2 = value2;
            azVar2.getClass();
        } while (!mutableStateFlow2.compareAndSet(value2, az.a(azVar2, 0, null, 14)));
    }

    public final void a(Function1<? super m40, m40> function1) {
        m40 value;
        m40 m40Var;
        function1.getClass();
        MutableStateFlow<m40> mutableStateFlow = this.w;
        do {
            value = mutableStateFlow.getValue();
            m40Var = value;
        } while (!mutableStateFlow.compareAndSet(value, m40Var != null ? function1.invoke(m40Var) : null));
    }

    public static final String a(MotionEvent motionEvent, au auVar) {
        PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
        l4.a(auVar.a((Matrix) null), pointF);
        return String.format(Locale.getDefault(), "PageLayout touched at (%.2f, %.2f)", Float.valueOf(pointF.x), Float.valueOf(pointF.y));
    }

    public final void a(ab abVar) {
        m40 state;
        abVar.getClass();
        if (getState() != null) {
            q30 q30Var = this.F;
            q30Var.getClass();
            gu guVar = q30Var.c;
            if (guVar != null) {
                guVar.d();
            }
            au parentView = q30Var.getParentView();
            if (parentView == null || (state = parentView.getState()) == null) {
                return;
            }
            Context context = q30Var.getContext();
            context.getClass();
            ta taVar = new ta(abVar, context, state.b);
            q30Var.c = taVar;
            taVar.a(q30Var);
        }
    }

    public final void a() {
        k2 k2Var = this.I;
        k2Var.d = new Function1() { // from class: com.pspdfkit.internal.au$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(au.a(this.f$0, (Annotation) obj));
            }
        };
        synchronized (k2Var) {
            k2Var.e.set(0.0f, 0.0f);
            k2Var.f.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    public static final boolean a(au auVar, Annotation annotation) {
        annotation.getClass();
        i4 i4Var = auVar.o;
        i4Var.getClass();
        return i4Var.m || i4.a(annotation, i4Var.n) == g4.PAGE;
    }
}
