package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

/* JADX INFO: compiled from: Button.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJA\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ7\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020#2\b\b\u0002\u0010%\u001a\u00020#2\b\b\u0002\u0010&\u001a\u00020#H\u0007¢\u0006\u0004\b'\u0010(J-\u0010)\u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020#2\b\b\u0002\u0010&\u001a\u00020#H\u0007¢\u0006\u0004\b*\u0010+J-\u0010,\u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020#2\b\b\u0002\u0010&\u001a\u00020#H\u0007¢\u0006\u0004\b-\u0010+R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\u0011\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0012\u0010\u000eR\u0013\u0010\u0013\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0014\u0010\u000eR\u000e\u0010.\u001a\u00020/X\u0086T¢\u0006\u0002\n\u0000R\u0013\u00100\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b1\u0010\u000eR\u0011\u00102\u001a\u0002038G¢\u0006\u0006\u001a\u0004\b4\u00105R\u0010\u00106\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0011\u00107\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u000b¨\u00069"}, d2 = {"Landroidx/compose/material/ButtonDefaults;", "", "<init>", "()V", "ButtonHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ButtonVerticalPadding", "ContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "MinWidth", "getMinWidth-D9Ej5fM", "()F", "MinHeight", "getMinHeight-D9Ej5fM", "IconSize", "getIconSize-D9Ej5fM", "IconSpacing", "getIconSpacing-D9Ej5fM", "elevation", "Landroidx/compose/material/ButtonElevation;", "defaultElevation", "pressedElevation", "disabledElevation", "elevation-yajeYGU", "(FFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/ButtonElevation;", "hoveredElevation", "focusedElevation", "elevation-R_JCAzs", "(FFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/ButtonElevation;", "buttonColors", "Landroidx/compose/material/ButtonColors;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "disabledBackgroundColor", "disabledContentColor", "buttonColors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/ButtonColors;", "outlinedButtonColors", "outlinedButtonColors-RGew2ao", "(JJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/ButtonColors;", "textButtonColors", "textButtonColors-RGew2ao", "OutlinedBorderOpacity", "", "OutlinedBorderSize", "getOutlinedBorderSize-D9Ej5fM", "outlinedBorder", "Landroidx/compose/foundation/BorderStroke;", "getOutlinedBorder", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/BorderStroke;", "TextButtonHorizontalPadding", "TextButtonContentPadding", "getTextButtonContentPadding", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ButtonDefaults {
    public static final int $stable = 0;
    private static final float ButtonHorizontalPadding;
    private static final float ButtonVerticalPadding;
    private static final PaddingValues ContentPadding;
    public static final ButtonDefaults INSTANCE = new ButtonDefaults();
    private static final float IconSize;
    private static final float IconSpacing;
    private static final float MinHeight;
    private static final float MinWidth;
    public static final float OutlinedBorderOpacity = 0.12f;
    private static final float OutlinedBorderSize;
    private static final PaddingValues TextButtonContentPadding;
    private static final float TextButtonHorizontalPadding;

    private ButtonDefaults() {
    }

    public final PaddingValues getContentPadding() {
        return ContentPadding;
    }

    /* JADX INFO: renamed from: getMinWidth-D9Ej5fM, reason: not valid java name */
    public final float m2307getMinWidthD9Ej5fM() {
        return MinWidth;
    }

    /* JADX INFO: renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m2306getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* JADX INFO: renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m2304getIconSizeD9Ej5fM() {
        return IconSize;
    }

    /* JADX INFO: renamed from: getIconSpacing-D9Ej5fM, reason: not valid java name */
    public final float m2305getIconSpacingD9Ej5fM() {
        return IconSpacing;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use another overload of elevation")
    /* JADX INFO: renamed from: elevation-yajeYGU, reason: not valid java name */
    public final /* synthetic */ ButtonElevation m2303elevationyajeYGU(float f, float f2, float f3, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1428576874, "C(elevation)N(defaultElevation:c#ui.unit.Dp,pressedElevation:c#ui.unit.Dp,disabledElevation:c#ui.unit.Dp)347@14836L185:Button.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            f = Dp.m9687constructorimpl(2);
        }
        float f4 = f;
        if ((i2 & 2) != 0) {
            f2 = Dp.m9687constructorimpl(8);
        }
        float f5 = f2;
        if ((i2 & 4) != 0) {
            f3 = Dp.m9687constructorimpl(0);
        }
        float f6 = f3;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1428576874, i, -1, "androidx.compose.material.ButtonDefaults.elevation (Button.kt:347)");
        }
        float f7 = 4;
        ButtonElevation buttonElevationM2302elevationR_JCAzs = m2302elevationR_JCAzs(f4, f5, f6, Dp.m9687constructorimpl(f7), Dp.m9687constructorimpl(f7), composer, (i & 14) | 27648 | (i & 112) | (i & 896) | ((i << 6) & 458752), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return buttonElevationM2302elevationR_JCAzs;
    }

    /* JADX INFO: renamed from: elevation-R_JCAzs, reason: not valid java name */
    public final ButtonElevation m2302elevationR_JCAzs(float f, float f2, float f3, float f4, float f5, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -737170518, "C(elevation)N(defaultElevation:c#ui.unit.Dp,pressedElevation:c#ui.unit.Dp,disabledElevation:c#ui.unit.Dp,hoveredElevation:c#ui.unit.Dp,focusedElevation:c#ui.unit.Dp)375@15987L499:Button.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            f = Dp.m9687constructorimpl(2);
        }
        float f6 = f;
        if ((i2 & 2) != 0) {
            f2 = Dp.m9687constructorimpl(8);
        }
        float f7 = f2;
        if ((i2 & 4) != 0) {
            f3 = Dp.m9687constructorimpl(0);
        }
        float f8 = f3;
        float fM9687constructorimpl = (i2 & 8) != 0 ? Dp.m9687constructorimpl(4) : f4;
        float fM9687constructorimpl2 = (i2 & 16) != 0 ? Dp.m9687constructorimpl(4) : f5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-737170518, i, -1, "androidx.compose.material.ButtonDefaults.elevation (Button.kt:374)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 248744253, "CC(remember):Button.kt#9igjgp");
        boolean z = ((((i & 14) ^ 6) > 4 && composer.changed(f6)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer.changed(f7)) || (i & 48) == 32) | ((((i & 896) ^ 384) > 256 && composer.changed(f8)) || (i & 384) == 256) | ((((i & 7168) ^ 3072) > 2048 && composer.changed(fM9687constructorimpl)) || (i & 3072) == 2048) | ((((57344 & i) ^ 24576) > 16384 && composer.changed(fM9687constructorimpl2)) || (i & 24576) == 16384);
        Object objRememberedValue = composer.rememberedValue();
        if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            DefaultButtonElevation defaultButtonElevation = new DefaultButtonElevation(f6, f7, f8, fM9687constructorimpl, fM9687constructorimpl2, null);
            composer.updateRememberedValue(defaultButtonElevation);
            objRememberedValue = defaultButtonElevation;
        }
        DefaultButtonElevation defaultButtonElevation2 = (DefaultButtonElevation) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultButtonElevation2;
    }

    /* JADX INFO: renamed from: buttonColors-ro_MJ88, reason: not valid java name */
    public final ButtonColors m2301buttonColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1870371134, "C(buttonColors)N(backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledBackgroundColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color)403@17055L6,404@17101L32,406@17202L6,408@17301L6,410@17382L6,410@17425L8:Button.kt#jmzs0o");
        long jM2342getPrimary0d7_KjU = (i2 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m2342getPrimary0d7_KjU() : j;
        long jM2360contentColorForek8zF_U = (i2 & 2) != 0 ? ColorsKt.m2360contentColorForek8zF_U(jM2342getPrimary0d7_KjU, composer, i & 14) : j2;
        long jM6859compositeOverOWjLjI = (i2 & 4) != 0 ? ColorKt.m6859compositeOverOWjLjI(Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2341getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColors(composer, 6).m2346getSurface0d7_KjU()) : j3;
        long jM6813copywmQWz5c$default = (i2 & 8) != 0 ? Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2341getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1870371134, i, -1, "androidx.compose.material.ButtonDefaults.buttonColors (Button.kt:412)");
        }
        DefaultButtonColors defaultButtonColors = new DefaultButtonColors(jM2342getPrimary0d7_KjU, jM2360contentColorForek8zF_U, jM6859compositeOverOWjLjI, jM6813copywmQWz5c$default, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultButtonColors;
    }

    /* JADX INFO: renamed from: outlinedButtonColors-RGew2ao, reason: not valid java name */
    public final ButtonColors m2309outlinedButtonColorsRGew2ao(long j, long j2, long j3, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -2124406093, "C(outlinedButtonColors)N(backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color)429@18202L6,430@18262L6,432@18342L6,432@18385L8:Button.kt#jmzs0o");
        long jM2346getSurface0d7_KjU = (i2 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m2346getSurface0d7_KjU() : j;
        long jM2342getPrimary0d7_KjU = (i2 & 2) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m2342getPrimary0d7_KjU() : j2;
        long jM6813copywmQWz5c$default = (i2 & 4) != 0 ? Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2341getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j3;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2124406093, i, -1, "androidx.compose.material.ButtonDefaults.outlinedButtonColors (Button.kt:434)");
        }
        DefaultButtonColors defaultButtonColors = new DefaultButtonColors(jM2346getSurface0d7_KjU, jM2342getPrimary0d7_KjU, jM2346getSurface0d7_KjU, jM6813copywmQWz5c$default, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultButtonColors;
    }

    /* JADX INFO: renamed from: textButtonColors-RGew2ao, reason: not valid java name */
    public final ButtonColors m2310textButtonColorsRGew2ao(long j, long j2, long j3, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 182742216, "C(textButtonColors)N(backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color)452@19182L6,454@19262L6,454@19305L8:Button.kt#jmzs0o");
        long jM6849getTransparent0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m6849getTransparent0d7_KjU() : j;
        long jM2342getPrimary0d7_KjU = (i2 & 2) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m2342getPrimary0d7_KjU() : j2;
        long jM6813copywmQWz5c$default = (i2 & 4) != 0 ? Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2341getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j3;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(182742216, i, -1, "androidx.compose.material.ButtonDefaults.textButtonColors (Button.kt:456)");
        }
        DefaultButtonColors defaultButtonColors = new DefaultButtonColors(jM6849getTransparent0d7_KjU, jM2342getPrimary0d7_KjU, jM6849getTransparent0d7_KjU, jM6813copywmQWz5c$default, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultButtonColors;
    }

    /* JADX INFO: renamed from: getOutlinedBorderSize-D9Ej5fM, reason: not valid java name */
    public final float m2308getOutlinedBorderSizeD9Ej5fM() {
        return OutlinedBorderSize;
    }

    public final BorderStroke getOutlinedBorder(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -2091313033, "C(<get-outlinedBorder>)475@20035L6:Button.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2091313033, i, -1, "androidx.compose.material.ButtonDefaults.<get-outlinedBorder> (Button.kt:473)");
        }
        BorderStroke borderStrokeM622BorderStrokecXLIe8U = BorderStrokeKt.m622BorderStrokecXLIe8U(OutlinedBorderSize, Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2341getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return borderStrokeM622BorderStrokecXLIe8U;
    }

    public final PaddingValues getTextButtonContentPadding() {
        return TextButtonContentPadding;
    }

    static {
        float fM9687constructorimpl = Dp.m9687constructorimpl(16);
        ButtonHorizontalPadding = fM9687constructorimpl;
        float f = 8;
        float fM9687constructorimpl2 = Dp.m9687constructorimpl(f);
        ButtonVerticalPadding = fM9687constructorimpl2;
        PaddingValues paddingValuesM1214PaddingValuesa9UjIt4 = PaddingKt.m1214PaddingValuesa9UjIt4(fM9687constructorimpl, fM9687constructorimpl2, fM9687constructorimpl, fM9687constructorimpl2);
        ContentPadding = paddingValuesM1214PaddingValuesa9UjIt4;
        MinWidth = Dp.m9687constructorimpl(64);
        MinHeight = Dp.m9687constructorimpl(36);
        IconSize = Dp.m9687constructorimpl(18);
        IconSpacing = Dp.m9687constructorimpl(f);
        OutlinedBorderSize = Dp.m9687constructorimpl(1);
        float fM9687constructorimpl3 = Dp.m9687constructorimpl(f);
        TextButtonHorizontalPadding = fM9687constructorimpl3;
        TextButtonContentPadding = PaddingKt.m1214PaddingValuesa9UjIt4(fM9687constructorimpl3, paddingValuesM1214PaddingValuesa9UjIt4.getTop(), fM9687constructorimpl3, paddingValuesM1214PaddingValuesa9UjIt4.getBottom());
    }
}
