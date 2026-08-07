package com.box.android.boxai.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.box.android.base.compose.BoxTheme;
import kotlin.Metadata;

/* JADX INFO: compiled from: BoxAITheme.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/boxai/ui/BoxAITheme;", "", "<init>", "()V", "colors", "Lcom/box/android/boxai/ui/BoxAIColors;", "getColors", "(Landroidx/compose/runtime/Composer;I)Lcom/box/android/boxai/ui/BoxAIColors;", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxAITheme {
    public static final int $stable = 0;
    public static final BoxAITheme INSTANCE = new BoxAITheme();

    private BoxAITheme() {
    }

    public final BoxAIColors getColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -349593278, "C(<get-colors>)10@292L11:BoxAITheme.kt#bwxcym");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-349593278, i, -1, "com.box.android.boxai.ui.BoxAITheme.<get-colors> (BoxAITheme.kt:10)");
        }
        BoxAIColors darkColors = BoxTheme.INSTANCE.isDarkTheme(composer, BoxTheme.$stable) ? BoxAIColorsKt.getDarkColors() : BoxAIColorsKt.getLightColors();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return darkColors;
    }
}
