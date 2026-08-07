package androidx.media3.effect;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.common.util.Consumer;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ClosedSendChannelException;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.guava.ListenableFutureKt;

/* JADX INFO: compiled from: PacketConsumerCaller.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001b*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u001bB-\b\u0002\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0011\u001a\u00020\u0012J\u0014\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eJ\u001e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u00172\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0007J\u0010\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0017H\u0007J\u0006\u0010\u001a\u001a\u00020\u0012R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Landroidx/media3/effect/PacketConsumerCaller;", ExifInterface.GPS_DIRECTION_TRUE, "", "packetConsumer", "Landroidx/media3/effect/PacketConsumer;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "errorConsumer", "Landroidx/media3/common/util/Consumer;", "Ljava/lang/Exception;", "<init>", "(Landroidx/media3/effect/PacketConsumer;Lkotlinx/coroutines/CoroutineScope;Landroidx/media3/common/util/Consumer;)V", "packetChannel", "Lkotlinx/coroutines/channels/Channel;", "Landroidx/media3/effect/PacketConsumer$Packet;", "consumerJob", "Lkotlinx/coroutines/Job;", "run", "", "tryQueuePacket", "", "packet", "queuePacket", "Lcom/google/common/util/concurrent/ListenableFuture;", "", "queueEndOfStream", "release", "Companion", "lib-effect_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PacketConsumerCaller<T> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Job consumerJob;
    private final Consumer<Exception> errorConsumer;
    private final Channel<PacketConsumer.Packet<T>> packetChannel;
    private final PacketConsumer<T> packetConsumer;
    private final CoroutineScope scope;

    public /* synthetic */ PacketConsumerCaller(PacketConsumer packetConsumer, CoroutineScope coroutineScope, Consumer consumer, DefaultConstructorMarker defaultConstructorMarker) {
        this(packetConsumer, coroutineScope, consumer);
    }

    @JvmStatic
    public static final <T> PacketConsumerCaller<T> create(PacketConsumer<T> packetConsumer, ExecutorService executorService, Consumer<Exception> consumer) {
        return INSTANCE.create(packetConsumer, executorService, consumer);
    }

    private PacketConsumerCaller(PacketConsumer<T> packetConsumer, CoroutineScope coroutineScope, Consumer<Exception> consumer) {
        this.packetConsumer = packetConsumer;
        this.scope = coroutineScope;
        this.errorConsumer = consumer;
        this.packetChannel = ChannelKt.Channel$default(0, null, null, 6, null);
    }

    public final void run() {
        if (this.consumerJob != null) {
            return;
        }
        this.consumerJob = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C08331(this, null), 3, null);
    }

    /* JADX INFO: renamed from: androidx.media3.effect.PacketConsumerCaller$run$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PacketConsumerCaller.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.media3.effect.PacketConsumerCaller$run$1", f = "PacketConsumerCaller.kt", i = {}, l = {65, 67}, m = "invokeSuspend", n = {}, s = {})
    static final class C08331 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ PacketConsumerCaller<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08331(PacketConsumerCaller<T> packetConsumerCaller, Continuation<? super C08331> continuation) {
            super(2, continuation);
            this.this$0 = packetConsumerCaller;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C08331(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08331) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:18:0x0043  */
        /* JADX WARN: Code duplicated, block: B:21:0x004e  */
        /* JADX WARN: Code duplicated, block: B:27:0x0073  */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0065, code lost:
        
            if (((androidx.media3.effect.PacketConsumerCaller) r7.this$0).packetConsumer.queuePacket(r8, r7) == r0) goto L24;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0065 -> B:26:0x0071). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0068 -> B:26:0x0071). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r7.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L28
                if (r1 == r3) goto L20
                if (r1 != r2) goto L18
                java.lang.Object r1 = r7.L$0
                kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Exception -> L16
                goto L71
            L16:
                r8 = move-exception
                goto L68
            L18:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L20:
                java.lang.Object r1 = r7.L$0
                kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                kotlin.ResultKt.throwOnFailure(r8)
                goto L46
            L28:
                kotlin.ResultKt.throwOnFailure(r8)
                androidx.media3.effect.PacketConsumerCaller<T> r8 = r7.this$0
                kotlinx.coroutines.channels.Channel r8 = androidx.media3.effect.PacketConsumerCaller.access$getPacketChannel$p(r8)
                kotlinx.coroutines.channels.ChannelIterator r8 = r8.iterator()
            L35:
                r1 = r7
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r7.L$0 = r8
                r7.label = r3
                java.lang.Object r1 = r8.hasNext(r1)
                if (r1 != r0) goto L43
                goto L67
            L43:
                r6 = r1
                r1 = r8
                r8 = r6
            L46:
                java.lang.Boolean r8 = (java.lang.Boolean) r8
                boolean r8 = r8.booleanValue()
                if (r8 == 0) goto L73
                java.lang.Object r8 = r1.next()
                androidx.media3.effect.PacketConsumer$Packet r8 = (androidx.media3.effect.PacketConsumer.Packet) r8
                androidx.media3.effect.PacketConsumerCaller<T> r4 = r7.this$0     // Catch: java.lang.Exception -> L16
                androidx.media3.effect.PacketConsumer r4 = androidx.media3.effect.PacketConsumerCaller.access$getPacketConsumer$p(r4)     // Catch: java.lang.Exception -> L16
                r5 = r7
                kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5     // Catch: java.lang.Exception -> L16
                r7.L$0 = r1     // Catch: java.lang.Exception -> L16
                r7.label = r2     // Catch: java.lang.Exception -> L16
                java.lang.Object r8 = r4.queuePacket(r8, r5)     // Catch: java.lang.Exception -> L16
                if (r8 != r0) goto L71
            L67:
                return r0
            L68:
                androidx.media3.effect.PacketConsumerCaller<T> r4 = r7.this$0
                androidx.media3.common.util.Consumer r4 = androidx.media3.effect.PacketConsumerCaller.access$getErrorConsumer$p(r4)
                r4.accept(r8)
            L71:
                r8 = r1
                goto L35
            L73:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.effect.PacketConsumerCaller.C08331.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final boolean tryQueuePacket(PacketConsumer.Packet<? extends T> packet) throws Throwable {
        Intrinsics.checkNotNullParameter(packet, "packet");
        Object obj = this.packetChannel.mo11206trySendJP2dKIU(packet);
        if (!(obj instanceof ChannelResult.Closed)) {
            return ChannelResult.m16344isSuccessimpl(obj);
        }
        Throwable thM16338exceptionOrNullimpl = ChannelResult.m16338exceptionOrNullimpl(obj);
        if (thM16338exceptionOrNullimpl == null) {
            throw new ClosedSendChannelException("Channel is closed");
        }
        throw thM16338exceptionOrNullimpl;
    }

    public final ListenableFuture queuePacket(PacketConsumer.Packet<? extends T> packet) {
        Intrinsics.checkNotNullParameter(packet, "packet");
        ListenableFuture listenableFutureFuture$default = ListenableFutureKt.future$default(this.scope, null, null, new PacketConsumerCaller$queuePacket$future$1(this, packet, null), 3, null);
        Futures.addCallback(listenableFutureFuture$default, new FutureCallback(this) { // from class: androidx.media3.effect.PacketConsumerCaller.queuePacket.1
            final /* synthetic */ PacketConsumerCaller<T> this$0;

            @Override // com.google.common.util.concurrent.FutureCallback
            public void onSuccess(Void result) {
            }

            {
                this.this$0 = this;
            }

            @Override // com.google.common.util.concurrent.FutureCallback
            public void onFailure(Throwable t) {
                Intrinsics.checkNotNullParameter(t, "t");
                ((PacketConsumerCaller) this.this$0).errorConsumer.accept(new Exception(t));
            }
        }, MoreExecutors.directExecutor());
        return listenableFutureFuture$default;
    }

    public final ListenableFuture queueEndOfStream() {
        ListenableFuture listenableFutureFuture$default = ListenableFutureKt.future$default(this.scope, null, null, new PacketConsumerCaller$queueEndOfStream$future$1(this, null), 3, null);
        Futures.addCallback(listenableFutureFuture$default, new FutureCallback(this) { // from class: androidx.media3.effect.PacketConsumerCaller.queueEndOfStream.1
            final /* synthetic */ PacketConsumerCaller<T> this$0;

            @Override // com.google.common.util.concurrent.FutureCallback
            public void onSuccess(Void result) {
            }

            {
                this.this$0 = this;
            }

            @Override // com.google.common.util.concurrent.FutureCallback
            public void onFailure(Throwable t) {
                Intrinsics.checkNotNullParameter(t, "t");
                ((PacketConsumerCaller) this.this$0).errorConsumer.accept(new Exception(t));
            }
        }, MoreExecutors.directExecutor());
        return listenableFutureFuture$default;
    }

    public final void release() {
        SendChannel.DefaultImpls.close$default(this.packetChannel, null, 1, null);
        Job job = this.consumerJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.consumerJob = null;
        CoroutineScopeKt.cancel$default(this.scope, null, 1, null);
    }

    /* JADX INFO: compiled from: PacketConsumerCaller.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J8\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0001\u0010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0007¨\u0006\u000e"}, d2 = {"Landroidx/media3/effect/PacketConsumerCaller$Companion;", "", "<init>", "()V", PasskeyWebListener.CREATE_UNIQUE_KEY, "Landroidx/media3/effect/PacketConsumerCaller;", ExifInterface.GPS_DIRECTION_TRUE, "packetConsumer", "Landroidx/media3/effect/PacketConsumer;", "executorService", "Ljava/util/concurrent/ExecutorService;", "errorConsumer", "Landroidx/media3/common/util/Consumer;", "Ljava/lang/Exception;", "lib-effect_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final <T> PacketConsumerCaller<T> create(PacketConsumer<T> packetConsumer, ExecutorService executorService, Consumer<Exception> errorConsumer) {
            Intrinsics.checkNotNullParameter(packetConsumer, "packetConsumer");
            Intrinsics.checkNotNullParameter(executorService, "executorService");
            Intrinsics.checkNotNullParameter(errorConsumer, "errorConsumer");
            return new PacketConsumerCaller<>(packetConsumer, CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(executorService)), errorConsumer, null);
        }
    }
}
