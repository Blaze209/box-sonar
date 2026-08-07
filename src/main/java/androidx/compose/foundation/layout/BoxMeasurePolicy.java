package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: Box.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J)\u0010\b\u001a\u00020\t*\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0012\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÂ\u0003J\u001d\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Landroidx/compose/foundation/layout/BoxMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "alignment", "Landroidx/compose/ui/Alignment;", "propagateMinConstraints", "", "<init>", "(Landroidx/compose/ui/Alignment;Z)V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
final /* data */ class BoxMeasurePolicy implements MeasurePolicy {
    private final Alignment alignment;
    private final boolean propagateMinConstraints;

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final Alignment getAlignment() {
        return this.alignment;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    private final boolean getPropagateMinConstraints() {
        return this.propagateMinConstraints;
    }

    public static /* synthetic */ BoxMeasurePolicy copy$default(BoxMeasurePolicy boxMeasurePolicy, Alignment alignment, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            alignment = boxMeasurePolicy.alignment;
        }
        if ((i & 2) != 0) {
            z = boxMeasurePolicy.propagateMinConstraints;
        }
        return boxMeasurePolicy.copy(alignment, z);
    }

    public final BoxMeasurePolicy copy(Alignment alignment, boolean propagateMinConstraints) {
        return new BoxMeasurePolicy(alignment, propagateMinConstraints);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BoxMeasurePolicy)) {
            return false;
        }
        BoxMeasurePolicy boxMeasurePolicy = (BoxMeasurePolicy) other;
        return Intrinsics.areEqual(this.alignment, boxMeasurePolicy.alignment) && this.propagateMinConstraints == boxMeasurePolicy.propagateMinConstraints;
    }

    public int hashCode() {
        return (this.alignment.hashCode() * 31) + Boolean.hashCode(this.propagateMinConstraints);
    }

    public String toString() {
        return "BoxMeasurePolicy(alignment=" + this.alignment + ", propagateMinConstraints=" + this.propagateMinConstraints + ')';
    }

    public BoxMeasurePolicy(Alignment alignment, boolean z) {
        this.alignment = alignment;
        this.propagateMinConstraints = z;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo344measure3p2s80s(final MeasureScope measureScope, final List<? extends Measurable> list, long j) {
        int iM9642getMinWidthimpl;
        int iM9641getMinHeightimpl;
        Placeable placeableMo8265measureBRTryo0;
        if (list.isEmpty()) {
            return MeasureScope.layout$default(measureScope, Constraints.m9642getMinWidthimpl(j), Constraints.m9641getMinHeightimpl(j), null, new Function1() { // from class: androidx.compose.foundation.layout.BoxMeasurePolicy$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BoxMeasurePolicy.measure_3p2s80s$lambda$0((Placeable.PlacementScope) obj);
                }
            }, 4, null);
        }
        long jM9628constructorimpl = this.propagateMinConstraints ? j : Constraints.m9628constructorimpl(j & ConstraintsKt.MaxDimensionsAndFocusMask);
        if (list.size() == 1) {
            final Measurable measurable = list.get(0);
            if (!BoxKt.getMatchesParentSize(measurable)) {
                placeableMo8265measureBRTryo0 = measurable.mo8265measureBRTryo0(jM9628constructorimpl);
                iM9642getMinWidthimpl = Math.max(Constraints.m9642getMinWidthimpl(j), placeableMo8265measureBRTryo0.getWidth());
                iM9641getMinHeightimpl = Math.max(Constraints.m9641getMinHeightimpl(j), placeableMo8265measureBRTryo0.getHeight());
            } else {
                iM9642getMinWidthimpl = Constraints.m9642getMinWidthimpl(j);
                iM9641getMinHeightimpl = Constraints.m9641getMinHeightimpl(j);
                placeableMo8265measureBRTryo0 = measurable.mo8265measureBRTryo0(Constraints.INSTANCE.m9650fixedJhjzzOo(Constraints.m9642getMinWidthimpl(j), Constraints.m9641getMinHeightimpl(j)));
            }
            final int i = iM9642getMinWidthimpl;
            final int i2 = iM9641getMinHeightimpl;
            final Placeable placeable = placeableMo8265measureBRTryo0;
            return MeasureScope.layout$default(measureScope, i, i2, null, new Function1() { // from class: androidx.compose.foundation.layout.BoxMeasurePolicy$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BoxMeasurePolicy.measure_3p2s80s$lambda$1(placeable, measurable, measureScope, i, i2, this, (Placeable.PlacementScope) obj);
                }
            }, 4, null);
        }
        final Placeable[] placeableArr = new Placeable[list.size()];
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = Constraints.m9642getMinWidthimpl(j);
        final Ref.IntRef intRef2 = new Ref.IntRef();
        intRef2.element = Constraints.m9641getMinHeightimpl(j);
        List<? extends Measurable> list2 = list;
        int size = list2.size();
        boolean z = false;
        for (int i3 = 0; i3 < size; i3++) {
            Measurable measurable2 = list.get(i3);
            if (BoxKt.getMatchesParentSize(measurable2)) {
                z = true;
            } else {
                Placeable placeableMo8265measureBRTryo1 = measurable2.mo8265measureBRTryo0(jM9628constructorimpl);
                placeableArr[i3] = placeableMo8265measureBRTryo1;
                intRef.element = Math.max(intRef.element, placeableMo8265measureBRTryo1.getWidth());
                intRef2.element = Math.max(intRef2.element, placeableMo8265measureBRTryo1.getHeight());
            }
        }
        if (z) {
            long jConstraints = ConstraintsKt.Constraints(intRef.element != Integer.MAX_VALUE ? intRef.element : 0, intRef.element, intRef2.element != Integer.MAX_VALUE ? intRef2.element : 0, intRef2.element);
            int size2 = list2.size();
            for (int i4 = 0; i4 < size2; i4++) {
                Measurable measurable3 = list.get(i4);
                if (BoxKt.getMatchesParentSize(measurable3)) {
                    placeableArr[i4] = measurable3.mo8265measureBRTryo0(jConstraints);
                }
            }
        }
        return MeasureScope.layout$default(measureScope, intRef.element, intRef2.element, null, new Function1() { // from class: androidx.compose.foundation.layout.BoxMeasurePolicy$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BoxMeasurePolicy.measure_3p2s80s$lambda$4(placeableArr, list, measureScope, intRef, intRef2, this, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$0(Placeable.PlacementScope placementScope) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$1(Placeable placeable, Measurable measurable, MeasureScope measureScope, int i, int i2, BoxMeasurePolicy boxMeasurePolicy, Placeable.PlacementScope placementScope) {
        BoxKt.placeInBox(placementScope, placeable, measurable, measureScope.getLayoutDirection(), i, i2, boxMeasurePolicy.alignment);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$4(Placeable[] placeableArr, List list, MeasureScope measureScope, Ref.IntRef intRef, Ref.IntRef intRef2, BoxMeasurePolicy boxMeasurePolicy, Placeable.PlacementScope placementScope) {
        int length = placeableArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            Placeable placeable = placeableArr[i];
            Intrinsics.checkNotNull(placeable, "null cannot be cast to non-null type androidx.compose.ui.layout.Placeable");
            BoxKt.placeInBox(placementScope, placeable, (Measurable) list.get(i2), measureScope.getLayoutDirection(), intRef.element, intRef2.element, boxMeasurePolicy.alignment);
            i++;
            i2++;
        }
        return Unit.INSTANCE;
    }
}
