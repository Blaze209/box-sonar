package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
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
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.state.ToggleableStateKt;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u001aU\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\r\u001aO\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00122\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\u0013\u001a-\u0010\u0014\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0003¢\u0006\u0002\u0010\u0016\u001a3\u0010\u0017\u001a\u00020\u0001*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 \u001a;\u0010!\u001a\u00020\u0001*\u00020\u00182\u0006\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020'H\u0002¢\u0006\u0004\b(\u0010)\"\u000e\u0010*\u001a\u00020+X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010,\u001a\u00020+X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010-\u001a\u00020+X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u00101\u001a\u00020/X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u00102\u001a\u00020/X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u00103\u001a\u00020/X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u00104\u001a\u00020/X\u0082\u0004¢\u0006\u0004\n\u0002\u00100¨\u00065²\u0006\n\u00106\u001a\u00020\u001dX\u008a\u0084\u0002²\u0006\n\u00107\u001a\u00020\u001dX\u008a\u0084\u0002²\u0006\n\u0010\"\u001a\u00020\u001aX\u008a\u0084\u0002²\u0006\n\u0010\u0019\u001a\u00020\u001aX\u008a\u0084\u0002²\u0006\n\u0010\u001b\u001a\u00020\u001aX\u008a\u0084\u0002"}, d2 = {"Checkbox", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "colors", "Landroidx/compose/material/CheckboxColors;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/CheckboxColors;Landroidx/compose/runtime/Composer;II)V", "TriStateCheckbox", "state", "Landroidx/compose/ui/state/ToggleableState;", ViewProps.ON_CLICK, "Lkotlin/Function0;", "(Landroidx/compose/ui/state/ToggleableState;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/CheckboxColors;Landroidx/compose/runtime/Composer;II)V", "CheckboxImpl", "value", "(ZLandroidx/compose/ui/state/ToggleableState;Landroidx/compose/ui/Modifier;Landroidx/compose/material/CheckboxColors;Landroidx/compose/runtime/Composer;I)V", "drawBox", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "boxColor", "Landroidx/compose/ui/graphics/Color;", ViewProps.BORDER_COLOR, "radius", "", "strokeWidth", "drawBox-1wkBAMs", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJFF)V", "drawCheck", "checkColor", "checkFraction", "crossCenterGravitation", "strokeWidthPx", "drawingCache", "Landroidx/compose/material/CheckDrawingCache;", "drawCheck-3IgeMak", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFFFLandroidx/compose/material/CheckDrawingCache;)V", "BoxInDuration", "", "BoxOutDuration", "CheckAnimationDuration", "CheckboxRippleRadius", "Landroidx/compose/ui/unit/Dp;", "F", "CheckboxDefaultPadding", "CheckboxSize", "StrokeWidth", "RadiusSize", "material", "checkDrawFraction", "checkCenterGravitationShiftFraction"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class CheckboxKt {
    private static final int BoxInDuration = 50;
    private static final int BoxOutDuration = 100;
    private static final int CheckAnimationDuration = 100;
    private static final float CheckboxDefaultPadding;
    private static final float CheckboxRippleRadius = Dp.m9687constructorimpl(24);
    private static final float CheckboxSize = Dp.m9687constructorimpl(20);
    private static final float RadiusSize;
    private static final float StrokeWidth;

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
    public static final Unit Checkbox$lambda$1(boolean z, Function1 function1, Modifier modifier, boolean z2, MutableInteractionSource mutableInteractionSource, CheckboxColors checkboxColors, int i, int i2, Composer composer, int i3) {
        Checkbox(z, function1, modifier, z2, mutableInteractionSource, checkboxColors, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CheckboxImpl$lambda$11(boolean z, ToggleableState toggleableState, Modifier modifier, CheckboxColors checkboxColors, int i, Composer composer, int i2) {
        CheckboxImpl(z, toggleableState, modifier, checkboxColors, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TriStateCheckbox$lambda$0(ToggleableState toggleableState, Function0 function0, Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, CheckboxColors checkboxColors, int i, int i2, Composer composer, int i3) {
        TriStateCheckbox(toggleableState, function0, modifier, z, mutableInteractionSource, checkboxColors, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0154  */
    /* JADX WARN: Code duplicated, block: B:104:0x015e  */
    /* JADX WARN: Code duplicated, block: B:106:0x0166  */
    /* JADX WARN: Code duplicated, block: B:108:0x0179  */
    /* JADX WARN: Code duplicated, block: B:111:0x0194  */
    /* JADX WARN: Code duplicated, block: B:113:0x019a  */
    /* JADX WARN: Code duplicated, block: B:116:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:118:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x0055  */
    /* JADX WARN: Code duplicated, block: B:31:0x0058  */
    /* JADX WARN: Code duplicated, block: B:33:0x005c  */
    /* JADX WARN: Code duplicated, block: B:35:0x0064  */
    /* JADX WARN: Code duplicated, block: B:36:0x0067  */
    /* JADX WARN: Code duplicated, block: B:41:0x0071  */
    /* JADX WARN: Code duplicated, block: B:42:0x0074  */
    /* JADX WARN: Code duplicated, block: B:44:0x0078  */
    /* JADX WARN: Code duplicated, block: B:46:0x0080  */
    /* JADX WARN: Code duplicated, block: B:47:0x0083  */
    /* JADX WARN: Code duplicated, block: B:52:0x008e  */
    /* JADX WARN: Code duplicated, block: B:54:0x0092  */
    /* JADX WARN: Code duplicated, block: B:56:0x009a  */
    /* JADX WARN: Code duplicated, block: B:57:0x009d  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:67:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:69:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:76:0x00e3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:77:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:78:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:80:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:81:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:83:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:87:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:88:0x011a  */
    /* JADX WARN: Code duplicated, block: B:92:0x0127  */
    /* JADX WARN: Code duplicated, block: B:95:0x0133  */
    /* JADX WARN: Code duplicated, block: B:97:0x014a  */
    /* JADX WARN: Code duplicated, block: B:98:0x014d  */
    public static final void Checkbox(final boolean z, final Function1<? super Boolean, Unit> function1, Modifier modifier, boolean z2, MutableInteractionSource mutableInteractionSource, CheckboxColors checkboxColors, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z3;
        int i5;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        int i7;
        CheckboxColors checkboxColors2;
        boolean z4;
        final Modifier modifier3;
        final boolean z5;
        final MutableInteractionSource mutableInteractionSource3;
        final CheckboxColors checkboxColors3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function0 function0;
        Modifier.Companion companion;
        boolean z6;
        MutableInteractionSource mutableInteractionSource4;
        boolean z7;
        boolean z8;
        Object objRememberedValue;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2118660998);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Checkbox)N(checked,onCheckedChange,modifier,enabled,interactionSource,colors)91@4126L325:Checkbox.kt#jmzs0o");
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
                            checkboxColors2 = checkboxColors;
                            int i9 = composerStartRestartGroup.changed(checkboxColors2) ? 131072 : 65536;
                            i3 |= i9;
                        } else {
                            checkboxColors2 = checkboxColors;
                        }
                        i3 |= i9;
                    } else {
                        checkboxColors2 = checkboxColors;
                    }
                    if ((74899 & i3) != 74898) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "89@4108L8");
                        function0 = null;
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i8 != 0) {
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
                                CheckboxColors checkboxColorsM2314colorszjMxDiM = CheckboxDefaults.INSTANCE.m2314colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                                composerStartRestartGroup = composerStartRestartGroup;
                                i3 &= -458753;
                                checkboxColors2 = checkboxColorsM2314colorszjMxDiM;
                            }
                            mutableInteractionSource2 = mutableInteractionSource4;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                            z6 = z3;
                            companion = modifier2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2118660998, i3, -1, "androidx.compose.material.Checkbox (Checkbox.kt:90)");
                        }
                        ToggleableState ToggleableState = ToggleableStateKt.ToggleableState(z);
                        if (function1 != null) {
                            composerStartRestartGroup.startReplaceGroup(1809972427);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "95@4263L29");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -218707913, "CC(remember):Checkbox.kt#9igjgp");
                            if ((i3 & 112) == 32) {
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                            z8 = z7 | ((i3 & 14) == 4);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z8 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function0() { // from class: androidx.compose.material.CheckboxKt$$ExternalSyntheticLambda5
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return CheckboxKt.Checkbox$lambda$0$0(function1, z);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            function0 = (Function0) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1810037123);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        TriStateCheckbox(ToggleableState, function0, companion, z6, mutableInteractionSource2, checkboxColors2, composerStartRestartGroup, i3 & 524160, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = companion;
                        z5 = z6;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        z5 = z3;
                    }
                    mutableInteractionSource3 = mutableInteractionSource2;
                    checkboxColors3 = checkboxColors2;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.CheckboxKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CheckboxKt.Checkbox$lambda$1(z, function1, modifier3, z5, mutableInteractionSource3, checkboxColors3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 24576;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        checkboxColors2 = checkboxColors;
                        if (composerStartRestartGroup.changed(checkboxColors2)) {
                        }
                        i3 |= i9;
                    } else {
                        checkboxColors2 = checkboxColors;
                    }
                    i3 |= i9;
                } else {
                    checkboxColors2 = checkboxColors;
                }
                if ((74899 & i3) != 74898) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "89@4108L8");
                    function0 = null;
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
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
                            CheckboxColors checkboxColorsM2314colorszjMxDiM2 = CheckboxDefaults.INSTANCE.m2314colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            composerStartRestartGroup = composerStartRestartGroup;
                            i3 &= -458753;
                            checkboxColors2 = checkboxColorsM2314colorszjMxDiM2;
                        }
                        mutableInteractionSource2 = mutableInteractionSource4;
                    } else {
                        if (i8 != 0) {
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
                            CheckboxColors checkboxColorsM2314colorszjMxDiM3 = CheckboxDefaults.INSTANCE.m2314colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            composerStartRestartGroup = composerStartRestartGroup;
                            i3 &= -458753;
                            checkboxColors2 = checkboxColorsM2314colorszjMxDiM3;
                        }
                        mutableInteractionSource2 = mutableInteractionSource4;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2118660998, i3, -1, "androidx.compose.material.Checkbox (Checkbox.kt:90)");
                    }
                    ToggleableState ToggleableState2 = ToggleableStateKt.ToggleableState(z);
                    if (function1 != null) {
                        composerStartRestartGroup.startReplaceGroup(1809972427);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "95@4263L29");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -218707913, "CC(remember):Checkbox.kt#9igjgp");
                        if ((i3 & 112) == 32) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        z8 = z7 | ((i3 & 14) == 4);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z8) {
                            objRememberedValue = new Function0() { // from class: androidx.compose.material.CheckboxKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return CheckboxKt.Checkbox$lambda$0$0(function1, z);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function0() { // from class: androidx.compose.material.CheckboxKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return CheckboxKt.Checkbox$lambda$0$0(function1, z);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        function0 = (Function0) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1810037123);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    TriStateCheckbox(ToggleableState2, function0, companion, z6, mutableInteractionSource2, checkboxColors2, composerStartRestartGroup, i3 & 524160, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = companion;
                    z5 = z6;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    z5 = z3;
                }
                mutableInteractionSource3 = mutableInteractionSource2;
                checkboxColors3 = checkboxColors2;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.CheckboxKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CheckboxKt.Checkbox$lambda$1(z, function1, modifier3, z5, mutableInteractionSource3, checkboxColors3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
                        checkboxColors2 = checkboxColors;
                        if (composerStartRestartGroup.changed(checkboxColors2)) {
                        }
                        i3 |= i9;
                    } else {
                        checkboxColors2 = checkboxColors;
                    }
                    i3 |= i9;
                } else {
                    checkboxColors2 = checkboxColors;
                }
                if ((74899 & i3) != 74898) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "89@4108L8");
                    function0 = null;
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
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
                            CheckboxColors checkboxColorsM2314colorszjMxDiM4 = CheckboxDefaults.INSTANCE.m2314colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            composerStartRestartGroup = composerStartRestartGroup;
                            i3 &= -458753;
                            checkboxColors2 = checkboxColorsM2314colorszjMxDiM4;
                        }
                        mutableInteractionSource2 = mutableInteractionSource4;
                    } else {
                        if (i8 != 0) {
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
                            CheckboxColors checkboxColorsM2314colorszjMxDiM5 = CheckboxDefaults.INSTANCE.m2314colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            composerStartRestartGroup = composerStartRestartGroup;
                            i3 &= -458753;
                            checkboxColors2 = checkboxColorsM2314colorszjMxDiM5;
                        }
                        mutableInteractionSource2 = mutableInteractionSource4;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2118660998, i3, -1, "androidx.compose.material.Checkbox (Checkbox.kt:90)");
                    }
                    ToggleableState ToggleableState3 = ToggleableStateKt.ToggleableState(z);
                    if (function1 != null) {
                        composerStartRestartGroup.startReplaceGroup(1809972427);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "95@4263L29");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -218707913, "CC(remember):Checkbox.kt#9igjgp");
                        if ((i3 & 112) == 32) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        z8 = z7 | ((i3 & 14) == 4);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z8) {
                            objRememberedValue = new Function0() { // from class: androidx.compose.material.CheckboxKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return CheckboxKt.Checkbox$lambda$0$0(function1, z);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function0() { // from class: androidx.compose.material.CheckboxKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return CheckboxKt.Checkbox$lambda$0$0(function1, z);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        function0 = (Function0) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1810037123);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    TriStateCheckbox(ToggleableState3, function0, companion, z6, mutableInteractionSource2, checkboxColors2, composerStartRestartGroup, i3 & 524160, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = companion;
                    z5 = z6;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    z5 = z3;
                }
                mutableInteractionSource3 = mutableInteractionSource2;
                checkboxColors3 = checkboxColors2;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.CheckboxKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CheckboxKt.Checkbox$lambda$1(z, function1, modifier3, z5, mutableInteractionSource3, checkboxColors3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    checkboxColors2 = checkboxColors;
                    if (composerStartRestartGroup.changed(checkboxColors2)) {
                    }
                    i3 |= i9;
                } else {
                    checkboxColors2 = checkboxColors;
                }
                i3 |= i9;
            } else {
                checkboxColors2 = checkboxColors;
            }
            if ((74899 & i3) != 74898) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "89@4108L8");
                function0 = null;
                if ((i & 1) != 0) {
                    if (i8 != 0) {
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
                        CheckboxColors checkboxColorsM2314colorszjMxDiM6 = CheckboxDefaults.INSTANCE.m2314colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        composerStartRestartGroup = composerStartRestartGroup;
                        i3 &= -458753;
                        checkboxColors2 = checkboxColorsM2314colorszjMxDiM6;
                    }
                    mutableInteractionSource2 = mutableInteractionSource4;
                } else {
                    if (i8 != 0) {
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
                        CheckboxColors checkboxColorsM2314colorszjMxDiM7 = CheckboxDefaults.INSTANCE.m2314colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        composerStartRestartGroup = composerStartRestartGroup;
                        i3 &= -458753;
                        checkboxColors2 = checkboxColorsM2314colorszjMxDiM7;
                    }
                    mutableInteractionSource2 = mutableInteractionSource4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2118660998, i3, -1, "androidx.compose.material.Checkbox (Checkbox.kt:90)");
                }
                ToggleableState ToggleableState4 = ToggleableStateKt.ToggleableState(z);
                if (function1 != null) {
                    composerStartRestartGroup.startReplaceGroup(1809972427);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "95@4263L29");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -218707913, "CC(remember):Checkbox.kt#9igjgp");
                    if ((i3 & 112) == 32) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    z8 = z7 | ((i3 & 14) == 4);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z8) {
                        objRememberedValue = new Function0() { // from class: androidx.compose.material.CheckboxKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return CheckboxKt.Checkbox$lambda$0$0(function1, z);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function0() { // from class: androidx.compose.material.CheckboxKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return CheckboxKt.Checkbox$lambda$0$0(function1, z);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    function0 = (Function0) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1810037123);
                    composerStartRestartGroup.endReplaceGroup();
                }
                TriStateCheckbox(ToggleableState4, function0, companion, z6, mutableInteractionSource2, checkboxColors2, composerStartRestartGroup, i3 & 524160, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = companion;
                z5 = z6;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                z5 = z3;
            }
            mutableInteractionSource3 = mutableInteractionSource2;
            checkboxColors3 = checkboxColors2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.CheckboxKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CheckboxKt.Checkbox$lambda$1(z, function1, modifier3, z5, mutableInteractionSource3, checkboxColors3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
                        checkboxColors2 = checkboxColors;
                        if (composerStartRestartGroup.changed(checkboxColors2)) {
                        }
                        i3 |= i9;
                    } else {
                        checkboxColors2 = checkboxColors;
                    }
                    i3 |= i9;
                } else {
                    checkboxColors2 = checkboxColors;
                }
                if ((74899 & i3) != 74898) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "89@4108L8");
                    function0 = null;
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
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
                            CheckboxColors checkboxColorsM2314colorszjMxDiM8 = CheckboxDefaults.INSTANCE.m2314colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            composerStartRestartGroup = composerStartRestartGroup;
                            i3 &= -458753;
                            checkboxColors2 = checkboxColorsM2314colorszjMxDiM8;
                        }
                        mutableInteractionSource2 = mutableInteractionSource4;
                    } else {
                        if (i8 != 0) {
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
                            CheckboxColors checkboxColorsM2314colorszjMxDiM9 = CheckboxDefaults.INSTANCE.m2314colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            composerStartRestartGroup = composerStartRestartGroup;
                            i3 &= -458753;
                            checkboxColors2 = checkboxColorsM2314colorszjMxDiM9;
                        }
                        mutableInteractionSource2 = mutableInteractionSource4;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2118660998, i3, -1, "androidx.compose.material.Checkbox (Checkbox.kt:90)");
                    }
                    ToggleableState ToggleableState5 = ToggleableStateKt.ToggleableState(z);
                    if (function1 != null) {
                        composerStartRestartGroup.startReplaceGroup(1809972427);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "95@4263L29");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -218707913, "CC(remember):Checkbox.kt#9igjgp");
                        if ((i3 & 112) == 32) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        z8 = z7 | ((i3 & 14) == 4);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z8) {
                            objRememberedValue = new Function0() { // from class: androidx.compose.material.CheckboxKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return CheckboxKt.Checkbox$lambda$0$0(function1, z);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function0() { // from class: androidx.compose.material.CheckboxKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return CheckboxKt.Checkbox$lambda$0$0(function1, z);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        function0 = (Function0) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1810037123);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    TriStateCheckbox(ToggleableState5, function0, companion, z6, mutableInteractionSource2, checkboxColors2, composerStartRestartGroup, i3 & 524160, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = companion;
                    z5 = z6;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    z5 = z3;
                }
                mutableInteractionSource3 = mutableInteractionSource2;
                checkboxColors3 = checkboxColors2;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.CheckboxKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CheckboxKt.Checkbox$lambda$1(z, function1, modifier3, z5, mutableInteractionSource3, checkboxColors3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    checkboxColors2 = checkboxColors;
                    if (composerStartRestartGroup.changed(checkboxColors2)) {
                    }
                    i3 |= i9;
                } else {
                    checkboxColors2 = checkboxColors;
                }
                i3 |= i9;
            } else {
                checkboxColors2 = checkboxColors;
            }
            if ((74899 & i3) != 74898) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "89@4108L8");
                function0 = null;
                if ((i & 1) != 0) {
                    if (i8 != 0) {
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
                        CheckboxColors checkboxColorsM2314colorszjMxDiM10 = CheckboxDefaults.INSTANCE.m2314colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        composerStartRestartGroup = composerStartRestartGroup;
                        i3 &= -458753;
                        checkboxColors2 = checkboxColorsM2314colorszjMxDiM10;
                    }
                    mutableInteractionSource2 = mutableInteractionSource4;
                } else {
                    if (i8 != 0) {
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
                        CheckboxColors checkboxColorsM2314colorszjMxDiM11 = CheckboxDefaults.INSTANCE.m2314colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        composerStartRestartGroup = composerStartRestartGroup;
                        i3 &= -458753;
                        checkboxColors2 = checkboxColorsM2314colorszjMxDiM11;
                    }
                    mutableInteractionSource2 = mutableInteractionSource4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2118660998, i3, -1, "androidx.compose.material.Checkbox (Checkbox.kt:90)");
                }
                ToggleableState ToggleableState6 = ToggleableStateKt.ToggleableState(z);
                if (function1 != null) {
                    composerStartRestartGroup.startReplaceGroup(1809972427);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "95@4263L29");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -218707913, "CC(remember):Checkbox.kt#9igjgp");
                    if ((i3 & 112) == 32) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    z8 = z7 | ((i3 & 14) == 4);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z8) {
                        objRememberedValue = new Function0() { // from class: androidx.compose.material.CheckboxKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return CheckboxKt.Checkbox$lambda$0$0(function1, z);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function0() { // from class: androidx.compose.material.CheckboxKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return CheckboxKt.Checkbox$lambda$0$0(function1, z);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    function0 = (Function0) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1810037123);
                    composerStartRestartGroup.endReplaceGroup();
                }
                TriStateCheckbox(ToggleableState6, function0, companion, z6, mutableInteractionSource2, checkboxColors2, composerStartRestartGroup, i3 & 524160, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = companion;
                z5 = z6;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                z5 = z3;
            }
            mutableInteractionSource3 = mutableInteractionSource2;
            checkboxColors3 = checkboxColors2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.CheckboxKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CheckboxKt.Checkbox$lambda$1(z, function1, modifier3, z5, mutableInteractionSource3, checkboxColors3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
                    checkboxColors2 = checkboxColors;
                    if (composerStartRestartGroup.changed(checkboxColors2)) {
                    }
                    i3 |= i9;
                } else {
                    checkboxColors2 = checkboxColors;
                }
                i3 |= i9;
            } else {
                checkboxColors2 = checkboxColors;
            }
            if ((74899 & i3) != 74898) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "89@4108L8");
                function0 = null;
                if ((i & 1) != 0) {
                    if (i8 != 0) {
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
                        CheckboxColors checkboxColorsM2314colorszjMxDiM12 = CheckboxDefaults.INSTANCE.m2314colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        composerStartRestartGroup = composerStartRestartGroup;
                        i3 &= -458753;
                        checkboxColors2 = checkboxColorsM2314colorszjMxDiM12;
                    }
                    mutableInteractionSource2 = mutableInteractionSource4;
                } else {
                    if (i8 != 0) {
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
                        CheckboxColors checkboxColorsM2314colorszjMxDiM13 = CheckboxDefaults.INSTANCE.m2314colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        composerStartRestartGroup = composerStartRestartGroup;
                        i3 &= -458753;
                        checkboxColors2 = checkboxColorsM2314colorszjMxDiM13;
                    }
                    mutableInteractionSource2 = mutableInteractionSource4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2118660998, i3, -1, "androidx.compose.material.Checkbox (Checkbox.kt:90)");
                }
                ToggleableState ToggleableState7 = ToggleableStateKt.ToggleableState(z);
                if (function1 != null) {
                    composerStartRestartGroup.startReplaceGroup(1809972427);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "95@4263L29");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -218707913, "CC(remember):Checkbox.kt#9igjgp");
                    if ((i3 & 112) == 32) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    z8 = z7 | ((i3 & 14) == 4);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z8) {
                        objRememberedValue = new Function0() { // from class: androidx.compose.material.CheckboxKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return CheckboxKt.Checkbox$lambda$0$0(function1, z);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function0() { // from class: androidx.compose.material.CheckboxKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return CheckboxKt.Checkbox$lambda$0$0(function1, z);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    function0 = (Function0) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1810037123);
                    composerStartRestartGroup.endReplaceGroup();
                }
                TriStateCheckbox(ToggleableState7, function0, companion, z6, mutableInteractionSource2, checkboxColors2, composerStartRestartGroup, i3 & 524160, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = companion;
                z5 = z6;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                z5 = z3;
            }
            mutableInteractionSource3 = mutableInteractionSource2;
            checkboxColors3 = checkboxColors2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.CheckboxKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CheckboxKt.Checkbox$lambda$1(z, function1, modifier3, z5, mutableInteractionSource3, checkboxColors3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        mutableInteractionSource2 = mutableInteractionSource;
        if ((196608 & i) == 0) {
            if ((i2 & 32) == 0) {
                checkboxColors2 = checkboxColors;
                if (composerStartRestartGroup.changed(checkboxColors2)) {
                }
                i3 |= i9;
            } else {
                checkboxColors2 = checkboxColors;
            }
            i3 |= i9;
        } else {
            checkboxColors2 = checkboxColors;
        }
        if ((74899 & i3) != 74898) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "89@4108L8");
            function0 = null;
            if ((i & 1) != 0) {
                if (i8 != 0) {
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
                    CheckboxColors checkboxColorsM2314colorszjMxDiM14 = CheckboxDefaults.INSTANCE.m2314colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    composerStartRestartGroup = composerStartRestartGroup;
                    i3 &= -458753;
                    checkboxColors2 = checkboxColorsM2314colorszjMxDiM14;
                }
                mutableInteractionSource2 = mutableInteractionSource4;
            } else {
                if (i8 != 0) {
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
                    CheckboxColors checkboxColorsM2314colorszjMxDiM15 = CheckboxDefaults.INSTANCE.m2314colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    composerStartRestartGroup = composerStartRestartGroup;
                    i3 &= -458753;
                    checkboxColors2 = checkboxColorsM2314colorszjMxDiM15;
                }
                mutableInteractionSource2 = mutableInteractionSource4;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2118660998, i3, -1, "androidx.compose.material.Checkbox (Checkbox.kt:90)");
            }
            ToggleableState ToggleableState8 = ToggleableStateKt.ToggleableState(z);
            if (function1 != null) {
                composerStartRestartGroup.startReplaceGroup(1809972427);
                ComposerKt.sourceInformation(composerStartRestartGroup, "95@4263L29");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -218707913, "CC(remember):Checkbox.kt#9igjgp");
                if ((i3 & 112) == 32) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                z8 = z7 | ((i3 & 14) == 4);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z8) {
                    objRememberedValue = new Function0() { // from class: androidx.compose.material.CheckboxKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return CheckboxKt.Checkbox$lambda$0$0(function1, z);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function0() { // from class: androidx.compose.material.CheckboxKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return CheckboxKt.Checkbox$lambda$0$0(function1, z);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                function0 = (Function0) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(1810037123);
                composerStartRestartGroup.endReplaceGroup();
            }
            TriStateCheckbox(ToggleableState8, function0, companion, z6, mutableInteractionSource2, checkboxColors2, composerStartRestartGroup, i3 & 524160, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = companion;
            z5 = z6;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            z5 = z3;
        }
        mutableInteractionSource3 = mutableInteractionSource2;
        checkboxColors3 = checkboxColors2;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.CheckboxKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CheckboxKt.Checkbox$lambda$1(z, function1, modifier3, z5, mutableInteractionSource3, checkboxColors3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Checkbox$lambda$0$0(Function1 function1, boolean z) {
        function1.invoke(Boolean.valueOf(!z));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0198  */
    /* JADX WARN: Code duplicated, block: B:103:0x019f  */
    /* JADX WARN: Code duplicated, block: B:106:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:108:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x005a  */
    /* JADX WARN: Code duplicated, block: B:31:0x005d  */
    /* JADX WARN: Code duplicated, block: B:33:0x0061  */
    /* JADX WARN: Code duplicated, block: B:35:0x0069  */
    /* JADX WARN: Code duplicated, block: B:36:0x006c  */
    /* JADX WARN: Code duplicated, block: B:41:0x0076  */
    /* JADX WARN: Code duplicated, block: B:42:0x0079  */
    /* JADX WARN: Code duplicated, block: B:44:0x007d  */
    /* JADX WARN: Code duplicated, block: B:46:0x0085  */
    /* JADX WARN: Code duplicated, block: B:47:0x0088  */
    /* JADX WARN: Code duplicated, block: B:52:0x0093  */
    /* JADX WARN: Code duplicated, block: B:54:0x0097  */
    /* JADX WARN: Code duplicated, block: B:56:0x009f  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:67:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:69:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:76:0x00e5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:77:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:78:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:80:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:81:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:83:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:87:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:88:0x0118  */
    /* JADX WARN: Code duplicated, block: B:92:0x0127  */
    /* JADX WARN: Code duplicated, block: B:94:0x012f  */
    /* JADX WARN: Code duplicated, block: B:95:0x0159  */
    /* JADX WARN: Code duplicated, block: B:97:0x0160  */
    /* JADX WARN: Code duplicated, block: B:98:0x0169  */
    public static final void TriStateCheckbox(final ToggleableState toggleableState, final Function0<Unit> function0, Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, CheckboxColors checkboxColors, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        int i5;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        int i7;
        CheckboxColors checkboxColorsM2314colorszjMxDiM;
        boolean z3;
        Composer composer2;
        final Modifier modifier3;
        final boolean z4;
        final CheckboxColors checkboxColors2;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        boolean z5;
        MutableInteractionSource mutableInteractionSource4;
        int i8;
        Modifier.Companion companionM1546triStateToggleableO2vRcR0;
        Modifier.Companion companionMinimumInteractiveComponentSize;
        Composer composerStartRestartGroup = composer.startRestartGroup(2031255194);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TriStateCheckbox)N(state,onClick,modifier,enabled,interactionSource,colors)152@6815L461:Checkbox.kt#jmzs0o");
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
                            checkboxColorsM2314colorszjMxDiM = checkboxColors;
                            int i10 = composerStartRestartGroup.changed(checkboxColorsM2314colorszjMxDiM) ? 131072 : 65536;
                            i3 |= i10;
                        } else {
                            checkboxColorsM2314colorszjMxDiM = checkboxColors;
                        }
                        i3 |= i10;
                    } else {
                        checkboxColorsM2314colorszjMxDiM = checkboxColors;
                    }
                    if ((74899 & i3) != 74898) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "137@6355L8");
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i9 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                mutableInteractionSource4 = null;
                            } else {
                                mutableInteractionSource4 = mutableInteractionSource2;
                            }
                            if ((i2 & 32) != 0) {
                                composer2 = composerStartRestartGroup;
                                i8 = i3 & (-458753);
                                checkboxColorsM2314colorszjMxDiM = CheckboxDefaults.INSTANCE.m2314colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            } else {
                                composer2 = composerStartRestartGroup;
                                i8 = i3;
                            }
                            mutableInteractionSource2 = mutableInteractionSource4;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                            i8 = i3;
                            composer2 = composerStartRestartGroup;
                            z5 = z2;
                            mutableInteractionSource2 = mutableInteractionSource2;
                            companion = modifier2;
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2031255194, i8, -1, "androidx.compose.material.TriStateCheckbox (Checkbox.kt:138)");
                        }
                        if (function0 != null) {
                            boolean z6 = z5;
                            companionM1546triStateToggleableO2vRcR0 = ToggleableKt.m1546triStateToggleableO2vRcR0(Modifier.INSTANCE, toggleableState, mutableInteractionSource2, RippleKt.m2523rippleH2RKhps$default(false, CheckboxRippleRadius, 0L, 4, null), z6, Role.m8825boximpl(Role.INSTANCE.m8834getCheckboxo7Vup1c()), function0);
                            z5 = z6;
                        } else {
                            companionM1546triStateToggleableO2vRcR0 = Modifier.INSTANCE;
                        }
                        if (function0 != null) {
                            companionMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE);
                        } else {
                            companionMinimumInteractiveComponentSize = Modifier.INSTANCE;
                        }
                        CheckboxColors checkboxColors3 = checkboxColorsM2314colorszjMxDiM;
                        CheckboxImpl(z5, toggleableState, PaddingKt.m1218padding3ABfNKs(companion.then(companionMinimumInteractiveComponentSize).then(companionM1546triStateToggleableO2vRcR0), CheckboxDefaultPadding), checkboxColors3, composer2, ((i8 >> 9) & 14) | ((i8 << 3) & 112) | ((i8 >> 6) & 7168));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        checkboxColors2 = checkboxColors3;
                        modifier3 = companion;
                        z4 = z5;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier3 = modifier2;
                        z4 = z2;
                        checkboxColors2 = checkboxColorsM2314colorszjMxDiM;
                    }
                    mutableInteractionSource3 = mutableInteractionSource2;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.CheckboxKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CheckboxKt.TriStateCheckbox$lambda$0(toggleableState, function0, modifier3, z4, mutableInteractionSource3, checkboxColors2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 24576;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        checkboxColorsM2314colorszjMxDiM = checkboxColors;
                        if (composerStartRestartGroup.changed(checkboxColorsM2314colorszjMxDiM)) {
                        }
                        i3 |= i10;
                    } else {
                        checkboxColorsM2314colorszjMxDiM = checkboxColors;
                    }
                    i3 |= i10;
                } else {
                    checkboxColorsM2314colorszjMxDiM = checkboxColors;
                }
                if ((74899 & i3) != 74898) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "137@6355L8");
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        if ((i2 & 32) != 0) {
                            composer2 = composerStartRestartGroup;
                            i8 = i3 & (-458753);
                            checkboxColorsM2314colorszjMxDiM = CheckboxDefaults.INSTANCE.m2314colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            composer2 = composerStartRestartGroup;
                            i8 = i3;
                        }
                        mutableInteractionSource2 = mutableInteractionSource4;
                    } else {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        if ((i2 & 32) != 0) {
                            composer2 = composerStartRestartGroup;
                            i8 = i3 & (-458753);
                            checkboxColorsM2314colorszjMxDiM = CheckboxDefaults.INSTANCE.m2314colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            composer2 = composerStartRestartGroup;
                            i8 = i3;
                        }
                        mutableInteractionSource2 = mutableInteractionSource4;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2031255194, i8, -1, "androidx.compose.material.TriStateCheckbox (Checkbox.kt:138)");
                    }
                    if (function0 != null) {
                        boolean z7 = z5;
                        companionM1546triStateToggleableO2vRcR0 = ToggleableKt.m1546triStateToggleableO2vRcR0(Modifier.INSTANCE, toggleableState, mutableInteractionSource2, RippleKt.m2523rippleH2RKhps$default(false, CheckboxRippleRadius, 0L, 4, null), z7, Role.m8825boximpl(Role.INSTANCE.m8834getCheckboxo7Vup1c()), function0);
                        z5 = z7;
                    } else {
                        companionM1546triStateToggleableO2vRcR0 = Modifier.INSTANCE;
                    }
                    if (function0 != null) {
                        companionMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE);
                    } else {
                        companionMinimumInteractiveComponentSize = Modifier.INSTANCE;
                    }
                    CheckboxColors checkboxColors4 = checkboxColorsM2314colorszjMxDiM;
                    CheckboxImpl(z5, toggleableState, PaddingKt.m1218padding3ABfNKs(companion.then(companionMinimumInteractiveComponentSize).then(companionM1546triStateToggleableO2vRcR0), CheckboxDefaultPadding), checkboxColors4, composer2, ((i8 >> 9) & 14) | ((i8 << 3) & 112) | ((i8 >> 6) & 7168));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    checkboxColors2 = checkboxColors4;
                    modifier3 = companion;
                    z4 = z5;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    z4 = z2;
                    checkboxColors2 = checkboxColorsM2314colorszjMxDiM;
                }
                mutableInteractionSource3 = mutableInteractionSource2;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.CheckboxKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CheckboxKt.TriStateCheckbox$lambda$0(toggleableState, function0, modifier3, z4, mutableInteractionSource3, checkboxColors2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            z2 = z;
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
                        checkboxColorsM2314colorszjMxDiM = checkboxColors;
                        if (composerStartRestartGroup.changed(checkboxColorsM2314colorszjMxDiM)) {
                        }
                        i3 |= i10;
                    } else {
                        checkboxColorsM2314colorszjMxDiM = checkboxColors;
                    }
                    i3 |= i10;
                } else {
                    checkboxColorsM2314colorszjMxDiM = checkboxColors;
                }
                if ((74899 & i3) != 74898) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "137@6355L8");
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        if ((i2 & 32) != 0) {
                            composer2 = composerStartRestartGroup;
                            i8 = i3 & (-458753);
                            checkboxColorsM2314colorszjMxDiM = CheckboxDefaults.INSTANCE.m2314colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            composer2 = composerStartRestartGroup;
                            i8 = i3;
                        }
                        mutableInteractionSource2 = mutableInteractionSource4;
                    } else {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        if ((i2 & 32) != 0) {
                            composer2 = composerStartRestartGroup;
                            i8 = i3 & (-458753);
                            checkboxColorsM2314colorszjMxDiM = CheckboxDefaults.INSTANCE.m2314colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            composer2 = composerStartRestartGroup;
                            i8 = i3;
                        }
                        mutableInteractionSource2 = mutableInteractionSource4;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2031255194, i8, -1, "androidx.compose.material.TriStateCheckbox (Checkbox.kt:138)");
                    }
                    if (function0 != null) {
                        boolean z8 = z5;
                        companionM1546triStateToggleableO2vRcR0 = ToggleableKt.m1546triStateToggleableO2vRcR0(Modifier.INSTANCE, toggleableState, mutableInteractionSource2, RippleKt.m2523rippleH2RKhps$default(false, CheckboxRippleRadius, 0L, 4, null), z8, Role.m8825boximpl(Role.INSTANCE.m8834getCheckboxo7Vup1c()), function0);
                        z5 = z8;
                    } else {
                        companionM1546triStateToggleableO2vRcR0 = Modifier.INSTANCE;
                    }
                    if (function0 != null) {
                        companionMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE);
                    } else {
                        companionMinimumInteractiveComponentSize = Modifier.INSTANCE;
                    }
                    CheckboxColors checkboxColors5 = checkboxColorsM2314colorszjMxDiM;
                    CheckboxImpl(z5, toggleableState, PaddingKt.m1218padding3ABfNKs(companion.then(companionMinimumInteractiveComponentSize).then(companionM1546triStateToggleableO2vRcR0), CheckboxDefaultPadding), checkboxColors5, composer2, ((i8 >> 9) & 14) | ((i8 << 3) & 112) | ((i8 >> 6) & 7168));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    checkboxColors2 = checkboxColors5;
                    modifier3 = companion;
                    z4 = z5;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    z4 = z2;
                    checkboxColors2 = checkboxColorsM2314colorszjMxDiM;
                }
                mutableInteractionSource3 = mutableInteractionSource2;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.CheckboxKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CheckboxKt.TriStateCheckbox$lambda$0(toggleableState, function0, modifier3, z4, mutableInteractionSource3, checkboxColors2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    checkboxColorsM2314colorszjMxDiM = checkboxColors;
                    if (composerStartRestartGroup.changed(checkboxColorsM2314colorszjMxDiM)) {
                    }
                    i3 |= i10;
                } else {
                    checkboxColorsM2314colorszjMxDiM = checkboxColors;
                }
                i3 |= i10;
            } else {
                checkboxColorsM2314colorszjMxDiM = checkboxColors;
            }
            if ((74899 & i3) != 74898) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "137@6355L8");
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    if ((i2 & 32) != 0) {
                        composer2 = composerStartRestartGroup;
                        i8 = i3 & (-458753);
                        checkboxColorsM2314colorszjMxDiM = CheckboxDefaults.INSTANCE.m2314colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    } else {
                        composer2 = composerStartRestartGroup;
                        i8 = i3;
                    }
                    mutableInteractionSource2 = mutableInteractionSource4;
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    if ((i2 & 32) != 0) {
                        composer2 = composerStartRestartGroup;
                        i8 = i3 & (-458753);
                        checkboxColorsM2314colorszjMxDiM = CheckboxDefaults.INSTANCE.m2314colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    } else {
                        composer2 = composerStartRestartGroup;
                        i8 = i3;
                    }
                    mutableInteractionSource2 = mutableInteractionSource4;
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2031255194, i8, -1, "androidx.compose.material.TriStateCheckbox (Checkbox.kt:138)");
                }
                if (function0 != null) {
                    boolean z9 = z5;
                    companionM1546triStateToggleableO2vRcR0 = ToggleableKt.m1546triStateToggleableO2vRcR0(Modifier.INSTANCE, toggleableState, mutableInteractionSource2, RippleKt.m2523rippleH2RKhps$default(false, CheckboxRippleRadius, 0L, 4, null), z9, Role.m8825boximpl(Role.INSTANCE.m8834getCheckboxo7Vup1c()), function0);
                    z5 = z9;
                } else {
                    companionM1546triStateToggleableO2vRcR0 = Modifier.INSTANCE;
                }
                if (function0 != null) {
                    companionMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE);
                } else {
                    companionMinimumInteractiveComponentSize = Modifier.INSTANCE;
                }
                CheckboxColors checkboxColors6 = checkboxColorsM2314colorszjMxDiM;
                CheckboxImpl(z5, toggleableState, PaddingKt.m1218padding3ABfNKs(companion.then(companionMinimumInteractiveComponentSize).then(companionM1546triStateToggleableO2vRcR0), CheckboxDefaultPadding), checkboxColors6, composer2, ((i8 >> 9) & 14) | ((i8 << 3) & 112) | ((i8 >> 6) & 7168));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                checkboxColors2 = checkboxColors6;
                modifier3 = companion;
                z4 = z5;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                z4 = z2;
                checkboxColors2 = checkboxColorsM2314colorszjMxDiM;
            }
            mutableInteractionSource3 = mutableInteractionSource2;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.CheckboxKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CheckboxKt.TriStateCheckbox$lambda$0(toggleableState, function0, modifier3, z4, mutableInteractionSource3, checkboxColors2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
                        checkboxColorsM2314colorszjMxDiM = checkboxColors;
                        if (composerStartRestartGroup.changed(checkboxColorsM2314colorszjMxDiM)) {
                        }
                        i3 |= i10;
                    } else {
                        checkboxColorsM2314colorszjMxDiM = checkboxColors;
                    }
                    i3 |= i10;
                } else {
                    checkboxColorsM2314colorszjMxDiM = checkboxColors;
                }
                if ((74899 & i3) != 74898) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "137@6355L8");
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        if ((i2 & 32) != 0) {
                            composer2 = composerStartRestartGroup;
                            i8 = i3 & (-458753);
                            checkboxColorsM2314colorszjMxDiM = CheckboxDefaults.INSTANCE.m2314colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            composer2 = composerStartRestartGroup;
                            i8 = i3;
                        }
                        mutableInteractionSource2 = mutableInteractionSource4;
                    } else {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        if ((i2 & 32) != 0) {
                            composer2 = composerStartRestartGroup;
                            i8 = i3 & (-458753);
                            checkboxColorsM2314colorszjMxDiM = CheckboxDefaults.INSTANCE.m2314colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            composer2 = composerStartRestartGroup;
                            i8 = i3;
                        }
                        mutableInteractionSource2 = mutableInteractionSource4;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2031255194, i8, -1, "androidx.compose.material.TriStateCheckbox (Checkbox.kt:138)");
                    }
                    if (function0 != null) {
                        boolean z10 = z5;
                        companionM1546triStateToggleableO2vRcR0 = ToggleableKt.m1546triStateToggleableO2vRcR0(Modifier.INSTANCE, toggleableState, mutableInteractionSource2, RippleKt.m2523rippleH2RKhps$default(false, CheckboxRippleRadius, 0L, 4, null), z10, Role.m8825boximpl(Role.INSTANCE.m8834getCheckboxo7Vup1c()), function0);
                        z5 = z10;
                    } else {
                        companionM1546triStateToggleableO2vRcR0 = Modifier.INSTANCE;
                    }
                    if (function0 != null) {
                        companionMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE);
                    } else {
                        companionMinimumInteractiveComponentSize = Modifier.INSTANCE;
                    }
                    CheckboxColors checkboxColors7 = checkboxColorsM2314colorszjMxDiM;
                    CheckboxImpl(z5, toggleableState, PaddingKt.m1218padding3ABfNKs(companion.then(companionMinimumInteractiveComponentSize).then(companionM1546triStateToggleableO2vRcR0), CheckboxDefaultPadding), checkboxColors7, composer2, ((i8 >> 9) & 14) | ((i8 << 3) & 112) | ((i8 >> 6) & 7168));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    checkboxColors2 = checkboxColors7;
                    modifier3 = companion;
                    z4 = z5;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    z4 = z2;
                    checkboxColors2 = checkboxColorsM2314colorszjMxDiM;
                }
                mutableInteractionSource3 = mutableInteractionSource2;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.CheckboxKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CheckboxKt.TriStateCheckbox$lambda$0(toggleableState, function0, modifier3, z4, mutableInteractionSource3, checkboxColors2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    checkboxColorsM2314colorszjMxDiM = checkboxColors;
                    if (composerStartRestartGroup.changed(checkboxColorsM2314colorszjMxDiM)) {
                    }
                    i3 |= i10;
                } else {
                    checkboxColorsM2314colorszjMxDiM = checkboxColors;
                }
                i3 |= i10;
            } else {
                checkboxColorsM2314colorszjMxDiM = checkboxColors;
            }
            if ((74899 & i3) != 74898) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "137@6355L8");
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    if ((i2 & 32) != 0) {
                        composer2 = composerStartRestartGroup;
                        i8 = i3 & (-458753);
                        checkboxColorsM2314colorszjMxDiM = CheckboxDefaults.INSTANCE.m2314colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    } else {
                        composer2 = composerStartRestartGroup;
                        i8 = i3;
                    }
                    mutableInteractionSource2 = mutableInteractionSource4;
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    if ((i2 & 32) != 0) {
                        composer2 = composerStartRestartGroup;
                        i8 = i3 & (-458753);
                        checkboxColorsM2314colorszjMxDiM = CheckboxDefaults.INSTANCE.m2314colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    } else {
                        composer2 = composerStartRestartGroup;
                        i8 = i3;
                    }
                    mutableInteractionSource2 = mutableInteractionSource4;
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2031255194, i8, -1, "androidx.compose.material.TriStateCheckbox (Checkbox.kt:138)");
                }
                if (function0 != null) {
                    boolean z11 = z5;
                    companionM1546triStateToggleableO2vRcR0 = ToggleableKt.m1546triStateToggleableO2vRcR0(Modifier.INSTANCE, toggleableState, mutableInteractionSource2, RippleKt.m2523rippleH2RKhps$default(false, CheckboxRippleRadius, 0L, 4, null), z11, Role.m8825boximpl(Role.INSTANCE.m8834getCheckboxo7Vup1c()), function0);
                    z5 = z11;
                } else {
                    companionM1546triStateToggleableO2vRcR0 = Modifier.INSTANCE;
                }
                if (function0 != null) {
                    companionMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE);
                } else {
                    companionMinimumInteractiveComponentSize = Modifier.INSTANCE;
                }
                CheckboxColors checkboxColors8 = checkboxColorsM2314colorszjMxDiM;
                CheckboxImpl(z5, toggleableState, PaddingKt.m1218padding3ABfNKs(companion.then(companionMinimumInteractiveComponentSize).then(companionM1546triStateToggleableO2vRcR0), CheckboxDefaultPadding), checkboxColors8, composer2, ((i8 >> 9) & 14) | ((i8 << 3) & 112) | ((i8 >> 6) & 7168));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                checkboxColors2 = checkboxColors8;
                modifier3 = companion;
                z4 = z5;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                z4 = z2;
                checkboxColors2 = checkboxColorsM2314colorszjMxDiM;
            }
            mutableInteractionSource3 = mutableInteractionSource2;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.CheckboxKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CheckboxKt.TriStateCheckbox$lambda$0(toggleableState, function0, modifier3, z4, mutableInteractionSource3, checkboxColors2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        z2 = z;
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
                    checkboxColorsM2314colorszjMxDiM = checkboxColors;
                    if (composerStartRestartGroup.changed(checkboxColorsM2314colorszjMxDiM)) {
                    }
                    i3 |= i10;
                } else {
                    checkboxColorsM2314colorszjMxDiM = checkboxColors;
                }
                i3 |= i10;
            } else {
                checkboxColorsM2314colorszjMxDiM = checkboxColors;
            }
            if ((74899 & i3) != 74898) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "137@6355L8");
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    if ((i2 & 32) != 0) {
                        composer2 = composerStartRestartGroup;
                        i8 = i3 & (-458753);
                        checkboxColorsM2314colorszjMxDiM = CheckboxDefaults.INSTANCE.m2314colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    } else {
                        composer2 = composerStartRestartGroup;
                        i8 = i3;
                    }
                    mutableInteractionSource2 = mutableInteractionSource4;
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    if ((i2 & 32) != 0) {
                        composer2 = composerStartRestartGroup;
                        i8 = i3 & (-458753);
                        checkboxColorsM2314colorszjMxDiM = CheckboxDefaults.INSTANCE.m2314colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    } else {
                        composer2 = composerStartRestartGroup;
                        i8 = i3;
                    }
                    mutableInteractionSource2 = mutableInteractionSource4;
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2031255194, i8, -1, "androidx.compose.material.TriStateCheckbox (Checkbox.kt:138)");
                }
                if (function0 != null) {
                    boolean z12 = z5;
                    companionM1546triStateToggleableO2vRcR0 = ToggleableKt.m1546triStateToggleableO2vRcR0(Modifier.INSTANCE, toggleableState, mutableInteractionSource2, RippleKt.m2523rippleH2RKhps$default(false, CheckboxRippleRadius, 0L, 4, null), z12, Role.m8825boximpl(Role.INSTANCE.m8834getCheckboxo7Vup1c()), function0);
                    z5 = z12;
                } else {
                    companionM1546triStateToggleableO2vRcR0 = Modifier.INSTANCE;
                }
                if (function0 != null) {
                    companionMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE);
                } else {
                    companionMinimumInteractiveComponentSize = Modifier.INSTANCE;
                }
                CheckboxColors checkboxColors9 = checkboxColorsM2314colorszjMxDiM;
                CheckboxImpl(z5, toggleableState, PaddingKt.m1218padding3ABfNKs(companion.then(companionMinimumInteractiveComponentSize).then(companionM1546triStateToggleableO2vRcR0), CheckboxDefaultPadding), checkboxColors9, composer2, ((i8 >> 9) & 14) | ((i8 << 3) & 112) | ((i8 >> 6) & 7168));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                checkboxColors2 = checkboxColors9;
                modifier3 = companion;
                z4 = z5;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                z4 = z2;
                checkboxColors2 = checkboxColorsM2314colorszjMxDiM;
            }
            mutableInteractionSource3 = mutableInteractionSource2;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.CheckboxKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CheckboxKt.TriStateCheckbox$lambda$0(toggleableState, function0, modifier3, z4, mutableInteractionSource3, checkboxColors2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        mutableInteractionSource2 = mutableInteractionSource;
        if ((196608 & i) == 0) {
            if ((i2 & 32) == 0) {
                checkboxColorsM2314colorszjMxDiM = checkboxColors;
                if (composerStartRestartGroup.changed(checkboxColorsM2314colorszjMxDiM)) {
                }
                i3 |= i10;
            } else {
                checkboxColorsM2314colorszjMxDiM = checkboxColors;
            }
            i3 |= i10;
        } else {
            checkboxColorsM2314colorszjMxDiM = checkboxColors;
        }
        if ((74899 & i3) != 74898) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "137@6355L8");
            if ((i & 1) != 0) {
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                if (i6 != 0) {
                    mutableInteractionSource4 = null;
                } else {
                    mutableInteractionSource4 = mutableInteractionSource2;
                }
                if ((i2 & 32) != 0) {
                    composer2 = composerStartRestartGroup;
                    i8 = i3 & (-458753);
                    checkboxColorsM2314colorszjMxDiM = CheckboxDefaults.INSTANCE.m2314colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                } else {
                    composer2 = composerStartRestartGroup;
                    i8 = i3;
                }
                mutableInteractionSource2 = mutableInteractionSource4;
            } else {
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                if (i6 != 0) {
                    mutableInteractionSource4 = null;
                } else {
                    mutableInteractionSource4 = mutableInteractionSource2;
                }
                if ((i2 & 32) != 0) {
                    composer2 = composerStartRestartGroup;
                    i8 = i3 & (-458753);
                    checkboxColorsM2314colorszjMxDiM = CheckboxDefaults.INSTANCE.m2314colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                } else {
                    composer2 = composerStartRestartGroup;
                    i8 = i3;
                }
                mutableInteractionSource2 = mutableInteractionSource4;
            }
            composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2031255194, i8, -1, "androidx.compose.material.TriStateCheckbox (Checkbox.kt:138)");
            }
            if (function0 != null) {
                boolean z13 = z5;
                companionM1546triStateToggleableO2vRcR0 = ToggleableKt.m1546triStateToggleableO2vRcR0(Modifier.INSTANCE, toggleableState, mutableInteractionSource2, RippleKt.m2523rippleH2RKhps$default(false, CheckboxRippleRadius, 0L, 4, null), z13, Role.m8825boximpl(Role.INSTANCE.m8834getCheckboxo7Vup1c()), function0);
                z5 = z13;
            } else {
                companionM1546triStateToggleableO2vRcR0 = Modifier.INSTANCE;
            }
            if (function0 != null) {
                companionMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE);
            } else {
                companionMinimumInteractiveComponentSize = Modifier.INSTANCE;
            }
            CheckboxColors checkboxColors10 = checkboxColorsM2314colorszjMxDiM;
            CheckboxImpl(z5, toggleableState, PaddingKt.m1218padding3ABfNKs(companion.then(companionMinimumInteractiveComponentSize).then(companionM1546triStateToggleableO2vRcR0), CheckboxDefaultPadding), checkboxColors10, composer2, ((i8 >> 9) & 14) | ((i8 << 3) & 112) | ((i8 >> 6) & 7168));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            checkboxColors2 = checkboxColors10;
            modifier3 = companion;
            z4 = z5;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            z4 = z2;
            checkboxColors2 = checkboxColorsM2314colorszjMxDiM;
        }
        mutableInteractionSource3 = mutableInteractionSource2;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.CheckboxKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CheckboxKt.TriStateCheckbox$lambda$0(toggleableState, function0, modifier3, z4, mutableInteractionSource3, checkboxColors2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:101:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:105:0x020a  */
    /* JADX WARN: Code duplicated, block: B:108:0x0246  */
    /* JADX WARN: Code duplicated, block: B:113:0x02ba  */
    /* JADX WARN: Code duplicated, block: B:116:0x02dc  */
    /* JADX WARN: Code duplicated, block: B:75:0x0140  */
    /* JADX WARN: Code duplicated, block: B:78:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:88:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:91:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:94:0x01e9  */
    private static final void CheckboxImpl(boolean z, final ToggleableState toggleableState, Modifier modifier, final CheckboxColors checkboxColors, Composer composer, final int i) {
        int i2;
        boolean z2;
        Modifier modifier2;
        float f;
        float f2;
        final State stateCreateTransitionAnimation;
        int i3;
        int i4;
        float f3;
        int i5;
        final State stateCreateTransitionAnimation2;
        Object objRememberedValue;
        final CheckDrawingCache checkDrawingCache;
        final State<Color> stateCheckmarkColor;
        final State<Color> stateBoxColor;
        final State<Color> stateBorderColor;
        boolean zChanged;
        Object objRememberedValue2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2118895727);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CheckboxImpl)N(enabled,value,modifier,colors)257@10849L23,259@10921L499,276@11488L514,291@12024L32,292@12086L21,293@12135L24,294@12190L27,295@12300L510,295@12222L588:Checkbox.kt#jmzs0o");
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
        int i6 = i2;
        if (!composerStartRestartGroup.shouldExecute((i6 & 1171) != 1170, i6 & 1)) {
            z2 = z;
            modifier2 = modifier;
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2118895727, i6, -1, "androidx.compose.material.CheckboxImpl (Checkbox.kt:256)");
            }
            int i7 = i6 >> 3;
            int i8 = i7 & 14;
            Transition transitionUpdateTransition = TransitionKt.updateTransition(toggleableState, (String) null, composerStartRestartGroup, i8, 2);
            Function3 function3 = new Function3() { // from class: androidx.compose.material.CheckboxKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return CheckboxKt.CheckboxImpl$lambda$0((Transition.Segment) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1338768149, "CC(animateFloat)P(2)1924@81822L78:Transition.kt#pdpnli");
            TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
            ToggleableState toggleableState2 = (ToggleableState) transitionUpdateTransition.getCurrentState();
            composerStartRestartGroup.startReplaceGroup(-1798345588);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):Checkbox.kt#jmzs0o");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1798345588, 0, -1, "androidx.compose.material.CheckboxImpl.<anonymous> (Checkbox.kt:268)");
            }
            int i9 = WhenMappings.$EnumSwitchMapping$0[toggleableState2.ordinal()];
            float f4 = 0.0f;
            if (i9 == 1) {
                f = 1.0f;
            } else if (i9 != 2) {
                if (i9 != 3) {
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
            composerStartRestartGroup.startReplaceGroup(-1798345588);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):Checkbox.kt#jmzs0o");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1798345588, 0, -1, "androidx.compose.material.CheckboxImpl.<anonymous> (Checkbox.kt:268)");
            }
            int i10 = WhenMappings.$EnumSwitchMapping$0[toggleableState3.ordinal()];
            if (i10 != 1) {
                if (i10 == 2) {
                    f2 = 0.0f;
                } else if (i10 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composerStartRestartGroup.endReplaceGroup();
                stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf, Float.valueOf(f2), (FiniteAnimationSpec) function3.invoke(transitionUpdateTransition.getSegment(), composerStartRestartGroup, 0), vectorConverter, "FloatAnimation", composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Function3 function4 = new Function3() { // from class: androidx.compose.material.CheckboxKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return CheckboxKt.CheckboxImpl$lambda$3((Transition.Segment) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                };
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1338768149, "CC(animateFloat)P(2)1924@81822L78:Transition.kt#pdpnli");
                TwoWayConverter<Float, AnimationVector1D> vectorConverter2 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
                ToggleableState toggleableState4 = (ToggleableState) transitionUpdateTransition.getCurrentState();
                composerStartRestartGroup.startReplaceGroup(-2098942571);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):Checkbox.kt#jmzs0o");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2098942571, 0, -1, "androidx.compose.material.CheckboxImpl.<anonymous> (Checkbox.kt:285)");
                }
                i3 = WhenMappings.$EnumSwitchMapping$0[toggleableState4.ordinal()];
                if (i3 != 1 || i3 == 2) {
                    i4 = 3;
                    f3 = 0.0f;
                } else {
                    i4 = 3;
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
                composerStartRestartGroup.startReplaceGroup(-2098942571);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):Checkbox.kt#jmzs0o");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2098942571, 0, -1, "androidx.compose.material.CheckboxImpl.<anonymous> (Checkbox.kt:285)");
                }
                i5 = WhenMappings.$EnumSwitchMapping$0[toggleableState5.ordinal()];
                if (i5 != 1 && i5 != 2) {
                    if (i5 == i4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    f4 = 1.0f;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composerStartRestartGroup.endReplaceGroup();
                stateCreateTransitionAnimation2 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf2, Float.valueOf(f4), (FiniteAnimationSpec) function4.invoke(transitionUpdateTransition.getSegment(), composerStartRestartGroup, 0), vectorConverter2, "FloatAnimation", composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -444253071, "CC(remember):Checkbox.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new CheckDrawingCache(null, null, null, 7, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                checkDrawingCache = (CheckDrawingCache) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                stateCheckmarkColor = checkboxColors.checkmarkColor(toggleableState, composerStartRestartGroup, i8 | ((i6 >> 6) & 112));
                int i11 = (i7 & 896) | (i6 & 126);
                z2 = z;
                stateBoxColor = checkboxColors.boxColor(z2, toggleableState, composerStartRestartGroup, i11);
                stateBorderColor = checkboxColors.borderColor(z2, toggleableState, composerStartRestartGroup, i11);
                modifier2 = modifier;
                Modifier modifierM1258requiredSize3ABfNKs = SizeKt.m1258requiredSize3ABfNKs(SizeKt.wrapContentSize$default(modifier2, Alignment.INSTANCE.getCenter(), false, 2, null), CheckboxSize);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -444243761, "CC(remember):Checkbox.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(stateBoxColor) | composerStartRestartGroup.changed(stateBorderColor) | composerStartRestartGroup.changed(stateCheckmarkColor) | composerStartRestartGroup.changed(stateCreateTransitionAnimation) | composerStartRestartGroup.changed(stateCreateTransitionAnimation2);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: androidx.compose.material.CheckboxKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CheckboxKt.CheckboxImpl$lambda$10$0(checkDrawingCache, stateBoxColor, stateBorderColor, stateCheckmarkColor, stateCreateTransitionAnimation, stateCreateTransitionAnimation2, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                CanvasKt.Canvas(modifierM1258requiredSize3ABfNKs, (Function1) objRememberedValue2, composerStartRestartGroup, 0);
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
            Function3 function5 = new Function3() { // from class: androidx.compose.material.CheckboxKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return CheckboxKt.CheckboxImpl$lambda$3((Transition.Segment) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1338768149, "CC(animateFloat)P(2)1924@81822L78:Transition.kt#pdpnli");
            TwoWayConverter<Float, AnimationVector1D> vectorConverter3 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
            ToggleableState toggleableState6 = (ToggleableState) transitionUpdateTransition.getCurrentState();
            composerStartRestartGroup.startReplaceGroup(-2098942571);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):Checkbox.kt#jmzs0o");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2098942571, 0, -1, "androidx.compose.material.CheckboxImpl.<anonymous> (Checkbox.kt:285)");
            }
            i3 = WhenMappings.$EnumSwitchMapping$0[toggleableState6.ordinal()];
            if (i3 != 1) {
                i4 = 3;
                f3 = 0.0f;
            } else {
                i4 = 3;
                f3 = 0.0f;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceGroup();
            Float fValueOf3 = Float.valueOf(f3);
            ToggleableState toggleableState7 = (ToggleableState) transitionUpdateTransition.getTargetState();
            composerStartRestartGroup.startReplaceGroup(-2098942571);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):Checkbox.kt#jmzs0o");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2098942571, 0, -1, "androidx.compose.material.CheckboxImpl.<anonymous> (Checkbox.kt:285)");
            }
            i5 = WhenMappings.$EnumSwitchMapping$0[toggleableState7.ordinal()];
            if (i5 != 1) {
                if (i5 == i4) {
                    throw new NoWhenBranchMatchedException();
                }
                f4 = 1.0f;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceGroup();
            stateCreateTransitionAnimation2 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf3, Float.valueOf(f4), (FiniteAnimationSpec) function5.invoke(transitionUpdateTransition.getSegment(), composerStartRestartGroup, 0), vectorConverter3, "FloatAnimation", composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -444253071, "CC(remember):Checkbox.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new CheckDrawingCache(null, null, null, 7, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            checkDrawingCache = (CheckDrawingCache) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            stateCheckmarkColor = checkboxColors.checkmarkColor(toggleableState, composerStartRestartGroup, i8 | ((i6 >> 6) & 112));
            int i12 = (i7 & 896) | (i6 & 126);
            z2 = z;
            stateBoxColor = checkboxColors.boxColor(z2, toggleableState, composerStartRestartGroup, i12);
            stateBorderColor = checkboxColors.borderColor(z2, toggleableState, composerStartRestartGroup, i12);
            modifier2 = modifier;
            Modifier modifierM1258requiredSize3ABfNKs2 = SizeKt.m1258requiredSize3ABfNKs(SizeKt.wrapContentSize$default(modifier2, Alignment.INSTANCE.getCenter(), false, 2, null), CheckboxSize);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -444243761, "CC(remember):Checkbox.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(stateBoxColor) | composerStartRestartGroup.changed(stateBorderColor) | composerStartRestartGroup.changed(stateCheckmarkColor) | composerStartRestartGroup.changed(stateCreateTransitionAnimation) | composerStartRestartGroup.changed(stateCreateTransitionAnimation2);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue2 = new Function1() { // from class: androidx.compose.material.CheckboxKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CheckboxKt.CheckboxImpl$lambda$10$0(checkDrawingCache, stateBoxColor, stateBorderColor, stateCheckmarkColor, stateCreateTransitionAnimation, stateCreateTransitionAnimation2, (DrawScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new Function1() { // from class: androidx.compose.material.CheckboxKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CheckboxKt.CheckboxImpl$lambda$10$0(checkDrawingCache, stateBoxColor, stateBorderColor, stateCheckmarkColor, stateCreateTransitionAnimation, stateCreateTransitionAnimation2, (DrawScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            CanvasKt.Canvas(modifierM1258requiredSize3ABfNKs2, (Function1) objRememberedValue2, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final boolean z3 = z2;
            final Modifier modifier3 = modifier2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.CheckboxKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CheckboxKt.CheckboxImpl$lambda$11(z3, toggleableState, modifier3, checkboxColors, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FiniteAnimationSpec CheckboxImpl$lambda$0(Transition.Segment segment, Composer composer, int i) {
        SpringSpec springSpecSnap;
        composer.startReplaceGroup(-1707702900);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1707702900, i, -1, "androidx.compose.material.CheckboxImpl.<anonymous> (Checkbox.kt:261)");
        }
        if (segment.getInitialState() == ToggleableState.Off) {
            springSpecSnap = AnimationSpecKt.tween$default(100, 0, null, 6, null);
        } else {
            springSpecSnap = segment.getTargetState() == ToggleableState.Off ? AnimationSpecKt.snap(100) : AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return springSpecSnap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FiniteAnimationSpec CheckboxImpl$lambda$3(Transition.Segment segment, Composer composer, int i) {
        TweenSpec tweenSpecSnap;
        composer.startReplaceGroup(1075283605);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1075283605, i, -1, "androidx.compose.material.CheckboxImpl.<anonymous> (Checkbox.kt:278)");
        }
        if (segment.getInitialState() == ToggleableState.Off) {
            tweenSpecSnap = AnimationSpecKt.snap$default(0, 1, null);
        } else {
            tweenSpecSnap = segment.getTargetState() == ToggleableState.Off ? AnimationSpecKt.snap(100) : AnimationSpecKt.tween$default(100, 0, null, 6, null);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return tweenSpecSnap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CheckboxImpl$lambda$10$0(CheckDrawingCache checkDrawingCache, State state, State state2, State state3, State state4, State state5, DrawScope drawScope) {
        float fFloor = (float) Math.floor(drawScope.mo754toPx0680j_4(StrokeWidth));
        m2317drawBox1wkBAMs(drawScope, CheckboxImpl$lambda$8(state), CheckboxImpl$lambda$9(state2), drawScope.mo754toPx0680j_4(RadiusSize), fFloor);
        m2318drawCheck3IgeMak(drawScope, CheckboxImpl$lambda$7(state3), CheckboxImpl$lambda$2(state4), CheckboxImpl$lambda$5(state5), fFloor, checkDrawingCache);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: drawBox-1wkBAMs, reason: not valid java name */
    private static final void m2317drawBox1wkBAMs(DrawScope drawScope, long j, long j2, float f, float f2) {
        float f3 = f2 / 2.0f;
        Stroke stroke = new Stroke(f2, 0.0f, 0, 0, null, 30, null);
        float fIntBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo7395getSizeNHjbRc() >> 32));
        if (Color.m6815equalsimpl0(j, j2)) {
            DrawScope.m7391drawRoundRectuAw5IA$default(drawScope, j, 0L, Size.m6629constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat)) & 4294967295L)), CornerRadius.m6523constructorimpl((((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(f)) & 4294967295L)), Fill.INSTANCE, 0.0f, null, 0, 226, null);
            return;
        }
        long jM6561constructorimpl = Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(f2)) << 32) | (((long) Float.floatToRawIntBits(f2)) & 4294967295L));
        float f4 = fIntBitsToFloat - (2 * f2);
        long jM6629constructorimpl = Size.m6629constructorimpl((((long) Float.floatToRawIntBits(f4)) << 32) | (((long) Float.floatToRawIntBits(f4)) & 4294967295L));
        float fMax = Math.max(0.0f, f - f2);
        DrawScope.m7391drawRoundRectuAw5IA$default(drawScope, j, jM6561constructorimpl, jM6629constructorimpl, CornerRadius.m6523constructorimpl((((long) Float.floatToRawIntBits(fMax)) << 32) | (((long) Float.floatToRawIntBits(fMax)) & 4294967295L)), Fill.INSTANCE, 0.0f, null, 0, 224, null);
        float f5 = fIntBitsToFloat - f2;
        float f6 = f - f3;
        DrawScope.m7391drawRoundRectuAw5IA$default(drawScope, j2, Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(f3)) << 32) | (((long) Float.floatToRawIntBits(f3)) & 4294967295L)), Size.m6629constructorimpl((((long) Float.floatToRawIntBits(f5)) & 4294967295L) | (Float.floatToRawIntBits(f5) << 32)), CornerRadius.m6523constructorimpl((((long) Float.floatToRawIntBits(f6)) << 32) | (((long) Float.floatToRawIntBits(f6)) & 4294967295L)), stroke, 0.0f, null, 0, 224, null);
    }

    /* JADX INFO: renamed from: drawCheck-3IgeMak, reason: not valid java name */
    private static final void m2318drawCheck3IgeMak(DrawScope drawScope, long j, float f, float f2, float f3, CheckDrawingCache checkDrawingCache) {
        Stroke stroke = new Stroke(f3, 0.0f, StrokeCap.INSTANCE.m7192getSquareKaPHkGw(), 0, null, 26, null);
        float fIntBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo7395getSizeNHjbRc() >> 32));
        float fLerp = MathHelpersKt.lerp(0.4f, 0.5f, f2);
        float fLerp2 = MathHelpersKt.lerp(0.7f, 0.5f, f2);
        float fLerp3 = MathHelpersKt.lerp(0.5f, 0.5f, f2);
        float fLerp4 = MathHelpersKt.lerp(0.3f, 0.5f, f2);
        checkDrawingCache.getCheckPath().reset();
        checkDrawingCache.getCheckPath().moveTo(0.2f * fIntBitsToFloat, fLerp3 * fIntBitsToFloat);
        checkDrawingCache.getCheckPath().lineTo(fLerp * fIntBitsToFloat, fLerp2 * fIntBitsToFloat);
        checkDrawingCache.getCheckPath().lineTo(0.8f * fIntBitsToFloat, fIntBitsToFloat * fLerp4);
        checkDrawingCache.getPathMeasure().setPath(checkDrawingCache.getCheckPath(), false);
        checkDrawingCache.getPathToDraw().reset();
        checkDrawingCache.getPathMeasure().getSegment(0.0f, checkDrawingCache.getPathMeasure().getLength() * f, checkDrawingCache.getPathToDraw(), true);
        DrawScope.m7385drawPathLG529CI$default(drawScope, checkDrawingCache.getPathToDraw(), j, 0.0f, stroke, null, 0, 52, null);
    }

    private static final float CheckboxImpl$lambda$2(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float CheckboxImpl$lambda$5(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final long CheckboxImpl$lambda$7(State<Color> state) {
        return state.getValue().m6824unboximpl();
    }

    private static final long CheckboxImpl$lambda$8(State<Color> state) {
        return state.getValue().m6824unboximpl();
    }

    private static final long CheckboxImpl$lambda$9(State<Color> state) {
        return state.getValue().m6824unboximpl();
    }

    static {
        float f = 2;
        CheckboxDefaultPadding = Dp.m9687constructorimpl(f);
        StrokeWidth = Dp.m9687constructorimpl(f);
        RadiusSize = Dp.m9687constructorimpl(f);
    }
}
