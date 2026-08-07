package com.pspdfkit.document.processor;

import android.graphics.Canvas;
import android.graphics.RectF;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.internal.document.DataProviderShim;
import com.pspdfkit.internal.jni.NativeNewPageConfiguration;
import com.pspdfkit.internal.lm;
import com.pspdfkit.internal.uw;
import com.pspdfkit.utils.EdgeInsets;
import com.pspdfkit.utils.Size;
import java.io.IOException;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public final class NewPage {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public final int backgroundColor;
    private final PageCanvas canvas;
    private final PageImage image;
    public final EdgeInsets margins;
    public final Size pageSize;
    private final PagePdf pdf;
    public final int rotation;
    public final lm sourceDocument;
    private final int sourceDocumentPageIndex;
    private final PagePattern sourcePattern;
    public static final Size PAGE_SIZE_A0 = new Size(2384.0f, 3370.0f);
    public static final Size PAGE_SIZE_A4 = new Size(595.0f, 842.0f);
    public static final Size PAGE_SIZE_A5 = new Size(420.0f, 595.0f);
    public static final Size PAGE_SIZE_US_LEGAL = new Size(612.0f, 1008.0f);
    public static final Size PAGE_SIZE_US_LETTER = new Size(612.0f, 792.0f);
    public static final Size PAGE_SIZE_B4 = new Size(709.0f, 1001.0f);
    public static final Size PAGE_SIZE_B5 = new Size(499.0f, 709.0f);

    public interface OnDrawCanvasCallback {
        void onDrawCanvas(Canvas canvas);
    }

    private NewPage(Size size, EdgeInsets edgeInsets, int i, int i2, PdfDocument pdfDocument, int i3, PagePattern pagePattern, PageImage pageImage, PagePdf pagePdf, PageCanvas pageCanvas) {
        this.pageSize = size;
        this.margins = edgeInsets;
        this.rotation = i;
        this.backgroundColor = i2;
        this.sourceDocument = (lm) pdfDocument;
        this.sourceDocumentPageIndex = i3;
        this.sourcePattern = pagePattern;
        this.pdf = pagePdf;
        this.image = pageImage;
        this.canvas = pageCanvas;
    }

    public static Builder emptyPage(Size size) {
        uw.a(size, "pageSize", null);
        return new Builder(size, PagePattern.BLANK);
    }

    public static Builder fromCanvas(Size size, OnDrawCanvasCallback onDrawCanvasCallback) {
        uw.a(size, "pageSize", null);
        uw.a(onDrawCanvasCallback, "callback", null);
        return new Builder(size, PagePattern.BLANK).withPageItem(new PageCanvas(size, onDrawCanvasCallback));
    }

    public static Builder fromPage(PdfDocument pdfDocument, int i) {
        uw.a(pdfDocument, "sourceDocument", null);
        return new Builder(pdfDocument, i);
    }

    public static Builder patternPage(Size size, PagePattern pagePattern) {
        uw.a(size, "pageSize", null);
        uw.a(pagePattern, "pattern", null);
        return new Builder(size, pagePattern);
    }

    public NativeNewPageConfiguration getNativeNewPageConfiguration() {
        NativeNewPageConfiguration nativeNewPageConfigurationCreateEmptyPage;
        lm lmVar = this.sourceDocument;
        if (lmVar != null) {
            nativeNewPageConfigurationCreateEmptyPage = NativeNewPageConfiguration.createExternalDocumentPage(lmVar.y, this.sourceDocumentPageIndex, Integer.valueOf(this.rotation), this.margins);
        } else {
            PagePattern pagePattern = this.sourcePattern;
            if (pagePattern == null || pagePattern.getDataProvider() == null) {
                Size size = this.pageSize;
                Integer numValueOf = Integer.valueOf(this.rotation);
                int i = this.backgroundColor;
                nativeNewPageConfigurationCreateEmptyPage = NativeNewPageConfiguration.createEmptyPage(size, numValueOf, i != 0 ? Integer.valueOf(i) : null, this.margins);
            } else {
                Size size2 = this.pageSize;
                Integer numValueOf2 = Integer.valueOf(this.rotation);
                int i2 = this.backgroundColor;
                nativeNewPageConfigurationCreateEmptyPage = NativeNewPageConfiguration.createTiledPatternPage(size2, numValueOf2, i2 != 0 ? Integer.valueOf(i2) : null, this.margins, DataProviderShim.createNativeDataDescriptor(this.sourcePattern.getDataProvider()));
            }
        }
        PageImage pageImage = this.image;
        if (pageImage != null) {
            try {
                nativeNewPageConfigurationCreateEmptyPage.setItem(pageImage.getItemConfiguration());
                return nativeNewPageConfigurationCreateEmptyPage;
            } catch (IOException e) {
                throw new PdfProcessorException(e.getMessage());
            }
        }
        PagePdf pagePdf = this.pdf;
        if (pagePdf != null) {
            nativeNewPageConfigurationCreateEmptyPage.setItem(pagePdf.getItemConfiguration());
            return nativeNewPageConfigurationCreateEmptyPage;
        }
        PageCanvas pageCanvas = this.canvas;
        if (pageCanvas != null) {
            nativeNewPageConfigurationCreateEmptyPage.setItem(pageCanvas.getItemConfiguration());
        }
        return nativeNewPageConfigurationCreateEmptyPage;
    }

    public boolean hasPatternSource() {
        return this.sourcePattern != null;
    }

    public boolean hasPdfPageSource() {
        return this.sourceDocument != null;
    }

    public String toString() {
        return "NewPage{pageSize=" + this.pageSize + ", margins=" + this.margins + ", rotation=" + this.rotation + ", thumbnailBarBackgroundColor=" + this.backgroundColor + AbstractJsonLexerKt.END_OBJ;
    }

    public static class Builder {
        private int backgroundColor;
        private PageCanvas canvas;
        private PageImage image;
        private EdgeInsets margins;
        private final Size pageSize;
        private PagePdf pdf;
        private int rotation;
        private final PdfDocument sourceDocument;
        private final int sourcePageIndex;
        private final PagePattern sourcePattern;

        private Builder(PdfDocument pdfDocument, int i) {
            this.margins = new EdgeInsets();
            this.rotation = 0;
            this.sourceDocument = pdfDocument;
            this.sourcePageIndex = i;
            this.pageSize = pdfDocument.getPageSize(i);
            this.sourcePattern = null;
        }

        public Builder backgroundColor(int i) {
            this.backgroundColor = i;
            return this;
        }

        public NewPage build() {
            return new NewPage(this.pageSize, this.margins, this.rotation, this.backgroundColor, this.sourceDocument, this.sourcePageIndex, this.sourcePattern, this.image, this.pdf, this.canvas);
        }

        public Builder rotation(int i) {
            int iAbs = Math.abs(i);
            if (iAbs != 0 && iAbs != 90 && iAbs != 180 && iAbs != 270) {
                throw new IllegalArgumentException("Rotation value may only be 0, 90, 180 or 270.");
            }
            this.rotation = i;
            return this;
        }

        public Builder withMargins(RectF rectF) {
            uw.a(rectF, "margins", null);
            this.margins = new EdgeInsets(rectF.top, rectF.left, rectF.bottom, rectF.right);
            return this;
        }

        public Builder withPageItem(PageCanvas pageCanvas) {
            uw.a(pageCanvas, "canvas", null);
            this.canvas = pageCanvas;
            this.image = null;
            this.pdf = null;
            return this;
        }

        public Builder withPageItem(PageImage pageImage) {
            uw.a(pageImage, "image", null);
            this.image = pageImage;
            this.pdf = null;
            this.canvas = null;
            return this;
        }

        public Builder withPageItem(PagePdf pagePdf) {
            uw.a(pagePdf, "pdf", null);
            this.pdf = pagePdf;
            this.image = null;
            this.canvas = null;
            return this;
        }

        private Builder(Size size, PagePattern pagePattern) {
            this.margins = new EdgeInsets();
            this.rotation = 0;
            this.sourceDocument = null;
            this.sourcePageIndex = 0;
            this.pageSize = size;
            this.sourcePattern = pagePattern;
        }
    }
}
