package androidx.compose.material.internal;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ExposedDropdownMenuPopup.android.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ExposedDropdownMenuPopup_androidKt$SimpleStack$1$1 implements MeasurePolicy {
    public static final ExposedDropdownMenuPopup_androidKt$SimpleStack$1$1 INSTANCE = new ExposedDropdownMenuPopup_androidKt$SimpleStack$1$1();

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo344measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        int i;
        int i2;
        int size = list.size();
        if (size == 0) {
            return MeasureScope.layout$default(measureScope, 0, 0, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.internal.ExposedDropdownMenuPopup_androidKt$SimpleStack$1$1.1
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Placeable.PlacementScope placementScope) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                    invoke2(placementScope);
                    return Unit.INSTANCE;
                }
            }, 4, null);
        }
        int i3 = 0;
        if (size == 1) {
            final Placeable placeableMo8265measureBRTryo0 = list.get(0).mo8265measureBRTryo0(j);
            return MeasureScope.layout$default(measureScope, placeableMo8265measureBRTryo0.getWidth(), placeableMo8265measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.internal.ExposedDropdownMenuPopup_androidKt$SimpleStack$1$1.2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                    invoke2(placementScope);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Placeable.PlacementScope placementScope) {
                    Placeable.PlacementScope.placeRelative$default(placementScope, placeableMo8265measureBRTryo0, 0, 0, 0.0f, 4, null);
                }
            }, 4, null);
        }
        ArrayList arrayList = new ArrayList(list.size());
        int size2 = list.size();
        for (int i4 = 0; i4 < size2; i4++) {
            arrayList.add(list.get(i4).mo8265measureBRTryo0(j));
        }
        final ArrayList arrayList2 = arrayList;
        int lastIndex = CollectionsKt.getLastIndex(arrayList2);
        if (lastIndex >= 0) {
            int iMax = 0;
            int iMax2 = 0;
            while (true) {
                Placeable placeable = (Placeable) arrayList2.get(i3);
                iMax = Math.max(iMax, placeable.getWidth());
                iMax2 = Math.max(iMax2, placeable.getHeight());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
            i = iMax;
            i2 = iMax2;
        } else {
            i = 0;
            i2 = 0;
        }
        return MeasureScope.layout$default(measureScope, i, i2, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.internal.ExposedDropdownMenuPopup_androidKt$SimpleStack$1$1.3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope placementScope) {
                int lastIndex2 = CollectionsKt.getLastIndex(arrayList2);
                if (lastIndex2 < 0) {
                    return;
                }
                int i5 = 0;
                while (true) {
                    Placeable.PlacementScope placementScope2 = placementScope;
                    Placeable.PlacementScope.placeRelative$default(placementScope2, arrayList2.get(i5), 0, 0, 0.0f, 4, null);
                    if (i5 == lastIndex2) {
                        return;
                    }
                    i5++;
                    placementScope = placementScope2;
                }
            }
        }, 4, null);
    }
}
