package com.pspdfkit.ui;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.listeners.OnVisibilityChangedListener;
import com.pspdfkit.ui.audio.AudioView;
import com.pspdfkit.ui.contentediting.ContentEditingStylingBar;
import com.pspdfkit.ui.forms.FormEditingBar;
import com.pspdfkit.ui.redaction.RedactionView;
import com.pspdfkit.ui.scale.MeasurementScaleView;
import com.pspdfkit.ui.search.PdfSearchView;
import com.pspdfkit.ui.tabs.PdfTabBar;

/* JADX INFO: loaded from: classes3.dex */
public interface PSPDFKitViews {

    public interface PSPDFView {
        void addOnVisibilityChangedListener(OnVisibilityChangedListener onVisibilityChangedListener);

        void clearDocument();

        Type getPSPDFViewType();

        void hide();

        boolean isDisplayed();

        void removeOnVisibilityChangedListener(OnVisibilityChangedListener onVisibilityChangedListener);

        void setDocument(PdfDocument pdfDocument, PdfConfiguration pdfConfiguration);

        void show();
    }

    public enum Type {
        VIEW_NONE,
        VIEW_THUMBNAIL_GRID,
        VIEW_SEARCH,
        VIEW_OUTLINE,
        VIEW_DOCUMENT_INFO,
        VIEW_THUMBNAIL_BAR,
        VIEW_READER
    }

    void addOnVisibilityChangedListener(OnVisibilityChangedListener onVisibilityChangedListener);

    Type getActiveViewType();

    AudioView getAudioInspector();

    ContentEditingStylingBar getContentEditingStylingBarView();

    ViewGroup getCreateTextBlockButtonsContainer();

    PdfDocumentInfoView getDocumentInfoView();

    TextView getDocumentTitleOverlayView();

    View getEmptyView();

    FormEditingBar getFormEditingBarView();

    FloatingActionButton getMainPageCreateTextBlockButton();

    MeasurementScaleView getMeasurementScaleView();

    View getNavigateBackButton();

    View getNavigateForwardButton();

    PdfOutlineView getOutlineView();

    TextView getPageNumberOverlayView();

    PdfReaderView getReaderView();

    RedactionView getRedactionView();

    PdfSearchView getSearchView();

    FloatingActionButton getSecondPageCreateTextBlockButton();

    PdfTabBar getTabBar();

    PdfThumbnailBar getThumbnailBarView();

    PdfThumbnailGrid getThumbnailGridView();

    PSPDFView getViewByType(Type type);

    void onRestoreViewHierarchyState(Bundle bundle);

    void onSaveViewHierarchyState(Bundle bundle);

    void removeOnVisibilityChangedListener(OnVisibilityChangedListener onVisibilityChangedListener);

    void resetDocument();

    void setDocument(PdfDocument pdfDocument);

    boolean showView(Type type);

    boolean toggleView(Type type);

    boolean toggleView(Type type, long j);
}
