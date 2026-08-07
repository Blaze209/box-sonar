package com.box.android.jobsui.helpers;

import com.box.android.base.presentation.components.topbar.component.jobsprogress.JobsProgressReducer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: TransfersHelper.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.jobsui.helpers.TransfersHelper$register$1$1", f = "TransfersHelper.kt", i = {0, 1, 1}, l = {35, 42}, m = "emit", n = {"state", "state", "color"}, s = {"L$0", "L$0", "L$1"}, v = 1)
final class TransfersHelper$register$1$1$emit$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TransfersHelper.AnonymousClass1.C01761<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    TransfersHelper$register$1$1$emit$1(TransfersHelper.AnonymousClass1.C01761<? super T> c01761, Continuation<? super TransfersHelper$register$1$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = c01761;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((JobsProgressReducer.State) null, (Continuation<? super Unit>) this);
    }
}
