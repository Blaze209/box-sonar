package com.pspdfkit.internal;

import com.pspdfkit.instant.client.InstantProgress;
import com.pspdfkit.instant.internal.jni.NativeInstantError;
import com.pspdfkit.instant.internal.jni.NativeServerDocumentLayer;
import com.pspdfkit.instant.internal.jni.NativeSyncRequestHint;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.instant.client.InstantAnnotationSyncManager$syncAnnotationsAsync$1", f = "InstantAnnotationSyncManager.kt", i = {0, 0}, l = {64}, m = "invokeSuspend", n = {"$this$callbackFlow", "channel"}, nl = {69}, s = {"L$0", "L$1"}, v = 2)
public final class cl extends SuspendLambda implements Function2<ProducerScope<? super InstantProgress>, Continuation<? super Unit>, Object> {
    public Object a;
    public int b;
    public /* synthetic */ Object c;
    public final /* synthetic */ zk d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ boolean f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cl(zk zkVar, boolean z, boolean z2, Continuation<? super cl> continuation) {
        super(2, continuation);
        this.d = zkVar;
        this.e = z;
        this.f = z2;
    }

    public static final Unit a(zk zkVar, ProducerScope producerScope) {
        if (zkVar.f == producerScope) {
            zkVar.f = null;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        cl clVar = new cl(this.d, this.e, this.f, continuation);
        clVar.c = obj;
        return clVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ProducerScope<? super InstantProgress> producerScope, Continuation<? super Unit> continuation) {
        return ((cl) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        final ProducerScope producerScope = (ProducerScope) this.c;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.b;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            zk zkVar = this.d;
            SendChannel<? super InstantProgress> sendChannel = zkVar.f;
            if (sendChannel != null) {
                zkVar.f = null;
                sendChannel.close(null);
            }
            this.d.f = producerScope;
            zk zkVar2 = this.d;
            boolean z = this.e;
            boolean z2 = this.f;
            zkVar2.getClass();
            NativeSyncRequestHint nativeSyncRequestHint = z2 ? NativeSyncRequestHint.LISTEN_FOR_UPDATES : NativeSyncRequestHint.FETCH_UPDATES;
            if (z) {
                nativeSyncRequestHint = NativeSyncRequestHint.PUSH_CHANGES;
            }
            NativeInstantError nativeInstantErrorStartSyncingWithHint = zkVar2.b.c.startSyncingWithHint(nativeSyncRequestHint);
            if (nativeInstantErrorStartSyncingWithHint != null) {
                NativeServerDocumentLayer nativeServerDocumentLayer = zkVar2.b.c;
                nativeServerDocumentLayer.getClass();
                zkVar2.a(nativeServerDocumentLayer, nativeInstantErrorStartSyncingWithHint);
            }
            final zk zkVar3 = this.d;
            Function0 function0 = new Function0() { // from class: com.pspdfkit.internal.cl$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return cl.a(zkVar3, producerScope);
                }
            };
            this.c = SpillingKt.nullOutSpilledVariable(producerScope);
            this.a = SpillingKt.nullOutSpilledVariable(producerScope);
            this.b = 1;
            if (ProduceKt.awaitClose(producerScope, function0, this) == coroutine_suspended) {
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
