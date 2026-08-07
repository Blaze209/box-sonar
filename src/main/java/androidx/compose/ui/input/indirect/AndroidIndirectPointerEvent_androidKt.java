package androidx.compose.ui.input.indirect;

import android.view.InputDevice;
import android.view.MotionEvent;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerId;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AndroidIndirectPointerEvent.android.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\u001a-\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0000¢\u0006\u0002\u0010\u0010\u001a\u0015\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0001H\u0000¢\u0006\u0002\u0010\u0012\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u000e\u0010\u0013\u001a\u00020\u0014X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"nativeEvent", "Landroid/view/MotionEvent;", "Landroidx/compose/ui/input/indirect/IndirectPointerEvent;", "getNativeEvent", "(Landroidx/compose/ui/input/indirect/IndirectPointerEvent;)Landroid/view/MotionEvent;", "IndirectPointerEvent", "motionEvent", "primaryDirectionalMotionAxis", "Landroidx/compose/ui/input/indirect/IndirectPointerEventPrimaryDirectionalMotionAxis;", "previousMotionEvent", "IndirectPointerEvent-eAXfkT4", "(Landroid/view/MotionEvent;ILandroid/view/MotionEvent;)Landroidx/compose/ui/input/indirect/IndirectPointerEvent;", "convertActionToIndirectPointerEventType", "Landroidx/compose/ui/input/indirect/IndirectPointerEventType;", "actionMasked", "", "(I)I", "indirectPrimaryDirectionalScrollAxis", "(Landroid/view/MotionEvent;)I", "RATIO_CUTOFF", "", "ui"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AndroidIndirectPointerEvent_androidKt {
    private static final float RATIO_CUTOFF = 5.0f;

    public static final MotionEvent getNativeEvent(IndirectPointerEvent indirectPointerEvent) {
        Intrinsics.checkNotNull(indirectPointerEvent, "null cannot be cast to non-null type androidx.compose.ui.input.indirect.AndroidIndirectPointerEvent");
        return ((AndroidIndirectPointerEvent) indirectPointerEvent).getNativeEvent();
    }

    /* JADX INFO: renamed from: IndirectPointerEvent-eAXfkT4$default, reason: not valid java name */
    public static /* synthetic */ IndirectPointerEvent m7639IndirectPointerEventeAXfkT4$default(MotionEvent motionEvent, int i, MotionEvent motionEvent2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = IndirectPointerEventPrimaryDirectionalMotionAxis.INSTANCE.m7647getNonenZO2Niw();
        }
        if ((i2 & 4) != 0) {
            motionEvent2 = null;
        }
        return m7638IndirectPointerEventeAXfkT4(motionEvent, i, motionEvent2);
    }

    /* JADX INFO: renamed from: IndirectPointerEvent-eAXfkT4, reason: not valid java name */
    public static final IndirectPointerEvent m7638IndirectPointerEventeAXfkT4(MotionEvent motionEvent, int i, MotionEvent motionEvent2) {
        int actionIndex;
        long jM6561constructorimpl;
        long eventTime;
        boolean z;
        MotionEvent motionEvent3 = motionEvent;
        MotionEvent motionEvent4 = motionEvent2;
        int actionMasked = motionEvent3.getActionMasked();
        if (actionMasked != 1) {
            actionIndex = actionMasked != 6 ? -1 : motionEvent3.getActionIndex();
        } else {
            actionIndex = 0;
        }
        Integer numValueOf = motionEvent4 != null ? Integer.valueOf(motionEvent4.getActionMasked()) : null;
        boolean z2 = (numValueOf != null && numValueOf.intValue() == 0) || (numValueOf != null && numValueOf.intValue() == 5) || (numValueOf != null && numValueOf.intValue() == 2);
        long eventTime2 = motionEvent3.getEventTime();
        int pointerCount = motionEvent3.getPointerCount();
        ArrayList arrayList = new ArrayList(pointerCount);
        int i2 = 0;
        while (i2 < pointerCount) {
            int pointerId = motionEvent3.getPointerId(i2);
            long jM8114constructorimpl = PointerId.m8114constructorimpl(pointerId);
            long jM6561constructorimpl2 = Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(motionEvent3.getX(i2))) << 32) | (((long) Float.floatToRawIntBits(motionEvent3.getY(i2))) & 4294967295L));
            actionIndex = actionIndex;
            boolean z3 = i2 != actionIndex;
            int iFindPointerIndex = motionEvent4 != null ? motionEvent4.findPointerIndex(pointerId) : -1;
            if (iFindPointerIndex >= 0) {
                Intrinsics.checkNotNull(motionEvent4);
                eventTime = motionEvent4.getEventTime();
                jM6561constructorimpl = Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(motionEvent4.getX(iFindPointerIndex))) << 32) | (((long) Float.floatToRawIntBits(motionEvent4.getY(iFindPointerIndex))) & 4294967295L));
                z = z2;
            } else {
                jM6561constructorimpl = jM6561constructorimpl2;
                eventTime = eventTime2;
                z = false;
            }
            long j = jM6561constructorimpl;
            ArrayList arrayList2 = arrayList;
            arrayList2.add(new IndirectPointerInputChange(jM8114constructorimpl, eventTime2, jM6561constructorimpl2, z3, motionEvent.getPressure(i2), eventTime, j, z, null));
            i2++;
            arrayList = arrayList2;
            pointerCount = pointerCount;
            motionEvent3 = motionEvent;
            actionMasked = actionMasked;
            motionEvent4 = motionEvent2;
        }
        return new AndroidIndirectPointerEvent(arrayList, convertActionToIndirectPointerEventType(actionMasked), i, motionEvent, null);
    }

    public static final int convertActionToIndirectPointerEventType(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    return IndirectPointerEventType.INSTANCE.m7657getMove4ZHQPSE();
                }
                if (i != 5) {
                    if (i != 6) {
                        return IndirectPointerEventType.INSTANCE.m7660getUnknown4ZHQPSE();
                    }
                }
            }
            return IndirectPointerEventType.INSTANCE.m7659getRelease4ZHQPSE();
        }
        return IndirectPointerEventType.INSTANCE.m7658getPress4ZHQPSE();
    }

    public static final int indirectPrimaryDirectionalScrollAxis(MotionEvent motionEvent) {
        if (!motionEvent.isFromSource(2097152)) {
            throw new IllegalArgumentException("MotionEvent must be a touch navigation source".toString());
        }
        InputDevice device = motionEvent.getDevice();
        if (device != null) {
            InputDevice.MotionRange motionRange = device.getMotionRange(0);
            InputDevice.MotionRange motionRange2 = device.getMotionRange(1);
            if (motionRange != null && motionRange2 == null) {
                return IndirectPointerEventPrimaryDirectionalMotionAxis.INSTANCE.m7648getXnZO2Niw();
            }
            if (motionRange2 != null && motionRange == null) {
                return IndirectPointerEventPrimaryDirectionalMotionAxis.INSTANCE.m7649getYnZO2Niw();
            }
            if (motionRange != null && motionRange2 != null) {
                float range = motionRange.getRange();
                float range2 = motionRange2.getRange();
                if (range > range2 && (range2 == 0.0f || range / range2 >= RATIO_CUTOFF)) {
                    return IndirectPointerEventPrimaryDirectionalMotionAxis.INSTANCE.m7648getXnZO2Niw();
                }
                if (range2 > range && (range == 0.0f || range2 / range >= RATIO_CUTOFF)) {
                    return IndirectPointerEventPrimaryDirectionalMotionAxis.INSTANCE.m7649getYnZO2Niw();
                }
            }
        }
        return IndirectPointerEventPrimaryDirectionalMotionAxis.INSTANCE.m7647getNonenZO2Niw();
    }
}
