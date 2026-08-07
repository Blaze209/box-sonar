package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.internal.Icons;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.ButtonGroupSmallTokens;
import androidx.compose.material3.tokens.ConnectedButtonGroupSmallTokens;
import androidx.compose.material3.tokens.ShapeTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: ButtonGroup.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00112\b\b\u0002\u0010#\u001a\u00020\u00112\b\b\u0002\u0010$\u001a\u00020\u0011H\u0007¢\u0006\u0002\u0010%J+\u0010&\u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00112\b\b\u0002\u0010#\u001a\u00020\u00112\b\b\u0002\u0010$\u001a\u00020\u0011H\u0007¢\u0006\u0002\u0010%J+\u0010'\u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00112\b\b\u0002\u0010#\u001a\u00020\u00112\b\b\u0002\u0010$\u001a\u00020\u0011H\u0007¢\u0006\u0002\u0010%JI\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020-2\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u0010\"\u001a\u00020\u00112\b\b\u0002\u00100\u001a\u0002012\n\b\u0002\u00102\u001a\u0004\u0018\u000103H\u0007¢\u0006\u0002\u00104R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u00020\r¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u000e\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u00118G¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00118G¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0016\u001a\u00020\u00118G¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\u0018\u001a\u00020\u00118G¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u00118G¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0013¨\u00065"}, d2 = {"Landroidx/compose/material3/ButtonGroupDefaults;", "", "<init>", "()V", "ExpandedRatio", "", "getExpandedRatio", "()F", "HorizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "getHorizontalArrangement", "()Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "ConnectedSpaceBetween", "Landroidx/compose/ui/unit/Dp;", "getConnectedSpaceBetween-D9Ej5fM", "F", "connectedLeadingButtonShape", "Landroidx/compose/ui/graphics/Shape;", "getConnectedLeadingButtonShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "connectedLeadingButtonPressShape", "getConnectedLeadingButtonPressShape", "connectedTrailingButtonShape", "getConnectedTrailingButtonShape", "connectedTrailingButtonPressShape", "getConnectedTrailingButtonPressShape", "connectedButtonCheckedShape", "Landroidx/compose/foundation/shape/RoundedCornerShape;", "getConnectedButtonCheckedShape", "()Landroidx/compose/foundation/shape/RoundedCornerShape;", "connectedMiddleButtonPressShape", "getConnectedMiddleButtonPressShape", "connectedLeadingButtonShapes", "Landroidx/compose/material3/ToggleButtonShapes;", "shape", "pressedShape", "checkedShape", "(Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ToggleButtonShapes;", "connectedMiddleButtonShapes", "connectedTrailingButtonShapes", "OverflowIndicator", "", "menuState", "Landroidx/compose/material3/ButtonGroupMenuState;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "colors", "Landroidx/compose/material3/IconButtonColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Landroidx/compose/material3/ButtonGroupMenuState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/IconButtonColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ButtonGroupDefaults {
    public static final int $stable = 0;
    public static final ButtonGroupDefaults INSTANCE = new ButtonGroupDefaults();
    private static final float ExpandedRatio = 0.15f;
    private static final Arrangement.Horizontal HorizontalArrangement = Arrangement.INSTANCE.m1073spacedBy0680j_4(ButtonGroupSmallTokens.INSTANCE.m5161getBetweenSpaceD9Ej5fM());
    private static final float ConnectedSpaceBetween = ConnectedButtonGroupSmallTokens.INSTANCE.m5309getBetweenSpaceD9Ej5fM();
    private static final RoundedCornerShape connectedButtonCheckedShape = ShapeTokens.INSTANCE.getCornerFull();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OverflowIndicator$lambda$2(ButtonGroupDefaults buttonGroupDefaults, ButtonGroupMenuState buttonGroupMenuState, Modifier modifier, boolean z, Shape shape, IconButtonColors iconButtonColors, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        buttonGroupDefaults.OverflowIndicator(buttonGroupMenuState, modifier, z, shape, iconButtonColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    private ButtonGroupDefaults() {
    }

    public final float getExpandedRatio() {
        return ExpandedRatio;
    }

    public final Arrangement.Horizontal getHorizontalArrangement() {
        return HorizontalArrangement;
    }

    /* JADX INFO: renamed from: getConnectedSpaceBetween-D9Ej5fM, reason: not valid java name */
    public final float m2882getConnectedSpaceBetweenD9Ej5fM() {
        return ConnectedSpaceBetween;
    }

    public final Shape getConnectedLeadingButtonShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1246076717, "C(<get-connectedLeadingButtonShape>):ButtonGroup.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1246076717, i, -1, "androidx.compose.material3.ButtonGroupDefaults.<get-connectedLeadingButtonShape> (ButtonGroup.kt:311)");
        }
        RoundedCornerShape roundedCornerShape = new RoundedCornerShape(ShapeDefaults.INSTANCE.getCornerFull$material3(), ConnectedButtonGroupSmallTokens.INSTANCE.getInnerCornerCornerSize(), ConnectedButtonGroupSmallTokens.INSTANCE.getInnerCornerCornerSize(), ShapeDefaults.INSTANCE.getCornerFull$material3());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return roundedCornerShape;
    }

    public final Shape getConnectedLeadingButtonPressShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1457991935, "C(<get-connectedLeadingButtonPressShape>):ButtonGroup.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1457991935, i, -1, "androidx.compose.material3.ButtonGroupDefaults.<get-connectedLeadingButtonPressShape> (ButtonGroup.kt:322)");
        }
        RoundedCornerShape roundedCornerShape = new RoundedCornerShape(ShapeDefaults.INSTANCE.getCornerFull$material3(), ConnectedButtonGroupSmallTokens.INSTANCE.getPressedInnerCornerCornerSize(), ConnectedButtonGroupSmallTokens.INSTANCE.getPressedInnerCornerCornerSize(), ShapeDefaults.INSTANCE.getCornerFull$material3());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return roundedCornerShape;
    }

    public final Shape getConnectedTrailingButtonShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -2057653407, "C(<get-connectedTrailingButtonShape>):ButtonGroup.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2057653407, i, -1, "androidx.compose.material3.ButtonGroupDefaults.<get-connectedTrailingButtonShape> (ButtonGroup.kt:333)");
        }
        RoundedCornerShape roundedCornerShape = new RoundedCornerShape(ConnectedButtonGroupSmallTokens.INSTANCE.getInnerCornerCornerSize(), ShapeDefaults.INSTANCE.getCornerFull$material3(), ShapeDefaults.INSTANCE.getCornerFull$material3(), ConnectedButtonGroupSmallTokens.INSTANCE.getInnerCornerCornerSize());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return roundedCornerShape;
    }

    public final Shape getConnectedTrailingButtonPressShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -52557273, "C(<get-connectedTrailingButtonPressShape>):ButtonGroup.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-52557273, i, -1, "androidx.compose.material3.ButtonGroupDefaults.<get-connectedTrailingButtonPressShape> (ButtonGroup.kt:344)");
        }
        RoundedCornerShape roundedCornerShape = new RoundedCornerShape(ConnectedButtonGroupSmallTokens.INSTANCE.getPressedInnerCornerCornerSize(), ShapeDefaults.INSTANCE.getCornerFull$material3(), ShapeDefaults.INSTANCE.getCornerFull$material3(), ConnectedButtonGroupSmallTokens.INSTANCE.getPressedInnerCornerCornerSize());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return roundedCornerShape;
    }

    public final RoundedCornerShape getConnectedButtonCheckedShape() {
        return connectedButtonCheckedShape;
    }

    public final Shape getConnectedMiddleButtonPressShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -285671115, "C(<get-connectedMiddleButtonPressShape>):ButtonGroup.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-285671115, i, -1, "androidx.compose.material3.ButtonGroupDefaults.<get-connectedMiddleButtonPressShape> (ButtonGroup.kt:357)");
        }
        RoundedCornerShape RoundedCornerShape = RoundedCornerShapeKt.RoundedCornerShape(ConnectedButtonGroupSmallTokens.INSTANCE.getPressedInnerCornerCornerSize());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return RoundedCornerShape;
    }

    public final ToggleButtonShapes connectedLeadingButtonShapes(Shape shape, Shape shape2, Shape shape3, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -1795302403, "C(connectedLeadingButtonShapes)N(shape,pressedShape,checkedShape)362@18106L27,363@18165L32:ButtonGroup.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            shape = getConnectedLeadingButtonShape(composer, (i >> 9) & 14);
        }
        if ((i2 & 2) != 0) {
            shape2 = getConnectedLeadingButtonPressShape(composer, (i >> 9) & 14);
        }
        if ((i2 & 4) != 0) {
            shape3 = connectedButtonCheckedShape;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1795302403, i, -1, "androidx.compose.material3.ButtonGroupDefaults.connectedLeadingButtonShapes (ButtonGroup.kt:366)");
        }
        ToggleButtonShapes toggleButtonShapes = new ToggleButtonShapes(shape, shape2, shape3);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return toggleButtonShapes;
    }

    public final ToggleButtonShapes connectedMiddleButtonShapes(Shape shape, Shape shape2, Shape shape3, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -669854558, "C(connectedMiddleButtonShapes)N(shape,pressedShape,checkedShape)375@18699L31:ButtonGroup.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            shape = ShapeDefaults.INSTANCE.getSmall();
        }
        if ((i2 & 2) != 0) {
            shape2 = getConnectedMiddleButtonPressShape(composer, (i >> 9) & 14);
        }
        if ((i2 & 4) != 0) {
            shape3 = connectedButtonCheckedShape;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-669854558, i, -1, "androidx.compose.material3.ButtonGroupDefaults.connectedMiddleButtonShapes (ButtonGroup.kt:378)");
        }
        ToggleButtonShapes toggleButtonShapes = new ToggleButtonShapes(shape, shape2, shape3);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return toggleButtonShapes;
    }

    public final ToggleButtonShapes connectedTrailingButtonShapes(Shape shape, Shape shape2, Shape shape3, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1136219689, "C(connectedTrailingButtonShapes)N(shape,pressedShape,checkedShape)383@19080L28,384@19140L33:ButtonGroup.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            shape = getConnectedTrailingButtonShape(composer, (i >> 9) & 14);
        }
        if ((i2 & 2) != 0) {
            shape2 = getConnectedTrailingButtonPressShape(composer, (i >> 9) & 14);
        }
        if ((i2 & 4) != 0) {
            shape3 = connectedButtonCheckedShape;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1136219689, i, -1, "androidx.compose.material3.ButtonGroupDefaults.connectedTrailingButtonShapes (ButtonGroup.kt:387)");
        }
        ToggleButtonShapes toggleButtonShapes = new ToggleButtonShapes(shape, shape2, shape3);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return toggleButtonShapes;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0123  */
    /* JADX WARN: Code duplicated, block: B:103:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:105:0x01be  */
    /* JADX WARN: Code duplicated, block: B:108:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0042  */
    /* JADX WARN: Code duplicated, block: B:24:0x0045  */
    /* JADX WARN: Code duplicated, block: B:26:0x0049  */
    /* JADX WARN: Code duplicated, block: B:28:0x0051  */
    /* JADX WARN: Code duplicated, block: B:29:0x0054  */
    /* JADX WARN: Code duplicated, block: B:34:0x005e  */
    /* JADX WARN: Code duplicated, block: B:36:0x0062  */
    /* JADX WARN: Code duplicated, block: B:38:0x006a  */
    /* JADX WARN: Code duplicated, block: B:39:0x006d  */
    /* JADX WARN: Code duplicated, block: B:42:0x0073  */
    /* JADX WARN: Code duplicated, block: B:45:0x0079  */
    /* JADX WARN: Code duplicated, block: B:47:0x007d  */
    /* JADX WARN: Code duplicated, block: B:49:0x0085  */
    /* JADX WARN: Code duplicated, block: B:50:0x0088  */
    /* JADX WARN: Code duplicated, block: B:53:0x008e  */
    /* JADX WARN: Code duplicated, block: B:56:0x0096  */
    /* JADX WARN: Code duplicated, block: B:57:0x0098  */
    /* JADX WARN: Code duplicated, block: B:59:0x009b  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:68:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:84:0x00eb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:85:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:86:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:88:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:91:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:94:0x0108  */
    /* JADX WARN: Code duplicated, block: B:96:0x0112  */
    /* JADX WARN: Code duplicated, block: B:97:0x0118  */
    public final void OverflowIndicator(final ButtonGroupMenuState buttonGroupMenuState, Modifier modifier, boolean z, Shape shape, IconButtonColors iconButtonColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        int i5;
        Shape filledShape;
        IconButtonColors iconButtonColorsFilledIconButtonColors;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        int i7;
        boolean z3;
        Composer composer2;
        final Modifier modifier3;
        final boolean z4;
        final Shape shape2;
        final IconButtonColors iconButtonColors2;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        final Modifier modifier4;
        MutableInteractionSource mutableInteractionSource4;
        final boolean z5;
        final Shape shape3;
        final IconButtonColors iconButtonColors3;
        Composer composerStartRestartGroup = composer.startRestartGroup(1050099185);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OverflowIndicator)N(menuState,modifier,enabled,shape,colors,interactionSource)416@21000L41,420@21126L60,421@21210L45,422@21277L22,423@21311L697,418@21051L957:ButtonGroup.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(buttonGroupMenuState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i8 = i2 & 2;
        if (i8 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        filledShape = shape;
                        int i9 = composerStartRestartGroup.changed(filledShape) ? 2048 : 1024;
                        i3 |= i9;
                    } else {
                        filledShape = shape;
                    }
                    i3 |= i9;
                } else {
                    filledShape = shape;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        iconButtonColorsFilledIconButtonColors = iconButtonColors;
                        int i10 = composerStartRestartGroup.changed(iconButtonColorsFilledIconButtonColors) ? 16384 : 8192;
                        i3 |= i10;
                    } else {
                        iconButtonColorsFilledIconButtonColors = iconButtonColors;
                    }
                    i3 |= i10;
                } else {
                    iconButtonColorsFilledIconButtonColors = iconButtonColors;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    if ((196608 & i) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                            i7 = 131072;
                        } else {
                            i7 = 65536;
                        }
                        i3 |= i7;
                    }
                    if ((74899 & i3) != 74898) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "412@20805L11,413@20872L24");
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i8 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                                filledShape = IconButtonDefaults.INSTANCE.getFilledShape(composerStartRestartGroup, 6);
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                iconButtonColorsFilledIconButtonColors = IconButtonDefaults.INSTANCE.filledIconButtonColors(composerStartRestartGroup, 6);
                            }
                            if (i6 != 0) {
                                mutableInteractionSource4 = null;
                                modifier4 = companion;
                                z5 = z2;
                                shape3 = filledShape;
                                iconButtonColors3 = iconButtonColorsFilledIconButtonColors;
                            } else {
                                modifier4 = companion;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1050099185, i3, -1, "androidx.compose.material3.ButtonGroupDefaults.OverflowIndicator (ButtonGroup.kt:415)");
                            }
                            Strings.Companion companion2 = Strings.INSTANCE;
                            final String strM5086getString2EP1pXo = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_button_group_more_options), composerStartRestartGroup, 0);
                            final MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource4;
                            Modifier modifier5 = modifier4;
                            boolean z6 = z5;
                            Shape shape4 = shape3;
                            IconButtonColors iconButtonColors4 = iconButtonColors3;
                            TooltipKt.TooltipBox(TooltipDefaults.INSTANCE.m4738rememberTooltipPositionProviderHu5FAss(TooltipAnchorPosition.INSTANCE.m4725getAbovelOKsHw4(), 0.0f, composerStartRestartGroup, 390, 2), ComposableLambdaKt.rememberComposableLambda(-1592749658, true, new Function3() { // from class: androidx.compose.material3.ButtonGroupDefaults$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return ButtonGroupDefaults.OverflowIndicator$lambda$0(strM5086getString2EP1pXo, (TooltipScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54), TooltipKt.rememberTooltipState(false, false, null, composerStartRestartGroup, 0, 7), null, null, false, false, false, ComposableLambdaKt.rememberComposableLambda(-519192434, true, new Function2() { // from class: androidx.compose.material3.ButtonGroupDefaults$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ButtonGroupDefaults.OverflowIndicator$lambda$1(buttonGroupMenuState, modifier4, z5, shape3, iconButtonColors3, mutableInteractionSource5, strM5086getString2EP1pXo, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, 100663344, 248);
                            composer2 = composerStartRestartGroup;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier5;
                            z4 = z6;
                            shape2 = shape4;
                            iconButtonColors2 = iconButtonColors4;
                            mutableInteractionSource3 = mutableInteractionSource5;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                            modifier4 = modifier2;
                        }
                        shape3 = filledShape;
                        iconButtonColors3 = iconButtonColorsFilledIconButtonColors;
                        mutableInteractionSource4 = mutableInteractionSource2;
                        z5 = z2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1050099185, i3, -1, "androidx.compose.material3.ButtonGroupDefaults.OverflowIndicator (ButtonGroup.kt:415)");
                        }
                        Strings.Companion companion3 = Strings.INSTANCE;
                        final String strM5086getString2EP1pXo2 = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_button_group_more_options), composerStartRestartGroup, 0);
                        final MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource4;
                        Modifier modifier6 = modifier4;
                        boolean z7 = z5;
                        Shape shape5 = shape3;
                        IconButtonColors iconButtonColors5 = iconButtonColors3;
                        TooltipKt.TooltipBox(TooltipDefaults.INSTANCE.m4738rememberTooltipPositionProviderHu5FAss(TooltipAnchorPosition.INSTANCE.m4725getAbovelOKsHw4(), 0.0f, composerStartRestartGroup, 390, 2), ComposableLambdaKt.rememberComposableLambda(-1592749658, true, new Function3() { // from class: androidx.compose.material3.ButtonGroupDefaults$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return ButtonGroupDefaults.OverflowIndicator$lambda$0(strM5086getString2EP1pXo2, (TooltipScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), TooltipKt.rememberTooltipState(false, false, null, composerStartRestartGroup, 0, 7), null, null, false, false, false, ComposableLambdaKt.rememberComposableLambda(-519192434, true, new Function2() { // from class: androidx.compose.material3.ButtonGroupDefaults$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ButtonGroupDefaults.OverflowIndicator$lambda$1(buttonGroupMenuState, modifier4, z5, shape3, iconButtonColors3, mutableInteractionSource6, strM5086getString2EP1pXo2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, 100663344, 248);
                        composer2 = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier6;
                        z4 = z7;
                        shape2 = shape5;
                        iconButtonColors2 = iconButtonColors5;
                        mutableInteractionSource3 = mutableInteractionSource6;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier3 = modifier2;
                        z4 = z2;
                        shape2 = filledShape;
                        iconButtonColors2 = iconButtonColorsFilledIconButtonColors;
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ButtonGroupDefaults$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ButtonGroupDefaults.OverflowIndicator$lambda$2(this.f$0, buttonGroupMenuState, modifier3, z4, shape2, iconButtonColors2, mutableInteractionSource3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((74899 & i3) != 74898) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "412@20805L11,413@20872L24");
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            filledShape = IconButtonDefaults.INSTANCE.getFilledShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            iconButtonColorsFilledIconButtonColors = IconButtonDefaults.INSTANCE.filledIconButtonColors(composerStartRestartGroup, 6);
                        }
                        if (i6 != 0) {
                            mutableInteractionSource4 = null;
                            modifier4 = companion;
                            z5 = z2;
                            shape3 = filledShape;
                            iconButtonColors3 = iconButtonColorsFilledIconButtonColors;
                        } else {
                            modifier4 = companion;
                            shape3 = filledShape;
                            iconButtonColors3 = iconButtonColorsFilledIconButtonColors;
                            mutableInteractionSource4 = mutableInteractionSource2;
                            z5 = z2;
                        }
                    } else {
                        if (i8 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            filledShape = IconButtonDefaults.INSTANCE.getFilledShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            iconButtonColorsFilledIconButtonColors = IconButtonDefaults.INSTANCE.filledIconButtonColors(composerStartRestartGroup, 6);
                        }
                        if (i6 != 0) {
                            mutableInteractionSource4 = null;
                            modifier4 = companion;
                            z5 = z2;
                            shape3 = filledShape;
                            iconButtonColors3 = iconButtonColorsFilledIconButtonColors;
                        } else {
                            modifier4 = companion;
                            shape3 = filledShape;
                            iconButtonColors3 = iconButtonColorsFilledIconButtonColors;
                            mutableInteractionSource4 = mutableInteractionSource2;
                            z5 = z2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1050099185, i3, -1, "androidx.compose.material3.ButtonGroupDefaults.OverflowIndicator (ButtonGroup.kt:415)");
                    }
                    Strings.Companion companion4 = Strings.INSTANCE;
                    final String strM5086getString2EP1pXo3 = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_button_group_more_options), composerStartRestartGroup, 0);
                    final MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource4;
                    Modifier modifier7 = modifier4;
                    boolean z8 = z5;
                    Shape shape6 = shape3;
                    IconButtonColors iconButtonColors6 = iconButtonColors3;
                    TooltipKt.TooltipBox(TooltipDefaults.INSTANCE.m4738rememberTooltipPositionProviderHu5FAss(TooltipAnchorPosition.INSTANCE.m4725getAbovelOKsHw4(), 0.0f, composerStartRestartGroup, 390, 2), ComposableLambdaKt.rememberComposableLambda(-1592749658, true, new Function3() { // from class: androidx.compose.material3.ButtonGroupDefaults$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return ButtonGroupDefaults.OverflowIndicator$lambda$0(strM5086getString2EP1pXo3, (TooltipScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), TooltipKt.rememberTooltipState(false, false, null, composerStartRestartGroup, 0, 7), null, null, false, false, false, ComposableLambdaKt.rememberComposableLambda(-519192434, true, new Function2() { // from class: androidx.compose.material3.ButtonGroupDefaults$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ButtonGroupDefaults.OverflowIndicator$lambda$1(buttonGroupMenuState, modifier4, z5, shape3, iconButtonColors3, mutableInteractionSource7, strM5086getString2EP1pXo3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 100663344, 248);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier7;
                    z4 = z8;
                    shape2 = shape6;
                    iconButtonColors2 = iconButtonColors6;
                    mutableInteractionSource3 = mutableInteractionSource7;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    z4 = z2;
                    shape2 = filledShape;
                    iconButtonColors2 = iconButtonColorsFilledIconButtonColors;
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ButtonGroupDefaults$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ButtonGroupDefaults.OverflowIndicator$lambda$2(this.f$0, buttonGroupMenuState, modifier3, z4, shape2, iconButtonColors2, mutableInteractionSource3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 384;
            z2 = z;
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    filledShape = shape;
                    if (composerStartRestartGroup.changed(filledShape)) {
                    }
                    i3 |= i9;
                } else {
                    filledShape = shape;
                }
                i3 |= i9;
            } else {
                filledShape = shape;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    iconButtonColorsFilledIconButtonColors = iconButtonColors;
                    if (composerStartRestartGroup.changed(iconButtonColorsFilledIconButtonColors)) {
                    }
                    i3 |= i10;
                } else {
                    iconButtonColorsFilledIconButtonColors = iconButtonColors;
                }
                i3 |= i10;
            } else {
                iconButtonColorsFilledIconButtonColors = iconButtonColors;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                if ((74899 & i3) != 74898) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "412@20805L11,413@20872L24");
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            filledShape = IconButtonDefaults.INSTANCE.getFilledShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            iconButtonColorsFilledIconButtonColors = IconButtonDefaults.INSTANCE.filledIconButtonColors(composerStartRestartGroup, 6);
                        }
                        if (i6 != 0) {
                            mutableInteractionSource4 = null;
                            modifier4 = companion;
                            z5 = z2;
                            shape3 = filledShape;
                            iconButtonColors3 = iconButtonColorsFilledIconButtonColors;
                        } else {
                            modifier4 = companion;
                            shape3 = filledShape;
                            iconButtonColors3 = iconButtonColorsFilledIconButtonColors;
                            mutableInteractionSource4 = mutableInteractionSource2;
                            z5 = z2;
                        }
                    } else {
                        if (i8 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            filledShape = IconButtonDefaults.INSTANCE.getFilledShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            iconButtonColorsFilledIconButtonColors = IconButtonDefaults.INSTANCE.filledIconButtonColors(composerStartRestartGroup, 6);
                        }
                        if (i6 != 0) {
                            mutableInteractionSource4 = null;
                            modifier4 = companion;
                            z5 = z2;
                            shape3 = filledShape;
                            iconButtonColors3 = iconButtonColorsFilledIconButtonColors;
                        } else {
                            modifier4 = companion;
                            shape3 = filledShape;
                            iconButtonColors3 = iconButtonColorsFilledIconButtonColors;
                            mutableInteractionSource4 = mutableInteractionSource2;
                            z5 = z2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1050099185, i3, -1, "androidx.compose.material3.ButtonGroupDefaults.OverflowIndicator (ButtonGroup.kt:415)");
                    }
                    Strings.Companion companion5 = Strings.INSTANCE;
                    final String strM5086getString2EP1pXo4 = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_button_group_more_options), composerStartRestartGroup, 0);
                    final MutableInteractionSource mutableInteractionSource8 = mutableInteractionSource4;
                    Modifier modifier8 = modifier4;
                    boolean z9 = z5;
                    Shape shape7 = shape3;
                    IconButtonColors iconButtonColors7 = iconButtonColors3;
                    TooltipKt.TooltipBox(TooltipDefaults.INSTANCE.m4738rememberTooltipPositionProviderHu5FAss(TooltipAnchorPosition.INSTANCE.m4725getAbovelOKsHw4(), 0.0f, composerStartRestartGroup, 390, 2), ComposableLambdaKt.rememberComposableLambda(-1592749658, true, new Function3() { // from class: androidx.compose.material3.ButtonGroupDefaults$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return ButtonGroupDefaults.OverflowIndicator$lambda$0(strM5086getString2EP1pXo4, (TooltipScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), TooltipKt.rememberTooltipState(false, false, null, composerStartRestartGroup, 0, 7), null, null, false, false, false, ComposableLambdaKt.rememberComposableLambda(-519192434, true, new Function2() { // from class: androidx.compose.material3.ButtonGroupDefaults$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ButtonGroupDefaults.OverflowIndicator$lambda$1(buttonGroupMenuState, modifier4, z5, shape3, iconButtonColors3, mutableInteractionSource8, strM5086getString2EP1pXo4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 100663344, 248);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier8;
                    z4 = z9;
                    shape2 = shape7;
                    iconButtonColors2 = iconButtonColors7;
                    mutableInteractionSource3 = mutableInteractionSource8;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    z4 = z2;
                    shape2 = filledShape;
                    iconButtonColors2 = iconButtonColorsFilledIconButtonColors;
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ButtonGroupDefaults$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ButtonGroupDefaults.OverflowIndicator$lambda$2(this.f$0, buttonGroupMenuState, modifier3, z4, shape2, iconButtonColors2, mutableInteractionSource3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((74899 & i3) != 74898) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "412@20805L11,413@20872L24");
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        filledShape = IconButtonDefaults.INSTANCE.getFilledShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        iconButtonColorsFilledIconButtonColors = IconButtonDefaults.INSTANCE.filledIconButtonColors(composerStartRestartGroup, 6);
                    }
                    if (i6 != 0) {
                        mutableInteractionSource4 = null;
                        modifier4 = companion;
                        z5 = z2;
                        shape3 = filledShape;
                        iconButtonColors3 = iconButtonColorsFilledIconButtonColors;
                    } else {
                        modifier4 = companion;
                        shape3 = filledShape;
                        iconButtonColors3 = iconButtonColorsFilledIconButtonColors;
                        mutableInteractionSource4 = mutableInteractionSource2;
                        z5 = z2;
                    }
                } else {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        filledShape = IconButtonDefaults.INSTANCE.getFilledShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        iconButtonColorsFilledIconButtonColors = IconButtonDefaults.INSTANCE.filledIconButtonColors(composerStartRestartGroup, 6);
                    }
                    if (i6 != 0) {
                        mutableInteractionSource4 = null;
                        modifier4 = companion;
                        z5 = z2;
                        shape3 = filledShape;
                        iconButtonColors3 = iconButtonColorsFilledIconButtonColors;
                    } else {
                        modifier4 = companion;
                        shape3 = filledShape;
                        iconButtonColors3 = iconButtonColorsFilledIconButtonColors;
                        mutableInteractionSource4 = mutableInteractionSource2;
                        z5 = z2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1050099185, i3, -1, "androidx.compose.material3.ButtonGroupDefaults.OverflowIndicator (ButtonGroup.kt:415)");
                }
                Strings.Companion companion6 = Strings.INSTANCE;
                final String strM5086getString2EP1pXo5 = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_button_group_more_options), composerStartRestartGroup, 0);
                final MutableInteractionSource mutableInteractionSource9 = mutableInteractionSource4;
                Modifier modifier9 = modifier4;
                boolean z10 = z5;
                Shape shape8 = shape3;
                IconButtonColors iconButtonColors8 = iconButtonColors3;
                TooltipKt.TooltipBox(TooltipDefaults.INSTANCE.m4738rememberTooltipPositionProviderHu5FAss(TooltipAnchorPosition.INSTANCE.m4725getAbovelOKsHw4(), 0.0f, composerStartRestartGroup, 390, 2), ComposableLambdaKt.rememberComposableLambda(-1592749658, true, new Function3() { // from class: androidx.compose.material3.ButtonGroupDefaults$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return ButtonGroupDefaults.OverflowIndicator$lambda$0(strM5086getString2EP1pXo5, (TooltipScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), TooltipKt.rememberTooltipState(false, false, null, composerStartRestartGroup, 0, 7), null, null, false, false, false, ComposableLambdaKt.rememberComposableLambda(-519192434, true, new Function2() { // from class: androidx.compose.material3.ButtonGroupDefaults$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ButtonGroupDefaults.OverflowIndicator$lambda$1(buttonGroupMenuState, modifier4, z5, shape3, iconButtonColors3, mutableInteractionSource9, strM5086getString2EP1pXo5, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 100663344, 248);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier9;
                z4 = z10;
                shape2 = shape8;
                iconButtonColors2 = iconButtonColors8;
                mutableInteractionSource3 = mutableInteractionSource9;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                z4 = z2;
                shape2 = filledShape;
                iconButtonColors2 = iconButtonColorsFilledIconButtonColors;
                mutableInteractionSource3 = mutableInteractionSource2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ButtonGroupDefaults$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ButtonGroupDefaults.OverflowIndicator$lambda$2(this.f$0, buttonGroupMenuState, modifier3, z4, shape2, iconButtonColors2, mutableInteractionSource3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    filledShape = shape;
                    if (composerStartRestartGroup.changed(filledShape)) {
                    }
                    i3 |= i9;
                } else {
                    filledShape = shape;
                }
                i3 |= i9;
            } else {
                filledShape = shape;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    iconButtonColorsFilledIconButtonColors = iconButtonColors;
                    if (composerStartRestartGroup.changed(iconButtonColorsFilledIconButtonColors)) {
                    }
                    i3 |= i10;
                } else {
                    iconButtonColorsFilledIconButtonColors = iconButtonColors;
                }
                i3 |= i10;
            } else {
                iconButtonColorsFilledIconButtonColors = iconButtonColors;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                if ((74899 & i3) != 74898) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "412@20805L11,413@20872L24");
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            filledShape = IconButtonDefaults.INSTANCE.getFilledShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            iconButtonColorsFilledIconButtonColors = IconButtonDefaults.INSTANCE.filledIconButtonColors(composerStartRestartGroup, 6);
                        }
                        if (i6 != 0) {
                            mutableInteractionSource4 = null;
                            modifier4 = companion;
                            z5 = z2;
                            shape3 = filledShape;
                            iconButtonColors3 = iconButtonColorsFilledIconButtonColors;
                        } else {
                            modifier4 = companion;
                            shape3 = filledShape;
                            iconButtonColors3 = iconButtonColorsFilledIconButtonColors;
                            mutableInteractionSource4 = mutableInteractionSource2;
                            z5 = z2;
                        }
                    } else {
                        if (i8 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            filledShape = IconButtonDefaults.INSTANCE.getFilledShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            iconButtonColorsFilledIconButtonColors = IconButtonDefaults.INSTANCE.filledIconButtonColors(composerStartRestartGroup, 6);
                        }
                        if (i6 != 0) {
                            mutableInteractionSource4 = null;
                            modifier4 = companion;
                            z5 = z2;
                            shape3 = filledShape;
                            iconButtonColors3 = iconButtonColorsFilledIconButtonColors;
                        } else {
                            modifier4 = companion;
                            shape3 = filledShape;
                            iconButtonColors3 = iconButtonColorsFilledIconButtonColors;
                            mutableInteractionSource4 = mutableInteractionSource2;
                            z5 = z2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1050099185, i3, -1, "androidx.compose.material3.ButtonGroupDefaults.OverflowIndicator (ButtonGroup.kt:415)");
                    }
                    Strings.Companion companion7 = Strings.INSTANCE;
                    final String strM5086getString2EP1pXo6 = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_button_group_more_options), composerStartRestartGroup, 0);
                    final MutableInteractionSource mutableInteractionSource10 = mutableInteractionSource4;
                    Modifier modifier10 = modifier4;
                    boolean z11 = z5;
                    Shape shape9 = shape3;
                    IconButtonColors iconButtonColors9 = iconButtonColors3;
                    TooltipKt.TooltipBox(TooltipDefaults.INSTANCE.m4738rememberTooltipPositionProviderHu5FAss(TooltipAnchorPosition.INSTANCE.m4725getAbovelOKsHw4(), 0.0f, composerStartRestartGroup, 390, 2), ComposableLambdaKt.rememberComposableLambda(-1592749658, true, new Function3() { // from class: androidx.compose.material3.ButtonGroupDefaults$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return ButtonGroupDefaults.OverflowIndicator$lambda$0(strM5086getString2EP1pXo6, (TooltipScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), TooltipKt.rememberTooltipState(false, false, null, composerStartRestartGroup, 0, 7), null, null, false, false, false, ComposableLambdaKt.rememberComposableLambda(-519192434, true, new Function2() { // from class: androidx.compose.material3.ButtonGroupDefaults$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ButtonGroupDefaults.OverflowIndicator$lambda$1(buttonGroupMenuState, modifier4, z5, shape3, iconButtonColors3, mutableInteractionSource10, strM5086getString2EP1pXo6, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 100663344, 248);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier10;
                    z4 = z11;
                    shape2 = shape9;
                    iconButtonColors2 = iconButtonColors9;
                    mutableInteractionSource3 = mutableInteractionSource10;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    z4 = z2;
                    shape2 = filledShape;
                    iconButtonColors2 = iconButtonColorsFilledIconButtonColors;
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ButtonGroupDefaults$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ButtonGroupDefaults.OverflowIndicator$lambda$2(this.f$0, buttonGroupMenuState, modifier3, z4, shape2, iconButtonColors2, mutableInteractionSource3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((74899 & i3) != 74898) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "412@20805L11,413@20872L24");
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        filledShape = IconButtonDefaults.INSTANCE.getFilledShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        iconButtonColorsFilledIconButtonColors = IconButtonDefaults.INSTANCE.filledIconButtonColors(composerStartRestartGroup, 6);
                    }
                    if (i6 != 0) {
                        mutableInteractionSource4 = null;
                        modifier4 = companion;
                        z5 = z2;
                        shape3 = filledShape;
                        iconButtonColors3 = iconButtonColorsFilledIconButtonColors;
                    } else {
                        modifier4 = companion;
                        shape3 = filledShape;
                        iconButtonColors3 = iconButtonColorsFilledIconButtonColors;
                        mutableInteractionSource4 = mutableInteractionSource2;
                        z5 = z2;
                    }
                } else {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        filledShape = IconButtonDefaults.INSTANCE.getFilledShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        iconButtonColorsFilledIconButtonColors = IconButtonDefaults.INSTANCE.filledIconButtonColors(composerStartRestartGroup, 6);
                    }
                    if (i6 != 0) {
                        mutableInteractionSource4 = null;
                        modifier4 = companion;
                        z5 = z2;
                        shape3 = filledShape;
                        iconButtonColors3 = iconButtonColorsFilledIconButtonColors;
                    } else {
                        modifier4 = companion;
                        shape3 = filledShape;
                        iconButtonColors3 = iconButtonColorsFilledIconButtonColors;
                        mutableInteractionSource4 = mutableInteractionSource2;
                        z5 = z2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1050099185, i3, -1, "androidx.compose.material3.ButtonGroupDefaults.OverflowIndicator (ButtonGroup.kt:415)");
                }
                Strings.Companion companion8 = Strings.INSTANCE;
                final String strM5086getString2EP1pXo7 = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_button_group_more_options), composerStartRestartGroup, 0);
                final MutableInteractionSource mutableInteractionSource11 = mutableInteractionSource4;
                Modifier modifier11 = modifier4;
                boolean z12 = z5;
                Shape shape10 = shape3;
                IconButtonColors iconButtonColors10 = iconButtonColors3;
                TooltipKt.TooltipBox(TooltipDefaults.INSTANCE.m4738rememberTooltipPositionProviderHu5FAss(TooltipAnchorPosition.INSTANCE.m4725getAbovelOKsHw4(), 0.0f, composerStartRestartGroup, 390, 2), ComposableLambdaKt.rememberComposableLambda(-1592749658, true, new Function3() { // from class: androidx.compose.material3.ButtonGroupDefaults$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return ButtonGroupDefaults.OverflowIndicator$lambda$0(strM5086getString2EP1pXo7, (TooltipScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), TooltipKt.rememberTooltipState(false, false, null, composerStartRestartGroup, 0, 7), null, null, false, false, false, ComposableLambdaKt.rememberComposableLambda(-519192434, true, new Function2() { // from class: androidx.compose.material3.ButtonGroupDefaults$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ButtonGroupDefaults.OverflowIndicator$lambda$1(buttonGroupMenuState, modifier4, z5, shape3, iconButtonColors3, mutableInteractionSource11, strM5086getString2EP1pXo7, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 100663344, 248);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier11;
                z4 = z12;
                shape2 = shape10;
                iconButtonColors2 = iconButtonColors10;
                mutableInteractionSource3 = mutableInteractionSource11;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                z4 = z2;
                shape2 = filledShape;
                iconButtonColors2 = iconButtonColorsFilledIconButtonColors;
                mutableInteractionSource3 = mutableInteractionSource2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ButtonGroupDefaults$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ButtonGroupDefaults.OverflowIndicator$lambda$2(this.f$0, buttonGroupMenuState, modifier3, z4, shape2, iconButtonColors2, mutableInteractionSource3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        z2 = z;
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                filledShape = shape;
                if (composerStartRestartGroup.changed(filledShape)) {
                }
                i3 |= i9;
            } else {
                filledShape = shape;
            }
            i3 |= i9;
        } else {
            filledShape = shape;
        }
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                iconButtonColorsFilledIconButtonColors = iconButtonColors;
                if (composerStartRestartGroup.changed(iconButtonColorsFilledIconButtonColors)) {
                }
                i3 |= i10;
            } else {
                iconButtonColorsFilledIconButtonColors = iconButtonColors;
            }
            i3 |= i10;
        } else {
            iconButtonColorsFilledIconButtonColors = iconButtonColors;
        }
        i6 = i2 & 32;
        if (i6 != 0) {
            if ((196608 & i) == 0) {
                mutableInteractionSource2 = mutableInteractionSource;
                if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
            if ((74899 & i3) != 74898) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "412@20805L11,413@20872L24");
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        filledShape = IconButtonDefaults.INSTANCE.getFilledShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        iconButtonColorsFilledIconButtonColors = IconButtonDefaults.INSTANCE.filledIconButtonColors(composerStartRestartGroup, 6);
                    }
                    if (i6 != 0) {
                        mutableInteractionSource4 = null;
                        modifier4 = companion;
                        z5 = z2;
                        shape3 = filledShape;
                        iconButtonColors3 = iconButtonColorsFilledIconButtonColors;
                    } else {
                        modifier4 = companion;
                        shape3 = filledShape;
                        iconButtonColors3 = iconButtonColorsFilledIconButtonColors;
                        mutableInteractionSource4 = mutableInteractionSource2;
                        z5 = z2;
                    }
                } else {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        filledShape = IconButtonDefaults.INSTANCE.getFilledShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        iconButtonColorsFilledIconButtonColors = IconButtonDefaults.INSTANCE.filledIconButtonColors(composerStartRestartGroup, 6);
                    }
                    if (i6 != 0) {
                        mutableInteractionSource4 = null;
                        modifier4 = companion;
                        z5 = z2;
                        shape3 = filledShape;
                        iconButtonColors3 = iconButtonColorsFilledIconButtonColors;
                    } else {
                        modifier4 = companion;
                        shape3 = filledShape;
                        iconButtonColors3 = iconButtonColorsFilledIconButtonColors;
                        mutableInteractionSource4 = mutableInteractionSource2;
                        z5 = z2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1050099185, i3, -1, "androidx.compose.material3.ButtonGroupDefaults.OverflowIndicator (ButtonGroup.kt:415)");
                }
                Strings.Companion companion9 = Strings.INSTANCE;
                final String strM5086getString2EP1pXo8 = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_button_group_more_options), composerStartRestartGroup, 0);
                final MutableInteractionSource mutableInteractionSource12 = mutableInteractionSource4;
                Modifier modifier12 = modifier4;
                boolean z13 = z5;
                Shape shape11 = shape3;
                IconButtonColors iconButtonColors11 = iconButtonColors3;
                TooltipKt.TooltipBox(TooltipDefaults.INSTANCE.m4738rememberTooltipPositionProviderHu5FAss(TooltipAnchorPosition.INSTANCE.m4725getAbovelOKsHw4(), 0.0f, composerStartRestartGroup, 390, 2), ComposableLambdaKt.rememberComposableLambda(-1592749658, true, new Function3() { // from class: androidx.compose.material3.ButtonGroupDefaults$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return ButtonGroupDefaults.OverflowIndicator$lambda$0(strM5086getString2EP1pXo8, (TooltipScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), TooltipKt.rememberTooltipState(false, false, null, composerStartRestartGroup, 0, 7), null, null, false, false, false, ComposableLambdaKt.rememberComposableLambda(-519192434, true, new Function2() { // from class: androidx.compose.material3.ButtonGroupDefaults$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ButtonGroupDefaults.OverflowIndicator$lambda$1(buttonGroupMenuState, modifier4, z5, shape3, iconButtonColors3, mutableInteractionSource12, strM5086getString2EP1pXo8, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 100663344, 248);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier12;
                z4 = z13;
                shape2 = shape11;
                iconButtonColors2 = iconButtonColors11;
                mutableInteractionSource3 = mutableInteractionSource12;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                z4 = z2;
                shape2 = filledShape;
                iconButtonColors2 = iconButtonColorsFilledIconButtonColors;
                mutableInteractionSource3 = mutableInteractionSource2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ButtonGroupDefaults$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ButtonGroupDefaults.OverflowIndicator$lambda$2(this.f$0, buttonGroupMenuState, modifier3, z4, shape2, iconButtonColors2, mutableInteractionSource3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        mutableInteractionSource2 = mutableInteractionSource;
        if ((74899 & i3) != 74898) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "412@20805L11,413@20872L24");
            if ((i & 1) != 0) {
                if (i8 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    z2 = true;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    filledShape = IconButtonDefaults.INSTANCE.getFilledShape(composerStartRestartGroup, 6);
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    iconButtonColorsFilledIconButtonColors = IconButtonDefaults.INSTANCE.filledIconButtonColors(composerStartRestartGroup, 6);
                }
                if (i6 != 0) {
                    mutableInteractionSource4 = null;
                    modifier4 = companion;
                    z5 = z2;
                    shape3 = filledShape;
                    iconButtonColors3 = iconButtonColorsFilledIconButtonColors;
                } else {
                    modifier4 = companion;
                    shape3 = filledShape;
                    iconButtonColors3 = iconButtonColorsFilledIconButtonColors;
                    mutableInteractionSource4 = mutableInteractionSource2;
                    z5 = z2;
                }
            } else {
                if (i8 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    z2 = true;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    filledShape = IconButtonDefaults.INSTANCE.getFilledShape(composerStartRestartGroup, 6);
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    iconButtonColorsFilledIconButtonColors = IconButtonDefaults.INSTANCE.filledIconButtonColors(composerStartRestartGroup, 6);
                }
                if (i6 != 0) {
                    mutableInteractionSource4 = null;
                    modifier4 = companion;
                    z5 = z2;
                    shape3 = filledShape;
                    iconButtonColors3 = iconButtonColorsFilledIconButtonColors;
                } else {
                    modifier4 = companion;
                    shape3 = filledShape;
                    iconButtonColors3 = iconButtonColorsFilledIconButtonColors;
                    mutableInteractionSource4 = mutableInteractionSource2;
                    z5 = z2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1050099185, i3, -1, "androidx.compose.material3.ButtonGroupDefaults.OverflowIndicator (ButtonGroup.kt:415)");
            }
            Strings.Companion companion10 = Strings.INSTANCE;
            final String strM5086getString2EP1pXo9 = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_button_group_more_options), composerStartRestartGroup, 0);
            final MutableInteractionSource mutableInteractionSource13 = mutableInteractionSource4;
            Modifier modifier13 = modifier4;
            boolean z14 = z5;
            Shape shape12 = shape3;
            IconButtonColors iconButtonColors12 = iconButtonColors3;
            TooltipKt.TooltipBox(TooltipDefaults.INSTANCE.m4738rememberTooltipPositionProviderHu5FAss(TooltipAnchorPosition.INSTANCE.m4725getAbovelOKsHw4(), 0.0f, composerStartRestartGroup, 390, 2), ComposableLambdaKt.rememberComposableLambda(-1592749658, true, new Function3() { // from class: androidx.compose.material3.ButtonGroupDefaults$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ButtonGroupDefaults.OverflowIndicator$lambda$0(strM5086getString2EP1pXo9, (TooltipScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), TooltipKt.rememberTooltipState(false, false, null, composerStartRestartGroup, 0, 7), null, null, false, false, false, ComposableLambdaKt.rememberComposableLambda(-519192434, true, new Function2() { // from class: androidx.compose.material3.ButtonGroupDefaults$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ButtonGroupDefaults.OverflowIndicator$lambda$1(buttonGroupMenuState, modifier4, z5, shape3, iconButtonColors3, mutableInteractionSource13, strM5086getString2EP1pXo9, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 100663344, 248);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier13;
            z4 = z14;
            shape2 = shape12;
            iconButtonColors2 = iconButtonColors12;
            mutableInteractionSource3 = mutableInteractionSource13;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            z4 = z2;
            shape2 = filledShape;
            iconButtonColors2 = iconButtonColorsFilledIconButtonColors;
            mutableInteractionSource3 = mutableInteractionSource2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ButtonGroupDefaults$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ButtonGroupDefaults.OverflowIndicator$lambda$2(this.f$0, buttonGroupMenuState, modifier3, z4, shape2, iconButtonColors2, mutableInteractionSource3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OverflowIndicator$lambda$0(final String str, TooltipScope tooltipScope, Composer composer, int i) {
        int i2;
        ComposerKt.sourceInformation(composer, "C421@21225L28,421@21212L41:ButtonGroup.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = i | ((i & 8) == 0 ? composer.changed(tooltipScope) : composer.changedInstance(tooltipScope) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1592749658, i2, -1, "androidx.compose.material3.ButtonGroupDefaults.OverflowIndicator.<anonymous> (ButtonGroup.kt:421)");
            }
            TooltipKt.m4746PlainTooltipgv3ox5I(tooltipScope, null, null, 0.0f, null, 0L, 0L, 0.0f, 0.0f, ComposableLambdaKt.rememberComposableLambda(-1424127112, true, new Function2() { // from class: androidx.compose.material3.ButtonGroupDefaults$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ButtonGroupDefaults.OverflowIndicator$lambda$0$0(str, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, (i2 & 14) | 805306368, 255);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OverflowIndicator$lambda$0$0(String str, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C421@21227L24:ButtonGroup.kt#uh7d8r");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1424127112, i, -1, "androidx.compose.material3.ButtonGroupDefaults.OverflowIndicator.<anonymous>.<anonymous> (ButtonGroup.kt:421)");
            }
            TextKt.m4494TextNvy7gAk(str, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OverflowIndicator$lambda$1(final ButtonGroupMenuState buttonGroupMenuState, Modifier modifier, boolean z, Shape shape, IconButtonColors iconButtonColors, MutableInteractionSource mutableInteractionSource, final String str, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C425@21369L202,437@21790L193,424@21325L673:ButtonGroup.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-519192434, i, -1, "androidx.compose.material3.ButtonGroupDefaults.OverflowIndicator.<anonymous> (ButtonGroup.kt:424)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, -727720680, "CC(remember):ButtonGroup.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(buttonGroupMenuState);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: androidx.compose.material3.ButtonGroupDefaults$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ButtonGroupDefaults.OverflowIndicator$lambda$1$0$0(buttonGroupMenuState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            IconButtonKt.FilledIconButton((Function0<Unit>) objRememberedValue, modifier, z, shape, iconButtonColors, mutableInteractionSource, ComposableLambdaKt.rememberComposableLambda(-833349714, true, new Function2() { // from class: androidx.compose.material3.ButtonGroupDefaults$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ButtonGroupDefaults.OverflowIndicator$lambda$1$1(str, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 1572864, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OverflowIndicator$lambda$1$0$0(ButtonGroupMenuState buttonGroupMenuState) {
        if (buttonGroupMenuState.isExpanded()) {
            buttonGroupMenuState.dismiss();
        } else {
            buttonGroupMenuState.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OverflowIndicator$lambda$1$1(String str, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C438@21812L153:ButtonGroup.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-833349714, i, -1, "androidx.compose.material3.ButtonGroupDefaults.OverflowIndicator.<anonymous>.<anonymous> (ButtonGroup.kt:438)");
            }
            IconKt.m3576Iconww6aTOc(Icons.Filled.INSTANCE.getMoreVert$material3(), str, (Modifier) null, 0L, composer, 0, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
