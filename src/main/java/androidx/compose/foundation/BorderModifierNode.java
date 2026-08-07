package androidx.compose.foundation;

import androidx.compose.ui.draw.CacheDrawModifierNode;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.ImageBitmapConfig;
import androidx.compose.ui.graphics.ImageBitmapKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathOperation;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: Border.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ,\u0010%\u001a\u00020&*\u00020'2\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020,H\u0002JC\u0010-\u001a\u00020&*\u00020'2\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010(\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020,H\u0002¢\u0006\u0004\b3\u00104J\f\u00105\u001a\u000206*\u000207H\u0016R\u0014\u0010\u000b\u001a\u00020\fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004@FX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Landroidx/compose/foundation/BorderModifierNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "widthParameter", "Landroidx/compose/ui/unit/Dp;", "brushParameter", "Landroidx/compose/ui/graphics/Brush;", "shapeParameter", "Landroidx/compose/ui/graphics/Shape;", "<init>", "(FLandroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/Shape;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "shouldAutoInvalidate", "", "getShouldAutoInvalidate", "()Z", "isImportantForBounds", "borderCache", "Landroidx/compose/foundation/BorderCache;", "value", "width", "getWidth-D9Ej5fM", "()F", "setWidth-0680j_4", "(F)V", "F", "brush", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "setBrush", "(Landroidx/compose/ui/graphics/Brush;)V", "shape", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "setShape", "(Landroidx/compose/ui/graphics/Shape;)V", "drawWithCacheModifierNode", "Landroidx/compose/ui/draw/CacheDrawModifierNode;", "drawGenericBorder", "Landroidx/compose/ui/draw/DrawResult;", "Landroidx/compose/ui/draw/CacheDrawScope;", "outline", "Landroidx/compose/ui/graphics/Outline$Generic;", "fillArea", "strokeWidth", "", "drawRoundRectBorder", "Landroidx/compose/ui/graphics/Outline$Rounded;", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "borderSize", "Landroidx/compose/ui/geometry/Size;", "drawRoundRectBorder-JqoCqck", "(Landroidx/compose/ui/draw/CacheDrawScope;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/Outline$Rounded;JJZF)Landroidx/compose/ui/draw/DrawResult;", "applySemantics", "", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BorderModifierNode extends DelegatingNode implements SemanticsModifierNode {
    public static final int $stable = 8;
    private BorderCache borderCache;
    private Brush brush;
    private final CacheDrawModifierNode drawWithCacheModifierNode;
    private final boolean isImportantForBounds;
    private Shape shape;
    private final boolean shouldAutoInvalidate;
    private float width;

    public /* synthetic */ BorderModifierNode(float f, Brush brush, Shape shape, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, brush, shape);
    }

    private BorderModifierNode(float f, Brush brush, Shape shape) {
        this.width = f;
        this.brush = brush;
        this.shape = shape;
        this.drawWithCacheModifierNode = (CacheDrawModifierNode) delegate(DrawModifierKt.CacheDrawModifierNode(new Function1() { // from class: androidx.compose.foundation.BorderModifierNode$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BorderModifierNode.drawWithCacheModifierNode$lambda$0(this.f$0, (CacheDrawScope) obj);
            }
        }));
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    /* JADX INFO: renamed from: isImportantForBounds, reason: from getter */
    public boolean getIsImportantForBounds() {
        return this.isImportantForBounds;
    }

    /* JADX INFO: renamed from: getWidth-D9Ej5fM, reason: not valid java name and from getter */
    public final float getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: setWidth-0680j_4, reason: not valid java name */
    public final void m614setWidth0680j_4(float f) {
        if (Dp.m9692equalsimpl0(this.width, f)) {
            return;
        }
        this.width = f;
        this.drawWithCacheModifierNode.invalidateDrawCache();
    }

    public final Brush getBrush() {
        return this.brush;
    }

    public final void setBrush(Brush brush) {
        if (Intrinsics.areEqual(this.brush, brush)) {
            return;
        }
        this.brush = brush;
        this.drawWithCacheModifierNode.invalidateDrawCache();
    }

    public final Shape getShape() {
        return this.shape;
    }

    public final void setShape(Shape shape) {
        if (Intrinsics.areEqual(this.shape, shape)) {
            return;
        }
        this.shape = shape;
        this.drawWithCacheModifierNode.invalidateDrawCache();
        SemanticsModifierNodeKt.invalidateSemantics(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawResult drawWithCacheModifierNode$lambda$0(BorderModifierNode borderModifierNode, CacheDrawScope cacheDrawScope) {
        if (cacheDrawScope.mo754toPx0680j_4(borderModifierNode.width) < 0.0f || Size.m6637getMinDimensionimpl(cacheDrawScope.m6349getSizeNHjbRc()) <= 0.0f) {
            return BorderKt.drawContentWithoutBorder(cacheDrawScope);
        }
        float f = 2;
        float fMin = Math.min(Dp.m9692equalsimpl0(borderModifierNode.width, Dp.INSTANCE.m9705getHairlineD9Ej5fM()) ? 1.0f : (float) Math.ceil(cacheDrawScope.mo754toPx0680j_4(borderModifierNode.width)), (float) Math.ceil(Size.m6637getMinDimensionimpl(cacheDrawScope.m6349getSizeNHjbRc()) / f));
        float f2 = fMin / f;
        long jM6561constructorimpl = Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(f2)) & 4294967295L) | (((long) Float.floatToRawIntBits(f2)) << 32));
        long jM6629constructorimpl = Size.m6629constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (cacheDrawScope.m6349getSizeNHjbRc() & 4294967295L)) - fMin)) & 4294967295L) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (cacheDrawScope.m6349getSizeNHjbRc() >> 32)) - fMin)) << 32));
        boolean z = f * fMin > Size.m6637getMinDimensionimpl(cacheDrawScope.m6349getSizeNHjbRc());
        Outline outlineMo655createOutlinePq9zytI = borderModifierNode.shape.mo655createOutlinePq9zytI(cacheDrawScope.m6349getSizeNHjbRc(), cacheDrawScope.getLayoutDirection(), cacheDrawScope);
        if (outlineMo655createOutlinePq9zytI instanceof Outline.Generic) {
            return borderModifierNode.drawGenericBorder(cacheDrawScope, borderModifierNode.brush, (Outline.Generic) outlineMo655createOutlinePq9zytI, z, fMin);
        }
        if (outlineMo655createOutlinePq9zytI instanceof Outline.Rounded) {
            return borderModifierNode.m612drawRoundRectBorderJqoCqck(cacheDrawScope, borderModifierNode.brush, (Outline.Rounded) outlineMo655createOutlinePq9zytI, jM6561constructorimpl, jM6629constructorimpl, z, fMin);
        }
        if (outlineMo655createOutlinePq9zytI instanceof Outline.Rectangle) {
            return BorderKt.m607drawRectBorderNsqcLGU(cacheDrawScope, borderModifierNode.brush, jM6561constructorimpl, jM6629constructorimpl, z, fMin);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:26:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:40:0x0152  */
    /* JADX WARN: Type inference failed for: r11v2, types: [T, androidx.compose.ui.graphics.ImageBitmap] */
    private final DrawResult drawGenericBorder(CacheDrawScope cacheDrawScope, final Brush brush, final Outline.Generic generic, boolean z, float f) throws Throwable {
        int iM7047getArgb8888_sVssgQ;
        ColorFilter colorFilterM6855tintxETnrds$default;
        boolean z2;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        CanvasDrawScope canvasDrawScope;
        CanvasDrawScope canvasDrawScope2;
        float f2;
        float f3;
        float f4;
        float f5;
        CanvasDrawScope canvasDrawScope3;
        DrawContext drawContext;
        long jMo7316getSizeNHjbRc;
        DrawContext drawContext2;
        long j;
        if (z) {
            return cacheDrawScope.onDrawWithContent(new Function1() { // from class: androidx.compose.foundation.BorderModifierNode$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BorderModifierNode.drawGenericBorder$lambda$0(generic, brush, (ContentDrawScope) obj);
                }
            });
        }
        if (brush instanceof SolidColor) {
            iM7047getArgb8888_sVssgQ = ImageBitmapConfig.INSTANCE.m7046getAlpha8_sVssgQ();
            colorFilterM6855tintxETnrds$default = ColorFilter.Companion.m6855tintxETnrds$default(ColorFilter.INSTANCE, Color.m6813copywmQWz5c$default(((SolidColor) brush).getValue(), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), 0, 2, null);
        } else {
            iM7047getArgb8888_sVssgQ = ImageBitmapConfig.INSTANCE.m7047getArgb8888_sVssgQ();
            colorFilterM6855tintxETnrds$default = null;
        }
        int i = iM7047getArgb8888_sVssgQ;
        final Rect bounds = generic.getPath().getBounds();
        if (this.borderCache == null) {
            this.borderCache = new BorderCache(null, null, null, null, 15, null);
        }
        BorderCache borderCache = this.borderCache;
        Intrinsics.checkNotNull(borderCache);
        Path pathObtainPath = borderCache.obtainPath();
        pathObtainPath.reset();
        Path.addRect$default(pathObtainPath, bounds, null, 2, null);
        pathObtainPath.mo6703opN5in7k0(pathObtainPath, generic.getPath(), PathOperation.INSTANCE.m7122getDifferenceb3I0S0c());
        Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        final long jM9853constructorimpl = IntSize.m9853constructorimpl((((long) ((int) Math.ceil(bounds.getBottom() - bounds.getTop()))) & 4294967295L) | (((long) ((int) Math.ceil(bounds.getRight() - bounds.getLeft()))) << 32));
        BorderCache borderCache2 = this.borderCache;
        Intrinsics.checkNotNull(borderCache2);
        ImageBitmap imageBitmapM7052ImageBitmapx__hDU$default = borderCache2.imageBitmap;
        Canvas Canvas = borderCache2.canvas;
        ImageBitmapConfig imageBitmapConfigM7039boximpl = imageBitmapM7052ImageBitmapx__hDU$default != null ? ImageBitmapConfig.m7039boximpl(imageBitmapM7052ImageBitmapx__hDU$default.mo6678getConfig_sVssgQ()) : null;
        if (!(imageBitmapConfigM7039boximpl == null ? false : ImageBitmapConfig.m7042equalsimpl0(imageBitmapConfigM7039boximpl.m7045unboximpl(), ImageBitmapConfig.INSTANCE.m7047getArgb8888_sVssgQ()))) {
            z2 = ImageBitmapConfig.m7041equalsimpl(i, imageBitmapM7052ImageBitmapx__hDU$default != null ? ImageBitmapConfig.m7039boximpl(imageBitmapM7052ImageBitmapx__hDU$default.mo6678getConfig_sVssgQ()) : null);
        }
        try {
            try {
                try {
                    try {
                        if (imageBitmapM7052ImageBitmapx__hDU$default != null && Canvas != null) {
                            objectRef = objectRef3;
                            if (Float.intBitsToFloat((int) (cacheDrawScope.m6349getSizeNHjbRc() >> 32)) <= imageBitmapM7052ImageBitmapx__hDU$default.getWidth() && Float.intBitsToFloat((int) (cacheDrawScope.m6349getSizeNHjbRc() & 4294967295L)) <= imageBitmapM7052ImageBitmapx__hDU$default.getHeight() && z2) {
                                objectRef2 = objectRef;
                            }
                            ?? r11 = imageBitmapM7052ImageBitmapx__hDU$default;
                            Canvas canvas = Canvas;
                            canvasDrawScope = borderCache2.canvasDrawScope;
                            if (canvasDrawScope == null) {
                                canvasDrawScope = new CanvasDrawScope();
                                borderCache2.canvasDrawScope = canvasDrawScope;
                            }
                            CanvasDrawScope canvasDrawScope4 = canvasDrawScope;
                            long jM9870toSizeozmzZPI = IntSizeKt.m9870toSizeozmzZPI(jM9853constructorimpl);
                            LayoutDirection layoutDirection = cacheDrawScope.getLayoutDirection();
                            CanvasDrawScope.DrawParams drawParams = canvasDrawScope4.getDrawParams();
                            final Ref.ObjectRef objectRef4 = objectRef2;
                            Density density = drawParams.getDensity();
                            LayoutDirection layoutDirection2 = drawParams.getLayoutDirection();
                            Canvas canvas2 = drawParams.getCanvas();
                            long size = drawParams.getSize();
                            CanvasDrawScope.DrawParams drawParams2 = canvasDrawScope4.getDrawParams();
                            drawParams2.setDensity(cacheDrawScope);
                            drawParams2.setLayoutDirection(layoutDirection);
                            drawParams2.setCanvas(canvas);
                            drawParams2.m7315setSizeuvyYCjk(jM9870toSizeozmzZPI);
                            canvas.save();
                            canvasDrawScope2 = canvasDrawScope4;
                            DrawScope.m7389drawRectnJ9OG0$default(canvasDrawScope2, Color.INSTANCE.m6840getBlack0d7_KjU(), 0L, jM9870toSizeozmzZPI, 0.0f, null, null, BlendMode.INSTANCE.m6727getClear0nO6VwU(), 58, null);
                            f2 = -bounds.getLeft();
                            f3 = -bounds.getTop();
                            canvasDrawScope2.getDrawContext().getTransform().translate(f2, f3);
                            f4 = f2;
                            canvasDrawScope3 = canvasDrawScope2;
                            final ColorFilter colorFilter = colorFilterM6855tintxETnrds$default;
                            f5 = f3;
                            DrawScope.m7384drawPathGBMwjPU$default(canvasDrawScope3, generic.getPath(), brush, 0.0f, new Stroke(f * 2, 0.0f, 0, 0, null, 30, null), null, 0, 52, null);
                            float f6 = 1;
                            float fIntBitsToFloat = (Float.intBitsToFloat((int) (canvasDrawScope3.mo7395getSizeNHjbRc() >> 32)) + f6) / Float.intBitsToFloat((int) (canvasDrawScope3.mo7395getSizeNHjbRc() >> 32));
                            float fIntBitsToFloat2 = (Float.intBitsToFloat((int) (canvasDrawScope3.mo7395getSizeNHjbRc() & 4294967295L)) + f6) / Float.intBitsToFloat((int) (canvasDrawScope3.mo7395getSizeNHjbRc() & 4294967295L));
                            long jMo7394getCenterF1C5BW0 = canvasDrawScope3.mo7394getCenterF1C5BW0();
                            drawContext = canvasDrawScope3.getDrawContext();
                            jMo7316getSizeNHjbRc = drawContext.mo7316getSizeNHjbRc();
                            drawContext.getCanvas().save();
                            drawContext.getTransform().mo7323scale0AR0LA0(fIntBitsToFloat, fIntBitsToFloat2, jMo7394getCenterF1C5BW0);
                            j = jMo7316getSizeNHjbRc;
                            DrawScope.m7384drawPathGBMwjPU$default(canvasDrawScope3, pathObtainPath, brush, 0.0f, null, null, BlendMode.INSTANCE.m6727getClear0nO6VwU(), 28, null);
                            drawContext.getCanvas().restore();
                            drawContext.mo7317setSizeuvyYCjk(j);
                            canvasDrawScope3.getDrawContext().getTransform().translate(-f4, -f5);
                            canvas.restore();
                            CanvasDrawScope.DrawParams drawParams3 = canvasDrawScope4.getDrawParams();
                            drawParams3.setDensity(density);
                            drawParams3.setLayoutDirection(layoutDirection2);
                            drawParams3.setCanvas(canvas2);
                            drawParams3.m7315setSizeuvyYCjk(size);
                            r11.prepareToDraw();
                            objectRef4.element = r11;
                            return cacheDrawScope.onDrawWithContent(new Function1() { // from class: androidx.compose.foundation.BorderModifierNode$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BorderModifierNode.drawGenericBorder$lambda$3(bounds, objectRef4, jM9853constructorimpl, colorFilter, (ContentDrawScope) obj);
                                }
                            });
                        }
                        objectRef = objectRef3;
                        DrawScope.m7384drawPathGBMwjPU$default(canvasDrawScope3, pathObtainPath, brush, 0.0f, null, null, BlendMode.INSTANCE.m6727getClear0nO6VwU(), 28, null);
                        drawContext.getCanvas().restore();
                        drawContext.mo7317setSizeuvyYCjk(j);
                        canvasDrawScope3.getDrawContext().getTransform().translate(-f4, -f5);
                        canvas.restore();
                        CanvasDrawScope.DrawParams drawParams4 = canvasDrawScope4.getDrawParams();
                        drawParams4.setDensity(density);
                        drawParams4.setLayoutDirection(layoutDirection2);
                        drawParams4.setCanvas(canvas2);
                        drawParams4.m7315setSizeuvyYCjk(size);
                        r11.prepareToDraw();
                        objectRef4.element = r11;
                        return cacheDrawScope.onDrawWithContent(new Function1() { // from class: androidx.compose.foundation.BorderModifierNode$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BorderModifierNode.drawGenericBorder$lambda$3(bounds, objectRef4, jM9853constructorimpl, colorFilter, (ContentDrawScope) obj);
                            }
                        });
                    } catch (Throwable th) {
                        th = th;
                        drawContext2 = drawContext;
                        drawContext2.getCanvas().restore();
                        drawContext2.mo7317setSizeuvyYCjk(j);
                        throw th;
                    }
                    drawContext.getTransform().mo7323scale0AR0LA0(fIntBitsToFloat, fIntBitsToFloat2, jMo7394getCenterF1C5BW0);
                    j = jMo7316getSizeNHjbRc;
                } catch (Throwable th2) {
                    th = th2;
                    drawContext2 = drawContext;
                    j = jMo7316getSizeNHjbRc;
                }
                DrawScope.m7384drawPathGBMwjPU$default(canvasDrawScope3, generic.getPath(), brush, 0.0f, new Stroke(f * 2, 0.0f, 0, 0, null, 30, null), null, 0, 52, null);
                float f7 = 1;
                float fIntBitsToFloat3 = (Float.intBitsToFloat((int) (canvasDrawScope3.mo7395getSizeNHjbRc() >> 32)) + f7) / Float.intBitsToFloat((int) (canvasDrawScope3.mo7395getSizeNHjbRc() >> 32));
                float fIntBitsToFloat4 = (Float.intBitsToFloat((int) (canvasDrawScope3.mo7395getSizeNHjbRc() & 4294967295L)) + f7) / Float.intBitsToFloat((int) (canvasDrawScope3.mo7395getSizeNHjbRc() & 4294967295L));
                long jMo7394getCenterF1C5BW1 = canvasDrawScope3.mo7394getCenterF1C5BW0();
                drawContext = canvasDrawScope3.getDrawContext();
                jMo7316getSizeNHjbRc = drawContext.mo7316getSizeNHjbRc();
                drawContext.getCanvas().save();
            } catch (Throwable th3) {
                th = th3;
                canvasDrawScope3.getDrawContext().getTransform().translate(-f4, -f5);
                throw th;
            }
            f4 = f2;
            canvasDrawScope3 = canvasDrawScope2;
            final ColorFilter colorFilter2 = colorFilterM6855tintxETnrds$default;
            f5 = f3;
        } catch (Throwable th4) {
            th = th4;
            f4 = f2;
            f5 = f3;
            canvasDrawScope3 = canvasDrawScope2;
        }
        objectRef2 = objectRef;
        imageBitmapM7052ImageBitmapx__hDU$default = ImageBitmapKt.m7052ImageBitmapx__hDU$default((int) (jM9853constructorimpl >> 32), (int) (jM9853constructorimpl & 4294967295L), i, false, null, 24, null);
        borderCache2.imageBitmap = imageBitmapM7052ImageBitmapx__hDU$default;
        Canvas = androidx.compose.ui.graphics.CanvasKt.Canvas(imageBitmapM7052ImageBitmapx__hDU$default);
        borderCache2.canvas = Canvas;
        ?? r12 = imageBitmapM7052ImageBitmapx__hDU$default;
        Canvas canvas3 = Canvas;
        canvasDrawScope = borderCache2.canvasDrawScope;
        if (canvasDrawScope == null) {
            canvasDrawScope = new CanvasDrawScope();
            borderCache2.canvasDrawScope = canvasDrawScope;
        }
        CanvasDrawScope canvasDrawScope5 = canvasDrawScope;
        long jM9870toSizeozmzZPI2 = IntSizeKt.m9870toSizeozmzZPI(jM9853constructorimpl);
        LayoutDirection layoutDirection3 = cacheDrawScope.getLayoutDirection();
        CanvasDrawScope.DrawParams drawParams5 = canvasDrawScope5.getDrawParams();
        final Ref.ObjectRef objectRef5 = objectRef2;
        Density density2 = drawParams5.getDensity();
        LayoutDirection layoutDirection4 = drawParams5.getLayoutDirection();
        Canvas canvas4 = drawParams5.getCanvas();
        long size2 = drawParams5.getSize();
        CanvasDrawScope.DrawParams drawParams6 = canvasDrawScope5.getDrawParams();
        drawParams6.setDensity(cacheDrawScope);
        drawParams6.setLayoutDirection(layoutDirection3);
        drawParams6.setCanvas(canvas3);
        drawParams6.m7315setSizeuvyYCjk(jM9870toSizeozmzZPI2);
        canvas3.save();
        canvasDrawScope2 = canvasDrawScope5;
        DrawScope.m7389drawRectnJ9OG0$default(canvasDrawScope2, Color.INSTANCE.m6840getBlack0d7_KjU(), 0L, jM9870toSizeozmzZPI2, 0.0f, null, null, BlendMode.INSTANCE.m6727getClear0nO6VwU(), 58, null);
        f2 = -bounds.getLeft();
        f3 = -bounds.getTop();
        canvasDrawScope2.getDrawContext().getTransform().translate(f2, f3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit drawGenericBorder$lambda$0(Outline.Generic generic, Brush brush, ContentDrawScope contentDrawScope) {
        contentDrawScope.drawContent();
        DrawScope.m7384drawPathGBMwjPU$default(contentDrawScope, generic.getPath(), brush, 0.0f, null, null, 0, 60, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit drawGenericBorder$lambda$3(Rect rect, Ref.ObjectRef objectRef, long j, ColorFilter colorFilter, ContentDrawScope contentDrawScope) throws Throwable {
        float f;
        contentDrawScope.drawContent();
        ContentDrawScope contentDrawScope2 = contentDrawScope;
        float left = rect.getLeft();
        float top = rect.getTop();
        contentDrawScope2.getDrawContext().getTransform().translate(left, top);
        try {
            try {
                DrawScope.m7378drawImageAZ2fEMs$default(contentDrawScope2, (ImageBitmap) objectRef.element, 0L, j, 0L, 0L, 0.0f, null, colorFilter, 0, 0, 890, null);
                contentDrawScope2.getDrawContext().getTransform().translate(-left, -top);
                return Unit.INSTANCE;
            } catch (Throwable th) {
                th = th;
                left = left;
                f = top;
                contentDrawScope2.getDrawContext().getTransform().translate(-left, -f);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            f = top;
        }
    }

    /* JADX INFO: renamed from: drawRoundRectBorder-JqoCqck, reason: not valid java name */
    private final DrawResult m612drawRoundRectBorderJqoCqck(CacheDrawScope cacheDrawScope, final Brush brush, Outline.Rounded rounded, final long j, final long j2, final boolean z, final float f) {
        if (RoundRectKt.isSimple(rounded.getRoundRect())) {
            final long jM6619getTopLeftCornerRadiuskKHJgLs = rounded.getRoundRect().m6619getTopLeftCornerRadiuskKHJgLs();
            final float f2 = f / 2;
            final Stroke stroke = new Stroke(f, 0.0f, 0, 0, null, 30, null);
            return cacheDrawScope.onDrawWithContent(new Function1() { // from class: androidx.compose.foundation.BorderModifierNode$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BorderModifierNode.drawRoundRectBorder_JqoCqck$lambda$0(z, brush, jM6619getTopLeftCornerRadiuskKHJgLs, f2, f, j, j2, stroke, (ContentDrawScope) obj);
                }
            });
        }
        if (this.borderCache == null) {
            this.borderCache = new BorderCache(null, null, null, null, 15, null);
        }
        BorderCache borderCache = this.borderCache;
        Intrinsics.checkNotNull(borderCache);
        final Path pathCreateRoundRectPath = BorderKt.createRoundRectPath(borderCache.obtainPath(), rounded.getRoundRect(), f, z);
        return cacheDrawScope.onDrawWithContent(new Function1() { // from class: androidx.compose.foundation.BorderModifierNode$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BorderModifierNode.drawRoundRectBorder_JqoCqck$lambda$1(pathCreateRoundRectPath, brush, (ContentDrawScope) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit drawRoundRectBorder_JqoCqck$lambda$0(boolean z, Brush brush, long j, float f, float f2, long j2, long j3, Stroke stroke, ContentDrawScope contentDrawScope) {
        contentDrawScope.drawContent();
        if (z) {
            DrawScope.m7390drawRoundRectZuiqVtQ$default(contentDrawScope, brush, 0L, 0L, j, 0.0f, null, null, 0, 246, null);
        } else if (Float.intBitsToFloat((int) (j >> 32)) < f) {
            ContentDrawScope contentDrawScope2 = contentDrawScope;
            float fIntBitsToFloat = Float.intBitsToFloat((int) (contentDrawScope.mo7395getSizeNHjbRc() >> 32)) - f2;
            float fIntBitsToFloat2 = Float.intBitsToFloat((int) (contentDrawScope.mo7395getSizeNHjbRc() & 4294967295L)) - f2;
            int iM6802getDifferencertfAjoo = ClipOp.INSTANCE.m6802getDifferencertfAjoo();
            DrawContext drawContext = contentDrawScope2.getDrawContext();
            long jMo7316getSizeNHjbRc = drawContext.mo7316getSizeNHjbRc();
            drawContext.getCanvas().save();
            try {
                drawContext.getTransform().mo7319clipRectN_I0leg(f2, f2, fIntBitsToFloat, fIntBitsToFloat2, iM6802getDifferencertfAjoo);
                DrawScope.m7390drawRoundRectZuiqVtQ$default(contentDrawScope2, brush, 0L, 0L, j, 0.0f, null, null, 0, 246, null);
            } finally {
                drawContext.getCanvas().restore();
                drawContext.mo7317setSizeuvyYCjk(jMo7316getSizeNHjbRc);
            }
        } else {
            DrawScope.m7390drawRoundRectZuiqVtQ$default(contentDrawScope, brush, j2, j3, BorderKt.m608shrinkKibmq7A(j, f), 0.0f, stroke, null, 0, 208, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit drawRoundRectBorder_JqoCqck$lambda$1(Path path, Brush brush, ContentDrawScope contentDrawScope) {
        contentDrawScope.drawContent();
        DrawScope.m7384drawPathGBMwjPU$default(contentDrawScope, path, brush, 0.0f, null, null, 0, 60, null);
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setShape(semanticsPropertyReceiver, this.shape);
    }
}
