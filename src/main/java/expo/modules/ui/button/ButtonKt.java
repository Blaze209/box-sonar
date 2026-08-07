package expo.modules.ui.button;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.media3.common.C;
import androidx.profileinstaller.ProfileVerifier;
import androidx.window.core.layout.WindowSizeClass;
import com.facebook.hermes.intl.Constants;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.views.ComposableScope;
import expo.modules.kotlin.views.FunctionalComposableScope;
import expo.modules.ui.ModifierRegistry;
import expo.modules.ui.ShapeViewKt;
import expo.modules.ui.UtilsKt;
import expo.modules.ui.menu.ContextMenuKt;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Button.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001ae\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0007¢\u0006\u0002\u0010\u0013\u001a-\u0010\u0014\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00010\u000fH\u0007¢\u0006\u0002\u0010\u001a¨\u0006\u001b"}, d2 = {"StyledButton", "", Constants.SENSITIVITY_VARIANT, "Lexpo/modules/ui/button/ButtonVariant;", "colors", "Lexpo/modules/ui/button/ButtonColors;", "disabled", "", "onPress", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/ui/graphics/Shape;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Lexpo/modules/ui/button/ButtonVariant;Lexpo/modules/ui/button/ButtonColors;ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ButtonContent", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "props", "Lexpo/modules/ui/button/ButtonProps;", "onButtonPressed", "Lexpo/modules/ui/button/ButtonPressedEvent;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/button/ButtonProps;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "expo-ui_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ButtonKt {

    /* JADX INFO: compiled from: Button.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ButtonVariant.values().length];
            try {
                iArr[ButtonVariant.BORDERED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ButtonVariant.BORDERLESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ButtonVariant.OUTLINED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ButtonVariant.ELEVATED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ButtonContent$lambda$4(FunctionalComposableScope functionalComposableScope, ButtonProps buttonProps, Function1 function1, int i, Composer composer, int i2) {
        ButtonContent(functionalComposableScope, buttonProps, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StyledButton$lambda$0(ButtonVariant buttonVariant, ButtonColors buttonColors, boolean z, Function0 function0, Modifier modifier, Shape shape, Function3 function3, int i, int i2, Composer composer, int i3) {
        StyledButton(buttonVariant, buttonColors, z, function0, modifier, shape, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:102:0x020d  */
    /* JADX WARN: Code duplicated, block: B:104:0x025d  */
    /* JADX WARN: Code duplicated, block: B:105:0x0266  */
    /* JADX WARN: Code duplicated, block: B:107:0x0286  */
    /* JADX WARN: Code duplicated, block: B:109:0x02d6  */
    /* JADX WARN: Code duplicated, block: B:110:0x02df  */
    /* JADX WARN: Code duplicated, block: B:112:0x02ff  */
    /* JADX WARN: Code duplicated, block: B:114:0x034f  */
    /* JADX WARN: Code duplicated, block: B:115:0x0358  */
    /* JADX WARN: Code duplicated, block: B:119:0x037c  */
    /* JADX WARN: Code duplicated, block: B:122:0x0385  */
    /* JADX WARN: Code duplicated, block: B:124:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:57:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:59:0x00be  */
    /* JADX WARN: Code duplicated, block: B:61:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:62:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:66:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:67:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:69:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:71:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:72:0x00df  */
    /* JADX WARN: Code duplicated, block: B:80:0x00f8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:81:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:82:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:85:0x0106  */
    /* JADX WARN: Code duplicated, block: B:88:0x0119 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:89:0x011b  */
    /* JADX WARN: Code duplicated, block: B:91:0x011e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:92:0x0120  */
    /* JADX WARN: Code duplicated, block: B:94:0x016d  */
    /* JADX WARN: Code duplicated, block: B:95:0x0176  */
    /* JADX WARN: Code duplicated, block: B:97:0x0194  */
    /* JADX WARN: Code duplicated, block: B:99:0x01e4  */
    public static final void StyledButton(final ButtonVariant variant, final ButtonColors colors, final boolean z, final Function0<Unit> onPress, Modifier modifier, final Shape shape, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        int i5;
        Modifier.Companion companion;
        int i6;
        final Modifier modifier3;
        Shape filledTonalShape;
        Shape textShape;
        Shape outlinedShape;
        Shape elevatedShape;
        Shape shape2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(variant, "variant");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(onPress, "onPress");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(755774231);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(StyledButton)P(6!1,2,4,3,5):Button.kt#kazlex");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(variant.ordinal()) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(colors) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onPress) ? 2048 : 1024;
        }
        int i7 = i2 & 16;
        if (i7 == 0) {
            if ((i & 24576) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
            }
            if ((i2 & 32) != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(shape)) {
                    i4 = 131072;
                } else {
                    i4 = 65536;
                }
                i3 |= i4;
            }
            if ((i2 & 64) != 0) {
                i3 |= 1572864;
            } else if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(content)) {
                    i5 = 1048576;
                } else {
                    i5 = 524288;
                }
                i3 |= i5;
            }
            if ((599187 & i3) == 599186 || !composerStartRestartGroup.getSkipping()) {
                if (i7 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(755774231, i3, -1, "expo.modules.ui.button.StyledButton (Button.kt:77)");
                }
                i6 = WhenMappings.$EnumSwitchMapping$0[variant.ordinal()];
                if (i6 == 1) {
                    int i8 = i3;
                    modifier3 = companion;
                    composerStartRestartGroup.startReplaceGroup(1051834919);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "83@2523L279,79@2407L484");
                    boolean z2 = !z;
                    androidx.compose.material3.ButtonColors buttonColorsM2855filledTonalButtonColorsro_MJ88 = ButtonDefaults.INSTANCE.m2855filledTonalButtonColorsro_MJ88(UtilsKt.getCompose(colors.getContainerColor()), UtilsKt.getCompose(colors.getContentColor()), UtilsKt.getCompose(colors.getDisabledContainerColor()), UtilsKt.getCompose(colors.getDisabledContentColor()), composerStartRestartGroup, ButtonDefaults.$stable << 12, 0);
                    composerStartRestartGroup.startReplaceGroup(449584863);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "89@2842L16");
                    if (shape == null) {
                        composerStartRestartGroup = composerStartRestartGroup;
                        filledTonalShape = ButtonDefaults.INSTANCE.getFilledTonalShape(composerStartRestartGroup, ButtonDefaults.$stable);
                    } else {
                        composerStartRestartGroup = composerStartRestartGroup;
                        filledTonalShape = shape;
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    androidx.compose.material3.ButtonKt.FilledTonalButton(onPress, modifier3, z2, filledTonalShape, buttonColorsM2855filledTonalButtonColorsro_MJ88, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, content, composerStartRestartGroup, ((i8 >> 9) & 126) | ((i8 << 9) & C.ENCODING_PCM_DOUBLE), WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND);
                    composerStartRestartGroup.endReplaceGroup();
                } else if (i6 == 2) {
                    int i9 = i3;
                    modifier3 = companion;
                    composerStartRestartGroup.startReplaceGroup(1052348124);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "97@3034L272,93@2925L463");
                    boolean z3 = !z;
                    androidx.compose.material3.ButtonColors buttonColorsM2878textButtonColorsro_MJ88 = ButtonDefaults.INSTANCE.m2878textButtonColorsro_MJ88(UtilsKt.getCompose(colors.getContainerColor()), UtilsKt.getCompose(colors.getContentColor()), UtilsKt.getCompose(colors.getDisabledContainerColor()), UtilsKt.getCompose(colors.getDisabledContentColor()), composerStartRestartGroup, ButtonDefaults.$stable << 12, 0);
                    composerStartRestartGroup.startReplaceGroup(449600984);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "103@3346L9");
                    if (shape == null) {
                        composerStartRestartGroup = composerStartRestartGroup;
                        textShape = ButtonDefaults.INSTANCE.getTextShape(composerStartRestartGroup, ButtonDefaults.$stable);
                    } else {
                        composerStartRestartGroup = composerStartRestartGroup;
                        textShape = shape;
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    androidx.compose.material3.ButtonKt.TextButton(onPress, modifier3, z3, textShape, buttonColorsM2878textButtonColorsro_MJ88, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, content, composerStartRestartGroup, ((i9 >> 9) & 126) | ((i9 << 9) & C.ENCODING_PCM_DOUBLE), WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND);
                    composerStartRestartGroup.endReplaceGroup();
                } else if (i6 == 3) {
                    int i10 = i3;
                    modifier3 = companion;
                    composerStartRestartGroup.startReplaceGroup(1052839536);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "111@3533L276,107@3420L475");
                    boolean z4 = !z;
                    androidx.compose.material3.ButtonColors buttonColorsM2876outlinedButtonColorsro_MJ88 = ButtonDefaults.INSTANCE.m2876outlinedButtonColorsro_MJ88(UtilsKt.getCompose(colors.getContainerColor()), UtilsKt.getCompose(colors.getContentColor()), UtilsKt.getCompose(colors.getDisabledContainerColor()), UtilsKt.getCompose(colors.getDisabledContentColor()), composerStartRestartGroup, ButtonDefaults.$stable << 12, 0);
                    composerStartRestartGroup.startReplaceGroup(449617084);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "117@3849L13");
                    if (shape == null) {
                        composerStartRestartGroup = composerStartRestartGroup;
                        outlinedShape = ButtonDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, ButtonDefaults.$stable);
                    } else {
                        composerStartRestartGroup = composerStartRestartGroup;
                        outlinedShape = shape;
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    androidx.compose.material3.ButtonKt.OutlinedButton(onPress, modifier3, z4, outlinedShape, buttonColorsM2876outlinedButtonColorsro_MJ88, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, content, composerStartRestartGroup, ((i10 >> 9) & 126) | ((i10 << 9) & C.ENCODING_PCM_DOUBLE), WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND);
                    composerStartRestartGroup.endReplaceGroup();
                } else if (i6 != 4) {
                    composerStartRestartGroup.startReplaceGroup(1053853608);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "139@4548L268,135@4443L451");
                    boolean z5 = !z;
                    androidx.compose.material3.ButtonColors buttonColorsM2850buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m2850buttonColorsro_MJ88(UtilsKt.getCompose(colors.getContainerColor()), UtilsKt.getCompose(colors.getContentColor()), UtilsKt.getCompose(colors.getDisabledContainerColor()), UtilsKt.getCompose(colors.getDisabledContentColor()), composerStartRestartGroup, ButtonDefaults.$stable << 12, 0);
                    composerStartRestartGroup.startReplaceGroup(449649300);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "145@4856L5");
                    if (shape == null) {
                        composerStartRestartGroup = composerStartRestartGroup;
                        shape2 = ButtonDefaults.INSTANCE.getShape(composerStartRestartGroup, ButtonDefaults.$stable);
                    } else {
                        composerStartRestartGroup = composerStartRestartGroup;
                        shape2 = shape;
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    modifier3 = companion;
                    androidx.compose.material3.ButtonKt.Button(onPress, modifier3, z5, shape2, buttonColorsM2850buttonColorsro_MJ88, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, content, composerStartRestartGroup, ((i3 >> 9) & 126) | ((i3 << 9) & C.ENCODING_PCM_DOUBLE), WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    modifier3 = companion;
                    composerStartRestartGroup.startReplaceGroup(1053342480);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "125@4040L276,121@3927L475");
                    boolean z6 = !z;
                    int i11 = i3;
                    androidx.compose.material3.ButtonColors buttonColorsM2853elevatedButtonColorsro_MJ88 = ButtonDefaults.INSTANCE.m2853elevatedButtonColorsro_MJ88(UtilsKt.getCompose(colors.getContainerColor()), UtilsKt.getCompose(colors.getContentColor()), UtilsKt.getCompose(colors.getDisabledContainerColor()), UtilsKt.getCompose(colors.getDisabledContentColor()), composerStartRestartGroup, ButtonDefaults.$stable << 12, 0);
                    composerStartRestartGroup.startReplaceGroup(449633308);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "131@4356L13");
                    if (shape == null) {
                        composerStartRestartGroup = composerStartRestartGroup;
                        elevatedShape = ButtonDefaults.INSTANCE.getElevatedShape(composerStartRestartGroup, ButtonDefaults.$stable);
                    } else {
                        composerStartRestartGroup = composerStartRestartGroup;
                        elevatedShape = shape;
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    androidx.compose.material3.ButtonKt.ElevatedButton(onPress, modifier3, z6, elevatedShape, buttonColorsM2853elevatedButtonColorsro_MJ88, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, content, composerStartRestartGroup, ((i11 >> 9) & 126) | ((i11 << 9) & C.ENCODING_PCM_DOUBLE), WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND);
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.button.ButtonKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ButtonKt.StyledButton$lambda$0(variant, colors, z, onPress, modifier3, shape, content, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        modifier2 = modifier;
        if ((i2 & 32) != 0) {
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            if (composerStartRestartGroup.changed(shape)) {
                i4 = 131072;
            } else {
                i4 = 65536;
            }
            i3 |= i4;
        }
        if ((i2 & 64) != 0) {
            i3 |= 1572864;
        } else if ((i & 1572864) == 0) {
            if (composerStartRestartGroup.changedInstance(content)) {
                i5 = 1048576;
            } else {
                i5 = 524288;
            }
            i3 |= i5;
        }
        if ((599187 & i3) == 599186) {
            if (i7 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(755774231, i3, -1, "expo.modules.ui.button.StyledButton (Button.kt:77)");
            }
            i6 = WhenMappings.$EnumSwitchMapping$0[variant.ordinal()];
            if (i6 == 1) {
                int i12 = i3;
                modifier3 = companion;
                composerStartRestartGroup.startReplaceGroup(1051834919);
                ComposerKt.sourceInformation(composerStartRestartGroup, "83@2523L279,79@2407L484");
                boolean z7 = !z;
                androidx.compose.material3.ButtonColors buttonColorsM2855filledTonalButtonColorsro_MJ89 = ButtonDefaults.INSTANCE.m2855filledTonalButtonColorsro_MJ88(UtilsKt.getCompose(colors.getContainerColor()), UtilsKt.getCompose(colors.getContentColor()), UtilsKt.getCompose(colors.getDisabledContainerColor()), UtilsKt.getCompose(colors.getDisabledContentColor()), composerStartRestartGroup, ButtonDefaults.$stable << 12, 0);
                composerStartRestartGroup.startReplaceGroup(449584863);
                ComposerKt.sourceInformation(composerStartRestartGroup, "89@2842L16");
                if (shape == null) {
                    composerStartRestartGroup = composerStartRestartGroup;
                    filledTonalShape = ButtonDefaults.INSTANCE.getFilledTonalShape(composerStartRestartGroup, ButtonDefaults.$stable);
                } else {
                    composerStartRestartGroup = composerStartRestartGroup;
                    filledTonalShape = shape;
                }
                composerStartRestartGroup.endReplaceGroup();
                androidx.compose.material3.ButtonKt.FilledTonalButton(onPress, modifier3, z7, filledTonalShape, buttonColorsM2855filledTonalButtonColorsro_MJ89, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, content, composerStartRestartGroup, ((i12 >> 9) & 126) | ((i12 << 9) & C.ENCODING_PCM_DOUBLE), WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND);
                composerStartRestartGroup.endReplaceGroup();
            } else if (i6 == 2) {
                int i13 = i3;
                modifier3 = companion;
                composerStartRestartGroup.startReplaceGroup(1052348124);
                ComposerKt.sourceInformation(composerStartRestartGroup, "97@3034L272,93@2925L463");
                boolean z8 = !z;
                androidx.compose.material3.ButtonColors buttonColorsM2878textButtonColorsro_MJ89 = ButtonDefaults.INSTANCE.m2878textButtonColorsro_MJ88(UtilsKt.getCompose(colors.getContainerColor()), UtilsKt.getCompose(colors.getContentColor()), UtilsKt.getCompose(colors.getDisabledContainerColor()), UtilsKt.getCompose(colors.getDisabledContentColor()), composerStartRestartGroup, ButtonDefaults.$stable << 12, 0);
                composerStartRestartGroup.startReplaceGroup(449600984);
                ComposerKt.sourceInformation(composerStartRestartGroup, "103@3346L9");
                if (shape == null) {
                    composerStartRestartGroup = composerStartRestartGroup;
                    textShape = ButtonDefaults.INSTANCE.getTextShape(composerStartRestartGroup, ButtonDefaults.$stable);
                } else {
                    composerStartRestartGroup = composerStartRestartGroup;
                    textShape = shape;
                }
                composerStartRestartGroup.endReplaceGroup();
                androidx.compose.material3.ButtonKt.TextButton(onPress, modifier3, z8, textShape, buttonColorsM2878textButtonColorsro_MJ89, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, content, composerStartRestartGroup, ((i13 >> 9) & 126) | ((i13 << 9) & C.ENCODING_PCM_DOUBLE), WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND);
                composerStartRestartGroup.endReplaceGroup();
            } else if (i6 == 3) {
                int i14 = i3;
                modifier3 = companion;
                composerStartRestartGroup.startReplaceGroup(1052839536);
                ComposerKt.sourceInformation(composerStartRestartGroup, "111@3533L276,107@3420L475");
                boolean z9 = !z;
                androidx.compose.material3.ButtonColors buttonColorsM2876outlinedButtonColorsro_MJ89 = ButtonDefaults.INSTANCE.m2876outlinedButtonColorsro_MJ88(UtilsKt.getCompose(colors.getContainerColor()), UtilsKt.getCompose(colors.getContentColor()), UtilsKt.getCompose(colors.getDisabledContainerColor()), UtilsKt.getCompose(colors.getDisabledContentColor()), composerStartRestartGroup, ButtonDefaults.$stable << 12, 0);
                composerStartRestartGroup.startReplaceGroup(449617084);
                ComposerKt.sourceInformation(composerStartRestartGroup, "117@3849L13");
                if (shape == null) {
                    composerStartRestartGroup = composerStartRestartGroup;
                    outlinedShape = ButtonDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, ButtonDefaults.$stable);
                } else {
                    composerStartRestartGroup = composerStartRestartGroup;
                    outlinedShape = shape;
                }
                composerStartRestartGroup.endReplaceGroup();
                androidx.compose.material3.ButtonKt.OutlinedButton(onPress, modifier3, z9, outlinedShape, buttonColorsM2876outlinedButtonColorsro_MJ89, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, content, composerStartRestartGroup, ((i14 >> 9) & 126) | ((i14 << 9) & C.ENCODING_PCM_DOUBLE), WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND);
                composerStartRestartGroup.endReplaceGroup();
            } else if (i6 != 4) {
                composerStartRestartGroup.startReplaceGroup(1053853608);
                ComposerKt.sourceInformation(composerStartRestartGroup, "139@4548L268,135@4443L451");
                boolean z10 = !z;
                androidx.compose.material3.ButtonColors buttonColorsM2850buttonColorsro_MJ89 = ButtonDefaults.INSTANCE.m2850buttonColorsro_MJ88(UtilsKt.getCompose(colors.getContainerColor()), UtilsKt.getCompose(colors.getContentColor()), UtilsKt.getCompose(colors.getDisabledContainerColor()), UtilsKt.getCompose(colors.getDisabledContentColor()), composerStartRestartGroup, ButtonDefaults.$stable << 12, 0);
                composerStartRestartGroup.startReplaceGroup(449649300);
                ComposerKt.sourceInformation(composerStartRestartGroup, "145@4856L5");
                if (shape == null) {
                    composerStartRestartGroup = composerStartRestartGroup;
                    shape2 = ButtonDefaults.INSTANCE.getShape(composerStartRestartGroup, ButtonDefaults.$stable);
                } else {
                    composerStartRestartGroup = composerStartRestartGroup;
                    shape2 = shape;
                }
                composerStartRestartGroup.endReplaceGroup();
                modifier3 = companion;
                androidx.compose.material3.ButtonKt.Button(onPress, modifier3, z10, shape2, buttonColorsM2850buttonColorsro_MJ89, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, content, composerStartRestartGroup, ((i3 >> 9) & 126) | ((i3 << 9) & C.ENCODING_PCM_DOUBLE), WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                modifier3 = companion;
                composerStartRestartGroup.startReplaceGroup(1053342480);
                ComposerKt.sourceInformation(composerStartRestartGroup, "125@4040L276,121@3927L475");
                boolean z11 = !z;
                int i15 = i3;
                androidx.compose.material3.ButtonColors buttonColorsM2853elevatedButtonColorsro_MJ89 = ButtonDefaults.INSTANCE.m2853elevatedButtonColorsro_MJ88(UtilsKt.getCompose(colors.getContainerColor()), UtilsKt.getCompose(colors.getContentColor()), UtilsKt.getCompose(colors.getDisabledContainerColor()), UtilsKt.getCompose(colors.getDisabledContentColor()), composerStartRestartGroup, ButtonDefaults.$stable << 12, 0);
                composerStartRestartGroup.startReplaceGroup(449633308);
                ComposerKt.sourceInformation(composerStartRestartGroup, "131@4356L13");
                if (shape == null) {
                    composerStartRestartGroup = composerStartRestartGroup;
                    elevatedShape = ButtonDefaults.INSTANCE.getElevatedShape(composerStartRestartGroup, ButtonDefaults.$stable);
                } else {
                    composerStartRestartGroup = composerStartRestartGroup;
                    elevatedShape = shape;
                }
                composerStartRestartGroup.endReplaceGroup();
                androidx.compose.material3.ButtonKt.ElevatedButton(onPress, modifier3, z11, elevatedShape, buttonColorsM2853elevatedButtonColorsro_MJ89, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, content, composerStartRestartGroup, ((i15 >> 9) & 126) | ((i15 << 9) & C.ENCODING_PCM_DOUBLE), WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            if (i7 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(755774231, i3, -1, "expo.modules.ui.button.StyledButton (Button.kt:77)");
            }
            i6 = WhenMappings.$EnumSwitchMapping$0[variant.ordinal()];
            if (i6 == 1) {
                int i16 = i3;
                modifier3 = companion;
                composerStartRestartGroup.startReplaceGroup(1051834919);
                ComposerKt.sourceInformation(composerStartRestartGroup, "83@2523L279,79@2407L484");
                boolean z12 = !z;
                androidx.compose.material3.ButtonColors buttonColorsM2855filledTonalButtonColorsro_MJ810 = ButtonDefaults.INSTANCE.m2855filledTonalButtonColorsro_MJ88(UtilsKt.getCompose(colors.getContainerColor()), UtilsKt.getCompose(colors.getContentColor()), UtilsKt.getCompose(colors.getDisabledContainerColor()), UtilsKt.getCompose(colors.getDisabledContentColor()), composerStartRestartGroup, ButtonDefaults.$stable << 12, 0);
                composerStartRestartGroup.startReplaceGroup(449584863);
                ComposerKt.sourceInformation(composerStartRestartGroup, "89@2842L16");
                if (shape == null) {
                    composerStartRestartGroup = composerStartRestartGroup;
                    filledTonalShape = ButtonDefaults.INSTANCE.getFilledTonalShape(composerStartRestartGroup, ButtonDefaults.$stable);
                } else {
                    composerStartRestartGroup = composerStartRestartGroup;
                    filledTonalShape = shape;
                }
                composerStartRestartGroup.endReplaceGroup();
                androidx.compose.material3.ButtonKt.FilledTonalButton(onPress, modifier3, z12, filledTonalShape, buttonColorsM2855filledTonalButtonColorsro_MJ810, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, content, composerStartRestartGroup, ((i16 >> 9) & 126) | ((i16 << 9) & C.ENCODING_PCM_DOUBLE), WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND);
                composerStartRestartGroup.endReplaceGroup();
            } else if (i6 == 2) {
                int i17 = i3;
                modifier3 = companion;
                composerStartRestartGroup.startReplaceGroup(1052348124);
                ComposerKt.sourceInformation(composerStartRestartGroup, "97@3034L272,93@2925L463");
                boolean z13 = !z;
                androidx.compose.material3.ButtonColors buttonColorsM2878textButtonColorsro_MJ810 = ButtonDefaults.INSTANCE.m2878textButtonColorsro_MJ88(UtilsKt.getCompose(colors.getContainerColor()), UtilsKt.getCompose(colors.getContentColor()), UtilsKt.getCompose(colors.getDisabledContainerColor()), UtilsKt.getCompose(colors.getDisabledContentColor()), composerStartRestartGroup, ButtonDefaults.$stable << 12, 0);
                composerStartRestartGroup.startReplaceGroup(449600984);
                ComposerKt.sourceInformation(composerStartRestartGroup, "103@3346L9");
                if (shape == null) {
                    composerStartRestartGroup = composerStartRestartGroup;
                    textShape = ButtonDefaults.INSTANCE.getTextShape(composerStartRestartGroup, ButtonDefaults.$stable);
                } else {
                    composerStartRestartGroup = composerStartRestartGroup;
                    textShape = shape;
                }
                composerStartRestartGroup.endReplaceGroup();
                androidx.compose.material3.ButtonKt.TextButton(onPress, modifier3, z13, textShape, buttonColorsM2878textButtonColorsro_MJ810, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, content, composerStartRestartGroup, ((i17 >> 9) & 126) | ((i17 << 9) & C.ENCODING_PCM_DOUBLE), WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND);
                composerStartRestartGroup.endReplaceGroup();
            } else if (i6 == 3) {
                int i18 = i3;
                modifier3 = companion;
                composerStartRestartGroup.startReplaceGroup(1052839536);
                ComposerKt.sourceInformation(composerStartRestartGroup, "111@3533L276,107@3420L475");
                boolean z14 = !z;
                androidx.compose.material3.ButtonColors buttonColorsM2876outlinedButtonColorsro_MJ810 = ButtonDefaults.INSTANCE.m2876outlinedButtonColorsro_MJ88(UtilsKt.getCompose(colors.getContainerColor()), UtilsKt.getCompose(colors.getContentColor()), UtilsKt.getCompose(colors.getDisabledContainerColor()), UtilsKt.getCompose(colors.getDisabledContentColor()), composerStartRestartGroup, ButtonDefaults.$stable << 12, 0);
                composerStartRestartGroup.startReplaceGroup(449617084);
                ComposerKt.sourceInformation(composerStartRestartGroup, "117@3849L13");
                if (shape == null) {
                    composerStartRestartGroup = composerStartRestartGroup;
                    outlinedShape = ButtonDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, ButtonDefaults.$stable);
                } else {
                    composerStartRestartGroup = composerStartRestartGroup;
                    outlinedShape = shape;
                }
                composerStartRestartGroup.endReplaceGroup();
                androidx.compose.material3.ButtonKt.OutlinedButton(onPress, modifier3, z14, outlinedShape, buttonColorsM2876outlinedButtonColorsro_MJ810, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, content, composerStartRestartGroup, ((i18 >> 9) & 126) | ((i18 << 9) & C.ENCODING_PCM_DOUBLE), WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND);
                composerStartRestartGroup.endReplaceGroup();
            } else if (i6 != 4) {
                composerStartRestartGroup.startReplaceGroup(1053853608);
                ComposerKt.sourceInformation(composerStartRestartGroup, "139@4548L268,135@4443L451");
                boolean z15 = !z;
                androidx.compose.material3.ButtonColors buttonColorsM2850buttonColorsro_MJ810 = ButtonDefaults.INSTANCE.m2850buttonColorsro_MJ88(UtilsKt.getCompose(colors.getContainerColor()), UtilsKt.getCompose(colors.getContentColor()), UtilsKt.getCompose(colors.getDisabledContainerColor()), UtilsKt.getCompose(colors.getDisabledContentColor()), composerStartRestartGroup, ButtonDefaults.$stable << 12, 0);
                composerStartRestartGroup.startReplaceGroup(449649300);
                ComposerKt.sourceInformation(composerStartRestartGroup, "145@4856L5");
                if (shape == null) {
                    composerStartRestartGroup = composerStartRestartGroup;
                    shape2 = ButtonDefaults.INSTANCE.getShape(composerStartRestartGroup, ButtonDefaults.$stable);
                } else {
                    composerStartRestartGroup = composerStartRestartGroup;
                    shape2 = shape;
                }
                composerStartRestartGroup.endReplaceGroup();
                modifier3 = companion;
                androidx.compose.material3.ButtonKt.Button(onPress, modifier3, z15, shape2, buttonColorsM2850buttonColorsro_MJ810, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, content, composerStartRestartGroup, ((i3 >> 9) & 126) | ((i3 << 9) & C.ENCODING_PCM_DOUBLE), WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                modifier3 = companion;
                composerStartRestartGroup.startReplaceGroup(1053342480);
                ComposerKt.sourceInformation(composerStartRestartGroup, "125@4040L276,121@3927L475");
                boolean z16 = !z;
                int i19 = i3;
                androidx.compose.material3.ButtonColors buttonColorsM2853elevatedButtonColorsro_MJ810 = ButtonDefaults.INSTANCE.m2853elevatedButtonColorsro_MJ88(UtilsKt.getCompose(colors.getContainerColor()), UtilsKt.getCompose(colors.getContentColor()), UtilsKt.getCompose(colors.getDisabledContainerColor()), UtilsKt.getCompose(colors.getDisabledContentColor()), composerStartRestartGroup, ButtonDefaults.$stable << 12, 0);
                composerStartRestartGroup.startReplaceGroup(449633308);
                ComposerKt.sourceInformation(composerStartRestartGroup, "131@4356L13");
                if (shape == null) {
                    composerStartRestartGroup = composerStartRestartGroup;
                    elevatedShape = ButtonDefaults.INSTANCE.getElevatedShape(composerStartRestartGroup, ButtonDefaults.$stable);
                } else {
                    composerStartRestartGroup = composerStartRestartGroup;
                    elevatedShape = shape;
                }
                composerStartRestartGroup.endReplaceGroup();
                androidx.compose.material3.ButtonKt.ElevatedButton(onPress, modifier3, z16, elevatedShape, buttonColorsM2853elevatedButtonColorsro_MJ810, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, content, composerStartRestartGroup, ((i19 >> 9) & 126) | ((i19 << 9) & C.ENCODING_PCM_DOUBLE), WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.button.ButtonKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ButtonKt.StyledButton$lambda$0(variant, colors, z, onPress, modifier3, shape, content, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void ButtonContent(final FunctionalComposableScope functionalComposableScope, final ButtonProps props, final Function1<? super ButtonPressedEvent, Unit> onButtonPressed, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(onButtonPressed, "onButtonPressed");
        Composer composerStartRestartGroup = composer.startRestartGroup(1885623749);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ButtonContent)P(1)164@5336L7,170@5448L194,176@5676L83,178@5811L608,166@5347L1072:Button.kt#kazlex");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope) : composerStartRestartGroup.changedInstance(functionalComposableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onButtonPressed) ? 256 : 128;
        }
        if ((i2 & Token.DOTQUERY) != 146 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1885623749, i2, -1, "expo.modules.ui.button.ButtonContent (Button.kt:155)");
            }
            ButtonVariant variant = props.getVariant();
            final String text = props.getText();
            ButtonColors elementColors = props.getElementColors();
            final String leadingIcon = props.getLeadingIcon();
            final String trailingIcon = props.getTrailingIcon();
            Boolean disabled = props.getDisabled();
            ProvidableCompositionLocal<MutableState<Boolean>> localContextMenuExpanded = ContextMenuKt.getLocalContextMenuExpanded();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localContextMenuExpanded);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final MutableState mutableState = (MutableState) objConsume;
            if (variant == null) {
                variant = ButtonVariant.DEFAULT;
            }
            boolean zBooleanValue = disabled != null ? disabled.booleanValue() : false;
            composerStartRestartGroup.startReplaceGroup(-1633490746);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):Button.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(mutableState) | ((i2 & 896) == 256);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: expo.modules.ui.button.ButtonKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ButtonKt.ButtonContent$lambda$3$lambda$2(mutableState, onButtonPressed);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceGroup();
            StyledButton(variant, elementColors, zBooleanValue, (Function0) objRememberedValue, ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, (AppContext.$stable << 3) | (ComposableScope.$stable << 6)), ShapeViewKt.shapeFromShapeRecord(props.getShape()), ComposableLambdaKt.rememberComposableLambda(2043301413, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: expo.modules.ui.button.ButtonKt.ButtonContent.2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer3, Integer num) {
                    invoke(rowScope, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(RowScope StyledButton, Composer composer3, int i3) {
                    Intrinsics.checkNotNullParameter(StyledButton, "$this$StyledButton");
                    ComposerKt.sourceInformation(composer3, "C179@5817L598:Button.kt#kazlex");
                    if ((i3 & 17) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2043301413, i3, -1, "expo.modules.ui.button.ButtonContent.<anonymous> (Button.kt:179)");
                    }
                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                    FunctionalComposableScope functionalComposableScope2 = functionalComposableScope;
                    String str = leadingIcon;
                    String str2 = text;
                    String str3 = trailingIcon;
                    ComposerKt.sourceInformationMarkerStart(composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    Modifier.Companion companion = Modifier.INSTANCE;
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer3, 48);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer3, companion);
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor);
                    } else {
                        composer3.useNode();
                    }
                    Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composer3);
                    Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer3, 1442877254, "C180@5877L42,191@6161L10:Button.kt#kazlex");
                    functionalComposableScope2.Children(new ComposableScope(rowScopeInstance, null, null, null, 14, null), composer3, ComposableScope.$stable | (FunctionalComposableScope.$stable << 3));
                    composer3.startReplaceGroup(1709114079);
                    ComposerKt.sourceInformation(composer3, "");
                    if (str != null) {
                        ImageVector imageVector = UtilsKt.getImageVector(str);
                        composer3.startReplaceGroup(1709115683);
                        ComposerKt.sourceInformation(composer3, "*183@6007L128");
                        if (imageVector != null) {
                            IconKt.m3576Iconww6aTOc(imageVector, str, PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m9687constructorimpl(8), 0.0f, 11, null), 0L, composer3, 384, 8);
                            Unit unit = Unit.INSTANCE;
                        }
                        composer3.endReplaceGroup();
                    }
                    composer3.endReplaceGroup();
                    TextKt.m4494TextNvy7gAk(str2, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer3, 0, 0, 262142);
                    composer3.startReplaceGroup(1709122209);
                    ComposerKt.sourceInformation(composer3, "");
                    if (str3 != null) {
                        ImageVector imageVector2 = UtilsKt.getImageVector(str3);
                        composer3.startReplaceGroup(1709123813);
                        ComposerKt.sourceInformation(composer3, "*195@6261L130");
                        if (imageVector2 != null) {
                            IconKt.m3576Iconww6aTOc(imageVector2, str3, PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m9687constructorimpl(8), 0.0f, 0.0f, 0.0f, 14, null), 0L, composer3, 384, 8);
                        }
                        composer3.endReplaceGroup();
                    }
                    composer3.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 1572864, 0);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.button.ButtonKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ButtonKt.ButtonContent$lambda$4(functionalComposableScope, props, onButtonPressed, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ButtonContent$lambda$3$lambda$2(MutableState mutableState, Function1 function1) {
        if (mutableState != null) {
            mutableState.setValue(true);
        }
        function1.invoke(new ButtonPressedEvent());
        return Unit.INSTANCE;
    }
}
