package androidx.compose.material;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.window.core.layout.WindowSizeClass;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: Switch.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\u001aU\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\r\u001a?\u0010\u000e\u001a\u00020\u0001*\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\t\u001a\u00020\u0013H\u0003¢\u0006\u0002\u0010\u0014\u001a+\u0010\u0015\u001a\u00020\u0001*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001b\u0010\u001c\"\u0016\u0010\u001d\u001a\u00020\u001eX\u0080\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 \"\u0016\u0010\"\u001a\u00020\u001eX\u0080\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b#\u0010 \"\u0016\u0010$\u001a\u00020\u001eX\u0080\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b%\u0010 \"\u0010\u0010&\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010!\"\u0010\u0010'\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010!\"\u0010\u0010(\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010!\"\u0010\u0010)\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010!\"\u0010\u0010*\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010!\"\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00120,X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010-\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010!\"\u0010\u0010.\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010!\"\u000e\u0010/\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u00100\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010!¨\u00061²\u0006\n\u00102\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\u0018\u00103\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005X\u008a\u0084\u0002²\u0006\n\u00104\u001a\u00020\u0003X\u008a\u0084\u0002²\u0006\n\u0010\u0017\u001a\u00020\u0018X\u008a\u0084\u0002²\u0006\n\u00105\u001a\u00020\u0018X\u008a\u0084\u0002²\u0006\n\u00106\u001a\u00020\u0018X\u008a\u0084\u0002"}, d2 = {"Switch", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "colors", "Landroidx/compose/material/SwitchColors;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/SwitchColors;Landroidx/compose/runtime/Composer;II)V", "SwitchImpl", "Landroidx/compose/foundation/layout/BoxScope;", "thumbValue", "Lkotlin/Function0;", "", "Landroidx/compose/foundation/interaction/InteractionSource;", "(Landroidx/compose/foundation/layout/BoxScope;ZZLandroidx/compose/material/SwitchColors;Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)V", "drawTrack", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "trackColor", "Landroidx/compose/ui/graphics/Color;", "trackWidth", "strokeWidth", "drawTrack-RPmYEkk", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFF)V", "TrackWidth", "Landroidx/compose/ui/unit/Dp;", "getTrackWidth", "()F", "F", "TrackStrokeWidth", "getTrackStrokeWidth", "ThumbDiameter", "getThumbDiameter", "ThumbRippleRadius", "DefaultSwitchPadding", "SwitchWidth", "SwitchHeight", "ThumbPathLength", "AnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "ThumbDefaultElevation", "ThumbPressedElevation", "SwitchPositionalThreshold", "SwitchVelocityThreshold", "material", "forceAnimationCheck", "currentOnCheckedChange", "currentChecked", "thumbColor", "resolvedThumbColor"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SwitchKt {
    private static final TweenSpec<Float> AnimationSpec;
    private static final float DefaultSwitchPadding;
    private static final float SwitchHeight;
    private static final float SwitchPositionalThreshold = 0.7f;
    private static final float SwitchVelocityThreshold;
    private static final float SwitchWidth;
    private static final float ThumbDefaultElevation;
    private static final float ThumbDiameter;
    private static final float ThumbPathLength;
    private static final float ThumbPressedElevation;
    private static final float ThumbRippleRadius;
    private static final float TrackStrokeWidth;
    private static final float TrackWidth;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Switch$lambda$12(boolean z, Function1 function1, Modifier modifier, boolean z2, MutableInteractionSource mutableInteractionSource, SwitchColors switchColors, int i, int i2, Composer composer, int i3) {
        Switch(z, function1, modifier, z2, mutableInteractionSource, switchColors, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float Switch$lambda$6$1(float f) {
        return f * 0.7f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float Switch$lambda$6$2(float f) {
        return f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SwitchImpl$lambda$7(BoxScope boxScope, boolean z, boolean z2, SwitchColors switchColors, Function0 function0, InteractionSource interactionSource, int i, Composer composer, int i2) {
        SwitchImpl(boxScope, z, z2, switchColors, function0, interactionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:105:0x0208  */
    /* JADX WARN: Code duplicated, block: B:107:0x0210  */
    /* JADX WARN: Code duplicated, block: B:110:0x0275  */
    /* JADX WARN: Code duplicated, block: B:114:0x0281  */
    /* JADX WARN: Code duplicated, block: B:117:0x02b4  */
    /* JADX WARN: Code duplicated, block: B:118:0x02b7  */
    /* JADX WARN: Code duplicated, block: B:121:0x02c4  */
    /* JADX WARN: Code duplicated, block: B:125:0x02cf  */
    /* JADX WARN: Code duplicated, block: B:128:0x02f9  */
    /* JADX WARN: Code duplicated, block: B:129:0x02fc  */
    /* JADX WARN: Code duplicated, block: B:131:0x0300  */
    /* JADX WARN: Code duplicated, block: B:132:0x0322  */
    /* JADX WARN: Code duplicated, block: B:134:0x0332  */
    /* JADX WARN: Code duplicated, block: B:135:0x033b  */
    /* JADX WARN: Code duplicated, block: B:138:0x034b A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:140:0x034e  */
    /* JADX WARN: Code duplicated, block: B:143:0x03b6  */
    /* JADX WARN: Code duplicated, block: B:146:0x03c2  */
    /* JADX WARN: Code duplicated, block: B:147:0x03c6  */
    /* JADX WARN: Code duplicated, block: B:150:0x03eb  */
    /* JADX WARN: Code duplicated, block: B:152:0x03f9  */
    /* JADX WARN: Code duplicated, block: B:155:0x043e  */
    /* JADX WARN: Code duplicated, block: B:157:0x0446  */
    /* JADX WARN: Code duplicated, block: B:160:0x0485  */
    /* JADX WARN: Code duplicated, block: B:162:0x048d  */
    /* JADX WARN: Code duplicated, block: B:165:0x049c  */
    /* JADX WARN: Code duplicated, block: B:167:? A[RETURN, SYNTHETIC] */
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
    /* JADX WARN: Code duplicated, block: B:67:0x00be  */
    /* JADX WARN: Code duplicated, block: B:69:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:77:0x00ee A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:78:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:79:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:81:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:82:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:84:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:85:0x0101  */
    /* JADX WARN: Code duplicated, block: B:88:0x0107  */
    /* JADX WARN: Code duplicated, block: B:89:0x0144  */
    /* JADX WARN: Code duplicated, block: B:92:0x0155  */
    /* JADX WARN: Code duplicated, block: B:95:0x015f  */
    /* JADX WARN: Code duplicated, block: B:97:0x017c  */
    /* JADX WARN: Code duplicated, block: B:99:0x018e  */
    public static final void Switch(final boolean z, final Function1<? super Boolean, Unit> function1, Modifier modifier, boolean z2, MutableInteractionSource mutableInteractionSource, SwitchColors switchColors, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z3;
        int i5;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        int i7;
        SwitchColors switchColors2;
        int i8;
        boolean z4;
        Composer composer2;
        final Modifier modifier3;
        final boolean z5;
        final MutableInteractionSource mutableInteractionSource3;
        final SwitchColors switchColors3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        SnapshotMutationPolicy snapshotMutationPolicy;
        Modifier.Companion companion;
        boolean z6;
        boolean z7;
        int i9;
        MutableInteractionSource mutableInteractionSource4;
        final float fMo754toPx0680j_4;
        Object objRememberedValue;
        MutableState mutableState;
        final float fMo754toPx0680j_5;
        boolean zChanged;
        Object objRememberedValue2;
        AnchoredDraggableState anchoredDraggableState;
        State stateRememberUpdatedState;
        int i10;
        State stateRememberUpdatedState2;
        boolean zChanged2;
        AnchoredDraggableState anchoredDraggableState2;
        Object obj;
        boolean z8;
        boolean zChanged3;
        Object objRememberedValue3;
        Object obj2;
        Object objConsume;
        boolean z9;
        MutableInteractionSource mutableInteractionSource5;
        int i11;
        boolean z10;
        Modifier.Companion companionM1540toggleableO2vRcR0;
        Modifier.Companion companionMinimumInteractiveComponentSize;
        final AnchoredDraggableState anchoredDraggableState3;
        int currentCompositeKeyHash;
        Function0<ComposeUiNode> constructor;
        Composer composerM6062constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        boolean zChanged4;
        Object objRememberedValue4;
        Object objRememberedValue5;
        Composer composerStartRestartGroup = composer.startRestartGroup(25866825);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Switch)N(checked,onCheckedChange,modifier,enabled,interactionSource,colors)103@4720L7,108@5102L34,109@5191L7,111@5276L524,124@5835L37,125@5899L29,126@5972L315,126@5933L354,135@6337L133,135@6292L178,140@6508L7,155@6950L1052:Switch.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i12 = i2 & 4;
        if (i12 == 0) {
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
                            switchColors2 = switchColors;
                            int i13 = composerStartRestartGroup.changed(switchColors2) ? 131072 : 65536;
                            i3 |= i13;
                        } else {
                            switchColors2 = switchColors;
                        }
                        i3 |= i13;
                    } else {
                        switchColors2 = switchColors;
                    }
                    i8 = i3;
                    if ((74899 & i3) != 74898) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z4, i8 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "98@4526L8");
                        snapshotMutationPolicy = null;
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i12 != 0) {
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
                                mutableInteractionSource2 = null;
                            } else {
                                mutableInteractionSource2 = mutableInteractionSource2;
                            }
                            if ((i2 & 32) != 0) {
                                snapshotMutationPolicy = null;
                                z7 = false;
                                SwitchColors switchColorsM2598colorsSQMK_m0 = SwitchDefaults.INSTANCE.m2598colorsSQMK_m0(0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                                composerStartRestartGroup = composerStartRestartGroup;
                                i9 = i8 & (-458753);
                                z3 = z6;
                                switchColors2 = switchColorsM2598colorsSQMK_m0;
                                modifier2 = companion;
                            } else {
                                snapshotMutationPolicy = null;
                                z7 = false;
                                modifier2 = companion;
                                z3 = z6;
                                switchColors2 = switchColors2;
                                i9 = i8;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            i9 = (i2 & 32) != 0 ? i8 & (-458753) : i8;
                            z7 = false;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(25866825, i9, -1, "androidx.compose.material.Switch (Switch.kt:99)");
                        }
                        if (mutableInteractionSource2 == null) {
                            composerStartRestartGroup.startReplaceGroup(1799771122);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "101@4621L39");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -911774192, "CC(remember):Switch.kt#9igjgp");
                            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue5 = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endReplaceGroup();
                            mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue5;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-911774843);
                            composerStartRestartGroup.endReplaceGroup();
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume2 = composerStartRestartGroup.consume(localDensity);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        fMo754toPx0680j_4 = ((Density) objConsume2).mo754toPx0680j_4(ThumbPathLength);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -911758805, "CC(remember):Switch.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z7), snapshotMutationPolicy, 2, snapshotMutationPolicy);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableState = (MutableState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume3 = composerStartRestartGroup.consume(localDensity2);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        fMo754toPx0680j_5 = ((Density) objConsume3).mo754toPx0680j_4(SwitchVelocityThreshold);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -911752747, "CC(remember):Switch.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(fMo754toPx0680j_4) | composerStartRestartGroup.changed(fMo754toPx0680j_5);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            final float f = 0.0f;
                            objRememberedValue2 = new AnchoredDraggableState(Boolean.valueOf(z), AnchoredDraggableKt.DraggableAnchors(new Function1() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj3) {
                                    return SwitchKt.Switch$lambda$6$0(f, fMo754toPx0680j_4, (DraggableAnchorsConfig) obj3);
                                }
                            }), new Function1() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj3) {
                                    return Float.valueOf(SwitchKt.Switch$lambda$6$1(((Float) obj3).floatValue()));
                                }
                            }, new Function0() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Float.valueOf(SwitchKt.Switch$lambda$6$2(fMo754toPx0680j_5));
                                }
                            }, AnimationSpec, null, 32, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        anchoredDraggableState = (AnchoredDraggableState) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i14 = i9 >> 3;
                        stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function1, composerStartRestartGroup, i14 & 14);
                        i10 = i9 & 14;
                        stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf(z), composerStartRestartGroup, i10);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -911730684, "CC(remember):Switch.kt#9igjgp");
                        zChanged2 = composerStartRestartGroup.changed(anchoredDraggableState) | composerStartRestartGroup.changed(stateRememberUpdatedState2) | composerStartRestartGroup.changed(stateRememberUpdatedState);
                        Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged2 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            Object switchKt$Switch$1$1 = new SwitchKt$Switch$1$1(anchoredDraggableState, stateRememberUpdatedState2, stateRememberUpdatedState, mutableState, null);
                            anchoredDraggableState2 = anchoredDraggableState;
                            obj = (Function2) switchKt$Switch$1$1;
                            composerStartRestartGroup.updateRememberedValue(obj);
                        } else {
                            obj = objRememberedValue6;
                            anchoredDraggableState2 = anchoredDraggableState;
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(anchoredDraggableState2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) obj, composerStartRestartGroup, z7 ? 1 : 0);
                        Boolean boolValueOf = Boolean.valueOf(z);
                        Boolean boolValueOf2 = Boolean.valueOf(Switch$lambda$3(mutableState));
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -911719186, "CC(remember):Switch.kt#9igjgp");
                        if (i10 == 4) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        zChanged3 = z8 | composerStartRestartGroup.changed(anchoredDraggableState2);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            obj2 = null;
                            objRememberedValue3 = (Function2) new SwitchKt$Switch$2$1(z, anchoredDraggableState2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            obj2 = null;
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(boolValueOf, boolValueOf2, (Function2) objRememberedValue3, composerStartRestartGroup, i10);
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        objConsume = composerStartRestartGroup.consume(localLayoutDirection);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (objConsume == LayoutDirection.Rtl) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                        if (function1 != null) {
                            z5 = z3;
                            mutableInteractionSource5 = mutableInteractionSource4;
                            i11 = 2;
                            z10 = false;
                            companionM1540toggleableO2vRcR0 = ToggleableKt.m1540toggleableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource5, null, z5, Role.m8825boximpl(Role.INSTANCE.m8838getSwitcho7Vup1c()), function1);
                        } else {
                            z5 = z3;
                            mutableInteractionSource5 = mutableInteractionSource4;
                            i11 = 2;
                            z10 = false;
                            companionM1540toggleableO2vRcR0 = Modifier.INSTANCE;
                        }
                        if (function1 != null) {
                            companionMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE);
                        } else {
                            companionMinimumInteractiveComponentSize = Modifier.INSTANCE;
                        }
                        Modifier modifierThen = modifier2.then(companionMinimumInteractiveComponentSize).then(companionM1540toggleableO2vRcR0);
                        boolean z11 = z10;
                        anchoredDraggableState3 = anchoredDraggableState2;
                        Modifier modifierM1260requiredSizeVpY3zN4 = SizeKt.m1260requiredSizeVpY3zN4(PaddingKt.m1218padding3ABfNKs(SizeKt.wrapContentSize$default(AnchoredDraggableKt.anchoredDraggable(modifierThen, anchoredDraggableState2, Orientation.Horizontal, (z5 || function1 == null) ? z10 : true, z9, mutableInteractionSource5, false), Alignment.INSTANCE.getCenter(), z11, i11, obj2), DefaultSwitchPadding), SwitchWidth, SwitchHeight);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), z11);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, z11 ? 1 : 0);
                        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1260requiredSizeVpY3zN4);
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                        Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 351089009, "C181@7892L42,177@7737L259:Switch.kt#jmzs0o");
                        boolean zBooleanValue = ((Boolean) anchoredDraggableState3.getTargetValue()).booleanValue();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1928332455, "CC(remember):Switch.kt#9igjgp");
                        zChanged4 = composerStartRestartGroup.changed(anchoredDraggableState3);
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = new Function0() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Float.valueOf(anchoredDraggableState3.requireOffset());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifier4 = modifier2;
                        SwitchImpl(boxScopeInstance, zBooleanValue, z5, switchColors2, (Function0) objRememberedValue4, mutableInteractionSource5, composerStartRestartGroup, (i14 & 896) | 6 | ((i9 >> 6) & 7168));
                        composer2 = composerStartRestartGroup;
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        switchColors3 = switchColors2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier3 = modifier2;
                        z5 = z3;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        switchColors3 = switchColors2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj3, Object obj4) {
                                return SwitchKt.Switch$lambda$12(z, function1, modifier3, z5, mutableInteractionSource3, switchColors3, i, i2, (Composer) obj3, ((Integer) obj4).intValue());
                            }
                        });
                    }
                }
                i3 |= 24576;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        switchColors2 = switchColors;
                        if (composerStartRestartGroup.changed(switchColors2)) {
                        }
                        i3 |= i13;
                    } else {
                        switchColors2 = switchColors;
                    }
                    i3 |= i13;
                } else {
                    switchColors2 = switchColors;
                }
                i8 = i3;
                if ((74899 & i3) != 74898) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i8 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "98@4526L8");
                    snapshotMutationPolicy = null;
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
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
                            mutableInteractionSource2 = null;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource2;
                        }
                        if ((i2 & 32) != 0) {
                            snapshotMutationPolicy = null;
                            z7 = false;
                            SwitchColors switchColorsM2598colorsSQMK_m1 = SwitchDefaults.INSTANCE.m2598colorsSQMK_m0(0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                            composerStartRestartGroup = composerStartRestartGroup;
                            i9 = i8 & (-458753);
                            z3 = z6;
                            switchColors2 = switchColorsM2598colorsSQMK_m1;
                            modifier2 = companion;
                        } else {
                            snapshotMutationPolicy = null;
                            z7 = false;
                            modifier2 = companion;
                            z3 = z6;
                            switchColors2 = switchColors2;
                            i9 = i8;
                        }
                    } else {
                        if (i12 != 0) {
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
                            mutableInteractionSource2 = null;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource2;
                        }
                        if ((i2 & 32) != 0) {
                            snapshotMutationPolicy = null;
                            z7 = false;
                            SwitchColors switchColorsM2598colorsSQMK_m2 = SwitchDefaults.INSTANCE.m2598colorsSQMK_m0(0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                            composerStartRestartGroup = composerStartRestartGroup;
                            i9 = i8 & (-458753);
                            z3 = z6;
                            switchColors2 = switchColorsM2598colorsSQMK_m2;
                            modifier2 = companion;
                        } else {
                            snapshotMutationPolicy = null;
                            z7 = false;
                            modifier2 = companion;
                            z3 = z6;
                            switchColors2 = switchColors2;
                            i9 = i8;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(25866825, i9, -1, "androidx.compose.material.Switch (Switch.kt:99)");
                    }
                    if (mutableInteractionSource2 == null) {
                        composerStartRestartGroup.startReplaceGroup(1799771122);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "101@4621L39");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -911774192, "CC(remember):Switch.kt#9igjgp");
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue5 = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue5;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-911774843);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume4 = composerStartRestartGroup.consume(localDensity3);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    fMo754toPx0680j_4 = ((Density) objConsume4).mo754toPx0680j_4(ThumbPathLength);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -911758805, "CC(remember):Switch.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z7), snapshotMutationPolicy, 2, snapshotMutationPolicy);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ProvidableCompositionLocal<Density> localDensity4 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume5 = composerStartRestartGroup.consume(localDensity4);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    fMo754toPx0680j_5 = ((Density) objConsume5).mo754toPx0680j_4(SwitchVelocityThreshold);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -911752747, "CC(remember):Switch.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(fMo754toPx0680j_4) | composerStartRestartGroup.changed(fMo754toPx0680j_5);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        final float f2 = 0.0f;
                        objRememberedValue2 = new AnchoredDraggableState(Boolean.valueOf(z), AnchoredDraggableKt.DraggableAnchors(new Function1() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj3) {
                                return SwitchKt.Switch$lambda$6$0(f2, fMo754toPx0680j_4, (DraggableAnchorsConfig) obj3);
                            }
                        }), new Function1() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj3) {
                                return Float.valueOf(SwitchKt.Switch$lambda$6$1(((Float) obj3).floatValue()));
                            }
                        }, new Function0() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(SwitchKt.Switch$lambda$6$2(fMo754toPx0680j_5));
                            }
                        }, AnimationSpec, null, 32, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        final float f3 = 0.0f;
                        objRememberedValue2 = new AnchoredDraggableState(Boolean.valueOf(z), AnchoredDraggableKt.DraggableAnchors(new Function1() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj3) {
                                return SwitchKt.Switch$lambda$6$0(f3, fMo754toPx0680j_4, (DraggableAnchorsConfig) obj3);
                            }
                        }), new Function1() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj3) {
                                return Float.valueOf(SwitchKt.Switch$lambda$6$1(((Float) obj3).floatValue()));
                            }
                        }, new Function0() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(SwitchKt.Switch$lambda$6$2(fMo754toPx0680j_5));
                            }
                        }, AnimationSpec, null, 32, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    anchoredDraggableState = (AnchoredDraggableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i15 = i9 >> 3;
                    stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function1, composerStartRestartGroup, i15 & 14);
                    i10 = i9 & 14;
                    stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf(z), composerStartRestartGroup, i10);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -911730684, "CC(remember):Switch.kt#9igjgp");
                    zChanged2 = composerStartRestartGroup.changed(anchoredDraggableState) | composerStartRestartGroup.changed(stateRememberUpdatedState2) | composerStartRestartGroup.changed(stateRememberUpdatedState);
                    Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2) {
                        Object switchKt$Switch$1$2 = new SwitchKt$Switch$1$1(anchoredDraggableState, stateRememberUpdatedState2, stateRememberUpdatedState, mutableState, null);
                        anchoredDraggableState2 = anchoredDraggableState;
                        obj = (Function2) switchKt$Switch$1$2;
                        composerStartRestartGroup.updateRememberedValue(obj);
                    } else {
                        Object switchKt$Switch$1$3 = new SwitchKt$Switch$1$1(anchoredDraggableState, stateRememberUpdatedState2, stateRememberUpdatedState, mutableState, null);
                        anchoredDraggableState2 = anchoredDraggableState;
                        obj = (Function2) switchKt$Switch$1$3;
                        composerStartRestartGroup.updateRememberedValue(obj);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(anchoredDraggableState2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) obj, composerStartRestartGroup, z7 ? 1 : 0);
                    Boolean boolValueOf3 = Boolean.valueOf(z);
                    Boolean boolValueOf4 = Boolean.valueOf(Switch$lambda$3(mutableState));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -911719186, "CC(remember):Switch.kt#9igjgp");
                    if (i10 == 4) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    zChanged3 = z8 | composerStartRestartGroup.changed(anchoredDraggableState2);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged3) {
                        obj2 = null;
                        objRememberedValue3 = (Function2) new SwitchKt$Switch$2$1(z, anchoredDraggableState2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        obj2 = null;
                        objRememberedValue3 = (Function2) new SwitchKt$Switch$2$1(z, anchoredDraggableState2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(boolValueOf3, boolValueOf4, (Function2) objRememberedValue3, composerStartRestartGroup, i10);
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    objConsume = composerStartRestartGroup.consume(localLayoutDirection2);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (objConsume == LayoutDirection.Rtl) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    if (function1 != null) {
                        z5 = z3;
                        mutableInteractionSource5 = mutableInteractionSource4;
                        i11 = 2;
                        z10 = false;
                        companionM1540toggleableO2vRcR0 = ToggleableKt.m1540toggleableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource5, null, z5, Role.m8825boximpl(Role.INSTANCE.m8838getSwitcho7Vup1c()), function1);
                    } else {
                        z5 = z3;
                        mutableInteractionSource5 = mutableInteractionSource4;
                        i11 = 2;
                        z10 = false;
                        companionM1540toggleableO2vRcR0 = Modifier.INSTANCE;
                    }
                    if (function1 != null) {
                        companionMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE);
                    } else {
                        companionMinimumInteractiveComponentSize = Modifier.INSTANCE;
                    }
                    Modifier modifierThen2 = modifier2.then(companionMinimumInteractiveComponentSize).then(companionM1540toggleableO2vRcR0);
                    boolean z12 = z10;
                    anchoredDraggableState3 = anchoredDraggableState2;
                    Modifier modifierM1260requiredSizeVpY3zN5 = SizeKt.m1260requiredSizeVpY3zN4(PaddingKt.m1218padding3ABfNKs(SizeKt.wrapContentSize$default(AnchoredDraggableKt.anchoredDraggable(modifierThen2, anchoredDraggableState2, Orientation.Horizontal, (z5 || function1 == null) ? z10 : true, z9, mutableInteractionSource5, false), Alignment.INSTANCE.getCenter(), z12, i11, obj2), DefaultSwitchPadding), SwitchWidth, SwitchHeight);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), z12);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, z12 ? 1 : 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1260requiredSizeVpY3zN5);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM6062constructorimpl.getInserting()) {
                        composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 351089009, "C181@7892L42,177@7737L259:Switch.kt#jmzs0o");
                    boolean zBooleanValue2 = ((Boolean) anchoredDraggableState3.getTargetValue()).booleanValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1928332455, "CC(remember):Switch.kt#9igjgp");
                    zChanged4 = composerStartRestartGroup.changed(anchoredDraggableState3);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged4) {
                        objRememberedValue4 = new Function0() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(anchoredDraggableState3.requireOffset());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new Function0() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(anchoredDraggableState3.requireOffset());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifier5 = modifier2;
                    SwitchImpl(boxScopeInstance2, zBooleanValue2, z5, switchColors2, (Function0) objRememberedValue4, mutableInteractionSource5, composerStartRestartGroup, (i15 & 896) | 6 | ((i9 >> 6) & 7168));
                    composer2 = composerStartRestartGroup;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier5;
                    switchColors3 = switchColors2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    z5 = z3;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    switchColors3 = switchColors2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj3, Object obj4) {
                            return SwitchKt.Switch$lambda$12(z, function1, modifier3, z5, mutableInteractionSource3, switchColors3, i, i2, (Composer) obj3, ((Integer) obj4).intValue());
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
                        switchColors2 = switchColors;
                        if (composerStartRestartGroup.changed(switchColors2)) {
                        }
                        i3 |= i13;
                    } else {
                        switchColors2 = switchColors;
                    }
                    i3 |= i13;
                } else {
                    switchColors2 = switchColors;
                }
                i8 = i3;
                if ((74899 & i3) != 74898) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i8 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "98@4526L8");
                    snapshotMutationPolicy = null;
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
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
                            mutableInteractionSource2 = null;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource2;
                        }
                        if ((i2 & 32) != 0) {
                            snapshotMutationPolicy = null;
                            z7 = false;
                            SwitchColors switchColorsM2598colorsSQMK_m3 = SwitchDefaults.INSTANCE.m2598colorsSQMK_m0(0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                            composerStartRestartGroup = composerStartRestartGroup;
                            i9 = i8 & (-458753);
                            z3 = z6;
                            switchColors2 = switchColorsM2598colorsSQMK_m3;
                            modifier2 = companion;
                        } else {
                            snapshotMutationPolicy = null;
                            z7 = false;
                            modifier2 = companion;
                            z3 = z6;
                            switchColors2 = switchColors2;
                            i9 = i8;
                        }
                    } else {
                        if (i12 != 0) {
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
                            mutableInteractionSource2 = null;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource2;
                        }
                        if ((i2 & 32) != 0) {
                            snapshotMutationPolicy = null;
                            z7 = false;
                            SwitchColors switchColorsM2598colorsSQMK_m4 = SwitchDefaults.INSTANCE.m2598colorsSQMK_m0(0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                            composerStartRestartGroup = composerStartRestartGroup;
                            i9 = i8 & (-458753);
                            z3 = z6;
                            switchColors2 = switchColorsM2598colorsSQMK_m4;
                            modifier2 = companion;
                        } else {
                            snapshotMutationPolicy = null;
                            z7 = false;
                            modifier2 = companion;
                            z3 = z6;
                            switchColors2 = switchColors2;
                            i9 = i8;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(25866825, i9, -1, "androidx.compose.material.Switch (Switch.kt:99)");
                    }
                    if (mutableInteractionSource2 == null) {
                        composerStartRestartGroup.startReplaceGroup(1799771122);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "101@4621L39");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -911774192, "CC(remember):Switch.kt#9igjgp");
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue5 = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue5;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-911774843);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    ProvidableCompositionLocal<Density> localDensity5 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume6 = composerStartRestartGroup.consume(localDensity5);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    fMo754toPx0680j_4 = ((Density) objConsume6).mo754toPx0680j_4(ThumbPathLength);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -911758805, "CC(remember):Switch.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z7), snapshotMutationPolicy, 2, snapshotMutationPolicy);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ProvidableCompositionLocal<Density> localDensity6 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume7 = composerStartRestartGroup.consume(localDensity6);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    fMo754toPx0680j_5 = ((Density) objConsume7).mo754toPx0680j_4(SwitchVelocityThreshold);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -911752747, "CC(remember):Switch.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(fMo754toPx0680j_4) | composerStartRestartGroup.changed(fMo754toPx0680j_5);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        final float f4 = 0.0f;
                        objRememberedValue2 = new AnchoredDraggableState(Boolean.valueOf(z), AnchoredDraggableKt.DraggableAnchors(new Function1() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj3) {
                                return SwitchKt.Switch$lambda$6$0(f4, fMo754toPx0680j_4, (DraggableAnchorsConfig) obj3);
                            }
                        }), new Function1() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj3) {
                                return Float.valueOf(SwitchKt.Switch$lambda$6$1(((Float) obj3).floatValue()));
                            }
                        }, new Function0() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(SwitchKt.Switch$lambda$6$2(fMo754toPx0680j_5));
                            }
                        }, AnimationSpec, null, 32, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        final float f5 = 0.0f;
                        objRememberedValue2 = new AnchoredDraggableState(Boolean.valueOf(z), AnchoredDraggableKt.DraggableAnchors(new Function1() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj3) {
                                return SwitchKt.Switch$lambda$6$0(f5, fMo754toPx0680j_4, (DraggableAnchorsConfig) obj3);
                            }
                        }), new Function1() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj3) {
                                return Float.valueOf(SwitchKt.Switch$lambda$6$1(((Float) obj3).floatValue()));
                            }
                        }, new Function0() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(SwitchKt.Switch$lambda$6$2(fMo754toPx0680j_5));
                            }
                        }, AnimationSpec, null, 32, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    anchoredDraggableState = (AnchoredDraggableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i16 = i9 >> 3;
                    stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function1, composerStartRestartGroup, i16 & 14);
                    i10 = i9 & 14;
                    stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf(z), composerStartRestartGroup, i10);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -911730684, "CC(remember):Switch.kt#9igjgp");
                    zChanged2 = composerStartRestartGroup.changed(anchoredDraggableState) | composerStartRestartGroup.changed(stateRememberUpdatedState2) | composerStartRestartGroup.changed(stateRememberUpdatedState);
                    Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2) {
                        Object switchKt$Switch$1$4 = new SwitchKt$Switch$1$1(anchoredDraggableState, stateRememberUpdatedState2, stateRememberUpdatedState, mutableState, null);
                        anchoredDraggableState2 = anchoredDraggableState;
                        obj = (Function2) switchKt$Switch$1$4;
                        composerStartRestartGroup.updateRememberedValue(obj);
                    } else {
                        Object switchKt$Switch$1$5 = new SwitchKt$Switch$1$1(anchoredDraggableState, stateRememberUpdatedState2, stateRememberUpdatedState, mutableState, null);
                        anchoredDraggableState2 = anchoredDraggableState;
                        obj = (Function2) switchKt$Switch$1$5;
                        composerStartRestartGroup.updateRememberedValue(obj);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(anchoredDraggableState2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) obj, composerStartRestartGroup, z7 ? 1 : 0);
                    Boolean boolValueOf5 = Boolean.valueOf(z);
                    Boolean boolValueOf6 = Boolean.valueOf(Switch$lambda$3(mutableState));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -911719186, "CC(remember):Switch.kt#9igjgp");
                    if (i10 == 4) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    zChanged3 = z8 | composerStartRestartGroup.changed(anchoredDraggableState2);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged3) {
                        obj2 = null;
                        objRememberedValue3 = (Function2) new SwitchKt$Switch$2$1(z, anchoredDraggableState2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        obj2 = null;
                        objRememberedValue3 = (Function2) new SwitchKt$Switch$2$1(z, anchoredDraggableState2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(boolValueOf5, boolValueOf6, (Function2) objRememberedValue3, composerStartRestartGroup, i10);
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    objConsume = composerStartRestartGroup.consume(localLayoutDirection3);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (objConsume == LayoutDirection.Rtl) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    if (function1 != null) {
                        z5 = z3;
                        mutableInteractionSource5 = mutableInteractionSource4;
                        i11 = 2;
                        z10 = false;
                        companionM1540toggleableO2vRcR0 = ToggleableKt.m1540toggleableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource5, null, z5, Role.m8825boximpl(Role.INSTANCE.m8838getSwitcho7Vup1c()), function1);
                    } else {
                        z5 = z3;
                        mutableInteractionSource5 = mutableInteractionSource4;
                        i11 = 2;
                        z10 = false;
                        companionM1540toggleableO2vRcR0 = Modifier.INSTANCE;
                    }
                    if (function1 != null) {
                        companionMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE);
                    } else {
                        companionMinimumInteractiveComponentSize = Modifier.INSTANCE;
                    }
                    Modifier modifierThen3 = modifier2.then(companionMinimumInteractiveComponentSize).then(companionM1540toggleableO2vRcR0);
                    boolean z13 = z10;
                    anchoredDraggableState3 = anchoredDraggableState2;
                    Modifier modifierM1260requiredSizeVpY3zN6 = SizeKt.m1260requiredSizeVpY3zN4(PaddingKt.m1218padding3ABfNKs(SizeKt.wrapContentSize$default(AnchoredDraggableKt.anchoredDraggable(modifierThen3, anchoredDraggableState2, Orientation.Horizontal, (z5 || function1 == null) ? z10 : true, z9, mutableInteractionSource5, false), Alignment.INSTANCE.getCenter(), z13, i11, obj2), DefaultSwitchPadding), SwitchWidth, SwitchHeight);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), z13);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, z13 ? 1 : 0);
                    CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1260requiredSizeVpY3zN6);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM6062constructorimpl.getInserting()) {
                        composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 351089009, "C181@7892L42,177@7737L259:Switch.kt#jmzs0o");
                    boolean zBooleanValue3 = ((Boolean) anchoredDraggableState3.getTargetValue()).booleanValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1928332455, "CC(remember):Switch.kt#9igjgp");
                    zChanged4 = composerStartRestartGroup.changed(anchoredDraggableState3);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged4) {
                        objRememberedValue4 = new Function0() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(anchoredDraggableState3.requireOffset());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new Function0() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(anchoredDraggableState3.requireOffset());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifier6 = modifier2;
                    SwitchImpl(boxScopeInstance3, zBooleanValue3, z5, switchColors2, (Function0) objRememberedValue4, mutableInteractionSource5, composerStartRestartGroup, (i16 & 896) | 6 | ((i9 >> 6) & 7168));
                    composer2 = composerStartRestartGroup;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier6;
                    switchColors3 = switchColors2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    z5 = z3;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    switchColors3 = switchColors2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj3, Object obj4) {
                            return SwitchKt.Switch$lambda$12(z, function1, modifier3, z5, mutableInteractionSource3, switchColors3, i, i2, (Composer) obj3, ((Integer) obj4).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    switchColors2 = switchColors;
                    if (composerStartRestartGroup.changed(switchColors2)) {
                    }
                    i3 |= i13;
                } else {
                    switchColors2 = switchColors;
                }
                i3 |= i13;
            } else {
                switchColors2 = switchColors;
            }
            i8 = i3;
            if ((74899 & i3) != 74898) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i8 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "98@4526L8");
                snapshotMutationPolicy = null;
                if ((i & 1) != 0) {
                    if (i12 != 0) {
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
                        mutableInteractionSource2 = null;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource2;
                    }
                    if ((i2 & 32) != 0) {
                        snapshotMutationPolicy = null;
                        z7 = false;
                        SwitchColors switchColorsM2598colorsSQMK_m5 = SwitchDefaults.INSTANCE.m2598colorsSQMK_m0(0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                        composerStartRestartGroup = composerStartRestartGroup;
                        i9 = i8 & (-458753);
                        z3 = z6;
                        switchColors2 = switchColorsM2598colorsSQMK_m5;
                        modifier2 = companion;
                    } else {
                        snapshotMutationPolicy = null;
                        z7 = false;
                        modifier2 = companion;
                        z3 = z6;
                        switchColors2 = switchColors2;
                        i9 = i8;
                    }
                } else {
                    if (i12 != 0) {
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
                        mutableInteractionSource2 = null;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource2;
                    }
                    if ((i2 & 32) != 0) {
                        snapshotMutationPolicy = null;
                        z7 = false;
                        SwitchColors switchColorsM2598colorsSQMK_m6 = SwitchDefaults.INSTANCE.m2598colorsSQMK_m0(0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                        composerStartRestartGroup = composerStartRestartGroup;
                        i9 = i8 & (-458753);
                        z3 = z6;
                        switchColors2 = switchColorsM2598colorsSQMK_m6;
                        modifier2 = companion;
                    } else {
                        snapshotMutationPolicy = null;
                        z7 = false;
                        modifier2 = companion;
                        z3 = z6;
                        switchColors2 = switchColors2;
                        i9 = i8;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(25866825, i9, -1, "androidx.compose.material.Switch (Switch.kt:99)");
                }
                if (mutableInteractionSource2 == null) {
                    composerStartRestartGroup.startReplaceGroup(1799771122);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "101@4621L39");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -911774192, "CC(remember):Switch.kt#9igjgp");
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue5;
                } else {
                    composerStartRestartGroup.startReplaceGroup(-911774843);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource4 = mutableInteractionSource2;
                }
                ProvidableCompositionLocal<Density> localDensity7 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume8 = composerStartRestartGroup.consume(localDensity7);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                fMo754toPx0680j_4 = ((Density) objConsume8).mo754toPx0680j_4(ThumbPathLength);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -911758805, "CC(remember):Switch.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z7), snapshotMutationPolicy, 2, snapshotMutationPolicy);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ProvidableCompositionLocal<Density> localDensity8 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume9 = composerStartRestartGroup.consume(localDensity8);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                fMo754toPx0680j_5 = ((Density) objConsume9).mo754toPx0680j_4(SwitchVelocityThreshold);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -911752747, "CC(remember):Switch.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(fMo754toPx0680j_4) | composerStartRestartGroup.changed(fMo754toPx0680j_5);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    final float f6 = 0.0f;
                    objRememberedValue2 = new AnchoredDraggableState(Boolean.valueOf(z), AnchoredDraggableKt.DraggableAnchors(new Function1() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj3) {
                            return SwitchKt.Switch$lambda$6$0(f6, fMo754toPx0680j_4, (DraggableAnchorsConfig) obj3);
                        }
                    }), new Function1() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj3) {
                            return Float.valueOf(SwitchKt.Switch$lambda$6$1(((Float) obj3).floatValue()));
                        }
                    }, new Function0() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(SwitchKt.Switch$lambda$6$2(fMo754toPx0680j_5));
                        }
                    }, AnimationSpec, null, 32, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    final float f7 = 0.0f;
                    objRememberedValue2 = new AnchoredDraggableState(Boolean.valueOf(z), AnchoredDraggableKt.DraggableAnchors(new Function1() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj3) {
                            return SwitchKt.Switch$lambda$6$0(f7, fMo754toPx0680j_4, (DraggableAnchorsConfig) obj3);
                        }
                    }), new Function1() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj3) {
                            return Float.valueOf(SwitchKt.Switch$lambda$6$1(((Float) obj3).floatValue()));
                        }
                    }, new Function0() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(SwitchKt.Switch$lambda$6$2(fMo754toPx0680j_5));
                        }
                    }, AnimationSpec, null, 32, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                anchoredDraggableState = (AnchoredDraggableState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i17 = i9 >> 3;
                stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function1, composerStartRestartGroup, i17 & 14);
                i10 = i9 & 14;
                stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf(z), composerStartRestartGroup, i10);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -911730684, "CC(remember):Switch.kt#9igjgp");
                zChanged2 = composerStartRestartGroup.changed(anchoredDraggableState) | composerStartRestartGroup.changed(stateRememberUpdatedState2) | composerStartRestartGroup.changed(stateRememberUpdatedState);
                Object objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                if (zChanged2) {
                    Object switchKt$Switch$1$6 = new SwitchKt$Switch$1$1(anchoredDraggableState, stateRememberUpdatedState2, stateRememberUpdatedState, mutableState, null);
                    anchoredDraggableState2 = anchoredDraggableState;
                    obj = (Function2) switchKt$Switch$1$6;
                    composerStartRestartGroup.updateRememberedValue(obj);
                } else {
                    Object switchKt$Switch$1$7 = new SwitchKt$Switch$1$1(anchoredDraggableState, stateRememberUpdatedState2, stateRememberUpdatedState, mutableState, null);
                    anchoredDraggableState2 = anchoredDraggableState;
                    obj = (Function2) switchKt$Switch$1$7;
                    composerStartRestartGroup.updateRememberedValue(obj);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(anchoredDraggableState2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) obj, composerStartRestartGroup, z7 ? 1 : 0);
                Boolean boolValueOf7 = Boolean.valueOf(z);
                Boolean boolValueOf8 = Boolean.valueOf(Switch$lambda$3(mutableState));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -911719186, "CC(remember):Switch.kt#9igjgp");
                if (i10 == 4) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                zChanged3 = z8 | composerStartRestartGroup.changed(anchoredDraggableState2);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged3) {
                    obj2 = null;
                    objRememberedValue3 = (Function2) new SwitchKt$Switch$2$1(z, anchoredDraggableState2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    obj2 = null;
                    objRememberedValue3 = (Function2) new SwitchKt$Switch$2$1(z, anchoredDraggableState2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(boolValueOf7, boolValueOf8, (Function2) objRememberedValue3, composerStartRestartGroup, i10);
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection4 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                objConsume = composerStartRestartGroup.consume(localLayoutDirection4);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (objConsume == LayoutDirection.Rtl) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                if (function1 != null) {
                    z5 = z3;
                    mutableInteractionSource5 = mutableInteractionSource4;
                    i11 = 2;
                    z10 = false;
                    companionM1540toggleableO2vRcR0 = ToggleableKt.m1540toggleableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource5, null, z5, Role.m8825boximpl(Role.INSTANCE.m8838getSwitcho7Vup1c()), function1);
                } else {
                    z5 = z3;
                    mutableInteractionSource5 = mutableInteractionSource4;
                    i11 = 2;
                    z10 = false;
                    companionM1540toggleableO2vRcR0 = Modifier.INSTANCE;
                }
                if (function1 != null) {
                    companionMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE);
                } else {
                    companionMinimumInteractiveComponentSize = Modifier.INSTANCE;
                }
                Modifier modifierThen4 = modifier2.then(companionMinimumInteractiveComponentSize).then(companionM1540toggleableO2vRcR0);
                boolean z14 = z10;
                anchoredDraggableState3 = anchoredDraggableState2;
                Modifier modifierM1260requiredSizeVpY3zN7 = SizeKt.m1260requiredSizeVpY3zN4(PaddingKt.m1218padding3ABfNKs(SizeKt.wrapContentSize$default(AnchoredDraggableKt.anchoredDraggable(modifierThen4, anchoredDraggableState2, Orientation.Horizontal, (z5 || function1 == null) ? z10 : true, z9, mutableInteractionSource5, false), Alignment.INSTANCE.getCenter(), z14, i11, obj2), DefaultSwitchPadding), SwitchWidth, SwitchHeight);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), z14);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, z14 ? 1 : 0);
                CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1260requiredSizeVpY3zN7);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl.getInserting()) {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 351089009, "C181@7892L42,177@7737L259:Switch.kt#jmzs0o");
                boolean zBooleanValue4 = ((Boolean) anchoredDraggableState3.getTargetValue()).booleanValue();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1928332455, "CC(remember):Switch.kt#9igjgp");
                zChanged4 = composerStartRestartGroup.changed(anchoredDraggableState3);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChanged4) {
                    objRememberedValue4 = new Function0() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(anchoredDraggableState3.requireOffset());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function0() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(anchoredDraggableState3.requireOffset());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifier7 = modifier2;
                SwitchImpl(boxScopeInstance4, zBooleanValue4, z5, switchColors2, (Function0) objRememberedValue4, mutableInteractionSource5, composerStartRestartGroup, (i17 & 896) | 6 | ((i9 >> 6) & 7168));
                composer2 = composerStartRestartGroup;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier7;
                switchColors3 = switchColors2;
                mutableInteractionSource3 = mutableInteractionSource2;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                z5 = z3;
                mutableInteractionSource3 = mutableInteractionSource2;
                switchColors3 = switchColors2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj3, Object obj4) {
                        return SwitchKt.Switch$lambda$12(z, function1, modifier3, z5, mutableInteractionSource3, switchColors3, i, i2, (Composer) obj3, ((Integer) obj4).intValue());
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
                        switchColors2 = switchColors;
                        if (composerStartRestartGroup.changed(switchColors2)) {
                        }
                        i3 |= i13;
                    } else {
                        switchColors2 = switchColors;
                    }
                    i3 |= i13;
                } else {
                    switchColors2 = switchColors;
                }
                i8 = i3;
                if ((74899 & i3) != 74898) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i8 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "98@4526L8");
                    snapshotMutationPolicy = null;
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
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
                            mutableInteractionSource2 = null;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource2;
                        }
                        if ((i2 & 32) != 0) {
                            snapshotMutationPolicy = null;
                            z7 = false;
                            SwitchColors switchColorsM2598colorsSQMK_m7 = SwitchDefaults.INSTANCE.m2598colorsSQMK_m0(0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                            composerStartRestartGroup = composerStartRestartGroup;
                            i9 = i8 & (-458753);
                            z3 = z6;
                            switchColors2 = switchColorsM2598colorsSQMK_m7;
                            modifier2 = companion;
                        } else {
                            snapshotMutationPolicy = null;
                            z7 = false;
                            modifier2 = companion;
                            z3 = z6;
                            switchColors2 = switchColors2;
                            i9 = i8;
                        }
                    } else {
                        if (i12 != 0) {
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
                            mutableInteractionSource2 = null;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource2;
                        }
                        if ((i2 & 32) != 0) {
                            snapshotMutationPolicy = null;
                            z7 = false;
                            SwitchColors switchColorsM2598colorsSQMK_m8 = SwitchDefaults.INSTANCE.m2598colorsSQMK_m0(0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                            composerStartRestartGroup = composerStartRestartGroup;
                            i9 = i8 & (-458753);
                            z3 = z6;
                            switchColors2 = switchColorsM2598colorsSQMK_m8;
                            modifier2 = companion;
                        } else {
                            snapshotMutationPolicy = null;
                            z7 = false;
                            modifier2 = companion;
                            z3 = z6;
                            switchColors2 = switchColors2;
                            i9 = i8;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(25866825, i9, -1, "androidx.compose.material.Switch (Switch.kt:99)");
                    }
                    if (mutableInteractionSource2 == null) {
                        composerStartRestartGroup.startReplaceGroup(1799771122);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "101@4621L39");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -911774192, "CC(remember):Switch.kt#9igjgp");
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue5 = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue5;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-911774843);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    ProvidableCompositionLocal<Density> localDensity9 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume10 = composerStartRestartGroup.consume(localDensity9);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    fMo754toPx0680j_4 = ((Density) objConsume10).mo754toPx0680j_4(ThumbPathLength);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -911758805, "CC(remember):Switch.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z7), snapshotMutationPolicy, 2, snapshotMutationPolicy);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ProvidableCompositionLocal<Density> localDensity10 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume11 = composerStartRestartGroup.consume(localDensity10);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    fMo754toPx0680j_5 = ((Density) objConsume11).mo754toPx0680j_4(SwitchVelocityThreshold);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -911752747, "CC(remember):Switch.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(fMo754toPx0680j_4) | composerStartRestartGroup.changed(fMo754toPx0680j_5);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        final float f8 = 0.0f;
                        objRememberedValue2 = new AnchoredDraggableState(Boolean.valueOf(z), AnchoredDraggableKt.DraggableAnchors(new Function1() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj3) {
                                return SwitchKt.Switch$lambda$6$0(f8, fMo754toPx0680j_4, (DraggableAnchorsConfig) obj3);
                            }
                        }), new Function1() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj3) {
                                return Float.valueOf(SwitchKt.Switch$lambda$6$1(((Float) obj3).floatValue()));
                            }
                        }, new Function0() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(SwitchKt.Switch$lambda$6$2(fMo754toPx0680j_5));
                            }
                        }, AnimationSpec, null, 32, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        final float f9 = 0.0f;
                        objRememberedValue2 = new AnchoredDraggableState(Boolean.valueOf(z), AnchoredDraggableKt.DraggableAnchors(new Function1() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj3) {
                                return SwitchKt.Switch$lambda$6$0(f9, fMo754toPx0680j_4, (DraggableAnchorsConfig) obj3);
                            }
                        }), new Function1() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj3) {
                                return Float.valueOf(SwitchKt.Switch$lambda$6$1(((Float) obj3).floatValue()));
                            }
                        }, new Function0() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(SwitchKt.Switch$lambda$6$2(fMo754toPx0680j_5));
                            }
                        }, AnimationSpec, null, 32, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    anchoredDraggableState = (AnchoredDraggableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i18 = i9 >> 3;
                    stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function1, composerStartRestartGroup, i18 & 14);
                    i10 = i9 & 14;
                    stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf(z), composerStartRestartGroup, i10);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -911730684, "CC(remember):Switch.kt#9igjgp");
                    zChanged2 = composerStartRestartGroup.changed(anchoredDraggableState) | composerStartRestartGroup.changed(stateRememberUpdatedState2) | composerStartRestartGroup.changed(stateRememberUpdatedState);
                    Object objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2) {
                        Object switchKt$Switch$1$8 = new SwitchKt$Switch$1$1(anchoredDraggableState, stateRememberUpdatedState2, stateRememberUpdatedState, mutableState, null);
                        anchoredDraggableState2 = anchoredDraggableState;
                        obj = (Function2) switchKt$Switch$1$8;
                        composerStartRestartGroup.updateRememberedValue(obj);
                    } else {
                        Object switchKt$Switch$1$9 = new SwitchKt$Switch$1$1(anchoredDraggableState, stateRememberUpdatedState2, stateRememberUpdatedState, mutableState, null);
                        anchoredDraggableState2 = anchoredDraggableState;
                        obj = (Function2) switchKt$Switch$1$9;
                        composerStartRestartGroup.updateRememberedValue(obj);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(anchoredDraggableState2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) obj, composerStartRestartGroup, z7 ? 1 : 0);
                    Boolean boolValueOf9 = Boolean.valueOf(z);
                    Boolean boolValueOf10 = Boolean.valueOf(Switch$lambda$3(mutableState));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -911719186, "CC(remember):Switch.kt#9igjgp");
                    if (i10 == 4) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    zChanged3 = z8 | composerStartRestartGroup.changed(anchoredDraggableState2);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged3) {
                        obj2 = null;
                        objRememberedValue3 = (Function2) new SwitchKt$Switch$2$1(z, anchoredDraggableState2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        obj2 = null;
                        objRememberedValue3 = (Function2) new SwitchKt$Switch$2$1(z, anchoredDraggableState2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(boolValueOf9, boolValueOf10, (Function2) objRememberedValue3, composerStartRestartGroup, i10);
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection5 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    objConsume = composerStartRestartGroup.consume(localLayoutDirection5);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (objConsume == LayoutDirection.Rtl) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    if (function1 != null) {
                        z5 = z3;
                        mutableInteractionSource5 = mutableInteractionSource4;
                        i11 = 2;
                        z10 = false;
                        companionM1540toggleableO2vRcR0 = ToggleableKt.m1540toggleableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource5, null, z5, Role.m8825boximpl(Role.INSTANCE.m8838getSwitcho7Vup1c()), function1);
                    } else {
                        z5 = z3;
                        mutableInteractionSource5 = mutableInteractionSource4;
                        i11 = 2;
                        z10 = false;
                        companionM1540toggleableO2vRcR0 = Modifier.INSTANCE;
                    }
                    if (function1 != null) {
                        companionMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE);
                    } else {
                        companionMinimumInteractiveComponentSize = Modifier.INSTANCE;
                    }
                    Modifier modifierThen5 = modifier2.then(companionMinimumInteractiveComponentSize).then(companionM1540toggleableO2vRcR0);
                    boolean z15 = z10;
                    anchoredDraggableState3 = anchoredDraggableState2;
                    Modifier modifierM1260requiredSizeVpY3zN8 = SizeKt.m1260requiredSizeVpY3zN4(PaddingKt.m1218padding3ABfNKs(SizeKt.wrapContentSize$default(AnchoredDraggableKt.anchoredDraggable(modifierThen5, anchoredDraggableState2, Orientation.Horizontal, (z5 || function1 == null) ? z10 : true, z9, mutableInteractionSource5, false), Alignment.INSTANCE.getCenter(), z15, i11, obj2), DefaultSwitchPadding), SwitchWidth, SwitchHeight);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), z15);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, z15 ? 1 : 0);
                    CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1260requiredSizeVpY3zN8);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM6062constructorimpl.getInserting()) {
                        composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 351089009, "C181@7892L42,177@7737L259:Switch.kt#jmzs0o");
                    boolean zBooleanValue5 = ((Boolean) anchoredDraggableState3.getTargetValue()).booleanValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1928332455, "CC(remember):Switch.kt#9igjgp");
                    zChanged4 = composerStartRestartGroup.changed(anchoredDraggableState3);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged4) {
                        objRememberedValue4 = new Function0() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(anchoredDraggableState3.requireOffset());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new Function0() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(anchoredDraggableState3.requireOffset());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifier8 = modifier2;
                    SwitchImpl(boxScopeInstance5, zBooleanValue5, z5, switchColors2, (Function0) objRememberedValue4, mutableInteractionSource5, composerStartRestartGroup, (i18 & 896) | 6 | ((i9 >> 6) & 7168));
                    composer2 = composerStartRestartGroup;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier8;
                    switchColors3 = switchColors2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    z5 = z3;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    switchColors3 = switchColors2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj3, Object obj4) {
                            return SwitchKt.Switch$lambda$12(z, function1, modifier3, z5, mutableInteractionSource3, switchColors3, i, i2, (Composer) obj3, ((Integer) obj4).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    switchColors2 = switchColors;
                    if (composerStartRestartGroup.changed(switchColors2)) {
                    }
                    i3 |= i13;
                } else {
                    switchColors2 = switchColors;
                }
                i3 |= i13;
            } else {
                switchColors2 = switchColors;
            }
            i8 = i3;
            if ((74899 & i3) != 74898) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i8 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "98@4526L8");
                snapshotMutationPolicy = null;
                if ((i & 1) != 0) {
                    if (i12 != 0) {
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
                        mutableInteractionSource2 = null;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource2;
                    }
                    if ((i2 & 32) != 0) {
                        snapshotMutationPolicy = null;
                        z7 = false;
                        SwitchColors switchColorsM2598colorsSQMK_m9 = SwitchDefaults.INSTANCE.m2598colorsSQMK_m0(0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                        composerStartRestartGroup = composerStartRestartGroup;
                        i9 = i8 & (-458753);
                        z3 = z6;
                        switchColors2 = switchColorsM2598colorsSQMK_m9;
                        modifier2 = companion;
                    } else {
                        snapshotMutationPolicy = null;
                        z7 = false;
                        modifier2 = companion;
                        z3 = z6;
                        switchColors2 = switchColors2;
                        i9 = i8;
                    }
                } else {
                    if (i12 != 0) {
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
                        mutableInteractionSource2 = null;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource2;
                    }
                    if ((i2 & 32) != 0) {
                        snapshotMutationPolicy = null;
                        z7 = false;
                        SwitchColors switchColorsM2598colorsSQMK_m10 = SwitchDefaults.INSTANCE.m2598colorsSQMK_m0(0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                        composerStartRestartGroup = composerStartRestartGroup;
                        i9 = i8 & (-458753);
                        z3 = z6;
                        switchColors2 = switchColorsM2598colorsSQMK_m10;
                        modifier2 = companion;
                    } else {
                        snapshotMutationPolicy = null;
                        z7 = false;
                        modifier2 = companion;
                        z3 = z6;
                        switchColors2 = switchColors2;
                        i9 = i8;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(25866825, i9, -1, "androidx.compose.material.Switch (Switch.kt:99)");
                }
                if (mutableInteractionSource2 == null) {
                    composerStartRestartGroup.startReplaceGroup(1799771122);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "101@4621L39");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -911774192, "CC(remember):Switch.kt#9igjgp");
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue5;
                } else {
                    composerStartRestartGroup.startReplaceGroup(-911774843);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource4 = mutableInteractionSource2;
                }
                ProvidableCompositionLocal<Density> localDensity11 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume12 = composerStartRestartGroup.consume(localDensity11);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                fMo754toPx0680j_4 = ((Density) objConsume12).mo754toPx0680j_4(ThumbPathLength);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -911758805, "CC(remember):Switch.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z7), snapshotMutationPolicy, 2, snapshotMutationPolicy);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ProvidableCompositionLocal<Density> localDensity12 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume13 = composerStartRestartGroup.consume(localDensity12);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                fMo754toPx0680j_5 = ((Density) objConsume13).mo754toPx0680j_4(SwitchVelocityThreshold);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -911752747, "CC(remember):Switch.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(fMo754toPx0680j_4) | composerStartRestartGroup.changed(fMo754toPx0680j_5);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    final float f10 = 0.0f;
                    objRememberedValue2 = new AnchoredDraggableState(Boolean.valueOf(z), AnchoredDraggableKt.DraggableAnchors(new Function1() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj3) {
                            return SwitchKt.Switch$lambda$6$0(f10, fMo754toPx0680j_4, (DraggableAnchorsConfig) obj3);
                        }
                    }), new Function1() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj3) {
                            return Float.valueOf(SwitchKt.Switch$lambda$6$1(((Float) obj3).floatValue()));
                        }
                    }, new Function0() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(SwitchKt.Switch$lambda$6$2(fMo754toPx0680j_5));
                        }
                    }, AnimationSpec, null, 32, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    final float f11 = 0.0f;
                    objRememberedValue2 = new AnchoredDraggableState(Boolean.valueOf(z), AnchoredDraggableKt.DraggableAnchors(new Function1() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj3) {
                            return SwitchKt.Switch$lambda$6$0(f11, fMo754toPx0680j_4, (DraggableAnchorsConfig) obj3);
                        }
                    }), new Function1() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj3) {
                            return Float.valueOf(SwitchKt.Switch$lambda$6$1(((Float) obj3).floatValue()));
                        }
                    }, new Function0() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(SwitchKt.Switch$lambda$6$2(fMo754toPx0680j_5));
                        }
                    }, AnimationSpec, null, 32, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                anchoredDraggableState = (AnchoredDraggableState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i19 = i9 >> 3;
                stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function1, composerStartRestartGroup, i19 & 14);
                i10 = i9 & 14;
                stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf(z), composerStartRestartGroup, i10);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -911730684, "CC(remember):Switch.kt#9igjgp");
                zChanged2 = composerStartRestartGroup.changed(anchoredDraggableState) | composerStartRestartGroup.changed(stateRememberUpdatedState2) | composerStartRestartGroup.changed(stateRememberUpdatedState);
                Object objRememberedValue11 = composerStartRestartGroup.rememberedValue();
                if (zChanged2) {
                    Object switchKt$Switch$1$10 = new SwitchKt$Switch$1$1(anchoredDraggableState, stateRememberUpdatedState2, stateRememberUpdatedState, mutableState, null);
                    anchoredDraggableState2 = anchoredDraggableState;
                    obj = (Function2) switchKt$Switch$1$10;
                    composerStartRestartGroup.updateRememberedValue(obj);
                } else {
                    Object switchKt$Switch$1$11 = new SwitchKt$Switch$1$1(anchoredDraggableState, stateRememberUpdatedState2, stateRememberUpdatedState, mutableState, null);
                    anchoredDraggableState2 = anchoredDraggableState;
                    obj = (Function2) switchKt$Switch$1$11;
                    composerStartRestartGroup.updateRememberedValue(obj);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(anchoredDraggableState2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) obj, composerStartRestartGroup, z7 ? 1 : 0);
                Boolean boolValueOf11 = Boolean.valueOf(z);
                Boolean boolValueOf12 = Boolean.valueOf(Switch$lambda$3(mutableState));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -911719186, "CC(remember):Switch.kt#9igjgp");
                if (i10 == 4) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                zChanged3 = z8 | composerStartRestartGroup.changed(anchoredDraggableState2);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged3) {
                    obj2 = null;
                    objRememberedValue3 = (Function2) new SwitchKt$Switch$2$1(z, anchoredDraggableState2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    obj2 = null;
                    objRememberedValue3 = (Function2) new SwitchKt$Switch$2$1(z, anchoredDraggableState2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(boolValueOf11, boolValueOf12, (Function2) objRememberedValue3, composerStartRestartGroup, i10);
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection6 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                objConsume = composerStartRestartGroup.consume(localLayoutDirection6);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (objConsume == LayoutDirection.Rtl) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                if (function1 != null) {
                    z5 = z3;
                    mutableInteractionSource5 = mutableInteractionSource4;
                    i11 = 2;
                    z10 = false;
                    companionM1540toggleableO2vRcR0 = ToggleableKt.m1540toggleableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource5, null, z5, Role.m8825boximpl(Role.INSTANCE.m8838getSwitcho7Vup1c()), function1);
                } else {
                    z5 = z3;
                    mutableInteractionSource5 = mutableInteractionSource4;
                    i11 = 2;
                    z10 = false;
                    companionM1540toggleableO2vRcR0 = Modifier.INSTANCE;
                }
                if (function1 != null) {
                    companionMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE);
                } else {
                    companionMinimumInteractiveComponentSize = Modifier.INSTANCE;
                }
                Modifier modifierThen6 = modifier2.then(companionMinimumInteractiveComponentSize).then(companionM1540toggleableO2vRcR0);
                boolean z16 = z10;
                anchoredDraggableState3 = anchoredDraggableState2;
                Modifier modifierM1260requiredSizeVpY3zN9 = SizeKt.m1260requiredSizeVpY3zN4(PaddingKt.m1218padding3ABfNKs(SizeKt.wrapContentSize$default(AnchoredDraggableKt.anchoredDraggable(modifierThen6, anchoredDraggableState2, Orientation.Horizontal, (z5 || function1 == null) ? z10 : true, z9, mutableInteractionSource5, false), Alignment.INSTANCE.getCenter(), z16, i11, obj2), DefaultSwitchPadding), SwitchWidth, SwitchHeight);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy6 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), z16);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, z16 ? 1 : 0);
                CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1260requiredSizeVpY3zN9);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl.getInserting()) {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier6, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance6 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 351089009, "C181@7892L42,177@7737L259:Switch.kt#jmzs0o");
                boolean zBooleanValue6 = ((Boolean) anchoredDraggableState3.getTargetValue()).booleanValue();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1928332455, "CC(remember):Switch.kt#9igjgp");
                zChanged4 = composerStartRestartGroup.changed(anchoredDraggableState3);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChanged4) {
                    objRememberedValue4 = new Function0() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(anchoredDraggableState3.requireOffset());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function0() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(anchoredDraggableState3.requireOffset());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifier9 = modifier2;
                SwitchImpl(boxScopeInstance6, zBooleanValue6, z5, switchColors2, (Function0) objRememberedValue4, mutableInteractionSource5, composerStartRestartGroup, (i19 & 896) | 6 | ((i9 >> 6) & 7168));
                composer2 = composerStartRestartGroup;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier9;
                switchColors3 = switchColors2;
                mutableInteractionSource3 = mutableInteractionSource2;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                z5 = z3;
                mutableInteractionSource3 = mutableInteractionSource2;
                switchColors3 = switchColors2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj3, Object obj4) {
                        return SwitchKt.Switch$lambda$12(z, function1, modifier3, z5, mutableInteractionSource3, switchColors3, i, i2, (Composer) obj3, ((Integer) obj4).intValue());
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
                    switchColors2 = switchColors;
                    if (composerStartRestartGroup.changed(switchColors2)) {
                    }
                    i3 |= i13;
                } else {
                    switchColors2 = switchColors;
                }
                i3 |= i13;
            } else {
                switchColors2 = switchColors;
            }
            i8 = i3;
            if ((74899 & i3) != 74898) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i8 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "98@4526L8");
                snapshotMutationPolicy = null;
                if ((i & 1) != 0) {
                    if (i12 != 0) {
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
                        mutableInteractionSource2 = null;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource2;
                    }
                    if ((i2 & 32) != 0) {
                        snapshotMutationPolicy = null;
                        z7 = false;
                        SwitchColors switchColorsM2598colorsSQMK_m11 = SwitchDefaults.INSTANCE.m2598colorsSQMK_m0(0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                        composerStartRestartGroup = composerStartRestartGroup;
                        i9 = i8 & (-458753);
                        z3 = z6;
                        switchColors2 = switchColorsM2598colorsSQMK_m11;
                        modifier2 = companion;
                    } else {
                        snapshotMutationPolicy = null;
                        z7 = false;
                        modifier2 = companion;
                        z3 = z6;
                        switchColors2 = switchColors2;
                        i9 = i8;
                    }
                } else {
                    if (i12 != 0) {
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
                        mutableInteractionSource2 = null;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource2;
                    }
                    if ((i2 & 32) != 0) {
                        snapshotMutationPolicy = null;
                        z7 = false;
                        SwitchColors switchColorsM2598colorsSQMK_m12 = SwitchDefaults.INSTANCE.m2598colorsSQMK_m0(0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                        composerStartRestartGroup = composerStartRestartGroup;
                        i9 = i8 & (-458753);
                        z3 = z6;
                        switchColors2 = switchColorsM2598colorsSQMK_m12;
                        modifier2 = companion;
                    } else {
                        snapshotMutationPolicy = null;
                        z7 = false;
                        modifier2 = companion;
                        z3 = z6;
                        switchColors2 = switchColors2;
                        i9 = i8;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(25866825, i9, -1, "androidx.compose.material.Switch (Switch.kt:99)");
                }
                if (mutableInteractionSource2 == null) {
                    composerStartRestartGroup.startReplaceGroup(1799771122);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "101@4621L39");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -911774192, "CC(remember):Switch.kt#9igjgp");
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue5;
                } else {
                    composerStartRestartGroup.startReplaceGroup(-911774843);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource4 = mutableInteractionSource2;
                }
                ProvidableCompositionLocal<Density> localDensity13 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume14 = composerStartRestartGroup.consume(localDensity13);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                fMo754toPx0680j_4 = ((Density) objConsume14).mo754toPx0680j_4(ThumbPathLength);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -911758805, "CC(remember):Switch.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z7), snapshotMutationPolicy, 2, snapshotMutationPolicy);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ProvidableCompositionLocal<Density> localDensity14 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume15 = composerStartRestartGroup.consume(localDensity14);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                fMo754toPx0680j_5 = ((Density) objConsume15).mo754toPx0680j_4(SwitchVelocityThreshold);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -911752747, "CC(remember):Switch.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(fMo754toPx0680j_4) | composerStartRestartGroup.changed(fMo754toPx0680j_5);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    final float f12 = 0.0f;
                    objRememberedValue2 = new AnchoredDraggableState(Boolean.valueOf(z), AnchoredDraggableKt.DraggableAnchors(new Function1() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj3) {
                            return SwitchKt.Switch$lambda$6$0(f12, fMo754toPx0680j_4, (DraggableAnchorsConfig) obj3);
                        }
                    }), new Function1() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj3) {
                            return Float.valueOf(SwitchKt.Switch$lambda$6$1(((Float) obj3).floatValue()));
                        }
                    }, new Function0() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(SwitchKt.Switch$lambda$6$2(fMo754toPx0680j_5));
                        }
                    }, AnimationSpec, null, 32, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    final float f13 = 0.0f;
                    objRememberedValue2 = new AnchoredDraggableState(Boolean.valueOf(z), AnchoredDraggableKt.DraggableAnchors(new Function1() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj3) {
                            return SwitchKt.Switch$lambda$6$0(f13, fMo754toPx0680j_4, (DraggableAnchorsConfig) obj3);
                        }
                    }), new Function1() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj3) {
                            return Float.valueOf(SwitchKt.Switch$lambda$6$1(((Float) obj3).floatValue()));
                        }
                    }, new Function0() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(SwitchKt.Switch$lambda$6$2(fMo754toPx0680j_5));
                        }
                    }, AnimationSpec, null, 32, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                anchoredDraggableState = (AnchoredDraggableState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i110 = i9 >> 3;
                stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function1, composerStartRestartGroup, i110 & 14);
                i10 = i9 & 14;
                stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf(z), composerStartRestartGroup, i10);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -911730684, "CC(remember):Switch.kt#9igjgp");
                zChanged2 = composerStartRestartGroup.changed(anchoredDraggableState) | composerStartRestartGroup.changed(stateRememberUpdatedState2) | composerStartRestartGroup.changed(stateRememberUpdatedState);
                Object objRememberedValue12 = composerStartRestartGroup.rememberedValue();
                if (zChanged2) {
                    Object switchKt$Switch$1$12 = new SwitchKt$Switch$1$1(anchoredDraggableState, stateRememberUpdatedState2, stateRememberUpdatedState, mutableState, null);
                    anchoredDraggableState2 = anchoredDraggableState;
                    obj = (Function2) switchKt$Switch$1$12;
                    composerStartRestartGroup.updateRememberedValue(obj);
                } else {
                    Object switchKt$Switch$1$13 = new SwitchKt$Switch$1$1(anchoredDraggableState, stateRememberUpdatedState2, stateRememberUpdatedState, mutableState, null);
                    anchoredDraggableState2 = anchoredDraggableState;
                    obj = (Function2) switchKt$Switch$1$13;
                    composerStartRestartGroup.updateRememberedValue(obj);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(anchoredDraggableState2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) obj, composerStartRestartGroup, z7 ? 1 : 0);
                Boolean boolValueOf13 = Boolean.valueOf(z);
                Boolean boolValueOf14 = Boolean.valueOf(Switch$lambda$3(mutableState));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -911719186, "CC(remember):Switch.kt#9igjgp");
                if (i10 == 4) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                zChanged3 = z8 | composerStartRestartGroup.changed(anchoredDraggableState2);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged3) {
                    obj2 = null;
                    objRememberedValue3 = (Function2) new SwitchKt$Switch$2$1(z, anchoredDraggableState2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    obj2 = null;
                    objRememberedValue3 = (Function2) new SwitchKt$Switch$2$1(z, anchoredDraggableState2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(boolValueOf13, boolValueOf14, (Function2) objRememberedValue3, composerStartRestartGroup, i10);
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection7 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                objConsume = composerStartRestartGroup.consume(localLayoutDirection7);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (objConsume == LayoutDirection.Rtl) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                if (function1 != null) {
                    z5 = z3;
                    mutableInteractionSource5 = mutableInteractionSource4;
                    i11 = 2;
                    z10 = false;
                    companionM1540toggleableO2vRcR0 = ToggleableKt.m1540toggleableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource5, null, z5, Role.m8825boximpl(Role.INSTANCE.m8838getSwitcho7Vup1c()), function1);
                } else {
                    z5 = z3;
                    mutableInteractionSource5 = mutableInteractionSource4;
                    i11 = 2;
                    z10 = false;
                    companionM1540toggleableO2vRcR0 = Modifier.INSTANCE;
                }
                if (function1 != null) {
                    companionMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE);
                } else {
                    companionMinimumInteractiveComponentSize = Modifier.INSTANCE;
                }
                Modifier modifierThen7 = modifier2.then(companionMinimumInteractiveComponentSize).then(companionM1540toggleableO2vRcR0);
                boolean z17 = z10;
                anchoredDraggableState3 = anchoredDraggableState2;
                Modifier modifierM1260requiredSizeVpY3zN10 = SizeKt.m1260requiredSizeVpY3zN4(PaddingKt.m1218padding3ABfNKs(SizeKt.wrapContentSize$default(AnchoredDraggableKt.anchoredDraggable(modifierThen7, anchoredDraggableState2, Orientation.Horizontal, (z5 || function1 == null) ? z10 : true, z9, mutableInteractionSource5, false), Alignment.INSTANCE.getCenter(), z17, i11, obj2), DefaultSwitchPadding), SwitchWidth, SwitchHeight);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy7 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), z17);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, z17 ? 1 : 0);
                CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1260requiredSizeVpY3zN10);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl.getInserting()) {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier7, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance7 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 351089009, "C181@7892L42,177@7737L259:Switch.kt#jmzs0o");
                boolean zBooleanValue7 = ((Boolean) anchoredDraggableState3.getTargetValue()).booleanValue();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1928332455, "CC(remember):Switch.kt#9igjgp");
                zChanged4 = composerStartRestartGroup.changed(anchoredDraggableState3);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChanged4) {
                    objRememberedValue4 = new Function0() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(anchoredDraggableState3.requireOffset());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function0() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(anchoredDraggableState3.requireOffset());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifier10 = modifier2;
                SwitchImpl(boxScopeInstance7, zBooleanValue7, z5, switchColors2, (Function0) objRememberedValue4, mutableInteractionSource5, composerStartRestartGroup, (i110 & 896) | 6 | ((i9 >> 6) & 7168));
                composer2 = composerStartRestartGroup;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier10;
                switchColors3 = switchColors2;
                mutableInteractionSource3 = mutableInteractionSource2;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                z5 = z3;
                mutableInteractionSource3 = mutableInteractionSource2;
                switchColors3 = switchColors2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj3, Object obj4) {
                        return SwitchKt.Switch$lambda$12(z, function1, modifier3, z5, mutableInteractionSource3, switchColors3, i, i2, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        mutableInteractionSource2 = mutableInteractionSource;
        if ((196608 & i) == 0) {
            if ((i2 & 32) == 0) {
                switchColors2 = switchColors;
                if (composerStartRestartGroup.changed(switchColors2)) {
                }
                i3 |= i13;
            } else {
                switchColors2 = switchColors;
            }
            i3 |= i13;
        } else {
            switchColors2 = switchColors;
        }
        i8 = i3;
        if ((74899 & i3) != 74898) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z4, i8 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "98@4526L8");
            snapshotMutationPolicy = null;
            if ((i & 1) != 0) {
                if (i12 != 0) {
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
                    mutableInteractionSource2 = null;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource2;
                }
                if ((i2 & 32) != 0) {
                    snapshotMutationPolicy = null;
                    z7 = false;
                    SwitchColors switchColorsM2598colorsSQMK_m13 = SwitchDefaults.INSTANCE.m2598colorsSQMK_m0(0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                    composerStartRestartGroup = composerStartRestartGroup;
                    i9 = i8 & (-458753);
                    z3 = z6;
                    switchColors2 = switchColorsM2598colorsSQMK_m13;
                    modifier2 = companion;
                } else {
                    snapshotMutationPolicy = null;
                    z7 = false;
                    modifier2 = companion;
                    z3 = z6;
                    switchColors2 = switchColors2;
                    i9 = i8;
                }
            } else {
                if (i12 != 0) {
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
                    mutableInteractionSource2 = null;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource2;
                }
                if ((i2 & 32) != 0) {
                    snapshotMutationPolicy = null;
                    z7 = false;
                    SwitchColors switchColorsM2598colorsSQMK_m14 = SwitchDefaults.INSTANCE.m2598colorsSQMK_m0(0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                    composerStartRestartGroup = composerStartRestartGroup;
                    i9 = i8 & (-458753);
                    z3 = z6;
                    switchColors2 = switchColorsM2598colorsSQMK_m14;
                    modifier2 = companion;
                } else {
                    snapshotMutationPolicy = null;
                    z7 = false;
                    modifier2 = companion;
                    z3 = z6;
                    switchColors2 = switchColors2;
                    i9 = i8;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(25866825, i9, -1, "androidx.compose.material.Switch (Switch.kt:99)");
            }
            if (mutableInteractionSource2 == null) {
                composerStartRestartGroup.startReplaceGroup(1799771122);
                ComposerKt.sourceInformation(composerStartRestartGroup, "101@4621L39");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -911774192, "CC(remember):Switch.kt#9igjgp");
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
                mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue5;
            } else {
                composerStartRestartGroup.startReplaceGroup(-911774843);
                composerStartRestartGroup.endReplaceGroup();
                mutableInteractionSource4 = mutableInteractionSource2;
            }
            ProvidableCompositionLocal<Density> localDensity15 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume16 = composerStartRestartGroup.consume(localDensity15);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            fMo754toPx0680j_4 = ((Density) objConsume16).mo754toPx0680j_4(ThumbPathLength);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -911758805, "CC(remember):Switch.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z7), snapshotMutationPolicy, 2, snapshotMutationPolicy);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ProvidableCompositionLocal<Density> localDensity16 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume17 = composerStartRestartGroup.consume(localDensity16);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            fMo754toPx0680j_5 = ((Density) objConsume17).mo754toPx0680j_4(SwitchVelocityThreshold);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -911752747, "CC(remember):Switch.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(fMo754toPx0680j_4) | composerStartRestartGroup.changed(fMo754toPx0680j_5);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                final float f14 = 0.0f;
                objRememberedValue2 = new AnchoredDraggableState(Boolean.valueOf(z), AnchoredDraggableKt.DraggableAnchors(new Function1() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj3) {
                        return SwitchKt.Switch$lambda$6$0(f14, fMo754toPx0680j_4, (DraggableAnchorsConfig) obj3);
                    }
                }), new Function1() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj3) {
                        return Float.valueOf(SwitchKt.Switch$lambda$6$1(((Float) obj3).floatValue()));
                    }
                }, new Function0() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Float.valueOf(SwitchKt.Switch$lambda$6$2(fMo754toPx0680j_5));
                    }
                }, AnimationSpec, null, 32, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                final float f15 = 0.0f;
                objRememberedValue2 = new AnchoredDraggableState(Boolean.valueOf(z), AnchoredDraggableKt.DraggableAnchors(new Function1() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj3) {
                        return SwitchKt.Switch$lambda$6$0(f15, fMo754toPx0680j_4, (DraggableAnchorsConfig) obj3);
                    }
                }), new Function1() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj3) {
                        return Float.valueOf(SwitchKt.Switch$lambda$6$1(((Float) obj3).floatValue()));
                    }
                }, new Function0() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Float.valueOf(SwitchKt.Switch$lambda$6$2(fMo754toPx0680j_5));
                    }
                }, AnimationSpec, null, 32, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            anchoredDraggableState = (AnchoredDraggableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i111 = i9 >> 3;
            stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function1, composerStartRestartGroup, i111 & 14);
            i10 = i9 & 14;
            stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf(z), composerStartRestartGroup, i10);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -911730684, "CC(remember):Switch.kt#9igjgp");
            zChanged2 = composerStartRestartGroup.changed(anchoredDraggableState) | composerStartRestartGroup.changed(stateRememberUpdatedState2) | composerStartRestartGroup.changed(stateRememberUpdatedState);
            Object objRememberedValue13 = composerStartRestartGroup.rememberedValue();
            if (zChanged2) {
                Object switchKt$Switch$1$14 = new SwitchKt$Switch$1$1(anchoredDraggableState, stateRememberUpdatedState2, stateRememberUpdatedState, mutableState, null);
                anchoredDraggableState2 = anchoredDraggableState;
                obj = (Function2) switchKt$Switch$1$14;
                composerStartRestartGroup.updateRememberedValue(obj);
            } else {
                Object switchKt$Switch$1$15 = new SwitchKt$Switch$1$1(anchoredDraggableState, stateRememberUpdatedState2, stateRememberUpdatedState, mutableState, null);
                anchoredDraggableState2 = anchoredDraggableState;
                obj = (Function2) switchKt$Switch$1$15;
                composerStartRestartGroup.updateRememberedValue(obj);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(anchoredDraggableState2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) obj, composerStartRestartGroup, z7 ? 1 : 0);
            Boolean boolValueOf15 = Boolean.valueOf(z);
            Boolean boolValueOf16 = Boolean.valueOf(Switch$lambda$3(mutableState));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -911719186, "CC(remember):Switch.kt#9igjgp");
            if (i10 == 4) {
                z8 = true;
            } else {
                z8 = false;
            }
            zChanged3 = z8 | composerStartRestartGroup.changed(anchoredDraggableState2);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged3) {
                obj2 = null;
                objRememberedValue3 = (Function2) new SwitchKt$Switch$2$1(z, anchoredDraggableState2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                obj2 = null;
                objRememberedValue3 = (Function2) new SwitchKt$Switch$2$1(z, anchoredDraggableState2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(boolValueOf15, boolValueOf16, (Function2) objRememberedValue3, composerStartRestartGroup, i10);
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection8 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            objConsume = composerStartRestartGroup.consume(localLayoutDirection8);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (objConsume == LayoutDirection.Rtl) {
                z9 = true;
            } else {
                z9 = false;
            }
            if (function1 != null) {
                z5 = z3;
                mutableInteractionSource5 = mutableInteractionSource4;
                i11 = 2;
                z10 = false;
                companionM1540toggleableO2vRcR0 = ToggleableKt.m1540toggleableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource5, null, z5, Role.m8825boximpl(Role.INSTANCE.m8838getSwitcho7Vup1c()), function1);
            } else {
                z5 = z3;
                mutableInteractionSource5 = mutableInteractionSource4;
                i11 = 2;
                z10 = false;
                companionM1540toggleableO2vRcR0 = Modifier.INSTANCE;
            }
            if (function1 != null) {
                companionMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE);
            } else {
                companionMinimumInteractiveComponentSize = Modifier.INSTANCE;
            }
            Modifier modifierThen8 = modifier2.then(companionMinimumInteractiveComponentSize).then(companionM1540toggleableO2vRcR0);
            boolean z18 = z10;
            anchoredDraggableState3 = anchoredDraggableState2;
            Modifier modifierM1260requiredSizeVpY3zN11 = SizeKt.m1260requiredSizeVpY3zN4(PaddingKt.m1218padding3ABfNKs(SizeKt.wrapContentSize$default(AnchoredDraggableKt.anchoredDraggable(modifierThen8, anchoredDraggableState2, Orientation.Horizontal, (z5 || function1 == null) ? z10 : true, z9, mutableInteractionSource5, false), Alignment.INSTANCE.getCenter(), z18, i11, obj2), DefaultSwitchPadding), SwitchWidth, SwitchHeight);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy8 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), z18);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, z18 ? 1 : 0);
            CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1260requiredSizeVpY3zN11);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM6062constructorimpl.getInserting()) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier8, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance8 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 351089009, "C181@7892L42,177@7737L259:Switch.kt#jmzs0o");
            boolean zBooleanValue8 = ((Boolean) anchoredDraggableState3.getTargetValue()).booleanValue();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1928332455, "CC(remember):Switch.kt#9igjgp");
            zChanged4 = composerStartRestartGroup.changed(anchoredDraggableState3);
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (!zChanged4) {
                objRememberedValue4 = new Function0() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Float.valueOf(anchoredDraggableState3.requireOffset());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = new Function0() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Float.valueOf(anchoredDraggableState3.requireOffset());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifier11 = modifier2;
            SwitchImpl(boxScopeInstance8, zBooleanValue8, z5, switchColors2, (Function0) objRememberedValue4, mutableInteractionSource5, composerStartRestartGroup, (i111 & 896) | 6 | ((i9 >> 6) & 7168));
            composer2 = composerStartRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier11;
            switchColors3 = switchColors2;
            mutableInteractionSource3 = mutableInteractionSource2;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            z5 = z3;
            mutableInteractionSource3 = mutableInteractionSource2;
            switchColors3 = switchColors2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj3, Object obj4) {
                    return SwitchKt.Switch$lambda$12(z, function1, modifier3, z5, mutableInteractionSource3, switchColors3, i, i2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Switch$lambda$3(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Switch$lambda$4(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Switch$lambda$6$0(float f, float f2, DraggableAnchorsConfig draggableAnchorsConfig) {
        draggableAnchorsConfig.at(false, f);
        draggableAnchorsConfig.at(true, f2);
        return Unit.INSTANCE;
    }

    private static final void SwitchImpl(final BoxScope boxScope, final boolean z, final boolean z2, final SwitchColors switchColors, final Function0<Float> function0, final InteractionSource interactionSource, Composer composer, final int i) {
        int i2;
        float f;
        boolean z3;
        long jSwitchImpl$lambda$4;
        Composer composerStartRestartGroup = composer.startRestartGroup(70908914);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SwitchImpl)N(checked,enabled,colors,thumbValue,interactionSource)220@9074L46,222@9160L614,222@9126L648,242@10001L28,243@10089L81,243@10034L136,246@10200L28,247@10278L7,248@10337L7,251@10460L6,250@10395L252,259@10726L43,257@10652L455:Switch.kt#jmzs0o");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(boxScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(switchColors) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(interactionSource) ? 131072 : 65536;
        }
        int i3 = i2;
        if (!composerStartRestartGroup.shouldExecute((74899 & i3) != 74898, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(70908914, i3, -1, "androidx.compose.material.SwitchImpl (Switch.kt:219)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -576004160, "CC(remember):Switch.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt.mutableStateListOf();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            SnapshotStateList snapshotStateList = (SnapshotStateList) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -576000840, "CC(remember):Switch.kt#9igjgp");
            boolean z4 = (458752 & i3) == 131072;
            SwitchKt$SwitchImpl$1$1 switchKt$SwitchImpl$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (z4 || switchKt$SwitchImpl$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                switchKt$SwitchImpl$1$1RememberedValue = new SwitchKt$SwitchImpl$1$1(interactionSource, snapshotStateList, null);
                composerStartRestartGroup.updateRememberedValue(switchKt$SwitchImpl$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(interactionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) switchKt$SwitchImpl$1$1RememberedValue, composerStartRestartGroup, (i3 >> 15) & 14);
            if (!snapshotStateList.isEmpty()) {
                f = ThumbPressedElevation;
            } else {
                f = ThumbDefaultElevation;
            }
            float f2 = f;
            int i4 = ((i3 >> 6) & 14) | (i3 & 112) | ((i3 >> 3) & 896);
            final State<Color> stateTrackColor = switchColors.trackColor(z2, z, composerStartRestartGroup, i4);
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(boxScope.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenter()), 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -575971645, "CC(remember):Switch.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(stateTrackColor);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SwitchKt.SwitchImpl$lambda$3$0(stateTrackColor, (DrawScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            CanvasKt.Canvas(modifierFillMaxSize$default, (Function1) objRememberedValue2, composerStartRestartGroup, 0);
            State<Color> stateThumbColor = switchColors.thumbColor(z2, z, composerStartRestartGroup, i4);
            ProvidableCompositionLocal<ElevationOverlay> localElevationOverlay = ElevationOverlayKt.getLocalElevationOverlay();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localElevationOverlay);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ElevationOverlay elevationOverlay = (ElevationOverlay) objConsume;
            ProvidableCompositionLocal<Dp> localAbsoluteElevation = ElevationOverlayKt.getLocalAbsoluteElevation();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localAbsoluteElevation);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            float fM9687constructorimpl = Dp.m9687constructorimpl(((Dp) objConsume2).m9701unboximpl() + f2);
            if (Color.m6815equalsimpl0(SwitchImpl$lambda$4(stateThumbColor), MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU()) && elevationOverlay != null) {
                composerStartRestartGroup.startReplaceGroup(-674840005);
                ComposerKt.sourceInformation(composerStartRestartGroup, "252@10539L36");
                z3 = true;
                jSwitchImpl$lambda$4 = elevationOverlay.mo2378apply7g2Lkgo(SwitchImpl$lambda$4(stateThumbColor), fM9687constructorimpl, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                z3 = true;
                composerStartRestartGroup.startReplaceGroup(-674751066);
                composerStartRestartGroup.endReplaceGroup();
                jSwitchImpl$lambda$4 = SwitchImpl$lambda$4(stateThumbColor);
            }
            State<Color> stateM437animateColorAsStateeuL9pac = SingleValueAnimationKt.m437animateColorAsStateeuL9pac(jSwitchImpl$lambda$4, null, null, null, composerStartRestartGroup, 0, 14);
            composerStartRestartGroup = composerStartRestartGroup;
            Modifier modifierAlign = boxScope.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenterStart());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -575951299, "CC(remember):Switch.kt#9igjgp");
            boolean z5 = (57344 & i3) == 16384 ? z3 : false;
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z5 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SwitchKt.SwitchImpl$lambda$6$0(function0, (Density) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SpacerKt.Spacer(BackgroundKt.m588backgroundbw27NRU(ShadowKt.m6412shadows4CzXII$default(SizeKt.m1258requiredSize3ABfNKs(IndicationKt.indication(OffsetKt.offset(modifierAlign, (Function1) objRememberedValue3), interactionSource, RippleKt.m2523rippleH2RKhps$default(false, ThumbRippleRadius, 0L, 4, null)), ThumbDiameter), f2, RoundedCornerShapeKt.getCircleShape(), false, 0L, 0L, 24, null), SwitchImpl$lambda$5(stateM437animateColorAsStateeuL9pac), RoundedCornerShapeKt.getCircleShape()), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SwitchKt.SwitchImpl$lambda$7(boxScope, z, z2, switchColors, function0, interactionSource, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SwitchImpl$lambda$3$0(State state, DrawScope drawScope) {
        m2601drawTrackRPmYEkk(drawScope, SwitchImpl$lambda$2(state), drawScope.mo754toPx0680j_4(TrackWidth), drawScope.mo754toPx0680j_4(TrackStrokeWidth));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntOffset SwitchImpl$lambda$6$0(Function0 function0, Density density) {
        return IntOffset.m9806boximpl(IntOffset.m9809constructorimpl((((long) MathKt.roundToInt(((Number) function0.invoke()).floatValue())) << 32) | (((long) 0) & 4294967295L)));
    }

    /* JADX INFO: renamed from: drawTrack-RPmYEkk, reason: not valid java name */
    private static final void m2601drawTrackRPmYEkk(DrawScope drawScope, long j, float f, float f2) {
        float f3 = f2 / 2;
        DrawScope.m7381drawLineNGM6Ib0$default(drawScope, j, Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo7394getCenterF1C5BW0() & 4294967295L)))) & 4294967295L) | (Float.floatToRawIntBits(f3) << 32)), Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo7394getCenterF1C5BW0() & 4294967295L)))) & 4294967295L) | (Float.floatToRawIntBits(f - f3) << 32)), f2, StrokeCap.INSTANCE.m7191getRoundKaPHkGw(), null, 0.0f, null, 0, WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND, null);
    }

    public static final float getTrackWidth() {
        return TrackWidth;
    }

    public static final float getTrackStrokeWidth() {
        return TrackStrokeWidth;
    }

    public static final float getThumbDiameter() {
        return ThumbDiameter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function1<Boolean, Unit> Switch$lambda$7(State<? extends Function1<? super Boolean, Unit>> state) {
        return (Function1) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Switch$lambda$8(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final long SwitchImpl$lambda$2(State<Color> state) {
        return state.getValue().m6824unboximpl();
    }

    private static final long SwitchImpl$lambda$4(State<Color> state) {
        return state.getValue().m6824unboximpl();
    }

    private static final long SwitchImpl$lambda$5(State<Color> state) {
        return state.getValue().m6824unboximpl();
    }

    static {
        float fM9687constructorimpl = Dp.m9687constructorimpl(34);
        TrackWidth = fM9687constructorimpl;
        TrackStrokeWidth = Dp.m9687constructorimpl(14);
        float fM9687constructorimpl2 = Dp.m9687constructorimpl(20);
        ThumbDiameter = fM9687constructorimpl2;
        ThumbRippleRadius = Dp.m9687constructorimpl(24);
        DefaultSwitchPadding = Dp.m9687constructorimpl(2);
        SwitchWidth = fM9687constructorimpl;
        SwitchHeight = fM9687constructorimpl2;
        ThumbPathLength = Dp.m9687constructorimpl(fM9687constructorimpl - fM9687constructorimpl2);
        AnimationSpec = new TweenSpec<>(100, 0, null, 6, null);
        ThumbDefaultElevation = Dp.m9687constructorimpl(1);
        ThumbPressedElevation = Dp.m9687constructorimpl(6);
        SwitchVelocityThreshold = Dp.m9687constructorimpl(125);
    }
}
