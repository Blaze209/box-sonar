package com.pspdfkit.internal;

import com.pspdfkit.annotations.measurements.MeasurementValueConfiguration;
import com.pspdfkit.configuration.rendering.PageRenderConfiguration;
import com.pspdfkit.ui.scale.MeasurementScaleView;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes3.dex */
public final class o00 {
    public final lm a;
    public final MeasurementScaleView b;

    @DebugMetadata(c = "com.pspdfkit.internal.annotations.measurements.SelectedMeasurementValueConfigurationController$onConfigurationSelected$1", f = "SelectedMeasurementValueConfigurationManager.kt", i = {}, l = {99}, m = "invokeSuspend", n = {}, nl = {100}, s = {}, v = 2)
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ MeasurementValueConfiguration c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(MeasurementValueConfiguration measurementValueConfiguration, Continuation<? super a> continuation) {
            super(2, continuation);
            this.c = measurementValueConfiguration;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return o00.this.new a(this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return o00.this.new a(this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                lm lmVar = o00.this.a;
                MeasurementValueConfiguration measurementValueConfiguration = this.c;
                this.a = 1;
                PageRenderConfiguration pageRenderConfiguration = lm.Q;
                if (lmVar.a(measurementValueConfiguration, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new p00(o00.this, null), 3, null);
            return Unit.INSTANCE;
        }
    }

    public o00(lm lmVar, MeasurementScaleView measurementScaleView) {
        lmVar.getClass();
        measurementScaleView.getClass();
        this.a = lmVar;
        this.b = measurementScaleView;
        e60.b = this;
        a(e60.a);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0066  */
    /* JADX WARN: Code duplicated, block: B:31:0x006c  */
    public final void a(MeasurementValueConfiguration measurementValueConfiguration) {
        o00 o00Var;
        Object next;
        lm lmVar = this.a;
        if (measurementValueConfiguration != null) {
            Iterator<T> it = lmVar.P.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics.areEqual((MeasurementValueConfiguration) next, measurementValueConfiguration));
            if (((MeasurementValueConfiguration) next) == null) {
                this.a.a(Dispatchers.getMain(), new a(measurementValueConfiguration, null));
                return;
            }
        } else if (!lmVar.P.isEmpty()) {
            MeasurementValueConfiguration measurementValueConfiguration2 = (MeasurementValueConfiguration) CollectionsKt.last((List) this.a.P);
            if (Intrinsics.areEqual(e60.a, measurementValueConfiguration2)) {
                MeasurementValueConfiguration measurementValueConfiguration3 = e60.a;
                if (!Intrinsics.areEqual(measurementValueConfiguration3 != null ? measurementValueConfiguration3.getName() : null, measurementValueConfiguration2 != null ? measurementValueConfiguration2.getName() : null)) {
                    e60.a = measurementValueConfiguration2;
                    o00Var = e60.b;
                    if (o00Var != null) {
                        o00Var.a(measurementValueConfiguration2);
                    }
                }
            } else {
                e60.a = measurementValueConfiguration2;
                o00Var = e60.b;
                if (o00Var != null) {
                    o00Var.a(measurementValueConfiguration2);
                }
            }
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new p00(this, null), 3, null);
    }
}
