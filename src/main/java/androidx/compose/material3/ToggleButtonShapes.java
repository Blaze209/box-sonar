package androidx.compose.material3;

import androidx.compose.ui.graphics.Shape;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ToggleButton.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003J!\u0010\r\u001a\u00020\u0003*\u0004\u0018\u00010\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fH\u0000¢\u0006\u0002\b\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Landroidx/compose/material3/ToggleButtonShapes;", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "pressedShape", "checkedShape", "<init>", "(Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;)V", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "getPressedShape", "getCheckedShape", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse$material3", "equals", "", "other", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ToggleButtonShapes {
    public static final int $stable = 0;
    private final Shape checkedShape;
    private final Shape pressedShape;
    private final Shape shape;

    public ToggleButtonShapes(Shape shape, Shape shape2, Shape shape3) {
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

    public static /* synthetic */ ToggleButtonShapes copy$default(ToggleButtonShapes toggleButtonShapes, Shape shape, Shape shape2, Shape shape3, int i, Object obj) {
        if ((i & 1) != 0) {
            shape = toggleButtonShapes.shape;
        }
        if ((i & 2) != 0) {
            shape2 = toggleButtonShapes.pressedShape;
        }
        if ((i & 4) != 0) {
            shape3 = toggleButtonShapes.checkedShape;
        }
        return toggleButtonShapes.copy(shape, shape2, shape3);
    }

    public final ToggleButtonShapes copy(Shape shape, Shape pressedShape, Shape checkedShape) {
        return new ToggleButtonShapes(takeOrElse$material3(shape, new Function0() { // from class: androidx.compose.material3.ToggleButtonShapes$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.shape;
            }
        }), takeOrElse$material3(pressedShape, new Function0() { // from class: androidx.compose.material3.ToggleButtonShapes$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.pressedShape;
            }
        }), takeOrElse$material3(checkedShape, new Function0() { // from class: androidx.compose.material3.ToggleButtonShapes$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.checkedShape;
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
        if (other == null || !(other instanceof ToggleButtonShapes)) {
            return false;
        }
        ToggleButtonShapes toggleButtonShapes = (ToggleButtonShapes) other;
        return Intrinsics.areEqual(this.shape, toggleButtonShapes.shape) && Intrinsics.areEqual(this.pressedShape, toggleButtonShapes.pressedShape) && Intrinsics.areEqual(this.checkedShape, toggleButtonShapes.checkedShape);
    }

    public int hashCode() {
        return (((this.shape.hashCode() * 31) + this.pressedShape.hashCode()) * 31) + this.checkedShape.hashCode();
    }
}
