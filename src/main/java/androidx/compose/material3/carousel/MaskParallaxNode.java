package androidx.compose.material3.carousel;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: MultiAspectCarousel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ#\u0010\u0012\u001a\u00020\u0013*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\f\u0010\u001b\u001a\u00020\u001c*\u00020\u001dH\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Landroidx/compose/material3/carousel/MaskParallaxNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "baseShape", "Landroidx/compose/ui/graphics/Shape;", "drawInfo", "Landroidx/compose/material3/carousel/MultiAspectCarouselItemDrawInfo;", "<init>", "(Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/carousel/MultiAspectCarouselItemDrawInfo;)V", "getDrawInfo", "()Landroidx/compose/material3/carousel/MultiAspectCarouselItemDrawInfo;", "setDrawInfo", "(Landroidx/compose/material3/carousel/MultiAspectCarouselItemDrawInfo;)V", "maskShape", "Landroidx/compose/material3/carousel/MaskShape;", "getMaskShape", "()Landroidx/compose/material3/carousel/MaskShape;", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "draw", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class MaskParallaxNode extends Modifier.Node implements LayoutModifierNode, DrawModifierNode {
    private MultiAspectCarouselItemDrawInfo drawInfo;
    private final MaskShape maskShape;

    public MaskParallaxNode(Shape shape, MultiAspectCarouselItemDrawInfo multiAspectCarouselItemDrawInfo) {
        this.drawInfo = multiAspectCarouselItemDrawInfo;
        this.maskShape = new MaskShape(shape, this.drawInfo);
    }

    public final MultiAspectCarouselItemDrawInfo getDrawInfo() {
        return this.drawInfo;
    }

    public final void setDrawInfo(MultiAspectCarouselItemDrawInfo multiAspectCarouselItemDrawInfo) {
        this.drawInfo = multiAspectCarouselItemDrawInfo;
    }

    public final MaskShape getMaskShape() {
        return this.maskShape;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo372measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        final Placeable placeableMo8265measureBRTryo0 = measurable.mo8265measureBRTryo0(j);
        return MeasureScope.layout$default(measureScope, placeableMo8265measureBRTryo0.getWidth(), placeableMo8265measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.material3.carousel.MaskParallaxNode$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MaskParallaxNode.measure_3p2s80s$lambda$0(placeableMo8265measureBRTryo0, this, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$0(Placeable placeable, final MaskParallaxNode maskParallaxNode, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.placeWithLayer$default(placementScope, placeable, 0, 0, 0.0f, new Function1() { // from class: androidx.compose.material3.carousel.MaskParallaxNode$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MaskParallaxNode.measure_3p2s80s$lambda$0$0(this.f$0, (GraphicsLayerScope) obj);
            }
        }, 4, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$0$0(MaskParallaxNode maskParallaxNode, GraphicsLayerScope graphicsLayerScope) {
        graphicsLayerScope.setClip(true);
        graphicsLayerScope.setShape(maskParallaxNode.maskShape);
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        if (this.drawInfo.isHorizontal()) {
            ContentDrawScope contentDrawScope2 = contentDrawScope;
            float parallax = this.drawInfo.getParallax();
            contentDrawScope2.getDrawContext().getTransform().translate(parallax, 0.0f);
            try {
                contentDrawScope.drawContent();
                return;
            } finally {
                contentDrawScope2.getDrawContext().getTransform().translate(-parallax, -0.0f);
            }
        }
        ContentDrawScope contentDrawScope3 = contentDrawScope;
        float parallax2 = this.drawInfo.getParallax();
        contentDrawScope3.getDrawContext().getTransform().translate(0.0f, parallax2);
        try {
            contentDrawScope.drawContent();
        } finally {
            contentDrawScope3.getDrawContext().getTransform().translate(-0.0f, -parallax2);
        }
    }
}
