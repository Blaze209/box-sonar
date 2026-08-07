package dev.chrisbanes.haze;

import android.graphics.BlendMode;
import kotlin.Metadata;

/* JADX INFO: compiled from: BlendMode.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"toAndroidBlendMode", "Landroid/graphics/BlendMode;", "Landroidx/compose/ui/graphics/BlendMode;", "toAndroidBlendMode-s9anfk8", "(I)Landroid/graphics/BlendMode;", "haze_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class BlendModeKt {
    /* JADX INFO: renamed from: toAndroidBlendMode-s9anfk8, reason: not valid java name */
    public static final BlendMode m14444toAndroidBlendModes9anfk8(int i) {
        if (androidx.compose.ui.graphics.BlendMode.m6723equalsimpl0(i, androidx.compose.ui.graphics.BlendMode.INSTANCE.m6727getClear0nO6VwU())) {
            return BlendMode.CLEAR;
        }
        if (androidx.compose.ui.graphics.BlendMode.m6723equalsimpl0(i, androidx.compose.ui.graphics.BlendMode.INSTANCE.m6728getColor0nO6VwU())) {
            return BlendMode.COLOR;
        }
        if (androidx.compose.ui.graphics.BlendMode.m6723equalsimpl0(i, androidx.compose.ui.graphics.BlendMode.INSTANCE.m6729getColorBurn0nO6VwU())) {
            return BlendMode.COLOR_BURN;
        }
        if (androidx.compose.ui.graphics.BlendMode.m6723equalsimpl0(i, androidx.compose.ui.graphics.BlendMode.INSTANCE.m6730getColorDodge0nO6VwU())) {
            return BlendMode.COLOR_DODGE;
        }
        if (androidx.compose.ui.graphics.BlendMode.m6723equalsimpl0(i, androidx.compose.ui.graphics.BlendMode.INSTANCE.m6731getDarken0nO6VwU())) {
            return BlendMode.DARKEN;
        }
        if (androidx.compose.ui.graphics.BlendMode.m6723equalsimpl0(i, androidx.compose.ui.graphics.BlendMode.INSTANCE.m6732getDifference0nO6VwU())) {
            return BlendMode.DIFFERENCE;
        }
        if (androidx.compose.ui.graphics.BlendMode.m6723equalsimpl0(i, androidx.compose.ui.graphics.BlendMode.INSTANCE.m6733getDst0nO6VwU())) {
            return BlendMode.DST;
        }
        if (androidx.compose.ui.graphics.BlendMode.m6723equalsimpl0(i, androidx.compose.ui.graphics.BlendMode.INSTANCE.m6734getDstAtop0nO6VwU())) {
            return BlendMode.DST_ATOP;
        }
        if (androidx.compose.ui.graphics.BlendMode.m6723equalsimpl0(i, androidx.compose.ui.graphics.BlendMode.INSTANCE.m6735getDstIn0nO6VwU())) {
            return BlendMode.DST_IN;
        }
        if (androidx.compose.ui.graphics.BlendMode.m6723equalsimpl0(i, androidx.compose.ui.graphics.BlendMode.INSTANCE.m6736getDstOut0nO6VwU())) {
            return BlendMode.DST_OUT;
        }
        if (androidx.compose.ui.graphics.BlendMode.m6723equalsimpl0(i, androidx.compose.ui.graphics.BlendMode.INSTANCE.m6737getDstOver0nO6VwU())) {
            return BlendMode.DST_OVER;
        }
        if (androidx.compose.ui.graphics.BlendMode.m6723equalsimpl0(i, androidx.compose.ui.graphics.BlendMode.INSTANCE.m6738getExclusion0nO6VwU())) {
            return BlendMode.EXCLUSION;
        }
        if (androidx.compose.ui.graphics.BlendMode.m6723equalsimpl0(i, androidx.compose.ui.graphics.BlendMode.INSTANCE.m6739getHardlight0nO6VwU())) {
            return BlendMode.HARD_LIGHT;
        }
        if (androidx.compose.ui.graphics.BlendMode.m6723equalsimpl0(i, androidx.compose.ui.graphics.BlendMode.INSTANCE.m6740getHue0nO6VwU())) {
            return BlendMode.HUE;
        }
        if (androidx.compose.ui.graphics.BlendMode.m6723equalsimpl0(i, androidx.compose.ui.graphics.BlendMode.INSTANCE.m6741getLighten0nO6VwU())) {
            return BlendMode.LIGHTEN;
        }
        if (androidx.compose.ui.graphics.BlendMode.m6723equalsimpl0(i, androidx.compose.ui.graphics.BlendMode.INSTANCE.m6742getLuminosity0nO6VwU())) {
            return BlendMode.LUMINOSITY;
        }
        if (androidx.compose.ui.graphics.BlendMode.m6723equalsimpl0(i, androidx.compose.ui.graphics.BlendMode.INSTANCE.m6743getModulate0nO6VwU())) {
            return BlendMode.MODULATE;
        }
        if (androidx.compose.ui.graphics.BlendMode.m6723equalsimpl0(i, androidx.compose.ui.graphics.BlendMode.INSTANCE.m6744getMultiply0nO6VwU())) {
            return BlendMode.MULTIPLY;
        }
        if (androidx.compose.ui.graphics.BlendMode.m6723equalsimpl0(i, androidx.compose.ui.graphics.BlendMode.INSTANCE.m6745getOverlay0nO6VwU())) {
            return BlendMode.OVERLAY;
        }
        if (androidx.compose.ui.graphics.BlendMode.m6723equalsimpl0(i, androidx.compose.ui.graphics.BlendMode.INSTANCE.m6747getSaturation0nO6VwU())) {
            return BlendMode.SATURATION;
        }
        if (androidx.compose.ui.graphics.BlendMode.m6723equalsimpl0(i, androidx.compose.ui.graphics.BlendMode.INSTANCE.m6748getScreen0nO6VwU())) {
            return BlendMode.SCREEN;
        }
        if (androidx.compose.ui.graphics.BlendMode.m6723equalsimpl0(i, androidx.compose.ui.graphics.BlendMode.INSTANCE.m6749getSoftlight0nO6VwU())) {
            return BlendMode.SOFT_LIGHT;
        }
        if (androidx.compose.ui.graphics.BlendMode.m6723equalsimpl0(i, androidx.compose.ui.graphics.BlendMode.INSTANCE.m6750getSrc0nO6VwU())) {
            return BlendMode.SRC;
        }
        if (androidx.compose.ui.graphics.BlendMode.m6723equalsimpl0(i, androidx.compose.ui.graphics.BlendMode.INSTANCE.m6751getSrcAtop0nO6VwU())) {
            return BlendMode.SRC_ATOP;
        }
        if (androidx.compose.ui.graphics.BlendMode.m6723equalsimpl0(i, androidx.compose.ui.graphics.BlendMode.INSTANCE.m6752getSrcIn0nO6VwU())) {
            return BlendMode.SRC_IN;
        }
        if (androidx.compose.ui.graphics.BlendMode.m6723equalsimpl0(i, androidx.compose.ui.graphics.BlendMode.INSTANCE.m6753getSrcOut0nO6VwU())) {
            return BlendMode.SRC_OUT;
        }
        return androidx.compose.ui.graphics.BlendMode.m6723equalsimpl0(i, androidx.compose.ui.graphics.BlendMode.INSTANCE.m6754getSrcOver0nO6VwU()) ? BlendMode.SRC_OVER : BlendMode.SRC_IN;
    }
}
