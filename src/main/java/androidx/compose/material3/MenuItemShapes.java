package androidx.compose.material3;

import androidx.compose.ui.graphics.Shape;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Menu.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003J!\u0010\u000b\u001a\u00020\u0003*\u0004\u0018\u00010\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\rH\u0000¢\u0006\u0002\b\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Landroidx/compose/material3/MenuItemShapes;", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "selectedShape", "<init>", "(Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;)V", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "getSelectedShape", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse$material3", "equals", "", "other", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MenuItemShapes {
    public static final int $stable = 0;
    private final Shape selectedShape;
    private final Shape shape;

    public MenuItemShapes(Shape shape, Shape shape2) {
        this.shape = shape;
        this.selectedShape = shape2;
    }

    public final Shape getSelectedShape() {
        return this.selectedShape;
    }

    public final Shape getShape() {
        return this.shape;
    }

    public static /* synthetic */ MenuItemShapes copy$default(MenuItemShapes menuItemShapes, Shape shape, Shape shape2, int i, Object obj) {
        if ((i & 1) != 0) {
            shape = menuItemShapes.shape;
        }
        if ((i & 2) != 0) {
            shape2 = menuItemShapes.selectedShape;
        }
        return menuItemShapes.copy(shape, shape2);
    }

    public final MenuItemShapes copy(Shape shape, Shape selectedShape) {
        return new MenuItemShapes(takeOrElse$material3(shape, new Function0() { // from class: androidx.compose.material3.MenuItemShapes$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.shape;
            }
        }), takeOrElse$material3(selectedShape, new Function0() { // from class: androidx.compose.material3.MenuItemShapes$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.selectedShape;
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
        if (other != null && (other instanceof MenuItemShapes)) {
            MenuItemShapes menuItemShapes = (MenuItemShapes) other;
            if (Intrinsics.areEqual(this.shape, menuItemShapes.shape) && Intrinsics.areEqual(this.selectedShape, menuItemShapes.selectedShape)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.shape.hashCode() * 31) + this.selectedShape.hashCode();
    }
}
