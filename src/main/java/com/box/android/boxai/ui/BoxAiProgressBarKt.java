package com.box.android.boxai.ui;

import androidx.compose.animation.TransitionKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.KeyframesSpec;
import androidx.compose.animation.core.StartOffset;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.unit.Dp;
import androidx.exifinterface.media.ExifInterface;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.BoxThemeKt;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: compiled from: BoxAiProgressBar.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\u001a#\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\t\u001a)\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\f0\u000b\"\u0004\b\u0000\u0010\f2\u0006\u0010\r\u001a\u0002H\f2\u0006\u0010\u000e\u001a\u0002H\fH\u0002¢\u0006\u0002\u0010\u000f\u001a#\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0016\u001a#\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0016\u001a\r\u0010\u0019\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\u001a\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b²\u0006\n\u0010\u001c\u001a\u00020\u0018X\u008a\u0084\u0002²\u0006\n\u0010\u001d\u001a\u00020\u0012X\u008a\u0084\u0002"}, d2 = {"ANIMATION_DURATION", "", "BoxAiProgressBar", "", "modifier", "Landroidx/compose/ui/Modifier;", "startingSize", "Landroidx/compose/ui/unit/Dp;", "BoxAiProgressBar-rAjV9yQ", "(Landroidx/compose/ui/Modifier;FLandroidx/compose/runtime/Composer;II)V", "keyFrameGenerator", "Landroidx/compose/animation/core/KeyframesSpec;", ExifInterface.GPS_DIRECTION_TRUE, "initial", "end", "(Ljava/lang/Object;Ljava/lang/Object;)Landroidx/compose/animation/core/KeyframesSpec;", "animateColor", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/graphics/Color;", "infiniteTransition", "Landroidx/compose/animation/core/InfiniteTransition;", SemanticAttributes.MessagingRocketmqMessageTypeValues.DELAY, "(Landroidx/compose/animation/core/InfiniteTransition;ILandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "animateSize", "", "BoxAiProgressBarPreview", "(Landroidx/compose/runtime/Composer;I)V", "boxai_generalProdRelease", "scale", "color"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxAiProgressBarKt {
    private static final int ANIMATION_DURATION;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiProgressBarPreview$lambda$0(int i, Composer composer, int i2) {
        BoxAiProgressBarPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiProgressBar_rAjV9yQ$lambda$2(Modifier modifier, float f, int i, int i2, Composer composer, int i3) {
        m12079BoxAiProgressBarrAjV9yQ(modifier, f, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static {
        Duration.Companion companion = Duration.INSTANCE;
        ANIMATION_DURATION = (int) Duration.m16167getInWholeMillisecondsimpl(DurationKt.toDuration(0.66d, DurationUnit.SECONDS));
    }

    /* JADX INFO: renamed from: BoxAiProgressBar-rAjV9yQ, reason: not valid java name */
    public static final void m12079BoxAiProgressBarrAjV9yQ(final Modifier modifier, final float f, Composer composer, final int i, final int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(164340967);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiProgressBar)N(modifier,startingSize:c#ui.unit.Dp)33@1433L47,42@1739L555:BoxAiProgressBar.kt#bwxcym");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(f) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (i5 != 0) {
                f = Dp.m9687constructorimpl(12);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(164340967, i3, -1, "com.box.android.boxai.ui.BoxAiProgressBar (BoxAiProgressBar.kt:32)");
            }
            InfiniteTransition infiniteTransitionRememberInfiniteTransition = InfiniteTransitionKt.rememberInfiniteTransition("loading indicator", composerStartRestartGroup, 6, 0);
            float fM9687constructorimpl = Dp.m9687constructorimpl(f / 6);
            composerStartRestartGroup.startReplaceGroup(-982113188);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*37@1579L49,38@1650L50");
            IntRange intRange = new IntRange(0, 2);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange, 10));
            Iterator<Integer> it = intRange.iterator();
            while (it.hasNext()) {
                int iNextInt = ((IntIterator) it).nextInt() * 100;
                arrayList.add(new Pair(Float.valueOf(BoxAiProgressBar_rAjV9yQ$lambda$0$0(animateSize(infiniteTransitionRememberInfiniteTransition, iNextInt, composerStartRestartGroup, InfiniteTransition.$stable))), Color.m6804boximpl(BoxAiProgressBar_rAjV9yQ$lambda$0$1(animateColor(infiniteTransitionRememberInfiniteTransition, iNextInt, composerStartRestartGroup, InfiniteTransition.$stable)))));
            }
            ArrayList<Pair> arrayList2 = arrayList;
            composerStartRestartGroup.endReplaceGroup();
            Arrangement.HorizontalOrVertical horizontalOrVerticalM1073spacedBy0680j_4 = Arrangement.INSTANCE.m1073spacedBy0680j_4(fM9687constructorimpl);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM1073spacedBy0680j_4, Alignment.INSTANCE.getTop(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1134219201, "C:BoxAiProgressBar.kt#bwxcym");
            composerStartRestartGroup.startReplaceGroup(2114798318);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*51@2064L130,47@1891L387");
            for (final Pair pair : arrayList2) {
                Modifier modifierTestTag = TestTagKt.testTag(SizeKt.m1268sizeVpY3zN4(Modifier.INSTANCE, fM9687constructorimpl, f), "BoxAi:ProgressBar");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2018485958, "CC(remember):BoxAiProgressBar.kt#9igjgp");
                boolean zChanged = composerStartRestartGroup.changed(pair);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.box.android.boxai.ui.BoxAiProgressBarKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BoxAiProgressBarKt.BoxAiProgressBar_rAjV9yQ$lambda$1$0$0$0(pair, (GraphicsLayerScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                BoxKt.Box(BackgroundKt.m588backgroundbw27NRU(GraphicsLayerModifierKt.graphicsLayer(modifierTestTag, (Function1) objRememberedValue), ((Color) pair.getSecond()).m6824unboximpl(), RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(32))), composerStartRestartGroup, 0);
            }
            composerStartRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.ui.BoxAiProgressBarKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiProgressBarKt.BoxAiProgressBar_rAjV9yQ$lambda$2(modifier, f, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiProgressBar_rAjV9yQ$lambda$1$0$0$0(Pair pair, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        graphicsLayer.setScaleY(((Number) pair.getFirst()).floatValue());
        graphicsLayer.mo7017setTransformOrigin__ExYCQ(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ());
        return Unit.INSTANCE;
    }

    private static final <T> KeyframesSpec<T> keyFrameGenerator(final T t, final T t2) {
        return AnimationSpecKt.keyframes(new Function1() { // from class: com.box.android.boxai.ui.BoxAiProgressBarKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BoxAiProgressBarKt.keyFrameGenerator$lambda$0(t, t2, (KeyframesSpec.KeyframesSpecConfig) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit keyFrameGenerator$lambda$0(Object obj, Object obj2, KeyframesSpec.KeyframesSpecConfig keyframes) {
        Intrinsics.checkNotNullParameter(keyframes, "$this$keyframes");
        keyframes.setDurationMillis(ANIMATION_DURATION);
        keyframes.at(obj, 0);
        keyframes.atFraction(obj2, 0.4f);
        keyframes.atFraction(obj, 0.8f);
        keyframes.atFraction(obj, 1.0f);
        return Unit.INSTANCE;
    }

    private static final State<Color> animateColor(InfiniteTransition infiniteTransition, int i, Composer composer, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -18122176, "C(animateColor)N(infiniteTransition,delay):BoxAiProgressBar.kt#bwxcym");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-18122176, i2, -1, "com.box.android.boxai.ui.animateColor (BoxAiProgressBar.kt:80)");
        }
        composer.startReplaceGroup(-235539194);
        ComposerKt.sourceInformation(composer, "*81@3179L6,82@3252L6,83@3300L318");
        long jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null);
        long jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU();
        State<Color> stateM455animateColorDTcfvLk = TransitionKt.m455animateColorDTcfvLk(infiniteTransition, jM6813copywmQWz5c$default, jM11533getMainActiveControl0d7_KjU, AnimationSpecKt.m475infiniteRepeatable9IiC70o$default(keyFrameGenerator(Color.m6804boximpl(jM6813copywmQWz5c$default), Color.m6804boximpl(jM11533getMainActiveControl0d7_KjU)), null, StartOffset.m512constructorimpl$default(i, 0, 2, null), 2, null), "color", composer, (i2 & 14) | InfiniteTransition.$stable | 24576 | (InfiniteRepeatableSpec.$stable << 9), 0);
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return stateM455animateColorDTcfvLk;
    }

    private static final State<Float> animateSize(InfiniteTransition infiniteTransition, int i, Composer composer, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1523832604, "C(animateSize)N(infiniteTransition,delay):BoxAiProgressBar.kt#bwxcym");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1523832604, i2, -1, "com.box.android.boxai.ui.animateSize (BoxAiProgressBar.kt:99)");
        }
        composer.startReplaceGroup(-180712877);
        ComposerKt.sourceInformation(composer, "*102@4000L290");
        State<Float> stateAnimateFloat = InfiniteTransitionKt.animateFloat(infiniteTransition, 1.2f, 1.6f, AnimationSpecKt.m475infiniteRepeatable9IiC70o$default(keyFrameGenerator(Float.valueOf(1.2f), Float.valueOf(1.6f)), null, StartOffset.m512constructorimpl$default(i, 0, 2, null), 2, null), "scale", composer, InfiniteTransition.$stable | 25008 | (i2 & 14) | (InfiniteRepeatableSpec.$stable << 9), 0);
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return stateAnimateFloat;
    }

    private static final void BoxAiProgressBarPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-264784672);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiProgressBarPreview)118@4421L131:BoxAiProgressBar.kt#bwxcym");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-264784672, i, -1, "com.box.android.boxai.ui.BoxAiProgressBarPreview (BoxAiProgressBar.kt:117)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$BoxAiProgressBarKt.INSTANCE.m12110getLambda$1989192149$boxai_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.ui.BoxAiProgressBarKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiProgressBarKt.BoxAiProgressBarPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final float BoxAiProgressBar_rAjV9yQ$lambda$0$0(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final long BoxAiProgressBar_rAjV9yQ$lambda$0$1(State<Color> state) {
        return state.getValue().m6824unboximpl();
    }
}
