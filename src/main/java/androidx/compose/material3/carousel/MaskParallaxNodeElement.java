package androidx.compose.material3.carousel;

import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MultiAspectCarousel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\r\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\f\u0010\u0011\u001a\u00020\u000f*\u00020\u0012H\u0016J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0019"}, d2 = {"Landroidx/compose/material3/carousel/MaskParallaxNodeElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/material3/carousel/MaskParallaxNode;", "baseShape", "Landroidx/compose/ui/graphics/Shape;", "drawInfo", "Landroidx/compose/material3/carousel/MultiAspectCarouselItemDrawInfo;", "<init>", "(Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/carousel/MultiAspectCarouselItemDrawInfo;)V", "getBaseShape", "()Landroidx/compose/ui/graphics/Shape;", "getDrawInfo", "()Landroidx/compose/material3/carousel/MultiAspectCarouselItemDrawInfo;", PasskeyWebListener.CREATE_UNIQUE_KEY, "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "equals", "", "other", "", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class MaskParallaxNodeElement extends ModifierNodeElement<MaskParallaxNode> {
    private final Shape baseShape;
    private final MultiAspectCarouselItemDrawInfo drawInfo;

    public MaskParallaxNodeElement(Shape shape, MultiAspectCarouselItemDrawInfo multiAspectCarouselItemDrawInfo) {
        this.baseShape = shape;
        this.drawInfo = multiAspectCarouselItemDrawInfo;
    }

    public final Shape getBaseShape() {
        return this.baseShape;
    }

    public final MultiAspectCarouselItemDrawInfo getDrawInfo() {
        return this.drawInfo;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: create */
    public MaskParallaxNode getNode() {
        return new MaskParallaxNode(this.baseShape, this.drawInfo);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(MaskParallaxNode node) {
        node.getMaskShape().setBaseShape(this.baseShape);
        node.getMaskShape().setDrawInfo(this.drawInfo);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.setName("maskParallaxNodeElement");
        inspectorInfo.getProperties().set("baseShape", this.baseShape);
        inspectorInfo.getProperties().set("drawInfo", this.drawInfo);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MaskParallaxNodeElement)) {
            return false;
        }
        MaskParallaxNodeElement maskParallaxNodeElement = (MaskParallaxNodeElement) other;
        return Intrinsics.areEqual(this.baseShape, maskParallaxNodeElement.baseShape) && Intrinsics.areEqual(this.drawInfo, maskParallaxNodeElement.drawInfo);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return (this.baseShape.hashCode() * 31) + this.drawInfo.hashCode();
    }
}
