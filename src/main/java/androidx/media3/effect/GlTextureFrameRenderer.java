package androidx.media3.effect;

import android.content.Context;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.SurfaceInfo;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.VideoFrameProcessor;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.GlUtil;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: GlTextureFrameRenderer.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 72\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u0005:\u000267B?\b\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0015\u001a\u00020\u00162\u0010\u0010\u0017\u001a\f\u0012\b\u0012\u00060\u0018j\u0002`\u00190\u000fH\u0016J\u001c\u0010#\u001a\u00020\u00162\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00020%H\u0096@¢\u0006\u0002\u0010&J\u000e\u0010'\u001a\u00020\u0016H\u0096@¢\u0006\u0002\u0010(J\u0012\u0010)\u001a\u00020\u00162\b\u0010*\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010+\u001a\u00020\u0016H\u0016J\u0010\u0010,\u001a\u00020\u00162\u0006\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020\u0016H\u0016J\u0010\u00100\u001a\u00020\u00162\u0006\u00101\u001a\u000202H\u0016J\u0010\u00103\u001a\u00020!2\u0006\u00104\u001a\u000205H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00160\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Landroidx/media3/effect/GlTextureFrameRenderer;", "Landroidx/media3/effect/RenderingPacketConsumer;", "Landroidx/media3/effect/GlTextureFrame;", "Landroidx/media3/common/SurfaceInfo;", "Landroidx/media3/effect/GlShaderProgram$InputListener;", "Landroidx/media3/effect/FinalShaderProgramWrapper$Listener;", "context", "Landroid/content/Context;", "glExecutorService", "Ljava/util/concurrent/ExecutorService;", "glObjectsProvider", "Landroidx/media3/common/GlObjectsProvider;", "videoFrameProcessingTaskExecutor", "Landroidx/media3/effect/VideoFrameProcessingTaskExecutor;", "errorHandler", "Landroidx/media3/common/util/Consumer;", "Landroidx/media3/common/VideoFrameProcessingException;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroidx/media3/effect/GlTextureFrameRenderer$Listener;", "<init>", "(Landroid/content/Context;Ljava/util/concurrent/ExecutorService;Landroidx/media3/common/GlObjectsProvider;Landroidx/media3/effect/VideoFrameProcessingTaskExecutor;Landroidx/media3/common/util/Consumer;Landroidx/media3/effect/GlTextureFrameRenderer$Listener;)V", "setErrorConsumer", "", "errorConsumer", "Ljava/lang/Exception;", "Lkotlin/Exception;", "glDispatcher", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "isReleased", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasRenderedPendingFrame", "Lkotlinx/coroutines/CompletableDeferred;", "finalShaderProgramWrapper", "Landroidx/media3/effect/FinalShaderProgramWrapper;", "outputSurfaceInfo", "queuePacket", "packet", "Landroidx/media3/effect/PacketConsumer$Packet;", "(Landroidx/media3/effect/PacketConsumer$Packet;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setRenderOutput", "output", "onReadyToAcceptInputFrame", "onInputFrameProcessed", "inputTexture", "Landroidx/media3/common/GlTextureInfo;", "onInputStreamProcessed", "onFrameRendered", "presentationTimeUs", "", "initializeFinalShaderProgramWrapper", "outputColorInfo", "Landroidx/media3/common/ColorInfo;", "Listener", "Companion", "lib-effect_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GlTextureFrameRenderer implements RenderingPacketConsumer<GlTextureFrame, SurfaceInfo>, GlShaderProgram.InputListener, FinalShaderProgramWrapper.Listener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Context context;
    private Consumer<VideoFrameProcessingException> errorHandler;
    private FinalShaderProgramWrapper finalShaderProgramWrapper;
    private final ExecutorCoroutineDispatcher glDispatcher;
    private final ExecutorService glExecutorService;
    private final GlObjectsProvider glObjectsProvider;
    private CompletableDeferred<Unit> hasRenderedPendingFrame;
    private final AtomicBoolean isReleased;
    private Listener listener;
    private volatile SurfaceInfo outputSurfaceInfo;
    private final VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor;

    public /* synthetic */ GlTextureFrameRenderer(Context context, ExecutorService executorService, GlObjectsProvider glObjectsProvider, VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor, Consumer consumer, Listener listener, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, executorService, glObjectsProvider, videoFrameProcessingTaskExecutor, consumer, listener);
    }

    @JvmStatic
    public static final GlTextureFrameRenderer create(Context context, ListeningExecutorService listeningExecutorService, GlObjectsProvider glObjectsProvider, Consumer<VideoFrameProcessingException> consumer, Listener listener) {
        return INSTANCE.create(context, listeningExecutorService, glObjectsProvider, consumer, listener);
    }

    @Override // androidx.media3.effect.FinalShaderProgramWrapper.Listener
    public void onFrameRendered(long presentationTimeUs) {
    }

    @Override // androidx.media3.effect.GlShaderProgram.InputListener
    public void onReadyToAcceptInputFrame() {
    }

    private GlTextureFrameRenderer(Context context, ExecutorService executorService, GlObjectsProvider glObjectsProvider, VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor, Consumer<VideoFrameProcessingException> consumer, Listener listener) {
        this.context = context;
        this.glExecutorService = executorService;
        this.glObjectsProvider = glObjectsProvider;
        this.videoFrameProcessingTaskExecutor = videoFrameProcessingTaskExecutor;
        this.errorHandler = consumer;
        this.listener = listener;
        this.glDispatcher = ExecutorsKt.from(executorService);
        this.isReleased = new AtomicBoolean(false);
        this.hasRenderedPendingFrame = CompletableDeferredKt.CompletableDeferred(Unit.INSTANCE);
    }

    /* JADX INFO: compiled from: GlTextureFrameRenderer.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u000bJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016¨\u0006\f"}, d2 = {"Landroidx/media3/effect/GlTextureFrameRenderer$Listener;", "", "onOutputSizeChanged", "", "width", "", "height", "onOutputFrameAvailableForRendering", "presentationTimeUs", "", "onEnded", "NO_OP", "lib-effect_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface Listener {

        /* JADX INFO: compiled from: GlTextureFrameRenderer.kt */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class DefaultImpls {
            public static void onEnded(Listener listener) {
            }

            public static void onOutputFrameAvailableForRendering(Listener listener, long j) {
            }

            public static void onOutputSizeChanged(Listener listener, int i, int i2) {
            }
        }

        void onEnded();

        void onOutputFrameAvailableForRendering(long presentationTimeUs);

        void onOutputSizeChanged(int width, int height);

        /* JADX INFO: compiled from: GlTextureFrameRenderer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/media3/effect/GlTextureFrameRenderer$Listener$NO_OP;", "Landroidx/media3/effect/GlTextureFrameRenderer$Listener;", "<init>", "()V", "lib-effect_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class NO_OP implements Listener {
            public static final NO_OP INSTANCE = new NO_OP();

            private NO_OP() {
            }

            @Override // androidx.media3.effect.GlTextureFrameRenderer.Listener
            public void onEnded() {
                DefaultImpls.onEnded(this);
            }

            @Override // androidx.media3.effect.GlTextureFrameRenderer.Listener
            public void onOutputFrameAvailableForRendering(long j) {
                DefaultImpls.onOutputFrameAvailableForRendering(this, j);
            }

            @Override // androidx.media3.effect.GlTextureFrameRenderer.Listener
            public void onOutputSizeChanged(int i, int i2) {
                DefaultImpls.onOutputSizeChanged(this, i, i2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setErrorConsumer$lambda$0(Consumer consumer, VideoFrameProcessingException t) {
        Intrinsics.checkNotNullParameter(t, "t");
        consumer.accept(t);
    }

    @Override // androidx.media3.effect.RenderingPacketConsumer
    public void setErrorConsumer(final Consumer<Exception> errorConsumer) {
        Intrinsics.checkNotNullParameter(errorConsumer, "errorConsumer");
        this.errorHandler = new Consumer() { // from class: androidx.media3.effect.GlTextureFrameRenderer$$ExternalSyntheticLambda0
            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                GlTextureFrameRenderer.setErrorConsumer$lambda$0(errorConsumer, (VideoFrameProcessingException) obj);
            }
        };
    }

    /* JADX INFO: renamed from: androidx.media3.effect.GlTextureFrameRenderer$queuePacket$2, reason: invalid class name */
    /* JADX INFO: compiled from: GlTextureFrameRenderer.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.media3.effect.GlTextureFrameRenderer$queuePacket$2", f = "GlTextureFrameRenderer.kt", i = {0}, l = {114}, m = "invokeSuspend", n = {"frame"}, s = {"L$0"})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PacketConsumer.Packet<GlTextureFrame> $packet;
        Object L$0;
        int label;
        final /* synthetic */ GlTextureFrameRenderer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(PacketConsumer.Packet<? extends GlTextureFrame> packet, GlTextureFrameRenderer glTextureFrameRenderer, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$packet = packet;
            this.this$0 = glTextureFrameRenderer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$packet, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws GlUtil.GlException {
            GlTextureFrame glTextureFrame;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    PacketConsumer.Packet<GlTextureFrame> packet = this.$packet;
                    if (packet instanceof PacketConsumer.Packet.Payload) {
                        GlTextureFrame glTextureFrame2 = (GlTextureFrame) ((PacketConsumer.Packet.Payload) packet).getPayload();
                        if (this.this$0.isReleased.get()) {
                            return Unit.INSTANCE;
                        }
                        FinalShaderProgramWrapper finalShaderProgramWrapperInitializeFinalShaderProgramWrapper = this.this$0.finalShaderProgramWrapper;
                        if (finalShaderProgramWrapperInitializeFinalShaderProgramWrapper == null) {
                            GlTextureFrameRenderer glTextureFrameRenderer = this.this$0;
                            ColorInfo SDR_BT709_LIMITED = glTextureFrame2.format.colorInfo;
                            if (SDR_BT709_LIMITED == null) {
                                SDR_BT709_LIMITED = ColorInfo.SDR_BT709_LIMITED;
                                Intrinsics.checkNotNullExpressionValue(SDR_BT709_LIMITED, "SDR_BT709_LIMITED");
                            }
                            finalShaderProgramWrapperInitializeFinalShaderProgramWrapper = glTextureFrameRenderer.initializeFinalShaderProgramWrapper(SDR_BT709_LIMITED);
                        }
                        this.this$0.hasRenderedPendingFrame = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
                        finalShaderProgramWrapperInitializeFinalShaderProgramWrapper.queueInputFrame(this.this$0.glObjectsProvider, glTextureFrame2.glTextureInfo, glTextureFrame2.presentationTimeUs);
                        finalShaderProgramWrapperInitializeFinalShaderProgramWrapper.renderOutputFrame(this.this$0.glObjectsProvider, glTextureFrame2.releaseTimeNs);
                        this.L$0 = glTextureFrame2;
                        this.label = 1;
                        if (this.this$0.hasRenderedPendingFrame.await(this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        glTextureFrame = glTextureFrame2;
                    } else if (packet instanceof PacketConsumer.Packet.EndOfStream) {
                        FinalShaderProgramWrapper finalShaderProgramWrapper = this.this$0.finalShaderProgramWrapper;
                        if (finalShaderProgramWrapper != null) {
                            finalShaderProgramWrapper.signalEndOfCurrentInputStream();
                        }
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                    return Unit.INSTANCE;
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                glTextureFrame = (GlTextureFrame) this.L$0;
                ResultKt.throwOnFailure(obj);
                glTextureFrame.release(null);
                return Unit.INSTANCE;
            } catch (CancellationException unused) {
                return Unit.INSTANCE;
            }
        }
    }

    @Override // androidx.media3.effect.PacketConsumer
    public Object queuePacket(PacketConsumer.Packet<? extends GlTextureFrame> packet, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.glDispatcher, new AnonymousClass2(packet, this, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    @Override // androidx.media3.effect.PacketConsumer
    public Object release(Continuation<? super Unit> continuation) {
        if (this.isReleased.compareAndSet(false, true)) {
            Job.DefaultImpls.cancel$default((Job) this.hasRenderedPendingFrame, (CancellationException) null, 1, (Object) null);
            return BuildersKt.withContext(this.glDispatcher, new C08312(null), continuation);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.media3.effect.GlTextureFrameRenderer$release$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GlTextureFrameRenderer.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.media3.effect.GlTextureFrameRenderer$release$2", f = "GlTextureFrameRenderer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C08312 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C08312(Continuation<? super C08312> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GlTextureFrameRenderer.this.new C08312(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08312) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws VideoFrameProcessingException {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            FinalShaderProgramWrapper finalShaderProgramWrapper = GlTextureFrameRenderer.this.finalShaderProgramWrapper;
            if (finalShaderProgramWrapper == null) {
                return null;
            }
            finalShaderProgramWrapper.release();
            return Unit.INSTANCE;
        }
    }

    @Override // androidx.media3.effect.RenderingPacketConsumer
    public void setRenderOutput(SurfaceInfo output) {
        this.outputSurfaceInfo = output;
        FinalShaderProgramWrapper finalShaderProgramWrapper = this.finalShaderProgramWrapper;
        if (finalShaderProgramWrapper != null) {
            finalShaderProgramWrapper.setOutputSurfaceInfo(output);
        }
    }

    @Override // androidx.media3.effect.GlShaderProgram.InputListener
    public void onInputFrameProcessed(GlTextureInfo inputTexture) {
        Intrinsics.checkNotNullParameter(inputTexture, "inputTexture");
        this.hasRenderedPendingFrame.complete(Unit.INSTANCE);
    }

    @Override // androidx.media3.effect.FinalShaderProgramWrapper.Listener
    public void onInputStreamProcessed() {
        this.listener.onEnded();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FinalShaderProgramWrapper initializeFinalShaderProgramWrapper(ColorInfo outputColorInfo) throws GlUtil.GlException {
        int[] iArr;
        if (ColorInfo.isTransferHdr(outputColorInfo)) {
            iArr = GlUtil.EGL_CONFIG_ATTRIBUTES_RGBA_1010102;
        } else {
            iArr = GlUtil.EGL_CONFIG_ATTRIBUTES_RGBA_8888;
        }
        Intrinsics.checkNotNull(iArr);
        EGLDisplay defaultEglDisplay = GlUtil.getDefaultEglDisplay();
        Intrinsics.checkNotNullExpressionValue(defaultEglDisplay, "getDefaultEglDisplay(...)");
        Pair pairCreateFocusedEglContextWithFallback = INSTANCE.createFocusedEglContextWithFallback(this.glObjectsProvider, defaultEglDisplay, iArr);
        FinalShaderProgramWrapper finalShaderProgramWrapper = new FinalShaderProgramWrapper(this.context, defaultEglDisplay, (EGLContext) pairCreateFocusedEglContextWithFallback.getFirst(), (EGLSurface) pairCreateFocusedEglContextWithFallback.getSecond(), outputColorInfo, this.videoFrameProcessingTaskExecutor, MoreExecutors.directExecutor(), new VideoFrameProcessor.Listener() { // from class: androidx.media3.effect.GlTextureFrameRenderer$initializeFinalShaderProgramWrapper$finalShaderProgramWrapper$1
            @Override // androidx.media3.common.VideoFrameProcessor.Listener
            public void onOutputSizeChanged(int width, int height) {
                this.this$0.listener.onOutputSizeChanged(width, height);
            }

            @Override // androidx.media3.common.VideoFrameProcessor.Listener
            public void onOutputFrameAvailableForRendering(long presentationTimeUs, boolean isRedrawnFrame) {
                this.this$0.listener.onOutputFrameAvailableForRendering(presentationTimeUs);
            }

            @Override // androidx.media3.common.VideoFrameProcessor.Listener
            public void onError(VideoFrameProcessingException e) {
                Intrinsics.checkNotNullParameter(e, "e");
                this.this$0.errorHandler.accept(e);
            }
        }, null, 0, 0, false);
        finalShaderProgramWrapper.setInputListener(this);
        finalShaderProgramWrapper.setListener(this);
        finalShaderProgramWrapper.setOutputSurfaceInfo(this.outputSurfaceInfo);
        this.finalShaderProgramWrapper = finalShaderProgramWrapper;
        return finalShaderProgramWrapper;
    }

    /* JADX INFO: compiled from: GlTextureFrameRenderer.kt */
    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J,\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00122\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J4\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00122\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002¨\u0006\u001c"}, d2 = {"Landroidx/media3/effect/GlTextureFrameRenderer$Companion;", "", "<init>", "()V", PasskeyWebListener.CREATE_UNIQUE_KEY, "Landroidx/media3/effect/GlTextureFrameRenderer;", "context", "Landroid/content/Context;", "glExecutorService", "Lcom/google/common/util/concurrent/ListeningExecutorService;", "glObjectsProvider", "Landroidx/media3/common/GlObjectsProvider;", "errorHandler", "Landroidx/media3/common/util/Consumer;", "Landroidx/media3/common/VideoFrameProcessingException;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroidx/media3/effect/GlTextureFrameRenderer$Listener;", "createFocusedEglContextWithFallback", "Lkotlin/Pair;", "Landroid/opengl/EGLContext;", "Landroid/opengl/EGLSurface;", "eglDisplay", "Landroid/opengl/EGLDisplay;", "configAttributes", "", "createFocusedEglContext", "openGlVersion", "", "lib-effect_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final GlTextureFrameRenderer create(Context context, ListeningExecutorService glExecutorService, GlObjectsProvider glObjectsProvider, Consumer<VideoFrameProcessingException> errorHandler, Listener listener) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(glExecutorService, "glExecutorService");
            Intrinsics.checkNotNullParameter(glObjectsProvider, "glObjectsProvider");
            Intrinsics.checkNotNullParameter(errorHandler, "errorHandler");
            Intrinsics.checkNotNullParameter(listener, "listener");
            ListeningExecutorService listeningExecutorService = glExecutorService;
            return new GlTextureFrameRenderer(context, listeningExecutorService, glObjectsProvider, new VideoFrameProcessingTaskExecutor(listeningExecutorService, false, new BitmapToGlTextureFrameProcessor$$ExternalSyntheticLambda3(errorHandler)), errorHandler, listener, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Pair<EGLContext, EGLSurface> createFocusedEglContextWithFallback(GlObjectsProvider glObjectsProvider, EGLDisplay eglDisplay, int[] configAttributes) {
            try {
                return createFocusedEglContext(glObjectsProvider, eglDisplay, 3, configAttributes);
            } catch (GlUtil.GlException unused) {
                return createFocusedEglContext(glObjectsProvider, eglDisplay, 2, configAttributes);
            }
        }

        private final Pair<EGLContext, EGLSurface> createFocusedEglContext(GlObjectsProvider glObjectsProvider, EGLDisplay eglDisplay, int openGlVersion, int[] configAttributes) throws GlUtil.GlException {
            EGLContext eGLContextCreateEglContext = glObjectsProvider.createEglContext(eglDisplay, openGlVersion, configAttributes);
            Intrinsics.checkNotNullExpressionValue(eGLContextCreateEglContext, "createEglContext(...)");
            EGLSurface eGLSurfaceCreateFocusedPlaceholderEglSurface = glObjectsProvider.createFocusedPlaceholderEglSurface(eGLContextCreateEglContext, eglDisplay);
            Intrinsics.checkNotNullExpressionValue(eGLSurfaceCreateFocusedPlaceholderEglSurface, "createFocusedPlaceholderEglSurface(...)");
            return TuplesKt.to(eGLContextCreateEglContext, eGLSurfaceCreateFocusedPlaceholderEglSurface);
        }
    }
}
