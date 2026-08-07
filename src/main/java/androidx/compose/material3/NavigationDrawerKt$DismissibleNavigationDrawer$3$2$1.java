package androidx.compose.material3;

import androidx.compose.foundation.gestures.AnchoredDraggableKt;
import androidx.compose.foundation.gestures.AnchoredDraggableState;
import androidx.compose.foundation.gestures.DraggableAnchorsConfig;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: NavigationDrawer.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class NavigationDrawerKt$DismissibleNavigationDrawer$3$2$1 implements MeasurePolicy {
    final /* synthetic */ MutableState<Boolean> $anchorsInitialized$delegate;
    final /* synthetic */ DrawerState $drawerState;

    NavigationDrawerKt$DismissibleNavigationDrawer$3$2$1(DrawerState drawerState, MutableState<Boolean> mutableState) {
        this.$drawerState = drawerState;
        this.$anchorsInitialized$delegate = mutableState;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo344measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        final Placeable placeableMo8265measureBRTryo0 = list.get(0).mo8265measureBRTryo0(j);
        final Placeable placeableMo8265measureBRTryo1 = list.get(1).mo8265measureBRTryo0(j);
        int width = placeableMo8265measureBRTryo1.getWidth();
        int height = placeableMo8265measureBRTryo1.getHeight();
        final DrawerState drawerState = this.$drawerState;
        final MutableState<Boolean> mutableState = this.$anchorsInitialized$delegate;
        return MeasureScope.layout$default(measureScope, width, height, null, new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$3$2$1$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NavigationDrawerKt$DismissibleNavigationDrawer$3$2$1.measure_3p2s80s$lambda$0(drawerState, placeableMo8265measureBRTryo0, placeableMo8265measureBRTryo1, mutableState, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$0(DrawerState drawerState, Placeable placeable, Placeable placeable2, MutableState mutableState, Placeable.PlacementScope placementScope) {
        float fPositionOf = drawerState.getAnchoredDraggableState$material3().getAnchors().positionOf(DrawerValue.Closed);
        final float f = -placeable.getWidth();
        if (!NavigationDrawerKt.DismissibleNavigationDrawer$lambda$1(mutableState) || fPositionOf != f) {
            if (!NavigationDrawerKt.DismissibleNavigationDrawer$lambda$1(mutableState)) {
                NavigationDrawerKt.DismissibleNavigationDrawer$lambda$2(mutableState, true);
            }
            AnchoredDraggableState.updateAnchors$default(drawerState.getAnchoredDraggableState$material3(), AnchoredDraggableKt.DraggableAnchors(new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$3$2$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return NavigationDrawerKt$DismissibleNavigationDrawer$3$2$1.measure_3p2s80s$lambda$0$0(f, (DraggableAnchorsConfig) obj);
                }
            }), null, 2, null);
        }
        int width = placeable.getWidth() + MathKt.roundToInt(drawerState.requireOffset$material3());
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, width, 0, 0.0f, 4, null);
        if (width != 0) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable, MathKt.roundToInt(drawerState.requireOffset$material3()), 0, 0.0f, 4, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$0$0(float f, DraggableAnchorsConfig draggableAnchorsConfig) {
        draggableAnchorsConfig.at(DrawerValue.Closed, f);
        draggableAnchorsConfig.at(DrawerValue.Open, 0.0f);
        return Unit.INSTANCE;
    }
}
