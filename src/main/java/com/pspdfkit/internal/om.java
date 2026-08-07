package com.pspdfkit.internal;

import com.pspdfkit.annotations.measurements.MeasurementValueConfiguration;
import com.pspdfkit.internal.jni.NativeDocument;
import com.pspdfkit.internal.jni.NativeMeasurementContentFormat;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.model.InternalPdfDocument$removeMeasurementValueConfiguration$2", f = "InternalPdfDocument.kt", i = {0}, l = {1394}, m = "invokeSuspend", n = {"configurations"}, nl = {1395}, s = {"L$0"}, v = 2)
public final class om extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public Object a;
    public int b;
    public final /* synthetic */ lm c;
    public final /* synthetic */ MeasurementValueConfiguration d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public om(lm lmVar, MeasurementValueConfiguration measurementValueConfiguration, Continuation continuation) {
        super(2, continuation);
        this.c = lmVar;
        this.d = measurementValueConfiguration;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new om(this.c, this.d, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return new om(this.c, this.d, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.b;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            NativeDocument nativeDocument = this.c.y;
            MeasurementValueConfiguration measurementValueConfiguration = this.d;
            measurementValueConfiguration.getClass();
            nativeDocument.removeMeasurementContentFormat(new NativeMeasurementContentFormat(measurementValueConfiguration.getName(), mr.a(measurementValueConfiguration.getScale()), mr.a(measurementValueConfiguration.getPrecision())));
            this.a = SpillingKt.nullOutSpilledVariable(lm.b(this.c));
            this.b = 1;
            if (Unit.INSTANCE == coroutine_suspended) {
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
