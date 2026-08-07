package com.pspdfkit.internal;

import com.pspdfkit.annotations.measurements.MeasurementValueConfiguration;
import java.util.ArrayList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.model.InternalPdfDocument$updateMeasurementValueConfigurationsCacheAsync$1", f = "InternalPdfDocument.kt", i = {0}, l = {1330}, m = "invokeSuspend", n = {"configurations"}, nl = {1331}, s = {"L$0"}, v = 2)
public final class pm extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public Object a;
    public int b;
    public final /* synthetic */ lm c;
    public final /* synthetic */ Function1<List<MeasurementValueConfiguration>, Unit> d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public pm(lm lmVar, Function1<? super List<MeasurementValueConfiguration>, Unit> function1, Continuation<? super pm> continuation) {
        super(2, continuation);
        this.c = lmVar;
        this.d = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new pm(this.c, this.d, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return new pm(this.c, this.d, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objWithContext;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.b;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ArrayList arrayListB = lm.b(this.c);
            Function1<List<MeasurementValueConfiguration>, Unit> function1 = this.d;
            this.a = SpillingKt.nullOutSpilledVariable(arrayListB);
            this.b = 1;
            if (function1 == null || (objWithContext = BuildersKt.withContext(Dispatchers.getMain(), new nm(function1, arrayListB, null), this)) != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                objWithContext = Unit.INSTANCE;
            }
            if (objWithContext == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
