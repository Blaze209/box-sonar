package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.tokens.ButtonLargeTokens;
import androidx.compose.material3.tokens.ButtonMediumTokens;
import androidx.compose.material3.tokens.ButtonSmallTokens;
import androidx.compose.material3.tokens.ButtonXLargeTokens;
import androidx.compose.material3.tokens.ButtonXSmallTokens;
import androidx.compose.material3.tokens.ElevatedButtonTokens;
import androidx.compose.material3.tokens.FilledButtonTokens;
import androidx.compose.material3.tokens.OutlinedButtonTokens;
import androidx.compose.material3.tokens.TonalButtonTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* JADX INFO: compiled from: ToggleButton.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0013\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0014\u001a\u00020\u0015H\u0007¢\u0006\u0002\u0010\u0016J1\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0018H\u0007¢\u0006\u0002\u0010\u001bJ\r\u0010@\u001a\u00020AH\u0007¢\u0006\u0002\u0010BJK\u0010@\u001a\u00020A2\b\b\u0002\u0010C\u001a\u00020D2\b\b\u0002\u0010E\u001a\u00020D2\b\b\u0002\u0010F\u001a\u00020D2\b\b\u0002\u0010G\u001a\u00020D2\b\b\u0002\u0010H\u001a\u00020D2\b\b\u0002\u0010I\u001a\u00020DH\u0007¢\u0006\u0004\bJ\u0010KJ\r\u0010P\u001a\u00020AH\u0007¢\u0006\u0002\u0010BJK\u0010P\u001a\u00020A2\b\b\u0002\u0010C\u001a\u00020D2\b\b\u0002\u0010E\u001a\u00020D2\b\b\u0002\u0010F\u001a\u00020D2\b\b\u0002\u0010G\u001a\u00020D2\b\b\u0002\u0010H\u001a\u00020D2\b\b\u0002\u0010I\u001a\u00020DH\u0007¢\u0006\u0004\bQ\u0010KJ\r\u0010T\u001a\u00020AH\u0007¢\u0006\u0002\u0010BJK\u0010T\u001a\u00020A2\b\b\u0002\u0010C\u001a\u00020D2\b\b\u0002\u0010E\u001a\u00020D2\b\b\u0002\u0010F\u001a\u00020D2\b\b\u0002\u0010G\u001a\u00020D2\b\b\u0002\u0010H\u001a\u00020D2\b\b\u0002\u0010I\u001a\u00020DH\u0007¢\u0006\u0004\bU\u0010KJ\r\u0010X\u001a\u00020AH\u0007¢\u0006\u0002\u0010BJK\u0010X\u001a\u00020A2\b\b\u0002\u0010C\u001a\u00020D2\b\b\u0002\u0010E\u001a\u00020D2\b\b\u0002\u0010F\u001a\u00020D2\b\b\u0002\u0010G\u001a\u00020D2\b\b\u0002\u0010H\u001a\u00020D2\b\b\u0002\u0010I\u001a\u00020DH\u0007¢\u0006\u0004\bY\u0010KJ\u0017\u0010\\\u001a\u00020\u00152\u0006\u0010]\u001a\u00020\u0005H\u0007¢\u0006\u0004\b^\u0010_R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\u000b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0013\u0010\f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\r\u0010\u0007R\u0013\u0010\u000e\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u001c\u001a\u00020\u0015*\u00020\u001d8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020\u00188G¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0011\u0010#\u001a\u00020\u00188G¢\u0006\u0006\u001a\u0004\b$\u0010\"R\u0011\u0010\u0017\u001a\u00020\u00188G¢\u0006\u0006\u001a\u0004\b%\u0010\"R\u0011\u0010\u0019\u001a\u00020\u00188G¢\u0006\u0006\u001a\u0004\b&\u0010\"R\u0011\u0010\u001a\u001a\u00020\u00188G¢\u0006\u0006\u001a\u0004\b'\u0010\"R\u0011\u0010(\u001a\u00020\u00188G¢\u0006\u0006\u001a\u0004\b)\u0010\"R\u0011\u0010*\u001a\u00020\u00188G¢\u0006\u0006\u001a\u0004\b+\u0010\"R\u0011\u0010,\u001a\u00020\u00188G¢\u0006\u0006\u001a\u0004\b-\u0010\"R\u0011\u0010.\u001a\u00020\u00188G¢\u0006\u0006\u001a\u0004\b/\u0010\"R\u0011\u00100\u001a\u00020\u00188G¢\u0006\u0006\u001a\u0004\b1\u0010\"R\u0011\u00102\u001a\u00020\u00188G¢\u0006\u0006\u001a\u0004\b3\u0010\"R\u0011\u00104\u001a\u00020\u00188G¢\u0006\u0006\u001a\u0004\b5\u0010\"R\u0011\u00106\u001a\u00020\u00188G¢\u0006\u0006\u001a\u0004\b7\u0010\"R\u0011\u00108\u001a\u00020\u00188G¢\u0006\u0006\u001a\u0004\b9\u0010\"R\u0011\u0010:\u001a\u00020\u00188G¢\u0006\u0006\u001a\u0004\b;\u0010\"R\u0011\u0010<\u001a\u00020\u00188G¢\u0006\u0006\u001a\u0004\b=\u0010\"R\u0011\u0010>\u001a\u00020\u00188G¢\u0006\u0006\u001a\u0004\b?\u0010\"R\u0018\u0010L\u001a\u00020A*\u00020M8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bN\u0010OR\u0018\u0010R\u001a\u00020A*\u00020M8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bS\u0010OR\u0018\u0010V\u001a\u00020A*\u00020M8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bW\u0010OR\u0018\u0010Z\u001a\u00020A*\u00020M8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b[\u0010O¨\u0006`"}, d2 = {"Landroidx/compose/material3/ToggleButtonDefaults;", "", "<init>", "()V", "MinHeight", "Landroidx/compose/ui/unit/Dp;", "getMinHeight-D9Ej5fM", "()F", "F", "ToggleButtonStartPadding", "ToggleButtonEndPadding", "ButtonVerticalPadding", "IconSpacing", "getIconSpacing-D9Ej5fM", "IconSize", "getIconSize-D9Ej5fM", "ContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "shapes", "Landroidx/compose/material3/ToggleButtonShapes;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/ToggleButtonShapes;", "shape", "Landroidx/compose/ui/graphics/Shape;", "pressedShape", "checkedShape", "(Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ToggleButtonShapes;", "defaultToggleButtonShapes", "Landroidx/compose/material3/Shapes;", "getDefaultToggleButtonShapes$material3", "(Landroidx/compose/material3/Shapes;)Landroidx/compose/material3/ToggleButtonShapes;", "roundShape", "getRoundShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "squareShape", "getSquareShape", "getShape", "getPressedShape", "getCheckedShape", "extraSmallSquareShape", "getExtraSmallSquareShape", "mediumSquareShape", "getMediumSquareShape", "largeSquareShape", "getLargeSquareShape", "extraLargeSquareShape", "getExtraLargeSquareShape", "extraSmallPressedShape", "getExtraSmallPressedShape", "mediumPressedShape", "getMediumPressedShape", "largePressedShape", "getLargePressedShape", "extraLargePressedShape", "getExtraLargePressedShape", "extraSmallCheckedSquareShape", "getExtraSmallCheckedSquareShape", "mediumCheckedSquareShape", "getMediumCheckedSquareShape", "largeCheckedSquareShape", "getLargeCheckedSquareShape", "extraLargeCheckedSquareShape", "getExtraLargeCheckedSquareShape", "toggleButtonColors", "Landroidx/compose/material3/ToggleButtonColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/ToggleButtonColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "disabledContainerColor", "disabledContentColor", "checkedContainerColor", "checkedContentColor", "toggleButtonColors-5tl4gsc", "(JJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ToggleButtonColors;", "defaultToggleButtonColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultToggleButtonColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/ToggleButtonColors;", "elevatedToggleButtonColors", "elevatedToggleButtonColors-5tl4gsc", "defaultElevatedToggleButtonColors", "getDefaultElevatedToggleButtonColors$material3", "tonalToggleButtonColors", "tonalToggleButtonColors-5tl4gsc", "defaultTonalToggleButtonColors", "getDefaultTonalToggleButtonColors$material3", "outlinedToggleButtonColors", "outlinedToggleButtonColors-5tl4gsc", "defaultOutlinedToggleButtonColors", "getDefaultOutlinedToggleButtonColors$material3", "shapesFor", "buttonHeight", "shapesFor-8Feqmps", "(FLandroidx/compose/runtime/Composer;I)Landroidx/compose/material3/ToggleButtonShapes;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ToggleButtonDefaults {
    public static final int $stable = 0;
    private static final float ButtonVerticalPadding;
    private static final PaddingValues ContentPadding;
    private static final float IconSize;
    private static final float IconSpacing;
    private static final float ToggleButtonEndPadding;
    private static final float ToggleButtonStartPadding;
    public static final ToggleButtonDefaults INSTANCE = new ToggleButtonDefaults();
    private static final float MinHeight = ButtonSmallTokens.INSTANCE.m5175getContainerHeightD9Ej5fM();

    private ToggleButtonDefaults() {
    }

    static {
        float fM5178getLeadingSpaceD9Ej5fM = ButtonSmallTokens.INSTANCE.m5178getLeadingSpaceD9Ej5fM();
        ToggleButtonStartPadding = fM5178getLeadingSpaceD9Ej5fM;
        float fM5180getTrailingSpaceD9Ej5fM = ButtonSmallTokens.INSTANCE.m5180getTrailingSpaceD9Ej5fM();
        ToggleButtonEndPadding = fM5180getTrailingSpaceD9Ej5fM;
        float fM9687constructorimpl = Dp.m9687constructorimpl(8);
        ButtonVerticalPadding = fM9687constructorimpl;
        IconSpacing = ButtonSmallTokens.INSTANCE.m5176getIconLabelSpaceD9Ej5fM();
        IconSize = ButtonSmallTokens.INSTANCE.m5177getIconSizeD9Ej5fM();
        ContentPadding = PaddingKt.m1214PaddingValuesa9UjIt4(fM5178getLeadingSpaceD9Ej5fM, fM9687constructorimpl, fM5180getTrailingSpaceD9Ej5fM, fM9687constructorimpl);
    }

    /* JADX INFO: renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m4606getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* JADX INFO: renamed from: getIconSpacing-D9Ej5fM, reason: not valid java name */
    public final float m4605getIconSpacingD9Ej5fM() {
        return IconSpacing;
    }

    /* JADX INFO: renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m4604getIconSizeD9Ej5fM() {
        return IconSize;
    }

    public final PaddingValues getContentPadding() {
        return ContentPadding;
    }

    public final ToggleButtonShapes shapes(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -908956393, "C(shapes)414@21073L6:ToggleButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-908956393, i, -1, "androidx.compose.material3.ToggleButtonDefaults.shapes (ToggleButton.kt:414)");
        }
        ToggleButtonShapes defaultToggleButtonShapes$material3 = getDefaultToggleButtonShapes$material3(MaterialTheme.INSTANCE.getShapes(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultToggleButtonShapes$material3;
    }

    public final ToggleButtonShapes shapes(Shape shape, Shape shape2, Shape shape3, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 708154610, "C(shapes)N(shape,pressedShape,checkedShape)430@21679L6:ToggleButton.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            shape = null;
        }
        if ((i2 & 2) != 0) {
            shape2 = null;
        }
        if ((i2 & 4) != 0) {
            shape3 = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(708154610, i, -1, "androidx.compose.material3.ToggleButtonDefaults.shapes (ToggleButton.kt:430)");
        }
        ToggleButtonShapes toggleButtonShapesCopy = getDefaultToggleButtonShapes$material3(MaterialTheme.INSTANCE.getShapes(composer, 6)).copy(shape, shape2, shape3);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return toggleButtonShapesCopy;
    }

    public final ToggleButtonShapes getDefaultToggleButtonShapes$material3(Shapes shapes) {
        ToggleButtonShapes defaultToggleButtonShapesCached = shapes.getDefaultToggleButtonShapesCached();
        if (defaultToggleButtonShapesCached != null) {
            return defaultToggleButtonShapesCached;
        }
        ToggleButtonShapes toggleButtonShapes = new ToggleButtonShapes(ShapesKt.fromToken(shapes, ButtonSmallTokens.INSTANCE.getContainerShapeRound()), RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(6)), ShapesKt.fromToken(shapes, ButtonSmallTokens.INSTANCE.getSelectedContainerShapeSquare()));
        shapes.setDefaultToggleButtonShapesCached$material3(toggleButtonShapes);
        return toggleButtonShapes;
    }

    public final Shape getRoundShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1185355301, "C(<get-roundShape>)449@22534L5:ToggleButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1185355301, i, -1, "androidx.compose.material3.ToggleButtonDefaults.<get-roundShape> (ToggleButton.kt:449)");
        }
        Shape value = ShapesKt.getValue(ButtonSmallTokens.INSTANCE.getContainerShapeRound(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getSquareShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 72021741, "C(<get-squareShape>)453@22719L5:ToggleButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(72021741, i, -1, "androidx.compose.material3.ToggleButtonDefaults.<get-squareShape> (ToggleButton.kt:453)");
        }
        Shape value = ShapesKt.getValue(ButtonSmallTokens.INSTANCE.getContainerShapeSquare(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 613821363, "C(<get-shape>)457@22871L5:ToggleButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(613821363, i, -1, "androidx.compose.material3.ToggleButtonDefaults.<get-shape> (ToggleButton.kt:457)");
        }
        Shape value = ShapesKt.getValue(ButtonSmallTokens.INSTANCE.getContainerShapeRound(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getPressedShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1385815397, "C(<get-pressedShape>):ToggleButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1385815397, i, -1, "androidx.compose.material3.ToggleButtonDefaults.<get-pressedShape> (ToggleButton.kt:461)");
        }
        RoundedCornerShape roundedCornerShapeM1573RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return roundedCornerShapeM1573RoundedCornerShape0680j_4;
    }

    public final Shape getCheckedShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1560635515, "C(<get-checkedShape>)465@23175L5:ToggleButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1560635515, i, -1, "androidx.compose.material3.ToggleButtonDefaults.<get-checkedShape> (ToggleButton.kt:465)");
        }
        Shape value = ShapesKt.getValue(ButtonSmallTokens.INSTANCE.getSelectedContainerShapeSquare(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getExtraSmallSquareShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -2098062181, "C(<get-extraSmallSquareShape>)469@23355L5:ToggleButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2098062181, i, -1, "androidx.compose.material3.ToggleButtonDefaults.<get-extraSmallSquareShape> (ToggleButton.kt:469)");
        }
        Shape value = ShapesKt.getValue(ButtonXSmallTokens.INSTANCE.getContainerShapeSquare(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getMediumSquareShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 904721879, "C(<get-mediumSquareShape>)473@23526L5:ToggleButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(904721879, i, -1, "androidx.compose.material3.ToggleButtonDefaults.<get-mediumSquareShape> (ToggleButton.kt:473)");
        }
        Shape value = ShapesKt.getValue(ButtonMediumTokens.INSTANCE.getContainerShapeSquare(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getLargeSquareShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -872190043, "C(<get-largeSquareShape>)477@23694L5:ToggleButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-872190043, i, -1, "androidx.compose.material3.ToggleButtonDefaults.<get-largeSquareShape> (ToggleButton.kt:477)");
        }
        Shape value = ShapesKt.getValue(ButtonLargeTokens.INSTANCE.getContainerShapeSquare(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getExtraLargeSquareShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1619300349, "C(<get-extraLargeSquareShape>)481@23874L5:ToggleButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1619300349, i, -1, "androidx.compose.material3.ToggleButtonDefaults.<get-extraLargeSquareShape> (ToggleButton.kt:481)");
        }
        Shape value = ShapesKt.getValue(ButtonXLargeTokens.INSTANCE.getContainerShapeSquare(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getExtraSmallPressedShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1550187515, "C(<get-extraSmallPressedShape>)485@24057L5:ToggleButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1550187515, i, -1, "androidx.compose.material3.ToggleButtonDefaults.<get-extraSmallPressedShape> (ToggleButton.kt:485)");
        }
        Shape value = ShapesKt.getValue(ButtonXSmallTokens.INSTANCE.getPressedContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getMediumPressedShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 186887365, "C(<get-mediumPressedShape>)489@24231L5:ToggleButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(186887365, i, -1, "androidx.compose.material3.ToggleButtonDefaults.<get-mediumPressedShape> (ToggleButton.kt:489)");
        }
        Shape value = ShapesKt.getValue(ButtonMediumTokens.INSTANCE.getPressedContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getLargePressedShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 811908737, "C(<get-largePressedShape>)493@24402L5:ToggleButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(811908737, i, -1, "androidx.compose.material3.ToggleButtonDefaults.<get-largePressedShape> (ToggleButton.kt:493)");
        }
        Shape value = ShapesKt.getValue(ButtonLargeTokens.INSTANCE.getPressedContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getExtraLargePressedShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1887476091, "C(<get-extraLargePressedShape>)497@24585L5:ToggleButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1887476091, i, -1, "androidx.compose.material3.ToggleButtonDefaults.<get-extraLargePressedShape> (ToggleButton.kt:497)");
        }
        Shape value = ShapesKt.getValue(ButtonXLargeTokens.INSTANCE.getPressedContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getExtraSmallCheckedSquareShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1161276741, "C(<get-extraSmallCheckedSquareShape>)501@24780L5:ToggleButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1161276741, i, -1, "androidx.compose.material3.ToggleButtonDefaults.<get-extraSmallCheckedSquareShape> (ToggleButton.kt:501)");
        }
        Shape value = ShapesKt.getValue(ButtonXSmallTokens.INSTANCE.getContainerShapeSquare(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getMediumCheckedSquareShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -163559803, "C(<get-mediumCheckedSquareShape>)505@24966L5:ToggleButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-163559803, i, -1, "androidx.compose.material3.ToggleButtonDefaults.<get-mediumCheckedSquareShape> (ToggleButton.kt:505)");
        }
        Shape value = ShapesKt.getValue(ButtonMediumTokens.INSTANCE.getContainerShapeSquare(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getLargeCheckedSquareShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 2008029189, "C(<get-largeCheckedSquareShape>)509@25149L5:ToggleButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2008029189, i, -1, "androidx.compose.material3.ToggleButtonDefaults.<get-largeCheckedSquareShape> (ToggleButton.kt:509)");
        }
        Shape value = ShapesKt.getValue(ButtonLargeTokens.INSTANCE.getContainerShapeSquare(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getExtraLargeCheckedSquareShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -812664635, "C(<get-extraLargeCheckedSquareShape>)513@25344L5:ToggleButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-812664635, i, -1, "androidx.compose.material3.ToggleButtonDefaults.<get-extraLargeCheckedSquareShape> (ToggleButton.kt:513)");
        }
        Shape value = ShapesKt.getValue(ButtonXLargeTokens.INSTANCE.getContainerShapeSquare(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final ToggleButtonColors toggleButtonColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1477900181, "C(toggleButtonColors)519@25552L11:ToggleButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1477900181, i, -1, "androidx.compose.material3.ToggleButtonDefaults.toggleButtonColors (ToggleButton.kt:519)");
        }
        ToggleButtonColors defaultToggleButtonColors$material3 = getDefaultToggleButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultToggleButtonColors$material3;
    }

    /* JADX INFO: renamed from: toggleButtonColors-5tl4gsc, reason: not valid java name */
    public final ToggleButtonColors m4609toggleButtonColors5tl4gsc(long j, long j2, long j3, long j4, long j5, long j6, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1534216259, "C(toggleButtonColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color,checkedContainerColor:c#ui.graphics.Color,checkedContentColor:c#ui.graphics.Color)541@26708L11:ToggleButton.kt#uh7d8r");
        long jM6850getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j;
        long jM6850getUnspecified0d7_KjU2 = (i2 & 2) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j2;
        long jM6850getUnspecified0d7_KjU3 = (i2 & 4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j3;
        long jM6850getUnspecified0d7_KjU4 = (i2 & 8) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j4;
        long jM6850getUnspecified0d7_KjU5 = (i2 & 16) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j5;
        long jM6850getUnspecified0d7_KjU6 = (i2 & 32) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1534216259, i, -1, "androidx.compose.material3.ToggleButtonDefaults.toggleButtonColors (ToggleButton.kt:541)");
        }
        ToggleButtonColors toggleButtonColorsM4596copytNS2XkQ = getDefaultToggleButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m4596copytNS2XkQ(jM6850getUnspecified0d7_KjU, jM6850getUnspecified0d7_KjU2, jM6850getUnspecified0d7_KjU3, jM6850getUnspecified0d7_KjU4, jM6850getUnspecified0d7_KjU5, jM6850getUnspecified0d7_KjU6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return toggleButtonColorsM4596copytNS2XkQ;
    }

    public final ToggleButtonColors getDefaultToggleButtonColors$material3(ColorScheme colorScheme) {
        ToggleButtonColors defaultToggleButtonColorsCached = colorScheme.getDefaultToggleButtonColorsCached();
        if (defaultToggleButtonColorsCached != null) {
            return defaultToggleButtonColorsCached;
        }
        ToggleButtonColors toggleButtonColors = new ToggleButtonColors(ColorSchemeKt.fromToken(colorScheme, FilledButtonTokens.INSTANCE.getUnselectedContainerColor()), ColorSchemeKt.fromToken(colorScheme, FilledButtonTokens.INSTANCE.getUnselectedPressedLabelTextColor()), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledButtonTokens.INSTANCE.getDisabledContainerColor()), FilledButtonTokens.INSTANCE.getDisabledContainerOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledButtonTokens.INSTANCE.getDisabledLabelTextColor()), FilledButtonTokens.INSTANCE.getDisabledLabelTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, FilledButtonTokens.INSTANCE.getSelectedContainerColor()), ColorSchemeKt.fromToken(colorScheme, FilledButtonTokens.INSTANCE.getSelectedPressedLabelTextColor()), null);
        colorScheme.setDefaultToggleButtonColorsCached$material3(toggleButtonColors);
        return toggleButtonColors;
    }

    public final ToggleButtonColors elevatedToggleButtonColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1388157941, "C(elevatedToggleButtonColors)576@28517L11:ToggleButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1388157941, i, -1, "androidx.compose.material3.ToggleButtonDefaults.elevatedToggleButtonColors (ToggleButton.kt:576)");
        }
        ToggleButtonColors defaultElevatedToggleButtonColors$material3 = getDefaultElevatedToggleButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultElevatedToggleButtonColors$material3;
    }

    /* JADX INFO: renamed from: elevatedToggleButtonColors-5tl4gsc, reason: not valid java name */
    public final ToggleButtonColors m4603elevatedToggleButtonColors5tl4gsc(long j, long j2, long j3, long j4, long j5, long j6, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -1621927923, "C(elevatedToggleButtonColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color,checkedContainerColor:c#ui.graphics.Color,checkedContentColor:c#ui.graphics.Color)600@29763L11:ToggleButton.kt#uh7d8r");
        long jM6850getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j;
        long jM6850getUnspecified0d7_KjU2 = (i2 & 2) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j2;
        long jM6850getUnspecified0d7_KjU3 = (i2 & 4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j3;
        long jM6850getUnspecified0d7_KjU4 = (i2 & 8) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j4;
        long jM6850getUnspecified0d7_KjU5 = (i2 & 16) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j5;
        long jM6850getUnspecified0d7_KjU6 = (i2 & 32) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1621927923, i, -1, "androidx.compose.material3.ToggleButtonDefaults.elevatedToggleButtonColors (ToggleButton.kt:600)");
        }
        ToggleButtonColors toggleButtonColorsM4596copytNS2XkQ = getDefaultElevatedToggleButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m4596copytNS2XkQ(jM6850getUnspecified0d7_KjU, jM6850getUnspecified0d7_KjU2, jM6850getUnspecified0d7_KjU3, jM6850getUnspecified0d7_KjU4, jM6850getUnspecified0d7_KjU5, jM6850getUnspecified0d7_KjU6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return toggleButtonColorsM4596copytNS2XkQ;
    }

    public final ToggleButtonColors getDefaultElevatedToggleButtonColors$material3(ColorScheme colorScheme) {
        ToggleButtonColors defaultElevatedToggleButtonColorsCached = colorScheme.getDefaultElevatedToggleButtonColorsCached();
        if (defaultElevatedToggleButtonColorsCached != null) {
            return defaultElevatedToggleButtonColorsCached;
        }
        ToggleButtonColors toggleButtonColors = new ToggleButtonColors(ColorSchemeKt.fromToken(colorScheme, ElevatedButtonTokens.INSTANCE.getUnselectedContainerColor()), ColorSchemeKt.fromToken(colorScheme, ElevatedButtonTokens.INSTANCE.getUnselectedPressedLabelTextColor()), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, ElevatedButtonTokens.INSTANCE.getDisabledContainerColor()), ElevatedButtonTokens.INSTANCE.getDisabledContainerOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, ElevatedButtonTokens.INSTANCE.getDisabledLabelTextColor()), ElevatedButtonTokens.INSTANCE.getDisabledLabelTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, ElevatedButtonTokens.INSTANCE.getSelectedContainerColor()), ColorSchemeKt.fromToken(colorScheme, ElevatedButtonTokens.INSTANCE.getSelectedPressedLabelTextColor()), null);
        colorScheme.setDefaultElevatedToggleButtonColorsCached$material3(toggleButtonColors);
        return toggleButtonColors;
    }

    public final ToggleButtonColors tonalToggleButtonColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -793286573, "C(tonalToggleButtonColors)635@31614L11:ToggleButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-793286573, i, -1, "androidx.compose.material3.ToggleButtonDefaults.tonalToggleButtonColors (ToggleButton.kt:635)");
        }
        ToggleButtonColors defaultTonalToggleButtonColors$material3 = getDefaultTonalToggleButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultTonalToggleButtonColors$material3;
    }

    /* JADX INFO: renamed from: tonalToggleButtonColors-5tl4gsc, reason: not valid java name */
    public final ToggleButtonColors m4610tonalToggleButtonColors5tl4gsc(long j, long j2, long j3, long j4, long j5, long j6, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 241675973, "C(tonalToggleButtonColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color,checkedContainerColor:c#ui.graphics.Color,checkedContentColor:c#ui.graphics.Color)658@32824L11:ToggleButton.kt#uh7d8r");
        long jM6850getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j;
        long jM6850getUnspecified0d7_KjU2 = (i2 & 2) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j2;
        long jM6850getUnspecified0d7_KjU3 = (i2 & 4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j3;
        long jM6850getUnspecified0d7_KjU4 = (i2 & 8) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j4;
        long jM6850getUnspecified0d7_KjU5 = (i2 & 16) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j5;
        long jM6850getUnspecified0d7_KjU6 = (i2 & 32) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(241675973, i, -1, "androidx.compose.material3.ToggleButtonDefaults.tonalToggleButtonColors (ToggleButton.kt:658)");
        }
        ToggleButtonColors toggleButtonColorsM4596copytNS2XkQ = getDefaultTonalToggleButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m4596copytNS2XkQ(jM6850getUnspecified0d7_KjU, jM6850getUnspecified0d7_KjU2, jM6850getUnspecified0d7_KjU3, jM6850getUnspecified0d7_KjU4, jM6850getUnspecified0d7_KjU5, jM6850getUnspecified0d7_KjU6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return toggleButtonColorsM4596copytNS2XkQ;
    }

    public final ToggleButtonColors getDefaultTonalToggleButtonColors$material3(ColorScheme colorScheme) {
        ToggleButtonColors defaultTonalToggleButtonColorsCached = colorScheme.getDefaultTonalToggleButtonColorsCached();
        if (defaultTonalToggleButtonColorsCached != null) {
            return defaultTonalToggleButtonColorsCached;
        }
        ToggleButtonColors toggleButtonColors = new ToggleButtonColors(ColorSchemeKt.fromToken(colorScheme, TonalButtonTokens.INSTANCE.getUnselectedContainerColor()), ColorSchemeKt.fromToken(colorScheme, TonalButtonTokens.INSTANCE.getUnselectedLabelTextColor()), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, TonalButtonTokens.INSTANCE.getDisabledContainerColor()), TonalButtonTokens.INSTANCE.getDisabledContainerOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, TonalButtonTokens.INSTANCE.getDisabledLabelTextColor()), TonalButtonTokens.INSTANCE.getDisabledLabelTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, TonalButtonTokens.INSTANCE.getSelectedContainerColor()), ColorSchemeKt.fromToken(colorScheme, TonalButtonTokens.INSTANCE.getSelectedLabelTextColor()), null);
        colorScheme.setDefaultTonalToggleButtonColorsCached$material3(toggleButtonColors);
        return toggleButtonColors;
    }

    public final ToggleButtonColors outlinedToggleButtonColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -188416429, "C(outlinedToggleButtonColors)690@34547L11:ToggleButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-188416429, i, -1, "androidx.compose.material3.ToggleButtonDefaults.outlinedToggleButtonColors (ToggleButton.kt:690)");
        }
        ToggleButtonColors defaultOutlinedToggleButtonColors$material3 = getDefaultOutlinedToggleButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultOutlinedToggleButtonColors$material3;
    }

    /* JADX INFO: renamed from: outlinedToggleButtonColors-5tl4gsc, reason: not valid java name */
    public final ToggleButtonColors m4607outlinedToggleButtonColors5tl4gsc(long j, long j2, long j3, long j4, long j5, long j6, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1380079813, "C(outlinedToggleButtonColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color,checkedContainerColor:c#ui.graphics.Color,checkedContentColor:c#ui.graphics.Color)714@35793L11:ToggleButton.kt#uh7d8r");
        long jM6850getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j;
        long jM6850getUnspecified0d7_KjU2 = (i2 & 2) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j2;
        long jM6850getUnspecified0d7_KjU3 = (i2 & 4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j3;
        long jM6850getUnspecified0d7_KjU4 = (i2 & 8) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j4;
        long jM6850getUnspecified0d7_KjU5 = (i2 & 16) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j5;
        long jM6850getUnspecified0d7_KjU6 = (i2 & 32) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1380079813, i, -1, "androidx.compose.material3.ToggleButtonDefaults.outlinedToggleButtonColors (ToggleButton.kt:714)");
        }
        ToggleButtonColors toggleButtonColorsM4596copytNS2XkQ = getDefaultOutlinedToggleButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m4596copytNS2XkQ(jM6850getUnspecified0d7_KjU, jM6850getUnspecified0d7_KjU2, jM6850getUnspecified0d7_KjU3, jM6850getUnspecified0d7_KjU4, jM6850getUnspecified0d7_KjU5, jM6850getUnspecified0d7_KjU6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return toggleButtonColorsM4596copytNS2XkQ;
    }

    public final ToggleButtonColors getDefaultOutlinedToggleButtonColors$material3(ColorScheme colorScheme) {
        ToggleButtonColors defaultOutlinedToggleButtonColorsCached = colorScheme.getDefaultOutlinedToggleButtonColorsCached();
        if (defaultOutlinedToggleButtonColorsCached != null) {
            return defaultOutlinedToggleButtonColorsCached;
        }
        ToggleButtonColors toggleButtonColors = new ToggleButtonColors(Color.INSTANCE.m6849getTransparent0d7_KjU(), ColorSchemeKt.fromToken(colorScheme, OutlinedButtonTokens.INSTANCE.getUnselectedLabelTextColor()), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedButtonTokens.INSTANCE.getDisabledOutlineColor()), OutlinedButtonTokens.INSTANCE.getDisabledContainerOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedButtonTokens.INSTANCE.getDisabledLabelTextColor()), OutlinedButtonTokens.INSTANCE.getDisabledLabelTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, OutlinedButtonTokens.INSTANCE.getSelectedContainerColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedButtonTokens.INSTANCE.getSelectedLabelTextColor()), null);
        colorScheme.setDefaultOutlinedToggleButtonColorsCached$material3(toggleButtonColors);
        return toggleButtonColors;
    }

    /* JADX INFO: renamed from: shapesFor-8Feqmps, reason: not valid java name */
    public final ToggleButtonShapes m4608shapesFor8Feqmps(float f, Composer composer, int i) {
        Composer composer2;
        ToggleButtonShapes toggleButtonShapesShapes;
        ComposerKt.sourceInformationMarkerStart(composer, 176948154, "C(shapesFor)N(buttonHeight:c#ui.unit.Dp):ToggleButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(176948154, i, -1, "androidx.compose.material3.ToggleButtonDefaults.shapesFor (ToggleButton.kt:748)");
        }
        float fM2860getExtraSmallContainerHeightD9Ej5fM = ButtonDefaults.INSTANCE.m2860getExtraSmallContainerHeightD9Ej5fM();
        float fM2871getMinHeightD9Ej5fM = ButtonDefaults.INSTANCE.m2871getMinHeightD9Ej5fM();
        float fM2868getMediumContainerHeightD9Ej5fM = ButtonDefaults.INSTANCE.m2868getMediumContainerHeightD9Ej5fM();
        float fM2865getLargeContainerHeightD9Ej5fM = ButtonDefaults.INSTANCE.m2865getLargeContainerHeightD9Ej5fM();
        float fM2857getExtraLargeContainerHeightD9Ej5fM = ButtonDefaults.INSTANCE.m2857getExtraLargeContainerHeightD9Ej5fM();
        float f2 = 2;
        if (Dp.m9686compareTo0680j_4(f, Dp.m9687constructorimpl(Dp.m9687constructorimpl(fM2860getExtraSmallContainerHeightD9Ej5fM + fM2871getMinHeightD9Ej5fM) / f2)) <= 0) {
            composer.startReplaceGroup(-1751500654);
            ComposerKt.sourceInformation(composer, "757@37995L5,758@38037L22,759@38096L28,756@37959L184");
            int i2 = (i >> 3) & 14;
            composer2 = composer;
            toggleButtonShapesShapes = shapes(getShape(composer, i2), getExtraSmallPressedShape(composer, i2), getExtraSmallCheckedSquareShape(composer, i2), composer2, (i << 6) & 7168, 0);
            composer.endReplaceGroup();
        } else if (Dp.m9686compareTo0680j_4(f, Dp.m9687constructorimpl(Dp.m9687constructorimpl(fM2871getMinHeightD9Ej5fM + fM2868getMediumContainerHeightD9Ej5fM) / f2)) <= 0) {
            composer.startReplaceGroup(-1751492862);
            ComposerKt.sourceInformation(composer, "761@38208L8");
            toggleButtonShapesShapes = shapes(composer, (i >> 3) & 14);
            composer.endReplaceGroup();
            composer2 = composer;
        } else if (Dp.m9686compareTo0680j_4(f, Dp.m9687constructorimpl(Dp.m9687constructorimpl(fM2868getMediumContainerHeightD9Ej5fM + fM2865getLargeContainerHeightD9Ej5fM) / f2)) <= 0) {
            composer.startReplaceGroup(-1751489846);
            ComposerKt.sourceInformation(composer, "764@38333L5,765@38375L18,766@38430L24,763@38297L176");
            int i3 = (i >> 3) & 14;
            composer2 = composer;
            toggleButtonShapesShapes = shapes(getShape(composer, i3), getMediumPressedShape(composer, i3), getMediumCheckedSquareShape(composer, i3), composer2, (i << 6) & 7168, 0);
            composer.endReplaceGroup();
        } else if (Dp.m9686compareTo0680j_4(f, Dp.m9687constructorimpl(Dp.m9687constructorimpl(fM2865getLargeContainerHeightD9Ej5fM + fM2857getExtraLargeContainerHeightD9Ej5fM) / f2)) <= 0) {
            composer.startReplaceGroup(-1751481624);
            ComposerKt.sourceInformation(composer, "770@38590L5,771@38632L17,772@38686L23,769@38554L174");
            int i4 = (i >> 3) & 14;
            composer2 = composer;
            toggleButtonShapesShapes = shapes(getShape(composer, i4), getLargePressedShape(composer, i4), getLargeCheckedSquareShape(composer, i4), composer2, (i << 6) & 7168, 0);
            composer2.endReplaceGroup();
        } else {
            composer2 = composer;
            composer2.startReplaceGroup(-1751474862);
            ComposerKt.sourceInformation(composer2, "776@38801L5,777@38843L22,778@38902L28,775@38765L184");
            int i5 = (i >> 3) & 14;
            toggleButtonShapesShapes = shapes(getShape(composer2, i5), getExtraLargePressedShape(composer2, i5), getExtraLargeCheckedSquareShape(composer2, i5), composer2, (i << 6) & 7168, 0);
            composer2.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return toggleButtonShapesShapes;
    }
}
