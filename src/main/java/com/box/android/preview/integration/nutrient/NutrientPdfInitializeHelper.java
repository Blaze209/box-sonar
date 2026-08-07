package com.box.android.preview.integration.nutrient;

import androidx.fragment.app.FragmentActivity;
import com.box.android.cpl.Store;
import com.box.android.preview.annotations.AnnotationCreationFragmentImpl;
import com.box.android.preview.annotations.AnnotationUpdateListenerImpl;
import com.box.android.preview.annotations.cpl.CreateAnnotationReducer;
import com.box.android.preview.annotations.managers.BoxPdfAnnotationManager;
import com.box.android.preview.annotations.managers.CreateAnnotationsManager;
import com.pspdfkit.ui.PdfFragment;
import com.pspdfkit.ui.PdfUiFragment;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NutrientPdfInitializeHelper.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0011B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001a\u0010\u0004\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00060\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0004\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/integration/nutrient/NutrientPdfInitializeHelper;", "", "pdfUiFragment", "Lcom/pspdfkit/ui/PdfUiFragment;", "getCreateAnnotationStore", "Lkotlin/Function0;", "Lcom/box/android/cpl/Store;", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$State;", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action;", "boxAnnotationManager", "Lcom/box/android/preview/annotations/managers/BoxPdfAnnotationManager;", "createAnnotationsManager", "Lcom/box/android/preview/annotations/managers/CreateAnnotationsManager;", "<init>", "(Lcom/pspdfkit/ui/PdfUiFragment;Lkotlin/jvm/functions/Function0;Lcom/box/android/preview/annotations/managers/BoxPdfAnnotationManager;Lcom/box/android/preview/annotations/managers/CreateAnnotationsManager;)V", "initialize", "", "DocumentPreviewFragmentImpl", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NutrientPdfInitializeHelper {
    public static final int $stable = 8;
    private final BoxPdfAnnotationManager boxAnnotationManager;
    private final CreateAnnotationsManager createAnnotationsManager;
    private final Function0<Store<CreateAnnotationReducer.State, CreateAnnotationReducer.Action>> getCreateAnnotationStore;
    private final PdfUiFragment pdfUiFragment;

    public NutrientPdfInitializeHelper(PdfUiFragment pdfUiFragment, Function0<Store<CreateAnnotationReducer.State, CreateAnnotationReducer.Action>> getCreateAnnotationStore, BoxPdfAnnotationManager boxAnnotationManager, CreateAnnotationsManager createAnnotationsManager) {
        Intrinsics.checkNotNullParameter(pdfUiFragment, "pdfUiFragment");
        Intrinsics.checkNotNullParameter(getCreateAnnotationStore, "getCreateAnnotationStore");
        Intrinsics.checkNotNullParameter(boxAnnotationManager, "boxAnnotationManager");
        Intrinsics.checkNotNullParameter(createAnnotationsManager, "createAnnotationsManager");
        this.pdfUiFragment = pdfUiFragment;
        this.getCreateAnnotationStore = getCreateAnnotationStore;
        this.boxAnnotationManager = boxAnnotationManager;
        this.createAnnotationsManager = createAnnotationsManager;
    }

    public final void initialize() {
        NutrientPdfInitializeHelperKt.hideContextualToolbar(this.pdfUiFragment);
        this.pdfUiFragment.requirePdfFragment().addDrawableProvider(this.boxAnnotationManager);
        this.boxAnnotationManager.setFragment(new DocumentPreviewFragmentImpl(this.pdfUiFragment));
        this.createAnnotationsManager.setFragment(new AnnotationCreationFragmentImpl(this.pdfUiFragment, this.createAnnotationsManager, this.getCreateAnnotationStore));
        this.createAnnotationsManager.setCreatingAnnotationUpdatedListener(new AnnotationUpdateListenerImpl(this.getCreateAnnotationStore, this.pdfUiFragment));
        NutrientPdfInitializeHelperKt.restoreCreateAnnotationState(this.getCreateAnnotationStore.invoke());
    }

    /* JADX INFO: compiled from: NutrientPdfInitializeHelper.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/box/android/preview/integration/nutrient/NutrientPdfInitializeHelper$DocumentPreviewFragmentImpl;", "Lcom/box/android/preview/annotations/managers/BoxPdfAnnotationManager$DocumentPreviewFragment;", "pdfUiFragment", "Lcom/pspdfkit/ui/PdfUiFragment;", "<init>", "(Lcom/pspdfkit/ui/PdfUiFragment;)V", "getPdfFragment", "Lcom/pspdfkit/ui/PdfFragment;", "getPreviewActivity", "Landroidx/fragment/app/FragmentActivity;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class DocumentPreviewFragmentImpl implements BoxPdfAnnotationManager.DocumentPreviewFragment {
        public static final int $stable = 8;
        private final PdfUiFragment pdfUiFragment;

        public DocumentPreviewFragmentImpl(PdfUiFragment pdfUiFragment) {
            Intrinsics.checkNotNullParameter(pdfUiFragment, "pdfUiFragment");
            this.pdfUiFragment = pdfUiFragment;
        }

        @Override // com.box.android.preview.annotations.managers.BoxPdfAnnotationManager.DocumentPreviewFragment
        public PdfFragment getPdfFragment() {
            PdfFragment pdfFragmentRequirePdfFragment = this.pdfUiFragment.requirePdfFragment();
            Intrinsics.checkNotNullExpressionValue(pdfFragmentRequirePdfFragment, "requirePdfFragment(...)");
            return pdfFragmentRequirePdfFragment;
        }

        @Override // com.box.android.preview.annotations.managers.BoxPdfAnnotationManager.DocumentPreviewFragment
        public FragmentActivity getPreviewActivity() {
            FragmentActivity activity = this.pdfUiFragment.getActivity();
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            return activity;
        }
    }
}
