package androidx.compose.material3;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.material3.internal.AnimatedShapeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ListItemDefaults.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\u001aG\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u00012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0001¢\u0006\u0002\u0010\u0011\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"hasRoundedCornerShapes", "", "Landroidx/compose/material3/ListItemShapes;", "getHasRoundedCornerShapes$annotations", "(Landroidx/compose/material3/ListItemShapes;)V", "getHasRoundedCornerShapes", "(Landroidx/compose/material3/ListItemShapes;)Z", "shapeForInteraction", "Landroidx/compose/ui/graphics/Shape;", "selected", "pressed", "focused", "hovered", "dragged", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "(Landroidx/compose/material3/ListItemShapes;ZZZZZLandroidx/compose/animation/core/FiniteAnimationSpec;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ListItemDefaultsKt {
    private static /* synthetic */ void getHasRoundedCornerShapes$annotations(ListItemShapes listItemShapes) {
    }

    private static final boolean getHasRoundedCornerShapes(ListItemShapes listItemShapes) {
        return (listItemShapes.getShape() instanceof RoundedCornerShape) && (listItemShapes.getSelectedShape() instanceof RoundedCornerShape) && (listItemShapes.getPressedShape() instanceof RoundedCornerShape) && (listItemShapes.getFocusedShape() instanceof RoundedCornerShape) && (listItemShapes.getHoveredShape() instanceof RoundedCornerShape) && (listItemShapes.getDraggedShape() instanceof RoundedCornerShape);
    }

    public static final Shape shapeForInteraction(ListItemShapes listItemShapes, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, FiniteAnimationSpec<Float> finiteAnimationSpec, Composer composer, int i) {
        Shape shape;
        composer.startReplaceGroup(2080718032);
        ComposerKt.sourceInformation(composer, "C(shapeForInteraction)N(selected,pressed,focused,hovered,dragged,animationSpec):ListItemDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2080718032, i, -1, "androidx.compose.material3.shapeForInteraction (ListItemDefaults.kt:1049)");
        }
        if (z2) {
            shape = listItemShapes.getPressedShape();
        } else if (z5) {
            shape = listItemShapes.getDraggedShape();
        } else if (z) {
            shape = listItemShapes.getSelectedShape();
        } else if (z3) {
            shape = listItemShapes.getFocusedShape();
        } else if (z4) {
            shape = listItemShapes.getHoveredShape();
        } else {
            shape = listItemShapes.getShape();
        }
        if (!getHasRoundedCornerShapes(listItemShapes)) {
            composer.startReplaceGroup(1650479986);
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return shape;
        }
        composer.startReplaceGroup(1703365676);
        ComposerKt.sourceInformation(composer, "");
        composer.startMovableGroup(-1884714849, listItemShapes);
        ComposerKt.sourceInformation(composer, "1061@53337L65");
        Intrinsics.checkNotNull(shape, "null cannot be cast to non-null type androidx.compose.foundation.shape.RoundedCornerShape");
        Shape shapeRememberAnimatedShape = AnimatedShapeKt.rememberAnimatedShape((RoundedCornerShape) shape, finiteAnimationSpec, composer, (i >> 15) & 112);
        composer.endMovableGroup();
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return shapeRememberAnimatedShape;
    }
}
