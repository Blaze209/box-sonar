package androidx.compose.material3;

import androidx.compose.ui.graphics.Shape;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ListItemDefaults.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJN\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003J!\u0010\u0013\u001a\u00020\u0003*\u0004\u0018\u00010\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0015H\u0000¢\u0006\u0002\b\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001c"}, d2 = {"Landroidx/compose/material3/ListItemShapes;", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "selectedShape", "pressedShape", "focusedShape", "hoveredShape", "draggedShape", "<init>", "(Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;)V", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "getSelectedShape", "getPressedShape", "getFocusedShape", "getHoveredShape", "getDraggedShape", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse$material3", "equals", "", "other", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ListItemShapes {
    public static final int $stable = 0;
    private final Shape draggedShape;
    private final Shape focusedShape;
    private final Shape hoveredShape;
    private final Shape pressedShape;
    private final Shape selectedShape;
    private final Shape shape;

    public ListItemShapes(Shape shape, Shape shape2, Shape shape3, Shape shape4, Shape shape5, Shape shape6) {
        this.shape = shape;
        this.selectedShape = shape2;
        this.pressedShape = shape3;
        this.focusedShape = shape4;
        this.hoveredShape = shape5;
        this.draggedShape = shape6;
    }

    public final Shape getShape() {
        return this.shape;
    }

    public final Shape getSelectedShape() {
        return this.selectedShape;
    }

    public final Shape getPressedShape() {
        return this.pressedShape;
    }

    public final Shape getFocusedShape() {
        return this.focusedShape;
    }

    public final Shape getHoveredShape() {
        return this.hoveredShape;
    }

    public final Shape getDraggedShape() {
        return this.draggedShape;
    }

    public static /* synthetic */ ListItemShapes copy$default(ListItemShapes listItemShapes, Shape shape, Shape shape2, Shape shape3, Shape shape4, Shape shape5, Shape shape6, int i, Object obj) {
        if ((i & 1) != 0) {
            shape = listItemShapes.shape;
        }
        if ((i & 2) != 0) {
            shape2 = listItemShapes.selectedShape;
        }
        if ((i & 4) != 0) {
            shape3 = listItemShapes.pressedShape;
        }
        if ((i & 8) != 0) {
            shape4 = listItemShapes.focusedShape;
        }
        if ((i & 16) != 0) {
            shape5 = listItemShapes.hoveredShape;
        }
        if ((i & 32) != 0) {
            shape6 = listItemShapes.draggedShape;
        }
        Shape shape7 = shape5;
        Shape shape8 = shape6;
        return listItemShapes.copy(shape, shape2, shape3, shape4, shape7, shape8);
    }

    public final ListItemShapes copy(Shape shape, Shape selectedShape, Shape pressedShape, Shape focusedShape, Shape hoveredShape, Shape draggedShape) {
        return new ListItemShapes(takeOrElse$material3(shape, new Function0() { // from class: androidx.compose.material3.ListItemShapes$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.shape;
            }
        }), takeOrElse$material3(selectedShape, new Function0() { // from class: androidx.compose.material3.ListItemShapes$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.selectedShape;
            }
        }), takeOrElse$material3(pressedShape, new Function0() { // from class: androidx.compose.material3.ListItemShapes$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.pressedShape;
            }
        }), takeOrElse$material3(focusedShape, new Function0() { // from class: androidx.compose.material3.ListItemShapes$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.focusedShape;
            }
        }), takeOrElse$material3(hoveredShape, new Function0() { // from class: androidx.compose.material3.ListItemShapes$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.hoveredShape;
            }
        }), takeOrElse$material3(draggedShape, new Function0() { // from class: androidx.compose.material3.ListItemShapes$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.draggedShape;
            }
        }));
    }

    public final Shape takeOrElse$material3(Shape shape, Function0<? extends Shape> function0) {
        return shape == null ? function0.invoke() : shape;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !(other instanceof ListItemShapes)) {
            return false;
        }
        ListItemShapes listItemShapes = (ListItemShapes) other;
        return Intrinsics.areEqual(this.shape, listItemShapes.shape) && Intrinsics.areEqual(this.selectedShape, listItemShapes.selectedShape) && Intrinsics.areEqual(this.pressedShape, listItemShapes.pressedShape) && Intrinsics.areEqual(this.focusedShape, listItemShapes.focusedShape) && Intrinsics.areEqual(this.hoveredShape, listItemShapes.hoveredShape) && Intrinsics.areEqual(this.draggedShape, listItemShapes.draggedShape);
    }

    public int hashCode() {
        return (((((((((this.shape.hashCode() * 31) + this.selectedShape.hashCode()) * 31) + this.pressedShape.hashCode()) * 31) + this.focusedShape.hashCode()) * 31) + this.hoveredShape.hashCode()) * 31) + this.draggedShape.hashCode();
    }
}
