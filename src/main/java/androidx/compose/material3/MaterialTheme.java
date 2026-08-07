package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.ProvidableCompositionLocal;
import kotlin.Metadata;

/* JADX INFO: compiled from: MaterialTheme.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8G¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8G¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u00118GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u00178FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0003\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Landroidx/compose/material3/MaterialTheme;", "", "<init>", "()V", "colorScheme", "Landroidx/compose/material3/ColorScheme;", "getColorScheme", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/ColorScheme;", "typography", "Landroidx/compose/material3/Typography;", "getTypography", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/Typography;", "shapes", "Landroidx/compose/material3/Shapes;", "getShapes", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/Shapes;", "motionScheme", "Landroidx/compose/material3/MotionScheme;", "getMotionScheme$annotations", "(Landroidx/compose/runtime/Composer;I)V", "getMotionScheme", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/MotionScheme;", "LocalMotionScheme", "Landroidx/compose/runtime/CompositionLocal;", "getLocalMotionScheme$annotations", "getLocalMotionScheme", "()Landroidx/compose/runtime/CompositionLocal;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MaterialTheme {
    public static final int $stable = 0;
    public static final MaterialTheme INSTANCE = new MaterialTheme();

    public static /* synthetic */ void getLocalMotionScheme$annotations() {
    }

    public static /* synthetic */ void getMotionScheme$annotations(Composer composer, int i) {
    }

    private MaterialTheme() {
    }

    public final ColorScheme getColorScheme(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -561618718, "C(<get-colorScheme>)124@5447L7:MaterialTheme.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-561618718, i, -1, "androidx.compose.material3.MaterialTheme.<get-colorScheme> (MaterialTheme.kt:124)");
        }
        ProvidableCompositionLocal<ColorScheme> localColorScheme = ColorSchemeKt.getLocalColorScheme();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localColorScheme);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ColorScheme colorScheme = (ColorScheme) objConsume;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return colorScheme;
    }

    public final Typography getTypography(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -942794935, "C(<get-typography>)132@5733L7:MaterialTheme.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-942794935, i, -1, "androidx.compose.material3.MaterialTheme.<get-typography> (MaterialTheme.kt:132)");
        }
        ProvidableCompositionLocal<Typography> localTypography = TypographyKt.getLocalTypography();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localTypography);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Typography typography = (Typography) objConsume;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return typography;
    }

    public final Shapes getShapes(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 419509830, "C(<get-shapes>)140@5999L7:MaterialTheme.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(419509830, i, -1, "androidx.compose.material3.MaterialTheme.<get-shapes> (MaterialTheme.kt:140)");
        }
        ProvidableCompositionLocal<Shapes> localShapes = ShapesKt.getLocalShapes();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localShapes);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Shapes shapes = (Shapes) objConsume;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return shapes;
    }

    public final MotionScheme getMotionScheme(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -506613891, "C(<get-motionScheme>)145@6243L7:MaterialTheme.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-506613891, i, -1, "androidx.compose.material3.MaterialTheme.<get-motionScheme> (MaterialTheme.kt:145)");
        }
        CompositionLocal<MotionScheme> localMotionScheme = getLocalMotionScheme();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localMotionScheme);
        ComposerKt.sourceInformationMarkerEnd(composer);
        MotionScheme motionScheme = (MotionScheme) objConsume;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return motionScheme;
    }

    public final CompositionLocal<MotionScheme> getLocalMotionScheme() {
        return MaterialThemeKt._localMotionScheme;
    }
}
