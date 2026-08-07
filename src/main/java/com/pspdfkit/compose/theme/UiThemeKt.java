package com.pspdfkit.compose.theme;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import io.nutrient.ui.theme.ThemeWrapperKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\r\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\u0010\u0007\u001a\r\u0010\b\u001a\u00020\u0006H\u0007¢\u0006\u0002\u0010\u0007\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\t"}, d2 = {"LocalPdfUiScheme", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Lcom/pspdfkit/compose/theme/SdkTheme;", "getLocalPdfUiScheme", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "getUiColors", "Lcom/pspdfkit/compose/theme/UiColorScheme;", "(Landroidx/compose/runtime/Composer;I)Lcom/pspdfkit/compose/theme/UiColorScheme;", "getComposeUiColors", "sdk-nutrient"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class UiThemeKt {
    private static final ProvidableCompositionLocal<SdkTheme> LocalPdfUiScheme = CompositionLocalKt.staticCompositionLocalOf(new Function0() { // from class: com.pspdfkit.compose.theme.UiThemeKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return UiThemeKt.LocalPdfUiScheme$lambda$0();
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final SdkTheme LocalPdfUiScheme$lambda$0() {
        return new SdkTheme(ThemeWrapperKt.defaultColorScheme(), ThemeWrapperKt.getDefaultUiIcons$default(null, 1, null));
    }

    public static final UiColorScheme getComposeUiColors(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1269899970, i, -1, "com.pspdfkit.compose.theme.getComposeUiColors (UiTheme.kt:76)");
        }
        UiColorScheme defaultUiColors = ThemeWrapperKt.getDefaultUiColors(null, null, null, null, composer, 0, 15);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return defaultUiColors;
    }

    public static final ProvidableCompositionLocal<SdkTheme> getLocalPdfUiScheme() {
        return LocalPdfUiScheme;
    }

    public static final UiColorScheme getUiColors(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-31668256, i, -1, "com.pspdfkit.compose.theme.getUiColors (UiTheme.kt:70)");
        }
        UiColorScheme defaultXmlUiColors = ThemeWrapperKt.getDefaultXmlUiColors(null, null, null, null, composer, 0, 15);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return defaultXmlUiColors;
    }
}
