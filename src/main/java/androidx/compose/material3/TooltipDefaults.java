package androidx.compose.material3;

import androidx.compose.material3.tokens.PlainTooltipTokens;
import androidx.compose.material3.tokens.RichTooltipTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import com.box.androidsdk.content.requests.BoxRequestsFile;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* JADX INFO: compiled from: Tooltip.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u001c\u001a\u00020\u001dJ\u0017\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010 \u001a\u00020!H\u0007¢\u0006\u0002\u0010\"J7\u0010 \u001a\u00020!2\b\b\u0002\u0010#\u001a\u00020\t2\b\b\u0002\u0010$\u001a\u00020\t2\b\b\u0002\u0010%\u001a\u00020\t2\b\b\u0002\u0010&\u001a\u00020\tH\u0007¢\u0006\u0004\b'\u0010(J\u0019\u0010-\u001a\u00020.2\b\b\u0002\u0010/\u001a\u00020\u0016H\u0007¢\u0006\u0004\b0\u00101J\u0019\u00102\u001a\u00020.2\b\b\u0002\u0010/\u001a\u00020\u0016H\u0007¢\u0006\u0004\b3\u00101J\u0019\u00104\u001a\u00020.2\b\b\u0002\u0010/\u001a\u00020\u0016H\u0007¢\u0006\u0004\b5\u00101J!\u00104\u001a\u00020.2\u0006\u00106\u001a\u0002072\b\b\u0002\u0010/\u001a\u00020\u0016H\u0007¢\u0006\u0004\b8\u00109R\u0011\u0010\u0004\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8G¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t8G¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0007R\u0013\u0010\u0010\u001a\u00020\u0011¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0015\u001a\u00020\u0016¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u001a\u001a\u00020\u0016¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001b\u0010\u0018R\u0018\u0010)\u001a\u00020!*\u00020*8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0014\u0010:\u001a\u00020\u001dX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<¨\u0006="}, d2 = {"Landroidx/compose/material3/TooltipDefaults;", "", "<init>", "()V", "plainTooltipContainerShape", "Landroidx/compose/ui/graphics/Shape;", "getPlainTooltipContainerShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "plainTooltipContainerColor", "Landroidx/compose/ui/graphics/Color;", "getPlainTooltipContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "plainTooltipContentColor", "getPlainTooltipContentColor", "richTooltipContainerShape", "getRichTooltipContainerShape", "caretSize", "Landroidx/compose/ui/unit/DpSize;", "getCaretSize-MYxV2XQ", "()J", "J", "plainTooltipMaxWidth", "Landroidx/compose/ui/unit/Dp;", "getPlainTooltipMaxWidth-D9Ej5fM", "()F", "F", "richTooltipMaxWidth", "getRichTooltipMaxWidth-D9Ej5fM", "caretShape", "Landroidx/compose/material3/DefaultTooltipCaretShape;", "caretShape-EaSLcWc", "(J)Landroidx/compose/ui/graphics/Shape;", "richTooltipColors", "Landroidx/compose/material3/RichTooltipColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/RichTooltipColors;", "containerColor", "contentColor", "titleContentColor", "actionContentColor", "richTooltipColors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/RichTooltipColors;", "defaultRichTooltipColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultRichTooltipColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/RichTooltipColors;", "rememberPlainTooltipPositionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "spacingBetweenTooltipAndAnchor", "rememberPlainTooltipPositionProvider-kHDZbjc", "(FLandroidx/compose/runtime/Composer;II)Landroidx/compose/ui/window/PopupPositionProvider;", "rememberRichTooltipPositionProvider", "rememberRichTooltipPositionProvider-kHDZbjc", "rememberTooltipPositionProvider", "rememberTooltipPositionProvider-kHDZbjc", "positioning", "Landroidx/compose/material3/TooltipAnchorPosition;", "rememberTooltipPositionProvider-Hu5FAss", "(IFLandroidx/compose/runtime/Composer;II)Landroidx/compose/ui/window/PopupPositionProvider;", "DefaultCaretShape", "getDefaultCaretShape$material3", "()Landroidx/compose/material3/DefaultTooltipCaretShape;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TooltipDefaults {
    public static final int $stable = 0;
    private static final DefaultTooltipCaretShape DefaultCaretShape;
    public static final TooltipDefaults INSTANCE = new TooltipDefaults();
    private static final long caretSize;
    private static final float plainTooltipMaxWidth;
    private static final float richTooltipMaxWidth;

    private TooltipDefaults() {
    }

    public final Shape getPlainTooltipContainerShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 49570325, "C(<get-plainTooltipContainerShape>)487@20255L5:Tooltip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(49570325, i, -1, "androidx.compose.material3.TooltipDefaults.<get-plainTooltipContainerShape> (Tooltip.kt:487)");
        }
        Shape value = ShapesKt.getValue(PlainTooltipTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final long getPlainTooltipContainerColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 102696215, "C(<get-plainTooltipContainerColor>)491@20431L5:Tooltip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(102696215, i, -1, "androidx.compose.material3.TooltipDefaults.<get-plainTooltipContainerColor> (Tooltip.kt:491)");
        }
        long value = ColorSchemeKt.getValue(PlainTooltipTokens.INSTANCE.getContainerColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final long getPlainTooltipContentColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1982928937, "C(<get-plainTooltipContentColor>)495@20619L5:Tooltip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1982928937, i, -1, "androidx.compose.material3.TooltipDefaults.<get-plainTooltipContentColor> (Tooltip.kt:495)");
        }
        long value = ColorSchemeKt.getValue(PlainTooltipTokens.INSTANCE.getSupportingTextColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getRichTooltipContainerShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1138709783, "C(<get-richTooltipContainerShape>)499@20792L5:Tooltip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1138709783, i, -1, "androidx.compose.material3.TooltipDefaults.<get-richTooltipContainerShape> (Tooltip.kt:499)");
        }
        Shape value = ShapesKt.getValue(RichTooltipTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    /* JADX INFO: renamed from: getCaretSize-MYxV2XQ, reason: not valid java name */
    public final long m4733getCaretSizeMYxV2XQ() {
        return caretSize;
    }

    /* JADX INFO: renamed from: getPlainTooltipMaxWidth-D9Ej5fM, reason: not valid java name */
    public final float m4734getPlainTooltipMaxWidthD9Ej5fM() {
        return plainTooltipMaxWidth;
    }

    /* JADX INFO: renamed from: getRichTooltipMaxWidth-D9Ej5fM, reason: not valid java name */
    public final float m4735getRichTooltipMaxWidthD9Ej5fM() {
        return richTooltipMaxWidth;
    }

    public final DefaultTooltipCaretShape caretShape() {
        return DefaultCaretShape;
    }

    /* JADX INFO: renamed from: caretShape-EaSLcWc$default, reason: not valid java name */
    public static /* synthetic */ Shape m4731caretShapeEaSLcWc$default(TooltipDefaults tooltipDefaults, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = caretSize;
        }
        return tooltipDefaults.m4732caretShapeEaSLcWc(j);
    }

    /* JADX INFO: renamed from: caretShape-EaSLcWc, reason: not valid java name */
    public final Shape m4732caretShapeEaSLcWc(long caretSize2) {
        return new DefaultTooltipCaretShape(caretSize2, null);
    }

    public final RichTooltipColors richTooltipColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1622312141, "C(richTooltipColors)525@21686L11:Tooltip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1622312141, i, -1, "androidx.compose.material3.TooltipDefaults.richTooltipColors (Tooltip.kt:525)");
        }
        RichTooltipColors defaultRichTooltipColors$material3 = getDefaultRichTooltipColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultRichTooltipColors$material3;
    }

    /* JADX INFO: renamed from: richTooltipColors-ro_MJ88, reason: not valid java name */
    public final RichTooltipColors m4740richTooltipColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1498555081, "C(richTooltipColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,titleContentColor:c#ui.graphics.Color,actionContentColor:c#ui.graphics.Color)538@22168L11:Tooltip.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            j = Color.INSTANCE.m6850getUnspecified0d7_KjU();
        }
        long j5 = j;
        long jM6850getUnspecified0d7_KjU = (i2 & 2) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j2;
        long jM6850getUnspecified0d7_KjU2 = (i2 & 4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j3;
        long jM6850getUnspecified0d7_KjU3 = (i2 & 8) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1498555081, i, -1, "androidx.compose.material3.TooltipDefaults.richTooltipColors (Tooltip.kt:538)");
        }
        RichTooltipColors richTooltipColorsM4023copyjRlVdoo = getDefaultRichTooltipColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m4023copyjRlVdoo(j5, jM6850getUnspecified0d7_KjU, jM6850getUnspecified0d7_KjU2, jM6850getUnspecified0d7_KjU3);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return richTooltipColorsM4023copyjRlVdoo;
    }

    public final RichTooltipColors getDefaultRichTooltipColors$material3(ColorScheme colorScheme) {
        RichTooltipColors defaultRichTooltipColorsCached = colorScheme.getDefaultRichTooltipColorsCached();
        if (defaultRichTooltipColorsCached != null) {
            return defaultRichTooltipColorsCached;
        }
        RichTooltipColors richTooltipColors = new RichTooltipColors(ColorSchemeKt.fromToken(colorScheme, RichTooltipTokens.INSTANCE.getContainerColor()), ColorSchemeKt.fromToken(colorScheme, RichTooltipTokens.INSTANCE.getSupportingTextColor()), ColorSchemeKt.fromToken(colorScheme, RichTooltipTokens.INSTANCE.getSubheadColor()), ColorSchemeKt.fromToken(colorScheme, RichTooltipTokens.INSTANCE.getActionLabelTextColor()), null);
        colorScheme.setDefaultRichTooltipColorsCached$material3(richTooltipColors);
        return richTooltipColors;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Deprecated in favor of rememberTooltipPositionProvider API.", replaceWith = @ReplaceWith(expression = "rememberTooltipPositionProvider(spacingBetweenTooltipAndAnchor)", imports = {}))
    /* JADX INFO: renamed from: rememberPlainTooltipPositionProvider-kHDZbjc, reason: not valid java name */
    public final PopupPositionProvider m4736rememberPlainTooltipPositionProviderkHDZbjc(float f, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1047866909, "C(rememberPlainTooltipPositionProvider)N(spacingBetweenTooltipAndAnchor:c#ui.unit.Dp)574@23802L7,575@23873L898:Tooltip.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            f = TooltipKt.getSpacingBetweenTooltipAndAnchor();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1047866909, i, -1, "androidx.compose.material3.TooltipDefaults.rememberPlainTooltipPositionProvider (Tooltip.kt:572)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        final int iMo748roundToPx0680j_4 = ((Density) objConsume).mo748roundToPx0680j_4(f);
        ComposerKt.sourceInformationMarkerStart(composer, 1977762303, "CC(remember):Tooltip.kt#9igjgp");
        boolean zChanged = composer.changed(iMo748roundToPx0680j_4);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new PopupPositionProvider() { // from class: androidx.compose.material3.TooltipDefaults$rememberPlainTooltipPositionProvider$1$1
                @Override // androidx.compose.ui.window.PopupPositionProvider
                /* JADX INFO: renamed from: calculatePosition-llwVHH4 */
                public long mo718calculatePositionllwVHH4(IntRect anchorBounds, long windowSize, LayoutDirection layoutDirection, long popupContentSize) {
                    int left = anchorBounds.getLeft() + ((anchorBounds.getWidth() - ((int) (popupContentSize >> 32))) / 2);
                    int top = (anchorBounds.getTop() - ((int) (popupContentSize & 4294967295L))) - iMo748roundToPx0680j_4;
                    if (top < 0) {
                        top = anchorBounds.getBottom() + iMo748roundToPx0680j_4;
                    }
                    return IntOffset.m9809constructorimpl((((long) left) << 32) | (((long) top) & 4294967295L));
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        TooltipDefaults$rememberPlainTooltipPositionProvider$1$1 tooltipDefaults$rememberPlainTooltipPositionProvider$1$1 = (TooltipDefaults$rememberPlainTooltipPositionProvider$1$1) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return tooltipDefaults$rememberPlainTooltipPositionProvider$1$1;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Deprecated in favor of rememberTooltipPositionProvider API.", replaceWith = @ReplaceWith(expression = "rememberTooltipPositionProvider(spacingBetweenTooltipAndAnchor)", imports = {}))
    /* JADX INFO: renamed from: rememberRichTooltipPositionProvider-kHDZbjc, reason: not valid java name */
    public final PopupPositionProvider m4737rememberRichTooltipPositionProviderkHDZbjc(float f, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -1538806795, "C(rememberRichTooltipPositionProvider)N(spacingBetweenTooltipAndAnchor:c#ui.unit.Dp)613@25533L7,614@25604L1458:Tooltip.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            f = TooltipKt.getSpacingBetweenTooltipAndAnchor();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1538806795, i, -1, "androidx.compose.material3.TooltipDefaults.rememberRichTooltipPositionProvider (Tooltip.kt:611)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        final int iMo748roundToPx0680j_4 = ((Density) objConsume).mo748roundToPx0680j_4(f);
        ComposerKt.sourceInformationMarkerStart(composer, -1324569625, "CC(remember):Tooltip.kt#9igjgp");
        boolean zChanged = composer.changed(iMo748roundToPx0680j_4);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new PopupPositionProvider() { // from class: androidx.compose.material3.TooltipDefaults$rememberRichTooltipPositionProvider$1$1
                @Override // androidx.compose.ui.window.PopupPositionProvider
                /* JADX INFO: renamed from: calculatePosition-llwVHH4 */
                public long mo718calculatePositionllwVHH4(IntRect anchorBounds, long windowSize, LayoutDirection layoutDirection, long popupContentSize) {
                    int left = anchorBounds.getLeft();
                    int i3 = (int) (popupContentSize >> 32);
                    if (left + i3 > ((int) (windowSize >> 32)) && (left = anchorBounds.getRight() - i3) < 0) {
                        left = anchorBounds.getLeft() + ((anchorBounds.getWidth() - i3) / 2);
                    }
                    int top = (anchorBounds.getTop() - ((int) (popupContentSize & 4294967295L))) - iMo748roundToPx0680j_4;
                    if (top < 0) {
                        top = anchorBounds.getBottom() + iMo748roundToPx0680j_4;
                    }
                    return IntOffset.m9809constructorimpl((((long) left) << 32) | (((long) top) & 4294967295L));
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        TooltipDefaults$rememberRichTooltipPositionProvider$1$1 tooltipDefaults$rememberRichTooltipPositionProvider$1$1 = (TooltipDefaults$rememberRichTooltipPositionProvider$1$1) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return tooltipDefaults$rememberRichTooltipPositionProvider$1$1;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Deprecated in favor of rememberTooltipPositionProvider API that takes a preferred positioning. Please use rememberTooltipPositionProvider with TooltipAnchorPosition.Above if this same behavior is desired.", replaceWith = @ReplaceWith(expression = "rememberTooltipPositionProvider(TooltipAnchorPosition.ABOVE, spacingBetweenTooltipAndAnchor)", imports = {}))
    /* JADX INFO: renamed from: rememberTooltipPositionProvider-kHDZbjc, reason: not valid java name */
    public final PopupPositionProvider m4739rememberTooltipPositionProviderkHDZbjc(float f, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -1613894159, "C(rememberTooltipPositionProvider)N(spacingBetweenTooltipAndAnchor:c#ui.unit.Dp)666@28083L7,667@28154L1618:Tooltip.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            f = TooltipKt.getSpacingBetweenTooltipAndAnchor();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1613894159, i, -1, "androidx.compose.material3.TooltipDefaults.rememberTooltipPositionProvider (Tooltip.kt:664)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        final int iMo748roundToPx0680j_4 = ((Density) objConsume).mo748roundToPx0680j_4(f);
        ComposerKt.sourceInformationMarkerStart(composer, -469082365, "CC(remember):Tooltip.kt#9igjgp");
        boolean zChanged = composer.changed(iMo748roundToPx0680j_4);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new PopupPositionProvider() { // from class: androidx.compose.material3.TooltipDefaults$rememberTooltipPositionProvider$1$1
                @Override // androidx.compose.ui.window.PopupPositionProvider
                /* JADX INFO: renamed from: calculatePosition-llwVHH4 */
                public long mo718calculatePositionllwVHH4(IntRect anchorBounds, long windowSize, LayoutDirection layoutDirection, long popupContentSize) {
                    int i3 = (int) (popupContentSize >> 32);
                    int left = anchorBounds.getLeft() + ((anchorBounds.getWidth() - i3) / 2);
                    if (left < 0) {
                        left = anchorBounds.getLeft();
                    } else if (left + i3 > ((int) (windowSize >> 32))) {
                        left = anchorBounds.getRight() - i3;
                    }
                    int top = (anchorBounds.getTop() - ((int) (popupContentSize & 4294967295L))) - iMo748roundToPx0680j_4;
                    if (top < 0) {
                        top = anchorBounds.getBottom() + iMo748roundToPx0680j_4;
                    }
                    return IntOffset.m9809constructorimpl((((long) left) << 32) | (((long) top) & 4294967295L));
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        TooltipDefaults$rememberTooltipPositionProvider$1$1 tooltipDefaults$rememberTooltipPositionProvider$1$1 = (TooltipDefaults$rememberTooltipPositionProvider$1$1) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return tooltipDefaults$rememberTooltipPositionProvider$1$1;
    }

    /* JADX INFO: renamed from: rememberTooltipPositionProvider-Hu5FAss, reason: not valid java name */
    public final PopupPositionProvider m4738rememberTooltipPositionProviderHu5FAss(int i, float f, Composer composer, int i2, int i3) {
        ComposerKt.sourceInformationMarkerStart(composer, -573803578, "C(rememberTooltipPositionProvider)N(positioning:c#material3.TooltipAnchorPosition,spacingBetweenTooltipAndAnchor:c#ui.unit.Dp)716@30477L7,717@30583L7,718@30620L172:Tooltip.kt#uh7d8r");
        if ((i3 & 2) != 0) {
            f = TooltipKt.getSpacingBetweenTooltipAndAnchor();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-573803578, i2, -1, "androidx.compose.material3.TooltipDefaults.rememberTooltipPositionProvider (Tooltip.kt:714)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        int iMo748roundToPx0680j_4 = ((Density) objConsume).mo748roundToPx0680j_4(f);
        ProvidableCompositionLocal<WindowInfo> localWindowInfo = CompositionLocalsKt.getLocalWindowInfo();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume2 = composer.consume(localWindowInfo);
        ComposerKt.sourceInformationMarkerEnd(composer);
        long jMo8777getContainerSizeYbymL2g = ((WindowInfo) objConsume2).mo8777getContainerSizeYbymL2g();
        ComposerKt.sourceInformationMarkerStart(composer, -1669411694, "CC(remember):Tooltip.kt#9igjgp");
        boolean zChanged = composer.changed(iMo748roundToPx0680j_4) | ((((i2 & 14) ^ 6) > 4 && composer.changed(i)) || (i2 & 6) == 4) | composer.changed(jMo8777getContainerSizeYbymL2g);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            TooltipPositionProviderImpl tooltipPositionProviderImpl = new TooltipPositionProviderImpl(i, iMo748roundToPx0680j_4, jMo8777getContainerSizeYbymL2g, null);
            composer.updateRememberedValue(tooltipPositionProviderImpl);
            objRememberedValue = tooltipPositionProviderImpl;
        }
        TooltipPositionProviderImpl tooltipPositionProviderImpl2 = (TooltipPositionProviderImpl) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return tooltipPositionProviderImpl2;
    }

    public final DefaultTooltipCaretShape getDefaultCaretShape$material3() {
        return DefaultCaretShape;
    }

    static {
        long jM9709DpSizeYgX7TsA = DpKt.m9709DpSizeYgX7TsA(Dp.m9687constructorimpl(16), Dp.m9687constructorimpl(8));
        caretSize = jM9709DpSizeYgX7TsA;
        plainTooltipMaxWidth = Dp.m9687constructorimpl(200);
        richTooltipMaxWidth = Dp.m9687constructorimpl(BoxRequestsFile.DownloadThumbnail.SIZE_320);
        DefaultCaretShape = new DefaultTooltipCaretShape(jM9709DpSizeYgX7TsA, null);
    }
}
