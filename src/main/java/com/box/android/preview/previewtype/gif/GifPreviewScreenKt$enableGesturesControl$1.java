package com.box.android.preview.previewtype.gif;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: GifPreviewScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final class GifPreviewScreenKt$enableGesturesControl$1 implements PointerInputEventHandler {
    final /* synthetic */ Function0<Unit> $onClick;
    final /* synthetic */ Function2<Offset, IntSize, Unit> $onDoubleClick;

    /* JADX WARN: Multi-variable type inference failed */
    GifPreviewScreenKt$enableGesturesControl$1(Function2<? super Offset, ? super IntSize, Unit> function2, Function0<Unit> function0) {
        this.$onDoubleClick = function2;
        this.$onClick = function0;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
    public final Object invoke(final PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        final Function2<Offset, IntSize, Unit> function2 = this.$onDoubleClick;
        Function1 function1 = new Function1() { // from class: com.box.android.preview.previewtype.gif.GifPreviewScreenKt$enableGesturesControl$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GifPreviewScreenKt$enableGesturesControl$1.invoke$lambda$0(function2, pointerInputScope, (Offset) obj);
            }
        };
        final Function0<Unit> function0 = this.$onClick;
        Object objDetectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, function1, null, null, new Function1() { // from class: com.box.android.preview.previewtype.gif.GifPreviewScreenKt$enableGesturesControl$1$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GifPreviewScreenKt$enableGesturesControl$1.invoke$lambda$1(function0, (Offset) obj);
            }
        }, continuation, 6, null);
        return objDetectTapGestures$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectTapGestures$default : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1(Function0 function0, Offset offset) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$0(Function2 function2, PointerInputScope pointerInputScope, Offset offset) {
        function2.invoke(offset, IntSize.m9850boximpl(pointerInputScope.getBoundsSize()));
        return Unit.INSTANCE;
    }
}
