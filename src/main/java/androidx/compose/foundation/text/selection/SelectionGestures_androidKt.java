package androidx.compose.foundation.text.selection;

import android.view.MotionEvent;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.core.view.InputDeviceCompat;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: SelectionGestures.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"isMouseOrTouchPad", "", "Landroidx/compose/ui/input/pointer/PointerEvent;", "foundation"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SelectionGestures_androidKt {
    public static final boolean isMouseOrTouchPad(PointerEvent pointerEvent) {
        MotionEvent motionEvent;
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        for (int i = 0; i < size; i++) {
            if (!PointerType.m8205equalsimpl0(changes.get(i).getType(), PointerType.INSTANCE.m8210getMouseT8wyACA())) {
                MotionEvent motionEvent2 = pointerEvent.getMotionEvent();
                if ((motionEvent2 == null || !motionEvent2.isFromSource(8194)) && ((motionEvent = pointerEvent.getMotionEvent()) == null || !motionEvent.isFromSource(InputDeviceCompat.SOURCE_TOUCHPAD))) {
                    return false;
                }
            }
        }
        return true;
    }
}
