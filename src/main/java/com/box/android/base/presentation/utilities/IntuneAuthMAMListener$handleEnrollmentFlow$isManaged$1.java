package com.box.android.base.presentation.utilities;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: IntuneAuthMAMListener.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.base.presentation.utilities.IntuneAuthMAMListener$handleEnrollmentFlow$isManaged$1", f = "IntuneAuthMAMListener.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class IntuneAuthMAMListener$handleEnrollmentFlow$isManaged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    int label;
    final /* synthetic */ IntuneAuthMAMListener this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    IntuneAuthMAMListener$handleEnrollmentFlow$isManaged$1(IntuneAuthMAMListener intuneAuthMAMListener, Continuation<? super IntuneAuthMAMListener$handleEnrollmentFlow$isManaged$1> continuation) {
        super(2, continuation);
        this.this$0 = intuneAuthMAMListener;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new IntuneAuthMAMListener$handleEnrollmentFlow$isManaged$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((IntuneAuthMAMListener$handleEnrollmentFlow$isManaged$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return Boxing.boxBoolean(this.this$0.intuneAuthManager.isIdentityManaged());
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
