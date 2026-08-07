package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.MotionEvent;
import androidx.lifecycle.Lifecycle;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.configuration.AnnotationConfigurationRegistry;
import com.pspdfkit.configuration.activity.PdfActivityConfiguration;
import com.pspdfkit.document.DocumentSaveOptions;
import com.pspdfkit.document.DocumentSource;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.forms.FormElement;
import com.pspdfkit.jetpack.compose.interactors.AnnotationListener;
import com.pspdfkit.jetpack.compose.interactors.DocumentConnection;
import com.pspdfkit.jetpack.compose.interactors.DocumentState;
import com.pspdfkit.jetpack.compose.interactors.FormListener;
import com.pspdfkit.jetpack.compose.interactors.UiListener;
import com.pspdfkit.listeners.DocumentListener;
import com.pspdfkit.listeners.scrolling.DocumentScrollListener;
import com.pspdfkit.listeners.scrolling.ScrollState;
import com.pspdfkit.ui.PSPDFKitViews;
import com.pspdfkit.ui.PdfFragment;
import com.pspdfkit.ui.PdfUi;
import com.pspdfkit.ui.PdfUiFragment;
import com.pspdfkit.ui.UiVisibleCallback;
import com.pspdfkit.ui.search.SearchResultHighlighter;
import com.pspdfkit.ui.special_mode.controller.AnnotationSelectionController;
import com.pspdfkit.ui.special_mode.controller.FormEditingController;
import com.pspdfkit.ui.special_mode.manager.FormManager;
import com.pspdfkit.ui.toolbar.ToolbarCoordinatorLayout;
import com.pspdfkit.utils.PdfLog;
import java.io.IOException;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;

