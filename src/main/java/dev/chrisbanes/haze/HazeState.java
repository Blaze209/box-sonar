package dev.chrisbanes.haze;

import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Haze.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u000eJ\u0015\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0010R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR*\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00128F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b\u0014\u0010\u0003\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R.\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u0011\u001a\u0004\u0018\u00010\u00198F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b\u001b\u0010\u0003\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Ldev/chrisbanes/haze/HazeState;", "", "<init>", "()V", "_areas", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Ldev/chrisbanes/haze/HazeArea;", "areas", "", "getAreas", "()Ljava/util/List;", "addArea", "", "area", "addArea$haze_release", "removeArea", "removeArea$haze_release", "value", "Landroidx/compose/ui/geometry/Offset;", "positionOnScreen", "getPositionOnScreen-F1C5BW0$annotations", "getPositionOnScreen-F1C5BW0", "()J", "setPositionOnScreen-k-4lQ0M", "(J)V", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "contentLayer", "getContentLayer$annotations", "getContentLayer", "()Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "setContentLayer", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "haze_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HazeState {
    public static final int $stable = 0;
    private final SnapshotStateList<HazeArea> _areas = SnapshotStateKt.mutableStateListOf();

    @Deprecated(message = "Inspect areas instead")
    public static /* synthetic */ void getContentLayer$annotations() {
    }

    @Deprecated(message = "Inspect areas instead")
    /* JADX INFO: renamed from: getPositionOnScreen-F1C5BW0$annotations, reason: not valid java name */
    public static /* synthetic */ void m14493getPositionOnScreenF1C5BW0$annotations() {
    }

    public final List<HazeArea> getAreas() {
        return this._areas.toList();
    }

    public final void addArea$haze_release(HazeArea area) {
        Intrinsics.checkNotNullParameter(area, "area");
        this._areas.add(area);
    }

    public final void removeArea$haze_release(HazeArea area) {
        Intrinsics.checkNotNullParameter(area, "area");
        this._areas.remove(area);
    }

    /* JADX INFO: renamed from: getPositionOnScreen-F1C5BW0, reason: not valid java name */
    public final long m14494getPositionOnScreenF1C5BW0() {
        HazeArea hazeArea = (HazeArea) CollectionsKt.firstOrNull((List) getAreas());
        return hazeArea != null ? hazeArea.m14447getPositionOnScreenF1C5BW0() : Offset.INSTANCE.m6584getUnspecifiedF1C5BW0();
    }

    /* JADX INFO: renamed from: setPositionOnScreen-k-4lQ0M, reason: not valid java name */
    public final void m14495setPositionOnScreenk4lQ0M(long j) {
        HazeArea hazeArea = (HazeArea) CollectionsKt.firstOrNull((List) getAreas());
        if (hazeArea != null) {
            hazeArea.m14449setPositionOnScreenk4lQ0M$haze_release(j);
        }
    }

    public final GraphicsLayer getContentLayer() {
        HazeArea hazeArea = (HazeArea) CollectionsKt.firstOrNull((List) getAreas());
        if (hazeArea != null) {
            return hazeArea.getContentLayer();
        }
        return null;
    }

    public final void setContentLayer(GraphicsLayer graphicsLayer) {
        HazeArea hazeArea = (HazeArea) CollectionsKt.firstOrNull((List) getAreas());
        if (hazeArea != null) {
            hazeArea.setContentLayer$haze_release(graphicsLayer);
        }
    }
}
