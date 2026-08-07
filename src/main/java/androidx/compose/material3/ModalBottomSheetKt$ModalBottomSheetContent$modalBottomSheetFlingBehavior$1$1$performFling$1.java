package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: ModalBottomSheet.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.ModalBottomSheetKt$ModalBottomSheetContent$modalBottomSheetFlingBehavior$1$1", f = "ModalBottomSheet.kt", i = {}, l = {248}, m = "performFling", n = {}, s = {}, v = 1)
final class ModalBottomSheetKt$ModalBottomSheetContent$modalBottomSheetFlingBehavior$1$1$performFling$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ModalBottomSheetKt$ModalBottomSheetContent$modalBottomSheetFlingBehavior$1$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ModalBottomSheetKt$ModalBottomSheetContent$modalBottomSheetFlingBehavior$1$1$performFling$1(ModalBottomSheetKt$ModalBottomSheetContent$modalBottomSheetFlingBehavior$1$1 modalBottomSheetKt$ModalBottomSheetContent$modalBottomSheetFlingBehavior$1$1, Continuation<? super ModalBottomSheetKt$ModalBottomSheetContent$modalBottomSheetFlingBehavior$1$1$performFling$1> continuation) {
        super(continuation);
        this.this$0 = modalBottomSheetKt$ModalBottomSheetContent$modalBottomSheetFlingBehavior$1$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.performFling(null, 0.0f, this);
    }
}
