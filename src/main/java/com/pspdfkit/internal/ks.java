package com.pspdfkit.internal;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.graphics.ColorUtils;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.configuration.AnnotationConfigurationRegistry;
import com.pspdfkit.annotations.defaults.AnnotationPreferencesManager;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.internal.jni.NativeAnnotation;
import com.pspdfkit.ui.PdfFragment;
import com.pspdfkit.ui.special_mode.controller.AnnotationToolVariant;
import com.pspdfkit.utils.BundleExtensions;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/pspdfkit/internal/ks;", "Lcom/pspdfkit/internal/c2;", "Lcom/pspdfkit/internal/ws$a;", "Lcom/pspdfkit/internal/ws$b;", "<init>", "()V", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ks extends c2 implements ws.a, ws.b {
    public ws i;
    public os j;
    public ts k;
    public Annotation l;

    @DebugMetadata(c = "com.pspdfkit.internal.annotations.editors.NoteEditorFragment$onDestroy$1", f = "NoteEditorFragment.kt", i = {}, l = {91}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ wk b;
        public final /* synthetic */ Annotation c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(wk wkVar, Annotation annotation, Continuation continuation) {
            super(2, continuation);
            this.b = wkVar;
            this.c = annotation;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.b, this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return new a(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objRemoveAnnotationFromPage;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                wk wkVar = this.b;
                Annotation annotation = this.c;
                this.a = 1;
                gm gmVar = wkVar.m;
                gmVar.getClass();
                uw.a(annotation, "annotation", null);
                NativeAnnotation nativeAnnotation = annotation.getInternal().getNativeAnnotation();
                if (nativeAnnotation == null || !gmVar.c.softDeleteCommentRootWithoutChildren(nativeAnnotation) || (objRemoveAnnotationFromPage = wkVar.removeAnnotationFromPage(annotation, this)) != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    objRemoveAnnotationFromPage = Unit.INSTANCE;
                }
                if (objRemoveAnnotationFromPage == coroutine_suspended) {
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

    @Override // com.pspdfkit.internal.c2
    public final void a(Annotation annotation) {
        annotation.getClass();
        this.l = annotation;
        b();
    }

    public final void b() {
        AnnotationToolVariant annotationToolVariant;
        Annotation annotation;
        lm lmVar;
        AnnotationPreferencesManager annotationPreferencesManager;
        PdfConfiguration pdfConfiguration;
        at atVar;
        AnnotationConfigurationRegistry annotationConfigurationRegistry;
        bm internal;
        if (this.j != null || this.l == null) {
            return;
        }
        PdfFragment pdfFragment = this.d;
        AnnotationToolVariant variant = null;
        AnnotationToolVariant activeAnnotationToolVariant = pdfFragment != null ? pdfFragment.getActiveAnnotationToolVariant() : null;
        if (activeAnnotationToolVariant == null) {
            Annotation annotation2 = this.l;
            if (annotation2 != null && (internal = annotation2.getInternal()) != null) {
                variant = internal.getVariant();
            }
            annotationToolVariant = variant;
        } else {
            annotationToolVariant = activeAnnotationToolVariant;
        }
        Context context = getContext();
        if (context == null || (annotation = this.l) == null || (lmVar = this.a) == null || (annotationPreferencesManager = this.h) == null || (pdfConfiguration = this.f) == null || (atVar = this.e) == null || (annotationConfigurationRegistry = this.g) == null || annotationToolVariant == null) {
            return;
        }
        o3 annotationProvider = lmVar.getAnnotationProvider();
        this.j = new os(((annotationProvider instanceof wk) && annotation.getInternal().isInstantCommentThreadRoot()) ? new nl(context, annotation, annotationPreferencesManager, (wk) annotationProvider) : new ms(context, annotation, annotationToolVariant, pdfConfiguration, annotationPreferencesManager, annotationProvider, atVar, annotationConfigurationRegistry));
        c();
    }

    public final void c() {
        ws wsVar;
        os osVar = this.j;
        if (osVar == null || (wsVar = this.i) == null || osVar.b != null) {
            return;
        }
        ts tsVar = this.k;
        osVar.b = wsVar;
        boolean z = true;
        osVar.d = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain().getImmediate()));
        wsVar.setPresenter(osVar);
        wsVar.setToolbarTitle(osVar.a.getTitle());
        int iM = osVar.a.m();
        js jsVar = osVar.b;
        if (jsVar != null) {
            jsVar.b(i9.a(iM, 0.2f), false);
            jsVar.a(iM, false);
            int iArgb = Color.argb(255, Color.red(iM), Color.green(iM), Color.blue(iM));
            int alphaComponent = ColorUtils.calculateContrast(-16777216, iArgb) <= ColorUtils.calculateContrast(-1, iArgb) ? -1 : -16777216;
            int iCalculateMinimumAlpha = ColorUtils.calculateMinimumAlpha(alphaComponent, iArgb, 7.0f);
            if (iCalculateMinimumAlpha >= 0) {
                alphaComponent = ColorUtils.setAlphaComponent(alphaComponent, iCalculateMinimumAlpha);
            }
            jsVar.setToolbarForegroundColor(alphaComponent);
            jsVar.setStatusBarColor(iM);
        }
        js.a aVar = js.a.UNDO;
        vs vsVar = wsVar.d;
        vsVar.getClass();
        MenuItem menuItemA = vsVar.a(aVar);
        if (menuItemA != null) {
            menuItemA.setVisible(false);
        }
        js.a aVar2 = js.a.REDO;
        vs vsVar2 = wsVar.d;
        vsVar2.getClass();
        MenuItem menuItemA2 = vsVar2.a(aVar2);
        if (menuItemA2 != null) {
            menuItemA2.setVisible(false);
        }
        gs gsVar = osVar.a;
        wsVar.a(gsVar.b());
        wsVar.setAddNewReplyBoxDisplayed(gsVar.l());
        wsVar.setStyleBoxDisplayed(gsVar.h());
        wsVar.setStyleBoxPickerColors(gsVar.f() ? gsVar.n() : CollectionsKt.emptyList());
        wsVar.setStyleBoxPickerIcons(gsVar.k() ? gsVar.d() : CollectionsKt.emptyList());
        String strA = osVar.a.a();
        if (strA != null) {
            int iA = ww.a(strA);
            wsVar.setStyleBoxSelectedIcon(strA);
            wsVar.setStyleBoxSelectedColor(iM);
            wsVar.setStyleBoxText(iA);
        }
        osVar.a.a(osVar);
        if (!osVar.a.c() || osVar.a.i()) {
            CoroutineScope coroutineScope = osVar.d;
            if (coroutineScope != null) {
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new ps(osVar, wsVar, null), 3, null);
            }
        } else {
            ds dsVarE = osVar.a.e();
            osVar.b(dsVarE);
            List<? extends ds> listListOf = CollectionsKt.listOf(dsVarE);
            String strG = dsVarE.g();
            if (strG != null && strG.length() != 0) {
                z = false;
            }
            listListOf.getClass();
            wsVar.a.a(listListOf, z);
        }
        if (tsVar != null) {
            Parcelable parcelable = wsVar.i;
            if (parcelable != null) {
                RecyclerView.LayoutManager layoutManager = wsVar.c.getLayoutManager();
                if (layoutManager != null) {
                    layoutManager.onRestoreInstanceState(parcelable);
                }
                wsVar.i = null;
            }
            wsVar.setStyleBoxExpanded(tsVar.a);
        }
        this.k = null;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onAttach(Context context) {
        context.getClass();
        super.onAttach(context);
        b();
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ts tsVar;
        layoutInflater.getClass();
        Context contextRequireContext = requireContext();
        contextRequireContext.getClass();
        ws wsVar = new ws(contextRequireContext);
        wsVar.setOnDismissViewListener(this);
        wsVar.setStatusBarColorCallback(this);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        parentFragmentManager.getClass();
        wsVar.setFragmentManager(parentFragmentManager);
        this.i = wsVar;
        if (bundle != null && (tsVar = (ts) BundleExtensions.getSupportParcelable(bundle, "NoteEditorFragment.PresenterState", ts.class)) != null) {
            this.k = tsVar;
        }
        ws wsVar2 = this.i;
        wsVar2.getClass();
        return wsVar2;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() throws InterruptedException {
        lm lmVar = this.a;
        o3 annotationProvider = lmVar != null ? lmVar.getAnnotationProvider() : null;
        Annotation annotation = this.l;
        if ((annotationProvider instanceof wk) && annotation != null) {
            BuildersKt__BuildersKt.runBlocking$default(null, new a((wk) annotationProvider, annotation, null), 1, null);
        }
        super.onDestroy();
    }

    @Override // com.pspdfkit.internal.c2, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        os osVar;
        js jsVar;
        ts tsVar;
        bundle.getClass();
        super.onSaveInstanceState(bundle);
        a();
        if (this.k == null && (osVar = this.j) != null && (jsVar = osVar.b) != null) {
            if (osVar == null) {
                tsVar = null;
            } else {
                if (jsVar == null) {
                    throw new IllegalStateException("Fetching presenter state while not subscribed");
                }
                tsVar = new ts(jsVar.g());
            }
            this.k = tsVar;
        }
        ts tsVar2 = this.k;
        if (!(tsVar2 instanceof ts)) {
            tsVar2 = null;
        }
        if (tsVar2 != null) {
            bundle.putParcelable("NoteEditorFragment.PresenterState", tsVar2);
            this.k = null;
        }
    }

    @Override // com.pspdfkit.internal.c2, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        c();
        b();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStop() {
        js jsVar;
        super.onStop();
        os osVar = this.j;
        if (osVar == null || (jsVar = osVar.b) == null) {
            return;
        }
        if (jsVar == null) {
            throw new IllegalStateException("Fetching presenter state while not subscribed");
        }
        this.k = new ts(jsVar.g());
        osVar.a.a((hs) null);
        js jsVar2 = osVar.b;
        if (jsVar2 != null) {
            if (!osVar.c) {
                List<ds> noteEditorContentCards = jsVar2.getNoteEditorContentCards();
                ArrayList arrayList = new ArrayList();
                for (Object obj : noteEditorContentCards) {
                    if (((ds) obj).c()) {
                        arrayList.add(obj);
                    }
                }
                osVar.a.a(arrayList);
            }
            jsVar2.setPresenter(null);
            osVar.b = null;
            osVar.c = false;
        }
        CoroutineScope coroutineScope = osVar.d;
        if (coroutineScope != null) {
            CoroutineScopeKt.cancel$default(coroutineScope, null, 1, null);
        }
        osVar.d = null;
        this.j = null;
    }

    @Override // com.pspdfkit.internal.ws.b
    public final void setStatusBarColor(int i) {
        Window window;
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        i9.a(window, i);
    }
}
