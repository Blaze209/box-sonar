package com.pspdfkit.configuration.rendering;

/* JADX INFO: loaded from: classes3.dex */
public class AnnotationRenderConfiguration {
    public final boolean drawRedactAsRedacted;
    public final Integer formHighlightColor;
    public final Integer formItemHighlightColor;
    public final Integer formRequiredFieldBorderColor;
    public final boolean invertColors;
    public final boolean showSignHereOverlay;
    public final Integer signHereOverlayBackgroundColor;
    public final boolean toGrayscale;

    public static class Builder {
        private Integer formHighlightColor = null;
        private Integer formItemHighlightColor = null;
        private Integer formRequiredFieldBorderColor = null;
        private Integer signHereOverlayBackgroundColor = null;
        private boolean invertColors = false;
        private boolean toGrayscale = false;
        private boolean redactionAnnotationPreviewEnabled = false;
        private boolean showSignHereOverlay = true;

        public AnnotationRenderConfiguration build() {
            return new AnnotationRenderConfiguration(this.formHighlightColor, this.formItemHighlightColor, this.formRequiredFieldBorderColor, this.signHereOverlayBackgroundColor, this.invertColors, this.toGrayscale, this.redactionAnnotationPreviewEnabled, this.showSignHereOverlay);
        }

        public Builder formHighlightColor(Integer num) {
            this.formHighlightColor = num;
            return this;
        }

        public Builder formItemHighlightColor(Integer num) {
            this.formItemHighlightColor = num;
            return this;
        }

        public Builder formRequiredFieldBorderColor(Integer num) {
            this.formRequiredFieldBorderColor = num;
            return this;
        }

        public Builder invertColors(boolean z) {
            this.invertColors = z;
            return this;
        }

        public Builder redactionAnnotationPreviewEnabled(boolean z) {
            this.redactionAnnotationPreviewEnabled = z;
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

    private AnnotationRenderConfiguration(Integer num, Integer num2, Integer num3, Integer num4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.formHighlightColor = num;
        this.formItemHighlightColor = num2;
        this.formRequiredFieldBorderColor = num3;
        this.signHereOverlayBackgroundColor = num4;
        this.invertColors = z;
        this.toGrayscale = z2;
        this.drawRedactAsRedacted = z3;
        this.showSignHereOverlay = z4;
    }
}
