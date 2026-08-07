package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.foundation.ProgressSemanticsKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.internal.AccessibilityUtilKt;
import androidx.compose.material3.internal.CircularWavyProgressModifiersKt;
import androidx.compose.material3.internal.LinearWavyProgressModifiersKt;
import androidx.compose.material3.tokens.MotionTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.ProgressBarRangeInfo;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.media3.common.C;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: WavyProgressIndicator.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u009c\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2#\b\u0002\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\u00040\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001ai\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0003\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0014\u001a\u00020\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0092\u0001\u0010\u001a\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2#\b\u0002\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\u00040\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u001b\u0010\u001c\u001ai\u0010\u001a\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0003\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0014\u001a\u00020\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u001d\u0010\u0019\"\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u001fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!\"\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040\u001fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010!¨\u0006$"}, d2 = {"LinearWavyProgressIndicator", "", "progress", "Lkotlin/Function0;", "", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "trackColor", "stroke", "Landroidx/compose/ui/graphics/drawscope/Stroke;", "trackStroke", "gapSize", "Landroidx/compose/ui/unit/Dp;", "stopSize", "amplitude", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "wavelength", "waveSpeed", "LinearWavyProgressIndicator-1YwxWKA", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/ui/graphics/drawscope/Stroke;FFLkotlin/jvm/functions/Function1;FFLandroidx/compose/runtime/Composer;III)V", "LinearWavyProgressIndicator-hvuEXSk", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/ui/graphics/drawscope/Stroke;FFFFLandroidx/compose/runtime/Composer;II)V", "CircularWavyProgressIndicator", "CircularWavyProgressIndicator-L8eD4gc", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/ui/graphics/drawscope/Stroke;FLkotlin/jvm/functions/Function1;FFLandroidx/compose/runtime/Composer;II)V", "CircularWavyProgressIndicator-hvuEXSk", "IncreasingAmplitudeAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "getIncreasingAmplitudeAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "DecreasingAmplitudeAnimationSpec", "getDecreasingAmplitudeAnimationSpec", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class WavyProgressIndicatorKt {
    private static final AnimationSpec<Float> IncreasingAmplitudeAnimationSpec = AnimationSpecKt.tween$default(500, 0, MotionTokens.INSTANCE.getEasingStandardCubicBezier(), 2, null);
    private static final AnimationSpec<Float> DecreasingAmplitudeAnimationSpec = AnimationSpecKt.tween$default(500, 0, MotionTokens.INSTANCE.getEasingEmphasizedAccelerateCubicBezier(), 2, null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CircularWavyProgressIndicator_L8eD4gc$lambda$1(Function0 function0, Modifier modifier, long j, long j2, Stroke stroke, Stroke stroke2, float f, Function1 function1, float f2, float f3, int i, int i2, Composer composer, int i3) {
        m4819CircularWavyProgressIndicatorL8eD4gc(function0, modifier, j, j2, stroke, stroke2, f, function1, f2, f3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CircularWavyProgressIndicator_hvuEXSk$lambda$1(Modifier modifier, long j, long j2, Stroke stroke, Stroke stroke2, float f, float f2, float f3, float f4, int i, int i2, Composer composer, int i3) {
        m4820CircularWavyProgressIndicatorhvuEXSk(modifier, j, j2, stroke, stroke2, f, f2, f3, f4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LinearWavyProgressIndicator_1YwxWKA$lambda$1(Function0 function0, Modifier modifier, long j, long j2, Stroke stroke, Stroke stroke2, float f, float f2, Function1 function1, float f3, float f4, int i, int i2, int i3, Composer composer, int i4) {
        m4821LinearWavyProgressIndicator1YwxWKA(function0, modifier, j, j2, stroke, stroke2, f, f2, function1, f3, f4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LinearWavyProgressIndicator_hvuEXSk$lambda$4(Modifier modifier, long j, long j2, Stroke stroke, Stroke stroke2, float f, float f2, float f3, float f4, int i, int i2, Composer composer, int i3) {
        m4822LinearWavyProgressIndicatorhvuEXSk(modifier, j, j2, stroke, stroke2, f, f2, f3, f4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:107:0x0122  */
    /* JADX WARN: Code duplicated, block: B:110:0x0128  */
    /* JADX WARN: Code duplicated, block: B:118:0x013e  */
    /* JADX WARN: Code duplicated, block: B:125:0x0155  */
    /* JADX WARN: Code duplicated, block: B:128:0x015e  */
    /* JADX WARN: Code duplicated, block: B:161:0x01c9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:162:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:163:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:166:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:167:0x01de  */
    /* JADX WARN: Code duplicated, block: B:170:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:171:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:174:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:175:0x01fa  */
    /* JADX WARN: Code duplicated, block: B:178:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:181:0x020c  */
    /* JADX WARN: Code duplicated, block: B:182:0x0215  */
    /* JADX WARN: Code duplicated, block: B:185:0x021b  */
    /* JADX WARN: Code duplicated, block: B:186:0x0224  */
    /* JADX WARN: Code duplicated, block: B:189:0x022c  */
    /* JADX WARN: Code duplicated, block: B:190:0x0235  */
    /* JADX WARN: Code duplicated, block: B:193:0x023b  */
    /* JADX WARN: Code duplicated, block: B:194:0x0247  */
    /* JADX WARN: Code duplicated, block: B:197:0x024f  */
    /* JADX WARN: Code duplicated, block: B:198:0x025e  */
    /* JADX WARN: Code duplicated, block: B:201:0x0276  */
    /* JADX WARN: Code duplicated, block: B:202:0x0281  */
    /* JADX WARN: Code duplicated, block: B:205:0x0298  */
    /* JADX WARN: Code duplicated, block: B:206:0x029a  */
    /* JADX WARN: Code duplicated, block: B:211:0x02a9  */
    /* JADX WARN: Code duplicated, block: B:214:0x02f5  */
    /* JADX WARN: Code duplicated, block: B:216:0x0305  */
    /* JADX WARN: Code duplicated, block: B:219:0x031e  */
    /* JADX WARN: Code duplicated, block: B:221:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0044  */
    /* JADX WARN: Code duplicated, block: B:25:0x0048  */
    /* JADX WARN: Code duplicated, block: B:27:0x0050  */
    /* JADX WARN: Code duplicated, block: B:28:0x0053  */
    /* JADX WARN: Code duplicated, block: B:31:0x0059  */
    /* JADX WARN: Code duplicated, block: B:34:0x005f  */
    /* JADX WARN: Code duplicated, block: B:36:0x0063  */
    /* JADX WARN: Code duplicated, block: B:38:0x006b  */
    /* JADX WARN: Code duplicated, block: B:39:0x006e  */
    /* JADX WARN: Code duplicated, block: B:42:0x0074  */
    /* JADX WARN: Code duplicated, block: B:45:0x007a  */
    /* JADX WARN: Code duplicated, block: B:47:0x007e  */
    /* JADX WARN: Code duplicated, block: B:49:0x0086  */
    /* JADX WARN: Code duplicated, block: B:50:0x0089  */
    /* JADX WARN: Code duplicated, block: B:53:0x008f  */
    /* JADX WARN: Code duplicated, block: B:56:0x0096  */
    /* JADX WARN: Code duplicated, block: B:58:0x009a  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:64:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:74:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:85:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:88:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:96:0x0104  */
    /* JADX WARN: Code duplicated, block: B:99:0x010c  */
    /* JADX INFO: renamed from: LinearWavyProgressIndicator-1YwxWKA, reason: not valid java name */
    public static final void m4821LinearWavyProgressIndicator1YwxWKA(final Function0<Float> function0, Modifier modifier, long j, long j2, Stroke stroke, Stroke stroke2, float f, float f2, Function1<? super Float, Float> function1, float f3, float f4, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        long j3;
        long j4;
        Stroke stroke3;
        Stroke linearTrackStroke;
        int i5;
        boolean z;
        final long j5;
        final long j6;
        final Stroke stroke4;
        final float f5;
        final float f6;
        final Function1<? super Float, Float> function2;
        final float f7;
        final float f8;
        final Modifier modifier3;
        final Stroke stroke5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        long indicatorColor;
        long trackColor;
        Stroke linearIndicatorStroke;
        float fM4811getLinearIndicatorTrackGapSizeD9Ej5fM;
        float fM4812getLinearTrackStopIndicatorSizeD9Ej5fM;
        Function1<? super Float, Float> indicatorAmplitude;
        float fM4809getLinearDeterminateWavelengthD9Ej5fM;
        Modifier modifier4;
        int i6;
        float f9;
        float f10;
        int i7;
        float f11;
        boolean z2;
        Object objRememberedValue;
        int i8;
        Composer composerStartRestartGroup = composer.startRestartGroup(2019304030);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LinearWavyProgressIndicator)N(progress,modifier,color:c#ui.graphics.Color,trackColor:c#ui.graphics.Color,stroke,trackStroke,gapSize:c#ui.unit.Dp,stopSize:c#ui.unit.Dp,amplitude,wavelength:c#ui.unit.Dp,waveSpeed:c#ui.unit.Dp)113@6037L317,109@5882L1193:WavyProgressIndicator.kt#uh7d8r");
        if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i9 = i3 & 2;
        if (i9 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i3 & 4) == 0) {
                    j3 = j;
                    int i10 = composerStartRestartGroup.changed(j3) ? 256 : 128;
                    i4 |= i10;
                } else {
                    j3 = j;
                }
                i4 |= i10;
            } else {
                j3 = j;
            }
            if ((i & 3072) == 0) {
                if ((i3 & 8) == 0) {
                    j4 = j2;
                    int i11 = composerStartRestartGroup.changed(j4) ? 2048 : 1024;
                    i4 |= i11;
                } else {
                    j4 = j2;
                }
                i4 |= i11;
            } else {
                j4 = j2;
            }
            if ((i & 24576) == 0) {
                if ((i3 & 16) == 0) {
                    stroke3 = stroke;
                    int i12 = composerStartRestartGroup.changedInstance(stroke3) ? 16384 : 8192;
                    i4 |= i12;
                } else {
                    stroke3 = stroke;
                }
                i4 |= i12;
            } else {
                stroke3 = stroke;
            }
            if ((196608 & i) == 0) {
                if ((i3 & 32) == 0) {
                    linearTrackStroke = stroke2;
                    int i13 = composerStartRestartGroup.changedInstance(linearTrackStroke) ? 131072 : 65536;
                    i4 |= i13;
                } else {
                    linearTrackStroke = stroke2;
                }
                i4 |= i13;
            } else {
                linearTrackStroke = stroke2;
            }
            if ((i & 1572864) != 0) {
                if ((i3 & 64) == 0 || !composerStartRestartGroup.changed(f)) {
                    i8 = 524288;
                } else {
                    i8 = 1048576;
                }
                i4 |= i8;
            }
            if ((i & 12582912) != 0) {
                i4 |= ((i3 & 128) == 0 || !composerStartRestartGroup.changed(f2)) ? 4194304 : 8388608;
            }
            if ((i & 100663296) != 0) {
                i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changedInstance(function1)) ? 33554432 : 67108864;
            }
            if ((i & 805306368) != 0) {
                i4 |= ((i3 & 512) == 0 || !composerStartRestartGroup.changed(f3)) ? 268435456 : C.BUFFER_FLAG_LAST_SAMPLE;
            }
            if ((i2 & 6) == 0) {
                i5 = i2 | (((i3 & 1024) == 0 || !composerStartRestartGroup.changed(f4)) ? 2 : 4);
            } else {
                i5 = i2;
            }
            if ((i4 & 306783379) == 306783378 || (i5 & 3) != 2) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "99@5245L14,100@5315L10,101@5378L21,102@5457L17");
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i3 & 4) != 0) {
                        indicatorColor = WavyProgressIndicatorDefaults.INSTANCE.getIndicatorColor(composerStartRestartGroup, 0);
                        i4 &= -897;
                    } else {
                        indicatorColor = j3;
                    }
                    if ((i3 & 8) != 0) {
                        trackColor = WavyProgressIndicatorDefaults.INSTANCE.getTrackColor(composerStartRestartGroup, 0);
                        i4 &= -7169;
                    } else {
                        trackColor = j4;
                    }
                    if ((i3 & 16) != 0) {
                        linearIndicatorStroke = WavyProgressIndicatorDefaults.INSTANCE.getLinearIndicatorStroke(composerStartRestartGroup, 0);
                        i4 &= -57345;
                    } else {
                        linearIndicatorStroke = stroke3;
                    }
                    if ((i3 & 32) != 0) {
                        i4 &= -458753;
                        linearTrackStroke = WavyProgressIndicatorDefaults.INSTANCE.getLinearTrackStroke(composerStartRestartGroup, 0);
                    }
                    if ((i3 & 64) != 0) {
                        fM4811getLinearIndicatorTrackGapSizeD9Ej5fM = WavyProgressIndicatorDefaults.INSTANCE.m4811getLinearIndicatorTrackGapSizeD9Ej5fM();
                        i4 &= -3670017;
                    } else {
                        fM4811getLinearIndicatorTrackGapSizeD9Ej5fM = f;
                    }
                    if ((i3 & 128) != 0) {
                        fM4812getLinearTrackStopIndicatorSizeD9Ej5fM = WavyProgressIndicatorDefaults.INSTANCE.m4812getLinearTrackStopIndicatorSizeD9Ej5fM();
                        i4 &= -29360129;
                    } else {
                        fM4812getLinearTrackStopIndicatorSizeD9Ej5fM = f2;
                    }
                    if ((i3 & 256) != 0) {
                        indicatorAmplitude = WavyProgressIndicatorDefaults.INSTANCE.getIndicatorAmplitude();
                        i4 &= -234881025;
                    } else {
                        indicatorAmplitude = function1;
                    }
                    if ((i3 & 512) != 0) {
                        fM4809getLinearDeterminateWavelengthD9Ej5fM = WavyProgressIndicatorDefaults.INSTANCE.m4809getLinearDeterminateWavelengthD9Ej5fM();
                        i4 &= -1879048193;
                    } else {
                        fM4809getLinearDeterminateWavelengthD9Ej5fM = f3;
                    }
                    modifier4 = companion;
                    if ((i3 & 1024) != 0) {
                        i6 = i4;
                        f9 = fM4811getLinearIndicatorTrackGapSizeD9Ej5fM;
                        f10 = fM4812getLinearTrackStopIndicatorSizeD9Ej5fM;
                        i7 = i5 & (-15);
                        stroke3 = linearIndicatorStroke;
                        j4 = trackColor;
                        j3 = indicatorColor;
                        modifier2 = modifier4;
                        f11 = fM4809getLinearDeterminateWavelengthD9Ej5fM;
                    } else {
                        i6 = i4;
                        f9 = fM4811getLinearIndicatorTrackGapSizeD9Ej5fM;
                        f10 = fM4812getLinearTrackStopIndicatorSizeD9Ej5fM;
                        i7 = i5;
                        stroke3 = linearIndicatorStroke;
                        j4 = trackColor;
                        j3 = indicatorColor;
                        modifier2 = modifier4;
                        f11 = f4;
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i3 & 4) != 0) {
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        i4 &= -7169;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                    }
                    if ((i3 & 32) != 0) {
                        i4 &= -458753;
                    }
                    if ((i3 & 64) != 0) {
                        i4 &= -3670017;
                    }
                    if ((i3 & 128) != 0) {
                        i4 &= -29360129;
                    }
                    if ((i3 & 256) != 0) {
                        i4 &= -234881025;
                    }
                    if ((i3 & 512) != 0) {
                        i4 &= -1879048193;
                    }
                    if ((i3 & 1024) != 0) {
                        i5 &= -15;
                    }
                    indicatorAmplitude = function1;
                    fM4809getLinearDeterminateWavelengthD9Ej5fM = f3;
                    f11 = f4;
                    i6 = i4;
                    i7 = i5;
                    f9 = f;
                    f10 = f2;
                }
                composerStartRestartGroup.endDefaults();
                float f12 = f10;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2019304030, i6, i7, "androidx.compose.material3.LinearWavyProgressIndicator (WavyProgressIndicator.kt:108)");
                }
                Modifier modifierThen = modifier2.then(AccessibilityUtilKt.getIncreaseVerticalSemanticsBounds());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -774014693, "CC(remember):WavyProgressIndicator.kt#9igjgp");
                if ((i6 & 14) == 4) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.WavyProgressIndicatorKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return WavyProgressIndicatorKt.LinearWavyProgressIndicator_1YwxWKA$lambda$0$0(function0, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                float f13 = f11;
                Modifier modifierM4996linearWavyProgressIndicatorbMBChCs = LinearWavyProgressModifiersKt.m4996linearWavyProgressIndicatorbMBChCs(ClipKt.clipToBounds(SizeKt.m1268sizeVpY3zN4(SemanticsModifierKt.semantics(modifierThen, true, (Function1) objRememberedValue), WavyProgressIndicatorDefaults.INSTANCE.m4808getLinearContainerWidthD9Ej5fM(), WavyProgressIndicatorDefaults.INSTANCE.m4807getLinearContainerHeightD9Ej5fM())), function0, indicatorAmplitude, j3, j4, stroke3, linearTrackStroke, f9, f12, fM4809getLinearDeterminateWavelengthD9Ej5fM, f13);
                Function1<? super Float, Float> function3 = indicatorAmplitude;
                float f14 = f9;
                SpacerKt.Spacer(modifierM4996linearWavyProgressIndicatorbMBChCs, composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                stroke4 = stroke3;
                f8 = f13;
                j5 = j3;
                f5 = f14;
                f6 = f12;
                long j7 = j4;
                function2 = function3;
                f7 = fM4809getLinearDeterminateWavelengthD9Ej5fM;
                j6 = j7;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                j5 = j3;
                j6 = j4;
                stroke4 = stroke3;
                f5 = f;
                f6 = f2;
                function2 = function1;
                f7 = f3;
                f8 = f4;
            }
            modifier3 = modifier2;
            stroke5 = linearTrackStroke;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WavyProgressIndicatorKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return WavyProgressIndicatorKt.LinearWavyProgressIndicator_1YwxWKA$lambda$1(function0, modifier3, j5, j6, stroke4, stroke5, f5, f6, function2, f7, f8, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 48;
        modifier2 = modifier;
        if ((i & 384) == 0) {
            if ((i3 & 4) == 0) {
                j3 = j;
                if (composerStartRestartGroup.changed(j3)) {
                }
                i4 |= i10;
            } else {
                j3 = j;
            }
            i4 |= i10;
        } else {
            j3 = j;
        }
        if ((i & 3072) == 0) {
            if ((i3 & 8) == 0) {
                j4 = j2;
                if (composerStartRestartGroup.changed(j4)) {
                }
                i4 |= i11;
            } else {
                j4 = j2;
            }
            i4 |= i11;
        } else {
            j4 = j2;
        }
        if ((i & 24576) == 0) {
            if ((i3 & 16) == 0) {
                stroke3 = stroke;
                if (composerStartRestartGroup.changedInstance(stroke3)) {
                }
                i4 |= i12;
            } else {
                stroke3 = stroke;
            }
            i4 |= i12;
        } else {
            stroke3 = stroke;
        }
        if ((196608 & i) == 0) {
            if ((i3 & 32) == 0) {
                linearTrackStroke = stroke2;
                if (composerStartRestartGroup.changedInstance(linearTrackStroke)) {
                }
                i4 |= i13;
            } else {
                linearTrackStroke = stroke2;
            }
            i4 |= i13;
        } else {
            linearTrackStroke = stroke2;
        }
        if ((i & 1572864) != 0) {
            if ((i3 & 64) == 0) {
                i8 = 524288;
            } else {
                i8 = 524288;
            }
            i4 |= i8;
        }
        if ((i & 12582912) != 0) {
            i4 |= ((i3 & 128) == 0 || !composerStartRestartGroup.changed(f2)) ? 4194304 : 8388608;
        }
        if ((i & 100663296) != 0) {
            i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changedInstance(function1)) ? 33554432 : 67108864;
        }
        if ((i & 805306368) != 0) {
            i4 |= ((i3 & 512) == 0 || !composerStartRestartGroup.changed(f3)) ? 268435456 : C.BUFFER_FLAG_LAST_SAMPLE;
        }
        if ((i2 & 6) == 0) {
            i5 = i2 | (((i3 & 1024) == 0 || !composerStartRestartGroup.changed(f4)) ? 2 : 4);
        } else {
            i5 = i2;
        }
        if ((i4 & 306783379) == 306783378) {
            z = true;
        } else {
            z = true;
        }
        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "99@5245L14,100@5315L10,101@5378L21,102@5457L17");
            if ((i & 1) != 0) {
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i3 & 4) != 0) {
                    indicatorColor = WavyProgressIndicatorDefaults.INSTANCE.getIndicatorColor(composerStartRestartGroup, 0);
                    i4 &= -897;
                } else {
                    indicatorColor = j3;
                }
                if ((i3 & 8) != 0) {
                    trackColor = WavyProgressIndicatorDefaults.INSTANCE.getTrackColor(composerStartRestartGroup, 0);
                    i4 &= -7169;
                } else {
                    trackColor = j4;
                }
                if ((i3 & 16) != 0) {
                    linearIndicatorStroke = WavyProgressIndicatorDefaults.INSTANCE.getLinearIndicatorStroke(composerStartRestartGroup, 0);
                    i4 &= -57345;
                } else {
                    linearIndicatorStroke = stroke3;
                }
                if ((i3 & 32) != 0) {
                    i4 &= -458753;
                    linearTrackStroke = WavyProgressIndicatorDefaults.INSTANCE.getLinearTrackStroke(composerStartRestartGroup, 0);
                }
                if ((i3 & 64) != 0) {
                    fM4811getLinearIndicatorTrackGapSizeD9Ej5fM = WavyProgressIndicatorDefaults.INSTANCE.m4811getLinearIndicatorTrackGapSizeD9Ej5fM();
                    i4 &= -3670017;
                } else {
                    fM4811getLinearIndicatorTrackGapSizeD9Ej5fM = f;
                }
                if ((i3 & 128) != 0) {
                    fM4812getLinearTrackStopIndicatorSizeD9Ej5fM = WavyProgressIndicatorDefaults.INSTANCE.m4812getLinearTrackStopIndicatorSizeD9Ej5fM();
                    i4 &= -29360129;
                } else {
                    fM4812getLinearTrackStopIndicatorSizeD9Ej5fM = f2;
                }
                if ((i3 & 256) != 0) {
                    indicatorAmplitude = WavyProgressIndicatorDefaults.INSTANCE.getIndicatorAmplitude();
                    i4 &= -234881025;
                } else {
                    indicatorAmplitude = function1;
                }
                if ((i3 & 512) != 0) {
                    fM4809getLinearDeterminateWavelengthD9Ej5fM = WavyProgressIndicatorDefaults.INSTANCE.m4809getLinearDeterminateWavelengthD9Ej5fM();
                    i4 &= -1879048193;
                } else {
                    fM4809getLinearDeterminateWavelengthD9Ej5fM = f3;
                }
                modifier4 = companion;
                if ((i3 & 1024) != 0) {
                    i6 = i4;
                    f9 = fM4811getLinearIndicatorTrackGapSizeD9Ej5fM;
                    f10 = fM4812getLinearTrackStopIndicatorSizeD9Ej5fM;
                    i7 = i5 & (-15);
                    stroke3 = linearIndicatorStroke;
                    j4 = trackColor;
                    j3 = indicatorColor;
                    modifier2 = modifier4;
                    f11 = fM4809getLinearDeterminateWavelengthD9Ej5fM;
                } else {
                    i6 = i4;
                    f9 = fM4811getLinearIndicatorTrackGapSizeD9Ej5fM;
                    f10 = fM4812getLinearTrackStopIndicatorSizeD9Ej5fM;
                    i7 = i5;
                    stroke3 = linearIndicatorStroke;
                    j4 = trackColor;
                    j3 = indicatorColor;
                    modifier2 = modifier4;
                    f11 = f4;
                }
            } else {
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i3 & 4) != 0) {
                    indicatorColor = WavyProgressIndicatorDefaults.INSTANCE.getIndicatorColor(composerStartRestartGroup, 0);
                    i4 &= -897;
                } else {
                    indicatorColor = j3;
                }
                if ((i3 & 8) != 0) {
                    trackColor = WavyProgressIndicatorDefaults.INSTANCE.getTrackColor(composerStartRestartGroup, 0);
                    i4 &= -7169;
                } else {
                    trackColor = j4;
                }
                if ((i3 & 16) != 0) {
                    linearIndicatorStroke = WavyProgressIndicatorDefaults.INSTANCE.getLinearIndicatorStroke(composerStartRestartGroup, 0);
                    i4 &= -57345;
                } else {
                    linearIndicatorStroke = stroke3;
                }
                if ((i3 & 32) != 0) {
                    i4 &= -458753;
                    linearTrackStroke = WavyProgressIndicatorDefaults.INSTANCE.getLinearTrackStroke(composerStartRestartGroup, 0);
                }
                if ((i3 & 64) != 0) {
                    fM4811getLinearIndicatorTrackGapSizeD9Ej5fM = WavyProgressIndicatorDefaults.INSTANCE.m4811getLinearIndicatorTrackGapSizeD9Ej5fM();
                    i4 &= -3670017;
                } else {
                    fM4811getLinearIndicatorTrackGapSizeD9Ej5fM = f;
                }
                if ((i3 & 128) != 0) {
                    fM4812getLinearTrackStopIndicatorSizeD9Ej5fM = WavyProgressIndicatorDefaults.INSTANCE.m4812getLinearTrackStopIndicatorSizeD9Ej5fM();
                    i4 &= -29360129;
                } else {
                    fM4812getLinearTrackStopIndicatorSizeD9Ej5fM = f2;
                }
                if ((i3 & 256) != 0) {
                    indicatorAmplitude = WavyProgressIndicatorDefaults.INSTANCE.getIndicatorAmplitude();
                    i4 &= -234881025;
                } else {
                    indicatorAmplitude = function1;
                }
                if ((i3 & 512) != 0) {
                    fM4809getLinearDeterminateWavelengthD9Ej5fM = WavyProgressIndicatorDefaults.INSTANCE.m4809getLinearDeterminateWavelengthD9Ej5fM();
                    i4 &= -1879048193;
                } else {
                    fM4809getLinearDeterminateWavelengthD9Ej5fM = f3;
                }
                modifier4 = companion;
                if ((i3 & 1024) != 0) {
                    i6 = i4;
                    f9 = fM4811getLinearIndicatorTrackGapSizeD9Ej5fM;
                    f10 = fM4812getLinearTrackStopIndicatorSizeD9Ej5fM;
                    i7 = i5 & (-15);
                    stroke3 = linearIndicatorStroke;
                    j4 = trackColor;
                    j3 = indicatorColor;
                    modifier2 = modifier4;
                    f11 = fM4809getLinearDeterminateWavelengthD9Ej5fM;
                } else {
                    i6 = i4;
                    f9 = fM4811getLinearIndicatorTrackGapSizeD9Ej5fM;
                    f10 = fM4812getLinearTrackStopIndicatorSizeD9Ej5fM;
                    i7 = i5;
                    stroke3 = linearIndicatorStroke;
                    j4 = trackColor;
                    j3 = indicatorColor;
                    modifier2 = modifier4;
                    f11 = f4;
                }
            }
            composerStartRestartGroup.endDefaults();
            float f15 = f10;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2019304030, i6, i7, "androidx.compose.material3.LinearWavyProgressIndicator (WavyProgressIndicator.kt:108)");
            }
            Modifier modifierThen2 = modifier2.then(AccessibilityUtilKt.getIncreaseVerticalSemanticsBounds());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -774014693, "CC(remember):WavyProgressIndicator.kt#9igjgp");
            if ((i6 & 14) == 4) {
                z2 = true;
            } else {
                z2 = false;
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z2) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.WavyProgressIndicatorKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return WavyProgressIndicatorKt.LinearWavyProgressIndicator_1YwxWKA$lambda$0$0(function0, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.WavyProgressIndicatorKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return WavyProgressIndicatorKt.LinearWavyProgressIndicator_1YwxWKA$lambda$0$0(function0, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            float f16 = f11;
            Modifier modifierM4996linearWavyProgressIndicatorbMBChCs2 = LinearWavyProgressModifiersKt.m4996linearWavyProgressIndicatorbMBChCs(ClipKt.clipToBounds(SizeKt.m1268sizeVpY3zN4(SemanticsModifierKt.semantics(modifierThen2, true, (Function1) objRememberedValue), WavyProgressIndicatorDefaults.INSTANCE.m4808getLinearContainerWidthD9Ej5fM(), WavyProgressIndicatorDefaults.INSTANCE.m4807getLinearContainerHeightD9Ej5fM())), function0, indicatorAmplitude, j3, j4, stroke3, linearTrackStroke, f9, f15, fM4809getLinearDeterminateWavelengthD9Ej5fM, f16);
            Function1<? super Float, Float> function4 = indicatorAmplitude;
            float f17 = f9;
            SpacerKt.Spacer(modifierM4996linearWavyProgressIndicatorbMBChCs2, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            stroke4 = stroke3;
            f8 = f16;
            j5 = j3;
            f5 = f17;
            f6 = f15;
            long j8 = j4;
            function2 = function4;
            f7 = fM4809getLinearDeterminateWavelengthD9Ej5fM;
            j6 = j8;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            j5 = j3;
            j6 = j4;
            stroke4 = stroke3;
            f5 = f;
            f6 = f2;
            function2 = function1;
            f7 = f3;
            f8 = f4;
        }
        modifier3 = modifier2;
        stroke5 = linearTrackStroke;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WavyProgressIndicatorKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WavyProgressIndicatorKt.LinearWavyProgressIndicator_1YwxWKA$lambda$1(function0, modifier3, j5, j6, stroke4, stroke5, f5, f6, function2, f7, f8, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LinearWavyProgressIndicator_1YwxWKA$lambda$0$0(Function0 function0, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Object objInvoke = function0.invoke();
        if (Float.isNaN(((Number) objInvoke).floatValue())) {
            objInvoke = null;
        }
        Float f = (Float) objInvoke;
        float fFloatValue = f != null ? f.floatValue() : 0.0f;
        if (fFloatValue < 0.0f) {
            fFloatValue = 0.0f;
        }
        if (fFloatValue > 1.0f) {
            fFloatValue = 1.0f;
        }
        SemanticsPropertiesKt.setProgressBarRangeInfo(semanticsPropertyReceiver, new ProgressBarRangeInfo(fFloatValue, RangesKt.rangeTo(0.0f, 1.0f), 0, 4, null));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x010f  */
    /* JADX WARN: Code duplicated, block: B:103:0x011e  */
    /* JADX WARN: Code duplicated, block: B:104:0x0120  */
    /* JADX WARN: Code duplicated, block: B:107:0x0129  */
    /* JADX WARN: Code duplicated, block: B:134:0x0187 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:135:0x0189  */
    /* JADX WARN: Code duplicated, block: B:136:0x018e  */
    /* JADX WARN: Code duplicated, block: B:139:0x0194  */
    /* JADX WARN: Code duplicated, block: B:142:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:145:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:148:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:151:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:153:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:156:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:157:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:160:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:161:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:164:0x020d  */
    /* JADX WARN: Code duplicated, block: B:169:0x02f5  */
    /* JADX WARN: Code duplicated, block: B:174:0x031c  */
    /* JADX WARN: Code duplicated, block: B:179:0x0343  */
    /* JADX WARN: Code duplicated, block: B:184:0x036a  */
    /* JADX WARN: Code duplicated, block: B:188:0x037f  */
    /* JADX WARN: Code duplicated, block: B:191:0x0384  */
    /* JADX WARN: Code duplicated, block: B:192:0x0387  */
    /* JADX WARN: Code duplicated, block: B:195:0x0396  */
    /* JADX WARN: Code duplicated, block: B:197:0x03a9  */
    /* JADX WARN: Code duplicated, block: B:200:0x03bf  */
    /* JADX WARN: Code duplicated, block: B:202:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:81:0x00db  */
    /* JADX WARN: Code duplicated, block: B:89:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:92:0x00f9  */
    /* JADX INFO: renamed from: LinearWavyProgressIndicator-hvuEXSk, reason: not valid java name */
    public static final void m4822LinearWavyProgressIndicatorhvuEXSk(Modifier modifier, long j, long j2, Stroke stroke, Stroke stroke2, float f, float f2, float f3, float f4, Composer composer, final int i, final int i2) {
        int i3;
        long indicatorColor;
        long trackColor;
        Stroke linearIndicatorStroke;
        Stroke linearTrackStroke;
        float fM4811getLinearIndicatorTrackGapSizeD9Ej5fM;
        float f5;
        boolean z;
        Composer composer2;
        final Modifier modifier2;
        final long j3;
        final long j4;
        final Stroke stroke3;
        final Stroke stroke4;
        final float f6;
        final float f7;
        final float f8;
        final float f9;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        float fM4810getLinearIndeterminateWavelengthD9Ej5fM;
        float f10;
        long j5;
        long j6;
        Stroke stroke5;
        Stroke stroke6;
        float f11;
        float f12;
        final State<Float> stateAnimateFloat;
        final State<Float> stateAnimateFloat2;
        final State<Float> stateAnimateFloat3;
        final State<Float> stateAnimateFloat4;
        boolean zChanged;
        Object objRememberedValue;
        boolean zChanged2;
        Object objRememberedValue2;
        boolean zChanged3;
        Object objRememberedValue3;
        boolean zChanged4;
        Object objRememberedValue4;
        float f13;
        float f14;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2070567281);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LinearWavyProgressIndicator)N(modifier,color:c#ui.graphics.Color,trackColor:c#ui.graphics.Color,stroke,trackStroke,gapSize:c#ui.unit.Dp,amplitude,wavelength:c#ui.unit.Dp,waveSpeed:c#ui.unit.Dp)178@9454L65,180@9571L219,187@9842L219,194@10114L221,201@10388L221,219@11063L23,220@11132L23,221@11202L24,222@11273L24,208@10615L1062:WavyProgressIndicator.kt#uh7d8r");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                indicatorColor = j;
                int i5 = composerStartRestartGroup.changed(indicatorColor) ? 32 : 16;
                i3 |= i5;
            } else {
                indicatorColor = j;
            }
            i3 |= i5;
        } else {
            indicatorColor = j;
        }
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                trackColor = j2;
                int i6 = composerStartRestartGroup.changed(trackColor) ? 256 : 128;
                i3 |= i6;
            } else {
                trackColor = j2;
            }
            i3 |= i6;
        } else {
            trackColor = j2;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                linearIndicatorStroke = stroke;
                int i7 = composerStartRestartGroup.changedInstance(linearIndicatorStroke) ? 2048 : 1024;
                i3 |= i7;
            } else {
                linearIndicatorStroke = stroke;
            }
            i3 |= i7;
        } else {
            linearIndicatorStroke = stroke;
        }
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                linearTrackStroke = stroke2;
                int i8 = composerStartRestartGroup.changedInstance(linearTrackStroke) ? 16384 : 8192;
                i3 |= i8;
            } else {
                linearTrackStroke = stroke2;
            }
            i3 |= i8;
        } else {
            linearTrackStroke = stroke2;
        }
        if ((196608 & i) == 0) {
            if ((i2 & 32) == 0) {
                fM4811getLinearIndicatorTrackGapSizeD9Ej5fM = f;
                int i9 = composerStartRestartGroup.changed(fM4811getLinearIndicatorTrackGapSizeD9Ej5fM) ? 131072 : 65536;
                i3 |= i9;
            } else {
                fM4811getLinearIndicatorTrackGapSizeD9Ej5fM = f;
            }
            i3 |= i9;
        } else {
            fM4811getLinearIndicatorTrackGapSizeD9Ej5fM = f;
        }
        int i10 = i2 & 64;
        if (i10 == 0) {
            if ((1572864 & i) == 0) {
                f5 = f2;
                i3 |= composerStartRestartGroup.changed(f5) ? 1048576 : 524288;
            }
            if ((i & 12582912) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(f3)) ? 4194304 : 8388608;
            }
            if ((i & 100663296) != 0) {
                i3 |= ((i2 & 256) == 0 || !composerStartRestartGroup.changed(f4)) ? 33554432 : 67108864;
            }
            if ((i3 & 38347923) != 38347922) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "169@8902L14,170@8972L10,171@9035L21,172@9114L17");
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i4 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        indicatorColor = WavyProgressIndicatorDefaults.INSTANCE.getIndicatorColor(composerStartRestartGroup, 0);
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        trackColor = WavyProgressIndicatorDefaults.INSTANCE.getTrackColor(composerStartRestartGroup, 0);
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        linearIndicatorStroke = WavyProgressIndicatorDefaults.INSTANCE.getLinearIndicatorStroke(composerStartRestartGroup, 0);
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        linearTrackStroke = WavyProgressIndicatorDefaults.INSTANCE.getLinearTrackStroke(composerStartRestartGroup, 0);
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        fM4811getLinearIndicatorTrackGapSizeD9Ej5fM = WavyProgressIndicatorDefaults.INSTANCE.m4811getLinearIndicatorTrackGapSizeD9Ej5fM();
                        i3 &= -458753;
                    }
                    if (i10 != 0) {
                        f5 = 1.0f;
                    }
                    if ((i2 & 128) != 0) {
                        fM4810getLinearIndeterminateWavelengthD9Ej5fM = WavyProgressIndicatorDefaults.INSTANCE.m4810getLinearIndeterminateWavelengthD9Ej5fM();
                        i3 = (-29360129) & i3;
                    } else {
                        fM4810getLinearIndeterminateWavelengthD9Ej5fM = f3;
                    }
                    if ((i2 & 256) != 0) {
                        i3 &= -234881025;
                        j5 = indicatorColor;
                        j6 = trackColor;
                        stroke5 = linearIndicatorStroke;
                        stroke6 = linearTrackStroke;
                        f11 = fM4811getLinearIndicatorTrackGapSizeD9Ej5fM;
                        f12 = fM4810getLinearIndeterminateWavelengthD9Ej5fM;
                        f10 = f12;
                    } else {
                        f10 = f4;
                        j5 = indicatorColor;
                        j6 = trackColor;
                        stroke5 = linearIndicatorStroke;
                        stroke6 = linearTrackStroke;
                        f11 = fM4811getLinearIndicatorTrackGapSizeD9Ej5fM;
                        f12 = fM4810getLinearIndeterminateWavelengthD9Ej5fM;
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                    }
                    if ((i2 & 128) != 0) {
                        i3 &= -29360129;
                    }
                    if ((i2 & 256) != 0) {
                        i3 &= -234881025;
                    }
                    companion = modifier;
                    f12 = f3;
                    f10 = f4;
                    j5 = indicatorColor;
                    j6 = trackColor;
                    stroke5 = linearIndicatorStroke;
                    stroke6 = linearTrackStroke;
                    f11 = fM4811getLinearIndicatorTrackGapSizeD9Ej5fM;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2070567281, i3, -1, "androidx.compose.material3.LinearWavyProgressIndicator (WavyProgressIndicator.kt:177)");
                }
                InfiniteTransition infiniteTransitionRememberInfiniteTransition = InfiniteTransitionKt.rememberInfiniteTransition("LinearWavyProgressIndicatorProgress", composerStartRestartGroup, 6, 0);
                stateAnimateFloat = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.0f, 1.0f, ProgressIndicatorKt.getLinearIndeterminateFirstLineHeadAnimationSpec(), "LinearWavyProgressIndicatorFirstHead", composerStartRestartGroup, InfiniteTransition.$stable | 25008 | (InfiniteRepeatableSpec.$stable << 9), 0);
                stateAnimateFloat2 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.0f, 1.0f, ProgressIndicatorKt.getLinearIndeterminateFirstLineTailAnimationSpec(), "LinearWavyProgressIndicatorFirstTail", composerStartRestartGroup, InfiniteTransition.$stable | 25008 | (InfiniteRepeatableSpec.$stable << 9), 0);
                stateAnimateFloat3 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.0f, 1.0f, ProgressIndicatorKt.getLinearIndeterminateSecondLineHeadAnimationSpec(), "LinearWavyProgressIndicatorSecondHead", composerStartRestartGroup, InfiniteTransition.$stable | 25008 | (InfiniteRepeatableSpec.$stable << 9), 0);
                stateAnimateFloat4 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.0f, 1.0f, ProgressIndicatorKt.getLinearIndeterminateSecondLineTailAnimationSpec(), "LinearWavyProgressIndicatorSecondTail", composerStartRestartGroup, InfiniteTransition.$stable | 25008 | (InfiniteRepeatableSpec.$stable << 9), 0);
                composer2 = composerStartRestartGroup;
                Modifier modifierClipToBounds = ClipKt.clipToBounds(SizeKt.m1268sizeVpY3zN4(ProgressSemanticsKt.progressSemantics(companion.then(AccessibilityUtilKt.getIncreaseVerticalSemanticsBounds())), WavyProgressIndicatorDefaults.INSTANCE.m4808getLinearContainerWidthD9Ej5fM(), WavyProgressIndicatorDefaults.INSTANCE.m4807getLinearContainerHeightD9Ej5fM()));
                ComposerKt.sourceInformationMarkerStart(composer2, -1245226074, "CC(remember):WavyProgressIndicator.kt#9igjgp");
                zChanged = composer2.changed(stateAnimateFloat);
                objRememberedValue = composer2.rememberedValue();
                if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: androidx.compose.material3.WavyProgressIndicatorKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(WavyProgressIndicatorKt.LinearWavyProgressIndicator_hvuEXSk$lambda$0$0(stateAnimateFloat));
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                }
                Function0 function0 = (Function0) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerStart(composer2, -1245223866, "CC(remember):WavyProgressIndicator.kt#9igjgp");
                zChanged2 = composer2.changed(stateAnimateFloat2);
                objRememberedValue2 = composer2.rememberedValue();
                if (!zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.WavyProgressIndicatorKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(WavyProgressIndicatorKt.LinearWavyProgressIndicator_hvuEXSk$lambda$1$0(stateAnimateFloat2));
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue2);
                }
                Function0 function1 = (Function0) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerStart(composer2, -1245221625, "CC(remember):WavyProgressIndicator.kt#9igjgp");
                zChanged3 = composer2.changed(stateAnimateFloat3);
                objRememberedValue3 = composer2.rememberedValue();
                if (!zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.WavyProgressIndicatorKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(WavyProgressIndicatorKt.LinearWavyProgressIndicator_hvuEXSk$lambda$2$0(stateAnimateFloat3));
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue3);
                }
                Function0 function2 = (Function0) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerStart(composer2, -1245219353, "CC(remember):WavyProgressIndicator.kt#9igjgp");
                zChanged4 = composer2.changed(stateAnimateFloat4);
                objRememberedValue4 = composer2.rememberedValue();
                if (!zChanged4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new Function0() { // from class: androidx.compose.material3.WavyProgressIndicatorKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(WavyProgressIndicatorKt.LinearWavyProgressIndicator_hvuEXSk$lambda$3$0(stateAnimateFloat4));
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue4);
                }
                Function0 function3 = (Function0) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                f13 = f5 >= 0.0f ? f5 : 0.0f;
                if (f13 > 1.0f) {
                    f14 = 1.0f;
                } else {
                    f14 = f13;
                }
                SpacerKt.Spacer(LinearWavyProgressModifiersKt.m4995linearWavyProgressIndicatorOFGGHrU(modifierClipToBounds, function0, function1, function2, function3, j5, j6, stroke5, stroke6, f11, f14, f12, f10), composer2, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = companion;
                j3 = j5;
                j4 = j6;
                stroke3 = stroke5;
                stroke4 = stroke6;
                f6 = f11;
                f7 = f12;
                f8 = f10;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier2 = modifier;
                j3 = indicatorColor;
                j4 = trackColor;
                stroke3 = linearIndicatorStroke;
                stroke4 = linearTrackStroke;
                f6 = fM4811getLinearIndicatorTrackGapSizeD9Ej5fM;
                f7 = f3;
                f8 = f4;
            }
            f9 = f5;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WavyProgressIndicatorKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return WavyProgressIndicatorKt.LinearWavyProgressIndicator_hvuEXSk$lambda$4(modifier2, j3, j4, stroke3, stroke4, f6, f9, f7, f8, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 1572864;
        f5 = f2;
        if ((i & 12582912) != 0) {
            i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(f3)) ? 4194304 : 8388608;
        }
        if ((i & 100663296) != 0) {
            i3 |= ((i2 & 256) == 0 || !composerStartRestartGroup.changed(f4)) ? 33554432 : 67108864;
        }
        if ((i3 & 38347923) != 38347922) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "169@8902L14,170@8972L10,171@9035L21,172@9114L17");
            if ((i & 1) != 0) {
                if (i4 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if ((i2 & 2) != 0) {
                    indicatorColor = WavyProgressIndicatorDefaults.INSTANCE.getIndicatorColor(composerStartRestartGroup, 0);
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    trackColor = WavyProgressIndicatorDefaults.INSTANCE.getTrackColor(composerStartRestartGroup, 0);
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    linearIndicatorStroke = WavyProgressIndicatorDefaults.INSTANCE.getLinearIndicatorStroke(composerStartRestartGroup, 0);
                    i3 &= -7169;
                }
                if ((i2 & 16) != 0) {
                    linearTrackStroke = WavyProgressIndicatorDefaults.INSTANCE.getLinearTrackStroke(composerStartRestartGroup, 0);
                    i3 &= -57345;
                }
                if ((i2 & 32) != 0) {
                    fM4811getLinearIndicatorTrackGapSizeD9Ej5fM = WavyProgressIndicatorDefaults.INSTANCE.m4811getLinearIndicatorTrackGapSizeD9Ej5fM();
                    i3 &= -458753;
                }
                if (i10 != 0) {
                    f5 = 1.0f;
                }
                if ((i2 & 128) != 0) {
                    fM4810getLinearIndeterminateWavelengthD9Ej5fM = WavyProgressIndicatorDefaults.INSTANCE.m4810getLinearIndeterminateWavelengthD9Ej5fM();
                    i3 = (-29360129) & i3;
                } else {
                    fM4810getLinearIndeterminateWavelengthD9Ej5fM = f3;
                }
                if ((i2 & 256) != 0) {
                    i3 &= -234881025;
                    j5 = indicatorColor;
                    j6 = trackColor;
                    stroke5 = linearIndicatorStroke;
                    stroke6 = linearTrackStroke;
                    f11 = fM4811getLinearIndicatorTrackGapSizeD9Ej5fM;
                    f12 = fM4810getLinearIndeterminateWavelengthD9Ej5fM;
                    f10 = f12;
                } else {
                    f10 = f4;
                    j5 = indicatorColor;
                    j6 = trackColor;
                    stroke5 = linearIndicatorStroke;
                    stroke6 = linearTrackStroke;
                    f11 = fM4811getLinearIndicatorTrackGapSizeD9Ej5fM;
                    f12 = fM4810getLinearIndeterminateWavelengthD9Ej5fM;
                }
            } else {
                if (i4 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if ((i2 & 2) != 0) {
                    indicatorColor = WavyProgressIndicatorDefaults.INSTANCE.getIndicatorColor(composerStartRestartGroup, 0);
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    trackColor = WavyProgressIndicatorDefaults.INSTANCE.getTrackColor(composerStartRestartGroup, 0);
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    linearIndicatorStroke = WavyProgressIndicatorDefaults.INSTANCE.getLinearIndicatorStroke(composerStartRestartGroup, 0);
                    i3 &= -7169;
                }
                if ((i2 & 16) != 0) {
                    linearTrackStroke = WavyProgressIndicatorDefaults.INSTANCE.getLinearTrackStroke(composerStartRestartGroup, 0);
                    i3 &= -57345;
                }
                if ((i2 & 32) != 0) {
                    fM4811getLinearIndicatorTrackGapSizeD9Ej5fM = WavyProgressIndicatorDefaults.INSTANCE.m4811getLinearIndicatorTrackGapSizeD9Ej5fM();
                    i3 &= -458753;
                }
                if (i10 != 0) {
                    f5 = 1.0f;
                }
                if ((i2 & 128) != 0) {
                    fM4810getLinearIndeterminateWavelengthD9Ej5fM = WavyProgressIndicatorDefaults.INSTANCE.m4810getLinearIndeterminateWavelengthD9Ej5fM();
                    i3 = (-29360129) & i3;
                } else {
                    fM4810getLinearIndeterminateWavelengthD9Ej5fM = f3;
                }
                if ((i2 & 256) != 0) {
                    i3 &= -234881025;
                    j5 = indicatorColor;
                    j6 = trackColor;
                    stroke5 = linearIndicatorStroke;
                    stroke6 = linearTrackStroke;
                    f11 = fM4811getLinearIndicatorTrackGapSizeD9Ej5fM;
                    f12 = fM4810getLinearIndeterminateWavelengthD9Ej5fM;
                    f10 = f12;
                } else {
                    f10 = f4;
                    j5 = indicatorColor;
                    j6 = trackColor;
                    stroke5 = linearIndicatorStroke;
                    stroke6 = linearTrackStroke;
                    f11 = fM4811getLinearIndicatorTrackGapSizeD9Ej5fM;
                    f12 = fM4810getLinearIndeterminateWavelengthD9Ej5fM;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2070567281, i3, -1, "androidx.compose.material3.LinearWavyProgressIndicator (WavyProgressIndicator.kt:177)");
            }
            InfiniteTransition infiniteTransitionRememberInfiniteTransition2 = InfiniteTransitionKt.rememberInfiniteTransition("LinearWavyProgressIndicatorProgress", composerStartRestartGroup, 6, 0);
            stateAnimateFloat = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition2, 0.0f, 1.0f, ProgressIndicatorKt.getLinearIndeterminateFirstLineHeadAnimationSpec(), "LinearWavyProgressIndicatorFirstHead", composerStartRestartGroup, InfiniteTransition.$stable | 25008 | (InfiniteRepeatableSpec.$stable << 9), 0);
            stateAnimateFloat2 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition2, 0.0f, 1.0f, ProgressIndicatorKt.getLinearIndeterminateFirstLineTailAnimationSpec(), "LinearWavyProgressIndicatorFirstTail", composerStartRestartGroup, InfiniteTransition.$stable | 25008 | (InfiniteRepeatableSpec.$stable << 9), 0);
            stateAnimateFloat3 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition2, 0.0f, 1.0f, ProgressIndicatorKt.getLinearIndeterminateSecondLineHeadAnimationSpec(), "LinearWavyProgressIndicatorSecondHead", composerStartRestartGroup, InfiniteTransition.$stable | 25008 | (InfiniteRepeatableSpec.$stable << 9), 0);
            stateAnimateFloat4 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition2, 0.0f, 1.0f, ProgressIndicatorKt.getLinearIndeterminateSecondLineTailAnimationSpec(), "LinearWavyProgressIndicatorSecondTail", composerStartRestartGroup, InfiniteTransition.$stable | 25008 | (InfiniteRepeatableSpec.$stable << 9), 0);
            composer2 = composerStartRestartGroup;
            Modifier modifierClipToBounds2 = ClipKt.clipToBounds(SizeKt.m1268sizeVpY3zN4(ProgressSemanticsKt.progressSemantics(companion.then(AccessibilityUtilKt.getIncreaseVerticalSemanticsBounds())), WavyProgressIndicatorDefaults.INSTANCE.m4808getLinearContainerWidthD9Ej5fM(), WavyProgressIndicatorDefaults.INSTANCE.m4807getLinearContainerHeightD9Ej5fM()));
            ComposerKt.sourceInformationMarkerStart(composer2, -1245226074, "CC(remember):WavyProgressIndicator.kt#9igjgp");
            zChanged = composer2.changed(stateAnimateFloat);
            objRememberedValue = composer2.rememberedValue();
            if (!zChanged) {
                objRememberedValue = new Function0() { // from class: androidx.compose.material3.WavyProgressIndicatorKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Float.valueOf(WavyProgressIndicatorKt.LinearWavyProgressIndicator_hvuEXSk$lambda$0$0(stateAnimateFloat));
                    }
                };
                composer2.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function0() { // from class: androidx.compose.material3.WavyProgressIndicatorKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Float.valueOf(WavyProgressIndicatorKt.LinearWavyProgressIndicator_hvuEXSk$lambda$0$0(stateAnimateFloat));
                    }
                };
                composer2.updateRememberedValue(objRememberedValue);
            }
            Function0 function4 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerStart(composer2, -1245223866, "CC(remember):WavyProgressIndicator.kt#9igjgp");
            zChanged2 = composer2.changed(stateAnimateFloat2);
            objRememberedValue2 = composer2.rememberedValue();
            if (!zChanged2) {
                objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.WavyProgressIndicatorKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Float.valueOf(WavyProgressIndicatorKt.LinearWavyProgressIndicator_hvuEXSk$lambda$1$0(stateAnimateFloat2));
                    }
                };
                composer2.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.WavyProgressIndicatorKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Float.valueOf(WavyProgressIndicatorKt.LinearWavyProgressIndicator_hvuEXSk$lambda$1$0(stateAnimateFloat2));
                    }
                };
                composer2.updateRememberedValue(objRememberedValue2);
            }
            Function0 function5 = (Function0) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerStart(composer2, -1245221625, "CC(remember):WavyProgressIndicator.kt#9igjgp");
            zChanged3 = composer2.changed(stateAnimateFloat3);
            objRememberedValue3 = composer2.rememberedValue();
            if (!zChanged3) {
                objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.WavyProgressIndicatorKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Float.valueOf(WavyProgressIndicatorKt.LinearWavyProgressIndicator_hvuEXSk$lambda$2$0(stateAnimateFloat3));
                    }
                };
                composer2.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.WavyProgressIndicatorKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Float.valueOf(WavyProgressIndicatorKt.LinearWavyProgressIndicator_hvuEXSk$lambda$2$0(stateAnimateFloat3));
                    }
                };
                composer2.updateRememberedValue(objRememberedValue3);
            }
            Function0 function6 = (Function0) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerStart(composer2, -1245219353, "CC(remember):WavyProgressIndicator.kt#9igjgp");
            zChanged4 = composer2.changed(stateAnimateFloat4);
            objRememberedValue4 = composer2.rememberedValue();
            if (!zChanged4) {
                objRememberedValue4 = new Function0() { // from class: androidx.compose.material3.WavyProgressIndicatorKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Float.valueOf(WavyProgressIndicatorKt.LinearWavyProgressIndicator_hvuEXSk$lambda$3$0(stateAnimateFloat4));
                    }
                };
                composer2.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = new Function0() { // from class: androidx.compose.material3.WavyProgressIndicatorKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Float.valueOf(WavyProgressIndicatorKt.LinearWavyProgressIndicator_hvuEXSk$lambda$3$0(stateAnimateFloat4));
                    }
                };
                composer2.updateRememberedValue(objRememberedValue4);
            }
            Function0 function7 = (Function0) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (f5 >= 0.0f) {
            }
            if (f13 > 1.0f) {
                f14 = 1.0f;
            } else {
                f14 = f13;
            }
            SpacerKt.Spacer(LinearWavyProgressModifiersKt.m4995linearWavyProgressIndicatorOFGGHrU(modifierClipToBounds2, function4, function5, function6, function7, j5, j6, stroke5, stroke6, f11, f14, f12, f10), composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = companion;
            j3 = j5;
            j4 = j6;
            stroke3 = stroke5;
            stroke4 = stroke6;
            f6 = f11;
            f7 = f12;
            f8 = f10;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier2 = modifier;
            j3 = indicatorColor;
            j4 = trackColor;
            stroke3 = linearIndicatorStroke;
            stroke4 = linearTrackStroke;
            f6 = fM4811getLinearIndicatorTrackGapSizeD9Ej5fM;
            f7 = f3;
            f8 = f4;
        }
        f9 = f5;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WavyProgressIndicatorKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WavyProgressIndicatorKt.LinearWavyProgressIndicator_hvuEXSk$lambda$4(modifier2, j3, j4, stroke3, stroke4, f6, f9, f7, f8, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float LinearWavyProgressIndicator_hvuEXSk$lambda$0$0(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float LinearWavyProgressIndicator_hvuEXSk$lambda$1$0(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float LinearWavyProgressIndicator_hvuEXSk$lambda$2$0(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float LinearWavyProgressIndicator_hvuEXSk$lambda$3$0(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX WARN: Code duplicated, block: B:100:0x010c  */
    /* JADX WARN: Code duplicated, block: B:108:0x0122  */
    /* JADX WARN: Code duplicated, block: B:111:0x012f  */
    /* JADX WARN: Code duplicated, block: B:112:0x0131  */
    /* JADX WARN: Code duplicated, block: B:115:0x013a  */
    /* JADX WARN: Code duplicated, block: B:145:0x0197 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:146:0x0199  */
    /* JADX WARN: Code duplicated, block: B:149:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:152:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:155:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:158:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:161:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:164:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:165:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:168:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:169:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:172:0x0201  */
    /* JADX WARN: Code duplicated, block: B:173:0x0205 A[PHI: r0 r3 r5 r6 r7 r9 r11 r12 r15
      0x0205: PHI (r0v41 kotlin.jvm.functions.Function1<? super java.lang.Float, java.lang.Float>) = 
      (r0v19 kotlin.jvm.functions.Function1<? super java.lang.Float, java.lang.Float>)
      (r0v51 kotlin.jvm.functions.Function1<? super java.lang.Float, java.lang.Float>)
     binds: [B:171:0x01ff, B:144:0x0191] A[DONT_GENERATE, DONT_INLINE]
      0x0205: PHI (r3v42 int) = (r3v22 int), (r3v50 int) binds: [B:171:0x01ff, B:144:0x0191] A[DONT_GENERATE, DONT_INLINE]
      0x0205: PHI (r5v8 float) = (r5v4 float), (r5v9 float) binds: [B:171:0x01ff, B:144:0x0191] A[DONT_GENERATE, DONT_INLINE]
      0x0205: PHI (r6v7 androidx.compose.ui.Modifier) = (r6v4 androidx.compose.ui.Modifier), (r6v2 androidx.compose.ui.Modifier) binds: [B:171:0x01ff, B:144:0x0191] A[DONT_GENERATE, DONT_INLINE]
      0x0205: PHI (r7v13 long) = (r7v9 long), (r7v6 long) binds: [B:171:0x01ff, B:144:0x0191] A[DONT_GENERATE, DONT_INLINE]
      0x0205: PHI (r9v9 long) = (r9v6 long), (r9v2 long) binds: [B:171:0x01ff, B:144:0x0191] A[DONT_GENERATE, DONT_INLINE]
      0x0205: PHI (r11v9 androidx.compose.ui.graphics.drawscope.Stroke) = (r11v5 androidx.compose.ui.graphics.drawscope.Stroke), (r11v2 androidx.compose.ui.graphics.drawscope.Stroke) binds: [B:171:0x01ff, B:144:0x0191] A[DONT_GENERATE, DONT_INLINE]
      0x0205: PHI (r12v10 androidx.compose.ui.graphics.drawscope.Stroke) = (r12v6 androidx.compose.ui.graphics.drawscope.Stroke), (r12v3 androidx.compose.ui.graphics.drawscope.Stroke) binds: [B:171:0x01ff, B:144:0x0191] A[DONT_GENERATE, DONT_INLINE]
      0x0205: PHI (r15v9 float) = (r15v6 float), (r15v3 float) binds: [B:171:0x01ff, B:144:0x0191] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:176:0x0210  */
    /* JADX WARN: Code duplicated, block: B:177:0x021e  */
    /* JADX WARN: Code duplicated, block: B:180:0x0255  */
    /* JADX WARN: Code duplicated, block: B:181:0x0257  */
    /* JADX WARN: Code duplicated, block: B:184:0x025e  */
    /* JADX WARN: Code duplicated, block: B:186:0x0266  */
    /* JADX WARN: Code duplicated, block: B:189:0x0282  */
    /* JADX WARN: Code duplicated, block: B:191:0x028e  */
    /* JADX WARN: Code duplicated, block: B:194:0x02a2  */
    /* JADX WARN: Code duplicated, block: B:196:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0044  */
    /* JADX WARN: Code duplicated, block: B:25:0x0048  */
    /* JADX WARN: Code duplicated, block: B:27:0x0050  */
    /* JADX WARN: Code duplicated, block: B:28:0x0053  */
    /* JADX WARN: Code duplicated, block: B:31:0x0059  */
    /* JADX WARN: Code duplicated, block: B:34:0x005f  */
    /* JADX WARN: Code duplicated, block: B:36:0x0063  */
    /* JADX WARN: Code duplicated, block: B:38:0x006b  */
    /* JADX WARN: Code duplicated, block: B:39:0x006e  */
    /* JADX WARN: Code duplicated, block: B:42:0x0074  */
    /* JADX WARN: Code duplicated, block: B:45:0x007a  */
    /* JADX WARN: Code duplicated, block: B:47:0x007e  */
    /* JADX WARN: Code duplicated, block: B:49:0x0086  */
    /* JADX WARN: Code duplicated, block: B:50:0x0089  */
    /* JADX WARN: Code duplicated, block: B:53:0x008f  */
    /* JADX WARN: Code duplicated, block: B:56:0x0096  */
    /* JADX WARN: Code duplicated, block: B:58:0x009a  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:64:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:69:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:71:0x00be  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:75:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:78:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:86:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:89:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:97:0x0104  */
    /* JADX INFO: renamed from: CircularWavyProgressIndicator-L8eD4gc, reason: not valid java name */
    public static final void m4819CircularWavyProgressIndicatorL8eD4gc(Function0<Float> function0, Modifier modifier, long j, long j2, Stroke stroke, Stroke stroke2, float f, Function1<? super Float, Float> function1, float f2, float f3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        long indicatorColor;
        long trackColor;
        Stroke circularIndicatorStroke;
        Stroke circularTrackStroke;
        float fM4805getCircularIndicatorTrackGapSizeD9Ej5fM;
        boolean z;
        final Function0<Float> function2;
        Function1<? super Float, Float> function3;
        final long j3;
        final Stroke stroke3;
        final Stroke stroke4;
        final float f4;
        final float f5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function1<? super Float, Float> indicatorAmplitude;
        float fM4806getCircularWavelengthD9Ej5fM;
        float f6;
        boolean z2;
        Object objRememberedValue;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1437375010);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CircularWavyProgressIndicator)N(progress,modifier,color:c#ui.graphics.Color,trackColor:c#ui.graphics.Color,stroke,trackStroke,gapSize:c#ui.unit.Dp,amplitude,wavelength:c#ui.unit.Dp,waveSpeed:c#ui.unit.Dp)304@15574L485,289@14958L1107:WavyProgressIndicator.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i2 & 4) == 0) {
                    indicatorColor = j;
                    int i5 = composerStartRestartGroup.changed(indicatorColor) ? 256 : 128;
                    i3 |= i5;
                } else {
                    indicatorColor = j;
                }
                i3 |= i5;
            } else {
                indicatorColor = j;
            }
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    trackColor = j2;
                    int i6 = composerStartRestartGroup.changed(trackColor) ? 2048 : 1024;
                    i3 |= i6;
                } else {
                    trackColor = j2;
                }
                i3 |= i6;
            } else {
                trackColor = j2;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    circularIndicatorStroke = stroke;
                    int i7 = composerStartRestartGroup.changedInstance(circularIndicatorStroke) ? 16384 : 8192;
                    i3 |= i7;
                } else {
                    circularIndicatorStroke = stroke;
                }
                i3 |= i7;
            } else {
                circularIndicatorStroke = stroke;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    circularTrackStroke = stroke2;
                    int i8 = composerStartRestartGroup.changedInstance(circularTrackStroke) ? 131072 : 65536;
                    i3 |= i8;
                } else {
                    circularTrackStroke = stroke2;
                }
                i3 |= i8;
            } else {
                circularTrackStroke = stroke2;
            }
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    fM4805getCircularIndicatorTrackGapSizeD9Ej5fM = f;
                    int i9 = composerStartRestartGroup.changed(fM4805getCircularIndicatorTrackGapSizeD9Ej5fM) ? 1048576 : 524288;
                    i3 |= i9;
                } else {
                    fM4805getCircularIndicatorTrackGapSizeD9Ej5fM = f;
                }
                i3 |= i9;
            } else {
                fM4805getCircularIndicatorTrackGapSizeD9Ej5fM = f;
            }
            if ((i & 12582912) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changedInstance(function1)) ? 4194304 : 8388608;
            }
            if ((i & 100663296) != 0) {
                i3 |= ((i2 & 256) == 0 || !composerStartRestartGroup.changed(f2)) ? 33554432 : 67108864;
            }
            if ((i & 805306368) != 0) {
                i3 |= ((i2 & 512) == 0 || !composerStartRestartGroup.changed(f3)) ? 268435456 : C.BUFFER_FLAG_LAST_SAMPLE;
            }
            if ((i3 & 306783379) != 306783378) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "280@14403L14,281@14473L10,282@14536L23,283@14617L19");
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i4 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 4) != 0) {
                        indicatorColor = WavyProgressIndicatorDefaults.INSTANCE.getIndicatorColor(composerStartRestartGroup, 0);
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        trackColor = WavyProgressIndicatorDefaults.INSTANCE.getTrackColor(composerStartRestartGroup, 0);
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        circularIndicatorStroke = WavyProgressIndicatorDefaults.INSTANCE.getCircularIndicatorStroke(composerStartRestartGroup, 0);
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        circularTrackStroke = WavyProgressIndicatorDefaults.INSTANCE.getCircularTrackStroke(composerStartRestartGroup, 0);
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        fM4805getCircularIndicatorTrackGapSizeD9Ej5fM = WavyProgressIndicatorDefaults.INSTANCE.m4805getCircularIndicatorTrackGapSizeD9Ej5fM();
                    }
                    if ((i2 & 128) != 0) {
                        indicatorAmplitude = WavyProgressIndicatorDefaults.INSTANCE.getIndicatorAmplitude();
                        i3 &= -29360129;
                    } else {
                        indicatorAmplitude = function1;
                    }
                    if ((i2 & 256) != 0) {
                        fM4806getCircularWavelengthD9Ej5fM = WavyProgressIndicatorDefaults.INSTANCE.m4806getCircularWavelengthD9Ej5fM();
                        i3 &= -234881025;
                    } else {
                        fM4806getCircularWavelengthD9Ej5fM = f2;
                    }
                    if ((i2 & 512) != 0) {
                        i3 &= -1879048193;
                        f6 = fM4806getCircularWavelengthD9Ej5fM;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1437375010, i3, -1, "androidx.compose.material3.CircularWavyProgressIndicator (WavyProgressIndicator.kt:288)");
                    }
                    Modifier modifierM4962circularWavyProgressIndicator4ohQjRg = CircularWavyProgressModifiersKt.m4962circularWavyProgressIndicator4ohQjRg(SizeKt.m1266size3ABfNKs(modifier2, WavyProgressIndicatorDefaults.INSTANCE.m4804getCircularContainerSizeD9Ej5fM()), function0, indicatorColor, trackColor, circularIndicatorStroke, circularTrackStroke, fM4805getCircularIndicatorTrackGapSizeD9Ej5fM, indicatorAmplitude, fM4806getCircularWavelengthD9Ej5fM, f6);
                    function2 = function0;
                    float f7 = f6;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1662127331, "CC(remember):WavyProgressIndicator.kt#9igjgp");
                    if ((i3 & 14) == 4) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material3.WavyProgressIndicatorKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return WavyProgressIndicatorKt.CircularWavyProgressIndicator_L8eD4gc$lambda$0$0(function2, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    SpacerKt.Spacer(SemanticsModifierKt.semantics(modifierM4962circularWavyProgressIndicator4ohQjRg, true, (Function1) objRememberedValue), composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function3 = indicatorAmplitude;
                    j3 = indicatorColor;
                    stroke3 = circularIndicatorStroke;
                    stroke4 = circularTrackStroke;
                    f5 = f7;
                    f4 = fM4806getCircularWavelengthD9Ej5fM;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        i3 &= -29360129;
                    }
                    if ((i2 & 256) != 0) {
                        i3 &= -234881025;
                    }
                    if ((i2 & 512) != 0) {
                        i3 &= -1879048193;
                    }
                    indicatorAmplitude = function1;
                    fM4806getCircularWavelengthD9Ej5fM = f2;
                }
                f6 = f3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1437375010, i3, -1, "androidx.compose.material3.CircularWavyProgressIndicator (WavyProgressIndicator.kt:288)");
                }
                Modifier modifierM4962circularWavyProgressIndicator4ohQjRg2 = CircularWavyProgressModifiersKt.m4962circularWavyProgressIndicator4ohQjRg(SizeKt.m1266size3ABfNKs(modifier2, WavyProgressIndicatorDefaults.INSTANCE.m4804getCircularContainerSizeD9Ej5fM()), function0, indicatorColor, trackColor, circularIndicatorStroke, circularTrackStroke, fM4805getCircularIndicatorTrackGapSizeD9Ej5fM, indicatorAmplitude, fM4806getCircularWavelengthD9Ej5fM, f6);
                function2 = function0;
                float f8 = f6;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1662127331, "CC(remember):WavyProgressIndicator.kt#9igjgp");
                if ((i3 & 14) == 4) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z2) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.WavyProgressIndicatorKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return WavyProgressIndicatorKt.CircularWavyProgressIndicator_L8eD4gc$lambda$0$0(function2, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.WavyProgressIndicatorKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return WavyProgressIndicatorKt.CircularWavyProgressIndicator_L8eD4gc$lambda$0$0(function2, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SpacerKt.Spacer(SemanticsModifierKt.semantics(modifierM4962circularWavyProgressIndicator4ohQjRg2, true, (Function1) objRememberedValue), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function3 = indicatorAmplitude;
                j3 = indicatorColor;
                stroke3 = circularIndicatorStroke;
                stroke4 = circularTrackStroke;
                f5 = f8;
                f4 = fM4806getCircularWavelengthD9Ej5fM;
            } else {
                function2 = function0;
                composerStartRestartGroup.skipToGroupEnd();
                function3 = function1;
                j3 = indicatorColor;
                stroke3 = circularIndicatorStroke;
                stroke4 = circularTrackStroke;
                f4 = f2;
                f5 = f3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final long j4 = trackColor;
                final Modifier modifier3 = modifier2;
                final Function1<? super Float, Float> function4 = function3;
                final float f9 = fM4805getCircularIndicatorTrackGapSizeD9Ej5fM;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WavyProgressIndicatorKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return WavyProgressIndicatorKt.CircularWavyProgressIndicator_L8eD4gc$lambda$1(function2, modifier3, j3, j4, stroke3, stroke4, f9, function4, f4, f5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                indicatorColor = j;
                if (composerStartRestartGroup.changed(indicatorColor)) {
                }
                i3 |= i5;
            } else {
                indicatorColor = j;
            }
            i3 |= i5;
        } else {
            indicatorColor = j;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                trackColor = j2;
                if (composerStartRestartGroup.changed(trackColor)) {
                }
                i3 |= i6;
            } else {
                trackColor = j2;
            }
            i3 |= i6;
        } else {
            trackColor = j2;
        }
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                circularIndicatorStroke = stroke;
                if (composerStartRestartGroup.changedInstance(circularIndicatorStroke)) {
                }
                i3 |= i7;
            } else {
                circularIndicatorStroke = stroke;
            }
            i3 |= i7;
        } else {
            circularIndicatorStroke = stroke;
        }
        if ((196608 & i) == 0) {
            if ((i2 & 32) == 0) {
                circularTrackStroke = stroke2;
                if (composerStartRestartGroup.changedInstance(circularTrackStroke)) {
                }
                i3 |= i8;
            } else {
                circularTrackStroke = stroke2;
            }
            i3 |= i8;
        } else {
            circularTrackStroke = stroke2;
        }
        if ((1572864 & i) == 0) {
            if ((i2 & 64) == 0) {
                fM4805getCircularIndicatorTrackGapSizeD9Ej5fM = f;
                if (composerStartRestartGroup.changed(fM4805getCircularIndicatorTrackGapSizeD9Ej5fM)) {
                }
                i3 |= i9;
            } else {
                fM4805getCircularIndicatorTrackGapSizeD9Ej5fM = f;
            }
            i3 |= i9;
        } else {
            fM4805getCircularIndicatorTrackGapSizeD9Ej5fM = f;
        }
        if ((i & 12582912) != 0) {
            i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changedInstance(function1)) ? 4194304 : 8388608;
        }
        if ((i & 100663296) != 0) {
            i3 |= ((i2 & 256) == 0 || !composerStartRestartGroup.changed(f2)) ? 33554432 : 67108864;
        }
        if ((i & 805306368) != 0) {
            i3 |= ((i2 & 512) == 0 || !composerStartRestartGroup.changed(f3)) ? 268435456 : C.BUFFER_FLAG_LAST_SAMPLE;
        }
        if ((i3 & 306783379) != 306783378) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "280@14403L14,281@14473L10,282@14536L23,283@14617L19");
            if ((i & 1) != 0) {
                if (i4 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i2 & 4) != 0) {
                    indicatorColor = WavyProgressIndicatorDefaults.INSTANCE.getIndicatorColor(composerStartRestartGroup, 0);
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    trackColor = WavyProgressIndicatorDefaults.INSTANCE.getTrackColor(composerStartRestartGroup, 0);
                    i3 &= -7169;
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    circularIndicatorStroke = WavyProgressIndicatorDefaults.INSTANCE.getCircularIndicatorStroke(composerStartRestartGroup, 0);
                }
                if ((i2 & 32) != 0) {
                    i3 &= -458753;
                    circularTrackStroke = WavyProgressIndicatorDefaults.INSTANCE.getCircularTrackStroke(composerStartRestartGroup, 0);
                }
                if ((i2 & 64) != 0) {
                    i3 &= -3670017;
                    fM4805getCircularIndicatorTrackGapSizeD9Ej5fM = WavyProgressIndicatorDefaults.INSTANCE.m4805getCircularIndicatorTrackGapSizeD9Ej5fM();
                }
                if ((i2 & 128) != 0) {
                    indicatorAmplitude = WavyProgressIndicatorDefaults.INSTANCE.getIndicatorAmplitude();
                    i3 &= -29360129;
                } else {
                    indicatorAmplitude = function1;
                }
                if ((i2 & 256) != 0) {
                    fM4806getCircularWavelengthD9Ej5fM = WavyProgressIndicatorDefaults.INSTANCE.m4806getCircularWavelengthD9Ej5fM();
                    i3 &= -234881025;
                } else {
                    fM4806getCircularWavelengthD9Ej5fM = f2;
                }
                if ((i2 & 512) != 0) {
                    i3 &= -1879048193;
                    f6 = fM4806getCircularWavelengthD9Ej5fM;
                } else {
                    f6 = f3;
                }
            } else {
                if (i4 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i2 & 4) != 0) {
                    indicatorColor = WavyProgressIndicatorDefaults.INSTANCE.getIndicatorColor(composerStartRestartGroup, 0);
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    trackColor = WavyProgressIndicatorDefaults.INSTANCE.getTrackColor(composerStartRestartGroup, 0);
                    i3 &= -7169;
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    circularIndicatorStroke = WavyProgressIndicatorDefaults.INSTANCE.getCircularIndicatorStroke(composerStartRestartGroup, 0);
                }
                if ((i2 & 32) != 0) {
                    i3 &= -458753;
                    circularTrackStroke = WavyProgressIndicatorDefaults.INSTANCE.getCircularTrackStroke(composerStartRestartGroup, 0);
                }
                if ((i2 & 64) != 0) {
                    i3 &= -3670017;
                    fM4805getCircularIndicatorTrackGapSizeD9Ej5fM = WavyProgressIndicatorDefaults.INSTANCE.m4805getCircularIndicatorTrackGapSizeD9Ej5fM();
                }
                if ((i2 & 128) != 0) {
                    indicatorAmplitude = WavyProgressIndicatorDefaults.INSTANCE.getIndicatorAmplitude();
                    i3 &= -29360129;
                } else {
                    indicatorAmplitude = function1;
                }
                if ((i2 & 256) != 0) {
                    fM4806getCircularWavelengthD9Ej5fM = WavyProgressIndicatorDefaults.INSTANCE.m4806getCircularWavelengthD9Ej5fM();
                    i3 &= -234881025;
                } else {
                    fM4806getCircularWavelengthD9Ej5fM = f2;
                }
                if ((i2 & 512) != 0) {
                    i3 &= -1879048193;
                    f6 = fM4806getCircularWavelengthD9Ej5fM;
                } else {
                    f6 = f3;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1437375010, i3, -1, "androidx.compose.material3.CircularWavyProgressIndicator (WavyProgressIndicator.kt:288)");
            }
            Modifier modifierM4962circularWavyProgressIndicator4ohQjRg3 = CircularWavyProgressModifiersKt.m4962circularWavyProgressIndicator4ohQjRg(SizeKt.m1266size3ABfNKs(modifier2, WavyProgressIndicatorDefaults.INSTANCE.m4804getCircularContainerSizeD9Ej5fM()), function0, indicatorColor, trackColor, circularIndicatorStroke, circularTrackStroke, fM4805getCircularIndicatorTrackGapSizeD9Ej5fM, indicatorAmplitude, fM4806getCircularWavelengthD9Ej5fM, f6);
            function2 = function0;
            float f10 = f6;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1662127331, "CC(remember):WavyProgressIndicator.kt#9igjgp");
            if ((i3 & 14) == 4) {
                z2 = true;
            } else {
                z2 = false;
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z2) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.WavyProgressIndicatorKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return WavyProgressIndicatorKt.CircularWavyProgressIndicator_L8eD4gc$lambda$0$0(function2, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.WavyProgressIndicatorKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return WavyProgressIndicatorKt.CircularWavyProgressIndicator_L8eD4gc$lambda$0$0(function2, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SpacerKt.Spacer(SemanticsModifierKt.semantics(modifierM4962circularWavyProgressIndicator4ohQjRg3, true, (Function1) objRememberedValue), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function3 = indicatorAmplitude;
            j3 = indicatorColor;
            stroke3 = circularIndicatorStroke;
            stroke4 = circularTrackStroke;
            f5 = f10;
            f4 = fM4806getCircularWavelengthD9Ej5fM;
        } else {
            function2 = function0;
            composerStartRestartGroup.skipToGroupEnd();
            function3 = function1;
            j3 = indicatorColor;
            stroke3 = circularIndicatorStroke;
            stroke4 = circularTrackStroke;
            f4 = f2;
            f5 = f3;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final long j5 = trackColor;
            final Modifier modifier4 = modifier2;
            final Function1 function5 = function3;
            final float f11 = fM4805getCircularIndicatorTrackGapSizeD9Ej5fM;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WavyProgressIndicatorKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WavyProgressIndicatorKt.CircularWavyProgressIndicator_L8eD4gc$lambda$1(function2, modifier4, j3, j5, stroke3, stroke4, f11, function5, f4, f5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CircularWavyProgressIndicator_L8eD4gc$lambda$0$0(Function0 function0, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        float fCoerceIn = RangesKt.coerceIn(((Number) function0.invoke()).floatValue(), 0.0f, 1.0f);
        SemanticsPropertiesKt.setProgressBarRangeInfo(semanticsPropertyReceiver, new ProgressBarRangeInfo(Float.isNaN(fCoerceIn) ? 0.0f : fCoerceIn, RangesKt.rangeTo(0.0f, 1.0f), 0, 4, null));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x010f  */
    /* JADX WARN: Code duplicated, block: B:103:0x011d  */
    /* JADX WARN: Code duplicated, block: B:104:0x011f  */
    /* JADX WARN: Code duplicated, block: B:107:0x0128  */
    /* JADX WARN: Code duplicated, block: B:134:0x0179 A[PHI: r0 r2 r4 r5 r7 r9 r10 r11 r14
      0x0179: PHI (r0v35 androidx.compose.ui.Modifier) = (r0v11 androidx.compose.ui.Modifier), (r0v44 androidx.compose.ui.Modifier) binds: [B:163:0x01e6, B:133:0x0173] A[DONT_GENERATE, DONT_INLINE]
      0x0179: PHI (r2v28 float) = (r2v11 float), (r2v29 float) binds: [B:163:0x01e6, B:133:0x0173] A[DONT_GENERATE, DONT_INLINE]
      0x0179: PHI (r4v44 int) = (r4v23 int), (r4v52 int) binds: [B:163:0x01e6, B:133:0x0173] A[DONT_GENERATE, DONT_INLINE]
      0x0179: PHI (r5v12 long) = (r5v3 long), (r5v2 long) binds: [B:163:0x01e6, B:133:0x0173] A[DONT_GENERATE, DONT_INLINE]
      0x0179: PHI (r7v10 long) = (r7v5 long), (r7v2 long) binds: [B:163:0x01e6, B:133:0x0173] A[DONT_GENERATE, DONT_INLINE]
      0x0179: PHI (r9v9 androidx.compose.ui.graphics.drawscope.Stroke) = (r9v5 androidx.compose.ui.graphics.drawscope.Stroke), (r9v2 androidx.compose.ui.graphics.drawscope.Stroke) binds: [B:163:0x01e6, B:133:0x0173] A[DONT_GENERATE, DONT_INLINE]
      0x0179: PHI (r10v10 androidx.compose.ui.graphics.drawscope.Stroke) = (r10v5 androidx.compose.ui.graphics.drawscope.Stroke), (r10v2 androidx.compose.ui.graphics.drawscope.Stroke) binds: [B:163:0x01e6, B:133:0x0173] A[DONT_GENERATE, DONT_INLINE]
      0x0179: PHI (r11v12 float) = (r11v7 float), (r11v13 float) binds: [B:163:0x01e6, B:133:0x0173] A[DONT_GENERATE, DONT_INLINE]
      0x0179: PHI (r14v8 float) = (r14v4 float), (r14v9 float) binds: [B:163:0x01e6, B:133:0x0173] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:135:0x017e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:136:0x0180  */
    /* JADX WARN: Code duplicated, block: B:137:0x0185  */
    /* JADX WARN: Code duplicated, block: B:140:0x018b  */
    /* JADX WARN: Code duplicated, block: B:141:0x019a  */
    /* JADX WARN: Code duplicated, block: B:144:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:147:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:150:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:153:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:154:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:156:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:157:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:160:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:161:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:164:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:167:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:168:0x0203  */
    /* JADX WARN: Code duplicated, block: B:171:0x0254  */
    /* JADX WARN: Code duplicated, block: B:174:0x0260  */
    /* JADX WARN: Code duplicated, block: B:175:0x0264  */
    /* JADX WARN: Code duplicated, block: B:178:0x0289  */
    /* JADX WARN: Code duplicated, block: B:180:0x0297  */
    /* JADX WARN: Code duplicated, block: B:183:0x0312  */
    /* JADX WARN: Code duplicated, block: B:185:0x031d  */
    /* JADX WARN: Code duplicated, block: B:188:0x0332  */
    /* JADX WARN: Code duplicated, block: B:190:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:81:0x00db  */
    /* JADX WARN: Code duplicated, block: B:89:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:92:0x00f9  */
    /* JADX INFO: renamed from: CircularWavyProgressIndicator-hvuEXSk, reason: not valid java name */
    public static final void m4820CircularWavyProgressIndicatorhvuEXSk(Modifier modifier, long j, long j2, Stroke stroke, Stroke stroke2, float f, float f2, float f3, float f4, Composer composer, final int i, final int i2) {
        int i3;
        long indicatorColor;
        long trackColor;
        Stroke circularIndicatorStroke;
        Stroke circularTrackStroke;
        float f5;
        float f6;
        boolean z;
        Modifier modifier2;
        final long j3;
        final long j4;
        final Stroke stroke3;
        final float f7;
        final float f8;
        final float f9;
        final Stroke stroke4;
        final float f10;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        int i4;
        float fM4805getCircularIndicatorTrackGapSizeD9Ej5fM;
        float f11;
        float fM4806getCircularWavelengthD9Ej5fM;
        int i5;
        float f12;
        int currentCompositeKeyHash;
        Function0<ComposeUiNode> constructor;
        Composer composerM6062constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        Composer composerStartRestartGroup = composer.startRestartGroup(958856149);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CircularWavyProgressIndicator)N(modifier,color:c#ui.graphics.Color,trackColor:c#ui.graphics.Color,stroke,trackStroke,gapSize:c#ui.unit.Dp,amplitude,wavelength:c#ui.unit.Dp,waveSpeed:c#ui.unit.Dp)359@18671L813:WavyProgressIndicator.kt#uh7d8r");
        int i6 = i2 & 1;
        if (i6 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                indicatorColor = j;
                int i7 = composerStartRestartGroup.changed(indicatorColor) ? 32 : 16;
                i3 |= i7;
            } else {
                indicatorColor = j;
            }
            i3 |= i7;
        } else {
            indicatorColor = j;
        }
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                trackColor = j2;
                int i8 = composerStartRestartGroup.changed(trackColor) ? 256 : 128;
                i3 |= i8;
            } else {
                trackColor = j2;
            }
            i3 |= i8;
        } else {
            trackColor = j2;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                circularIndicatorStroke = stroke;
                int i9 = composerStartRestartGroup.changedInstance(circularIndicatorStroke) ? 2048 : 1024;
                i3 |= i9;
            } else {
                circularIndicatorStroke = stroke;
            }
            i3 |= i9;
        } else {
            circularIndicatorStroke = stroke;
        }
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                circularTrackStroke = stroke2;
                int i10 = composerStartRestartGroup.changedInstance(circularTrackStroke) ? 16384 : 8192;
                i3 |= i10;
            } else {
                circularTrackStroke = stroke2;
            }
            i3 |= i10;
        } else {
            circularTrackStroke = stroke2;
        }
        if ((196608 & i) == 0) {
            if ((i2 & 32) == 0) {
                f5 = f;
                int i11 = composerStartRestartGroup.changed(f5) ? 131072 : 65536;
                i3 |= i11;
            } else {
                f5 = f;
            }
            i3 |= i11;
        } else {
            f5 = f;
        }
        int i12 = i2 & 64;
        if (i12 == 0) {
            if ((1572864 & i) == 0) {
                f6 = f2;
                i3 |= composerStartRestartGroup.changed(f6) ? 1048576 : 524288;
            }
            if ((i & 12582912) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(f3)) ? 4194304 : 8388608;
            }
            if ((i & 100663296) != 0) {
                i3 |= ((i2 & 256) == 0 || !composerStartRestartGroup.changed(f4)) ? 33554432 : 67108864;
            }
            if ((i3 & 38347923) != 38347922) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "350@18149L14,351@18219L10,352@18282L23,353@18363L19");
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                        i4 = 0;
                        indicatorColor = WavyProgressIndicatorDefaults.INSTANCE.getIndicatorColor(composerStartRestartGroup, 0);
                    } else {
                        i4 = 0;
                    }
                    if ((i2 & 4) != 0) {
                        trackColor = WavyProgressIndicatorDefaults.INSTANCE.getTrackColor(composerStartRestartGroup, i4);
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        circularIndicatorStroke = WavyProgressIndicatorDefaults.INSTANCE.getCircularIndicatorStroke(composerStartRestartGroup, i4);
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        circularTrackStroke = WavyProgressIndicatorDefaults.INSTANCE.getCircularTrackStroke(composerStartRestartGroup, i4);
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        fM4805getCircularIndicatorTrackGapSizeD9Ej5fM = WavyProgressIndicatorDefaults.INSTANCE.m4805getCircularIndicatorTrackGapSizeD9Ej5fM();
                        i3 &= -458753;
                    } else {
                        fM4805getCircularIndicatorTrackGapSizeD9Ej5fM = f5;
                    }
                    if (i12 != 0) {
                        f11 = 1.0f;
                    } else {
                        f11 = f6;
                    }
                    if ((i2 & 128) != 0) {
                        fM4806getCircularWavelengthD9Ej5fM = WavyProgressIndicatorDefaults.INSTANCE.m4806getCircularWavelengthD9Ej5fM();
                        i3 &= -29360129;
                    } else {
                        fM4806getCircularWavelengthD9Ej5fM = f3;
                    }
                    if ((i2 & 256) != 0) {
                        i5 = i3 & (-234881025);
                        f12 = fM4806getCircularWavelengthD9Ej5fM;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(958856149, i5, -1, "androidx.compose.material3.CircularWavyProgressIndicator (WavyProgressIndicator.kt:358)");
                    }
                    Modifier modifierM1266size3ABfNKs = SizeKt.m1266size3ABfNKs(companion, WavyProgressIndicatorDefaults.INSTANCE.m4804getCircularContainerSizeD9Ej5fM());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    modifier2 = companion;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1266size3ABfNKs);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    long j5 = indicatorColor;
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1902088322, "C360@18764L452,375@19417L61:WavyProgressIndicator.kt#uh7d8r");
                    float f13 = f11;
                    float f14 = fM4805getCircularIndicatorTrackGapSizeD9Ej5fM;
                    f6 = f13;
                    float f15 = f12;
                    SpacerKt.Spacer(CircularWavyProgressModifiersKt.m4961circularWavyProgressIndicator4JQtiWo(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), j5, trackColor, circularIndicatorStroke, circularTrackStroke, fM4805getCircularIndicatorTrackGapSizeD9Ej5fM, f13, fM4806getCircularWavelengthD9Ej5fM, f12), composerStartRestartGroup, 0);
                    SpacerKt.Spacer(ProgressSemanticsKt.progressSemantics(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null)), composerStartRestartGroup, 6);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j3 = j5;
                    j4 = trackColor;
                    stroke3 = circularTrackStroke;
                    f7 = f14;
                    f8 = fM4806getCircularWavelengthD9Ej5fM;
                    f9 = f15;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                    }
                    if ((i2 & 128) != 0) {
                        i3 &= -29360129;
                    }
                    if ((i2 & 256) != 0) {
                        i3 &= -234881025;
                    }
                    companion = modifier;
                    fM4806getCircularWavelengthD9Ej5fM = f3;
                    fM4805getCircularIndicatorTrackGapSizeD9Ej5fM = f5;
                    f11 = f6;
                }
                i5 = i3;
                f12 = f4;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(958856149, i5, -1, "androidx.compose.material3.CircularWavyProgressIndicator (WavyProgressIndicator.kt:358)");
                }
                Modifier modifierM1266size3ABfNKs2 = SizeKt.m1266size3ABfNKs(companion, WavyProgressIndicatorDefaults.INSTANCE.m4804getCircularContainerSizeD9Ej5fM());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                modifier2 = companion;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1266size3ABfNKs2);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                long j6 = indicatorColor;
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1902088322, "C360@18764L452,375@19417L61:WavyProgressIndicator.kt#uh7d8r");
                float f16 = f11;
                float f17 = fM4805getCircularIndicatorTrackGapSizeD9Ej5fM;
                f6 = f16;
                float f18 = f12;
                SpacerKt.Spacer(CircularWavyProgressModifiersKt.m4961circularWavyProgressIndicator4JQtiWo(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), j6, trackColor, circularIndicatorStroke, circularTrackStroke, fM4805getCircularIndicatorTrackGapSizeD9Ej5fM, f16, fM4806getCircularWavelengthD9Ej5fM, f12), composerStartRestartGroup, 0);
                SpacerKt.Spacer(ProgressSemanticsKt.progressSemantics(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null)), composerStartRestartGroup, 6);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j3 = j6;
                j4 = trackColor;
                stroke3 = circularTrackStroke;
                f7 = f17;
                f8 = fM4806getCircularWavelengthD9Ej5fM;
                f9 = f18;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier2 = modifier;
                j3 = indicatorColor;
                j4 = trackColor;
                stroke3 = circularTrackStroke;
                f7 = f5;
                f8 = f3;
                f9 = f4;
            }
            stroke4 = circularIndicatorStroke;
            f10 = f6;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier3 = modifier2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WavyProgressIndicatorKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return WavyProgressIndicatorKt.CircularWavyProgressIndicator_hvuEXSk$lambda$1(modifier3, j3, j4, stroke4, stroke3, f7, f10, f8, f9, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 1572864;
        f6 = f2;
        if ((i & 12582912) != 0) {
            i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(f3)) ? 4194304 : 8388608;
        }
        if ((i & 100663296) != 0) {
            i3 |= ((i2 & 256) == 0 || !composerStartRestartGroup.changed(f4)) ? 33554432 : 67108864;
        }
        if ((i3 & 38347923) != 38347922) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "350@18149L14,351@18219L10,352@18282L23,353@18363L19");
            if ((i & 1) != 0) {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                    i4 = 0;
                    indicatorColor = WavyProgressIndicatorDefaults.INSTANCE.getIndicatorColor(composerStartRestartGroup, 0);
                } else {
                    i4 = 0;
                }
                if ((i2 & 4) != 0) {
                    trackColor = WavyProgressIndicatorDefaults.INSTANCE.getTrackColor(composerStartRestartGroup, i4);
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    circularIndicatorStroke = WavyProgressIndicatorDefaults.INSTANCE.getCircularIndicatorStroke(composerStartRestartGroup, i4);
                    i3 &= -7169;
                }
                if ((i2 & 16) != 0) {
                    circularTrackStroke = WavyProgressIndicatorDefaults.INSTANCE.getCircularTrackStroke(composerStartRestartGroup, i4);
                    i3 &= -57345;
                }
                if ((i2 & 32) != 0) {
                    fM4805getCircularIndicatorTrackGapSizeD9Ej5fM = WavyProgressIndicatorDefaults.INSTANCE.m4805getCircularIndicatorTrackGapSizeD9Ej5fM();
                    i3 &= -458753;
                } else {
                    fM4805getCircularIndicatorTrackGapSizeD9Ej5fM = f5;
                }
                if (i12 != 0) {
                    f11 = 1.0f;
                } else {
                    f11 = f6;
                }
                if ((i2 & 128) != 0) {
                    fM4806getCircularWavelengthD9Ej5fM = WavyProgressIndicatorDefaults.INSTANCE.m4806getCircularWavelengthD9Ej5fM();
                    i3 &= -29360129;
                } else {
                    fM4806getCircularWavelengthD9Ej5fM = f3;
                }
                if ((i2 & 256) != 0) {
                    i5 = i3 & (-234881025);
                    f12 = fM4806getCircularWavelengthD9Ej5fM;
                } else {
                    i5 = i3;
                    f12 = f4;
                }
            } else {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                    i4 = 0;
                    indicatorColor = WavyProgressIndicatorDefaults.INSTANCE.getIndicatorColor(composerStartRestartGroup, 0);
                } else {
                    i4 = 0;
                }
                if ((i2 & 4) != 0) {
                    trackColor = WavyProgressIndicatorDefaults.INSTANCE.getTrackColor(composerStartRestartGroup, i4);
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    circularIndicatorStroke = WavyProgressIndicatorDefaults.INSTANCE.getCircularIndicatorStroke(composerStartRestartGroup, i4);
                    i3 &= -7169;
                }
                if ((i2 & 16) != 0) {
                    circularTrackStroke = WavyProgressIndicatorDefaults.INSTANCE.getCircularTrackStroke(composerStartRestartGroup, i4);
                    i3 &= -57345;
                }
                if ((i2 & 32) != 0) {
                    fM4805getCircularIndicatorTrackGapSizeD9Ej5fM = WavyProgressIndicatorDefaults.INSTANCE.m4805getCircularIndicatorTrackGapSizeD9Ej5fM();
                    i3 &= -458753;
                } else {
                    fM4805getCircularIndicatorTrackGapSizeD9Ej5fM = f5;
                }
                if (i12 != 0) {
                    f11 = 1.0f;
                } else {
                    f11 = f6;
                }
                if ((i2 & 128) != 0) {
                    fM4806getCircularWavelengthD9Ej5fM = WavyProgressIndicatorDefaults.INSTANCE.m4806getCircularWavelengthD9Ej5fM();
                    i3 &= -29360129;
                } else {
                    fM4806getCircularWavelengthD9Ej5fM = f3;
                }
                if ((i2 & 256) != 0) {
                    i5 = i3 & (-234881025);
                    f12 = fM4806getCircularWavelengthD9Ej5fM;
                } else {
                    i5 = i3;
                    f12 = f4;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(958856149, i5, -1, "androidx.compose.material3.CircularWavyProgressIndicator (WavyProgressIndicator.kt:358)");
            }
            Modifier modifierM1266size3ABfNKs3 = SizeKt.m1266size3ABfNKs(companion, WavyProgressIndicatorDefaults.INSTANCE.m4804getCircularContainerSizeD9Ej5fM());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            modifier2 = companion;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1266size3ABfNKs3);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            long j7 = indicatorColor;
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1902088322, "C360@18764L452,375@19417L61:WavyProgressIndicator.kt#uh7d8r");
            float f19 = f11;
            float f110 = fM4805getCircularIndicatorTrackGapSizeD9Ej5fM;
            f6 = f19;
            float f111 = f12;
            SpacerKt.Spacer(CircularWavyProgressModifiersKt.m4961circularWavyProgressIndicator4JQtiWo(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), j7, trackColor, circularIndicatorStroke, circularTrackStroke, fM4805getCircularIndicatorTrackGapSizeD9Ej5fM, f19, fM4806getCircularWavelengthD9Ej5fM, f12), composerStartRestartGroup, 0);
            SpacerKt.Spacer(ProgressSemanticsKt.progressSemantics(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null)), composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            j3 = j7;
            j4 = trackColor;
            stroke3 = circularTrackStroke;
            f7 = f110;
            f8 = fM4806getCircularWavelengthD9Ej5fM;
            f9 = f111;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
            j3 = indicatorColor;
            j4 = trackColor;
            stroke3 = circularTrackStroke;
            f7 = f5;
            f8 = f3;
            f9 = f4;
        }
        stroke4 = circularIndicatorStroke;
        f10 = f6;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WavyProgressIndicatorKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WavyProgressIndicatorKt.CircularWavyProgressIndicator_hvuEXSk$lambda$1(modifier4, j3, j4, stroke4, stroke3, f7, f10, f8, f9, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final AnimationSpec<Float> getIncreasingAmplitudeAnimationSpec() {
        return IncreasingAmplitudeAnimationSpec;
    }

    public static final AnimationSpec<Float> getDecreasingAmplitudeAnimationSpec() {
        return DecreasingAmplitudeAnimationSpec;
    }
}
