package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.Looper;
import android.view.MotionEvent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.box.android.common.utilities.BoxCommonConstants;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.WidgetAnnotation;
import com.pspdfkit.forms.SignatureFormElement;
import com.pspdfkit.internal.jni.NativeLicense;
import com.pspdfkit.internal.jni.NativeLicenseFeatures;
import com.pspdfkit.internal.jni.NativeSignatureFeatureAvailability;
import com.pspdfkit.signatures.Signature;
import com.pspdfkit.signatures.listeners.OnSignaturePickedListener;
import com.pspdfkit.ui.PdfFragment;
import com.pspdfkit.ui.signatures.ElectronicSignatureFragment;
import com.pspdfkit.ui.signatures.SignaturePickerFragment;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import com.pspdfkit.ui.special_mode.controller.AnnotationToolVariant;
import com.pspdfkit.utils.BundleExtensions;
import java.util.EnumSet;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes3.dex */
public final class u10 extends d3 implements OnSignaturePickedListener, tk {
    public final AnnotationToolVariant c;
    public d00 d;
    public PointF e;
    public final Matrix f;
    public final CoroutineScope g;
    public Job h;
    public v10 i;
    public final wi j;
    public final nf k;

    public final class a extends w20 {
        public Point a;

        public a() {
        }

        @Override // com.pspdfkit.internal.w20, com.pspdfkit.internal.xi
        public final void c(MotionEvent motionEvent) {
            motionEvent.getClass();
            this.a = null;
        }

        @Override // com.pspdfkit.internal.w20, com.pspdfkit.internal.xi
        public final boolean d(MotionEvent motionEvent) {
            lm lmVarJ;
            au auVarL;
            motionEvent.getClass();
            Point point = this.a;
            if (point == null || (lmVarJ = u10.this.j()) == null || (auVarL = u10.this.l()) == null) {
                return false;
            }
            Context context = u10.this.a.a;
            context.getClass();
            boolean zA = a80.a(context, point.x, point.y, (int) motionEvent.getRawX(), (int) motionEvent.getRawY());
            boolean zB = auVarL.getPageEditor().b(motionEvent);
            auVarL.a(u10.this.f);
            u10 u10Var = u10.this;
            Annotation annotationA = u10Var.k.a(motionEvent, u10Var.f, false);
            WidgetAnnotation widgetAnnotation = annotationA instanceof WidgetAnnotation ? (WidgetAnnotation) annotationA : null;
            if (widgetAnnotation != null && ar.b().a(NativeLicenseFeatures.ACRO_FORMS) && lmVarJ.g.hasFieldsCache() && (widgetAnnotation.getFormElement() instanceof SignatureFormElement)) {
                nf nfVar = u10.this.k;
                nfVar.getClass();
                k2 k2Var = nfVar.a;
                k2Var.getClass();
                Annotation annotation = (Annotation) CollectionsKt.firstOrNull(h2.a(k2Var.c, widgetAnnotation));
                if (annotation != null) {
                    u10.this.a.f.setSelectedAnnotation(annotation);
                    return true;
                }
            }
            if (!zA && !zB) {
                u10 u10Var2 = u10.this;
                PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
                l4.a(auVarL.a((Matrix) null), pointF);
                u10Var2.e = pointF;
                u10 u10Var3 = u10.this;
                d20.a(u10Var3.a.f, u10Var3);
                d00 d00Var = u10.this.d;
                if (d00Var != null) {
                    d00Var.a().onSaveInstanceState(new Bundle());
                }
                this.a = null;
            }
            return true;
        }

        @Override // com.pspdfkit.internal.w20
        public final boolean h(MotionEvent motionEvent) {
            motionEvent.getClass();
            return true;
        }

