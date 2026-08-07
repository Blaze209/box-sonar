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
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WideNavigationRail.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"androidx/compose/material3/WideNavigationRailKt$ModalWideNavigationRailContent$railFlingBehavior$1$1", "Landroidx/compose/foundation/gestures/FlingBehavior;", "performFling", "", "Landroidx/compose/foundation/gestures/ScrollScope;", "initialVelocity", "(Landroidx/compose/foundation/gestures/ScrollScope;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WideNavigationRailKt$ModalWideNavigationRailContent$railFlingBehavior$1$1 implements FlingBehavior {
    final /* synthetic */ TargetedFlingBehavior $anchoredDraggableFlingBehavior;
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $modalAnimateToDismiss;

    /* JADX WARN: Multi-variable type inference failed */
    WideNavigationRailKt$ModalWideNavigationRailContent$railFlingBehavior$1$1(TargetedFlingBehavior targetedFlingBehavior, Function1<? super Continuation<? super Unit>, ? extends Object> function1) {
        this.$anchoredDraggableFlingBehavior = targetedFlingBehavior;
        this.$modalAnimateToDismiss = function1;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // androidx.compose.foundation.gestures.FlingBehavior
    public Object performFling(ScrollScope scrollScope, float f, Continuation<? super Float> continuation) throws Throwable {
        WideNavigationRailKt$ModalWideNavigationRailContent$railFlingBehavior$1$1$performFling$1 wideNavigationRailKt$ModalWideNavigationRailContent$railFlingBehavior$1$1$performFling$1;
        float f2;
        if (continuation instanceof WideNavigationRailKt$ModalWideNavigationRailContent$railFlingBehavior$1$1$performFling$1) {
            wideNavigationRailKt$ModalWideNavigationRailContent$railFlingBehavior$1$1$performFling$1 = (WideNavigationRailKt$ModalWideNavigationRailContent$railFlingBehavior$1$1$performFling$1) continuation;
            if ((wideNavigationRailKt$ModalWideNavigationRailContent$railFlingBehavior$1$1$performFling$1.label & Integer.MIN_VALUE) != 0) {
                wideNavigationRailKt$ModalWideNavigationRailContent$railFlingBehavior$1$1$performFling$1.label -= Integer.MIN_VALUE;
            } else {
                wideNavigationRailKt$ModalWideNavigationRailContent$railFlingBehavior$1$1$performFling$1 = new WideNavigationRailKt$ModalWideNavigationRailContent$railFlingBehavior$1$1$performFling$1(this, continuation);
            }
        } else {
            wideNavigationRailKt$ModalWideNavigationRailContent$railFlingBehavior$1$1$performFling$1 = new WideNavigationRailKt$ModalWideNavigationRailContent$railFlingBehavior$1$1$performFling$1(this, continuation);
        }
        Object objPerformFling = wideNavigationRailKt$ModalWideNavigationRailContent$railFlingBehavior$1$1$performFling$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = wideNavigationRailKt$ModalWideNavigationRailContent$railFlingBehavior$1$1$performFling$1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objPerformFling);
                TargetedFlingBehavior targetedFlingBehavior = this.$anchoredDraggableFlingBehavior;
                wideNavigationRailKt$ModalWideNavigationRailContent$railFlingBehavior$1$1$performFling$1.label = 1;
                objPerformFling = targetedFlingBehavior.performFling(scrollScope, f, wideNavigationRailKt$ModalWideNavigationRailContent$railFlingBehavior$1$1$performFling$1);
                if (objPerformFling == coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                ResultKt.throwOnFailure(objPerformFling);
            } else {
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Throwable th = (Throwable) wideNavigationRailKt$ModalWideNavigationRailContent$railFlingBehavior$1$1$performFling$1.L$0;
                    ResultKt.throwOnFailure(objPerformFling);
                    throw th;
                }
                f2 = wideNavigationRailKt$ModalWideNavigationRailContent$railFlingBehavior$1$1$performFling$1.F$0;
                ResultKt.throwOnFailure(objPerformFling);
            }
            return Boxing.boxFloat(f2);
            float fFloatValue = ((Number) objPerformFling).floatValue();
            Function1<Continuation<? super Unit>, Object> function1 = this.$modalAnimateToDismiss;
            wideNavigationRailKt$ModalWideNavigationRailContent$railFlingBehavior$1$1$performFling$1.F$0 = fFloatValue;
            wideNavigationRailKt$ModalWideNavigationRailContent$railFlingBehavior$1$1$performFling$1.label = 2;
            if (function1.invoke(wideNavigationRailKt$ModalWideNavigationRailContent$railFlingBehavior$1$1$performFling$1) != coroutine_suspended) {
                f2 = fFloatValue;
                return Boxing.boxFloat(f2);
            }
        } catch (Throwable th2) {
            Function1<Continuation<? super Unit>, Object> function2 = this.$modalAnimateToDismiss;
            wideNavigationRailKt$ModalWideNavigationRailContent$railFlingBehavior$1$1$performFling$1.L$0 = th2;
            wideNavigationRailKt$ModalWideNavigationRailContent$railFlingBehavior$1$1$performFling$1.label = 3;
            if (function2.invoke(wideNavigationRailKt$ModalWideNavigationRailContent$railFlingBehavior$1$1$performFling$1) != coroutine_suspended) {
                throw th2;
            }
        }
        return coroutine_suspended;
    }
}
