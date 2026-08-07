package expo.modules.ui.button;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.IconButtonColors;
import androidx.compose.material3.IconButtonDefaults;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.hermes.intl.Constants;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.views.ComposableScope;
import expo.modules.kotlin.views.FunctionalComposableScope;
import expo.modules.ui.ModifierRegistry;
import expo.modules.ui.ShapeViewKt;
import expo.modules.ui.UtilsKt;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IconButton.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aZ\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0002\u0010\u0010\u001a-\u0010\u0011\u001a\u00020\u0001*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0016H\u0007¢\u0006\u0002\u0010\u0018¨\u0006\u0019"}, d2 = {"StyledIconButton", "", Constants.SENSITIVITY_VARIANT, "Lexpo/modules/ui/button/IconButtonVariant;", "colors", "Lexpo/modules/ui/button/ButtonColors;", "disabled", "", "onPress", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/ui/graphics/Shape;", "content", "Landroidx/compose/runtime/Composable;", "(Lexpo/modules/ui/button/IconButtonVariant;Lexpo/modules/ui/button/ButtonColors;ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "IconButtonContent", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "props", "Lexpo/modules/ui/button/IconButtonProps;", "onButtonPressed", "Lkotlin/Function1;", "Lexpo/modules/ui/button/ButtonPressedEvent;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/button/IconButtonProps;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "expo-ui_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class IconButtonKt {

    /* JADX INFO: compiled from: IconButton.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[IconButtonVariant.values().length];
            try {
                iArr[IconButtonVariant.BORDERED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IconButtonVariant.OUTLINED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IconButtonContent$lambda$3(FunctionalComposableScope functionalComposableScope, IconButtonProps iconButtonProps, Function1 function1, int i, Composer composer, int i2) {
        IconButtonContent(functionalComposableScope, iconButtonProps, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StyledIconButton$lambda$0(IconButtonVariant iconButtonVariant, ButtonColors buttonColors, boolean z, Function0 function0, Modifier modifier, Shape shape, Function2 function2, int i, int i2, Composer composer, int i3) {
        StyledIconButton(iconButtonVariant, buttonColors, z, function0, modifier, shape, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0254  */
    /* JADX WARN: Code duplicated, block: B:105:0x025d  */
    /* JADX WARN: Code duplicated, block: B:107:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:57:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:59:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:61:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:62:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:66:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:67:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:69:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:71:0x00db  */
    /* JADX WARN: Code duplicated, block: B:72:0x00de  */
    /* JADX WARN: Code duplicated, block: B:80:0x00f7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:81:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:82:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:85:0x0105  */
    /* JADX WARN: Code duplicated, block: B:88:0x0118 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:89:0x011a  */
    /* JADX WARN: Code duplicated, block: B:90:0x016d  */
    /* JADX WARN: Code duplicated, block: B:92:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:93:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:95:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:97:0x022b  */
    /* JADX WARN: Code duplicated, block: B:98:0x0234  */
    public static final void StyledIconButton(final IconButtonVariant variant, final ButtonColors colors, final boolean z, final Function0<Unit> onPress, Modifier modifier, final Shape shape, final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        int i5;
        Modifier.Companion companion;
        int i6;
        Shape filledTonalShape;
        final Modifier modifier3;
        Shape outlinedShape;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(variant, "variant");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(onPress, "onPress");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(199810975);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(StyledIconButton)P(6!1,2,4,3,5):IconButton.kt#kazlex");
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
                    ComposerKt.traceEventStart(199810975, i3, -1, "expo.modules.ui.button.StyledIconButton (IconButton.kt:43)");
                }
                i6 = WhenMappings.$EnumSwitchMapping$0[variant.ordinal()];
                if (i6 == 1) {
                    int i8 = i3;
                    composerStartRestartGroup.startReplaceGroup(-255627853);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "49@1601L283,45@1477L496");
                    boolean z2 = !z;
                    IconButtonColors iconButtonColorsM3538filledTonalIconButtonColorsro_MJ88 = IconButtonDefaults.INSTANCE.m3538filledTonalIconButtonColorsro_MJ88(UtilsKt.getCompose(colors.getContainerColor()), UtilsKt.getCompose(colors.getContentColor()), UtilsKt.getCompose(colors.getDisabledContainerColor()), UtilsKt.getCompose(colors.getDisabledContentColor()), composerStartRestartGroup, IconButtonDefaults.$stable << 12, 0);
                    composerStartRestartGroup.startReplaceGroup(-1255158969);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "55@1924L16");
                    if (shape == null) {
                        filledTonalShape = ButtonDefaults.INSTANCE.getFilledTonalShape(composerStartRestartGroup, ButtonDefaults.$stable);
                    } else {
                        filledTonalShape = shape;
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    int i9 = ((i8 >> 9) & 126) | (i8 & 3670016);
                    modifier3 = companion;
                    androidx.compose.material3.IconButtonKt.FilledTonalIconButton(onPress, modifier3, z2, filledTonalShape, iconButtonColorsM3538filledTonalIconButtonColorsro_MJ88, (MutableInteractionSource) null, content, composerStartRestartGroup, i9, 32);
                    composerStartRestartGroup.endReplaceGroup();
                } else if (i6 != 2) {
                    composerStartRestartGroup.startReplaceGroup(-254605535);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "77@2623L272,73@2510L418");
                    int i10 = i3;
                    IconButtonColors iconButtonColorsM3545iconButtonColorsro_MJ88 = IconButtonDefaults.INSTANCE.m3545iconButtonColorsro_MJ88(UtilsKt.getCompose(colors.getContainerColor()), UtilsKt.getCompose(colors.getContentColor()), UtilsKt.getCompose(colors.getDisabledContainerColor()), UtilsKt.getCompose(colors.getDisabledContentColor()), composerStartRestartGroup, IconButtonDefaults.$stable << 12, 0);
                    int i11 = ((i10 >> 9) & 126) | (i10 & 3670016);
                    modifier3 = companion;
                    composerStartRestartGroup = composerStartRestartGroup;
                    androidx.compose.material3.IconButtonKt.IconButton(onPress, modifier3, !z, iconButtonColorsM3545iconButtonColorsro_MJ88, (MutableInteractionSource) null, (Shape) null, content, composerStartRestartGroup, i11, 48);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    int i12 = i3;
                    composerStartRestartGroup.startReplaceGroup(-255100388);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "63@2130L280,59@2009L487");
                    boolean z3 = !z;
                    IconButtonColors iconButtonColorsM3551outlinedIconButtonColorsro_MJ88 = IconButtonDefaults.INSTANCE.m3551outlinedIconButtonColorsro_MJ88(UtilsKt.getCompose(colors.getContainerColor()), UtilsKt.getCompose(colors.getContentColor()), UtilsKt.getCompose(colors.getDisabledContainerColor()), UtilsKt.getCompose(colors.getDisabledContentColor()), composerStartRestartGroup, IconButtonDefaults.$stable << 12, 0);
                    composerStartRestartGroup.startReplaceGroup(-1255142140);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "69@2450L13");
                    if (shape == null) {
                        outlinedShape = ButtonDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, ButtonDefaults.$stable);
                    } else {
                        outlinedShape = shape;
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    int i13 = ((i12 >> 9) & 126) | ((i12 << 3) & 29360128);
                    modifier3 = companion;
                    androidx.compose.material3.IconButtonKt.OutlinedIconButton(onPress, modifier3, z3, outlinedShape, iconButtonColorsM3551outlinedIconButtonColorsro_MJ88, (BorderStroke) null, (MutableInteractionSource) null, content, composerStartRestartGroup, i13, 96);
                    composerStartRestartGroup = composerStartRestartGroup;
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
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.button.IconButtonKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return IconButtonKt.StyledIconButton$lambda$0(variant, colors, z, onPress, modifier3, shape, content, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
                ComposerKt.traceEventStart(199810975, i3, -1, "expo.modules.ui.button.StyledIconButton (IconButton.kt:43)");
            }
            i6 = WhenMappings.$EnumSwitchMapping$0[variant.ordinal()];
            if (i6 == 1) {
                int i14 = i3;
                composerStartRestartGroup.startReplaceGroup(-255627853);
                ComposerKt.sourceInformation(composerStartRestartGroup, "49@1601L283,45@1477L496");
                boolean z4 = !z;
                IconButtonColors iconButtonColorsM3538filledTonalIconButtonColorsro_MJ89 = IconButtonDefaults.INSTANCE.m3538filledTonalIconButtonColorsro_MJ88(UtilsKt.getCompose(colors.getContainerColor()), UtilsKt.getCompose(colors.getContentColor()), UtilsKt.getCompose(colors.getDisabledContainerColor()), UtilsKt.getCompose(colors.getDisabledContentColor()), composerStartRestartGroup, IconButtonDefaults.$stable << 12, 0);
                composerStartRestartGroup.startReplaceGroup(-1255158969);
                ComposerKt.sourceInformation(composerStartRestartGroup, "55@1924L16");
                if (shape == null) {
                    filledTonalShape = ButtonDefaults.INSTANCE.getFilledTonalShape(composerStartRestartGroup, ButtonDefaults.$stable);
                } else {
                    filledTonalShape = shape;
                }
                composerStartRestartGroup.endReplaceGroup();
                int i15 = ((i14 >> 9) & 126) | (i14 & 3670016);
                modifier3 = companion;
                androidx.compose.material3.IconButtonKt.FilledTonalIconButton(onPress, modifier3, z4, filledTonalShape, iconButtonColorsM3538filledTonalIconButtonColorsro_MJ89, (MutableInteractionSource) null, content, composerStartRestartGroup, i15, 32);
                composerStartRestartGroup.endReplaceGroup();
            } else if (i6 != 2) {
                composerStartRestartGroup.startReplaceGroup(-254605535);
                ComposerKt.sourceInformation(composerStartRestartGroup, "77@2623L272,73@2510L418");
                int i16 = i3;
                IconButtonColors iconButtonColorsM3545iconButtonColorsro_MJ89 = IconButtonDefaults.INSTANCE.m3545iconButtonColorsro_MJ88(UtilsKt.getCompose(colors.getContainerColor()), UtilsKt.getCompose(colors.getContentColor()), UtilsKt.getCompose(colors.getDisabledContainerColor()), UtilsKt.getCompose(colors.getDisabledContentColor()), composerStartRestartGroup, IconButtonDefaults.$stable << 12, 0);
                int i17 = ((i16 >> 9) & 126) | (i16 & 3670016);
                modifier3 = companion;
                composerStartRestartGroup = composerStartRestartGroup;
                androidx.compose.material3.IconButtonKt.IconButton(onPress, modifier3, !z, iconButtonColorsM3545iconButtonColorsro_MJ89, (MutableInteractionSource) null, (Shape) null, content, composerStartRestartGroup, i17, 48);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                int i18 = i3;
                composerStartRestartGroup.startReplaceGroup(-255100388);
                ComposerKt.sourceInformation(composerStartRestartGroup, "63@2130L280,59@2009L487");
                boolean z5 = !z;
                IconButtonColors iconButtonColorsM3551outlinedIconButtonColorsro_MJ89 = IconButtonDefaults.INSTANCE.m3551outlinedIconButtonColorsro_MJ88(UtilsKt.getCompose(colors.getContainerColor()), UtilsKt.getCompose(colors.getContentColor()), UtilsKt.getCompose(colors.getDisabledContainerColor()), UtilsKt.getCompose(colors.getDisabledContentColor()), composerStartRestartGroup, IconButtonDefaults.$stable << 12, 0);
                composerStartRestartGroup.startReplaceGroup(-1255142140);
                ComposerKt.sourceInformation(composerStartRestartGroup, "69@2450L13");
                if (shape == null) {
                    outlinedShape = ButtonDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, ButtonDefaults.$stable);
                } else {
                    outlinedShape = shape;
                }
                composerStartRestartGroup.endReplaceGroup();
                int i19 = ((i18 >> 9) & 126) | ((i18 << 3) & 29360128);
                modifier3 = companion;
                androidx.compose.material3.IconButtonKt.OutlinedIconButton(onPress, modifier3, z5, outlinedShape, iconButtonColorsM3551outlinedIconButtonColorsro_MJ89, (BorderStroke) null, (MutableInteractionSource) null, content, composerStartRestartGroup, i19, 96);
                composerStartRestartGroup = composerStartRestartGroup;
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
                ComposerKt.traceEventStart(199810975, i3, -1, "expo.modules.ui.button.StyledIconButton (IconButton.kt:43)");
            }
            i6 = WhenMappings.$EnumSwitchMapping$0[variant.ordinal()];
            if (i6 == 1) {
                int i110 = i3;
                composerStartRestartGroup.startReplaceGroup(-255627853);
                ComposerKt.sourceInformation(composerStartRestartGroup, "49@1601L283,45@1477L496");
                boolean z6 = !z;
                IconButtonColors iconButtonColorsM3538filledTonalIconButtonColorsro_MJ810 = IconButtonDefaults.INSTANCE.m3538filledTonalIconButtonColorsro_MJ88(UtilsKt.getCompose(colors.getContainerColor()), UtilsKt.getCompose(colors.getContentColor()), UtilsKt.getCompose(colors.getDisabledContainerColor()), UtilsKt.getCompose(colors.getDisabledContentColor()), composerStartRestartGroup, IconButtonDefaults.$stable << 12, 0);
                composerStartRestartGroup.startReplaceGroup(-1255158969);
                ComposerKt.sourceInformation(composerStartRestartGroup, "55@1924L16");
                if (shape == null) {
                    filledTonalShape = ButtonDefaults.INSTANCE.getFilledTonalShape(composerStartRestartGroup, ButtonDefaults.$stable);
                } else {
                    filledTonalShape = shape;
                }
                composerStartRestartGroup.endReplaceGroup();
                int i111 = ((i110 >> 9) & 126) | (i110 & 3670016);
                modifier3 = companion;
                androidx.compose.material3.IconButtonKt.FilledTonalIconButton(onPress, modifier3, z6, filledTonalShape, iconButtonColorsM3538filledTonalIconButtonColorsro_MJ810, (MutableInteractionSource) null, content, composerStartRestartGroup, i111, 32);
                composerStartRestartGroup.endReplaceGroup();
            } else if (i6 != 2) {
                composerStartRestartGroup.startReplaceGroup(-254605535);
                ComposerKt.sourceInformation(composerStartRestartGroup, "77@2623L272,73@2510L418");
                int i112 = i3;
                IconButtonColors iconButtonColorsM3545iconButtonColorsro_MJ810 = IconButtonDefaults.INSTANCE.m3545iconButtonColorsro_MJ88(UtilsKt.getCompose(colors.getContainerColor()), UtilsKt.getCompose(colors.getContentColor()), UtilsKt.getCompose(colors.getDisabledContainerColor()), UtilsKt.getCompose(colors.getDisabledContentColor()), composerStartRestartGroup, IconButtonDefaults.$stable << 12, 0);
                int i113 = ((i112 >> 9) & 126) | (i112 & 3670016);
                modifier3 = companion;
                composerStartRestartGroup = composerStartRestartGroup;
                androidx.compose.material3.IconButtonKt.IconButton(onPress, modifier3, !z, iconButtonColorsM3545iconButtonColorsro_MJ810, (MutableInteractionSource) null, (Shape) null, content, composerStartRestartGroup, i113, 48);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                int i114 = i3;
                composerStartRestartGroup.startReplaceGroup(-255100388);
                ComposerKt.sourceInformation(composerStartRestartGroup, "63@2130L280,59@2009L487");
                boolean z7 = !z;
                IconButtonColors iconButtonColorsM3551outlinedIconButtonColorsro_MJ810 = IconButtonDefaults.INSTANCE.m3551outlinedIconButtonColorsro_MJ88(UtilsKt.getCompose(colors.getContainerColor()), UtilsKt.getCompose(colors.getContentColor()), UtilsKt.getCompose(colors.getDisabledContainerColor()), UtilsKt.getCompose(colors.getDisabledContentColor()), composerStartRestartGroup, IconButtonDefaults.$stable << 12, 0);
                composerStartRestartGroup.startReplaceGroup(-1255142140);
                ComposerKt.sourceInformation(composerStartRestartGroup, "69@2450L13");
                if (shape == null) {
                    outlinedShape = ButtonDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, ButtonDefaults.$stable);
                } else {
                    outlinedShape = shape;
                }
                composerStartRestartGroup.endReplaceGroup();
                int i115 = ((i114 >> 9) & 126) | ((i114 << 3) & 29360128);
                modifier3 = companion;
                androidx.compose.material3.IconButtonKt.OutlinedIconButton(onPress, modifier3, z7, outlinedShape, iconButtonColorsM3551outlinedIconButtonColorsro_MJ810, (BorderStroke) null, (MutableInteractionSource) null, content, composerStartRestartGroup, i115, 96);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.button.IconButtonKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return IconButtonKt.StyledIconButton$lambda$0(variant, colors, z, onPress, modifier3, shape, content, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void IconButtonContent(final FunctionalComposableScope functionalComposableScope, final IconButtonProps props, final Function1<? super ButtonPressedEvent, Unit> onButtonPressed, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(onButtonPressed, "onButtonPressed");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1056953410);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(IconButtonContent)P(1)101@3284L41,102@3359L83,104@3494L37,97@3175L356:IconButton.kt#kazlex");
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
                ComposerKt.traceEventStart(-1056953410, i2, -1, "expo.modules.ui.button.IconButtonContent (IconButton.kt:92)");
            }
            IconButtonVariant variant = props.getVariant();
            ButtonColors elementColors = props.getElementColors();
            Boolean disabled = props.getDisabled();
            if (variant == null) {
                variant = IconButtonVariant.DEFAULT;
            }
            boolean zBooleanValue = disabled != null ? disabled.booleanValue() : false;
            composerStartRestartGroup.startReplaceGroup(5004770);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):IconButton.kt#9igjgp");
            boolean z = (i2 & 896) == 256;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: expo.modules.ui.button.IconButtonKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return IconButtonKt.IconButtonContent$lambda$2$lambda$1(onButtonPressed);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceGroup();
            StyledIconButton(variant, elementColors, zBooleanValue, (Function0) objRememberedValue, ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, (ComposableScope.$stable << 6) | (AppContext.$stable << 3)), ShapeViewKt.shapeFromShapeRecord(props.getShape()), ComposableLambdaKt.rememberComposableLambda(-104999923, true, new Function2<Composer, Integer, Unit>() { // from class: expo.modules.ui.button.IconButtonKt.IconButtonContent.2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    ComposerKt.sourceInformation(composer2, "C105@3500L27:IconButton.kt#kazlex");
                    if ((i3 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-104999923, i3, -1, "expo.modules.ui.button.IconButtonContent.<anonymous> (IconButton.kt:105)");
                    }
                    functionalComposableScope.Children(new ComposableScope(null, null, null, null, 15, null), composer2, ComposableScope.$stable | (FunctionalComposableScope.$stable << 3));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 1572864, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.button.IconButtonKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return IconButtonKt.IconButtonContent$lambda$3(functionalComposableScope, props, onButtonPressed, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IconButtonContent$lambda$2$lambda$1(Function1 function1) {
        function1.invoke(new ButtonPressedEvent());
        return Unit.INSTANCE;
    }
}
