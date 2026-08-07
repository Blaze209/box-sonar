package com.microsoft.identity.common.internal.activebrokerdiscovery;

import com.microsoft.identity.common.internal.broker.BrokerData;
import com.microsoft.identity.common.internal.broker.ipc.IIpcStrategy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: BrokerDiscoveryClient.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/microsoft/identity/common/internal/broker/BrokerData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.microsoft.identity.common.internal.activebrokerdiscovery.BrokerDiscoveryClient$Companion$queryFromBroker$2$deferredResults$1$1", f = "BrokerDiscoveryClient.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class BrokerDiscoveryClient$Companion$queryFromBroker$2$deferredResults$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BrokerData>, Object> {
    final /* synthetic */ BrokerData $candidate;
    final /* synthetic */ IIpcStrategy $ipcStrategy;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BrokerDiscoveryClient$Companion$queryFromBroker$2$deferredResults$1$1(BrokerData brokerData, IIpcStrategy iIpcStrategy, Continuation<? super BrokerDiscoveryClient$Companion$queryFromBroker$2$deferredResults$1$1> continuation) {
        super(2, continuation);
        this.$candidate = brokerData;
        this.$ipcStrategy = iIpcStrategy;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BrokerDiscoveryClient$Companion$queryFromBroker$2$deferredResults$1$1(this.$candidate, this.$ipcStrategy, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super BrokerData> continuation) {
        return ((BrokerDiscoveryClient$Companion$queryFromBroker$2$deferredResults$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return BrokerDiscoveryClient.INSTANCE.makeRequest(this.$candidate, this.$ipcStrategy);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
