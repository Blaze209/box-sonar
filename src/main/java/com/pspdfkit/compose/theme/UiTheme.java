package com.pspdfkit.compose.theme;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8G¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/pspdfkit/compose/theme/UiTheme;", "", "<init>", "()V", "colors", "Lcom/pspdfkit/compose/theme/UiColorScheme;", "getColors", "(Landroidx/compose/runtime/Composer;I)Lcom/pspdfkit/compose/theme/UiColorScheme;", "icons", "Lcom/pspdfkit/compose/theme/UiIconScheme;", "getIcons", "(Landroidx/compose/runtime/Composer;I)Lcom/pspdfkit/compose/theme/UiIconScheme;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class UiTheme {
    public static final int $stable = 0;
    public static final UiTheme INSTANCE = new UiTheme();

    private UiTheme() {
    }

    public final UiColorScheme getColors(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1957035902, i, -1, "com.pspdfkit.compose.theme.UiTheme.<get-colors> (UiTheme.kt:28)");
        }
        UiColorScheme colors = ((SdkTheme) composer.consume(UiThemeKt.getLocalPdfUiScheme())).getColors();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return colors;
    }

    public final UiIconScheme getIcons(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(617713670, i, -1, "com.pspdfkit.compose.theme.UiTheme.<get-icons> (UiTheme.kt:35)");
        }
        UiIconScheme icons = ((SdkTheme) composer.consume(UiThemeKt.getLocalPdfUiScheme())).getIcons();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return icons;
    }
}
