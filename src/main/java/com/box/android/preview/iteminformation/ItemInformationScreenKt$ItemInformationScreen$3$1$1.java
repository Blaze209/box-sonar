package com.box.android.preview.iteminformation;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ItemInformationScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final class ItemInformationScreenKt$ItemInformationScreen$3$1$1 implements PointerInputEventHandler {
    final /* synthetic */ FocusManager $focusManager;

    ItemInformationScreenKt$ItemInformationScreen$3$1$1(FocusManager focusManager) {
        this.$focusManager = focusManager;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        final FocusManager focusManager = this.$focusManager;
        Object objDetectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, null, new Function1() { // from class: com.box.android.preview.iteminformation.ItemInformationScreenKt$ItemInformationScreen$3$1$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ItemInformationScreenKt$ItemInformationScreen$3$1$1.invoke$lambda$0(focusManager, (Offset) obj);
            }
        }, continuation, 7, null);
        return objDetectTapGestures$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectTapGestures$default : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$0(FocusManager focusManager, Offset offset) {
        FocusManager.clearFocus$default(focusManager, false, 1, null);
        return Unit.INSTANCE;
    }
}
