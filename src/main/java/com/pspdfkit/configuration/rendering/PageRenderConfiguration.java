package com.pspdfkit.configuration.rendering;

import android.graphics.Bitmap;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.internal.uw;
import com.pspdfkit.ui.drawable.PdfDrawable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class PageRenderConfiguration {
    public final List<AnnotationType> excludedAnnotationTypes;
    public final List<Integer> excludedAnnotations;
    public final Integer formHighlightColor;
    public final Integer formItemHighlightColor;
    public final Integer formRequiredFieldBorderColor;
    public final boolean invertColors;
    public final int paperColor;
    public final boolean redactionAnnotationPreviewEnabled;
    public final int regionFullPageHeight;
    public final int regionFullPageWidth;
    public final int regionX;
    public final int regionY;
    public final boolean renderRegion;
    public final List<PdfDrawable> renderedDrawables;
    public final Bitmap reuseBitmap;
    public final boolean showSignHereOverlay;
    public final Integer signHereOverlayBackgroundColor;
    public final boolean toGrayscale;
    public final boolean useCache;

    public static class Builder {
        private List<AnnotationType> excludedAnnotationTypes;
        private List<Integer> excludedAnnotations;
        private final List<PdfDrawable> pdfDrawables = new ArrayList();
        private int paperColor = -1;
        private Integer formHighlightColor = null;
        private Integer formItemHighlightColor = null;
        private Integer formRequiredFieldBorderColor = null;
        private Integer signHereOverlayBackgroundColor = null;
        private boolean invertColors = false;
        private boolean toGrayscale = false;
        private boolean redactionAnnotationPreviewEnabled = false;
        private boolean useCache = true;
        private Bitmap reuseBitmap = null;
        private boolean renderRegion = false;
        private int regionX = 0;
        private int regionY = 0;
        private int regionFullPageWidth = 0;
        private int regionFullPageHeight = 0;
        private boolean showSignHereOverlay = true;

        public Builder() {
            List list = Collections.EMPTY_LIST;
            this.excludedAnnotations = list;
            this.excludedAnnotationTypes = list;
        }

        public PageRenderConfiguration build() {
            return new PageRenderConfiguration(this.paperColor, this.formHighlightColor, this.formItemHighlightColor, this.formRequiredFieldBorderColor, this.signHereOverlayBackgroundColor, this.useCache, this.reuseBitmap, this.renderRegion, this.regionX, this.regionY, this.regionFullPageWidth, this.regionFullPageHeight, this.invertColors, this.toGrayscale, this.redactionAnnotationPreviewEnabled, this.pdfDrawables, this.showSignHereOverlay, this.excludedAnnotations, this.excludedAnnotationTypes);
        }

        public Builder cache(boolean z) {
            this.useCache = z;
            return this;
        }

        public Builder excludedAnnotationTypes(List<AnnotationType> list) {
            this.excludedAnnotationTypes = list;
            return this;
        }

        public Builder excludedAnnotations(List<Integer> list) {
            this.excludedAnnotations = list;
            return this;
        }

        public Builder formHighlightColor(int i) {
            this.formHighlightColor = Integer.valueOf(i);
            return this;
        }

        public Builder formItemHighlightColor(int i) {
            this.formItemHighlightColor = Integer.valueOf(i);
            return this;
        }

        public Builder formRequiredFieldBorderColor(int i) {
            this.formRequiredFieldBorderColor = Integer.valueOf(i);
            return this;
        }

        public Builder invertColors(boolean z) {
            this.invertColors = z;
            return this;
        }

        public Builder paperColor(int i) {
            this.paperColor = i;
            return this;
        }

        public Builder redactionAnnotationPreviewEnabled(boolean z) {
            this.redactionAnnotationPreviewEnabled = z;
            return this;
        }

        public Builder region(int i, int i2, int i3, int i4) {
            this.renderRegion = true;
            this.regionX = i;
            this.regionY = i2;
            this.regionFullPageWidth = i3;
            this.regionFullPageHeight = i4;
            return this;
        }

        public Builder renderedDrawables(List<PdfDrawable> list) {
            uw.a(list, "pdfDrawables", null);
            this.pdfDrawables.clear();
            this.pdfDrawables.addAll(list);
            return this;
        }

        public Builder reuseBitmap(Bitmap bitmap) {
            this.reuseBitmap = bitmap;
            return this;
        }

        public Builder showSignHereOverlay(boolean z) {
            this.showSignHereOverlay = z;
            return this;
        }

        public Builder signHereOverlayBackgroundColor(Integer num) {
            this.signHereOverlayBackgroundColor = num;
            return this;
        }

        public Builder toGrayscale(boolean z) {
            this.toGrayscale = z;
            return this;
        }
    }

    private PageRenderConfiguration(int i, Integer num, Integer num2, Integer num3, Integer num4, boolean z, Bitmap bitmap, boolean z2, int i2, int i3, int i4, int i5, boolean z3, boolean z4, boolean z5, List<PdfDrawable> list, boolean z6, List<Integer> list2, List<AnnotationType> list3) {
        this.paperColor = i;
        this.formHighlightColor = num;
        this.formItemHighlightColor = num2;
        this.formRequiredFieldBorderColor = num3;
        this.signHereOverlayBackgroundColor = num4;
        this.invertColors = z3;
        this.toGrayscale = z4;
        this.redactionAnnotationPreviewEnabled = z5;
        this.useCache = z;
        this.reuseBitmap = bitmap;
        this.renderRegion = z2;
        this.regionX = i2;
        this.regionY = i3;
        this.regionFullPageWidth = i4;
        this.regionFullPageHeight = i5;
        this.renderedDrawables = list;
        this.showSignHereOverlay = z6;
        this.excludedAnnotations = list2;
        this.excludedAnnotationTypes = list3;
    }
}