/* JADX INFO: loaded from: classes3.dex */
public final class x9 implements DocumentConnection, DocumentListener, UiVisibleCallback, DocumentScrollListener, FormManager.OnFormElementClickedListener, FormManager.OnFormElementSelectedListener, FormManager.OnFormElementDeselectedListener, FormManager.OnFormElementUpdatedListener, FormManager.OnFormElementEditingModeChangeListener, FormManager.OnFormElementViewUpdatedListener, gc {
    public final PdfUiFragment a;
    public Function0<Unit> b = new Function0() { // from class: com.pspdfkit.internal.x9$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return x9.j();
        }
    };
    public Function1<? super Boolean, Unit> c = new Function1() { // from class: com.pspdfkit.internal.x9$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return x9.a(((Boolean) obj).booleanValue());
        }
    };
    public com.pspdfkit.jetpack.compose.interactors.DocumentListener d = new com.pspdfkit.jetpack.compose.interactors.DocumentListener(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    public AnnotationListener e = new AnnotationListener(null, null, null, null, 15, null);
    public UiListener f = new UiListener(null, null, 3, null);
    public FormListener g = new FormListener(null, null, null, null, null, null, null, null, null, null, null, null, 4095, null);
    public final Function1<Boolean, Unit> h = new Function1() { // from class: com.pspdfkit.internal.x9$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return x9.a(this.f$0, ((Boolean) obj).booleanValue());
        }
    };
    public final p4 i = new p4(new Function3() { // from class: com.pspdfkit.internal.x9$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return Boolean.valueOf(x9.a(this.f$0, (AnnotationSelectionController) obj, (Annotation) obj2, ((Boolean) obj3).booleanValue()));
        }
    }, new Function2() { // from class: com.pspdfkit.internal.x9$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return x9.a(this.f$0, (Annotation) obj, ((Boolean) obj2).booleanValue());
        }
    }, new Function2() { // from class: com.pspdfkit.internal.x9$$ExternalSyntheticLambda5
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return x9.a(this.f$0, (List) obj, ((Boolean) obj2).booleanValue());
        }
    }, new Function2() { // from class: com.pspdfkit.internal.x9$$ExternalSyntheticLambda6
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return x9.b(this.f$0, (Annotation) obj, ((Boolean) obj2).booleanValue());
        }
    });

    public x9(PdfUiFragment pdfUiFragment) {
        this.a = pdfUiFragment;
    }

    public static final Unit b(x9 x9Var, Annotation annotation, boolean z) {
        annotation.getClass();
        Function2<Annotation, Boolean, Unit> onAnnotationDeselected = x9Var.e.getOnAnnotationDeselected();
        if (onAnnotationDeselected != null) {
            onAnnotationDeselected.invoke(annotation, Boolean.valueOf(z));
        }
        return Unit.INSTANCE;
    }

    public static final Unit j() {
        return Unit.INSTANCE;
    }

    @Override // com.pspdfkit.internal.gc
    public final Object a(Context context, DocumentState documentState, ToolbarCoordinatorLayout.OnContextualToolbarLifecycleListener onContextualToolbarLifecycleListener, Function2 function2, Continuation continuation) {
        return a(this, context, documentState, onContextualToolbarLifecycleListener, function2, continuation);
    }

    @Override // com.pspdfkit.jetpack.compose.interactors.DocumentConnection
    public final void addAnnotationToPage(Annotation annotation, boolean z) {
        annotation.getClass();
        PdfFragment pdfFragment = this.a.getPdfFragment();
        if (pdfFragment != null) {
            pdfFragment.addAnnotationToPage(annotation, z);
        }
    }

    @Override // com.pspdfkit.jetpack.compose.interactors.DocumentConnection
    public final void addDrawableProvider(SearchResultHighlighter searchResultHighlighter) {
        searchResultHighlighter.getClass();
        PdfFragment pdfFragment = this.a.getPdfFragment();
        if (pdfFragment != null) {
            pdfFragment.addDrawableProvider(searchResultHighlighter);
        }
    }

    @Override // com.pspdfkit.internal.gc
    public final int c() {
        cw implementation = this.a.getImplementation();
        implementation.getClass();
        return implementation.getContextualToolbarSizePx();
    }

    @Override // com.pspdfkit.internal.gc
    public final Bundle e() {
        PdfFragment pdfFragmentRequirePdfFragment = this.a.requirePdfFragment();
        pdfFragmentRequirePdfFragment.getClass();
        Bundle state = pdfFragmentRequirePdfFragment.getState();
        state.getClass();
        return state;
    }

    @Override // com.pspdfkit.internal.gc
    public final boolean f() {
        cw implementation = this.a.getImplementation();
        implementation.getClass();
        return implementation.isDefaultViewerActive();
    }

    @Override // com.pspdfkit.jetpack.compose.interactors.DocumentConnection
    public final AnnotationConfigurationRegistry getAnnotationConfigurationRegistry() {
        PdfFragment pdfFragmentRequirePdfFragment = this.a.requirePdfFragment();
        pdfFragmentRequirePdfFragment.getClass();
        AnnotationConfigurationRegistry annotationConfiguration = pdfFragmentRequirePdfFragment.getAnnotationConfiguration();
        annotationConfiguration.getClass();
        return annotationConfiguration;
    }

    @Override // com.pspdfkit.internal.gc
    public final DocumentSource getDocumentSource() {
        PdfFragment pdfFragmentRequirePdfFragment = this.a.requirePdfFragment();
        pdfFragmentRequirePdfFragment.getClass();
        PdfDocument document = pdfFragmentRequirePdfFragment.getDocument();
        if (document != null) {
            return document.getDocumentSource();
        }
        return null;
    }

    @Override // com.pspdfkit.jetpack.compose.interactors.DocumentConnection
    public final PSPDFKitViews getPdfActivityViews() {
        return this.a.getPSPDFKitViews();
    }

    @Override // com.pspdfkit.jetpack.compose.interactors.DocumentConnection
    public final PdfUi getPdfUI() {
        return this.a;
    }

    @Override // com.pspdfkit.jetpack.compose.interactors.DocumentConnection
    public final PdfUi getPdfUi() {
        return this.a;
    }

    @Override // com.pspdfkit.jetpack.compose.interactors.DocumentConnection
    public final Function1<Boolean, Unit> getShowToolbarMenu() {
        return this.h;
    }

    @Override // com.pspdfkit.internal.gc
    public final PdfActivityConfiguration h() {
        PdfActivityConfiguration configuration = this.a.getConfiguration();
        configuration.getClass();
        return configuration;
    }

    @Override // com.pspdfkit.jetpack.compose.interactors.DocumentConnection
    public final void highlight(int i, List<? extends RectF> list) {
        list.getClass();
        PdfFragment pdfFragment = this.a.getPdfFragment();
        if (pdfFragment != null) {
            pdfFragment.highlight(pdfFragment.requireContext(), list, i);
        }
    }

    @Override // com.pspdfkit.internal.gc
    public final void i() {
        cw implementation = this.a.getImplementation();
        implementation.getClass();
        implementation.onBackPressed();
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager.OnFormElementClickedListener
    public final boolean isFormElementClickable(FormElement formElement) {
        formElement.getClass();
        Function1<FormElement, Boolean> onIsFormElementClickableListener = this.g.getOnIsFormElementClickableListener();
        if (onIsFormElementClickableListener != null) {
            return onIsFormElementClickableListener.invoke(formElement).booleanValue();
        }
        return true;
    }

    @Override // com.pspdfkit.ui.UiVisibleCallback
    public final void isUiVisible(boolean z) {
        Function1<Boolean, Unit> onUiVisible = this.f.getOnUiVisible();
        if (onUiVisible != null) {
            onUiVisible.invoke(Boolean.valueOf(z));
        }
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager.OnFormElementEditingModeChangeListener
    public final void onChangeFormElementEditingMode(FormEditingController formEditingController) {
        formEditingController.getClass();
        Function1<FormEditingController, Boolean> onChangeFormElementEditingMode = this.g.getOnChangeFormElementEditingMode();
        if (onChangeFormElementEditingMode != null) {
            onChangeFormElementEditingMode.invoke(formEditingController);
        }
    }

    @Override // com.pspdfkit.listeners.DocumentListener
    public final boolean onDocumentClick() {
        Function0<Boolean> onDocumentClick = this.d.getOnDocumentClick();
        if (onDocumentClick != null) {
            return onDocumentClick.invoke().booleanValue();
        }
        return false;
    }

    @Override // com.pspdfkit.listeners.DocumentListener
    public final void onDocumentLoadFailed(Throwable th) {
        th.getClass();
        Function1<Throwable, Unit> onDocumentLoadFailed = this.d.getOnDocumentLoadFailed();
        if (onDocumentLoadFailed != null) {
            onDocumentLoadFailed.invoke(th);
        }
    }

    @Override // com.pspdfkit.listeners.DocumentListener
    public final void onDocumentLoaded(PdfDocument pdfDocument) {
        pdfDocument.getClass();
        this.b.invoke();
        Function1<PdfDocument, Unit> onDocumentLoaded = this.d.getOnDocumentLoaded();
        if (onDocumentLoaded != null) {
            onDocumentLoaded.invoke(pdfDocument);
        } else {
            this.a.onDocumentLoaded(pdfDocument);
        }
        PdfFragment pdfFragmentRequirePdfFragment = this.a.requirePdfFragment();
        pdfFragmentRequirePdfFragment.getClass();
        pdfFragmentRequirePdfFragment.addOnAnnotationSelectedListener(this.i);
        pdfFragmentRequirePdfFragment.addDocumentScrollListener(this);
        pdfFragmentRequirePdfFragment.addOnFormElementClickedListener(this);
        pdfFragmentRequirePdfFragment.addOnFormElementSelectedListener(this);
        pdfFragmentRequirePdfFragment.addOnFormElementDeselectedListener(this);
        pdfFragmentRequirePdfFragment.addOnFormElementUpdatedListener(this);
        pdfFragmentRequirePdfFragment.addOnFormElementEditingModeChangeListener(this);
        pdfFragmentRequirePdfFragment.addOnFormElementViewUpdatedListener(this);
        cw implementation = this.a.getImplementation();
        implementation.getClass();
        implementation.setUiVisibleCallback(this);
    }

    @Override // com.pspdfkit.listeners.DocumentListener
    public final boolean onDocumentSave(PdfDocument pdfDocument, DocumentSaveOptions documentSaveOptions) {
        pdfDocument.getClass();
        documentSaveOptions.getClass();
        Function2<PdfDocument, DocumentSaveOptions, Boolean> onDocumentSave = this.d.getOnDocumentSave();
        if (onDocumentSave != null) {
            return onDocumentSave.invoke(pdfDocument, documentSaveOptions).booleanValue();
        }
        return true;
    }

    @Override // com.pspdfkit.listeners.DocumentListener
    public final void onDocumentSaveCancelled(PdfDocument pdfDocument) {
        Function1<PdfDocument, Unit> onDocumentSaveCancelled = this.d.getOnDocumentSaveCancelled();
        if (onDocumentSaveCancelled != null) {
            onDocumentSaveCancelled.invoke(pdfDocument);
        }
    }

    @Override // com.pspdfkit.listeners.DocumentListener
    public final void onDocumentSaveFailed(PdfDocument pdfDocument, Throwable th) {
        pdfDocument.getClass();
        th.getClass();
        Function2<PdfDocument, Throwable, Unit> onDocumentSaveFailed = this.d.getOnDocumentSaveFailed();
        if (onDocumentSaveFailed != null) {
            onDocumentSaveFailed.invoke(pdfDocument, th);
        }
    }

    @Override // com.pspdfkit.listeners.DocumentListener
    public final void onDocumentSaved(PdfDocument pdfDocument) {
        pdfDocument.getClass();
        Function1<PdfDocument, Unit> onDocumentSaved = this.d.getOnDocumentSaved();
        if (onDocumentSaved != null) {
            onDocumentSaved.invoke(pdfDocument);
        }
    }

    @Override // com.pspdfkit.listeners.scrolling.DocumentScrollListener
    public final void onDocumentScrolled(int i, int i2, int i3, int i4, int i5, int i6) {
    }

    @Override // com.pspdfkit.listeners.DocumentListener
    public final void onDocumentZoomed(PdfDocument pdfDocument, int i, float f) {
        pdfDocument.getClass();
        Function3<PdfDocument, Integer, Float, Unit> onDocumentZoomed = this.d.getOnDocumentZoomed();
        if (onDocumentZoomed != null) {
            onDocumentZoomed.invoke(pdfDocument, Integer.valueOf(i), Float.valueOf(f));
        }
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager.OnFormElementEditingModeChangeListener
    public final void onEnterFormElementEditingMode(FormEditingController formEditingController) {
        formEditingController.getClass();
        Function1<FormEditingController, Boolean> onEnterFormElementEditingMode = this.g.getOnEnterFormElementEditingMode();
        if (onEnterFormElementEditingMode != null) {
            onEnterFormElementEditingMode.invoke(formEditingController);
        }
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager.OnFormElementEditingModeChangeListener
    public final void onExitFormElementEditingMode(FormEditingController formEditingController) {
        formEditingController.getClass();
        Function1<FormEditingController, Boolean> onExitFormElementEditingMode = this.g.getOnExitFormElementEditingMode();
        if (onExitFormElementEditingMode != null) {
            onExitFormElementEditingMode.invoke(formEditingController);
        }
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager.OnFormElementClickedListener
    public final boolean onFormElementClicked(FormElement formElement) {
        formElement.getClass();
        Function1<FormElement, Boolean> onFormElementClickedListener = this.g.getOnFormElementClickedListener();
        if (onFormElementClickedListener != null) {
            return onFormElementClickedListener.invoke(formElement).booleanValue();
        }
        return false;
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager.OnFormElementDeselectedListener
    public final void onFormElementDeselected(FormElement formElement, boolean z) {
        formElement.getClass();
        Function2<FormElement, Boolean, Boolean> onFormElementDeselectedListener = this.g.getOnFormElementDeselectedListener();
        if (onFormElementDeselectedListener != null) {
            onFormElementDeselectedListener.invoke(formElement, Boolean.valueOf(z));
        }
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager.OnFormElementSelectedListener
    public final void onFormElementSelected(FormElement formElement) {
        formElement.getClass();
        Function1<FormElement, Boolean> onFormElementSelectedListener = this.g.getOnFormElementSelectedListener();
        if (onFormElementSelectedListener != null) {
            onFormElementSelectedListener.invoke(formElement);
        }
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager.OnFormElementUpdatedListener
    public final void onFormElementUpdated(FormElement formElement) {
        formElement.getClass();
        Function1<FormElement, Boolean> onFormElementUpdatedListener = this.g.getOnFormElementUpdatedListener();
        if (onFormElementUpdatedListener != null) {
            onFormElementUpdatedListener.invoke(formElement);
        }
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager.OnFormElementViewUpdatedListener
    public final void onFormElementValidationFailed(FormElement formElement, String str) {
        formElement.getClass();
        str.getClass();
        Function2<FormElement, String, Boolean> onFormElementValidationFailed = this.g.getOnFormElementValidationFailed();
        if (onFormElementValidationFailed != null) {
            onFormElementValidationFailed.invoke(formElement, str);
        }
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager.OnFormElementViewUpdatedListener
    public final void onFormElementValidationSuccess(FormElement formElement) {
        formElement.getClass();
        Function1<FormElement, Boolean> onFormElementValidationSuccess = this.g.getOnFormElementValidationSuccess();
        if (onFormElementValidationSuccess != null) {
            onFormElementValidationSuccess.invoke(formElement);
        }
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager.OnFormElementViewUpdatedListener
    public final void onFormElementViewUpdated(FormElement formElement) {
        formElement.getClass();
        Function1<FormElement, Boolean> onFormElementViewUpdatedListener = this.g.getOnFormElementViewUpdatedListener();
        if (onFormElementViewUpdatedListener != null) {
            onFormElementViewUpdatedListener.invoke(formElement);
        }
    }

    @Override // com.pspdfkit.listeners.DocumentListener
    public final void onPageChanged(PdfDocument pdfDocument, int i) {
        pdfDocument.getClass();
        Function2<PdfDocument, Integer, Unit> onPageChanged = this.d.getOnPageChanged();
        if (onPageChanged != null) {
            onPageChanged.invoke(pdfDocument, Integer.valueOf(i));
        }
    }

    @Override // com.pspdfkit.listeners.DocumentListener
    public final boolean onPageClick(PdfDocument pdfDocument, int i, MotionEvent motionEvent, PointF pointF, Annotation annotation) {
        pdfDocument.getClass();
        Function5<PdfDocument, Integer, MotionEvent, PointF, Annotation, Boolean> onPageClick = this.d.getOnPageClick();
        if (onPageClick != null) {
            return onPageClick.invoke(pdfDocument, Integer.valueOf(i), motionEvent, pointF, annotation).booleanValue();
        }
        return false;
    }

    @Override // com.pspdfkit.listeners.DocumentListener
    public final void onPageUpdated(PdfDocument pdfDocument, int i) {
        pdfDocument.getClass();
        Function2<PdfDocument, Integer, Unit> onPageUpdated = this.d.getOnPageUpdated();
        if (onPageUpdated != null) {
            onPageUpdated.invoke(pdfDocument, Integer.valueOf(i));
        }
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager.OnFormElementSelectedListener
    public final boolean onPrepareFormElementSelection(FormElement formElement) {
        formElement.getClass();
        Function1<FormElement, Boolean> onPrepareFormElementSelection = this.g.getOnPrepareFormElementSelection();
        if (onPrepareFormElementSelection != null) {
            return onPrepareFormElementSelection.invoke(formElement).booleanValue();
        }
        return false;
    }

    @Override // com.pspdfkit.listeners.scrolling.DocumentScrollListener
    public final void onScrollStateChanged(ScrollState scrollState) {
        scrollState.getClass();
        Function1<ScrollState, Unit> onDocumentScroll = this.f.getOnDocumentScroll();
        if (onDocumentScroll != null) {
            onDocumentScroll.invoke(scrollState);
        }
    }

    @Override // com.pspdfkit.jetpack.compose.interactors.DocumentConnection
    public final void save(String str, DocumentSaveOptions documentSaveOptions) throws IOException {
        PdfDocument document;
        PdfFragment pdfFragment = this.a.getPdfFragment();
        if (pdfFragment == null || (document = pdfFragment.getDocument()) == null) {
            return;
        }
        lm lmVar = (lm) document;
        if (documentSaveOptions == null) {
            documentSaveOptions = lmVar.a(true);
        }
        if (str != null) {
            lmVar.save(str, documentSaveOptions);
        } else {
            lmVar.a(documentSaveOptions);
        }
    }

    @Override // com.pspdfkit.jetpack.compose.interactors.DocumentConnection
    public final void setPageIndex(int i) {
        Lifecycle lifecycleRegistry;
        Lifecycle.State state;
        PdfFragment pdfFragment;
        PdfFragment pdfFragment2 = this.a.getPdfFragment();
        if (pdfFragment2 == null || (lifecycleRegistry = pdfFragment2.getLifecycleRegistry()) == null || (state = lifecycleRegistry.getState()) == null || !state.isAtLeast(Lifecycle.State.CREATED) || (pdfFragment = this.a.getPdfFragment()) == null) {
            return;
        }
        pdfFragment.setPageIndex(i);
    }

    public static final Unit a(boolean z) {
        return Unit.INSTANCE;
    }

    public static final boolean a(x9 x9Var, AnnotationSelectionController annotationSelectionController, Annotation annotation, boolean z) {
        annotationSelectionController.getClass();
        annotation.getClass();
        Function3<AnnotationSelectionController, Annotation, Boolean, Boolean> onPrepareAnnotationSelection = x9Var.e.getOnPrepareAnnotationSelection();
        if (onPrepareAnnotationSelection != null) {
            return onPrepareAnnotationSelection.invoke(annotationSelectionController, annotation, Boolean.valueOf(z)).booleanValue();
        }
        return true;
    }

    @Override // com.pspdfkit.internal.gc
    public final void b() {
        cw implementation = this.a.getImplementation();
        implementation.getClass();
        implementation.exitCurrentState();
    }

    @Override // com.pspdfkit.internal.gc
    public final void b(int i) {
        cw implementation = this.a.getImplementation();
        implementation.getClass();
        implementation.onOptionsItemSelectedById(i);
    }

    public static final Unit a(x9 x9Var, Annotation annotation, boolean z) {
        annotation.getClass();
        Function2<Annotation, Boolean, Unit> onAnnotationSelected = x9Var.e.getOnAnnotationSelected();
        if (onAnnotationSelected != null) {
            onAnnotationSelected.invoke(annotation, Boolean.valueOf(z));
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(x9 x9Var, List list, boolean z) {
        list.getClass();
        Function2<List<? extends Annotation>, Boolean, Unit> onAnnotationSelectionFinished = x9Var.e.getOnAnnotationSelectionFinished();
        if (onAnnotationSelectionFinished != null) {
            onAnnotationSelectionFinished.invoke(list, Boolean.valueOf(z));
        }
        return Unit.INSTANCE;
    }

    @Override // com.pspdfkit.internal.gc
    public final void a(DocumentSource documentSource) {
        try {
            PdfFragment pdfFragmentRequirePdfFragment = this.a.requirePdfFragment();
            pdfFragmentRequirePdfFragment.getClass();
            if (documentSource == null) {
                PdfDocument document = pdfFragmentRequirePdfFragment.getDocument();
                documentSource = document != null ? document.getDocumentSource() : null;
                if (documentSource == null) {
                    return;
                }
            }
            pdfFragmentRequirePdfFragment.setCustomPdfSource(documentSource);
        } catch (Exception e) {
            PdfLog.w("setCustomPdfSource", e.getLocalizedMessage(), new Object[0]);
        }
    }

    @Override // com.pspdfkit.internal.gc
    public final void a(Bundle bundle) {
        if (bundle != null) {
            PdfFragment pdfFragmentRequirePdfFragment = this.a.requirePdfFragment();
            pdfFragmentRequirePdfFragment.getClass();
            pdfFragmentRequirePdfFragment.setState(bundle);
        }
    }

    @Override // com.pspdfkit.internal.gc
    public final void a(int i) {
        cw implementation = this.a.getImplementation();
        implementation.getClass();
        implementation.setContentViewTopPadding(i);
    }

    public static final Unit a(x9 x9Var, boolean z) {
        x9Var.c.invoke(Boolean.valueOf(z));
        return Unit.INSTANCE;
    }

    @Override // com.pspdfkit.internal.gc
    public final void a(PdfActivityConfiguration pdfActivityConfiguration) {
        pdfActivityConfiguration.getClass();
        this.a.setConfiguration(pdfActivityConfiguration);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static Object a(x9 x9Var, Context context, DocumentState documentState, ToolbarCoordinatorLayout.OnContextualToolbarLifecycleListener onContextualToolbarLifecycleListener, Function2 function2, Continuation continuation) {
        w9 w9Var;
        if (continuation instanceof w9) {
            w9Var = (w9) continuation;
            int i = w9Var.i;
            if ((i & Integer.MIN_VALUE) != 0) {
                w9Var.i = i - Integer.MIN_VALUE;
            } else {
                w9Var = new w9(x9Var, continuation);
            }
        } else {
            w9Var = new w9(x9Var, continuation);
        }
        Object obj = w9Var.g;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = w9Var.i;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            PdfActivityConfiguration configuration = x9Var.a.getConfiguration();
            configuration.getClass();
            bv bvVar = new bv(context, configuration);
            bvVar.d = x9Var.a.getDocument();
            w9Var.a = x9Var;
            w9Var.b = SpillingKt.nullOutSpilledVariable(context);
            w9Var.c = documentState;
            w9Var.d = onContextualToolbarLifecycleListener;
            w9Var.e = SpillingKt.nullOutSpilledVariable(function2);
            w9Var.f = SpillingKt.nullOutSpilledVariable(bvVar);
            w9Var.i = 1;
            if (function2.invoke(bvVar, w9Var) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            onContextualToolbarLifecycleListener = w9Var.d;
            documentState = w9Var.c;
            x9Var = w9Var.a;
            ResultKt.throwOnFailure(obj);
        }
        x9Var.a.getPSPDFKitViews().addOnVisibilityChangedListener(documentState);
        if (onContextualToolbarLifecycleListener != null) {
            cw implementation = x9Var.a.getImplementation();
            implementation.getClass();
            implementation.setOnContextualToolbarLifecycleListener(onContextualToolbarLifecycleListener);
        }
        return Unit.INSTANCE;
    }
}
