package androidx.compose.material3.carousel;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;

/* JADX INFO: compiled from: MultiAspectCarousel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0002\u001a\u00020\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Landroidx/compose/material3/carousel/MaskShape;", "Landroidx/compose/ui/graphics/Shape;", "baseShape", "drawInfo", "Landroidx/compose/material3/carousel/MultiAspectCarouselItemDrawInfo;", "<init>", "(Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/carousel/MultiAspectCarouselItemDrawInfo;)V", "getBaseShape", "()Landroidx/compose/ui/graphics/Shape;", "setBaseShape", "(Landroidx/compose/ui/graphics/Shape;)V", "getDrawInfo", "()Landroidx/compose/material3/carousel/MultiAspectCarouselItemDrawInfo;", "setDrawInfo", "(Landroidx/compose/material3/carousel/MultiAspectCarouselItemDrawInfo;)V", "path", "Landroidx/compose/ui/graphics/Path;", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "size", "Landroidx/compose/ui/geometry/Size;", ViewProps.LAYOUT_DIRECTION, "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "createOutline-Pq9zytI", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;)Landroidx/compose/ui/graphics/Outline;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class MaskShape implements Shape {
    private Shape baseShape;
    private MultiAspectCarouselItemDrawInfo drawInfo;
    private final Path path = AndroidPath_androidKt.Path();

    public MaskShape(Shape shape, MultiAspectCarouselItemDrawInfo multiAspectCarouselItemDrawInfo) {
        this.baseShape = shape;
        this.drawInfo = multiAspectCarouselItemDrawInfo;
    }

    public final Shape getBaseShape() {
        return this.baseShape;
    }

    public final MultiAspectCarouselItemDrawInfo getDrawInfo() {
        return this.drawInfo;
    }

    public final void setBaseShape(Shape shape) {
        this.baseShape = shape;
    }

    public final void setDrawInfo(MultiAspectCarouselItemDrawInfo multiAspectCarouselItemDrawInfo) {
        this.drawInfo = multiAspectCarouselItemDrawInfo;
    }

    @Override // androidx.compose.ui.graphics.Shape
    /* JADX INFO: renamed from: createOutline-Pq9zytI */
    public Outline mo655createOutlinePq9zytI(long size, LayoutDirection layoutDirection, Density density) {
        Rect rect;
        Path path = this.path;
        path.reset();
        Rect rectM6659toRectuvyYCjk = SizeKt.m6659toRectuvyYCjk(size);
        if (this.drawInfo.getSize() != 0.0f) {
            if (this.drawInfo.isHorizontal()) {
                rect = new Rect(this.drawInfo.getMaskStart(), rectM6659toRectuvyYCjk.getTop(), this.drawInfo.getMaskEnd(), rectM6659toRectuvyYCjk.getBottom());
            } else {
                rect = new Rect(rectM6659toRectuvyYCjk.getLeft(), this.drawInfo.getMaskStart(), rectM6659toRectuvyYCjk.getRight(), this.drawInfo.getMaskEnd());
            }
            rectM6659toRectuvyYCjk = rect;
        }
        OutlineKt.addOutline(path, this.baseShape.mo655createOutlinePq9zytI(rectM6659toRectuvyYCjk.m6602getSizeNHjbRc(), layoutDirection, density));
        float left = rectM6659toRectuvyYCjk.getLeft();
        path.mo6706translatek4lQ0M(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(rectM6659toRectuvyYCjk.getTop())) & 4294967295L) | (((long) Float.floatToRawIntBits(left)) << 32)));
        path.close();
        return this.path.isEmpty() ? new Outline.Rectangle(SizeKt.m6659toRectuvyYCjk(size)) : new Outline.Generic(this.path);
    }
}
