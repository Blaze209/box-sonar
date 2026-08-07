package dev.chrisbanes.haze;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;

/* JADX INFO: compiled from: Haze.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u00101\u001a\u000202H\u0016R+\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r8F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR+\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u00128F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R(\u0010\u001b\u001a\u0004\u0018\u00010\u00012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR/\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\u0004\u001a\u0004\u0018\u00010 8F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b&\u0010\f\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0016\u0010'\u001a\u0004\u0018\u00010(8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020,X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u00063"}, d2 = {"Ldev/chrisbanes/haze/HazeArea;", "", "<init>", "()V", "<set-?>", "Landroidx/compose/ui/geometry/Offset;", "positionOnScreen", "getPositionOnScreen-F1C5BW0", "()J", "setPositionOnScreen-k-4lQ0M$haze_release", "(J)V", "positionOnScreen$delegate", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/geometry/Size;", "size", "getSize-NH-jbRc", "setSize-uvyYCjk$haze_release", "size$delegate", "", ViewProps.Z_INDEX, "getZIndex", "()F", "setZIndex$haze_release", "(F)V", "zIndex$delegate", "Landroidx/compose/runtime/MutableFloatState;", "value", "key", "getKey", "()Ljava/lang/Object;", "setKey$haze_release", "(Ljava/lang/Object;)V", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "contentLayer", "getContentLayer", "()Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "setContentLayer$haze_release", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "contentLayer$delegate", "bounds", "Landroidx/compose/ui/geometry/Rect;", "getBounds$haze_release", "()Landroidx/compose/ui/geometry/Rect;", "contentDrawing", "", "getContentDrawing$haze_release", "()Z", "setContentDrawing$haze_release", "(Z)V", "toString", "", "haze_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HazeArea {
    public static final int $stable = 0;
    private boolean contentDrawing;
    private Object key;

    /* JADX INFO: renamed from: positionOnScreen$delegate, reason: from kotlin metadata */
    private final MutableState positionOnScreen = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m6558boximpl(Offset.INSTANCE.m6584getUnspecifiedF1C5BW0()), null, 2, null);

    /* JADX INFO: renamed from: size$delegate, reason: from kotlin metadata */
    private final MutableState size = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Size.m6626boximpl(Size.INSTANCE.m6646getUnspecifiedNHjbRc()), null, 2, null);

    /* JADX INFO: renamed from: zIndex$delegate, reason: from kotlin metadata */
    private final MutableFloatState zIndex = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);

    /* JADX INFO: renamed from: contentLayer$delegate, reason: from kotlin metadata */
    private final MutableState contentLayer = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getPositionOnScreen-F1C5BW0, reason: not valid java name */
    public final long m14447getPositionOnScreenF1C5BW0() {
        return ((Offset) this.positionOnScreen.getValue()).m6579unboximpl();
    }

    /* JADX INFO: renamed from: setPositionOnScreen-k-4lQ0M$haze_release, reason: not valid java name */
    public final void m14449setPositionOnScreenk4lQ0M$haze_release(long j) {
        this.positionOnScreen.setValue(Offset.m6558boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
    public final long m14448getSizeNHjbRc() {
        return ((Size) this.size.getValue()).m6643unboximpl();
    }

    /* JADX INFO: renamed from: setSize-uvyYCjk$haze_release, reason: not valid java name */
    public final void m14450setSizeuvyYCjk$haze_release(long j) {
        this.size.setValue(Size.m6626boximpl(j));
    }

    public final float getZIndex() {
        return this.zIndex.getFloatValue();
    }

    public final void setZIndex$haze_release(float f) {
        this.zIndex.setFloatValue(f);
    }

    public final Object getKey() {
        return this.key;
    }

    public final void setKey$haze_release(Object obj) {
        this.key = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final GraphicsLayer getContentLayer() {
        return (GraphicsLayer) this.contentLayer.getValue();
    }

    public final void setContentLayer$haze_release(GraphicsLayer graphicsLayer) {
        this.contentLayer.setValue(graphicsLayer);
    }

    public final Rect getBounds$haze_release() {
        if (m14448getSizeNHjbRc() == InlineClassHelperKt.UnspecifiedPackedFloats || !OffsetKt.m6588isSpecifiedk4lQ0M(m14447getPositionOnScreenF1C5BW0())) {
            return null;
        }
        return RectKt.m6609Recttz77jQw(m14447getPositionOnScreenF1C5BW0(), m14448getSizeNHjbRc());
    }

    /* JADX INFO: renamed from: getContentDrawing$haze_release, reason: from getter */
    public final boolean getContentDrawing() {
        return this.contentDrawing;
    }

    public final void setContentDrawing$haze_release(boolean z) {
        this.contentDrawing = z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("HazeArea(");
        sb.append("positionOnScreen=" + Offset.m6577toStringimpl(m14447getPositionOnScreenF1C5BW0()) + ", ");
        sb.append("size=" + Size.m6642toStringimpl(m14448getSizeNHjbRc()) + ", ");
        sb.append("zIndex=" + getZIndex() + ", ");
        sb.append("contentLayer=" + getContentLayer() + ", ");
        sb.append("contentDrawing=" + this.contentDrawing);
        sb.append(")");
        return sb.toString();
    }
}
