package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableKt;
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
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: RadioButton.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001aO\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\r\"\u000e\u0010\u000e\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012\"\u0010\u0010\u0013\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012\"\u0010\u0010\u0014\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012\"\u0010\u0010\u0015\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012\"\u0010\u0010\u0016\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012\"\u0010\u0010\u0017\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012¨\u0006\u0018"}, d2 = {"RadioButton", "", "selected", "", ViewProps.ON_CLICK, "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "colors", "Landroidx/compose/material/RadioButtonColors;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/RadioButtonColors;Landroidx/compose/runtime/Composer;II)V", "RadioAnimationDuration", "", "RadioButtonRippleRadius", "Landroidx/compose/ui/unit/Dp;", "F", "RadioButtonPadding", "RadioButtonSize", "RadioRadius", "RadioButtonDotSize", "RadioStrokeWidth", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class RadioButtonKt {
    private static final int RadioAnimationDuration = 100;
    private static final float RadioButtonDotSize;
    private static final float RadioButtonPadding;
    private static final float RadioButtonRippleRadius = Dp.m9687constructorimpl(24);
    private static final float RadioButtonSize;
    private static final float RadioRadius;
    private static final float RadioStrokeWidth;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RadioButton$lambda$1(boolean z, Function0 function0, Modifier modifier, boolean z2, MutableInteractionSource mutableInteractionSource, RadioButtonColors radioButtonColors, int i, int i2, Composer composer, int i3) {
        RadioButton(z, function0, modifier, z2, mutableInteractionSource, radioButtonColors, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:102:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:105:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:107:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:110:0x020a  */
    /* JADX WARN: Code duplicated, block: B:112:0x0210  */
    /* JADX WARN: Code duplicated, block: B:115:0x021d  */
    /* JADX WARN: Code duplicated, block: B:117:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x0054  */
    /* JADX WARN: Code duplicated, block: B:31:0x0057  */
    /* JADX WARN: Code duplicated, block: B:33:0x005b  */
    /* JADX WARN: Code duplicated, block: B:35:0x0063  */
    /* JADX WARN: Code duplicated, block: B:36:0x0066  */
    /* JADX WARN: Code duplicated, block: B:41:0x0070  */
    /* JADX WARN: Code duplicated, block: B:42:0x0073  */
    /* JADX WARN: Code duplicated, block: B:44:0x0077  */
    /* JADX WARN: Code duplicated, block: B:46:0x007f  */
    /* JADX WARN: Code duplicated, block: B:47:0x0082  */
    /* JADX WARN: Code duplicated, block: B:52:0x008d  */
    /* JADX WARN: Code duplicated, block: B:54:0x0091  */
    /* JADX WARN: Code duplicated, block: B:56:0x0099  */
    /* JADX WARN: Code duplicated, block: B:57:0x009c  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:67:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:69:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:76:0x00e3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:77:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:78:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:80:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:81:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:83:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:87:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:88:0x0116  */
    /* JADX WARN: Code duplicated, block: B:92:0x0124  */
    /* JADX WARN: Code duplicated, block: B:94:0x012c  */
    /* JADX WARN: Code duplicated, block: B:95:0x0136  */
    /* JADX WARN: Code duplicated, block: B:98:0x0170  */
    /* JADX WARN: Code duplicated, block: B:99:0x019e  */
    public static final void RadioButton(final boolean z, final Function0<Unit> function0, Modifier modifier, boolean z2, MutableInteractionSource mutableInteractionSource, RadioButtonColors radioButtonColors, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z3;
        int i5;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        int i7;
        RadioButtonColors radioButtonColorsM2518colorsRGew2ao;
        boolean z4;
        final Modifier modifier3;
        final boolean z5;
        final MutableInteractionSource mutableInteractionSource3;
        final RadioButtonColors radioButtonColors2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        boolean z6;
        MutableInteractionSource mutableInteractionSource4;
        Composer composer2;
        int i8;
        MutableInteractionSource mutableInteractionSource5;
        char c;
        float fM9687constructorimpl;
        final State<Dp> stateM464animateDpAsStateAjpBEmI;
        final State<Color> stateRadioColor;
        Modifier.Companion companionM1533selectableO2vRcR0;
        Modifier.Companion companionMinimumInteractiveComponentSize;
        boolean zChanged;
        Object objRememberedValue;
        Composer composerStartRestartGroup = composer.startRestartGroup(1314435585);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RadioButton)N(selected,onClick,modifier,enabled,interactionSource,colors)82@3703L177,86@3909L29,113@4796L386,100@4389L793:RadioButton.kt#jmzs0o");
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
                i6 = i2 & 16;
                if (i6 != 0) {
                    if ((i & 24576) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                            i7 = 16384;
                        } else {
                            i7 = 8192;
                        }
                        i3 |= i7;
                    }
                    if ((196608 & i) == 0) {
                        if ((i2 & 32) == 0) {
                            radioButtonColorsM2518colorsRGew2ao = radioButtonColors;
                            int i10 = composerStartRestartGroup.changed(radioButtonColorsM2518colorsRGew2ao) ? 131072 : 65536;
                            i3 |= i10;
                        } else {
                            radioButtonColorsM2518colorsRGew2ao = radioButtonColors;
                        }
                        i3 |= i10;
                    } else {
                        radioButtonColorsM2518colorsRGew2ao = radioButtonColors;
                    }
                    if ((74899 & i3) != 74898) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "79@3661L8");
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i9 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i4 != 0) {
                                z6 = true;
                            } else {
                                z6 = z3;
                            }
                            if (i6 != 0) {
                                mutableInteractionSource4 = null;
                            } else {
                                mutableInteractionSource4 = mutableInteractionSource2;
                            }
                            if ((i2 & 32) != 0) {
                                composer2 = composerStartRestartGroup;
                                i8 = i3 & (-458753);
                                radioButtonColorsM2518colorsRGew2ao = RadioButtonDefaults.INSTANCE.m2518colorsRGew2ao(0L, 0L, 0L, composer2, 3072, 7);
                            } else {
                                composer2 = composerStartRestartGroup;
                                i8 = i3;
                                radioButtonColorsM2518colorsRGew2ao = radioButtonColorsM2518colorsRGew2ao;
                            }
                            mutableInteractionSource5 = mutableInteractionSource4;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                            i8 = i3;
                            companion = modifier2;
                            z6 = z3;
                            mutableInteractionSource5 = mutableInteractionSource2;
                            composer2 = composerStartRestartGroup;
                            radioButtonColorsM2518colorsRGew2ao = radioButtonColorsM2518colorsRGew2ao;
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1314435585, i8, -1, "androidx.compose.material.RadioButton (RadioButton.kt:80)");
                        }
                        if (z) {
                            c = 2;
                            fM9687constructorimpl = Dp.m9687constructorimpl(RadioButtonDotSize / 2);
                        } else {
                            c = 2;
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        }
                        char c2 = c;
                        int i11 = i8;
                        composerStartRestartGroup = composer2;
                        stateM464animateDpAsStateAjpBEmI = AnimateAsStateKt.m464animateDpAsStateAjpBEmI(fM9687constructorimpl, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, composerStartRestartGroup, 48, 12);
                        int i12 = i11 >> 9;
                        stateRadioColor = radioButtonColorsM2518colorsRGew2ao.radioColor(z6, z, composerStartRestartGroup, ((i11 << 3) & 112) | (i12 & 14) | (i12 & 896));
                        if (function0 != null) {
                            z5 = z6;
                            companionM1533selectableO2vRcR0 = SelectableKt.m1533selectableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource5, RippleKt.m2523rippleH2RKhps$default(false, RadioButtonRippleRadius, 0L, 4, null), z5, Role.m8825boximpl(Role.INSTANCE.m8837getRadioButtono7Vup1c()), function0);
                        } else {
                            z5 = z6;
                            companionM1533selectableO2vRcR0 = Modifier.INSTANCE;
                        }
                        if (function0 != null) {
                            companionMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE);
                        } else {
                            companionMinimumInteractiveComponentSize = Modifier.INSTANCE;
                        }
                        Modifier modifierM1258requiredSize3ABfNKs = SizeKt.m1258requiredSize3ABfNKs(PaddingKt.m1218padding3ABfNKs(SizeKt.wrapContentSize$default(companion.then(companionMinimumInteractiveComponentSize).then(companionM1533selectableO2vRcR0), Alignment.INSTANCE.getCenter(), r4, c2, null), RadioButtonPadding), RadioButtonSize);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 452256579, "CC(remember):RadioButton.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(stateRadioColor) | composerStartRestartGroup.changed(stateM464animateDpAsStateAjpBEmI);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: androidx.compose.material.RadioButtonKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return RadioButtonKt.RadioButton$lambda$0$0(stateRadioColor, stateM464animateDpAsStateAjpBEmI, (DrawScope) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        CanvasKt.Canvas(modifierM1258requiredSize3ABfNKs, (Function1) objRememberedValue, composerStartRestartGroup, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource3 = mutableInteractionSource5;
                        modifier3 = companion;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        z5 = z3;
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    radioButtonColors2 = radioButtonColorsM2518colorsRGew2ao;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.RadioButtonKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return RadioButtonKt.RadioButton$lambda$1(z, function0, modifier3, z5, mutableInteractionSource3, radioButtonColors2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 24576;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        radioButtonColorsM2518colorsRGew2ao = radioButtonColors;
                        if (composerStartRestartGroup.changed(radioButtonColorsM2518colorsRGew2ao)) {
                        }
                        i3 |= i10;
                    } else {
                        radioButtonColorsM2518colorsRGew2ao = radioButtonColors;
                    }
                    i3 |= i10;
                } else {
                    radioButtonColorsM2518colorsRGew2ao = radioButtonColors;
                }
                if ((74899 & i3) != 74898) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "79@3661L8");
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        if ((i2 & 32) != 0) {
                            composer2 = composerStartRestartGroup;
                            i8 = i3 & (-458753);
                            radioButtonColorsM2518colorsRGew2ao = RadioButtonDefaults.INSTANCE.m2518colorsRGew2ao(0L, 0L, 0L, composer2, 3072, 7);
                        } else {
                            composer2 = composerStartRestartGroup;
                            i8 = i3;
                            radioButtonColorsM2518colorsRGew2ao = radioButtonColorsM2518colorsRGew2ao;
                        }
                        mutableInteractionSource5 = mutableInteractionSource4;
                    } else {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        if ((i2 & 32) != 0) {
                            composer2 = composerStartRestartGroup;
                            i8 = i3 & (-458753);
                            radioButtonColorsM2518colorsRGew2ao = RadioButtonDefaults.INSTANCE.m2518colorsRGew2ao(0L, 0L, 0L, composer2, 3072, 7);
                        } else {
                            composer2 = composerStartRestartGroup;
                            i8 = i3;
                            radioButtonColorsM2518colorsRGew2ao = radioButtonColorsM2518colorsRGew2ao;
                        }
                        mutableInteractionSource5 = mutableInteractionSource4;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1314435585, i8, -1, "androidx.compose.material.RadioButton (RadioButton.kt:80)");
                    }
                    if (z) {
                        c = 2;
                        fM9687constructorimpl = Dp.m9687constructorimpl(RadioButtonDotSize / 2);
                    } else {
                        c = 2;
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    }
                    char c3 = c;
                    int i13 = i8;
                    composerStartRestartGroup = composer2;
                    stateM464animateDpAsStateAjpBEmI = AnimateAsStateKt.m464animateDpAsStateAjpBEmI(fM9687constructorimpl, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, composerStartRestartGroup, 48, 12);
                    int i14 = i13 >> 9;
                    stateRadioColor = radioButtonColorsM2518colorsRGew2ao.radioColor(z6, z, composerStartRestartGroup, ((i13 << 3) & 112) | (i14 & 14) | (i14 & 896));
                    if (function0 != null) {
                        z5 = z6;
                        companionM1533selectableO2vRcR0 = SelectableKt.m1533selectableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource5, RippleKt.m2523rippleH2RKhps$default(false, RadioButtonRippleRadius, 0L, 4, null), z5, Role.m8825boximpl(Role.INSTANCE.m8837getRadioButtono7Vup1c()), function0);
                    } else {
                        z5 = z6;
                        companionM1533selectableO2vRcR0 = Modifier.INSTANCE;
                    }
                    if (function0 != null) {
                        companionMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE);
                    } else {
                        companionMinimumInteractiveComponentSize = Modifier.INSTANCE;
                    }
                    Modifier modifierM1258requiredSize3ABfNKs2 = SizeKt.m1258requiredSize3ABfNKs(PaddingKt.m1218padding3ABfNKs(SizeKt.wrapContentSize$default(companion.then(companionMinimumInteractiveComponentSize).then(companionM1533selectableO2vRcR0), Alignment.INSTANCE.getCenter(), r4, c3, null), RadioButtonPadding), RadioButtonSize);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 452256579, "CC(remember):RadioButton.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(stateRadioColor) | composerStartRestartGroup.changed(stateM464animateDpAsStateAjpBEmI);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material.RadioButtonKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return RadioButtonKt.RadioButton$lambda$0$0(stateRadioColor, stateM464animateDpAsStateAjpBEmI, (DrawScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material.RadioButtonKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return RadioButtonKt.RadioButton$lambda$0$0(stateRadioColor, stateM464animateDpAsStateAjpBEmI, (DrawScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    CanvasKt.Canvas(modifierM1258requiredSize3ABfNKs2, (Function1) objRememberedValue, composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource3 = mutableInteractionSource5;
                    modifier3 = companion;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    z5 = z3;
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                radioButtonColors2 = radioButtonColorsM2518colorsRGew2ao;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.RadioButtonKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return RadioButtonKt.RadioButton$lambda$1(z, function0, modifier3, z5, mutableInteractionSource3, radioButtonColors2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            z3 = z2;
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        radioButtonColorsM2518colorsRGew2ao = radioButtonColors;
                        if (composerStartRestartGroup.changed(radioButtonColorsM2518colorsRGew2ao)) {
                        }
                        i3 |= i10;
                    } else {
                        radioButtonColorsM2518colorsRGew2ao = radioButtonColors;
                    }
                    i3 |= i10;
                } else {
                    radioButtonColorsM2518colorsRGew2ao = radioButtonColors;
                }
                if ((74899 & i3) != 74898) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "79@3661L8");
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        if ((i2 & 32) != 0) {
                            composer2 = composerStartRestartGroup;
                            i8 = i3 & (-458753);
                            radioButtonColorsM2518colorsRGew2ao = RadioButtonDefaults.INSTANCE.m2518colorsRGew2ao(0L, 0L, 0L, composer2, 3072, 7);
                        } else {
                            composer2 = composerStartRestartGroup;
                            i8 = i3;
                            radioButtonColorsM2518colorsRGew2ao = radioButtonColorsM2518colorsRGew2ao;
                        }
                        mutableInteractionSource5 = mutableInteractionSource4;
                    } else {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        if ((i2 & 32) != 0) {
                            composer2 = composerStartRestartGroup;
                            i8 = i3 & (-458753);
                            radioButtonColorsM2518colorsRGew2ao = RadioButtonDefaults.INSTANCE.m2518colorsRGew2ao(0L, 0L, 0L, composer2, 3072, 7);
                        } else {
                            composer2 = composerStartRestartGroup;
                            i8 = i3;
                            radioButtonColorsM2518colorsRGew2ao = radioButtonColorsM2518colorsRGew2ao;
                        }
                        mutableInteractionSource5 = mutableInteractionSource4;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1314435585, i8, -1, "androidx.compose.material.RadioButton (RadioButton.kt:80)");
                    }
                    if (z) {
                        c = 2;
                        fM9687constructorimpl = Dp.m9687constructorimpl(RadioButtonDotSize / 2);
                    } else {
                        c = 2;
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    }
                    char c4 = c;
                    int i15 = i8;
                    composerStartRestartGroup = composer2;
                    stateM464animateDpAsStateAjpBEmI = AnimateAsStateKt.m464animateDpAsStateAjpBEmI(fM9687constructorimpl, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, composerStartRestartGroup, 48, 12);
                    int i16 = i15 >> 9;
                    stateRadioColor = radioButtonColorsM2518colorsRGew2ao.radioColor(z6, z, composerStartRestartGroup, ((i15 << 3) & 112) | (i16 & 14) | (i16 & 896));
                    if (function0 != null) {
                        z5 = z6;
                        companionM1533selectableO2vRcR0 = SelectableKt.m1533selectableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource5, RippleKt.m2523rippleH2RKhps$default(false, RadioButtonRippleRadius, 0L, 4, null), z5, Role.m8825boximpl(Role.INSTANCE.m8837getRadioButtono7Vup1c()), function0);
                    } else {
                        z5 = z6;
                        companionM1533selectableO2vRcR0 = Modifier.INSTANCE;
                    }
                    if (function0 != null) {
                        companionMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE);
                    } else {
                        companionMinimumInteractiveComponentSize = Modifier.INSTANCE;
                    }
                    Modifier modifierM1258requiredSize3ABfNKs3 = SizeKt.m1258requiredSize3ABfNKs(PaddingKt.m1218padding3ABfNKs(SizeKt.wrapContentSize$default(companion.then(companionMinimumInteractiveComponentSize).then(companionM1533selectableO2vRcR0), Alignment.INSTANCE.getCenter(), r4, c4, null), RadioButtonPadding), RadioButtonSize);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 452256579, "CC(remember):RadioButton.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(stateRadioColor) | composerStartRestartGroup.changed(stateM464animateDpAsStateAjpBEmI);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material.RadioButtonKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return RadioButtonKt.RadioButton$lambda$0$0(stateRadioColor, stateM464animateDpAsStateAjpBEmI, (DrawScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material.RadioButtonKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return RadioButtonKt.RadioButton$lambda$0$0(stateRadioColor, stateM464animateDpAsStateAjpBEmI, (DrawScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    CanvasKt.Canvas(modifierM1258requiredSize3ABfNKs3, (Function1) objRememberedValue, composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource3 = mutableInteractionSource5;
                    modifier3 = companion;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    z5 = z3;
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                radioButtonColors2 = radioButtonColorsM2518colorsRGew2ao;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.RadioButtonKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return RadioButtonKt.RadioButton$lambda$1(z, function0, modifier3, z5, mutableInteractionSource3, radioButtonColors2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    radioButtonColorsM2518colorsRGew2ao = radioButtonColors;
                    if (composerStartRestartGroup.changed(radioButtonColorsM2518colorsRGew2ao)) {
                    }
                    i3 |= i10;
                } else {
                    radioButtonColorsM2518colorsRGew2ao = radioButtonColors;
                }
                i3 |= i10;
            } else {
                radioButtonColorsM2518colorsRGew2ao = radioButtonColors;
            }
            if ((74899 & i3) != 74898) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "79@3661L8");
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z6 = true;
                    } else {
                        z6 = z3;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    if ((i2 & 32) != 0) {
                        composer2 = composerStartRestartGroup;
                        i8 = i3 & (-458753);
                        radioButtonColorsM2518colorsRGew2ao = RadioButtonDefaults.INSTANCE.m2518colorsRGew2ao(0L, 0L, 0L, composer2, 3072, 7);
                    } else {
                        composer2 = composerStartRestartGroup;
                        i8 = i3;
                        radioButtonColorsM2518colorsRGew2ao = radioButtonColorsM2518colorsRGew2ao;
                    }
                    mutableInteractionSource5 = mutableInteractionSource4;
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z6 = true;
                    } else {
                        z6 = z3;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    if ((i2 & 32) != 0) {
                        composer2 = composerStartRestartGroup;
                        i8 = i3 & (-458753);
                        radioButtonColorsM2518colorsRGew2ao = RadioButtonDefaults.INSTANCE.m2518colorsRGew2ao(0L, 0L, 0L, composer2, 3072, 7);
                    } else {
                        composer2 = composerStartRestartGroup;
                        i8 = i3;
                        radioButtonColorsM2518colorsRGew2ao = radioButtonColorsM2518colorsRGew2ao;
                    }
                    mutableInteractionSource5 = mutableInteractionSource4;
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1314435585, i8, -1, "androidx.compose.material.RadioButton (RadioButton.kt:80)");
                }
                if (z) {
                    c = 2;
                    fM9687constructorimpl = Dp.m9687constructorimpl(RadioButtonDotSize / 2);
                } else {
                    c = 2;
                    fM9687constructorimpl = Dp.m9687constructorimpl(0);
                }
                char c5 = c;
                int i17 = i8;
                composerStartRestartGroup = composer2;
                stateM464animateDpAsStateAjpBEmI = AnimateAsStateKt.m464animateDpAsStateAjpBEmI(fM9687constructorimpl, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, composerStartRestartGroup, 48, 12);
                int i18 = i17 >> 9;
                stateRadioColor = radioButtonColorsM2518colorsRGew2ao.radioColor(z6, z, composerStartRestartGroup, ((i17 << 3) & 112) | (i18 & 14) | (i18 & 896));
                if (function0 != null) {
                    z5 = z6;
                    companionM1533selectableO2vRcR0 = SelectableKt.m1533selectableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource5, RippleKt.m2523rippleH2RKhps$default(false, RadioButtonRippleRadius, 0L, 4, null), z5, Role.m8825boximpl(Role.INSTANCE.m8837getRadioButtono7Vup1c()), function0);
                } else {
                    z5 = z6;
                    companionM1533selectableO2vRcR0 = Modifier.INSTANCE;
                }
                if (function0 != null) {
                    companionMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE);
                } else {
                    companionMinimumInteractiveComponentSize = Modifier.INSTANCE;
                }
                Modifier modifierM1258requiredSize3ABfNKs4 = SizeKt.m1258requiredSize3ABfNKs(PaddingKt.m1218padding3ABfNKs(SizeKt.wrapContentSize$default(companion.then(companionMinimumInteractiveComponentSize).then(companionM1533selectableO2vRcR0), Alignment.INSTANCE.getCenter(), r4, c5, null), RadioButtonPadding), RadioButtonSize);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 452256579, "CC(remember):RadioButton.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(stateRadioColor) | composerStartRestartGroup.changed(stateM464animateDpAsStateAjpBEmI);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material.RadioButtonKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return RadioButtonKt.RadioButton$lambda$0$0(stateRadioColor, stateM464animateDpAsStateAjpBEmI, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material.RadioButtonKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return RadioButtonKt.RadioButton$lambda$0$0(stateRadioColor, stateM464animateDpAsStateAjpBEmI, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                CanvasKt.Canvas(modifierM1258requiredSize3ABfNKs4, (Function1) objRememberedValue, composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                mutableInteractionSource3 = mutableInteractionSource5;
                modifier3 = companion;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                z5 = z3;
                mutableInteractionSource3 = mutableInteractionSource2;
            }
            radioButtonColors2 = radioButtonColorsM2518colorsRGew2ao;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.RadioButtonKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return RadioButtonKt.RadioButton$lambda$1(z, function0, modifier3, z5, mutableInteractionSource3, radioButtonColors2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        radioButtonColorsM2518colorsRGew2ao = radioButtonColors;
                        if (composerStartRestartGroup.changed(radioButtonColorsM2518colorsRGew2ao)) {
                        }
                        i3 |= i10;
                    } else {
                        radioButtonColorsM2518colorsRGew2ao = radioButtonColors;
                    }
                    i3 |= i10;
                } else {
                    radioButtonColorsM2518colorsRGew2ao = radioButtonColors;
                }
                if ((74899 & i3) != 74898) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "79@3661L8");
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        if ((i2 & 32) != 0) {
                            composer2 = composerStartRestartGroup;
                            i8 = i3 & (-458753);
                            radioButtonColorsM2518colorsRGew2ao = RadioButtonDefaults.INSTANCE.m2518colorsRGew2ao(0L, 0L, 0L, composer2, 3072, 7);
                        } else {
                            composer2 = composerStartRestartGroup;
                            i8 = i3;
                            radioButtonColorsM2518colorsRGew2ao = radioButtonColorsM2518colorsRGew2ao;
                        }
                        mutableInteractionSource5 = mutableInteractionSource4;
                    } else {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        if ((i2 & 32) != 0) {
                            composer2 = composerStartRestartGroup;
                            i8 = i3 & (-458753);
                            radioButtonColorsM2518colorsRGew2ao = RadioButtonDefaults.INSTANCE.m2518colorsRGew2ao(0L, 0L, 0L, composer2, 3072, 7);
                        } else {
                            composer2 = composerStartRestartGroup;
                            i8 = i3;
                            radioButtonColorsM2518colorsRGew2ao = radioButtonColorsM2518colorsRGew2ao;
                        }
                        mutableInteractionSource5 = mutableInteractionSource4;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1314435585, i8, -1, "androidx.compose.material.RadioButton (RadioButton.kt:80)");
                    }
                    if (z) {
                        c = 2;
                        fM9687constructorimpl = Dp.m9687constructorimpl(RadioButtonDotSize / 2);
                    } else {
                        c = 2;
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    }
                    char c6 = c;
                    int i19 = i8;
                    composerStartRestartGroup = composer2;
                    stateM464animateDpAsStateAjpBEmI = AnimateAsStateKt.m464animateDpAsStateAjpBEmI(fM9687constructorimpl, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, composerStartRestartGroup, 48, 12);
                    int i110 = i19 >> 9;
                    stateRadioColor = radioButtonColorsM2518colorsRGew2ao.radioColor(z6, z, composerStartRestartGroup, ((i19 << 3) & 112) | (i110 & 14) | (i110 & 896));
                    if (function0 != null) {
                        z5 = z6;
                        companionM1533selectableO2vRcR0 = SelectableKt.m1533selectableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource5, RippleKt.m2523rippleH2RKhps$default(false, RadioButtonRippleRadius, 0L, 4, null), z5, Role.m8825boximpl(Role.INSTANCE.m8837getRadioButtono7Vup1c()), function0);
                    } else {
                        z5 = z6;
                        companionM1533selectableO2vRcR0 = Modifier.INSTANCE;
                    }
                    if (function0 != null) {
                        companionMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE);
                    } else {
                        companionMinimumInteractiveComponentSize = Modifier.INSTANCE;
                    }
                    Modifier modifierM1258requiredSize3ABfNKs5 = SizeKt.m1258requiredSize3ABfNKs(PaddingKt.m1218padding3ABfNKs(SizeKt.wrapContentSize$default(companion.then(companionMinimumInteractiveComponentSize).then(companionM1533selectableO2vRcR0), Alignment.INSTANCE.getCenter(), r4, c6, null), RadioButtonPadding), RadioButtonSize);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 452256579, "CC(remember):RadioButton.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(stateRadioColor) | composerStartRestartGroup.changed(stateM464animateDpAsStateAjpBEmI);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material.RadioButtonKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return RadioButtonKt.RadioButton$lambda$0$0(stateRadioColor, stateM464animateDpAsStateAjpBEmI, (DrawScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material.RadioButtonKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return RadioButtonKt.RadioButton$lambda$0$0(stateRadioColor, stateM464animateDpAsStateAjpBEmI, (DrawScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    CanvasKt.Canvas(modifierM1258requiredSize3ABfNKs5, (Function1) objRememberedValue, composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource3 = mutableInteractionSource5;
                    modifier3 = companion;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    z5 = z3;
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                radioButtonColors2 = radioButtonColorsM2518colorsRGew2ao;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.RadioButtonKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return RadioButtonKt.RadioButton$lambda$1(z, function0, modifier3, z5, mutableInteractionSource3, radioButtonColors2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    radioButtonColorsM2518colorsRGew2ao = radioButtonColors;
                    if (composerStartRestartGroup.changed(radioButtonColorsM2518colorsRGew2ao)) {
                    }
                    i3 |= i10;
                } else {
                    radioButtonColorsM2518colorsRGew2ao = radioButtonColors;
                }
                i3 |= i10;
            } else {
                radioButtonColorsM2518colorsRGew2ao = radioButtonColors;
            }
            if ((74899 & i3) != 74898) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "79@3661L8");
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z6 = true;
                    } else {
                        z6 = z3;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    if ((i2 & 32) != 0) {
                        composer2 = composerStartRestartGroup;
                        i8 = i3 & (-458753);
                        radioButtonColorsM2518colorsRGew2ao = RadioButtonDefaults.INSTANCE.m2518colorsRGew2ao(0L, 0L, 0L, composer2, 3072, 7);
                    } else {
                        composer2 = composerStartRestartGroup;
                        i8 = i3;
                        radioButtonColorsM2518colorsRGew2ao = radioButtonColorsM2518colorsRGew2ao;
                    }
                    mutableInteractionSource5 = mutableInteractionSource4;
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z6 = true;
                    } else {
                        z6 = z3;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    if ((i2 & 32) != 0) {
                        composer2 = composerStartRestartGroup;
                        i8 = i3 & (-458753);
                        radioButtonColorsM2518colorsRGew2ao = RadioButtonDefaults.INSTANCE.m2518colorsRGew2ao(0L, 0L, 0L, composer2, 3072, 7);
                    } else {
                        composer2 = composerStartRestartGroup;
                        i8 = i3;
                        radioButtonColorsM2518colorsRGew2ao = radioButtonColorsM2518colorsRGew2ao;
                    }
                    mutableInteractionSource5 = mutableInteractionSource4;
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1314435585, i8, -1, "androidx.compose.material.RadioButton (RadioButton.kt:80)");
                }
                if (z) {
                    c = 2;
                    fM9687constructorimpl = Dp.m9687constructorimpl(RadioButtonDotSize / 2);
                } else {
                    c = 2;
                    fM9687constructorimpl = Dp.m9687constructorimpl(0);
                }
                char c7 = c;
                int i111 = i8;
                composerStartRestartGroup = composer2;
                stateM464animateDpAsStateAjpBEmI = AnimateAsStateKt.m464animateDpAsStateAjpBEmI(fM9687constructorimpl, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, composerStartRestartGroup, 48, 12);
                int i112 = i111 >> 9;
                stateRadioColor = radioButtonColorsM2518colorsRGew2ao.radioColor(z6, z, composerStartRestartGroup, ((i111 << 3) & 112) | (i112 & 14) | (i112 & 896));
                if (function0 != null) {
                    z5 = z6;
                    companionM1533selectableO2vRcR0 = SelectableKt.m1533selectableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource5, RippleKt.m2523rippleH2RKhps$default(false, RadioButtonRippleRadius, 0L, 4, null), z5, Role.m8825boximpl(Role.INSTANCE.m8837getRadioButtono7Vup1c()), function0);
                } else {
                    z5 = z6;
                    companionM1533selectableO2vRcR0 = Modifier.INSTANCE;
                }
                if (function0 != null) {
                    companionMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE);
                } else {
                    companionMinimumInteractiveComponentSize = Modifier.INSTANCE;
                }
                Modifier modifierM1258requiredSize3ABfNKs6 = SizeKt.m1258requiredSize3ABfNKs(PaddingKt.m1218padding3ABfNKs(SizeKt.wrapContentSize$default(companion.then(companionMinimumInteractiveComponentSize).then(companionM1533selectableO2vRcR0), Alignment.INSTANCE.getCenter(), r4, c7, null), RadioButtonPadding), RadioButtonSize);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 452256579, "CC(remember):RadioButton.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(stateRadioColor) | composerStartRestartGroup.changed(stateM464animateDpAsStateAjpBEmI);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material.RadioButtonKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return RadioButtonKt.RadioButton$lambda$0$0(stateRadioColor, stateM464animateDpAsStateAjpBEmI, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material.RadioButtonKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return RadioButtonKt.RadioButton$lambda$0$0(stateRadioColor, stateM464animateDpAsStateAjpBEmI, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                CanvasKt.Canvas(modifierM1258requiredSize3ABfNKs6, (Function1) objRememberedValue, composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                mutableInteractionSource3 = mutableInteractionSource5;
                modifier3 = companion;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                z5 = z3;
                mutableInteractionSource3 = mutableInteractionSource2;
            }
            radioButtonColors2 = radioButtonColorsM2518colorsRGew2ao;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.RadioButtonKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return RadioButtonKt.RadioButton$lambda$1(z, function0, modifier3, z5, mutableInteractionSource3, radioButtonColors2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        z3 = z2;
        i6 = i2 & 16;
        if (i6 != 0) {
            if ((i & 24576) == 0) {
                mutableInteractionSource2 = mutableInteractionSource;
                if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    radioButtonColorsM2518colorsRGew2ao = radioButtonColors;
                    if (composerStartRestartGroup.changed(radioButtonColorsM2518colorsRGew2ao)) {
                    }
                    i3 |= i10;
                } else {
                    radioButtonColorsM2518colorsRGew2ao = radioButtonColors;
                }
                i3 |= i10;
            } else {
                radioButtonColorsM2518colorsRGew2ao = radioButtonColors;
            }
            if ((74899 & i3) != 74898) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "79@3661L8");
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z6 = true;
                    } else {
                        z6 = z3;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    if ((i2 & 32) != 0) {
                        composer2 = composerStartRestartGroup;
                        i8 = i3 & (-458753);
                        radioButtonColorsM2518colorsRGew2ao = RadioButtonDefaults.INSTANCE.m2518colorsRGew2ao(0L, 0L, 0L, composer2, 3072, 7);
                    } else {
                        composer2 = composerStartRestartGroup;
                        i8 = i3;
                        radioButtonColorsM2518colorsRGew2ao = radioButtonColorsM2518colorsRGew2ao;
                    }
                    mutableInteractionSource5 = mutableInteractionSource4;
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z6 = true;
                    } else {
                        z6 = z3;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    if ((i2 & 32) != 0) {
                        composer2 = composerStartRestartGroup;
                        i8 = i3 & (-458753);
                        radioButtonColorsM2518colorsRGew2ao = RadioButtonDefaults.INSTANCE.m2518colorsRGew2ao(0L, 0L, 0L, composer2, 3072, 7);
                    } else {
                        composer2 = composerStartRestartGroup;
                        i8 = i3;
                        radioButtonColorsM2518colorsRGew2ao = radioButtonColorsM2518colorsRGew2ao;
                    }
                    mutableInteractionSource5 = mutableInteractionSource4;
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1314435585, i8, -1, "androidx.compose.material.RadioButton (RadioButton.kt:80)");
                }
                if (z) {
                    c = 2;
                    fM9687constructorimpl = Dp.m9687constructorimpl(RadioButtonDotSize / 2);
                } else {
                    c = 2;
                    fM9687constructorimpl = Dp.m9687constructorimpl(0);
                }
                char c8 = c;
                int i113 = i8;
                composerStartRestartGroup = composer2;
                stateM464animateDpAsStateAjpBEmI = AnimateAsStateKt.m464animateDpAsStateAjpBEmI(fM9687constructorimpl, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, composerStartRestartGroup, 48, 12);
                int i114 = i113 >> 9;
                stateRadioColor = radioButtonColorsM2518colorsRGew2ao.radioColor(z6, z, composerStartRestartGroup, ((i113 << 3) & 112) | (i114 & 14) | (i114 & 896));
                if (function0 != null) {
                    z5 = z6;
                    companionM1533selectableO2vRcR0 = SelectableKt.m1533selectableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource5, RippleKt.m2523rippleH2RKhps$default(false, RadioButtonRippleRadius, 0L, 4, null), z5, Role.m8825boximpl(Role.INSTANCE.m8837getRadioButtono7Vup1c()), function0);
                } else {
                    z5 = z6;
                    companionM1533selectableO2vRcR0 = Modifier.INSTANCE;
                }
                if (function0 != null) {
                    companionMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE);
                } else {
                    companionMinimumInteractiveComponentSize = Modifier.INSTANCE;
                }
                Modifier modifierM1258requiredSize3ABfNKs7 = SizeKt.m1258requiredSize3ABfNKs(PaddingKt.m1218padding3ABfNKs(SizeKt.wrapContentSize$default(companion.then(companionMinimumInteractiveComponentSize).then(companionM1533selectableO2vRcR0), Alignment.INSTANCE.getCenter(), r4, c8, null), RadioButtonPadding), RadioButtonSize);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 452256579, "CC(remember):RadioButton.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(stateRadioColor) | composerStartRestartGroup.changed(stateM464animateDpAsStateAjpBEmI);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material.RadioButtonKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return RadioButtonKt.RadioButton$lambda$0$0(stateRadioColor, stateM464animateDpAsStateAjpBEmI, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material.RadioButtonKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return RadioButtonKt.RadioButton$lambda$0$0(stateRadioColor, stateM464animateDpAsStateAjpBEmI, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                CanvasKt.Canvas(modifierM1258requiredSize3ABfNKs7, (Function1) objRememberedValue, composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                mutableInteractionSource3 = mutableInteractionSource5;
                modifier3 = companion;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                z5 = z3;
                mutableInteractionSource3 = mutableInteractionSource2;
            }
            radioButtonColors2 = radioButtonColorsM2518colorsRGew2ao;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.RadioButtonKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return RadioButtonKt.RadioButton$lambda$1(z, function0, modifier3, z5, mutableInteractionSource3, radioButtonColors2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        mutableInteractionSource2 = mutableInteractionSource;
        if ((196608 & i) == 0) {
            if ((i2 & 32) == 0) {
                radioButtonColorsM2518colorsRGew2ao = radioButtonColors;
                if (composerStartRestartGroup.changed(radioButtonColorsM2518colorsRGew2ao)) {
                }
                i3 |= i10;
            } else {
                radioButtonColorsM2518colorsRGew2ao = radioButtonColors;
            }
            i3 |= i10;
        } else {
            radioButtonColorsM2518colorsRGew2ao = radioButtonColors;
        }
        if ((74899 & i3) != 74898) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "79@3661L8");
            if ((i & 1) != 0) {
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    z6 = true;
                } else {
                    z6 = z3;
                }
                if (i6 != 0) {
                    mutableInteractionSource4 = null;
                } else {
                    mutableInteractionSource4 = mutableInteractionSource2;
                }
                if ((i2 & 32) != 0) {
                    composer2 = composerStartRestartGroup;
                    i8 = i3 & (-458753);
                    radioButtonColorsM2518colorsRGew2ao = RadioButtonDefaults.INSTANCE.m2518colorsRGew2ao(0L, 0L, 0L, composer2, 3072, 7);
                } else {
                    composer2 = composerStartRestartGroup;
                    i8 = i3;
                    radioButtonColorsM2518colorsRGew2ao = radioButtonColorsM2518colorsRGew2ao;
                }
                mutableInteractionSource5 = mutableInteractionSource4;
            } else {
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    z6 = true;
                } else {
                    z6 = z3;
                }
                if (i6 != 0) {
                    mutableInteractionSource4 = null;
                } else {
                    mutableInteractionSource4 = mutableInteractionSource2;
                }
                if ((i2 & 32) != 0) {
                    composer2 = composerStartRestartGroup;
                    i8 = i3 & (-458753);
                    radioButtonColorsM2518colorsRGew2ao = RadioButtonDefaults.INSTANCE.m2518colorsRGew2ao(0L, 0L, 0L, composer2, 3072, 7);
                } else {
                    composer2 = composerStartRestartGroup;
                    i8 = i3;
                    radioButtonColorsM2518colorsRGew2ao = radioButtonColorsM2518colorsRGew2ao;
                }
                mutableInteractionSource5 = mutableInteractionSource4;
            }
            composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1314435585, i8, -1, "androidx.compose.material.RadioButton (RadioButton.kt:80)");
            }
            if (z) {
                c = 2;
                fM9687constructorimpl = Dp.m9687constructorimpl(RadioButtonDotSize / 2);
            } else {
                c = 2;
                fM9687constructorimpl = Dp.m9687constructorimpl(0);
            }
            char c9 = c;
            int i115 = i8;
            composerStartRestartGroup = composer2;
            stateM464animateDpAsStateAjpBEmI = AnimateAsStateKt.m464animateDpAsStateAjpBEmI(fM9687constructorimpl, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, composerStartRestartGroup, 48, 12);
            int i116 = i115 >> 9;
            stateRadioColor = radioButtonColorsM2518colorsRGew2ao.radioColor(z6, z, composerStartRestartGroup, ((i115 << 3) & 112) | (i116 & 14) | (i116 & 896));
            if (function0 != null) {
                z5 = z6;
                companionM1533selectableO2vRcR0 = SelectableKt.m1533selectableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource5, RippleKt.m2523rippleH2RKhps$default(false, RadioButtonRippleRadius, 0L, 4, null), z5, Role.m8825boximpl(Role.INSTANCE.m8837getRadioButtono7Vup1c()), function0);
            } else {
                z5 = z6;
                companionM1533selectableO2vRcR0 = Modifier.INSTANCE;
            }
            if (function0 != null) {
                companionMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE);
            } else {
                companionMinimumInteractiveComponentSize = Modifier.INSTANCE;
            }
            Modifier modifierM1258requiredSize3ABfNKs8 = SizeKt.m1258requiredSize3ABfNKs(PaddingKt.m1218padding3ABfNKs(SizeKt.wrapContentSize$default(companion.then(companionMinimumInteractiveComponentSize).then(companionM1533selectableO2vRcR0), Alignment.INSTANCE.getCenter(), r4, c9, null), RadioButtonPadding), RadioButtonSize);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 452256579, "CC(remember):RadioButton.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(stateRadioColor) | composerStartRestartGroup.changed(stateM464animateDpAsStateAjpBEmI);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material.RadioButtonKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return RadioButtonKt.RadioButton$lambda$0$0(stateRadioColor, stateM464animateDpAsStateAjpBEmI, (DrawScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function1() { // from class: androidx.compose.material.RadioButtonKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return RadioButtonKt.RadioButton$lambda$0$0(stateRadioColor, stateM464animateDpAsStateAjpBEmI, (DrawScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            CanvasKt.Canvas(modifierM1258requiredSize3ABfNKs8, (Function1) objRememberedValue, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            mutableInteractionSource3 = mutableInteractionSource5;
            modifier3 = companion;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            z5 = z3;
            mutableInteractionSource3 = mutableInteractionSource2;
        }
        radioButtonColors2 = radioButtonColorsM2518colorsRGew2ao;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.RadioButtonKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RadioButtonKt.RadioButton$lambda$1(z, function0, modifier3, z5, mutableInteractionSource3, radioButtonColors2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RadioButton$lambda$0$0(State state, State state2, DrawScope drawScope) {
        float f = drawScope.mo754toPx0680j_4(RadioStrokeWidth);
        float f2 = f / 2;
        DrawScope.m7376drawCircleVaOC9Bg$default(drawScope, ((Color) state.getValue()).m6824unboximpl(), drawScope.mo754toPx0680j_4(RadioRadius) - f2, 0L, 0.0f, new Stroke(f, 0.0f, 0, 0, null, 30, null), null, 0, 108, null);
        if (Dp.m9686compareTo0680j_4(((Dp) state2.getValue()).m9701unboximpl(), Dp.m9687constructorimpl(0)) > 0) {
            DrawScope.m7376drawCircleVaOC9Bg$default(drawScope, ((Color) state.getValue()).m6824unboximpl(), drawScope.mo754toPx0680j_4(((Dp) state2.getValue()).m9701unboximpl()) - f2, 0L, 0.0f, Fill.INSTANCE, null, 0, 108, null);
        }
        return Unit.INSTANCE;
    }

    static {
        float f = 2;
        RadioButtonPadding = Dp.m9687constructorimpl(f);
        float fM9687constructorimpl = Dp.m9687constructorimpl(20);
        RadioButtonSize = fM9687constructorimpl;
        RadioRadius = Dp.m9687constructorimpl(fM9687constructorimpl / f);
        RadioButtonDotSize = Dp.m9687constructorimpl(12);
        RadioStrokeWidth = Dp.m9687constructorimpl(f);
    }
}
