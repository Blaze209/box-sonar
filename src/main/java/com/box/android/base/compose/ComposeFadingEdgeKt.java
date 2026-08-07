package com.box.android.base.compose;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.CompositingStrategy;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Density;
import com.facebook.react.modules.appstate.AppStateModule;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ComposeFadingEdge.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a!\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0019\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000b\u001a\u0019\u0010\f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000b\u001aJ\u0010\u000e\u001a\u00020\u0001*\u00020\u00012\u001d\u0010\u000f\u001a\u0019\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0010¢\u0006\u0002\b\u00142\u001d\u0010\u0015\u001a\u0019\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0010¢\u0006\u0002\b\u0014H\u0002\u001aY\u0010\u0016\u001a\u00020\u0001*\u00020\u00012\u001d\u0010\u0017\u001a\u0019\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0010¢\u0006\u0002\b\u00142\u001d\u0010\u0018\u001a\u0019\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0010¢\u0006\u0002\b\u00142\u0006\u0010\u0004\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"topFadingEdge", "Landroidx/compose/ui/Modifier;", "gradientHeight", "Landroidx/compose/ui/unit/Dp;", AppStateModule.APP_STATE_BACKGROUND, "Landroidx/compose/ui/graphics/Color;", "topFadingEdge-H2RKhps", "(Landroidx/compose/ui/Modifier;FJ)Landroidx/compose/ui/Modifier;", "leftFadingEdge", "gradientWidth", "leftFadingEdge-3ABfNKs", "(Landroidx/compose/ui/Modifier;F)Landroidx/compose/ui/Modifier;", "rightFadingEdge", "rightFadingEdge-3ABfNKs", "horizontalFadingEdge", "startXPx", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/geometry/Size;", "", "Lkotlin/ExtensionFunctionType;", "endXPx", "verticalFadingEdge", "startYPx", "endYPx", "verticalFadingEdge-g2O1Hgs", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;J)Landroidx/compose/ui/Modifier;", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ComposeFadingEdgeKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final float leftFadingEdge_3ABfNKs$lambda$0(Density horizontalFadingEdge, Size size) {
        Intrinsics.checkNotNullParameter(horizontalFadingEdge, "$this$horizontalFadingEdge");
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float topFadingEdge_H2RKhps$lambda$0(Density verticalFadingEdge, Size size) {
        Intrinsics.checkNotNullParameter(verticalFadingEdge, "$this$verticalFadingEdge");
        return 0.0f;
    }

    /* JADX INFO: renamed from: topFadingEdge-H2RKhps, reason: not valid java name */
    public static final Modifier m11630topFadingEdgeH2RKhps(Modifier topFadingEdge, final float f, long j) {
        Intrinsics.checkNotNullParameter(topFadingEdge, "$this$topFadingEdge");
        return m11631verticalFadingEdgeg2O1Hgs(topFadingEdge, new Function2() { // from class: com.box.android.base.compose.ComposeFadingEdgeKt$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Float.valueOf(ComposeFadingEdgeKt.topFadingEdge_H2RKhps$lambda$0((Density) obj, (Size) obj2));
            }
        }, new Function2() { // from class: com.box.android.base.compose.ComposeFadingEdgeKt$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Float.valueOf(ComposeFadingEdgeKt.topFadingEdge_H2RKhps$lambda$1(f, (Density) obj, (Size) obj2));
            }
        }, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float topFadingEdge_H2RKhps$lambda$1(float f, Density verticalFadingEdge, Size size) {
        Intrinsics.checkNotNullParameter(verticalFadingEdge, "$this$verticalFadingEdge");
        return verticalFadingEdge.mo754toPx0680j_4(f);
    }

    /* JADX INFO: renamed from: leftFadingEdge-3ABfNKs, reason: not valid java name */
    public static final Modifier m11628leftFadingEdge3ABfNKs(Modifier leftFadingEdge, final float f) {
        Intrinsics.checkNotNullParameter(leftFadingEdge, "$this$leftFadingEdge");
        return horizontalFadingEdge(leftFadingEdge, new Function2() { // from class: com.box.android.base.compose.ComposeFadingEdgeKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Float.valueOf(ComposeFadingEdgeKt.leftFadingEdge_3ABfNKs$lambda$0((Density) obj, (Size) obj2));
            }
        }, new Function2() { // from class: com.box.android.base.compose.ComposeFadingEdgeKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Float.valueOf(ComposeFadingEdgeKt.leftFadingEdge_3ABfNKs$lambda$1(f, (Density) obj, (Size) obj2));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float leftFadingEdge_3ABfNKs$lambda$1(float f, Density horizontalFadingEdge, Size size) {
        Intrinsics.checkNotNullParameter(horizontalFadingEdge, "$this$horizontalFadingEdge");
        return horizontalFadingEdge.mo754toPx0680j_4(f);
    }

    /* JADX INFO: renamed from: rightFadingEdge-3ABfNKs, reason: not valid java name */
    public static final Modifier m11629rightFadingEdge3ABfNKs(Modifier rightFadingEdge, final float f) {
        Intrinsics.checkNotNullParameter(rightFadingEdge, "$this$rightFadingEdge");
        return horizontalFadingEdge(rightFadingEdge, new Function2() { // from class: com.box.android.base.compose.ComposeFadingEdgeKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Float.valueOf(ComposeFadingEdgeKt.rightFadingEdge_3ABfNKs$lambda$0((Density) obj, (Size) obj2));
            }
        }, new Function2() { // from class: com.box.android.base.compose.ComposeFadingEdgeKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Float.valueOf(ComposeFadingEdgeKt.rightFadingEdge_3ABfNKs$lambda$1(f, (Density) obj, (Size) obj2));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float rightFadingEdge_3ABfNKs$lambda$0(Density horizontalFadingEdge, Size size) {
        Intrinsics.checkNotNullParameter(horizontalFadingEdge, "$this$horizontalFadingEdge");
        return Float.intBitsToFloat((int) (size.m6643unboximpl() >> 32));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float rightFadingEdge_3ABfNKs$lambda$1(float f, Density horizontalFadingEdge, Size size) {
        Intrinsics.checkNotNullParameter(horizontalFadingEdge, "$this$horizontalFadingEdge");
        return Float.intBitsToFloat((int) (size.m6643unboximpl() >> 32)) - horizontalFadingEdge.mo754toPx0680j_4(f);
    }

    private static final Modifier horizontalFadingEdge(Modifier modifier, final Function2<? super Density, ? super Size, Float> function2, final Function2<? super Density, ? super Size, Float> function3) {
        return DrawModifierKt.drawWithCache(GraphicsLayerModifierKt.m6981graphicsLayer_6ThJ44$default(modifier, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, CompositingStrategy.INSTANCE.m6907getOffscreenNrFUSI(), 0, null, 458751, null), new Function1() { // from class: com.box.android.base.compose.ComposeFadingEdgeKt$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ComposeFadingEdgeKt.horizontalFadingEdge$lambda$0(function2, function3, (CacheDrawScope) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawResult horizontalFadingEdge$lambda$0(Function2 function2, Function2 function3, CacheDrawScope drawWithCache) {
        Intrinsics.checkNotNullParameter(drawWithCache, "$this$drawWithCache");
        final Brush brushM6761horizontalGradient8A3gB4$default = Brush.Companion.m6761horizontalGradient8A3gB4$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m6804boximpl(Color.INSTANCE.m6849getTransparent0d7_KjU()), Color.m6804boximpl(Color.INSTANCE.m6851getWhite0d7_KjU())}), ((Number) function2.invoke(drawWithCache, Size.m6626boximpl(drawWithCache.m6349getSizeNHjbRc()))).floatValue(), ((Number) function3.invoke(drawWithCache, Size.m6626boximpl(drawWithCache.m6349getSizeNHjbRc()))).floatValue(), 0, 8, (Object) null);
        return drawWithCache.onDrawWithContent(new Function1() { // from class: com.box.android.base.compose.ComposeFadingEdgeKt$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ComposeFadingEdgeKt.horizontalFadingEdge$lambda$0$0(brushM6761horizontalGradient8A3gB4$default, (ContentDrawScope) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit horizontalFadingEdge$lambda$0$0(Brush brush, ContentDrawScope onDrawWithContent) {
        Intrinsics.checkNotNullParameter(onDrawWithContent, "$this$onDrawWithContent");
        onDrawWithContent.drawContent();
        DrawScope.m7388drawRectAsUm42w$default(onDrawWithContent, brush, 0L, 0L, 0.0f, null, null, BlendMode.INSTANCE.m6735getDstIn0nO6VwU(), 62, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: verticalFadingEdge-g2O1Hgs, reason: not valid java name */
    private static final Modifier m11631verticalFadingEdgeg2O1Hgs(Modifier modifier, final Function2<? super Density, ? super Size, Float> function2, final Function2<? super Density, ? super Size, Float> function3, final long j) {
        return DrawModifierKt.drawWithCache(GraphicsLayerModifierKt.m6981graphicsLayer_6ThJ44$default(modifier, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, CompositingStrategy.INSTANCE.m6907getOffscreenNrFUSI(), 0, null, 458751, null), new Function1() { // from class: com.box.android.base.compose.ComposeFadingEdgeKt$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ComposeFadingEdgeKt.verticalFadingEdge_g2O1Hgs$lambda$0(j, function2, function3, (CacheDrawScope) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawResult verticalFadingEdge_g2O1Hgs$lambda$0(long j, Function2 function2, Function2 function3, CacheDrawScope drawWithCache) {
        Intrinsics.checkNotNullParameter(drawWithCache, "$this$drawWithCache");
        final Brush brushM6769verticalGradient8A3gB4$default = Brush.Companion.m6769verticalGradient8A3gB4$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m6804boximpl(Color.INSTANCE.m6849getTransparent0d7_KjU()), Color.m6804boximpl(j)}), ((Number) function2.invoke(drawWithCache, Size.m6626boximpl(drawWithCache.m6349getSizeNHjbRc()))).floatValue(), ((Number) function3.invoke(drawWithCache, Size.m6626boximpl(drawWithCache.m6349getSizeNHjbRc()))).floatValue(), 0, 8, (Object) null);
        return drawWithCache.onDrawWithContent(new Function1() { // from class: com.box.android.base.compose.ComposeFadingEdgeKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ComposeFadingEdgeKt.verticalFadingEdge_g2O1Hgs$lambda$0$0(brushM6769verticalGradient8A3gB4$default, (ContentDrawScope) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit verticalFadingEdge_g2O1Hgs$lambda$0$0(Brush brush, ContentDrawScope onDrawWithContent) {
        Intrinsics.checkNotNullParameter(onDrawWithContent, "$this$onDrawWithContent");
        onDrawWithContent.drawContent();
        DrawScope.m7388drawRectAsUm42w$default(onDrawWithContent, brush, 0L, 0L, 0.0f, null, null, BlendMode.INSTANCE.m6735getDstIn0nO6VwU(), 62, null);
        return Unit.INSTANCE;
    }
}
