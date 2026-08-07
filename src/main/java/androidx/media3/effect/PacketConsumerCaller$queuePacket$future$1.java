package androidx.media3.effect;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: PacketConsumerCaller.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.media3.effect.PacketConsumerCaller$queuePacket$future$1", f = "PacketConsumerCaller.kt", i = {}, l = {103}, m = "invokeSuspend", n = {}, s = {})
final class PacketConsumerCaller$queuePacket$future$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation, Object> {
    final /* synthetic */ PacketConsumer.Packet<T> $packet;
    int label;
    final /* synthetic */ PacketConsumerCaller<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    PacketConsumerCaller$queuePacket$future$1(PacketConsumerCaller<T> packetConsumerCaller, PacketConsumer.Packet<? extends T> packet, Continuation<? super PacketConsumerCaller$queuePacket$future$1> continuation) {
        super(2, continuation);
        this.this$0 = packetConsumerCaller;
        this.$packet = packet;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PacketConsumerCaller$queuePacket$future$1(this.this$0, this.$packet, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((PacketConsumerCaller$queuePacket$future$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return null;
        }
        ResultKt.throwOnFailure(obj);
        this.label = 1;
        if (((PacketConsumerCaller) this.this$0).packetChannel.send(this.$packet, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return null;
    }
}
