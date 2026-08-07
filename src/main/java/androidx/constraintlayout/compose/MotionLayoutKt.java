package androidx.constraintlayout.compose;

import android.view.View;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableLongState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotLongStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.ScaleKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.motion.widget.Key;
import androidx.media3.common.C;
import androidx.profileinstaller.ProfileVerifier;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: compiled from: MotionLayout.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000¦\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u007f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u001e\b\u0004\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u0015H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001au\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u001e\b\u0004\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u0015H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u008d\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060 2\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0010\b\n\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\"2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u001e\b\u0004\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u0015H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0016\u0010#\u001a£\u0001\u0010$\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020(2\u0006\u0010\u0007\u001a\u00020\b2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00010,2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.2\u0006\u0010\u000f\u001a\u00020\u00102\u001c\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u0015H\u0001¢\u0006\u0002\u00100\u001a\u0084\u0001\u0010$\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00010,2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.2\u0006\u0010\u000f\u001a\u00020\u00102\u001c\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u0015H\u0001ø\u0001\u0000¢\u0006\u0004\b1\u00102\u001a¤\u0001\u0010$\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060 2\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\"2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00010,2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.2\u0006\u0010\u000f\u001a\u00020\u00102\u001c\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u0015H\u0001ø\u0001\u0000¢\u0006\u0004\b3\u00104\u001a\u001f\u00105\u001a\u00020\u00012\u0006\u00106\u001a\u0002072\b\u0010%\u001a\u0004\u0018\u00010&H\u0001¢\u0006\u0002\u00108\u001a\u0015\u00109\u001a\u0002072\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¢\u0006\u0002\u0010:\u001a\\\u0010;\u001a\u00020<2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00010=2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.2\u0006\u0010>\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020@2\u0006\u00106\u001a\u0002072\u0006\u0010A\u001a\u00020B2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0001\u001a4\u0010C\u001a\u00020\b*\u00020\b2\u0006\u0010A\u001a\u00020B2\u0006\u0010D\u001a\u00020\u00062\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020(H\u0001\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006E²\u0006\n\u0010\u0002\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u0010\u0004\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u0010F\u001a\u00020(X\u008a\u008e\u0002"}, d2 = {"MotionLayout", "", "start", "Landroidx/constraintlayout/compose/ConstraintSet;", "end", "progress", "", "modifier", "Landroidx/compose/ui/Modifier;", "transition", "Landroidx/constraintlayout/compose/Transition;", "debugFlags", "Landroidx/constraintlayout/compose/DebugFlags;", "optimizationLevel", "", "invalidationStrategy", "Landroidx/constraintlayout/compose/InvalidationStrategy;", "content", "Lkotlin/Function1;", "Landroidx/constraintlayout/compose/MotionLayoutScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "MotionLayout-T3LJ6Qw", "(Landroidx/constraintlayout/compose/ConstraintSet;Landroidx/constraintlayout/compose/ConstraintSet;FLandroidx/compose/ui/Modifier;Landroidx/constraintlayout/compose/Transition;IILandroidx/constraintlayout/compose/InvalidationStrategy;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "motionScene", "Landroidx/constraintlayout/compose/MotionScene;", "transitionName", "", "MotionLayout-6oYECBM", "(Landroidx/constraintlayout/compose/MotionScene;FLandroidx/compose/ui/Modifier;Ljava/lang/String;IILandroidx/constraintlayout/compose/InvalidationStrategy;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "constraintSetName", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "finishedAnimationListener", "Lkotlin/Function0;", "(Landroidx/constraintlayout/compose/MotionScene;Ljava/lang/String;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;IILandroidx/constraintlayout/compose/InvalidationStrategy;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "MotionLayoutCore", "informationReceiver", "Landroidx/constraintlayout/compose/LayoutInformationReceiver;", "showBounds", "", "showPaths", "showKeyPositions", "contentTracker", "Landroidx/compose/runtime/MutableState;", "compositionSource", "Landroidx/compose/ui/node/Ref;", "Landroidx/constraintlayout/compose/CompositionSource;", "(Landroidx/constraintlayout/compose/ConstraintSet;Landroidx/constraintlayout/compose/ConstraintSet;Landroidx/constraintlayout/compose/Transition;FLandroidx/constraintlayout/compose/LayoutInformationReceiver;IZZZLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/node/Ref;Landroidx/constraintlayout/compose/InvalidationStrategy;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "MotionLayoutCore-SehEMGo", "(Landroidx/constraintlayout/compose/MotionScene;FLjava/lang/String;IILandroidx/compose/ui/Modifier;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/node/Ref;Landroidx/constraintlayout/compose/InvalidationStrategy;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "MotionLayoutCore-TEds9UA", "(Landroidx/constraintlayout/compose/MotionScene;Ljava/lang/String;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;IILandroidx/compose/runtime/MutableState;Landroidx/compose/ui/node/Ref;Landroidx/constraintlayout/compose/InvalidationStrategy;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "UpdateWithForcedIfNoUserChange", Key.MOTIONPROGRESS, "Landroidx/compose/runtime/MutableFloatState;", "(Landroidx/compose/runtime/MutableFloatState;Landroidx/constraintlayout/compose/LayoutInformationReceiver;Landroidx/compose/runtime/Composer;I)V", "createAndUpdateMotionProgress", "(FLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/MutableFloatState;", "motionLayoutMeasurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "Landroidx/compose/runtime/State;", "constraintSetStart", "constraintSetEnd", "Landroidx/constraintlayout/compose/TransitionImpl;", "measurer", "Landroidx/constraintlayout/compose/MotionMeasurer;", "motionDebug", "scaleFactor", "constraintlayout-compose_release", "animateToEnd"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class MotionLayoutKt {
    /* JADX INFO: renamed from: MotionLayout-T3LJ6Qw, reason: not valid java name */
    public static final void m10102MotionLayoutT3LJ6Qw(ConstraintSet constraintSet, ConstraintSet constraintSet2, float f, Modifier modifier, Transition transition, int i, int i2, InvalidationStrategy invalidationStrategy, final Function3<? super MotionLayoutScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i3, int i4) {
        ComposerKt.sourceInformationMarkerStart(composer, -531105279, "CC(MotionLayout)P(7,2,6,4,8,1:androidx.constraintlayout.compose.DebugFlags,5,3)143@6062L53,144@6144L93,149@6399L627,164@7031L556:MotionLayout.kt#fysre8");
        Modifier modifier2 = (i4 & 8) != 0 ? Modifier.INSTANCE : modifier;
        Transition transition2 = (i4 & 16) != 0 ? null : transition;
        int iM10045getNonebfy_xzQ = (i4 & 32) != 0 ? DebugFlags.INSTANCE.m10045getNonebfy_xzQ() : i;
        int i5 = (i4 & 64) != 0 ? 257 : i2;
        final InvalidationStrategy defaultInvalidationStrategy = (i4 & 128) != 0 ? InvalidationStrategy.INSTANCE.getDefaultInvalidationStrategy() : invalidationStrategy;
        ComposerKt.sourceInformationMarkerStart(composer, 1692700147, "CC(remember):MotionLayout.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
            composer.updateRememberedValue(objRememberedValue);
        }
        final MutableState mutableState = (MutableState) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 1692702811, "CC(remember):MotionLayout.kt#9igjgp");
        Object objRememberedValue2 = composer.rememberedValue();
        Object obj = objRememberedValue2;
        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            Ref ref = new Ref();
            ref.setValue(CompositionSource.Unknown);
            composer.updateRememberedValue(ref);
            obj = ref;
        }
        final Ref ref2 = (Ref) obj;
        ComposerKt.sourceInformationMarkerEnd(composer);
        MotionLayoutCore(constraintSet, constraintSet2, transition2, f, null, i5, DebugFlags.m10038getShowBoundsimpl(iM10045getNonebfy_xzQ), DebugFlags.m10040getShowPathsimpl(iM10045getNonebfy_xzQ), DebugFlags.m10039getShowKeyPositionsimpl(iM10045getNonebfy_xzQ), modifier2, mutableState, ref2, defaultInvalidationStrategy, ComposableLambdaKt.rememberComposableLambda(284503157, true, new Function3<MotionLayoutScope, Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt$MotionLayout$contentDelegate$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(MotionLayoutScope motionLayoutScope, Composer composer2, Integer num) {
                invoke(motionLayoutScope, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(MotionLayoutScope motionLayoutScope, Composer composer2, int i6) {
                ComposerKt.sourceInformation(composer2, "C162@7011L9:MotionLayout.kt#fysre8");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(284503157, i6, -1, "androidx.constraintlayout.compose.MotionLayout.<anonymous> (MotionLayout.kt:152)");
                }
                mutableState.setValue(Unit.INSTANCE);
                if (defaultInvalidationStrategy.getOnObservedStateChange() == null && ref2.getValue() == CompositionSource.Unknown) {
                    ref2.setValue(CompositionSource.Content);
                }
                function3.invoke(motionLayoutScope, composer2, Integer.valueOf(i6 & 14));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, composer, 54), composer, (i3 & 14) | 24576 | (i3 & 112) | ((i3 >> 6) & 896) | ((i3 << 3) & 7168) | ((i3 >> 3) & 458752) | ((i3 << 18) & C.ENCODING_PCM_DOUBLE), (Ref.$stable << 3) | 3078 | ((i3 >> 15) & 896));
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    /* JADX INFO: renamed from: MotionLayout-6oYECBM, reason: not valid java name */
    public static final void m10101MotionLayout6oYECBM(MotionScene motionScene, float f, Modifier modifier, String str, int i, int i2, InvalidationStrategy invalidationStrategy, final Function3<? super MotionLayoutScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i3, int i4) {
        ComposerKt.sourceInformationMarkerStart(composer, -808697931, "CC(MotionLayout)P(4,6,3,7,1:androidx.constraintlayout.compose.DebugFlags,5,2)253@10965L53,254@11047L93,259@11302L627,275@11935L412:MotionLayout.kt#fysre8");
        if ((i4 & 4) != 0) {
            modifier = Modifier.INSTANCE;
        }
        Modifier modifier2 = modifier;
        if ((i4 & 8) != 0) {
            str = "default";
        }
        String str2 = str;
        int iM10045getNonebfy_xzQ = (i4 & 16) != 0 ? DebugFlags.INSTANCE.m10045getNonebfy_xzQ() : i;
        int i5 = (i4 & 32) != 0 ? 257 : i2;
        final InvalidationStrategy defaultInvalidationStrategy = (i4 & 64) != 0 ? InvalidationStrategy.INSTANCE.getDefaultInvalidationStrategy() : invalidationStrategy;
        ComposerKt.sourceInformationMarkerStart(composer, 1692857043, "CC(remember):MotionLayout.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
            composer.updateRememberedValue(objRememberedValue);
        }
        final MutableState mutableState = (MutableState) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 1692859707, "CC(remember):MotionLayout.kt#9igjgp");
        Object objRememberedValue2 = composer.rememberedValue();
        Object obj = objRememberedValue2;
        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            Ref ref = new Ref();
            ref.setValue(CompositionSource.Unknown);
            composer.updateRememberedValue(ref);
            obj = ref;
        }
        final Ref ref2 = (Ref) obj;
        ComposerKt.sourceInformationMarkerEnd(composer);
        m10104MotionLayoutCoreSehEMGo(motionScene, f, str2, i5, iM10045getNonebfy_xzQ, modifier2, mutableState, ref2, defaultInvalidationStrategy, ComposableLambdaKt.rememberComposableLambda(-23317463, true, new Function3<MotionLayoutScope, Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt$MotionLayout$contentDelegate$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(MotionLayoutScope motionLayoutScope, Composer composer2, Integer num) {
                invoke(motionLayoutScope, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(MotionLayoutScope motionLayoutScope, Composer composer2, int i6) {
                ComposerKt.sourceInformation(composer2, "C272@11914L9:MotionLayout.kt#fysre8");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-23317463, i6, -1, "androidx.constraintlayout.compose.MotionLayout.<anonymous> (MotionLayout.kt:262)");
                }
                mutableState.setValue(Unit.INSTANCE);
                if (defaultInvalidationStrategy.getOnObservedStateChange() == null && ref2.getValue() == CompositionSource.Unknown) {
                    ref2.setValue(CompositionSource.Content);
                }
                function3.invoke(motionLayoutScope, composer2, Integer.valueOf(i6 & 14));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, composer, 54), composer, (i3 & 14) | 806879232 | (i3 & 112) | ((i3 >> 3) & 896) | ((i3 >> 6) & 7168) | (i3 & 57344) | ((i3 << 9) & 458752) | (Ref.$stable << 21) | (234881024 & (i3 << 6)));
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    /* JADX INFO: renamed from: MotionLayout-T3LJ6Qw, reason: not valid java name */
    public static final void m10103MotionLayoutT3LJ6Qw(MotionScene motionScene, String str, AnimationSpec<Float> animationSpec, Modifier modifier, Function0<Unit> function0, int i, int i2, InvalidationStrategy invalidationStrategy, final Function3<? super MotionLayoutScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i3, int i4) {
        ComposerKt.sourceInformationMarkerStart(composer, -267984822, "CC(MotionLayout)P(7,1!1,6,4,3:androidx.constraintlayout.compose.DebugFlags,8,5)379@16664L53,380@16746L93,385@17001L627,401@17634L491:MotionLayout.kt#fysre8");
        Modifier modifier2 = (i4 & 8) != 0 ? Modifier.INSTANCE : modifier;
        Function0<Unit> function1 = (i4 & 16) != 0 ? null : function0;
        int iM10045getNonebfy_xzQ = (i4 & 32) != 0 ? DebugFlags.INSTANCE.m10045getNonebfy_xzQ() : i;
        int i5 = (i4 & 64) != 0 ? 257 : i2;
        final InvalidationStrategy defaultInvalidationStrategy = (i4 & 128) != 0 ? InvalidationStrategy.INSTANCE.getDefaultInvalidationStrategy() : invalidationStrategy;
        ComposerKt.sourceInformationMarkerStart(composer, 1693039411, "CC(remember):MotionLayout.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
            composer.updateRememberedValue(objRememberedValue);
        }
        final MutableState mutableState = (MutableState) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 1693042075, "CC(remember):MotionLayout.kt#9igjgp");
        Object objRememberedValue2 = composer.rememberedValue();
        Object obj = objRememberedValue2;
        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            Ref ref = new Ref();
            ref.setValue(CompositionSource.Unknown);
            composer.updateRememberedValue(ref);
            obj = ref;
        }
        final Ref ref2 = (Ref) obj;
        ComposerKt.sourceInformationMarkerEnd(composer);
        m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier2, function1, iM10045getNonebfy_xzQ, i5, mutableState, ref2, defaultInvalidationStrategy, ComposableLambdaKt.rememberComposableLambda(1064705982, true, new Function3<MotionLayoutScope, Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt$MotionLayout$contentDelegate$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(MotionLayoutScope motionLayoutScope, Composer composer2, Integer num) {
                invoke(motionLayoutScope, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(MotionLayoutScope motionLayoutScope, Composer composer2, int i6) {
                ComposerKt.sourceInformation(composer2, "C398@17613L9:MotionLayout.kt#fysre8");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1064705982, i6, -1, "androidx.constraintlayout.compose.MotionLayout.<anonymous> (MotionLayout.kt:388)");
                }
                mutableState.setValue(Unit.INSTANCE);
                if (defaultInvalidationStrategy.getOnObservedStateChange() == null && ref2.getValue() == CompositionSource.Unknown) {
                    ref2.setValue(CompositionSource.Content);
                }
                function3.invoke(motionLayoutScope, composer2, Integer.valueOf(i6 & 14));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, composer, 54), composer, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | (Ref.$stable << 24) | ((i3 << 6) & C.ENCODING_PCM_DOUBLE), 6, 0);
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x011a  */
    /* JADX WARN: Code duplicated, block: B:102:0x011e  */
    /* JADX WARN: Code duplicated, block: B:104:0x0123  */
    /* JADX WARN: Code duplicated, block: B:106:0x012b  */
    /* JADX WARN: Code duplicated, block: B:107:0x012e  */
    /* JADX WARN: Code duplicated, block: B:112:0x0139  */
    /* JADX WARN: Code duplicated, block: B:113:0x0141  */
    /* JADX WARN: Code duplicated, block: B:115:0x0145  */
    /* JADX WARN: Code duplicated, block: B:117:0x014d  */
    /* JADX WARN: Code duplicated, block: B:118:0x0150  */
    /* JADX WARN: Code duplicated, block: B:120:0x015b  */
    /* JADX WARN: Code duplicated, block: B:123:0x016b  */
    /* JADX WARN: Code duplicated, block: B:129:0x0181 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:130:0x0183  */
    /* JADX WARN: Code duplicated, block: B:131:0x0188  */
    /* JADX WARN: Code duplicated, block: B:133:0x018b  */
    /* JADX WARN: Code duplicated, block: B:135:0x018e  */
    /* JADX WARN: Code duplicated, block: B:136:0x0197  */
    /* JADX WARN: Code duplicated, block: B:138:0x019b  */
    /* JADX WARN: Code duplicated, block: B:141:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:144:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:147:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:148:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:151:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:153:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:156:0x0217  */
    /* JADX WARN: Code duplicated, block: B:157:0x021a  */
    /* JADX WARN: Code duplicated, block: B:160:0x0226  */
    /* JADX WARN: Code duplicated, block: B:162:0x022e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:163:0x0230  */
    /* JADX WARN: Code duplicated, block: B:165:0x0236  */
    /* JADX WARN: Code duplicated, block: B:169:0x0253  */
    /* JADX WARN: Code duplicated, block: B:170:0x0256  */
    /* JADX WARN: Code duplicated, block: B:173:0x0262  */
    /* JADX WARN: Code duplicated, block: B:175:0x026a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:176:0x026c  */
    /* JADX WARN: Code duplicated, block: B:178:0x0272  */
    /* JADX WARN: Code duplicated, block: B:182:0x0282 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:265:0x04b1  */
    /* JADX WARN: Code duplicated, block: B:269:0x04da  */
    /* JADX WARN: Code duplicated, block: B:272:0x04e3  */
    /* JADX WARN: Code duplicated, block: B:274:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:275:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x007f  */
    /* JADX WARN: Code duplicated, block: B:47:0x0082  */
    /* JADX WARN: Code duplicated, block: B:49:0x0086  */
    /* JADX WARN: Code duplicated, block: B:51:0x008e  */
    /* JADX WARN: Code duplicated, block: B:52:0x0091  */
    /* JADX WARN: Code duplicated, block: B:57:0x009e  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:62:0x00af  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:67:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:72:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:77:0x00da  */
    /* JADX WARN: Code duplicated, block: B:78:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:83:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:88:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:90:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:92:0x0100  */
    /* JADX WARN: Code duplicated, block: B:94:0x0105  */
    /* JADX WARN: Code duplicated, block: B:95:0x010a  */
    /* JADX WARN: Code duplicated, block: B:97:0x0110  */
    /* JADX WARN: Code duplicated, block: B:98:0x0113  */
    /* JADX INFO: renamed from: MotionLayoutCore-TEds9UA, reason: not valid java name */
    public static final void m10105MotionLayoutCoreTEds9UA(final MotionScene motionScene, final String str, final AnimationSpec<Float> animationSpec, Modifier modifier, Function0<Unit> function0, int i, int i2, final MutableState<Unit> mutableState, final Ref<CompositionSource> ref, final InvalidationStrategy invalidationStrategy, final Function3<? super MotionLayoutScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i3, final int i4, final int i5) {
        int i6;
        Modifier modifier2;
        int i7;
        Function0<Unit> function1;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        final int i13;
        int i14;
        int i15;
        boolean zChangedInstance;
        int i16;
        int i17;
        int i18;
        int i19;
        Modifier.Companion companion;
        int iM10045getNonebfy_xzQ;
        final int i20;
        Object objRememberedValue;
        int i21;
        final Modifier modifier3;
        boolean z;
        boolean zChanged;
        Object objRememberedValue2;
        Transition transition;
        boolean z2;
        boolean zChanged2;
        Object objRememberedValue3;
        String startConstraintSetId;
        ConstraintSet constraintSet;
        boolean z3;
        boolean zChanged3;
        Object objRememberedValue4;
        String endConstraintSetId;
        final Function0<Unit> function2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        LayoutInformationReceiver layoutInformationReceiver;
        Animatable animatable;
        Function0<Unit> function4;
        LayoutInformationReceiver layoutInformationReceiver2;
        Composer composer2;
        final Modifier modifier4;
        final Function0<Unit> function5;
        final int i22;
        Channel channel;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1132252061);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MotionLayoutCore)P(9,2!1,8,6,5:androidx.constraintlayout.compose.DebugFlags,10,4!1,7)432@18758L35,435@18824L113,440@18970L189,445@19189L181,454@19480L54,455@19565L52,458@19657L147,462@19825L27,464@19878L46,466@19944L54,489@20879L591:MotionLayout.kt#fysre8");
        if ((i5 & 1) != 0) {
            i6 = i3 | 6;
        } else if ((i3 & 6) == 0) {
            i6 = (composerStartRestartGroup.changed(motionScene) ? 4 : 2) | i3;
        } else {
            i6 = i3;
        }
        if ((i5 & 2) != 0) {
            i6 |= 48;
        } else if ((i3 & 48) == 0) {
            i6 |= composerStartRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i5 & 4) != 0) {
            i6 |= 384;
        } else if ((i3 & 384) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(animationSpec) ? 256 : 128;
        }
        int i23 = i5 & 8;
        if (i23 == 0) {
            if ((i3 & 3072) == 0) {
                modifier2 = modifier;
                i6 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            i7 = i5 & 16;
            if (i7 != 0) {
                if ((i3 & 24576) == 0) {
                    function1 = function0;
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i8 = 16384;
                    } else {
                        i8 = 8192;
                    }
                    i6 |= i8;
                }
                i9 = i5 & 32;
                if (i9 != 0) {
                    i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    i10 = i;
                } else {
                    i10 = i;
                    if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(i10)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i6 |= i11;
                    }
                }
                i12 = i5 & 64;
                if (i12 != 0) {
                    i6 |= 1572864;
                    i13 = i2;
                } else {
                    i13 = i2;
                    if ((i3 & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(i13)) {
                            i14 = 1048576;
                        } else {
                            i14 = 524288;
                        }
                        i6 |= i14;
                    }
                }
                if ((i5 & 128) != 0) {
                    if ((i3 & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(mutableState)) {
                            i15 = 8388608;
                        } else {
                            i15 = 4194304;
                        }
                        i6 |= i15;
                    }
                    if ((i5 & 256) != 0) {
                        if ((100663296 & i3) == 0) {
                            if ((134217728 & i3) == 0) {
                                zChangedInstance = composerStartRestartGroup.changed(ref);
                            } else {
                                zChangedInstance = composerStartRestartGroup.changedInstance(ref);
                            }
                            if (zChangedInstance) {
                                i16 = 67108864;
                            } else {
                                i16 = 33554432;
                            }
                        }
                        if ((i5 & 512) != 0) {
                            if ((805306368 & i3) == 0) {
                                if (composerStartRestartGroup.changedInstance(invalidationStrategy)) {
                                    i17 = C.BUFFER_FLAG_LAST_SAMPLE;
                                } else {
                                    i17 = 268435456;
                                }
                                i6 |= i17;
                            }
                            if ((i5 & 1024) != 0) {
                                i18 = i4 | 6;
                            } else if ((i4 & 6) == 0) {
                                if (composerStartRestartGroup.changedInstance(function3)) {
                                    i19 = 4;
                                } else {
                                    i19 = 2;
                                }
                                i18 = i4 | i19;
                            } else {
                                i18 = i4;
                            }
                            if ((i6 & 306783379) == 306783378 || (i18 & 3) != 2 || !composerStartRestartGroup.getSkipping()) {
                                if (i23 != 0) {
                                    companion = Modifier.INSTANCE;
                                } else {
                                    companion = modifier2;
                                }
                                if (i7 != 0) {
                                    function1 = null;
                                }
                                if (i9 != 0) {
                                    iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                                } else {
                                    iM10045getNonebfy_xzQ = i10;
                                }
                                if (i12 != 0) {
                                    i13 = 257;
                                }
                                i20 = i13;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
                                }
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                MutableLongState mutableLongState = (MutableLongState) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                long longValue = mutableLongState.getLongValue();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
                                i21 = i6 & 14;
                                modifier3 = companion;
                                if (i21 == 4) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                zChanged = z | composerStartRestartGroup.changed(longValue);
                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (!zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = motionScene.getTransitionInstance("default");
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                }
                                transition = (Transition) objRememberedValue2;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                long longValue2 = mutableLongState.getLongValue();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
                                if (i21 == 4) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                zChanged2 = z2 | composerStartRestartGroup.changed(longValue2);
                                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (!zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    if (transition != null || (startConstraintSetId = transition.getStartConstraintSetId()) == null) {
                                        startConstraintSetId = "start";
                                    }
                                    objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                }
                                constraintSet = (ConstraintSet) objRememberedValue3;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                int i24 = i6;
                                long longValue3 = mutableLongState.getLongValue();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
                                if (i21 == 4) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                zChanged3 = composerStartRestartGroup.changed(longValue3) | z3;
                                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                                if (!zChanged3 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                    if (transition != null || (endConstraintSetId = transition.getEndConstraintSetId()) == null) {
                                        endConstraintSetId = "end";
                                    }
                                    objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                                }
                                ConstraintSet constraintSet2 = (ConstraintSet) objRememberedValue4;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                if (constraintSet != null || constraintSet2 == null) {
                                    function2 = function1;
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                                    if (scopeUpdateScopeEndRestartGroup != null) {
                                        final int i25 = iM10045getNonebfy_xzQ;
                                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                                            public final void invoke(Composer composer3, int i26) {
                                                MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i25, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                                            }
                                        });
                                        return;
                                    }
                                    return;
                                }
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488039373, "CC(remember):MotionLayout.kt#9igjgp");
                                boolean z4 = i21 == 4;
                                Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                                if (z4 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                    MutableState mutableStateMutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(constraintSet, null, 2, null);
                                    composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default);
                                    objRememberedValue5 = mutableStateMutableStateOf$default;
                                }
                                MutableState mutableState2 = (MutableState) objRememberedValue5;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488036655, "CC(remember):MotionLayout.kt#9igjgp");
                                boolean z5 = i21 == 4;
                                Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                                if (z5 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                    MutableState mutableStateMutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(constraintSet2, null, 2, null);
                                    composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default2);
                                    objRememberedValue6 = mutableStateMutableStateOf$default2;
                                }
                                MutableState mutableState3 = (MutableState) objRememberedValue6;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488033616, "CC(remember):MotionLayout.kt#9igjgp");
                                boolean z6 = (i21 == 4) | ((i24 & 112) == 32);
                                Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                                if (z6 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                    ConstraintSet constraintSetInstance = str != null ? motionScene.getConstraintSetInstance(str) : null;
                                    composerStartRestartGroup.updateRememberedValue(constraintSetInstance);
                                    objRememberedValue7 = constraintSetInstance;
                                }
                                final ConstraintSet constraintSet3 = (ConstraintSet) objRememberedValue7;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488028360, "CC(remember):MotionLayout.kt#9igjgp");
                                Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue8 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                                }
                                Animatable animatable2 = (Animatable) objRememberedValue8;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488026645, "CC(remember):MotionLayout.kt#9igjgp");
                                boolean z7 = i21 == 4;
                                Object objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                                if (z7 || objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue9 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                                }
                                MutableState mutableState4 = (MutableState) objRememberedValue9;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488024525, "CC(remember):MotionLayout.kt#9igjgp");
                                Object objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                                    layoutInformationReceiver = null;
                                    objRememberedValue10 = ChannelKt.Channel$default(-1, null, null, 6, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                                } else {
                                    layoutInformationReceiver = null;
                                }
                                final Channel channel2 = (Channel) objRememberedValue10;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                composerStartRestartGroup.startReplaceGroup(-488021789);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "469@20058L40,469@20047L51,471@20145L723,471@20108L760");
                                if (constraintSet3 != null) {
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488020891, "CC(remember):MotionLayout.kt#9igjgp");
                                    boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(channel2) | composerStartRestartGroup.changed(constraintSet3);
                                    Object objRememberedValue11 = composerStartRestartGroup.rememberedValue();
                                    if (zChangedInstance2 || objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue11 = (Function0) new Function0<Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$2$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public /* bridge */ /* synthetic */ Unit invoke() {
                                                invoke2();
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2() {
                                                channel2.mo11206trySendJP2dKIU(constraintSet3);
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue11);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    EffectsKt.SideEffect((Function0) objRememberedValue11, composerStartRestartGroup, 0);
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488017424, "CC(remember):MotionLayout.kt#9igjgp");
                                    boolean zChangedInstance3 = composerStartRestartGroup.changedInstance(channel2) | composerStartRestartGroup.changed(mutableState4) | composerStartRestartGroup.changed(mutableState2) | composerStartRestartGroup.changed(mutableState3) | composerStartRestartGroup.changedInstance(animatable2) | composerStartRestartGroup.changedInstance(animationSpec) | ((i24 & 57344) == 16384);
                                    MotionLayoutKt$MotionLayoutCore$3$1 motionLayoutKt$MotionLayoutCore$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (zChangedInstance3 || motionLayoutKt$MotionLayoutCore$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                        animatable = animatable2;
                                        Function0<Unit> function6 = function1;
                                        layoutInformationReceiver2 = null;
                                        channel = channel2;
                                        function4 = function6;
                                        motionLayoutKt$MotionLayoutCore$3$1RememberedValue = new MotionLayoutKt$MotionLayoutCore$3$1(channel, animatable, animationSpec, function6, mutableState4, mutableState2, mutableState3, null);
                                        composerStartRestartGroup.updateRememberedValue(motionLayoutKt$MotionLayoutCore$3$1RememberedValue);
                                    } else {
                                        animatable = animatable2;
                                        function4 = function1;
                                        layoutInformationReceiver2 = null;
                                        channel = channel2;
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    EffectsKt.LaunchedEffect(motionScene, channel, (Function2) motionLayoutKt$MotionLayoutCore$3$1RememberedValue, composerStartRestartGroup, i21);
                                } else {
                                    i24 = i24;
                                    animatable = animatable2;
                                    function4 = function1;
                                    layoutInformationReceiver2 = layoutInformationReceiver;
                                }
                                composerStartRestartGroup.endReplaceGroup();
                                ConstraintSet constraintSetMotionLayoutCore_TEds9UA$lambda$14 = MotionLayoutCore_TEds9UA$lambda$14(mutableState2);
                                ConstraintSet constraintSetMotionLayoutCore_TEds9UA$lambda$17 = MotionLayoutCore_TEds9UA$lambda$17(mutableState3);
                                float fFloatValue = ((Number) animatable.getValue()).floatValue();
                                LayoutInformationReceiver layoutInformationReceiver3 = motionScene instanceof LayoutInformationReceiver ? (LayoutInformationReceiver) motionScene : layoutInformationReceiver2;
                                boolean zM10038getShowBoundsimpl = DebugFlags.m10038getShowBoundsimpl(iM10045getNonebfy_xzQ);
                                boolean zM10040getShowPathsimpl = DebugFlags.m10040getShowPathsimpl(iM10045getNonebfy_xzQ);
                                boolean zM10039getShowKeyPositionsimpl = DebugFlags.m10039getShowKeyPositionsimpl(iM10045getNonebfy_xzQ);
                                int i26 = ((i24 >> 3) & 458752) | ((i24 << 18) & C.ENCODING_PCM_DOUBLE);
                                int i27 = i24 >> 21;
                                composer2 = composerStartRestartGroup;
                                MotionLayoutCore(constraintSetMotionLayoutCore_TEds9UA$lambda$14, constraintSetMotionLayoutCore_TEds9UA$lambda$17, transition, fFloatValue, layoutInformationReceiver3, i20, zM10038getShowBoundsimpl, zM10040getShowPathsimpl, zM10039getShowKeyPositionsimpl, modifier3, mutableState, ref, invalidationStrategy, function3, composer2, i26, (i27 & 896) | (i27 & 14) | (Ref.$stable << 3) | (i27 & 112) | ((i18 << 9) & 7168));
                                i13 = i20;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier4 = modifier3;
                                function5 = function4;
                                i22 = iM10045getNonebfy_xzQ;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                i22 = i10;
                                modifier4 = modifier2;
                                composer2 = composerStartRestartGroup;
                                function5 = function1;
                            }
                            scopeUpdateScopeEndRestartGroup2 = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup2 != null) {
                                scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.4
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

                                    public final void invoke(Composer composer3, int i28) {
                                        MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier4, function5, i22, i13, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                                    }
                                });
                            }
                        }
                        i6 |= 805306368;
                        if ((i5 & 1024) != 0) {
                            i18 = i4 | 6;
                        } else if ((i4 & 6) == 0) {
                            if (composerStartRestartGroup.changedInstance(function3)) {
                                i19 = 4;
                            } else {
                                i19 = 2;
                            }
                            i18 = i4 | i19;
                        } else {
                            i18 = i4;
                        }
                        if ((i6 & 306783379) == 306783378) {
                            if (i23 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i7 != 0) {
                                function1 = null;
                            }
                            if (i9 != 0) {
                                iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                            } else {
                                iM10045getNonebfy_xzQ = i10;
                            }
                            if (i12 != 0) {
                                i13 = 257;
                            }
                            i20 = i13;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            MutableLongState mutableLongState2 = (MutableLongState) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            long longValue4 = mutableLongState2.getLongValue();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
                            i21 = i6 & 14;
                            modifier3 = companion;
                            if (i21 == 4) {
                                z = true;
                            } else {
                                z = false;
                            }
                            zChanged = z | composerStartRestartGroup.changed(longValue4);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged) {
                                objRememberedValue2 = motionScene.getTransitionInstance("default");
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            } else {
                                objRememberedValue2 = motionScene.getTransitionInstance("default");
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            transition = (Transition) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            long longValue5 = mutableLongState2.getLongValue();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
                            if (i21 == 4) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            zChanged2 = z2 | composerStartRestartGroup.changed(longValue5);
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged2) {
                                if (transition != null) {
                                    startConstraintSetId = "start";
                                } else {
                                    startConstraintSetId = "start";
                                }
                                objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                if (transition != null) {
                                    startConstraintSetId = "start";
                                } else {
                                    startConstraintSetId = "start";
                                }
                                objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            constraintSet = (ConstraintSet) objRememberedValue3;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            int i28 = i6;
                            long longValue6 = mutableLongState2.getLongValue();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
                            if (i21 == 4) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            zChanged3 = composerStartRestartGroup.changed(longValue6) | z3;
                            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged3) {
                                if (transition != null) {
                                    endConstraintSetId = "end";
                                } else {
                                    endConstraintSetId = "end";
                                }
                                objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            } else {
                                if (transition != null) {
                                    endConstraintSetId = "end";
                                } else {
                                    endConstraintSetId = "end";
                                }
                                objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            }
                            ConstraintSet constraintSet4 = (ConstraintSet) objRememberedValue4;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (constraintSet != null) {
                            }
                            function2 = function1;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                                final int i29 = iM10045getNonebfy_xzQ;
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                                    public final void invoke(Composer composer3, int i210) {
                                        MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i29, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        if (i23 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i7 != 0) {
                            function1 = null;
                        }
                        if (i9 != 0) {
                            iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                        } else {
                            iM10045getNonebfy_xzQ = i10;
                        }
                        if (i12 != 0) {
                            i13 = 257;
                        }
                        i20 = i13;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        MutableLongState mutableLongState3 = (MutableLongState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        long longValue7 = mutableLongState3.getLongValue();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
                        i21 = i6 & 14;
                        modifier3 = companion;
                        if (i21 == 4) {
                            z = true;
                        } else {
                            z = false;
                        }
                        zChanged = z | composerStartRestartGroup.changed(longValue7);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = motionScene.getTransitionInstance("default");
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = motionScene.getTransitionInstance("default");
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        transition = (Transition) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        long longValue8 = mutableLongState3.getLongValue();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
                        if (i21 == 4) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        zChanged2 = z2 | composerStartRestartGroup.changed(longValue8);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged2) {
                            if (transition != null) {
                                startConstraintSetId = "start";
                            } else {
                                startConstraintSetId = "start";
                            }
                            objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            if (transition != null) {
                                startConstraintSetId = "start";
                            } else {
                                startConstraintSetId = "start";
                            }
                            objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        constraintSet = (ConstraintSet) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i210 = i6;
                        long longValue9 = mutableLongState3.getLongValue();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
                        if (i21 == 4) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        zChanged3 = composerStartRestartGroup.changed(longValue9) | z3;
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged3) {
                            if (transition != null) {
                                endConstraintSetId = "end";
                            } else {
                                endConstraintSetId = "end";
                            }
                            objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        } else {
                            if (transition != null) {
                                endConstraintSetId = "end";
                            } else {
                                endConstraintSetId = "end";
                            }
                            objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        ConstraintSet constraintSet5 = (ConstraintSet) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (constraintSet != null) {
                        }
                        function2 = function1;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            final int i211 = iM10045getNonebfy_xzQ;
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                                public final void invoke(Composer composer3, int i212) {
                                    MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i211, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                                }
                            });
                            return;
                        }
                        return;
                        scopeUpdateScopeEndRestartGroup2 = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup2 != null) {
                            scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.4
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

                                public final void invoke(Composer composer3, int i212) {
                                    MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier4, function5, i22, i13, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                                }
                            });
                        }
                    }
                    i16 = 100663296;
                    i6 |= i16;
                    if ((i5 & 512) != 0) {
                        if ((805306368 & i3) == 0) {
                            if (composerStartRestartGroup.changedInstance(invalidationStrategy)) {
                                i17 = C.BUFFER_FLAG_LAST_SAMPLE;
                            } else {
                                i17 = 268435456;
                            }
                            i6 |= i17;
                        }
                        if ((i5 & 1024) != 0) {
                            i18 = i4 | 6;
                        } else if ((i4 & 6) == 0) {
                            if (composerStartRestartGroup.changedInstance(function3)) {
                                i19 = 4;
                            } else {
                                i19 = 2;
                            }
                            i18 = i4 | i19;
                        } else {
                            i18 = i4;
                        }
                        if ((i6 & 306783379) == 306783378) {
                            if (i23 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i7 != 0) {
                                function1 = null;
                            }
                            if (i9 != 0) {
                                iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                            } else {
                                iM10045getNonebfy_xzQ = i10;
                            }
                            if (i12 != 0) {
                                i13 = 257;
                            }
                            i20 = i13;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            MutableLongState mutableLongState4 = (MutableLongState) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            long longValue10 = mutableLongState4.getLongValue();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
                            i21 = i6 & 14;
                            modifier3 = companion;
                            if (i21 == 4) {
                                z = true;
                            } else {
                                z = false;
                            }
                            zChanged = z | composerStartRestartGroup.changed(longValue10);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged) {
                                objRememberedValue2 = motionScene.getTransitionInstance("default");
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            } else {
                                objRememberedValue2 = motionScene.getTransitionInstance("default");
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            transition = (Transition) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            long longValue11 = mutableLongState4.getLongValue();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
                            if (i21 == 4) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            zChanged2 = z2 | composerStartRestartGroup.changed(longValue11);
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged2) {
                                if (transition != null) {
                                    startConstraintSetId = "start";
                                } else {
                                    startConstraintSetId = "start";
                                }
                                objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                if (transition != null) {
                                    startConstraintSetId = "start";
                                } else {
                                    startConstraintSetId = "start";
                                }
                                objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            constraintSet = (ConstraintSet) objRememberedValue3;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            int i212 = i6;
                            long longValue12 = mutableLongState4.getLongValue();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
                            if (i21 == 4) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            zChanged3 = composerStartRestartGroup.changed(longValue12) | z3;
                            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged3) {
                                if (transition != null) {
                                    endConstraintSetId = "end";
                                } else {
                                    endConstraintSetId = "end";
                                }
                                objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            } else {
                                if (transition != null) {
                                    endConstraintSetId = "end";
                                } else {
                                    endConstraintSetId = "end";
                                }
                                objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            }
                            ConstraintSet constraintSet6 = (ConstraintSet) objRememberedValue4;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (constraintSet != null) {
                            }
                            function2 = function1;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                                final int i213 = iM10045getNonebfy_xzQ;
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                                    public final void invoke(Composer composer3, int i214) {
                                        MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i213, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        if (i23 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i7 != 0) {
                            function1 = null;
                        }
                        if (i9 != 0) {
                            iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                        } else {
                            iM10045getNonebfy_xzQ = i10;
                        }
                        if (i12 != 0) {
                            i13 = 257;
                        }
                        i20 = i13;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        MutableLongState mutableLongState5 = (MutableLongState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        long longValue13 = mutableLongState5.getLongValue();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
                        i21 = i6 & 14;
                        modifier3 = companion;
                        if (i21 == 4) {
                            z = true;
                        } else {
                            z = false;
                        }
                        zChanged = z | composerStartRestartGroup.changed(longValue13);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = motionScene.getTransitionInstance("default");
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = motionScene.getTransitionInstance("default");
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        transition = (Transition) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        long longValue14 = mutableLongState5.getLongValue();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
                        if (i21 == 4) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        zChanged2 = z2 | composerStartRestartGroup.changed(longValue14);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged2) {
                            if (transition != null) {
                                startConstraintSetId = "start";
                            } else {
                                startConstraintSetId = "start";
                            }
                            objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            if (transition != null) {
                                startConstraintSetId = "start";
                            } else {
                                startConstraintSetId = "start";
                            }
                            objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        constraintSet = (ConstraintSet) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i214 = i6;
                        long longValue15 = mutableLongState5.getLongValue();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
                        if (i21 == 4) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        zChanged3 = composerStartRestartGroup.changed(longValue15) | z3;
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged3) {
                            if (transition != null) {
                                endConstraintSetId = "end";
                            } else {
                                endConstraintSetId = "end";
                            }
                            objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        } else {
                            if (transition != null) {
                                endConstraintSetId = "end";
                            } else {
                                endConstraintSetId = "end";
                            }
                            objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        ConstraintSet constraintSet7 = (ConstraintSet) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (constraintSet != null) {
                        }
                        function2 = function1;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            final int i215 = iM10045getNonebfy_xzQ;
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                                public final void invoke(Composer composer3, int i216) {
                                    MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i215, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                                }
                            });
                            return;
                        }
                        return;
                        scopeUpdateScopeEndRestartGroup2 = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup2 != null) {
                            scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.4
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

                                public final void invoke(Composer composer3, int i216) {
                                    MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier4, function5, i22, i13, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                                }
                            });
                        }
                    }
                    i6 |= 805306368;
                    if ((i5 & 1024) != 0) {
                        i18 = i4 | 6;
                    } else if ((i4 & 6) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i19 = 4;
                        } else {
                            i19 = 2;
                        }
                        i18 = i4 | i19;
                    } else {
                        i18 = i4;
                    }
                    if ((i6 & 306783379) == 306783378) {
                        if (i23 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i7 != 0) {
                            function1 = null;
                        }
                        if (i9 != 0) {
                            iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                        } else {
                            iM10045getNonebfy_xzQ = i10;
                        }
                        if (i12 != 0) {
                            i13 = 257;
                        }
                        i20 = i13;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        MutableLongState mutableLongState6 = (MutableLongState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        long longValue16 = mutableLongState6.getLongValue();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
                        i21 = i6 & 14;
                        modifier3 = companion;
                        if (i21 == 4) {
                            z = true;
                        } else {
                            z = false;
                        }
                        zChanged = z | composerStartRestartGroup.changed(longValue16);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = motionScene.getTransitionInstance("default");
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = motionScene.getTransitionInstance("default");
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        transition = (Transition) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        long longValue17 = mutableLongState6.getLongValue();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
                        if (i21 == 4) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        zChanged2 = z2 | composerStartRestartGroup.changed(longValue17);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged2) {
                            if (transition != null) {
                                startConstraintSetId = "start";
                            } else {
                                startConstraintSetId = "start";
                            }
                            objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            if (transition != null) {
                                startConstraintSetId = "start";
                            } else {
                                startConstraintSetId = "start";
                            }
                            objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        constraintSet = (ConstraintSet) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i216 = i6;
                        long longValue18 = mutableLongState6.getLongValue();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
                        if (i21 == 4) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        zChanged3 = composerStartRestartGroup.changed(longValue18) | z3;
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged3) {
                            if (transition != null) {
                                endConstraintSetId = "end";
                            } else {
                                endConstraintSetId = "end";
                            }
                            objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        } else {
                            if (transition != null) {
                                endConstraintSetId = "end";
                            } else {
                                endConstraintSetId = "end";
                            }
                            objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        ConstraintSet constraintSet8 = (ConstraintSet) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (constraintSet != null) {
                        }
                        function2 = function1;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            final int i217 = iM10045getNonebfy_xzQ;
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                                public final void invoke(Composer composer3, int i218) {
                                    MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i217, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if (i23 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i7 != 0) {
                        function1 = null;
                    }
                    if (i9 != 0) {
                        iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                    } else {
                        iM10045getNonebfy_xzQ = i10;
                    }
                    if (i12 != 0) {
                        i13 = 257;
                    }
                    i20 = i13;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    MutableLongState mutableLongState7 = (MutableLongState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long longValue19 = mutableLongState7.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
                    i21 = i6 & 14;
                    modifier3 = companion;
                    if (i21 == 4) {
                        z = true;
                    } else {
                        z = false;
                    }
                    zChanged = z | composerStartRestartGroup.changed(longValue19);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = motionScene.getTransitionInstance("default");
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = motionScene.getTransitionInstance("default");
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    transition = (Transition) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long longValue110 = mutableLongState7.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
                    if (i21 == 4) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    zChanged2 = z2 | composerStartRestartGroup.changed(longValue110);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        if (transition != null) {
                            startConstraintSetId = "start";
                        } else {
                            startConstraintSetId = "start";
                        }
                        objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        if (transition != null) {
                            startConstraintSetId = "start";
                        } else {
                            startConstraintSetId = "start";
                        }
                        objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    constraintSet = (ConstraintSet) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i218 = i6;
                    long longValue111 = mutableLongState7.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
                    if (i21 == 4) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    zChanged3 = composerStartRestartGroup.changed(longValue111) | z3;
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged3) {
                        if (transition != null) {
                            endConstraintSetId = "end";
                        } else {
                            endConstraintSetId = "end";
                        }
                        objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        if (transition != null) {
                            endConstraintSetId = "end";
                        } else {
                            endConstraintSetId = "end";
                        }
                        objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ConstraintSet constraintSet9 = (ConstraintSet) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (constraintSet != null) {
                    }
                    function2 = function1;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final int i219 = iM10045getNonebfy_xzQ;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                            public final void invoke(Composer composer3, int i2110) {
                                MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i219, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                            }
                        });
                        return;
                    }
                    return;
                    scopeUpdateScopeEndRestartGroup2 = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup2 != null) {
                        scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.4
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

                            public final void invoke(Composer composer3, int i2110) {
                                MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier4, function5, i22, i13, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                            }
                        });
                    }
                }
                i6 |= 12582912;
                if ((i5 & 256) != 0) {
                    if ((100663296 & i3) == 0) {
                        if ((134217728 & i3) == 0) {
                            zChangedInstance = composerStartRestartGroup.changed(ref);
                        } else {
                            zChangedInstance = composerStartRestartGroup.changedInstance(ref);
                        }
                        if (zChangedInstance) {
                            i16 = 67108864;
                        } else {
                            i16 = 33554432;
                        }
                    }
                    if ((i5 & 512) != 0) {
                        if ((805306368 & i3) == 0) {
                            if (composerStartRestartGroup.changedInstance(invalidationStrategy)) {
                                i17 = C.BUFFER_FLAG_LAST_SAMPLE;
                            } else {
                                i17 = 268435456;
                            }
                            i6 |= i17;
                        }
                        if ((i5 & 1024) != 0) {
                            i18 = i4 | 6;
                        } else if ((i4 & 6) == 0) {
                            if (composerStartRestartGroup.changedInstance(function3)) {
                                i19 = 4;
                            } else {
                                i19 = 2;
                            }
                            i18 = i4 | i19;
                        } else {
                            i18 = i4;
                        }
                        if ((i6 & 306783379) == 306783378) {
                            if (i23 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i7 != 0) {
                                function1 = null;
                            }
                            if (i9 != 0) {
                                iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                            } else {
                                iM10045getNonebfy_xzQ = i10;
                            }
                            if (i12 != 0) {
                                i13 = 257;
                            }
                            i20 = i13;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            MutableLongState mutableLongState8 = (MutableLongState) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            long longValue112 = mutableLongState8.getLongValue();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
                            i21 = i6 & 14;
                            modifier3 = companion;
                            if (i21 == 4) {
                                z = true;
                            } else {
                                z = false;
                            }
                            zChanged = z | composerStartRestartGroup.changed(longValue112);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged) {
                                objRememberedValue2 = motionScene.getTransitionInstance("default");
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            } else {
                                objRememberedValue2 = motionScene.getTransitionInstance("default");
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            transition = (Transition) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            long longValue113 = mutableLongState8.getLongValue();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
                            if (i21 == 4) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            zChanged2 = z2 | composerStartRestartGroup.changed(longValue113);
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged2) {
                                if (transition != null) {
                                    startConstraintSetId = "start";
                                } else {
                                    startConstraintSetId = "start";
                                }
                                objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                if (transition != null) {
                                    startConstraintSetId = "start";
                                } else {
                                    startConstraintSetId = "start";
                                }
                                objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            constraintSet = (ConstraintSet) objRememberedValue3;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            int i2110 = i6;
                            long longValue114 = mutableLongState8.getLongValue();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
                            if (i21 == 4) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            zChanged3 = composerStartRestartGroup.changed(longValue114) | z3;
                            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged3) {
                                if (transition != null) {
                                    endConstraintSetId = "end";
                                } else {
                                    endConstraintSetId = "end";
                                }
                                objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            } else {
                                if (transition != null) {
                                    endConstraintSetId = "end";
                                } else {
                                    endConstraintSetId = "end";
                                }
                                objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            }
                            ConstraintSet constraintSet10 = (ConstraintSet) objRememberedValue4;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (constraintSet != null) {
                            }
                            function2 = function1;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                                final int i2111 = iM10045getNonebfy_xzQ;
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                                    public final void invoke(Composer composer3, int i2112) {
                                        MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i2111, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        if (i23 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i7 != 0) {
                            function1 = null;
                        }
                        if (i9 != 0) {
                            iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                        } else {
                            iM10045getNonebfy_xzQ = i10;
                        }
                        if (i12 != 0) {
                            i13 = 257;
                        }
                        i20 = i13;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        MutableLongState mutableLongState9 = (MutableLongState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        long longValue115 = mutableLongState9.getLongValue();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
                        i21 = i6 & 14;
                        modifier3 = companion;
                        if (i21 == 4) {
                            z = true;
                        } else {
                            z = false;
                        }
                        zChanged = z | composerStartRestartGroup.changed(longValue115);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = motionScene.getTransitionInstance("default");
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = motionScene.getTransitionInstance("default");
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        transition = (Transition) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        long longValue116 = mutableLongState9.getLongValue();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
                        if (i21 == 4) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        zChanged2 = z2 | composerStartRestartGroup.changed(longValue116);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged2) {
                            if (transition != null) {
                                startConstraintSetId = "start";
                            } else {
                                startConstraintSetId = "start";
                            }
                            objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            if (transition != null) {
                                startConstraintSetId = "start";
                            } else {
                                startConstraintSetId = "start";
                            }
                            objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        constraintSet = (ConstraintSet) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i2112 = i6;
                        long longValue117 = mutableLongState9.getLongValue();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
                        if (i21 == 4) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        zChanged3 = composerStartRestartGroup.changed(longValue117) | z3;
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged3) {
                            if (transition != null) {
                                endConstraintSetId = "end";
                            } else {
                                endConstraintSetId = "end";
                            }
                            objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        } else {
                            if (transition != null) {
                                endConstraintSetId = "end";
                            } else {
                                endConstraintSetId = "end";
                            }
                            objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        ConstraintSet constraintSet11 = (ConstraintSet) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (constraintSet != null) {
                        }
                        function2 = function1;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            final int i2113 = iM10045getNonebfy_xzQ;
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                                public final void invoke(Composer composer3, int i2114) {
                                    MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i2113, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                                }
                            });
                            return;
                        }
                        return;
                        scopeUpdateScopeEndRestartGroup2 = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup2 != null) {
                            scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.4
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

                                public final void invoke(Composer composer3, int i2114) {
                                    MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier4, function5, i22, i13, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                                }
                            });
                        }
                    }
                    i6 |= 805306368;
                    if ((i5 & 1024) != 0) {
                        i18 = i4 | 6;
                    } else if ((i4 & 6) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i19 = 4;
                        } else {
                            i19 = 2;
                        }
                        i18 = i4 | i19;
                    } else {
                        i18 = i4;
                    }
                    if ((i6 & 306783379) == 306783378) {
                        if (i23 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i7 != 0) {
                            function1 = null;
                        }
                        if (i9 != 0) {
                            iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                        } else {
                            iM10045getNonebfy_xzQ = i10;
                        }
                        if (i12 != 0) {
                            i13 = 257;
                        }
                        i20 = i13;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        MutableLongState mutableLongState10 = (MutableLongState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        long longValue118 = mutableLongState10.getLongValue();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
                        i21 = i6 & 14;
                        modifier3 = companion;
                        if (i21 == 4) {
                            z = true;
                        } else {
                            z = false;
                        }
                        zChanged = z | composerStartRestartGroup.changed(longValue118);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = motionScene.getTransitionInstance("default");
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = motionScene.getTransitionInstance("default");
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        transition = (Transition) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        long longValue119 = mutableLongState10.getLongValue();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
                        if (i21 == 4) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        zChanged2 = z2 | composerStartRestartGroup.changed(longValue119);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged2) {
                            if (transition != null) {
                                startConstraintSetId = "start";
                            } else {
                                startConstraintSetId = "start";
                            }
                            objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            if (transition != null) {
                                startConstraintSetId = "start";
                            } else {
                                startConstraintSetId = "start";
                            }
                            objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        constraintSet = (ConstraintSet) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i2114 = i6;
                        long longValue1110 = mutableLongState10.getLongValue();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
                        if (i21 == 4) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        zChanged3 = composerStartRestartGroup.changed(longValue1110) | z3;
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged3) {
                            if (transition != null) {
                                endConstraintSetId = "end";
                            } else {
                                endConstraintSetId = "end";
                            }
                            objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        } else {
                            if (transition != null) {
                                endConstraintSetId = "end";
                            } else {
                                endConstraintSetId = "end";
                            }
                            objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        ConstraintSet constraintSet12 = (ConstraintSet) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (constraintSet != null) {
                        }
                        function2 = function1;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            final int i2115 = iM10045getNonebfy_xzQ;
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                                public final void invoke(Composer composer3, int i2116) {
                                    MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i2115, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if (i23 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i7 != 0) {
                        function1 = null;
                    }
                    if (i9 != 0) {
                        iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                    } else {
                        iM10045getNonebfy_xzQ = i10;
                    }
                    if (i12 != 0) {
                        i13 = 257;
                    }
                    i20 = i13;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    MutableLongState mutableLongState11 = (MutableLongState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long longValue1111 = mutableLongState11.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
                    i21 = i6 & 14;
                    modifier3 = companion;
                    if (i21 == 4) {
                        z = true;
                    } else {
                        z = false;
                    }
                    zChanged = z | composerStartRestartGroup.changed(longValue1111);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = motionScene.getTransitionInstance("default");
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = motionScene.getTransitionInstance("default");
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    transition = (Transition) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long longValue1112 = mutableLongState11.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
                    if (i21 == 4) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    zChanged2 = z2 | composerStartRestartGroup.changed(longValue1112);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        if (transition != null) {
                            startConstraintSetId = "start";
                        } else {
                            startConstraintSetId = "start";
                        }
                        objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        if (transition != null) {
                            startConstraintSetId = "start";
                        } else {
                            startConstraintSetId = "start";
                        }
                        objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    constraintSet = (ConstraintSet) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i2116 = i6;
                    long longValue1113 = mutableLongState11.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
                    if (i21 == 4) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    zChanged3 = composerStartRestartGroup.changed(longValue1113) | z3;
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged3) {
                        if (transition != null) {
                            endConstraintSetId = "end";
                        } else {
                            endConstraintSetId = "end";
                        }
                        objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        if (transition != null) {
                            endConstraintSetId = "end";
                        } else {
                            endConstraintSetId = "end";
                        }
                        objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ConstraintSet constraintSet13 = (ConstraintSet) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (constraintSet != null) {
                    }
                    function2 = function1;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final int i2117 = iM10045getNonebfy_xzQ;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                            public final void invoke(Composer composer3, int i2118) {
                                MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i2117, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                            }
                        });
                        return;
                    }
                    return;
                    scopeUpdateScopeEndRestartGroup2 = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup2 != null) {
                        scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.4
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

                            public final void invoke(Composer composer3, int i2118) {
                                MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier4, function5, i22, i13, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                            }
                        });
                    }
                }
                i16 = 100663296;
                i6 |= i16;
                if ((i5 & 512) != 0) {
                    if ((805306368 & i3) == 0) {
                        if (composerStartRestartGroup.changedInstance(invalidationStrategy)) {
                            i17 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i17 = 268435456;
                        }
                        i6 |= i17;
                    }
                    if ((i5 & 1024) != 0) {
                        i18 = i4 | 6;
                    } else if ((i4 & 6) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i19 = 4;
                        } else {
                            i19 = 2;
                        }
                        i18 = i4 | i19;
                    } else {
                        i18 = i4;
                    }
                    if ((i6 & 306783379) == 306783378) {
                        if (i23 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i7 != 0) {
                            function1 = null;
                        }
                        if (i9 != 0) {
                            iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                        } else {
                            iM10045getNonebfy_xzQ = i10;
                        }
                        if (i12 != 0) {
                            i13 = 257;
                        }
                        i20 = i13;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        MutableLongState mutableLongState12 = (MutableLongState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        long longValue1114 = mutableLongState12.getLongValue();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
                        i21 = i6 & 14;
                        modifier3 = companion;
                        if (i21 == 4) {
                            z = true;
                        } else {
                            z = false;
                        }
                        zChanged = z | composerStartRestartGroup.changed(longValue1114);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = motionScene.getTransitionInstance("default");
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = motionScene.getTransitionInstance("default");
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        transition = (Transition) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        long longValue1115 = mutableLongState12.getLongValue();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
                        if (i21 == 4) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        zChanged2 = z2 | composerStartRestartGroup.changed(longValue1115);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged2) {
                            if (transition != null) {
                                startConstraintSetId = "start";
                            } else {
                                startConstraintSetId = "start";
                            }
                            objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            if (transition != null) {
                                startConstraintSetId = "start";
                            } else {
                                startConstraintSetId = "start";
                            }
                            objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        constraintSet = (ConstraintSet) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i2118 = i6;
                        long longValue1116 = mutableLongState12.getLongValue();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
                        if (i21 == 4) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        zChanged3 = composerStartRestartGroup.changed(longValue1116) | z3;
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged3) {
                            if (transition != null) {
                                endConstraintSetId = "end";
                            } else {
                                endConstraintSetId = "end";
                            }
                            objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        } else {
                            if (transition != null) {
                                endConstraintSetId = "end";
                            } else {
                                endConstraintSetId = "end";
                            }
                            objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        ConstraintSet constraintSet14 = (ConstraintSet) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (constraintSet != null) {
                        }
                        function2 = function1;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            final int i2119 = iM10045getNonebfy_xzQ;
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                                public final void invoke(Composer composer3, int i21110) {
                                    MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i2119, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if (i23 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i7 != 0) {
                        function1 = null;
                    }
                    if (i9 != 0) {
                        iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                    } else {
                        iM10045getNonebfy_xzQ = i10;
                    }
                    if (i12 != 0) {
                        i13 = 257;
                    }
                    i20 = i13;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    MutableLongState mutableLongState13 = (MutableLongState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long longValue1117 = mutableLongState13.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
                    i21 = i6 & 14;
                    modifier3 = companion;
                    if (i21 == 4) {
                        z = true;
                    } else {
                        z = false;
                    }
                    zChanged = z | composerStartRestartGroup.changed(longValue1117);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = motionScene.getTransitionInstance("default");
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = motionScene.getTransitionInstance("default");
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    transition = (Transition) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long longValue1118 = mutableLongState13.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
                    if (i21 == 4) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    zChanged2 = z2 | composerStartRestartGroup.changed(longValue1118);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        if (transition != null) {
                            startConstraintSetId = "start";
                        } else {
                            startConstraintSetId = "start";
                        }
                        objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        if (transition != null) {
                            startConstraintSetId = "start";
                        } else {
                            startConstraintSetId = "start";
                        }
                        objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    constraintSet = (ConstraintSet) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i21110 = i6;
                    long longValue1119 = mutableLongState13.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
                    if (i21 == 4) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    zChanged3 = composerStartRestartGroup.changed(longValue1119) | z3;
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged3) {
                        if (transition != null) {
                            endConstraintSetId = "end";
                        } else {
                            endConstraintSetId = "end";
                        }
                        objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        if (transition != null) {
                            endConstraintSetId = "end";
                        } else {
                            endConstraintSetId = "end";
                        }
                        objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ConstraintSet constraintSet15 = (ConstraintSet) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (constraintSet != null) {
                    }
                    function2 = function1;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final int i21111 = iM10045getNonebfy_xzQ;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                            public final void invoke(Composer composer3, int i21112) {
                                MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i21111, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                            }
                        });
                        return;
                    }
                    return;
                    scopeUpdateScopeEndRestartGroup2 = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup2 != null) {
                        scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.4
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

                            public final void invoke(Composer composer3, int i21112) {
                                MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier4, function5, i22, i13, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                            }
                        });
                    }
                }
                i6 |= 805306368;
                if ((i5 & 1024) != 0) {
                    i18 = i4 | 6;
                } else if ((i4 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i19 = 4;
                    } else {
                        i19 = 2;
                    }
                    i18 = i4 | i19;
                } else {
                    i18 = i4;
                }
                if ((i6 & 306783379) == 306783378) {
                    if (i23 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i7 != 0) {
                        function1 = null;
                    }
                    if (i9 != 0) {
                        iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                    } else {
                        iM10045getNonebfy_xzQ = i10;
                    }
                    if (i12 != 0) {
                        i13 = 257;
                    }
                    i20 = i13;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    MutableLongState mutableLongState14 = (MutableLongState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long longValue11110 = mutableLongState14.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
                    i21 = i6 & 14;
                    modifier3 = companion;
                    if (i21 == 4) {
                        z = true;
                    } else {
                        z = false;
                    }
                    zChanged = z | composerStartRestartGroup.changed(longValue11110);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = motionScene.getTransitionInstance("default");
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = motionScene.getTransitionInstance("default");
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    transition = (Transition) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long longValue11111 = mutableLongState14.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
                    if (i21 == 4) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    zChanged2 = z2 | composerStartRestartGroup.changed(longValue11111);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        if (transition != null) {
                            startConstraintSetId = "start";
                        } else {
                            startConstraintSetId = "start";
                        }
                        objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        if (transition != null) {
                            startConstraintSetId = "start";
                        } else {
                            startConstraintSetId = "start";
                        }
                        objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    constraintSet = (ConstraintSet) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i21112 = i6;
                    long longValue11112 = mutableLongState14.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
                    if (i21 == 4) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    zChanged3 = composerStartRestartGroup.changed(longValue11112) | z3;
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged3) {
                        if (transition != null) {
                            endConstraintSetId = "end";
                        } else {
                            endConstraintSetId = "end";
                        }
                        objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        if (transition != null) {
                            endConstraintSetId = "end";
                        } else {
                            endConstraintSetId = "end";
                        }
                        objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ConstraintSet constraintSet16 = (ConstraintSet) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (constraintSet != null) {
                    }
                    function2 = function1;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final int i21113 = iM10045getNonebfy_xzQ;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                            public final void invoke(Composer composer3, int i21114) {
                                MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i21113, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                            }
                        });
                        return;
                    }
                    return;
                }
                if (i23 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i7 != 0) {
                    function1 = null;
                }
                if (i9 != 0) {
                    iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                } else {
                    iM10045getNonebfy_xzQ = i10;
                }
                if (i12 != 0) {
                    i13 = 257;
                }
                i20 = i13;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                MutableLongState mutableLongState15 = (MutableLongState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                long longValue11113 = mutableLongState15.getLongValue();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
                i21 = i6 & 14;
                modifier3 = companion;
                if (i21 == 4) {
                    z = true;
                } else {
                    z = false;
                }
                zChanged = z | composerStartRestartGroup.changed(longValue11113);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = motionScene.getTransitionInstance("default");
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = motionScene.getTransitionInstance("default");
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                transition = (Transition) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                long longValue11114 = mutableLongState15.getLongValue();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
                if (i21 == 4) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                zChanged2 = z2 | composerStartRestartGroup.changed(longValue11114);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    if (transition != null) {
                        startConstraintSetId = "start";
                    } else {
                        startConstraintSetId = "start";
                    }
                    objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    if (transition != null) {
                        startConstraintSetId = "start";
                    } else {
                        startConstraintSetId = "start";
                    }
                    objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                constraintSet = (ConstraintSet) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i21114 = i6;
                long longValue11115 = mutableLongState15.getLongValue();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
                if (i21 == 4) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                zChanged3 = composerStartRestartGroup.changed(longValue11115) | z3;
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChanged3) {
                    if (transition != null) {
                        endConstraintSetId = "end";
                    } else {
                        endConstraintSetId = "end";
                    }
                    objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    if (transition != null) {
                        endConstraintSetId = "end";
                    } else {
                        endConstraintSetId = "end";
                    }
                    objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ConstraintSet constraintSet17 = (ConstraintSet) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (constraintSet != null) {
                }
                function2 = function1;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final int i21115 = iM10045getNonebfy_xzQ;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                        public final void invoke(Composer composer3, int i21116) {
                            MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i21115, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                        }
                    });
                    return;
                }
                return;
                scopeUpdateScopeEndRestartGroup2 = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup2 != null) {
                    scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.4
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

                        public final void invoke(Composer composer3, int i21116) {
                            MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier4, function5, i22, i13, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                        }
                    });
                }
            }
            i6 |= 24576;
            function1 = function0;
            i9 = i5 & 32;
            if (i9 != 0) {
                i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i10 = i;
            } else {
                i10 = i;
                if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(i10)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i6 |= i11;
                }
            }
            i12 = i5 & 64;
            if (i12 != 0) {
                i6 |= 1572864;
                i13 = i2;
            } else {
                i13 = i2;
                if ((i3 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(i13)) {
                        i14 = 1048576;
                    } else {
                        i14 = 524288;
                    }
                    i6 |= i14;
                }
            }
            if ((i5 & 128) != 0) {
                if ((i3 & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(mutableState)) {
                        i15 = 8388608;
                    } else {
                        i15 = 4194304;
                    }
                    i6 |= i15;
                }
                if ((i5 & 256) != 0) {
                    if ((100663296 & i3) == 0) {
                        if ((134217728 & i3) == 0) {
                            zChangedInstance = composerStartRestartGroup.changed(ref);
                        } else {
                            zChangedInstance = composerStartRestartGroup.changedInstance(ref);
                        }
                        if (zChangedInstance) {
                            i16 = 67108864;
                        } else {
                            i16 = 33554432;
                        }
                    }
                    if ((i5 & 512) != 0) {
                        if ((805306368 & i3) == 0) {
                            if (composerStartRestartGroup.changedInstance(invalidationStrategy)) {
                                i17 = C.BUFFER_FLAG_LAST_SAMPLE;
                            } else {
                                i17 = 268435456;
                            }
                            i6 |= i17;
                        }
                        if ((i5 & 1024) != 0) {
                            i18 = i4 | 6;
                        } else if ((i4 & 6) == 0) {
                            if (composerStartRestartGroup.changedInstance(function3)) {
                                i19 = 4;
                            } else {
                                i19 = 2;
                            }
                            i18 = i4 | i19;
                        } else {
                            i18 = i4;
                        }
                        if ((i6 & 306783379) == 306783378) {
                            if (i23 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i7 != 0) {
                                function1 = null;
                            }
                            if (i9 != 0) {
                                iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                            } else {
                                iM10045getNonebfy_xzQ = i10;
                            }
                            if (i12 != 0) {
                                i13 = 257;
                            }
                            i20 = i13;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            MutableLongState mutableLongState16 = (MutableLongState) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            long longValue11116 = mutableLongState16.getLongValue();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
                            i21 = i6 & 14;
                            modifier3 = companion;
                            if (i21 == 4) {
                                z = true;
                            } else {
                                z = false;
                            }
                            zChanged = z | composerStartRestartGroup.changed(longValue11116);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged) {
                                objRememberedValue2 = motionScene.getTransitionInstance("default");
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            } else {
                                objRememberedValue2 = motionScene.getTransitionInstance("default");
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            transition = (Transition) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            long longValue11117 = mutableLongState16.getLongValue();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
                            if (i21 == 4) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            zChanged2 = z2 | composerStartRestartGroup.changed(longValue11117);
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged2) {
                                if (transition != null) {
                                    startConstraintSetId = "start";
                                } else {
                                    startConstraintSetId = "start";
                                }
                                objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                if (transition != null) {
                                    startConstraintSetId = "start";
                                } else {
                                    startConstraintSetId = "start";
                                }
                                objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            constraintSet = (ConstraintSet) objRememberedValue3;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            int i21116 = i6;
                            long longValue11118 = mutableLongState16.getLongValue();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
                            if (i21 == 4) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            zChanged3 = composerStartRestartGroup.changed(longValue11118) | z3;
                            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged3) {
                                if (transition != null) {
                                    endConstraintSetId = "end";
                                } else {
                                    endConstraintSetId = "end";
                                }
                                objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            } else {
                                if (transition != null) {
                                    endConstraintSetId = "end";
                                } else {
                                    endConstraintSetId = "end";
                                }
                                objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            }
                            ConstraintSet constraintSet18 = (ConstraintSet) objRememberedValue4;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (constraintSet != null) {
                            }
                            function2 = function1;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                                final int i21117 = iM10045getNonebfy_xzQ;
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                                    public final void invoke(Composer composer3, int i21118) {
                                        MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i21117, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        if (i23 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i7 != 0) {
                            function1 = null;
                        }
                        if (i9 != 0) {
                            iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                        } else {
                            iM10045getNonebfy_xzQ = i10;
                        }
                        if (i12 != 0) {
                            i13 = 257;
                        }
                        i20 = i13;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        MutableLongState mutableLongState17 = (MutableLongState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        long longValue11119 = mutableLongState17.getLongValue();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
                        i21 = i6 & 14;
                        modifier3 = companion;
                        if (i21 == 4) {
                            z = true;
                        } else {
                            z = false;
                        }
                        zChanged = z | composerStartRestartGroup.changed(longValue11119);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = motionScene.getTransitionInstance("default");
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = motionScene.getTransitionInstance("default");
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        transition = (Transition) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        long longValue111110 = mutableLongState17.getLongValue();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
                        if (i21 == 4) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        zChanged2 = z2 | composerStartRestartGroup.changed(longValue111110);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged2) {
                            if (transition != null) {
                                startConstraintSetId = "start";
                            } else {
                                startConstraintSetId = "start";
                            }
                            objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            if (transition != null) {
                                startConstraintSetId = "start";
                            } else {
                                startConstraintSetId = "start";
                            }
                            objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        constraintSet = (ConstraintSet) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i21118 = i6;
                        long longValue111111 = mutableLongState17.getLongValue();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
                        if (i21 == 4) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        zChanged3 = composerStartRestartGroup.changed(longValue111111) | z3;
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged3) {
                            if (transition != null) {
                                endConstraintSetId = "end";
                            } else {
                                endConstraintSetId = "end";
                            }
                            objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        } else {
                            if (transition != null) {
                                endConstraintSetId = "end";
                            } else {
                                endConstraintSetId = "end";
                            }
                            objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        ConstraintSet constraintSet19 = (ConstraintSet) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (constraintSet != null) {
                        }
                        function2 = function1;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            final int i21119 = iM10045getNonebfy_xzQ;
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                                public final void invoke(Composer composer3, int i211110) {
                                    MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i21119, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                                }
                            });
                            return;
                        }
                        return;
                        scopeUpdateScopeEndRestartGroup2 = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup2 != null) {
                            scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.4
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

                                public final void invoke(Composer composer3, int i211110) {
                                    MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier4, function5, i22, i13, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                                }
                            });
                        }
                    }
                    i6 |= 805306368;
                    if ((i5 & 1024) != 0) {
                        i18 = i4 | 6;
                    } else if ((i4 & 6) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i19 = 4;
                        } else {
                            i19 = 2;
                        }
                        i18 = i4 | i19;
                    } else {
                        i18 = i4;
                    }
                    if ((i6 & 306783379) == 306783378) {
                        if (i23 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i7 != 0) {
                            function1 = null;
                        }
                        if (i9 != 0) {
                            iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                        } else {
                            iM10045getNonebfy_xzQ = i10;
                        }
                        if (i12 != 0) {
                            i13 = 257;
                        }
                        i20 = i13;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        MutableLongState mutableLongState18 = (MutableLongState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        long longValue111112 = mutableLongState18.getLongValue();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
                        i21 = i6 & 14;
                        modifier3 = companion;
                        if (i21 == 4) {
                            z = true;
                        } else {
                            z = false;
                        }
                        zChanged = z | composerStartRestartGroup.changed(longValue111112);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = motionScene.getTransitionInstance("default");
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = motionScene.getTransitionInstance("default");
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        transition = (Transition) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        long longValue111113 = mutableLongState18.getLongValue();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
                        if (i21 == 4) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        zChanged2 = z2 | composerStartRestartGroup.changed(longValue111113);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged2) {
                            if (transition != null) {
                                startConstraintSetId = "start";
                            } else {
                                startConstraintSetId = "start";
                            }
                            objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            if (transition != null) {
                                startConstraintSetId = "start";
                            } else {
                                startConstraintSetId = "start";
                            }
                            objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        constraintSet = (ConstraintSet) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i211110 = i6;
                        long longValue111114 = mutableLongState18.getLongValue();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
                        if (i21 == 4) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        zChanged3 = composerStartRestartGroup.changed(longValue111114) | z3;
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged3) {
                            if (transition != null) {
                                endConstraintSetId = "end";
                            } else {
                                endConstraintSetId = "end";
                            }
                            objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        } else {
                            if (transition != null) {
                                endConstraintSetId = "end";
                            } else {
                                endConstraintSetId = "end";
                            }
                            objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        ConstraintSet constraintSet110 = (ConstraintSet) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (constraintSet != null) {
                        }
                        function2 = function1;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            final int i211111 = iM10045getNonebfy_xzQ;
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                                public final void invoke(Composer composer3, int i211112) {
                                    MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i211111, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if (i23 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i7 != 0) {
                        function1 = null;
                    }
                    if (i9 != 0) {
                        iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                    } else {
                        iM10045getNonebfy_xzQ = i10;
                    }
                    if (i12 != 0) {
                        i13 = 257;
                    }
                    i20 = i13;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    MutableLongState mutableLongState19 = (MutableLongState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long longValue111115 = mutableLongState19.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
                    i21 = i6 & 14;
                    modifier3 = companion;
                    if (i21 == 4) {
                        z = true;
                    } else {
                        z = false;
                    }
                    zChanged = z | composerStartRestartGroup.changed(longValue111115);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = motionScene.getTransitionInstance("default");
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = motionScene.getTransitionInstance("default");
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    transition = (Transition) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long longValue111116 = mutableLongState19.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
                    if (i21 == 4) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    zChanged2 = z2 | composerStartRestartGroup.changed(longValue111116);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        if (transition != null) {
                            startConstraintSetId = "start";
                        } else {
                            startConstraintSetId = "start";
                        }
                        objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        if (transition != null) {
                            startConstraintSetId = "start";
                        } else {
                            startConstraintSetId = "start";
                        }
                        objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    constraintSet = (ConstraintSet) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i211112 = i6;
                    long longValue111117 = mutableLongState19.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
                    if (i21 == 4) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    zChanged3 = composerStartRestartGroup.changed(longValue111117) | z3;
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged3) {
                        if (transition != null) {
                            endConstraintSetId = "end";
                        } else {
                            endConstraintSetId = "end";
                        }
                        objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        if (transition != null) {
                            endConstraintSetId = "end";
                        } else {
                            endConstraintSetId = "end";
                        }
                        objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ConstraintSet constraintSet111 = (ConstraintSet) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (constraintSet != null) {
                    }
                    function2 = function1;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final int i211113 = iM10045getNonebfy_xzQ;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                            public final void invoke(Composer composer3, int i211114) {
                                MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i211113, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                            }
                        });
                        return;
                    }
                    return;
                    scopeUpdateScopeEndRestartGroup2 = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup2 != null) {
                        scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.4
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

                            public final void invoke(Composer composer3, int i211114) {
                                MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier4, function5, i22, i13, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                            }
                        });
                    }
                }
                i16 = 100663296;
                i6 |= i16;
                if ((i5 & 512) != 0) {
                    if ((805306368 & i3) == 0) {
                        if (composerStartRestartGroup.changedInstance(invalidationStrategy)) {
                            i17 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i17 = 268435456;
                        }
                        i6 |= i17;
                    }
                    if ((i5 & 1024) != 0) {
                        i18 = i4 | 6;
                    } else if ((i4 & 6) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i19 = 4;
                        } else {
                            i19 = 2;
                        }
                        i18 = i4 | i19;
                    } else {
                        i18 = i4;
                    }
                    if ((i6 & 306783379) == 306783378) {
                        if (i23 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i7 != 0) {
                            function1 = null;
                        }
                        if (i9 != 0) {
                            iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                        } else {
                            iM10045getNonebfy_xzQ = i10;
                        }
                        if (i12 != 0) {
                            i13 = 257;
                        }
                        i20 = i13;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        MutableLongState mutableLongState110 = (MutableLongState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        long longValue111118 = mutableLongState110.getLongValue();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
                        i21 = i6 & 14;
                        modifier3 = companion;
                        if (i21 == 4) {
                            z = true;
                        } else {
                            z = false;
                        }
                        zChanged = z | composerStartRestartGroup.changed(longValue111118);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = motionScene.getTransitionInstance("default");
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = motionScene.getTransitionInstance("default");
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        transition = (Transition) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        long longValue111119 = mutableLongState110.getLongValue();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
                        if (i21 == 4) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        zChanged2 = z2 | composerStartRestartGroup.changed(longValue111119);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged2) {
                            if (transition != null) {
                                startConstraintSetId = "start";
                            } else {
                                startConstraintSetId = "start";
                            }
                            objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            if (transition != null) {
                                startConstraintSetId = "start";
                            } else {
                                startConstraintSetId = "start";
                            }
                            objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        constraintSet = (ConstraintSet) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i211114 = i6;
                        long longValue1111110 = mutableLongState110.getLongValue();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
                        if (i21 == 4) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        zChanged3 = composerStartRestartGroup.changed(longValue1111110) | z3;
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged3) {
                            if (transition != null) {
                                endConstraintSetId = "end";
                            } else {
                                endConstraintSetId = "end";
                            }
                            objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        } else {
                            if (transition != null) {
                                endConstraintSetId = "end";
                            } else {
                                endConstraintSetId = "end";
                            }
                            objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        ConstraintSet constraintSet112 = (ConstraintSet) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (constraintSet != null) {
                        }
                        function2 = function1;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            final int i211115 = iM10045getNonebfy_xzQ;
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                                public final void invoke(Composer composer3, int i211116) {
                                    MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i211115, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if (i23 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i7 != 0) {
                        function1 = null;
                    }
                    if (i9 != 0) {
                        iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                    } else {
                        iM10045getNonebfy_xzQ = i10;
                    }
                    if (i12 != 0) {
                        i13 = 257;
                    }
                    i20 = i13;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    MutableLongState mutableLongState111 = (MutableLongState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long longValue1111111 = mutableLongState111.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
                    i21 = i6 & 14;
                    modifier3 = companion;
                    if (i21 == 4) {
                        z = true;
                    } else {
                        z = false;
                    }
                    zChanged = z | composerStartRestartGroup.changed(longValue1111111);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = motionScene.getTransitionInstance("default");
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = motionScene.getTransitionInstance("default");
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    transition = (Transition) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long longValue1111112 = mutableLongState111.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
                    if (i21 == 4) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    zChanged2 = z2 | composerStartRestartGroup.changed(longValue1111112);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        if (transition != null) {
                            startConstraintSetId = "start";
                        } else {
                            startConstraintSetId = "start";
                        }
                        objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        if (transition != null) {
                            startConstraintSetId = "start";
                        } else {
                            startConstraintSetId = "start";
                        }
                        objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    constraintSet = (ConstraintSet) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i211116 = i6;
                    long longValue1111113 = mutableLongState111.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
                    if (i21 == 4) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    zChanged3 = composerStartRestartGroup.changed(longValue1111113) | z3;
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged3) {
                        if (transition != null) {
                            endConstraintSetId = "end";
                        } else {
                            endConstraintSetId = "end";
                        }
                        objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        if (transition != null) {
                            endConstraintSetId = "end";
                        } else {
                            endConstraintSetId = "end";
                        }
                        objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ConstraintSet constraintSet113 = (ConstraintSet) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (constraintSet != null) {
                    }
                    function2 = function1;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final int i211117 = iM10045getNonebfy_xzQ;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                            public final void invoke(Composer composer3, int i211118) {
                                MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i211117, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                            }
                        });
                        return;
                    }
                    return;
                    scopeUpdateScopeEndRestartGroup2 = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup2 != null) {
                        scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.4
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

                            public final void invoke(Composer composer3, int i211118) {
                                MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier4, function5, i22, i13, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                            }
                        });
                    }
                }
                i6 |= 805306368;
                if ((i5 & 1024) != 0) {
                    i18 = i4 | 6;
                } else if ((i4 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i19 = 4;
                    } else {
                        i19 = 2;
                    }
                    i18 = i4 | i19;
                } else {
                    i18 = i4;
                }
                if ((i6 & 306783379) == 306783378) {
                    if (i23 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i7 != 0) {
                        function1 = null;
                    }
                    if (i9 != 0) {
                        iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                    } else {
                        iM10045getNonebfy_xzQ = i10;
                    }
                    if (i12 != 0) {
                        i13 = 257;
                    }
                    i20 = i13;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    MutableLongState mutableLongState112 = (MutableLongState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long longValue1111114 = mutableLongState112.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
                    i21 = i6 & 14;
                    modifier3 = companion;
                    if (i21 == 4) {
                        z = true;
                    } else {
                        z = false;
                    }
                    zChanged = z | composerStartRestartGroup.changed(longValue1111114);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = motionScene.getTransitionInstance("default");
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = motionScene.getTransitionInstance("default");
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    transition = (Transition) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long longValue1111115 = mutableLongState112.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
                    if (i21 == 4) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    zChanged2 = z2 | composerStartRestartGroup.changed(longValue1111115);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        if (transition != null) {
                            startConstraintSetId = "start";
                        } else {
                            startConstraintSetId = "start";
                        }
                        objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        if (transition != null) {
                            startConstraintSetId = "start";
                        } else {
                            startConstraintSetId = "start";
                        }
                        objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    constraintSet = (ConstraintSet) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i211118 = i6;
                    long longValue1111116 = mutableLongState112.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
                    if (i21 == 4) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    zChanged3 = composerStartRestartGroup.changed(longValue1111116) | z3;
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged3) {
                        if (transition != null) {
                            endConstraintSetId = "end";
                        } else {
                            endConstraintSetId = "end";
                        }
                        objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        if (transition != null) {
                            endConstraintSetId = "end";
                        } else {
                            endConstraintSetId = "end";
                        }
                        objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ConstraintSet constraintSet114 = (ConstraintSet) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (constraintSet != null) {
                    }
                    function2 = function1;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final int i211119 = iM10045getNonebfy_xzQ;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                            public final void invoke(Composer composer3, int i2111110) {
                                MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i211119, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                            }
                        });
                        return;
                    }
                    return;
                }
                if (i23 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i7 != 0) {
                    function1 = null;
                }
                if (i9 != 0) {
                    iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                } else {
                    iM10045getNonebfy_xzQ = i10;
                }
                if (i12 != 0) {
                    i13 = 257;
                }
                i20 = i13;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                MutableLongState mutableLongState113 = (MutableLongState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                long longValue1111117 = mutableLongState113.getLongValue();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
                i21 = i6 & 14;
                modifier3 = companion;
                if (i21 == 4) {
                    z = true;
                } else {
                    z = false;
                }
                zChanged = z | composerStartRestartGroup.changed(longValue1111117);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = motionScene.getTransitionInstance("default");
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = motionScene.getTransitionInstance("default");
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                transition = (Transition) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                long longValue1111118 = mutableLongState113.getLongValue();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
                if (i21 == 4) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                zChanged2 = z2 | composerStartRestartGroup.changed(longValue1111118);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    if (transition != null) {
                        startConstraintSetId = "start";
                    } else {
                        startConstraintSetId = "start";
                    }
                    objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    if (transition != null) {
                        startConstraintSetId = "start";
                    } else {
                        startConstraintSetId = "start";
                    }
                    objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                constraintSet = (ConstraintSet) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i2111110 = i6;
                long longValue1111119 = mutableLongState113.getLongValue();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
                if (i21 == 4) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                zChanged3 = composerStartRestartGroup.changed(longValue1111119) | z3;
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChanged3) {
                    if (transition != null) {
                        endConstraintSetId = "end";
                    } else {
                        endConstraintSetId = "end";
                    }
                    objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    if (transition != null) {
                        endConstraintSetId = "end";
                    } else {
                        endConstraintSetId = "end";
                    }
                    objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ConstraintSet constraintSet115 = (ConstraintSet) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (constraintSet != null) {
                }
                function2 = function1;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final int i2111111 = iM10045getNonebfy_xzQ;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                        public final void invoke(Composer composer3, int i2111112) {
                            MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i2111111, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                        }
                    });
                    return;
                }
                return;
                scopeUpdateScopeEndRestartGroup2 = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup2 != null) {
                    scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.4
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

                        public final void invoke(Composer composer3, int i2111112) {
                            MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier4, function5, i22, i13, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                        }
                    });
                }
            }
            i6 |= 12582912;
            if ((i5 & 256) != 0) {
                if ((100663296 & i3) == 0) {
                    if ((134217728 & i3) == 0) {
                        zChangedInstance = composerStartRestartGroup.changed(ref);
                    } else {
                        zChangedInstance = composerStartRestartGroup.changedInstance(ref);
                    }
                    if (zChangedInstance) {
                        i16 = 67108864;
                    } else {
                        i16 = 33554432;
                    }
                }
                if ((i5 & 512) != 0) {
                    if ((805306368 & i3) == 0) {
                        if (composerStartRestartGroup.changedInstance(invalidationStrategy)) {
                            i17 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i17 = 268435456;
                        }
                        i6 |= i17;
                    }
                    if ((i5 & 1024) != 0) {
                        i18 = i4 | 6;
                    } else if ((i4 & 6) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i19 = 4;
                        } else {
                            i19 = 2;
                        }
                        i18 = i4 | i19;
                    } else {
                        i18 = i4;
                    }
                    if ((i6 & 306783379) == 306783378) {
                        if (i23 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i7 != 0) {
                            function1 = null;
                        }
                        if (i9 != 0) {
                            iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                        } else {
                            iM10045getNonebfy_xzQ = i10;
                        }
                        if (i12 != 0) {
                            i13 = 257;
                        }
                        i20 = i13;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        MutableLongState mutableLongState114 = (MutableLongState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        long longValue11111110 = mutableLongState114.getLongValue();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
                        i21 = i6 & 14;
                        modifier3 = companion;
                        if (i21 == 4) {
                            z = true;
                        } else {
                            z = false;
                        }
                        zChanged = z | composerStartRestartGroup.changed(longValue11111110);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = motionScene.getTransitionInstance("default");
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = motionScene.getTransitionInstance("default");
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        transition = (Transition) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        long longValue11111111 = mutableLongState114.getLongValue();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
                        if (i21 == 4) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        zChanged2 = z2 | composerStartRestartGroup.changed(longValue11111111);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged2) {
                            if (transition != null) {
                                startConstraintSetId = "start";
                            } else {
                                startConstraintSetId = "start";
                            }
                            objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            if (transition != null) {
                                startConstraintSetId = "start";
                            } else {
                                startConstraintSetId = "start";
                            }
                            objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        constraintSet = (ConstraintSet) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i2111112 = i6;
                        long longValue11111112 = mutableLongState114.getLongValue();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
                        if (i21 == 4) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        zChanged3 = composerStartRestartGroup.changed(longValue11111112) | z3;
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged3) {
                            if (transition != null) {
                                endConstraintSetId = "end";
                            } else {
                                endConstraintSetId = "end";
                            }
                            objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        } else {
                            if (transition != null) {
                                endConstraintSetId = "end";
                            } else {
                                endConstraintSetId = "end";
                            }
                            objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        ConstraintSet constraintSet116 = (ConstraintSet) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (constraintSet != null) {
                        }
                        function2 = function1;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            final int i2111113 = iM10045getNonebfy_xzQ;
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                                public final void invoke(Composer composer3, int i2111114) {
                                    MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i2111113, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if (i23 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i7 != 0) {
                        function1 = null;
                    }
                    if (i9 != 0) {
                        iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                    } else {
                        iM10045getNonebfy_xzQ = i10;
                    }
                    if (i12 != 0) {
                        i13 = 257;
                    }
                    i20 = i13;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    MutableLongState mutableLongState115 = (MutableLongState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long longValue11111113 = mutableLongState115.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
                    i21 = i6 & 14;
                    modifier3 = companion;
                    if (i21 == 4) {
                        z = true;
                    } else {
                        z = false;
                    }
                    zChanged = z | composerStartRestartGroup.changed(longValue11111113);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = motionScene.getTransitionInstance("default");
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = motionScene.getTransitionInstance("default");
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    transition = (Transition) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long longValue11111114 = mutableLongState115.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
                    if (i21 == 4) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    zChanged2 = z2 | composerStartRestartGroup.changed(longValue11111114);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        if (transition != null) {
                            startConstraintSetId = "start";
                        } else {
                            startConstraintSetId = "start";
                        }
                        objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        if (transition != null) {
                            startConstraintSetId = "start";
                        } else {
                            startConstraintSetId = "start";
                        }
                        objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    constraintSet = (ConstraintSet) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i2111114 = i6;
                    long longValue11111115 = mutableLongState115.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
                    if (i21 == 4) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    zChanged3 = composerStartRestartGroup.changed(longValue11111115) | z3;
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged3) {
                        if (transition != null) {
                            endConstraintSetId = "end";
                        } else {
                            endConstraintSetId = "end";
                        }
                        objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        if (transition != null) {
                            endConstraintSetId = "end";
                        } else {
                            endConstraintSetId = "end";
                        }
                        objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ConstraintSet constraintSet117 = (ConstraintSet) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (constraintSet != null) {
                    }
                    function2 = function1;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final int i2111115 = iM10045getNonebfy_xzQ;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                            public final void invoke(Composer composer3, int i2111116) {
                                MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i2111115, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                            }
                        });
                        return;
                    }
                    return;
                    scopeUpdateScopeEndRestartGroup2 = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup2 != null) {
                        scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.4
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

                            public final void invoke(Composer composer3, int i2111116) {
                                MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier4, function5, i22, i13, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                            }
                        });
                    }
                }
                i6 |= 805306368;
                if ((i5 & 1024) != 0) {
                    i18 = i4 | 6;
                } else if ((i4 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i19 = 4;
                    } else {
                        i19 = 2;
                    }
                    i18 = i4 | i19;
                } else {
                    i18 = i4;
                }
                if ((i6 & 306783379) == 306783378) {
                    if (i23 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i7 != 0) {
                        function1 = null;
                    }
                    if (i9 != 0) {
                        iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                    } else {
                        iM10045getNonebfy_xzQ = i10;
                    }
                    if (i12 != 0) {
                        i13 = 257;
                    }
                    i20 = i13;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    MutableLongState mutableLongState116 = (MutableLongState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long longValue11111116 = mutableLongState116.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
                    i21 = i6 & 14;
                    modifier3 = companion;
                    if (i21 == 4) {
                        z = true;
                    } else {
                        z = false;
                    }
                    zChanged = z | composerStartRestartGroup.changed(longValue11111116);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = motionScene.getTransitionInstance("default");
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = motionScene.getTransitionInstance("default");
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    transition = (Transition) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long longValue11111117 = mutableLongState116.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
                    if (i21 == 4) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    zChanged2 = z2 | composerStartRestartGroup.changed(longValue11111117);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        if (transition != null) {
                            startConstraintSetId = "start";
                        } else {
                            startConstraintSetId = "start";
                        }
                        objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        if (transition != null) {
                            startConstraintSetId = "start";
                        } else {
                            startConstraintSetId = "start";
                        }
                        objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    constraintSet = (ConstraintSet) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i2111116 = i6;
                    long longValue11111118 = mutableLongState116.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
                    if (i21 == 4) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    zChanged3 = composerStartRestartGroup.changed(longValue11111118) | z3;
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged3) {
                        if (transition != null) {
                            endConstraintSetId = "end";
                        } else {
                            endConstraintSetId = "end";
                        }
                        objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        if (transition != null) {
                            endConstraintSetId = "end";
                        } else {
                            endConstraintSetId = "end";
                        }
                        objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ConstraintSet constraintSet118 = (ConstraintSet) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (constraintSet != null) {
                    }
                    function2 = function1;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final int i2111117 = iM10045getNonebfy_xzQ;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                            public final void invoke(Composer composer3, int i2111118) {
                                MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i2111117, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                            }
                        });
                        return;
                    }
                    return;
                }
                if (i23 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i7 != 0) {
                    function1 = null;
                }
                if (i9 != 0) {
                    iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                } else {
                    iM10045getNonebfy_xzQ = i10;
                }
                if (i12 != 0) {
                    i13 = 257;
                }
                i20 = i13;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                MutableLongState mutableLongState117 = (MutableLongState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                long longValue11111119 = mutableLongState117.getLongValue();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
                i21 = i6 & 14;
                modifier3 = companion;
                if (i21 == 4) {
                    z = true;
                } else {
                    z = false;
                }
                zChanged = z | composerStartRestartGroup.changed(longValue11111119);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = motionScene.getTransitionInstance("default");
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = motionScene.getTransitionInstance("default");
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                transition = (Transition) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                long longValue111111110 = mutableLongState117.getLongValue();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
                if (i21 == 4) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                zChanged2 = z2 | composerStartRestartGroup.changed(longValue111111110);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    if (transition != null) {
                        startConstraintSetId = "start";
                    } else {
                        startConstraintSetId = "start";
                    }
                    objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    if (transition != null) {
                        startConstraintSetId = "start";
                    } else {
                        startConstraintSetId = "start";
                    }
                    objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                constraintSet = (ConstraintSet) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i2111118 = i6;
                long longValue111111111 = mutableLongState117.getLongValue();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
                if (i21 == 4) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                zChanged3 = composerStartRestartGroup.changed(longValue111111111) | z3;
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChanged3) {
                    if (transition != null) {
                        endConstraintSetId = "end";
                    } else {
                        endConstraintSetId = "end";
                    }
                    objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    if (transition != null) {
                        endConstraintSetId = "end";
                    } else {
                        endConstraintSetId = "end";
                    }
                    objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ConstraintSet constraintSet119 = (ConstraintSet) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (constraintSet != null) {
                }
                function2 = function1;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final int i2111119 = iM10045getNonebfy_xzQ;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                        public final void invoke(Composer composer3, int i21111110) {
                            MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i2111119, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                        }
                    });
                    return;
                }
                return;
                scopeUpdateScopeEndRestartGroup2 = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup2 != null) {
                    scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.4
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

                        public final void invoke(Composer composer3, int i21111110) {
                            MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier4, function5, i22, i13, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                        }
                    });
                }
            }
            i16 = 100663296;
            i6 |= i16;
            if ((i5 & 512) != 0) {
                if ((805306368 & i3) == 0) {
                    if (composerStartRestartGroup.changedInstance(invalidationStrategy)) {
                        i17 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i17 = 268435456;
                    }
                    i6 |= i17;
                }
                if ((i5 & 1024) != 0) {
                    i18 = i4 | 6;
                } else if ((i4 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i19 = 4;
                    } else {
                        i19 = 2;
                    }
                    i18 = i4 | i19;
                } else {
                    i18 = i4;
                }
                if ((i6 & 306783379) == 306783378) {
                    if (i23 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i7 != 0) {
                        function1 = null;
                    }
                    if (i9 != 0) {
                        iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                    } else {
                        iM10045getNonebfy_xzQ = i10;
                    }
                    if (i12 != 0) {
                        i13 = 257;
                    }
                    i20 = i13;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    MutableLongState mutableLongState118 = (MutableLongState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long longValue111111112 = mutableLongState118.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
                    i21 = i6 & 14;
                    modifier3 = companion;
                    if (i21 == 4) {
                        z = true;
                    } else {
                        z = false;
                    }
                    zChanged = z | composerStartRestartGroup.changed(longValue111111112);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = motionScene.getTransitionInstance("default");
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = motionScene.getTransitionInstance("default");
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    transition = (Transition) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long longValue111111113 = mutableLongState118.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
                    if (i21 == 4) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    zChanged2 = z2 | composerStartRestartGroup.changed(longValue111111113);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        if (transition != null) {
                            startConstraintSetId = "start";
                        } else {
                            startConstraintSetId = "start";
                        }
                        objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        if (transition != null) {
                            startConstraintSetId = "start";
                        } else {
                            startConstraintSetId = "start";
                        }
                        objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    constraintSet = (ConstraintSet) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i21111110 = i6;
                    long longValue111111114 = mutableLongState118.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
                    if (i21 == 4) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    zChanged3 = composerStartRestartGroup.changed(longValue111111114) | z3;
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged3) {
                        if (transition != null) {
                            endConstraintSetId = "end";
                        } else {
                            endConstraintSetId = "end";
                        }
                        objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        if (transition != null) {
                            endConstraintSetId = "end";
                        } else {
                            endConstraintSetId = "end";
                        }
                        objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ConstraintSet constraintSet1110 = (ConstraintSet) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (constraintSet != null) {
                    }
                    function2 = function1;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final int i21111111 = iM10045getNonebfy_xzQ;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                            public final void invoke(Composer composer3, int i21111112) {
                                MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i21111111, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                            }
                        });
                        return;
                    }
                    return;
                }
                if (i23 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i7 != 0) {
                    function1 = null;
                }
                if (i9 != 0) {
                    iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                } else {
                    iM10045getNonebfy_xzQ = i10;
                }
                if (i12 != 0) {
                    i13 = 257;
                }
                i20 = i13;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                MutableLongState mutableLongState119 = (MutableLongState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                long longValue111111115 = mutableLongState119.getLongValue();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
                i21 = i6 & 14;
                modifier3 = companion;
                if (i21 == 4) {
                    z = true;
                } else {
                    z = false;
                }
                zChanged = z | composerStartRestartGroup.changed(longValue111111115);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = motionScene.getTransitionInstance("default");
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = motionScene.getTransitionInstance("default");
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                transition = (Transition) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                long longValue111111116 = mutableLongState119.getLongValue();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
                if (i21 == 4) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                zChanged2 = z2 | composerStartRestartGroup.changed(longValue111111116);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    if (transition != null) {
                        startConstraintSetId = "start";
                    } else {
                        startConstraintSetId = "start";
                    }
                    objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    if (transition != null) {
                        startConstraintSetId = "start";
                    } else {
                        startConstraintSetId = "start";
                    }
                    objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                constraintSet = (ConstraintSet) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i21111112 = i6;
                long longValue111111117 = mutableLongState119.getLongValue();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
                if (i21 == 4) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                zChanged3 = composerStartRestartGroup.changed(longValue111111117) | z3;
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChanged3) {
                    if (transition != null) {
                        endConstraintSetId = "end";
                    } else {
                        endConstraintSetId = "end";
                    }
                    objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    if (transition != null) {
                        endConstraintSetId = "end";
                    } else {
                        endConstraintSetId = "end";
                    }
                    objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ConstraintSet constraintSet1111 = (ConstraintSet) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (constraintSet != null) {
                }
                function2 = function1;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final int i21111113 = iM10045getNonebfy_xzQ;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                        public final void invoke(Composer composer3, int i21111114) {
                            MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i21111113, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                        }
                    });
                    return;
                }
                return;
                scopeUpdateScopeEndRestartGroup2 = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup2 != null) {
                    scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.4
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

                        public final void invoke(Composer composer3, int i21111114) {
                            MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier4, function5, i22, i13, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                        }
                    });
                }
            }
            i6 |= 805306368;
            if ((i5 & 1024) != 0) {
                i18 = i4 | 6;
            } else if ((i4 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i19 = 4;
                } else {
                    i19 = 2;
                }
                i18 = i4 | i19;
            } else {
                i18 = i4;
            }
            if ((i6 & 306783379) == 306783378) {
                if (i23 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i7 != 0) {
                    function1 = null;
                }
                if (i9 != 0) {
                    iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                } else {
                    iM10045getNonebfy_xzQ = i10;
                }
                if (i12 != 0) {
                    i13 = 257;
                }
                i20 = i13;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                MutableLongState mutableLongState1110 = (MutableLongState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                long longValue111111118 = mutableLongState1110.getLongValue();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
                i21 = i6 & 14;
                modifier3 = companion;
                if (i21 == 4) {
                    z = true;
                } else {
                    z = false;
                }
                zChanged = z | composerStartRestartGroup.changed(longValue111111118);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = motionScene.getTransitionInstance("default");
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = motionScene.getTransitionInstance("default");
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                transition = (Transition) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                long longValue111111119 = mutableLongState1110.getLongValue();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
                if (i21 == 4) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                zChanged2 = z2 | composerStartRestartGroup.changed(longValue111111119);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    if (transition != null) {
                        startConstraintSetId = "start";
                    } else {
                        startConstraintSetId = "start";
                    }
                    objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    if (transition != null) {
                        startConstraintSetId = "start";
                    } else {
                        startConstraintSetId = "start";
                    }
                    objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                constraintSet = (ConstraintSet) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i21111114 = i6;
                long longValue1111111110 = mutableLongState1110.getLongValue();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
                if (i21 == 4) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                zChanged3 = composerStartRestartGroup.changed(longValue1111111110) | z3;
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChanged3) {
                    if (transition != null) {
                        endConstraintSetId = "end";
                    } else {
                        endConstraintSetId = "end";
                    }
                    objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    if (transition != null) {
                        endConstraintSetId = "end";
                    } else {
                        endConstraintSetId = "end";
                    }
                    objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ConstraintSet constraintSet1112 = (ConstraintSet) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (constraintSet != null) {
                }
                function2 = function1;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final int i21111115 = iM10045getNonebfy_xzQ;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                        public final void invoke(Composer composer3, int i21111116) {
                            MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i21111115, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                        }
                    });
                    return;
                }
                return;
            }
            if (i23 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (i7 != 0) {
                function1 = null;
            }
            if (i9 != 0) {
                iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
            } else {
                iM10045getNonebfy_xzQ = i10;
            }
            if (i12 != 0) {
                i13 = 257;
            }
            i20 = i13;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            MutableLongState mutableLongState1111 = (MutableLongState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            long longValue1111111111 = mutableLongState1111.getLongValue();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
            i21 = i6 & 14;
            modifier3 = companion;
            if (i21 == 4) {
                z = true;
            } else {
                z = false;
            }
            zChanged = z | composerStartRestartGroup.changed(longValue1111111111);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue2 = motionScene.getTransitionInstance("default");
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = motionScene.getTransitionInstance("default");
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            transition = (Transition) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            long longValue1111111112 = mutableLongState1111.getLongValue();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
            if (i21 == 4) {
                z2 = true;
            } else {
                z2 = false;
            }
            zChanged2 = z2 | composerStartRestartGroup.changed(longValue1111111112);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (!zChanged2) {
                if (transition != null) {
                    startConstraintSetId = "start";
                } else {
                    startConstraintSetId = "start";
                }
                objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                if (transition != null) {
                    startConstraintSetId = "start";
                } else {
                    startConstraintSetId = "start";
                }
                objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            constraintSet = (ConstraintSet) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i21111116 = i6;
            long longValue1111111113 = mutableLongState1111.getLongValue();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
            if (i21 == 4) {
                z3 = true;
            } else {
                z3 = false;
            }
            zChanged3 = composerStartRestartGroup.changed(longValue1111111113) | z3;
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (!zChanged3) {
                if (transition != null) {
                    endConstraintSetId = "end";
                } else {
                    endConstraintSetId = "end";
                }
                objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            } else {
                if (transition != null) {
                    endConstraintSetId = "end";
                } else {
                    endConstraintSetId = "end";
                }
                objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ConstraintSet constraintSet1113 = (ConstraintSet) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (constraintSet != null) {
            }
            function2 = function1;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final int i21111117 = iM10045getNonebfy_xzQ;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                    public final void invoke(Composer composer3, int i21111118) {
                        MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i21111117, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                    }
                });
                return;
            }
            return;
            scopeUpdateScopeEndRestartGroup2 = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup2 != null) {
                scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.4
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

                    public final void invoke(Composer composer3, int i21111118) {
                        MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier4, function5, i22, i13, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                    }
                });
            }
        }
        i6 |= 3072;
        modifier2 = modifier;
        i7 = i5 & 16;
        if (i7 != 0) {
            if ((i3 & 24576) == 0) {
                function1 = function0;
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i8 = 16384;
                } else {
                    i8 = 8192;
                }
                i6 |= i8;
            }
            i9 = i5 & 32;
            if (i9 != 0) {
                i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i10 = i;
            } else {
                i10 = i;
                if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(i10)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i6 |= i11;
                }
            }
            i12 = i5 & 64;
            if (i12 != 0) {
                i6 |= 1572864;
                i13 = i2;
            } else {
                i13 = i2;
                if ((i3 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(i13)) {
                        i14 = 1048576;
                    } else {
                        i14 = 524288;
                    }
                    i6 |= i14;
                }
            }
            if ((i5 & 128) != 0) {
                if ((i3 & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(mutableState)) {
                        i15 = 8388608;
                    } else {
                        i15 = 4194304;
                    }
                    i6 |= i15;
                }
                if ((i5 & 256) != 0) {
                    if ((100663296 & i3) == 0) {
                        if ((134217728 & i3) == 0) {
                            zChangedInstance = composerStartRestartGroup.changed(ref);
                        } else {
                            zChangedInstance = composerStartRestartGroup.changedInstance(ref);
                        }
                        if (zChangedInstance) {
                            i16 = 67108864;
                        } else {
                            i16 = 33554432;
                        }
                    }
                    if ((i5 & 512) != 0) {
                        if ((805306368 & i3) == 0) {
                            if (composerStartRestartGroup.changedInstance(invalidationStrategy)) {
                                i17 = C.BUFFER_FLAG_LAST_SAMPLE;
                            } else {
                                i17 = 268435456;
                            }
                            i6 |= i17;
                        }
                        if ((i5 & 1024) != 0) {
                            i18 = i4 | 6;
                        } else if ((i4 & 6) == 0) {
                            if (composerStartRestartGroup.changedInstance(function3)) {
                                i19 = 4;
                            } else {
                                i19 = 2;
                            }
                            i18 = i4 | i19;
                        } else {
                            i18 = i4;
                        }
                        if ((i6 & 306783379) == 306783378) {
                            if (i23 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i7 != 0) {
                                function1 = null;
                            }
                            if (i9 != 0) {
                                iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                            } else {
                                iM10045getNonebfy_xzQ = i10;
                            }
                            if (i12 != 0) {
                                i13 = 257;
                            }
                            i20 = i13;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            MutableLongState mutableLongState1112 = (MutableLongState) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            long longValue1111111114 = mutableLongState1112.getLongValue();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
                            i21 = i6 & 14;
                            modifier3 = companion;
                            if (i21 == 4) {
                                z = true;
                            } else {
                                z = false;
                            }
                            zChanged = z | composerStartRestartGroup.changed(longValue1111111114);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged) {
                                objRememberedValue2 = motionScene.getTransitionInstance("default");
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            } else {
                                objRememberedValue2 = motionScene.getTransitionInstance("default");
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            transition = (Transition) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            long longValue1111111115 = mutableLongState1112.getLongValue();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
                            if (i21 == 4) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            zChanged2 = z2 | composerStartRestartGroup.changed(longValue1111111115);
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged2) {
                                if (transition != null) {
                                    startConstraintSetId = "start";
                                } else {
                                    startConstraintSetId = "start";
                                }
                                objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                if (transition != null) {
                                    startConstraintSetId = "start";
                                } else {
                                    startConstraintSetId = "start";
                                }
                                objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            constraintSet = (ConstraintSet) objRememberedValue3;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            int i21111118 = i6;
                            long longValue1111111116 = mutableLongState1112.getLongValue();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
                            if (i21 == 4) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            zChanged3 = composerStartRestartGroup.changed(longValue1111111116) | z3;
                            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged3) {
                                if (transition != null) {
                                    endConstraintSetId = "end";
                                } else {
                                    endConstraintSetId = "end";
                                }
                                objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            } else {
                                if (transition != null) {
                                    endConstraintSetId = "end";
                                } else {
                                    endConstraintSetId = "end";
                                }
                                objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            }
                            ConstraintSet constraintSet1114 = (ConstraintSet) objRememberedValue4;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (constraintSet != null) {
                            }
                            function2 = function1;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                                final int i21111119 = iM10045getNonebfy_xzQ;
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                                    public final void invoke(Composer composer3, int i211111110) {
                                        MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i21111119, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        if (i23 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i7 != 0) {
                            function1 = null;
                        }
                        if (i9 != 0) {
                            iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                        } else {
                            iM10045getNonebfy_xzQ = i10;
                        }
                        if (i12 != 0) {
                            i13 = 257;
                        }
                        i20 = i13;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        MutableLongState mutableLongState1113 = (MutableLongState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        long longValue1111111117 = mutableLongState1113.getLongValue();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
                        i21 = i6 & 14;
                        modifier3 = companion;
                        if (i21 == 4) {
                            z = true;
                        } else {
                            z = false;
                        }
                        zChanged = z | composerStartRestartGroup.changed(longValue1111111117);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = motionScene.getTransitionInstance("default");
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = motionScene.getTransitionInstance("default");
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        transition = (Transition) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        long longValue1111111118 = mutableLongState1113.getLongValue();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
                        if (i21 == 4) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        zChanged2 = z2 | composerStartRestartGroup.changed(longValue1111111118);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged2) {
                            if (transition != null) {
                                startConstraintSetId = "start";
                            } else {
                                startConstraintSetId = "start";
                            }
                            objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            if (transition != null) {
                                startConstraintSetId = "start";
                            } else {
                                startConstraintSetId = "start";
                            }
                            objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        constraintSet = (ConstraintSet) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i211111110 = i6;
                        long longValue1111111119 = mutableLongState1113.getLongValue();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
                        if (i21 == 4) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        zChanged3 = composerStartRestartGroup.changed(longValue1111111119) | z3;
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged3) {
                            if (transition != null) {
                                endConstraintSetId = "end";
                            } else {
                                endConstraintSetId = "end";
                            }
                            objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        } else {
                            if (transition != null) {
                                endConstraintSetId = "end";
                            } else {
                                endConstraintSetId = "end";
                            }
                            objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        ConstraintSet constraintSet1115 = (ConstraintSet) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (constraintSet != null) {
                        }
                        function2 = function1;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            final int i211111111 = iM10045getNonebfy_xzQ;
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                                public final void invoke(Composer composer3, int i211111112) {
                                    MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i211111111, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                                }
                            });
                            return;
                        }
                        return;
                        scopeUpdateScopeEndRestartGroup2 = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup2 != null) {
                            scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.4
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

                                public final void invoke(Composer composer3, int i211111112) {
                                    MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier4, function5, i22, i13, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                                }
                            });
                        }
                    }
                    i6 |= 805306368;
                    if ((i5 & 1024) != 0) {
                        i18 = i4 | 6;
                    } else if ((i4 & 6) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i19 = 4;
                        } else {
                            i19 = 2;
                        }
                        i18 = i4 | i19;
                    } else {
                        i18 = i4;
                    }
                    if ((i6 & 306783379) == 306783378) {
                        if (i23 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i7 != 0) {
                            function1 = null;
                        }
                        if (i9 != 0) {
                            iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                        } else {
                            iM10045getNonebfy_xzQ = i10;
                        }
                        if (i12 != 0) {
                            i13 = 257;
                        }
                        i20 = i13;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        MutableLongState mutableLongState1114 = (MutableLongState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        long longValue11111111110 = mutableLongState1114.getLongValue();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
                        i21 = i6 & 14;
                        modifier3 = companion;
                        if (i21 == 4) {
                            z = true;
                        } else {
                            z = false;
                        }
                        zChanged = z | composerStartRestartGroup.changed(longValue11111111110);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = motionScene.getTransitionInstance("default");
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = motionScene.getTransitionInstance("default");
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        transition = (Transition) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        long longValue11111111111 = mutableLongState1114.getLongValue();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
                        if (i21 == 4) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        zChanged2 = z2 | composerStartRestartGroup.changed(longValue11111111111);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged2) {
                            if (transition != null) {
                                startConstraintSetId = "start";
                            } else {
                                startConstraintSetId = "start";
                            }
                            objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            if (transition != null) {
                                startConstraintSetId = "start";
                            } else {
                                startConstraintSetId = "start";
                            }
                            objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        constraintSet = (ConstraintSet) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i211111112 = i6;
                        long longValue11111111112 = mutableLongState1114.getLongValue();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
                        if (i21 == 4) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        zChanged3 = composerStartRestartGroup.changed(longValue11111111112) | z3;
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged3) {
                            if (transition != null) {
                                endConstraintSetId = "end";
                            } else {
                                endConstraintSetId = "end";
                            }
                            objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        } else {
                            if (transition != null) {
                                endConstraintSetId = "end";
                            } else {
                                endConstraintSetId = "end";
                            }
                            objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        ConstraintSet constraintSet1116 = (ConstraintSet) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (constraintSet != null) {
                        }
                        function2 = function1;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            final int i211111113 = iM10045getNonebfy_xzQ;
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                                public final void invoke(Composer composer3, int i211111114) {
                                    MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i211111113, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if (i23 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i7 != 0) {
                        function1 = null;
                    }
                    if (i9 != 0) {
                        iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                    } else {
                        iM10045getNonebfy_xzQ = i10;
                    }
                    if (i12 != 0) {
                        i13 = 257;
                    }
                    i20 = i13;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    MutableLongState mutableLongState1115 = (MutableLongState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long longValue11111111113 = mutableLongState1115.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
                    i21 = i6 & 14;
                    modifier3 = companion;
                    if (i21 == 4) {
                        z = true;
                    } else {
                        z = false;
                    }
                    zChanged = z | composerStartRestartGroup.changed(longValue11111111113);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = motionScene.getTransitionInstance("default");
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = motionScene.getTransitionInstance("default");
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    transition = (Transition) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long longValue11111111114 = mutableLongState1115.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
                    if (i21 == 4) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    zChanged2 = z2 | composerStartRestartGroup.changed(longValue11111111114);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        if (transition != null) {
                            startConstraintSetId = "start";
                        } else {
                            startConstraintSetId = "start";
                        }
                        objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        if (transition != null) {
                            startConstraintSetId = "start";
                        } else {
                            startConstraintSetId = "start";
                        }
                        objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    constraintSet = (ConstraintSet) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i211111114 = i6;
                    long longValue11111111115 = mutableLongState1115.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
                    if (i21 == 4) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    zChanged3 = composerStartRestartGroup.changed(longValue11111111115) | z3;
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged3) {
                        if (transition != null) {
                            endConstraintSetId = "end";
                        } else {
                            endConstraintSetId = "end";
                        }
                        objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        if (transition != null) {
                            endConstraintSetId = "end";
                        } else {
                            endConstraintSetId = "end";
                        }
                        objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ConstraintSet constraintSet1117 = (ConstraintSet) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (constraintSet != null) {
                    }
                    function2 = function1;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final int i211111115 = iM10045getNonebfy_xzQ;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                            public final void invoke(Composer composer3, int i211111116) {
                                MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i211111115, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                            }
                        });
                        return;
                    }
                    return;
                    scopeUpdateScopeEndRestartGroup2 = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup2 != null) {
                        scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.4
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

                            public final void invoke(Composer composer3, int i211111116) {
                                MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier4, function5, i22, i13, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                            }
                        });
                    }
                }
                i16 = 100663296;
                i6 |= i16;
                if ((i5 & 512) != 0) {
                    if ((805306368 & i3) == 0) {
                        if (composerStartRestartGroup.changedInstance(invalidationStrategy)) {
                            i17 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i17 = 268435456;
                        }
                        i6 |= i17;
                    }
                    if ((i5 & 1024) != 0) {
                        i18 = i4 | 6;
                    } else if ((i4 & 6) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i19 = 4;
                        } else {
                            i19 = 2;
                        }
                        i18 = i4 | i19;
                    } else {
                        i18 = i4;
                    }
                    if ((i6 & 306783379) == 306783378) {
                        if (i23 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i7 != 0) {
                            function1 = null;
                        }
                        if (i9 != 0) {
                            iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                        } else {
                            iM10045getNonebfy_xzQ = i10;
                        }
                        if (i12 != 0) {
                            i13 = 257;
                        }
                        i20 = i13;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        MutableLongState mutableLongState1116 = (MutableLongState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        long longValue11111111116 = mutableLongState1116.getLongValue();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
                        i21 = i6 & 14;
                        modifier3 = companion;
                        if (i21 == 4) {
                            z = true;
                        } else {
                            z = false;
                        }
                        zChanged = z | composerStartRestartGroup.changed(longValue11111111116);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = motionScene.getTransitionInstance("default");
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = motionScene.getTransitionInstance("default");
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        transition = (Transition) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        long longValue11111111117 = mutableLongState1116.getLongValue();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
                        if (i21 == 4) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        zChanged2 = z2 | composerStartRestartGroup.changed(longValue11111111117);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged2) {
                            if (transition != null) {
                                startConstraintSetId = "start";
                            } else {
                                startConstraintSetId = "start";
                            }
                            objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            if (transition != null) {
                                startConstraintSetId = "start";
                            } else {
                                startConstraintSetId = "start";
                            }
                            objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        constraintSet = (ConstraintSet) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i211111116 = i6;
                        long longValue11111111118 = mutableLongState1116.getLongValue();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
                        if (i21 == 4) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        zChanged3 = composerStartRestartGroup.changed(longValue11111111118) | z3;
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged3) {
                            if (transition != null) {
                                endConstraintSetId = "end";
                            } else {
                                endConstraintSetId = "end";
                            }
                            objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        } else {
                            if (transition != null) {
                                endConstraintSetId = "end";
                            } else {
                                endConstraintSetId = "end";
                            }
                            objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        ConstraintSet constraintSet1118 = (ConstraintSet) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (constraintSet != null) {
                        }
                        function2 = function1;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            final int i211111117 = iM10045getNonebfy_xzQ;
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                                public final void invoke(Composer composer3, int i211111118) {
                                    MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i211111117, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if (i23 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i7 != 0) {
                        function1 = null;
                    }
                    if (i9 != 0) {
                        iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                    } else {
                        iM10045getNonebfy_xzQ = i10;
                    }
                    if (i12 != 0) {
                        i13 = 257;
                    }
                    i20 = i13;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    MutableLongState mutableLongState1117 = (MutableLongState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long longValue11111111119 = mutableLongState1117.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
                    i21 = i6 & 14;
                    modifier3 = companion;
                    if (i21 == 4) {
                        z = true;
                    } else {
                        z = false;
                    }
                    zChanged = z | composerStartRestartGroup.changed(longValue11111111119);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = motionScene.getTransitionInstance("default");
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = motionScene.getTransitionInstance("default");
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    transition = (Transition) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long longValue111111111110 = mutableLongState1117.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
                    if (i21 == 4) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    zChanged2 = z2 | composerStartRestartGroup.changed(longValue111111111110);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        if (transition != null) {
                            startConstraintSetId = "start";
                        } else {
                            startConstraintSetId = "start";
                        }
                        objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        if (transition != null) {
                            startConstraintSetId = "start";
                        } else {
                            startConstraintSetId = "start";
                        }
                        objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    constraintSet = (ConstraintSet) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i211111118 = i6;
                    long longValue111111111111 = mutableLongState1117.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
                    if (i21 == 4) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    zChanged3 = composerStartRestartGroup.changed(longValue111111111111) | z3;
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged3) {
                        if (transition != null) {
                            endConstraintSetId = "end";
                        } else {
                            endConstraintSetId = "end";
                        }
                        objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        if (transition != null) {
                            endConstraintSetId = "end";
                        } else {
                            endConstraintSetId = "end";
                        }
                        objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ConstraintSet constraintSet1119 = (ConstraintSet) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (constraintSet != null) {
                    }
                    function2 = function1;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final int i211111119 = iM10045getNonebfy_xzQ;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                            public final void invoke(Composer composer3, int i2111111110) {
                                MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i211111119, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                            }
                        });
                        return;
                    }
                    return;
                    scopeUpdateScopeEndRestartGroup2 = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup2 != null) {
                        scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.4
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

                            public final void invoke(Composer composer3, int i2111111110) {
                                MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier4, function5, i22, i13, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                            }
                        });
                    }
                }
                i6 |= 805306368;
                if ((i5 & 1024) != 0) {
                    i18 = i4 | 6;
                } else if ((i4 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i19 = 4;
                    } else {
                        i19 = 2;
                    }
                    i18 = i4 | i19;
                } else {
                    i18 = i4;
                }
                if ((i6 & 306783379) == 306783378) {
                    if (i23 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i7 != 0) {
                        function1 = null;
                    }
                    if (i9 != 0) {
                        iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                    } else {
                        iM10045getNonebfy_xzQ = i10;
                    }
                    if (i12 != 0) {
                        i13 = 257;
                    }
                    i20 = i13;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    MutableLongState mutableLongState1118 = (MutableLongState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long longValue111111111112 = mutableLongState1118.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
                    i21 = i6 & 14;
                    modifier3 = companion;
                    if (i21 == 4) {
                        z = true;
                    } else {
                        z = false;
                    }
                    zChanged = z | composerStartRestartGroup.changed(longValue111111111112);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = motionScene.getTransitionInstance("default");
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = motionScene.getTransitionInstance("default");
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    transition = (Transition) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long longValue111111111113 = mutableLongState1118.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
                    if (i21 == 4) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    zChanged2 = z2 | composerStartRestartGroup.changed(longValue111111111113);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        if (transition != null) {
                            startConstraintSetId = "start";
                        } else {
                            startConstraintSetId = "start";
                        }
                        objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        if (transition != null) {
                            startConstraintSetId = "start";
                        } else {
                            startConstraintSetId = "start";
                        }
                        objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    constraintSet = (ConstraintSet) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i2111111110 = i6;
                    long longValue111111111114 = mutableLongState1118.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
                    if (i21 == 4) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    zChanged3 = composerStartRestartGroup.changed(longValue111111111114) | z3;
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged3) {
                        if (transition != null) {
                            endConstraintSetId = "end";
                        } else {
                            endConstraintSetId = "end";
                        }
                        objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        if (transition != null) {
                            endConstraintSetId = "end";
                        } else {
                            endConstraintSetId = "end";
                        }
                        objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ConstraintSet constraintSet11110 = (ConstraintSet) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (constraintSet != null) {
                    }
                    function2 = function1;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final int i2111111111 = iM10045getNonebfy_xzQ;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                            public final void invoke(Composer composer3, int i2111111112) {
                                MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i2111111111, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                            }
                        });
                        return;
                    }
                    return;
                }
                if (i23 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i7 != 0) {
                    function1 = null;
                }
                if (i9 != 0) {
                    iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                } else {
                    iM10045getNonebfy_xzQ = i10;
                }
                if (i12 != 0) {
                    i13 = 257;
                }
                i20 = i13;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                MutableLongState mutableLongState1119 = (MutableLongState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                long longValue111111111115 = mutableLongState1119.getLongValue();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
                i21 = i6 & 14;
                modifier3 = companion;
                if (i21 == 4) {
                    z = true;
                } else {
                    z = false;
                }
                zChanged = z | composerStartRestartGroup.changed(longValue111111111115);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = motionScene.getTransitionInstance("default");
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = motionScene.getTransitionInstance("default");
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                transition = (Transition) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                long longValue111111111116 = mutableLongState1119.getLongValue();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
                if (i21 == 4) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                zChanged2 = z2 | composerStartRestartGroup.changed(longValue111111111116);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    if (transition != null) {
                        startConstraintSetId = "start";
                    } else {
                        startConstraintSetId = "start";
                    }
                    objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    if (transition != null) {
                        startConstraintSetId = "start";
                    } else {
                        startConstraintSetId = "start";
                    }
                    objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                constraintSet = (ConstraintSet) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i2111111112 = i6;
                long longValue111111111117 = mutableLongState1119.getLongValue();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
                if (i21 == 4) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                zChanged3 = composerStartRestartGroup.changed(longValue111111111117) | z3;
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChanged3) {
                    if (transition != null) {
                        endConstraintSetId = "end";
                    } else {
                        endConstraintSetId = "end";
                    }
                    objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    if (transition != null) {
                        endConstraintSetId = "end";
                    } else {
                        endConstraintSetId = "end";
                    }
                    objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ConstraintSet constraintSet11111 = (ConstraintSet) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (constraintSet != null) {
                }
                function2 = function1;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final int i2111111113 = iM10045getNonebfy_xzQ;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                        public final void invoke(Composer composer3, int i2111111114) {
                            MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i2111111113, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                        }
                    });
                    return;
                }
                return;
                scopeUpdateScopeEndRestartGroup2 = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup2 != null) {
                    scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.4
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

                        public final void invoke(Composer composer3, int i2111111114) {
                            MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier4, function5, i22, i13, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                        }
                    });
                }
            }
            i6 |= 12582912;
            if ((i5 & 256) != 0) {
                if ((100663296 & i3) == 0) {
                    if ((134217728 & i3) == 0) {
                        zChangedInstance = composerStartRestartGroup.changed(ref);
                    } else {
                        zChangedInstance = composerStartRestartGroup.changedInstance(ref);
                    }
                    if (zChangedInstance) {
                        i16 = 67108864;
                    } else {
                        i16 = 33554432;
                    }
                }
                if ((i5 & 512) != 0) {
                    if ((805306368 & i3) == 0) {
                        if (composerStartRestartGroup.changedInstance(invalidationStrategy)) {
                            i17 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i17 = 268435456;
                        }
                        i6 |= i17;
                    }
                    if ((i5 & 1024) != 0) {
                        i18 = i4 | 6;
                    } else if ((i4 & 6) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i19 = 4;
                        } else {
                            i19 = 2;
                        }
                        i18 = i4 | i19;
                    } else {
                        i18 = i4;
                    }
                    if ((i6 & 306783379) == 306783378) {
                        if (i23 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i7 != 0) {
                            function1 = null;
                        }
                        if (i9 != 0) {
                            iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                        } else {
                            iM10045getNonebfy_xzQ = i10;
                        }
                        if (i12 != 0) {
                            i13 = 257;
                        }
                        i20 = i13;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        MutableLongState mutableLongState11110 = (MutableLongState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        long longValue111111111118 = mutableLongState11110.getLongValue();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
                        i21 = i6 & 14;
                        modifier3 = companion;
                        if (i21 == 4) {
                            z = true;
                        } else {
                            z = false;
                        }
                        zChanged = z | composerStartRestartGroup.changed(longValue111111111118);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = motionScene.getTransitionInstance("default");
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = motionScene.getTransitionInstance("default");
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        transition = (Transition) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        long longValue111111111119 = mutableLongState11110.getLongValue();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
                        if (i21 == 4) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        zChanged2 = z2 | composerStartRestartGroup.changed(longValue111111111119);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged2) {
                            if (transition != null) {
                                startConstraintSetId = "start";
                            } else {
                                startConstraintSetId = "start";
                            }
                            objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            if (transition != null) {
                                startConstraintSetId = "start";
                            } else {
                                startConstraintSetId = "start";
                            }
                            objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        constraintSet = (ConstraintSet) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i2111111114 = i6;
                        long longValue1111111111110 = mutableLongState11110.getLongValue();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
                        if (i21 == 4) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        zChanged3 = composerStartRestartGroup.changed(longValue1111111111110) | z3;
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged3) {
                            if (transition != null) {
                                endConstraintSetId = "end";
                            } else {
                                endConstraintSetId = "end";
                            }
                            objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        } else {
                            if (transition != null) {
                                endConstraintSetId = "end";
                            } else {
                                endConstraintSetId = "end";
                            }
                            objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        ConstraintSet constraintSet11112 = (ConstraintSet) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (constraintSet != null) {
                        }
                        function2 = function1;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            final int i2111111115 = iM10045getNonebfy_xzQ;
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                                public final void invoke(Composer composer3, int i2111111116) {
                                    MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i2111111115, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if (i23 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i7 != 0) {
                        function1 = null;
                    }
                    if (i9 != 0) {
                        iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                    } else {
                        iM10045getNonebfy_xzQ = i10;
                    }
                    if (i12 != 0) {
                        i13 = 257;
                    }
                    i20 = i13;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    MutableLongState mutableLongState11111 = (MutableLongState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long longValue1111111111111 = mutableLongState11111.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
                    i21 = i6 & 14;
                    modifier3 = companion;
                    if (i21 == 4) {
                        z = true;
                    } else {
                        z = false;
                    }
                    zChanged = z | composerStartRestartGroup.changed(longValue1111111111111);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = motionScene.getTransitionInstance("default");
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = motionScene.getTransitionInstance("default");
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    transition = (Transition) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long longValue1111111111112 = mutableLongState11111.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
                    if (i21 == 4) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    zChanged2 = z2 | composerStartRestartGroup.changed(longValue1111111111112);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        if (transition != null) {
                            startConstraintSetId = "start";
                        } else {
                            startConstraintSetId = "start";
                        }
                        objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        if (transition != null) {
                            startConstraintSetId = "start";
                        } else {
                            startConstraintSetId = "start";
                        }
                        objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    constraintSet = (ConstraintSet) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i2111111116 = i6;
                    long longValue1111111111113 = mutableLongState11111.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
                    if (i21 == 4) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    zChanged3 = composerStartRestartGroup.changed(longValue1111111111113) | z3;
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged3) {
                        if (transition != null) {
                            endConstraintSetId = "end";
                        } else {
                            endConstraintSetId = "end";
                        }
                        objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        if (transition != null) {
                            endConstraintSetId = "end";
                        } else {
                            endConstraintSetId = "end";
                        }
                        objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ConstraintSet constraintSet11113 = (ConstraintSet) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (constraintSet != null) {
                    }
                    function2 = function1;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final int i2111111117 = iM10045getNonebfy_xzQ;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                            public final void invoke(Composer composer3, int i2111111118) {
                                MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i2111111117, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                            }
                        });
                        return;
                    }
                    return;
                    scopeUpdateScopeEndRestartGroup2 = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup2 != null) {
                        scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.4
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

                            public final void invoke(Composer composer3, int i2111111118) {
                                MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier4, function5, i22, i13, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                            }
                        });
                    }
                }
                i6 |= 805306368;
                if ((i5 & 1024) != 0) {
                    i18 = i4 | 6;
                } else if ((i4 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i19 = 4;
                    } else {
                        i19 = 2;
                    }
                    i18 = i4 | i19;
                } else {
                    i18 = i4;
                }
                if ((i6 & 306783379) == 306783378) {
                    if (i23 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i7 != 0) {
                        function1 = null;
                    }
                    if (i9 != 0) {
                        iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                    } else {
                        iM10045getNonebfy_xzQ = i10;
                    }
                    if (i12 != 0) {
                        i13 = 257;
                    }
                    i20 = i13;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    MutableLongState mutableLongState11112 = (MutableLongState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long longValue1111111111114 = mutableLongState11112.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
                    i21 = i6 & 14;
                    modifier3 = companion;
                    if (i21 == 4) {
                        z = true;
                    } else {
                        z = false;
                    }
                    zChanged = z | composerStartRestartGroup.changed(longValue1111111111114);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = motionScene.getTransitionInstance("default");
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = motionScene.getTransitionInstance("default");
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    transition = (Transition) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long longValue1111111111115 = mutableLongState11112.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
                    if (i21 == 4) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    zChanged2 = z2 | composerStartRestartGroup.changed(longValue1111111111115);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        if (transition != null) {
                            startConstraintSetId = "start";
                        } else {
                            startConstraintSetId = "start";
                        }
                        objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        if (transition != null) {
                            startConstraintSetId = "start";
                        } else {
                            startConstraintSetId = "start";
                        }
                        objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    constraintSet = (ConstraintSet) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i2111111118 = i6;
                    long longValue1111111111116 = mutableLongState11112.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
                    if (i21 == 4) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    zChanged3 = composerStartRestartGroup.changed(longValue1111111111116) | z3;
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged3) {
                        if (transition != null) {
                            endConstraintSetId = "end";
                        } else {
                            endConstraintSetId = "end";
                        }
                        objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        if (transition != null) {
                            endConstraintSetId = "end";
                        } else {
                            endConstraintSetId = "end";
                        }
                        objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ConstraintSet constraintSet11114 = (ConstraintSet) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (constraintSet != null) {
                    }
                    function2 = function1;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final int i2111111119 = iM10045getNonebfy_xzQ;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                            public final void invoke(Composer composer3, int i21111111110) {
                                MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i2111111119, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                            }
                        });
                        return;
                    }
                    return;
                }
                if (i23 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i7 != 0) {
                    function1 = null;
                }
                if (i9 != 0) {
                    iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                } else {
                    iM10045getNonebfy_xzQ = i10;
                }
                if (i12 != 0) {
                    i13 = 257;
                }
                i20 = i13;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                MutableLongState mutableLongState11113 = (MutableLongState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                long longValue1111111111117 = mutableLongState11113.getLongValue();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
                i21 = i6 & 14;
                modifier3 = companion;
                if (i21 == 4) {
                    z = true;
                } else {
                    z = false;
                }
                zChanged = z | composerStartRestartGroup.changed(longValue1111111111117);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = motionScene.getTransitionInstance("default");
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = motionScene.getTransitionInstance("default");
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                transition = (Transition) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                long longValue1111111111118 = mutableLongState11113.getLongValue();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
                if (i21 == 4) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                zChanged2 = z2 | composerStartRestartGroup.changed(longValue1111111111118);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    if (transition != null) {
                        startConstraintSetId = "start";
                    } else {
                        startConstraintSetId = "start";
                    }
                    objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    if (transition != null) {
                        startConstraintSetId = "start";
                    } else {
                        startConstraintSetId = "start";
                    }
                    objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                constraintSet = (ConstraintSet) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i21111111110 = i6;
                long longValue1111111111119 = mutableLongState11113.getLongValue();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
                if (i21 == 4) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                zChanged3 = composerStartRestartGroup.changed(longValue1111111111119) | z3;
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChanged3) {
                    if (transition != null) {
                        endConstraintSetId = "end";
                    } else {
                        endConstraintSetId = "end";
                    }
                    objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    if (transition != null) {
                        endConstraintSetId = "end";
                    } else {
                        endConstraintSetId = "end";
                    }
                    objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ConstraintSet constraintSet11115 = (ConstraintSet) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (constraintSet != null) {
                }
                function2 = function1;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final int i21111111111 = iM10045getNonebfy_xzQ;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                        public final void invoke(Composer composer3, int i21111111112) {
                            MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i21111111111, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                        }
                    });
                    return;
                }
                return;
                scopeUpdateScopeEndRestartGroup2 = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup2 != null) {
                    scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.4
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

                        public final void invoke(Composer composer3, int i21111111112) {
                            MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier4, function5, i22, i13, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                        }
                    });
                }
            }
            i16 = 100663296;
            i6 |= i16;
            if ((i5 & 512) != 0) {
                if ((805306368 & i3) == 0) {
                    if (composerStartRestartGroup.changedInstance(invalidationStrategy)) {
                        i17 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i17 = 268435456;
                    }
                    i6 |= i17;
                }
                if ((i5 & 1024) != 0) {
                    i18 = i4 | 6;
                } else if ((i4 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i19 = 4;
                    } else {
                        i19 = 2;
                    }
                    i18 = i4 | i19;
                } else {
                    i18 = i4;
                }
                if ((i6 & 306783379) == 306783378) {
                    if (i23 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i7 != 0) {
                        function1 = null;
                    }
                    if (i9 != 0) {
                        iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                    } else {
                        iM10045getNonebfy_xzQ = i10;
                    }
                    if (i12 != 0) {
                        i13 = 257;
                    }
                    i20 = i13;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    MutableLongState mutableLongState11114 = (MutableLongState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long longValue11111111111110 = mutableLongState11114.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
                    i21 = i6 & 14;
                    modifier3 = companion;
                    if (i21 == 4) {
                        z = true;
                    } else {
                        z = false;
                    }
                    zChanged = z | composerStartRestartGroup.changed(longValue11111111111110);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = motionScene.getTransitionInstance("default");
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = motionScene.getTransitionInstance("default");
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    transition = (Transition) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long longValue11111111111111 = mutableLongState11114.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
                    if (i21 == 4) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    zChanged2 = z2 | composerStartRestartGroup.changed(longValue11111111111111);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        if (transition != null) {
                            startConstraintSetId = "start";
                        } else {
                            startConstraintSetId = "start";
                        }
                        objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        if (transition != null) {
                            startConstraintSetId = "start";
                        } else {
                            startConstraintSetId = "start";
                        }
                        objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    constraintSet = (ConstraintSet) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i21111111112 = i6;
                    long longValue11111111111112 = mutableLongState11114.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
                    if (i21 == 4) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    zChanged3 = composerStartRestartGroup.changed(longValue11111111111112) | z3;
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged3) {
                        if (transition != null) {
                            endConstraintSetId = "end";
                        } else {
                            endConstraintSetId = "end";
                        }
                        objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        if (transition != null) {
                            endConstraintSetId = "end";
                        } else {
                            endConstraintSetId = "end";
                        }
                        objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ConstraintSet constraintSet11116 = (ConstraintSet) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (constraintSet != null) {
                    }
                    function2 = function1;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final int i21111111113 = iM10045getNonebfy_xzQ;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                            public final void invoke(Composer composer3, int i21111111114) {
                                MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i21111111113, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                            }
                        });
                        return;
                    }
                    return;
                }
                if (i23 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i7 != 0) {
                    function1 = null;
                }
                if (i9 != 0) {
                    iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                } else {
                    iM10045getNonebfy_xzQ = i10;
                }
                if (i12 != 0) {
                    i13 = 257;
                }
                i20 = i13;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                MutableLongState mutableLongState11115 = (MutableLongState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                long longValue11111111111113 = mutableLongState11115.getLongValue();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
                i21 = i6 & 14;
                modifier3 = companion;
                if (i21 == 4) {
                    z = true;
                } else {
                    z = false;
                }
                zChanged = z | composerStartRestartGroup.changed(longValue11111111111113);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = motionScene.getTransitionInstance("default");
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = motionScene.getTransitionInstance("default");
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                transition = (Transition) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                long longValue11111111111114 = mutableLongState11115.getLongValue();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
                if (i21 == 4) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                zChanged2 = z2 | composerStartRestartGroup.changed(longValue11111111111114);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    if (transition != null) {
                        startConstraintSetId = "start";
                    } else {
                        startConstraintSetId = "start";
                    }
                    objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    if (transition != null) {
                        startConstraintSetId = "start";
                    } else {
                        startConstraintSetId = "start";
                    }
                    objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                constraintSet = (ConstraintSet) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i21111111114 = i6;
                long longValue11111111111115 = mutableLongState11115.getLongValue();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
                if (i21 == 4) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                zChanged3 = composerStartRestartGroup.changed(longValue11111111111115) | z3;
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChanged3) {
                    if (transition != null) {
                        endConstraintSetId = "end";
                    } else {
                        endConstraintSetId = "end";
                    }
                    objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    if (transition != null) {
                        endConstraintSetId = "end";
                    } else {
                        endConstraintSetId = "end";
                    }
                    objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ConstraintSet constraintSet11117 = (ConstraintSet) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (constraintSet != null) {
                }
                function2 = function1;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final int i21111111115 = iM10045getNonebfy_xzQ;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                        public final void invoke(Composer composer3, int i21111111116) {
                            MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i21111111115, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                        }
                    });
                    return;
                }
                return;
                scopeUpdateScopeEndRestartGroup2 = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup2 != null) {
                    scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.4
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

                        public final void invoke(Composer composer3, int i21111111116) {
                            MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier4, function5, i22, i13, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                        }
                    });
                }
            }
            i6 |= 805306368;
            if ((i5 & 1024) != 0) {
                i18 = i4 | 6;
            } else if ((i4 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i19 = 4;
                } else {
                    i19 = 2;
                }
                i18 = i4 | i19;
            } else {
                i18 = i4;
            }
            if ((i6 & 306783379) == 306783378) {
                if (i23 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i7 != 0) {
                    function1 = null;
                }
                if (i9 != 0) {
                    iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                } else {
                    iM10045getNonebfy_xzQ = i10;
                }
                if (i12 != 0) {
                    i13 = 257;
                }
                i20 = i13;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                MutableLongState mutableLongState11116 = (MutableLongState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                long longValue11111111111116 = mutableLongState11116.getLongValue();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
                i21 = i6 & 14;
                modifier3 = companion;
                if (i21 == 4) {
                    z = true;
                } else {
                    z = false;
                }
                zChanged = z | composerStartRestartGroup.changed(longValue11111111111116);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = motionScene.getTransitionInstance("default");
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = motionScene.getTransitionInstance("default");
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                transition = (Transition) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                long longValue11111111111117 = mutableLongState11116.getLongValue();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
                if (i21 == 4) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                zChanged2 = z2 | composerStartRestartGroup.changed(longValue11111111111117);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    if (transition != null) {
                        startConstraintSetId = "start";
                    } else {
                        startConstraintSetId = "start";
                    }
                    objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    if (transition != null) {
                        startConstraintSetId = "start";
                    } else {
                        startConstraintSetId = "start";
                    }
                    objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                constraintSet = (ConstraintSet) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i21111111116 = i6;
                long longValue11111111111118 = mutableLongState11116.getLongValue();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
                if (i21 == 4) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                zChanged3 = composerStartRestartGroup.changed(longValue11111111111118) | z3;
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChanged3) {
                    if (transition != null) {
                        endConstraintSetId = "end";
                    } else {
                        endConstraintSetId = "end";
                    }
                    objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    if (transition != null) {
                        endConstraintSetId = "end";
                    } else {
                        endConstraintSetId = "end";
                    }
                    objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ConstraintSet constraintSet11118 = (ConstraintSet) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (constraintSet != null) {
                }
                function2 = function1;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final int i21111111117 = iM10045getNonebfy_xzQ;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                        public final void invoke(Composer composer3, int i21111111118) {
                            MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i21111111117, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                        }
                    });
                    return;
                }
                return;
            }
            if (i23 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (i7 != 0) {
                function1 = null;
            }
            if (i9 != 0) {
                iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
            } else {
                iM10045getNonebfy_xzQ = i10;
            }
            if (i12 != 0) {
                i13 = 257;
            }
            i20 = i13;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            MutableLongState mutableLongState11117 = (MutableLongState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            long longValue11111111111119 = mutableLongState11117.getLongValue();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
            i21 = i6 & 14;
            modifier3 = companion;
            if (i21 == 4) {
                z = true;
            } else {
                z = false;
            }
            zChanged = z | composerStartRestartGroup.changed(longValue11111111111119);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue2 = motionScene.getTransitionInstance("default");
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = motionScene.getTransitionInstance("default");
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            transition = (Transition) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            long longValue111111111111110 = mutableLongState11117.getLongValue();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
            if (i21 == 4) {
                z2 = true;
            } else {
                z2 = false;
            }
            zChanged2 = z2 | composerStartRestartGroup.changed(longValue111111111111110);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (!zChanged2) {
                if (transition != null) {
                    startConstraintSetId = "start";
                } else {
                    startConstraintSetId = "start";
                }
                objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                if (transition != null) {
                    startConstraintSetId = "start";
                } else {
                    startConstraintSetId = "start";
                }
                objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            constraintSet = (ConstraintSet) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i21111111118 = i6;
            long longValue111111111111111 = mutableLongState11117.getLongValue();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
            if (i21 == 4) {
                z3 = true;
            } else {
                z3 = false;
            }
            zChanged3 = composerStartRestartGroup.changed(longValue111111111111111) | z3;
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (!zChanged3) {
                if (transition != null) {
                    endConstraintSetId = "end";
                } else {
                    endConstraintSetId = "end";
                }
                objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            } else {
                if (transition != null) {
                    endConstraintSetId = "end";
                } else {
                    endConstraintSetId = "end";
                }
                objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ConstraintSet constraintSet11119 = (ConstraintSet) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (constraintSet != null) {
            }
            function2 = function1;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final int i21111111119 = iM10045getNonebfy_xzQ;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                    public final void invoke(Composer composer3, int i211111111110) {
                        MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i21111111119, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                    }
                });
                return;
            }
            return;
            scopeUpdateScopeEndRestartGroup2 = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup2 != null) {
                scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.4
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

                    public final void invoke(Composer composer3, int i211111111110) {
                        MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier4, function5, i22, i13, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                    }
                });
            }
        }
        i6 |= 24576;
        function1 = function0;
        i9 = i5 & 32;
        if (i9 != 0) {
            i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i10 = i;
        } else {
            i10 = i;
            if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(i10)) {
                    i11 = 131072;
                } else {
                    i11 = 65536;
                }
                i6 |= i11;
            }
        }
        i12 = i5 & 64;
        if (i12 != 0) {
            i6 |= 1572864;
            i13 = i2;
        } else {
            i13 = i2;
            if ((i3 & 1572864) == 0) {
                if (composerStartRestartGroup.changed(i13)) {
                    i14 = 1048576;
                } else {
                    i14 = 524288;
                }
                i6 |= i14;
            }
        }
        if ((i5 & 128) != 0) {
            if ((i3 & 12582912) == 0) {
                if (composerStartRestartGroup.changed(mutableState)) {
                    i15 = 8388608;
                } else {
                    i15 = 4194304;
                }
                i6 |= i15;
            }
            if ((i5 & 256) != 0) {
                if ((100663296 & i3) == 0) {
                    if ((134217728 & i3) == 0) {
                        zChangedInstance = composerStartRestartGroup.changed(ref);
                    } else {
                        zChangedInstance = composerStartRestartGroup.changedInstance(ref);
                    }
                    if (zChangedInstance) {
                        i16 = 67108864;
                    } else {
                        i16 = 33554432;
                    }
                }
                if ((i5 & 512) != 0) {
                    if ((805306368 & i3) == 0) {
                        if (composerStartRestartGroup.changedInstance(invalidationStrategy)) {
                            i17 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i17 = 268435456;
                        }
                        i6 |= i17;
                    }
                    if ((i5 & 1024) != 0) {
                        i18 = i4 | 6;
                    } else if ((i4 & 6) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i19 = 4;
                        } else {
                            i19 = 2;
                        }
                        i18 = i4 | i19;
                    } else {
                        i18 = i4;
                    }
                    if ((i6 & 306783379) == 306783378) {
                        if (i23 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i7 != 0) {
                            function1 = null;
                        }
                        if (i9 != 0) {
                            iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                        } else {
                            iM10045getNonebfy_xzQ = i10;
                        }
                        if (i12 != 0) {
                            i13 = 257;
                        }
                        i20 = i13;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        MutableLongState mutableLongState11118 = (MutableLongState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        long longValue111111111111112 = mutableLongState11118.getLongValue();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
                        i21 = i6 & 14;
                        modifier3 = companion;
                        if (i21 == 4) {
                            z = true;
                        } else {
                            z = false;
                        }
                        zChanged = z | composerStartRestartGroup.changed(longValue111111111111112);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = motionScene.getTransitionInstance("default");
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = motionScene.getTransitionInstance("default");
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        transition = (Transition) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        long longValue111111111111113 = mutableLongState11118.getLongValue();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
                        if (i21 == 4) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        zChanged2 = z2 | composerStartRestartGroup.changed(longValue111111111111113);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged2) {
                            if (transition != null) {
                                startConstraintSetId = "start";
                            } else {
                                startConstraintSetId = "start";
                            }
                            objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            if (transition != null) {
                                startConstraintSetId = "start";
                            } else {
                                startConstraintSetId = "start";
                            }
                            objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        constraintSet = (ConstraintSet) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i211111111110 = i6;
                        long longValue111111111111114 = mutableLongState11118.getLongValue();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
                        if (i21 == 4) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        zChanged3 = composerStartRestartGroup.changed(longValue111111111111114) | z3;
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged3) {
                            if (transition != null) {
                                endConstraintSetId = "end";
                            } else {
                                endConstraintSetId = "end";
                            }
                            objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        } else {
                            if (transition != null) {
                                endConstraintSetId = "end";
                            } else {
                                endConstraintSetId = "end";
                            }
                            objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        ConstraintSet constraintSet111110 = (ConstraintSet) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (constraintSet != null) {
                        }
                        function2 = function1;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            final int i211111111111 = iM10045getNonebfy_xzQ;
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                                public final void invoke(Composer composer3, int i211111111112) {
                                    MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i211111111111, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if (i23 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i7 != 0) {
                        function1 = null;
                    }
                    if (i9 != 0) {
                        iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                    } else {
                        iM10045getNonebfy_xzQ = i10;
                    }
                    if (i12 != 0) {
                        i13 = 257;
                    }
                    i20 = i13;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    MutableLongState mutableLongState11119 = (MutableLongState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long longValue111111111111115 = mutableLongState11119.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
                    i21 = i6 & 14;
                    modifier3 = companion;
                    if (i21 == 4) {
                        z = true;
                    } else {
                        z = false;
                    }
                    zChanged = z | composerStartRestartGroup.changed(longValue111111111111115);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = motionScene.getTransitionInstance("default");
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = motionScene.getTransitionInstance("default");
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    transition = (Transition) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long longValue111111111111116 = mutableLongState11119.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
                    if (i21 == 4) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    zChanged2 = z2 | composerStartRestartGroup.changed(longValue111111111111116);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        if (transition != null) {
                            startConstraintSetId = "start";
                        } else {
                            startConstraintSetId = "start";
                        }
                        objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        if (transition != null) {
                            startConstraintSetId = "start";
                        } else {
                            startConstraintSetId = "start";
                        }
                        objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    constraintSet = (ConstraintSet) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i211111111112 = i6;
                    long longValue111111111111117 = mutableLongState11119.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
                    if (i21 == 4) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    zChanged3 = composerStartRestartGroup.changed(longValue111111111111117) | z3;
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged3) {
                        if (transition != null) {
                            endConstraintSetId = "end";
                        } else {
                            endConstraintSetId = "end";
                        }
                        objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        if (transition != null) {
                            endConstraintSetId = "end";
                        } else {
                            endConstraintSetId = "end";
                        }
                        objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ConstraintSet constraintSet111111 = (ConstraintSet) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (constraintSet != null) {
                    }
                    function2 = function1;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final int i211111111113 = iM10045getNonebfy_xzQ;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                            public final void invoke(Composer composer3, int i211111111114) {
                                MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i211111111113, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                            }
                        });
                        return;
                    }
                    return;
                    scopeUpdateScopeEndRestartGroup2 = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup2 != null) {
                        scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.4
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

                            public final void invoke(Composer composer3, int i211111111114) {
                                MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier4, function5, i22, i13, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                            }
                        });
                    }
                }
                i6 |= 805306368;
                if ((i5 & 1024) != 0) {
                    i18 = i4 | 6;
                } else if ((i4 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i19 = 4;
                    } else {
                        i19 = 2;
                    }
                    i18 = i4 | i19;
                } else {
                    i18 = i4;
                }
                if ((i6 & 306783379) == 306783378) {
                    if (i23 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i7 != 0) {
                        function1 = null;
                    }
                    if (i9 != 0) {
                        iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                    } else {
                        iM10045getNonebfy_xzQ = i10;
                    }
                    if (i12 != 0) {
                        i13 = 257;
                    }
                    i20 = i13;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    MutableLongState mutableLongState111110 = (MutableLongState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long longValue111111111111118 = mutableLongState111110.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
                    i21 = i6 & 14;
                    modifier3 = companion;
                    if (i21 == 4) {
                        z = true;
                    } else {
                        z = false;
                    }
                    zChanged = z | composerStartRestartGroup.changed(longValue111111111111118);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = motionScene.getTransitionInstance("default");
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = motionScene.getTransitionInstance("default");
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    transition = (Transition) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long longValue111111111111119 = mutableLongState111110.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
                    if (i21 == 4) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    zChanged2 = z2 | composerStartRestartGroup.changed(longValue111111111111119);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        if (transition != null) {
                            startConstraintSetId = "start";
                        } else {
                            startConstraintSetId = "start";
                        }
                        objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        if (transition != null) {
                            startConstraintSetId = "start";
                        } else {
                            startConstraintSetId = "start";
                        }
                        objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    constraintSet = (ConstraintSet) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i211111111114 = i6;
                    long longValue1111111111111110 = mutableLongState111110.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
                    if (i21 == 4) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    zChanged3 = composerStartRestartGroup.changed(longValue1111111111111110) | z3;
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged3) {
                        if (transition != null) {
                            endConstraintSetId = "end";
                        } else {
                            endConstraintSetId = "end";
                        }
                        objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        if (transition != null) {
                            endConstraintSetId = "end";
                        } else {
                            endConstraintSetId = "end";
                        }
                        objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ConstraintSet constraintSet111112 = (ConstraintSet) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (constraintSet != null) {
                    }
                    function2 = function1;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final int i211111111115 = iM10045getNonebfy_xzQ;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                            public final void invoke(Composer composer3, int i211111111116) {
                                MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i211111111115, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                            }
                        });
                        return;
                    }
                    return;
                }
                if (i23 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i7 != 0) {
                    function1 = null;
                }
                if (i9 != 0) {
                    iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                } else {
                    iM10045getNonebfy_xzQ = i10;
                }
                if (i12 != 0) {
                    i13 = 257;
                }
                i20 = i13;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                MutableLongState mutableLongState111111 = (MutableLongState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                long longValue1111111111111111 = mutableLongState111111.getLongValue();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
                i21 = i6 & 14;
                modifier3 = companion;
                if (i21 == 4) {
                    z = true;
                } else {
                    z = false;
                }
                zChanged = z | composerStartRestartGroup.changed(longValue1111111111111111);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = motionScene.getTransitionInstance("default");
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = motionScene.getTransitionInstance("default");
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                transition = (Transition) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                long longValue1111111111111112 = mutableLongState111111.getLongValue();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
                if (i21 == 4) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                zChanged2 = z2 | composerStartRestartGroup.changed(longValue1111111111111112);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    if (transition != null) {
                        startConstraintSetId = "start";
                    } else {
                        startConstraintSetId = "start";
                    }
                    objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    if (transition != null) {
                        startConstraintSetId = "start";
                    } else {
                        startConstraintSetId = "start";
                    }
                    objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                constraintSet = (ConstraintSet) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i211111111116 = i6;
                long longValue1111111111111113 = mutableLongState111111.getLongValue();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
                if (i21 == 4) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                zChanged3 = composerStartRestartGroup.changed(longValue1111111111111113) | z3;
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChanged3) {
                    if (transition != null) {
                        endConstraintSetId = "end";
                    } else {
                        endConstraintSetId = "end";
                    }
                    objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    if (transition != null) {
                        endConstraintSetId = "end";
                    } else {
                        endConstraintSetId = "end";
                    }
                    objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ConstraintSet constraintSet111113 = (ConstraintSet) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (constraintSet != null) {
                }
                function2 = function1;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final int i211111111117 = iM10045getNonebfy_xzQ;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                        public final void invoke(Composer composer3, int i211111111118) {
                            MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i211111111117, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                        }
                    });
                    return;
                }
                return;
                scopeUpdateScopeEndRestartGroup2 = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup2 != null) {
                    scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.4
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

                        public final void invoke(Composer composer3, int i211111111118) {
                            MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier4, function5, i22, i13, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                        }
                    });
                }
            }
            i16 = 100663296;
            i6 |= i16;
            if ((i5 & 512) != 0) {
                if ((805306368 & i3) == 0) {
                    if (composerStartRestartGroup.changedInstance(invalidationStrategy)) {
                        i17 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i17 = 268435456;
                    }
                    i6 |= i17;
                }
                if ((i5 & 1024) != 0) {
                    i18 = i4 | 6;
                } else if ((i4 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i19 = 4;
                    } else {
                        i19 = 2;
                    }
                    i18 = i4 | i19;
                } else {
                    i18 = i4;
                }
                if ((i6 & 306783379) == 306783378) {
                    if (i23 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i7 != 0) {
                        function1 = null;
                    }
                    if (i9 != 0) {
                        iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                    } else {
                        iM10045getNonebfy_xzQ = i10;
                    }
                    if (i12 != 0) {
                        i13 = 257;
                    }
                    i20 = i13;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    MutableLongState mutableLongState111112 = (MutableLongState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long longValue1111111111111114 = mutableLongState111112.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
                    i21 = i6 & 14;
                    modifier3 = companion;
                    if (i21 == 4) {
                        z = true;
                    } else {
                        z = false;
                    }
                    zChanged = z | composerStartRestartGroup.changed(longValue1111111111111114);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = motionScene.getTransitionInstance("default");
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = motionScene.getTransitionInstance("default");
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    transition = (Transition) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long longValue1111111111111115 = mutableLongState111112.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
                    if (i21 == 4) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    zChanged2 = z2 | composerStartRestartGroup.changed(longValue1111111111111115);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        if (transition != null) {
                            startConstraintSetId = "start";
                        } else {
                            startConstraintSetId = "start";
                        }
                        objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        if (transition != null) {
                            startConstraintSetId = "start";
                        } else {
                            startConstraintSetId = "start";
                        }
                        objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    constraintSet = (ConstraintSet) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i211111111118 = i6;
                    long longValue1111111111111116 = mutableLongState111112.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
                    if (i21 == 4) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    zChanged3 = composerStartRestartGroup.changed(longValue1111111111111116) | z3;
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged3) {
                        if (transition != null) {
                            endConstraintSetId = "end";
                        } else {
                            endConstraintSetId = "end";
                        }
                        objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        if (transition != null) {
                            endConstraintSetId = "end";
                        } else {
                            endConstraintSetId = "end";
                        }
                        objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ConstraintSet constraintSet111114 = (ConstraintSet) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (constraintSet != null) {
                    }
                    function2 = function1;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final int i211111111119 = iM10045getNonebfy_xzQ;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                            public final void invoke(Composer composer3, int i2111111111110) {
                                MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i211111111119, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                            }
                        });
                        return;
                    }
                    return;
                }
                if (i23 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i7 != 0) {
                    function1 = null;
                }
                if (i9 != 0) {
                    iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                } else {
                    iM10045getNonebfy_xzQ = i10;
                }
                if (i12 != 0) {
                    i13 = 257;
                }
                i20 = i13;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                MutableLongState mutableLongState111113 = (MutableLongState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                long longValue1111111111111117 = mutableLongState111113.getLongValue();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
                i21 = i6 & 14;
                modifier3 = companion;
                if (i21 == 4) {
                    z = true;
                } else {
                    z = false;
                }
                zChanged = z | composerStartRestartGroup.changed(longValue1111111111111117);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = motionScene.getTransitionInstance("default");
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = motionScene.getTransitionInstance("default");
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                transition = (Transition) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                long longValue1111111111111118 = mutableLongState111113.getLongValue();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
                if (i21 == 4) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                zChanged2 = z2 | composerStartRestartGroup.changed(longValue1111111111111118);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    if (transition != null) {
                        startConstraintSetId = "start";
                    } else {
                        startConstraintSetId = "start";
                    }
                    objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    if (transition != null) {
                        startConstraintSetId = "start";
                    } else {
                        startConstraintSetId = "start";
                    }
                    objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                constraintSet = (ConstraintSet) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i2111111111110 = i6;
                long longValue1111111111111119 = mutableLongState111113.getLongValue();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
                if (i21 == 4) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                zChanged3 = composerStartRestartGroup.changed(longValue1111111111111119) | z3;
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChanged3) {
                    if (transition != null) {
                        endConstraintSetId = "end";
                    } else {
                        endConstraintSetId = "end";
                    }
                    objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    if (transition != null) {
                        endConstraintSetId = "end";
                    } else {
                        endConstraintSetId = "end";
                    }
                    objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ConstraintSet constraintSet111115 = (ConstraintSet) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (constraintSet != null) {
                }
                function2 = function1;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final int i2111111111111 = iM10045getNonebfy_xzQ;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                        public final void invoke(Composer composer3, int i2111111111112) {
                            MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i2111111111111, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                        }
                    });
                    return;
                }
                return;
                scopeUpdateScopeEndRestartGroup2 = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup2 != null) {
                    scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.4
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

                        public final void invoke(Composer composer3, int i2111111111112) {
                            MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier4, function5, i22, i13, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                        }
                    });
                }
            }
            i6 |= 805306368;
            if ((i5 & 1024) != 0) {
                i18 = i4 | 6;
            } else if ((i4 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i19 = 4;
                } else {
                    i19 = 2;
                }
                i18 = i4 | i19;
            } else {
                i18 = i4;
            }
            if ((i6 & 306783379) == 306783378) {
                if (i23 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i7 != 0) {
                    function1 = null;
                }
                if (i9 != 0) {
                    iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                } else {
                    iM10045getNonebfy_xzQ = i10;
                }
                if (i12 != 0) {
                    i13 = 257;
                }
                i20 = i13;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                MutableLongState mutableLongState111114 = (MutableLongState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                long longValue11111111111111110 = mutableLongState111114.getLongValue();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
                i21 = i6 & 14;
                modifier3 = companion;
                if (i21 == 4) {
                    z = true;
                } else {
                    z = false;
                }
                zChanged = z | composerStartRestartGroup.changed(longValue11111111111111110);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = motionScene.getTransitionInstance("default");
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = motionScene.getTransitionInstance("default");
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                transition = (Transition) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                long longValue11111111111111111 = mutableLongState111114.getLongValue();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
                if (i21 == 4) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                zChanged2 = z2 | composerStartRestartGroup.changed(longValue11111111111111111);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    if (transition != null) {
                        startConstraintSetId = "start";
                    } else {
                        startConstraintSetId = "start";
                    }
                    objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    if (transition != null) {
                        startConstraintSetId = "start";
                    } else {
                        startConstraintSetId = "start";
                    }
                    objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                constraintSet = (ConstraintSet) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i2111111111112 = i6;
                long longValue11111111111111112 = mutableLongState111114.getLongValue();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
                if (i21 == 4) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                zChanged3 = composerStartRestartGroup.changed(longValue11111111111111112) | z3;
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChanged3) {
                    if (transition != null) {
                        endConstraintSetId = "end";
                    } else {
                        endConstraintSetId = "end";
                    }
                    objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    if (transition != null) {
                        endConstraintSetId = "end";
                    } else {
                        endConstraintSetId = "end";
                    }
                    objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ConstraintSet constraintSet111116 = (ConstraintSet) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (constraintSet != null) {
                }
                function2 = function1;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final int i2111111111113 = iM10045getNonebfy_xzQ;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                        public final void invoke(Composer composer3, int i2111111111114) {
                            MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i2111111111113, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                        }
                    });
                    return;
                }
                return;
            }
            if (i23 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (i7 != 0) {
                function1 = null;
            }
            if (i9 != 0) {
                iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
            } else {
                iM10045getNonebfy_xzQ = i10;
            }
            if (i12 != 0) {
                i13 = 257;
            }
            i20 = i13;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            MutableLongState mutableLongState111115 = (MutableLongState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            long longValue11111111111111113 = mutableLongState111115.getLongValue();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
            i21 = i6 & 14;
            modifier3 = companion;
            if (i21 == 4) {
                z = true;
            } else {
                z = false;
            }
            zChanged = z | composerStartRestartGroup.changed(longValue11111111111111113);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue2 = motionScene.getTransitionInstance("default");
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = motionScene.getTransitionInstance("default");
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            transition = (Transition) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            long longValue11111111111111114 = mutableLongState111115.getLongValue();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
            if (i21 == 4) {
                z2 = true;
            } else {
                z2 = false;
            }
            zChanged2 = z2 | composerStartRestartGroup.changed(longValue11111111111111114);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (!zChanged2) {
                if (transition != null) {
                    startConstraintSetId = "start";
                } else {
                    startConstraintSetId = "start";
                }
                objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                if (transition != null) {
                    startConstraintSetId = "start";
                } else {
                    startConstraintSetId = "start";
                }
                objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            constraintSet = (ConstraintSet) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i2111111111114 = i6;
            long longValue11111111111111115 = mutableLongState111115.getLongValue();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
            if (i21 == 4) {
                z3 = true;
            } else {
                z3 = false;
            }
            zChanged3 = composerStartRestartGroup.changed(longValue11111111111111115) | z3;
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (!zChanged3) {
                if (transition != null) {
                    endConstraintSetId = "end";
                } else {
                    endConstraintSetId = "end";
                }
                objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            } else {
                if (transition != null) {
                    endConstraintSetId = "end";
                } else {
                    endConstraintSetId = "end";
                }
                objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ConstraintSet constraintSet111117 = (ConstraintSet) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (constraintSet != null) {
            }
            function2 = function1;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final int i2111111111115 = iM10045getNonebfy_xzQ;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                    public final void invoke(Composer composer3, int i2111111111116) {
                        MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i2111111111115, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                    }
                });
                return;
            }
            return;
            scopeUpdateScopeEndRestartGroup2 = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup2 != null) {
                scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.4
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

                    public final void invoke(Composer composer3, int i2111111111116) {
                        MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier4, function5, i22, i13, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                    }
                });
            }
        }
        i6 |= 12582912;
        if ((i5 & 256) != 0) {
            if ((100663296 & i3) == 0) {
                if ((134217728 & i3) == 0) {
                    zChangedInstance = composerStartRestartGroup.changed(ref);
                } else {
                    zChangedInstance = composerStartRestartGroup.changedInstance(ref);
                }
                if (zChangedInstance) {
                    i16 = 67108864;
                } else {
                    i16 = 33554432;
                }
            }
            if ((i5 & 512) != 0) {
                if ((805306368 & i3) == 0) {
                    if (composerStartRestartGroup.changedInstance(invalidationStrategy)) {
                        i17 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i17 = 268435456;
                    }
                    i6 |= i17;
                }
                if ((i5 & 1024) != 0) {
                    i18 = i4 | 6;
                } else if ((i4 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i19 = 4;
                    } else {
                        i19 = 2;
                    }
                    i18 = i4 | i19;
                } else {
                    i18 = i4;
                }
                if ((i6 & 306783379) == 306783378) {
                    if (i23 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i7 != 0) {
                        function1 = null;
                    }
                    if (i9 != 0) {
                        iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                    } else {
                        iM10045getNonebfy_xzQ = i10;
                    }
                    if (i12 != 0) {
                        i13 = 257;
                    }
                    i20 = i13;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    MutableLongState mutableLongState111116 = (MutableLongState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long longValue11111111111111116 = mutableLongState111116.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
                    i21 = i6 & 14;
                    modifier3 = companion;
                    if (i21 == 4) {
                        z = true;
                    } else {
                        z = false;
                    }
                    zChanged = z | composerStartRestartGroup.changed(longValue11111111111111116);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = motionScene.getTransitionInstance("default");
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = motionScene.getTransitionInstance("default");
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    transition = (Transition) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long longValue11111111111111117 = mutableLongState111116.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
                    if (i21 == 4) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    zChanged2 = z2 | composerStartRestartGroup.changed(longValue11111111111111117);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        if (transition != null) {
                            startConstraintSetId = "start";
                        } else {
                            startConstraintSetId = "start";
                        }
                        objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        if (transition != null) {
                            startConstraintSetId = "start";
                        } else {
                            startConstraintSetId = "start";
                        }
                        objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    constraintSet = (ConstraintSet) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i2111111111116 = i6;
                    long longValue11111111111111118 = mutableLongState111116.getLongValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
                    if (i21 == 4) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    zChanged3 = composerStartRestartGroup.changed(longValue11111111111111118) | z3;
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged3) {
                        if (transition != null) {
                            endConstraintSetId = "end";
                        } else {
                            endConstraintSetId = "end";
                        }
                        objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        if (transition != null) {
                            endConstraintSetId = "end";
                        } else {
                            endConstraintSetId = "end";
                        }
                        objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ConstraintSet constraintSet111118 = (ConstraintSet) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (constraintSet != null) {
                    }
                    function2 = function1;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final int i2111111111117 = iM10045getNonebfy_xzQ;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                            public final void invoke(Composer composer3, int i2111111111118) {
                                MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i2111111111117, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                            }
                        });
                        return;
                    }
                    return;
                }
                if (i23 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i7 != 0) {
                    function1 = null;
                }
                if (i9 != 0) {
                    iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                } else {
                    iM10045getNonebfy_xzQ = i10;
                }
                if (i12 != 0) {
                    i13 = 257;
                }
                i20 = i13;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                MutableLongState mutableLongState111117 = (MutableLongState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                long longValue11111111111111119 = mutableLongState111117.getLongValue();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
                i21 = i6 & 14;
                modifier3 = companion;
                if (i21 == 4) {
                    z = true;
                } else {
                    z = false;
                }
                zChanged = z | composerStartRestartGroup.changed(longValue11111111111111119);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = motionScene.getTransitionInstance("default");
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = motionScene.getTransitionInstance("default");
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                transition = (Transition) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                long longValue111111111111111110 = mutableLongState111117.getLongValue();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
                if (i21 == 4) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                zChanged2 = z2 | composerStartRestartGroup.changed(longValue111111111111111110);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    if (transition != null) {
                        startConstraintSetId = "start";
                    } else {
                        startConstraintSetId = "start";
                    }
                    objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    if (transition != null) {
                        startConstraintSetId = "start";
                    } else {
                        startConstraintSetId = "start";
                    }
                    objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                constraintSet = (ConstraintSet) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i2111111111118 = i6;
                long longValue111111111111111111 = mutableLongState111117.getLongValue();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
                if (i21 == 4) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                zChanged3 = composerStartRestartGroup.changed(longValue111111111111111111) | z3;
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChanged3) {
                    if (transition != null) {
                        endConstraintSetId = "end";
                    } else {
                        endConstraintSetId = "end";
                    }
                    objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    if (transition != null) {
                        endConstraintSetId = "end";
                    } else {
                        endConstraintSetId = "end";
                    }
                    objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ConstraintSet constraintSet111119 = (ConstraintSet) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (constraintSet != null) {
                }
                function2 = function1;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final int i2111111111119 = iM10045getNonebfy_xzQ;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                        public final void invoke(Composer composer3, int i21111111111110) {
                            MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i2111111111119, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                        }
                    });
                    return;
                }
                return;
                scopeUpdateScopeEndRestartGroup2 = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup2 != null) {
                    scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.4
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

                        public final void invoke(Composer composer3, int i21111111111110) {
                            MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier4, function5, i22, i13, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                        }
                    });
                }
            }
            i6 |= 805306368;
            if ((i5 & 1024) != 0) {
                i18 = i4 | 6;
            } else if ((i4 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i19 = 4;
                } else {
                    i19 = 2;
                }
                i18 = i4 | i19;
            } else {
                i18 = i4;
            }
            if ((i6 & 306783379) == 306783378) {
                if (i23 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i7 != 0) {
                    function1 = null;
                }
                if (i9 != 0) {
                    iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                } else {
                    iM10045getNonebfy_xzQ = i10;
                }
                if (i12 != 0) {
                    i13 = 257;
                }
                i20 = i13;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                MutableLongState mutableLongState111118 = (MutableLongState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                long longValue111111111111111112 = mutableLongState111118.getLongValue();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
                i21 = i6 & 14;
                modifier3 = companion;
                if (i21 == 4) {
                    z = true;
                } else {
                    z = false;
                }
                zChanged = z | composerStartRestartGroup.changed(longValue111111111111111112);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = motionScene.getTransitionInstance("default");
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = motionScene.getTransitionInstance("default");
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                transition = (Transition) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                long longValue111111111111111113 = mutableLongState111118.getLongValue();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
                if (i21 == 4) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                zChanged2 = z2 | composerStartRestartGroup.changed(longValue111111111111111113);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    if (transition != null) {
                        startConstraintSetId = "start";
                    } else {
                        startConstraintSetId = "start";
                    }
                    objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    if (transition != null) {
                        startConstraintSetId = "start";
                    } else {
                        startConstraintSetId = "start";
                    }
                    objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                constraintSet = (ConstraintSet) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i21111111111110 = i6;
                long longValue111111111111111114 = mutableLongState111118.getLongValue();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
                if (i21 == 4) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                zChanged3 = composerStartRestartGroup.changed(longValue111111111111111114) | z3;
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChanged3) {
                    if (transition != null) {
                        endConstraintSetId = "end";
                    } else {
                        endConstraintSetId = "end";
                    }
                    objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    if (transition != null) {
                        endConstraintSetId = "end";
                    } else {
                        endConstraintSetId = "end";
                    }
                    objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ConstraintSet constraintSet1111110 = (ConstraintSet) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (constraintSet != null) {
                }
                function2 = function1;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final int i21111111111111 = iM10045getNonebfy_xzQ;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                        public final void invoke(Composer composer3, int i21111111111112) {
                            MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i21111111111111, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                        }
                    });
                    return;
                }
                return;
            }
            if (i23 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (i7 != 0) {
                function1 = null;
            }
            if (i9 != 0) {
                iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
            } else {
                iM10045getNonebfy_xzQ = i10;
            }
            if (i12 != 0) {
                i13 = 257;
            }
            i20 = i13;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            MutableLongState mutableLongState111119 = (MutableLongState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            long longValue111111111111111115 = mutableLongState111119.getLongValue();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
            i21 = i6 & 14;
            modifier3 = companion;
            if (i21 == 4) {
                z = true;
            } else {
                z = false;
            }
            zChanged = z | composerStartRestartGroup.changed(longValue111111111111111115);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue2 = motionScene.getTransitionInstance("default");
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = motionScene.getTransitionInstance("default");
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            transition = (Transition) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            long longValue111111111111111116 = mutableLongState111119.getLongValue();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
            if (i21 == 4) {
                z2 = true;
            } else {
                z2 = false;
            }
            zChanged2 = z2 | composerStartRestartGroup.changed(longValue111111111111111116);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (!zChanged2) {
                if (transition != null) {
                    startConstraintSetId = "start";
                } else {
                    startConstraintSetId = "start";
                }
                objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                if (transition != null) {
                    startConstraintSetId = "start";
                } else {
                    startConstraintSetId = "start";
                }
                objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            constraintSet = (ConstraintSet) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i21111111111112 = i6;
            long longValue111111111111111117 = mutableLongState111119.getLongValue();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
            if (i21 == 4) {
                z3 = true;
            } else {
                z3 = false;
            }
            zChanged3 = composerStartRestartGroup.changed(longValue111111111111111117) | z3;
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (!zChanged3) {
                if (transition != null) {
                    endConstraintSetId = "end";
                } else {
                    endConstraintSetId = "end";
                }
                objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            } else {
                if (transition != null) {
                    endConstraintSetId = "end";
                } else {
                    endConstraintSetId = "end";
                }
                objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ConstraintSet constraintSet1111111 = (ConstraintSet) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (constraintSet != null) {
            }
            function2 = function1;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final int i21111111111113 = iM10045getNonebfy_xzQ;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                    public final void invoke(Composer composer3, int i21111111111114) {
                        MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i21111111111113, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                    }
                });
                return;
            }
            return;
            scopeUpdateScopeEndRestartGroup2 = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup2 != null) {
                scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.4
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

                    public final void invoke(Composer composer3, int i21111111111114) {
                        MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier4, function5, i22, i13, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                    }
                });
            }
        }
        i16 = 100663296;
        i6 |= i16;
        if ((i5 & 512) != 0) {
            if ((805306368 & i3) == 0) {
                if (composerStartRestartGroup.changedInstance(invalidationStrategy)) {
                    i17 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i17 = 268435456;
                }
                i6 |= i17;
            }
            if ((i5 & 1024) != 0) {
                i18 = i4 | 6;
            } else if ((i4 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i19 = 4;
                } else {
                    i19 = 2;
                }
                i18 = i4 | i19;
            } else {
                i18 = i4;
            }
            if ((i6 & 306783379) == 306783378) {
                if (i23 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i7 != 0) {
                    function1 = null;
                }
                if (i9 != 0) {
                    iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
                } else {
                    iM10045getNonebfy_xzQ = i10;
                }
                if (i12 != 0) {
                    i13 = 257;
                }
                i20 = i13;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                MutableLongState mutableLongState1111110 = (MutableLongState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                long longValue111111111111111118 = mutableLongState1111110.getLongValue();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
                i21 = i6 & 14;
                modifier3 = companion;
                if (i21 == 4) {
                    z = true;
                } else {
                    z = false;
                }
                zChanged = z | composerStartRestartGroup.changed(longValue111111111111111118);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = motionScene.getTransitionInstance("default");
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = motionScene.getTransitionInstance("default");
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                transition = (Transition) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                long longValue111111111111111119 = mutableLongState1111110.getLongValue();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
                if (i21 == 4) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                zChanged2 = z2 | composerStartRestartGroup.changed(longValue111111111111111119);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    if (transition != null) {
                        startConstraintSetId = "start";
                    } else {
                        startConstraintSetId = "start";
                    }
                    objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    if (transition != null) {
                        startConstraintSetId = "start";
                    } else {
                        startConstraintSetId = "start";
                    }
                    objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                constraintSet = (ConstraintSet) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i21111111111114 = i6;
                long longValue1111111111111111110 = mutableLongState1111110.getLongValue();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
                if (i21 == 4) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                zChanged3 = composerStartRestartGroup.changed(longValue1111111111111111110) | z3;
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChanged3) {
                    if (transition != null) {
                        endConstraintSetId = "end";
                    } else {
                        endConstraintSetId = "end";
                    }
                    objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    if (transition != null) {
                        endConstraintSetId = "end";
                    } else {
                        endConstraintSetId = "end";
                    }
                    objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ConstraintSet constraintSet1111112 = (ConstraintSet) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (constraintSet != null) {
                }
                function2 = function1;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final int i21111111111115 = iM10045getNonebfy_xzQ;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                        public final void invoke(Composer composer3, int i21111111111116) {
                            MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i21111111111115, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                        }
                    });
                    return;
                }
                return;
            }
            if (i23 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (i7 != 0) {
                function1 = null;
            }
            if (i9 != 0) {
                iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
            } else {
                iM10045getNonebfy_xzQ = i10;
            }
            if (i12 != 0) {
                i13 = 257;
            }
            i20 = i13;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            MutableLongState mutableLongState1111111 = (MutableLongState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            long longValue1111111111111111111 = mutableLongState1111111.getLongValue();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
            i21 = i6 & 14;
            modifier3 = companion;
            if (i21 == 4) {
                z = true;
            } else {
                z = false;
            }
            zChanged = z | composerStartRestartGroup.changed(longValue1111111111111111111);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue2 = motionScene.getTransitionInstance("default");
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = motionScene.getTransitionInstance("default");
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            transition = (Transition) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            long longValue1111111111111111112 = mutableLongState1111111.getLongValue();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
            if (i21 == 4) {
                z2 = true;
            } else {
                z2 = false;
            }
            zChanged2 = z2 | composerStartRestartGroup.changed(longValue1111111111111111112);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (!zChanged2) {
                if (transition != null) {
                    startConstraintSetId = "start";
                } else {
                    startConstraintSetId = "start";
                }
                objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                if (transition != null) {
                    startConstraintSetId = "start";
                } else {
                    startConstraintSetId = "start";
                }
                objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            constraintSet = (ConstraintSet) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i21111111111116 = i6;
            long longValue1111111111111111113 = mutableLongState1111111.getLongValue();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
            if (i21 == 4) {
                z3 = true;
            } else {
                z3 = false;
            }
            zChanged3 = composerStartRestartGroup.changed(longValue1111111111111111113) | z3;
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (!zChanged3) {
                if (transition != null) {
                    endConstraintSetId = "end";
                } else {
                    endConstraintSetId = "end";
                }
                objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            } else {
                if (transition != null) {
                    endConstraintSetId = "end";
                } else {
                    endConstraintSetId = "end";
                }
                objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ConstraintSet constraintSet1111113 = (ConstraintSet) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (constraintSet != null) {
            }
            function2 = function1;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final int i21111111111117 = iM10045getNonebfy_xzQ;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                    public final void invoke(Composer composer3, int i21111111111118) {
                        MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i21111111111117, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                    }
                });
                return;
            }
            return;
            scopeUpdateScopeEndRestartGroup2 = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup2 != null) {
                scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.4
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

                    public final void invoke(Composer composer3, int i21111111111118) {
                        MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier4, function5, i22, i13, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                    }
                });
            }
        }
        i6 |= 805306368;
        if ((i5 & 1024) != 0) {
            i18 = i4 | 6;
        } else if ((i4 & 6) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i19 = 4;
            } else {
                i19 = 2;
            }
            i18 = i4 | i19;
        } else {
            i18 = i4;
        }
        if ((i6 & 306783379) == 306783378) {
            if (i23 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (i7 != 0) {
                function1 = null;
            }
            if (i9 != 0) {
                iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
            } else {
                iM10045getNonebfy_xzQ = i10;
            }
            if (i12 != 0) {
                i13 = 257;
            }
            i20 = i13;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            MutableLongState mutableLongState1111112 = (MutableLongState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            long longValue1111111111111111114 = mutableLongState1111112.getLongValue();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
            i21 = i6 & 14;
            modifier3 = companion;
            if (i21 == 4) {
                z = true;
            } else {
                z = false;
            }
            zChanged = z | composerStartRestartGroup.changed(longValue1111111111111111114);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue2 = motionScene.getTransitionInstance("default");
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = motionScene.getTransitionInstance("default");
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            transition = (Transition) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            long longValue1111111111111111115 = mutableLongState1111112.getLongValue();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
            if (i21 == 4) {
                z2 = true;
            } else {
                z2 = false;
            }
            zChanged2 = z2 | composerStartRestartGroup.changed(longValue1111111111111111115);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (!zChanged2) {
                if (transition != null) {
                    startConstraintSetId = "start";
                } else {
                    startConstraintSetId = "start";
                }
                objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                if (transition != null) {
                    startConstraintSetId = "start";
                } else {
                    startConstraintSetId = "start";
                }
                objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            constraintSet = (ConstraintSet) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i21111111111118 = i6;
            long longValue1111111111111111116 = mutableLongState1111112.getLongValue();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
            if (i21 == 4) {
                z3 = true;
            } else {
                z3 = false;
            }
            zChanged3 = composerStartRestartGroup.changed(longValue1111111111111111116) | z3;
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (!zChanged3) {
                if (transition != null) {
                    endConstraintSetId = "end";
                } else {
                    endConstraintSetId = "end";
                }
                objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            } else {
                if (transition != null) {
                    endConstraintSetId = "end";
                } else {
                    endConstraintSetId = "end";
                }
                objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ConstraintSet constraintSet1111114 = (ConstraintSet) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (constraintSet != null) {
            }
            function2 = function1;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final int i21111111111119 = iM10045getNonebfy_xzQ;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                    public final void invoke(Composer composer3, int i211111111111110) {
                        MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i21111111111119, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                    }
                });
                return;
            }
            return;
        }
        if (i23 != 0) {
            companion = Modifier.INSTANCE;
        } else {
            companion = modifier2;
        }
        if (i7 != 0) {
            function1 = null;
        }
        if (i9 != 0) {
            iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
        } else {
            iM10045getNonebfy_xzQ = i10;
        }
        if (i12 != 0) {
            i13 = 257;
        }
        i20 = i13;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1132252061, i6, i18, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:431)");
        }
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488062496, "CC(remember):MotionLayout.kt#9igjgp");
        objRememberedValue = composerStartRestartGroup.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
        }
        MutableLongState mutableLongState1111113 = (MutableLongState) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        long longValue1111111111111111117 = mutableLongState1111113.getLongValue();
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488060306, "CC(remember):MotionLayout.kt#9igjgp");
        i21 = i6 & 14;
        modifier3 = companion;
        if (i21 == 4) {
            z = true;
        } else {
            z = false;
        }
        zChanged = z | composerStartRestartGroup.changed(longValue1111111111111111117);
        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
        if (!zChanged) {
            objRememberedValue2 = motionScene.getTransitionInstance("default");
            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
        } else {
            objRememberedValue2 = motionScene.getTransitionInstance("default");
            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
        }
        transition = (Transition) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        long longValue1111111111111111118 = mutableLongState1111113.getLongValue();
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488055558, "CC(remember):MotionLayout.kt#9igjgp");
        if (i21 == 4) {
            z2 = true;
        } else {
            z2 = false;
        }
        zChanged2 = z2 | composerStartRestartGroup.changed(longValue1111111111111111118);
        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
        if (!zChanged2) {
            if (transition != null) {
                startConstraintSetId = "start";
            } else {
                startConstraintSetId = "start";
            }
            objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
        } else {
            if (transition != null) {
                startConstraintSetId = "start";
            } else {
                startConstraintSetId = "start";
            }
            objRememberedValue3 = motionScene.getConstraintSetInstance(startConstraintSetId);
            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
        }
        constraintSet = (ConstraintSet) objRememberedValue3;
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        int i211111111111110 = i6;
        long longValue1111111111111111119 = mutableLongState1111113.getLongValue();
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488048558, "CC(remember):MotionLayout.kt#9igjgp");
        if (i21 == 4) {
            z3 = true;
        } else {
            z3 = false;
        }
        zChanged3 = composerStartRestartGroup.changed(longValue1111111111111111119) | z3;
        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
        if (!zChanged3) {
            if (transition != null) {
                endConstraintSetId = "end";
            } else {
                endConstraintSetId = "end";
            }
            objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
        } else {
            if (transition != null) {
                endConstraintSetId = "end";
            } else {
                endConstraintSetId = "end";
            }
            objRememberedValue4 = motionScene.getConstraintSetInstance(endConstraintSetId);
            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
        }
        ConstraintSet constraintSet1111115 = (ConstraintSet) objRememberedValue4;
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        if (constraintSet != null) {
        }
        function2 = function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final int i211111111111111 = iM10045getNonebfy_xzQ;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.1
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

                public final void invoke(Composer composer3, int i211111111111112) {
                    MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier3, function2, i211111111111111, i20, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                }
            });
            return;
        }
        return;
        scopeUpdateScopeEndRestartGroup2 = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup2 != null) {
            scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.4
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

                public final void invoke(Composer composer3, int i211111111111112) {
                    MotionLayoutKt.m10105MotionLayoutCoreTEds9UA(motionScene, str, animationSpec, modifier4, function5, i22, i13, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConstraintSet MotionLayoutCore_TEds9UA$lambda$14(MutableState<ConstraintSet> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConstraintSet MotionLayoutCore_TEds9UA$lambda$17(MutableState<ConstraintSet> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean MotionLayoutCore_TEds9UA$lambda$23(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void MotionLayoutCore_TEds9UA$lambda$24(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: renamed from: MotionLayoutCore-SehEMGo, reason: not valid java name */
    public static final void m10104MotionLayoutCoreSehEMGo(final MotionScene motionScene, final float f, final String str, final int i, final int i2, final Modifier modifier, final MutableState<Unit> mutableState, final Ref<CompositionSource> ref, final InvalidationStrategy invalidationStrategy, final Function3<? super MotionLayoutScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i3) {
        int i4;
        float f2;
        int i5;
        int i6;
        Function3<? super MotionLayoutScope, ? super Composer, ? super Integer, Unit> function4;
        String startConstraintSetId;
        String endConstraintSetId;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1160212844);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MotionLayoutCore)P(6,8,9,7,3:androidx.constraintlayout.compose.DebugFlags,5,2!1,4)523@22002L91,526@22119L178,531@22320L170,539@22557L585:MotionLayout.kt#fysre8");
        if ((i3 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(motionScene) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            f2 = f;
            i4 |= composerStartRestartGroup.changed(f2) ? 32 : 16;
        } else {
            f2 = f;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerStartRestartGroup.changed(str) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            i5 = i;
            i4 |= composerStartRestartGroup.changed(i5) ? 2048 : 1024;
        } else {
            i5 = i;
        }
        if ((i3 & 24576) == 0) {
            i6 = i2;
            i4 |= composerStartRestartGroup.changed(i6) ? 16384 : 8192;
        } else {
            i6 = i2;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerStartRestartGroup.changed(modifier) ? 131072 : 65536;
        }
        if ((1572864 & i3) == 0) {
            i4 |= composerStartRestartGroup.changed(mutableState) ? 1048576 : 524288;
        }
        if ((12582912 & i3) == 0) {
            i4 |= (16777216 & i3) == 0 ? composerStartRestartGroup.changed(ref) : composerStartRestartGroup.changedInstance(ref) ? 8388608 : 4194304;
        }
        if ((100663296 & i3) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(invalidationStrategy) ? 67108864 : 33554432;
        }
        if ((805306368 & i3) == 0) {
            function4 = function3;
            i4 |= composerStartRestartGroup.changedInstance(function4) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        } else {
            function4 = function3;
        }
        if ((i4 & 306783379) != 306783378 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1160212844, i4, -1, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:521)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -487958632, "CC(remember):MotionLayout.kt#9igjgp");
            int i7 = i4 & 14;
            int i8 = i4;
            boolean z = ((i4 & 896) == 256) | (i7 == 4);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = motionScene.getTransitionInstance(str);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Transition transition = (Transition) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -487954801, "CC(remember):MotionLayout.kt#9igjgp");
            boolean zChanged = (i7 == 4) | composerStartRestartGroup.changed(transition);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                if (transition == null || (startConstraintSetId = transition.getStartConstraintSetId()) == null) {
                    startConstraintSetId = "start";
                }
                objRememberedValue2 = motionScene.getConstraintSetInstance(startConstraintSetId);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ConstraintSet constraintSet = (ConstraintSet) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -487948377, "CC(remember):MotionLayout.kt#9igjgp");
            boolean zChanged2 = (i7 == 4) | composerStartRestartGroup.changed(transition);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                if (transition == null || (endConstraintSetId = transition.getEndConstraintSetId()) == null) {
                    endConstraintSetId = "end";
                }
                objRememberedValue3 = motionScene.getConstraintSetInstance(endConstraintSetId);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ConstraintSet constraintSet2 = (ConstraintSet) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (constraintSet == null || constraintSet2 == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.5
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

                        public final void invoke(Composer composer3, int i9) {
                            MotionLayoutKt.m10104MotionLayoutCoreSehEMGo(motionScene, f, str, i, i2, modifier, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1));
                        }
                    });
                    return;
                }
                return;
            }
            composer2 = composerStartRestartGroup;
            int i9 = i8 >> 18;
            MotionLayoutCore(constraintSet, constraintSet2, transition, f2, motionScene instanceof LayoutInformationReceiver ? (LayoutInformationReceiver) motionScene : null, i5, DebugFlags.m10038getShowBoundsimpl(i6), DebugFlags.m10040getShowPathsimpl(i2), DebugFlags.m10039getShowKeyPositionsimpl(i2), modifier, mutableState, ref, invalidationStrategy, function4, composer2, ((i8 << 6) & 465920) | ((i8 << 12) & C.ENCODING_PCM_DOUBLE), (i9 & 14) | (Ref.$stable << 3) | (i9 & 112) | (i9 & 896) | (i9 & 7168));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup2 != null) {
            scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.6
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

                public final void invoke(Composer composer3, int i10) {
                    MotionLayoutKt.m10104MotionLayoutCoreSehEMGo(motionScene, f, str, i, i2, modifier, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1));
                }
            });
        }
    }

    public static final void MotionLayoutCore(final ConstraintSet constraintSet, final ConstraintSet constraintSet2, final Transition transition, final float f, final LayoutInformationReceiver layoutInformationReceiver, final int i, final boolean z, final boolean z2, final boolean z3, final Modifier modifier, final MutableState<Unit> mutableState, final Ref<CompositionSource> ref, final InvalidationStrategy invalidationStrategy, final Function3<? super MotionLayoutScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i2, final int i3) {
        int i4;
        ConstraintSet constraintSet3;
        int i5;
        boolean z4;
        boolean z5;
        boolean z6;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-657259923);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MotionLayoutCore)P(12,3,13,8,4,7,9,11,10,6,2!1,5)576@23762L50,579@23984L35,583@24169L128,588@24330L7,589@24385L7,590@24412L36,591@24465L56,593@24527L328,673@27479L33,675@27571L19,658@26890L706:MotionLayout.kt#fysre8");
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(constraintSet) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            constraintSet3 = constraintSet2;
            i4 |= composerStartRestartGroup.changed(constraintSet3) ? 32 : 16;
        } else {
            constraintSet3 = constraintSet2;
        }
        if ((i2 & 384) == 0) {
            i4 |= composerStartRestartGroup.changed(transition) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= composerStartRestartGroup.changed(f) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i4 |= (32768 & i2) == 0 ? composerStartRestartGroup.changed(layoutInformationReceiver) : composerStartRestartGroup.changedInstance(layoutInformationReceiver) ? 16384 : 8192;
        }
        if ((196608 & i2) == 0) {
            i4 |= composerStartRestartGroup.changed(i) ? 131072 : 65536;
        }
        if ((i2 & 1572864) == 0) {
            i4 |= composerStartRestartGroup.changed(z) ? 1048576 : 524288;
        }
        if ((i2 & 12582912) == 0) {
            i4 |= composerStartRestartGroup.changed(z2) ? 8388608 : 4194304;
        }
        if ((i2 & 100663296) == 0) {
            i4 |= composerStartRestartGroup.changed(z3) ? 67108864 : 33554432;
        }
        if ((i2 & 805306368) == 0) {
            i4 |= composerStartRestartGroup.changed(modifier) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        if ((i3 & 6) == 0) {
            i5 = i3 | (composerStartRestartGroup.changed(mutableState) ? 4 : 2);
        } else {
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= (i3 & 64) == 0 ? composerStartRestartGroup.changed(ref) : composerStartRestartGroup.changedInstance(ref) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(invalidationStrategy) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(function3) ? 2048 : 1024;
        }
        int i6 = i5;
        if ((i4 & 306783379) != 306783378 || (i6 & 1171) != 1170 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-657259923, i4, i6, "androidx.constraintlayout.compose.MotionLayoutCore (MotionLayout.kt:575)");
            }
            int i7 = i4 >> 9;
            MutableFloatState mutableFloatStateCreateAndUpdateMotionProgress = createAndUpdateMotionProgress(f, composerStartRestartGroup, i7 & 14);
            TransitionImpl eMPTY$constraintlayout_compose_release = transition instanceof TransitionImpl ? (TransitionImpl) transition : null;
            if (eMPTY$constraintlayout_compose_release == null) {
                eMPTY$constraintlayout_compose_release = TransitionImpl.INSTANCE.getEMPTY$constraintlayout_compose_release();
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -487895264, "CC(remember):MotionLayout.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(0L);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            MutableLongState mutableLongState = (MutableLongState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            mutableLongState.getLongValue();
            if (layoutInformationReceiver != null) {
                layoutInformationReceiver.setUpdateFlag(mutableLongState);
            }
            UpdateWithForcedIfNoUserChange(mutableFloatStateCreateAndUpdateMotionProgress, layoutInformationReceiver, composerStartRestartGroup, i7 & 112);
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Density density = (Density) objConsume;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -487881567, "CC(remember):MotionLayout.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new MotionMeasurer(density);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final MotionMeasurer motionMeasurer = (MotionMeasurer) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -487879851, "CC(remember):MotionLayout.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new MotionLayoutScope(motionMeasurer, mutableFloatStateCreateAndUpdateMotionProgress);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            final MotionLayoutScope motionLayoutScope = (MotionLayoutScope) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -487877595, "CC(remember):MotionLayout.kt#9igjgp");
            boolean z7 = ((i4 & 14) == 4) | ((i4 & 112) == 32) | ((i4 & 896) == 256);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (z7 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                TransitionImpl transitionImpl = eMPTY$constraintlayout_compose_release;
                motionMeasurer.initWith(constraintSet, constraintSet3, layoutDirection, transitionImpl, mutableFloatStateCreateAndUpdateMotionProgress.getFloatValue());
                eMPTY$constraintlayout_compose_release = transitionImpl;
                objRememberedValue4 = true;
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ((Boolean) objRememberedValue4).booleanValue();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.startReplaceGroup(-487866413);
            ComposerKt.sourceInformation(composerStartRestartGroup, "606@24972L631");
            if (invalidationStrategy.getOnObservedStateChange() != null) {
                Snapshot.Companion companion = Snapshot.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -487863052, "CC(remember):MotionLayout.kt#9igjgp");
                boolean z8 = ((i6 & 14) == 4) | ((i6 & 112) == 32 || ((i6 & 64) != 0 && composerStartRestartGroup.changedInstance(ref)));
                Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (z8 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = (Function1) new Function1<Object, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$8$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                            invoke2(obj);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Object obj) {
                            mutableState.setValue(Unit.INSTANCE);
                            if (ref.getValue() == CompositionSource.Unknown) {
                                ref.setValue(CompositionSource.Content);
                            }
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Snapshot.Companion.observe$default(companion, (Function1) objRememberedValue5, null, invalidationStrategy.getOnObservedStateChange(), 2, null);
            }
            composerStartRestartGroup.endReplaceGroup();
            MeasurePolicy measurePolicyMotionLayoutMeasurePolicy = motionLayoutMeasurePolicy(mutableState, ref, constraintSet, constraintSet2, eMPTY$constraintlayout_compose_release, mutableFloatStateCreateAndUpdateMotionProgress, motionMeasurer, i, invalidationStrategy);
            motionMeasurer.addLayoutInformationReceiver(layoutInformationReceiver);
            MotionLayoutDebugFlags forcedDrawDebug = layoutInformationReceiver != null ? layoutInformationReceiver.getForcedDrawDebug() : null;
            float forcedScaleFactor = motionMeasurer.getForcedScaleFactor();
            if (forcedDrawDebug == null || forcedDrawDebug == MotionLayoutDebugFlags.UNKNOWN) {
                z4 = z;
                z5 = z3;
                z6 = z2;
            } else {
                z4 = forcedDrawDebug == MotionLayoutDebugFlags.SHOW_ALL;
                z6 = z4;
                z5 = z6;
            }
            composerStartRestartGroup.startReplaceGroup(-487808243);
            ComposerKt.sourceInformation(composerStartRestartGroup, "652@26805L7");
            ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume3 = composerStartRestartGroup.consume(localView);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            boolean zIsShowingLayoutBounds = Api30Impl.isShowingLayoutBounds((View) objConsume3);
            composerStartRestartGroup.endReplaceGroup();
            Modifier modifierMotionPointerInput = MotionDragHandlerKt.motionPointerInput(motionDebug(modifier, motionMeasurer, forcedScaleFactor, zIsShowingLayoutBounds ? true : z4, z6, z5), transition == null ? TransitionImpl.INSTANCE.getEMPTY$constraintlayout_compose_release() : transition, mutableFloatStateCreateAndUpdateMotionProgress, motionMeasurer);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -487783426, "CC(remember):MotionLayout.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(motionMeasurer);
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$9$1
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
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composer2 = composerStartRestartGroup;
            LayoutKt.MultiMeasureLayout(SemanticsModifierKt.semantics$default(modifierMotionPointerInput, false, (Function1) objRememberedValue6, 1, null), ComposableLambdaKt.rememberComposableLambda(1008059664, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.10
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

                public final void invoke(Composer composer3, int i8) {
                    ComposerKt.sourceInformation(composer3, "C675@27579L9:MotionLayout.kt#fysre8");
                    if ((i8 & 3) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1008059664, i8, -1, "androidx.constraintlayout.compose.MotionLayoutCore.<anonymous> (MotionLayout.kt:675)");
                    }
                    function3.invoke(motionLayoutScope, composer3, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), measurePolicyMotionLayoutMeasurePolicy, composer2, 48, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore.11
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

                public final void invoke(Composer composer3, int i8) {
                    MotionLayoutKt.MotionLayoutCore(constraintSet, constraintSet2, transition, f, layoutInformationReceiver, i, z, z2, z3, modifier, mutableState, ref, invalidationStrategy, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3));
                }
            });
        }
    }

    public static final MeasurePolicy motionLayoutMeasurePolicy(final androidx.compose.runtime.State<Unit> state, final Ref<CompositionSource> ref, final ConstraintSet constraintSet, final ConstraintSet constraintSet2, final TransitionImpl transitionImpl, final MutableFloatState mutableFloatState, final MotionMeasurer motionMeasurer, final int i, final InvalidationStrategy invalidationStrategy) {
        return new MeasurePolicy() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.motionLayoutMeasurePolicy.1
            @Override // androidx.compose.ui.layout.MeasurePolicy
            /* JADX INFO: renamed from: measure-3p2s80s */
            public final MeasureResult mo344measure3p2s80s(MeasureScope measureScope, final List<? extends Measurable> list, long j) {
                state.getValue();
                MotionMeasurer motionMeasurer2 = motionMeasurer;
                LayoutDirection layoutDirection = measureScope.getLayoutDirection();
                ConstraintSet constraintSet3 = constraintSet;
                ConstraintSet constraintSet4 = constraintSet2;
                TransitionImpl transitionImpl2 = transitionImpl;
                int i2 = i;
                float floatValue = mutableFloatState.getFloatValue();
                CompositionSource value = ref.getValue();
                if (value == null) {
                    value = CompositionSource.Unknown;
                }
                long jM10128performInterpolationMeasurelUsXzhU = motionMeasurer2.m10128performInterpolationMeasurelUsXzhU(j, layoutDirection, constraintSet3, constraintSet4, transitionImpl2, list, i2, floatValue, value, invalidationStrategy.getShouldInvalidate());
                ref.setValue(CompositionSource.Unknown);
                int iM9858getWidthimpl = IntSize.m9858getWidthimpl(jM10128performInterpolationMeasurelUsXzhU);
                int iM9857getHeightimpl = IntSize.m9857getHeightimpl(jM10128performInterpolationMeasurelUsXzhU);
                final MotionMeasurer motionMeasurer3 = motionMeasurer;
                return MeasureScope.layout$default(measureScope, iM9858getWidthimpl, iM9857getHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.motionLayoutMeasurePolicy.1.1
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

    public static final void UpdateWithForcedIfNoUserChange(final MutableFloatState mutableFloatState, final LayoutInformationReceiver layoutInformationReceiver, Composer composer, final int i) {
        int i2;
        Object obj;
        Composer composerStartRestartGroup = composer.startRestartGroup(1501096015);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(UpdateWithForcedIfNoUserChange)P(1)1019@41023L63:MotionLayout.kt#fysre8");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(mutableFloatState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? composerStartRestartGroup.changed(layoutInformationReceiver) : composerStartRestartGroup.changedInstance(layoutInformationReceiver) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1501096015, i2, -1, "androidx.constraintlayout.compose.UpdateWithForcedIfNoUserChange (MotionLayout.kt:1011)");
            }
            if (layoutInformationReceiver == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.UpdateWithForcedIfNoUserChange.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i3) {
                            MotionLayoutKt.UpdateWithForcedIfNoUserChange(mutableFloatState, layoutInformationReceiver, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                        }
                    });
                    return;
                }
                return;
            }
            float floatValue = mutableFloatState.getFloatValue();
            float forcedProgress = layoutInformationReceiver.getForcedProgress();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 744481438, "CC(remember):MotionLayout.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = objRememberedValue;
                Ref ref = new Ref();
                ref.setValue(Float.valueOf(floatValue));
                composerStartRestartGroup.updateRememberedValue(ref);
                obj = ref;
            }
            obj = objRememberedValue;
            Ref ref2 = (Ref) obj;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (!Float.isNaN(forcedProgress) && Intrinsics.areEqual((Float) ref2.getValue(), floatValue)) {
                mutableFloatState.setFloatValue(forcedProgress);
            } else {
                layoutInformationReceiver.resetForcedProgress();
            }
            ref2.setValue(Float.valueOf(floatValue));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup2 != null) {
            scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.UpdateWithForcedIfNoUserChange.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    MotionLayoutKt.UpdateWithForcedIfNoUserChange(mutableFloatState, layoutInformationReceiver, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final MutableFloatState createAndUpdateMotionProgress(float f, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1721363510, "C(createAndUpdateMotionProgress)1039@41867L42,1040@41925L52:MotionLayout.kt#fysre8");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1721363510, i, -1, "androidx.constraintlayout.compose.createAndUpdateMotionProgress (MotionLayout.kt:1038)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 346851123, "CC(remember):MotionLayout.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = PrimitiveSnapshotStateKt.mutableFloatStateOf(f);
            composer.updateRememberedValue(objRememberedValue);
        }
        MutableFloatState mutableFloatState = (MutableFloatState) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 346852989, "CC(remember):MotionLayout.kt#9igjgp");
        Object objRememberedValue2 = composer.rememberedValue();
        Object obj = objRememberedValue2;
        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            kotlin.jvm.internal.Ref.FloatRef floatRef = new kotlin.jvm.internal.Ref.FloatRef();
            floatRef.element = f;
            composer.updateRememberedValue(floatRef);
            obj = floatRef;
        }
        kotlin.jvm.internal.Ref.FloatRef floatRef2 = (kotlin.jvm.internal.Ref.FloatRef) obj;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (floatRef2.element != f) {
            floatRef2.element = f;
            mutableFloatState.setFloatValue(f);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return mutableFloatState;
    }

    public static final Modifier motionDebug(Modifier modifier, final MotionMeasurer motionMeasurer, float f, final boolean z, final boolean z2, final boolean z3) {
        if (!Float.isNaN(f)) {
            modifier = ScaleKt.scale(modifier, f);
        }
        return (z || z3 || z2) ? DrawModifierKt.drawBehind(modifier, new Function1<DrawScope, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt.motionDebug.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                invoke2(drawScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DrawScope drawScope) {
                motionMeasurer.drawDebug(drawScope, z, z2, z3);
            }
        }) : modifier;
    }
}
