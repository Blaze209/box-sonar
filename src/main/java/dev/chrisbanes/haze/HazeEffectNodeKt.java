package dev.chrisbanes.haze;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.modifier.ModifierLocalKt;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.unit.Dp;
import com.microsoft.identity.common.internal.broker.SerializedNames;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HazeEffectNode.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u001d\u0010\r\u001a\u00020\u0002*\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0011\u0010\u0012\u001ao\u0010\u0013\u001a\u0004\u0018\u00010\b*\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0015\u001a\u00020\u00022\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0000¢\u0006\u0004\b\u001f\u0010 \u001a\u0016\u0010\u0013\u001a\u0004\u0018\u00010\b*\u00020!2\u0006\u0010\"\u001a\u00020\u0007H\u0000\u001a\u0011\u0010#\u001a\u00020$*\u00020\u000eH\u0000¢\u0006\u0002\u0010%\u001a\u0011\u0010&\u001a\u00020\u0010*\u00020\u000eH\u0000¢\u0006\u0002\u0010'\u001a\u0012\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017*\u00020\u000eH\u0000\u001a\f\u0010)\u001a\u00020\u0018*\u00020\u000eH\u0000\u001a\f\u0010*\u001a\u00020\u0002*\u00020\u000eH\u0000\"\u001c\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"'\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006+"}, d2 = {"ModifierLocalCurrentHazeZIndex", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "", "getModifierLocalCurrentHazeZIndex", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "renderEffectCache", "Ldev/chrisbanes/haze/SimpleLruCache;", "Ldev/chrisbanes/haze/RenderEffectParams;", "Landroidx/compose/ui/graphics/RenderEffect;", "getRenderEffectCache", "()Ldev/chrisbanes/haze/SimpleLruCache;", "renderEffectCache$delegate", "Lkotlin/Lazy;", "calculateInputScaleFactor", "Ldev/chrisbanes/haze/HazeEffectNode;", "blurRadius", "Landroidx/compose/ui/unit/Dp;", "calculateInputScaleFactor-3ABfNKs", "(Ldev/chrisbanes/haze/HazeEffectNode;F)F", "getOrCreateRenderEffect", "inputScale", "noiseFactor", "tints", "", "Ldev/chrisbanes/haze/HazeTint;", "tintAlphaModulate", "contentSize", "Landroidx/compose/ui/geometry/Size;", "mask", "Landroidx/compose/ui/graphics/Brush;", "progressive", "getOrCreateRenderEffect-Q3IRXdk", "(Ldev/chrisbanes/haze/HazeEffectNode;FFFLjava/util/List;FJLandroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/Brush;)Landroidx/compose/ui/graphics/RenderEffect;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", SerializedNames.PARAMS, "resolveBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "(Ldev/chrisbanes/haze/HazeEffectNode;)J", "resolveBlurRadius", "(Ldev/chrisbanes/haze/HazeEffectNode;)F", "resolveTints", "resolveFallbackTint", "resolveNoiseFactor", "haze_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class HazeEffectNodeKt {
    private static final ProvidableModifierLocal<Float> ModifierLocalCurrentHazeZIndex = ModifierLocalKt.modifierLocalOf(new Function0() { // from class: dev.chrisbanes.haze.HazeEffectNodeKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return HazeEffectNodeKt.ModifierLocalCurrentHazeZIndex$lambda$0();
        }
    });
    private static final Lazy renderEffectCache$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0() { // from class: dev.chrisbanes.haze.HazeEffectNodeKt$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return HazeEffectNodeKt.renderEffectCache_delegate$lambda$1();
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Float ModifierLocalCurrentHazeZIndex$lambda$0() {
        return null;
    }

    public static final ProvidableModifierLocal<Float> getModifierLocalCurrentHazeZIndex() {
        return ModifierLocalCurrentHazeZIndex;
    }

    private static final SimpleLruCache<RenderEffectParams, RenderEffect> getRenderEffectCache() {
        return (SimpleLruCache) renderEffectCache$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SimpleLruCache renderEffectCache_delegate$lambda$1() {
        return new SimpleLruCache(10);
    }

    /* JADX INFO: renamed from: calculateInputScaleFactor-3ABfNKs$default, reason: not valid java name */
    public static /* synthetic */ float m14473calculateInputScaleFactor3ABfNKs$default(HazeEffectNode hazeEffectNode, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = resolveBlurRadius(hazeEffectNode);
        }
        return m14472calculateInputScaleFactor3ABfNKs(hazeEffectNode, f);
    }

    @ExperimentalHazeApi
    /* JADX INFO: renamed from: calculateInputScaleFactor-3ABfNKs, reason: not valid java name */
    public static final float m14472calculateInputScaleFactor3ABfNKs(HazeEffectNode calculateInputScaleFactor, float f) {
        Intrinsics.checkNotNullParameter(calculateInputScaleFactor, "$this$calculateInputScaleFactor");
        HazeInputScale inputScale = calculateInputScaleFactor.getInputScale();
        if (Intrinsics.areEqual(inputScale, HazeInputScale.None.INSTANCE)) {
            return 1.0f;
        }
        if (inputScale instanceof HazeInputScale.Fixed) {
            return ((HazeInputScale.Fixed) inputScale).m14482unboximpl();
        }
        if (!Intrinsics.areEqual(inputScale, HazeInputScale.Auto.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        }
        if (Dp.m9686compareTo0680j_4(f, Dp.m9687constructorimpl(7)) < 0) {
            return 1.0f;
        }
        return (calculateInputScaleFactor.getProgressive() == null && calculateInputScaleFactor.getMask() == null) ? 0.3334f : 0.5f;
    }

    /* JADX INFO: renamed from: getOrCreateRenderEffect-Q3IRXdk$default, reason: not valid java name */
    public static /* synthetic */ RenderEffect m14475getOrCreateRenderEffectQ3IRXdk$default(HazeEffectNode hazeEffectNode, float f, float f2, float f3, List list, float f4, long j, Brush brush, Brush brush2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = m14473calculateInputScaleFactor3ABfNKs$default(hazeEffectNode, 0.0f, 1, null);
        }
        if ((i & 2) != 0) {
            float fResolveBlurRadius = resolveBlurRadius(hazeEffectNode);
            if (Float.isNaN(fResolveBlurRadius)) {
                fResolveBlurRadius = Dp.m9687constructorimpl(0);
            }
            f2 = Dp.m9687constructorimpl(fResolveBlurRadius * f);
        }
        if ((i & 4) != 0) {
            f3 = resolveNoiseFactor(hazeEffectNode);
        }
        if ((i & 8) != 0) {
            list = resolveTints(hazeEffectNode);
        }
        if ((i & 16) != 0) {
            f4 = 1.0f;
        }
        if ((i & 32) != 0) {
            j = Size.m6641times7Ah8Wj8(hazeEffectNode.getSize(), f);
        }
        if ((i & 64) != 0) {
            brush = hazeEffectNode.getMask();
        }
        Brush brush3 = (i & 128) != 0 ? null : brush2;
        return m14474getOrCreateRenderEffectQ3IRXdk(hazeEffectNode, f, f2, f3, list, f4, j, brush, brush3);
    }

    /* JADX INFO: renamed from: getOrCreateRenderEffect-Q3IRXdk, reason: not valid java name */
    public static final RenderEffect m14474getOrCreateRenderEffectQ3IRXdk(HazeEffectNode getOrCreateRenderEffect, float f, float f2, float f3, List<HazeTint> tints, float f4, long j, Brush brush, Brush brush2) {
        Intrinsics.checkNotNullParameter(getOrCreateRenderEffect, "$this$getOrCreateRenderEffect");
        Intrinsics.checkNotNullParameter(tints, "tints");
        return getOrCreateRenderEffect(getOrCreateRenderEffect, new RenderEffectParams(f2, f3, tints, f4, j, brush, brush2, null));
    }

    public static final RenderEffect getOrCreateRenderEffect(CompositionLocalConsumerModifierNode compositionLocalConsumerModifierNode, final RenderEffectParams params) {
        Intrinsics.checkNotNullParameter(compositionLocalConsumerModifierNode, "<this>");
        Intrinsics.checkNotNullParameter(params, "params");
        Log_androidKt.log(HazeEffectNode.TAG, new Function0() { // from class: dev.chrisbanes.haze.HazeEffectNodeKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HazeEffectNodeKt.getOrCreateRenderEffect$lambda$3(params);
            }
        });
        RenderEffect renderEffect = getRenderEffectCache().get(params);
        if (renderEffect != null) {
            Log_androidKt.log(HazeEffectNode.TAG, new Function0() { // from class: dev.chrisbanes.haze.HazeEffectNodeKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return HazeEffectNodeKt.getOrCreateRenderEffect$lambda$4(params);
                }
            });
            return renderEffect;
        }
        Log_androidKt.log(HazeEffectNode.TAG, new Function0() { // from class: dev.chrisbanes.haze.HazeEffectNodeKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HazeEffectNodeKt.getOrCreateRenderEffect$lambda$5(params);
            }
        });
        RenderEffect renderEffectCreateRenderEffect = RenderEffect_androidKt.createRenderEffect(compositionLocalConsumerModifierNode, params);
        if (renderEffectCreateRenderEffect == null) {
            return null;
        }
        getRenderEffectCache().set(params, renderEffectCreateRenderEffect);
        return renderEffectCreateRenderEffect;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getOrCreateRenderEffect$lambda$3(RenderEffectParams renderEffectParams) {
        return "getOrCreateRenderEffect: " + renderEffectParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getOrCreateRenderEffect$lambda$4(RenderEffectParams renderEffectParams) {
        return "getOrCreateRenderEffect. Returning cached: " + renderEffectParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getOrCreateRenderEffect$lambda$5(RenderEffectParams renderEffectParams) {
        return "getOrCreateRenderEffect. Creating: " + renderEffectParams;
    }

    public static final long resolveBackgroundColor(HazeEffectNode hazeEffectNode) {
        Intrinsics.checkNotNullParameter(hazeEffectNode, "<this>");
        long backgroundColor = hazeEffectNode.getBackgroundColor();
        if (backgroundColor == 16) {
            backgroundColor = hazeEffectNode.getStyle().m14500getBackgroundColor0d7_KjU();
        }
        return backgroundColor != 16 ? backgroundColor : hazeEffectNode.getCompositionLocalStyle().m14500getBackgroundColor0d7_KjU();
    }

    public static final float resolveBlurRadius(HazeEffectNode hazeEffectNode) {
        Intrinsics.checkNotNullParameter(hazeEffectNode, "<this>");
        float blurRadius = hazeEffectNode.getBlurRadius();
        if (Float.isNaN(blurRadius)) {
            blurRadius = hazeEffectNode.getStyle().m14501getBlurRadiusD9Ej5fM();
        }
        return !Float.isNaN(blurRadius) ? blurRadius : hazeEffectNode.getCompositionLocalStyle().m14501getBlurRadiusD9Ej5fM();
    }

    public static final List<HazeTint> resolveTints(HazeEffectNode hazeEffectNode) {
        Intrinsics.checkNotNullParameter(hazeEffectNode, "<this>");
        List<HazeTint> tints = hazeEffectNode.getTints();
        if (tints.isEmpty()) {
            tints = null;
        }
        if (tints == null) {
            tints = hazeEffectNode.getStyle().getTints();
            if (tints.isEmpty()) {
                tints = null;
            }
            if (tints == null) {
                List<HazeTint> tints2 = hazeEffectNode.getCompositionLocalStyle().getTints();
                List<HazeTint> list = tints2.isEmpty() ? null : tints2;
                return list == null ? CollectionsKt.emptyList() : list;
            }
        }
        return tints;
    }

    public static final HazeTint resolveFallbackTint(HazeEffectNode hazeEffectNode) {
        Intrinsics.checkNotNullParameter(hazeEffectNode, "<this>");
        HazeTint fallbackTint = hazeEffectNode.getFallbackTint();
        if (!fallbackTint.isSpecified()) {
            fallbackTint = null;
        }
        if (fallbackTint != null) {
            return fallbackTint;
        }
        HazeTint fallbackTint2 = hazeEffectNode.getStyle().getFallbackTint();
        HazeTint hazeTint = fallbackTint2.isSpecified() ? fallbackTint2 : null;
        return hazeTint == null ? hazeEffectNode.getCompositionLocalStyle().getFallbackTint() : hazeTint;
    }

    public static final float resolveNoiseFactor(HazeEffectNode hazeEffectNode) {
        Intrinsics.checkNotNullParameter(hazeEffectNode, "<this>");
        float noiseFactor = hazeEffectNode.getNoiseFactor();
        if (0.0f > noiseFactor || noiseFactor > 1.0f) {
            noiseFactor = hazeEffectNode.getStyle().getNoiseFactor();
        }
        return (0.0f > noiseFactor || noiseFactor > 1.0f) ? hazeEffectNode.getCompositionLocalStyle().getNoiseFactor() : noiseFactor;
    }
}
