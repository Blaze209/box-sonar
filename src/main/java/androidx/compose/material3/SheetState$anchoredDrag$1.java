package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: SheetDefaults.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.SheetState", f = "SheetDefaults.kt", i = {0}, l = {276}, m = "anchoredDrag$material3", n = {"consumedVelocity"}, s = {"L$0"}, v = 1)
final class SheetState$anchoredDrag$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SheetState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SheetState$anchoredDrag$1(SheetState sheetState, Continuation<? super SheetState$anchoredDrag$1> continuation) {
        super(continuation);
        this.this$0 = sheetState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.anchoredDrag$material3(null, 0.0f, this);
    }
}
