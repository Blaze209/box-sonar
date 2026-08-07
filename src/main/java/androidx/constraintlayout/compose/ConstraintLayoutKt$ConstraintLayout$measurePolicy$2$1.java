package androidx.constraintlayout.compose;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ConstraintLayout.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;"}, k = 3, mv = {1, 8, 0}, xi = 176)
public final class ConstraintLayoutKt$ConstraintLayout$measurePolicy$2$1 implements MeasurePolicy {
    final /* synthetic */ ConstraintSet $constraintSet;
    final /* synthetic */ MutableState<Unit> $contentTracker;
    final /* synthetic */ Measurer $measurer;
    final /* synthetic */ int $optimizationLevel;

    public ConstraintLayoutKt$ConstraintLayout$measurePolicy$2$1(MutableState<Unit> mutableState, Measurer measurer, ConstraintSet constraintSet, int i) {
        this.$contentTracker = mutableState;
        this.$measurer = measurer;
        this.$constraintSet = constraintSet;
        this.$optimizationLevel = i;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo344measure3p2s80s(MeasureScope measureScope, final List<? extends Measurable> list, long j) {
        this.$contentTracker.getValue();
        long jM10087performMeasure2eBlSMk = this.$measurer.m10087performMeasure2eBlSMk(j, measureScope.getLayoutDirection(), this.$constraintSet, list, this.$optimizationLevel);
        int iM9858getWidthimpl = IntSize.m9858getWidthimpl(jM10087performMeasure2eBlSMk);
        int iM9857getHeightimpl = IntSize.m9857getHeightimpl(jM10087performMeasure2eBlSMk);
        final Measurer measurer = this.$measurer;
        return MeasureScope.layout$default(measureScope, iM9858getWidthimpl, iM9857getHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.constraintlayout.compose.ConstraintLayoutKt$ConstraintLayout$measurePolicy$2$1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope placementScope) {
                measurer.performLayout(placementScope, list);
            }
        }, 4, null);
    }
}
