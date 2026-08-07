package androidx.constraintlayout.compose;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.motion.widget.Key;
import androidx.media3.common.C;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: compiled from: LateMotionLayout.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\\\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a\u0098\u0001\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0011\u0010\u0016\u001a\r\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0017H\u0001¢\u0006\u0002\u0010\u0018\u001a^\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00132\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u00132\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\b0\f2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002¨\u0006 "}, d2 = {"LateMotionLayout", "", "start", "Landroidx/compose/runtime/MutableState;", "Landroidx/constraintlayout/compose/ConstraintSet;", "end", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "channel", "Lkotlinx/coroutines/channels/Channel;", "contentTracker", "Landroidx/compose/runtime/State;", "compositionSource", "Landroidx/compose/ui/node/Ref;", "Landroidx/constraintlayout/compose/CompositionSource;", "optimizationLevel", "", "finishedAnimationListener", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/animation/core/AnimationSpec;Lkotlinx/coroutines/channels/Channel;Landroidx/compose/runtime/State;Landroidx/compose/ui/node/Ref;ILkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "lateMotionLayoutMeasurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "startProvider", "endProvider", Key.MOTIONPROGRESS, "measurer", "Landroidx/constraintlayout/compose/MotionMeasurer;", "constraintlayout-compose_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LateMotionLayoutKt {
    public static final void LateMotionLayout(final MutableState<ConstraintSet> mutableState, final MutableState<ConstraintSet> mutableState2, final AnimationSpec<Float> animationSpec, Channel<ConstraintSet> channel, final androidx.compose.runtime.State<Unit> state, final Ref<CompositionSource> ref, final int i, final Function0<Unit> function0, final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i2) {
        int i3;
        androidx.compose.runtime.State<Unit> state2;
        int i4;
        Composer composer2;
        final Channel<ConstraintSet> channel2;
        Composer composerStartRestartGroup = composer.startRestartGroup(688627412);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LateMotionLayout)P(9,5!2,4!1,8,6,7)56@2099L7,57@2126L36,59@2193L29,60@2248L41,61@2310L33,67@2542L30,68@2600L28,78@2956L33,77@2898L163,83@3091L941,83@3067L965:LateMotionLayout.kt#fysre8");
        if ((i2 & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(mutableState) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(mutableState2) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(animationSpec) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(channel) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            state2 = state;
            i3 |= composerStartRestartGroup.changed(state2) ? 16384 : 8192;
        } else {
            state2 = state;
        }
        if ((196608 & i2) == 0) {
            i3 |= (i2 & 262144) == 0 ? composerStartRestartGroup.changed(ref) : composerStartRestartGroup.changedInstance(ref) ? 131072 : 65536;
        }
        if ((1572864 & i2) == 0) {
            i4 = i;
            i3 |= composerStartRestartGroup.changed(i4) ? 1048576 : 524288;
        } else {
            i4 = i;
        }
        if ((i2 & 12582912) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 8388608 : 4194304;
        }
        if ((i2 & 100663296) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 67108864 : 33554432;
        }
        if ((i2 & 805306368) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        if ((i3 & 306783379) != 306783378 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(688627412, i3, -1, "androidx.constraintlayout.compose.LateMotionLayout (LateMotionLayout.kt:55)");
            }
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Density density = (Density) objConsume;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -999655640, "CC(remember):LateMotionLayout.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new MotionMeasurer(density);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MotionMeasurer motionMeasurer = (MotionMeasurer) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -999653503, "CC(remember):LateMotionLayout.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Animatable animatable = (Animatable) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -999651731, "CC(remember):LateMotionLayout.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = animatable.asState();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            androidx.compose.runtime.State state3 = (androidx.compose.runtime.State) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -999649755, "CC(remember):LateMotionLayout.kt#9igjgp");
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = SnapshotIntStateKt.mutableIntStateOf(1);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            MutableIntState mutableIntState = (MutableIntState) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -999642334, "CC(remember):LateMotionLayout.kt#9igjgp");
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = (Function0) new Function0<ConstraintSet>() { // from class: androidx.constraintlayout.compose.LateMotionLayoutKt$LateMotionLayout$measurePolicy$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final ConstraintSet invoke() {
                        ConstraintSet value = mutableState.getValue();
                        Intrinsics.checkNotNull(value);
                        return value;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            Function0 function1 = (Function0) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -999640480, "CC(remember):LateMotionLayout.kt#9igjgp");
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = (Function0) new Function0<ConstraintSet>() { // from class: androidx.constraintlayout.compose.LateMotionLayoutKt$LateMotionLayout$measurePolicy$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final ConstraintSet invoke() {
                        ConstraintSet value = mutableState2.getValue();
                        Intrinsics.checkNotNull(value);
                        return value;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i5 = i3;
            MeasurePolicy measurePolicyLateMotionLayoutMeasurePolicy = lateMotionLayoutMeasurePolicy(function1, (Function0) objRememberedValue6, state2, ref, state3, motionMeasurer, i4);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -999629083, "CC(remember):LateMotionLayout.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(motionMeasurer);
            Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue7 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.constraintlayout.compose.LateMotionLayoutKt$LateMotionLayout$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        ToolingUtilsKt.setDesignInfoProvider(semanticsPropertyReceiver, motionMeasurer);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composer2 = composerStartRestartGroup;
            LayoutKt.MultiMeasureLayout(SemanticsModifierKt.semantics$default(modifier, false, (Function1) objRememberedValue7, 1, null), function2, measurePolicyLateMotionLayoutMeasurePolicy, composer2, (i5 >> 24) & 112, 0);
            ComposerKt.sourceInformationMarkerStart(composer2, -999623855, "CC(remember):LateMotionLayout.kt#9igjgp");
            boolean zChangedInstance2 = composer2.changedInstance(channel) | ((i5 & 14) == 4) | ((i5 & 112) == 32) | ((i5 & 458752) == 131072 || ((i5 & 262144) != 0 && composer2.changedInstance(ref))) | composer2.changedInstance(animatable) | composer2.changedInstance(animationSpec) | ((i5 & 29360128) == 8388608);
            LateMotionLayoutKt$LateMotionLayout$2$1 lateMotionLayoutKt$LateMotionLayout$2$1RememberedValue = composer2.rememberedValue();
            if (zChangedInstance2 || lateMotionLayoutKt$LateMotionLayout$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                channel2 = channel;
                lateMotionLayoutKt$LateMotionLayout$2$1RememberedValue = new LateMotionLayoutKt$LateMotionLayout$2$1(channel, mutableIntState, mutableState, mutableState2, ref, animatable, animationSpec, function0, null);
                composer2.updateRememberedValue(lateMotionLayoutKt$LateMotionLayout$2$1RememberedValue);
            } else {
                channel2 = channel;
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            EffectsKt.LaunchedEffect(channel2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) lateMotionLayoutKt$LateMotionLayout$2$1RememberedValue, composer2, (i5 >> 9) & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            channel2 = channel;
            composer2 = composerStartRestartGroup;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.LateMotionLayoutKt.LateMotionLayout.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i6) {
                    LateMotionLayoutKt.LateMotionLayout(mutableState, mutableState2, animationSpec, channel2, state, ref, i, function0, modifier, function2, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
                }
            });
        }
    }

    private static final MeasurePolicy lateMotionLayoutMeasurePolicy(final Function0<? extends ConstraintSet> function0, final Function0<? extends ConstraintSet> function1, final androidx.compose.runtime.State<Unit> state, final Ref<CompositionSource> ref, final androidx.compose.runtime.State<Float> state2, final MotionMeasurer motionMeasurer, final int i) {
        return new MeasurePolicy() { // from class: androidx.constraintlayout.compose.LateMotionLayoutKt.lateMotionLayoutMeasurePolicy.1
            @Override // androidx.compose.ui.layout.MeasurePolicy
            /* JADX INFO: renamed from: measure-3p2s80s */
            public final MeasureResult mo344measure3p2s80s(MeasureScope measureScope, final List<? extends Measurable> list, long j) {
                state.getValue();
                MotionMeasurer motionMeasurer2 = motionMeasurer;
                LayoutDirection layoutDirection = measureScope.getLayoutDirection();
                ConstraintSet constraintSetInvoke = function0.invoke();
                ConstraintSet constraintSetInvoke2 = function1.invoke();
                TransitionImpl eMPTY$constraintlayout_compose_release = TransitionImpl.INSTANCE.getEMPTY$constraintlayout_compose_release();
                int i2 = i;
                float fFloatValue = state2.getValue().floatValue();
                CompositionSource value = ref.getValue();
                if (value == null) {
                    value = CompositionSource.Unknown;
                }
                long jM10128performInterpolationMeasurelUsXzhU = motionMeasurer2.m10128performInterpolationMeasurelUsXzhU(j, layoutDirection, constraintSetInvoke, constraintSetInvoke2, eMPTY$constraintlayout_compose_release, list, i2, fFloatValue, value, null);
                ref.setValue(CompositionSource.Unknown);
                int iM9858getWidthimpl = IntSize.m9858getWidthimpl(jM10128performInterpolationMeasurelUsXzhU);
                int iM9857getHeightimpl = IntSize.m9857getHeightimpl(jM10128performInterpolationMeasurelUsXzhU);
                final MotionMeasurer motionMeasurer3 = motionMeasurer;
                return MeasureScope.layout$default(measureScope, iM9858getWidthimpl, iM9857getHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.constraintlayout.compose.LateMotionLayoutKt.lateMotionLayoutMeasurePolicy.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                        invoke2(placementScope);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Placeable.PlacementScope placementScope) {
                        motionMeasurer3.performLayout(placementScope, list);
                    }
                }, 4, null);
            }
        };
    }
}
