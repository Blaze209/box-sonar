package com.pspdfkit.internal;

import com.pspdfkit.annotations.measurements.MeasurementValueConfiguration;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.annotations.measurements.SelectedMeasurementValueConfigurationController$updateView$1", f = "SelectedMeasurementValueConfigurationManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
public final class p00 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ o00 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p00(o00 o00Var, Continuation<? super p00> continuation) {
        super(2, continuation);
        this.a = o00Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new p00(this.a, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return new p00(this.a, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        o00 o00Var = this.a;
        MeasurementValueConfiguration measurementValueConfiguration = e60.a;
        o00Var.b.updateScaleLabel(measurementValueConfiguration != null ? measurementValueConfiguration.getNameForDisplay(false) : null, measurementValueConfiguration != null);
        return Unit.INSTANCE;
    }
}
