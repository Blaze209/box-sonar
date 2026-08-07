package androidx.compose.material;

import androidx.compose.animation.ColorVectorConverterKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.FloatCompanionObject;

/* JADX INFO: compiled from: TextFieldImpl.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\b\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J¯\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\f¢\u0006\u0002\b\r2\u0006\u0010\u000e\u001a\u00020\u000f2e\u0010\u0010\u001aa\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00050\u0011¢\u0006\u0002\b\rH\u0007¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b²\u0006\n\u0010\u0015\u001a\u00020\u0012X\u008a\u0084\u0002²\u0006\n\u0010\u0018\u001a\u00020\u0012X\u008a\u0084\u0002²\u0006\n\u0010\u0016\u001a\u00020\tX\u008a\u0084\u0002²\u0006\n\u0010\u0017\u001a\u00020\tX\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/material/TextFieldTransitionScope;", "", "<init>", "()V", "Transition", "", "inputState", "Landroidx/compose/material/InputPhase;", "focusedTextStyleColor", "Landroidx/compose/ui/graphics/Color;", "unfocusedTextStyleColor", "contentColor", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "showLabel", "", "content", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "labelProgress", "labelTextStyleColor", "labelContentColor", "placeholderOpacity", "Transition-DTcfvLk", "(Landroidx/compose/material/InputPhase;JJLkotlin/jvm/functions/Function3;ZLkotlin/jvm/functions/Function6;Landroidx/compose/runtime/Composer;I)V", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class TextFieldTransitionScope {
    public static final TextFieldTransitionScope INSTANCE = new TextFieldTransitionScope();

    /* JADX INFO: compiled from: TextFieldImpl.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[InputPhase.values().length];
            try {
                iArr[InputPhase.Focused.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[InputPhase.UnfocusedEmpty.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[InputPhase.UnfocusedNotEmpty.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Transition_DTcfvLk$lambda$11(TextFieldTransitionScope textFieldTransitionScope, InputPhase inputPhase, long j, long j2, Function3 function3, boolean z, Function6 function6, int i, Composer composer, int i2) {
        textFieldTransitionScope.m2656TransitionDTcfvLk(inputPhase, j, j2, function3, z, function6, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    private TextFieldTransitionScope() {
    }

    /* JADX WARN: Code duplicated, block: B:104:0x01f0  */
    /* JADX INFO: renamed from: Transition-DTcfvLk, reason: not valid java name */
    public final void m2656TransitionDTcfvLk(final InputPhase inputPhase, final long j, final long j2, final Function3<? super InputPhase, ? super Composer, ? super Integer, Color> function3, final boolean z, final Function6<? super Float, ? super Color, ? super Color, ? super Float, ? super Composer, ? super Integer, Unit> function6, Composer composer, final int i) {
        int i2;
        Function6<? super Float, ? super Color, ? super Color, ? super Float, ? super Composer, ? super Integer, Unit> function7;
        Composer composer2;
        float f;
        int i3;
        float f2;
        float f3;
        Composer composerStartRestartGroup = composer.startRestartGroup(509439888);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Transition)N(inputState,focusedTextStyleColor:c#ui.graphics.Color,unfocusedTextStyleColor:c#ui.graphics.Color,contentColor,showLabel,content)287@11617L59,290@11730L362,302@12151L1237,332@13448L332,343@13838L203,349@14051L82:TextFieldImpl.kt#jmzs0o");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(inputPhase.ordinal()) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(j2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            function7 = function6;
            i2 |= composerStartRestartGroup.changedInstance(function7) ? 131072 : 65536;
        } else {
            function7 = function6;
        }
        if (!composerStartRestartGroup.shouldExecute((74899 & i2) != 74898, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(509439888, i2, -1, "androidx.compose.material.TextFieldTransitionScope.Transition (TextFieldImpl.kt:283)");
            }
            Transition transitionUpdateTransition = TransitionKt.updateTransition(inputPhase, "TextFieldInputState", composerStartRestartGroup, (i2 & 14) | 48, 0);
            Function3 function4 = new Function3() { // from class: androidx.compose.material.TextFieldTransitionScope$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return TextFieldTransitionScope.Transition_DTcfvLk$lambda$0((Transition.Segment) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1338768149, "CC(animateFloat)P(2)1924@81822L78:Transition.kt#pdpnli");
            TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
            InputPhase inputPhase2 = (InputPhase) transitionUpdateTransition.getCurrentState();
            composerStartRestartGroup.startReplaceGroup(389927550);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):TextFieldImpl.kt#jmzs0o");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(389927550, 0, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:294)");
            }
            int i4 = WhenMappings.$EnumSwitchMapping$0[inputPhase2.ordinal()];
            float f4 = 1.0f;
            if (i4 == 1) {
                f = 1.0f;
            } else if (i4 != 2) {
                if (i4 != 3) {
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
            InputPhase inputPhase3 = (InputPhase) transitionUpdateTransition.getTargetState();
            composerStartRestartGroup.startReplaceGroup(389927550);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):TextFieldImpl.kt#jmzs0o");
            if (ComposerKt.isTraceInProgress()) {
                i3 = -1;
                ComposerKt.traceEventStart(389927550, 0, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:294)");
            } else {
                i3 = -1;
            }
            int i5 = WhenMappings.$EnumSwitchMapping$0[inputPhase3.ordinal()];
            if (i5 == 1) {
                f2 = 1.0f;
            } else if (i5 != 2) {
                if (i5 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                f2 = 1.0f;
            } else {
                f2 = 0.0f;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceGroup();
            int i6 = i3;
            State stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf, Float.valueOf(f2), (FiniteAnimationSpec) function4.invoke(transitionUpdateTransition.getSegment(), composerStartRestartGroup, 0), vectorConverter, "LabelProgress", composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Function3 function5 = new Function3() { // from class: androidx.compose.material.TextFieldTransitionScope$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return TextFieldTransitionScope.Transition_DTcfvLk$lambda$3((Transition.Segment) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1338768149, "CC(animateFloat)P(2)1924@81822L78:Transition.kt#pdpnli");
            TwoWayConverter<Float, AnimationVector1D> vectorConverter2 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
            InputPhase inputPhase4 = (InputPhase) transitionUpdateTransition.getCurrentState();
            composerStartRestartGroup.startReplaceGroup(1246942589);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):TextFieldImpl.kt#jmzs0o");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1246942589, 0, i6, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:324)");
            }
            int i7 = WhenMappings.$EnumSwitchMapping$0[inputPhase4.ordinal()];
            if (i7 == 1) {
                f3 = 1.0f;
            } else {
                if (i7 != 2) {
                    if (i7 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                } else if (!z) {
                    f3 = 1.0f;
                }
                f3 = 0.0f;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceGroup();
            Float fValueOf2 = Float.valueOf(f3);
            InputPhase inputPhase5 = (InputPhase) transitionUpdateTransition.getTargetState();
            composerStartRestartGroup.startReplaceGroup(1246942589);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):TextFieldImpl.kt#jmzs0o");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1246942589, 0, i6, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:324)");
            }
            int i8 = WhenMappings.$EnumSwitchMapping$0[inputPhase5.ordinal()];
            if (i8 != 1) {
                if (i8 != 2) {
                    if (i8 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                } else if (z) {
                }
                f4 = 0.0f;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceGroup();
            State stateCreateTransitionAnimation2 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf2, Float.valueOf(f4), (FiniteAnimationSpec) function5.invoke(transitionUpdateTransition.getSegment(), composerStartRestartGroup, 0), vectorConverter2, "PlaceholderOpacity", composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Function3 function8 = new Function3() { // from class: androidx.compose.material.TextFieldTransitionScope$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return TextFieldTransitionScope.Transition_DTcfvLk$lambda$6((Transition.Segment) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1939694975, "CC(animateColor)P(2)67@3229L31,68@3296L58,70@3367L70:Transition.kt#xbi5r1");
            InputPhase inputPhase6 = (InputPhase) transitionUpdateTransition.getTargetState();
            composerStartRestartGroup.startReplaceGroup(-2001931362);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):TextFieldImpl.kt#jmzs0o");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2001931362, 0, i6, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:336)");
            }
            long j3 = WhenMappings.$EnumSwitchMapping$0[inputPhase6.ordinal()] == 1 ? j : j2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceGroup();
            ColorSpace colorSpaceM6818getColorSpaceimpl = Color.m6818getColorSpaceimpl(j3);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1918408359, "CC(remember):Transition.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(colorSpaceM6818getColorSpaceimpl);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(colorSpaceM6818getColorSpaceimpl);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            TwoWayConverter twoWayConverter = (TwoWayConverter) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
            InputPhase inputPhase7 = (InputPhase) transitionUpdateTransition.getCurrentState();
            composerStartRestartGroup.startReplaceGroup(-2001931362);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):TextFieldImpl.kt#jmzs0o");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2001931362, 0, i6, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:336)");
            }
            long j4 = WhenMappings.$EnumSwitchMapping$0[inputPhase7.ordinal()] == 1 ? j : j2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceGroup();
            Color colorM6804boximpl = Color.m6804boximpl(j4);
            InputPhase inputPhase8 = (InputPhase) transitionUpdateTransition.getTargetState();
            composerStartRestartGroup.startReplaceGroup(-2001931362);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):TextFieldImpl.kt#jmzs0o");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2001931362, 0, i6, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:336)");
            }
            long j5 = WhenMappings.$EnumSwitchMapping$0[inputPhase8.ordinal()] == 1 ? j : j2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceGroup();
            State stateCreateTransitionAnimation3 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, colorM6804boximpl, Color.m6804boximpl(j5), (FiniteAnimationSpec) function8.invoke(transitionUpdateTransition.getSegment(), composerStartRestartGroup, 0), twoWayConverter, "LabelTextStyleColor", composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Function3 function9 = new Function3() { // from class: androidx.compose.material.TextFieldTransitionScope$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return TextFieldTransitionScope.Transition_DTcfvLk$lambda$9((Transition.Segment) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            int i9 = (i2 & 7168) | 384;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1939694975, "CC(animateColor)P(2)67@3229L31,68@3296L58,70@3367L70:Transition.kt#xbi5r1");
            ColorSpace colorSpaceM6818getColorSpaceimpl2 = Color.m6818getColorSpaceimpl(function3.invoke(transitionUpdateTransition.getTargetState(), composerStartRestartGroup, Integer.valueOf((i9 >> 6) & 112)).m6824unboximpl());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1918408359, "CC(remember):Transition.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(colorSpaceM6818getColorSpaceimpl2);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(colorSpaceM6818getColorSpaceimpl2);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
            int i10 = ((((i9 << 3) & 57344) | 3072) >> 9) & 112;
            State stateCreateTransitionAnimation4 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, function3.invoke(transitionUpdateTransition.getCurrentState(), composerStartRestartGroup, Integer.valueOf(i10)), function3.invoke(transitionUpdateTransition.getTargetState(), composerStartRestartGroup, Integer.valueOf(i10)), (FiniteAnimationSpec) function9.invoke(transitionUpdateTransition.getSegment(), composerStartRestartGroup, 0), (TwoWayConverter) objRememberedValue2, "LabelContentColor", composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            function7.invoke(Float.valueOf(Transition_DTcfvLk$lambda$2(stateCreateTransitionAnimation)), Color.m6804boximpl(Transition_DTcfvLk$lambda$8(stateCreateTransitionAnimation3)), Color.m6804boximpl(Transition_DTcfvLk$lambda$10(stateCreateTransitionAnimation4)), Float.valueOf(Transition_DTcfvLk$lambda$5(stateCreateTransitionAnimation2)), composerStartRestartGroup, Integer.valueOf(57344 & (i2 >> 3)));
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TextFieldTransitionScope$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TextFieldTransitionScope.Transition_DTcfvLk$lambda$11(this.f$0, inputPhase, j, j2, function3, z, function6, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FiniteAnimationSpec Transition_DTcfvLk$lambda$0(Transition.Segment segment, Composer composer, int i) {
        composer.startReplaceGroup(-883519390);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-883519390, i, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:292)");
        }
        TweenSpec tweenSpecTween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return tweenSpecTween$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FiniteAnimationSpec Transition_DTcfvLk$lambda$3(Transition.Segment segment, Composer composer, int i) {
        TweenSpec tweenSpecTween;
        composer.startReplaceGroup(1849239065);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1849239065, i, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:305)");
        }
        if (segment.isTransitioningTo(InputPhase.Focused, InputPhase.UnfocusedEmpty)) {
            tweenSpecTween = AnimationSpecKt.tween$default(67, 0, EasingKt.getLinearEasing(), 2, null);
        } else if (segment.isTransitioningTo(InputPhase.UnfocusedEmpty, InputPhase.Focused) || segment.isTransitioningTo(InputPhase.UnfocusedNotEmpty, InputPhase.UnfocusedEmpty)) {
            tweenSpecTween = AnimationSpecKt.tween(83, 67, EasingKt.getLinearEasing());
        } else {
            tweenSpecTween = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return tweenSpecTween;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FiniteAnimationSpec Transition_DTcfvLk$lambda$6(Transition.Segment segment, Composer composer, int i) {
        composer.startReplaceGroup(-2017811095);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2017811095, i, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:333)");
        }
        TweenSpec tweenSpecTween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return tweenSpecTween$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FiniteAnimationSpec Transition_DTcfvLk$lambda$9(Transition.Segment segment, Composer composer, int i) {
        composer.startReplaceGroup(-1176639650);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1176639650, i, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:344)");
        }
        TweenSpec tweenSpecTween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return tweenSpecTween$default;
    }

    private static final float Transition_DTcfvLk$lambda$2(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float Transition_DTcfvLk$lambda$5(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final long Transition_DTcfvLk$lambda$8(State<Color> state) {
        return state.getValue().m6824unboximpl();
    }

    private static final long Transition_DTcfvLk$lambda$10(State<Color> state) {
        return state.getValue().m6824unboximpl();
    }
}
