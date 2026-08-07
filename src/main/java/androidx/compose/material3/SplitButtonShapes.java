package androidx.compose.material3;

import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SplitButton.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0011"}, d2 = {"Landroidx/compose/material3/SplitButtonShapes;", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "pressedShape", "checkedShape", "<init>", "(Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;)V", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "getPressedShape", "getCheckedShape", "equals", "", "other", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SplitButtonShapes {
    public static final int $stable = 0;
    private final Shape checkedShape;
    private final Shape pressedShape;
    private final Shape shape;

    public SplitButtonShapes(Shape shape, Shape shape2, Shape shape3) {
        this.shape = shape;
        this.pressedShape = shape2;
        this.checkedShape = shape3;
    }

    public final Shape getCheckedShape() {
        return this.checkedShape;
    }

    public final Shape getPressedShape() {
        return this.pressedShape;
    }

    public final Shape getShape() {
        return this.shape;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !(other instanceof SplitButtonShapes)) {
            return false;
        }
        SplitButtonShapes splitButtonShapes = (SplitButtonShapes) other;
        return Intrinsics.areEqual(this.shape, splitButtonShapes.shape) && Intrinsics.areEqual(this.pressedShape, splitButtonShapes.pressedShape) && Intrinsics.areEqual(this.checkedShape, splitButtonShapes.checkedShape);
    }

    public int hashCode() {
        int iHashCode = this.shape.hashCode();
        Shape shape = this.pressedShape;
        if (shape != null) {
            iHashCode = (iHashCode * 31) + shape.hashCode();
        }
        Shape shape2 = this.checkedShape;
        return shape2 != null ? (iHashCode * 31) + shape2.hashCode() : iHashCode;
    }
}
