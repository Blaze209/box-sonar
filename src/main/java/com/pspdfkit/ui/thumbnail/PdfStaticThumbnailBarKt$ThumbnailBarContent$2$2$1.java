package com.pspdfkit.ui.thumbnail;

import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class PdfStaticThumbnailBarKt$ThumbnailBarContent$2$2$1 implements PointerInputEventHandler {
    final /* synthetic */ Function1<ThumbnailBarEvent, Unit> $onEvent;

    /* JADX WARN: Multi-variable type inference failed */
    public PdfStaticThumbnailBarKt$ThumbnailBarContent$2$2$1(Function1<? super ThumbnailBarEvent, Unit> function1) {
        this.$onEvent = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$0(Function1 function1, PointerInputChange pointerInputChange, Offset offset) {
        pointerInputChange.getClass();
        function1.invoke(new ThumbnailBarEvent.ThumbnailScrolled((int) Float.intBitsToFloat((int) (pointerInputChange.getPosition() >> 32)), (int) Float.intBitsToFloat((int) (pointerInputChange.getPosition() & 4294967295L))));
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        final Function1<ThumbnailBarEvent, Unit> function1 = this.$onEvent;
        Object objDetectDragGestures$default = DragGestureDetectorKt.detectDragGestures$default(pointerInputScope, null, null, null, new Function2() { // from class: com.pspdfkit.ui.thumbnail.PdfStaticThumbnailBarKt$ThumbnailBarContent$2$2$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return PdfStaticThumbnailBarKt$ThumbnailBarContent$2$2$1.invoke$lambda$0(function1, (PointerInputChange) obj, (Offset) obj2);
            }
        }, continuation, 7, null);
        return objDetectDragGestures$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectDragGestures$default : Unit.INSTANCE;
    }
}
