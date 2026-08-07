package com.box.android.preview.previewtype.gif;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerInputChange;
import com.facebook.react.uimanager.ViewProps;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: GifZoomPosition.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0010¢\u0006\u0004\b\u0019\u0010\u001aJ5\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 ¢\u0006\u0004\b!\u0010\"J'\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0010H\u0002¢\u0006\u0004\b%\u0010&R+\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006("}, d2 = {"Lcom/box/android/preview/previewtype/gif/GifZoomPositionState;", "", "<init>", "()V", "<set-?>", "Lcom/box/android/preview/previewtype/gif/GifZoomPosition;", ViewProps.POSITION, "getPosition", "()Lcom/box/android/preview/previewtype/gif/GifZoomPosition;", "setPosition", "(Lcom/box/android/preview/previewtype/gif/GifZoomPosition;)V", "position$delegate", "Landroidx/compose/runtime/MutableState;", "updateCurrentPosition", "", "newScreenSize", "Landroidx/compose/ui/unit/IntSize;", "newContentSize", "updateCurrentPosition-TemP2vQ", "(JJ)V", "updatePositionOnDoubleClick", "tapOffset", "Landroidx/compose/ui/geometry/Offset;", "contentSize", "screenSize", "updatePositionOnDoubleClick-r-U8d4M", "(JJJ)V", "updatePositionOnPinch", "pan", "zoom", "", "event", "Landroidx/compose/ui/input/pointer/PointerEvent;", "updatePositionOnPinch-s0lP2Ac", "(JFJJLandroidx/compose/ui/input/pointer/PointerEvent;)V", "calculateMaxOffset", "scale", "calculateMaxOffset-xzClIrE", "(FJJ)J", "Companion", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GifZoomPositionState {
    public static final int $stable = 0;
    private static final float MAX_SCALE = 4.0f;
    private static final float MID_SCALE = 2.5f;
    private static final float MIN_SCALE = 1.0f;

    /* JADX INFO: renamed from: position$delegate, reason: from kotlin metadata */
    private final MutableState position = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new GifZoomPosition(1.0f, Offset.INSTANCE.m6585getZeroF1C5BW0(), null), null, 2, null);

    private final void setPosition(GifZoomPosition gifZoomPosition) {
        this.position.setValue(gifZoomPosition);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final GifZoomPosition getPosition() {
        return (GifZoomPosition) this.position.getValue();
    }

    /* JADX INFO: renamed from: updateCurrentPosition-TemP2vQ, reason: not valid java name */
    public final void m12945updateCurrentPositionTemP2vQ(long newScreenSize, long newContentSize) {
        long jM12944calculateMaxOffsetxzClIrE = m12944calculateMaxOffsetxzClIrE(getPosition().getScale(), newContentSize, newScreenSize);
        float fIntBitsToFloat = Float.intBitsToFloat((int) (jM12944calculateMaxOffsetxzClIrE >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jM12944calculateMaxOffsetxzClIrE & 4294967295L));
        float fCoerceIn = fIntBitsToFloat < 0.0f ? 0.0f : RangesKt.coerceIn(Float.intBitsToFloat((int) (getPosition().m12943getOffsetF1C5BW0() >> 32)), -fIntBitsToFloat, fIntBitsToFloat);
        float fCoerceIn2 = fIntBitsToFloat2 >= 0.0f ? RangesKt.coerceIn(Float.intBitsToFloat((int) (getPosition().m12943getOffsetF1C5BW0() & 4294967295L)), -fIntBitsToFloat2, fIntBitsToFloat2) : 0.0f;
        setPosition(GifZoomPosition.m12940copyUv8p0NA$default(getPosition(), 0.0f, Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(fCoerceIn2)) & 4294967295L) | (((long) Float.floatToRawIntBits(fCoerceIn)) << 32)), 1, null));
    }

    /* JADX INFO: renamed from: updatePositionOnDoubleClick-r-U8d4M, reason: not valid java name */
    public final void m12946updatePositionOnDoubleClickrU8d4M(long tapOffset, long contentSize, long screenSize) {
        float f;
        float scale = getPosition().getScale();
        if (RangesKt.rangeUntil(1.0f, MID_SCALE).contains(Float.valueOf(scale))) {
            f = 2.5f;
        } else {
            f = RangesKt.rangeUntil(MID_SCALE, 4.0f).contains(Float.valueOf(scale)) ? 4.0f : 1.0f;
        }
        long jM12944calculateMaxOffsetxzClIrE = m12944calculateMaxOffsetxzClIrE(f, contentSize, screenSize);
        float f2 = f;
        float fIntBitsToFloat = Float.intBitsToFloat((int) (jM12944calculateMaxOffsetxzClIrE >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jM12944calculateMaxOffsetxzClIrE & 4294967295L));
        setPosition(new GifZoomPosition(f2, Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat < 0.0f ? 0.0f : RangesKt.coerceIn((-(Float.intBitsToFloat((int) (tapOffset >> 32)) - (((int) (contentSize >> 32)) / 2.0f))) * f2, -fIntBitsToFloat, fIntBitsToFloat))) << 32) | (4294967295L & ((long) Float.floatToRawIntBits(fIntBitsToFloat2 >= 0.0f ? RangesKt.coerceIn((-(Float.intBitsToFloat((int) (tapOffset & 4294967295L)) - (((int) (contentSize & 4294967295L)) / 2.0f))) * f2, -fIntBitsToFloat2, fIntBitsToFloat2) : 0.0f)))), null));
    }

    /* JADX INFO: renamed from: updatePositionOnPinch-s0lP2Ac, reason: not valid java name */
    public final void m12947updatePositionOnPinchs0lP2Ac(long pan, float zoom, long contentSize, long screenSize, PointerEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        float fCoerceIn = RangesKt.coerceIn(getPosition().getScale() * zoom, 1.0f, 4.0f);
        long jM12944calculateMaxOffsetxzClIrE = m12944calculateMaxOffsetxzClIrE(fCoerceIn, contentSize, screenSize);
        float fIntBitsToFloat = Float.intBitsToFloat((int) (jM12944calculateMaxOffsetxzClIrE >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jM12944calculateMaxOffsetxzClIrE & 4294967295L));
        float fCoerceIn2 = fIntBitsToFloat < 0.0f ? 0.0f : RangesKt.coerceIn(Float.intBitsToFloat((int) (getPosition().m12943getOffsetF1C5BW0() >> 32)) + (Float.intBitsToFloat((int) (pan >> 32)) * fCoerceIn), -fIntBitsToFloat, fIntBitsToFloat);
        float fCoerceIn3 = fIntBitsToFloat2 >= 0.0f ? RangesKt.coerceIn(Float.intBitsToFloat((int) (getPosition().m12943getOffsetF1C5BW0() & 4294967295L)) + (Float.intBitsToFloat((int) (pan & 4294967295L)) * fCoerceIn), -fIntBitsToFloat2, fIntBitsToFloat2) : 0.0f;
        if (Math.abs(fCoerceIn2) < fIntBitsToFloat) {
            Iterator<T> it = event.getChanges().iterator();
            while (it.hasNext()) {
                ((PointerInputChange) it.next()).consume();
            }
        }
        setPosition(new GifZoomPosition(fCoerceIn, Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(fCoerceIn2)) << 32) | (((long) Float.floatToRawIntBits(fCoerceIn3)) & 4294967295L)), null));
    }

    /* JADX INFO: renamed from: calculateMaxOffset-xzClIrE, reason: not valid java name */
    private final long m12944calculateMaxOffsetxzClIrE(float scale, long contentSize, long screenSize) {
        float f = scale - 1;
        float f2 = (int) (contentSize >> 32);
        float f3 = (f * f2) + f2;
        float f4 = (int) (contentSize & 4294967295L);
        float f5 = (f * f4) + f4;
        float f6 = 2;
        return Offset.m6561constructorimpl((((long) Float.floatToRawIntBits((f3 - ((int) (screenSize >> 32))) / f6)) << 32) | (((long) Float.floatToRawIntBits((f5 - ((int) (screenSize & 4294967295L))) / f6)) & 4294967295L));
    }
}
