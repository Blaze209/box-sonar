package com.box.android.base.compose;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: SimpleBottomSheet.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final class SimpleBottomSheetKt$SimpleBottomSheet$4$2$2$1 implements PointerInputEventHandler {
    final /* synthetic */ float $dismissPosition;
    final /* synthetic */ Animatable<Float, AnimationVector1D> $offsetY;
    final /* synthetic */ Function0<Unit> $onDismissRequest;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ MutableFloatState $topBarPosition$delegate;

    SimpleBottomSheetKt$SimpleBottomSheet$4$2$2$1(float f, Function0<Unit> function0, CoroutineScope coroutineScope, MutableFloatState mutableFloatState, Animatable<Float, AnimationVector1D> animatable) {
        this.$dismissPosition = f;
        this.$onDismissRequest = function0;
        this.$scope = coroutineScope;
        this.$topBarPosition$delegate = mutableFloatState;
        this.$offsetY = animatable;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        final float f = this.$dismissPosition;
        final Function0<Unit> function0 = this.$onDismissRequest;
        final CoroutineScope coroutineScope = this.$scope;
        final MutableFloatState mutableFloatState = this.$topBarPosition$delegate;
        final Animatable<Float, AnimationVector1D> animatable = this.$offsetY;
        Function0 function1 = new Function0() { // from class: com.box.android.base.compose.SimpleBottomSheetKt$SimpleBottomSheet$4$2$2$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SimpleBottomSheetKt$SimpleBottomSheet$4$2$2$1.invoke$lambda$0(f, function0, coroutineScope, mutableFloatState, animatable);
            }
        };
        final CoroutineScope coroutineScope2 = this.$scope;
        final Animatable<Float, AnimationVector1D> animatable2 = this.$offsetY;
        Object objDetectVerticalDragGestures$default = DragGestureDetectorKt.detectVerticalDragGestures$default(pointerInputScope, null, function1, null, new Function2() { // from class: com.box.android.base.compose.SimpleBottomSheetKt$SimpleBottomSheet$4$2$2$1$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return SimpleBottomSheetKt$SimpleBottomSheet$4$2$2$1.invoke$lambda$1(coroutineScope2, animatable2, (PointerInputChange) obj, ((Float) obj2).floatValue());
            }
        }, continuation, 5, null);
        return objDetectVerticalDragGestures$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectVerticalDragGestures$default : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1(CoroutineScope coroutineScope, Animatable animatable, PointerInputChange pointerInputChange, float f) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "<unused var>");
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new SimpleBottomSheetKt$SimpleBottomSheet$4$2$2$1$2$1(animatable, f, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$0(float f, Function0 function0, CoroutineScope coroutineScope, MutableFloatState mutableFloatState, Animatable animatable) {
        if (SimpleBottomSheetKt.SimpleBottomSheet$lambda$3(mutableFloatState) <= f) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new SimpleBottomSheetKt$SimpleBottomSheet$4$2$2$1$1$1(animatable, null), 3, null);
        } else {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }
}
