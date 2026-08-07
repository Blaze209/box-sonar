package androidx.compose.material3;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.RadioButtonTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: RadioButton.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aO\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0002\u0010\r\"\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010\"\u0010\u0010\u0011\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010\"\u0010\u0010\u0012\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006\u0013"}, d2 = {"RadioButton", "", "selected", "", ViewProps.ON_CLICK, "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "colors", "Landroidx/compose/material3/RadioButtonColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/RadioButtonColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "RadioButtonPadding", "Landroidx/compose/ui/unit/Dp;", "F", "RadioButtonDotSize", "RadioStrokeWidth", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class RadioButtonKt {
    private static final float RadioButtonDotSize = Dp.m9687constructorimpl(12);
    private static final float RadioButtonPadding;
    private static final float RadioStrokeWidth;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RadioButton$lambda$1(boolean z, Function0 function0, Modifier modifier, boolean z2, RadioButtonColors radioButtonColors, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        RadioButton(z, function0, modifier, z2, radioButtonColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:103:0x01de  */
    /* JADX WARN: Code duplicated, block: B:105:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:108:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:110:0x0203  */
    /* JADX WARN: Code duplicated, block: B:113:0x0211  */
    /* JADX WARN: Code duplicated, block: B:115:? A[RETURN, SYNTHETIC] */
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
    /* JADX WARN: Code duplicated, block: B:63:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:67:0x00be  */
    /* JADX WARN: Code duplicated, block: B:69:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:78:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:79:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:81:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:86:0x0101  */
    /* JADX WARN: Code duplicated, block: B:87:0x0106  */
    /* JADX WARN: Code duplicated, block: B:90:0x0113  */
    /* JADX WARN: Code duplicated, block: B:92:0x011b  */
    /* JADX WARN: Code duplicated, block: B:93:0x0124  */
    /* JADX WARN: Code duplicated, block: B:96:0x0155  */
    /* JADX WARN: Code duplicated, block: B:97:0x018d  */
    /* JADX WARN: Code duplicated, block: B:99:0x0197  */
    public static final void RadioButton(final boolean z, final Function0<Unit> function0, Modifier modifier, boolean z2, RadioButtonColors radioButtonColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z3;
        int i5;
        RadioButtonColors radioButtonColorsColors;
        int i6;
        int i7;
        boolean z4;
        final MutableInteractionSource mutableInteractionSource2;
        final Modifier modifier3;
        final boolean z5;
        final RadioButtonColors radioButtonColors2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        int i8;
        boolean z6;
        RadioButtonColors radioButtonColors3;
        float fM9687constructorimpl;
        final State<Dp> stateM464animateDpAsStateAjpBEmI;
        final State<Color> stateRadioColor$material3;
        Modifier modifier4;
        Modifier.Companion companionM1533selectableO2vRcR0;
        Modifier.Companion companionMinimumInteractiveComponentSize;
        boolean zChanged;
        Object objRememberedValue;
        Composer composerStartRestartGroup = composer.startRestartGroup(408580840);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RadioButton)N(selected,onClick,modifier,enabled,colors,interactionSource)85@4070L7,82@3836L252,87@4117L29,114@5028L416,101@4610L834:RadioButton.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
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
                        radioButtonColorsColors = radioButtonColors;
                        int i10 = composerStartRestartGroup.changed(radioButtonColorsColors) ? 16384 : 8192;
                        i3 |= i10;
                    } else {
                        radioButtonColorsColors = radioButtonColors;
                    }
                    i3 |= i10;
                } else {
                    radioButtonColorsColors = radioButtonColors;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    if ((196608 & i) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
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
                        ComposerKt.sourceInformation(composerStartRestartGroup, "78@3737L8");
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i9 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                radioButtonColorsColors = RadioButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            }
                            if (i6 != 0) {
                                i8 = i3;
                                z6 = z3;
                                radioButtonColors3 = radioButtonColorsColors;
                                mutableInteractionSource = null;
                            } else {
                                i8 = i3;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(408580840, i8, -1, "androidx.compose.material3.RadioButton (RadioButton.kt:80)");
                            }
                            if (z) {
                                fM9687constructorimpl = Dp.m9687constructorimpl(RadioButtonDotSize / 2);
                            } else {
                                fM9687constructorimpl = Dp.m9687constructorimpl(0);
                            }
                            stateM464animateDpAsStateAjpBEmI = AnimateAsStateKt.m464animateDpAsStateAjpBEmI(fM9687constructorimpl, MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), null, null, composerStartRestartGroup, 0, 12);
                            stateRadioColor$material3 = radioButtonColors3.radioColor$material3(z6, z, composerStartRestartGroup, ((i8 >> 6) & 896) | ((i8 >> 9) & 14) | ((i8 << 3) & 112));
                            if (function0 != null) {
                                Modifier modifier5 = companion;
                                z5 = z6;
                                modifier4 = modifier5;
                                companionM1533selectableO2vRcR0 = SelectableKt.m1533selectableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource, RippleKt.m4031rippleH2RKhps$default(false, Dp.m9687constructorimpl(RadioButtonTokens.INSTANCE.m5715getStateLayerSizeD9Ej5fM() / 2), 0L, 4, null), z5, Role.m8825boximpl(Role.INSTANCE.m8837getRadioButtono7Vup1c()), function0);
                            } else {
                                modifier4 = companion;
                                z5 = z6;
                                companionM1533selectableO2vRcR0 = Modifier.INSTANCE;
                            }
                            if (function0 != null) {
                                companionMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE);
                            } else {
                                companionMinimumInteractiveComponentSize = Modifier.INSTANCE;
                            }
                            Modifier modifierM1258requiredSize3ABfNKs = SizeKt.m1258requiredSize3ABfNKs(PaddingKt.m1218padding3ABfNKs(SizeKt.wrapContentSize$default(modifier4.then(companionMinimumInteractiveComponentSize).then(companionM1533selectableO2vRcR0), Alignment.INSTANCE.getCenter(), false, 2, 0), RadioButtonPadding), RadioButtonTokens.INSTANCE.m5714getIconSizeD9Ej5fM());
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1804210920, "CC(remember):RadioButton.kt#9igjgp");
                            zChanged = composerStartRestartGroup.changed(stateRadioColor$material3) | composerStartRestartGroup.changed(stateM464animateDpAsStateAjpBEmI);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: androidx.compose.material3.RadioButtonKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return RadioButtonKt.RadioButton$lambda$0$0(stateRadioColor$material3, stateM464animateDpAsStateAjpBEmI, (DrawScope) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            CanvasKt.Canvas(modifierM1258requiredSize3ABfNKs, (Function1) objRememberedValue, composerStartRestartGroup, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            mutableInteractionSource2 = mutableInteractionSource;
                            radioButtonColors2 = radioButtonColors3;
                            modifier3 = modifier4;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                            i8 = i3;
                            companion = modifier2;
                        }
                        z6 = z3;
                        radioButtonColors3 = radioButtonColorsColors;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(408580840, i8, -1, "androidx.compose.material3.RadioButton (RadioButton.kt:80)");
                        }
                        if (z) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(RadioButtonDotSize / 2);
                        } else {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        }
                        stateM464animateDpAsStateAjpBEmI = AnimateAsStateKt.m464animateDpAsStateAjpBEmI(fM9687constructorimpl, MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), null, null, composerStartRestartGroup, 0, 12);
                        stateRadioColor$material3 = radioButtonColors3.radioColor$material3(z6, z, composerStartRestartGroup, ((i8 >> 6) & 896) | ((i8 >> 9) & 14) | ((i8 << 3) & 112));
                        if (function0 != null) {
                            Modifier modifier6 = companion;
                            z5 = z6;
                            modifier4 = modifier6;
                            companionM1533selectableO2vRcR0 = SelectableKt.m1533selectableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource, RippleKt.m4031rippleH2RKhps$default(false, Dp.m9687constructorimpl(RadioButtonTokens.INSTANCE.m5715getStateLayerSizeD9Ej5fM() / 2), 0L, 4, null), z5, Role.m8825boximpl(Role.INSTANCE.m8837getRadioButtono7Vup1c()), function0);
                        } else {
                            modifier4 = companion;
                            z5 = z6;
                            companionM1533selectableO2vRcR0 = Modifier.INSTANCE;
                        }
                        if (function0 != null) {
                            companionMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE);
                        } else {
                            companionMinimumInteractiveComponentSize = Modifier.INSTANCE;
                        }
                        Modifier modifierM1258requiredSize3ABfNKs2 = SizeKt.m1258requiredSize3ABfNKs(PaddingKt.m1218padding3ABfNKs(SizeKt.wrapContentSize$default(modifier4.then(companionMinimumInteractiveComponentSize).then(companionM1533selectableO2vRcR0), Alignment.INSTANCE.getCenter(), false, 2, 0), RadioButtonPadding), RadioButtonTokens.INSTANCE.m5714getIconSizeD9Ej5fM());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1804210920, "CC(remember):RadioButton.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(stateRadioColor$material3) | composerStartRestartGroup.changed(stateM464animateDpAsStateAjpBEmI);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = new Function1() { // from class: androidx.compose.material3.RadioButtonKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return RadioButtonKt.RadioButton$lambda$0$0(stateRadioColor$material3, stateM464animateDpAsStateAjpBEmI, (DrawScope) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function1() { // from class: androidx.compose.material3.RadioButtonKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return RadioButtonKt.RadioButton$lambda$0$0(stateRadioColor$material3, stateM464animateDpAsStateAjpBEmI, (DrawScope) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        CanvasKt.Canvas(modifierM1258requiredSize3ABfNKs2, (Function1) objRememberedValue, composerStartRestartGroup, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource2 = mutableInteractionSource;
                        radioButtonColors2 = radioButtonColors3;
                        modifier3 = modifier4;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        z5 = z3;
                        radioButtonColors2 = radioButtonColorsColors;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.RadioButtonKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return RadioButtonKt.RadioButton$lambda$1(z, function0, modifier3, z5, radioButtonColors2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                if ((74899 & i3) != 74898) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "78@3737L8");
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            radioButtonColorsColors = RadioButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        }
                        if (i6 != 0) {
                            i8 = i3;
                            z6 = z3;
                            radioButtonColors3 = radioButtonColorsColors;
                            mutableInteractionSource = null;
                        } else {
                            i8 = i3;
                            z6 = z3;
                            radioButtonColors3 = radioButtonColorsColors;
                        }
                    } else {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            radioButtonColorsColors = RadioButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        }
                        if (i6 != 0) {
                            i8 = i3;
                            z6 = z3;
                            radioButtonColors3 = radioButtonColorsColors;
                            mutableInteractionSource = null;
                        } else {
                            i8 = i3;
                            z6 = z3;
                            radioButtonColors3 = radioButtonColorsColors;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(408580840, i8, -1, "androidx.compose.material3.RadioButton (RadioButton.kt:80)");
                    }
                    if (z) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(RadioButtonDotSize / 2);
                    } else {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    }
                    stateM464animateDpAsStateAjpBEmI = AnimateAsStateKt.m464animateDpAsStateAjpBEmI(fM9687constructorimpl, MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), null, null, composerStartRestartGroup, 0, 12);
                    stateRadioColor$material3 = radioButtonColors3.radioColor$material3(z6, z, composerStartRestartGroup, ((i8 >> 6) & 896) | ((i8 >> 9) & 14) | ((i8 << 3) & 112));
                    if (function0 != null) {
                        Modifier modifier7 = companion;
                        z5 = z6;
                        modifier4 = modifier7;
                        companionM1533selectableO2vRcR0 = SelectableKt.m1533selectableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource, RippleKt.m4031rippleH2RKhps$default(false, Dp.m9687constructorimpl(RadioButtonTokens.INSTANCE.m5715getStateLayerSizeD9Ej5fM() / 2), 0L, 4, null), z5, Role.m8825boximpl(Role.INSTANCE.m8837getRadioButtono7Vup1c()), function0);
                    } else {
                        modifier4 = companion;
                        z5 = z6;
                        companionM1533selectableO2vRcR0 = Modifier.INSTANCE;
                    }
                    if (function0 != null) {
                        companionMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE);
                    } else {
                        companionMinimumInteractiveComponentSize = Modifier.INSTANCE;
                    }
                    Modifier modifierM1258requiredSize3ABfNKs3 = SizeKt.m1258requiredSize3ABfNKs(PaddingKt.m1218padding3ABfNKs(SizeKt.wrapContentSize$default(modifier4.then(companionMinimumInteractiveComponentSize).then(companionM1533selectableO2vRcR0), Alignment.INSTANCE.getCenter(), false, 2, 0), RadioButtonPadding), RadioButtonTokens.INSTANCE.m5714getIconSizeD9Ej5fM());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1804210920, "CC(remember):RadioButton.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(stateRadioColor$material3) | composerStartRestartGroup.changed(stateM464animateDpAsStateAjpBEmI);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material3.RadioButtonKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return RadioButtonKt.RadioButton$lambda$0$0(stateRadioColor$material3, stateM464animateDpAsStateAjpBEmI, (DrawScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material3.RadioButtonKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return RadioButtonKt.RadioButton$lambda$0$0(stateRadioColor$material3, stateM464animateDpAsStateAjpBEmI, (DrawScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    CanvasKt.Canvas(modifierM1258requiredSize3ABfNKs3, (Function1) objRememberedValue, composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource2 = mutableInteractionSource;
                    radioButtonColors2 = radioButtonColors3;
                    modifier3 = modifier4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    z5 = z3;
                    radioButtonColors2 = radioButtonColorsColors;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.RadioButtonKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return RadioButtonKt.RadioButton$lambda$1(z, function0, modifier3, z5, radioButtonColors2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            z3 = z2;
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    radioButtonColorsColors = radioButtonColors;
                    if (composerStartRestartGroup.changed(radioButtonColorsColors)) {
                    }
                    i3 |= i10;
                } else {
                    radioButtonColorsColors = radioButtonColors;
                }
                i3 |= i10;
            } else {
                radioButtonColorsColors = radioButtonColors;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
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
                    ComposerKt.sourceInformation(composerStartRestartGroup, "78@3737L8");
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            radioButtonColorsColors = RadioButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        }
                        if (i6 != 0) {
                            i8 = i3;
                            z6 = z3;
                            radioButtonColors3 = radioButtonColorsColors;
                            mutableInteractionSource = null;
                        } else {
                            i8 = i3;
                            z6 = z3;
                            radioButtonColors3 = radioButtonColorsColors;
                        }
                    } else {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            radioButtonColorsColors = RadioButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        }
                        if (i6 != 0) {
                            i8 = i3;
                            z6 = z3;
                            radioButtonColors3 = radioButtonColorsColors;
                            mutableInteractionSource = null;
                        } else {
                            i8 = i3;
                            z6 = z3;
                            radioButtonColors3 = radioButtonColorsColors;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(408580840, i8, -1, "androidx.compose.material3.RadioButton (RadioButton.kt:80)");
                    }
                    if (z) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(RadioButtonDotSize / 2);
                    } else {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    }
                    stateM464animateDpAsStateAjpBEmI = AnimateAsStateKt.m464animateDpAsStateAjpBEmI(fM9687constructorimpl, MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), null, null, composerStartRestartGroup, 0, 12);
                    stateRadioColor$material3 = radioButtonColors3.radioColor$material3(z6, z, composerStartRestartGroup, ((i8 >> 6) & 896) | ((i8 >> 9) & 14) | ((i8 << 3) & 112));
                    if (function0 != null) {
                        Modifier modifier8 = companion;
                        z5 = z6;
                        modifier4 = modifier8;
                        companionM1533selectableO2vRcR0 = SelectableKt.m1533selectableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource, RippleKt.m4031rippleH2RKhps$default(false, Dp.m9687constructorimpl(RadioButtonTokens.INSTANCE.m5715getStateLayerSizeD9Ej5fM() / 2), 0L, 4, null), z5, Role.m8825boximpl(Role.INSTANCE.m8837getRadioButtono7Vup1c()), function0);
                    } else {
                        modifier4 = companion;
                        z5 = z6;
                        companionM1533selectableO2vRcR0 = Modifier.INSTANCE;
                    }
                    if (function0 != null) {
                        companionMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE);
                    } else {
                        companionMinimumInteractiveComponentSize = Modifier.INSTANCE;
                    }
                    Modifier modifierM1258requiredSize3ABfNKs4 = SizeKt.m1258requiredSize3ABfNKs(PaddingKt.m1218padding3ABfNKs(SizeKt.wrapContentSize$default(modifier4.then(companionMinimumInteractiveComponentSize).then(companionM1533selectableO2vRcR0), Alignment.INSTANCE.getCenter(), false, 2, 0), RadioButtonPadding), RadioButtonTokens.INSTANCE.m5714getIconSizeD9Ej5fM());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1804210920, "CC(remember):RadioButton.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(stateRadioColor$material3) | composerStartRestartGroup.changed(stateM464animateDpAsStateAjpBEmI);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material3.RadioButtonKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return RadioButtonKt.RadioButton$lambda$0$0(stateRadioColor$material3, stateM464animateDpAsStateAjpBEmI, (DrawScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material3.RadioButtonKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return RadioButtonKt.RadioButton$lambda$0$0(stateRadioColor$material3, stateM464animateDpAsStateAjpBEmI, (DrawScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    CanvasKt.Canvas(modifierM1258requiredSize3ABfNKs4, (Function1) objRememberedValue, composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource2 = mutableInteractionSource;
                    radioButtonColors2 = radioButtonColors3;
                    modifier3 = modifier4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    z5 = z3;
                    radioButtonColors2 = radioButtonColorsColors;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.RadioButtonKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return RadioButtonKt.RadioButton$lambda$1(z, function0, modifier3, z5, radioButtonColors2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            if ((74899 & i3) != 74898) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "78@3737L8");
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        radioButtonColorsColors = RadioButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    }
                    if (i6 != 0) {
                        i8 = i3;
                        z6 = z3;
                        radioButtonColors3 = radioButtonColorsColors;
                        mutableInteractionSource = null;
                    } else {
                        i8 = i3;
                        z6 = z3;
                        radioButtonColors3 = radioButtonColorsColors;
                    }
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        radioButtonColorsColors = RadioButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    }
                    if (i6 != 0) {
                        i8 = i3;
                        z6 = z3;
                        radioButtonColors3 = radioButtonColorsColors;
                        mutableInteractionSource = null;
                    } else {
                        i8 = i3;
                        z6 = z3;
                        radioButtonColors3 = radioButtonColorsColors;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(408580840, i8, -1, "androidx.compose.material3.RadioButton (RadioButton.kt:80)");
                }
                if (z) {
                    fM9687constructorimpl = Dp.m9687constructorimpl(RadioButtonDotSize / 2);
                } else {
                    fM9687constructorimpl = Dp.m9687constructorimpl(0);
                }
                stateM464animateDpAsStateAjpBEmI = AnimateAsStateKt.m464animateDpAsStateAjpBEmI(fM9687constructorimpl, MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), null, null, composerStartRestartGroup, 0, 12);
                stateRadioColor$material3 = radioButtonColors3.radioColor$material3(z6, z, composerStartRestartGroup, ((i8 >> 6) & 896) | ((i8 >> 9) & 14) | ((i8 << 3) & 112));
                if (function0 != null) {
                    Modifier modifier9 = companion;
                    z5 = z6;
                    modifier4 = modifier9;
                    companionM1533selectableO2vRcR0 = SelectableKt.m1533selectableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource, RippleKt.m4031rippleH2RKhps$default(false, Dp.m9687constructorimpl(RadioButtonTokens.INSTANCE.m5715getStateLayerSizeD9Ej5fM() / 2), 0L, 4, null), z5, Role.m8825boximpl(Role.INSTANCE.m8837getRadioButtono7Vup1c()), function0);
                } else {
                    modifier4 = companion;
                    z5 = z6;
                    companionM1533selectableO2vRcR0 = Modifier.INSTANCE;
                }
                if (function0 != null) {
                    companionMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE);
                } else {
                    companionMinimumInteractiveComponentSize = Modifier.INSTANCE;
                }
                Modifier modifierM1258requiredSize3ABfNKs5 = SizeKt.m1258requiredSize3ABfNKs(PaddingKt.m1218padding3ABfNKs(SizeKt.wrapContentSize$default(modifier4.then(companionMinimumInteractiveComponentSize).then(companionM1533selectableO2vRcR0), Alignment.INSTANCE.getCenter(), false, 2, 0), RadioButtonPadding), RadioButtonTokens.INSTANCE.m5714getIconSizeD9Ej5fM());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1804210920, "CC(remember):RadioButton.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(stateRadioColor$material3) | composerStartRestartGroup.changed(stateM464animateDpAsStateAjpBEmI);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.RadioButtonKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return RadioButtonKt.RadioButton$lambda$0$0(stateRadioColor$material3, stateM464animateDpAsStateAjpBEmI, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.RadioButtonKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return RadioButtonKt.RadioButton$lambda$0$0(stateRadioColor$material3, stateM464animateDpAsStateAjpBEmI, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                CanvasKt.Canvas(modifierM1258requiredSize3ABfNKs5, (Function1) objRememberedValue, composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                mutableInteractionSource2 = mutableInteractionSource;
                radioButtonColors2 = radioButtonColors3;
                modifier3 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                mutableInteractionSource2 = mutableInteractionSource;
                modifier3 = modifier2;
                z5 = z3;
                radioButtonColors2 = radioButtonColorsColors;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.RadioButtonKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return RadioButtonKt.RadioButton$lambda$1(z, function0, modifier3, z5, radioButtonColors2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
                    radioButtonColorsColors = radioButtonColors;
                    if (composerStartRestartGroup.changed(radioButtonColorsColors)) {
                    }
                    i3 |= i10;
                } else {
                    radioButtonColorsColors = radioButtonColors;
                }
                i3 |= i10;
            } else {
                radioButtonColorsColors = radioButtonColors;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
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
                    ComposerKt.sourceInformation(composerStartRestartGroup, "78@3737L8");
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            radioButtonColorsColors = RadioButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        }
                        if (i6 != 0) {
                            i8 = i3;
                            z6 = z3;
                            radioButtonColors3 = radioButtonColorsColors;
                            mutableInteractionSource = null;
                        } else {
                            i8 = i3;
                            z6 = z3;
                            radioButtonColors3 = radioButtonColorsColors;
                        }
                    } else {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            radioButtonColorsColors = RadioButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        }
                        if (i6 != 0) {
                            i8 = i3;
                            z6 = z3;
                            radioButtonColors3 = radioButtonColorsColors;
                            mutableInteractionSource = null;
                        } else {
                            i8 = i3;
                            z6 = z3;
                            radioButtonColors3 = radioButtonColorsColors;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(408580840, i8, -1, "androidx.compose.material3.RadioButton (RadioButton.kt:80)");
                    }
                    if (z) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(RadioButtonDotSize / 2);
                    } else {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    }
                    stateM464animateDpAsStateAjpBEmI = AnimateAsStateKt.m464animateDpAsStateAjpBEmI(fM9687constructorimpl, MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), null, null, composerStartRestartGroup, 0, 12);
                    stateRadioColor$material3 = radioButtonColors3.radioColor$material3(z6, z, composerStartRestartGroup, ((i8 >> 6) & 896) | ((i8 >> 9) & 14) | ((i8 << 3) & 112));
                    if (function0 != null) {
                        Modifier modifier10 = companion;
                        z5 = z6;
                        modifier4 = modifier10;
                        companionM1533selectableO2vRcR0 = SelectableKt.m1533selectableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource, RippleKt.m4031rippleH2RKhps$default(false, Dp.m9687constructorimpl(RadioButtonTokens.INSTANCE.m5715getStateLayerSizeD9Ej5fM() / 2), 0L, 4, null), z5, Role.m8825boximpl(Role.INSTANCE.m8837getRadioButtono7Vup1c()), function0);
                    } else {
                        modifier4 = companion;
                        z5 = z6;
                        companionM1533selectableO2vRcR0 = Modifier.INSTANCE;
                    }
                    if (function0 != null) {
                        companionMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE);
                    } else {
                        companionMinimumInteractiveComponentSize = Modifier.INSTANCE;
                    }
                    Modifier modifierM1258requiredSize3ABfNKs6 = SizeKt.m1258requiredSize3ABfNKs(PaddingKt.m1218padding3ABfNKs(SizeKt.wrapContentSize$default(modifier4.then(companionMinimumInteractiveComponentSize).then(companionM1533selectableO2vRcR0), Alignment.INSTANCE.getCenter(), false, 2, 0), RadioButtonPadding), RadioButtonTokens.INSTANCE.m5714getIconSizeD9Ej5fM());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1804210920, "CC(remember):RadioButton.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(stateRadioColor$material3) | composerStartRestartGroup.changed(stateM464animateDpAsStateAjpBEmI);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material3.RadioButtonKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return RadioButtonKt.RadioButton$lambda$0$0(stateRadioColor$material3, stateM464animateDpAsStateAjpBEmI, (DrawScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material3.RadioButtonKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return RadioButtonKt.RadioButton$lambda$0$0(stateRadioColor$material3, stateM464animateDpAsStateAjpBEmI, (DrawScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    CanvasKt.Canvas(modifierM1258requiredSize3ABfNKs6, (Function1) objRememberedValue, composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource2 = mutableInteractionSource;
                    radioButtonColors2 = radioButtonColors3;
                    modifier3 = modifier4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    z5 = z3;
                    radioButtonColors2 = radioButtonColorsColors;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.RadioButtonKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return RadioButtonKt.RadioButton$lambda$1(z, function0, modifier3, z5, radioButtonColors2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            if ((74899 & i3) != 74898) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "78@3737L8");
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        radioButtonColorsColors = RadioButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    }
                    if (i6 != 0) {
                        i8 = i3;
                        z6 = z3;
                        radioButtonColors3 = radioButtonColorsColors;
                        mutableInteractionSource = null;
                    } else {
                        i8 = i3;
                        z6 = z3;
                        radioButtonColors3 = radioButtonColorsColors;
                    }
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        radioButtonColorsColors = RadioButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    }
                    if (i6 != 0) {
                        i8 = i3;
                        z6 = z3;
                        radioButtonColors3 = radioButtonColorsColors;
                        mutableInteractionSource = null;
                    } else {
                        i8 = i3;
                        z6 = z3;
                        radioButtonColors3 = radioButtonColorsColors;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(408580840, i8, -1, "androidx.compose.material3.RadioButton (RadioButton.kt:80)");
                }
                if (z) {
                    fM9687constructorimpl = Dp.m9687constructorimpl(RadioButtonDotSize / 2);
                } else {
                    fM9687constructorimpl = Dp.m9687constructorimpl(0);
                }
                stateM464animateDpAsStateAjpBEmI = AnimateAsStateKt.m464animateDpAsStateAjpBEmI(fM9687constructorimpl, MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), null, null, composerStartRestartGroup, 0, 12);
                stateRadioColor$material3 = radioButtonColors3.radioColor$material3(z6, z, composerStartRestartGroup, ((i8 >> 6) & 896) | ((i8 >> 9) & 14) | ((i8 << 3) & 112));
                if (function0 != null) {
                    Modifier modifier11 = companion;
                    z5 = z6;
                    modifier4 = modifier11;
                    companionM1533selectableO2vRcR0 = SelectableKt.m1533selectableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource, RippleKt.m4031rippleH2RKhps$default(false, Dp.m9687constructorimpl(RadioButtonTokens.INSTANCE.m5715getStateLayerSizeD9Ej5fM() / 2), 0L, 4, null), z5, Role.m8825boximpl(Role.INSTANCE.m8837getRadioButtono7Vup1c()), function0);
                } else {
                    modifier4 = companion;
                    z5 = z6;
                    companionM1533selectableO2vRcR0 = Modifier.INSTANCE;
                }
                if (function0 != null) {
                    companionMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE);
                } else {
                    companionMinimumInteractiveComponentSize = Modifier.INSTANCE;
                }
                Modifier modifierM1258requiredSize3ABfNKs7 = SizeKt.m1258requiredSize3ABfNKs(PaddingKt.m1218padding3ABfNKs(SizeKt.wrapContentSize$default(modifier4.then(companionMinimumInteractiveComponentSize).then(companionM1533selectableO2vRcR0), Alignment.INSTANCE.getCenter(), false, 2, 0), RadioButtonPadding), RadioButtonTokens.INSTANCE.m5714getIconSizeD9Ej5fM());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1804210920, "CC(remember):RadioButton.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(stateRadioColor$material3) | composerStartRestartGroup.changed(stateM464animateDpAsStateAjpBEmI);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.RadioButtonKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return RadioButtonKt.RadioButton$lambda$0$0(stateRadioColor$material3, stateM464animateDpAsStateAjpBEmI, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.RadioButtonKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return RadioButtonKt.RadioButton$lambda$0$0(stateRadioColor$material3, stateM464animateDpAsStateAjpBEmI, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                CanvasKt.Canvas(modifierM1258requiredSize3ABfNKs7, (Function1) objRememberedValue, composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                mutableInteractionSource2 = mutableInteractionSource;
                radioButtonColors2 = radioButtonColors3;
                modifier3 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                mutableInteractionSource2 = mutableInteractionSource;
                modifier3 = modifier2;
                z5 = z3;
                radioButtonColors2 = radioButtonColorsColors;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.RadioButtonKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return RadioButtonKt.RadioButton$lambda$1(z, function0, modifier3, z5, radioButtonColors2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        z3 = z2;
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                radioButtonColorsColors = radioButtonColors;
                if (composerStartRestartGroup.changed(radioButtonColorsColors)) {
                }
                i3 |= i10;
            } else {
                radioButtonColorsColors = radioButtonColors;
            }
            i3 |= i10;
        } else {
            radioButtonColorsColors = radioButtonColors;
        }
        i6 = i2 & 32;
        if (i6 != 0) {
            if ((196608 & i) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
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
                ComposerKt.sourceInformation(composerStartRestartGroup, "78@3737L8");
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        radioButtonColorsColors = RadioButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    }
                    if (i6 != 0) {
                        i8 = i3;
                        z6 = z3;
                        radioButtonColors3 = radioButtonColorsColors;
                        mutableInteractionSource = null;
                    } else {
                        i8 = i3;
                        z6 = z3;
                        radioButtonColors3 = radioButtonColorsColors;
                    }
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        radioButtonColorsColors = RadioButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    }
                    if (i6 != 0) {
                        i8 = i3;
                        z6 = z3;
                        radioButtonColors3 = radioButtonColorsColors;
                        mutableInteractionSource = null;
                    } else {
                        i8 = i3;
                        z6 = z3;
                        radioButtonColors3 = radioButtonColorsColors;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(408580840, i8, -1, "androidx.compose.material3.RadioButton (RadioButton.kt:80)");
                }
                if (z) {
                    fM9687constructorimpl = Dp.m9687constructorimpl(RadioButtonDotSize / 2);
                } else {
                    fM9687constructorimpl = Dp.m9687constructorimpl(0);
                }
                stateM464animateDpAsStateAjpBEmI = AnimateAsStateKt.m464animateDpAsStateAjpBEmI(fM9687constructorimpl, MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), null, null, composerStartRestartGroup, 0, 12);
                stateRadioColor$material3 = radioButtonColors3.radioColor$material3(z6, z, composerStartRestartGroup, ((i8 >> 6) & 896) | ((i8 >> 9) & 14) | ((i8 << 3) & 112));
                if (function0 != null) {
                    Modifier modifier12 = companion;
                    z5 = z6;
                    modifier4 = modifier12;
                    companionM1533selectableO2vRcR0 = SelectableKt.m1533selectableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource, RippleKt.m4031rippleH2RKhps$default(false, Dp.m9687constructorimpl(RadioButtonTokens.INSTANCE.m5715getStateLayerSizeD9Ej5fM() / 2), 0L, 4, null), z5, Role.m8825boximpl(Role.INSTANCE.m8837getRadioButtono7Vup1c()), function0);
                } else {
                    modifier4 = companion;
                    z5 = z6;
                    companionM1533selectableO2vRcR0 = Modifier.INSTANCE;
                }
                if (function0 != null) {
                    companionMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE);
                } else {
                    companionMinimumInteractiveComponentSize = Modifier.INSTANCE;
                }
                Modifier modifierM1258requiredSize3ABfNKs8 = SizeKt.m1258requiredSize3ABfNKs(PaddingKt.m1218padding3ABfNKs(SizeKt.wrapContentSize$default(modifier4.then(companionMinimumInteractiveComponentSize).then(companionM1533selectableO2vRcR0), Alignment.INSTANCE.getCenter(), false, 2, 0), RadioButtonPadding), RadioButtonTokens.INSTANCE.m5714getIconSizeD9Ej5fM());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1804210920, "CC(remember):RadioButton.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(stateRadioColor$material3) | composerStartRestartGroup.changed(stateM464animateDpAsStateAjpBEmI);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.RadioButtonKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return RadioButtonKt.RadioButton$lambda$0$0(stateRadioColor$material3, stateM464animateDpAsStateAjpBEmI, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.RadioButtonKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return RadioButtonKt.RadioButton$lambda$0$0(stateRadioColor$material3, stateM464animateDpAsStateAjpBEmI, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                CanvasKt.Canvas(modifierM1258requiredSize3ABfNKs8, (Function1) objRememberedValue, composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                mutableInteractionSource2 = mutableInteractionSource;
                radioButtonColors2 = radioButtonColors3;
                modifier3 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                mutableInteractionSource2 = mutableInteractionSource;
                modifier3 = modifier2;
                z5 = z3;
                radioButtonColors2 = radioButtonColorsColors;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.RadioButtonKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return RadioButtonKt.RadioButton$lambda$1(z, function0, modifier3, z5, radioButtonColors2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        if ((74899 & i3) != 74898) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "78@3737L8");
            if ((i & 1) != 0) {
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    z3 = true;
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    radioButtonColorsColors = RadioButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                }
                if (i6 != 0) {
                    i8 = i3;
                    z6 = z3;
                    radioButtonColors3 = radioButtonColorsColors;
                    mutableInteractionSource = null;
                } else {
                    i8 = i3;
                    z6 = z3;
                    radioButtonColors3 = radioButtonColorsColors;
                }
            } else {
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    z3 = true;
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    radioButtonColorsColors = RadioButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                }
                if (i6 != 0) {
                    i8 = i3;
                    z6 = z3;
                    radioButtonColors3 = radioButtonColorsColors;
                    mutableInteractionSource = null;
                } else {
                    i8 = i3;
                    z6 = z3;
                    radioButtonColors3 = radioButtonColorsColors;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(408580840, i8, -1, "androidx.compose.material3.RadioButton (RadioButton.kt:80)");
            }
            if (z) {
                fM9687constructorimpl = Dp.m9687constructorimpl(RadioButtonDotSize / 2);
            } else {
                fM9687constructorimpl = Dp.m9687constructorimpl(0);
            }
            stateM464animateDpAsStateAjpBEmI = AnimateAsStateKt.m464animateDpAsStateAjpBEmI(fM9687constructorimpl, MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), null, null, composerStartRestartGroup, 0, 12);
            stateRadioColor$material3 = radioButtonColors3.radioColor$material3(z6, z, composerStartRestartGroup, ((i8 >> 6) & 896) | ((i8 >> 9) & 14) | ((i8 << 3) & 112));
            if (function0 != null) {
                Modifier modifier13 = companion;
                z5 = z6;
                modifier4 = modifier13;
                companionM1533selectableO2vRcR0 = SelectableKt.m1533selectableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource, RippleKt.m4031rippleH2RKhps$default(false, Dp.m9687constructorimpl(RadioButtonTokens.INSTANCE.m5715getStateLayerSizeD9Ej5fM() / 2), 0L, 4, null), z5, Role.m8825boximpl(Role.INSTANCE.m8837getRadioButtono7Vup1c()), function0);
            } else {
                modifier4 = companion;
                z5 = z6;
                companionM1533selectableO2vRcR0 = Modifier.INSTANCE;
            }
            if (function0 != null) {
                companionMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE);
            } else {
                companionMinimumInteractiveComponentSize = Modifier.INSTANCE;
            }
            Modifier modifierM1258requiredSize3ABfNKs9 = SizeKt.m1258requiredSize3ABfNKs(PaddingKt.m1218padding3ABfNKs(SizeKt.wrapContentSize$default(modifier4.then(companionMinimumInteractiveComponentSize).then(companionM1533selectableO2vRcR0), Alignment.INSTANCE.getCenter(), false, 2, 0), RadioButtonPadding), RadioButtonTokens.INSTANCE.m5714getIconSizeD9Ej5fM());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1804210920, "CC(remember):RadioButton.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(stateRadioColor$material3) | composerStartRestartGroup.changed(stateM464animateDpAsStateAjpBEmI);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.RadioButtonKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return RadioButtonKt.RadioButton$lambda$0$0(stateRadioColor$material3, stateM464animateDpAsStateAjpBEmI, (DrawScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.RadioButtonKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return RadioButtonKt.RadioButton$lambda$0$0(stateRadioColor$material3, stateM464animateDpAsStateAjpBEmI, (DrawScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            CanvasKt.Canvas(modifierM1258requiredSize3ABfNKs9, (Function1) objRememberedValue, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            mutableInteractionSource2 = mutableInteractionSource;
            radioButtonColors2 = radioButtonColors3;
            modifier3 = modifier4;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            mutableInteractionSource2 = mutableInteractionSource;
            modifier3 = modifier2;
            z5 = z3;
            radioButtonColors2 = radioButtonColorsColors;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.RadioButtonKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RadioButtonKt.RadioButton$lambda$1(z, function0, modifier3, z5, radioButtonColors2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RadioButton$lambda$0$0(State state, State state2, DrawScope drawScope) {
        float f = drawScope.mo754toPx0680j_4(RadioStrokeWidth);
        float f2 = 2;
        float f3 = f / f2;
        DrawScope.m7376drawCircleVaOC9Bg$default(drawScope, ((Color) state.getValue()).m6824unboximpl(), drawScope.mo754toPx0680j_4(Dp.m9687constructorimpl(RadioButtonTokens.INSTANCE.m5714getIconSizeD9Ej5fM() / f2)) - f3, 0L, 0.0f, new Stroke(f, 0.0f, 0, 0, null, 30, null), null, 0, 108, null);
        if (Dp.m9686compareTo0680j_4(((Dp) state2.getValue()).m9701unboximpl(), Dp.m9687constructorimpl(0)) > 0) {
            DrawScope.m7376drawCircleVaOC9Bg$default(drawScope, ((Color) state.getValue()).m6824unboximpl(), drawScope.mo754toPx0680j_4(((Dp) state2.getValue()).m9701unboximpl()) - f3, 0L, 0.0f, Fill.INSTANCE, null, 0, 108, null);
        }
        return Unit.INSTANCE;
    }

    static {
        float f = 2;
        RadioButtonPadding = Dp.m9687constructorimpl(f);
        RadioStrokeWidth = Dp.m9687constructorimpl(f);
    }
}