        @Override // com.pspdfkit.internal.w20, com.pspdfkit.internal.xi
        public final void onDown(MotionEvent motionEvent) {
            motionEvent.getClass();
            this.a = new Point((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.views.page.handler.SignatureAnnotationModeHandler$onSignaturePicked$1", f = "SignatureAnnotationModeHandler.kt", i = {}, l = {208}, m = "invokeSuspend", n = {}, nl = {BoxCommonConstants.REQUEST_OPTIONS}, s = {}, v = 2)
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ lm b;
        public final /* synthetic */ Annotation c;
        public final /* synthetic */ u10 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(lm lmVar, Annotation annotation, u10 u10Var, Continuation<? super b> continuation) {
            super(2, continuation);
            this.b = lmVar;
            this.c = annotation;
            this.d = u10Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.b, this.c, this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                o3 annotationProvider = this.b.getAnnotationProvider();
                Annotation annotation = this.c;
                this.a = 1;
                if (annotationProvider.addAnnotationToPage(annotation, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            q0 q0Var = this.d.a;
            if (q0Var.s == AnnotationTool.SIGNATURE) {
                AnnotationTool annotationTool = AnnotationTool.NONE;
                AnnotationToolVariant annotationToolVariantDefaultVariant = AnnotationToolVariant.defaultVariant();
                annotationToolVariantDefaultVariant.getClass();
                annotationTool.getClass();
                q0Var.b.enterAnnotatingMode(annotationTool, annotationToolVariantDefaultVariant);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u10(q0 q0Var, AnnotationToolVariant annotationToolVariant, k2 k2Var) {
        super(q0Var);
        q0Var.getClass();
        annotationToolVariant.getClass();
        k2Var.getClass();
        this.c = annotationToolVariant;
        this.f = new Matrix();
        this.g = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        Context context = q0Var.a;
        context.getClass();
        wi wiVar = new wi(context);
        wiVar.a(vi.Tap, new a());
        this.j = wiVar;
        nf nfVar = new nf(k2Var);
        EnumSet<AnnotationType> enumSetOf = EnumSet.of(AnnotationType.WIDGET);
        enumSetOf.getClass();
        nfVar.b = enumSetOf;
        this.k = nfVar;
    }

    @Override // com.pspdfkit.internal.gu
    public final void a(Canvas canvas) {
        canvas.getClass();
    }

    @Override // com.pspdfkit.internal.gu
    public final void a(Matrix matrix) {
    }

    @Override // com.pspdfkit.internal.gu
    public final boolean c() {
        v10 v10Var = this.i;
        if (v10Var != null) {
            this.a.f.removeDocumentListener(v10Var);
            this.i = null;
        }
        FragmentManager parentFragmentManager = this.a.f.getParentFragmentManager();
        parentFragmentManager.getClass();
        ElectronicSignatureFragment.dismiss(parentFragmentManager);
        SignaturePickerFragment.Companion companion = SignaturePickerFragment.INSTANCE;
        FragmentManager parentFragmentManager2 = this.a.f.getParentFragmentManager();
        parentFragmentManager2.getClass();
        companion.dismiss(parentFragmentManager2);
        Job job = this.h;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.h = null;
        return false;
    }

    @Override // com.pspdfkit.internal.gu
    public final boolean d() {
        c();
        CoroutineScopeKt.cancel$default(this.g, null, 1, null);
        this.a.b(this);
        return false;
    }

    @Override // com.pspdfkit.internal.gu
    public final int f() {
        return 10;
    }

    @Override // com.pspdfkit.internal.gu
    public final void g() {
        this.a.c(this);
    }

    @Override // com.pspdfkit.internal.d3
    public final AnnotationTool h() {
        return AnnotationTool.SIGNATURE;
    }

    @Override // com.pspdfkit.internal.d3
    public final AnnotationToolVariant i() {
        return this.c;
    }

    @Override // com.pspdfkit.signatures.listeners.OnSignaturePickedListener
    public final void onDismiss() {
    }

    @Override // com.pspdfkit.internal.tk
    public final boolean onRestoreInstanceState(Bundle bundle) {
        bundle.getClass();
        if (bundle.getInt("STATE_PAGE_INDEX") != k()) {
            return false;
        }
        PdfFragment pdfFragment = this.a.f;
        pdfFragment.getClass();
        synchronized (ar.b()) {
            if (NativeLicense.license().signatureFeatureAvailability() == NativeSignatureFeatureAvailability.ELECTRONICSIGNATURES) {
                ElectronicSignatureFragment.restore(pdfFragment.getParentFragmentManager(), this, pdfFragment.getSignatureStorage());
            } else {
                SignaturePickerFragment.Companion companion = SignaturePickerFragment.INSTANCE;
                FragmentManager parentFragmentManager = pdfFragment.getParentFragmentManager();
                parentFragmentManager.getClass();
                companion.restore(parentFragmentManager, this, pdfFragment.getSignatureStorage());
            }
        }
        this.e = (PointF) BundleExtensions.getSupportParcelable(bundle, "STATE_TOUCH_POINT", PointF.class);
        return true;
    }

    @Override // com.pspdfkit.internal.tk
    public final void onSaveInstanceState(Bundle bundle) {
        bundle.getClass();
        PointF pointF = this.e;
        if (pointF != null) {
            bundle.putInt("STATE_PAGE_INDEX", k());
            bundle.putParcelable("STATE_TOUCH_POINT", pointF);
        }
    }

    @Override // com.pspdfkit.signatures.listeners.OnSignaturePickedListener
    public final void onSignaturePicked(Signature signature) {
        lm lmVarJ;
        signature.getClass();
        PointF pointF = this.e;
        if (pointF == null || (lmVarJ = j()) == null) {
            return;
        }
        d00 d00Var = this.d;
        if (d00Var != null) {
            FragmentManager fragmentManager = d00Var.a;
            String str = d00Var.b;
            int i = sk.c;
            fragmentManager.getClass();
            str.getClass();
            if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                throw new IllegalStateException("removeFragment() may only be called from the main thread.");
            }
            Fragment fragmentFindFragmentByTag = fragmentManager.findFragmentByTag(str);
            if (fragmentFindFragmentByTag != null) {
                fi.a(fragmentManager, fragmentFindFragmentByTag);
            }
        }
        Annotation annotation = signature.toAnnotation(lmVarJ, k(), pointF);
        q0 q0Var = this.a;
        q0Var.getClass();
        annotation.getClass();
        ww.a(q0Var.g, annotation);
        annotation.getInternal().setVariant(q0Var.t);
        BuildersKt__Builders_commonKt.launch$default(this.g, null, null, new b(lmVarJ, annotation, this, null), 3, null);
    }

    @Override // com.pspdfkit.internal.d3, com.pspdfkit.internal.gu
    public final void a(q30 q30Var) {
        this.b = q30Var;
        if (ar.b().a(NativeLicenseFeatures.ACRO_FORMS)) {
            Job job = this.h;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.h = BuildersKt__Builders_commonKt.launch$default(this.g, null, null, new w10(this, null), 3, null);
        }
        FragmentManager parentFragmentManager = this.a.f.getParentFragmentManager();
        String str = "com.pspdfkit.internal.SignatureAnnotationCreationMode.SAVED_STATE_FRAGMENT_TAG" + k();
        d00 d00Var = new d00(parentFragmentManager, str, this);
        sk skVar = (sk) parentFragmentManager.findFragmentByTag(str);
        if (skVar != null) {
            skVar.a = this;
            Bundle bundle = skVar.b;
            if (bundle != null) {
                skVar.b = bundle;
                if (onRestoreInstanceState(bundle)) {
                    skVar.b = null;
                }
            }
        }
        this.d = d00Var;
        v10 v10Var = new v10();
        this.i = v10Var;
        this.a.f.addDocumentListener(v10Var);
        this.a.a(this);
    }

    @Override // com.pspdfkit.internal.gu
    public final boolean a(MotionEvent motionEvent) {
        return this.j.a(motionEvent);
    }
}
