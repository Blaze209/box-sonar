package androidx.media3.effect;

import android.util.Pair;
import androidx.media3.common.OverlaySettings;
import com.google.common.base.Preconditions;

/* JADX INFO: loaded from: classes8.dex */
public final class StaticOverlaySettings implements OverlaySettings {
    private final float alphaScale;
    private final Pair<Float, Float> backgroundFrameAnchor;
    private final float hdrLuminanceMultiplier;
    private final Pair<Float, Float> overlayFrameAnchor;
    private final float rotationDegrees;
    private final Pair<Float, Float> scale;

    public static final class Builder {
        private float alphaScale = 1.0f;
        private Pair<Float, Float> backgroundFrameAnchor = OverlaySettings.DEFAULT_BACKGROUND_FRAME_ANCHOR;
        private Pair<Float, Float> overlayFrameAnchor = OverlaySettings.DEFAULT_OVERLAY_FRAME_ANCHOR;
        private Pair<Float, Float> scale = OverlaySettings.DEFAULT_SCALE;
        private float rotationDegrees = 0.0f;
        private float hdrLuminanceMultiplier = 1.0f;

        public Builder setAlphaScale(float f) {
            Preconditions.checkArgument(0.0f <= f, "alphaScale needs to be greater than or equal to zero.");
            this.alphaScale = f;
            return this;
        }

        public Builder setBackgroundFrameAnchor(float f, float f2) {
            Preconditions.checkArgument(-1.0f <= f && f <= 1.0f);
            Preconditions.checkArgument(-1.0f <= f2 && f2 <= 1.0f);
            this.backgroundFrameAnchor = Pair.create(Float.valueOf(f), Float.valueOf(f2));
            return this;
        }

        public Builder setOverlayFrameAnchor(float f, float f2) {
            Preconditions.checkArgument(-1.0f <= f && f <= 1.0f);
            Preconditions.checkArgument(-1.0f <= f2 && f2 <= 1.0f);
            this.overlayFrameAnchor = Pair.create(Float.valueOf(f), Float.valueOf(f2));
            return this;
        }

        public Builder setScale(float f, float f2) {
            this.scale = Pair.create(Float.valueOf(f), Float.valueOf(f2));
            return this;
        }

        public Builder setRotationDegrees(float f) {
            this.rotationDegrees = f;
            return this;
        }

        public Builder setHdrLuminanceMultiplier(float f) {
            this.hdrLuminanceMultiplier = f;
            return this;
        }

        public StaticOverlaySettings build() {
            return new StaticOverlaySettings(this.alphaScale, this.backgroundFrameAnchor, this.overlayFrameAnchor, this.scale, this.rotationDegrees, this.hdrLuminanceMultiplier);
        }
    }

    private StaticOverlaySettings(float f, Pair<Float, Float> pair, Pair<Float, Float> pair2, Pair<Float, Float> pair3, float f2, float f3) {
        this.alphaScale = f;
        this.backgroundFrameAnchor = pair;
        this.overlayFrameAnchor = pair2;
        this.scale = pair3;
        this.rotationDegrees = f2;
        this.hdrLuminanceMultiplier = f3;
    }

    @Override // androidx.media3.common.OverlaySettings
    public float getAlphaScale() {
        return this.alphaScale;
    }

    @Override // androidx.media3.common.OverlaySettings
    public Pair<Float, Float> getBackgroundFrameAnchor() {
        return this.backgroundFrameAnchor;
    }

    @Override // androidx.media3.common.OverlaySettings
    public Pair<Float, Float> getOverlayFrameAnchor() {
        return this.overlayFrameAnchor;
    }

    @Override // androidx.media3.common.OverlaySettings
    public Pair<Float, Float> getScale() {
        return this.scale;
    }

    @Override // androidx.media3.common.OverlaySettings
    public float getRotationDegrees() {
        return this.rotationDegrees;
    }

    @Override // androidx.media3.common.OverlaySettings
    public float getHdrLuminanceMultiplier() {
        return this.hdrLuminanceMultiplier;
    }
}
