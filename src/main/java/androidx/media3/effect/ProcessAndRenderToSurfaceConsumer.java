package androidx.media3.effect;

import android.view.SurfaceHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.collect.ImmutableList;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ProcessAndRenderToSurfaceConsumer.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0001\u0011B\u0019\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\"\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\rH\u0096@¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u000f\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/media3/effect/ProcessAndRenderToSurfaceConsumer;", "Landroidx/media3/effect/PacketConsumer;", "Lcom/google/common/collect/ImmutableList;", "Landroidx/media3/effect/HardwareBufferFrame;", "effectsPipeline", "Landroidx/media3/effect/DefaultHardwareBufferEffectsPipeline;", "frameQueue", "Landroidx/media3/effect/SurfaceHolderHardwareBufferFrameQueue;", "<init>", "(Landroidx/media3/effect/DefaultHardwareBufferEffectsPipeline;Landroidx/media3/effect/SurfaceHolderHardwareBufferFrameQueue;)V", "queuePacket", "", "packet", "Landroidx/media3/effect/PacketConsumer$Packet;", "(Landroidx/media3/effect/PacketConsumer$Packet;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Factory", "lib-effect_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ProcessAndRenderToSurfaceConsumer implements PacketConsumer<ImmutableList<HardwareBufferFrame>> {
    private final DefaultHardwareBufferEffectsPipeline effectsPipeline;
    private final SurfaceHolderHardwareBufferFrameQueue frameQueue;

    /* JADX INFO: renamed from: androidx.media3.effect.ProcessAndRenderToSurfaceConsumer$release$1, reason: invalid class name */
    /* JADX INFO: compiled from: ProcessAndRenderToSurfaceConsumer.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.media3.effect.ProcessAndRenderToSurfaceConsumer", f = "ProcessAndRenderToSurfaceConsumer.kt", i = {0}, l = {81}, m = "release", n = {"this"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ProcessAndRenderToSurfaceConsumer.this.release(this);
        }
    }

    public /* synthetic */ ProcessAndRenderToSurfaceConsumer(DefaultHardwareBufferEffectsPipeline defaultHardwareBufferEffectsPipeline, SurfaceHolderHardwareBufferFrameQueue surfaceHolderHardwareBufferFrameQueue, DefaultConstructorMarker defaultConstructorMarker) {
        this(defaultHardwareBufferEffectsPipeline, surfaceHolderHardwareBufferFrameQueue);
    }

    private ProcessAndRenderToSurfaceConsumer(DefaultHardwareBufferEffectsPipeline defaultHardwareBufferEffectsPipeline, SurfaceHolderHardwareBufferFrameQueue surfaceHolderHardwareBufferFrameQueue) {
        this.effectsPipeline = defaultHardwareBufferEffectsPipeline;
        this.frameQueue = surfaceHolderHardwareBufferFrameQueue;
    }

    /* JADX INFO: compiled from: ProcessAndRenderToSurfaceConsumer.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\tJ\u001a\u0010\u0013\u001a\u00020\u00102\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\tR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/media3/effect/ProcessAndRenderToSurfaceConsumer$Factory;", "Landroidx/media3/effect/PacketConsumer$Factory;", "Lcom/google/common/collect/ImmutableList;", "Landroidx/media3/effect/HardwareBufferFrame;", "<init>", "()V", "surfaceHolder", "Landroid/view/SurfaceHolder;", "surfaceHolderExecutor", "Ljava/util/concurrent/Executor;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroidx/media3/effect/SurfaceHolderHardwareBufferFrameQueue$Listener;", "listenerExecutor", PasskeyWebListener.CREATE_UNIQUE_KEY, "Landroidx/media3/effect/PacketConsumer;", "setOutput", "", "output", "executor", "setListener", "lib-effect_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Factory implements PacketConsumer.Factory<ImmutableList<HardwareBufferFrame>> {
        private SurfaceHolderHardwareBufferFrameQueue.Listener listener;
        private Executor listenerExecutor;
        private SurfaceHolder surfaceHolder;
        private Executor surfaceHolderExecutor;

        @Override // androidx.media3.effect.PacketConsumer.Factory
        public PacketConsumer<ImmutableList<HardwareBufferFrame>> create() {
            SurfaceHolder surfaceHolder = this.surfaceHolder;
            Intrinsics.checkNotNull(surfaceHolder);
            Executor executor = this.surfaceHolderExecutor;
            Intrinsics.checkNotNull(executor);
            SurfaceHolderHardwareBufferFrameQueue.Listener listener = this.listener;
            Intrinsics.checkNotNull(listener);
            Executor executor2 = this.listenerExecutor;
            Intrinsics.checkNotNull(executor2);
            SurfaceHolderHardwareBufferFrameQueue surfaceHolderHardwareBufferFrameQueue = new SurfaceHolderHardwareBufferFrameQueue(surfaceHolder, executor, listener, executor2);
            DefaultHardwareBufferEffectsPipeline defaultHardwareBufferEffectsPipeline = new DefaultHardwareBufferEffectsPipeline();
            defaultHardwareBufferEffectsPipeline.setRenderOutput((HardwareBufferFrameQueue) surfaceHolderHardwareBufferFrameQueue);
            return new ProcessAndRenderToSurfaceConsumer(defaultHardwareBufferEffectsPipeline, surfaceHolderHardwareBufferFrameQueue, null);
        }

        public final void setOutput(SurfaceHolder output, Executor executor) {
            this.surfaceHolder = output;
            this.surfaceHolderExecutor = executor;
        }

        public final void setListener(SurfaceHolderHardwareBufferFrameQueue.Listener listener, Executor executor) {
            this.listener = listener;
            this.listenerExecutor = executor;
        }
    }

    @Override // androidx.media3.effect.PacketConsumer
    public Object queuePacket(PacketConsumer.Packet<? extends ImmutableList<HardwareBufferFrame>> packet, Continuation<? super Unit> continuation) {
        Object objQueuePacket = this.effectsPipeline.queuePacket(packet, continuation);
        return objQueuePacket == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objQueuePacket : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // androidx.media3.effect.PacketConsumer
    public Object release(Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            DefaultHardwareBufferEffectsPipeline defaultHardwareBufferEffectsPipeline = this.effectsPipeline;
            anonymousClass1.L$0 = this;
            anonymousClass1.label = 1;
            if (defaultHardwareBufferEffectsPipeline.release(anonymousClass1) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this = (ProcessAndRenderToSurfaceConsumer) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        this.frameQueue.release();
        return Unit.INSTANCE;
    }
}
