package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.ScrimTokens;
import androidx.compose.material3.tokens.SheetBottomTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: SheetDefaults.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JA\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u000f2\b\b\u0002\u0010&\u001a\u00020\u000f2\b\b\u0002\u0010'\u001a\u00020\u00052\b\b\u0002\u0010(\u001a\u00020\u000bH\u0007¢\u0006\u0004\b)\u0010*R\u0011\u0010\u0004\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u000b8G¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u00020\u000f¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0013\u001a\u00020\u000b8G¢\u0006\u0006\u001a\u0004\b\u0014\u0010\rR\u0013\u0010\u0015\u001a\u00020\u000f¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0016\u0010\u0011R\u0013\u0010\u0017\u001a\u00020\u000f¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0018\u0010\u0011R\u0011\u0010\u0019\u001a\u00020\u001a8G¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u00020\u000fX\u0080\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001e\u0010\u0011R\u0016\u0010\u001f\u001a\u00020\u000fX\u0080\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b \u0010\u0011¨\u0006+"}, d2 = {"Landroidx/compose/material3/BottomSheetDefaults;", "", "<init>", "()V", "HiddenShape", "Landroidx/compose/ui/graphics/Shape;", "getHiddenShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "ExpandedShape", "getExpandedShape", "ContainerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "Elevation", "Landroidx/compose/ui/unit/Dp;", "getElevation-D9Ej5fM", "()F", "F", "ScrimColor", "getScrimColor", "SheetPeekHeight", "getSheetPeekHeight-D9Ej5fM", "SheetMaxWidth", "getSheetMaxWidth-D9Ej5fM", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "getWindowInsets", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "PositionalThreshold", "getPositionalThreshold-D9Ej5fM$material3", "VelocityThreshold", "getVelocityThreshold-D9Ej5fM$material3", "DragHandle", "", "modifier", "Landroidx/compose/ui/Modifier;", "width", "height", "shape", "color", "DragHandle-lgZ2HuY", "(Landroidx/compose/ui/Modifier;FFLandroidx/compose/ui/graphics/Shape;JLandroidx/compose/runtime/Composer;II)V", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BottomSheetDefaults {
    public static final int $stable = 0;
    private static final float PositionalThreshold;
    private static final float SheetPeekHeight;
    public static final BottomSheetDefaults INSTANCE = new BottomSheetDefaults();
    private static final float Elevation = SheetBottomTokens.INSTANCE.m5754getDockedModalContainerElevationD9Ej5fM();
    private static final float SheetMaxWidth = Dp.m9687constructorimpl(640);
    private static final float VelocityThreshold = Dp.m9687constructorimpl(125);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DragHandle_lgZ2HuY$lambda$2(BottomSheetDefaults bottomSheetDefaults, Modifier modifier, float f, float f2, Shape shape, long j, int i, int i2, Composer composer, int i3) {
        bottomSheetDefaults.m2812DragHandlelgZ2HuY(modifier, f, f2, shape, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    private BottomSheetDefaults() {
    }

    public final Shape getHiddenShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1971658024, "C(<get-HiddenShape>)385@16214L5:SheetDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1971658024, i, -1, "androidx.compose.material3.BottomSheetDefaults.<get-HiddenShape> (SheetDefaults.kt:385)");
        }
        Shape value = ShapesKt.getValue(SheetBottomTokens.INSTANCE.getDockedMinimizedContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getExpandedShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1683783414, "C(<get-ExpandedShape>)389@16412L5:SheetDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1683783414, i, -1, "androidx.compose.material3.BottomSheetDefaults.<get-ExpandedShape> (SheetDefaults.kt:389)");
        }
        Shape value = ShapesKt.getValue(SheetBottomTokens.INSTANCE.getDockedContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final long getContainerColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 433375448, "C(<get-ContainerColor>)393@16575L5:SheetDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(433375448, i, -1, "androidx.compose.material3.BottomSheetDefaults.<get-ContainerColor> (SheetDefaults.kt:393)");
        }
        long value = ColorSchemeKt.getValue(SheetBottomTokens.INSTANCE.getDockedContainerColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    static {
        float f = 56;
        SheetPeekHeight = Dp.m9687constructorimpl(f);
        PositionalThreshold = Dp.m9687constructorimpl(f);
    }

    /* JADX INFO: renamed from: getElevation-D9Ej5fM, reason: not valid java name */
    public final float m2813getElevationD9Ej5fM() {
        return Elevation;
    }

    public final long getScrimColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -2040719176, "C(<get-ScrimColor>)400@16859L5:SheetDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2040719176, i, -1, "androidx.compose.material3.BottomSheetDefaults.<get-ScrimColor> (SheetDefaults.kt:400)");
        }
        long jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(ColorSchemeKt.getValue(ScrimTokens.INSTANCE.getContainerColor(), composer, 6), 0.32f, 0.0f, 0.0f, 0.0f, 14, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return jM6813copywmQWz5c$default;
    }

    /* JADX INFO: renamed from: getSheetPeekHeight-D9Ej5fM, reason: not valid java name */
    public final float m2816getSheetPeekHeightD9Ej5fM() {
        return SheetPeekHeight;
    }

    /* JADX INFO: renamed from: getSheetMaxWidth-D9Ej5fM, reason: not valid java name */
    public final float m2815getSheetMaxWidthD9Ej5fM() {
        return SheetMaxWidth;
    }

    public final WindowInsets getWindowInsets(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -511309409, "C(<get-windowInsets>)411@17289L11:SheetDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-511309409, i, -1, "androidx.compose.material3.BottomSheetDefaults.<get-windowInsets> (SheetDefaults.kt:411)");
        }
        WindowInsets windowInsetsM1294onlybOOhFvg = WindowInsetsKt.m1294onlybOOhFvg(WindowInsets_androidKt.getSafeDrawing(WindowInsets.INSTANCE, composer, 6), WindowInsetsSides.m1311plusgK_yJZ4(WindowInsetsSides.INSTANCE.m1319getBottomJoeWqyM(), WindowInsetsSides.INSTANCE.m1325getTopJoeWqyM()));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return windowInsetsM1294onlybOOhFvg;
    }

    /* JADX INFO: renamed from: getPositionalThreshold-D9Ej5fM$material3, reason: not valid java name */
    public final float m2814getPositionalThresholdD9Ej5fM$material3() {
        return PositionalThreshold;
    }

    /* JADX INFO: renamed from: getVelocityThreshold-D9Ej5fM$material3, reason: not valid java name */
    public final float m2817getVelocityThresholdD9Ej5fM$material3() {
        return VelocityThreshold;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x019d  */
    /* JADX WARN: Code duplicated, block: B:104:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:106:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x004e  */
    /* JADX WARN: Code duplicated, block: B:27:0x0051  */
    /* JADX WARN: Code duplicated, block: B:29:0x0055  */
    /* JADX WARN: Code duplicated, block: B:31:0x005d  */
    /* JADX WARN: Code duplicated, block: B:32:0x0060  */
    /* JADX WARN: Code duplicated, block: B:37:0x006a  */
    /* JADX WARN: Code duplicated, block: B:39:0x006e  */
    /* JADX WARN: Code duplicated, block: B:41:0x0076  */
    /* JADX WARN: Code duplicated, block: B:42:0x0079  */
    /* JADX WARN: Code duplicated, block: B:45:0x007f  */
    /* JADX WARN: Code duplicated, block: B:48:0x0085  */
    /* JADX WARN: Code duplicated, block: B:50:0x0089  */
    /* JADX WARN: Code duplicated, block: B:52:0x0091  */
    /* JADX WARN: Code duplicated, block: B:53:0x0094  */
    /* JADX WARN: Code duplicated, block: B:56:0x009a  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:65:0x00be  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:77:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:78:0x00de  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:82:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:88:0x0108  */
    /* JADX WARN: Code duplicated, block: B:91:0x011e  */
    /* JADX WARN: Code duplicated, block: B:94:0x014d  */
    /* JADX WARN: Code duplicated, block: B:96:0x0155  */
    /* JADX WARN: Code duplicated, block: B:99:0x0198  */
    /* JADX INFO: renamed from: DragHandle-lgZ2HuY, reason: not valid java name */
    public final void m2812DragHandlelgZ2HuY(Modifier modifier, float f, float f2, Shape shape, long j, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        final float fM5753getDockedDragHandleWidthD9Ej5fM;
        int i4;
        float fM5752getDockedDragHandleHeightD9Ej5fM;
        int i5;
        Shape extraLarge;
        long value;
        boolean z;
        Composer composer2;
        final Modifier.Companion companion;
        final float f3;
        final float f4;
        final Shape shape2;
        final long j2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final String strM5086getString2EP1pXo;
        boolean zChanged;
        Object objRememberedValue;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1364277227);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DragHandle)N(modifier,width:c#ui.unit.Dp,height:c#ui.unit.Dp,shape,color:c#ui.graphics.Color)426@17918L51,429@18091L82,434@18239L74,427@17978L335:SheetDefaults.kt#uh7d8r");
        int i6 = i2 & 1;
        if (i6 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        int i7 = i2 & 2;
        if (i7 == 0) {
            if ((i & 48) == 0) {
                fM5753getDockedDragHandleWidthD9Ej5fM = f;
                i3 |= composerStartRestartGroup.changed(fM5753getDockedDragHandleWidthD9Ej5fM) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    fM5752getDockedDragHandleHeightD9Ej5fM = f2;
                    if (composerStartRestartGroup.changed(fM5752getDockedDragHandleHeightD9Ej5fM)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        extraLarge = shape;
                        int i8 = composerStartRestartGroup.changed(extraLarge) ? 2048 : 1024;
                        i3 |= i8;
                    } else {
                        extraLarge = shape;
                    }
                    i3 |= i8;
                } else {
                    extraLarge = shape;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        value = j;
                        int i9 = composerStartRestartGroup.changed(value) ? 16384 : 8192;
                        i3 |= i9;
                    } else {
                        value = j;
                    }
                    i3 |= i9;
                } else {
                    value = j;
                }
                if ((i3 & 9363) != 9362) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "423@17785L6,424@17867L5");
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i6 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i7 != 0) {
                            fM5753getDockedDragHandleWidthD9Ej5fM = SheetBottomTokens.INSTANCE.m5753getDockedDragHandleWidthD9Ej5fM();
                        }
                        if (i4 != 0) {
                            fM5752getDockedDragHandleHeightD9Ej5fM = SheetBottomTokens.INSTANCE.m5752getDockedDragHandleHeightD9Ej5fM();
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            extraLarge = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getExtraLarge();
                        }
                        if ((i2 & 16) != 0) {
                            value = ColorSchemeKt.getValue(SheetBottomTokens.INSTANCE.getDockedDragHandleColor(), composerStartRestartGroup, 6);
                            i3 &= -57345;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                        }
                        companion = modifier2;
                    }
                    final float f5 = fM5752getDockedDragHandleHeightD9Ej5fM;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1364277227, i3, -1, "androidx.compose.material3.BottomSheetDefaults.DragHandle (SheetDefaults.kt:425)");
                    }
                    Strings.Companion companion2 = Strings.INSTANCE;
                    strM5086getString2EP1pXo = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_bottom_sheet_drag_handle_description), composerStartRestartGroup, 0);
                    Modifier modifierM1220paddingVpY3zN4$default = PaddingKt.m1220paddingVpY3zN4$default(companion, 0.0f, SheetDefaultsKt.DragHandleVerticalPadding, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1105373081, "CC(remember):SheetDefaults.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(strM5086getString2EP1pXo);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material3.BottomSheetDefaults$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BottomSheetDefaults.DragHandle_lgZ2HuY$lambda$0$0(strM5086getString2EP1pXo, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i10 = i3 >> 6;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m4323SurfaceT9BRK9s(SemanticsModifierKt.semantics$default(modifierM1220paddingVpY3zN4$default, false, (Function1) objRememberedValue, 1, null), extraLarge, value, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1039573072, true, new Function2() { // from class: androidx.compose.material3.BottomSheetDefaults$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BottomSheetDefaults.DragHandle_lgZ2HuY$lambda$1(fM5753getDockedDragHandleWidthD9Ej5fM, f5, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, (i10 & 112) | 12582912 | (i10 & 896), 120);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f3 = f5;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    companion = modifier2;
                    f3 = fM5752getDockedDragHandleHeightD9Ej5fM;
                }
                f4 = fM5753getDockedDragHandleWidthD9Ej5fM;
                shape2 = extraLarge;
                j2 = value;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.BottomSheetDefaults$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BottomSheetDefaults.DragHandle_lgZ2HuY$lambda$2(this.f$0, companion, f4, f3, shape2, j2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 384;
            fM5752getDockedDragHandleHeightD9Ej5fM = f2;
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    extraLarge = shape;
                    if (composerStartRestartGroup.changed(extraLarge)) {
                    }
                    i3 |= i8;
                } else {
                    extraLarge = shape;
                }
                i3 |= i8;
            } else {
                extraLarge = shape;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    value = j;
                    if (composerStartRestartGroup.changed(value)) {
                    }
                    i3 |= i9;
                } else {
                    value = j;
                }
                i3 |= i9;
            } else {
                value = j;
            }
            if ((i3 & 9363) != 9362) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "423@17785L6,424@17867L5");
                if ((i & 1) != 0) {
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i7 != 0) {
                        fM5753getDockedDragHandleWidthD9Ej5fM = SheetBottomTokens.INSTANCE.m5753getDockedDragHandleWidthD9Ej5fM();
                    }
                    if (i4 != 0) {
                        fM5752getDockedDragHandleHeightD9Ej5fM = SheetBottomTokens.INSTANCE.m5752getDockedDragHandleHeightD9Ej5fM();
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        extraLarge = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getExtraLarge();
                    }
                    if ((i2 & 16) != 0) {
                        value = ColorSchemeKt.getValue(SheetBottomTokens.INSTANCE.getDockedDragHandleColor(), composerStartRestartGroup, 6);
                        i3 &= -57345;
                    }
                } else {
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i7 != 0) {
                        fM5753getDockedDragHandleWidthD9Ej5fM = SheetBottomTokens.INSTANCE.m5753getDockedDragHandleWidthD9Ej5fM();
                    }
                    if (i4 != 0) {
                        fM5752getDockedDragHandleHeightD9Ej5fM = SheetBottomTokens.INSTANCE.m5752getDockedDragHandleHeightD9Ej5fM();
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        extraLarge = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getExtraLarge();
                    }
                    if ((i2 & 16) != 0) {
                        value = ColorSchemeKt.getValue(SheetBottomTokens.INSTANCE.getDockedDragHandleColor(), composerStartRestartGroup, 6);
                        i3 &= -57345;
                    }
                }
                final float f6 = fM5752getDockedDragHandleHeightD9Ej5fM;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1364277227, i3, -1, "androidx.compose.material3.BottomSheetDefaults.DragHandle (SheetDefaults.kt:425)");
                }
                Strings.Companion companion3 = Strings.INSTANCE;
                strM5086getString2EP1pXo = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_bottom_sheet_drag_handle_description), composerStartRestartGroup, 0);
                Modifier modifierM1220paddingVpY3zN4$default2 = PaddingKt.m1220paddingVpY3zN4$default(companion, 0.0f, SheetDefaultsKt.DragHandleVerticalPadding, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1105373081, "CC(remember):SheetDefaults.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(strM5086getString2EP1pXo);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.BottomSheetDefaults$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BottomSheetDefaults.DragHandle_lgZ2HuY$lambda$0$0(strM5086getString2EP1pXo, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.BottomSheetDefaults$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BottomSheetDefaults.DragHandle_lgZ2HuY$lambda$0$0(strM5086getString2EP1pXo, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i11 = i3 >> 6;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m4323SurfaceT9BRK9s(SemanticsModifierKt.semantics$default(modifierM1220paddingVpY3zN4$default2, false, (Function1) objRememberedValue, 1, null), extraLarge, value, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1039573072, true, new Function2() { // from class: androidx.compose.material3.BottomSheetDefaults$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BottomSheetDefaults.DragHandle_lgZ2HuY$lambda$1(fM5753getDockedDragHandleWidthD9Ej5fM, f6, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, (i11 & 112) | 12582912 | (i11 & 896), 120);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f3 = f6;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                companion = modifier2;
                f3 = fM5752getDockedDragHandleHeightD9Ej5fM;
            }
            f4 = fM5753getDockedDragHandleWidthD9Ej5fM;
            shape2 = extraLarge;
            j2 = value;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.BottomSheetDefaults$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BottomSheetDefaults.DragHandle_lgZ2HuY$lambda$2(this.f$0, companion, f4, f3, shape2, j2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        fM5753getDockedDragHandleWidthD9Ej5fM = f;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                fM5752getDockedDragHandleHeightD9Ej5fM = f2;
                if (composerStartRestartGroup.changed(fM5752getDockedDragHandleHeightD9Ej5fM)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    extraLarge = shape;
                    if (composerStartRestartGroup.changed(extraLarge)) {
                    }
                    i3 |= i8;
                } else {
                    extraLarge = shape;
                }
                i3 |= i8;
            } else {
                extraLarge = shape;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    value = j;
                    if (composerStartRestartGroup.changed(value)) {
                    }
                    i3 |= i9;
                } else {
                    value = j;
                }
                i3 |= i9;
            } else {
                value = j;
            }
            if ((i3 & 9363) != 9362) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "423@17785L6,424@17867L5");
                if ((i & 1) != 0) {
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i7 != 0) {
                        fM5753getDockedDragHandleWidthD9Ej5fM = SheetBottomTokens.INSTANCE.m5753getDockedDragHandleWidthD9Ej5fM();
                    }
                    if (i4 != 0) {
                        fM5752getDockedDragHandleHeightD9Ej5fM = SheetBottomTokens.INSTANCE.m5752getDockedDragHandleHeightD9Ej5fM();
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        extraLarge = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getExtraLarge();
                    }
                    if ((i2 & 16) != 0) {
                        value = ColorSchemeKt.getValue(SheetBottomTokens.INSTANCE.getDockedDragHandleColor(), composerStartRestartGroup, 6);
                        i3 &= -57345;
                    }
                } else {
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i7 != 0) {
                        fM5753getDockedDragHandleWidthD9Ej5fM = SheetBottomTokens.INSTANCE.m5753getDockedDragHandleWidthD9Ej5fM();
                    }
                    if (i4 != 0) {
                        fM5752getDockedDragHandleHeightD9Ej5fM = SheetBottomTokens.INSTANCE.m5752getDockedDragHandleHeightD9Ej5fM();
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        extraLarge = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getExtraLarge();
                    }
                    if ((i2 & 16) != 0) {
                        value = ColorSchemeKt.getValue(SheetBottomTokens.INSTANCE.getDockedDragHandleColor(), composerStartRestartGroup, 6);
                        i3 &= -57345;
                    }
                }
                final float f7 = fM5752getDockedDragHandleHeightD9Ej5fM;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1364277227, i3, -1, "androidx.compose.material3.BottomSheetDefaults.DragHandle (SheetDefaults.kt:425)");
                }
                Strings.Companion companion4 = Strings.INSTANCE;
                strM5086getString2EP1pXo = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_bottom_sheet_drag_handle_description), composerStartRestartGroup, 0);
                Modifier modifierM1220paddingVpY3zN4$default3 = PaddingKt.m1220paddingVpY3zN4$default(companion, 0.0f, SheetDefaultsKt.DragHandleVerticalPadding, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1105373081, "CC(remember):SheetDefaults.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(strM5086getString2EP1pXo);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.BottomSheetDefaults$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BottomSheetDefaults.DragHandle_lgZ2HuY$lambda$0$0(strM5086getString2EP1pXo, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.BottomSheetDefaults$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BottomSheetDefaults.DragHandle_lgZ2HuY$lambda$0$0(strM5086getString2EP1pXo, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i12 = i3 >> 6;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m4323SurfaceT9BRK9s(SemanticsModifierKt.semantics$default(modifierM1220paddingVpY3zN4$default3, false, (Function1) objRememberedValue, 1, null), extraLarge, value, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1039573072, true, new Function2() { // from class: androidx.compose.material3.BottomSheetDefaults$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BottomSheetDefaults.DragHandle_lgZ2HuY$lambda$1(fM5753getDockedDragHandleWidthD9Ej5fM, f7, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, (i12 & 112) | 12582912 | (i12 & 896), 120);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f3 = f7;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                companion = modifier2;
                f3 = fM5752getDockedDragHandleHeightD9Ej5fM;
            }
            f4 = fM5753getDockedDragHandleWidthD9Ej5fM;
            shape2 = extraLarge;
            j2 = value;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.BottomSheetDefaults$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BottomSheetDefaults.DragHandle_lgZ2HuY$lambda$2(this.f$0, companion, f4, f3, shape2, j2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        fM5752getDockedDragHandleHeightD9Ej5fM = f2;
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                extraLarge = shape;
                if (composerStartRestartGroup.changed(extraLarge)) {
                }
                i3 |= i8;
            } else {
                extraLarge = shape;
            }
            i3 |= i8;
        } else {
            extraLarge = shape;
        }
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                value = j;
                if (composerStartRestartGroup.changed(value)) {
                }
                i3 |= i9;
            } else {
                value = j;
            }
            i3 |= i9;
        } else {
            value = j;
        }
        if ((i3 & 9363) != 9362) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "423@17785L6,424@17867L5");
            if ((i & 1) != 0) {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i7 != 0) {
                    fM5753getDockedDragHandleWidthD9Ej5fM = SheetBottomTokens.INSTANCE.m5753getDockedDragHandleWidthD9Ej5fM();
                }
                if (i4 != 0) {
                    fM5752getDockedDragHandleHeightD9Ej5fM = SheetBottomTokens.INSTANCE.m5752getDockedDragHandleHeightD9Ej5fM();
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    extraLarge = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getExtraLarge();
                }
                if ((i2 & 16) != 0) {
                    value = ColorSchemeKt.getValue(SheetBottomTokens.INSTANCE.getDockedDragHandleColor(), composerStartRestartGroup, 6);
                    i3 &= -57345;
                }
            } else {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i7 != 0) {
                    fM5753getDockedDragHandleWidthD9Ej5fM = SheetBottomTokens.INSTANCE.m5753getDockedDragHandleWidthD9Ej5fM();
                }
                if (i4 != 0) {
                    fM5752getDockedDragHandleHeightD9Ej5fM = SheetBottomTokens.INSTANCE.m5752getDockedDragHandleHeightD9Ej5fM();
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    extraLarge = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getExtraLarge();
                }
                if ((i2 & 16) != 0) {
                    value = ColorSchemeKt.getValue(SheetBottomTokens.INSTANCE.getDockedDragHandleColor(), composerStartRestartGroup, 6);
                    i3 &= -57345;
                }
            }
            final float f8 = fM5752getDockedDragHandleHeightD9Ej5fM;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1364277227, i3, -1, "androidx.compose.material3.BottomSheetDefaults.DragHandle (SheetDefaults.kt:425)");
            }
            Strings.Companion companion5 = Strings.INSTANCE;
            strM5086getString2EP1pXo = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_bottom_sheet_drag_handle_description), composerStartRestartGroup, 0);
            Modifier modifierM1220paddingVpY3zN4$default4 = PaddingKt.m1220paddingVpY3zN4$default(companion, 0.0f, SheetDefaultsKt.DragHandleVerticalPadding, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1105373081, "CC(remember):SheetDefaults.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(strM5086getString2EP1pXo);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.BottomSheetDefaults$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BottomSheetDefaults.DragHandle_lgZ2HuY$lambda$0$0(strM5086getString2EP1pXo, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.BottomSheetDefaults$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BottomSheetDefaults.DragHandle_lgZ2HuY$lambda$0$0(strM5086getString2EP1pXo, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i13 = i3 >> 6;
            composer2 = composerStartRestartGroup;
            SurfaceKt.m4323SurfaceT9BRK9s(SemanticsModifierKt.semantics$default(modifierM1220paddingVpY3zN4$default4, false, (Function1) objRememberedValue, 1, null), extraLarge, value, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1039573072, true, new Function2() { // from class: androidx.compose.material3.BottomSheetDefaults$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BottomSheetDefaults.DragHandle_lgZ2HuY$lambda$1(fM5753getDockedDragHandleWidthD9Ej5fM, f8, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, (i13 & 112) | 12582912 | (i13 & 896), 120);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            f3 = f8;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            companion = modifier2;
            f3 = fM5752getDockedDragHandleHeightD9Ej5fM;
        }
        f4 = fM5753getDockedDragHandleWidthD9Ej5fM;
        shape2 = extraLarge;
        j2 = value;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.BottomSheetDefaults$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BottomSheetDefaults.DragHandle_lgZ2HuY$lambda$2(this.f$0, companion, f4, f3, shape2, j2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DragHandle_lgZ2HuY$lambda$0$0(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DragHandle_lgZ2HuY$lambda$1(float f, float f2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C435@18253L50:SheetDefaults.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1039573072, i, -1, "androidx.compose.material3.BottomSheetDefaults.DragHandle.<anonymous> (SheetDefaults.kt:435)");
            }
            BoxKt.Box(SizeKt.m1268sizeVpY3zN4(Modifier.INSTANCE, f, f2), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
