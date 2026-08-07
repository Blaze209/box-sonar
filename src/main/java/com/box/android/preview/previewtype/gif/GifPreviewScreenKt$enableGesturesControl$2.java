package com.box.android.preview.previewtype.gif;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GifPreviewScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final class GifPreviewScreenKt$enableGesturesControl$2 implements PointerInputEventHandler {
    final /* synthetic */ Function4<Offset, Float, IntSize, PointerEvent, Unit> $onPinch;

    /* JADX WARN: Multi-variable type inference failed */
    GifPreviewScreenKt$enableGesturesControl$2(Function4<? super Offset, ? super Float, ? super IntSize, ? super PointerEvent, Unit> function4) {
        this.$onPinch = function4;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
    public final Object invoke(final PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        final Function4<Offset, Float, IntSize, PointerEvent, Unit> function4 = this.$onPinch;
        Object objDetectPlainTransformGestures = PointerInputScopeExtKt.detectPlainTransformGestures(pointerInputScope, new Function3() { // from class: com.box.android.preview.previewtype.gif.GifPreviewScreenKt$enableGesturesControl$2$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return GifPreviewScreenKt$enableGesturesControl$2.invoke$lambda$0(function4, pointerInputScope, (Offset) obj, ((Float) obj2).floatValue(), (PointerEvent) obj3);
            }
        }, continuation);
        return objDetectPlainTransformGestures == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectPlainTransformGestures : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$0(Function4 function4, PointerInputScope pointerInputScope, Offset offset, float f, PointerEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        function4.invoke(offset, Float.valueOf(f), IntSize.m9850boximpl(pointerInputScope.getBoundsSize()), event);
        return Unit.INSTANCE;
    }
}
