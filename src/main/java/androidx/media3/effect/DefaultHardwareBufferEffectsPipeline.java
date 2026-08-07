package androidx.media3.effect;

import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.HardwareBufferRenderer;
import android.graphics.Paint;
import android.graphics.RecordingCanvas;
import android.graphics.RenderNode;
import android.hardware.HardwareBuffer;
import android.hardware.SyncFence;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.Log;
import com.google.common.collect.ImmutableList;
import external.sdk.pendo.io.mozilla.javascript.Context;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: compiled from: DefaultHardwareBufferEffectsPipeline.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u0000 12\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001:\u00011B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010\u0013\u001a\u00020\u00112\u0010\u0010\u0014\u001a\f\u0012\b\u0012\u00060\u0016j\u0002`\u00170\u0015H\u0016J\"\u0010\u0018\u001a\u00020\u00112\u0012\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u001aH\u0096@¢\u0006\u0002\u0010\u001bJ\u000e\u0010\u001c\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010\u001dJ\u0016\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u0003H\u0082@¢\u0006\u0002\u0010 J\u0016\u0010!\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0003H\u0082@¢\u0006\u0002\u0010 JB\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020%2\b\u0010,\u001a\u0004\u0018\u00010'H\u0082@¢\u0006\u0002\u0010-J\u0018\u0010.\u001a\u00020\u00112\b\u0010/\u001a\u0004\u0018\u00010'H\u0082@¢\u0006\u0002\u00100R\u0018\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Landroidx/media3/effect/DefaultHardwareBufferEffectsPipeline;", "Landroidx/media3/effect/RenderingPacketConsumer;", "Lcom/google/common/collect/ImmutableList;", "Landroidx/media3/effect/HardwareBufferFrame;", "Landroidx/media3/effect/HardwareBufferFrameQueue;", "<init>", "()V", "internalExecutor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "Ljava/util/concurrent/ExecutorService;", "internalDispatcher", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "isReleased", "Ljava/util/concurrent/atomic/AtomicBoolean;", "outputBufferQueue", "setRenderOutput", "", "output", "setErrorConsumer", "errorConsumer", "Landroidx/media3/common/util/Consumer;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "queuePacket", "packet", "Landroidx/media3/effect/PacketConsumer$Packet;", "(Landroidx/media3/effect/PacketConsumer$Packet;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processFrame", "inputFrame", "(Landroidx/media3/effect/HardwareBufferFrame;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOutputFrame", "renderToOutputBuffer", "Landroid/hardware/SyncFence;", "inputBuffer", "Landroid/hardware/HardwareBuffer;", "inputFence", "Landroidx/media3/effect/SyncFenceCompat;", "inputWidth", "", "inputHeight", "outputBuffer", "outputFence", "(Landroid/hardware/HardwareBuffer;Landroidx/media3/effect/SyncFenceCompat;IILandroid/hardware/HardwareBuffer;Landroidx/media3/effect/SyncFenceCompat;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "waitOn", "fence", "(Landroidx/media3/effect/SyncFenceCompat;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "lib-effect_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DefaultHardwareBufferEffectsPipeline implements RenderingPacketConsumer<ImmutableList<HardwareBufferFrame>, HardwareBufferFrameQueue> {
    private static final String TAG = "DefaultHBEffects";
    private static final long TIMEOUT_MS = 10000;
    private final ExecutorCoroutineDispatcher internalDispatcher;
    private final ExecutorService internalExecutor;
    private final AtomicBoolean isReleased;
    private HardwareBufferFrameQueue outputBufferQueue;

    /* JADX INFO: renamed from: androidx.media3.effect.DefaultHardwareBufferEffectsPipeline$getOutputFrame$1, reason: invalid class name */
    /* JADX INFO: compiled from: DefaultHardwareBufferEffectsPipeline.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.media3.effect.DefaultHardwareBufferEffectsPipeline", f = "DefaultHardwareBufferEffectsPipeline.kt", i = {0, 0}, l = {150}, m = "getOutputFrame", n = {"this", "bufferFormat"}, s = {"L$0", "L$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultHardwareBufferEffectsPipeline.this.getOutputFrame(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.media3.effect.DefaultHardwareBufferEffectsPipeline$processFrame$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DefaultHardwareBufferEffectsPipeline.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.media3.effect.DefaultHardwareBufferEffectsPipeline", f = "DefaultHardwareBufferEffectsPipeline.kt", i = {0, 0, 1, 1, 1}, l = {92, 97}, m = "processFrame", n = {"this", "inputFrame", "this", "inputFrame", "outputFrame"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
    static final class C08261 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C08261(Continuation<? super C08261> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultHardwareBufferEffectsPipeline.this.processFrame(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.media3.effect.DefaultHardwareBufferEffectsPipeline$renderToOutputBuffer$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DefaultHardwareBufferEffectsPipeline.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.media3.effect.DefaultHardwareBufferEffectsPipeline", f = "DefaultHardwareBufferEffectsPipeline.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2}, l = {Context.VERSION_1_7, 180, 220}, m = "renderToOutputBuffer", n = {"this", "inputBuffer", "outputBuffer", "outputFence", "renderer", "inputWidth", "inputHeight", "this", "outputBuffer", "renderer", "renderNode", "inputBitmap", "inputWidth", "inputHeight", "this", "renderer", "$completion$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$5", "I$0", "I$1", "L$0", "L$1", "L$3", "L$4", "L$5", "I$0", "I$1", "L$0", "L$2", "L$3"})
    static final class C08271 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C08271(Continuation<? super C08271> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultHardwareBufferEffectsPipeline.this.renderToOutputBuffer(null, null, 0, 0, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.media3.effect.DefaultHardwareBufferEffectsPipeline$waitOn$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DefaultHardwareBufferEffectsPipeline.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.media3.effect.DefaultHardwareBufferEffectsPipeline", f = "DefaultHardwareBufferEffectsPipeline.kt", i = {0}, l = {204}, m = "waitOn", n = {"fence"}, s = {"L$0"})
    static final class C08281 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C08281(Continuation<? super C08281> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultHardwareBufferEffectsPipeline.this.waitOn(null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getOutputFrame$lambda$1() {
    }

    @Override // androidx.media3.effect.RenderingPacketConsumer
    public void setErrorConsumer(Consumer<Exception> errorConsumer) {
        Intrinsics.checkNotNullParameter(errorConsumer, "errorConsumer");
    }

    public DefaultHardwareBufferEffectsPipeline() {
        ExecutorService internalExecutor = Executors.newSingleThreadExecutor();
        this.internalExecutor = internalExecutor;
        Intrinsics.checkNotNullExpressionValue(internalExecutor, "internalExecutor");
        this.internalDispatcher = ExecutorsKt.from(internalExecutor);
        this.isReleased = new AtomicBoolean(false);
    }

    @Override // androidx.media3.effect.RenderingPacketConsumer
    public void setRenderOutput(HardwareBufferFrameQueue output) {
        this.outputBufferQueue = output;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.effect.PacketConsumer
    public Object queuePacket(PacketConsumer.Packet<? extends ImmutableList<HardwareBufferFrame>> packet, Continuation<? super Unit> continuation) {
        if (this.isReleased.get()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (packet instanceof PacketConsumer.Packet.EndOfStream) {
            HardwareBufferFrameQueue hardwareBufferFrameQueue = this.outputBufferQueue;
            Intrinsics.checkNotNull(hardwareBufferFrameQueue);
            hardwareBufferFrameQueue.signalEndOfStream();
        } else {
            if (!(packet instanceof PacketConsumer.Packet.Payload)) {
                throw new NoWhenBranchMatchedException();
            }
            PacketConsumer.Packet.Payload payload = (PacketConsumer.Packet.Payload) packet;
            int lastIndex = CollectionsKt.getLastIndex((List) payload.getPayload());
            int i = 1;
            if (1 <= lastIndex) {
                while (true) {
                    ((HardwareBufferFrame) ((ImmutableList) payload.getPayload()).get(i)).release(null);
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
            if (!((Collection) payload.getPayload()).isEmpty()) {
                E e = ((ImmutableList) payload.getPayload()).get(0);
                Intrinsics.checkNotNullExpressionValue(e, "get(...)");
                Object objProcessFrame = processFrame((HardwareBufferFrame) e, continuation);
                return objProcessFrame == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objProcessFrame : Unit.INSTANCE;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.media3.effect.PacketConsumer
    public Object release(Continuation<? super Unit> continuation) {
        if (!this.isReleased.getAndSet(true)) {
            this.internalExecutor.shutdown();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object processFrame(HardwareBufferFrame hardwareBufferFrame, Continuation<? super Unit> continuation) {
        C08261 c08261;
        HardwareBufferFrame hardwareBufferFrame2;
        DefaultHardwareBufferEffectsPipeline defaultHardwareBufferEffectsPipeline;
        if (continuation instanceof C08261) {
            c08261 = (C08261) continuation;
            if ((c08261.label & Integer.MIN_VALUE) != 0) {
                c08261.label -= Integer.MIN_VALUE;
            } else {
                c08261 = new C08261(continuation);
            }
        } else {
            c08261 = new C08261(continuation);
        }
        C08261 c08262 = c08261;
        Object outputFrame = c08262.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c08262.label;
        try {
            if (i != 0) {
                if (i == 1) {
                    hardwareBufferFrame = (HardwareBufferFrame) c08262.L$1;
                    this = (DefaultHardwareBufferEffectsPipeline) c08262.L$0;
                    ResultKt.throwOnFailure(outputFrame);
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    hardwareBufferFrame2 = (HardwareBufferFrame) c08262.L$2;
                    hardwareBufferFrame = (HardwareBufferFrame) c08262.L$1;
                    defaultHardwareBufferEffectsPipeline = (DefaultHardwareBufferEffectsPipeline) c08262.L$0;
                    ResultKt.throwOnFailure(outputFrame);
                }
                SyncFence syncFence = (SyncFence) outputFrame;
                SyncFenceCompat syncFenceCompatDuplicate = SyncFenceCompat.duplicate(syncFence);
                HardwareBufferFrame hardwareBufferFrameBuild = hardwareBufferFrame2.buildUpon().setPresentationTimeUs(hardwareBufferFrame.presentationTimeUs).setReleaseTimeNs(hardwareBufferFrame.releaseTimeNs).setFormat(hardwareBufferFrame.format).setMetadata(hardwareBufferFrame.getMetadata()).setAcquireFence(SyncFenceCompat.duplicate(syncFence)).build();
                HardwareBufferFrameQueue hardwareBufferFrameQueue = defaultHardwareBufferEffectsPipeline.outputBufferQueue;
                Intrinsics.checkNotNull(hardwareBufferFrameQueue);
                hardwareBufferFrameQueue.queue(hardwareBufferFrameBuild);
                syncFence.close();
                hardwareBufferFrame.release(syncFenceCompatDuplicate);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(outputFrame);
            if (hardwareBufferFrame.hardwareBuffer == null) {
                throw new IllegalArgumentException("Input frame missing HardwareBuffer");
            }
            c08262.L$0 = this;
            c08262.L$1 = hardwareBufferFrame;
            c08262.label = 1;
            outputFrame = getOutputFrame(hardwareBufferFrame, c08262);
            if (outputFrame == coroutine_suspended) {
            }
            return coroutine_suspended;
            DefaultHardwareBufferEffectsPipeline defaultHardwareBufferEffectsPipeline2 = this;
            hardwareBufferFrame2 = (HardwareBufferFrame) outputFrame;
            if (hardwareBufferFrame2.hardwareBuffer == null) {
                throw new IllegalStateException("Check failed.".toString());
            }
            HardwareBuffer hardwareBuffer = hardwareBufferFrame.hardwareBuffer;
            SyncFenceCompat syncFenceCompat = hardwareBufferFrame.acquireFence;
            int i2 = hardwareBufferFrame.format.width;
            int i3 = hardwareBufferFrame.format.height;
            HardwareBuffer hardwareBuffer2 = hardwareBufferFrame2.hardwareBuffer;
            SyncFenceCompat syncFenceCompat2 = hardwareBufferFrame2.acquireFence;
            c08262.L$0 = defaultHardwareBufferEffectsPipeline2;
            c08262.L$1 = hardwareBufferFrame;
            c08262.L$2 = hardwareBufferFrame2;
            c08262.label = 2;
            outputFrame = defaultHardwareBufferEffectsPipeline2.renderToOutputBuffer(hardwareBuffer, syncFenceCompat, i2, i3, hardwareBuffer2, syncFenceCompat2, c08262);
            if (outputFrame != coroutine_suspended) {
                defaultHardwareBufferEffectsPipeline = defaultHardwareBufferEffectsPipeline2;
                SyncFence syncFence2 = (SyncFence) outputFrame;
                SyncFenceCompat syncFenceCompatDuplicate2 = SyncFenceCompat.duplicate(syncFence2);
                HardwareBufferFrame hardwareBufferFrameBuild2 = hardwareBufferFrame2.buildUpon().setPresentationTimeUs(hardwareBufferFrame.presentationTimeUs).setReleaseTimeNs(hardwareBufferFrame.releaseTimeNs).setFormat(hardwareBufferFrame.format).setMetadata(hardwareBufferFrame.getMetadata()).setAcquireFence(SyncFenceCompat.duplicate(syncFence2)).build();
                HardwareBufferFrameQueue hardwareBufferFrameQueue2 = defaultHardwareBufferEffectsPipeline.outputBufferQueue;
                Intrinsics.checkNotNull(hardwareBufferFrameQueue2);
                hardwareBufferFrameQueue2.queue(hardwareBufferFrameBuild2);
                syncFence2.close();
                hardwareBufferFrame.release(syncFenceCompatDuplicate2);
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        } catch (Throwable th) {
            hardwareBufferFrame.release(null);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getOutputFrame(HardwareBufferFrame hardwareBufferFrame, Continuation<? super HardwareBufferFrame> continuation) {
        AnonymousClass1 anonymousClass1;
        HardwareBufferFrameQueue.FrameFormat frameFormatBuild;
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
            HardwareBufferFrameQueue.FrameFormat.Builder usageFlags = new HardwareBufferFrameQueue.FrameFormat.Builder().setWidth(hardwareBufferFrame.format.width).setHeight(hardwareBufferFrame.format.height).setPixelFormat(ColorInfo.isTransferHdr(hardwareBufferFrame.format.colorInfo) ? 43 : 1).setUsageFlags(768L);
            ColorInfo SDR_BT709_LIMITED = hardwareBufferFrame.format.colorInfo;
            if (SDR_BT709_LIMITED == null) {
                SDR_BT709_LIMITED = ColorInfo.SDR_BT709_LIMITED;
                Intrinsics.checkNotNullExpressionValue(SDR_BT709_LIMITED, "SDR_BT709_LIMITED");
            }
            frameFormatBuild = usageFlags.setColorInfo(SDR_BT709_LIMITED).build();
            final CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
            HardwareBufferFrameQueue hardwareBufferFrameQueue = this.outputBufferQueue;
            Intrinsics.checkNotNull(hardwareBufferFrameQueue);
            HardwareBufferFrame hardwareBufferFrameDequeue = hardwareBufferFrameQueue.dequeue(frameFormatBuild, new Runnable() { // from class: androidx.media3.effect.DefaultHardwareBufferEffectsPipeline$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    DefaultHardwareBufferEffectsPipeline.getOutputFrame$lambda$0(completableDeferredCompletableDeferred$default);
                }
            });
            if (hardwareBufferFrameDequeue != null) {
                return hardwareBufferFrameDequeue;
            }
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(completableDeferredCompletableDeferred$default, null);
            anonymousClass1.L$0 = this;
            anonymousClass1.L$1 = frameFormatBuild;
            anonymousClass1.label = 1;
            if (TimeoutKt.withTimeout(10000L, anonymousClass2, anonymousClass1) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            HardwareBufferFrameQueue.FrameFormat frameFormat = (HardwareBufferFrameQueue.FrameFormat) anonymousClass1.L$1;
            DefaultHardwareBufferEffectsPipeline defaultHardwareBufferEffectsPipeline = (DefaultHardwareBufferEffectsPipeline) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
            frameFormatBuild = frameFormat;
            this = defaultHardwareBufferEffectsPipeline;
        }
        HardwareBufferFrameQueue hardwareBufferFrameQueue2 = this.outputBufferQueue;
        Intrinsics.checkNotNull(hardwareBufferFrameQueue2);
        HardwareBufferFrame hardwareBufferFrameDequeue2 = hardwareBufferFrameQueue2.dequeue(frameFormatBuild, new Runnable() { // from class: androidx.media3.effect.DefaultHardwareBufferEffectsPipeline$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                DefaultHardwareBufferEffectsPipeline.getOutputFrame$lambda$1();
            }
        });
        if (hardwareBufferFrameDequeue2 != null) {
            return hardwareBufferFrameDequeue2;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getOutputFrame$lambda$0(CompletableDeferred completableDeferred) {
        completableDeferred.complete(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: androidx.media3.effect.DefaultHardwareBufferEffectsPipeline$getOutputFrame$2, reason: invalid class name */
    /* JADX INFO: compiled from: DefaultHardwareBufferEffectsPipeline.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.media3.effect.DefaultHardwareBufferEffectsPipeline$getOutputFrame$2", f = "DefaultHardwareBufferEffectsPipeline.kt", i = {}, l = {150}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CompletableDeferred<Unit> $capacityAvailable;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(CompletableDeferred<Unit> completableDeferred, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$capacityAvailable = completableDeferred;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$capacityAvailable, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (this.$capacityAvailable.await(this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:45:0x0120 A[Catch: all -> 0x0078, TryCatch #2 {all -> 0x0078, blocks: (B:21:0x0073, B:43:0x011a, B:45:0x0120, B:47:0x0172, B:54:0x0181, B:55:0x018a), top: B:70:0x0073 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x0172 A[Catch: all -> 0x0078, TRY_LEAVE, TryCatch #2 {all -> 0x0078, blocks: (B:21:0x0073, B:43:0x011a, B:45:0x0120, B:47:0x0172, B:54:0x0181, B:55:0x018a), top: B:70:0x0073 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x017a  */
    /* JADX WARN: Code duplicated, block: B:54:0x0181 A[Catch: all -> 0x0078, TRY_ENTER, TryCatch #2 {all -> 0x0078, blocks: (B:21:0x0073, B:43:0x011a, B:45:0x0120, B:47:0x0172, B:54:0x0181, B:55:0x018a), top: B:70:0x0073 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    public final Object renderToOutputBuffer(HardwareBuffer hardwareBuffer, SyncFenceCompat syncFenceCompat, int i, int i2, HardwareBuffer hardwareBuffer2, SyncFenceCompat syncFenceCompat2, Continuation<? super SyncFence> continuation) throws Exception {
        C08271 c08271;
        HardwareBufferRenderer hardwareBufferRenderer;
        HardwareBufferRenderer hardwareBufferRenderer2;
        HardwareBuffer hardwareBuffer3;
        SyncFenceCompat syncFenceCompat3;
        int i3;
        int i4;
        DefaultHardwareBufferEffectsPipeline defaultHardwareBufferEffectsPipeline;
        HardwareBuffer hardwareBuffer4;
        int i5;
        AutoCloseable autoCloseable;
        RenderNode renderNode;
        HardwareBufferRenderer hardwareBufferRenderer3;
        Bitmap bitmap;
        int i6;
        final DefaultHardwareBufferEffectsPipeline defaultHardwareBufferEffectsPipeline2;
        AutoCloseable autoCloseable2;
        Throwable th;
        HardwareBuffer hardwareBuffer5 = hardwareBuffer2;
        if (continuation instanceof C08271) {
            c08271 = (C08271) continuation;
            if ((c08271.label & Integer.MIN_VALUE) != 0) {
                c08271.label -= Integer.MIN_VALUE;
            } else {
                c08271 = new C08271(continuation);
            }
        } else {
            c08271 = new C08271(continuation);
        }
        Object result = c08271.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i7 = c08271.label;
        if (i7 != 0) {
            if (i7 == 1) {
                int i8 = c08271.I$1;
                int i9 = c08271.I$0;
                hardwareBufferRenderer2 = (HardwareBufferRenderer) c08271.L$5;
                AutoCloseable autoCloseable3 = (AutoCloseable) c08271.L$4;
                syncFenceCompat3 = (SyncFenceCompat) c08271.L$3;
                HardwareBuffer hardwareBuffer6 = (HardwareBuffer) c08271.L$2;
                HardwareBuffer hardwareBuffer7 = (HardwareBuffer) c08271.L$1;
                defaultHardwareBufferEffectsPipeline = (DefaultHardwareBufferEffectsPipeline) c08271.L$0;
                try {
                    ResultKt.throwOnFailure(result);
                    i3 = i9;
                    hardwareBuffer5 = hardwareBuffer6;
                    hardwareBufferRenderer = autoCloseable3;
                    hardwareBuffer3 = hardwareBuffer7;
                    i4 = i8;
                } catch (Throwable th2) {
                    th = th2;
                    hardwareBufferRenderer = autoCloseable3;
                }
            } else {
                if (i7 != 2) {
                    if (i7 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    autoCloseable2 = (AutoCloseable) c08271.L$1;
                    try {
                        ResultKt.throwOnFailure(result);
                        SyncFence syncFence = (SyncFence) result;
                        AutoCloseableKt.closeFinally(autoCloseable2, null);
                        return syncFence;
                    } catch (Throwable th3) {
                        th = th3;
                        hardwareBufferRenderer = autoCloseable2;
                        th = th;
                        throw th;
                    }
                }
                i6 = c08271.I$1;
                i5 = c08271.I$0;
                bitmap = (Bitmap) c08271.L$5;
                renderNode = (RenderNode) c08271.L$4;
                hardwareBufferRenderer3 = (HardwareBufferRenderer) c08271.L$3;
                autoCloseable = (AutoCloseable) c08271.L$2;
                hardwareBuffer4 = (HardwareBuffer) c08271.L$1;
                defaultHardwareBufferEffectsPipeline2 = (DefaultHardwareBufferEffectsPipeline) c08271.L$0;
                try {
                    ResultKt.throwOnFailure(result);
                    if (!hardwareBuffer4.isClosed()) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    RecordingCanvas recordingCanvasBeginRecording = renderNode.beginRecording(i5, i6);
                    Intrinsics.checkNotNullExpressionValue(recordingCanvasBeginRecording, "beginRecording(...)");
                    recordingCanvasBeginRecording.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
                    renderNode.endRecording();
                    hardwareBufferRenderer3.setContentRoot(renderNode);
                    c08271.L$0 = defaultHardwareBufferEffectsPipeline2;
                    c08271.L$1 = autoCloseable;
                    c08271.L$2 = hardwareBufferRenderer3;
                    c08271.L$3 = c08271;
                    c08271.L$4 = null;
                    c08271.L$5 = null;
                    c08271.label = 3;
                    CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(c08271), 1);
                    cancellableContinuationImpl.initCancellability();
                    final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
                    hardwareBufferRenderer3.obtainRenderRequest().draw(defaultHardwareBufferEffectsPipeline2.internalExecutor, new java.util.function.Consumer() { // from class: androidx.media3.effect.DefaultHardwareBufferEffectsPipeline$renderToOutputBuffer$2$1$1
                        @Override // java.util.function.Consumer
                        public final void accept(HardwareBufferRenderer.RenderResult renderResult) {
                            Object objM14780constructorimpl;
                            final SyncFence fence = renderResult.getFence();
                            Intrinsics.checkNotNullExpressionValue(fence, "getFence(...)");
                            CancellableContinuation<SyncFence> cancellableContinuation = cancellableContinuationImpl2;
                            try {
                                Result.Companion companion = Result.INSTANCE;
                                cancellableContinuation.resume(fence, new Function3<Throwable, SyncFence, CoroutineContext, Unit>() { // from class: androidx.media3.effect.DefaultHardwareBufferEffectsPipeline$renderToOutputBuffer$2$1$1$1$1
                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th4, SyncFence syncFence2, CoroutineContext coroutineContext) {
                                        invoke2(th4, syncFence2, coroutineContext);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(Throwable th4, SyncFence syncFence2, CoroutineContext coroutineContext) {
                                        Intrinsics.checkNotNullParameter(th4, "<unused var>");
                                        Intrinsics.checkNotNullParameter(syncFence2, "<unused var>");
                                        Intrinsics.checkNotNullParameter(coroutineContext, "<unused var>");
                                        fence.close();
                                    }
                                });
                                objM14780constructorimpl = Result.m14780constructorimpl(Unit.INSTANCE);
                            } catch (Throwable th4) {
                                Result.Companion companion2 = Result.INSTANCE;
                                objM14780constructorimpl = Result.m14780constructorimpl(ResultKt.createFailure(th4));
                            }
                            if (Result.m14783exceptionOrNullimpl(objM14780constructorimpl) != null) {
                                fence.close();
                            }
                        }
                    });
                    result = cancellableContinuationImpl.getResult();
                    if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended(c08271);
                    }
                    if (result != coroutine_suspended) {
                        autoCloseable2 = autoCloseable;
                        SyncFence syncFence2 = (SyncFence) result;
                        AutoCloseableKt.closeFinally(autoCloseable2, null);
                        return syncFence2;
                    }
                    return coroutine_suspended;
                } catch (Throwable th4) {
                    th = th4;
                    hardwareBufferRenderer = autoCloseable;
                }
            }
            try {
                throw th;
            } catch (Throwable th5) {
                AutoCloseableKt.closeFinally(hardwareBufferRenderer, th);
                throw th5;
            }
        }
        ResultKt.throwOnFailure(result);
        hardwareBufferRenderer = new HardwareBufferRenderer(hardwareBuffer5);
        try {
            hardwareBufferRenderer2 = hardwareBufferRenderer;
            c08271.L$0 = this;
            hardwareBuffer3 = hardwareBuffer;
            c08271.L$1 = hardwareBuffer3;
            c08271.L$2 = hardwareBuffer5;
            syncFenceCompat3 = syncFenceCompat2;
            c08271.L$3 = syncFenceCompat3;
            c08271.L$4 = hardwareBufferRenderer;
            c08271.L$5 = hardwareBufferRenderer2;
            i3 = i;
            c08271.I$0 = i3;
            i4 = i2;
            c08271.I$1 = i4;
            c08271.label = 1;
            if (waitOn(syncFenceCompat, c08271) != coroutine_suspended) {
                defaultHardwareBufferEffectsPipeline = this;
            }
            return coroutine_suspended;
        } catch (Throwable th6) {
            th = th6;
            th = th;
            throw th;
        }
        if (hardwareBuffer3.isClosed()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        Bitmap bitmapWrapHardwareBuffer = Bitmap.wrapHardwareBuffer(hardwareBuffer3, ColorSpace.get(ColorSpace.Named.SRGB));
        if (bitmapWrapHardwareBuffer == null) {
            throw new IllegalStateException("Failed to wrap input HardwareBuffer in Bitmap");
        }
        RenderNode renderNode2 = new RenderNode("PlaceholderEffect");
        renderNode2.setPosition(0, 0, i3, i4);
        c08271.L$0 = defaultHardwareBufferEffectsPipeline;
        c08271.L$1 = hardwareBuffer5;
        c08271.L$2 = hardwareBufferRenderer;
        c08271.L$3 = hardwareBufferRenderer2;
        c08271.L$4 = renderNode2;
        c08271.L$5 = bitmapWrapHardwareBuffer;
        c08271.I$0 = i3;
        c08271.I$1 = i4;
        c08271.label = 2;
        if (defaultHardwareBufferEffectsPipeline.waitOn(syncFenceCompat3, c08271) != coroutine_suspended) {
            int i10 = i3;
            hardwareBuffer4 = hardwareBuffer5;
            i5 = i10;
            autoCloseable = hardwareBufferRenderer;
            renderNode = renderNode2;
            hardwareBufferRenderer3 = hardwareBufferRenderer2;
            bitmap = bitmapWrapHardwareBuffer;
            i6 = i4;
            defaultHardwareBufferEffectsPipeline2 = defaultHardwareBufferEffectsPipeline;
            if (!hardwareBuffer4.isClosed()) {
                throw new IllegalStateException("Check failed.".toString());
            }
            RecordingCanvas recordingCanvasBeginRecording2 = renderNode.beginRecording(i5, i6);
            Intrinsics.checkNotNullExpressionValue(recordingCanvasBeginRecording2, "beginRecording(...)");
            recordingCanvasBeginRecording2.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            renderNode.endRecording();
            hardwareBufferRenderer3.setContentRoot(renderNode);
            c08271.L$0 = defaultHardwareBufferEffectsPipeline2;
            c08271.L$1 = autoCloseable;
            c08271.L$2 = hardwareBufferRenderer3;
            c08271.L$3 = c08271;
            c08271.L$4 = null;
            c08271.L$5 = null;
            c08271.label = 3;
            CancellableContinuationImpl cancellableContinuationImpl3 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(c08271), 1);
            cancellableContinuationImpl3.initCancellability();
            final CancellableContinuation<? super SyncFence> cancellableContinuationImpl4 = cancellableContinuationImpl3;
            hardwareBufferRenderer3.obtainRenderRequest().draw(defaultHardwareBufferEffectsPipeline2.internalExecutor, new java.util.function.Consumer() { // from class: androidx.media3.effect.DefaultHardwareBufferEffectsPipeline$renderToOutputBuffer$2$1$1
                @Override // java.util.function.Consumer
                public final void accept(HardwareBufferRenderer.RenderResult renderResult) {
                    Object objM14780constructorimpl;
                    final SyncFence fence = renderResult.getFence();
                    Intrinsics.checkNotNullExpressionValue(fence, "getFence(...)");
                    CancellableContinuation<SyncFence> cancellableContinuation = cancellableContinuationImpl4;
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        cancellableContinuation.resume(fence, new Function3<Throwable, SyncFence, CoroutineContext, Unit>() { // from class: androidx.media3.effect.DefaultHardwareBufferEffectsPipeline$renderToOutputBuffer$2$1$1$1$1
                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(Throwable th7, SyncFence syncFence3, CoroutineContext coroutineContext) {
                                invoke2(th7, syncFence3, coroutineContext);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Throwable th7, SyncFence syncFence3, CoroutineContext coroutineContext) {
                                Intrinsics.checkNotNullParameter(th7, "<unused var>");
                                Intrinsics.checkNotNullParameter(syncFence3, "<unused var>");
                                Intrinsics.checkNotNullParameter(coroutineContext, "<unused var>");
                                fence.close();
                            }
                        });
                        objM14780constructorimpl = Result.m14780constructorimpl(Unit.INSTANCE);
                    } catch (Throwable th7) {
                        Result.Companion companion2 = Result.INSTANCE;
                        objM14780constructorimpl = Result.m14780constructorimpl(ResultKt.createFailure(th7));
                    }
                    if (Result.m14783exceptionOrNullimpl(objM14780constructorimpl) != null) {
                        fence.close();
                    }
                }
            });
            result = cancellableContinuationImpl3.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(c08271);
            }
            if (result != coroutine_suspended) {
                autoCloseable2 = autoCloseable;
                SyncFence syncFence3 = (SyncFence) result;
                AutoCloseableKt.closeFinally(autoCloseable2, null);
                return syncFence3;
            }
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object waitOn(SyncFenceCompat syncFenceCompat, Continuation<? super Unit> continuation) throws IOException {
        C08281 c08281;
        if (continuation instanceof C08281) {
            c08281 = (C08281) continuation;
            if ((c08281.label & Integer.MIN_VALUE) != 0) {
                c08281.label -= Integer.MIN_VALUE;
            } else {
                c08281 = new C08281(continuation);
            }
        } else {
            c08281 = new C08281(continuation);
        }
        Object objWithContext = c08281.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c08281.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objWithContext);
            if (syncFenceCompat != null) {
                ExecutorCoroutineDispatcher executorCoroutineDispatcher = this.internalDispatcher;
                DefaultHardwareBufferEffectsPipeline$waitOn$2$signaled$1 defaultHardwareBufferEffectsPipeline$waitOn$2$signaled$1 = new DefaultHardwareBufferEffectsPipeline$waitOn$2$signaled$1(syncFenceCompat, null);
                c08281.L$0 = syncFenceCompat;
                c08281.label = 1;
                objWithContext = BuildersKt.withContext(executorCoroutineDispatcher, defaultHardwareBufferEffectsPipeline$waitOn$2$signaled$1, c08281);
                if (objWithContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        syncFenceCompat = (SyncFenceCompat) c08281.L$0;
        ResultKt.throwOnFailure(objWithContext);
        if (!((Boolean) objWithContext).booleanValue()) {
            Log.w(TAG, "Timed out waiting for fence.");
        }
        syncFenceCompat.close();
        return Unit.INSTANCE;
    }
}
