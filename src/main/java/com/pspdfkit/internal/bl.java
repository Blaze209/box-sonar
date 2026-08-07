package com.pspdfkit.internal;

import com.pspdfkit.instant.internal.jni.NativeServerChangeApplicator;
import com.pspdfkit.instant.internal.jni.NativeServerChangeApplicatorChanges;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.instant.client.InstantAnnotationSyncManager$applySyncChanges$changes$1", f = "InstantAnnotationSyncManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
public final class bl extends SuspendLambda implements Function1<Continuation<? super NativeServerChangeApplicatorChanges>, Object> {
    public final /* synthetic */ NativeServerChangeApplicator a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bl(NativeServerChangeApplicator nativeServerChangeApplicator, Continuation<? super bl> continuation) {
        super(1, continuation);
        this.a = nativeServerChangeApplicator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new bl(this.a, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super NativeServerChangeApplicatorChanges> continuation) {
        NativeServerChangeApplicator nativeServerChangeApplicator = this.a;
        new bl(nativeServerChangeApplicator, continuation);
        Unit unit = Unit.INSTANCE;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(unit);
        return nativeServerChangeApplicator.apply();
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        return this.a.apply();
    }
}
