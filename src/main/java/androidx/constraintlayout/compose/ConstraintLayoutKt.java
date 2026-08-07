package androidx.constraintlayout.compose;

import android.util.Log;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableLongState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotLongStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ScaleKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.constraintlayout.core.state.WidgetFrame;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.media3.common.C;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: compiled from: ConstraintLayout.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000º\u0001\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001af\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00152\u0010\b\n\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00182\u001e\b\u0004\u0010\u0019\u001a\u0018\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u000f0\u001a¢\u0006\u0002\b\u001c¢\u0006\u0002\b\u001dH\u0087\b¢\u0006\u0002\u0010\u001e\u001an\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u001f\u001a\u00020\u00012\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0010\b\n\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00182\u001e\b\u0004\u0010\u0019\u001a\u0018\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u000f0\u001a¢\u0006\u0002\b\u001c¢\u0006\u0002\b\u001dH\u0087\b¢\u0006\u0002\u0010!\u001ac\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020#2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00152\u0010\b\n\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00182\u0013\b\u0004\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u000f0\u0018¢\u0006\u0002\b\u001cH\u0087\b¢\u0006\u0002\u0010$\u001ak\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020#2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u001f\u001a\u00020\u00012\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0010\b\n\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00182\u0013\b\u0004\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u000f0\u0018¢\u0006\u0002\b\u001cH\u0087\b¢\u0006\u0002\u0010%\u001a'\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020#2\u0017\u0010(\u001a\u0013\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u000f0\u001a¢\u0006\u0002\b\u001d\u001a\u0018\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020#2\b\b\u0001\u0010*\u001a\u00020+\u001a\u001f\u0010&\u001a\u00020#2\u0017\u0010(\u001a\u0013\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u000f0\u001a¢\u0006\u0002\b\u001d\u001a\u0010\u0010&\u001a\u00020#2\b\b\u0001\u0010*\u001a\u00020+\u001a#\u0010&\u001a\u00020#2\b\b\u0001\u0010\u0019\u001a\u00020+2\n\b\u0003\u0010,\u001a\u0004\u0018\u00010+H\u0007¢\u0006\u0002\u0010-\u001a\u001e\u0010.\u001a\u00020\u000f2\u0006\u0010/\u001a\u0002002\f\u00101\u001a\b\u0012\u0004\u0012\u00020302H\u0000\u001a\b\u00104\u001a\u000205H\u0000\u001a\u001c\u00106\u001a\u00020\u0003*\u00020\u00042\u0006\u00107\u001a\u000208ø\u0001\u0000¢\u0006\u0004\b9\u0010:\u001a\u001c\u00106\u001a\u00020\u0007*\u00020\b2\u0006\u00107\u001a\u000208ø\u0001\u0000¢\u0006\u0004\b9\u0010;\u001a\u001e\u0010\u0002\u001a\u00020\u0007*\u00020\b2\u0006\u00107\u001a\u000208H\u0007ø\u0001\u0000¢\u0006\u0004\b<\u0010;\u001a\u001c\u0010=\u001a\u00020\b*\u00020\u00042\u0006\u00107\u001a\u000208ø\u0001\u0000¢\u0006\u0004\b>\u0010?\u001a\u001c\u0010=\u001a\u00020\u0007*\u00020\u00032\u0006\u00107\u001a\u000208ø\u0001\u0000¢\u0006\u0004\b>\u0010@\u001a0\u0010A\u001a\u00020\u000f*\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020F2\b\b\u0002\u0010G\u001a\u00020HH\u0000ø\u0001\u0000¢\u0006\u0004\bI\u0010J\u001a\f\u0010K\u001a\u00020+*\u00020LH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082D¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0003*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"\u0015\u0010\u0002\u001a\u00020\u0007*\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\t\"\u0015\u0010\n\u001a\u00020\b*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u0015\u0010\n\u001a\u00020\u0007*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\r*\f\b\u0000\u0010M\"\u00020N2\u00020N*\f\b\u0000\u0010O\"\u00020P2\u00020P\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006Q²\u0006\n\u0010R\u001a\u00020#X\u008a\u008e\u0002²\u0006\n\u0010S\u001a\u00020#X\u008a\u008e\u0002"}, d2 = {"DEBUG", "", "atLeastWrapContent", "Landroidx/constraintlayout/compose/Dimension$MaxCoercible;", "Landroidx/constraintlayout/compose/Dimension$Coercible;", "getAtLeastWrapContent", "(Landroidx/constraintlayout/compose/Dimension$Coercible;)Landroidx/constraintlayout/compose/Dimension$MaxCoercible;", "Landroidx/constraintlayout/compose/Dimension;", "Landroidx/constraintlayout/compose/Dimension$MinCoercible;", "(Landroidx/constraintlayout/compose/Dimension$MinCoercible;)Landroidx/constraintlayout/compose/Dimension;", "atMostWrapContent", "getAtMostWrapContent", "(Landroidx/constraintlayout/compose/Dimension$Coercible;)Landroidx/constraintlayout/compose/Dimension$MinCoercible;", "(Landroidx/constraintlayout/compose/Dimension$MaxCoercible;)Landroidx/constraintlayout/compose/Dimension;", "ConstraintLayout", "", "modifier", "Landroidx/compose/ui/Modifier;", "optimizationLevel", "", "animateChangesSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "finishedAnimationListener", "Lkotlin/Function0;", "content", "Lkotlin/Function1;", "Landroidx/constraintlayout/compose/ConstraintLayoutScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;ILandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "animateChanges", "animationSpec", "(Landroidx/compose/ui/Modifier;IZLandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "constraintSet", "Landroidx/constraintlayout/compose/ConstraintSet;", "(Landroidx/constraintlayout/compose/ConstraintSet;Landroidx/compose/ui/Modifier;ILandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/constraintlayout/compose/ConstraintSet;Landroidx/compose/ui/Modifier;IZLandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ConstraintSet", "extendConstraintSet", "description", "Landroidx/constraintlayout/compose/ConstraintSetScope;", "jsonContent", "", "overrideVariables", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/constraintlayout/compose/ConstraintSet;", "buildMapping", "state", "Landroidx/constraintlayout/compose/State;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "createId", "", "atLeast", "dp", "Landroidx/compose/ui/unit/Dp;", "atLeast-3ABfNKs", "(Landroidx/constraintlayout/compose/Dimension$Coercible;F)Landroidx/constraintlayout/compose/Dimension$MaxCoercible;", "(Landroidx/constraintlayout/compose/Dimension$MinCoercible;F)Landroidx/constraintlayout/compose/Dimension;", "atLeastWrapContent-3ABfNKs", "atMost", "atMost-3ABfNKs", "(Landroidx/constraintlayout/compose/Dimension$Coercible;F)Landroidx/constraintlayout/compose/Dimension$MinCoercible;", "(Landroidx/constraintlayout/compose/Dimension$MaxCoercible;F)Landroidx/constraintlayout/compose/Dimension;", "placeWithFrameTransform", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "placeable", "Landroidx/compose/ui/layout/Placeable;", "frame", "Landroidx/constraintlayout/core/state/WidgetFrame;", "offset", "Landroidx/compose/ui/unit/IntOffset;", "placeWithFrameTransform-Ktjjmr4", "(Landroidx/compose/ui/layout/Placeable$PlacementScope;Landroidx/compose/ui/layout/Placeable;Landroidx/constraintlayout/core/state/WidgetFrame;J)V", "toDebugString", "Landroidx/constraintlayout/core/widgets/ConstraintWidget;", "SolverDimension", "Landroidx/constraintlayout/core/state/Dimension;", "SolverState", "Landroidx/constraintlayout/core/state/State;", "constraintlayout-compose_release", "startConstraint", "endConstraint"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ConstraintLayoutKt {
    private static final boolean DEBUG = false;

    public static final void ConstraintLayout(Modifier modifier, int i, AnimationSpec<Float> animationSpec, Function0<Unit> function0, Function3<? super ConstraintLayoutScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i2, int i3) {
        composer.startReplaceGroup(-1003410150);
        ComposerKt.sourceInformation(composer, "CC(ConstraintLayout)P(3,4!1,2)414@18758L7,415@18785L30,416@18832L36,417@18903L34,418@18962L45,419@19033L53,421@19112L652,440@19793L288,449@20174L33,451@20266L729,448@20116L885:ConstraintLayout.kt#fysre8");
        Modifier modifier2 = (i3 & 1) != 0 ? Modifier.INSTANCE : modifier;
        int i4 = (i3 & 2) != 0 ? 257 : i;
        AnimationSpec<Float> animationSpec2 = (i3 & 4) != 0 ? null : animationSpec;
        Function0<Unit> function1 = (i3 & 8) != 0 ? null : function0;
        composer.startReplaceGroup(212064437);
        ComposerKt.sourceInformation(composer, "359@16265L33,360@16347L33,361@16401L70,362@16501L53,363@16587L101,366@16711L54,368@16821L1432,399@18263L441");
        if (animationSpec2 != null) {
            ComposerKt.sourceInformationMarkerStart(composer, 212064614, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composer.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212067238, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composer.updateRememberedValue(objRememberedValue2);
            }
            MutableState mutableState2 = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212069003, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object objRememberedValue3 = composer.rememberedValue();
            Object obj = objRememberedValue3;
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                ConstraintLayoutScope constraintLayoutScope = new ConstraintLayoutScope();
                constraintLayoutScope.setAnimateChanges(true);
                composer.updateRememberedValue(constraintLayoutScope);
                obj = constraintLayoutScope;
            }
            ConstraintLayoutScope constraintLayoutScope2 = (ConstraintLayoutScope) obj;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212072186, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object objRememberedValue4 = composer.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                composer.updateRememberedValue(objRememberedValue4);
            }
            MutableState mutableState3 = (MutableState) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212074986, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object objRememberedValue5 = composer.rememberedValue();
            Object obj2 = objRememberedValue5;
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                Ref ref = new Ref();
                ref.setValue(CompositionSource.Unknown);
                composer.updateRememberedValue(ref);
                obj2 = ref;
            }
            Ref ref2 = (Ref) obj2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212078907, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object objRememberedValue6 = composer.rememberedValue();
            if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = ChannelKt.Channel$default(-1, null, null, 6, null);
                composer.updateRememberedValue(objRememberedValue6);
            }
            Channel channel = (Channel) objRememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(composer);
            LateMotionLayoutKt.LateMotionLayout(mutableState, mutableState2, animationSpec2, channel, mutableState3, ref2, i4, function1, modifier2, ComposableLambdaKt.rememberComposableLambda(-74958949, true, new ConstraintLayoutKt$ConstraintLayout$contentDelegate$1(mutableState3, ref2, constraintLayoutScope2, function3, channel, mutableState, mutableState2), composer, 54), composer, (i2 & 896) | 805330998 | (Ref.$stable << 15) | ((i2 << 15) & 3670016) | ((i2 << 12) & 29360128) | ((i2 << 24) & 234881024));
            composer.endReplaceGroup();
            composer.endReplaceGroup();
            return;
        }
        composer.endReplaceGroup();
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Density density = (Density) objConsume;
        ComposerKt.sourceInformationMarkerStart(composer, 212145251, "CC(remember):ConstraintLayout.kt#9igjgp");
        Object objRememberedValue7 = composer.rememberedValue();
        if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue7 = new Measurer(density);
            composer.updateRememberedValue(objRememberedValue7);
        }
        Measurer measurer = (Measurer) objRememberedValue7;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 212146761, "CC(remember):ConstraintLayout.kt#9igjgp");
        Object objRememberedValue8 = composer.rememberedValue();
        if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue8 = new ConstraintLayoutScope();
            composer.updateRememberedValue(objRememberedValue8);
        }
        ConstraintLayoutScope constraintLayoutScope3 = (ConstraintLayoutScope) objRememberedValue8;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 212149031, "CC(remember):ConstraintLayout.kt#9igjgp");
        Object objRememberedValue9 = composer.rememberedValue();
        if (objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue9 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
            composer.updateRememberedValue(objRememberedValue9);
        }
        MutableState mutableState4 = (MutableState) objRememberedValue9;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 212150930, "CC(remember):ConstraintLayout.kt#9igjgp");
        Object objRememberedValue10 = composer.rememberedValue();
        if (objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue10 = new ConstraintSetForInlineDsl(constraintLayoutScope3);
            composer.updateRememberedValue(objRememberedValue10);
        }
        ConstraintSetForInlineDsl constraintSetForInlineDsl = (ConstraintSetForInlineDsl) objRememberedValue10;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 212153210, "CC(remember):ConstraintLayout.kt#9igjgp");
        Object objRememberedValue11 = composer.rememberedValue();
        if (objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue11 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
            composer.updateRememberedValue(objRememberedValue11);
        }
        MutableState mutableState5 = (MutableState) objRememberedValue11;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 212156337, "CC(remember):ConstraintLayout.kt#9igjgp");
        boolean zChangedInstance = ((((i2 & 112) ^ 48) > 32 && composer.changed(i4)) || (i2 & 48) == 32) | composer.changedInstance(measurer);
        Object objRememberedValue12 = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue12 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue12 = (MeasurePolicy) new ConstraintLayoutKt$ConstraintLayout$measurePolicy$1$1(mutableState5, measurer, constraintSetForInlineDsl, i4, mutableState4);
            composer.updateRememberedValue(objRememberedValue12);
        }
        MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue12;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 212177765, "CC(remember):ConstraintLayout.kt#9igjgp");
        Object objRememberedValue13 = composer.rememberedValue();
        if (objRememberedValue13 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue13 = (Function0) new ConstraintLayoutKt$ConstraintLayout$onHelpersChanged$1$1(mutableState4, constraintSetForInlineDsl);
            composer.updateRememberedValue(objRememberedValue13);
        }
        Function0 function2 = (Function0) objRememberedValue13;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 212189702, "CC(remember):ConstraintLayout.kt#9igjgp");
        boolean zChangedInstance2 = composer.changedInstance(measurer);
        Object objRememberedValue14 = composer.rememberedValue();
        if (zChangedInstance2 || objRememberedValue14 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue14 = (Function1) new ConstraintLayoutKt$ConstraintLayout$1$1(measurer);
            composer.updateRememberedValue(objRememberedValue14);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        LayoutKt.MultiMeasureLayout(SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue14, 1, null), ComposableLambdaKt.rememberComposableLambda(1200550679, true, new AnonymousClass2(mutableState5, constraintLayoutScope3, function3, function2), composer, 54), measurePolicy, composer, 48, 0);
        composer.endReplaceGroup();
    }

    /* JADX INFO: renamed from: androidx.constraintlayout.compose.ConstraintLayoutKt$ConstraintLayout$2, reason: invalid class name */
    /* JADX INFO: compiled from: ConstraintLayout.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 176)
    public static final class AnonymousClass2 extends Lambda implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ Function3<ConstraintLayoutScope, Composer, Integer, Unit> $content;
        final /* synthetic */ MutableState<Unit> $contentTracker;
        final /* synthetic */ Function0<Unit> $onHelpersChanged;
        final /* synthetic */ ConstraintLayoutScope $scope;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(MutableState<Unit> mutableState, ConstraintLayoutScope constraintLayoutScope, Function3<? super ConstraintLayoutScope, ? super Composer, ? super Integer, Unit> function3, Function0<Unit> function0) {
            super(2);
            this.$contentTracker = mutableState;
            this.$scope = constraintLayoutScope;
            this.$content = function3;
            this.$onHelpersChanged = function0;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C457@20608L9,462@20943L28:ConstraintLayout.kt#fysre8");
            if ((i & 3) != 2 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1200550679, i, -1, "androidx.constraintlayout.compose.ConstraintLayout.<anonymous> (ConstraintLayout.kt:454)");
                }
                this.$contentTracker.setValue(Unit.INSTANCE);
                int helpersHashCode = this.$scope.getHelpersHashCode();
                this.$scope.reset();
                this.$content.invoke(this.$scope, composer, 0);
                if (this.$scope.getHelpersHashCode() != helpersHashCode) {
                    EffectsKt.SideEffect(this.$onHelpersChanged, composer, 6);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Prefer version that takes a nullable AnimationSpec to animate changes.", replaceWith = @ReplaceWith(expression = "ConstraintLayout(modifier = modifier, optimizationLevel = optimizationLevel, animateChangesSpec = animationSpec, finishedAnimationListener = finishedAnimationListener) { content() }", imports = {}))
    public static final void ConstraintLayout(Modifier modifier, int i, boolean z, AnimationSpec<Float> animationSpec, Function0<Unit> function0, Function3<? super ConstraintLayoutScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i2, int i3) {
        Measurer measurer;
        MutableState mutableState;
        Object obj;
        ComposerKt.sourceInformationMarkerStart(composer, -2033384074, "CC(ConstraintLayout)P(4,5!2,3)490@21869L262:ConstraintLayout.kt#fysre8");
        Modifier modifier2 = (i3 & 1) != 0 ? Modifier.INSTANCE : modifier;
        int i4 = (i3 & 2) != 0 ? 257 : i;
        boolean z2 = (i3 & 4) != 0 ? false : z;
        TweenSpec tweenSpecTween$default = (i3 & 8) != 0 ? AnimationSpecKt.tween$default(0, 0, null, 7, null) : animationSpec;
        Function0<Unit> function1 = (i3 & 16) != 0 ? null : function0;
        if (!z2) {
            tweenSpecTween$default = null;
        }
        int i5 = i2 >> 3;
        int i6 = (i2 & 126) | (i5 & 7168) | (i5 & 57344);
        composer.startReplaceGroup(-1003410150);
        ComposerKt.sourceInformation(composer, "CC(ConstraintLayout)P(3,4!1,2)414@18758L7,415@18785L30,416@18832L36,417@18903L34,418@18962L45,419@19033L53,421@19112L652,440@19793L288,449@20174L33,451@20266L729,448@20116L885:ConstraintLayout.kt#fysre8");
        composer.startReplaceGroup(212064437);
        ComposerKt.sourceInformation(composer, "359@16265L33,360@16347L33,361@16401L70,362@16501L53,363@16587L101,366@16711L54,368@16821L1432,399@18263L441");
        if (tweenSpecTween$default != null) {
            ComposerKt.sourceInformationMarkerStart(composer, 212064614, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composer.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState2 = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212067238, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composer.updateRememberedValue(objRememberedValue2);
            }
            MutableState mutableState3 = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212069003, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object objRememberedValue3 = composer.rememberedValue();
            Object obj2 = objRememberedValue3;
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                ConstraintLayoutScope constraintLayoutScope = new ConstraintLayoutScope();
                constraintLayoutScope.setAnimateChanges(true);
                composer.updateRememberedValue(constraintLayoutScope);
                obj2 = constraintLayoutScope;
            }
            ConstraintLayoutScope constraintLayoutScope2 = (ConstraintLayoutScope) obj2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212072186, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object objRememberedValue4 = composer.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                composer.updateRememberedValue(objRememberedValue4);
            }
            MutableState mutableState4 = (MutableState) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212074986, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object objRememberedValue5 = composer.rememberedValue();
            Object obj3 = objRememberedValue5;
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                Ref ref = new Ref();
                ref.setValue(CompositionSource.Unknown);
                composer.updateRememberedValue(ref);
                obj3 = ref;
            }
            Ref ref2 = (Ref) obj3;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212078907, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object objRememberedValue6 = composer.rememberedValue();
            if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = ChannelKt.Channel$default(-1, null, null, 6, null);
                composer.updateRememberedValue(objRememberedValue6);
            }
            Channel channel = (Channel) objRememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(composer);
            LateMotionLayoutKt.LateMotionLayout(mutableState2, mutableState3, tweenSpecTween$default, channel, mutableState4, ref2, i4, function1, modifier2, ComposableLambdaKt.rememberComposableLambda(-74958949, true, new ConstraintLayoutKt$ConstraintLayout$contentDelegate$1(mutableState4, ref2, constraintLayoutScope2, function3, channel, mutableState2, mutableState3), composer, 54), composer, (Ref.$stable << 15) | 805330998 | ((i6 << 15) & 3670016) | ((i6 << 12) & 29360128) | ((i6 << 24) & 234881024));
            composer.endReplaceGroup();
            composer.endReplaceGroup();
        } else {
            composer.endReplaceGroup();
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Density density = (Density) objConsume;
            ComposerKt.sourceInformationMarkerStart(composer, 212145251, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object objRememberedValue7 = composer.rememberedValue();
            if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue7 = new Measurer(density);
                composer.updateRememberedValue(objRememberedValue7);
            }
            Measurer measurer2 = (Measurer) objRememberedValue7;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212146761, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object objRememberedValue8 = composer.rememberedValue();
            if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue8 = new ConstraintLayoutScope();
                composer.updateRememberedValue(objRememberedValue8);
            }
            ConstraintLayoutScope constraintLayoutScope3 = (ConstraintLayoutScope) objRememberedValue8;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212149031, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object objRememberedValue9 = composer.rememberedValue();
            if (objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue9 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composer.updateRememberedValue(objRememberedValue9);
            }
            MutableState mutableState5 = (MutableState) objRememberedValue9;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212150930, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object objRememberedValue10 = composer.rememberedValue();
            if (objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue10 = new ConstraintSetForInlineDsl(constraintLayoutScope3);
                composer.updateRememberedValue(objRememberedValue10);
            }
            ConstraintSetForInlineDsl constraintSetForInlineDsl = (ConstraintSetForInlineDsl) objRememberedValue10;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212153210, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object objRememberedValue11 = composer.rememberedValue();
            if (objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue11 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                composer.updateRememberedValue(objRememberedValue11);
            }
            MutableState mutableState6 = (MutableState) objRememberedValue11;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212156337, "CC(remember):ConstraintLayout.kt#9igjgp");
            boolean zChangedInstance = ((((i6 & 112) ^ 48) > 32 && composer.changed(i4)) || (i6 & 48) == 32) | composer.changedInstance(measurer2);
            Object objRememberedValue12 = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue12 == Composer.INSTANCE.getEmpty()) {
                measurer = measurer2;
                mutableState = mutableState6;
                obj = (MeasurePolicy) new ConstraintLayoutKt$ConstraintLayout$measurePolicy$1$1(mutableState, measurer, constraintSetForInlineDsl, i4, mutableState5);
                composer.updateRememberedValue(obj);
            } else {
                obj = objRememberedValue12;
                measurer = measurer2;
                mutableState = mutableState6;
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) obj;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212177765, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object objRememberedValue13 = composer.rememberedValue();
            if (objRememberedValue13 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue13 = (Function0) new ConstraintLayoutKt$ConstraintLayout$onHelpersChanged$1$1(mutableState5, constraintSetForInlineDsl);
                composer.updateRememberedValue(objRememberedValue13);
            }
            Function0 function2 = (Function0) objRememberedValue13;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212189702, "CC(remember):ConstraintLayout.kt#9igjgp");
            boolean zChangedInstance2 = composer.changedInstance(measurer);
            Object objRememberedValue14 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue14 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue14 = (Function1) new ConstraintLayoutKt$ConstraintLayout$1$1(measurer);
                composer.updateRememberedValue(objRememberedValue14);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            LayoutKt.MultiMeasureLayout(SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue14, 1, null), ComposableLambdaKt.rememberComposableLambda(1200550679, true, new AnonymousClass2(mutableState, constraintLayoutScope3, function3, function2), composer, 54), measurePolicy, composer, 48, 0);
            composer.endReplaceGroup();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void ConstraintLayout(ConstraintSet constraintSet, Modifier modifier, int i, AnimationSpec<Float> animationSpec, Function0<Unit> function0, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i2, int i3) {
        Animatable animatable;
        ComposerKt.sourceInformationMarkerStart(composer, 2055379008, "CC(ConstraintLayout)P(1,4,5!1,3):ConstraintLayout.kt#fysre8");
        Modifier modifier2 = (i3 & 2) != 0 ? Modifier.INSTANCE : modifier;
        int i4 = (i3 & 4) != 0 ? 257 : i;
        AnimationSpec<Float> animationSpec2 = (i3 & 8) != 0 ? null : animationSpec;
        Function0<Unit> function1 = (i3 & 16) != 0 ? null : function0;
        if (animationSpec2 != null) {
            composer.startReplaceGroup(-2000511133);
            ComposerKt.sourceInformation(composer, "764@31799L42,765@31871L42,766@31937L29,767@31989L54,768@32068L33,770@32122L34,770@32111L45,772@32190L794,772@32166L818,789@32993L201");
            ComposerKt.sourceInformationMarkerStart(composer, 212561711, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(constraintSet, null, 2, null);
                composer.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212564015, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(constraintSet, null, 2, null);
                composer.updateRememberedValue(objRememberedValue2);
            }
            MutableState mutableState2 = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212566114, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                composer.updateRememberedValue(objRememberedValue3);
            }
            Animatable animatable2 = (Animatable) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212567803, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object objRememberedValue4 = composer.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = ChannelKt.Channel$default(-1, null, null, 6, null);
                composer.updateRememberedValue(objRememberedValue4);
            }
            Channel channel = (Channel) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212570310, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object objRememberedValue5 = composer.rememberedValue();
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = SnapshotIntStateKt.mutableIntStateOf(1);
                composer.updateRememberedValue(objRememberedValue5);
            }
            MutableIntState mutableIntState = (MutableIntState) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212572039, "CC(remember):ConstraintLayout.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(channel) | (((6 ^ (i2 & 14)) > 4 && composer.changed(constraintSet)) || (i2 & 6) == 4);
            Object objRememberedValue6 = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = (Function0) new ConstraintLayoutKt$ConstraintLayout$3$1(channel, constraintSet);
                composer.updateRememberedValue(objRememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            EffectsKt.SideEffect((Function0) objRememberedValue6, composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, 212574975, "CC(remember):ConstraintLayout.kt#9igjgp");
            boolean zChangedInstance2 = composer.changedInstance(channel) | composer.changedInstance(animatable2) | composer.changedInstance(animationSpec2) | ((((57344 & i2) ^ 24576) > 16384 && composer.changed(function1)) || (i2 & 24576) == 16384);
            Object objRememberedValue7 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                animatable = animatable2;
                objRememberedValue7 = (Function2) new ConstraintLayoutKt$ConstraintLayout$4$1(channel, mutableIntState, animatable, animationSpec2, function1, mutableState, mutableState2, null);
                composer.updateRememberedValue(objRememberedValue7);
            } else {
                animatable = animatable2;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            EffectsKt.LaunchedEffect(channel, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue7, composer, 0);
            ConstraintSet constraintSetM10017ConstraintLayout$lambda17 = m10017ConstraintLayout$lambda17(mutableState);
            ConstraintSet constraintSetM10019ConstraintLayout$lambda20 = m10019ConstraintLayout$lambda20(mutableState2);
            float fFloatValue = ((Number) animatable.getValue()).floatValue();
            int i5 = (i2 << 6) & 7168;
            ComposerKt.sourceInformationMarkerStart(composer, -531105279, "CC(MotionLayout)P(7,2,6,4,8,1:androidx.constraintlayout.compose.DebugFlags,5,3)143@6062L53,144@6144L93,149@6399L627,164@7031L556:MotionLayout.kt#fysre8");
            int iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
            InvalidationStrategy defaultInvalidationStrategy = InvalidationStrategy.INSTANCE.getDefaultInvalidationStrategy();
            ComposerKt.sourceInformationMarkerStart(composer, 1692700147, "CC(remember):MotionLayout.kt#9igjgp");
            Object objRememberedValue8 = composer.rememberedValue();
            if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue8 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                composer.updateRememberedValue(objRememberedValue8);
            }
            MutableState mutableState3 = (MutableState) objRememberedValue8;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 1692702811, "CC(remember):MotionLayout.kt#9igjgp");
            Object objRememberedValue9 = composer.rememberedValue();
            Object obj = objRememberedValue9;
            if (objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                Ref ref = new Ref();
                ref.setValue(CompositionSource.Unknown);
                composer.updateRememberedValue(ref);
                obj = ref;
            }
            Ref ref2 = (Ref) obj;
            ComposerKt.sourceInformationMarkerEnd(composer);
            MotionLayoutKt.MotionLayoutCore(constraintSetM10017ConstraintLayout$lambda17, constraintSetM10019ConstraintLayout$lambda20, null, fFloatValue, null, 257, DebugFlags.m10038getShowBoundsimpl(iM10045getNonebfy_xzQ), DebugFlags.m10040getShowPathsimpl(iM10045getNonebfy_xzQ), DebugFlags.m10039getShowKeyPositionsimpl(iM10045getNonebfy_xzQ), modifier2, mutableState3, ref2, defaultInvalidationStrategy, ComposableLambdaKt.rememberComposableLambda(284503157, true, new ConstraintLayoutKt$ConstraintLayout$$inlined$MotionLayoutT3LJ6Qw$1(mutableState3, defaultInvalidationStrategy, ref2, function2, i2), composer, 54), composer, 24576 | ((i5 << 18) & C.ENCODING_PCM_DOUBLE), (Ref.$stable << 3) | 3078);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-1999053668);
            ComposerKt.sourceInformation(composer, "797@33234L35,799@33300L53,800@33389L7,801@33420L30,802@33459L108,806@33596L484");
            ComposerKt.sourceInformationMarkerStart(composer, 212607624, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object objRememberedValue10 = composer.rememberedValue();
            if (objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue10 = SnapshotLongStateKt.mutableLongStateOf(0L);
                composer.updateRememberedValue(objRememberedValue10);
            }
            MutableLongState mutableLongState = (MutableLongState) objRememberedValue10;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212609754, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object objRememberedValue11 = composer.rememberedValue();
            if (objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue11 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                composer.updateRememberedValue(objRememberedValue11);
            }
            MutableState mutableState4 = (MutableState) objRememberedValue11;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Density density = (Density) objConsume;
            ComposerKt.sourceInformationMarkerStart(composer, 212613571, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object objRememberedValue12 = composer.rememberedValue();
            if (objRememberedValue12 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue12 = new Measurer(density);
                composer.updateRememberedValue(objRememberedValue12);
            }
            Measurer measurer = (Measurer) objRememberedValue12;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212614897, "CC(remember):ConstraintLayout.kt#9igjgp");
            int i6 = (i2 & 14) ^ 6;
            boolean z = (i6 > 4 && composer.changed(constraintSet)) || (i2 & 6) == 4;
            Object objRememberedValue13 = composer.rememberedValue();
            if (z || objRememberedValue13 == Composer.INSTANCE.getEmpty()) {
                measurer.parseDesignElements(constraintSet);
                objRememberedValue13 = true;
                composer.updateRememberedValue(objRememberedValue13);
            }
            ((Boolean) objRememberedValue13).booleanValue();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212619657, "CC(remember):ConstraintLayout.kt#9igjgp");
            boolean zChangedInstance3 = composer.changedInstance(measurer) | ((i6 > 4 && composer.changed(constraintSet)) || (i2 & 6) == 4) | ((((i2 & 896) ^ 384) > 256 && composer.changed(i4)) || (i2 & 384) == 256);
            Object objRememberedValue14 = composer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue14 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue14 = (MeasurePolicy) new ConstraintLayoutKt$ConstraintLayout$measurePolicy$2$1(mutableState4, measurer, constraintSet, i4);
                composer.updateRememberedValue(objRememberedValue14);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue14;
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (constraintSet instanceof EditableJSONLayout) {
                ((EditableJSONLayout) constraintSet).setUpdateFlag(mutableLongState);
            }
            measurer.addLayoutInformationReceiver(constraintSet instanceof LayoutInformationReceiver ? (LayoutInformationReceiver) constraintSet : null);
            float forcedScaleFactor = measurer.getForcedScaleFactor();
            if (!Float.isNaN(forcedScaleFactor)) {
                composer.startReplaceGroup(-1997939559);
                ComposerKt.sourceInformation(composer, "828@34465L459");
                Modifier modifierScale = ScaleKt.scale(modifier2, measurer.getForcedScaleFactor());
                ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                Modifier.Companion companion = Modifier.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(constructor);
                } else {
                    composer.useNode();
                }
                Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composer);
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer, -2074840520, "C831@34593L33,833@34709L113,830@34528L312:ConstraintLayout.kt#fysre8");
                ComposerKt.sourceInformationMarkerStart(composer, -1729495323, "CC(remember):ConstraintLayout.kt#9igjgp");
                boolean zChangedInstance4 = composer.changedInstance(measurer);
                Object objRememberedValue15 = composer.rememberedValue();
                if (zChangedInstance4 || objRememberedValue15 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue15 = (Function1) new ConstraintLayoutKt$ConstraintLayout$7$1$1(measurer);
                    composer.updateRememberedValue(objRememberedValue15);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                LayoutKt.MultiMeasureLayout(SemanticsModifierKt.semantics$default(modifierScale, false, (Function1) objRememberedValue15, 1, null), ComposableLambdaKt.rememberComposableLambda(1131308473, true, new ConstraintLayoutKt$ConstraintLayout$7$2(measurer, function2), composer, 54), measurePolicy, composer, 48, 0);
                composer.startReplaceGroup(-1729486855);
                ComposerKt.sourceInformation(composer, "*838@34874L34");
                measurer.drawDebugBounds(boxScopeInstance, forcedScaleFactor, composer, 6);
                Unit unit = Unit.INSTANCE;
                composer.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1997387480);
                ComposerKt.sourceInformation(composer, "843@35057L33,845@35165L380,842@34991L568");
                ComposerKt.sourceInformationMarkerStart(composer, 212665958, "CC(remember):ConstraintLayout.kt#9igjgp");
                boolean zChangedInstance5 = composer.changedInstance(measurer);
                Object objRememberedValue16 = composer.rememberedValue();
                if (zChangedInstance5 || objRememberedValue16 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue16 = (Function1) new ConstraintLayoutKt$ConstraintLayout$8$1(measurer);
                    composer.updateRememberedValue(objRememberedValue16);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                LayoutKt.MultiMeasureLayout(SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue16, 1, null), ComposableLambdaKt.rememberComposableLambda(-207512644, true, new AnonymousClass9(mutableState4, measurer, function2), composer, 54), measurePolicy, composer, 48, 0);
                composer.endReplaceGroup();
            }
            composer.endReplaceGroup();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: ConstraintLayout$lambda-17, reason: not valid java name */
    public static final ConstraintSet m10017ConstraintLayout$lambda17(MutableState<ConstraintSet> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: ConstraintLayout$lambda-20, reason: not valid java name */
    public static final ConstraintSet m10019ConstraintLayout$lambda20(MutableState<ConstraintSet> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: renamed from: androidx.constraintlayout.compose.ConstraintLayoutKt$ConstraintLayout$9, reason: invalid class name */
    /* JADX INFO: compiled from: ConstraintLayout.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 176)
    public static final class AnonymousClass9 extends Lambda implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ Function2<Composer, Integer, Unit> $content;
        final /* synthetic */ MutableState<Unit> $contentTracker;
        final /* synthetic */ Measurer $measurer;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass9(MutableState<Unit> mutableState, Measurer measurer, Function2<? super Composer, ? super Integer, Unit> function2) {
            super(2);
            this.$contentTracker = mutableState;
            this.$measurer = measurer;
            this.$content = function2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C850@35475L22,851@35518L9:ConstraintLayout.kt#fysre8");
            if ((i & 3) != 2 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-207512644, i, -1, "androidx.constraintlayout.compose.ConstraintLayout.<anonymous> (ConstraintLayout.kt:849)");
                }
                this.$contentTracker.setValue(Unit.INSTANCE);
                this.$measurer.createDesignElements(composer, 0);
                this.$content.invoke(composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Prefer version that takes a nullable AnimationSpec to animate changes.", replaceWith = @ReplaceWith(expression = "ConstraintLayout(constraintSet = constraintSet, modifier = modifier, optimizationLevel = optimizationLevel, animateChangesSpec = animationSpec, finishedAnimationListener = finishedAnimationListener) { content() }", imports = {}))
    public static final void ConstraintLayout(ConstraintSet constraintSet, Modifier modifier, int i, boolean z, AnimationSpec<Float> animationSpec, Function0<Unit> function0, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i2, int i3) {
        Animatable animatable;
        ComposerKt.sourceInformationMarkerStart(composer, 136894876, "CC(ConstraintLayout)P(2,5,6!2,4)882@36507L301:ConstraintLayout.kt#fysre8");
        Modifier modifier2 = (i3 & 2) != 0 ? Modifier.INSTANCE : modifier;
        int i4 = (i3 & 4) != 0 ? 257 : i;
        boolean z2 = (i3 & 8) != 0 ? false : z;
        TweenSpec tweenSpecTween$default = (i3 & 16) != 0 ? AnimationSpecKt.tween$default(0, 0, null, 7, null) : animationSpec;
        Function0<Unit> function1 = (i3 & 32) != 0 ? null : function0;
        if (!z2) {
            tweenSpecTween$default = null;
        }
        int i5 = i2 >> 3;
        int i6 = (i5 & 458752) | (i2 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED) | (i5 & 57344);
        ComposerKt.sourceInformationMarkerStart(composer, 2055379008, "CC(ConstraintLayout)P(1,4,5!1,3):ConstraintLayout.kt#fysre8");
        if (tweenSpecTween$default != null) {
            composer.startReplaceGroup(-2000511133);
            ComposerKt.sourceInformation(composer, "764@31799L42,765@31871L42,766@31937L29,767@31989L54,768@32068L33,770@32122L34,770@32111L45,772@32190L794,772@32166L818,789@32993L201");
            ComposerKt.sourceInformationMarkerStart(composer, 212561711, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(constraintSet, null, 2, null);
                composer.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212564015, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(constraintSet, null, 2, null);
                composer.updateRememberedValue(objRememberedValue2);
            }
            MutableState mutableState2 = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212566114, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                composer.updateRememberedValue(objRememberedValue3);
            }
            Animatable animatable2 = (Animatable) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212567803, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object objRememberedValue4 = composer.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = ChannelKt.Channel$default(-1, null, null, 6, null);
                composer.updateRememberedValue(objRememberedValue4);
            }
            Channel channel = (Channel) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212570310, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object objRememberedValue5 = composer.rememberedValue();
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = SnapshotIntStateKt.mutableIntStateOf(1);
                composer.updateRememberedValue(objRememberedValue5);
            }
            MutableIntState mutableIntState = (MutableIntState) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212572039, "CC(remember):ConstraintLayout.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(channel) | (((6 ^ (i6 & 14)) > 4 && composer.changed(constraintSet)) || (i6 & 6) == 4);
            Object objRememberedValue6 = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = (Function0) new ConstraintLayoutKt$ConstraintLayout$3$1(channel, constraintSet);
                composer.updateRememberedValue(objRememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            EffectsKt.SideEffect((Function0) objRememberedValue6, composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, 212574975, "CC(remember):ConstraintLayout.kt#9igjgp");
            boolean zChangedInstance2 = composer.changedInstance(channel) | composer.changedInstance(animatable2) | composer.changedInstance(tweenSpecTween$default) | ((((i6 & 57344) ^ 24576) > 16384 && composer.changed(function1)) || (i6 & 24576) == 16384);
            Object objRememberedValue7 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                animatable = animatable2;
                objRememberedValue7 = (Function2) new ConstraintLayoutKt$ConstraintLayout$4$1(channel, mutableIntState, animatable, tweenSpecTween$default, function1, mutableState, mutableState2, null);
                composer.updateRememberedValue(objRememberedValue7);
            } else {
                animatable = animatable2;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            EffectsKt.LaunchedEffect(channel, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue7, composer, 0);
            ConstraintSet constraintSetM10017ConstraintLayout$lambda17 = m10017ConstraintLayout$lambda17(mutableState);
            ConstraintSet constraintSetM10019ConstraintLayout$lambda20 = m10019ConstraintLayout$lambda20(mutableState2);
            float fFloatValue = ((Number) animatable.getValue()).floatValue();
            int i7 = (i6 << 6) & 7168;
            ComposerKt.sourceInformationMarkerStart(composer, -531105279, "CC(MotionLayout)P(7,2,6,4,8,1:androidx.constraintlayout.compose.DebugFlags,5,3)143@6062L53,144@6144L93,149@6399L627,164@7031L556:MotionLayout.kt#fysre8");
            int iM10045getNonebfy_xzQ = DebugFlags.INSTANCE.m10045getNonebfy_xzQ();
            InvalidationStrategy defaultInvalidationStrategy = InvalidationStrategy.INSTANCE.getDefaultInvalidationStrategy();
            ComposerKt.sourceInformationMarkerStart(composer, 1692700147, "CC(remember):MotionLayout.kt#9igjgp");
            Object objRememberedValue8 = composer.rememberedValue();
            if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue8 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                composer.updateRememberedValue(objRememberedValue8);
            }
            MutableState mutableState3 = (MutableState) objRememberedValue8;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 1692702811, "CC(remember):MotionLayout.kt#9igjgp");
            Object objRememberedValue9 = composer.rememberedValue();
            Object obj = objRememberedValue9;
            if (objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                Ref ref = new Ref();
                ref.setValue(CompositionSource.Unknown);
                composer.updateRememberedValue(ref);
                obj = ref;
            }
            Ref ref2 = (Ref) obj;
            ComposerKt.sourceInformationMarkerEnd(composer);
            MotionLayoutKt.MotionLayoutCore(constraintSetM10017ConstraintLayout$lambda17, constraintSetM10019ConstraintLayout$lambda20, null, fFloatValue, null, 257, DebugFlags.m10038getShowBoundsimpl(iM10045getNonebfy_xzQ), DebugFlags.m10040getShowPathsimpl(iM10045getNonebfy_xzQ), DebugFlags.m10039getShowKeyPositionsimpl(iM10045getNonebfy_xzQ), modifier2, mutableState3, ref2, defaultInvalidationStrategy, ComposableLambdaKt.rememberComposableLambda(284503157, true, new ConstraintLayoutKt$ConstraintLayout$$inlined$MotionLayoutT3LJ6Qw$1(mutableState3, defaultInvalidationStrategy, ref2, function2, i6), composer, 54), composer, 24576 | ((i7 << 18) & C.ENCODING_PCM_DOUBLE), (Ref.$stable << 3) | 3078);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-1999053668);
            ComposerKt.sourceInformation(composer, "797@33234L35,799@33300L53,800@33389L7,801@33420L30,802@33459L108,806@33596L484");
            ComposerKt.sourceInformationMarkerStart(composer, 212607624, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object objRememberedValue10 = composer.rememberedValue();
            if (objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue10 = SnapshotLongStateKt.mutableLongStateOf(0L);
                composer.updateRememberedValue(objRememberedValue10);
            }
            MutableLongState mutableLongState = (MutableLongState) objRememberedValue10;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212609754, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object objRememberedValue11 = composer.rememberedValue();
            if (objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue11 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                composer.updateRememberedValue(objRememberedValue11);
            }
            MutableState mutableState4 = (MutableState) objRememberedValue11;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Density density = (Density) objConsume;
            ComposerKt.sourceInformationMarkerStart(composer, 212613571, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object objRememberedValue12 = composer.rememberedValue();
            if (objRememberedValue12 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue12 = new Measurer(density);
                composer.updateRememberedValue(objRememberedValue12);
            }
            Measurer measurer = (Measurer) objRememberedValue12;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212614897, "CC(remember):ConstraintLayout.kt#9igjgp");
            int i8 = (i6 & 14) ^ 6;
            boolean z3 = (i8 > 4 && composer.changed(constraintSet)) || (i6 & 6) == 4;
            Object objRememberedValue13 = composer.rememberedValue();
            if (z3 || objRememberedValue13 == Composer.INSTANCE.getEmpty()) {
                measurer.parseDesignElements(constraintSet);
                objRememberedValue13 = true;
                composer.updateRememberedValue(objRememberedValue13);
            }
            ((Boolean) objRememberedValue13).booleanValue();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212619657, "CC(remember):ConstraintLayout.kt#9igjgp");
            boolean zChangedInstance3 = ((i8 > 4 && composer.changed(constraintSet)) || (i6 & 6) == 4) | composer.changedInstance(measurer) | ((((i6 & 896) ^ 384) > 256 && composer.changed(i4)) || (i6 & 384) == 256);
            Object objRememberedValue14 = composer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue14 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue14 = (MeasurePolicy) new ConstraintLayoutKt$ConstraintLayout$measurePolicy$2$1(mutableState4, measurer, constraintSet, i4);
                composer.updateRememberedValue(objRememberedValue14);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue14;
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (constraintSet instanceof EditableJSONLayout) {
                ((EditableJSONLayout) constraintSet).setUpdateFlag(mutableLongState);
            }
            measurer.addLayoutInformationReceiver(constraintSet instanceof LayoutInformationReceiver ? (LayoutInformationReceiver) constraintSet : null);
            float forcedScaleFactor = measurer.getForcedScaleFactor();
            if (Float.isNaN(forcedScaleFactor)) {
                composer.startReplaceGroup(-1997387480);
                ComposerKt.sourceInformation(composer, "843@35057L33,845@35165L380,842@34991L568");
                ComposerKt.sourceInformationMarkerStart(composer, 212665958, "CC(remember):ConstraintLayout.kt#9igjgp");
                boolean zChangedInstance4 = composer.changedInstance(measurer);
                Object objRememberedValue15 = composer.rememberedValue();
                if (zChangedInstance4 || objRememberedValue15 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue15 = (Function1) new ConstraintLayoutKt$ConstraintLayout$8$1(measurer);
                    composer.updateRememberedValue(objRememberedValue15);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                LayoutKt.MultiMeasureLayout(SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue15, 1, null), ComposableLambdaKt.rememberComposableLambda(-207512644, true, new AnonymousClass9(mutableState4, measurer, function2), composer, 54), measurePolicy, composer, 48, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1997939559);
                ComposerKt.sourceInformation(composer, "828@34465L459");
                Modifier modifierScale = ScaleKt.scale(modifier2, measurer.getForcedScaleFactor());
                ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                Modifier.Companion companion = Modifier.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(constructor);
                } else {
                    composer.useNode();
                }
                Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composer);
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer, -2074840520, "C831@34593L33,833@34709L113,830@34528L312:ConstraintLayout.kt#fysre8");
                ComposerKt.sourceInformationMarkerStart(composer, -1729495323, "CC(remember):ConstraintLayout.kt#9igjgp");
                boolean zChangedInstance5 = composer.changedInstance(measurer);
                Object objRememberedValue16 = composer.rememberedValue();
                if (zChangedInstance5 || objRememberedValue16 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue16 = (Function1) new ConstraintLayoutKt$ConstraintLayout$7$1$1(measurer);
                    composer.updateRememberedValue(objRememberedValue16);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                LayoutKt.MultiMeasureLayout(SemanticsModifierKt.semantics$default(modifierScale, false, (Function1) objRememberedValue16, 1, null), ComposableLambdaKt.rememberComposableLambda(1131308473, true, new ConstraintLayoutKt$ConstraintLayout$7$2(measurer, function2), composer, 54), measurePolicy, composer, 48, 0);
                composer.startReplaceGroup(-1729486855);
                ComposerKt.sourceInformation(composer, "*838@34874L34");
                measurer.drawDebugBounds(boxScopeInstance, forcedScaleFactor, composer, 6);
                Unit unit = Unit.INSTANCE;
                composer.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endReplaceGroup();
            }
            composer.endReplaceGroup();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    public static final Object createId() {
        return new Object() { // from class: androidx.constraintlayout.compose.ConstraintLayoutKt.createId.1
        };
    }

    public static final Dimension.MaxCoercible getAtLeastWrapContent(Dimension.Coercible coercible) {
        Intrinsics.checkNotNull(coercible, "null cannot be cast to non-null type androidx.constraintlayout.compose.DimensionDescription");
        DimensionDescription dimensionDescription = (DimensionDescription) coercible;
        dimensionDescription.getMin().update("wrap");
        return dimensionDescription;
    }

    /* JADX INFO: renamed from: atLeast-3ABfNKs, reason: not valid java name */
    public static final Dimension.MaxCoercible m10025atLeast3ABfNKs(Dimension.Coercible coercible, float f) {
        Intrinsics.checkNotNull(coercible, "null cannot be cast to non-null type androidx.constraintlayout.compose.DimensionDescription");
        DimensionDescription dimensionDescription = (DimensionDescription) coercible;
        dimensionDescription.getMin().m10048update0680j_4(f);
        return dimensionDescription;
    }

    /* JADX INFO: renamed from: atMost-3ABfNKs, reason: not valid java name */
    public static final Dimension.MinCoercible m10028atMost3ABfNKs(Dimension.Coercible coercible, float f) {
        Intrinsics.checkNotNull(coercible, "null cannot be cast to non-null type androidx.constraintlayout.compose.DimensionDescription");
        DimensionDescription dimensionDescription = (DimensionDescription) coercible;
        dimensionDescription.getMax().m10048update0680j_4(f);
        return dimensionDescription;
    }

    public static final Dimension.MinCoercible getAtMostWrapContent(Dimension.Coercible coercible) {
        Intrinsics.checkNotNull(coercible, "null cannot be cast to non-null type androidx.constraintlayout.compose.DimensionDescription");
        DimensionDescription dimensionDescription = (DimensionDescription) coercible;
        dimensionDescription.getMax().update("wrap");
        return dimensionDescription;
    }

    @Deprecated(message = "Unintended method name, use atLeast(dp) instead", replaceWith = @ReplaceWith(expression = "this.atLeast(dp)", imports = {"androidx.constraintlayout.compose.atLeast"}))
    /* JADX INFO: renamed from: atLeastWrapContent-3ABfNKs, reason: not valid java name */
    public static final Dimension m10027atLeastWrapContent3ABfNKs(Dimension.MinCoercible minCoercible, float f) {
        Intrinsics.checkNotNull(minCoercible, "null cannot be cast to non-null type androidx.constraintlayout.compose.DimensionDescription");
        DimensionDescription dimensionDescription = (DimensionDescription) minCoercible;
        dimensionDescription.getMin().m10048update0680j_4(f);
        return dimensionDescription;
    }

    /* JADX INFO: renamed from: atLeast-3ABfNKs, reason: not valid java name */
    public static final Dimension m10026atLeast3ABfNKs(Dimension.MinCoercible minCoercible, float f) {
        Intrinsics.checkNotNull(minCoercible, "null cannot be cast to non-null type androidx.constraintlayout.compose.DimensionDescription");
        DimensionDescription dimensionDescription = (DimensionDescription) minCoercible;
        dimensionDescription.getMin().m10048update0680j_4(f);
        return dimensionDescription;
    }

    public static final Dimension getAtLeastWrapContent(Dimension.MinCoercible minCoercible) {
        Intrinsics.checkNotNull(minCoercible, "null cannot be cast to non-null type androidx.constraintlayout.compose.DimensionDescription");
        DimensionDescription dimensionDescription = (DimensionDescription) minCoercible;
        dimensionDescription.getMin().update("wrap");
        return dimensionDescription;
    }

    /* JADX INFO: renamed from: atMost-3ABfNKs, reason: not valid java name */
    public static final Dimension m10029atMost3ABfNKs(Dimension.MaxCoercible maxCoercible, float f) {
        Intrinsics.checkNotNull(maxCoercible, "null cannot be cast to non-null type androidx.constraintlayout.compose.DimensionDescription");
        DimensionDescription dimensionDescription = (DimensionDescription) maxCoercible;
        dimensionDescription.getMax().m10048update0680j_4(f);
        return dimensionDescription;
    }

    public static final Dimension getAtMostWrapContent(Dimension.MaxCoercible maxCoercible) {
        Intrinsics.checkNotNull(maxCoercible, "null cannot be cast to non-null type androidx.constraintlayout.compose.DimensionDescription");
        DimensionDescription dimensionDescription = (DimensionDescription) maxCoercible;
        dimensionDescription.getMax().update("wrap");
        return dimensionDescription;
    }

    public static final ConstraintSet ConstraintSet(String str, String str2, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1420317079, "C(ConstraintSet)1346@54787L86:ConstraintLayout.kt#fysre8");
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        String str3 = str2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1420317079, i, -1, "androidx.constraintlayout.compose.ConstraintSet (ConstraintLayout.kt:1344)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 1304135421, "CC(remember):ConstraintLayout.kt#9igjgp");
        boolean z = ((((i & 14) ^ 6) > 4 && composer.changed(str)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer.changed(str3)) || (i & 48) == 32);
        Object objRememberedValue = composer.rememberedValue();
        if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            JSONConstraintSet jSONConstraintSet = new JSONConstraintSet(str, str3, null, 4, null);
            composer.updateRememberedValue(jSONConstraintSet);
            objRememberedValue = jSONConstraintSet;
        }
        JSONConstraintSet jSONConstraintSet2 = (JSONConstraintSet) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return jSONConstraintSet2;
    }

    public static final ConstraintSet ConstraintSet(String str) {
        return new JSONConstraintSet(str, null, null, 6, null);
    }

    public static final ConstraintSet ConstraintSet(ConstraintSet constraintSet, String str) {
        return new JSONConstraintSet(str, null, constraintSet, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final ConstraintSet ConstraintSet(Function1<? super ConstraintSetScope, Unit> function1) {
        return new DslConstraintSet(function1, null, 2, 0 == true ? 1 : 0);
    }

    public static final ConstraintSet ConstraintSet(ConstraintSet constraintSet, Function1<? super ConstraintSetScope, Unit> function1) {
        return new DslConstraintSet(function1, constraintSet);
    }

    /* JADX INFO: renamed from: placeWithFrameTransform-Ktjjmr4$default, reason: not valid java name */
    public static /* synthetic */ void m10031placeWithFrameTransformKtjjmr4$default(Placeable.PlacementScope placementScope, Placeable placeable, WidgetFrame widgetFrame, long j, int i, Object obj) {
        if ((i & 4) != 0) {
            j = IntOffset.INSTANCE.m9826getZeronOccac();
        }
        m10030placeWithFrameTransformKtjjmr4(placementScope, placeable, widgetFrame, j);
    }

    /* JADX INFO: renamed from: placeWithFrameTransform-Ktjjmr4, reason: not valid java name */
    public static final void m10030placeWithFrameTransformKtjjmr4(Placeable.PlacementScope placementScope, Placeable placeable, final WidgetFrame widgetFrame, long j) {
        if (widgetFrame.visibility == 8) {
            if (DEBUG) {
                Log.d("CCL", "Widget: " + widgetFrame.getId() + " is Gone. Skipping placement.");
            }
        } else if (widgetFrame.isDefaultTransform()) {
            Placeable.PlacementScope.m8331place70tqf50$default(placementScope, placeable, IntOffsetKt.IntOffset(widgetFrame.left - IntOffset.m9815getXimpl(j), widgetFrame.top - IntOffset.m9816getYimpl(j)), 0.0f, 2, null);
        } else {
            placementScope.placeWithLayer(placeable, widgetFrame.left - IntOffset.m9815getXimpl(j), widgetFrame.top - IntOffset.m9816getYimpl(j), Float.isNaN(widgetFrame.translationZ) ? 0.0f : widgetFrame.translationZ, new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.constraintlayout.compose.ConstraintLayoutKt$placeWithFrameTransform$layerBlock$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                    invoke2(graphicsLayerScope);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(GraphicsLayerScope graphicsLayerScope) {
                    if (!Float.isNaN(widgetFrame.pivotX) || !Float.isNaN(widgetFrame.pivotY)) {
                        graphicsLayerScope.mo7017setTransformOrigin__ExYCQ(TransformOriginKt.TransformOrigin(Float.isNaN(widgetFrame.pivotX) ? 0.5f : widgetFrame.pivotX, Float.isNaN(widgetFrame.pivotY) ? 0.5f : widgetFrame.pivotY));
                    }
                    if (!Float.isNaN(widgetFrame.rotationX)) {
                        graphicsLayerScope.setRotationX(widgetFrame.rotationX);
                    }
                    if (!Float.isNaN(widgetFrame.rotationY)) {
                        graphicsLayerScope.setRotationY(widgetFrame.rotationY);
                    }
                    if (!Float.isNaN(widgetFrame.rotationZ)) {
                        graphicsLayerScope.setRotationZ(widgetFrame.rotationZ);
                    }
                    if (!Float.isNaN(widgetFrame.translationX)) {
                        graphicsLayerScope.setTranslationX(widgetFrame.translationX);
                    }
                    if (!Float.isNaN(widgetFrame.translationY)) {
                        graphicsLayerScope.setTranslationY(widgetFrame.translationY);
                    }
                    if (!Float.isNaN(widgetFrame.translationZ)) {
                        graphicsLayerScope.setShadowElevation(widgetFrame.translationZ);
                    }
                    if (!Float.isNaN(widgetFrame.scaleX) || !Float.isNaN(widgetFrame.scaleY)) {
                        graphicsLayerScope.setScaleX(Float.isNaN(widgetFrame.scaleX) ? 1.0f : widgetFrame.scaleX);
                        graphicsLayerScope.setScaleY(Float.isNaN(widgetFrame.scaleY) ? 1.0f : widgetFrame.scaleY);
                    }
                    if (Float.isNaN(widgetFrame.alpha)) {
                        return;
                    }
                    graphicsLayerScope.setAlpha(widgetFrame.alpha);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String toDebugString(ConstraintWidget constraintWidget) {
        StringBuilder sb = new StringBuilder();
        sb.append(constraintWidget.getDebugName()).append(" width ").append(constraintWidget.getWidth()).append(" minWidth ").append(constraintWidget.getMinWidth()).append(" maxWidth ").append(constraintWidget.getMaxWidth()).append(" height ").append(constraintWidget.getHeight()).append(" minHeight ").append(constraintWidget.getMinHeight()).append(" maxHeight ").append(constraintWidget.getMaxHeight()).append(" HDB ").append(constraintWidget.getHorizontalDimensionBehaviour()).append(" VDB ").append(constraintWidget.getVerticalDimensionBehaviour()).append(" MCW ").append(constraintWidget.mMatchConstraintDefaultWidth).append(" MCH ").append(constraintWidget.mMatchConstraintDefaultHeight).append(" percentW ").append(constraintWidget.mMatchConstraintPercentWidth);
        sb.append(" percentH ").append(constraintWidget.mMatchConstraintPercentHeight);
        return sb.toString();
    }

    public static final void buildMapping(State state, List<? extends Measurable> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Measurable measurable = list.get(i);
            Object layoutId = LayoutIdKt.getLayoutId(measurable);
            if (layoutId == null && (layoutId = ConstraintLayoutTagKt.getConstraintLayoutId(measurable)) == null) {
                layoutId = createId();
            }
            state.map(layoutId.toString(), measurable);
            Object constraintLayoutTag = ConstraintLayoutTagKt.getConstraintLayoutTag(measurable);
            if (constraintLayoutTag != null && (constraintLayoutTag instanceof String) && (layoutId instanceof String)) {
                state.setTag((String) layoutId, (String) constraintLayoutTag);
            }
        }
    }
}
