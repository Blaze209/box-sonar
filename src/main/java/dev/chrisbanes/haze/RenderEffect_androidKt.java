package dev.chrisbanes.haze;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RuntimeShader;
import android.graphics.Shader;
import android.os.Build;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidRenderEffect_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.offline.DownloadService;
import com.facebook.react.uimanager.ViewProps;
import com.microsoft.identity.common.internal.broker.SerializedNames;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: RenderEffect.android.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0007H\u0000\u001a\u0014\u0010\u0010\u001a\u00020\u000b*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002\u001a\u001c\u0010\u0014\u001a\u00020\u0015*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0003\u001a9\u0010\u0017\u001a\u00020\u0015*\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0003¢\u0006\u0004\b \u0010!\u001a\u001d\u0010\"\u001a\u0004\u0018\u00010#*\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002¢\u0006\u0004\b$\u0010%\u001aA\u0010&\u001a\u00020\u0015*\u00020\u00152\f\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(2\b\b\u0002\u0010*\u001a\u00020\u00132\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010#2\b\b\u0002\u0010+\u001a\u00020\u001dH\u0003¢\u0006\u0004\b,\u0010-\u001a7\u0010.\u001a\u00020\u0015*\u00020\u00152\u0006\u0010/\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010#2\u0006\u0010+\u001a\u00020\u001dH\u0003¢\u0006\u0004\b0\u00101\u001a-\u00102\u001a\u00020\u0015*\u00020\u00152\u0006\u00103\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0003¢\u0006\u0004\b4\u00105\u001a \u00106\u001a\u00020\u00152\u0006\u00107\u001a\u00020\u00132\u0006\u00108\u001a\u0002092\u0006\u0010\u0018\u001a\u00020#H\u0003\u001a\u0014\u0010:\u001a\u00020\u0015*\u00020\u00152\u0006\u0010;\u001a\u00020\u0015H\u0003\u001a\u0014\u0010<\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010=\u001a\u00020\nH\u0002\"'\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r\"\u0014\u0010>\u001a\b\u0012\u0004\u0012\u00020@0?X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"createRenderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", SerializedNames.PARAMS, "Ldev/chrisbanes/haze/RenderEffectParams;", "canUseGraphicLayers", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "noiseTextureCache", "Ldev/chrisbanes/haze/SimpleLruCache;", "", "Landroid/graphics/Bitmap;", "getNoiseTextureCache", "()Ldev/chrisbanes/haze/SimpleLruCache;", "noiseTextureCache$delegate", "Lkotlin/Lazy;", "getNoiseTexture", "Landroid/content/Context;", "noiseFactor", "", "withNoise", "Landroid/graphics/RenderEffect;", "context", "withMask", "mask", "Landroidx/compose/ui/graphics/Brush;", "size", "Landroidx/compose/ui/geometry/Size;", "offset", "Landroidx/compose/ui/geometry/Offset;", "blendMode", "Landroid/graphics/BlendMode;", "withMask-jA9W-mQ", "(Landroid/graphics/RenderEffect;Landroidx/compose/ui/graphics/Brush;JJLandroid/graphics/BlendMode;)Landroid/graphics/RenderEffect;", "toShader", "Landroid/graphics/Shader;", "toShader-d16Qtg0", "(Landroidx/compose/ui/graphics/Brush;J)Landroid/graphics/Shader;", "withTints", "tints", "", "Ldev/chrisbanes/haze/HazeTint;", "alphaModulate", "maskOffset", "withTints-0mBilkg", "(Landroid/graphics/RenderEffect;Ljava/util/List;FLandroid/graphics/Shader;J)Landroid/graphics/RenderEffect;", "withTint", "tint", "withTint-0mBilkg", "(Landroid/graphics/RenderEffect;Ldev/chrisbanes/haze/HazeTint;FLandroid/graphics/Shader;J)Landroid/graphics/RenderEffect;", "blendWith", DownloadService.KEY_FOREGROUND, "blendWith-moWRBKg", "(Landroid/graphics/RenderEffect;Landroid/graphics/RenderEffect;Landroid/graphics/BlendMode;J)Landroid/graphics/RenderEffect;", "createBlurImageFilterWithMask", "blurRadiusPx", "bounds", "Landroidx/compose/ui/geometry/Rect;", "chainWith", "imageFilter", ViewProps.TRANSFORM, "alpha", "paintLocal", "Ljava/lang/ThreadLocal;", "Landroid/graphics/Paint;", "haze_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class RenderEffect_androidKt {
    private static final Lazy noiseTextureCache$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0() { // from class: dev.chrisbanes.haze.RenderEffect_androidKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return RenderEffect_androidKt.noiseTextureCache_delegate$lambda$3();
        }
    });
    private static final ThreadLocal<Paint> paintLocal = new ThreadLocal<>();

    public static final RenderEffect createRenderEffect(CompositionLocalConsumerModifierNode compositionLocalConsumerModifierNode, RenderEffectParams params) {
        android.graphics.RenderEffect renderEffectCreateBlurEffect;
        Intrinsics.checkNotNullParameter(compositionLocalConsumerModifierNode, "<this>");
        Intrinsics.checkNotNullParameter(params, "params");
        if (Build.VERSION.SDK_INT < 31) {
            return null;
        }
        float f = 0;
        if (Dp.m9686compareTo0680j_4(params.getBlurRadius(), Dp.m9687constructorimpl(f)) < 0) {
            throw new IllegalArgumentException("blurRadius needs to be equal or greater than 0.dp".toString());
        }
        Brush progressive = params.getProgressive();
        Shader shaderM14514toShaderd16Qtg0 = progressive != null ? m14514toShaderd16Qtg0(progressive, params.getContentSize()) : null;
        if (Dp.m9686compareTo0680j_4(params.getBlurRadius(), Dp.m9687constructorimpl(f)) <= 0) {
            renderEffectCreateBlurEffect = android.graphics.RenderEffect.createOffsetEffect(0.0f, 0.0f);
        } else if (Build.VERSION.SDK_INT >= 33 && shaderM14514toShaderd16Qtg0 != null) {
            renderEffectCreateBlurEffect = createBlurImageFilterWithMask(((Density) CompositionLocalConsumerModifierNodeKt.currentValueOf(compositionLocalConsumerModifierNode, CompositionLocalsKt.getLocalDensity())).mo754toPx0680j_4(params.getBlurRadius()), SizeKt.m6659toRectuvyYCjk(params.getContentSize()), shaderM14514toShaderd16Qtg0);
        } else {
            try {
                float fMo754toPx0680j_4 = ((Density) CompositionLocalConsumerModifierNodeKt.currentValueOf(compositionLocalConsumerModifierNode, CompositionLocalsKt.getLocalDensity())).mo754toPx0680j_4(params.getBlurRadius());
                renderEffectCreateBlurEffect = android.graphics.RenderEffect.createBlurEffect(fMo754toPx0680j_4, fMo754toPx0680j_4, Shader.TileMode.CLAMP);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Error whilst calling RenderEffect.createBlurEffect. This is likely because this device does not support a blur radius of " + Dp.m9698toStringimpl(params.getBlurRadius()) + "dp", e);
            }
        }
        Intrinsics.checkNotNull(renderEffectCreateBlurEffect);
        return AndroidRenderEffect_androidKt.asComposeRenderEffect(m14516withMaskjA9WmQ$default(m14520withTints0mBilkg$default(withNoise(renderEffectCreateBlurEffect, (Context) CompositionLocalConsumerModifierNodeKt.currentValueOf(compositionLocalConsumerModifierNode, AndroidCompositionLocals_androidKt.getLocalContext()), params.getNoiseFactor()), params.getTints(), params.getTintAlphaModulate(), shaderM14514toShaderd16Qtg0, 0L, 8, null), params.getMask(), params.getContentSize(), 0L, null, 12, null));
    }

    public static final boolean canUseGraphicLayers(DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        return Build.VERSION.SDK_INT >= 31 && AndroidCanvas_androidKt.getNativeCanvas(drawScope.getDrawContext().getCanvas()).isHardwareAccelerated();
    }

    private static final SimpleLruCache<Integer, Bitmap> getNoiseTextureCache() {
        return (SimpleLruCache) noiseTextureCache$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SimpleLruCache noiseTextureCache_delegate$lambda$3() {
        return new SimpleLruCache(3);
    }

    private static final Bitmap getNoiseTexture(Context context, float f) {
        int iCoerceIn = RangesKt.coerceIn(MathKt.roundToInt(f * 255), 0, 255);
        Bitmap bitmap = getNoiseTextureCache().get(Integer.valueOf(iCoerceIn));
        if (bitmap != null && !bitmap.isRecycled()) {
            return bitmap;
        }
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(context.getResources(), R.drawable.haze_noise);
        Intrinsics.checkNotNullExpressionValue(bitmapDecodeResource, "decodeResource(...)");
        Bitmap bitmapTransform = transform(bitmapDecodeResource, iCoerceIn);
        getNoiseTextureCache().set(Integer.valueOf(iCoerceIn), bitmapTransform);
        return bitmapTransform;
    }

    private static final android.graphics.RenderEffect withNoise(android.graphics.RenderEffect renderEffect, Context context, float f) {
        if (f < 0.005f) {
            return renderEffect;
        }
        android.graphics.RenderEffect renderEffectCreateBlendModeEffect = android.graphics.RenderEffect.createBlendModeEffect(android.graphics.RenderEffect.createShaderEffect(new BitmapShader(getNoiseTexture(context, f), Shader.TileMode.REPEAT, Shader.TileMode.REPEAT)), renderEffect, BlendMode.DST_ATOP);
        Intrinsics.checkNotNull(renderEffectCreateBlendModeEffect);
        return renderEffectCreateBlendModeEffect;
    }

    /* JADX INFO: renamed from: withMask-jA9W-mQ$default, reason: not valid java name */
    static /* synthetic */ android.graphics.RenderEffect m14516withMaskjA9WmQ$default(android.graphics.RenderEffect renderEffect, Brush brush, long j, long j2, BlendMode blendMode, int i, Object obj) {
        if ((i & 4) != 0) {
            j2 = Offset.INSTANCE.m6585getZeroF1C5BW0();
        }
        long j3 = j2;
        if ((i & 8) != 0) {
            blendMode = BlendMode.DST_IN;
        }
        return m14515withMaskjA9WmQ(renderEffect, brush, j, j3, blendMode);
    }

    /* JADX INFO: renamed from: withMask-jA9W-mQ, reason: not valid java name */
    private static final android.graphics.RenderEffect m14515withMaskjA9WmQ(android.graphics.RenderEffect renderEffect, Brush brush, long j, long j2, BlendMode blendMode) {
        Shader shaderM14514toShaderd16Qtg0;
        if (brush == null || (shaderM14514toShaderd16Qtg0 = m14514toShaderd16Qtg0(brush, j)) == null) {
            return renderEffect;
        }
        android.graphics.RenderEffect renderEffectCreateShaderEffect = android.graphics.RenderEffect.createShaderEffect(shaderM14514toShaderd16Qtg0);
        Intrinsics.checkNotNullExpressionValue(renderEffectCreateShaderEffect, "createShaderEffect(...)");
        return m14512blendWithmoWRBKg(renderEffect, renderEffectCreateShaderEffect, blendMode, j2);
    }

    /* JADX INFO: renamed from: toShader-d16Qtg0, reason: not valid java name */
    private static final Shader m14514toShaderd16Qtg0(Brush brush, long j) {
        if (brush instanceof ShaderBrush) {
            return ((ShaderBrush) brush).mo6783createShaderuvyYCjk(j);
        }
        return null;
    }

    /* JADX INFO: renamed from: withTints-0mBilkg$default, reason: not valid java name */
    static /* synthetic */ android.graphics.RenderEffect m14520withTints0mBilkg$default(android.graphics.RenderEffect renderEffect, List list, float f, Shader shader, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 1.0f;
        }
        float f2 = f;
        if ((i & 4) != 0) {
            shader = null;
        }
        Shader shader2 = shader;
        if ((i & 8) != 0) {
            j = Offset.INSTANCE.m6585getZeroF1C5BW0();
        }
        return m14519withTints0mBilkg(renderEffect, list, f2, shader2, j);
    }

    /* JADX INFO: renamed from: withTints-0mBilkg, reason: not valid java name */
    private static final android.graphics.RenderEffect m14519withTints0mBilkg(android.graphics.RenderEffect renderEffect, List<HazeTint> list, float f, Shader shader, long j) {
        Iterator<T> it = list.iterator();
        android.graphics.RenderEffect renderEffectM14517withTint0mBilkg = renderEffect;
        while (it.hasNext()) {
            renderEffectM14517withTint0mBilkg = m14517withTint0mBilkg(renderEffectM14517withTint0mBilkg, (HazeTint) it.next(), f, shader, j);
        }
        return renderEffectM14517withTint0mBilkg;
    }

    /* JADX INFO: renamed from: withTint-0mBilkg$default, reason: not valid java name */
    static /* synthetic */ android.graphics.RenderEffect m14518withTint0mBilkg$default(android.graphics.RenderEffect renderEffect, HazeTint hazeTint, float f, Shader shader, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 1.0f;
        }
        return m14517withTint0mBilkg(renderEffect, hazeTint, f, shader, j);
    }

    /* JADX INFO: renamed from: withTint-0mBilkg, reason: not valid java name */
    private static final android.graphics.RenderEffect m14517withTint0mBilkg(android.graphics.RenderEffect renderEffect, HazeTint hazeTint, float f, Shader shader, long j) {
        long jM14508getColor0d7_KjU;
        if (hazeTint.m14508getColor0d7_KjU() == 16) {
            return renderEffect;
        }
        if (f < 1.0f) {
            jM14508getColor0d7_KjU = Color.m6813copywmQWz5c$default(hazeTint.m14508getColor0d7_KjU(), Color.m6816getAlphaimpl(hazeTint.m14508getColor0d7_KjU()) * f, 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jM14508getColor0d7_KjU = hazeTint.m14508getColor0d7_KjU();
        }
        if (Color.m6816getAlphaimpl(jM14508getColor0d7_KjU) < 0.005f) {
            return renderEffect;
        }
        if (shader != null) {
            android.graphics.RenderEffect renderEffectCreateColorFilterEffect = android.graphics.RenderEffect.createColorFilterEffect(new BlendModeColorFilter(ColorKt.m6868toArgb8_81llA(jM14508getColor0d7_KjU), BlendMode.SRC_IN), android.graphics.RenderEffect.createShaderEffect(shader));
            Intrinsics.checkNotNullExpressionValue(renderEffectCreateColorFilterEffect, "createColorFilterEffect(...)");
            return m14512blendWithmoWRBKg(renderEffect, renderEffectCreateColorFilterEffect, BlendModeKt.m14444toAndroidBlendModes9anfk8(hazeTint.m14507getBlendMode0nO6VwU()), j);
        }
        android.graphics.RenderEffect renderEffectCreateColorFilterEffect2 = android.graphics.RenderEffect.createColorFilterEffect(new BlendModeColorFilter(ColorKt.m6868toArgb8_81llA(jM14508getColor0d7_KjU), BlendModeKt.m14444toAndroidBlendModes9anfk8(hazeTint.m14507getBlendMode0nO6VwU())), renderEffect);
        Intrinsics.checkNotNull(renderEffectCreateColorFilterEffect2);
        return renderEffectCreateColorFilterEffect2;
    }

    /* JADX INFO: renamed from: blendWith-moWRBKg$default, reason: not valid java name */
    static /* synthetic */ android.graphics.RenderEffect m14513blendWithmoWRBKg$default(android.graphics.RenderEffect renderEffect, android.graphics.RenderEffect renderEffect2, BlendMode blendMode, long j, int i, Object obj) {
        if ((i & 4) != 0) {
            j = Offset.INSTANCE.m6585getZeroF1C5BW0();
        }
        return m14512blendWithmoWRBKg(renderEffect, renderEffect2, blendMode, j);
    }

    /* JADX INFO: renamed from: blendWith-moWRBKg, reason: not valid java name */
    private static final android.graphics.RenderEffect m14512blendWithmoWRBKg(android.graphics.RenderEffect renderEffect, android.graphics.RenderEffect renderEffect2, BlendMode blendMode, long j) {
        android.graphics.RenderEffect renderEffectCreateBlendModeEffect = android.graphics.RenderEffect.createBlendModeEffect(renderEffect, android.graphics.RenderEffect.createOffsetEffect(Offset.m6569getXimpl(j), Offset.m6570getYimpl(j), renderEffect2), blendMode);
        Intrinsics.checkNotNullExpressionValue(renderEffectCreateBlendModeEffect, "createBlendModeEffect(...)");
        return renderEffectCreateBlendModeEffect;
    }

    private static final android.graphics.RenderEffect createBlurImageFilterWithMask$shader(float f, Rect rect, Shader shader, boolean z) {
        RuntimeShader runtimeShader = new RuntimeShader(HazeShadersKt.BLUR_SKSL);
        runtimeShader.setFloatUniform("blurRadius", f);
        runtimeShader.setIntUniform("direction", z ? 1 : 0);
        runtimeShader.setFloatUniform("crop", rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom());
        runtimeShader.setInputShader("mask", shader);
        android.graphics.RenderEffect renderEffectCreateRuntimeShaderEffect = android.graphics.RenderEffect.createRuntimeShaderEffect(runtimeShader, "content");
        Intrinsics.checkNotNullExpressionValue(renderEffectCreateRuntimeShaderEffect, "createRuntimeShaderEffect(...)");
        return renderEffectCreateRuntimeShaderEffect;
    }

    private static final android.graphics.RenderEffect createBlurImageFilterWithMask(float f, Rect rect, Shader shader) {
        return chainWith(createBlurImageFilterWithMask$shader(f, rect, shader, false), createBlurImageFilterWithMask$shader(f, rect, shader, true));
    }

    private static final android.graphics.RenderEffect chainWith(android.graphics.RenderEffect renderEffect, android.graphics.RenderEffect renderEffect2) {
        android.graphics.RenderEffect renderEffectCreateChainEffect = android.graphics.RenderEffect.createChainEffect(renderEffect2, renderEffect);
        Intrinsics.checkNotNullExpressionValue(renderEffectCreateChainEffect, "createChainEffect(...)");
        return renderEffectCreateChainEffect;
    }

    private static final Bitmap transform(Bitmap bitmap, int i) {
        ThreadLocal<Paint> threadLocal = paintLocal;
        Paint paint = threadLocal.get();
        if (paint == null) {
            paint = new Paint();
            threadLocal.set(paint);
        }
        Paint paint2 = paint;
        paint2.reset();
        paint2.setAlpha(i);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        new Canvas(bitmapCreateBitmap).drawBitmap(bitmap, 0.0f, 0.0f, paint2);
        return bitmapCreateBitmap;
    }
}
