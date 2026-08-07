package com.box.android.preview.integration.nutrient;

import android.view.View;
import android.widget.FrameLayout;
import com.box.android.cpl.Store;
import com.box.android.preview.R;
import com.box.android.preview.annotations.cpl.CreateAnnotationReducer;
import com.box.android.preview.annotations.managers.BoxAnnotationMarkupType;
import com.box.android.preview.annotations.managers.BoxAnnotationTool;
import com.box.android.preview.document.copytext.CopySelectedTextReducer;
import com.box.android.preview.previewtype.document.DocumentPreviewReducer;
import com.box.android.preview.previewtype.document.NutrientPdfViewsOnVisibilityChangeListener;
import com.box.android.preview.previewtype.document.copytext.DocumentTextSelectionListener;
import com.box.android.preview.previewtype.document.copytext.TextSelectionManager;
import com.pspdfkit.ui.PdfOutlineView;
import com.pspdfkit.ui.PdfThumbnailGrid;
import com.pspdfkit.ui.PdfUiFragment;
import com.pspdfkit.ui.search.SearchResultHighlighter;
import com.pspdfkit.ui.toolbar.ContextualToolbar;
import com.pspdfkit.ui.toolbar.ToolbarCoordinatorLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: NutrientPdfInitializeHelper.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a6\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b\u001a\u001e\u0010\f\u001a\u00020\u00012\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0004H\u0002\u001a\f\u0010\u000f\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0010"}, d2 = {"initializeDocumentComponents", "", "Lcom/pspdfkit/ui/PdfUiFragment;", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$State;", "Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action;", "searchResultHighlighter", "Lcom/pspdfkit/ui/search/SearchResultHighlighter;", "citationResultHighlighter", "textSelectionManager", "Lcom/box/android/preview/previewtype/document/copytext/TextSelectionManager;", "restoreCreateAnnotationState", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$State;", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action;", "hideContextualToolbar", "preview_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class NutrientPdfInitializeHelperKt {
    public static final void initializeDocumentComponents(PdfUiFragment pdfUiFragment, Store<DocumentPreviewReducer.State, DocumentPreviewReducer.Action> store, SearchResultHighlighter searchResultHighlighter, SearchResultHighlighter citationResultHighlighter, TextSelectionManager textSelectionManager) {
        FrameLayout frameLayout;
        Intrinsics.checkNotNullParameter(pdfUiFragment, "<this>");
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(searchResultHighlighter, "searchResultHighlighter");
        Intrinsics.checkNotNullParameter(citationResultHighlighter, "citationResultHighlighter");
        Intrinsics.checkNotNullParameter(textSelectionManager, "textSelectionManager");
        pdfUiFragment.requirePdfFragment().addOnTextSelectionChangeListener(new DocumentTextSelectionListener(store.scope(new PropertyReference1Impl() { // from class: com.box.android.preview.integration.nutrient.NutrientPdfInitializeHelperKt.initializeDocumentComponents.1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((DocumentPreviewReducer.State) obj).getCopyTextState();
            }
        }, AnonymousClass2.INSTANCE)));
        pdfUiFragment.requirePdfFragment().addDrawableProvider(searchResultHighlighter);
        pdfUiFragment.requirePdfFragment().addDrawableProvider(citationResultHighlighter);
        textSelectionManager.setFragment(pdfUiFragment);
        View view = pdfUiFragment.getView();
        if (view != null && (frameLayout = (FrameLayout) view.findViewById(R.id.pspdf__activity_content)) != null) {
            frameLayout.setPadding(0, 0, 0, 0);
        }
        View view2 = pdfUiFragment.getView();
        PdfOutlineView pdfOutlineView = view2 != null ? (PdfOutlineView) view2.findViewById(R.id.pspdf__activity_outline_view) : null;
        View view3 = pdfUiFragment.getView();
        PdfThumbnailGrid pdfThumbnailGrid = view3 != null ? (PdfThumbnailGrid) view3.findViewById(R.id.pspdf__activity_thumbnail_grid) : null;
        if (pdfOutlineView != null) {
            pdfOutlineView.setBookmarkAddingEnabled(false);
        }
        if (pdfOutlineView != null) {
            pdfOutlineView.setBookmarkEditingEnabled(false);
        }
        NutrientPdfViewsOnVisibilityChangeListener nutrientPdfViewsOnVisibilityChangeListener = new NutrientPdfViewsOnVisibilityChangeListener(store);
        if (pdfOutlineView != null) {
            pdfOutlineView.addOnVisibilityChangedListener(nutrientPdfViewsOnVisibilityChangeListener);
        }
        if (pdfThumbnailGrid != null) {
            pdfThumbnailGrid.addOnVisibilityChangedListener(nutrientPdfViewsOnVisibilityChangeListener);
        }
    }

    /* JADX INFO: renamed from: com.box.android.preview.integration.nutrient.NutrientPdfInitializeHelperKt$initializeDocumentComponents$2, reason: invalid class name */
    /* JADX INFO: compiled from: NutrientPdfInitializeHelper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<CopySelectedTextReducer.Action, DocumentPreviewReducer.Action.CopyText> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        AnonymousClass2() {
            super(1, DocumentPreviewReducer.Action.CopyText.class, "<init>", "<init>(Lcom/box/android/preview/document/copytext/CopySelectedTextReducer$Action;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final DocumentPreviewReducer.Action.CopyText invoke(CopySelectedTextReducer.Action p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return new DocumentPreviewReducer.Action.CopyText(p0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void restoreCreateAnnotationState(Store<CreateAnnotationReducer.State, CreateAnnotationReducer.Action> store) {
        Integer color;
        BoxAnnotationMarkupType markupType;
        BoxAnnotationTool tool;
        StateFlow<CreateAnnotationReducer.State> state;
        CreateAnnotationReducer.State value = (store == null || (state = store.getState()) == null) ? null : state.getValue();
        if (value != null && (tool = value.getTool()) != null) {
            store.send(new CreateAnnotationReducer.Action.UpdateTool(tool));
        }
        if (value != null && (markupType = value.getMarkupType()) != null) {
            store.send(new CreateAnnotationReducer.Action.UpdateMarkUpType(markupType));
        }
        if (value == null || (color = value.getColor()) == null) {
            return;
        }
        store.send(new CreateAnnotationReducer.Action.UpdateColor(color.intValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hideContextualToolbar(PdfUiFragment pdfUiFragment) {
        pdfUiFragment.setOnContextualToolbarLifecycleListener(new ToolbarCoordinatorLayout.OnContextualToolbarLifecycleListener() { // from class: com.box.android.preview.integration.nutrient.NutrientPdfInitializeHelperKt.hideContextualToolbar.1
            @Override // com.pspdfkit.ui.toolbar.ToolbarCoordinatorLayout.OnContextualToolbarLifecycleListener
            public void onDisplayContextualToolbar(ContextualToolbar<?> toolbar) {
                Intrinsics.checkNotNullParameter(toolbar, "toolbar");
            }

            @Override // com.pspdfkit.ui.toolbar.ToolbarCoordinatorLayout.OnContextualToolbarLifecycleListener
            public void onRemoveContextualToolbar(ContextualToolbar<?> toolbar) {
                Intrinsics.checkNotNullParameter(toolbar, "toolbar");
            }

            @Override // com.pspdfkit.ui.toolbar.ToolbarCoordinatorLayout.OnContextualToolbarLifecycleListener
            public void onPrepareContextualToolbar(ContextualToolbar<?> toolbar) {
                Intrinsics.checkNotNullParameter(toolbar, "toolbar");
                toolbar.setVisibility(8);
            }
        });
    }
}
