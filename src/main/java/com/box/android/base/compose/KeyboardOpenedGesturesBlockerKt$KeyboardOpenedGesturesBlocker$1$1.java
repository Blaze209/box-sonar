package com.box.android.base.compose;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: KeyboardOpenedGesturesBlocker.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final class KeyboardOpenedGesturesBlockerKt$KeyboardOpenedGesturesBlocker$1$1 implements PointerInputEventHandler {
    final /* synthetic */ SoftwareKeyboardController $keyboard;

    KeyboardOpenedGesturesBlockerKt$KeyboardOpenedGesturesBlocker$1$1(SoftwareKeyboardController softwareKeyboardController) {
        this.$keyboard = softwareKeyboardController;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$0(SoftwareKeyboardController softwareKeyboardController, Offset offset) {
        if (softwareKeyboardController != null) {
            softwareKeyboardController.hide();
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        final SoftwareKeyboardController softwareKeyboardController = this.$keyboard;
        Object objDetectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, null, new Function1() { // from class: com.box.android.base.compose.KeyboardOpenedGesturesBlockerKt$KeyboardOpenedGesturesBlocker$1$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return KeyboardOpenedGesturesBlockerKt$KeyboardOpenedGesturesBlocker$1$1.invoke$lambda$0(softwareKeyboardController, (Offset) obj);
            }
        }, continuation, 7, null);
        return objDetectTapGestures$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectTapGestures$default : Unit.INSTANCE;
    }
}
