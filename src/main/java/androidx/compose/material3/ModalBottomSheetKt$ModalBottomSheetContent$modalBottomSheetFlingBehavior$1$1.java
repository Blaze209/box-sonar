package androidx.compose.material3;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ModalBottomSheet.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"androidx/compose/material3/ModalBottomSheetKt$ModalBottomSheetContent$modalBottomSheetFlingBehavior$1$1", "Landroidx/compose/foundation/gestures/FlingBehavior;", "performFling", "", "Landroidx/compose/foundation/gestures/ScrollScope;", "initialVelocity", "(Landroidx/compose/foundation/gestures/ScrollScope;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ModalBottomSheetKt$ModalBottomSheetContent$modalBottomSheetFlingBehavior$1$1 implements FlingBehavior {
    final /* synthetic */ TargetedFlingBehavior $anchoredDraggableFlingBehavior;
    final /* synthetic */ Function0<Unit> $onDismissRequest;
    final /* synthetic */ SheetState $sheetState;

    ModalBottomSheetKt$ModalBottomSheetContent$modalBottomSheetFlingBehavior$1$1(TargetedFlingBehavior targetedFlingBehavior, SheetState sheetState, Function0<Unit> function0) {
        this.$anchoredDraggableFlingBehavior = targetedFlingBehavior;
        this.$sheetState = sheetState;
        this.$onDismissRequest = function0;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // androidx.compose.foundation.gestures.FlingBehavior
    public Object performFling(ScrollScope scrollScope, float f, Continuation<? super Float> continuation) {
        ModalBottomSheetKt$ModalBottomSheetContent$modalBottomSheetFlingBehavior$1$1$performFling$1 modalBottomSheetKt$ModalBottomSheetContent$modalBottomSheetFlingBehavior$1$1$performFling$1;
        if (continuation instanceof ModalBottomSheetKt$ModalBottomSheetContent$modalBottomSheetFlingBehavior$1$1$performFling$1) {
            modalBottomSheetKt$ModalBottomSheetContent$modalBottomSheetFlingBehavior$1$1$performFling$1 = (ModalBottomSheetKt$ModalBottomSheetContent$modalBottomSheetFlingBehavior$1$1$performFling$1) continuation;
            if ((modalBottomSheetKt$ModalBottomSheetContent$modalBottomSheetFlingBehavior$1$1$performFling$1.label & Integer.MIN_VALUE) != 0) {
                modalBottomSheetKt$ModalBottomSheetContent$modalBottomSheetFlingBehavior$1$1$performFling$1.label -= Integer.MIN_VALUE;
            } else {
                modalBottomSheetKt$ModalBottomSheetContent$modalBottomSheetFlingBehavior$1$1$performFling$1 = new ModalBottomSheetKt$ModalBottomSheetContent$modalBottomSheetFlingBehavior$1$1$performFling$1(this, continuation);
            }
        } else {
            modalBottomSheetKt$ModalBottomSheetContent$modalBottomSheetFlingBehavior$1$1$performFling$1 = new ModalBottomSheetKt$ModalBottomSheetContent$modalBottomSheetFlingBehavior$1$1$performFling$1(this, continuation);
        }
        Object objPerformFling = modalBottomSheetKt$ModalBottomSheetContent$modalBottomSheetFlingBehavior$1$1$performFling$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = modalBottomSheetKt$ModalBottomSheetContent$modalBottomSheetFlingBehavior$1$1$performFling$1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objPerformFling);
                TargetedFlingBehavior targetedFlingBehavior = this.$anchoredDraggableFlingBehavior;
                modalBottomSheetKt$ModalBottomSheetContent$modalBottomSheetFlingBehavior$1$1$performFling$1.label = 1;
                objPerformFling = targetedFlingBehavior.performFling(scrollScope, f, modalBottomSheetKt$ModalBottomSheetContent$modalBottomSheetFlingBehavior$1$1$performFling$1);
                if (objPerformFling == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objPerformFling);
            }
            float fFloatValue = ((Number) objPerformFling).floatValue();
            if (!this.$sheetState.isVisible()) {
                this.$onDismissRequest.invoke();
            }
            return Boxing.boxFloat(fFloatValue);
        } catch (Throwable th) {
            if (!this.$sheetState.isVisible()) {
                this.$onDismissRequest.invoke();
            }
            throw th;
        }
    }
}
