package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;

/* JADX INFO: compiled from: ContentAlpha.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\f\u001a\u00020\u00052\b\b\u0001\u0010\r\u001a\u00020\u00052\b\b\u0001\u0010\u000e\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007¨\u0006\u0010"}, d2 = {"Landroidx/compose/material/ContentAlpha;", "", "<init>", "()V", "high", "", "getHigh", "(Landroidx/compose/runtime/Composer;I)F", FirebaseAnalytics.Param.MEDIUM, "getMedium", "disabled", "getDisabled", "contentAlpha", "highContrastAlpha", "lowContrastAlpha", "(FFLandroidx/compose/runtime/Composer;I)F", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ContentAlpha {
    public static final int $stable = 0;
    public static final ContentAlpha INSTANCE = new ContentAlpha();

    private ContentAlpha() {
    }

    public final float getHigh(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 629162431, "C(<get-high>)36@1157L159:ContentAlpha.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(629162431, i, -1, "androidx.compose.material.ContentAlpha.<get-high> (ContentAlpha.kt:36)");
        }
        float fContentAlpha = contentAlpha(1.0f, 0.87f, composer, ((i << 6) & 896) | 54);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return fContentAlpha;
    }

    public final float getMedium(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1999054879, "C(<get-medium>)48@1533L163:ContentAlpha.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1999054879, i, -1, "androidx.compose.material.ContentAlpha.<get-medium> (ContentAlpha.kt:48)");
        }
        float fContentAlpha = contentAlpha(0.74f, 0.6f, composer, ((i << 6) & 896) | 54);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return fContentAlpha;
    }

    public final float getDisabled(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 621183615, "C(<get-disabled>)60@1905L167:ContentAlpha.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(621183615, i, -1, "androidx.compose.material.ContentAlpha.<get-disabled> (ContentAlpha.kt:60)");
        }
        float fContentAlpha = contentAlpha(0.38f, 0.38f, composer, ((i << 6) & 896) | 54);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return fContentAlpha;
    }

    private final float contentAlpha(float f, float f2, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1528360391, "C(contentAlpha)N(highContrastAlpha,lowContrastAlpha)78@2713L7,79@2760L6:ContentAlpha.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1528360391, i, -1, "androidx.compose.material.ContentAlpha.contentAlpha (ContentAlpha.kt:77)");
        }
        ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContentColor);
        ComposerKt.sourceInformationMarkerEnd(composer);
        long jM6824unboximpl = ((Color) objConsume).m6824unboximpl();
        if (!MaterialTheme.INSTANCE.getColors(composer, 6).isLight() ? ColorKt.m6866luminance8_81llA(jM6824unboximpl) >= 0.5d : ColorKt.m6866luminance8_81llA(jM6824unboximpl) <= 0.5d) {
            f = f2;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return f;
    }
}
