package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.MotionEvent;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.configuration.AnnotationConfigurationRegistry;
import com.pspdfkit.configuration.activity.PdfActivityConfiguration;
import com.pspdfkit.document.DocumentSaveOptions;
import com.pspdfkit.document.DocumentSource;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.forms.FormElement;
import com.pspdfkit.instant.document.InstantDocumentState;
import com.pspdfkit.instant.document.InstantPdfDocument;
import com.pspdfkit.instant.exceptions.InstantException;
import com.pspdfkit.instant.listeners.InstantDocumentListener;
import com.pspdfkit.instant.ui.InstantPdfUiFragment;
import com.pspdfkit.jetpack.compose.interactors.DocumentConnection;
import com.pspdfkit.jetpack.compose.interactors.DocumentState;
import com.pspdfkit.listeners.DocumentListener;
import com.pspdfkit.listeners.scrolling.DocumentScrollListener;
import com.pspdfkit.listeners.scrolling.ScrollState;
import com.pspdfkit.ui.PSPDFKitViews;
import com.pspdfkit.ui.PdfFragment;
import com.pspdfkit.ui.PdfUi;
import com.pspdfkit.ui.UiVisibleCallback;
import com.pspdfkit.ui.search.SearchResultHighlighter;
import com.pspdfkit.ui.special_mode.controller.FormEditingController;
import com.pspdfkit.ui.special_mode.manager.FormManager;
import com.pspdfkit.ui.toolbar.ToolbarCoordinatorLayout;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/pspdfkit/internal/u9;", "Lcom/pspdfkit/instant/ui/InstantPdfUiFragment;", "", "Lcom/pspdfkit/instant/listeners/InstantDocumentListener;", "<init>", "()V", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class u9 extends InstantPdfUiFragment implements DocumentConnection, DocumentListener, UiVisibleCallback, DocumentScrollListener, FormManager.OnFormElementClickedListener, FormManager.OnFormElementSelectedListener, FormManager.OnFormElementDeselectedListener, FormManager.OnFormElementUpdatedListener, FormManager.OnFormElementEditingModeChangeListener, FormManager.OnFormElementViewUpdatedListener, gc, InstantDocumentListener {
    public final x9 a = new x9(this);
    public com.pspdfkit.jetpack.compose.interactors.InstantDocumentListener b = new com.pspdfkit.jetpack.compose.interactors.InstantDocumentListener(null, null, null, null, null, null, null, null, 255, null);

    @Override // com.pspdfkit.internal.gc
    public final void a(DocumentSource documentSource) {
        this.a.a(documentSource);
    }

    @Override // com.pspdfkit.jetpack.compose.interactors.DocumentConnection
    public final void addAnnotationToPage(Annotation annotation, boolean z) {
        annotation.getClass();
        this.a.addAnnotationToPage(annotation, z);
    }

    @Override // com.pspdfkit.jetpack.compose.interactors.DocumentConnection
    public final void addDrawableProvider(SearchResultHighlighter searchResultHighlighter) {
        searchResultHighlighter.getClass();
        this.a.addDrawableProvider(searchResultHighlighter);
    }

    @Override // com.pspdfkit.internal.gc
    public final void b(int i) {
        cw implementation = this.a.a.getImplementation();
        implementation.getClass();
        implementation.onOptionsItemSelectedById(i);
    }

    @Override // com.pspdfkit.internal.gc
    public final int c() {
        cw implementation = this.a.a.getImplementation();
        implementation.getClass();
        return implementation.getContextualToolbarSizePx();
    }

    @Override // com.pspdfkit.internal.gc
    public final Bundle e() {
        return this.a.e();
    }

    @Override // com.pspdfkit.internal.gc
    public final boolean f() {
        cw implementation = this.a.a.getImplementation();
        implementation.getClass();
        return implementation.isDefaultViewerActive();
    }

    @Override // com.pspdfkit.jetpack.compose.interactors.DocumentConnection
    public final AnnotationConfigurationRegistry getAnnotationConfigurationRegistry() {
        return this.a.getAnnotationConfigurationRegistry();
    }

    @Override // com.pspdfkit.internal.gc
    public final DocumentSource getDocumentSource() {
        return this.a.getDocumentSource();
    }

    @Override // com.pspdfkit.jetpack.compose.interactors.DocumentConnection
    public final PSPDFKitViews getPdfActivityViews() {
        return this.a.a.getPSPDFKitViews();
    }

    @Override // com.pspdfkit.jetpack.compose.interactors.DocumentConnection
    public final PdfUi getPdfUI() {
        return this.a.a;
    }

    @Override // com.pspdfkit.jetpack.compose.interactors.DocumentConnection
    public final PdfUi getPdfUi() {
        return this.a.a;
    }

    @Override // com.pspdfkit.jetpack.compose.interactors.DocumentConnection
    public final Function1<Boolean, Unit> getShowToolbarMenu() {
        return this.a.h;
    }

    @Override // com.pspdfkit.internal.gc
    public final PdfActivityConfiguration h() {
        PdfActivityConfiguration configuration = this.a.a.getConfiguration();
        configuration.getClass();
        return configuration;
    }

    @Override // com.pspdfkit.jetpack.compose.interactors.DocumentConnection
    public final void highlight(int i, List<? extends RectF> list) {
        list.getClass();
        this.a.highlight(i, list);
    }

    @Override // com.pspdfkit.internal.gc
    public final void i() {
        cw implementation = this.a.a.getImplementation();
        implementation.getClass();
        implementation.onBackPressed();
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager.OnFormElementClickedListener
    public final boolean isFormElementClickable(FormElement formElement) {
        formElement.getClass();
        return this.a.isFormElementClickable(formElement);
    }

    @Override // com.pspdfkit.ui.UiVisibleCallback
    public final void isUiVisible(boolean z) {
        this.a.isUiVisible(z);
    }

    @Override // com.pspdfkit.instant.ui.InstantPdfUiFragment, com.pspdfkit.instant.listeners.InstantDocumentListener
    public final void onAuthenticationFailed(InstantPdfDocument instantPdfDocument, InstantException instantException) {
        instantPdfDocument.getClass();
        instantException.getClass();
        Function2<InstantPdfDocument, InstantException, Unit> onAuthenticationFailed = this.b.getOnAuthenticationFailed();
        if (onAuthenticationFailed != null) {
            onAuthenticationFailed.invoke(instantPdfDocument, instantException);
        }
    }

    @Override // com.pspdfkit.instant.ui.InstantPdfUiFragment, com.pspdfkit.instant.listeners.InstantDocumentListener
    public final void onAuthenticationFinished(InstantPdfDocument instantPdfDocument, String str) {
        instantPdfDocument.getClass();
        str.getClass();
        Function2<InstantPdfDocument, String, Unit> onAuthenticationFinished = this.b.getOnAuthenticationFinished();
        if (onAuthenticationFinished != null) {
            onAuthenticationFinished.invoke(instantPdfDocument, str);
        }
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager.OnFormElementEditingModeChangeListener
    public final void onChangeFormElementEditingMode(FormEditingController formEditingController) {
        formEditingController.getClass();
        this.a.onChangeFormElementEditingMode(formEditingController);
    }

    @Override // com.pspdfkit.ui.PdfUiFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        x9 x9Var = this.a;
        PdfFragment pdfFragmentRequirePdfFragment = x9Var.a.requirePdfFragment();
        pdfFragmentRequirePdfFragment.getClass();
        pdfFragmentRequirePdfFragment.removeOnAnnotationSelectedListener(x9Var.i);
        pdfFragmentRequirePdfFragment.removeDocumentScrollListener(x9Var);
        pdfFragmentRequirePdfFragment.removeOnFormElementClickedListener(x9Var);
        pdfFragmentRequirePdfFragment.removeOnFormElementSelectedListener(x9Var);
        pdfFragmentRequirePdfFragment.removeOnFormElementDeselectedListener(x9Var);
        pdfFragmentRequirePdfFragment.removeOnFormElementUpdatedListener(x9Var);
        pdfFragmentRequirePdfFragment.removeOnFormElementEditingModeChangeListener(x9Var);
        pdfFragmentRequirePdfFragment.removeOnFormElementViewUpdatedListener(x9Var);
        getImplementation().onDestroy();
    }

    @Override // com.pspdfkit.listeners.DocumentListener
    public final boolean onDocumentClick() {
        return this.a.onDocumentClick();
    }

    @Override // com.pspdfkit.instant.ui.InstantPdfUiFragment, com.pspdfkit.instant.listeners.InstantDocumentListener
    public final void onDocumentCorrupted(InstantPdfDocument instantPdfDocument) {
        instantPdfDocument.getClass();
        Function1<InstantPdfDocument, Unit> onDocumentCorrupted = this.b.getOnDocumentCorrupted();
        if (onDocumentCorrupted != null) {
            onDocumentCorrupted.invoke(instantPdfDocument);
        }
    }

    @Override // com.pspdfkit.instant.ui.InstantPdfUiFragment, com.pspdfkit.instant.listeners.InstantDocumentListener
    public final void onDocumentInvalidated(InstantPdfDocument instantPdfDocument) {
        instantPdfDocument.getClass();
        Function1<InstantPdfDocument, Unit> onDocumentInvalidated = this.b.getOnDocumentInvalidated();
        if (onDocumentInvalidated != null) {
            onDocumentInvalidated.invoke(instantPdfDocument);
        }
    }

    @Override // com.pspdfkit.listeners.DocumentListener
    public final void onDocumentLoadFailed(Throwable th) {
        th.getClass();
        this.a.onDocumentLoadFailed(th);
    }

    @Override // com.pspdfkit.listeners.DocumentListener
    public final void onDocumentLoaded(PdfDocument pdfDocument) {
        pdfDocument.getClass();
        this.a.onDocumentLoaded(pdfDocument);
    }

    @Override // com.pspdfkit.listeners.DocumentListener
    public final boolean onDocumentSave(PdfDocument pdfDocument, DocumentSaveOptions documentSaveOptions) {
        pdfDocument.getClass();
        documentSaveOptions.getClass();
        return this.a.onDocumentSave(pdfDocument, documentSaveOptions);
    }

    @Override // com.pspdfkit.listeners.DocumentListener
    public final void onDocumentSaveCancelled(PdfDocument pdfDocument) {
        this.a.onDocumentSaveCancelled(pdfDocument);
    }

    @Override // com.pspdfkit.listeners.DocumentListener
    public final void onDocumentSaveFailed(PdfDocument pdfDocument, Throwable th) {
        pdfDocument.getClass();
        th.getClass();
        this.a.onDocumentSaveFailed(pdfDocument, th);
    }

    @Override // com.pspdfkit.listeners.DocumentListener
    public final void onDocumentSaved(PdfDocument pdfDocument) {
        pdfDocument.getClass();
        this.a.onDocumentSaved(pdfDocument);
    }

    @Override // com.pspdfkit.listeners.scrolling.DocumentScrollListener
    public final void onDocumentScrolled(int i, int i2, int i3, int i4, int i5, int i6) {
        this.a.getClass();
    }

    @Override // com.pspdfkit.instant.ui.InstantPdfUiFragment, com.pspdfkit.instant.listeners.InstantDocumentListener
    public final void onDocumentStateChanged(InstantPdfDocument instantPdfDocument, InstantDocumentState instantDocumentState) {
        instantPdfDocument.getClass();
        instantDocumentState.getClass();
        Function2<InstantPdfDocument, InstantDocumentState, Unit> onDocumentStateChanged = this.b.getOnDocumentStateChanged();
        if (onDocumentStateChanged != null) {
            onDocumentStateChanged.invoke(instantPdfDocument, instantDocumentState);
        }
    }

    @Override // com.pspdfkit.listeners.DocumentListener
    public final void onDocumentZoomed(PdfDocument pdfDocument, int i, float f) {
        pdfDocument.getClass();
        this.a.onDocumentZoomed(pdfDocument, i, f);
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager.OnFormElementEditingModeChangeListener
    public final void onEnterFormElementEditingMode(FormEditingController formEditingController) {
        formEditingController.getClass();
        this.a.onEnterFormElementEditingMode(formEditingController);
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager.OnFormElementEditingModeChangeListener
    public final void onExitFormElementEditingMode(FormEditingController formEditingController) {
        formEditingController.getClass();
        this.a.onExitFormElementEditingMode(formEditingController);
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager.OnFormElementClickedListener
    public final boolean onFormElementClicked(FormElement formElement) {
        formElement.getClass();
        return this.a.onFormElementClicked(formElement);
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager.OnFormElementDeselectedListener
    public final void onFormElementDeselected(FormElement formElement, boolean z) {
        formElement.getClass();
        this.a.onFormElementDeselected(formElement, z);
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager.OnFormElementSelectedListener
    public final void onFormElementSelected(FormElement formElement) {
        formElement.getClass();
        this.a.onFormElementSelected(formElement);
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager.OnFormElementUpdatedListener
    public final void onFormElementUpdated(FormElement formElement) {
        formElement.getClass();
        this.a.onFormElementUpdated(formElement);
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager.OnFormElementViewUpdatedListener
    public final void onFormElementValidationFailed(FormElement formElement, String str) {
        formElement.getClass();
        str.getClass();
        this.a.onFormElementValidationFailed(formElement, str);
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager.OnFormElementViewUpdatedListener
    public final void onFormElementValidationSuccess(FormElement formElement) {
        formElement.getClass();
        this.a.onFormElementValidationSuccess(formElement);
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager.OnFormElementViewUpdatedListener
    public final void onFormElementViewUpdated(FormElement formElement) {
        formElement.getClass();
        this.a.onFormElementViewUpdated(formElement);
    }

    @Override // com.pspdfkit.listeners.DocumentListener
    public final void onPageChanged(PdfDocument pdfDocument, int i) {
        pdfDocument.getClass();
        this.a.onPageChanged(pdfDocument, i);
    }

    @Override // com.pspdfkit.listeners.DocumentListener
    public final boolean onPageClick(PdfDocument pdfDocument, int i, MotionEvent motionEvent, PointF pointF, Annotation annotation) {
        pdfDocument.getClass();
        return this.a.onPageClick(pdfDocument, i, motionEvent, pointF, annotation);
    }

    @Override // com.pspdfkit.listeners.DocumentListener
    public final void onPageUpdated(PdfDocument pdfDocument, int i) {
        pdfDocument.getClass();
        this.a.onPageUpdated(pdfDocument, i);
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager.OnFormElementSelectedListener
    public final boolean onPrepareFormElementSelection(FormElement formElement) {
        formElement.getClass();
        return this.a.onPrepareFormElementSelection(formElement);
    }

    @Override // com.pspdfkit.listeners.scrolling.DocumentScrollListener
    public final void onScrollStateChanged(ScrollState scrollState) {
        scrollState.getClass();
        this.a.onScrollStateChanged(scrollState);
    }

    @Override // com.pspdfkit.instant.ui.InstantPdfUiFragment, com.pspdfkit.instant.listeners.InstantDocumentListener
    public final void onSyncError(InstantPdfDocument instantPdfDocument, InstantException instantException) {
        instantPdfDocument.getClass();
        instantException.getClass();
        Function2<InstantPdfDocument, InstantException, Unit> onSyncError = this.b.getOnSyncError();
        if (onSyncError != null) {
            onSyncError.invoke(instantPdfDocument, instantException);
        }
    }

    @Override // com.pspdfkit.instant.ui.InstantPdfUiFragment, com.pspdfkit.instant.listeners.InstantDocumentListener
    public final void onSyncFinished(InstantPdfDocument instantPdfDocument) {
        instantPdfDocument.getClass();
        Function1<InstantPdfDocument, Unit> onSyncFinished = this.b.getOnSyncFinished();
        if (onSyncFinished != null) {
            onSyncFinished.invoke(instantPdfDocument);
        }
    }

    @Override // com.pspdfkit.instant.ui.InstantPdfUiFragment, com.pspdfkit.instant.listeners.InstantDocumentListener
    public final void onSyncStarted(InstantPdfDocument instantPdfDocument) {
        instantPdfDocument.getClass();
        Function1<InstantPdfDocument, Unit> onSyncStarted = this.b.getOnSyncStarted();
        if (onSyncStarted != null) {
            onSyncStarted.invoke(instantPdfDocument);
        }
    }

    @Override // com.pspdfkit.jetpack.compose.interactors.DocumentConnection
    public final void save(String str, DocumentSaveOptions documentSaveOptions) throws IOException {
        this.a.save(str, documentSaveOptions);
    }

    @Override // com.pspdfkit.ui.PdfUi, com.pspdfkit.jetpack.compose.interactors.DocumentConnection
    public final void setPageIndex(int i) {
        this.a.setPageIndex(i);
    }

    @Override // com.pspdfkit.internal.gc
    public final void a(Bundle bundle) {
        this.a.a(bundle);
    }

    @Override // com.pspdfkit.internal.gc
    public final void a(PdfActivityConfiguration pdfActivityConfiguration) {
        pdfActivityConfiguration.getClass();
        x9 x9Var = this.a;
        x9Var.getClass();
        x9Var.a.setConfiguration(pdfActivityConfiguration);
    }

    @Override // com.pspdfkit.internal.gc
    public final Object a(Context context, DocumentState documentState, ToolbarCoordinatorLayout.OnContextualToolbarLifecycleListener onContextualToolbarLifecycleListener, Function2 function2, Continuation continuation) {
        x9 x9Var = this.a;
        x9Var.getClass();
        Object objA = x9.a(x9Var, context, documentState, onContextualToolbarLifecycleListener, function2, continuation);
        return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Unit.INSTANCE;
    }

    @Override // com.pspdfkit.internal.gc
    public final void b() {
        cw implementation = this.a.a.getImplementation();
        implementation.getClass();
        implementation.exitCurrentState();
    }

    @Override // com.pspdfkit.internal.gc
    public final void a(int i) {
        cw implementation = this.a.a.getImplementation();
        implementation.getClass();
        implementation.setContentViewTopPadding(i);
    }
}
