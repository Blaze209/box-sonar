package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.material3.tokens.CheckboxTokens;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.state.ToggleableStateKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;

/* JADX INFO: compiled from: Checkbox.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000l\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aU\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0002\u0010\r\u001ae\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0002\u0010\u0011\u001aO\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00142\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00162\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0002\u0010\u0017\u001a_\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00142\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00162\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0002\u0010\u0018\u001a=\u0010\u0019\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0003¢\u0006\u0002\u0010\u001b\u001a3\u0010\u001c\u001a\u00020\u0001*\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u000fH\u0002¢\u0006\u0004\b$\u0010%\u001a;\u0010&\u001a\u00020\u0001*\u00020\u001d2\u0006\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020+H\u0002¢\u0006\u0004\b,\u0010-\"\u000e\u0010.\u001a\u00020/X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0004\n\u0002\u00102\"\u0010\u00103\u001a\u000201X\u0082\u0004¢\u0006\u0004\n\u0002\u00102\"\u0010\u00104\u001a\u000201X\u0082\u0004¢\u0006\u0004\n\u0002\u00102¨\u00065"}, d2 = {"Checkbox", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "colors", "Landroidx/compose/material3/CheckboxColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/CheckboxColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "checkmarkStroke", "Landroidx/compose/ui/graphics/drawscope/Stroke;", "outlineStroke", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/CheckboxColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "TriStateCheckbox", "state", "Landroidx/compose/ui/state/ToggleableState;", ViewProps.ON_CLICK, "Lkotlin/Function0;", "(Landroidx/compose/ui/state/ToggleableState;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/CheckboxColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/state/ToggleableState;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/CheckboxColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "CheckboxImpl", "value", "(ZLandroidx/compose/ui/state/ToggleableState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/CheckboxColors;Landroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/runtime/Composer;I)V", "drawBox", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "boxColor", "Landroidx/compose/ui/graphics/Color;", ViewProps.BORDER_COLOR, "radius", "", "stroke", "drawBox-1wkBAMs", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJFLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawCheck", "checkColor", "checkFraction", "crossCenterGravitation", "drawingCache", "Landroidx/compose/material3/CheckDrawingCache;", "drawCheck-3IgeMak", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFFLandroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/material3/CheckDrawingCache;)V", "SnapAnimationDelay", "", "CheckboxDefaultPadding", "Landroidx/compose/ui/unit/Dp;", "F", "CheckboxSize", "RadiusSize", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class CheckboxKt {
    private static final float CheckboxDefaultPadding;
    private static final float CheckboxSize = Dp.m9687constructorimpl(20);
    private static final float RadiusSize;
    private static final int SnapAnimationDelay = 100;

    /* JADX INFO: compiled from: Checkbox.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ToggleableState.values().length];
            try {
                iArr[ToggleableState.On.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ToggleableState.Off.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ToggleableState.Indeterminate.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Checkbox$lambda$2(boolean z, Function1 function1, Modifier modifier, boolean z2, CheckboxColors checkboxColors, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        Checkbox(z, function1, modifier, z2, checkboxColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Checkbox$lambda$4(boolean z, Function1 function1, Stroke stroke, Stroke stroke2, Modifier modifier, boolean z2, CheckboxColors checkboxColors, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        Checkbox(z, function1, stroke, stroke2, modifier, z2, checkboxColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CheckboxImpl$lambda$6(boolean z, ToggleableState toggleableState, Modifier modifier, CheckboxColors checkboxColors, Stroke stroke, Stroke stroke2, int i, Composer composer, int i2) {
        CheckboxImpl(z, toggleableState, modifier, checkboxColors, stroke, stroke2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TriStateCheckbox$lambda$1(ToggleableState toggleableState, Function0 function0, Modifier modifier, boolean z, CheckboxColors checkboxColors, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        TriStateCheckbox(toggleableState, function0, modifier, z, checkboxColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TriStateCheckbox$lambda$2(ToggleableState toggleableState, Function0 function0, Stroke stroke, Stroke stroke2, Modifier modifier, boolean z, CheckboxColors checkboxColors, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        TriStateCheckbox(toggleableState, function0, stroke, stroke2, modifier, z, checkboxColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x016a  */
    /* JADX WARN: Code duplicated, block: B:102:0x0172  */
    /* JADX WARN: Code duplicated, block: B:104:0x0185  */
    /* JADX WARN: Code duplicated, block: B:107:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:109:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:112:0x01df  */
    /* JADX WARN: Code duplicated, block: B:114:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x0055  */
    /* JADX WARN: Code duplicated, block: B:31:0x0058  */
    /* JADX WARN: Code duplicated, block: B:33:0x005c  */
    /* JADX WARN: Code duplicated, block: B:35:0x0064  */
    /* JADX WARN: Code duplicated, block: B:36:0x0067  */
    /* JADX WARN: Code duplicated, block: B:41:0x0071  */
    /* JADX WARN: Code duplicated, block: B:43:0x0075  */
    /* JADX WARN: Code duplicated, block: B:45:0x007d  */
    /* JADX WARN: Code duplicated, block: B:46:0x0080  */
    /* JADX WARN: Code duplicated, block: B:49:0x0086  */
    /* JADX WARN: Code duplicated, block: B:52:0x008e  */
    /* JADX WARN: Code duplicated, block: B:53:0x0090  */
    /* JADX WARN: Code duplicated, block: B:55:0x0093  */
    /* JADX WARN: Code duplicated, block: B:57:0x009b  */
    /* JADX WARN: Code duplicated, block: B:58:0x009e  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:67:0x00be  */
    /* JADX WARN: Code duplicated, block: B:69:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:75:0x00de A[PHI: r4 r9 r11 r12
      0x00de: PHI (r4v19 int) = (r4v14 int), (r4v11 int), (r4v20 int) binds: [B:84:0x00fc, B:73:0x00da, B:74:0x00dc] A[DONT_GENERATE, DONT_INLINE]
      0x00de: PHI (r9v22 androidx.compose.ui.Modifier) = (r9v4 androidx.compose.ui.Modifier), (r9v2 androidx.compose.ui.Modifier), (r9v2 androidx.compose.ui.Modifier) binds: [B:84:0x00fc, B:73:0x00da, B:74:0x00dc] A[DONT_GENERATE, DONT_INLINE]
      0x00de: PHI (r11v6 boolean) = (r11v3 boolean), (r11v2 boolean), (r11v2 boolean) binds: [B:84:0x00fc, B:73:0x00da, B:74:0x00dc] A[DONT_GENERATE, DONT_INLINE]
      0x00de: PHI (r12v10 androidx.compose.material3.CheckboxColors) = 
      (r12v7 androidx.compose.material3.CheckboxColors)
      (r12v6 androidx.compose.material3.CheckboxColors)
      (r12v6 androidx.compose.material3.CheckboxColors)
     binds: [B:84:0x00fc, B:73:0x00da, B:74:0x00dc] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:77:0x00e4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:78:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:80:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:83:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:85:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:88:0x010c  */
    /* JADX WARN: Code duplicated, block: B:91:0x013f  */
    /* JADX WARN: Code duplicated, block: B:93:0x0156  */
    /* JADX WARN: Code duplicated, block: B:94:0x0159  */
    /* JADX WARN: Code duplicated, block: B:97:0x0160  */
    public static final void Checkbox(final boolean z, final Function1<? super Boolean, Unit> function1, Modifier modifier, boolean z2, CheckboxColors checkboxColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z3;
        int i5;
        CheckboxColors checkboxColorsColors;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        int i7;
        boolean z4;
        Composer composer2;
        final Modifier modifier3;
        final boolean z5;
        final CheckboxColors checkboxColors2;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        boolean z6;
        CheckboxColors checkboxColors3;
        MutableInteractionSource mutableInteractionSource4;
        Function0 function0;
        boolean z7;
        boolean z8;
        Object objRememberedValue;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1406741137);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Checkbox)N(checked,onCheckedChange,modifier,enabled,colors,interactionSource)98@4432L7,99@4492L493:Checkbox.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i8 = i2 & 4;
        if (i8 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    z3 = z2;
                    if (composerStartRestartGroup.changed(z3)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        checkboxColorsColors = checkboxColors;
                        int i9 = composerStartRestartGroup.changed(checkboxColorsColors) ? 16384 : 8192;
                        i3 |= i9;
                    } else {
                        checkboxColorsColors = checkboxColors;
                    }
                    i3 |= i9;
                } else {
                    checkboxColorsColors = checkboxColors;
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
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "95@4319L8");
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i8 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            }
                            if (i6 != 0) {
                                z6 = z3;
                                checkboxColors3 = checkboxColorsColors;
                                mutableInteractionSource4 = null;
                            }
                            Modifier modifier4 = modifier2;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1406741137, i3, -1, "androidx.compose.material3.Checkbox (Checkbox.kt:97)");
                            }
                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume = composerStartRestartGroup.consume(localDensity);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            float fFloor = (float) Math.floor(((Density) objConsume).mo754toPx0680j_4(CheckboxDefaults.INSTANCE.m2932getStrokeWidthD9Ej5fM()));
                            ToggleableState ToggleableState = ToggleableStateKt.ToggleableState(z);
                            if (function1 != null) {
                                composerStartRestartGroup.startReplaceGroup(2066141046);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "103@4629L29");
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1036481580, "CC(remember):Checkbox.kt#9igjgp");
                                if ((i3 & 112) == 32) {
                                    z7 = true;
                                } else {
                                    z7 = false;
                                }
                                z8 = z7 | ((i3 & 14) == 4);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (!z8 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new Function0() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda8
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return CheckboxKt.Checkbox$lambda$1$0(function1, z);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                composerStartRestartGroup.endReplaceGroup();
                                function0 = (Function0) objRememberedValue;
                            } else {
                                composerStartRestartGroup.startReplaceGroup(2066206735);
                                composerStartRestartGroup.endReplaceGroup();
                                function0 = null;
                            }
                            composer2 = composerStartRestartGroup;
                            TriStateCheckbox(ToggleableState, function0, new Stroke(fFloor, 0.0f, StrokeCap.INSTANCE.m7192getSquareKaPHkGw(), 0, null, 26, null), new Stroke(fFloor, 0.0f, 0, 0, null, 30, null), modifier4, z6, checkboxColors3, mutableInteractionSource4, composer2, (i3 << 6) & 33546240, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                            z5 = z6;
                            checkboxColors2 = checkboxColors3;
                            mutableInteractionSource3 = mutableInteractionSource4;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                        }
                        z6 = z3;
                        mutableInteractionSource4 = mutableInteractionSource2;
                        checkboxColors3 = checkboxColorsColors;
                        Modifier modifier5 = modifier2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1406741137, i3, -1, "androidx.compose.material3.Checkbox (Checkbox.kt:97)");
                        }
                        ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume2 = composerStartRestartGroup.consume(localDensity2);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        float fFloor2 = (float) Math.floor(((Density) objConsume2).mo754toPx0680j_4(CheckboxDefaults.INSTANCE.m2932getStrokeWidthD9Ej5fM()));
                        ToggleableState ToggleableState2 = ToggleableStateKt.ToggleableState(z);
                        if (function1 != null) {
                            composerStartRestartGroup.startReplaceGroup(2066141046);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "103@4629L29");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1036481580, "CC(remember):Checkbox.kt#9igjgp");
                            if ((i3 & 112) == 32) {
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                            z8 = z7 | ((i3 & 14) == 4);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z8) {
                                objRememberedValue = new Function0() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda8
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return CheckboxKt.Checkbox$lambda$1$0(function1, z);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = new Function0() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda8
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return CheckboxKt.Checkbox$lambda$1$0(function1, z);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endReplaceGroup();
                            function0 = (Function0) objRememberedValue;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(2066206735);
                            composerStartRestartGroup.endReplaceGroup();
                            function0 = null;
                        }
                        composer2 = composerStartRestartGroup;
                        TriStateCheckbox(ToggleableState2, function0, new Stroke(fFloor2, 0.0f, StrokeCap.INSTANCE.m7192getSquareKaPHkGw(), 0, null, 26, null), new Stroke(fFloor2, 0.0f, 0, 0, null, 30, null), modifier5, z6, checkboxColors3, mutableInteractionSource4, composer2, (i3 << 6) & 33546240, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier5;
                        z5 = z6;
                        checkboxColors2 = checkboxColors3;
                        mutableInteractionSource3 = mutableInteractionSource4;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier3 = modifier2;
                        z5 = z3;
                        checkboxColors2 = checkboxColorsColors;
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CheckboxKt.Checkbox$lambda$2(z, function1, modifier3, z5, checkboxColors2, mutableInteractionSource3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((74899 & i3) != 74898) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "95@4319L8");
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        }
                        if (i6 != 0) {
                            z6 = z3;
                            checkboxColors3 = checkboxColorsColors;
                            mutableInteractionSource4 = null;
                        } else {
                            z6 = z3;
                            mutableInteractionSource4 = mutableInteractionSource2;
                            checkboxColors3 = checkboxColorsColors;
                        }
                    } else {
                        if (i8 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        }
                        if (i6 != 0) {
                            z6 = z3;
                            checkboxColors3 = checkboxColorsColors;
                            mutableInteractionSource4 = null;
                        } else {
                            z6 = z3;
                            mutableInteractionSource4 = mutableInteractionSource2;
                            checkboxColors3 = checkboxColorsColors;
                        }
                    }
                    Modifier modifier6 = modifier2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1406741137, i3, -1, "androidx.compose.material3.Checkbox (Checkbox.kt:97)");
                    }
                    ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume3 = composerStartRestartGroup.consume(localDensity3);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    float fFloor3 = (float) Math.floor(((Density) objConsume3).mo754toPx0680j_4(CheckboxDefaults.INSTANCE.m2932getStrokeWidthD9Ej5fM()));
                    ToggleableState ToggleableState3 = ToggleableStateKt.ToggleableState(z);
                    if (function1 != null) {
                        composerStartRestartGroup.startReplaceGroup(2066141046);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "103@4629L29");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1036481580, "CC(remember):Checkbox.kt#9igjgp");
                        if ((i3 & 112) == 32) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        z8 = z7 | ((i3 & 14) == 4);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z8) {
                            objRememberedValue = new Function0() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return CheckboxKt.Checkbox$lambda$1$0(function1, z);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function0() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return CheckboxKt.Checkbox$lambda$1$0(function1, z);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                        function0 = (Function0) objRememberedValue;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(2066206735);
                        composerStartRestartGroup.endReplaceGroup();
                        function0 = null;
                    }
                    composer2 = composerStartRestartGroup;
                    TriStateCheckbox(ToggleableState3, function0, new Stroke(fFloor3, 0.0f, StrokeCap.INSTANCE.m7192getSquareKaPHkGw(), 0, null, 26, null), new Stroke(fFloor3, 0.0f, 0, 0, null, 30, null), modifier6, z6, checkboxColors3, mutableInteractionSource4, composer2, (i3 << 6) & 33546240, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier6;
                    z5 = z6;
                    checkboxColors2 = checkboxColors3;
                    mutableInteractionSource3 = mutableInteractionSource4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    z5 = z3;
                    checkboxColors2 = checkboxColorsColors;
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CheckboxKt.Checkbox$lambda$2(z, function1, modifier3, z5, checkboxColors2, mutableInteractionSource3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            z3 = z2;
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    checkboxColorsColors = checkboxColors;
                    if (composerStartRestartGroup.changed(checkboxColorsColors)) {
                    }
                    i3 |= i9;
                } else {
                    checkboxColorsColors = checkboxColors;
                }
                i3 |= i9;
            } else {
                checkboxColorsColors = checkboxColors;
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
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "95@4319L8");
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        }
                        if (i6 != 0) {
                            z6 = z3;
                            checkboxColors3 = checkboxColorsColors;
                            mutableInteractionSource4 = null;
                        } else {
                            z6 = z3;
                            mutableInteractionSource4 = mutableInteractionSource2;
                            checkboxColors3 = checkboxColorsColors;
                        }
                    } else {
                        if (i8 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        }
                        if (i6 != 0) {
                            z6 = z3;
                            checkboxColors3 = checkboxColorsColors;
                            mutableInteractionSource4 = null;
                        } else {
                            z6 = z3;
                            mutableInteractionSource4 = mutableInteractionSource2;
                            checkboxColors3 = checkboxColorsColors;
                        }
                    }
                    Modifier modifier7 = modifier2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1406741137, i3, -1, "androidx.compose.material3.Checkbox (Checkbox.kt:97)");
                    }
                    ProvidableCompositionLocal<Density> localDensity4 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume4 = composerStartRestartGroup.consume(localDensity4);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    float fFloor4 = (float) Math.floor(((Density) objConsume4).mo754toPx0680j_4(CheckboxDefaults.INSTANCE.m2932getStrokeWidthD9Ej5fM()));
                    ToggleableState ToggleableState4 = ToggleableStateKt.ToggleableState(z);
                    if (function1 != null) {
                        composerStartRestartGroup.startReplaceGroup(2066141046);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "103@4629L29");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1036481580, "CC(remember):Checkbox.kt#9igjgp");
                        if ((i3 & 112) == 32) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        z8 = z7 | ((i3 & 14) == 4);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z8) {
                            objRememberedValue = new Function0() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return CheckboxKt.Checkbox$lambda$1$0(function1, z);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function0() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return CheckboxKt.Checkbox$lambda$1$0(function1, z);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                        function0 = (Function0) objRememberedValue;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(2066206735);
                        composerStartRestartGroup.endReplaceGroup();
                        function0 = null;
                    }
                    composer2 = composerStartRestartGroup;
                    TriStateCheckbox(ToggleableState4, function0, new Stroke(fFloor4, 0.0f, StrokeCap.INSTANCE.m7192getSquareKaPHkGw(), 0, null, 26, null), new Stroke(fFloor4, 0.0f, 0, 0, null, 30, null), modifier7, z6, checkboxColors3, mutableInteractionSource4, composer2, (i3 << 6) & 33546240, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier7;
                    z5 = z6;
                    checkboxColors2 = checkboxColors3;
                    mutableInteractionSource3 = mutableInteractionSource4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    z5 = z3;
                    checkboxColors2 = checkboxColorsColors;
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CheckboxKt.Checkbox$lambda$2(z, function1, modifier3, z5, checkboxColors2, mutableInteractionSource3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((74899 & i3) != 74898) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "95@4319L8");
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    }
                    if (i6 != 0) {
                        z6 = z3;
                        checkboxColors3 = checkboxColorsColors;
                        mutableInteractionSource4 = null;
                    } else {
                        z6 = z3;
                        mutableInteractionSource4 = mutableInteractionSource2;
                        checkboxColors3 = checkboxColorsColors;
                    }
                } else {
                    if (i8 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    }
                    if (i6 != 0) {
                        z6 = z3;
                        checkboxColors3 = checkboxColorsColors;
                        mutableInteractionSource4 = null;
                    } else {
                        z6 = z3;
                        mutableInteractionSource4 = mutableInteractionSource2;
                        checkboxColors3 = checkboxColorsColors;
                    }
                }
                Modifier modifier8 = modifier2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1406741137, i3, -1, "androidx.compose.material3.Checkbox (Checkbox.kt:97)");
                }
                ProvidableCompositionLocal<Density> localDensity5 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume5 = composerStartRestartGroup.consume(localDensity5);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                float fFloor5 = (float) Math.floor(((Density) objConsume5).mo754toPx0680j_4(CheckboxDefaults.INSTANCE.m2932getStrokeWidthD9Ej5fM()));
                ToggleableState ToggleableState5 = ToggleableStateKt.ToggleableState(z);
                if (function1 != null) {
                    composerStartRestartGroup.startReplaceGroup(2066141046);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "103@4629L29");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1036481580, "CC(remember):Checkbox.kt#9igjgp");
                    if ((i3 & 112) == 32) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    z8 = z7 | ((i3 & 14) == 4);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z8) {
                        objRememberedValue = new Function0() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return CheckboxKt.Checkbox$lambda$1$0(function1, z);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function0() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return CheckboxKt.Checkbox$lambda$1$0(function1, z);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                    function0 = (Function0) objRememberedValue;
                } else {
                    composerStartRestartGroup.startReplaceGroup(2066206735);
                    composerStartRestartGroup.endReplaceGroup();
                    function0 = null;
                }
                composer2 = composerStartRestartGroup;
                TriStateCheckbox(ToggleableState5, function0, new Stroke(fFloor5, 0.0f, StrokeCap.INSTANCE.m7192getSquareKaPHkGw(), 0, null, 26, null), new Stroke(fFloor5, 0.0f, 0, 0, null, 30, null), modifier8, z6, checkboxColors3, mutableInteractionSource4, composer2, (i3 << 6) & 33546240, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier8;
                z5 = z6;
                checkboxColors2 = checkboxColors3;
                mutableInteractionSource3 = mutableInteractionSource4;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                z5 = z3;
                checkboxColors2 = checkboxColorsColors;
                mutableInteractionSource3 = mutableInteractionSource2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CheckboxKt.Checkbox$lambda$2(z, function1, modifier3, z5, checkboxColors2, mutableInteractionSource3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 3072) == 0) {
                z3 = z2;
                if (composerStartRestartGroup.changed(z3)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    checkboxColorsColors = checkboxColors;
                    if (composerStartRestartGroup.changed(checkboxColorsColors)) {
                    }
                    i3 |= i9;
                } else {
                    checkboxColorsColors = checkboxColors;
                }
                i3 |= i9;
            } else {
                checkboxColorsColors = checkboxColors;
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
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "95@4319L8");
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        }
                        if (i6 != 0) {
                            z6 = z3;
                            checkboxColors3 = checkboxColorsColors;
                            mutableInteractionSource4 = null;
                        } else {
                            z6 = z3;
                            mutableInteractionSource4 = mutableInteractionSource2;
                            checkboxColors3 = checkboxColorsColors;
                        }
                    } else {
                        if (i8 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        }
                        if (i6 != 0) {
                            z6 = z3;
                            checkboxColors3 = checkboxColorsColors;
                            mutableInteractionSource4 = null;
                        } else {
                            z6 = z3;
                            mutableInteractionSource4 = mutableInteractionSource2;
                            checkboxColors3 = checkboxColorsColors;
                        }
                    }
                    Modifier modifier9 = modifier2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1406741137, i3, -1, "androidx.compose.material3.Checkbox (Checkbox.kt:97)");
                    }
                    ProvidableCompositionLocal<Density> localDensity6 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume6 = composerStartRestartGroup.consume(localDensity6);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    float fFloor6 = (float) Math.floor(((Density) objConsume6).mo754toPx0680j_4(CheckboxDefaults.INSTANCE.m2932getStrokeWidthD9Ej5fM()));
                    ToggleableState ToggleableState6 = ToggleableStateKt.ToggleableState(z);
                    if (function1 != null) {
                        composerStartRestartGroup.startReplaceGroup(2066141046);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "103@4629L29");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1036481580, "CC(remember):Checkbox.kt#9igjgp");
                        if ((i3 & 112) == 32) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        z8 = z7 | ((i3 & 14) == 4);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z8) {
                            objRememberedValue = new Function0() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return CheckboxKt.Checkbox$lambda$1$0(function1, z);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function0() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return CheckboxKt.Checkbox$lambda$1$0(function1, z);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                        function0 = (Function0) objRememberedValue;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(2066206735);
                        composerStartRestartGroup.endReplaceGroup();
                        function0 = null;
                    }
                    composer2 = composerStartRestartGroup;
                    TriStateCheckbox(ToggleableState6, function0, new Stroke(fFloor6, 0.0f, StrokeCap.INSTANCE.m7192getSquareKaPHkGw(), 0, null, 26, null), new Stroke(fFloor6, 0.0f, 0, 0, null, 30, null), modifier9, z6, checkboxColors3, mutableInteractionSource4, composer2, (i3 << 6) & 33546240, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier9;
                    z5 = z6;
                    checkboxColors2 = checkboxColors3;
                    mutableInteractionSource3 = mutableInteractionSource4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    z5 = z3;
                    checkboxColors2 = checkboxColorsColors;
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CheckboxKt.Checkbox$lambda$2(z, function1, modifier3, z5, checkboxColors2, mutableInteractionSource3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((74899 & i3) != 74898) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "95@4319L8");
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    }
                    if (i6 != 0) {
                        z6 = z3;
                        checkboxColors3 = checkboxColorsColors;
                        mutableInteractionSource4 = null;
                    } else {
                        z6 = z3;
                        mutableInteractionSource4 = mutableInteractionSource2;
                        checkboxColors3 = checkboxColorsColors;
                    }
                } else {
                    if (i8 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    }
                    if (i6 != 0) {
                        z6 = z3;
                        checkboxColors3 = checkboxColorsColors;
                        mutableInteractionSource4 = null;
                    } else {
                        z6 = z3;
                        mutableInteractionSource4 = mutableInteractionSource2;
                        checkboxColors3 = checkboxColorsColors;
                    }
                }
                Modifier modifier10 = modifier2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1406741137, i3, -1, "androidx.compose.material3.Checkbox (Checkbox.kt:97)");
                }
                ProvidableCompositionLocal<Density> localDensity7 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume7 = composerStartRestartGroup.consume(localDensity7);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                float fFloor7 = (float) Math.floor(((Density) objConsume7).mo754toPx0680j_4(CheckboxDefaults.INSTANCE.m2932getStrokeWidthD9Ej5fM()));
                ToggleableState ToggleableState7 = ToggleableStateKt.ToggleableState(z);
                if (function1 != null) {
                    composerStartRestartGroup.startReplaceGroup(2066141046);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "103@4629L29");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1036481580, "CC(remember):Checkbox.kt#9igjgp");
                    if ((i3 & 112) == 32) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    z8 = z7 | ((i3 & 14) == 4);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z8) {
                        objRememberedValue = new Function0() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return CheckboxKt.Checkbox$lambda$1$0(function1, z);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function0() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return CheckboxKt.Checkbox$lambda$1$0(function1, z);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                    function0 = (Function0) objRememberedValue;
                } else {
                    composerStartRestartGroup.startReplaceGroup(2066206735);
                    composerStartRestartGroup.endReplaceGroup();
                    function0 = null;
                }
                composer2 = composerStartRestartGroup;
                TriStateCheckbox(ToggleableState7, function0, new Stroke(fFloor7, 0.0f, StrokeCap.INSTANCE.m7192getSquareKaPHkGw(), 0, null, 26, null), new Stroke(fFloor7, 0.0f, 0, 0, null, 30, null), modifier10, z6, checkboxColors3, mutableInteractionSource4, composer2, (i3 << 6) & 33546240, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier10;
                z5 = z6;
                checkboxColors2 = checkboxColors3;
                mutableInteractionSource3 = mutableInteractionSource4;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                z5 = z3;
                checkboxColors2 = checkboxColorsColors;
                mutableInteractionSource3 = mutableInteractionSource2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CheckboxKt.Checkbox$lambda$2(z, function1, modifier3, z5, checkboxColors2, mutableInteractionSource3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        z3 = z2;
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                checkboxColorsColors = checkboxColors;
                if (composerStartRestartGroup.changed(checkboxColorsColors)) {
                }
                i3 |= i9;
            } else {
                checkboxColorsColors = checkboxColors;
            }
            i3 |= i9;
        } else {
            checkboxColorsColors = checkboxColors;
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
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "95@4319L8");
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    }
                    if (i6 != 0) {
                        z6 = z3;
                        checkboxColors3 = checkboxColorsColors;
                        mutableInteractionSource4 = null;
                    } else {
                        z6 = z3;
                        mutableInteractionSource4 = mutableInteractionSource2;
                        checkboxColors3 = checkboxColorsColors;
                    }
                } else {
                    if (i8 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    }
                    if (i6 != 0) {
                        z6 = z3;
                        checkboxColors3 = checkboxColorsColors;
                        mutableInteractionSource4 = null;
                    } else {
                        z6 = z3;
                        mutableInteractionSource4 = mutableInteractionSource2;
                        checkboxColors3 = checkboxColorsColors;
                    }
                }
                Modifier modifier11 = modifier2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1406741137, i3, -1, "androidx.compose.material3.Checkbox (Checkbox.kt:97)");
                }
                ProvidableCompositionLocal<Density> localDensity8 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume8 = composerStartRestartGroup.consume(localDensity8);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                float fFloor8 = (float) Math.floor(((Density) objConsume8).mo754toPx0680j_4(CheckboxDefaults.INSTANCE.m2932getStrokeWidthD9Ej5fM()));
                ToggleableState ToggleableState8 = ToggleableStateKt.ToggleableState(z);
                if (function1 != null) {
                    composerStartRestartGroup.startReplaceGroup(2066141046);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "103@4629L29");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1036481580, "CC(remember):Checkbox.kt#9igjgp");
                    if ((i3 & 112) == 32) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    z8 = z7 | ((i3 & 14) == 4);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z8) {
                        objRememberedValue = new Function0() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return CheckboxKt.Checkbox$lambda$1$0(function1, z);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function0() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return CheckboxKt.Checkbox$lambda$1$0(function1, z);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                    function0 = (Function0) objRememberedValue;
                } else {
                    composerStartRestartGroup.startReplaceGroup(2066206735);
                    composerStartRestartGroup.endReplaceGroup();
                    function0 = null;
                }
                composer2 = composerStartRestartGroup;
                TriStateCheckbox(ToggleableState8, function0, new Stroke(fFloor8, 0.0f, StrokeCap.INSTANCE.m7192getSquareKaPHkGw(), 0, null, 26, null), new Stroke(fFloor8, 0.0f, 0, 0, null, 30, null), modifier11, z6, checkboxColors3, mutableInteractionSource4, composer2, (i3 << 6) & 33546240, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier11;
                z5 = z6;
                checkboxColors2 = checkboxColors3;
                mutableInteractionSource3 = mutableInteractionSource4;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                z5 = z3;
                checkboxColors2 = checkboxColorsColors;
                mutableInteractionSource3 = mutableInteractionSource2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CheckboxKt.Checkbox$lambda$2(z, function1, modifier3, z5, checkboxColors2, mutableInteractionSource3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        mutableInteractionSource2 = mutableInteractionSource;
        if ((74899 & i3) != 74898) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "95@4319L8");
            if ((i & 1) != 0) {
                if (i8 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    z3 = true;
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                }
                if (i6 != 0) {
                    z6 = z3;
                    checkboxColors3 = checkboxColorsColors;
                    mutableInteractionSource4 = null;
                } else {
                    z6 = z3;
                    mutableInteractionSource4 = mutableInteractionSource2;
                    checkboxColors3 = checkboxColorsColors;
                }
            } else {
                if (i8 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    z3 = true;
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                }
                if (i6 != 0) {
                    z6 = z3;
                    checkboxColors3 = checkboxColorsColors;
                    mutableInteractionSource4 = null;
                } else {
                    z6 = z3;
                    mutableInteractionSource4 = mutableInteractionSource2;
                    checkboxColors3 = checkboxColorsColors;
                }
            }
            Modifier modifier12 = modifier2;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1406741137, i3, -1, "androidx.compose.material3.Checkbox (Checkbox.kt:97)");
            }
            ProvidableCompositionLocal<Density> localDensity9 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume9 = composerStartRestartGroup.consume(localDensity9);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            float fFloor9 = (float) Math.floor(((Density) objConsume9).mo754toPx0680j_4(CheckboxDefaults.INSTANCE.m2932getStrokeWidthD9Ej5fM()));
            ToggleableState ToggleableState9 = ToggleableStateKt.ToggleableState(z);
            if (function1 != null) {
                composerStartRestartGroup.startReplaceGroup(2066141046);
                ComposerKt.sourceInformation(composerStartRestartGroup, "103@4629L29");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1036481580, "CC(remember):Checkbox.kt#9igjgp");
                if ((i3 & 112) == 32) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                z8 = z7 | ((i3 & 14) == 4);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z8) {
                    objRememberedValue = new Function0() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return CheckboxKt.Checkbox$lambda$1$0(function1, z);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function0() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return CheckboxKt.Checkbox$lambda$1$0(function1, z);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
                function0 = (Function0) objRememberedValue;
            } else {
                composerStartRestartGroup.startReplaceGroup(2066206735);
                composerStartRestartGroup.endReplaceGroup();
                function0 = null;
            }
            composer2 = composerStartRestartGroup;
            TriStateCheckbox(ToggleableState9, function0, new Stroke(fFloor9, 0.0f, StrokeCap.INSTANCE.m7192getSquareKaPHkGw(), 0, null, 26, null), new Stroke(fFloor9, 0.0f, 0, 0, null, 30, null), modifier12, z6, checkboxColors3, mutableInteractionSource4, composer2, (i3 << 6) & 33546240, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier12;
            z5 = z6;
            checkboxColors2 = checkboxColors3;
            mutableInteractionSource3 = mutableInteractionSource4;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            z5 = z3;
            checkboxColors2 = checkboxColorsColors;
            mutableInteractionSource3 = mutableInteractionSource2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CheckboxKt.Checkbox$lambda$2(z, function1, modifier3, z5, checkboxColors2, mutableInteractionSource3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Checkbox$lambda$1$0(Function1 function1, boolean z) {
        function1.invoke(Boolean.valueOf(!z));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0144  */
    /* JADX WARN: Code duplicated, block: B:104:0x0150  */
    /* JADX WARN: Code duplicated, block: B:107:0x015c  */
    /* JADX WARN: Code duplicated, block: B:109:0x0173  */
    /* JADX WARN: Code duplicated, block: B:110:0x0176  */
    /* JADX WARN: Code duplicated, block: B:113:0x017d  */
    /* JADX WARN: Code duplicated, block: B:116:0x0187  */
    /* JADX WARN: Code duplicated, block: B:118:0x018f  */
    /* JADX WARN: Code duplicated, block: B:120:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:123:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:125:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:128:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:130:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x007c  */
    /* JADX WARN: Code duplicated, block: B:45:0x007e  */
    /* JADX WARN: Code duplicated, block: B:47:0x0081  */
    /* JADX WARN: Code duplicated, block: B:49:0x0089  */
    /* JADX WARN: Code duplicated, block: B:50:0x008c  */
    /* JADX WARN: Code duplicated, block: B:55:0x0097  */
    /* JADX WARN: Code duplicated, block: B:57:0x009b  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:67:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:76:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:80:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:82:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:88:0x010b A[PHI: r6 r8 r12 r15
      0x010b: PHI (r6v13 int) = (r6v7 int), (r6v15 int) binds: [B:100:0x0142, B:87:0x0108] A[DONT_GENERATE, DONT_INLINE]
      0x010b: PHI (r8v11 androidx.compose.ui.Modifier) = (r8v5 androidx.compose.ui.Modifier), (r8v2 androidx.compose.ui.Modifier) binds: [B:100:0x0142, B:87:0x0108] A[DONT_GENERATE, DONT_INLINE]
      0x010b: PHI (r12v8 boolean) = (r12v4 boolean), (r12v3 boolean) binds: [B:100:0x0142, B:87:0x0108] A[DONT_GENERATE, DONT_INLINE]
      0x010b: PHI (r15v12 androidx.compose.material3.CheckboxColors) = (r15v8 androidx.compose.material3.CheckboxColors), (r15v7 androidx.compose.material3.CheckboxColors) binds: [B:100:0x0142, B:87:0x0108] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:92:0x0126 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:93:0x0128  */
    /* JADX WARN: Code duplicated, block: B:95:0x012f  */
    /* JADX WARN: Code duplicated, block: B:98:0x0135  */
    /* JADX WARN: Code duplicated, block: B:99:0x0140  */
    public static final void Checkbox(final boolean z, final Function1<? super Boolean, Unit> function1, final Stroke stroke, final Stroke stroke2, Modifier modifier, boolean z2, CheckboxColors checkboxColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z3;
        int i5;
        CheckboxColors checkboxColorsColors;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        int i7;
        int i8;
        boolean z4;
        Composer composer2;
        final Modifier modifier3;
        final boolean z5;
        final MutableInteractionSource mutableInteractionSource3;
        final CheckboxColors checkboxColors2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function0 function0;
        int i9;
        MutableInteractionSource mutableInteractionSource4;
        CheckboxColors checkboxColors3;
        boolean z6;
        int i10;
        int i11;
        boolean z7;
        boolean z8;
        Object objRememberedValue;
        Composer composerStartRestartGroup = composer.startRestartGroup(534932591);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Checkbox)N(checked,onCheckedChange,checkmarkStroke,outlineStroke,modifier,enabled,colors,interactionSource)162@7424L439:Checkbox.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(stroke) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(stroke2) ? 2048 : 1024;
        }
        int i12 = i2 & 16;
        if (i12 == 0) {
            if ((i & 24576) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
            }
            i4 = i2 & 32;
            if (i4 != 0) {
                if ((196608 & i) == 0) {
                    z3 = z2;
                    if (composerStartRestartGroup.changed(z3)) {
                        i5 = 131072;
                    } else {
                        i5 = 65536;
                    }
                    i3 |= i5;
                }
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        checkboxColorsColors = checkboxColors;
                        int i13 = composerStartRestartGroup.changed(checkboxColorsColors) ? 1048576 : 524288;
                        i3 |= i13;
                    } else {
                        checkboxColorsColors = checkboxColors;
                    }
                    i3 |= i13;
                } else {
                    checkboxColorsColors = checkboxColors;
                }
                i6 = i2 & 128;
                if (i6 != 0) {
                    i3 |= 12582912;
                    mutableInteractionSource2 = mutableInteractionSource;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                            i7 = 8388608;
                        } else {
                            i7 = 4194304;
                        }
                        i3 |= i7;
                    }
                }
                i8 = i3;
                if ((i3 & 4793491) != 4793490) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i8 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "159@7349L8");
                    function0 = null;
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i12 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if ((i2 & 64) != 0) {
                            i9 = i8 & (-3670017);
                            checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        } else {
                            i9 = i8;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource4 = null;
                        }
                        z6 = z3;
                        checkboxColors3 = checkboxColorsColors;
                        i11 = 32;
                        i10 = 534932591;
                        Modifier modifier4 = modifier2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i10, i9, -1, "androidx.compose.material3.Checkbox (Checkbox.kt:161)");
                        }
                        ToggleableState ToggleableState = ToggleableStateKt.ToggleableState(z);
                        if (function1 != null) {
                            composerStartRestartGroup.startReplaceGroup(1848587702);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "166@7561L29");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1325840916, "CC(remember):Checkbox.kt#9igjgp");
                            if ((i9 & 112) == i11) {
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                            z8 = z7 | ((i9 & 14) == 4);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z8 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function0() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda5
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return CheckboxKt.Checkbox$lambda$3$0(function1, z);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            function0 = (Function0) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1848653391);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        composer2 = composerStartRestartGroup;
                        TriStateCheckbox(ToggleableState, function0, stroke, stroke2, modifier4, z6, checkboxColors3, mutableInteractionSource4, composer2, i9 & 33554304, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        z5 = z6;
                        checkboxColors2 = checkboxColors3;
                        mutableInteractionSource3 = mutableInteractionSource4;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 64) != 0) {
                            i9 = i8 & (-3670017);
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource2;
                            z6 = z3;
                            i9 = i8;
                            i11 = 32;
                            i10 = 534932591;
                            checkboxColors3 = checkboxColorsColors;
                        }
                        Modifier modifier5 = modifier2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i10, i9, -1, "androidx.compose.material3.Checkbox (Checkbox.kt:161)");
                        }
                        ToggleableState ToggleableState2 = ToggleableStateKt.ToggleableState(z);
                        if (function1 != null) {
                            composerStartRestartGroup.startReplaceGroup(1848587702);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "166@7561L29");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1325840916, "CC(remember):Checkbox.kt#9igjgp");
                            if ((i9 & 112) == i11) {
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                            z8 = z7 | ((i9 & 14) == 4);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z8) {
                                objRememberedValue = new Function0() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda5
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return CheckboxKt.Checkbox$lambda$3$0(function1, z);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = new Function0() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda5
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return CheckboxKt.Checkbox$lambda$3$0(function1, z);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            function0 = (Function0) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1848653391);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        composer2 = composerStartRestartGroup;
                        TriStateCheckbox(ToggleableState2, function0, stroke, stroke2, modifier5, z6, checkboxColors3, mutableInteractionSource4, composer2, i9 & 33554304, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier5;
                        z5 = z6;
                        checkboxColors2 = checkboxColors3;
                        mutableInteractionSource3 = mutableInteractionSource4;
                    }
                    mutableInteractionSource4 = mutableInteractionSource2;
                    z6 = z3;
                    checkboxColors3 = checkboxColorsColors;
                    i11 = 32;
                    i10 = 534932591;
                    Modifier modifier6 = modifier2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i10, i9, -1, "androidx.compose.material3.Checkbox (Checkbox.kt:161)");
                    }
                    ToggleableState ToggleableState3 = ToggleableStateKt.ToggleableState(z);
                    if (function1 != null) {
                        composerStartRestartGroup.startReplaceGroup(1848587702);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "166@7561L29");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1325840916, "CC(remember):Checkbox.kt#9igjgp");
                        if ((i9 & 112) == i11) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        z8 = z7 | ((i9 & 14) == 4);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z8) {
                            objRememberedValue = new Function0() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return CheckboxKt.Checkbox$lambda$3$0(function1, z);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function0() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return CheckboxKt.Checkbox$lambda$3$0(function1, z);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        function0 = (Function0) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1848653391);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    composer2 = composerStartRestartGroup;
                    TriStateCheckbox(ToggleableState3, function0, stroke, stroke2, modifier6, z6, checkboxColors3, mutableInteractionSource4, composer2, i9 & 33554304, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier6;
                    z5 = z6;
                    checkboxColors2 = checkboxColors3;
                    mutableInteractionSource3 = mutableInteractionSource4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    z5 = z3;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    checkboxColors2 = checkboxColorsColors;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CheckboxKt.Checkbox$lambda$4(z, function1, stroke, stroke2, modifier3, z5, checkboxColors2, mutableInteractionSource3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z3 = z2;
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    checkboxColorsColors = checkboxColors;
                    if (composerStartRestartGroup.changed(checkboxColorsColors)) {
                    }
                    i3 |= i13;
                } else {
                    checkboxColorsColors = checkboxColors;
                }
                i3 |= i13;
            } else {
                checkboxColorsColors = checkboxColors;
            }
            i6 = i2 & 128;
            if (i6 != 0) {
                i3 |= 12582912;
                mutableInteractionSource2 = mutableInteractionSource;
            } else {
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i7 = 8388608;
                    } else {
                        i7 = 4194304;
                    }
                    i3 |= i7;
                }
            }
            i8 = i3;
            if ((i3 & 4793491) != 4793490) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i8 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "159@7349L8");
                function0 = null;
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if ((i2 & 64) != 0) {
                        i9 = i8 & (-3670017);
                        checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    } else {
                        i9 = i8;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    z6 = z3;
                    checkboxColors3 = checkboxColorsColors;
                    i11 = 32;
                    i10 = 534932591;
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if ((i2 & 64) != 0) {
                        i9 = i8 & (-3670017);
                        checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    } else {
                        i9 = i8;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    z6 = z3;
                    checkboxColors3 = checkboxColorsColors;
                    i11 = 32;
                    i10 = 534932591;
                }
                Modifier modifier7 = modifier2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i10, i9, -1, "androidx.compose.material3.Checkbox (Checkbox.kt:161)");
                }
                ToggleableState ToggleableState4 = ToggleableStateKt.ToggleableState(z);
                if (function1 != null) {
                    composerStartRestartGroup.startReplaceGroup(1848587702);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "166@7561L29");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1325840916, "CC(remember):Checkbox.kt#9igjgp");
                    if ((i9 & 112) == i11) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    z8 = z7 | ((i9 & 14) == 4);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z8) {
                        objRememberedValue = new Function0() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return CheckboxKt.Checkbox$lambda$3$0(function1, z);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function0() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return CheckboxKt.Checkbox$lambda$3$0(function1, z);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    function0 = (Function0) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1848653391);
                    composerStartRestartGroup.endReplaceGroup();
                }
                composer2 = composerStartRestartGroup;
                TriStateCheckbox(ToggleableState4, function0, stroke, stroke2, modifier7, z6, checkboxColors3, mutableInteractionSource4, composer2, i9 & 33554304, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier7;
                z5 = z6;
                checkboxColors2 = checkboxColors3;
                mutableInteractionSource3 = mutableInteractionSource4;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                z5 = z3;
                mutableInteractionSource3 = mutableInteractionSource2;
                checkboxColors2 = checkboxColorsColors;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CheckboxKt.Checkbox$lambda$4(z, function1, stroke, stroke2, modifier3, z5, checkboxColors2, mutableInteractionSource3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        modifier2 = modifier;
        i4 = i2 & 32;
        if (i4 != 0) {
            if ((196608 & i) == 0) {
                z3 = z2;
                if (composerStartRestartGroup.changed(z3)) {
                    i5 = 131072;
                } else {
                    i5 = 65536;
                }
                i3 |= i5;
            }
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    checkboxColorsColors = checkboxColors;
                    if (composerStartRestartGroup.changed(checkboxColorsColors)) {
                    }
                    i3 |= i13;
                } else {
                    checkboxColorsColors = checkboxColors;
                }
                i3 |= i13;
            } else {
                checkboxColorsColors = checkboxColors;
            }
            i6 = i2 & 128;
            if (i6 != 0) {
                i3 |= 12582912;
                mutableInteractionSource2 = mutableInteractionSource;
            } else {
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i7 = 8388608;
                    } else {
                        i7 = 4194304;
                    }
                    i3 |= i7;
                }
            }
            i8 = i3;
            if ((i3 & 4793491) != 4793490) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i8 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "159@7349L8");
                function0 = null;
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if ((i2 & 64) != 0) {
                        i9 = i8 & (-3670017);
                        checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    } else {
                        i9 = i8;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    z6 = z3;
                    checkboxColors3 = checkboxColorsColors;
                    i11 = 32;
                    i10 = 534932591;
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if ((i2 & 64) != 0) {
                        i9 = i8 & (-3670017);
                        checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    } else {
                        i9 = i8;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    z6 = z3;
                    checkboxColors3 = checkboxColorsColors;
                    i11 = 32;
                    i10 = 534932591;
                }
                Modifier modifier8 = modifier2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i10, i9, -1, "androidx.compose.material3.Checkbox (Checkbox.kt:161)");
                }
                ToggleableState ToggleableState5 = ToggleableStateKt.ToggleableState(z);
                if (function1 != null) {
                    composerStartRestartGroup.startReplaceGroup(1848587702);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "166@7561L29");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1325840916, "CC(remember):Checkbox.kt#9igjgp");
                    if ((i9 & 112) == i11) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    z8 = z7 | ((i9 & 14) == 4);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z8) {
                        objRememberedValue = new Function0() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return CheckboxKt.Checkbox$lambda$3$0(function1, z);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function0() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return CheckboxKt.Checkbox$lambda$3$0(function1, z);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    function0 = (Function0) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1848653391);
                    composerStartRestartGroup.endReplaceGroup();
                }
                composer2 = composerStartRestartGroup;
                TriStateCheckbox(ToggleableState5, function0, stroke, stroke2, modifier8, z6, checkboxColors3, mutableInteractionSource4, composer2, i9 & 33554304, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier8;
                z5 = z6;
                checkboxColors2 = checkboxColors3;
                mutableInteractionSource3 = mutableInteractionSource4;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                z5 = z3;
                mutableInteractionSource3 = mutableInteractionSource2;
                checkboxColors2 = checkboxColorsColors;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CheckboxKt.Checkbox$lambda$4(z, function1, stroke, stroke2, modifier3, z5, checkboxColors2, mutableInteractionSource3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        z3 = z2;
        if ((1572864 & i) == 0) {
            if ((i2 & 64) == 0) {
                checkboxColorsColors = checkboxColors;
                if (composerStartRestartGroup.changed(checkboxColorsColors)) {
                }
                i3 |= i13;
            } else {
                checkboxColorsColors = checkboxColors;
            }
            i3 |= i13;
        } else {
            checkboxColorsColors = checkboxColors;
        }
        i6 = i2 & 128;
        if (i6 != 0) {
            i3 |= 12582912;
            mutableInteractionSource2 = mutableInteractionSource;
        } else {
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                    i7 = 8388608;
                } else {
                    i7 = 4194304;
                }
                i3 |= i7;
            }
        }
        i8 = i3;
        if ((i3 & 4793491) != 4793490) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z4, i8 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "159@7349L8");
            function0 = null;
            if ((i & 1) != 0) {
                if (i12 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    z3 = true;
                }
                if ((i2 & 64) != 0) {
                    i9 = i8 & (-3670017);
                    checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                } else {
                    i9 = i8;
                }
                if (i6 != 0) {
                    mutableInteractionSource4 = null;
                } else {
                    mutableInteractionSource4 = mutableInteractionSource2;
                }
                z6 = z3;
                checkboxColors3 = checkboxColorsColors;
                i11 = 32;
                i10 = 534932591;
            } else {
                if (i12 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    z3 = true;
                }
                if ((i2 & 64) != 0) {
                    i9 = i8 & (-3670017);
                    checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                } else {
                    i9 = i8;
                }
                if (i6 != 0) {
                    mutableInteractionSource4 = null;
                } else {
                    mutableInteractionSource4 = mutableInteractionSource2;
                }
                z6 = z3;
                checkboxColors3 = checkboxColorsColors;
                i11 = 32;
                i10 = 534932591;
            }
            Modifier modifier9 = modifier2;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i10, i9, -1, "androidx.compose.material3.Checkbox (Checkbox.kt:161)");
            }
            ToggleableState ToggleableState6 = ToggleableStateKt.ToggleableState(z);
            if (function1 != null) {
                composerStartRestartGroup.startReplaceGroup(1848587702);
                ComposerKt.sourceInformation(composerStartRestartGroup, "166@7561L29");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1325840916, "CC(remember):Checkbox.kt#9igjgp");
                if ((i9 & 112) == i11) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                z8 = z7 | ((i9 & 14) == 4);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z8) {
                    objRememberedValue = new Function0() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return CheckboxKt.Checkbox$lambda$3$0(function1, z);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function0() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return CheckboxKt.Checkbox$lambda$3$0(function1, z);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                function0 = (Function0) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(1848653391);
                composerStartRestartGroup.endReplaceGroup();
            }
            composer2 = composerStartRestartGroup;
            TriStateCheckbox(ToggleableState6, function0, stroke, stroke2, modifier9, z6, checkboxColors3, mutableInteractionSource4, composer2, i9 & 33554304, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier9;
            z5 = z6;
            checkboxColors2 = checkboxColors3;
            mutableInteractionSource3 = mutableInteractionSource4;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            z5 = z3;
            mutableInteractionSource3 = mutableInteractionSource2;
            checkboxColors2 = checkboxColorsColors;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CheckboxKt.Checkbox$lambda$4(z, function1, stroke, stroke2, modifier3, z5, checkboxColors2, mutableInteractionSource3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Checkbox$lambda$3$0(Function1 function1, boolean z) {
        function1.invoke(Boolean.valueOf(!z));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x005a  */
    /* JADX WARN: Code duplicated, block: B:31:0x005d  */
    /* JADX WARN: Code duplicated, block: B:33:0x0061  */
    /* JADX WARN: Code duplicated, block: B:35:0x0069  */
    /* JADX WARN: Code duplicated, block: B:36:0x006c  */
    /* JADX WARN: Code duplicated, block: B:41:0x0076  */
    /* JADX WARN: Code duplicated, block: B:43:0x007a  */
    /* JADX WARN: Code duplicated, block: B:45:0x0082  */
    /* JADX WARN: Code duplicated, block: B:46:0x0085  */
    /* JADX WARN: Code duplicated, block: B:49:0x008b  */
    /* JADX WARN: Code duplicated, block: B:52:0x0093  */
    /* JADX WARN: Code duplicated, block: B:53:0x0095  */
    /* JADX WARN: Code duplicated, block: B:55:0x0098  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:67:0x00be  */
    /* JADX WARN: Code duplicated, block: B:69:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:78:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:79:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:82:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:87:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:88:0x0104  */
    /* JADX WARN: Code duplicated, block: B:91:0x0112  */
    /* JADX WARN: Code duplicated, block: B:94:0x0188  */
    /* JADX WARN: Code duplicated, block: B:96:0x0190  */
    /* JADX WARN: Code duplicated, block: B:99:0x019f  */
    public static final void TriStateCheckbox(final ToggleableState toggleableState, final Function0<Unit> function0, Modifier modifier, boolean z, CheckboxColors checkboxColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        int i5;
        CheckboxColors checkboxColorsColors;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        int i7;
        boolean z3;
        Composer composer2;
        final Modifier modifier3;
        final boolean z4;
        final CheckboxColors checkboxColors2;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i8;
        Modifier.Companion companion;
        boolean z5;
        Modifier modifier4;
        boolean z6;
        CheckboxColors checkboxColors3;
        MutableInteractionSource mutableInteractionSource4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1608358065);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TriStateCheckbox)N(state,onClick,modifier,enabled,colors,interactionSource)215@9923L7,216@9983L337:Checkbox.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(toggleableState.ordinal()) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        int i9 = i2 & 4;
        if (i9 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        checkboxColorsColors = checkboxColors;
                        int i10 = composerStartRestartGroup.changed(checkboxColorsColors) ? 16384 : 8192;
                        i3 |= i10;
                    } else {
                        checkboxColorsColors = checkboxColors;
                    }
                    i3 |= i10;
                } else {
                    checkboxColorsColors = checkboxColors;
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
                        ComposerKt.sourceInformation(composerStartRestartGroup, "212@9810L8");
                        i8 = 6;
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i9 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            z5 = i4 == 0 ? z2 : true;
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            }
                            if (i6 != 0) {
                                modifier4 = companion;
                                z6 = z5;
                                i8 = 6;
                                mutableInteractionSource4 = null;
                                checkboxColors3 = checkboxColorsColors;
                            } else {
                                modifier4 = companion;
                                z6 = z5;
                                checkboxColors3 = checkboxColorsColors;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1608358065, i3, -1, "androidx.compose.material3.TriStateCheckbox (Checkbox.kt:214)");
                            }
                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume = composerStartRestartGroup.consume(localDensity);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            float fFloor = (float) Math.floor(((Density) objConsume).mo754toPx0680j_4(CheckboxDefaults.INSTANCE.m2932getStrokeWidthD9Ej5fM()));
                            Stroke stroke = new Stroke(fFloor, 0.0f, StrokeCap.INSTANCE.m7192getSquareKaPHkGw(), 0, null, 26, null);
                            Stroke stroke2 = new Stroke(fFloor, 0.0f, 0, 0, null, 30, null);
                            int i11 = i3 & 126;
                            int i12 = i3 << i8;
                            composer2 = composerStartRestartGroup;
                            TriStateCheckbox(toggleableState, function0, stroke, stroke2, modifier4, z6, checkboxColors3, mutableInteractionSource4, composer2, i11 | (57344 & i12) | (458752 & i12) | (3670016 & i12) | (i12 & 29360128), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                            z4 = z6;
                            checkboxColors2 = checkboxColors3;
                            mutableInteractionSource3 = mutableInteractionSource4;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                            modifier4 = modifier2;
                            z6 = z2;
                            checkboxColors3 = checkboxColorsColors;
                        }
                        mutableInteractionSource4 = mutableInteractionSource2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1608358065, i3, -1, "androidx.compose.material3.TriStateCheckbox (Checkbox.kt:214)");
                        }
                        ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume2 = composerStartRestartGroup.consume(localDensity2);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        float fFloor2 = (float) Math.floor(((Density) objConsume2).mo754toPx0680j_4(CheckboxDefaults.INSTANCE.m2932getStrokeWidthD9Ej5fM()));
                        Stroke stroke3 = new Stroke(fFloor2, 0.0f, StrokeCap.INSTANCE.m7192getSquareKaPHkGw(), 0, null, 26, null);
                        Stroke stroke4 = new Stroke(fFloor2, 0.0f, 0, 0, null, 30, null);
                        int i13 = i3 & 126;
                        int i14 = i3 << i8;
                        composer2 = composerStartRestartGroup;
                        TriStateCheckbox(toggleableState, function0, stroke3, stroke4, modifier4, z6, checkboxColors3, mutableInteractionSource4, composer2, i13 | (57344 & i14) | (458752 & i14) | (3670016 & i14) | (i14 & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        z4 = z6;
                        checkboxColors2 = checkboxColors3;
                        mutableInteractionSource3 = mutableInteractionSource4;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier3 = modifier2;
                        z4 = z2;
                        checkboxColors2 = checkboxColorsColors;
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CheckboxKt.TriStateCheckbox$lambda$1(toggleableState, function0, modifier3, z4, checkboxColors2, mutableInteractionSource3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
                    ComposerKt.sourceInformation(composerStartRestartGroup, "212@9810L8");
                    i8 = 6;
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        }
                        if (i6 != 0) {
                            modifier4 = companion;
                            z6 = z5;
                            i8 = 6;
                            mutableInteractionSource4 = null;
                            checkboxColors3 = checkboxColorsColors;
                        } else {
                            modifier4 = companion;
                            z6 = z5;
                            checkboxColors3 = checkboxColorsColors;
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                    } else {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        }
                        if (i6 != 0) {
                            modifier4 = companion;
                            z6 = z5;
                            i8 = 6;
                            mutableInteractionSource4 = null;
                            checkboxColors3 = checkboxColorsColors;
                        } else {
                            modifier4 = companion;
                            z6 = z5;
                            checkboxColors3 = checkboxColorsColors;
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1608358065, i3, -1, "androidx.compose.material3.TriStateCheckbox (Checkbox.kt:214)");
                    }
                    ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume3 = composerStartRestartGroup.consume(localDensity3);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    float fFloor3 = (float) Math.floor(((Density) objConsume3).mo754toPx0680j_4(CheckboxDefaults.INSTANCE.m2932getStrokeWidthD9Ej5fM()));
                    Stroke stroke5 = new Stroke(fFloor3, 0.0f, StrokeCap.INSTANCE.m7192getSquareKaPHkGw(), 0, null, 26, null);
                    Stroke stroke6 = new Stroke(fFloor3, 0.0f, 0, 0, null, 30, null);
                    int i15 = i3 & 126;
                    int i16 = i3 << i8;
                    composer2 = composerStartRestartGroup;
                    TriStateCheckbox(toggleableState, function0, stroke5, stroke6, modifier4, z6, checkboxColors3, mutableInteractionSource4, composer2, i15 | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    z4 = z6;
                    checkboxColors2 = checkboxColors3;
                    mutableInteractionSource3 = mutableInteractionSource4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    z4 = z2;
                    checkboxColors2 = checkboxColorsColors;
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CheckboxKt.TriStateCheckbox$lambda$1(toggleableState, function0, modifier3, z4, checkboxColors2, mutableInteractionSource3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            z2 = z;
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    checkboxColorsColors = checkboxColors;
                    if (composerStartRestartGroup.changed(checkboxColorsColors)) {
                    }
                    i3 |= i10;
                } else {
                    checkboxColorsColors = checkboxColors;
                }
                i3 |= i10;
            } else {
                checkboxColorsColors = checkboxColors;
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
                    ComposerKt.sourceInformation(composerStartRestartGroup, "212@9810L8");
                    i8 = 6;
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        }
                        if (i6 != 0) {
                            modifier4 = companion;
                            z6 = z5;
                            i8 = 6;
                            mutableInteractionSource4 = null;
                            checkboxColors3 = checkboxColorsColors;
                        } else {
                            modifier4 = companion;
                            z6 = z5;
                            checkboxColors3 = checkboxColorsColors;
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                    } else {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        }
                        if (i6 != 0) {
                            modifier4 = companion;
                            z6 = z5;
                            i8 = 6;
                            mutableInteractionSource4 = null;
                            checkboxColors3 = checkboxColorsColors;
                        } else {
                            modifier4 = companion;
                            z6 = z5;
                            checkboxColors3 = checkboxColorsColors;
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1608358065, i3, -1, "androidx.compose.material3.TriStateCheckbox (Checkbox.kt:214)");
                    }
                    ProvidableCompositionLocal<Density> localDensity4 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume4 = composerStartRestartGroup.consume(localDensity4);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    float fFloor4 = (float) Math.floor(((Density) objConsume4).mo754toPx0680j_4(CheckboxDefaults.INSTANCE.m2932getStrokeWidthD9Ej5fM()));
                    Stroke stroke7 = new Stroke(fFloor4, 0.0f, StrokeCap.INSTANCE.m7192getSquareKaPHkGw(), 0, null, 26, null);
                    Stroke stroke8 = new Stroke(fFloor4, 0.0f, 0, 0, null, 30, null);
                    int i17 = i3 & 126;
                    int i18 = i3 << i8;
                    composer2 = composerStartRestartGroup;
                    TriStateCheckbox(toggleableState, function0, stroke7, stroke8, modifier4, z6, checkboxColors3, mutableInteractionSource4, composer2, i17 | (57344 & i18) | (458752 & i18) | (3670016 & i18) | (i18 & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    z4 = z6;
                    checkboxColors2 = checkboxColors3;
                    mutableInteractionSource3 = mutableInteractionSource4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    z4 = z2;
                    checkboxColors2 = checkboxColorsColors;
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CheckboxKt.TriStateCheckbox$lambda$1(toggleableState, function0, modifier3, z4, checkboxColors2, mutableInteractionSource3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
                ComposerKt.sourceInformation(composerStartRestartGroup, "212@9810L8");
                i8 = 6;
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    }
                    if (i6 != 0) {
                        modifier4 = companion;
                        z6 = z5;
                        i8 = 6;
                        mutableInteractionSource4 = null;
                        checkboxColors3 = checkboxColorsColors;
                    } else {
                        modifier4 = companion;
                        z6 = z5;
                        checkboxColors3 = checkboxColorsColors;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    }
                    if (i6 != 0) {
                        modifier4 = companion;
                        z6 = z5;
                        i8 = 6;
                        mutableInteractionSource4 = null;
                        checkboxColors3 = checkboxColorsColors;
                    } else {
                        modifier4 = companion;
                        z6 = z5;
                        checkboxColors3 = checkboxColorsColors;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1608358065, i3, -1, "androidx.compose.material3.TriStateCheckbox (Checkbox.kt:214)");
                }
                ProvidableCompositionLocal<Density> localDensity5 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume5 = composerStartRestartGroup.consume(localDensity5);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                float fFloor5 = (float) Math.floor(((Density) objConsume5).mo754toPx0680j_4(CheckboxDefaults.INSTANCE.m2932getStrokeWidthD9Ej5fM()));
                Stroke stroke9 = new Stroke(fFloor5, 0.0f, StrokeCap.INSTANCE.m7192getSquareKaPHkGw(), 0, null, 26, null);
                Stroke stroke10 = new Stroke(fFloor5, 0.0f, 0, 0, null, 30, null);
                int i19 = i3 & 126;
                int i110 = i3 << i8;
                composer2 = composerStartRestartGroup;
                TriStateCheckbox(toggleableState, function0, stroke9, stroke10, modifier4, z6, checkboxColors3, mutableInteractionSource4, composer2, i19 | (57344 & i110) | (458752 & i110) | (3670016 & i110) | (i110 & 29360128), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                z4 = z6;
                checkboxColors2 = checkboxColors3;
                mutableInteractionSource3 = mutableInteractionSource4;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                z4 = z2;
                checkboxColors2 = checkboxColorsColors;
                mutableInteractionSource3 = mutableInteractionSource2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CheckboxKt.TriStateCheckbox$lambda$1(toggleableState, function0, modifier3, z4, checkboxColors2, mutableInteractionSource3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 3072) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    checkboxColorsColors = checkboxColors;
                    if (composerStartRestartGroup.changed(checkboxColorsColors)) {
                    }
                    i3 |= i10;
                } else {
                    checkboxColorsColors = checkboxColors;
                }
                i3 |= i10;
            } else {
                checkboxColorsColors = checkboxColors;
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
                    ComposerKt.sourceInformation(composerStartRestartGroup, "212@9810L8");
                    i8 = 6;
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        }
                        if (i6 != 0) {
                            modifier4 = companion;
                            z6 = z5;
                            i8 = 6;
                            mutableInteractionSource4 = null;
                            checkboxColors3 = checkboxColorsColors;
                        } else {
                            modifier4 = companion;
                            z6 = z5;
                            checkboxColors3 = checkboxColorsColors;
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                    } else {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        }
                        if (i6 != 0) {
                            modifier4 = companion;
                            z6 = z5;
                            i8 = 6;
                            mutableInteractionSource4 = null;
                            checkboxColors3 = checkboxColorsColors;
                        } else {
                            modifier4 = companion;
                            z6 = z5;
                            checkboxColors3 = checkboxColorsColors;
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1608358065, i3, -1, "androidx.compose.material3.TriStateCheckbox (Checkbox.kt:214)");
                    }
                    ProvidableCompositionLocal<Density> localDensity6 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume6 = composerStartRestartGroup.consume(localDensity6);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    float fFloor6 = (float) Math.floor(((Density) objConsume6).mo754toPx0680j_4(CheckboxDefaults.INSTANCE.m2932getStrokeWidthD9Ej5fM()));
                    Stroke stroke11 = new Stroke(fFloor6, 0.0f, StrokeCap.INSTANCE.m7192getSquareKaPHkGw(), 0, null, 26, null);
                    Stroke stroke12 = new Stroke(fFloor6, 0.0f, 0, 0, null, 30, null);
                    int i111 = i3 & 126;
                    int i112 = i3 << i8;
                    composer2 = composerStartRestartGroup;
                    TriStateCheckbox(toggleableState, function0, stroke11, stroke12, modifier4, z6, checkboxColors3, mutableInteractionSource4, composer2, i111 | (57344 & i112) | (458752 & i112) | (3670016 & i112) | (i112 & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    z4 = z6;
                    checkboxColors2 = checkboxColors3;
                    mutableInteractionSource3 = mutableInteractionSource4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    z4 = z2;
                    checkboxColors2 = checkboxColorsColors;
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CheckboxKt.TriStateCheckbox$lambda$1(toggleableState, function0, modifier3, z4, checkboxColors2, mutableInteractionSource3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
                ComposerKt.sourceInformation(composerStartRestartGroup, "212@9810L8");
                i8 = 6;
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    }
                    if (i6 != 0) {
                        modifier4 = companion;
                        z6 = z5;
                        i8 = 6;
                        mutableInteractionSource4 = null;
                        checkboxColors3 = checkboxColorsColors;
                    } else {
                        modifier4 = companion;
                        z6 = z5;
                        checkboxColors3 = checkboxColorsColors;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    }
                    if (i6 != 0) {
                        modifier4 = companion;
                        z6 = z5;
                        i8 = 6;
                        mutableInteractionSource4 = null;
                        checkboxColors3 = checkboxColorsColors;
                    } else {
                        modifier4 = companion;
                        z6 = z5;
                        checkboxColors3 = checkboxColorsColors;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1608358065, i3, -1, "androidx.compose.material3.TriStateCheckbox (Checkbox.kt:214)");
                }
                ProvidableCompositionLocal<Density> localDensity7 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume7 = composerStartRestartGroup.consume(localDensity7);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                float fFloor7 = (float) Math.floor(((Density) objConsume7).mo754toPx0680j_4(CheckboxDefaults.INSTANCE.m2932getStrokeWidthD9Ej5fM()));
                Stroke stroke13 = new Stroke(fFloor7, 0.0f, StrokeCap.INSTANCE.m7192getSquareKaPHkGw(), 0, null, 26, null);
                Stroke stroke14 = new Stroke(fFloor7, 0.0f, 0, 0, null, 30, null);
                int i113 = i3 & 126;
                int i114 = i3 << i8;
                composer2 = composerStartRestartGroup;
                TriStateCheckbox(toggleableState, function0, stroke13, stroke14, modifier4, z6, checkboxColors3, mutableInteractionSource4, composer2, i113 | (57344 & i114) | (458752 & i114) | (3670016 & i114) | (i114 & 29360128), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                z4 = z6;
                checkboxColors2 = checkboxColors3;
                mutableInteractionSource3 = mutableInteractionSource4;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                z4 = z2;
                checkboxColors2 = checkboxColorsColors;
                mutableInteractionSource3 = mutableInteractionSource2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CheckboxKt.TriStateCheckbox$lambda$1(toggleableState, function0, modifier3, z4, checkboxColors2, mutableInteractionSource3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        z2 = z;
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                checkboxColorsColors = checkboxColors;
                if (composerStartRestartGroup.changed(checkboxColorsColors)) {
                }
                i3 |= i10;
            } else {
                checkboxColorsColors = checkboxColors;
            }
            i3 |= i10;
        } else {
            checkboxColorsColors = checkboxColors;
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
                ComposerKt.sourceInformation(composerStartRestartGroup, "212@9810L8");
                i8 = 6;
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    }
                    if (i6 != 0) {
                        modifier4 = companion;
                        z6 = z5;
                        i8 = 6;
                        mutableInteractionSource4 = null;
                        checkboxColors3 = checkboxColorsColors;
                    } else {
                        modifier4 = companion;
                        z6 = z5;
                        checkboxColors3 = checkboxColorsColors;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    }
                    if (i6 != 0) {
                        modifier4 = companion;
                        z6 = z5;
                        i8 = 6;
                        mutableInteractionSource4 = null;
                        checkboxColors3 = checkboxColorsColors;
                    } else {
                        modifier4 = companion;
                        z6 = z5;
                        checkboxColors3 = checkboxColorsColors;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1608358065, i3, -1, "androidx.compose.material3.TriStateCheckbox (Checkbox.kt:214)");
                }
                ProvidableCompositionLocal<Density> localDensity8 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume8 = composerStartRestartGroup.consume(localDensity8);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                float fFloor8 = (float) Math.floor(((Density) objConsume8).mo754toPx0680j_4(CheckboxDefaults.INSTANCE.m2932getStrokeWidthD9Ej5fM()));
                Stroke stroke15 = new Stroke(fFloor8, 0.0f, StrokeCap.INSTANCE.m7192getSquareKaPHkGw(), 0, null, 26, null);
                Stroke stroke16 = new Stroke(fFloor8, 0.0f, 0, 0, null, 30, null);
                int i115 = i3 & 126;
                int i116 = i3 << i8;
                composer2 = composerStartRestartGroup;
                TriStateCheckbox(toggleableState, function0, stroke15, stroke16, modifier4, z6, checkboxColors3, mutableInteractionSource4, composer2, i115 | (57344 & i116) | (458752 & i116) | (3670016 & i116) | (i116 & 29360128), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                z4 = z6;
                checkboxColors2 = checkboxColors3;
                mutableInteractionSource3 = mutableInteractionSource4;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                z4 = z2;
                checkboxColors2 = checkboxColorsColors;
                mutableInteractionSource3 = mutableInteractionSource2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CheckboxKt.TriStateCheckbox$lambda$1(toggleableState, function0, modifier3, z4, checkboxColors2, mutableInteractionSource3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
            ComposerKt.sourceInformation(composerStartRestartGroup, "212@9810L8");
            i8 = 6;
            if ((i & 1) != 0) {
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 == 0) {
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                }
                if (i6 != 0) {
                    modifier4 = companion;
                    z6 = z5;
                    i8 = 6;
                    mutableInteractionSource4 = null;
                    checkboxColors3 = checkboxColorsColors;
                } else {
                    modifier4 = companion;
                    z6 = z5;
                    checkboxColors3 = checkboxColorsColors;
                    mutableInteractionSource4 = mutableInteractionSource2;
                }
            } else {
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 == 0) {
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                }
                if (i6 != 0) {
                    modifier4 = companion;
                    z6 = z5;
                    i8 = 6;
                    mutableInteractionSource4 = null;
                    checkboxColors3 = checkboxColorsColors;
                } else {
                    modifier4 = companion;
                    z6 = z5;
                    checkboxColors3 = checkboxColorsColors;
                    mutableInteractionSource4 = mutableInteractionSource2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1608358065, i3, -1, "androidx.compose.material3.TriStateCheckbox (Checkbox.kt:214)");
            }
            ProvidableCompositionLocal<Density> localDensity9 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume9 = composerStartRestartGroup.consume(localDensity9);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            float fFloor9 = (float) Math.floor(((Density) objConsume9).mo754toPx0680j_4(CheckboxDefaults.INSTANCE.m2932getStrokeWidthD9Ej5fM()));
            Stroke stroke17 = new Stroke(fFloor9, 0.0f, StrokeCap.INSTANCE.m7192getSquareKaPHkGw(), 0, null, 26, null);
            Stroke stroke18 = new Stroke(fFloor9, 0.0f, 0, 0, null, 30, null);
            int i117 = i3 & 126;
            int i118 = i3 << i8;
            composer2 = composerStartRestartGroup;
            TriStateCheckbox(toggleableState, function0, stroke17, stroke18, modifier4, z6, checkboxColors3, mutableInteractionSource4, composer2, i117 | (57344 & i118) | (458752 & i118) | (3670016 & i118) | (i118 & 29360128), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            z4 = z6;
            checkboxColors2 = checkboxColors3;
            mutableInteractionSource3 = mutableInteractionSource4;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            z4 = z2;
            checkboxColors2 = checkboxColorsColors;
            mutableInteractionSource3 = mutableInteractionSource2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CheckboxKt.TriStateCheckbox$lambda$1(toggleableState, function0, modifier3, z4, checkboxColors2, mutableInteractionSource3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0146  */
    /* JADX WARN: Code duplicated, block: B:105:0x0154  */
    /* JADX WARN: Code duplicated, block: B:106:0x016d  */
    /* JADX WARN: Code duplicated, block: B:108:0x018a  */
    /* JADX WARN: Code duplicated, block: B:109:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:111:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:112:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:115:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:116:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:119:0x0208  */
    /* JADX WARN: Code duplicated, block: B:121:0x0212  */
    /* JADX WARN: Code duplicated, block: B:124:0x0221  */
    /* JADX WARN: Code duplicated, block: B:126:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x0083  */
    /* JADX WARN: Code duplicated, block: B:45:0x0085  */
    /* JADX WARN: Code duplicated, block: B:47:0x0088  */
    /* JADX WARN: Code duplicated, block: B:49:0x0090  */
    /* JADX WARN: Code duplicated, block: B:50:0x0093  */
    /* JADX WARN: Code duplicated, block: B:55:0x009e  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:59:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:66:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:71:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:72:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:76:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:80:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:82:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:88:0x010d A[PHI: r2 r5 r13 r14
      0x010d: PHI (r2v35 int) = (r2v20 int), (r2v38 int) binds: [B:98:0x0135, B:87:0x010b] A[DONT_GENERATE, DONT_INLINE]
      0x010d: PHI (r5v14 androidx.compose.ui.Modifier) = (r5v4 androidx.compose.ui.Modifier), (r5v2 androidx.compose.ui.Modifier) binds: [B:98:0x0135, B:87:0x010b] A[DONT_GENERATE, DONT_INLINE]
      0x010d: PHI (r13v8 boolean) = (r13v4 boolean), (r13v3 boolean) binds: [B:98:0x0135, B:87:0x010b] A[DONT_GENERATE, DONT_INLINE]
      0x010d: PHI (r14v11 androidx.compose.material3.CheckboxColors) = (r14v8 androidx.compose.material3.CheckboxColors), (r14v7 androidx.compose.material3.CheckboxColors) binds: [B:98:0x0135, B:87:0x010b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:90:0x011a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:91:0x011c  */
    /* JADX WARN: Code duplicated, block: B:93:0x0123  */
    /* JADX WARN: Code duplicated, block: B:96:0x0129  */
    /* JADX WARN: Code duplicated, block: B:97:0x0133  */
    /* JADX WARN: Code duplicated, block: B:99:0x0137  */
    public static final void TriStateCheckbox(final ToggleableState toggleableState, final Function0<Unit> function0, final Stroke stroke, final Stroke stroke2, Modifier modifier, boolean z, CheckboxColors checkboxColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i3;
        final Modifier modifier2;
        int i4;
        boolean z2;
        int i5;
        CheckboxColors checkboxColorsColors;
        int i6;
        int i7;
        int i8;
        boolean z3;
        final MutableInteractionSource mutableInteractionSource2;
        Composer composer2;
        final boolean z4;
        final CheckboxColors checkboxColors2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i9;
        MutableInteractionSource mutableInteractionSource3;
        boolean z5;
        int i10;
        Modifier modifier3;
        boolean z6;
        IndicationNodeFactory indicationNodeFactoryM4031rippleH2RKhps$default;
        MutableInteractionSource mutableInteractionSource4;
        boolean z7;
        Modifier.Companion companionM1546triStateToggleableO2vRcR0;
        Modifier.Companion companionMinimumInteractiveComponentSize;
        Modifier.Companion companionM1218padding3ABfNKs;
        MutableInteractionSource mutableInteractionSource5;
        Composer composerStartRestartGroup = composer.startRestartGroup(-406243761);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TriStateCheckbox)N(state,onClick,checkmarkStroke,outlineStroke,modifier,enabled,colors,interactionSource)301@13908L739:Checkbox.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(toggleableState.ordinal()) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(stroke) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(stroke2) ? 2048 : 1024;
        }
        int i11 = i2 & 16;
        if (i11 == 0) {
            if ((i & 24576) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
            }
            i4 = i2 & 32;
            if (i4 != 0) {
                if ((196608 & i) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i5 = 131072;
                    } else {
                        i5 = 65536;
                    }
                    i3 |= i5;
                }
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        checkboxColorsColors = checkboxColors;
                        int i12 = composerStartRestartGroup.changed(checkboxColorsColors) ? 1048576 : 524288;
                        i3 |= i12;
                    } else {
                        checkboxColorsColors = checkboxColors;
                    }
                    i3 |= i12;
                } else {
                    checkboxColorsColors = checkboxColors;
                }
                i6 = i2 & 128;
                if (i6 != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i7 = 8388608;
                    } else {
                        i7 = 4194304;
                    }
                    i3 |= i7;
                }
                i8 = i3;
                if ((i3 & 4793491) != 4793490) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i8 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "274@12999L8");
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 64) != 0) {
                            i9 = i8 & (-3670017);
                            checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        } else {
                            i9 = i8;
                        }
                        if (i6 != 0) {
                            int i13 = i9;
                            mutableInteractionSource3 = null;
                            z5 = z2;
                            i10 = i13;
                            modifier3 = modifier2;
                        } else {
                            modifier3 = modifier2;
                            z5 = z2;
                            i10 = i9;
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 64) != 0) {
                            i9 = i8 & (-3670017);
                            modifier3 = modifier2;
                            z5 = z2;
                            i10 = i9;
                            mutableInteractionSource3 = mutableInteractionSource;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                            modifier3 = modifier2;
                            z5 = z2;
                            i10 = i8;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-406243761, i10, -1, "androidx.compose.material3.TriStateCheckbox (Checkbox.kt:276)");
                    }
                    z6 = ComposeMaterial3Flags.isCheckboxStylingFixEnabled;
                    if (z6) {
                        indicationNodeFactoryM4031rippleH2RKhps$default = RippleKt.m4030rippleH2RKhps(false, Dp.m9687constructorimpl(CheckboxTokens.INSTANCE.m5200getStateLayerSizeD9Ej5fM() / 2), checkboxColorsColors.m2929indicatorColorvNxB06k$material3(toggleableState));
                    } else {
                        indicationNodeFactoryM4031rippleH2RKhps$default = RippleKt.m4031rippleH2RKhps$default(false, Dp.m9687constructorimpl(CheckboxTokens.INSTANCE.m5200getStateLayerSizeD9Ej5fM() / 2), 0L, 4, null);
                    }
                    if (function0 != null) {
                        z7 = z5;
                        companionM1546triStateToggleableO2vRcR0 = ToggleableKt.m1546triStateToggleableO2vRcR0(Modifier.INSTANCE, toggleableState, mutableInteractionSource5, indicationNodeFactoryM4031rippleH2RKhps$default, z7, Role.m8825boximpl(Role.INSTANCE.m8834getCheckboxo7Vup1c()), function0);
                        mutableInteractionSource4 = mutableInteractionSource5;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource3;
                        z7 = z5;
                        companionM1546triStateToggleableO2vRcR0 = Modifier.INSTANCE;
                    }
                    if (function0 != null) {
                        mutableInteractionSource5 = mutableInteractionSource3;
                        companionMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE);
                    } else {
                        mutableInteractionSource5 = mutableInteractionSource3;
                        companionMinimumInteractiveComponentSize = Modifier.INSTANCE;
                    }
                    Modifier modifierThen = modifier3.then(companionMinimumInteractiveComponentSize).then(companionM1546triStateToggleableO2vRcR0);
                    if (z6) {
                        companionM1218padding3ABfNKs = Modifier.INSTANCE;
                    } else {
                        companionM1218padding3ABfNKs = PaddingKt.m1218padding3ABfNKs(Modifier.INSTANCE, CheckboxDefaultPadding);
                    }
                    Modifier modifierThen2 = modifierThen.then(companionM1218padding3ABfNKs);
                    int i14 = i10 << 6;
                    CheckboxColors checkboxColors3 = checkboxColorsColors;
                    boolean z8 = z7;
                    CheckboxImpl(z8, toggleableState, modifierThen2, checkboxColors3, stroke, stroke2, composerStartRestartGroup, ((i10 >> 15) & 14) | ((i10 << 3) & 112) | ((i10 >> 9) & 7168) | (57344 & i14) | (i14 & 458752));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    checkboxColors2 = checkboxColors3;
                    composer2 = composerStartRestartGroup;
                    modifier2 = modifier3;
                    mutableInteractionSource2 = mutableInteractionSource4;
                    z4 = z8;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    composer2 = composerStartRestartGroup;
                    z4 = z2;
                    checkboxColors2 = checkboxColorsColors;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CheckboxKt.TriStateCheckbox$lambda$2(toggleableState, function0, stroke, stroke2, modifier2, z4, checkboxColors2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z2 = z;
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    checkboxColorsColors = checkboxColors;
                    if (composerStartRestartGroup.changed(checkboxColorsColors)) {
                    }
                    i3 |= i12;
                } else {
                    checkboxColorsColors = checkboxColors;
                }
                i3 |= i12;
            } else {
                checkboxColorsColors = checkboxColors;
            }
            i6 = i2 & 128;
            if (i6 != 0) {
                i3 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i7 = 8388608;
                } else {
                    i7 = 4194304;
                }
                i3 |= i7;
            }
            i8 = i3;
            if ((i3 & 4793491) != 4793490) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i8 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "274@12999L8");
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 64) != 0) {
                        i9 = i8 & (-3670017);
                        checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    } else {
                        i9 = i8;
                    }
                    if (i6 != 0) {
                        int i15 = i9;
                        mutableInteractionSource3 = null;
                        z5 = z2;
                        i10 = i15;
                        modifier3 = modifier2;
                    } else {
                        modifier3 = modifier2;
                        z5 = z2;
                        i10 = i9;
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 64) != 0) {
                        i9 = i8 & (-3670017);
                        checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    } else {
                        i9 = i8;
                    }
                    if (i6 != 0) {
                        int i16 = i9;
                        mutableInteractionSource3 = null;
                        z5 = z2;
                        i10 = i16;
                        modifier3 = modifier2;
                    } else {
                        modifier3 = modifier2;
                        z5 = z2;
                        i10 = i9;
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-406243761, i10, -1, "androidx.compose.material3.TriStateCheckbox (Checkbox.kt:276)");
                }
                z6 = ComposeMaterial3Flags.isCheckboxStylingFixEnabled;
                if (z6) {
                    indicationNodeFactoryM4031rippleH2RKhps$default = RippleKt.m4030rippleH2RKhps(false, Dp.m9687constructorimpl(CheckboxTokens.INSTANCE.m5200getStateLayerSizeD9Ej5fM() / 2), checkboxColorsColors.m2929indicatorColorvNxB06k$material3(toggleableState));
                } else {
                    indicationNodeFactoryM4031rippleH2RKhps$default = RippleKt.m4031rippleH2RKhps$default(false, Dp.m9687constructorimpl(CheckboxTokens.INSTANCE.m5200getStateLayerSizeD9Ej5fM() / 2), 0L, 4, null);
                }
                if (function0 != null) {
                    z7 = z5;
                    companionM1546triStateToggleableO2vRcR0 = ToggleableKt.m1546triStateToggleableO2vRcR0(Modifier.INSTANCE, toggleableState, mutableInteractionSource5, indicationNodeFactoryM4031rippleH2RKhps$default, z7, Role.m8825boximpl(Role.INSTANCE.m8834getCheckboxo7Vup1c()), function0);
                    mutableInteractionSource4 = mutableInteractionSource5;
                } else {
                    mutableInteractionSource4 = mutableInteractionSource3;
                    z7 = z5;
                    companionM1546triStateToggleableO2vRcR0 = Modifier.INSTANCE;
                }
                if (function0 != null) {
                    mutableInteractionSource5 = mutableInteractionSource3;
                    companionMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE);
                } else {
                    mutableInteractionSource5 = mutableInteractionSource3;
                    companionMinimumInteractiveComponentSize = Modifier.INSTANCE;
                }
                Modifier modifierThen3 = modifier3.then(companionMinimumInteractiveComponentSize).then(companionM1546triStateToggleableO2vRcR0);
                if (z6) {
                    companionM1218padding3ABfNKs = Modifier.INSTANCE;
                } else {
                    companionM1218padding3ABfNKs = PaddingKt.m1218padding3ABfNKs(Modifier.INSTANCE, CheckboxDefaultPadding);
                }
                Modifier modifierThen4 = modifierThen3.then(companionM1218padding3ABfNKs);
                int i17 = i10 << 6;
                CheckboxColors checkboxColors4 = checkboxColorsColors;
                boolean z9 = z7;
                CheckboxImpl(z9, toggleableState, modifierThen4, checkboxColors4, stroke, stroke2, composerStartRestartGroup, ((i10 >> 15) & 14) | ((i10 << 3) & 112) | ((i10 >> 9) & 7168) | (57344 & i17) | (i17 & 458752));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                checkboxColors2 = checkboxColors4;
                composer2 = composerStartRestartGroup;
                modifier2 = modifier3;
                mutableInteractionSource2 = mutableInteractionSource4;
                z4 = z9;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                mutableInteractionSource2 = mutableInteractionSource;
                composer2 = composerStartRestartGroup;
                z4 = z2;
                checkboxColors2 = checkboxColorsColors;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CheckboxKt.TriStateCheckbox$lambda$2(toggleableState, function0, stroke, stroke2, modifier2, z4, checkboxColors2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        modifier2 = modifier;
        i4 = i2 & 32;
        if (i4 != 0) {
            if ((196608 & i) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i5 = 131072;
                } else {
                    i5 = 65536;
                }
                i3 |= i5;
            }
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    checkboxColorsColors = checkboxColors;
                    if (composerStartRestartGroup.changed(checkboxColorsColors)) {
                    }
                    i3 |= i12;
                } else {
                    checkboxColorsColors = checkboxColors;
                }
                i3 |= i12;
            } else {
                checkboxColorsColors = checkboxColors;
            }
            i6 = i2 & 128;
            if (i6 != 0) {
                i3 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i7 = 8388608;
                } else {
                    i7 = 4194304;
                }
                i3 |= i7;
            }
            i8 = i3;
            if ((i3 & 4793491) != 4793490) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i8 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "274@12999L8");
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 64) != 0) {
                        i9 = i8 & (-3670017);
                        checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    } else {
                        i9 = i8;
                    }
                    if (i6 != 0) {
                        int i18 = i9;
                        mutableInteractionSource3 = null;
                        z5 = z2;
                        i10 = i18;
                        modifier3 = modifier2;
                    } else {
                        modifier3 = modifier2;
                        z5 = z2;
                        i10 = i9;
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 64) != 0) {
                        i9 = i8 & (-3670017);
                        checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    } else {
                        i9 = i8;
                    }
                    if (i6 != 0) {
                        int i19 = i9;
                        mutableInteractionSource3 = null;
                        z5 = z2;
                        i10 = i19;
                        modifier3 = modifier2;
                    } else {
                        modifier3 = modifier2;
                        z5 = z2;
                        i10 = i9;
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-406243761, i10, -1, "androidx.compose.material3.TriStateCheckbox (Checkbox.kt:276)");
                }
                z6 = ComposeMaterial3Flags.isCheckboxStylingFixEnabled;
                if (z6) {
                    indicationNodeFactoryM4031rippleH2RKhps$default = RippleKt.m4030rippleH2RKhps(false, Dp.m9687constructorimpl(CheckboxTokens.INSTANCE.m5200getStateLayerSizeD9Ej5fM() / 2), checkboxColorsColors.m2929indicatorColorvNxB06k$material3(toggleableState));
                } else {
                    indicationNodeFactoryM4031rippleH2RKhps$default = RippleKt.m4031rippleH2RKhps$default(false, Dp.m9687constructorimpl(CheckboxTokens.INSTANCE.m5200getStateLayerSizeD9Ej5fM() / 2), 0L, 4, null);
                }
                if (function0 != null) {
                    z7 = z5;
                    companionM1546triStateToggleableO2vRcR0 = ToggleableKt.m1546triStateToggleableO2vRcR0(Modifier.INSTANCE, toggleableState, mutableInteractionSource5, indicationNodeFactoryM4031rippleH2RKhps$default, z7, Role.m8825boximpl(Role.INSTANCE.m8834getCheckboxo7Vup1c()), function0);
                    mutableInteractionSource4 = mutableInteractionSource5;
                } else {
                    mutableInteractionSource4 = mutableInteractionSource3;
                    z7 = z5;
                    companionM1546triStateToggleableO2vRcR0 = Modifier.INSTANCE;
                }
                if (function0 != null) {
                    mutableInteractionSource5 = mutableInteractionSource3;
                    companionMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE);
                } else {
                    mutableInteractionSource5 = mutableInteractionSource3;
                    companionMinimumInteractiveComponentSize = Modifier.INSTANCE;
                }
                Modifier modifierThen5 = modifier3.then(companionMinimumInteractiveComponentSize).then(companionM1546triStateToggleableO2vRcR0);
                if (z6) {
                    companionM1218padding3ABfNKs = Modifier.INSTANCE;
                } else {
                    companionM1218padding3ABfNKs = PaddingKt.m1218padding3ABfNKs(Modifier.INSTANCE, CheckboxDefaultPadding);
                }
                Modifier modifierThen6 = modifierThen5.then(companionM1218padding3ABfNKs);
                int i110 = i10 << 6;
                CheckboxColors checkboxColors5 = checkboxColorsColors;
                boolean z10 = z7;
                CheckboxImpl(z10, toggleableState, modifierThen6, checkboxColors5, stroke, stroke2, composerStartRestartGroup, ((i10 >> 15) & 14) | ((i10 << 3) & 112) | ((i10 >> 9) & 7168) | (57344 & i110) | (i110 & 458752));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                checkboxColors2 = checkboxColors5;
                composer2 = composerStartRestartGroup;
                modifier2 = modifier3;
                mutableInteractionSource2 = mutableInteractionSource4;
                z4 = z10;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                mutableInteractionSource2 = mutableInteractionSource;
                composer2 = composerStartRestartGroup;
                z4 = z2;
                checkboxColors2 = checkboxColorsColors;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CheckboxKt.TriStateCheckbox$lambda$2(toggleableState, function0, stroke, stroke2, modifier2, z4, checkboxColors2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        z2 = z;
        if ((1572864 & i) == 0) {
            if ((i2 & 64) == 0) {
                checkboxColorsColors = checkboxColors;
                if (composerStartRestartGroup.changed(checkboxColorsColors)) {
                }
                i3 |= i12;
            } else {
                checkboxColorsColors = checkboxColors;
            }
            i3 |= i12;
        } else {
            checkboxColorsColors = checkboxColors;
        }
        i6 = i2 & 128;
        if (i6 != 0) {
            i3 |= 12582912;
        } else if ((i & 12582912) == 0) {
            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                i7 = 8388608;
            } else {
                i7 = 4194304;
            }
            i3 |= i7;
        }
        i8 = i3;
        if ((i3 & 4793491) != 4793490) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i8 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "274@12999L8");
            if ((i & 1) != 0) {
                if (i11 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    z2 = true;
                }
                if ((i2 & 64) != 0) {
                    i9 = i8 & (-3670017);
                    checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                } else {
                    i9 = i8;
                }
                if (i6 != 0) {
                    int i111 = i9;
                    mutableInteractionSource3 = null;
                    z5 = z2;
                    i10 = i111;
                    modifier3 = modifier2;
                } else {
                    modifier3 = modifier2;
                    z5 = z2;
                    i10 = i9;
                    mutableInteractionSource3 = mutableInteractionSource;
                }
            } else {
                if (i11 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    z2 = true;
                }
                if ((i2 & 64) != 0) {
                    i9 = i8 & (-3670017);
                    checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                } else {
                    i9 = i8;
                }
                if (i6 != 0) {
                    int i112 = i9;
                    mutableInteractionSource3 = null;
                    z5 = z2;
                    i10 = i112;
                    modifier3 = modifier2;
                } else {
                    modifier3 = modifier2;
                    z5 = z2;
                    i10 = i9;
                    mutableInteractionSource3 = mutableInteractionSource;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-406243761, i10, -1, "androidx.compose.material3.TriStateCheckbox (Checkbox.kt:276)");
            }
            z6 = ComposeMaterial3Flags.isCheckboxStylingFixEnabled;
            if (z6) {
                indicationNodeFactoryM4031rippleH2RKhps$default = RippleKt.m4030rippleH2RKhps(false, Dp.m9687constructorimpl(CheckboxTokens.INSTANCE.m5200getStateLayerSizeD9Ej5fM() / 2), checkboxColorsColors.m2929indicatorColorvNxB06k$material3(toggleableState));
            } else {
                indicationNodeFactoryM4031rippleH2RKhps$default = RippleKt.m4031rippleH2RKhps$default(false, Dp.m9687constructorimpl(CheckboxTokens.INSTANCE.m5200getStateLayerSizeD9Ej5fM() / 2), 0L, 4, null);
            }
            if (function0 != null) {
                z7 = z5;
                companionM1546triStateToggleableO2vRcR0 = ToggleableKt.m1546triStateToggleableO2vRcR0(Modifier.INSTANCE, toggleableState, mutableInteractionSource5, indicationNodeFactoryM4031rippleH2RKhps$default, z7, Role.m8825boximpl(Role.INSTANCE.m8834getCheckboxo7Vup1c()), function0);
                mutableInteractionSource4 = mutableInteractionSource5;
            } else {
                mutableInteractionSource4 = mutableInteractionSource3;
                z7 = z5;
                companionM1546triStateToggleableO2vRcR0 = Modifier.INSTANCE;
            }
            if (function0 != null) {
                mutableInteractionSource5 = mutableInteractionSource3;
                companionMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE);
            } else {
                mutableInteractionSource5 = mutableInteractionSource3;
                companionMinimumInteractiveComponentSize = Modifier.INSTANCE;
            }
            Modifier modifierThen7 = modifier3.then(companionMinimumInteractiveComponentSize).then(companionM1546triStateToggleableO2vRcR0);
            if (z6) {
                companionM1218padding3ABfNKs = Modifier.INSTANCE;
            } else {
                companionM1218padding3ABfNKs = PaddingKt.m1218padding3ABfNKs(Modifier.INSTANCE, CheckboxDefaultPadding);
            }
            Modifier modifierThen8 = modifierThen7.then(companionM1218padding3ABfNKs);
            int i113 = i10 << 6;
            CheckboxColors checkboxColors6 = checkboxColorsColors;
            boolean z11 = z7;
            CheckboxImpl(z11, toggleableState, modifierThen8, checkboxColors6, stroke, stroke2, composerStartRestartGroup, ((i10 >> 15) & 14) | ((i10 << 3) & 112) | ((i10 >> 9) & 7168) | (57344 & i113) | (i113 & 458752));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            checkboxColors2 = checkboxColors6;
            composer2 = composerStartRestartGroup;
            modifier2 = modifier3;
            mutableInteractionSource2 = mutableInteractionSource4;
            z4 = z11;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            mutableInteractionSource2 = mutableInteractionSource;
            composer2 = composerStartRestartGroup;
            z4 = z2;
            checkboxColors2 = checkboxColorsColors;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CheckboxKt.TriStateCheckbox$lambda$2(toggleableState, function0, stroke, stroke2, modifier2, z4, checkboxColors2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0206  */
    /* JADX WARN: Code duplicated, block: B:105:0x020e  */
    /* JADX WARN: Code duplicated, block: B:108:0x022c  */
    /* JADX WARN: Code duplicated, block: B:115:0x0242  */
    /* JADX WARN: Code duplicated, block: B:116:0x0245  */
    /* JADX WARN: Code duplicated, block: B:120:0x0251  */
    /* JADX WARN: Code duplicated, block: B:123:0x0296  */
    /* JADX WARN: Code duplicated, block: B:126:0x02b1  */
    /* JADX WARN: Code duplicated, block: B:127:0x02c9  */
    /* JADX WARN: Code duplicated, block: B:130:0x02f1  */
    /* JADX WARN: Code duplicated, block: B:131:0x02f8  */
    /* JADX WARN: Code duplicated, block: B:138:0x0344  */
    /* JADX WARN: Code duplicated, block: B:141:0x035f  */
    /* JADX WARN: Code duplicated, block: B:89:0x017b  */
    /* JADX WARN: Code duplicated, block: B:92:0x01e8  */
    private static final void CheckboxImpl(final boolean z, final ToggleableState toggleableState, final Modifier modifier, final CheckboxColors checkboxColors, final Stroke stroke, final Stroke stroke2, Composer composer, final int i) {
        int i2;
        Composer composer2;
        float f;
        float f2;
        final State stateCreateTransitionAnimation;
        int i3;
        float f3;
        int i4;
        final State stateCreateTransitionAnimation2;
        Object objRememberedValue;
        final CheckDrawingCache checkDrawingCache;
        State<Color> stateCheckmarkColor$material3;
        final State<Color> state;
        final State<Color> stateBoxColor$material3;
        final State<Color> stateBorderColor$material3;
        float fM5193getContainerSizeD9Ej5fM;
        boolean zChanged;
        Object objRememberedValue2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-891330208);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CheckboxImpl)N(enabled,value,modifier,colors,checkmarkStroke,outlineStroke)479@23102L23,480@23194L14,482@23256L608,500@23931L594,516@24547L32,523@24788L24,524@24842L27,531@25113L476,531@25034L555:Checkbox.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(toggleableState.ordinal()) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(checkboxColors) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(stroke) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(stroke2) ? 131072 : 65536;
        }
        if (!composerStartRestartGroup.shouldExecute((74899 & i2) != 74898, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-891330208, i2, -1, "androidx.compose.material3.CheckboxImpl (Checkbox.kt:477)");
            }
            boolean z2 = ComposeMaterial3Flags.isCheckboxStylingFixEnabled;
            int i5 = i2 >> 3;
            int i6 = i5 & 14;
            Transition transitionUpdateTransition = TransitionKt.updateTransition(toggleableState, (String) null, composerStartRestartGroup, i6, 2);
            final FiniteAnimationSpec finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
            Function3 function3 = new Function3() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return CheckboxKt.CheckboxImpl$lambda$0(finiteAnimationSpecValue, (Transition.Segment) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1338768149, "CC(animateFloat)P(2)1924@81822L78:Transition.kt#pdpnli");
            TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
            ToggleableState toggleableState2 = (ToggleableState) transitionUpdateTransition.getCurrentState();
            composerStartRestartGroup.startReplaceGroup(-768316570);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):Checkbox.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-768316570, 0, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:492)");
            }
            int i7 = WhenMappings.$EnumSwitchMapping$0[toggleableState2.ordinal()];
            float f4 = 0.0f;
            if (i7 == 1) {
                f = 1.0f;
            } else if (i7 != 2) {
                if (i7 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                f = 1.0f;
            } else {
                f = 0.0f;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceGroup();
            Float fValueOf = Float.valueOf(f);
            ToggleableState toggleableState3 = (ToggleableState) transitionUpdateTransition.getTargetState();
            composerStartRestartGroup.startReplaceGroup(-768316570);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):Checkbox.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-768316570, 0, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:492)");
            }
            int i8 = WhenMappings.$EnumSwitchMapping$0[toggleableState3.ordinal()];
            if (i8 != 1) {
                if (i8 == 2) {
                    f2 = 0.0f;
                } else if (i8 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composerStartRestartGroup.endReplaceGroup();
                stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf, Float.valueOf(f2), (FiniteAnimationSpec) function3.invoke(transitionUpdateTransition.getSegment(), composerStartRestartGroup, 0), vectorConverter, "FloatAnimation", composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Function3 function4 = new Function3() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return CheckboxKt.CheckboxImpl$lambda$2(finiteAnimationSpecValue, (Transition.Segment) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                };
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1338768149, "CC(animateFloat)P(2)1924@81822L78:Transition.kt#pdpnli");
                TwoWayConverter<Float, AnimationVector1D> vectorConverter2 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
                ToggleableState toggleableState4 = (ToggleableState) transitionUpdateTransition.getCurrentState();
                composerStartRestartGroup.startReplaceGroup(1840054703);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):Checkbox.kt#uh7d8r");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1840054703, 0, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:510)");
                }
                i3 = WhenMappings.$EnumSwitchMapping$0[toggleableState4.ordinal()];
                if (i3 != 1 || i3 == 2) {
                    f3 = 0.0f;
                } else {
                    if (i3 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    f3 = 1.0f;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composerStartRestartGroup.endReplaceGroup();
                Float fValueOf2 = Float.valueOf(f3);
                ToggleableState toggleableState5 = (ToggleableState) transitionUpdateTransition.getTargetState();
                composerStartRestartGroup.startReplaceGroup(1840054703);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):Checkbox.kt#uh7d8r");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1840054703, 0, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:510)");
                }
                i4 = WhenMappings.$EnumSwitchMapping$0[toggleableState5.ordinal()];
                if (i4 != 1 && i4 != 2) {
                    if (i4 == 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    f4 = 1.0f;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composerStartRestartGroup.endReplaceGroup();
                stateCreateTransitionAnimation2 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf2, Float.valueOf(f4), (FiniteAnimationSpec) function4.invoke(transitionUpdateTransition.getSegment(), composerStartRestartGroup, 0), vectorConverter2, "FloatAnimation", composerStartRestartGroup, 0);
                composer2 = composerStartRestartGroup;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerStart(composer2, -1869782464, "CC(remember):Checkbox.kt#9igjgp");
                objRememberedValue = composer2.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    Object checkDrawingCache2 = new CheckDrawingCache(null, null, null, 7, null);
                    composer2.updateRememberedValue(checkDrawingCache2);
                    objRememberedValue = checkDrawingCache2;
                }
                checkDrawingCache = (CheckDrawingCache) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (z2) {
                    composer2.startReplaceGroup(-2128586395);
                    ComposerKt.sourceInformation(composer2, "519@24663L30");
                    stateCheckmarkColor$material3 = checkboxColors.checkmarkColor$material3(z, toggleableState, composer2, (i2 & 126) | (i5 & 896));
                    composer2.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(-2128520210);
                    ComposerKt.sourceInformation(composer2, "521@24730L21");
                    stateCheckmarkColor$material3 = checkboxColors.checkmarkColor$material3(toggleableState, composer2, i6 | ((i2 >> 6) & 112));
                    composer2.endReplaceGroup();
                }
                state = stateCheckmarkColor$material3;
                int i9 = (i2 & 126) | (i5 & 896);
                stateBoxColor$material3 = checkboxColors.boxColor$material3(z, toggleableState, composer2, i9);
                stateBorderColor$material3 = checkboxColors.borderColor$material3(z, toggleableState, composer2, i9);
                if (z2) {
                    fM5193getContainerSizeD9Ej5fM = CheckboxTokens.INSTANCE.m5193getContainerSizeD9Ej5fM();
                } else {
                    fM5193getContainerSizeD9Ej5fM = CheckboxSize;
                }
                Modifier modifierM1258requiredSize3ABfNKs = SizeKt.m1258requiredSize3ABfNKs(SizeKt.wrapContentSize$default(modifier, Alignment.INSTANCE.getCenter(), false, 2, null), fM5193getContainerSizeD9Ej5fM);
                ComposerKt.sourceInformationMarkerStart(composer2, -1869763908, "CC(remember):Checkbox.kt#9igjgp");
                zChanged = composer2.changed(stateBoxColor$material3) | composer2.changed(stateBorderColor$material3) | composer2.changedInstance(stroke2) | composer2.changed(state) | composer2.changed(stateCreateTransitionAnimation) | composer2.changed(stateCreateTransitionAnimation2) | composer2.changedInstance(stroke);
                objRememberedValue2 = composer2.rememberedValue();
                if (!zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    Object obj = new Function1() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return CheckboxKt.CheckboxImpl$lambda$5$0(stateBoxColor$material3, stateBorderColor$material3, stroke2, state, stateCreateTransitionAnimation, stateCreateTransitionAnimation2, stroke, checkDrawingCache, (DrawScope) obj2);
                        }
                    };
                    composer2.updateRememberedValue(obj);
                    objRememberedValue2 = obj;
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                CanvasKt.Canvas(modifierM1258requiredSize3ABfNKs, (Function1) objRememberedValue2, composer2, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            f2 = 1.0f;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceGroup();
            stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf, Float.valueOf(f2), (FiniteAnimationSpec) function3.invoke(transitionUpdateTransition.getSegment(), composerStartRestartGroup, 0), vectorConverter, "FloatAnimation", composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Function3 function5 = new Function3() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return CheckboxKt.CheckboxImpl$lambda$2(finiteAnimationSpecValue, (Transition.Segment) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            };
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1338768149, "CC(animateFloat)P(2)1924@81822L78:Transition.kt#pdpnli");
            TwoWayConverter<Float, AnimationVector1D> vectorConverter3 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
            ToggleableState toggleableState6 = (ToggleableState) transitionUpdateTransition.getCurrentState();
            composerStartRestartGroup.startReplaceGroup(1840054703);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):Checkbox.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1840054703, 0, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:510)");
            }
            i3 = WhenMappings.$EnumSwitchMapping$0[toggleableState6.ordinal()];
            if (i3 != 1) {
                f3 = 0.0f;
            } else {
                f3 = 0.0f;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceGroup();
            Float fValueOf3 = Float.valueOf(f3);
            ToggleableState toggleableState7 = (ToggleableState) transitionUpdateTransition.getTargetState();
            composerStartRestartGroup.startReplaceGroup(1840054703);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):Checkbox.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1840054703, 0, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:510)");
            }
            i4 = WhenMappings.$EnumSwitchMapping$0[toggleableState7.ordinal()];
            if (i4 != 1) {
                if (i4 == 3) {
                    throw new NoWhenBranchMatchedException();
                }
                f4 = 1.0f;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceGroup();
            stateCreateTransitionAnimation2 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf3, Float.valueOf(f4), (FiniteAnimationSpec) function5.invoke(transitionUpdateTransition.getSegment(), composerStartRestartGroup, 0), vectorConverter3, "FloatAnimation", composerStartRestartGroup, 0);
            composer2 = composerStartRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerStart(composer2, -1869782464, "CC(remember):Checkbox.kt#9igjgp");
            objRememberedValue = composer2.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                Object checkDrawingCache3 = new CheckDrawingCache(null, null, null, 7, null);
                composer2.updateRememberedValue(checkDrawingCache3);
                objRememberedValue = checkDrawingCache3;
            }
            checkDrawingCache = (CheckDrawingCache) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (z2) {
                composer2.startReplaceGroup(-2128586395);
                ComposerKt.sourceInformation(composer2, "519@24663L30");
                stateCheckmarkColor$material3 = checkboxColors.checkmarkColor$material3(z, toggleableState, composer2, (i2 & 126) | (i5 & 896));
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-2128520210);
                ComposerKt.sourceInformation(composer2, "521@24730L21");
                stateCheckmarkColor$material3 = checkboxColors.checkmarkColor$material3(toggleableState, composer2, i6 | ((i2 >> 6) & 112));
                composer2.endReplaceGroup();
            }
            state = stateCheckmarkColor$material3;
            int i10 = (i2 & 126) | (i5 & 896);
            stateBoxColor$material3 = checkboxColors.boxColor$material3(z, toggleableState, composer2, i10);
            stateBorderColor$material3 = checkboxColors.borderColor$material3(z, toggleableState, composer2, i10);
            if (z2) {
                fM5193getContainerSizeD9Ej5fM = CheckboxTokens.INSTANCE.m5193getContainerSizeD9Ej5fM();
            } else {
                fM5193getContainerSizeD9Ej5fM = CheckboxSize;
            }
            Modifier modifierM1258requiredSize3ABfNKs2 = SizeKt.m1258requiredSize3ABfNKs(SizeKt.wrapContentSize$default(modifier, Alignment.INSTANCE.getCenter(), false, 2, null), fM5193getContainerSizeD9Ej5fM);
            ComposerKt.sourceInformationMarkerStart(composer2, -1869763908, "CC(remember):Checkbox.kt#9igjgp");
            zChanged = composer2.changed(stateBoxColor$material3) | composer2.changed(stateBorderColor$material3) | composer2.changedInstance(stroke2) | composer2.changed(state) | composer2.changed(stateCreateTransitionAnimation) | composer2.changed(stateCreateTransitionAnimation2) | composer2.changedInstance(stroke);
            objRememberedValue2 = composer2.rememberedValue();
            if (!zChanged) {
                Object obj2 = new Function1() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj3) {
                        return CheckboxKt.CheckboxImpl$lambda$5$0(stateBoxColor$material3, stateBorderColor$material3, stroke2, state, stateCreateTransitionAnimation, stateCreateTransitionAnimation2, stroke, checkDrawingCache, (DrawScope) obj3);
                    }
                };
                composer2.updateRememberedValue(obj2);
                objRememberedValue2 = obj2;
            } else {
                Object obj3 = new Function1() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj4) {
                        return CheckboxKt.CheckboxImpl$lambda$5$0(stateBoxColor$material3, stateBorderColor$material3, stroke2, state, stateCreateTransitionAnimation, stateCreateTransitionAnimation2, stroke, checkDrawingCache, (DrawScope) obj4);
                    }
                };
                composer2.updateRememberedValue(obj3);
                objRememberedValue2 = obj3;
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            CanvasKt.Canvas(modifierM1258requiredSize3ABfNKs2, (Function1) objRememberedValue2, composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj4, Object obj5) {
                    return CheckboxKt.CheckboxImpl$lambda$6(z, toggleableState, modifier, checkboxColors, stroke, stroke2, i, (Composer) obj4, ((Integer) obj5).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FiniteAnimationSpec CheckboxImpl$lambda$0(FiniteAnimationSpec finiteAnimationSpec, Transition.Segment segment, Composer composer, int i) {
        composer.startReplaceGroup(1780794470);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1780794470, i, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:484)");
        }
        if (segment.getInitialState() != ToggleableState.Off && segment.getTargetState() == ToggleableState.Off) {
            finiteAnimationSpec = AnimationSpecKt.snap(100);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return finiteAnimationSpec;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FiniteAnimationSpec CheckboxImpl$lambda$2(FiniteAnimationSpec finiteAnimationSpec, Transition.Segment segment, Composer composer, int i) {
        composer.startReplaceGroup(630790831);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(630790831, i, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:502)");
        }
        if (segment.getInitialState() == ToggleableState.Off) {
            finiteAnimationSpec = AnimationSpecKt.snap$default(0, 1, null);
        } else if (segment.getTargetState() == ToggleableState.Off) {
            finiteAnimationSpec = AnimationSpecKt.snap(100);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return finiteAnimationSpec;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CheckboxImpl$lambda$5$0(State state, State state2, Stroke stroke, State state3, State state4, State state5, Stroke stroke2, CheckDrawingCache checkDrawingCache, DrawScope drawScope) {
        m2935drawBox1wkBAMs(drawScope, ((Color) state.getValue()).m6824unboximpl(), ((Color) state2.getValue()).m6824unboximpl(), drawScope.mo754toPx0680j_4(RadiusSize), stroke);
        m2936drawCheck3IgeMak(drawScope, ((Color) state3.getValue()).m6824unboximpl(), ((Number) state4.getValue()).floatValue(), ((Number) state5.getValue()).floatValue(), stroke2, checkDrawingCache);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: drawBox-1wkBAMs, reason: not valid java name */
    private static final void m2935drawBox1wkBAMs(DrawScope drawScope, long j, long j2, float f, Stroke stroke) {
        float width = stroke.getWidth() / 2.0f;
        float fIntBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo7395getSizeNHjbRc() >> 32));
        if (!Color.m6815equalsimpl0(j, j2)) {
            long jM6561constructorimpl = Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(stroke.getWidth())) << 32) | (((long) Float.floatToRawIntBits(stroke.getWidth())) & 4294967295L));
            float f2 = 2;
            long jM6629constructorimpl = Size.m6629constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat - (stroke.getWidth() * f2))) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat - (stroke.getWidth() * f2))) & 4294967295L));
            float fMax = Math.max(0.0f, f - stroke.getWidth());
            DrawScope.m7391drawRoundRectuAw5IA$default(drawScope, j, jM6561constructorimpl, jM6629constructorimpl, CornerRadius.m6523constructorimpl((((long) Float.floatToRawIntBits(fMax)) << 32) | (((long) Float.floatToRawIntBits(fMax)) & 4294967295L)), Fill.INSTANCE, 0.0f, null, 0, 224, null);
            long jM6561constructorimpl2 = Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(width)) << 32) | (((long) Float.floatToRawIntBits(width)) & 4294967295L));
            float width2 = fIntBitsToFloat - stroke.getWidth();
            float f3 = f - width;
            DrawScope.m7391drawRoundRectuAw5IA$default(drawScope, j2, jM6561constructorimpl2, Size.m6629constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat - stroke.getWidth())) & 4294967295L) | (Float.floatToRawIntBits(width2) << 32)), CornerRadius.m6523constructorimpl((((long) Float.floatToRawIntBits(f3)) << 32) | (((long) Float.floatToRawIntBits(f3)) & 4294967295L)), stroke, 0.0f, null, 0, 224, null);
            return;
        }
        DrawScope.m7391drawRoundRectuAw5IA$default(drawScope, j, 0L, Size.m6629constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat)) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32)), CornerRadius.m6523constructorimpl((((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(f)) & 4294967295L)), Fill.INSTANCE, 0.0f, null, 0, 226, null);
    }

    /* JADX INFO: renamed from: drawCheck-3IgeMak, reason: not valid java name */
    private static final void m2936drawCheck3IgeMak(DrawScope drawScope, long j, float f, float f2, Stroke stroke, CheckDrawingCache checkDrawingCache) {
        boolean z = ComposeMaterial3Flags.isCheckboxStylingFixEnabled;
        float fIntBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo7395getSizeNHjbRc() >> 32));
        float f3 = z ? 0.65f : 0.7f;
        float f4 = z ? 0.25f : 0.2f;
        float f5 = z ? 0.75f : 0.8f;
        float fLerp = MathHelpersKt.lerp(0.4f, 0.5f, f2);
        float fLerp2 = MathHelpersKt.lerp(f3, 0.5f, f2);
        float fLerp3 = MathHelpersKt.lerp(0.5f, 0.5f, f2);
        float fLerp4 = MathHelpersKt.lerp(0.3f, 0.5f, f2);
        checkDrawingCache.getCheckPath().rewind();
        checkDrawingCache.getCheckPath().moveTo(f4 * fIntBitsToFloat, fLerp3 * fIntBitsToFloat);
        checkDrawingCache.getCheckPath().lineTo(fLerp * fIntBitsToFloat, fLerp2 * fIntBitsToFloat);
        checkDrawingCache.getCheckPath().lineTo(f5 * fIntBitsToFloat, fIntBitsToFloat * fLerp4);
        checkDrawingCache.getPathMeasure().setPath(checkDrawingCache.getCheckPath(), false);
        checkDrawingCache.getPathToDraw().rewind();
        checkDrawingCache.getPathMeasure().getSegment(0.0f, checkDrawingCache.getPathMeasure().getLength() * f, checkDrawingCache.getPathToDraw(), true);
        DrawScope.m7385drawPathLG529CI$default(drawScope, checkDrawingCache.getPathToDraw(), j, 0.0f, stroke, null, 0, 52, null);
    }

    static {
        float f = 2;
        CheckboxDefaultPadding = Dp.m9687constructorimpl(f);
        RadiusSize = Dp.m9687constructorimpl(f);
    }
}
