package com.box.android.boxai.multidoc;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: BoxAiMultidocAvailabilityReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.boxai.multidoc.BoxAiMultidocAvailabilityReducer$build$1$2", f = "BoxAiMultidocAvailabilityReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class BoxAiMultidocAvailabilityReducer$build$1$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BoxAiMultidocAvailabilityReducer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BoxAiMultidocAvailabilityReducer$build$1$2(BoxAiMultidocAvailabilityReducer boxAiMultidocAvailabilityReducer, Continuation<? super BoxAiMultidocAvailabilityReducer$build$1$2> continuation) {
        super(1, continuation);
        this.this$0 = boxAiMultidocAvailabilityReducer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new BoxAiMultidocAvailabilityReducer$build$1$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((BoxAiMultidocAvailabilityReducer$build$1$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.this$0.getEnvironment().getBoxAiObservability().logBoxAiEnabledInMultiselect();
        return Unit.INSTANCE;
    }
}
