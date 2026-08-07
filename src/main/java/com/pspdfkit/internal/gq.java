package com.pspdfkit.internal;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.annotations.measurements.MeasurementValueConfigurationEditorImpl", f = "MeasurementValueConfigurationEditorImpl.kt", i = {0}, l = {347}, m = "performEditOperationSuspend", n = {"operationBlock"}, nl = {348}, s = {"L$0"}, v = 2)
public final class gq extends ContinuationImpl {
    public Object a;
    public /* synthetic */ Object b;
    public final /* synthetic */ dq c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gq(dq dqVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.c = dqVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        return dq.a(this.c, (Function1) null, this);
    }
}
