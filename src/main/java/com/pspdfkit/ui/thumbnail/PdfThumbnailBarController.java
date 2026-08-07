package com.pspdfkit.ui.thumbnail;

import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.listeners.DocumentListener;
import com.pspdfkit.listeners.OnVisibilityChangedListener;
import com.pspdfkit.ui.PdfThumbnailBar;
import com.pspdfkit.ui.drawable.PdfDrawableProvider;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface PdfThumbnailBarController {
    void addOnVisibilityChangedListener(OnVisibilityChangedListener onVisibilityChangedListener);

    void clearDocument();

    int getBackgroundColor();

    DocumentListener getDocumentListener();

    int getSelectedThumbnailBorderColor();

    int getThumbnailBorderColor();

    int getThumbnailHeight();

    int getThumbnailWidth();

    boolean isBackgroundTransparent();

    boolean isRedactionAnnotationPreviewEnabled();

    boolean isUsingPageAspectRatio();

    void removeOnVisibilityChangedListener(OnVisibilityChangedListener onVisibilityChangedListener);

    void setBackgroundColor(int i);

    void setDocument(PdfDocument pdfDocument, PdfConfiguration pdfConfiguration);

    void setDrawableProviders(List<PdfDrawableProvider> list);

    void setOnPageChangedListener(PdfThumbnailBar.OnPageChangedListener onPageChangedListener);

    void setRedactionAnnotationPreviewEnabled(boolean z);

    void setSelectedThumbnailBorderColor(int i);

    void setThumbnailBorderColor(int i);

    void setThumbnailHeight(int i);

    void setThumbnailWidth(int i);

    void setUsePageAspectRatio(boolean z);
}
