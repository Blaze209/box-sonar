package dev.chrisbanes.haze;

import android.os.Build;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Dp;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: HazeChildNode.android.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a$\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0001\u001a$\u0010\u000b\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"USE_RUNTIME_SHADER", "", "drawLinearGradientProgressiveEffect", "", "Ldev/chrisbanes/haze/HazeEffectNode;", "drawScope", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "progressive", "Ldev/chrisbanes/haze/HazeProgressive$LinearGradient;", "contentLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "drawLinearGradientProgressiveEffectUsingLayers", "haze_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class HazeChildNode_androidKt {
    private static final boolean USE_RUNTIME_SHADER = true;

    public static final void drawLinearGradientProgressiveEffect(HazeEffectNode hazeEffectNode, DrawScope drawScope, HazeProgressive.LinearGradient progressive, GraphicsLayer contentLayer) {
        Intrinsics.checkNotNullParameter(hazeEffectNode, "<this>");
        Intrinsics.checkNotNullParameter(drawScope, "drawScope");
        Intrinsics.checkNotNullParameter(progressive, "progressive");
        Intrinsics.checkNotNullParameter(contentLayer, "contentLayer");
        if (Build.VERSION.SDK_INT >= 33) {
            contentLayer.setRenderEffect(HazeEffectNodeKt.m14475getOrCreateRenderEffectQ3IRXdk$default(hazeEffectNode, 0.0f, 0.0f, 0.0f, null, 0.0f, 0L, null, GradientKt.asBrush$default(progressive, 0, 1, null), 127, null));
            contentLayer.setAlpha(hazeEffectNode.getAlpha());
            GraphicsLayerKt.drawLayer(drawScope, contentLayer);
        } else {
            if (progressive.getPreferPerformance()) {
                contentLayer.setRenderEffect(HazeEffectNodeKt.m14475getOrCreateRenderEffectQ3IRXdk$default(hazeEffectNode, 0.0f, 0.0f, 0.0f, null, 0.0f, 0L, GradientKt.asBrush$default(progressive, 0, 1, null), null, 191, null));
                contentLayer.setAlpha(hazeEffectNode.getAlpha());
                GraphicsLayerKt.drawLayer(drawScope, contentLayer);
                return;
            }
            drawLinearGradientProgressiveEffectUsingLayers(hazeEffectNode, drawScope, progressive, contentLayer);
        }
    }

    private static final void drawLinearGradientProgressiveEffectUsingLayers(HazeEffectNode hazeEffectNode, DrawScope drawScope, HazeProgressive.LinearGradient linearGradient, final GraphicsLayer graphicsLayer) {
        float startIntensity = linearGradient.getStartIntensity();
        float f = 0.0f;
        if (0.0f <= startIntensity) {
            float f2 = 1.0f;
            if (startIntensity <= 1.0f) {
                float endIntensity = linearGradient.getEndIntensity();
                if (0.0f > endIntensity || endIntensity > 1.0f) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                char c = 2;
                int iCoerceAtLeast = RangesKt.coerceAtLeast((int) Math.ceil(UtilsKt.m14521calculateLengthwtYxqtY(linearGradient.m14488getStartF1C5BW0(), linearGradient.m14487getEndF1C5BW0(), drawScope.mo7395getSizeNHjbRc()) / drawScope.getDrawContext().getDensity().mo754toPx0680j_4(Dp.m9687constructorimpl(60))), 2);
                GraphicsContext graphicsContext = (GraphicsContext) CompositionLocalConsumerModifierNodeKt.currentValueOf(hazeEffectNode, CompositionLocalsKt.getLocalGraphicsContext());
                char c2 = 0;
                IntRange intRange = linearGradient.getEndIntensity() >= linearGradient.getStartIntensity() ? new IntRange(0, iCoerceAtLeast) : RangesKt.downTo(iCoerceAtLeast, 0);
                List<HazeTint> listResolveTints = HazeEffectNodeKt.resolveTints(hazeEffectNode);
                IntProgression intProgression = intRange;
                float fResolveNoiseFactor = HazeEffectNodeKt.resolveNoiseFactor(hazeEffectNode);
                float fResolveBlurRadius = HazeEffectNodeKt.resolveBlurRadius(hazeEffectNode);
                if (Float.isNaN(fResolveBlurRadius)) {
                    fResolveBlurRadius = Dp.m9687constructorimpl(0);
                }
                char c3 = 1;
                float fM9687constructorimpl = Dp.m9687constructorimpl(fResolveBlurRadius * HazeEffectNodeKt.m14473calculateInputScaleFactor3ABfNKs$default(hazeEffectNode, 0.0f, 1, null));
                int first = intProgression.getFirst();
                int last = intProgression.getLast();
                int step = intProgression.getStep();
                if ((step <= 0 || first > last) && (step >= 0 || last > first)) {
                    return;
                }
                final int i = first;
                while (true) {
                    float f3 = i;
                    float f4 = iCoerceAtLeast;
                    final float f5 = f3 / f4;
                    char c4 = c2;
                    char c5 = c3;
                    float f6 = f;
                    final float fLerp = UtilsKt.lerp(linearGradient.getStartIntensity(), linearGradient.getEndIntensity(), linearGradient.getEasing().transform(f5));
                    GraphicsLayer graphicsLayerCreateGraphicsLayer = graphicsContext.createGraphicsLayer();
                    float f7 = f2;
                    char c6 = c;
                    int i2 = iCoerceAtLeast;
                    drawScope.mo7396recordJVtK1S4(graphicsLayerCreateGraphicsLayer, graphicsLayer.getSize(), new Function1() { // from class: dev.chrisbanes.haze.HazeChildNode_androidKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return HazeChildNode_androidKt.drawLinearGradientProgressiveEffectUsingLayers$lambda$6$lambda$4(graphicsLayer, (DrawScope) obj);
                        }
                    });
                    Log_androidKt.log(HazeEffectNode.TAG, new Function0() { // from class: dev.chrisbanes.haze.HazeChildNode_androidKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return HazeChildNode_androidKt.drawLinearGradientProgressiveEffectUsingLayers$lambda$6$lambda$5(i, f5, fLerp);
                        }
                    });
                    float fMin = Math.min(linearGradient.getStartIntensity(), linearGradient.getEndIntensity());
                    float fMax = Math.max(linearGradient.getStartIntensity(), linearGradient.getEndIntensity());
                    float fM9687constructorimpl2 = Dp.m9687constructorimpl(fM9687constructorimpl * fLerp);
                    Brush.Companion companion = Brush.INSTANCE;
                    Pair[] pairArr = new Pair[4];
                    pairArr[c4] = TuplesKt.to(Float.valueOf(UtilsKt.lerp(fMin, fMax, (f3 - 2.0f) / f4)), Color.m6804boximpl(Color.INSTANCE.m6849getTransparent0d7_KjU()));
                    pairArr[c5] = TuplesKt.to(Float.valueOf(UtilsKt.lerp(fMin, fMax, (f3 - f7) / f4)), Color.m6804boximpl(Color.INSTANCE.m6840getBlack0d7_KjU()));
                    pairArr[c6] = TuplesKt.to(Float.valueOf(UtilsKt.lerp(fMin, fMax, (f3 + f6) / f4)), Color.m6804boximpl(Color.INSTANCE.m6840getBlack0d7_KjU()));
                    pairArr[3] = TuplesKt.to(Float.valueOf(UtilsKt.lerp(fMin, fMax, (f3 + f7) / f4)), Color.m6804boximpl(Color.INSTANCE.m6849getTransparent0d7_KjU()));
                    Brush brushM6764linearGradientmHitzGk$default = Brush.Companion.m6764linearGradientmHitzGk$default(companion, pairArr, linearGradient.m14488getStartF1C5BW0(), linearGradient.m14487getEndF1C5BW0(), 0, 8, (Object) null);
                    int i3 = i;
                    GraphicsContext graphicsContext2 = graphicsContext;
                    List<HazeTint> list = listResolveTints;
                    int i4 = last;
                    graphicsLayerCreateGraphicsLayer.setRenderEffect(HazeEffectNodeKt.m14475getOrCreateRenderEffectQ3IRXdk$default(hazeEffectNode, 0.0f, fM9687constructorimpl2, fResolveNoiseFactor, list, fLerp, 0L, brushM6764linearGradientmHitzGk$default, null, Token.DEBUGGER, null));
                    graphicsLayerCreateGraphicsLayer.setAlpha(hazeEffectNode.getAlpha());
                    GraphicsLayerKt.drawLayer(drawScope, graphicsLayerCreateGraphicsLayer);
                    graphicsContext2.releaseGraphicsLayer(graphicsLayerCreateGraphicsLayer);
                    if (i3 == i4) {
                        return;
                    }
                    i = i3 + step;
                    listResolveTints = list;
                    graphicsContext = graphicsContext2;
                    last = i4;
                    c2 = c4;
                    c3 = c5;
                    f = f6;
                    f2 = f7;
                    c = c6;
                    iCoerceAtLeast = i2;
                }
            }
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit drawLinearGradientProgressiveEffectUsingLayers$lambda$6$lambda$4(GraphicsLayer graphicsLayer, DrawScope record) {
        Intrinsics.checkNotNullParameter(record, "$this$record");
        GraphicsLayerKt.drawLayer(record, graphicsLayer);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String drawLinearGradientProgressiveEffectUsingLayers$lambda$6$lambda$5(int i, float f, float f2) {
        return "drawProgressiveEffect. step=" + i + ", fraction=" + f + ", intensity=" + f2;
    }
}
