package com.pspdfkit.ui.thumbnail;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class PdfStaticThumbnailBarKt$ThumbnailBarContent$2$1$1 implements PointerInputEventHandler {
    final /* synthetic */ Function1<ThumbnailBarEvent, Unit> $onEvent;

    /* JADX WARN: Multi-variable type inference failed */
    public PdfStaticThumbnailBarKt$ThumbnailBarContent$2$1$1(Function1<? super ThumbnailBarEvent, Unit> function1) {
        this.$onEvent = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$0(Function1 function1, Offset offset) {
        function1.invoke(new ThumbnailBarEvent.ThumbnailScrolled((int) Float.intBitsToFloat((int) (offset.m6579unboximpl() >> 32)), (int) Float.intBitsToFloat((int) (offset.m6579unboximpl() & 4294967295L))));
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        final Function1<ThumbnailBarEvent, Unit> function1 = this.$onEvent;
        Object objDetectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, null, new Function1() { // from class: com.pspdfkit.ui.thumbnail.PdfStaticThumbnailBarKt$ThumbnailBarContent$2$1$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PdfStaticThumbnailBarKt$ThumbnailBarContent$2$1$1.invoke$lambda$0(function1, (Offset) obj);
            }
        }, continuation, 7, null);
        return objDetectTapGestures$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectTapGestures$default : Unit.INSTANCE;
    }
}
