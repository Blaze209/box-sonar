package androidx.compose.material3;

import androidx.compose.runtime.MutableIntState;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: FloatingActionButtonMenu.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class FloatingActionButtonMenuKt$FloatingActionButtonMenu$1$1 implements MeasurePolicy {
    final /* synthetic */ MutableIntState $buttonHeight$delegate;
    final /* synthetic */ Alignment.Horizontal $horizontalAlignment;

    FloatingActionButtonMenuKt$FloatingActionButtonMenu$1$1(MutableIntState mutableIntState, Alignment.Horizontal horizontal) {
        this.$buttonHeight$delegate = mutableIntState;
        this.$horizontalAlignment = horizontal;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v6, types: [T, androidx.compose.ui.layout.Placeable] */
    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo344measure3p2s80s(final MeasureScope measureScope, List<? extends Measurable> list, long j) {
        int width;
        int height;
        final Placeable placeableMo8265measureBRTryo0 = list.get(0).mo8265measureBRTryo0(j);
        final int i = measureScope.mo748roundToPx0680j_4(FloatingActionButtonMenuKt.FabMenuButtonPaddingBottom);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (list.size() > 1) {
            objectRef.element = list.get(1).mo8265measureBRTryo0(j);
            this.$buttonHeight$delegate.setIntValue(((Placeable) objectRef.element).getHeight());
            width = Math.max(((Placeable) objectRef.element).getWidth(), placeableMo8265measureBRTryo0.getWidth());
            height = Math.max(((Placeable) objectRef.element).getHeight() + i, placeableMo8265measureBRTryo0.getHeight());
        } else {
            width = placeableMo8265measureBRTryo0.getWidth();
            height = placeableMo8265measureBRTryo0.getHeight();
        }
        final int iMin = Math.min(width, Constraints.m9640getMaxWidthimpl(j));
        final int iMin2 = Math.min(height, Constraints.m9639getMaxHeightimpl(j));
        final Alignment.Horizontal horizontal = this.$horizontalAlignment;
        return MeasureScope.layout$default(measureScope, iMin, iMin2, null, new Function1() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$FloatingActionButtonMenu$1$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FloatingActionButtonMenuKt$FloatingActionButtonMenu$1$1.measure_3p2s80s$lambda$0(horizontal, placeableMo8265measureBRTryo0, iMin, measureScope, objectRef, iMin2, i, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit measure_3p2s80s$lambda$0(Alignment.Horizontal horizontal, Placeable placeable, int i, MeasureScope measureScope, Ref.ObjectRef objectRef, int i2, int i3, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.place$default(placementScope, placeable, horizontal.align(placeable.getWidth(), i, measureScope.getLayoutDirection()), 0, 0.0f, 4, null);
        if (objectRef.element != 0) {
            Placeable.PlacementScope.place$default(placementScope, (Placeable) objectRef.element, horizontal.align(((Placeable) objectRef.element).getWidth(), i, measureScope.getLayoutDirection()), (i2 - ((Placeable) objectRef.element).getHeight()) - i3, 0.0f, 4, null);
        }
        return Unit.INSTANCE;
    }
}
